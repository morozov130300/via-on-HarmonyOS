package x8;

import android.R;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.tuyafeng.support.utils.FragmentUtils;
import java.util.concurrent.Callable;
import mark.via.browser.kd;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class o2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f14614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.lifecycle.j f14615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final oa.k1 f14616c = kd.c();

    public o2(Fragment fragment) {
        this.f14614a = fragment.y0();
        this.f14615b = fragment.b1();
    }

    public static /* synthetic */ void a(o2 o2Var, String str, String str2, Boolean bool) {
        o2Var.getClass();
        if (!bool.booleanValue()) {
            Context context = o2Var.f14614a;
            com.tuyafeng.support.utils.n.s(context, context.getString(w7.u.Kg, str));
        } else {
            Context context2 = o2Var.f14614a;
            com.tuyafeng.support.utils.n.s(context2, context2.getString(w7.u.Lg, str));
            o2Var.j(str2, str);
        }
    }

    public static /* synthetic */ void b(o2 o2Var, s5.a aVar) {
        o2Var.getClass();
        x.d dVar = (x.d) aVar.c();
        if (dVar == null) {
            com.tuyafeng.support.utils.n.q(o2Var.f14614a, w7.u.Jg);
        } else {
            o2Var.m((ra.a) dVar.f14455a, (ra.c) dVar.f14456b);
        }
    }

    public static /* synthetic */ Boolean c(o2 o2Var, int i10, ra.a aVar) {
        boolean zP;
        qa.c cVarF = o2Var.f14616c.f();
        if (i10 > 0) {
            zP = cVarF.p(i10, aVar);
        } else {
            zP = cVarF.a(aVar) > 0;
        }
        return Boolean.valueOf(zP);
    }

    public static /* synthetic */ void e(final o2 o2Var, String str, final String str2, Boolean bool) {
        o2Var.getClass();
        if (bool.booleanValue()) {
            return;
        }
        Context context = o2Var.f14614a;
        com.tuyafeng.support.utils.n.t(context, context.getString(w7.u.Ig, str), o2Var.f14614a.getString(w7.u.oi), new View.OnClickListener() { // from class: x8.n2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FragmentUtils.j(FragmentUtils.c(this.f14612a.f14614a), sa.y.class, sa.y.E3(str2, true));
            }
        });
    }

    public static /* synthetic */ void g(o2 o2Var, ra.a aVar, boolean z10, ra.c cVar, View view, q5.k.p pVar) {
        int iE;
        if (z10) {
            o2Var.getClass();
            iE = cVar.e();
        } else {
            iE = 0;
        }
        o2Var.i(aVar, iE);
    }

    public static /* synthetic */ s5.a h(o2 o2Var, String str) {
        o2Var.getClass();
        ra.a aVarE = ra.a.e(ua.a.c(str), str);
        return aVarE == null ? s5.a.f(null) : s5.a.e(new x.d(aVarE, o2Var.f14616c.f().h(aVarE.d(), aVarE.c().b())));
    }

    public static q5.k k(Context context, ra.a aVar, ra.c cVar) {
        String string;
        if (aVar == null) {
            com.tuyafeng.support.utils.n.q(context, w7.u.Vb);
            return null;
        }
        String strI = cVar != null ? cVar.i() : null;
        String strI2 = aVar.c().i();
        if (strI2 == null) {
            strI2 = strI != null ? strI : "0.1";
        }
        q5.k kVarL = q5.k.l(context);
        if (cVar == null) {
            kVarL.f0(w7.u.rg);
            kVarL.K(context.getString(w7.u.f14171o8, aVar.c().g(), strI2));
        } else {
            boolean zEquals = strI2.equals(strI);
            kVarL.f0(!zEquals ? w7.u.zg : w7.u.ug);
            if (zEquals) {
                string = context.getString(w7.u.f14227s8, aVar.c().g(), strI2);
            } else {
                int i10 = w7.u.f14307y8;
                String strG = aVar.c().g();
                if (strI == null) {
                    strI = "0.1";
                }
                string = context.getString(i10, strG, strI, strI2);
            }
            kVarL.K(string);
        }
        if (cVar != null) {
            aVar.f(cVar.j());
        }
        return kVarL;
    }

    public final void i(final ra.a aVar, final int i10) {
        final String strD = aVar.d();
        final String strG = aVar.c().g();
        ((autodispose2.r) r6.q.f(new Callable() { // from class: x8.j2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return o2.c(this.f14588c, i10, aVar);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(this.f14615b))).a(new u6.f() { // from class: x8.k2
            @Override // u6.f
            public final void accept(Object obj) {
                o2.a(this.f14591c, strG, strD, (Boolean) obj);
            }
        }, new w7.a0());
    }

    public final void j(final String str, final String str2) {
        if (com.tuyafeng.support.utils.p.f(str)) {
            return;
        }
        ((autodispose2.r) r6.q.f(new Callable() { // from class: x8.l2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Boolean.valueOf(this.f14597c.f14616c.f().J(str));
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(this.f14615b))).a(new u6.f() { // from class: x8.m2
            @Override // u6.f
            public final void accept(Object obj) {
                o2.e(this.f14601c, str2, str, (Boolean) obj);
            }
        }, new w7.e0());
    }

    public void l(final String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        Context context = this.f14614a;
        com.tuyafeng.support.utils.n.s(context, context.getString(w7.u.Og));
        ((autodispose2.r) r6.q.f(new Callable() { // from class: x8.g2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return o2.h(this.f14575c, str);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(this.f14615b))).a(new u6.f() { // from class: x8.h2
            @Override // u6.f
            public final void accept(Object obj) {
                o2.b(this.f14579c, (s5.a) obj);
            }
        }, new w7.e0());
    }

    public final void m(final ra.a aVar, final ra.c cVar) {
        q5.k kVarK = k(this.f14614a, aVar, cVar);
        if (kVarK == null) {
            return;
        }
        final boolean z10 = cVar != null;
        kVarK.X(R.string.ok, new q5.k.m() { // from class: x8.i2
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                o2.g(this.f14584a, aVar, z10, cVar, view, pVar);
            }
        });
        kVarK.P(R.string.cancel, null);
        kVarK.h0();
    }
}
