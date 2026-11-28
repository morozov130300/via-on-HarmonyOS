package h2;

import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class m implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5650a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d0 f5652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f5655f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Exception f5656g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5657h;

    public m(int i10, d0 d0Var) {
        this.f5651b = i10;
        this.f5652c = d0Var;
    }

    private final void a() {
        if (this.f5653d + this.f5654e + this.f5655f == this.f5651b) {
            if (this.f5656g == null) {
                if (this.f5657h) {
                    this.f5652c.p();
                    return;
                } else {
                    this.f5652c.o(null);
                    return;
                }
            }
            this.f5652c.n(new ExecutionException(this.f5654e + " out of " + this.f5651b + " underlying tasks failed", this.f5656g));
        }
    }

    @Override // h2.b
    public final void b() {
        synchronized (this.f5650a) {
            this.f5655f++;
            this.f5657h = true;
            a();
        }
    }

    @Override // h2.c
    public final void c(Exception exc) {
        synchronized (this.f5650a) {
            this.f5654e++;
            this.f5656g = exc;
            a();
        }
    }

    @Override // h2.d
    public final void onSuccess(Object obj) {
        synchronized (this.f5650a) {
            this.f5653d++;
            a();
        }
    }
}
