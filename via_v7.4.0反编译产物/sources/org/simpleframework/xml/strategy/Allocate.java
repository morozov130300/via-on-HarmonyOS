package org.simpleframework.xml.strategy;

import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class Allocate implements Value {
    private String key;
    private Map map;
    private Value value;

    public Allocate(Value value, Map map, String str) {
        this.value = value;
        this.map = map;
        this.key = str;
    }

    @Override // org.simpleframework.xml.strategy.Value
    public int getLength() {
        return this.value.getLength();
    }

    @Override // org.simpleframework.xml.strategy.Value
    public Class getType() {
        return this.value.getType();
    }

    @Override // org.simpleframework.xml.strategy.Value
    public Object getValue() {
        return this.map.get(this.key);
    }

    @Override // org.simpleframework.xml.strategy.Value
    public boolean isReference() {
        return false;
    }

    @Override // org.simpleframework.xml.strategy.Value
    public void setValue(Object obj) {
        String str = this.key;
        if (str != null) {
            this.map.put(str, obj);
        }
        this.value.setValue(obj);
    }
}
