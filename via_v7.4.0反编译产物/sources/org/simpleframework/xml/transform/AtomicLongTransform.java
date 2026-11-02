package org.simpleframework.xml.transform;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class AtomicLongTransform implements Transform<AtomicLong> {
    @Override // org.simpleframework.xml.transform.Transform
    public AtomicLong read(String str) {
        return new AtomicLong(Long.valueOf(str).longValue());
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(AtomicLong atomicLong) {
        return atomicLong.toString();
    }
}
