package la;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class h implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f7546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f7547b;

    public h(d dVar, c7.a aVar) {
        this.f7546a = dVar;
        this.f7547b = aVar;
    }

    public static h a(d dVar, c7.a aVar) {
        return new h(dVar, aVar);
    }

    public static q9.d c(d dVar, Context context) {
        return (q9.d) d6.g.b(dVar.e(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public q9.d get() {
        return c(this.f7546a, (Context) this.f7547b.get());
    }
}
