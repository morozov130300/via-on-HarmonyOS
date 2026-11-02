package z9;

import i6.i0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class i implements h {
    @Override // z9.h
    public String a() {
        return getUrl();
    }

    @Override // z9.h
    public String b() {
        return "shenma";
    }

    @Override // z9.h
    public String getUrl() {
        String strG = r9.g.a().g();
        if (strG == null || strG.isEmpty()) {
            return "https://yz.m.sm.cn/s?q=";
        }
        if (i0.f7006a.s(strG)) {
            return strG;
        }
        return "https://yz.m.sm.cn/s?from=" + strG + "&q=";
    }
}
