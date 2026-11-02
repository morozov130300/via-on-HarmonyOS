package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Value;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class ObjectInstance implements Instance {
    private final Context context;
    private final Class type;
    private final Value value;

    public ObjectInstance(Context context, Value value) {
        this.type = value.getType();
        this.context = context;
        this.value = value;
    }

    @Override // org.simpleframework.xml.core.Instance
    public Object getInstance() {
        if (this.value.isReference()) {
            return this.value.getValue();
        }
        Object objectInstance = getInstance(this.type);
        Value value = this.value;
        if (value != null) {
            value.setValue(objectInstance);
        }
        return objectInstance;
    }

    public Object getInstance(Class cls) {
        return this.context.getInstance(cls).getInstance();
    }

    @Override // org.simpleframework.xml.core.Instance
    public Class getType() {
        return this.type;
    }

    @Override // org.simpleframework.xml.core.Instance
    public boolean isReference() {
        return this.value.isReference();
    }

    @Override // org.simpleframework.xml.core.Instance
    public Object setInstance(Object obj) {
        Value value = this.value;
        if (value != null) {
            value.setValue(obj);
        }
        return obj;
    }
}
