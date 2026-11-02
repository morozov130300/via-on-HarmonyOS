package org.simpleframework.xml.transform;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class ByteTransform implements Transform<Byte> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.simpleframework.xml.transform.Transform
    public Byte read(String str) {
        return Byte.valueOf(str);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(Byte b10) {
        return b10.toString();
    }
}
