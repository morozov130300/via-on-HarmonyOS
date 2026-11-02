package org.simpleframework.xml.transform;

import java.math.BigDecimal;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class BigDecimalTransform implements Transform<BigDecimal> {
    @Override // org.simpleframework.xml.transform.Transform
    public BigDecimal read(String str) {
        return new BigDecimal(str);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(BigDecimal bigDecimal) {
        return bigDecimal.toString();
    }
}
