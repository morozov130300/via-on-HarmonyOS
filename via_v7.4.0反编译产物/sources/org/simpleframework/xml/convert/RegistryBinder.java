package org.simpleframework.xml.convert;

import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class RegistryBinder {
    private final Cache<Class> cache = new ConcurrentCache();
    private final ConverterFactory factory = new ConverterFactory();

    private Converter create(Class cls) {
        return this.factory.getInstance(cls);
    }

    public void bind(Class cls, Class cls2) {
        this.cache.cache(cls, cls2);
    }

    public Converter lookup(Class cls) {
        Class clsFetch = this.cache.fetch(cls);
        if (clsFetch != null) {
            return create(clsFetch);
        }
        return null;
    }
}
