package v9;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u9.m f13443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u9.l f13444b;

    public c(u9.m mVar, u9.l lVar) {
        this.f13443a = mVar;
        this.f13444b = lVar;
    }

    @Override // v9.g
    public void a() {
        tc.a.a("upgrade for customization preferences", new Object[0]);
        if (this.f13443a.contains("searchinfo") || this.f13443a.contains("logoinfo2") || this.f13443a.contains("favinfo") || this.f13443a.contains("custominfo")) {
            tc.a.a("there is the new data, stop upgrading", new Object[0]);
            return;
        }
        int i10 = this.f13443a.getInt("homeskinchioce", 0);
        int iS1 = this.f13444b.S1();
        g9.d dVar = new g9.d(193766400);
        int i11 = iS1 == 1 ? 127 : 0;
        int i12 = iS1 == 1 ? 80 : 0;
        int i13 = iS1 != 1 ? 72 : 80;
        dVar.m(i11);
        dVar.n(i12);
        dVar.k(i13);
        this.f13444b.Y0(dVar);
        g9.e eVar = new g9.e(2490468);
        eVar.h(i10 == 1 ? 30 : 127);
        eVar.k(i10 == 2);
        this.f13444b.P0(eVar);
        g9.c cVar = new g9.c(1638446);
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
        this.f13444b.G2(cVar);
        g9.b bVar = new g9.b(0);
        bVar.i(this.f13443a.getBoolean("hidesearchpart", false));
        this.f13444b.m(bVar);
    }

    @Override // v9.g
    public int b() {
        return 2;
    }
}
