package f2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class l7 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f5456e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ o7 f5457j;

    public l7(o7 o7Var, boolean z10) {
        this.f5457j = o7Var;
        this.f5456e = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zO = this.f5457j.f5030a.o();
        boolean zN = this.f5457j.f5030a.n();
        this.f5457j.f5030a.k(this.f5456e);
        if (zN == this.f5456e) {
            this.f5457j.f5030a.d().v().b("Default data collection state already set to", Boolean.valueOf(this.f5456e));
        }
        if (this.f5457j.f5030a.o() == zO || this.f5457j.f5030a.o() != this.f5457j.f5030a.n()) {
            this.f5457j.f5030a.d().x().c("Default data collection is different than actual status", Boolean.valueOf(this.f5456e), Boolean.valueOf(zO));
        }
        this.f5457j.P();
    }
}
