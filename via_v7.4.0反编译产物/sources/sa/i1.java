package sa;

import org.json.JSONObject;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class i1 implements n5.c {
    @Override // n5.c
    public String a(String str) {
        return i6.j0.f7011a.d(str);
    }

    @Override // n5.c
    public String b(String str, String str2, String str3) {
        return "javascript:window[" + JSONObject.quote(str) + "]['gm_menus'][" + JSONObject.quote(str2) + "][" + JSONObject.quote(str3) + "]();";
    }

    @Override // n5.c
    public String c(String str) {
        return i6.j0.f7011a.j(str);
    }

    @Override // n5.c
    public String d(String[] strArr, String str) {
        return i6.j0.f7011a.i(strArr, str);
    }

    @Override // n5.c
    public String e(String str, String str2, int i10) {
        return i6.j0.f7011a.c(str, str2, i10);
    }
}
