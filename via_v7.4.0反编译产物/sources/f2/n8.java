package f2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class n8 extends n {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ d9 f5531e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n8(d9 d9Var, c6 c6Var) {
        super(c6Var);
        this.f5531e = d9Var;
    }

    @Override // f2.n
    public final void c() {
        d9 d9Var = this.f5531e;
        d9Var.h();
        if (d9Var.z()) {
            d9Var.f5030a.d().v().a("Inactivity, disconnecting from the service");
            d9Var.Q();
        }
    }
}
