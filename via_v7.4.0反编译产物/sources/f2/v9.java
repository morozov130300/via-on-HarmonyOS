package f2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class v9 {

    /* renamed from: a, reason: collision with root package name */
    public final w1.c f5776a;

    /* renamed from: b, reason: collision with root package name */
    public long f5777b;

    public v9(w1.c cVar) {
        t1.f.h(cVar);
        this.f5776a = cVar;
    }

    public final void a() {
        this.f5777b = 0L;
    }

    public final void b() {
        this.f5777b = this.f5776a.b();
    }

    public final boolean c(long j10) {
        return this.f5777b == 0 || this.f5776a.b() - this.f5777b >= 3600000;
    }
}
