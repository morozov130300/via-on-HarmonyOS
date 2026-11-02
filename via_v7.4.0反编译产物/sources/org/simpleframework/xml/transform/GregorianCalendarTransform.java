package org.simpleframework.xml.transform;

import java.util.Date;
import java.util.GregorianCalendar;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class GregorianCalendarTransform implements Transform<GregorianCalendar> {
    private final DateTransform transform;

    public GregorianCalendarTransform() {
        this(Date.class);
    }

    public GregorianCalendarTransform(Class cls) {
        this.transform = new DateTransform(cls);
    }

    private GregorianCalendar read(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (date != null) {
            gregorianCalendar.setTime(date);
        }
        return gregorianCalendar;
    }

    @Override // org.simpleframework.xml.transform.Transform
    public GregorianCalendar read(String str) {
        return read(this.transform.read(str));
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(GregorianCalendar gregorianCalendar) {
        return this.transform.write((DateTransform) gregorianCalendar.getTime());
    }
}
