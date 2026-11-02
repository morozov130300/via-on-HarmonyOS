package org.simpleframework.xml.transform;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class BooleanTransform implements Transform<Boolean> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.simpleframework.xml.transform.Transform
    public Boolean read(String str) {
        return Boolean.valueOf(str);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(Boolean bool) {
        return bool.toString();
    }
}
