package hb;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import ib.m;
import java.util.ArrayList;
import java.util.Collections;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.simpleframework.xml.strategy.Name;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class u4 extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public final w9.l f6779r0 = pa.r.j();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements m.a {
        public a() {
        }

        @Override // ib.m.a
        public void a(int i10) {
            u4.this.m3(i10);
        }

        @Override // ib.m.a
        public void b(int i10) {
            u4.this.n3(i10);
        }
    }

    public static /* synthetic */ void h3(u4 u4Var, int i10, String str, Bundle bundle) {
        u4Var.getClass();
        int i11 = bundle.getInt(Name.MARK, 0);
        switch (i10) {
            case 0:
                u4Var.f6779r0.Q1(i11);
                break;
            case 1:
                u4Var.f6779r0.t(i11);
                break;
            case 2:
                u4Var.f6779r0.l2(i11);
                break;
            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                u4Var.f6779r0.G0(i11);
                break;
            case 4:
                u4Var.f6779r0.B0(i11);
                break;
            case 5:
                u4Var.f6779r0.f0(i11);
                break;
            case 6:
                u4Var.f6779r0.J0(i11);
                break;
        }
        u4Var.N0().x(l6.f6644v0);
    }

    public static /* synthetic */ void i3(u4 u4Var, View view, int i10, a6.q qVar) {
        u4Var.getClass();
        if (qVar.c() == 3) {
            g6.i.g(u4Var, ra.i.class);
        }
    }

    public static /* synthetic */ void j3(u4 u4Var, y5.f fVar, View view, int i10, a6.n nVar) {
        u4Var.getClass();
        int iC = nVar.c();
        if (iC == 1) {
            nVar.j(!nVar.i());
            u4Var.f6779r0.S1(nVar.i());
            fVar.m(i10);
            return;
        }
        if (iC == 2) {
            nVar.j(!nVar.i());
            u4Var.f6779r0.M0(nVar.i());
            fVar.m(i10);
        } else if (iC == 4) {
            nVar.j(!nVar.i());
            u4Var.f6779r0.M(nVar.i());
            fVar.m(i10);
        } else if (iC == 5) {
            w9.a aVarV = u4Var.f6779r0.v();
            nVar.j(true ^ nVar.i());
            aVarV.D(nVar.i());
            u4Var.f6779r0.q0(aVarV);
            fVar.m(i10);
        }
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        final y5.f fVar = new y5.f(Collections.EMPTY_LIST);
        fVar.K(a6.n.class, new a6.p(new y5.g() { // from class: hb.q4
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                u4.j3(this.f6721a, fVar, view2, i10, (a6.n) obj);
            }
        }));
        fVar.K(a6.q.class, new a6.s(new y5.g() { // from class: hb.r4
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                u4.i3(this.f6733a, view2, i10, (a6.q) obj);
            }
        }));
        fVar.K(String.class, new ib.m(new a()));
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a6.n(1, Z0(x7.u.f14070m1), this.f6779r0.w2()));
        arrayList.add(new a6.n(2, Z0(x7.u.Mh), this.f6779r0.y2()));
        arrayList.add(new a6.n(4, Z0(x7.u.f14233y4), Z0(x7.u.f14246z4), this.f6779r0.E1()));
        arrayList.add(new a6.q(3, Z0(x7.u.f14184u7)));
        arrayList.add("");
        fVar.M(arrayList);
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(null);
        this.f10459q0.setAdapter(fVar);
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        z8.v3.a(zVar, x7.u.sc);
    }

    public final void m3(final int i10) {
        int iK0;
        switch (i10) {
            case 0:
                iK0 = this.f6779r0.k0();
                break;
            case 1:
                iK0 = this.f6779r0.c2();
                break;
            case 2:
                iK0 = this.f6779r0.E();
                break;
            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                iK0 = this.f6779r0.h0();
                break;
            case 4:
                iK0 = this.f6779r0.w1();
                break;
            case 5:
                iK0 = this.f6779r0.g2();
                break;
            case 6:
                iK0 = this.f6779r0.m1();
                break;
            default:
                iK0 = 0;
                break;
        }
        g6.n.t(l0(), v4.b(I(), iK0), Z0(x7.u.M), new View.OnClickListener() { // from class: hb.s4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f6744a.n3(i10);
            }
        });
    }

    public final void n3(final int i10) {
        int iK0;
        switch (i10) {
            case 0:
                iK0 = this.f6779r0.k0();
                break;
            case 1:
                iK0 = this.f6779r0.c2();
                break;
            case 2:
                iK0 = this.f6779r0.E();
                break;
            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                iK0 = this.f6779r0.h0();
                break;
            case 4:
                iK0 = this.f6779r0.w1();
                break;
            case 5:
                iK0 = this.f6779r0.g2();
                break;
            case 6:
                iK0 = this.f6779r0.m1();
                break;
            default:
                iK0 = 0;
                break;
        }
        N0().y1(l6.f6644v0, this, new androidx.fragment.app.i0() { // from class: hb.t4
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                u4.h3(this.f6759a, i10, str, bundle);
            }
        });
        g6.i.h(this, l6.class, l6.j3(iK0, true));
    }
}
