package f2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class ba extends aa {

    /* renamed from: c, reason: collision with root package name */
    public boolean f5061c;

    public ba(pa paVar) {
        super(paVar);
        this.f5039b.r();
    }

    public final void i() {
        if (!k()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void j() {
        if (this.f5061c) {
            throw new IllegalStateException("Can't initialize twice");
        }
        l();
        this.f5039b.m();
        this.f5061c = true;
    }

    public final boolean k() {
        return this.f5061c;
    }

    public abstract boolean l();
}
