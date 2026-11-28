package g2;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzau;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class ja implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f5008c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f5009e = "_err";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Bundle f5010m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ ka f5011n;

    public ja(ka kaVar, String str, String str2, Bundle bundle) {
        this.f5011n = kaVar;
        this.f5008c = str;
        this.f5010m = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5011n.f5040a.k((zzau) u1.f.h(this.f5011n.f5040a.h0().y0(this.f5008c, this.f5009e, this.f5010m, "auto", this.f5011n.f5040a.a().a(), false, true)), this.f5008c);
    }
}
