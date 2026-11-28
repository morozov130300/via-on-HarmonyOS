package a8;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b0 implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f129b;

    public b0(c7.a aVar, c7.a aVar2) {
        this.f128a = aVar;
        this.f129b = aVar2;
    }

    public static b0 a(c7.a aVar, c7.a aVar2) {
        return new b0(aVar, aVar2);
    }

    public static a0 c(w9.a aVar, m9.c cVar) {
        return new a0(aVar, cVar);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public a0 get() {
        return c((w9.a) this.f128a.get(), (m9.c) this.f129b.get());
    }
}
