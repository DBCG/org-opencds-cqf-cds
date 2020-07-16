package org.opencds.cqf.cds.providers;

import ca.uhn.fhir.rest.api.SearchStyleEnum;

public class ProviderConfiguration {

    public static final ProviderConfiguration DEFAULT_PROVIDER_CONFIGURATION = 
        new ProviderConfiguration(true, 64, SearchStyleEnum.GET);

    private int maxCodesPerQuery;
    private SearchStyleEnum searchStyle;
    private boolean expandValueSets;

    public ProviderConfiguration(boolean expandValueSets, int maxCodesPerQuery, SearchStyleEnum searchStyle) {
        this.maxCodesPerQuery = maxCodesPerQuery;
        this.searchStyle = searchStyle;
        this.expandValueSets = expandValueSets;
    }

    public int getMaxCodesPerQuery() {
        return this.maxCodesPerQuery;
    }

    public SearchStyleEnum getSearchStyle() {
        return this.searchStyle;
    }

    public boolean getExpandValueSets() {
        return this.expandValueSets;
    }
}