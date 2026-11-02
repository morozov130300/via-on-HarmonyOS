package z9;

import i6.i0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e implements h {
    @Override // z9.h
    public String a() {
        return getUrl();
    }

    @Override // z9.h
    public String b() {
        return "google";
    }

    @Override // z9.h
    public String getUrl() {
        String strP = r9.g.a().p();
        if (strP == null || strP.isEmpty()) {
            return "https://www.google.com/search?q=";
        }
        if (i0.f7006a.s(strP)) {
            return strP;
        }
        return "https://www.google.com/search?" + strP + "&q=";
    }
}
