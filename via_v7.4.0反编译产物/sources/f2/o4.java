package f2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class o4 {

    /* renamed from: a, reason: collision with root package name */
    public final h5 f5544a;

    public o4(pa paVar) {
        this.f5544a = paVar.b0();
    }

    public final boolean a() {
        try {
            x1.d dVarA = x1.e.a(this.f5544a.c());
            if (dVarA != null) {
                return dVarA.c("com.android.vending", 128).versionCode >= 80837300;
            }
            this.f5544a.d().v().a("Failed to get PackageManager for Install Referrer Play Store compatibility check");
            return false;
        } catch (Exception e10) {
            this.f5544a.d().v().b("Failed to retrieve Play Store version for Install Referrer", e10);
            return false;
        }
    }
}
