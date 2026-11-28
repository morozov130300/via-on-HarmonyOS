package hb;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tuyafeng.support.utils.FragmentUtils;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class w6 extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public z9.d f6127u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f6128v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public List f6129w0 = Collections.EMPTY_LIST;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends t5.i {
        public a() {
        }

        @Override // t5.i
        public View o(ViewGroup viewGroup) {
            return w5.c.h().a(viewGroup);
        }

        @Override // t5.i
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void l(w5.g gVar, String str, int i10) {
            gVar.X(w5.c.f13659c, str);
        }
    }

    public static /* synthetic */ boolean g3(w6 w6Var, View view, int i10, String str) {
        w6Var.s3(i10, view);
        return true;
    }

    public static /* synthetic */ void h3(w6 w6Var, int i10, AdapterView adapterView, View view, int i11, long j10) {
        if (i11 == 0) {
            w6Var.p3(i10);
        } else {
            w6Var.o3(i10);
        }
    }

    public static /* synthetic */ void i3(w6 w6Var, String str, Bundle bundle) {
        w6Var.getClass();
        if ((bundle.getInt("changed", 0) & 1) != 0) {
            w6Var.q3();
        }
        w6Var.L0().x("result");
    }

    public static /* synthetic */ void j3(w6 w6Var, String str, View view, q5.k.p pVar) {
        w6Var.getClass();
        if (com.tuyafeng.support.utils.e.e(pVar.f11819c, 1)) {
            return;
        }
        String strTrim = pVar.f11819c[0].trim();
        if (strTrim.contains("://")) {
            strTrim = c6.a2.f1958a.f(strTrim);
        }
        String strF = y9.c.f(strTrim);
        if (strF.isEmpty() || str.equals(strF)) {
            return;
        }
        if (w6Var.f6127u0.c(str, strF)) {
            w6Var.q3();
        } else {
            com.tuyafeng.support.utils.n.s(w6Var.G(), w6Var.Y0(w7.u.Zc, strF));
        }
    }

    public static /* synthetic */ void l3(w6 w6Var, View view, q5.k.p pVar) {
        w6Var.getClass();
        if (com.tuyafeng.support.utils.e.e(pVar.f11819c, 1)) {
            return;
        }
        String strTrim = pVar.f11819c[0].trim();
        if (strTrim.contains("://")) {
            strTrim = c6.a2.f1958a.f(strTrim);
        }
        w6Var.n3(y9.c.f(strTrim));
    }

    private void q3() {
        List listI = this.f6127u0.i();
        Collections.sort(listI, new i8.p());
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new w5.h(this.f6129w0, listI));
        this.f6129w0 = listI;
        this.f6128v0.M(listI);
        eVarB.c(this.f6128v0);
        d3(listI.isEmpty());
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f6128v0 = new t5.f(Collections.EMPTY_LIST);
        a aVar = new a();
        aVar.j(new t5.g() { // from class: hb.p6
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6027a.r3((String) obj);
            }
        });
        aVar.k(new t5.h() { // from class: hb.q6
            @Override // t5.h
            public final boolean a(View view2, int i10, Object obj) {
                return w6.g3(this.f6040a, view2, i10, (String) obj);
            }
        });
        this.f6128v0.K(String.class, aVar);
        this.f7946t0.setAdapter(this.f6128v0);
        q3();
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        x8.v3.a(e0Var, w7.u.V0);
        e0Var.c(new com.tuyafeng.support.widget.e0.b(0, 0, lb.g.a(G(), w7.o.f13810m, w7.u.ge), X0(w7.u.O)), new View.OnClickListener() { // from class: hb.r6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f6054a.m3();
            }
        });
    }

    public final void m3() {
        q5.k.l(G()).f0(w7.u.O).v(false).i("", "www.example.com", 1).X(R.string.ok, new q5.k.m() { // from class: hb.t6
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                w6.l3(this.f6077a, view, pVar);
            }
        }).P(R.string.cancel, null).h0();
    }

    public final void n3(String str) {
        r3(str);
    }

    public final void o3(int i10) {
        this.f6127u0.b((String) this.f6129w0.get(i10));
        this.f6129w0.remove(i10);
        this.f6128v0.u(i10);
        d3(this.f6128v0.g() == 0);
    }

    public final void p3(int i10) {
        final String str = (String) this.f6129w0.get(i10);
        q5.k.l(G()).f0(w7.u.E).v(false).i(str, "www.example.com", 1).X(R.string.ok, new q5.k.m() { // from class: hb.v6
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                w6.j3(this.f6109a, str, view, pVar);
            }
        }).P(R.string.cancel, null).h0();
    }

    public final void r3(String str) {
        L0().z1("result", this, new androidx.fragment.app.i0() { // from class: hb.s6
            @Override // androidx.fragment.app.i0
            public final void a(String str2, Bundle bundle) {
                w6.i3(this.f6065a, str2, bundle);
            }
        });
        FragmentUtils.j(this, jb.u4.class, jb.u4.U3(str));
    }

    public final void s3(final int i10, View view) {
        q5.k.l(G()).G(new String[]{X0(w7.u.E), X0(w7.u.f14298y)}, new AdapterView.OnItemClickListener() { // from class: hb.u6
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                w6.h3(this.f6093a, i10, adapterView, view2, i11, j10);
            }
        }).j0(view);
    }

    @Override // androidx.fragment.app.Fragment
    public void t1(Context context) {
        super.t1(context);
        la.s.b(context).y(this);
    }
}
