package g2;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class g extends a6 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f4810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f4811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Boolean f4812d;

    public g(h5 h5Var) {
        super(h5Var);
        this.f4811c = new f() { // from class: g2.e
            @Override // g2.f
            public final String e(String str, String str2) {
                return null;
            }
        };
    }

    public static final long I() {
        return ((Long) i3.f4921f.a(null)).longValue();
    }

    public static final long i() {
        return ((Long) i3.F.a(null)).longValue();
    }

    public final boolean A() {
        Boolean boolT = t("google_analytics_adid_collection_enabled");
        return boolT == null || boolT.booleanValue();
    }

    public final boolean B(String str, h3 h3Var) {
        if (str == null) {
            return ((Boolean) h3Var.a(null)).booleanValue();
        }
        String strE = this.f4811c.e(str, h3Var.b());
        return TextUtils.isEmpty(strE) ? ((Boolean) h3Var.a(null)).booleanValue() : ((Boolean) h3Var.a(Boolean.valueOf("1".equals(strE)))).booleanValue();
    }

    public final boolean C(String str) {
        return "1".equals(this.f4811c.e(str, "gaia_collection_enabled"));
    }

    public final boolean D() {
        Boolean boolT = t("google_analytics_automatic_screen_reporting_enabled");
        return boolT == null || boolT.booleanValue();
    }

    public final boolean E() {
        this.f4646a.b();
        Boolean boolT = t("firebase_analytics_collection_deactivated");
        return boolT != null && boolT.booleanValue();
    }

    public final boolean F(String str) {
        return "1".equals(this.f4811c.e(str, "measurement.event_sampling_enabled"));
    }

    public final boolean G() {
        if (this.f4810b == null) {
            Boolean boolT = t("app_measurement_lite");
            this.f4810b = boolT;
            if (boolT == null) {
                this.f4810b = Boolean.FALSE;
            }
        }
        return this.f4810b.booleanValue() || !this.f4646a.s();
    }

    public final boolean H() {
        if (this.f4812d == null) {
            synchronized (this) {
                try {
                    if (this.f4812d == null) {
                        ApplicationInfo applicationInfo = this.f4646a.c().getApplicationInfo();
                        String strA = x1.k.a();
                        if (applicationInfo != null) {
                            String str = applicationInfo.processName;
                            boolean z10 = false;
                            if (str != null && str.equals(strA)) {
                                z10 = true;
                            }
                            this.f4812d = Boolean.valueOf(z10);
                        }
                        if (this.f4812d == null) {
                            this.f4812d = Boolean.TRUE;
                            this.f4646a.d().r().a("My process not in the list of running processes");
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f4812d.booleanValue();
    }

    public final String j(String str, String str2) {
        try {
            String str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, "");
            u1.f.h(str3);
            return str3;
        } catch (ClassNotFoundException e10) {
            this.f4646a.d().r().b("Could not find SystemProperties class", e10);
            return "";
        } catch (IllegalAccessException e11) {
            this.f4646a.d().r().b("Could not access SystemProperties.get()", e11);
            return "";
        } catch (NoSuchMethodException e12) {
            this.f4646a.d().r().b("Could not find SystemProperties.get() method", e12);
            return "";
        } catch (InvocationTargetException e13) {
            this.f4646a.d().r().b("SystemProperties.get() threw an exception", e13);
            return "";
        }
    }

    public final double k(String str, h3 h3Var) {
        if (str == null) {
            return ((Double) h3Var.a(null)).doubleValue();
        }
        String strE = this.f4811c.e(str, h3Var.b());
        if (TextUtils.isEmpty(strE)) {
            return ((Double) h3Var.a(null)).doubleValue();
        }
        try {
            return ((Double) h3Var.a(Double.valueOf(Double.parseDouble(strE)))).doubleValue();
        } catch (NumberFormatException unused) {
            return ((Double) h3Var.a(null)).doubleValue();
        }
    }

    public final int l(String str) {
        return p(str, i3.J, 500, 2000);
    }

    public final int m() {
        return this.f4646a.N().X(201500000, true) ? 100 : 25;
    }

    public final int n(String str) {
        return p(str, i3.K, 25, 100);
    }

    public final int o(String str, h3 h3Var) {
        if (str == null) {
            return ((Integer) h3Var.a(null)).intValue();
        }
        String strE = this.f4811c.e(str, h3Var.b());
        if (TextUtils.isEmpty(strE)) {
            return ((Integer) h3Var.a(null)).intValue();
        }
        try {
            return ((Integer) h3Var.a(Integer.valueOf(Integer.parseInt(strE)))).intValue();
        } catch (NumberFormatException unused) {
            return ((Integer) h3Var.a(null)).intValue();
        }
    }

    public final int p(String str, h3 h3Var, int i10, int i11) {
        return Math.max(Math.min(o(str, h3Var), i11), i10);
    }

    public final long q() {
        this.f4646a.b();
        return 79000L;
    }

    public final long r(String str, h3 h3Var) {
        if (str == null) {
            return ((Long) h3Var.a(null)).longValue();
        }
        String strE = this.f4811c.e(str, h3Var.b());
        if (TextUtils.isEmpty(strE)) {
            return ((Long) h3Var.a(null)).longValue();
        }
        try {
            return ((Long) h3Var.a(Long.valueOf(Long.parseLong(strE)))).longValue();
        } catch (NumberFormatException unused) {
            return ((Long) h3Var.a(null)).longValue();
        }
    }

    public final Bundle s() {
        try {
            if (this.f4646a.c().getPackageManager() == null) {
                this.f4646a.d().r().a("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfoB = y1.e.a(this.f4646a.c()).b(this.f4646a.c().getPackageName(), 128);
            if (applicationInfoB != null) {
                return applicationInfoB.metaData;
            }
            this.f4646a.d().r().a("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e10) {
            this.f4646a.d().r().b("Failed to load metadata: Package name not found", e10);
            return null;
        }
    }

    public final Boolean t(String str) {
        u1.f.d(str);
        Bundle bundleS = s();
        if (bundleS == null) {
            this.f4646a.d().r().a("Failed to load metadata: Metadata bundle is null");
            return null;
        }
        if (bundleS.containsKey(str)) {
            return Boolean.valueOf(bundleS.getBoolean(str));
        }
        return null;
    }

    public final String u() {
        return j("debug.firebase.analytics.app", "");
    }

    public final String v() {
        return j("debug.deferred.deeplink", "");
    }

    public final String w() {
        this.f4646a.b();
        return "FA";
    }

    public final String x(String str, h3 h3Var) {
        return str == null ? (String) h3Var.a(null) : (String) h3Var.a(this.f4811c.e(str, h3Var.b()));
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0042 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:14:0x0043 A[Catch: NotFoundException -> 0x0048, TRY_LEAVE, TryCatch #0 {NotFoundException -> 0x0048, blocks: (B:11:0x002e, B:14:0x0043), top: B:19:0x002e }] */
    /* JADX WARN: Code duplicated, block: B:19:0x002e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final List y(String str) {
        Integer numValueOf;
        String[] stringArray;
        u1.f.d("analytics.safelisted_events");
        Bundle bundleS = s();
        if (bundleS != null) {
            if (bundleS.containsKey("analytics.safelisted_events")) {
                numValueOf = Integer.valueOf(bundleS.getInt("analytics.safelisted_events"));
            }
            if (numValueOf != null) {
                try {
                    stringArray = this.f4646a.c().getResources().getStringArray(numValueOf.intValue());
                    if (stringArray == null) {
                        return null;
                    }
                    return Arrays.asList(stringArray);
                } catch (Resources.NotFoundException e10) {
                    this.f4646a.d().r().b("Failed to load string array from metadata: resource not found", e10);
                }
            }
            return null;
        }
        this.f4646a.d().r().a("Failed to load metadata: Metadata bundle is null");
        numValueOf = null;
        if (numValueOf != null) {
            stringArray = this.f4646a.c().getResources().getStringArray(numValueOf.intValue());
            if (stringArray == null) {
                return null;
            }
            return Arrays.asList(stringArray);
        }
        return null;
    }

    public final void z(f fVar) {
        this.f4811c = fVar;
    }
}
