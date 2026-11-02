package hb;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class y4 extends o8.g {

    /* renamed from: s0, reason: collision with root package name */
    public y5.f f6841s0;

    /* renamed from: t0, reason: collision with root package name */
    public w9.p f6842t0;

    /* renamed from: r0, reason: collision with root package name */
    public final w9.l f6840r0 = pa.r.j();

    /* renamed from: u0, reason: collision with root package name */
    public final androidx.activity.result.b f6843u0 = y2(new e.g(), new androidx.activity.result.a() { // from class: hb.w4
        @Override // androidx.activity.result.a
        public final void a(Object obj) {
            y4.g3(this.f6808a, (Boolean) obj);
        }
    });

    public static /* synthetic */ void g3(y4 y4Var, Boolean bool) {
        y4Var.getClass();
        if (!bool.booleanValue()) {
            z8.f.m(y4Var.I());
            return;
        }
        int iI3 = y4Var.i3(0);
        a6.n nVarJ3 = y4Var.j3(iI3);
        if (nVarJ3 == null) {
            return;
        }
        nVarJ3.j(true);
        y4Var.f6842t0.X(true);
        y4Var.f6840r0.g0(y4Var.f6842t0);
        y4Var.f6841s0.m(iI3);
    }

    private int i3(int i10) {
        List listH = this.f6841s0.H();
        for (int i11 = 0; i11 < listH.size(); i11++) {
            Object obj = listH.get(i11);
            if ((obj instanceof a6.q) && ((a6.q) obj).c() == i10) {
                return i11;
            }
        }
        return -1;
    }

    private a6.n j3(int i10) {
        List listH = this.f6841s0.H();
        if (i10 < 0 || i10 >= listH.size() || !(listH.get(i10) instanceof a6.n)) {
            return null;
        }
        return (a6.n) listH.get(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k3(View view, int i10, a6.n nVar) {
        int iC = nVar.c();
        if (iC == 0) {
            if (!nVar.i()) {
                this.f6843u0.a("android.permission.ACCESS_FINE_LOCATION");
                return;
            }
            nVar.j(false);
            this.f6842t0.X(false);
            this.f6840r0.g0(this.f6842t0);
            w9.n.e().y(true);
        } else if (iC == 1) {
            nVar.j(!nVar.i());
            this.f6842t0.P(nVar.i());
            this.f6840r0.g0(this.f6842t0);
            w9.n.e().y(true);
        } else if (iC == 2) {
            nVar.j(!nVar.i());
            this.f6842t0.h0(!nVar.i());
            this.f6840r0.g0(this.f6842t0);
            w9.n.e().y(true);
        } else if (iC == 3) {
            nVar.j(!nVar.i());
            this.f6842t0.f0(nVar.i());
            this.f6840r0.g0(this.f6842t0);
            w9.n.e().y(true);
        } else if (iC == 4) {
            nVar.j(!nVar.i());
            this.f6842t0.g0(nVar.i());
            this.f6840r0.g0(this.f6842t0);
            w9.n.e().y(true);
        } else if (iC == 5) {
            nVar.j(!nVar.i());
            this.f6842t0.c0(nVar.i());
            this.f6840r0.g0(this.f6842t0);
            w9.n.e().y(true);
        } else if (iC == 6) {
            nVar.j(!nVar.i());
            this.f6842t0.k0(nVar.i());
            this.f6840r0.g0(this.f6842t0);
        }
        this.f6841s0.m(i10);
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f6842t0 = this.f6840r0.m2();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a6.n(1, Z0(x7.u.H3), this.f6842t0.m()));
        arrayList.add(new a6.n(6, Z0(x7.u.D3), this.f6842t0.F()));
        arrayList.add(new a6.n(4, Z0(x7.u.F3), Z0(x7.u.G3), this.f6842t0.B()));
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(null);
        y5.f fVar = new y5.f(arrayList);
        this.f6841s0 = fVar;
        fVar.K(a6.n.class, new a6.p(new y5.g() { // from class: hb.x4
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6828a.k3(view2, i10, (a6.n) obj);
            }
        }));
        this.f10459q0.setAdapter(this.f6841s0);
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        z8.v3.a(zVar, x7.u.tc);
    }
}
