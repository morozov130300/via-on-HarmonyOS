package lc;

import oc.y;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f implements rc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f7663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char f7664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f7665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f7666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f f7667e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f f7668f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f7669g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f7670h = 1;

    public f(y yVar, char c10, boolean z10, boolean z11, f fVar) {
        this.f7663a = yVar;
        this.f7664b = c10;
        this.f7665c = z10;
        this.f7666d = z11;
        this.f7667e = fVar;
    }

    @Override // rc.b
    public int a() {
        return this.f7670h;
    }

    @Override // rc.b
    public boolean b() {
        return this.f7665c;
    }

    @Override // rc.b
    public boolean c() {
        return this.f7666d;
    }

    @Override // rc.b
    public int length() {
        return this.f7669g;
    }
}
