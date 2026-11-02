package f2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class b6 extends a6 {

    /* renamed from: b, reason: collision with root package name */
    public boolean f5054b;

    public b6(h5 h5Var) {
        super(h5Var);
        this.f5030a.i();
    }

    public void i() {
    }

    public abstract boolean j();

    public final void k() {
        if (!n()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void l() {
        if (this.f5054b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (j()) {
            return;
        }
        this.f5030a.g();
        this.f5054b = true;
    }

    public final void m() {
        if (this.f5054b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        i();
        this.f5030a.g();
        this.f5054b = true;
    }

    public final boolean n() {
        return this.f5054b;
    }
}
