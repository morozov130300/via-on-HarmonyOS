package g2;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class x7 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Bundle f5430c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ v7 f5431e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ v7 f5432m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ long f5433n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ d8 f5434o;

    public x7(d8 d8Var, Bundle bundle, v7 v7Var, v7 v7Var2, long j10) {
        this.f5434o = d8Var;
        this.f5430c = bundle;
        this.f5431e = v7Var;
        this.f5432m = v7Var2;
        this.f5433n = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d8.w(this.f5434o, this.f5430c, this.f5431e, this.f5432m, this.f5433n);
    }
}
