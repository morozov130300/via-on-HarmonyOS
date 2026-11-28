package g2;

import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile Handler f5129d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c6 f5130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Runnable f5131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile long f5132c;

    public n(c6 c6Var) {
        u1.f.h(c6Var);
        this.f5130a = c6Var;
        this.f5131b = new m(this, c6Var);
    }

    public final void b() {
        this.f5132c = 0L;
        f().removeCallbacks(this.f5131b);
    }

    public abstract void c();

    public final void d(long j10) {
        b();
        if (j10 >= 0) {
            this.f5132c = this.f5130a.a().a();
            if (f().postDelayed(this.f5131b, j10)) {
                return;
            }
            this.f5130a.d().r().b("Failed to schedule delayed post. time", Long.valueOf(j10));
        }
    }

    public final boolean e() {
        return this.f5132c != 0;
    }

    public final Handler f() {
        Handler handler;
        if (f5129d != null) {
            return f5129d;
        }
        synchronized (n.class) {
            try {
                if (f5129d == null) {
                    f5129d = new com.google.android.gms.internal.measurement.c1(this.f5130a.c().getMainLooper());
                }
                handler = f5129d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }
}
