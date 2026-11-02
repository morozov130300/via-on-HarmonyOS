package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
abstract class ParameterContact<T extends Annotation> implements Contact {
    protected final Constructor factory;
    protected final int index;
    protected final T label;
    protected final Annotation[] labels;
    protected final Class owner;

    public ParameterContact(T t10, Constructor constructor, int i10) {
        this.labels = constructor.getParameterAnnotations()[i10];
        this.owner = constructor.getDeclaringClass();
        this.factory = constructor;
        this.index = i10;
        this.label = t10;
    }

    @Override // org.simpleframework.xml.core.Contact
    public Object get(Object obj) {
        return null;
    }

    @Override // org.simpleframework.xml.core.Contact
    public Annotation getAnnotation() {
        return this.label;
    }

    @Override // org.simpleframework.xml.strategy.Type
    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        for (Annotation annotation : this.labels) {
            A a10 = (A) annotation;
            if (a10.annotationType().equals(cls)) {
                return a10;
            }
        }
        return null;
    }

    @Override // org.simpleframework.xml.core.Contact
    public Class getDeclaringClass() {
        return this.owner;
    }

    @Override // org.simpleframework.xml.core.Contact
    public Class getDependent() {
        return Reflector.getParameterDependent(this.factory, this.index);
    }

    @Override // org.simpleframework.xml.core.Contact
    public Class[] getDependents() {
        return Reflector.getParameterDependents(this.factory, this.index);
    }

    @Override // org.simpleframework.xml.core.Contact
    public abstract String getName();

    @Override // org.simpleframework.xml.strategy.Type
    public Class getType() {
        return this.factory.getParameterTypes()[this.index];
    }

    @Override // org.simpleframework.xml.core.Contact
    public boolean isReadOnly() {
        return false;
    }

    @Override // org.simpleframework.xml.core.Contact
    public void set(Object obj, Object obj2) {
    }

    @Override // org.simpleframework.xml.core.Contact, org.simpleframework.xml.strategy.Type
    public String toString() {
        return String.format("parameter %s of constructor %s", Integer.valueOf(this.index), this.factory);
    }
}
