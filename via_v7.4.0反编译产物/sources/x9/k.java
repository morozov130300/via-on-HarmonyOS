package x9;

import z8.b4;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class k implements g {

    /* renamed from: a, reason: collision with root package name */
    public final w9.m f14311a;

    /* renamed from: b, reason: collision with root package name */
    public final w9.l f14312b;

    public k(w9.m mVar, w9.l lVar) {
        this.f14311a = mVar;
        this.f14312b = lVar;
    }

    public static w.d c(int i10, String str) {
        int i11;
        if (i10 == 2) {
            i11 = -3;
            str = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Safari/537.36";
        } else if (i10 == 3) {
            i11 = -4;
            str = "Mozilla/5.0 (Windows NT 10.0; Trident/7.0; rv:11.0) like Gecko";
        } else if (i10 == 4) {
            i11 = -6;
            str = "Mozilla/5.0 (iPhone; CPU iPhone OS 18_5 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/18.5 Mobile/15E148 Safari/604.1";
        } else if (i10 == 5) {
            i11 = -8;
            str = "Mozilla/5.0 (Symbian/3; Series60/5.2 NokiaN8-00/012.002; Profile/MIDP-2.1 Configuration/CLDC-1.1 ) AppleWebKit/533.4 (KHTML, like Gecko) NokiaBrowser/7.3.0 Mobile Safari/533.4 3gpp-gba";
        } else if (i10 != 6) {
            i11 = 0;
            str = null;
        } else {
            i11 = -999;
        }
        return new w.d(Integer.valueOf(i11), str);
    }

    @Override // x9.g
    public void a() {
        w.d dVarC = c(this.f14311a.getInt("agentchoose", 0), this.f14311a.getString("userAgentString", ""));
        this.f14312b.I(((Integer) dVarC.f13207a).intValue());
        if (b4.f(((Integer) dVarC.f13207a).intValue())) {
            this.f14312b.f2((String) dVarC.f13208b);
        }
    }

    @Override // x9.g
    public int b() {
        return 6;
    }
}
