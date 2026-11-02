package d1;

import android.content.Context;
import d1.u;
import k1.h0;
import k1.l0;
import l1.n0;
import l1.u0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class e extends u {

    /* renamed from: e, reason: collision with root package name */
    public i7.a f4495e;

    /* renamed from: j, reason: collision with root package name */
    public i7.a f4496j;

    /* renamed from: k, reason: collision with root package name */
    public i7.a f4497k;

    /* renamed from: l, reason: collision with root package name */
    public i7.a f4498l;

    /* renamed from: m, reason: collision with root package name */
    public i7.a f4499m;

    /* renamed from: n, reason: collision with root package name */
    public i7.a f4500n;

    /* renamed from: o, reason: collision with root package name */
    public i7.a f4501o;

    /* renamed from: p, reason: collision with root package name */
    public i7.a f4502p;

    /* renamed from: q, reason: collision with root package name */
    public i7.a f4503q;

    /* renamed from: r, reason: collision with root package name */
    public i7.a f4504r;

    /* renamed from: s, reason: collision with root package name */
    public i7.a f4505s;

    /* renamed from: t, reason: collision with root package name */
    public i7.a f4506t;

    /* renamed from: u, reason: collision with root package name */
    public i7.a f4507u;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b implements u.a {

        /* renamed from: a, reason: collision with root package name */
        public Context f4508a;

        public b() {
        }

        @Override // d1.u.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(Context context) {
            this.f4508a = (Context) f1.d.b(context);
            return this;
        }

        @Override // d1.u.a
        public u build() {
            f1.d.a(this.f4508a, Context.class);
            return new e(this.f4508a);
        }
    }

    public e(Context context) {
        f(context);
    }

    public static u.a d() {
        return new b();
    }

    @Override // d1.u
    public l1.d a() {
        return (l1.d) this.f4501o.get();
    }

    @Override // d1.u
    public t b() {
        return (t) this.f4507u.get();
    }

    public final void f(Context context) {
        this.f4495e = f1.a.a(k.a());
        f1.b bVarA = f1.c.a(context);
        this.f4496j = bVarA;
        e1.h hVarA = e1.h.a(bVarA, n1.c.a(), n1.d.a());
        this.f4497k = hVarA;
        this.f4498l = f1.a.a(e1.j.a(this.f4496j, hVarA));
        this.f4499m = u0.a(this.f4496j, l1.g.a(), l1.i.a());
        this.f4500n = f1.a.a(l1.h.a(this.f4496j));
        this.f4501o = f1.a.a(n0.a(n1.c.a(), n1.d.a(), l1.j.a(), this.f4499m, this.f4500n));
        j1.g gVarB = j1.g.b(n1.c.a());
        this.f4502p = gVarB;
        j1.i iVarA = j1.i.a(this.f4496j, this.f4501o, gVarB, n1.d.a());
        this.f4503q = iVarA;
        i7.a aVar = this.f4495e;
        i7.a aVar2 = this.f4498l;
        i7.a aVar3 = this.f4501o;
        this.f4504r = j1.d.a(aVar, aVar2, iVarA, aVar3, aVar3);
        i7.a aVar4 = this.f4496j;
        i7.a aVar5 = this.f4498l;
        i7.a aVar6 = this.f4501o;
        this.f4505s = h0.a(aVar4, aVar5, aVar6, this.f4503q, this.f4495e, aVar6, n1.c.a(), n1.d.a(), this.f4501o);
        i7.a aVar7 = this.f4495e;
        i7.a aVar8 = this.f4501o;
        this.f4506t = l0.a(aVar7, aVar8, this.f4503q, aVar8);
        this.f4507u = f1.a.a(v.a(n1.c.a(), n1.d.a(), this.f4504r, this.f4505s, this.f4506t));
    }
}
