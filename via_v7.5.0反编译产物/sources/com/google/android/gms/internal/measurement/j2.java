package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class j2 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f2867c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f2868e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f2869m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ u2 f2870n;

    public j2(u2 u2Var, boolean z10) {
        this.f2870n = u2Var;
        this.f2867c = u2Var.f3112b.a();
        this.f2868e = u2Var.f3112b.b();
        this.f2869m = z10;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f2870n.f3117g) {
            b();
            return;
        }
        try {
            a();
        } catch (Exception e10) {
            this.f2870n.h(e10, false, this.f2869m);
            b();
        }
    }

    public void b() {
    }
}
