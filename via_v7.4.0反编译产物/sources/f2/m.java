package f2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class m implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ c6 f5461e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ n f5462j;

    public m(n nVar, c6 c6Var) {
        this.f5462j = nVar;
        this.f5461e = c6Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5461e.b();
        if (c.a()) {
            this.f5461e.f().z(this);
            return;
        }
        boolean zE = this.f5462j.e();
        this.f5462j.f5516c = 0L;
        if (zE) {
            this.f5462j.c();
        }
    }
}
