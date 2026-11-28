package g2;

import com.google.android.gms.measurement.internal.zzau;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class t5 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzau f5312c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f5313e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ z5 f5314m;

    public t5(z5 z5Var, zzau zzauVar, String str) {
        this.f5314m = z5Var;
        this.f5312c = zzauVar;
        this.f5313e = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5314m.f5487d.e();
        this.f5314m.f5487d.k(this.f5312c, this.f5313e);
    }
}
