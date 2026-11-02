package org.simpleframework.xml.core;

import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.strategy.Type;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class Entry {
    private static final String DEFAULT_NAME = "entry";
    private boolean attribute;
    private Contact contact;
    private String entry;
    private String key;
    private Class keyType;
    private ElementMap label;
    private String value;
    private Class valueType;

    public Entry(Contact contact, ElementMap elementMap) {
        this.attribute = elementMap.attribute();
        this.entry = elementMap.entry();
        this.value = elementMap.value();
        this.key = elementMap.key();
        this.contact = contact;
        this.label = elementMap;
    }

    private Class getDependent(int i10) {
        Class[] dependents = this.contact.getDependents();
        return (dependents.length >= i10 && dependents.length != 0) ? dependents[i10] : Object.class;
    }

    private boolean isEmpty(String str) {
        return str.length() == 0;
    }

    public Contact getContact() {
        return this.contact;
    }

    public String getEntry() {
        String str = this.entry;
        if (str == null) {
            return str;
        }
        if (isEmpty(str)) {
            this.entry = DEFAULT_NAME;
        }
        return this.entry;
    }

    public String getKey() {
        String str = this.key;
        if (str == null) {
            return str;
        }
        if (isEmpty(str)) {
            this.key = null;
        }
        return this.key;
    }

    public Converter getKey(Context context) {
        Type keyType = getKeyType();
        return context.isPrimitive(keyType) ? new PrimitiveKey(context, this, keyType) : new CompositeKey(context, this, keyType);
    }

    public Type getKeyType() {
        if (this.keyType == null) {
            Class clsKeyType = this.label.keyType();
            this.keyType = clsKeyType;
            if (clsKeyType == Void.TYPE) {
                this.keyType = getDependent(0);
            }
        }
        return new ClassType(this.keyType);
    }

    public String getValue() {
        String str = this.value;
        if (str == null) {
            return str;
        }
        if (isEmpty(str)) {
            this.value = null;
        }
        return this.value;
    }

    public Converter getValue(Context context) {
        Type valueType = getValueType();
        return context.isPrimitive(valueType) ? new PrimitiveValue(context, this, valueType) : new CompositeValue(context, this, valueType);
    }

    public Type getValueType() {
        if (this.valueType == null) {
            Class clsValueType = this.label.valueType();
            this.valueType = clsValueType;
            if (clsValueType == Void.TYPE) {
                this.valueType = getDependent(1);
            }
        }
        return new ClassType(this.valueType);
    }

    public boolean isAttribute() {
        return this.attribute;
    }

    public boolean isInline() {
        return isAttribute();
    }

    public String toString() {
        return String.format("%s on %s", this.label, this.contact);
    }
}
