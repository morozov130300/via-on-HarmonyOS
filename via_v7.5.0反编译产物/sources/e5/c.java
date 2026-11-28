package e5;

import android.content.Context;
import android.os.Build;
import k5.o;
import k5.p;
import k5.u;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c implements a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile c f4212e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f5.c f4213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h5.c f4214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public o f4215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p f4216d;

    public static c f() {
        if (f4212e == null) {
            synchronized (c.class) {
                try {
                    if (f4212e == null) {
                        f4212e = new c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f4212e;
    }

    @Override // e5.a
    public f5.c a() {
        if (this.f4213a == null) {
            h();
        }
        return this.f4213a;
    }

    @Override // e5.a
    public o b() {
        if (this.f4215c == null) {
            h();
        }
        return this.f4215c;
    }

    @Override // e5.a
    public h5.c c() {
        if (this.f4214b == null) {
            synchronized (c.class) {
                try {
                    if (this.f4214b == null) {
                        this.f4214b = new h5.a(e(), this.f4213a);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f4214b;
    }

    @Override // e5.a
    public p d() {
        if (this.f4216d == null) {
            h();
        }
        return this.f4216d;
    }

    @Override // e5.a
    public g e() {
        return b.b().a();
    }

    public void g(Context context) {
        this.f4213a = new f5.a(new f5.d(context));
        if (Build.VERSION.SDK_INT >= 21) {
            this.f4215c = new u(context);
        } else {
            this.f4215c = new k5.a();
        }
        this.f4216d = new k5.b(context);
    }

    public final void h() {
        throw new NullPointerException("You have to call ComponmentHolder::init");
    }
}
