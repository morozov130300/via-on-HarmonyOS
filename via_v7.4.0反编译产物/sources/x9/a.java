package x9;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a implements g {

    /* renamed from: a, reason: collision with root package name */
    public final w9.m f14300a;

    /* renamed from: b, reason: collision with root package name */
    public final w9.l f14301b;

    public a(w9.m mVar, w9.l lVar) {
        this.f14300a = mVar;
        this.f14301b = lVar;
    }

    @Override // x9.g
    public void a() {
        w9.a aVar = new w9.a(w9.a.f13355b);
        aVar.E(this.f14300a.getBoolean("hidestatus", aVar.f()));
        aVar.A(this.f14300a.getBoolean("colormode", aVar.i()));
        aVar.x(this.f14300a.getBoolean("autovideobtn", aVar.f()));
        aVar.O(this.f14300a.getBoolean("volume", aVar.v()));
        aVar.G(this.f14300a.getBoolean("pulltorefresh", aVar.n()));
        aVar.y(this.f14300a.getBoolean("backforwardgesture", aVar.g()));
        aVar.z(this.f14300a.getBoolean("builtin", aVar.h()));
        this.f14301b.q0(aVar);
    }

    @Override // x9.g
    public int b() {
        return 9;
    }
}
