package la;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class n implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f7558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f7559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c7.a f7560c;

    public n(d dVar, c7.a aVar, c7.a aVar2) {
        this.f7558a = dVar;
        this.f7559b = aVar;
        this.f7560c = aVar2;
    }

    public static n a(d dVar, c7.a aVar, c7.a aVar2) {
        return new n(dVar, aVar, aVar2);
    }

    public static pb.b c(d dVar, Context context, u9.l lVar) {
        return (pb.b) d6.g.b(dVar.k(context, lVar), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public pb.b get() {
        return c(this.f7558a, (Context) this.f7559b.get(), (u9.l) this.f7560c.get());
    }
}
