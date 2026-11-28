package r1;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c0 f11929e = new c0(true, 3, 1, null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f11930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f11932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f11933d;

    public c0(boolean z10, int i10, int i11, String str, Throwable th) {
        this.f11930a = z10;
        this.f11933d = i10;
        this.f11931b = str;
        this.f11932c = th;
    }

    public static c0 b() {
        return f11929e;
    }

    public static c0 c(String str) {
        return new c0(false, 1, 5, str, null);
    }

    public static c0 d(String str, Throwable th) {
        return new c0(false, 1, 5, str, th);
    }

    public static c0 f(int i10) {
        return new c0(true, i10, 1, null, null);
    }

    public static c0 g(int i10, int i11, String str, Throwable th) {
        return new c0(false, i10, i11, str, th);
    }

    public String a() {
        return this.f11931b;
    }

    public final void e() {
        if (this.f11930a || !Log.isLoggable("GoogleCertificatesRslt", 3)) {
            return;
        }
        if (this.f11932c != null) {
            Log.d("GoogleCertificatesRslt", a(), this.f11932c);
        } else {
            Log.d("GoogleCertificatesRslt", a());
        }
    }
}
