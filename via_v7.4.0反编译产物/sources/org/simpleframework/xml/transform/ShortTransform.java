package org.simpleframework.xml.transform;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class ShortTransform implements Transform<Short> {
    @Override // org.simpleframework.xml.transform.Transform
    public Short read(String str) {
        return Short.valueOf(str);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(Short sh) {
        return sh.toString();
    }
}
