package p2;

import android.util.Log;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class f {

    /* renamed from: c, reason: collision with root package name */
    public static final f f10950c = new f("FirebaseCrashlytics");

    /* renamed from: a, reason: collision with root package name */
    public final String f10951a;

    /* renamed from: b, reason: collision with root package name */
    public int f10952b = 4;

    public f(String str) {
        this.f10951a = str;
    }

    public static f f() {
        return f10950c;
    }

    public final boolean a(int i10) {
        return this.f10952b <= i10 || Log.isLoggable(this.f10951a, i10);
    }

    public void b(String str) {
        c(str, null);
    }

    public void c(String str, Throwable th) {
        if (a(3)) {
            Log.d(this.f10951a, str, th);
        }
    }

    public void d(String str) {
        e(str, null);
    }

    public void e(String str, Throwable th) {
        if (a(6)) {
            Log.e(this.f10951a, str, th);
        }
    }

    public void g(String str) {
        h(str, null);
    }

    public void h(String str, Throwable th) {
        if (a(4)) {
            Log.i(this.f10951a, str, th);
        }
    }

    public void i(String str) {
        j(str, null);
    }

    public void j(String str, Throwable th) {
        if (a(2)) {
            Log.v(this.f10951a, str, th);
        }
    }

    public void k(String str) {
        l(str, null);
    }

    public void l(String str, Throwable th) {
        if (a(5)) {
            Log.w(this.f10951a, str, th);
        }
    }
}
