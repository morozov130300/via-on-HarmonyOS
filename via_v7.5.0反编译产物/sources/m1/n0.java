package m1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class n0 implements g1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f7833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f7834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c7.a f7835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c7.a f7836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c7.a f7837e;

    public n0(c7.a aVar, c7.a aVar2, c7.a aVar3, c7.a aVar4, c7.a aVar5) {
        this.f7833a = aVar;
        this.f7834b = aVar2;
        this.f7835c = aVar3;
        this.f7836d = aVar4;
        this.f7837e = aVar5;
    }

    public static n0 a(c7.a aVar, c7.a aVar2, c7.a aVar3, c7.a aVar4, c7.a aVar5) {
        return new n0(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static m0 c(o1.a aVar, o1.a aVar2, Object obj, Object obj2, c7.a aVar3) {
        return new m0(aVar, aVar2, (e) obj, (t0) obj2, aVar3);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public m0 get() {
        return c((o1.a) this.f7833a.get(), (o1.a) this.f7834b.get(), this.f7835c.get(), this.f7836d.get(), this.f7837e);
    }
}
