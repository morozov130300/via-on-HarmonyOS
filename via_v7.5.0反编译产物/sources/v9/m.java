package v9;

import u9.p;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class m implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u9.m f13454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u9.l f13455b;

    public m(u9.m mVar, u9.l lVar) {
        this.f13454a = mVar;
        this.f13455b = lVar;
    }

    @Override // v9.g
    public void a() {
        p pVar = new p(0);
        p pVar2 = new p(96495257);
        pVar.H(this.f13454a.getBoolean("adblockplus", pVar2.g()));
        pVar.W(this.f13454a.getBoolean("locationaccess", pVar2.u()));
        pVar.V(this.f13454a.getBoolean("java", pVar2.t()));
        pVar.S(!this.f13454a.getBoolean("blockimages", !pVar2.q()));
        pVar.T(this.f13454a.getBoolean("imageswitch", pVar2.r()));
        pVar.U(this.f13454a.getBoolean("incognitoMode", pVar2.s()));
        pVar.O(this.f13454a.getBoolean("donottrack", pVar2.m()));
        pVar.d0(this.f13454a.getBoolean("datasaving", pVar2.z()));
        pVar.R(this.f13454a.getBoolean("smartback", pVar2.p()));
        pVar.Q(!this.f13454a.getBoolean("ignoresecondarysslerror", !pVar2.o()));
        pVar.N(this.f13454a.getBoolean("requestdesktopsite", pVar2.l()));
        pVar.j0(this.f13454a.getBoolean("webpagedebug", pVar2.F()));
        pVar.L(true);
        pVar.f0(!this.f13454a.getBoolean("3rdcookies", pVar2.B()));
        pVar.I(this.f13454a.getBoolean("blockpopup", pVar2.h()));
        this.f13455b.F1(pVar);
        tc.a.a("upgrade web settings flag done, result: %s", Long.toBinaryString(pVar.a()));
    }

    @Override // v9.g
    public int b() {
        return 3;
    }
}
