package hb;

import android.R;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import w5.k;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class z extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public final w9.l f6851r0;

    /* renamed from: s0, reason: collision with root package name */
    public final w9.p f6852s0;

    /* renamed from: t0, reason: collision with root package name */
    public final w9.a f6853t0;

    /* renamed from: u0, reason: collision with root package name */
    public y5.f f6854u0;

    public z() {
        w9.l lVarJ = pa.r.j();
        this.f6851r0 = lVarJ;
        this.f6852s0 = lVarJ.m2();
        this.f6853t0 = lVarJ.v();
    }

    public static /* synthetic */ void g3(z zVar, View view, k.p pVar) {
        zVar.getClass();
        g6.i.g(zVar, g4.class);
    }

    public static /* synthetic */ void i3(z zVar, View view, int i10, a6.q qVar) {
        zVar.getClass();
        if (qVar.c() == 6) {
            zVar.k3();
        }
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        z8.r3.d(this.f10459q0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a6.n(4, Z0(x7.u.f14227xb), Z0(x7.u.f14240yb), this.f6852s0.z()));
        arrayList.add(new a6.n(1, Z0(x7.u.Cc), this.f6851r0.F()));
        int i10 = Build.VERSION.SDK_INT;
        arrayList.add(new a6.n(3, Z0(x7.u.Oh), this.f6852s0.G()));
        if (z8.n3.h(I())) {
            arrayList.add(new a6.n(8, Z0(x7.u.C3), !this.f6853t0.m()));
        }
        if (i10 >= 21) {
            arrayList.add(new a6.n(7, Z0(x7.u.A3), Z0(x7.u.B3), true ^ this.f6853t0.j()));
        }
        if (i10 >= 26) {
            arrayList.add(new a6.n(5, Z0(x7.u.Sf), Z0(x7.u.Tf), this.f6852s0.y()));
        }
        arrayList.add(new a6.q(6, Z0(x7.u.Yf), Z0(x7.u.ag)));
        this.f6854u0 = new y5.f(arrayList);
        a6.s sVar = new a6.s();
        sVar.j(new y5.g() { // from class: hb.w
            @Override // y5.g
            public final void a(View view2, int i11, Object obj) {
                z.i3(this.f6802a, view2, i11, (a6.q) obj);
            }
        });
        this.f6854u0.K(a6.q.class, sVar);
        a6.p pVar = new a6.p();
        pVar.j(new y5.g() { // from class: hb.x
            @Override // y5.g
            public final void a(View view2, int i11, Object obj) {
                this.f6822a.j3(view2, i11, (a6.n) obj);
            }
        });
        this.f6854u0.K(a6.n.class, pVar);
        this.f10459q0.setAdapter(this.f6854u0);
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        z8.v3.a(zVar, x7.u.f14123pc);
    }

    public final void j3(View view, int i10, a6.n nVar) {
        int iC = nVar.c();
        if (iC == 4) {
            nVar.j(!nVar.i());
            this.f6852s0.e0(nVar.i());
            this.f6851r0.g0(this.f6852s0);
            w9.n.e().y(true);
        } else if (iC == 1) {
            nVar.j(!nVar.i());
            this.f6851r0.p2(nVar.i());
        } else if (iC == 2) {
            nVar.j(!nVar.i());
            this.f6852s0.S(nVar.i());
            this.f6851r0.g0(this.f6852s0);
            w9.n.e().y(true);
        } else if (iC == 3) {
            nVar.j(!nVar.i());
            this.f6852s0.l0(nVar.i());
            this.f6851r0.g0(this.f6852s0);
            w9.n.e().y(true);
            if (nVar.i()) {
                g6.n.k(I(), x7.u.Oh, x7.u.Ph);
            }
        } else if (iC == 5) {
            nVar.j(!nVar.i());
            this.f6852s0.d0(nVar.i());
            this.f6851r0.g0(this.f6852s0);
            w9.n.e().y(true);
        } else if (iC == 6) {
            k3();
        } else if (iC == 7) {
            nVar.j(!nVar.i());
            l3(!nVar.i());
        } else if (iC == 8) {
            nVar.j(!nVar.i());
            this.f6853t0.F(!nVar.i());
            this.f6851r0.q0(this.f6853t0);
        }
        this.f6854u0.m(i10);
    }

    public final void k3() {
        if (this.f6851r0.G2() != 0) {
            g6.i.g(this, g4.class);
        } else {
            w5.k.l(I()).d0(x7.u.Yf).I(x7.u.f13923b8).w(x7.u.Zf, false).M(true).V(R.string.ok, new k.m() { // from class: hb.y
                @Override // w5.k.m
                public final void a(View view, k.p pVar) {
                    z.g3(this.f6833a, view, pVar);
                }
            }).N(R.string.cancel, null).f0();
        }
    }

    public final void l3(boolean z10) {
        this.f6853t0.B(z10);
        this.f6851r0.q0(this.f6853t0);
    }
}
