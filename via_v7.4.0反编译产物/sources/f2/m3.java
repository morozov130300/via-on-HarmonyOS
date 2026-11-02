package f2;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzha;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class m3 extends c4 {

    /* renamed from: c, reason: collision with root package name */
    public String f5466c;

    /* renamed from: d, reason: collision with root package name */
    public String f5467d;

    /* renamed from: e, reason: collision with root package name */
    public int f5468e;

    /* renamed from: f, reason: collision with root package name */
    public String f5469f;

    /* renamed from: g, reason: collision with root package name */
    public String f5470g;

    /* renamed from: h, reason: collision with root package name */
    public long f5471h;

    /* renamed from: i, reason: collision with root package name */
    public final long f5472i;

    /* renamed from: j, reason: collision with root package name */
    public List f5473j;

    /* renamed from: k, reason: collision with root package name */
    public String f5474k;

    /* renamed from: l, reason: collision with root package name */
    public int f5475l;

    /* renamed from: m, reason: collision with root package name */
    public String f5476m;

    /* renamed from: n, reason: collision with root package name */
    public String f5477n;

    /* renamed from: o, reason: collision with root package name */
    public String f5478o;

    /* renamed from: p, reason: collision with root package name */
    public long f5479p;

    /* renamed from: q, reason: collision with root package name */
    public String f5480q;

    public m3(h5 h5Var, long j10) {
        super(h5Var);
        this.f5479p = 0L;
        this.f5480q = null;
        this.f5472i = j10;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:0|2|(1:4)(21:89|6|(1:10)(2:11|(1:13))|85|14|(4:16|(1:18)(1:20)|87|21)|26|(1:31)(1:30)|32|33|43|(1:45)|91|46|(1:48)(1:49)|50|(3:52|(1:54)(1:55)|56)|(3:60|(1:62)(1:63)|64)|67|(2:70|(1:72)(4:73|(3:76|(1:94)(1:95)|74)|93|79))(1:79)|(2:81|82)(2:83|84))|5|26|(2:28|31)(0)|32|33|43|(0)|91|46|(0)(0)|50|(0)|(0)|67|(0)(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01bb, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01de, code lost:
    
        r11.f5030a.d().r().c("Fetching Google App Id failed with exception. appId", f2.v3.z(r0), r2);
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0194 A[Catch: IllegalStateException -> 0x01bb, TryCatch #3 {IllegalStateException -> 0x01bb, blocks: (B:46:0x0172, B:50:0x018c, B:52:0x0194, B:56:0x01b2, B:55:0x01ae, B:60:0x01bf, B:62:0x01d5, B:64:0x01da, B:63:0x01d8), top: B:91:0x0172 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01bf A[Catch: IllegalStateException -> 0x01bb, TryCatch #3 {IllegalStateException -> 0x01bb, blocks: (B:46:0x0172, B:50:0x018c, B:52:0x0194, B:56:0x01b2, B:55:0x01ae, B:60:0x01bf, B:62:0x01d5, B:64:0x01da, B:63:0x01d8), top: B:91:0x0172 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x024e  */
    @Override // f2.c4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l() throws Resources.NotFoundException, PackageManager.NameNotFoundException {
        String str;
        String string;
        boolean z10;
        int iX;
        List listY;
        String strB;
        String packageName = this.f5030a.c().getPackageName();
        PackageManager packageManager = this.f5030a.c().getPackageManager();
        int i10 = Integer.MIN_VALUE;
        String str2 = "";
        String str3 = "Unknown";
        String installerPackageName = "unknown";
        if (packageManager != null) {
            try {
                installerPackageName = packageManager.getInstallerPackageName(packageName);
            } catch (IllegalArgumentException unused) {
                this.f5030a.d().r().b("Error retrieving app installer package name. appId", v3.z(packageName));
            }
            if (installerPackageName == null) {
                installerPackageName = "manual_install";
            } else if ("com.android.vending".equals(installerPackageName)) {
                installerPackageName = "";
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(this.f5030a.c().getPackageName(), 0);
                if (packageInfo != null) {
                    CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                    string = !TextUtils.isEmpty(applicationLabel) ? applicationLabel.toString() : "Unknown";
                    try {
                        str3 = packageInfo.versionName;
                        i10 = packageInfo.versionCode;
                    } catch (PackageManager.NameNotFoundException unused2) {
                        str = str3;
                        str3 = string;
                        this.f5030a.d().r().c("Error retrieving package info. appId, appName", v3.z(packageName), str3);
                        string = str3;
                        str3 = str;
                        this.f5466c = packageName;
                        this.f5469f = installerPackageName;
                        this.f5467d = str3;
                        this.f5468e = i10;
                        this.f5470g = string;
                        this.f5471h = 0L;
                        if (TextUtils.isEmpty(this.f5030a.O())) {
                        }
                        iX = this.f5030a.x();
                        switch (iX) {
                        }
                        this.f5476m = "";
                        this.f5477n = "";
                        this.f5030a.b();
                        if (z10) {
                        }
                        strB = u7.b(this.f5030a.c(), "google_app_id", this.f5030a.R());
                        if (!TextUtils.isEmpty(strB)) {
                        }
                        this.f5476m = str2;
                        if (!TextUtils.isEmpty(strB)) {
                        }
                        if (iX == 0) {
                        }
                        this.f5473j = null;
                        this.f5030a.b();
                        listY = this.f5030a.z().y("analytics.safelisted_events");
                        if (listY == null) {
                        }
                        if (packageManager != null) {
                        }
                    }
                }
            } catch (PackageManager.NameNotFoundException unused3) {
                str = "Unknown";
            }
            this.f5466c = packageName;
            this.f5469f = installerPackageName;
            this.f5467d = str3;
            this.f5468e = i10;
            this.f5470g = string;
            this.f5471h = 0L;
            z10 = !TextUtils.isEmpty(this.f5030a.O()) && "am".equals(this.f5030a.P());
            iX = this.f5030a.x();
            switch (iX) {
                case 0:
                    this.f5030a.d().v().a("App measurement collection enabled");
                    break;
                case 1:
                    this.f5030a.d().u().a("App measurement deactivated via the manifest");
                    break;
                case 2:
                    this.f5030a.d().v().a("App measurement deactivated via the init parameters");
                    break;
                case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                    this.f5030a.d().u().a("App measurement disabled by setAnalyticsCollectionEnabled(false)");
                    break;
                case 4:
                    this.f5030a.d().u().a("App measurement disabled via the manifest");
                    break;
                case 5:
                    this.f5030a.d().v().a("App measurement disabled via the init parameters");
                    break;
                case 6:
                    this.f5030a.d().x().a("App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics");
                    break;
                case 7:
                    this.f5030a.d().u().a("App measurement disabled via the global data collection setting");
                    break;
                default:
                    this.f5030a.d().u().a("App measurement disabled due to denied storage consent");
                    break;
            }
            this.f5476m = "";
            this.f5477n = "";
            this.f5030a.b();
            if (z10) {
                this.f5477n = this.f5030a.O();
            }
            strB = u7.b(this.f5030a.c(), "google_app_id", this.f5030a.R());
            if (!TextUtils.isEmpty(strB)) {
                str2 = strB;
            }
            this.f5476m = str2;
            if (!TextUtils.isEmpty(strB)) {
                Context contextC = this.f5030a.c();
                String strR = this.f5030a.R();
                t1.f.h(contextC);
                Resources resources = contextC.getResources();
                if (TextUtils.isEmpty(strR)) {
                    strR = z4.a(contextC);
                }
                this.f5477n = z4.b("admob_app_id", resources, strR);
            }
            if (iX == 0) {
                this.f5030a.d().v().c("App measurement enabled for app package, google app id", this.f5466c, TextUtils.isEmpty(this.f5476m) ? this.f5477n : this.f5476m);
            }
            this.f5473j = null;
            this.f5030a.b();
            listY = this.f5030a.z().y("analytics.safelisted_events");
            if (listY == null) {
                this.f5473j = listY;
            } else if (listY.isEmpty()) {
                this.f5030a.d().x().a("Safelisted event list is empty. Ignoring");
            } else {
                Iterator it = listY.iterator();
                while (it.hasNext()) {
                    if (!this.f5030a.N().R("safelisted event", (String) it.next())) {
                    }
                }
                this.f5473j = listY;
            }
            if (packageManager != null) {
                this.f5475l = x1.b.a(this.f5030a.c()) ? 1 : 0;
                return;
            } else {
                this.f5475l = 0;
                return;
            }
        }
        this.f5030a.d().r().b("PackageManager is null, app identity information might be inaccurate. appId", v3.z(packageName));
        string = "Unknown";
        this.f5466c = packageName;
        this.f5469f = installerPackageName;
        this.f5467d = str3;
        this.f5468e = i10;
        this.f5470g = string;
        this.f5471h = 0L;
        if (TextUtils.isEmpty(this.f5030a.O())) {
        }
        iX = this.f5030a.x();
        switch (iX) {
        }
        this.f5476m = "";
        this.f5477n = "";
        this.f5030a.b();
        if (z10) {
        }
        strB = u7.b(this.f5030a.c(), "google_app_id", this.f5030a.R());
        if (!TextUtils.isEmpty(strB)) {
        }
        this.f5476m = str2;
        if (!TextUtils.isEmpty(strB)) {
        }
        if (iX == 0) {
        }
        this.f5473j = null;
        this.f5030a.b();
        listY = this.f5030a.z().y("analytics.safelisted_events");
        if (listY == null) {
        }
        if (packageManager != null) {
        }
    }

    @Override // f2.c4
    public final boolean n() {
        return true;
    }

    public final int o() {
        i();
        return this.f5475l;
    }

    public final int p() {
        i();
        return this.f5468e;
    }

    /*  JADX ERROR: NullPointerException in pass: ConstructorVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(jadx.core.dex.instructions.args.InsnArg)" because "resultArg" is null
        	at jadx.core.dex.visitors.MoveInlineVisitor.processMove(MoveInlineVisitor.java:52)
        	at jadx.core.dex.visitors.MoveInlineVisitor.moveInline(MoveInlineVisitor.java:41)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:43)
        */
    public final com.google.android.gms.measurement.internal.zzq q(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r37v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:405)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:297)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:286)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:270)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:161)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:103)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:79)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:117)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:403)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:391)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:341)
        */
    /*  JADX ERROR: NullPointerException in pass: ConstructorVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(jadx.core.dex.instructions.args.InsnArg)" because "resultArg" is null
        	at jadx.core.dex.visitors.MoveInlineVisitor.processMove(MoveInlineVisitor.java:52)
        	at jadx.core.dex.visitors.MoveInlineVisitor.moveInline(MoveInlineVisitor.java:41)
        */

    public final String r() {
        i();
        return this.f5477n;
    }

    public final String s() {
        i();
        t1.f.h(this.f5466c);
        return this.f5466c;
    }

    public final String t() {
        h();
        i();
        t1.f.h(this.f5476m);
        return this.f5476m;
    }

    public final List u() {
        return this.f5473j;
    }

    public final void v() {
        String str;
        h();
        if (this.f5030a.F().q().j(zzha.ANALYTICS_STORAGE)) {
            byte[] bArr = new byte[16];
            this.f5030a.N().u().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        } else {
            this.f5030a.d().q().a("Analytics Storage consent is not granted");
            str = null;
        }
        this.f5030a.d().q().a(String.format("Resetting session stitching token to %s", str == null ? "null" : "not null"));
        this.f5478o = str;
        this.f5479p = this.f5030a.a().a();
    }

    public final boolean w(String str) {
        String str2 = this.f5480q;
        boolean z10 = false;
        if (str2 != null && !str2.equals(str)) {
            z10 = true;
        }
        this.f5480q = str;
        return z10;
    }
}
