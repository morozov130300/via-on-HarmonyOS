package hb;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tuyafeng.support.utils.FragmentUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class w5 extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public t5.f f6120u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public final List f6121v0 = new ArrayList();

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public int f6122w0 = -999;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public u9.l f6123x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public w9.a f6124y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public Map f6125z0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends t5.i {
        public a() {
        }

        @Override // t5.i
        public View o(ViewGroup viewGroup) {
            v5.i iVar = new v5.i(viewGroup.getContext());
            iVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            return iVar;
        }

        @Override // t5.i
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void l(w5.g gVar, ga.c cVar, int i10) {
            boolean z10 = false;
            gVar.T(v5.i.f13394m, cVar.d() == w5.this.f6122w0);
            gVar.X(v5.i.f13392c, cVar.g());
            String str = w5.this.f6125z0 == null ? "" : (String) w5.this.f6125z0.get(Integer.valueOf(cVar.d()));
            int i11 = v5.i.f13393e;
            gVar.X(i11, str);
            if (str != null && !str.isEmpty()) {
                z10 = true;
            }
            gVar.Y(i11, z10);
        }
    }

    public static /* synthetic */ void f3(w5 w5Var, String str, Bundle bundle) {
        w5Var.getClass();
        int i10 = bundle.getInt("engine_result", 0);
        w5Var.f6125z0 = tb.c.f(w5Var.f6123x0);
        if (i10 > 0) {
            w5Var.s3(i10);
        } else {
            int iP3 = w5Var.p3(i10);
            if (iP3 >= 0) {
                w5Var.f6120u0.m(iP3);
            }
        }
        w5Var.L0().x("engine_result");
    }

    public static /* synthetic */ boolean g3(final w5 w5Var, View view, final int i10, ga.c cVar) {
        w5Var.getClass();
        final int iD = cVar.d();
        if (iD <= 0) {
            w5Var.o3(iD);
            return true;
        }
        q5.k.l(w5Var.G()).G(new String[]{w5Var.X0(w7.u.E), w5Var.X0(w7.u.f14298y)}, new AdapterView.OnItemClickListener() { // from class: hb.s5
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                w5.j3(this.f6062a, iD, i10, adapterView, view2, i11, j10);
            }
        }).j0(view);
        return true;
    }

    public static /* synthetic */ void h3(w5 w5Var, View view, int i10, ga.c cVar) {
        int iP3 = w5Var.p3(w5Var.f6122w0);
        if (iP3 == i10) {
            return;
        }
        w5Var.r3(cVar);
        if (iP3 >= 0) {
            w5Var.f6120u0.m(iP3);
        }
        w5Var.f6120u0.m(i10);
    }

    public static /* synthetic */ void j3(w5 w5Var, int i10, int i11, AdapterView adapterView, View view, int i12, long j10) {
        if (i12 == 0) {
            w5Var.o3(i10);
            return;
        }
        if (i10 == w5Var.f6122w0) {
            int iA = x8.q2.a();
            int size = w5Var.f6121v0.size();
            int i13 = 0;
            for (int i14 = 0; i14 < size; i14++) {
                if (i14 != i11 && ((ga.c) w5Var.f6121v0.get(i14)).d() == iA) {
                    i13 = i14;
                    break;
                }
            }
            w5Var.r3((ga.c) w5Var.f6121v0.get(i13));
            w5Var.f6120u0.m(i13);
        }
        w5Var.f6124y0.z().a(i10);
        w5Var.f6125z0.remove(Integer.valueOf(i10));
        tb.c.g(w5Var.f6123x0, w5Var.f6125z0);
        w5Var.f6121v0.remove(i11);
        w5Var.f6120u0.u(i11);
    }

    public static /* synthetic */ void l3(w5 w5Var, int i10, int i11, ga.c cVar) {
        if (i10 < 0) {
            int size = w5Var.f6121v0.size();
            w5Var.f6121v0.add(cVar);
            w5Var.f6120u0.o(size);
            w5Var.f7946t0.x1(size);
            return;
        }
        w5Var.f6121v0.set(i10, cVar);
        w5Var.f6120u0.m(i10);
        if (w5Var.f6122w0 == i11) {
            w5Var.r3(cVar);
        }
    }

    private void q3() {
        this.f6122w0 = this.f6123x0.M1();
        List listB = x8.q2.b(G());
        listB.addAll(this.f6124y0.z().b(2));
        this.f6121v0.clear();
        this.f6121v0.addAll(listB);
        this.f6120u0.l();
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f6120u0 = new t5.f(this.f6121v0);
        a aVar = new a();
        aVar.j(new t5.g() { // from class: hb.q5
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                w5.h3(this.f6039a, view2, i10, (ga.c) obj);
            }
        });
        aVar.k(new t5.h() { // from class: hb.r5
            @Override // t5.h
            public final boolean a(View view2, int i10, Object obj) {
                return w5.g3(this.f6053a, view2, i10, (ga.c) obj);
            }
        });
        this.f6120u0.K(ga.c.class, aVar);
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f7946t0.setAdapter(this.f6120u0);
        u9.l lVarJ = la.s.j();
        this.f6123x0 = lVarJ;
        this.f6125z0 = tb.c.f(lVarJ);
        this.f6124y0 = la.s.f();
        q3();
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        x8.v3.a(e0Var, w7.u.Xb);
        e0Var.c(new com.tuyafeng.support.widget.e0.b(1, 1, lb.g.a(G(), w7.o.f13810m, w7.u.ge), X0(w7.u.O)), new View.OnClickListener() { // from class: hb.p5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f6026a.o3(0);
            }
        });
    }

    public final void o3(int i10) {
        L0().z1("engine_result", this, new androidx.fragment.app.i0() { // from class: hb.t5
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                w5.f3(this.f6076a, str, bundle);
            }
        });
        FragmentUtils.k(this, d1.class, d1.s3(i10), null);
    }

    public final int p3(int i10) {
        int size = this.f6121v0.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (((ga.c) this.f6121v0.get(i11)).d() == i10) {
                return i11;
            }
        }
        return -1;
    }

    public final void r3(ga.c cVar) {
        int iD = cVar.d();
        this.f6122w0 = iD;
        if (x8.q2.g(iD)) {
            this.f6123x0.p1(cVar.a());
        }
        this.f6123x0.s(this.f6122w0);
    }

    public final void s3(final int i10) {
        if (this.f6120u0 == null) {
            return;
        }
        final int iP3 = p3(i10);
        ((autodispose2.m) r6.f.h(new Callable() { // from class: hb.u5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f6091c.f6124y0.z().c(i10);
            }
        }).n(a7.a.c()).k(q6.b.b()).p(s8.b.a(b1()))).a(new u6.f() { // from class: hb.v5
            @Override // u6.f
            public final void accept(Object obj) {
                w5.l3(this.f6106c, iP3, i10, (ga.c) obj);
            }
        }, new w7.e0());
    }
}
