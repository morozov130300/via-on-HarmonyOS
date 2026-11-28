package la;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class g implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f7544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f7545b;

    public g(d dVar, c7.a aVar) {
        this.f7544a = dVar;
        this.f7545b = aVar;
    }

    public static g a(d dVar, c7.a aVar) {
        return new g(dVar, aVar);
    }

    public static n9.o c(d dVar, Context context) {
        return (n9.o) d6.g.b(dVar.d(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public n9.o get() {
        return c(this.f7544a, (Context) this.f7545b.get());
    }
}
