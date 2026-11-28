package z8;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class f0 implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f15413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f15414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c7.a f15415c;

    public f0(c7.a aVar, c7.a aVar2, c7.a aVar3) {
        this.f15413a = aVar;
        this.f15414b = aVar2;
        this.f15415c = aVar3;
    }

    public static f0 a(c7.a aVar, c7.a aVar2, c7.a aVar3) {
        return new f0(aVar, aVar2, aVar3);
    }

    public static e0 c(u9.l lVar, n9.o oVar, e6.e eVar) {
        return new e0(lVar, oVar, eVar);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public e0 get() {
        return c((u9.l) this.f15413a.get(), (n9.o) this.f15414b.get(), (e6.e) this.f15415c.get());
    }
}
