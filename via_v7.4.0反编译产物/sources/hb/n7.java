package hb;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.f;
import com.tuyafeng.support.widget.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mark.via.settings.helper.ToolbarsViewDelegate;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.simpleframework.xml.strategy.Name;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class n7 extends o8.g implements ToolbarsViewDelegate.b {

    /* renamed from: r0, reason: collision with root package name */
    public ToolbarsViewDelegate.GestureTarget f6679r0;

    /* renamed from: s0, reason: collision with root package name */
    public w9.l f6680s0;

    /* renamed from: t0, reason: collision with root package name */
    public y5.f f6681t0;

    /* renamed from: u0, reason: collision with root package name */
    public com.tuyafeng.support.widget.c f6682u0 = null;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6683a;

        static {
            int[] iArr = new int[ToolbarsViewDelegate.GestureTarget.values().length];
            f6683a = iArr;
            try {
                iArr[ToolbarsViewDelegate.GestureTarget.BACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6683a[ToolbarsViewDelegate.GestureTarget.FORWARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6683a[ToolbarsViewDelegate.GestureTarget.HOME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6683a[ToolbarsViewDelegate.GestureTarget.TABS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6683a[ToolbarsViewDelegate.GestureTarget.MENU.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6683a[ToolbarsViewDelegate.GestureTarget.FAB_LEFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6683a[ToolbarsViewDelegate.GestureTarget.FAB_RIGHT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f6683a[ToolbarsViewDelegate.GestureTarget.FAB_UP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f6683a[ToolbarsViewDelegate.GestureTarget.FAB_DOWN.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f6683a[ToolbarsViewDelegate.GestureTarget.SWIPE_BACK.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f6683a[ToolbarsViewDelegate.GestureTarget.SWIPE_FORWARD.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public static /* synthetic */ void h3(n7 n7Var, String str, Bundle bundle) {
        if (n7Var.f6679r0 != null && bundle.containsKey(Name.MARK)) {
            n7Var.w3(n7Var.f6679r0, bundle.getInt(Name.MARK));
        }
        n7Var.f6679r0 = null;
    }

    public static /* synthetic */ void i3(n7 n7Var, AdapterView adapterView, View view, int i10, long j10) {
        n7Var.f6680s0.j(i10);
        w9.a aVarV = n7Var.f6680s0.v();
        boolean z10 = true;
        if (i10 != 2 && i10 != 1) {
            z10 = false;
        }
        if (aVarV.t() && !z10) {
            aVarV.M(false);
            n7Var.f6680s0.q0(aVarV);
        }
        n7Var.t3();
    }

    public static /* synthetic */ void j3(n7 n7Var, AdapterView adapterView, View view, int i10, long j10) {
        n7Var.f6680s0.C0(i10);
        n7Var.t3();
    }

    public static /* synthetic */ void k3(n7 n7Var, w9.a aVar, AdapterView adapterView, View view, int i10, long j10) {
        n7Var.f6680s0.j(i10 + 1);
        n7Var.f6680s0.v().M(true);
        n7Var.f6680s0.q0(aVar);
        n7Var.t3();
    }

    public static /* synthetic */ void m3(n7 n7Var, w5.k kVar, int i10) {
        n7Var.f6680s0.u2(i10);
        n7Var.t3();
        kVar.n();
    }

    @Override // mark.via.settings.helper.ToolbarsViewDelegate.b
    public void K(final ToolbarsViewDelegate.GestureTarget gestureTarget) {
        int i10;
        if (gestureTarget == ToolbarsViewDelegate.GestureTarget.FAB) {
            g6.n.s(l0(), Z0(x7.u.f14018i5));
            return;
        }
        switch (a.f6683a[gestureTarget.ordinal()]) {
            case 1:
                i10 = x7.u.A9;
                break;
            case 2:
                i10 = x7.u.B9;
                break;
            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                i10 = x7.u.f14100o3;
                break;
            case 4:
                i10 = x7.u.Qd;
                break;
            case 5:
                i10 = x7.u.f14114p3;
                break;
            case 6:
                i10 = x7.u.f13976f5;
                break;
            case 7:
                i10 = x7.u.f13990g5;
                break;
            case 8:
                i10 = x7.u.f14004h5;
                break;
            case 9:
                i10 = x7.u.f13962e5;
                break;
            case 10:
            case 11:
                if ((gestureTarget == ToolbarsViewDelegate.GestureTarget.SWIPE_BACK) == g6.l.d(I())) {
                    i10 = x7.u.Eg;
                    break;
                } else {
                    i10 = x7.u.Fg;
                    break;
                }
            default:
                return;
        }
        g6.n.t(l0(), a1((gestureTarget == ToolbarsViewDelegate.GestureTarget.SWIPE_BACK || gestureTarget == ToolbarsViewDelegate.GestureTarget.SWIPE_FORWARD || gestureTarget == ToolbarsViewDelegate.GestureTarget.FAB_LEFT || gestureTarget == ToolbarsViewDelegate.GestureTarget.FAB_RIGHT || gestureTarget == ToolbarsViewDelegate.GestureTarget.FAB_UP || gestureTarget == ToolbarsViewDelegate.GestureTarget.FAB_DOWN) ? x7.u.Dg : x7.u.Cg, Z0(i10), v4.b(I(), s3(gestureTarget))), Z0(x7.u.M), new View.OnClickListener() { // from class: hb.m7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f6661a.R(gestureTarget);
            }
        });
    }

    @Override // mark.via.settings.helper.ToolbarsViewDelegate.b
    public void R(ToolbarsViewDelegate.GestureTarget gestureTarget) {
        if (g6.i.d(this)) {
            return;
        }
        this.f6679r0 = gestureTarget;
        g6.i.h(this, l6.class, l6.j3(s3(gestureTarget), true));
    }

    @Override // androidx.fragment.app.Fragment
    public void U1(Bundle bundle) {
        super.U1(bundle);
        ToolbarsViewDelegate.GestureTarget gestureTarget = this.f6679r0;
        if (gestureTarget != null) {
            bundle.putString("toolbar_gesture_target", gestureTarget.name());
        }
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f6680s0 = pa.r.j();
        N0().y1(l6.f6644v0, d1(), new androidx.fragment.app.i0() { // from class: hb.f7
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle2) {
                n7.h3(this.f6549a, str, bundle2);
            }
        });
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f6681t0 = new y5.f(Collections.EMPTY_LIST);
        a6.s sVar = new a6.s();
        sVar.j(new y5.g() { // from class: hb.g7
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6563a.v3((a6.q) obj, i10);
            }
        });
        this.f6681t0.K(a6.q.class, sVar);
        a6.p pVar = new a6.p();
        pVar.j(new y5.g() { // from class: hb.h7
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6572a.u3((a6.n) obj, i10);
            }
        });
        this.f6681t0.K(a6.n.class, pVar);
        this.f6681t0.K(a6.l.class, new a6.m());
        this.f6681t0.K(ib.b0.class, new ToolbarsViewDelegate(this));
        this.f10459q0.setAdapter(this.f6681t0);
        t3();
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        z8.v3.a(zVar, x7.u.Hg);
    }

    public final void o3() {
        w5.k.l(I()).d0(x7.u.Pg).Z(x7.j.f13651h, this.f6680s0.x0(), new AdapterView.OnItemClickListener() { // from class: hb.j7
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                n7.i3(this.f6618a, adapterView, view, i10, j10);
            }
        }).f0();
    }

    public final List p3() {
        ArrayList arrayList = new ArrayList();
        int iX0 = this.f6680s0.x0();
        boolean z10 = (iX0 == 2 || iX0 == 1) && this.f6680s0.v().t();
        int iG1 = this.f6680s0.g1();
        arrayList.add(new ib.b0(iX0, z10, iG1, this.f6680s0.r2() == 2, this.f6680s0.S()));
        arrayList.add(new a6.q(1, Z0(x7.u.Pg), g6.e.c(I(), x7.j.f13651h, iX0)));
        arrayList.add(new a6.q(2, Z0(x7.u.P5), g6.e.c(I(), x7.j.f13646c, this.f6680s0.r2())));
        arrayList.add(new a6.n(3, Z0(x7.u.f14220x4), z10));
        arrayList.add(new a6.q(4, Z0(x7.u.oh), g6.e.c(I(), x7.j.f13653j, iG1)));
        arrayList.add(new a6.n(5, Z0(x7.u.f14127q2), Z0(x7.u.f14140r2), this.f6680s0.A2()));
        return arrayList;
    }

    public final void q3() {
        int iX0 = this.f6680s0.x0();
        boolean z10 = iX0 == 2 || iX0 == 1;
        final w9.a aVarV = this.f6680s0.v();
        boolean zT = aVarV.t();
        boolean z11 = !zT;
        if (!zT && !z10) {
            w5.k.l(I()).d0(x7.u.Pg).I(x7.u.qg).s(1).b0(new String[]{Z0(x7.u.Rg), Z0(x7.u.Qg)}, -1, new AdapterView.OnItemClickListener() { // from class: hb.i7
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                    n7.k3(this.f6598a, aVarV, adapterView, view, i10, j10);
                }
            }).f0();
            return;
        }
        aVarV.M(z11);
        this.f6680s0.q0(aVarV);
        t3();
    }

    public final void r3() {
        com.tuyafeng.support.widget.c cVar = this.f6682u0;
        if (cVar == null) {
            com.tuyafeng.support.widget.c cVar2 = new com.tuyafeng.support.widget.c(I());
            this.f6682u0 = cVar2;
            int[] iArr = {x7.o.f13778x0, x7.o.f13781y0, x7.o.f13784z0};
            cVar2.setItemTextColor(x8.h.p(I()));
            this.f6682u0.setItemHighlightColor(x8.h.j(I()));
            this.f6682u0.setItemDrawableTint(x8.h.l(I()));
            this.f6682u0.setItemDrawaleHeight(g6.y.h(I(), 90.0f));
            this.f6682u0.setItemDrawableWidth(g6.y.h(I(), 50.0f));
            this.f6682u0.setItemTextSize(x8.h.v(I()));
            this.f6682u0.setItemBackground(g6.f.e(I(), x7.o.f13720e));
            this.f6682u0.c(x7.j.f13646c, iArr, this.f6680s0.r2());
        } else {
            ((ViewGroup) cVar.getParent()).removeAllViews();
        }
        final w5.k kVarY = w5.k.l(I()).d0(x7.u.P5).y(this.f6682u0);
        kVarY.f0();
        this.f6682u0.setHighlightChangedListener(new c.b() { // from class: hb.l7
            @Override // com.tuyafeng.support.widget.c.b
            public final void a(int i10) {
                n7.m3(this.f6649a, kVarY, i10);
            }
        });
    }

    public final int s3(ToolbarsViewDelegate.GestureTarget gestureTarget) {
        switch (a.f6683a[gestureTarget.ordinal()]) {
            case 1:
                return this.f6680s0.k0();
            case 2:
                return this.f6680s0.c2();
            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                return this.f6680s0.E();
            case 4:
                return this.f6680s0.h0();
            case 5:
                return this.f6680s0.w1();
            case 6:
                return this.f6680s0.v0();
            case 7:
                return this.f6680s0.c1();
            case 8:
                return this.f6680s0.i2();
            case 9:
                return this.f6680s0.z2();
            case 10:
                return this.f6680s0.g2();
            case 11:
                return this.f6680s0.m1();
            default:
                throw new IllegalArgumentException("Unknown gesture target: " + gestureTarget);
        }
    }

    public final void t3() {
        x3(p3());
    }

    public final void u3(a6.n nVar, int i10) {
        int iC = nVar.c();
        if (iC == 3) {
            q3();
        } else if (iC == 5) {
            this.f6680s0.X0(!nVar.i());
            t3();
        }
    }

    public final void v3(a6.q qVar, int i10) {
        int iC = qVar.c();
        if (iC == 1) {
            o3();
        } else if (iC == 2) {
            r3();
        } else if (iC == 4) {
            y3();
        }
    }

    public final void w3(ToolbarsViewDelegate.GestureTarget gestureTarget, int i10) {
        switch (a.f6683a[gestureTarget.ordinal()]) {
            case 1:
                this.f6680s0.Q1(i10);
                break;
            case 2:
                this.f6680s0.t(i10);
                break;
            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                this.f6680s0.l2(i10);
                break;
            case 4:
                this.f6680s0.G0(i10);
                break;
            case 5:
                this.f6680s0.B0(i10);
                break;
            case 6:
                this.f6680s0.s0(i10);
                break;
            case 7:
                this.f6680s0.v1(i10);
                break;
            case 8:
                this.f6680s0.d2(i10);
                break;
            case 9:
                this.f6680s0.t2(i10);
                break;
            case 10:
                this.f6680s0.f0(i10);
                break;
            case 11:
                this.f6680s0.J0(i10);
                break;
        }
    }

    public final void x3(List list) {
        y5.f fVar = this.f6681t0;
        if (fVar == null) {
            return;
        }
        f.e eVarB = androidx.recyclerview.widget.f.b(new ib.c0(fVar.H(), list));
        this.f6681t0.M(list);
        eVarB.c(this.f6681t0);
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        String string;
        super.y1(bundle);
        if (bundle == null || (string = bundle.getString("toolbar_gesture_target")) == null) {
            return;
        }
        this.f6679r0 = ToolbarsViewDelegate.GestureTarget.valueOf(string);
    }

    public final void y3() {
        w5.k.l(I()).d0(x7.u.oh).Z(x7.j.f13653j, this.f6680s0.g1(), new AdapterView.OnItemClickListener() { // from class: hb.k7
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                n7.j3(this.f6630a, adapterView, view, i10, j10);
            }
        }).f0();
    }
}
