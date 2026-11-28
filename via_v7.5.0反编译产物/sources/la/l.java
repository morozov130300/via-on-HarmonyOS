package la;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class l implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f7555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f7556b;

    public l(d dVar, c7.a aVar) {
        this.f7555a = dVar;
        this.f7556b = aVar;
    }

    public static l a(d dVar, c7.a aVar) {
        return new l(dVar, aVar);
    }

    public static q8.b c(d dVar, Context context) {
        return (q8.b) d6.g.b(dVar.i(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public q8.b get() {
        return c(this.f7555a, (Context) this.f7556b.get());
    }
}
