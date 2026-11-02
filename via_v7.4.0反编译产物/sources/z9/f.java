package z9;

import i6.i0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class f implements h {
    @Override // z9.h
    public String a() {
        String strD = r9.g.a().d();
        if (strD == null || strD.isEmpty()) {
            return "https://www.so.com/s?q=";
        }
        if (i0.f7006a.s(strD)) {
            return strD;
        }
        return "https://m.so.com/s?" + strD + "&q=";
    }

    @Override // z9.h
    public String b() {
        return "haosou";
    }

    @Override // z9.h
    public String getUrl() {
        String strD = r9.g.a().d();
        if (strD == null || strD.isEmpty()) {
            return "https://m.so.com/s?q=";
        }
        if (i0.f7006a.s(strD)) {
            return strD;
        }
        return "https://m.so.com/s?" + strD + "&q=";
    }
}
