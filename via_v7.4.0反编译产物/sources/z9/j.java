package z9;

import i6.i0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class j implements h {
    @Override // z9.h
    public String a() {
        String strM = r9.g.a().m();
        return (strM == null || strM.isEmpty()) ? "https://www.sogou.com/web?query=" : getUrl();
    }

    @Override // z9.h
    public String b() {
        return "sougou";
    }

    @Override // z9.h
    public String getUrl() {
        String strM = r9.g.a().m();
        if (strM == null || strM.isEmpty()) {
            return "https://wap.sogou.com/web/sl?keyword=";
        }
        if (i0.f7006a.s(strM)) {
            return strM;
        }
        return "https://wap.sogou.com/web/sl?bid=sogou-mobb-" + strM + "&keyword=";
    }
}
