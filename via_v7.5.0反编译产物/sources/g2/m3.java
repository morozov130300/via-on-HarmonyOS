package g2;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.ae;
import com.google.android.gms.internal.measurement.ed;
import com.google.android.gms.internal.measurement.qe;
import com.google.android.gms.measurement.internal.zzha;
import com.google.android.gms.measurement.internal.zzq;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class m3 extends c4 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f5083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5084e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f5085f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f5086g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f5087h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f5088i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List f5089j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f5090k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f5091l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f5092m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f5093n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f5094o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f5095p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f5096q;

    public m3(h5 h5Var, long j10) {
        super(h5Var);
        this.f5095p = 0L;
        this.f5096q = null;
        this.f5088i = j10;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:34:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:35:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:36:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:37:0x0100  */
    /* JADX WARN: Code duplicated, block: B:38:0x0110  */
    /* JADX WARN: Code duplicated, block: B:39:0x0120  */
    /* JADX WARN: Code duplicated, block: B:40:0x0130  */
    /* JADX WARN: Code duplicated, block: B:41:0x0140  */
    /* JADX WARN: Code duplicated, block: B:42:0x0150  */
    /* JADX WARN: Code duplicated, block: B:45:0x016a  */
    /* JADX WARN: Code duplicated, block: B:48:0x018a  */
    /* JADX WARN: Code duplicated, block: B:49:0x018b  */
    /* JADX WARN: Code duplicated, block: B:52:0x0194 A[Catch: IllegalStateException -> 0x01bb, TryCatch #3 {IllegalStateException -> 0x01bb, blocks: (B:46:0x0172, B:50:0x018c, B:52:0x0194, B:56:0x01b2, B:55:0x01ae, B:60:0x01bf, B:62:0x01d5, B:64:0x01da, B:63:0x01d8), top: B:91:0x0172 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:55:0x01ae A[Catch: IllegalStateException -> 0x01bb, TryCatch #3 {IllegalStateException -> 0x01bb, blocks: (B:46:0x0172, B:50:0x018c, B:52:0x0194, B:56:0x01b2, B:55:0x01ae, B:60:0x01bf, B:62:0x01d5, B:64:0x01da, B:63:0x01d8), top: B:91:0x0172 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x01bf A[Catch: IllegalStateException -> 0x01bb, TryCatch #3 {IllegalStateException -> 0x01bb, blocks: (B:46:0x0172, B:50:0x018c, B:52:0x0194, B:56:0x01b2, B:55:0x01ae, B:60:0x01bf, B:62:0x01d5, B:64:0x01da, B:63:0x01d8), top: B:91:0x0172 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x01d5 A[Catch: IllegalStateException -> 0x01bb, TryCatch #3 {IllegalStateException -> 0x01bb, blocks: (B:46:0x0172, B:50:0x018c, B:52:0x0194, B:56:0x01b2, B:55:0x01ae, B:60:0x01bf, B:62:0x01d5, B:64:0x01da, B:63:0x01d8), top: B:91:0x0172 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x01d8 A[Catch: IllegalStateException -> 0x01bb, TryCatch #3 {IllegalStateException -> 0x01bb, blocks: (B:46:0x0172, B:50:0x018c, B:52:0x0194, B:56:0x01b2, B:55:0x01ae, B:60:0x01bf, B:62:0x01d5, B:64:0x01da, B:63:0x01d8), top: B:91:0x0172 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0208  */
    /* JADX WARN: Code duplicated, block: B:72:0x020e  */
    /* JADX WARN: Code duplicated, block: B:73:0x021e  */
    /* JADX WARN: Code duplicated, block: B:76:0x0228  */
    /* JADX WARN: Code duplicated, block: B:79:0x023d  */
    /* JADX WARN: Code duplicated, block: B:81:0x0241  */
    /* JADX WARN: Code duplicated, block: B:83:0x024e  */
    /* JADX WARN: Code duplicated, block: B:93:0x023d A[SYNTHETIC] */
    @Override // g2.c4
    public final void l() {
        String str;
        String string;
        boolean z10;
        int iX;
        List listY;
        Iterator it;
        String strB;
        String str2;
        Context contextC;
        String strR;
        String packageName = this.f4646a.c().getPackageName();
        PackageManager packageManager = this.f4646a.c().getPackageManager();
        int i10 = Integer.MIN_VALUE;
        String str3 = "";
        String str4 = "Unknown";
        String installerPackageName = "unknown";
        try {
            if (packageManager != null) {
                try {
                    installerPackageName = packageManager.getInstallerPackageName(packageName);
                } catch (IllegalArgumentException unused) {
                    this.f4646a.d().r().b("Error retrieving app installer package name. appId", v3.z(packageName));
                }
                if (installerPackageName == null) {
                    installerPackageName = "manual_install";
                } else if ("com.android.vending".equals(installerPackageName)) {
                    installerPackageName = "";
                }
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(this.f4646a.c().getPackageName(), 0);
                    if (packageInfo != null) {
                        CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                        string = !TextUtils.isEmpty(applicationLabel) ? applicationLabel.toString() : "Unknown";
                        try {
                            str4 = packageInfo.versionName;
                            i10 = packageInfo.versionCode;
                        } catch (PackageManager.NameNotFoundException unused2) {
                            str = str4;
                            str4 = string;
                            this.f4646a.d().r().c("Error retrieving package info. appId, appName", v3.z(packageName), str4);
                            string = str4;
                            str4 = str;
                        }
                    }
                } catch (PackageManager.NameNotFoundException unused3) {
                    str = "Unknown";
                }
                this.f5082c = packageName;
                this.f5085f = installerPackageName;
                this.f5083d = str4;
                this.f5084e = i10;
                this.f5086g = string;
                this.f5087h = 0L;
                if (TextUtils.isEmpty(this.f4646a.O()) && "am".equals(this.f4646a.P())) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                iX = this.f4646a.x();
                switch (iX) {
                    case 0:
                        this.f4646a.d().v().a("App measurement collection enabled");
                        break;
                    case 1:
                        this.f4646a.d().u().a("App measurement deactivated via the manifest");
                        break;
                    case 2:
                        this.f4646a.d().v().a("App measurement deactivated via the init parameters");
                        break;
                    case 3:
                        this.f4646a.d().u().a("App measurement disabled by setAnalyticsCollectionEnabled(false)");
                        break;
                    case 4:
                        this.f4646a.d().u().a("App measurement disabled via the manifest");
                        break;
                    case 5:
                        this.f4646a.d().v().a("App measurement disabled via the init parameters");
                        break;
                    case 6:
                        this.f4646a.d().x().a("App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics");
                        break;
                    case 7:
                        this.f4646a.d().u().a("App measurement disabled via the global data collection setting");
                        break;
                    default:
                        this.f4646a.d().u().a("App measurement disabled due to denied storage consent");
                        break;
                }
                this.f5092m = "";
                this.f5093n = "";
                this.f4646a.b();
                if (z10) {
                    this.f5093n = this.f4646a.O();
                }
                strB = u7.b(this.f4646a.c(), "google_app_id", this.f4646a.R());
                if (TextUtils.isEmpty(strB)) {
                    str3 = strB;
                }
                this.f5092m = str3;
                if (!TextUtils.isEmpty(strB)) {
                    contextC = this.f4646a.c();
                    strR = this.f4646a.R();
                    u1.f.h(contextC);
                    Resources resources = contextC.getResources();
                    if (!TextUtils.isEmpty(strR)) {
                        strR = z4.a(contextC);
                    }
                    this.f5093n = z4.b("admob_app_id", resources, strR);
                }
                if (iX == 0) {
                    t3 t3VarV = this.f4646a.d().v();
                    String str5 = this.f5082c;
                    if (TextUtils.isEmpty(this.f5092m)) {
                        str2 = this.f5093n;
                    } else {
                        str2 = this.f5092m;
                    }
                    t3VarV.c("App measurement enabled for app package, google app id", str5, str2);
                }
                this.f5089j = null;
                this.f4646a.b();
                listY = this.f4646a.z().y("analytics.safelisted_events");
                if (listY != null) {
                    this.f5089j = listY;
                } else if (listY.isEmpty()) {
                    this.f4646a.d().x().a("Safelisted event list is empty. Ignoring");
                } else {
                    it = listY.iterator();
                    do {
                        if (it.hasNext()) {
                            this.f5089j = listY;
                        }
                    } while (this.f4646a.N().R("safelisted event", (String) it.next()));
                }
                if (packageManager != null) {
                    this.f5091l = y1.b.a(this.f4646a.c()) ? 1 : 0;
                } else {
                    this.f5091l = 0;
                }
            }
            this.f4646a.d().r().b("PackageManager is null, app identity information might be inaccurate. appId", v3.z(packageName));
            strB = u7.b(this.f4646a.c(), "google_app_id", this.f4646a.R());
            if (TextUtils.isEmpty(strB)) {
                str3 = strB;
            }
            this.f5092m = str3;
            if (!TextUtils.isEmpty(strB)) {
                contextC = this.f4646a.c();
                strR = this.f4646a.R();
                u1.f.h(contextC);
                Resources resources2 = contextC.getResources();
                if (!TextUtils.isEmpty(strR)) {
                    strR = z4.a(contextC);
                }
                this.f5093n = z4.b("admob_app_id", resources2, strR);
            }
            if (iX == 0) {
                t3 t3VarV2 = this.f4646a.d().v();
                String str6 = this.f5082c;
                if (TextUtils.isEmpty(this.f5092m)) {
                    str2 = this.f5093n;
                } else {
                    str2 = this.f5092m;
                }
                t3VarV2.c("App measurement enabled for app package, google app id", str6, str2);
            }
        } catch (IllegalStateException e10) {
            this.f4646a.d().r().c("Fetching Google App Id failed with exception. appId", v3.z(packageName), e10);
        }
        string = "Unknown";
        this.f5082c = packageName;
        this.f5085f = installerPackageName;
        this.f5083d = str4;
        this.f5084e = i10;
        this.f5086g = string;
        this.f5087h = 0L;
        if (TextUtils.isEmpty(this.f4646a.O())) {
            z10 = false;
        } else {
            z10 = false;
        }
        iX = this.f4646a.x();
        switch (iX) {
            case 0:
                this.f4646a.d().v().a("App measurement collection enabled");
                break;
            case 1:
                this.f4646a.d().u().a("App measurement deactivated via the manifest");
                break;
            case 2:
                this.f4646a.d().v().a("App measurement deactivated via the init parameters");
                break;
            case 3:
                this.f4646a.d().u().a("App measurement disabled by setAnalyticsCollectionEnabled(false)");
                break;
            case 4:
                this.f4646a.d().u().a("App measurement disabled via the manifest");
                break;
            case 5:
                this.f4646a.d().v().a("App measurement disabled via the init parameters");
                break;
            case 6:
                this.f4646a.d().x().a("App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics");
                break;
            case 7:
                this.f4646a.d().u().a("App measurement disabled via the global data collection setting");
                break;
            default:
                this.f4646a.d().u().a("App measurement disabled due to denied storage consent");
                break;
        }
        this.f5092m = "";
        this.f5093n = "";
        this.f4646a.b();
        if (z10) {
            this.f5093n = this.f4646a.O();
        }
        this.f5089j = null;
        this.f4646a.b();
        listY = this.f4646a.z().y("analytics.safelisted_events");
        if (listY != null) {
            this.f5089j = listY;
        } else if (listY.isEmpty()) {
            this.f4646a.d().x().a("Safelisted event list is empty. Ignoring");
        } else {
            it = listY.iterator();
            do {
                if (it.hasNext()) {
                    this.f5089j = listY;
                }
            } while (this.f4646a.N().R("safelisted event", (String) it.next()));
        }
        if (packageManager != null) {
            this.f5091l = y1.b.a(this.f4646a.c()) ? 1 : 0;
        } else {
            this.f5091l = 0;
        }
    }

    @Override // g2.c4
    public final boolean n() {
        return true;
    }

    public final int o() {
        i();
        return this.f5091l;
    }

    public final int p() {
        i();
        return this.f5084e;
    }

    /* JADX WARN: Code duplicated, block: B:107:0x02bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x0193  */
    /* JADX WARN: Code duplicated, block: B:49:0x019a  */
    /* JADX WARN: Code duplicated, block: B:52:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:54:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:57:0x020a  */
    /* JADX WARN: Code duplicated, block: B:60:0x022e  */
    /* JADX WARN: Code duplicated, block: B:63:0x0238  */
    /* JADX WARN: Code duplicated, block: B:72:0x025e  */
    /* JADX WARN: Code duplicated, block: B:74:0x026e  */
    /* JADX WARN: Code duplicated, block: B:77:0x0288  */
    /* JADX WARN: Code duplicated, block: B:78:0x028b  */
    /* JADX WARN: Code duplicated, block: B:81:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:88:0x02cd A[Catch: NameNotFoundException -> 0x02d2, TRY_LEAVE, TryCatch #3 {NameNotFoundException -> 0x02d2, blocks: (B:86:0x02c7, B:88:0x02cd), top: B:103:0x02c7 }] */
    public final zzq q(String str) {
        boolean z10;
        h5 h5Var;
        long jA;
        long jMin;
        Boolean boolT;
        Boolean boolValueOf;
        String str2;
        Boolean boolT2;
        boolean zBooleanValue;
        wa waVarN;
        String strS;
        int i10;
        ApplicationInfo applicationInfoB;
        h();
        String strS2 = s();
        String strT = t();
        i();
        String str3 = this.f5083d;
        i();
        long j10 = this.f5084e;
        i();
        u1.f.h(this.f5085f);
        String str4 = this.f5085f;
        this.f4646a.z().q();
        i();
        h();
        long j11 = this.f5087h;
        if (j11 == 0) {
            wa waVarN2 = this.f4646a.N();
            Context contextC = this.f4646a.c();
            String packageName = this.f4646a.c().getPackageName();
            waVarN2.h();
            u1.f.h(contextC);
            u1.f.d(packageName);
            PackageManager packageManager = contextC.getPackageManager();
            MessageDigest messageDigestT = wa.t();
            long jS0 = -1;
            if (messageDigestT == null) {
                waVarN2.f4646a.d().r().a("Could not get MD5 instance");
            } else {
                if (packageManager != null) {
                    try {
                        if (waVarN2.W(contextC, packageName)) {
                            jS0 = 0;
                        } else {
                            Signature[] signatureArr = y1.e.a(contextC).c(waVarN2.f4646a.c().getPackageName(), 64).signatures;
                            if (signatureArr == null || signatureArr.length <= 0) {
                                waVarN2.f4646a.d().w().a("Could not get signatures");
                            } else {
                                jS0 = wa.s0(messageDigestT.digest(signatureArr[0].toByteArray()));
                            }
                        }
                    } catch (PackageManager.NameNotFoundException e10) {
                        waVarN2.f4646a.d().r().b("Package name not found", e10);
                        j11 = 0;
                    }
                }
                j11 = 0;
                this.f5087h = j11;
            }
            j11 = jS0;
            this.f5087h = j11;
        }
        boolean zO = this.f4646a.o();
        boolean z11 = !this.f4646a.F().f5059q;
        h();
        long j12 = 0;
        String str5 = null;
        if (this.f4646a.o()) {
            qe.b();
            if (this.f4646a.z().B(null, i3.f4920e0)) {
                this.f4646a.d().v().a("Disabled IID for tests.");
            } else {
                try {
                    Class<?> clsLoadClass = this.f4646a.c().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                    if (clsLoadClass != null) {
                        try {
                            z10 = z11;
                            try {
                                str5 = null;
                                Object objInvoke = clsLoadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, this.f4646a.c());
                                if (objInvoke != null) {
                                    try {
                                        str5 = (String) clsLoadClass.getDeclaredMethod("getFirebaseInstanceId", null).invoke(objInvoke, null);
                                    } catch (Exception unused) {
                                        this.f4646a.d().x().a("Failed to retrieve Firebase Instance Id");
                                        str5 = null;
                                    }
                                }
                            } catch (Exception unused2) {
                                this.f4646a.d().y().a("Failed to obtain Firebase Analytics instance");
                                str5 = null;
                                h5Var = this.f4646a;
                                jA = h5Var.F().f5047e.a();
                                if (jA == 0) {
                                    jMin = h5Var.G;
                                } else {
                                    jMin = Math.min(h5Var.G, jA);
                                }
                                i();
                                int i11 = this.f5091l;
                                boolean zA = this.f4646a.z().A();
                                l4 l4VarF = this.f4646a.F();
                                l4VarF.h();
                                boolean z12 = l4VarF.o().getBoolean("deferred_analytics_collection", false);
                                i();
                                String str6 = this.f5093n;
                                boolT = this.f4646a.z().t("google_analytics_default_allow_ad_personalization_signals");
                                if (boolT == null) {
                                    boolValueOf = null;
                                } else {
                                    boolValueOf = Boolean.valueOf(!boolT.booleanValue());
                                }
                                long j13 = this.f5088i;
                                Boolean bool = boolValueOf;
                                List list = this.f5089j;
                                String strI = this.f4646a.F().q().i();
                                if (this.f5090k == null) {
                                    this.f5090k = this.f4646a.N().q();
                                }
                                String str7 = this.f5090k;
                                ae.b();
                                if (this.f4646a.z().B(null, i3.f4942p0)) {
                                    h();
                                    if (this.f5095p != 0) {
                                        long jA2 = this.f4646a.a().a() - this.f5095p;
                                        if (this.f5094o != null) {
                                            v();
                                        }
                                    }
                                    if (this.f5094o == null) {
                                        v();
                                    }
                                    str2 = this.f5094o;
                                } else {
                                    str2 = null;
                                }
                                g gVarZ = this.f4646a.z();
                                h5 h5Var2 = gVarZ.f4646a;
                                boolT2 = gVarZ.t("google_analytics_sgtm_upload_enabled");
                                if (boolT2 == null) {
                                    zBooleanValue = false;
                                } else {
                                    zBooleanValue = boolT2.booleanValue();
                                }
                                ed.b();
                                if (this.f4646a.z().B(null, i3.F0)) {
                                    waVarN = this.f4646a.N();
                                    strS = s();
                                    if (waVarN.f4646a.c().getPackageManager() != null) {
                                        try {
                                            i10 = 0;
                                            try {
                                                applicationInfoB = y1.e.a(waVarN.f4646a.c()).b(strS, 0);
                                                if (applicationInfoB != null) {
                                                    i10 = applicationInfoB.targetSdkVersion;
                                                }
                                            } catch (PackageManager.NameNotFoundException unused3) {
                                                waVarN.f4646a.b();
                                                waVarN.f4646a.d().u().b("PackageManager failed to find running app: app_id", strS);
                                            }
                                        } catch (PackageManager.NameNotFoundException unused4) {
                                            i10 = 0;
                                        }
                                        j12 = i10;
                                    }
                                }
                                return new zzq(strS2, strT, str3, j10, str4, 79000L, j11, str, zO, z10, str5, 0L, jMin, i11, zA, z12, str6, bool, j13, list, (String) null, strI, str7, str2, zBooleanValue, j12);
                            }
                        } catch (Exception unused5) {
                            z10 = z11;
                        }
                    }
                } catch (ClassNotFoundException unused6) {
                    z10 = z11;
                }
            }
            z10 = z11;
        } else {
            z10 = z11;
        }
        h5Var = this.f4646a;
        jA = h5Var.F().f5047e.a();
        if (jA == 0) {
            jMin = h5Var.G;
        } else {
            jMin = Math.min(h5Var.G, jA);
        }
        i();
        int i12 = this.f5091l;
        boolean zA2 = this.f4646a.z().A();
        l4 l4VarF2 = this.f4646a.F();
        l4VarF2.h();
        boolean z13 = l4VarF2.o().getBoolean("deferred_analytics_collection", false);
        i();
        String str8 = this.f5093n;
        boolT = this.f4646a.z().t("google_analytics_default_allow_ad_personalization_signals");
        if (boolT == null) {
            boolValueOf = null;
        } else {
            boolValueOf = Boolean.valueOf(!boolT.booleanValue());
        }
        long j14 = this.f5088i;
        Boolean bool2 = boolValueOf;
        List list2 = this.f5089j;
        String strI2 = this.f4646a.F().q().i();
        if (this.f5090k == null) {
            this.f5090k = this.f4646a.N().q();
        }
        String str9 = this.f5090k;
        ae.b();
        if (this.f4646a.z().B(null, i3.f4942p0)) {
            h();
            if (this.f5095p != 0) {
                long jA3 = this.f4646a.a().a() - this.f5095p;
                if (this.f5094o != null && jA3 > 86400000 && this.f5096q == null) {
                    v();
                }
            }
            if (this.f5094o == null) {
                v();
            }
            str2 = this.f5094o;
        } else {
            str2 = null;
        }
        g gVarZ2 = this.f4646a.z();
        h5 h5Var3 = gVarZ2.f4646a;
        boolT2 = gVarZ2.t("google_analytics_sgtm_upload_enabled");
        if (boolT2 == null) {
            zBooleanValue = false;
        } else {
            zBooleanValue = boolT2.booleanValue();
        }
        ed.b();
        if (this.f4646a.z().B(null, i3.F0)) {
            waVarN = this.f4646a.N();
            strS = s();
            if (waVarN.f4646a.c().getPackageManager() != null) {
                i10 = 0;
                applicationInfoB = y1.e.a(waVarN.f4646a.c()).b(strS, 0);
                if (applicationInfoB != null) {
                    i10 = applicationInfoB.targetSdkVersion;
                }
                j12 = i10;
            }
        }
        return new zzq(strS2, strT, str3, j10, str4, 79000L, j11, str, zO, z10, str5, 0L, jMin, i12, zA2, z13, str8, bool2, j14, list2, (String) null, strI2, str9, str2, zBooleanValue, j12);
    }

    public final String r() {
        i();
        return this.f5093n;
    }

    public final String s() {
        i();
        u1.f.h(this.f5082c);
        return this.f5082c;
    }

    public final String t() {
        h();
        i();
        u1.f.h(this.f5092m);
        return this.f5092m;
    }

    public final List u() {
        return this.f5089j;
    }

    public final void v() {
        String str;
        h();
        if (this.f4646a.F().q().j(zzha.ANALYTICS_STORAGE)) {
            byte[] bArr = new byte[16];
            this.f4646a.N().u().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        } else {
            this.f4646a.d().q().a("Analytics Storage consent is not granted");
            str = null;
        }
        this.f4646a.d().q().a(String.format("Resetting session stitching token to %s", str == null ? "null" : "not null"));
        this.f5094o = str;
        this.f5095p = this.f4646a.a().a();
    }

    public final boolean w(String str) {
        String str2 = this.f5096q;
        boolean z10 = false;
        if (str2 != null && !str2.equals(str)) {
            z10 = true;
        }
        this.f5096q = str;
        return z10;
    }
}
