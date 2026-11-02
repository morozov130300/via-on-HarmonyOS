package e5;

import android.content.Context;
import android.os.Build;
import k5.o;
import k5.p;
import k5.u;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c implements a {

    /* renamed from: e, reason: collision with root package name */
    public static volatile c f4766e;

    /* renamed from: a, reason: collision with root package name */
    public f5.c f4767a;

    /* renamed from: b, reason: collision with root package name */
    public h5.c f4768b;

    /* renamed from: c, reason: collision with root package name */
    public o f4769c;

    /* renamed from: d, reason: collision with root package name */
    public p f4770d;

    public static c f() {
        if (f4766e == null) {
            synchronized (c.class) {
                try {
                    if (f4766e == null) {
                        f4766e = new c();
                    }
                } finally {
                }
            }
        }
        return f4766e;
    }

    @Override // e5.a
    public f5.c a() {
        if (this.f4767a == null) {
            h();
        }
        return this.f4767a;
    }

    @Override // e5.a
    public o b() {
        if (this.f4769c == null) {
            h();
        }
        return this.f4769c;
    }

    @Override // e5.a
    public h5.c c() {
        if (this.f4768b == null) {
            synchronized (c.class) {
                try {
                    if (this.f4768b == null) {
                        this.f4768b = new h5.a(e(), this.f4767a);
                    }
                } finally {
                }
            }
        }
        return this.f4768b;
    }

    @Override // e5.a
    public p d() {
        if (this.f4770d == null) {
            h();
        }
        return this.f4770d;
    }

    @Override // e5.a
    public g e() {
        return b.b().a();
    }

    public void g(Context context) {
        this.f4767a = new f5.a(new f5.d(context));
        if (Build.VERSION.SDK_INT >= 21) {
            this.f4769c = new u(context);
        } else {
            this.f4769c = new k5.a();
        }
        this.f4770d = new k5.b(context);
    }

    public final void h() {
        throw new NullPointerException("You have to call ComponmentHolder::init");
    }
}
