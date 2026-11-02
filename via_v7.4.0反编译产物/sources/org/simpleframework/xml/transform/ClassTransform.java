package org.simpleframework.xml.transform;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class ClassTransform implements Transform<Class> {
    private static final String BOOLEAN = "boolean";
    private static final String BYTE = "byte";
    private static final String CHARACTER = "char";
    private static final String DOUBLE = "double";
    private static final String FLOAT = "float";
    private static final String INTEGER = "int";
    private static final String LONG = "long";
    private static final String SHORT = "short";
    private static final String VOID = "void";

    private ClassLoader getCallerClassLoader() {
        return getClass().getClassLoader();
    }

    private static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    private Class readPrimitive(String str) {
        if (str.equals(BYTE)) {
            return Byte.TYPE;
        }
        if (str.equals(SHORT)) {
            return Short.TYPE;
        }
        if (str.equals(INTEGER)) {
            return Integer.TYPE;
        }
        if (str.equals(LONG)) {
            return Long.TYPE;
        }
        if (str.equals(CHARACTER)) {
            return Character.TYPE;
        }
        if (str.equals(FLOAT)) {
            return Float.TYPE;
        }
        if (str.equals(DOUBLE)) {
            return Double.TYPE;
        }
        if (str.equals(BOOLEAN)) {
            return Boolean.TYPE;
        }
        if (str.equals(VOID)) {
            return Void.TYPE;
        }
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.simpleframework.xml.transform.Transform
    public Class read(String str) {
        Class primitive = readPrimitive(str);
        if (primitive != null) {
            return primitive;
        }
        ClassLoader classLoader = getClassLoader();
        if (classLoader == null) {
            classLoader = getCallerClassLoader();
        }
        return classLoader.loadClass(str);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(Class cls) {
        return cls.getName();
    }
}
