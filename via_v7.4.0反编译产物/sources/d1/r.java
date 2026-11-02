package d1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class r implements a1.e {

    /* renamed from: a, reason: collision with root package name */
    public final p f4518a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4519b;

    /* renamed from: c, reason: collision with root package name */
    public final a1.b f4520c;

    /* renamed from: d, reason: collision with root package name */
    public final a1.d f4521d;

    /* renamed from: e, reason: collision with root package name */
    public final s f4522e;

    public r(p pVar, String str, a1.b bVar, a1.d dVar, s sVar) {
        this.f4518a = pVar;
        this.f4519b = str;
        this.f4520c = bVar;
        this.f4521d = dVar;
        this.f4522e = sVar;
    }

    @Override // a1.e
    public void a(a1.c cVar, a1.g gVar) {
        this.f4522e.a(o.a().e(this.f4518a).c(cVar).f(this.f4519b).d(this.f4521d).b(this.f4520c).a(), gVar);
    }

    public p b() {
        return this.f4518a;
    }
}
