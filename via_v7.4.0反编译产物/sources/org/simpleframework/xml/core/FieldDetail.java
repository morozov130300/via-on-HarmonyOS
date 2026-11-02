package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class FieldDetail {
    private final Field field;
    private final Annotation[] list;
    private final String name;

    public FieldDetail(Field field) {
        this.list = field.getDeclaredAnnotations();
        this.name = field.getName();
        this.field = field;
    }

    public Annotation[] getAnnotations() {
        return this.list;
    }

    public Field getField() {
        return this.field;
    }

    public String getName() {
        return this.name;
    }
}
