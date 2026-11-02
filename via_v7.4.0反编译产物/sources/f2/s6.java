package f2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class s6 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f5676e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ o7 f5677j;

    public s6(o7 o7Var, long j10) {
        this.f5677j = o7Var;
        this.f5676e = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5677j.f5030a.F().f5437k.b(this.f5676e);
        this.f5677j.f5030a.d().q().b("Session timeout duration set", Long.valueOf(this.f5676e));
    }
}
