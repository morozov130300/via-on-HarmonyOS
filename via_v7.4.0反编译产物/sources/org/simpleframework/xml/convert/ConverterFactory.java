package org.simpleframework.xml.convert;

import java.lang.reflect.Constructor;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class ConverterFactory {
    private final Cache<Converter> cache = new ConcurrentCache();

    private Constructor getConstructor(Class cls) throws NoSuchMethodException, SecurityException {
        Constructor declaredConstructor = cls.getDeclaredConstructor(null);
        if (!declaredConstructor.isAccessible()) {
            declaredConstructor.setAccessible(true);
        }
        return declaredConstructor;
    }

    private Converter getConverter(Class cls) throws ConvertException, NoSuchMethodException, SecurityException {
        Constructor constructor = getConstructor(cls);
        if (constructor != null) {
            return getConverter(cls, constructor);
        }
        throw new ConvertException("No default constructor for %s", cls);
    }

    private Converter getConverter(Class cls, Constructor constructor) {
        Converter converter = (Converter) constructor.newInstance(null);
        if (converter != null) {
            this.cache.cache(cls, converter);
        }
        return converter;
    }

    public Converter getInstance(Class cls) {
        Converter converterFetch = this.cache.fetch(cls);
        return converterFetch == null ? getConverter(cls) : converterFetch;
    }

    public Converter getInstance(Convert convert) throws ConvertException {
        Class<? extends Converter> clsValue = convert.value();
        if (clsValue.isInterface()) {
            throw new ConvertException("Can not instantiate %s", clsValue);
        }
        return getInstance(clsValue);
    }
}
