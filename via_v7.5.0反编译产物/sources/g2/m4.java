package g2;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.he;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class m4 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.t0 f5097c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ServiceConnection f5098e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ n4 f5099m;

    public m4(n4 n4Var, com.google.android.gms.internal.measurement.t0 t0Var, ServiceConnection serviceConnection) {
        this.f5099m = n4Var;
        this.f5097c = t0Var;
        this.f5098e = serviceConnection;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x011b  */
    /* JADX WARN: Code duplicated, block: B:38:0x0132  */
    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundleX;
        n4 n4Var = this.f5099m;
        o4 o4Var = n4Var.f5138b;
        String str = n4Var.f5137a;
        com.google.android.gms.internal.measurement.t0 t0Var = this.f5097c;
        ServiceConnection serviceConnection = this.f5098e;
        o4Var.f5160a.f().h();
        Bundle bundle = new Bundle();
        bundle.putString("package_name", str);
        try {
            bundleX = t0Var.x(bundle);
            if (bundleX == null) {
                o4Var.f5160a.d().r().a("Install Referrer Service returned a null response");
                bundleX = null;
            }
        } catch (Exception e10) {
            o4Var.f5160a.d().r().b("Exception occurred while retrieving the Install Referrer", e10.getMessage());
        }
        o4Var.f5160a.f().h();
        h5.t();
        if (bundleX != null) {
            long j10 = bundleX.getLong("install_begin_timestamp_seconds", 0L) * 1000;
            if (j10 == 0) {
                o4Var.f5160a.d().w().a("Service response is missing Install Referrer install timestamp");
            } else {
                String string = bundleX.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    o4Var.f5160a.d().r().a("No referrer defined in Install Referrer response");
                } else {
                    o4Var.f5160a.d().v().b("InstallReferrer API result", string);
                    wa waVarN = o4Var.f5160a.N();
                    Uri uri = Uri.parse("?".concat(string));
                    he.b();
                    Bundle bundleV0 = waVarN.v0(uri, o4Var.f5160a.z().B(null, i3.f4960y0));
                    if (bundleV0 == null) {
                        o4Var.f5160a.d().r().a("No campaign params defined in Install Referrer result");
                    } else {
                        String string2 = bundleV0.getString("medium");
                        if (string2 == null || "(not set)".equalsIgnoreCase(string2) || "organic".equalsIgnoreCase(string2)) {
                            if (j10 == o4Var.f5160a.F().f5048f.a()) {
                                o4Var.f5160a.d().v().a("Logging Install Referrer campaign from module while it may have already been logged.");
                            }
                            if (o4Var.f5160a.o()) {
                                o4Var.f5160a.F().f5048f.b(j10);
                                o4Var.f5160a.d().v().b("Logging Install Referrer campaign from gmscore with ", "referrer API v2");
                                bundleV0.putString("_cis", "referrer API v2");
                                o4Var.f5160a.I().t("auto", "_cmp", bundleV0, str);
                            }
                        } else {
                            long j11 = bundleX.getLong("referrer_click_timestamp_seconds", 0L) * 1000;
                            if (j11 == 0) {
                                o4Var.f5160a.d().r().a("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                bundleV0.putLong("click_timestamp", j11);
                                if (j10 == o4Var.f5160a.F().f5048f.a()) {
                                    o4Var.f5160a.d().v().a("Logging Install Referrer campaign from module while it may have already been logged.");
                                }
                                if (o4Var.f5160a.o()) {
                                    o4Var.f5160a.F().f5048f.b(j10);
                                    o4Var.f5160a.d().v().b("Logging Install Referrer campaign from gmscore with ", "referrer API v2");
                                    bundleV0.putString("_cis", "referrer API v2");
                                    o4Var.f5160a.I().t("auto", "_cmp", bundleV0, str);
                                }
                            }
                        }
                    }
                }
            }
        }
        w1.b.b().c(o4Var.f5160a.c(), serviceConnection);
    }
}
