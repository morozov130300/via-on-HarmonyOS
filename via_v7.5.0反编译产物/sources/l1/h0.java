package l1;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class h0 implements g1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f7421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f7422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c7.a f7423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c7.a f7424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c7.a f7425e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c7.a f7426f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c7.a f7427g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c7.a f7428h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c7.a f7429i;

    public h0(c7.a aVar, c7.a aVar2, c7.a aVar3, c7.a aVar4, c7.a aVar5, c7.a aVar6, c7.a aVar7, c7.a aVar8, c7.a aVar9) {
        this.f7421a = aVar;
        this.f7422b = aVar2;
        this.f7423c = aVar3;
        this.f7424d = aVar4;
        this.f7425e = aVar5;
        this.f7426f = aVar6;
        this.f7427g = aVar7;
        this.f7428h = aVar8;
        this.f7429i = aVar9;
    }

    public static h0 a(c7.a aVar, c7.a aVar2, c7.a aVar3, c7.a aVar4, c7.a aVar5, c7.a aVar6, c7.a aVar7, c7.a aVar8, c7.a aVar9) {
        return new h0(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9);
    }

    public static g0 c(Context context, f1.d dVar, m1.d dVar2, m0 m0Var, Executor executor, n1.a aVar, o1.a aVar2, o1.a aVar3, m1.c cVar) {
        return new g0(context, dVar, dVar2, m0Var, executor, aVar, aVar2, aVar3, cVar);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public g0 get() {
        return c((Context) this.f7421a.get(), (f1.d) this.f7422b.get(), (m1.d) this.f7423c.get(), (m0) this.f7424d.get(), (Executor) this.f7425e.get(), (n1.a) this.f7426f.get(), (o1.a) this.f7427g.get(), (o1.a) this.f7428h.get(), (m1.c) this.f7429i.get());
    }
}
