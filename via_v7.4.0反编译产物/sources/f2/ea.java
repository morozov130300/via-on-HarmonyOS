package f2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class ea implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ qa f5158e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ pa f5159j;

    public ea(pa paVar, qa qaVar) {
        this.f5159j = paVar;
        this.f5158e = qaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        pa.k0(this.f5159j, this.f5158e);
        this.f5159j.x();
    }
}
