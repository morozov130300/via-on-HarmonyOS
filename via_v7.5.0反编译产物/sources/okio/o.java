package okio;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static n f11479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f11480b;

    public static void a(n nVar) {
        if (nVar.f11477f != null || nVar.f11478g != null) {
            throw new IllegalArgumentException();
        }
        if (nVar.f11475d) {
            return;
        }
        synchronized (o.class) {
            try {
                long j10 = f11480b;
                if (j10 + 8192 > 65536) {
                    return;
                }
                f11480b = j10 + 8192;
                nVar.f11477f = f11479a;
                nVar.f11474c = 0;
                nVar.f11473b = 0;
                f11479a = nVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static n b() {
        synchronized (o.class) {
            try {
                n nVar = f11479a;
                if (nVar == null) {
                    return new n();
                }
                f11479a = nVar.f11477f;
                nVar.f11477f = null;
                f11480b -= 8192;
                return nVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
