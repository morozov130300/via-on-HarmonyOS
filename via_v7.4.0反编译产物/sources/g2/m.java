package g2;

import java.util.concurrent.ExecutionException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class m implements l {

    /* renamed from: a, reason: collision with root package name */
    public final Object f6153a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final int f6154b;

    /* renamed from: c, reason: collision with root package name */
    public final d0 f6155c;

    /* renamed from: d, reason: collision with root package name */
    public int f6156d;

    /* renamed from: e, reason: collision with root package name */
    public int f6157e;

    /* renamed from: f, reason: collision with root package name */
    public int f6158f;

    /* renamed from: g, reason: collision with root package name */
    public Exception f6159g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f6160h;

    public m(int i10, d0 d0Var) {
        this.f6154b = i10;
        this.f6155c = d0Var;
    }

    private final void a() {
        if (this.f6156d + this.f6157e + this.f6158f == this.f6154b) {
            if (this.f6159g == null) {
                if (this.f6160h) {
                    this.f6155c.p();
                    return;
                } else {
                    this.f6155c.o(null);
                    return;
                }
            }
            this.f6155c.n(new ExecutionException(this.f6157e + " out of " + this.f6154b + " underlying tasks failed", this.f6159g));
        }
    }

    @Override // g2.b
    public final void b() {
        synchronized (this.f6153a) {
            this.f6158f++;
            this.f6160h = true;
            a();
        }
    }

    @Override // g2.c
    public final void c(Exception exc) {
        synchronized (this.f6153a) {
            this.f6157e++;
            this.f6159g = exc;
            a();
        }
    }

    @Override // g2.d
    public final void onSuccess(Object obj) {
        synchronized (this.f6153a) {
            this.f6156d++;
            a();
        }
    }
}
