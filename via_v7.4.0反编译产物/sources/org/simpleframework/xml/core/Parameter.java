package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
interface Parameter {
    Annotation getAnnotation();

    Expression getExpression();

    int getIndex();

    Object getKey();

    String getName();

    String getPath();

    Class getType();

    boolean isAttribute();

    boolean isPrimitive();

    boolean isRequired();

    boolean isText();

    String toString();
}
