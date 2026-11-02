package autodispose2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class f extends x6.j implements n {

    /* renamed from: e, reason: collision with root package name */
    public final x6.l f1751e;

    /* renamed from: j, reason: collision with root package name */
    public final x6.c f1752j;

    public f(x6.l lVar, x6.c cVar) {
        this.f1751e = lVar;
        this.f1752j = cVar;
    }

    @Override // x6.j
    public void C(x6.m mVar) {
        this.f1751e.b(new AutoDisposingObserverImpl(this.f1752j, mVar));
    }
}
