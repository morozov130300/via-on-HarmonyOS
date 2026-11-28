package g2;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class z3 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x3 f5481c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f5482e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Throwable f5483m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final byte[] f5484n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f5485o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Map f5486p;

    public /* synthetic */ z3(String str, x3 x3Var, int i10, Throwable th, byte[] bArr, Map map, y3 y3Var) {
        u1.f.h(x3Var);
        this.f5481c = x3Var;
        this.f5482e = i10;
        this.f5483m = th;
        this.f5484n = bArr;
        this.f5485o = str;
        this.f5486p = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5481c.a(this.f5485o, this.f5482e, this.f5483m, this.f5484n, this.f5486p);
    }
}
