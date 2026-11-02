package f2;

import android.os.Handler;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: d, reason: collision with root package name */
    public static volatile Handler f5513d;

    /* renamed from: a, reason: collision with root package name */
    public final c6 f5514a;

    /* renamed from: b, reason: collision with root package name */
    public final Runnable f5515b;

    /* renamed from: c, reason: collision with root package name */
    public volatile long f5516c;

    public n(c6 c6Var) {
        t1.f.h(c6Var);
        this.f5514a = c6Var;
        this.f5515b = new m(this, c6Var);
    }

    public final void b() {
        this.f5516c = 0L;
        f().removeCallbacks(this.f5515b);
    }

    public abstract void c();

    public final void d(long j10) {
        b();
        if (j10 >= 0) {
            this.f5516c = this.f5514a.a().a();
            if (f().postDelayed(this.f5515b, j10)) {
                return;
            }
            this.f5514a.d().r().b("Failed to schedule delayed post. time", Long.valueOf(j10));
        }
    }

    public final boolean e() {
        return this.f5516c != 0;
    }

    public final Handler f() {
        Handler handler;
        if (f5513d != null) {
            return f5513d;
        }
        synchronized (n.class) {
            try {
                if (f5513d == null) {
                    f5513d = new com.google.android.gms.internal.measurement.c1(this.f5514a.c().getMainLooper());
                }
                handler = f5513d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }
}
