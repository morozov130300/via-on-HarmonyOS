package g2;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class t6 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f5315c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f5316e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ long f5317m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Bundle f5318n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ boolean f5319o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ boolean f5320p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ boolean f5321q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final /* synthetic */ String f5322r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final /* synthetic */ o7 f5323s;

    public t6(o7 o7Var, String str, String str2, long j10, Bundle bundle, boolean z10, boolean z11, boolean z12, String str3) {
        this.f5323s = o7Var;
        this.f5315c = str;
        this.f5316e = str2;
        this.f5317m = j10;
        this.f5318n = bundle;
        this.f5319o = z10;
        this.f5320p = z11;
        this.f5321q = z12;
        this.f5322r = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5323s.w(this.f5315c, this.f5316e, this.f5317m, this.f5318n, this.f5319o, this.f5320p, this.f5321q, this.f5322r);
    }
}
