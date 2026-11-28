package sa;

import oa.k1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class h0 implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f12262a;

    public h0(c7.a aVar) {
        this.f12262a = aVar;
    }

    public static h0 a(c7.a aVar) {
        return new h0(aVar);
    }

    public static g0 c(k1 k1Var) {
        return new g0(k1Var);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public g0 get() {
        return c((k1) this.f12262a.get());
    }
}
