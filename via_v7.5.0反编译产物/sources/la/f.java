package la;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class f implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f7540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f7541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c7.a f7542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c7.a f7543d;

    public f(d dVar, c7.a aVar, c7.a aVar2, c7.a aVar3) {
        this.f7540a = dVar;
        this.f7541b = aVar;
        this.f7542c = aVar2;
        this.f7543d = aVar3;
    }

    public static f a(d dVar, c7.a aVar, c7.a aVar2, c7.a aVar3) {
        return new f(dVar, aVar, aVar2, aVar3);
    }

    public static u4.a c(d dVar, Context context, u9.l lVar, u9.r rVar) {
        return (u4.a) d6.g.b(dVar.c(context, lVar, rVar), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public u4.a get() {
        return c(this.f7540a, (Context) this.f7541b.get(), (u9.l) this.f7542c.get(), (u9.r) this.f7543d.get());
    }
}
