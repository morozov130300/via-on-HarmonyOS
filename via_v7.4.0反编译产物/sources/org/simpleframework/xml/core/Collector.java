package org.simpleframework.xml.core;

import java.util.Iterator;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class Collector implements Criteria {
    private final Registry alias;
    private final Registry registry;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class Registry extends LinkedHashMap<Object, Variable> {
        private Registry() {
        }

        public Iterator<Object> iterator() {
            return keySet().iterator();
        }
    }

    public Collector() {
        this.registry = new Registry();
        this.alias = new Registry();
    }

    @Override // org.simpleframework.xml.core.Criteria
    public void commit(Object obj) {
        for (Variable variable : this.registry.values()) {
            variable.getContact().set(obj, variable.getValue());
        }
    }

    @Override // org.simpleframework.xml.core.Criteria
    public Variable get(Object obj) {
        return this.registry.get(obj);
    }

    @Override // org.simpleframework.xml.core.Criteria
    public Variable get(Label label) {
        if (label == null) {
            return null;
        }
        return this.registry.get(label.getKey());
    }

    @Override // java.lang.Iterable
    public Iterator<Object> iterator() {
        return this.registry.iterator();
    }

    @Override // org.simpleframework.xml.core.Criteria
    public Variable remove(Object obj) {
        return this.registry.remove(obj);
    }

    @Override // org.simpleframework.xml.core.Criteria
    public Variable resolve(String str) {
        return this.alias.get(str);
    }

    @Override // org.simpleframework.xml.core.Criteria
    public void set(Label label, Object obj) {
        Variable variable = new Variable(label, obj);
        if (label != null) {
            String[] paths = label.getPaths();
            Object key = label.getKey();
            for (String str : paths) {
                this.alias.put(str, variable);
            }
            this.registry.put(key, variable);
        }
    }
}
