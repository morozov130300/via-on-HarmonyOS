package z9;

import i6.i0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b implements h {
    @Override // z9.h
    public String a() {
        return getUrl();
    }

    @Override // z9.h
    public String b() {
        return "bing";
    }

    @Override // z9.h
    public String getUrl() {
        String strJ = r9.g.a().j();
        if (strJ == null || strJ.isEmpty()) {
            return "https://www.bing.com/search?q=";
        }
        if (i0.f7006a.s(strJ)) {
            return strJ;
        }
        return "https://www.bing.com/search?" + strJ + "&q=";
    }
}
