package lc;

import oc.y;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f7656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f7657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f7658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f7659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f7660e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f7661f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f7662g = false;

    public e(y yVar, int i10, e eVar, f fVar, boolean z10) {
        this.f7656a = yVar;
        this.f7657b = i10;
        this.f7658c = z10;
        this.f7659d = eVar;
        this.f7660e = fVar;
    }

    public static e a(y yVar, int i10, e eVar, f fVar) {
        return new e(yVar, i10, eVar, fVar, true);
    }

    public static e b(y yVar, int i10, e eVar, f fVar) {
        return new e(yVar, i10, eVar, fVar, false);
    }
}
