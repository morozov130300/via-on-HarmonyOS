package e1;

import android.content.Context;
import l1.h0;
import l1.l0;
import m1.n0;
import m1.u0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class e extends u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c7.a f4127c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c7.a f4128e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public c7.a f4129m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public c7.a f4130n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public c7.a f4131o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public c7.a f4132p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public c7.a f4133q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public c7.a f4134r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public c7.a f4135s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public c7.a f4136t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public c7.a f4137u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public c7.a f4138v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public c7.a f4139w;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b implements u.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f4140a;

        public b() {
        }

        @Override // e1.u.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(Context context) {
            this.f4140a = (Context) g1.d.b(context);
            return this;
        }

        @Override // e1.u.a
        public u build() {
            g1.d.a(this.f4140a, Context.class);
            return new e(this.f4140a);
        }
    }

    public static u.a c() {
        return new b();
    }

    @Override // e1.u
    public m1.d a() {
        return (m1.d) this.f4133q.get();
    }

    @Override // e1.u
    public t b() {
        return (t) this.f4139w.get();
    }

    public final void e(Context context) {
        this.f4127c = g1.a.a(k.a());
        g1.b bVarA = g1.c.a(context);
        this.f4128e = bVarA;
        f1.h hVarA = f1.h.a(bVarA, o1.c.a(), o1.d.a());
        this.f4129m = hVarA;
        this.f4130n = g1.a.a(f1.j.a(this.f4128e, hVarA));
        this.f4131o = u0.a(this.f4128e, m1.g.a(), m1.i.a());
        this.f4132p = g1.a.a(m1.h.a(this.f4128e));
        this.f4133q = g1.a.a(n0.a(o1.c.a(), o1.d.a(), m1.j.a(), this.f4131o, this.f4132p));
        k1.g gVarB = k1.g.b(o1.c.a());
        this.f4134r = gVarB;
        k1.i iVarA = k1.i.a(this.f4128e, this.f4133q, gVarB, o1.d.a());
        this.f4135s = iVarA;
        c7.a aVar = this.f4127c;
        c7.a aVar2 = this.f4130n;
        c7.a aVar3 = this.f4133q;
        this.f4136t = k1.d.a(aVar, aVar2, iVarA, aVar3, aVar3);
        c7.a aVar4 = this.f4128e;
        c7.a aVar5 = this.f4130n;
        c7.a aVar6 = this.f4133q;
        this.f4137u = h0.a(aVar4, aVar5, aVar6, this.f4135s, this.f4127c, aVar6, o1.c.a(), o1.d.a(), this.f4133q);
        c7.a aVar7 = this.f4127c;
        c7.a aVar8 = this.f4133q;
        this.f4138v = l0.a(aVar7, aVar8, this.f4135s, aVar8);
        this.f4139w = g1.a.a(v.a(o1.c.a(), o1.d.a(), this.f4136t, this.f4137u, this.f4138v));
    }

    public e(Context context) {
        e(context);
    }
}
