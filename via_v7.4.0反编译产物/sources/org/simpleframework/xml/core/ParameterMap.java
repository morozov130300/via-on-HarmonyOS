package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class ParameterMap extends LinkedHashMap<Object, Parameter> implements Iterable<Parameter> {
    public Parameter get(int i10) {
        return getAll().get(i10);
    }

    public List<Parameter> getAll() {
        Collection<Parameter> collectionValues = values();
        return !collectionValues.isEmpty() ? new ArrayList(collectionValues) : Collections.EMPTY_LIST;
    }

    @Override // java.lang.Iterable
    public Iterator<Parameter> iterator() {
        return values().iterator();
    }
}
