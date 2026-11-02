package q1;

import android.util.Log;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c0 {

    /* renamed from: e, reason: collision with root package name */
    public static final c0 f11239e = new c0(true, 3, 1, null, null);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f11240a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11241b;

    /* renamed from: c, reason: collision with root package name */
    public final Throwable f11242c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11243d;

    public c0(boolean z10, int i10, int i11, String str, Throwable th) {
        this.f11240a = z10;
        this.f11243d = i10;
        this.f11241b = str;
        this.f11242c = th;
    }

    public static c0 b() {
        return f11239e;
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
        return this.f11241b;
    }

    public final void e() {
        if (this.f11240a || !Log.isLoggable("GoogleCertificatesRslt", 3)) {
            return;
        }
        if (this.f11242c != null) {
            Log.d("GoogleCertificatesRslt", a(), this.f11242c);
        } else {
            Log.d("GoogleCertificatesRslt", a());
        }
    }
}
