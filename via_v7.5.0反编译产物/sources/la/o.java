package la;

import android.content.Context;
import oa.k1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class o implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f7561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f7562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c7.a f7563c;

    public o(d dVar, c7.a aVar, c7.a aVar2) {
        this.f7561a = dVar;
        this.f7562b = aVar;
        this.f7563c = aVar2;
    }

    public static o a(d dVar, c7.a aVar, c7.a aVar2) {
        return new o(dVar, aVar, aVar2);
    }

    public static k1 c(d dVar, Context context, u9.l lVar) {
        return (k1) d6.g.b(dVar.l(context, lVar), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public k1 get() {
        return c(this.f7561a, (Context) this.f7562b.get(), (u9.l) this.f7563c.get());
    }
}
