package z9;

import i6.i0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a implements h {
    @Override // z9.h
    public String a() {
        String strI = r9.g.a().i();
        if (strI == null || strI.isEmpty()) {
            return "https://www.baidu.com/s?ie=utf-8&word=";
        }
        if (i0.f7006a.s(strI)) {
            return strI;
        }
        return "https://www.baidu.com/s?ie=utf-8&from=" + strI + "&word=";
    }

    @Override // z9.h
    public String b() {
        return "baidu";
    }

    @Override // z9.h
    public String getUrl() {
        String strI = r9.g.a().i();
        if (strI == null || strI.isEmpty()) {
            return "https://m.baidu.com/s?word=";
        }
        if (i0.f7006a.s(strI)) {
            return strI;
        }
        return "https://m.baidu.com/s?from=" + strI + "&word=";
    }
}
