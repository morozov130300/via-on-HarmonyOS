package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
class Comparer {
    private static final String NAME = "name";
    private final String[] ignore;

    public Comparer() {
        this(NAME);
    }

    private boolean isIgnore(Method method) {
        String name = method.getName();
        String[] strArr = this.ignore;
        if (strArr != null) {
            for (String str : strArr) {
                if (name.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean equals(Annotation annotation, Annotation annotation2) {
        Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
        Class<? extends Annotation> clsAnnotationType2 = annotation2.annotationType();
        Method[] declaredMethods = clsAnnotationType.getDeclaredMethods();
        if (!clsAnnotationType.equals(clsAnnotationType2)) {
            return false;
        }
        for (Method method : declaredMethods) {
            if (!isIgnore(method) && !method.invoke(annotation, null).equals(method.invoke(annotation2, null))) {
                return false;
            }
        }
        return true;
    }

    public Comparer(String... strArr) {
        this.ignore = strArr;
    }
}
