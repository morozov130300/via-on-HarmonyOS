package la;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class i implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f7548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f7549b;

    public i(d dVar, c7.a aVar) {
        this.f7548a = dVar;
        this.f7549b = aVar;
    }

    public static i a(d dVar, c7.a aVar) {
        return new i(dVar, aVar);
    }

    public static e6.e c(d dVar, Context context) {
        return (e6.e) d6.g.b(dVar.f(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public e6.e get() {
        return c(this.f7548a, (Context) this.f7549b.get());
    }
}
