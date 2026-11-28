package la;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class p implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f7564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f7565b;

    public p(d dVar, c7.a aVar) {
        this.f7564a = dVar;
        this.f7565b = aVar;
    }

    public static p a(d dVar, c7.a aVar) {
        return new p(dVar, aVar);
    }

    public static u9.r c(d dVar, Context context) {
        return (u9.r) d6.g.b(dVar.m(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public u9.r get() {
        return c(this.f7564a, (Context) this.f7565b.get());
    }
}
