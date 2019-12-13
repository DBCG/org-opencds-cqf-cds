package com.alphora.providers;

import org.opencds.cqf.cql.elm.execution.InEvaluator;
import org.opencds.cqf.cql.elm.execution.IncludesEvaluator;
import org.opencds.cqf.cql.model.Dstu3FhirModelResolver;
import org.opencds.cqf.cql.model.ModelResolver;
import org.opencds.cqf.cql.retrieve.TerminologyAwareRetrieveProvider;
import org.opencds.cqf.cql.runtime.Code;
import org.opencds.cqf.cql.runtime.DateTime;
import org.opencds.cqf.cql.runtime.Interval;
import org.opencds.cqf.cql.terminology.ValueSetInfo;

import java.util.*;

public class PrefetchDataProviderStu3 extends TerminologyAwareRetrieveProvider {

    private Map<String, List<Object>> prefetchResources;
    private ModelResolver resolver;

    public PrefetchDataProviderStu3(List<Object> resources) {
        prefetchResources = PrefetchDataProviderHelper.populateMap(resources);
        this.resolver = new Dstu3FhirModelResolver();
    }

    @Override
    public Iterable<Object> retrieve(String context, String contextPath, Object contextValue, String dataType, String templateId,
                                     String codePath, Iterable<Code> codes, String valueSet, String datePath,
                                     String dateLowPath, String dateHighPath, Interval dateRange)
    {
        if (codePath == null && (codes != null || valueSet != null)) {
            throw new IllegalArgumentException("A code path must be provided when filtering on codes or a valueset.");
        }

        if (dataType == null) {
            throw new IllegalArgumentException("A data type (i.e. Procedure, Valueset, etc...) must be specified for clinical data retrieval");
        }

        List<Object> resourcesOfType = prefetchResources.get(dataType);

        if (resourcesOfType == null) {
            return Collections.emptyList();
        }

        // no resources or no filtering -> return list
        if (resourcesOfType.isEmpty() || (dateRange == null && codePath == null)) {
            return resourcesOfType;
        }

        List<Object> returnList = new ArrayList<>();
        for (Object resource : resourcesOfType) {
            boolean includeResource = true;
            if (dateRange != null) {
                if (datePath != null) {
                    if (dateHighPath != null || dateLowPath != null) {
                        throw new IllegalArgumentException("If the datePath is specified, the dateLowPath and dateHighPath attributes must not be present.");
                    }

                    Object dateObject = PrefetchDataProviderHelper.getStu3DateTime(this.resolver.resolvePath(resource, datePath));
                    DateTime date = dateObject instanceof DateTime ? (DateTime) dateObject : null;
                    Interval dateInterval = dateObject instanceof Interval ? (Interval) dateObject : null;
                    String precision = PrefetchDataProviderHelper.getPrecision(Arrays.asList(dateRange, date));
                    if (date != null && !(InEvaluator.in(date, dateRange, precision))) {
                        includeResource = false;
                    }
                    // TODO - add precision to includes evaluator
                    else if (dateInterval != null && !(IncludesEvaluator.includes(dateRange, dateInterval, precision))) {
                        includeResource = false;
                    }
                } else {
                    if (dateHighPath == null && dateLowPath == null) {
                        throw new IllegalArgumentException("If the datePath is not given, either the lowDatePath or highDatePath must be provided.");
                    }

                    DateTime lowDate = dateLowPath == null ? null : (DateTime) PrefetchDataProviderHelper.getStu3DateTime(this.resolver.resolvePath(resource, dateLowPath));
                    DateTime highDate = dateHighPath == null ? null : (DateTime) PrefetchDataProviderHelper.getStu3DateTime(this.resolver.resolvePath(resource, dateHighPath));

                    String precision = PrefetchDataProviderHelper.getPrecision(Arrays.asList(dateRange, lowDate, highDate));

                    Interval interval = new Interval(lowDate, true, highDate, true);

                    // TODO - add precision to includes evaluator
                    if (!IncludesEvaluator.includes(dateRange, interval, precision)) {
                        includeResource = false;
                    }
                }
            }

            if (codePath != null && !codePath.equals("") && includeResource) {
                if (valueSet != null && terminologyProvider != null) {
                    if (valueSet.startsWith("urn:oid:")) {
                        valueSet = valueSet.replace("urn:oid:", "");
                    }
                    ValueSetInfo valueSetInfo = new ValueSetInfo().withId(valueSet);
                    codes = terminologyProvider.expand(valueSetInfo);
                }
                if (codes != null) {
                    Object codeObject = PrefetchDataProviderHelper.getStu3Code(this.resolver.resolvePath(resource, codePath));
                    includeResource = PrefetchDataProviderHelper.checkCodeMembership(codes, codeObject);
                }
            }

            if (includeResource) {
                returnList.add(resource);
            }
        }

        return returnList;
    }
}
