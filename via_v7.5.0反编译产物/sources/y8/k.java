package y8;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tuyafeng.support.utils.FragmentUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.simpleframework.xml.strategy.Name;
import x8.r3;
import x8.v3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class k extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public u9.l f14981u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public n9.o f14982v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public t5.f f14983w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public final Map f14984x0 = new HashMap();

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public String f14985y0 = null;

    public static /* synthetic */ void g3(k kVar, String[] strArr, AdapterView adapterView, View view, int i10, long j10) {
        kVar.getClass();
        FragmentUtils.k(kVar, s0.class, s0.G3(strArr[i10]), null);
    }

    public static /* synthetic */ void h3(k kVar, String str, Boolean bool) {
        if (str.equals(kVar.f14985y0)) {
            kVar.t3(null);
        } else {
            kVar.s3();
        }
    }

    public static /* synthetic */ void i3(k kVar, String str, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 == 0) {
            kVar.r3(str);
        } else {
            kVar.q3(str);
        }
    }

    public static /* synthetic */ boolean j3(final k kVar, View view, int i10, v5.g gVar) {
        kVar.getClass();
        if (i10 == 0) {
            return false;
        }
        final String str = (String) kVar.f14984x0.get(Integer.valueOf(gVar.c()));
        q5.k.l(kVar.G()).G(new String[]{kVar.X0(w7.u.E), kVar.X0(w7.u.f14298y)}, new AdapterView.OnItemClickListener() { // from class: y8.f
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                k.i3(this.f14955a, str, adapterView, view2, i11, j10);
            }
        }).j0(view);
        return true;
    }

    public static /* synthetic */ void l3(k kVar, String str, Bundle bundle) {
        kVar.getClass();
        if (bundle.getString(Name.MARK) != null) {
            kVar.s3();
        }
        kVar.L0().x("result");
    }

    public static /* synthetic */ void m3(k kVar, List list) {
        kVar.f14985y0 = kVar.f14981u0.q0();
        kVar.u3(kVar.p3(list));
    }

    public static /* synthetic */ void n3(k kVar, View view, int i10, v5.g gVar) {
        kVar.getClass();
        kVar.t3((String) kVar.f14984x0.get(Integer.valueOf(gVar.c())));
    }

    private List p3(List list) {
        ArrayList arrayList = new ArrayList();
        this.f14984x0.clear();
        Iterator it = list.iterator();
        boolean z10 = true;
        while (it.hasNext()) {
            n9.l lVar = (n9.l) it.next();
            int iHashCode = lVar.d().hashCode();
            this.f14984x0.put(Integer.valueOf(iHashCode), lVar.d());
            boolean zEquals = lVar.d().equals(this.f14985y0);
            if (zEquals) {
                z10 = false;
            }
            arrayList.add(new v5.g(iHashCode, lVar.g(), zEquals));
        }
        arrayList.add(0, new v5.g(0, X0(w7.u.f14060g9), z10));
        if (z10 && this.f14985y0 != null) {
            this.f14985y0 = null;
        }
        return arrayList;
    }

    private void s3() {
        ((autodispose2.r) r6.q.f(new Callable() { // from class: y8.g
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f14961c.f14982v0.t();
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: y8.h
            @Override // u6.f
            public final void accept(Object obj) {
                k.m3(this.f14965c, (List) obj);
            }
        }, new w7.e0());
    }

    private void u3(List list) {
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new v5.k(this.f14983w0.H(), list));
        this.f14983w0.M(list);
        eVarB.c(this.f14983w0);
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f14981u0 = la.s.j();
        this.f14982v0 = la.s.e();
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        r3.e(this.f7946t0);
        this.f14983w0 = new t5.f(Collections.EMPTY_LIST);
        v5.j jVar = new v5.j();
        jVar.j(new t5.g() { // from class: y8.a
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                k.n3(this.f14941a, view2, i10, (v5.g) obj);
            }
        });
        jVar.k(new t5.h() { // from class: y8.b
            @Override // t5.h
            public final boolean a(View view2, int i10, Object obj) {
                return k.j3(this.f14943a, view2, i10, (v5.g) obj);
            }
        });
        this.f14983w0.K(v5.g.class, jVar);
        this.f7946t0.setAdapter(this.f14983w0);
        s3();
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        v3.a(e0Var, w7.u.T0);
        e0Var.c(new com.tuyafeng.support.widget.e0.b(1, 1, lb.g.a(G(), w7.o.f13810m, w7.u.ge), X0(w7.u.O)), new View.OnClickListener() { // from class: y8.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f14945a.r3(null);
            }
        });
    }

    public final void q3(final String str) {
        ((autodispose2.r) r6.q.f(new Callable() { // from class: y8.i
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Boolean.valueOf(this.f14975c.f14982v0.n(str));
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: y8.j
            @Override // u6.f
            public final void accept(Object obj) {
                k.h3(this.f14978c, str, (Boolean) obj);
            }
        }, new w7.e0());
    }

    public final void r3(String str) {
        L0().z1("result", this, new androidx.fragment.app.i0() { // from class: y8.d
            @Override // androidx.fragment.app.i0
            public final void a(String str2, Bundle bundle) {
                k.l3(this.f14948a, str2, bundle);
            }
        });
        if (str != null) {
            FragmentUtils.k(this, s0.class, s0.G3(str), null);
            return;
        }
        final String[] strArrD = n9.s.d();
        if (strArrD.length == 0) {
            FragmentUtils.k(this, s0.class, s0.G3(null), null);
            return;
        }
        String[] strArr = new String[strArrD.length];
        for (int i10 = 0; i10 < strArrD.length; i10++) {
            n9.l lVarC = n9.s.c(strArrD[i10]);
            strArr[i10] = lVarC == null ? X0(w7.u.J0) : lVarC.g();
        }
        q5.k.l(G()).f0(w7.u.O).G(strArr, new AdapterView.OnItemClickListener() { // from class: y8.e
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i11, long j10) {
                k.g3(this.f14952a, strArrD, adapterView, view, i11, j10);
            }
        }).h0();
    }

    public final void t3(String str) {
        boolean zEquals;
        if (str == null) {
            String str2 = this.f14985y0;
            zEquals = str2 == null || str2.isEmpty();
        } else {
            zEquals = str.equals(this.f14985y0);
        }
        if (zEquals) {
            return;
        }
        this.f14981u0.J0(str);
        s3();
    }
}
