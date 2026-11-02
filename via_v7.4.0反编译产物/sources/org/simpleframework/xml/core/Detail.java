package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.List;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
interface Detail {
    DefaultType getAccess();

    Annotation[] getAnnotations();

    Constructor[] getConstructors();

    List<FieldDetail> getFields();

    List<MethodDetail> getMethods();

    String getName();

    Namespace getNamespace();

    NamespaceList getNamespaceList();

    Order getOrder();

    DefaultType getOverride();

    Root getRoot();

    Class getSuper();

    Class getType();

    boolean isInstantiable();

    boolean isPrimitive();

    boolean isRequired();

    boolean isStrict();
}
