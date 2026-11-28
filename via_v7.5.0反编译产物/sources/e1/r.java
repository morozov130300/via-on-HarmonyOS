package e1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class r implements b1.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f4150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b1.b f4152c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b1.d f4153d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final s f4154e;

    public r(p pVar, String str, b1.b bVar, b1.d dVar, s sVar) {
        this.f4150a = pVar;
        this.f4151b = str;
        this.f4152c = bVar;
        this.f4153d = dVar;
        this.f4154e = sVar;
    }

    @Override // b1.e
    public void a(b1.c cVar, b1.g gVar) {
        this.f4154e.a(o.a().e(this.f4150a).c(cVar).f(this.f4151b).d(this.f4153d).b(this.f4152c).a(), gVar);
    }

    public p b() {
        return this.f4150a;
    }
}
