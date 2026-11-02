package hb;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tuyafeng.support.widget.z;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class w5 extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public y5.f f6809r0;

    /* renamed from: s0, reason: collision with root package name */
    public final List f6810s0 = new ArrayList();

    /* renamed from: t0, reason: collision with root package name */
    public int f6811t0 = -999;

    /* renamed from: u0, reason: collision with root package name */
    public w9.l f6812u0;

    /* renamed from: v0, reason: collision with root package name */
    public y9.a f6813v0;

    /* renamed from: w0, reason: collision with root package name */
    public Map f6814w0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends y5.i {
        public a() {
        }

        @Override // y5.i
        public View o(ViewGroup viewGroup) {
            a6.i iVar = new a6.i(viewGroup.getContext());
            iVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            return iVar;
        }

        @Override // y5.i
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public void l(b6.g gVar, ja.c cVar, int i10) {
            boolean z10 = false;
            gVar.T(a6.i.f110k, cVar.d() == w5.this.f6811t0);
            gVar.X(a6.i.f108e, cVar.g());
            String str = w5.this.f6814w0 == null ? "" : (String) w5.this.f6814w0.get(Integer.valueOf(cVar.d()));
            int i11 = a6.i.f109j;
            gVar.X(i11, str);
            if (str != null && !str.isEmpty()) {
                z10 = true;
            }
            gVar.Y(i11, z10);
        }
    }

    public static /* synthetic */ void g3(w5 w5Var, String str, Bundle bundle) {
        w5Var.getClass();
        int i10 = bundle.getInt("engine_result", 0);
        w5Var.f6814w0 = tb.c.f(w5Var.f6812u0);
        if (i10 > 0) {
            w5Var.t3(i10);
        } else {
            int iQ3 = w5Var.q3(i10);
            if (iQ3 >= 0) {
                w5Var.f6809r0.m(iQ3);
            }
        }
        w5Var.N0().x("engine_result");
    }

    public static /* synthetic */ boolean h3(final w5 w5Var, View view, final int i10, ja.c cVar) {
        w5Var.getClass();
        final int iD = cVar.d();
        if (iD <= 0) {
            w5Var.p3(iD);
            return true;
        }
        w5.k.l(w5Var.I()).F(new String[]{w5Var.Z0(x7.u.D), w5Var.Z0(x7.u.f14215x)}, new AdapterView.OnItemClickListener() { // from class: hb.s5
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) throws JSONException {
                w5.k3(this.f6746a, iD, i10, adapterView, view2, i11, j10);
            }
        }).h0(view);
        return true;
    }

    public static /* synthetic */ void i3(w5 w5Var, View view, int i10, ja.c cVar) {
        int iQ3 = w5Var.q3(w5Var.f6811t0);
        if (iQ3 == i10) {
            return;
        }
        w5Var.s3(cVar);
        if (iQ3 >= 0) {
            w5Var.f6809r0.m(iQ3);
        }
        w5Var.f6809r0.m(i10);
    }

    public static /* synthetic */ void k3(w5 w5Var, int i10, int i11, AdapterView adapterView, View view, int i12, long j10) throws JSONException {
        if (i12 == 0) {
            w5Var.p3(i10);
            return;
        }
        if (i10 == w5Var.f6811t0) {
            int iA = z8.v2.a();
            int size = w5Var.f6810s0.size();
            int i13 = 0;
            int i14 = 0;
            while (true) {
                if (i14 < size) {
                    if (i14 != i11 && ((ja.c) w5Var.f6810s0.get(i14)).d() == iA) {
                        i13 = i14;
                        break;
                    }
                    i14++;
                } else {
                    break;
                }
            }
            w5Var.s3((ja.c) w5Var.f6810s0.get(i13));
            w5Var.f6809r0.m(i13);
        }
        w5Var.f6813v0.z().a(i10);
        w5Var.f6814w0.remove(Integer.valueOf(i10));
        tb.c.g(w5Var.f6812u0, w5Var.f6814w0);
        w5Var.f6810s0.remove(i11);
        w5Var.f6809r0.u(i11);
    }

    public static /* synthetic */ void m3(w5 w5Var, int i10, int i11, ja.c cVar) {
        if (i10 < 0) {
            int size = w5Var.f6810s0.size();
            w5Var.f6810s0.add(cVar);
            w5Var.f6809r0.o(size);
            w5Var.f10459q0.x1(size);
            return;
        }
        w5Var.f6810s0.set(i10, cVar);
        w5Var.f6809r0.m(i10);
        if (w5Var.f6811t0 == i11) {
            w5Var.s3(cVar);
        }
    }

    private void r3() {
        this.f6811t0 = this.f6812u0.M1();
        List listB = z8.v2.b(I());
        listB.addAll(this.f6813v0.z().c(2));
        this.f6810s0.clear();
        this.f6810s0.addAll(listB);
        this.f6809r0.l();
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f6809r0 = new y5.f(this.f6810s0);
        a aVar = new a();
        aVar.j(new y5.g() { // from class: hb.q5
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                w5.i3(this.f6723a, view2, i10, (ja.c) obj);
            }
        });
        aVar.k(new y5.h() { // from class: hb.r5
            @Override // y5.h
            public final boolean a(View view2, int i10, Object obj) {
                return w5.h3(this.f6734a, view2, i10, (ja.c) obj);
            }
        });
        this.f6809r0.K(ja.c.class, aVar);
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f10459q0.setAdapter(this.f6809r0);
        w9.l lVarJ = pa.r.j();
        this.f6812u0 = lVarJ;
        this.f6814w0 = tb.c.f(lVarJ);
        this.f6813v0 = pa.r.f();
        r3();
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        z8.v3.a(zVar, x7.u.Kb);
        zVar.c(new z.b(1, 1, lb.b.a(I(), x7.o.f13747n, x7.u.Rd), Z0(x7.u.N)), new View.OnClickListener() { // from class: hb.p5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f6711a.p3(0);
            }
        });
    }

    public final void p3(int i10) {
        N0().y1("engine_result", this, new androidx.fragment.app.i0() { // from class: hb.t5
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                w5.g3(this.f6761a, str, bundle);
            }
        });
        g6.i.i(this, c1.class, c1.s3(i10), null);
    }

    public final int q3(int i10) {
        int size = this.f6810s0.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (((ja.c) this.f6810s0.get(i11)).d() == i10) {
                return i11;
            }
        }
        return -1;
    }

    public final void s3(ja.c cVar) {
        int iD = cVar.d();
        this.f6811t0 = iD;
        if (z8.v2.g(iD)) {
            this.f6812u0.o1(cVar.a());
        }
        this.f6812u0.q(this.f6811t0);
    }

    public final void t3(final int i10) {
        if (this.f6809r0 == null) {
            return;
        }
        final int iQ3 = q3(i10);
        ((autodispose2.m) x6.f.h(new Callable() { // from class: hb.u5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f6781e.f6813v0.z().d(i10);
            }
        }).n(g7.a.c()).k(w6.b.b()).p(u8.b.a(d1()))).a(new a7.e() { // from class: hb.v5
            @Override // a7.e
            public final void accept(Object obj) {
                w5.m3(this.f6796e, iQ3, i10, (ja.c) obj);
            }
        }, new x7.g0());
    }
}
