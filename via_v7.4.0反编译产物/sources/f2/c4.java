package f2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class c4 extends b3 {

    /* renamed from: b, reason: collision with root package name */
    public boolean f5066b;

    public c4(h5 h5Var) {
        super(h5Var);
        this.f5030a.i();
    }

    public final void i() {
        if (!m()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void j() {
        if (this.f5066b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (n()) {
            return;
        }
        this.f5030a.g();
        this.f5066b = true;
    }

    public final void k() {
        if (this.f5066b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        l();
        this.f5030a.g();
        this.f5066b = true;
    }

    public void l() {
    }

    public final boolean m() {
        return this.f5066b;
    }

    public abstract boolean n();
}
