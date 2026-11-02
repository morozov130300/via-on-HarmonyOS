package x9;

import w9.p;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class m implements g {

    /* renamed from: a, reason: collision with root package name */
    public final w9.m f14314a;

    /* renamed from: b, reason: collision with root package name */
    public final w9.l f14315b;

    public m(w9.m mVar, w9.l lVar) {
        this.f14314a = mVar;
        this.f14315b = lVar;
    }

    @Override // x9.g
    public void a() {
        p pVar = new p(0);
        p pVar2 = new p(96495261);
        pVar.I(this.f14314a.getBoolean("adblockplus", pVar2.g()));
        pVar.X(this.f14314a.getBoolean("locationaccess", pVar2.u()));
        pVar.f0(this.f14314a.getBoolean("passwords", pVar2.A()));
        pVar.W(this.f14314a.getBoolean("java", pVar2.t()));
        pVar.T(!this.f14314a.getBoolean("blockimages", !pVar2.q()));
        pVar.U(this.f14314a.getBoolean("imageswitch", pVar2.r()));
        pVar.V(this.f14314a.getBoolean("incognitoMode", pVar2.s()));
        pVar.P(this.f14314a.getBoolean("donottrack", pVar2.m()));
        pVar.e0(this.f14314a.getBoolean("datasaving", pVar2.z()));
        pVar.S(this.f14314a.getBoolean("smartback", pVar2.p()));
        pVar.R(!this.f14314a.getBoolean("ignoresecondarysslerror", !pVar2.o()));
        pVar.O(this.f14314a.getBoolean("requestdesktopsite", pVar2.l()));
        pVar.l0(this.f14314a.getBoolean("webpagedebug", pVar2.G()));
        pVar.M(true);
        pVar.h0(!this.f14314a.getBoolean("3rdcookies", pVar2.C()));
        pVar.J(this.f14314a.getBoolean("blockpopup", pVar2.h()));
        this.f14315b.g0(pVar);
        pc.a.a("upgrade web settings flag done, result: %s", Long.toBinaryString(pVar.a()));
    }

    @Override // x9.g
    public int b() {
        return 3;
    }
}
