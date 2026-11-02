package f2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class z8 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ l3 f5877e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ c9 f5878j;

    public z8(c9 c9Var, l3 l3Var) {
        this.f5878j = c9Var;
        this.f5877e = l3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f5878j) {
            try {
                this.f5878j.f5073a = false;
                if (!this.f5878j.f5075c.z()) {
                    this.f5878j.f5075c.f5030a.d().q().a("Connected to remote service");
                    this.f5878j.f5075c.x(this.f5877e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
