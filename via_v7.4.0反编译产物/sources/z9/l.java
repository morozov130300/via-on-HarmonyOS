package z9;

import i6.i0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class l implements h {
    @Override // z9.h
    public String a() {
        return getUrl();
    }

    @Override // z9.h
    public String b() {
        return "toutiao";
    }

    @Override // z9.h
    public String getUrl() {
        String strK = r9.g.a().k();
        if (strK == null || strK.isEmpty()) {
            return "https://so.toutiao.com/search?keyword=";
        }
        if (i0.f7006a.s(strK)) {
            return strK;
        }
        return "https://so.toutiao.com/search?" + strK + "&keyword=";
    }
}
