package g2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class o4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h5 f5160a;

    public o4(pa paVar) {
        this.f5160a = paVar.b0();
    }

    public final boolean a() {
        try {
            y1.d dVarA = y1.e.a(this.f5160a.c());
            if (dVarA != null) {
                return dVarA.c("com.android.vending", 128).versionCode >= 80837300;
            }
            this.f5160a.d().v().a("Failed to get PackageManager for Install Referrer Play Store compatibility check");
            return false;
        } catch (Exception e10) {
            this.f5160a.d().v().b("Failed to retrieve Play Store version for Install Referrer", e10);
            return false;
        }
    }
}
