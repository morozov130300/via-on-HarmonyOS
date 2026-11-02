package org.simpleframework.xml.strategy;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class ArrayValue implements Value {
    private int size;
    private Class type;
    private Object value;

    public ArrayValue(Class cls, int i10) {
        this.type = cls;
        this.size = i10;
    }

    @Override // org.simpleframework.xml.strategy.Value
    public int getLength() {
        return this.size;
    }

    @Override // org.simpleframework.xml.strategy.Value
    public Class getType() {
        return this.type;
    }

    @Override // org.simpleframework.xml.strategy.Value
    public Object getValue() {
        return this.value;
    }

    @Override // org.simpleframework.xml.strategy.Value
    public boolean isReference() {
        return false;
    }

    @Override // org.simpleframework.xml.strategy.Value
    public void setValue(Object obj) {
        this.value = obj;
    }
}
