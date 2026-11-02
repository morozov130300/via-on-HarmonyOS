package org.simpleframework.xml.core;

import org.simpleframework.xml.Version;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
interface Context {
    Object getAttribute(Object obj);

    Caller getCaller(Class cls);

    Decorator getDecorator(Class cls);

    Instance getInstance(Class cls);

    Instance getInstance(Value value);

    String getName(Class cls);

    Value getOverride(Type type, InputNode inputNode);

    String getProperty(String str);

    Schema getSchema(Class cls);

    Session getSession();

    Style getStyle();

    Support getSupport();

    Class getType(Type type, Object obj);

    Version getVersion(Class cls);

    boolean isFloat(Class cls);

    boolean isFloat(Type type);

    boolean isPrimitive(Class cls);

    boolean isPrimitive(Type type);

    boolean isStrict();

    boolean setOverride(Type type, Object obj, OutputNode outputNode);
}
