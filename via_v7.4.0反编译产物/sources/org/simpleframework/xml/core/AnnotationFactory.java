package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.Map;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Verbosity;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class AnnotationFactory {
    private final Format format;
    private final boolean required;

    public AnnotationFactory(Detail detail, Support support) {
        this.required = detail.isRequired();
        this.format = support.getFormat();
    }

    private ClassLoader getClassLoader() {
        return AnnotationFactory.class.getClassLoader();
    }

    private Annotation getInstance(Class cls) {
        ClassLoader classLoader = getClassLoader();
        return cls.isArray() ? isPrimitive(cls.getComponentType()) ? getInstance(classLoader, Element.class) : getInstance(classLoader, ElementArray.class) : (isPrimitive(cls) && isAttribute()) ? getInstance(classLoader, Attribute.class) : getInstance(classLoader, Element.class);
    }

    private Annotation getInstance(ClassLoader classLoader, Class cls) {
        return getInstance(classLoader, cls, false);
    }

    private Annotation getInstance(ClassLoader classLoader, Class cls, boolean z10) {
        return (Annotation) Proxy.newProxyInstance(classLoader, new Class[]{cls}, new AnnotationHandler(cls, this.required, z10));
    }

    private boolean isAttribute() {
        Verbosity verbosity = this.format.getVerbosity();
        return verbosity != null && verbosity == Verbosity.LOW;
    }

    private boolean isPrimitive(Class cls) {
        if (Number.class.isAssignableFrom(cls) || cls == Boolean.class || cls == Character.class) {
            return true;
        }
        return cls.isPrimitive();
    }

    private boolean isPrimitiveKey(Class[] clsArr) {
        if (clsArr == null || clsArr.length <= 0) {
            return false;
        }
        Class superclass = clsArr[0].getSuperclass();
        Class cls = clsArr[0];
        if (superclass == null || !(superclass.isEnum() || cls.isEnum())) {
            return isPrimitive(cls);
        }
        return true;
    }

    public Annotation getInstance(Class cls, Class[] clsArr) {
        ClassLoader classLoader = getClassLoader();
        return Map.class.isAssignableFrom(cls) ? (isPrimitiveKey(clsArr) && isAttribute()) ? getInstance(classLoader, ElementMap.class, true) : getInstance(classLoader, ElementMap.class) : Collection.class.isAssignableFrom(cls) ? getInstance(classLoader, ElementList.class) : getInstance(cls);
    }
}
