package org.simpleframework.xml.core;

import org.simpleframework.xml.Version;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
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
