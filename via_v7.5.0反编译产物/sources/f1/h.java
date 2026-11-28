package f1;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class h implements g1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f4425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f4426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c7.a f4427c;

    public h(c7.a aVar, c7.a aVar2, c7.a aVar3) {
        this.f4425a = aVar;
        this.f4426b = aVar2;
        this.f4427c = aVar3;
    }

    public static h a(c7.a aVar, c7.a aVar2, c7.a aVar3) {
        return new h(aVar, aVar2, aVar3);
    }

    public static g c(Context context, o1.a aVar, o1.a aVar2) {
        return new g(context, aVar, aVar2);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public g get() {
        return c((Context) this.f4425a.get(), (o1.a) this.f4426b.get(), (o1.a) this.f4427c.get());
    }
}
