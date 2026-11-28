package la;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class k implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f7553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f7554b;

    public k(d dVar, c7.a aVar) {
        this.f7553a = dVar;
        this.f7554b = aVar;
    }

    public static k a(d dVar, c7.a aVar) {
        return new k(dVar, aVar);
    }

    public static u9.l c(d dVar, Context context) {
        return (u9.l) d6.g.b(dVar.h(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public u9.l get() {
        return c(this.f7553a, (Context) this.f7554b.get());
    }
}
