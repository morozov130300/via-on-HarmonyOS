package f2;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.he;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class m4 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.t0 f5481e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ ServiceConnection f5482j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ n4 f5483k;

    public m4(n4 n4Var, com.google.android.gms.internal.measurement.t0 t0Var, ServiceConnection serviceConnection) {
        this.f5483k = n4Var;
        this.f5481e = t0Var;
        this.f5482j = serviceConnection;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0132  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        Bundle bundleY;
        n4 n4Var = this.f5483k;
        o4 o4Var = n4Var.f5522b;
        String str = n4Var.f5521a;
        com.google.android.gms.internal.measurement.t0 t0Var = this.f5481e;
        ServiceConnection serviceConnection = this.f5482j;
        o4Var.f5544a.f().h();
        Bundle bundle = new Bundle();
        bundle.putString("package_name", str);
        try {
            bundleY = t0Var.y(bundle);
        } catch (Exception e10) {
            o4Var.f5544a.d().r().b("Exception occurred while retrieving the Install Referrer", e10.getMessage());
        }
        if (bundleY == null) {
            o4Var.f5544a.d().r().a("Install Referrer Service returned a null response");
            bundleY = null;
        }
        o4Var.f5544a.f().h();
        h5.t();
        if (bundleY != null) {
            long j10 = bundleY.getLong("install_begin_timestamp_seconds", 0L) * 1000;
            if (j10 == 0) {
                o4Var.f5544a.d().w().a("Service response is missing Install Referrer install timestamp");
            } else {
                String string = bundleY.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    o4Var.f5544a.d().r().a("No referrer defined in Install Referrer response");
                } else {
                    o4Var.f5544a.d().v().b("InstallReferrer API result", string);
                    wa waVarN = o4Var.f5544a.N();
                    Uri uri = Uri.parse("?".concat(string));
                    he.b();
                    Bundle bundleV0 = waVarN.v0(uri, o4Var.f5544a.z().B(null, i3.f5344y0));
                    if (bundleV0 == null) {
                        o4Var.f5544a.d().r().a("No campaign params defined in Install Referrer result");
                    } else {
                        String string2 = bundleV0.getString("medium");
                        if (string2 == null || "(not set)".equalsIgnoreCase(string2) || "organic".equalsIgnoreCase(string2)) {
                            if (j10 == o4Var.f5544a.F().f5432f.a()) {
                                o4Var.f5544a.d().v().a("Logging Install Referrer campaign from module while it may have already been logged.");
                            }
                            if (o4Var.f5544a.o()) {
                                o4Var.f5544a.F().f5432f.b(j10);
                                o4Var.f5544a.d().v().b("Logging Install Referrer campaign from gmscore with ", "referrer API v2");
                                bundleV0.putString("_cis", "referrer API v2");
                                o4Var.f5544a.I().t("auto", "_cmp", bundleV0, str);
                            }
                        } else {
                            long j11 = bundleY.getLong("referrer_click_timestamp_seconds", 0L) * 1000;
                            if (j11 == 0) {
                                o4Var.f5544a.d().r().a("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                bundleV0.putLong("click_timestamp", j11);
                                if (j10 == o4Var.f5544a.F().f5432f.a()) {
                                }
                                if (o4Var.f5544a.o()) {
                                }
                            }
                        }
                    }
                }
            }
        }
        v1.b.b().c(o4Var.f5544a.c(), serviceConnection);
    }
}
