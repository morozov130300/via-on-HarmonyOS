package org.simpleframework.xml.transform;

import java.util.Date;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class DateTransform<T extends Date> implements Transform<T> {
    private final DateFactory<T> factory;

    public DateTransform(Class<T> cls) {
        this.factory = new DateFactory<>(cls);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public synchronized T read(String str) {
        return (T) this.factory.getInstance(Long.valueOf(DateType.getDate(str).getTime()));
    }

    @Override // org.simpleframework.xml.transform.Transform
    public synchronized String write(T t10) {
        return DateType.getText(t10);
    }
}
