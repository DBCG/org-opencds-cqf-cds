package org.opencds.cqf.cds.discovery;

import java.io.Serializable;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

public class PrefetchUrlList extends CopyOnWriteArrayList<String> implements Serializable {

    @Override
    public boolean add(String element) {
        for (String s : this) {
            if (s.equals(element)) return false;
            if (element.startsWith(s)) return false;
            if (s.startsWith(element)) this.remove(s);
        }
        return super.add(element);
    }

    @Override
    public boolean addAll(Collection<? extends String> toAdd) {
        for (String s : toAdd) {
            add(s);
        }
        return true;
    }
}
