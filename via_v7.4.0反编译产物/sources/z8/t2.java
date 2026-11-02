package z8;

import android.R;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import c8.lc;
import java.util.concurrent.Callable;
import w5.k;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class t2 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f14757a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.lifecycle.h f14758b;

    /* renamed from: c, reason: collision with root package name */
    public final n5.b f14759c = lc.c();

    public t2(Fragment fragment) {
        this.f14757a = fragment.A0();
        this.f14758b = fragment.d1();
    }

    public static /* synthetic */ void b(t2 t2Var, w.d dVar) {
        t2Var.getClass();
        t2Var.q((r5.a) dVar.f13207a, (r5.c) dVar.f13208b);
    }

    public static /* synthetic */ w.d c(t2 t2Var, String str) {
        t2Var.getClass();
        r5.a aVarE = ia.d.e(str);
        if (aVarE == null) {
            return null;
        }
        return new w.d(aVarE, t2Var.f14759c.d().i(aVarE.e(), aVarE.d().b()));
    }

    public static /* synthetic */ void d(final t2 t2Var, final String str) {
        t2Var.getClass();
        ((autodispose2.m) x6.f.h(new Callable() { // from class: z8.n2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return t2.c(this.f14728e, str);
            }
        }).n(g7.a.c()).k(w6.b.b()).p(u8.b.a(t2Var.f14758b))).a(new a7.e() { // from class: z8.o2
            @Override // a7.e
            public final void accept(Object obj) {
                t2.b(this.f14730e, (w.d) obj);
            }
        }, new x7.g0());
    }

    public static /* synthetic */ void e(t2 t2Var, x5.a aVar) {
        t2Var.getClass();
        w.d dVar = (w.d) aVar.c();
        if (dVar == null) {
            g6.n.q(t2Var.f14757a, x7.u.tg);
        } else {
            t2Var.q((r5.a) dVar.f13207a, (r5.c) dVar.f13208b);
        }
    }

    public static /* synthetic */ void f(t2 t2Var, r5.a aVar, boolean z10, r5.c cVar, View view, k.p pVar) {
        int iE;
        if (z10) {
            t2Var.getClass();
            iE = cVar.e();
        } else {
            iE = 0;
        }
        t2Var.l(aVar, iE);
    }

    public static /* synthetic */ void h(final t2 t2Var, String str, final String str2, Boolean bool) {
        t2Var.getClass();
        if (bool.booleanValue()) {
            return;
        }
        Context context = t2Var.f14757a;
        g6.n.t(context, context.getString(x7.u.sg, str), t2Var.f14757a.getString(x7.u.Jh), new View.OnClickListener() { // from class: z8.j2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g6.i.h(g6.i.b(this.f14710a.f14757a), ta.u.class, ta.u.F3(str2, true));
            }
        });
    }

    public static /* synthetic */ x5.a i(t2 t2Var, String str) {
        t2Var.getClass();
        r5.a aVarF = r5.a.f(s5.b.d(str), str);
        return aVarF == null ? x5.a.f(null) : x5.a.e(new w.d(aVarF, t2Var.f14759c.d().i(aVarF.e(), aVarF.d().b())));
    }

    public static /* synthetic */ void j(t2 t2Var, String str, String str2, Boolean bool) {
        t2Var.getClass();
        if (!bool.booleanValue()) {
            Context context = t2Var.f14757a;
            g6.n.s(context, context.getString(x7.u.ug, str));
        } else {
            Context context2 = t2Var.f14757a;
            g6.n.s(context2, context2.getString(x7.u.vg, str));
            t2Var.m(str2, str);
        }
    }

    public static /* synthetic */ Boolean k(t2 t2Var, int i10, r5.a aVar) {
        p5.c cVarD = t2Var.f14759c.d();
        return Boolean.valueOf(i10 > 0 ? cVarD.p(i10, aVar) : cVarD.h(aVar) > 0);
    }

    public static w5.k n(Context context, r5.a aVar, r5.c cVar) {
        String string;
        if (aVar == null) {
            g6.n.q(context, x7.u.Ib);
            return null;
        }
        String strI = cVar != null ? cVar.i() : null;
        String strI2 = aVar.d().i();
        if (strI2 == null) {
            strI2 = strI != null ? strI : "0.1";
        }
        w5.k kVarL = w5.k.l(context);
        if (cVar == null) {
            kVarL.d0(x7.u.bg);
            kVarL.J(context.getString(x7.u.f13937c8, aVar.d().g(), strI2));
        } else {
            boolean zEquals = strI2.equals(strI);
            kVarL.d0(!zEquals ? x7.u.kg : x7.u.eg);
            if (zEquals) {
                string = context.getString(x7.u.f13993g8, aVar.d().g(), strI2);
            } else {
                int i10 = x7.u.f14077m8;
                String strG = aVar.d().g();
                if (strI == null) {
                    strI = "0.1";
                }
                string = context.getString(i10, strG, strI, strI2);
            }
            kVarL.J(string);
        }
        if (cVar != null) {
            aVar.g(cVar.j());
        }
        return kVarL;
    }

    public final void l(final r5.a aVar, final int i10) {
        final String strE = aVar.e();
        final String strG = aVar.d().g();
        ((autodispose2.r) x6.o.g(new Callable() { // from class: z8.p2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return t2.k(this.f14732e, i10, aVar);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(this.f14758b))).a(new a7.e() { // from class: z8.q2
            @Override // a7.e
            public final void accept(Object obj) {
                t2.j(this.f14738e, strG, strE, (Boolean) obj);
            }
        }, new x7.c0());
    }

    public final void m(final String str, final String str2) {
        if (g6.p.f(str)) {
            return;
        }
        ((autodispose2.r) x6.o.g(new Callable() { // from class: z8.r2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Boolean.valueOf(this.f14750e.f14759c.d().J(str));
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(this.f14758b))).a(new a7.e() { // from class: z8.s2
            @Override // a7.e
            public final void accept(Object obj) {
                t2.h(this.f14753e, str2, str, (Boolean) obj);
            }
        }, new x7.g0());
    }

    public void o(final String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        h.c(g6.f.a(this.f14757a), new Runnable() { // from class: z8.l2
            @Override // java.lang.Runnable
            public final void run() {
                t2.d(this.f14718e, str);
            }
        });
    }

    public void p(final String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        Context context = this.f14757a;
        g6.n.s(context, context.getString(x7.u.yg));
        ((autodispose2.r) x6.o.g(new Callable() { // from class: z8.i2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return t2.i(this.f14708e, str);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(this.f14758b))).a(new a7.e() { // from class: z8.k2
            @Override // a7.e
            public final void accept(Object obj) {
                t2.e(this.f14712e, (x5.a) obj);
            }
        }, new x7.g0());
    }

    public final void q(final r5.a aVar, final r5.c cVar) {
        w5.k kVarN = n(this.f14757a, aVar, cVar);
        if (kVarN == null) {
            return;
        }
        final boolean z10 = cVar != null;
        kVarN.V(R.string.ok, new k.m() { // from class: z8.m2
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                t2.f(this.f14724a, aVar, z10, cVar, view, pVar);
            }
        });
        kVarN.N(R.string.cancel, null);
        kVarN.f0();
    }
}
