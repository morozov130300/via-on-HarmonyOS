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
import x8.r3;
import x8.v3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class z extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public u9.l f15039u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public n9.o f15040v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public t5.f f15041w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public final Map f15042x0 = new HashMap();

    public static /* synthetic */ void h3(z zVar, List list) {
        zVar.t3(zVar.p3(list));
        zVar.d3(list.isEmpty());
    }

    public static /* synthetic */ void i3(z zVar, AdapterView adapterView, View view, int i10, long j10) {
        zVar.getClass();
        FragmentUtils.k(zVar, h1.class, h1.p3(i10 == 0 ? 1 : 2), null);
    }

    public static /* synthetic */ void k3(z zVar, String str, Bundle bundle) {
        zVar.getClass();
        if (bundle.getString("sug_result", null) != null) {
            zVar.s3();
        }
        zVar.L0().x("sug_result");
    }

    public static /* synthetic */ void l3(z zVar, String str, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 == 0) {
            zVar.r3(null, str);
        } else {
            zVar.q3(str);
        }
    }

    public static /* synthetic */ void n3(z zVar, View view, int i10, v5.q qVar) {
        zVar.getClass();
        zVar.r3(null, (String) zVar.f15042x0.get(Integer.valueOf(qVar.c())));
    }

    public static /* synthetic */ boolean o3(final z zVar, View view, int i10, v5.q qVar) {
        zVar.getClass();
        final String str = (String) zVar.f15042x0.get(Integer.valueOf(qVar.c()));
        q5.k.l(zVar.G()).G(new String[]{zVar.X0(w7.u.E), zVar.X0(w7.u.f14298y)}, new AdapterView.OnItemClickListener() { // from class: y8.u
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                z.l3(this.f15028a, str, adapterView, view2, i11, j10);
            }
        }).j0(view);
        return true;
    }

    private List p3(List list) {
        ArrayList arrayList = new ArrayList();
        this.f15042x0.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            n9.q qVar = (n9.q) it.next();
            if (qVar.g() == 1) {
                int iHashCode = qVar.d().hashCode();
                this.f15042x0.put(Integer.valueOf(iHashCode), qVar.d());
                arrayList.add(new v5.q(iHashCode, qVar.e()));
            }
        }
        if (!arrayList.isEmpty()) {
            arrayList.add(0, new v5.l(X0(w7.u.ce)));
        }
        int size = arrayList.size();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            n9.q qVar2 = (n9.q) it2.next();
            if (qVar2.g() == 2) {
                int iHashCode2 = qVar2.d().hashCode();
                this.f15042x0.put(Integer.valueOf(iHashCode2), qVar2.d());
                arrayList.add(new v5.q(iHashCode2, qVar2.e()));
            }
        }
        if (arrayList.size() > size) {
            arrayList.add(size, new v5.l(X0(w7.u.f14294x8)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s3() {
        ((autodispose2.r) r6.q.f(new Callable() { // from class: y8.s
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f15006c.f15040v0.u();
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: y8.t
            @Override // u6.f
            public final void accept(Object obj) {
                z.h3(this.f15025c, (List) obj);
            }
        }, new w7.e0());
    }

    private void t3(List list) {
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new v5.k(this.f15041w0.H(), list));
        this.f15041w0.M(list);
        eVarB.c(this.f15041w0);
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f15039u0 = la.s.j();
        this.f15040v0 = la.s.e();
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        r3.e(this.f7946t0);
        t5.f fVar = new t5.f(Collections.EMPTY_LIST);
        this.f15041w0 = fVar;
        fVar.K(v5.l.class, new v5.m());
        v5.s sVar = new v5.s();
        sVar.j(new t5.g() { // from class: y8.q
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                z.n3(this.f15002a, view2, i10, (v5.q) obj);
            }
        });
        sVar.k(new t5.h() { // from class: y8.r
            @Override // t5.h
            public final boolean a(View view2, int i10, Object obj) {
                return z.o3(this.f15004a, view2, i10, (v5.q) obj);
            }
        });
        this.f15041w0.K(v5.q.class, sVar);
        this.f7946t0.setAdapter(this.f15041w0);
        s3();
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        v3.b(e0Var, X0(w7.u.S0));
        e0Var.c(new com.tuyafeng.support.widget.e0.b(1, 1, lb.g.a(G(), w7.o.f13810m, w7.u.ge), X0(w7.u.O)), new View.OnClickListener() { // from class: y8.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15000a.r3(view, null);
            }
        });
    }

    public final void q3(final String str) {
        ((autodispose2.r) r6.q.f(new Callable() { // from class: y8.x
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Boolean.valueOf(this.f15034c.f15040v0.v(str));
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: y8.y
            @Override // u6.f
            public final void accept(Object obj) {
                this.f15037c.s3();
            }
        }, new w7.e0());
    }

    public final void r3(View view, String str) {
        L0().z1("sug_result", this, new androidx.fragment.app.i0() { // from class: y8.v
            @Override // androidx.fragment.app.i0
            public final void a(String str2, Bundle bundle) {
                z.k3(this.f15030a, str2, bundle);
            }
        });
        if (str == null) {
            q5.k.l(G()).G(new String[]{X0(w7.u.ce), X0(w7.u.f14294x8)}, new AdapterView.OnItemClickListener() { // from class: y8.w
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view2, int i10, long j10) {
                    z.i3(this.f15032a, adapterView, view2, i10, j10);
                }
            }).j0(view);
        } else {
            FragmentUtils.k(this, h1.class, h1.q3(str), null);
        }
    }
}
