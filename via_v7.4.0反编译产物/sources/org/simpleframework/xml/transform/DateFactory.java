package org.simpleframework.xml.transform;

import java.lang.reflect.Constructor;
import java.util.Date;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class DateFactory<T extends Date> {
    private final Constructor<T> factory;

    public DateFactory(Class<T> cls) {
        this(cls, Long.TYPE);
    }

    public DateFactory(Class<T> cls, Class... clsArr) {
        this.factory = cls.getDeclaredConstructor(clsArr);
    }

    public T getInstance(Object... objArr) {
        return this.factory.newInstance(objArr);
    }
}
