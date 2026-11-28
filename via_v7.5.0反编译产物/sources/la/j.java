package la;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class j implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f7550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f7551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c7.a f7552c;

    public j(d dVar, c7.a aVar, c7.a aVar2) {
        this.f7550a = dVar;
        this.f7551b = aVar;
        this.f7552c = aVar2;
    }

    public static j a(d dVar, c7.a aVar, c7.a aVar2) {
        return new j(dVar, aVar, aVar2);
    }

    public static t9.g c(d dVar, Context context, u9.l lVar) {
        return (t9.g) d6.g.b(dVar.g(context, lVar), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public t9.g get() {
        return c(this.f7550a, (Context) this.f7551b.get(), (u9.l) this.f7552c.get());
    }
}
