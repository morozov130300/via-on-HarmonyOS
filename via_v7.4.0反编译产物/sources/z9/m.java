package z9;

import i6.i0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class m implements h {
    @Override // z9.h
    public String a() {
        return getUrl();
    }

    @Override // z9.h
    public String b() {
        return "yahoo";
    }

    @Override // z9.h
    public String getUrl() {
        String strF = r9.g.a().f();
        if (strF == null || strF.isEmpty()) {
            return "https://search.yahoo.com/search?p=";
        }
        if (i0.f7006a.s(strF)) {
            return strF;
        }
        return "https://search.yahoo.com/search?" + strF + "&p=";
    }
}
