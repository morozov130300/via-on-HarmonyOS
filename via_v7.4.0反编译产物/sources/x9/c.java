package x9;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c implements g {

    /* renamed from: a, reason: collision with root package name */
    public final w9.m f14303a;

    /* renamed from: b, reason: collision with root package name */
    public final w9.l f14304b;

    public c(w9.m mVar, w9.l lVar) {
        this.f14303a = mVar;
        this.f14304b = lVar;
    }

    @Override // x9.g
    public void a() {
        pc.a.a("upgrade for customization preferences", new Object[0]);
        if (this.f14303a.contains("searchinfo") || this.f14303a.contains("logoinfo2") || this.f14303a.contains("favinfo") || this.f14303a.contains("custominfo")) {
            pc.a.a("there is the new data, stop upgrading", new Object[0]);
            return;
        }
        int i10 = this.f14303a.getInt("homeskinchioce", 0);
        int iR1 = this.f14304b.R1();
        i9.d dVar = new i9.d(193766400);
        int i11 = iR1 == 1 ? 127 : 0;
        int i12 = iR1 == 1 ? 80 : 0;
        int i13 = iR1 != 1 ? 72 : 80;
        dVar.m(i11);
        dVar.n(i12);
        dVar.k(i13);
        this.f14304b.W1(dVar);
        i9.e eVar = new i9.e(2490468);
        eVar.h(i10 == 1 ? 30 : 127);
        eVar.k(i10 == 2);
        this.f14304b.W0(eVar);
        i9.c cVar = new i9.c(1638446);
        int i14 = i10 == 1 ? 64 : 46;
        int i15 = i10 == 1 ? 42 : 0;
        int i16 = i10 == 1 ? 30 : 127;
        boolean z10 = i10 == 2;
        boolean z11 = i10 == 2;
        cVar.l(i14);
        cVar.h(i15);
        cVar.k(i16);
        cVar.i(z10);
        cVar.j(z11);
        this.f14304b.r(cVar);
        i9.b bVar = new i9.b(0);
        bVar.g(this.f14303a.getBoolean("hidesearchpart", false));
        this.f14304b.h1(bVar);
    }

    @Override // x9.g
    public int b() {
        return 2;
    }
}
