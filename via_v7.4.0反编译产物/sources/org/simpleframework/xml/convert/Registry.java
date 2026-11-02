package org.simpleframework.xml.convert;

import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class Registry {
    private final Cache<Converter> cache = new ConcurrentCache();
    private final RegistryBinder binder = new RegistryBinder();

    private Converter create(Class cls) {
        Converter converterLookup = this.binder.lookup(cls);
        if (converterLookup != null) {
            this.cache.cache(cls, converterLookup);
        }
        return converterLookup;
    }

    public Registry bind(Class cls, Class cls2) {
        if (cls != null) {
            this.binder.bind(cls, cls2);
        }
        return this;
    }

    public Registry bind(Class cls, Converter converter) {
        if (cls != null) {
            this.cache.cache(cls, converter);
        }
        return this;
    }

    public Converter lookup(Class cls) {
        Converter converterFetch = this.cache.fetch(cls);
        return converterFetch == null ? create(cls) : converterFetch;
    }
}
