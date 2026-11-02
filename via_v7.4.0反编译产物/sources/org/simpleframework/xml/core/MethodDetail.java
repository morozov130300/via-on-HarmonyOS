package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class MethodDetail {
    private final Annotation[] list;
    private final Method method;
    private final String name;

    public MethodDetail(Method method) {
        this.list = method.getDeclaredAnnotations();
        this.name = method.getName();
        this.method = method;
    }

    public Annotation[] getAnnotations() {
        return this.list;
    }

    public Method getMethod() {
        return this.method;
    }

    public String getName() {
        return this.name;
    }
}
