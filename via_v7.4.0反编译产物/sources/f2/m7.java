package f2;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.he;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class m7 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f5498e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Uri f5499j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f5500k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f5501l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ n7 f5502m;

    public m7(n7 n7Var, boolean z10, Uri uri, String str, String str2) {
        this.f5502m = n7Var;
        this.f5498e = z10;
        this.f5499j = uri;
        this.f5500k = str;
        this.f5501l = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundleV0;
        n7 n7Var = this.f5502m;
        boolean z10 = this.f5498e;
        Uri uri = this.f5499j;
        String str = this.f5500k;
        String str2 = this.f5501l;
        n7Var.f5530e.h();
        try {
            wa waVarN = n7Var.f5530e.f5030a.N();
            he.b();
            g gVarZ = n7Var.f5530e.f5030a.z();
            h3 h3Var = i3.f5342x0;
            boolean zB = gVarZ.B(null, h3Var);
            if (TextUtils.isEmpty(str2)) {
                bundleV0 = null;
            } else {
                if (!str2.contains("gclid") && !str2.contains("utm_campaign") && !str2.contains("utm_source") && !str2.contains("utm_medium") && !str2.contains("utm_id") && !str2.contains("dclid") && !str2.contains("srsltid")) {
                    if (zB && str2.contains("sfmc_id")) {
                        zB = true;
                    }
                    waVarN.f5030a.d().q().a("Activity created with data 'referrer' without required params");
                    bundleV0 = null;
                }
                bundleV0 = waVarN.v0(Uri.parse("https://google.com/search?".concat(str2)), zB);
                if (bundleV0 != null) {
                    bundleV0.putString("_cis", "referrer");
                }
            }
            if (z10) {
                wa waVarN2 = n7Var.f5530e.f5030a.N();
                he.b();
                Bundle bundleV02 = waVarN2.v0(uri, n7Var.f5530e.f5030a.z().B(null, h3Var));
                if (bundleV02 != null) {
                    bundleV02.putString("_cis", "intent");
                    if (!bundleV02.containsKey("gclid") && bundleV0 != null && bundleV0.containsKey("gclid")) {
                        bundleV02.putString("_cer", String.format("gclid=%s", bundleV0.getString("gclid")));
                    }
                    n7Var.f5530e.u(str, "_cmp", bundleV02);
                    n7Var.f5530e.f5560l.a(str, bundleV02);
                }
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            n7Var.f5530e.f5030a.d().q().b("Activity created with referrer", str2);
            if (n7Var.f5530e.f5030a.z().B(null, i3.f5300c0)) {
                if (bundleV0 != null) {
                    n7Var.f5530e.u(str, "_cmp", bundleV0);
                    n7Var.f5530e.f5560l.a(str, bundleV0);
                } else {
                    n7Var.f5530e.f5030a.d().q().b("Referrer does not contain valid parameters", str2);
                }
                n7Var.f5530e.K("auto", "_ldl", null, true);
                return;
            }
            if (!str2.contains("gclid") || (!str2.contains("utm_campaign") && !str2.contains("utm_source") && !str2.contains("utm_medium") && !str2.contains("utm_term") && !str2.contains("utm_content"))) {
                n7Var.f5530e.f5030a.d().q().a("Activity created with data 'referrer' without required params");
            } else {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                n7Var.f5530e.K("auto", "_ldl", str2, true);
            }
        } catch (RuntimeException e10) {
            n7Var.f5530e.f5030a.d().r().b("Throwable caught in handleReferrerForOnActivityCreated", e10);
        }
    }
}
