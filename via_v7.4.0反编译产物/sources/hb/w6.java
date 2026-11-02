package hb;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.f;
import com.tuyafeng.support.widget.z;
import java.util.Collections;
import java.util.List;
import w5.k;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class w6 extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public ca.d f6816r0;

    /* renamed from: s0, reason: collision with root package name */
    public y5.f f6817s0;

    /* renamed from: t0, reason: collision with root package name */
    public List f6818t0 = Collections.EMPTY_LIST;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends y5.i {
        public a() {
        }

        @Override // y5.i
        public View o(ViewGroup viewGroup) {
            return b6.c.h().a(viewGroup);
        }

        @Override // y5.i
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public void l(b6.g gVar, String str, int i10) {
            gVar.X(b6.c.f1828c, str);
        }
    }

    public static /* synthetic */ boolean h3(w6 w6Var, View view, int i10, String str) {
        w6Var.t3(i10, view);
        return true;
    }

    public static /* synthetic */ void i3(w6 w6Var, int i10, AdapterView adapterView, View view, int i11, long j10) {
        if (i11 == 0) {
            w6Var.q3(i10);
        } else {
            w6Var.p3(i10);
        }
    }

    public static /* synthetic */ void j3(w6 w6Var, String str, Bundle bundle) {
        w6Var.getClass();
        if ((bundle.getInt("changed", 0) & 1) != 0) {
            w6Var.r3();
        }
        w6Var.N0().x("result");
    }

    public static /* synthetic */ void k3(w6 w6Var, String str, View view, k.p pVar) {
        w6Var.getClass();
        if (g6.e.e(pVar.f13339c, 1)) {
            return;
        }
        String strTrim = pVar.f13339c[0].trim();
        if (strTrim.contains("://")) {
            strTrim = i6.i0.f7006a.e(strTrim);
        }
        String strF = ba.c.f(strTrim);
        if (strF.isEmpty() || str.equals(strF)) {
            return;
        }
        if (w6Var.f6816r0.c(str, strF)) {
            w6Var.r3();
        } else {
            g6.n.s(w6Var.I(), w6Var.a1(x7.u.Kc, strF));
        }
    }

    public static /* synthetic */ void m3(w6 w6Var, View view, k.p pVar) {
        w6Var.getClass();
        if (g6.e.e(pVar.f13339c, 1)) {
            return;
        }
        String strTrim = pVar.f13339c[0].trim();
        if (strTrim.contains("://")) {
            strTrim = i6.i0.f7006a.e(strTrim);
        }
        w6Var.o3(ba.c.f(strTrim));
    }

    private void r3() {
        List listJ = this.f6816r0.j();
        Collections.sort(listJ, new k8.p());
        f.e eVarB = androidx.recyclerview.widget.f.b(new b6.h(this.f6818t0, listJ));
        this.f6818t0 = listJ;
        this.f6817s0.M(listJ);
        eVarB.c(this.f6817s0);
        e3(listJ.isEmpty());
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f6817s0 = new y5.f(Collections.EMPTY_LIST);
        a aVar = new a();
        aVar.j(new y5.g() { // from class: hb.p6
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6712a.s3((String) obj);
            }
        });
        aVar.k(new y5.h() { // from class: hb.q6
            @Override // y5.h
            public final boolean a(View view2, int i10, Object obj) {
                return w6.h3(this.f6724a, view2, i10, (String) obj);
            }
        });
        this.f6817s0.K(String.class, aVar);
        this.f10459q0.setAdapter(this.f6817s0);
        r3();
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        z8.v3.a(zVar, x7.u.S0);
        zVar.c(new z.b(0, 0, lb.b.a(I(), x7.o.f13747n, x7.u.Rd), Z0(x7.u.N)), new View.OnClickListener() { // from class: hb.r6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f6735a.n3();
            }
        });
    }

    public final void n3() {
        w5.k.l(I()).d0(x7.u.N).u(false).i("", "www.example.com", 1).V(R.string.ok, new k.m() { // from class: hb.t6
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                w6.m3(this.f6762a, view, pVar);
            }
        }).N(R.string.cancel, null).f0();
    }

    public final void o3(String str) {
        s3(str);
    }

    public final void p3(int i10) {
        this.f6816r0.b((String) this.f6818t0.get(i10));
        this.f6818t0.remove(i10);
        this.f6817s0.u(i10);
        e3(this.f6817s0.g() == 0);
    }

    public final void q3(int i10) {
        final String str = (String) this.f6818t0.get(i10);
        w5.k.l(I()).d0(x7.u.D).u(false).i(str, "www.example.com", 1).V(R.string.ok, new k.m() { // from class: hb.v6
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                w6.k3(this.f6799a, str, view, pVar);
            }
        }).N(R.string.cancel, null).f0();
    }

    public final void s3(String str) {
        N0().y1("result", this, new androidx.fragment.app.i0() { // from class: hb.s6
            @Override // androidx.fragment.app.i0
            public final void a(String str2, Bundle bundle) {
                w6.j3(this.f6749a, str2, bundle);
            }
        });
        g6.i.h(this, jb.u4.class, jb.u4.V3(str));
    }

    public final void t3(final int i10, View view) {
        w5.k.l(I()).F(new String[]{Z0(x7.u.D), Z0(x7.u.f14215x)}, new AdapterView.OnItemClickListener() { // from class: hb.u6
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                w6.i3(this.f6783a, i10, adapterView, view2, i11, j10);
            }
        }).h0(view);
    }

    @Override // androidx.fragment.app.Fragment
    public void v1(Context context) {
        super.v1(context);
        pa.r.b(context).x(this);
    }
}
