package hb;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tuyafeng.support.utils.FragmentUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mark.via.settings.helper.FabPreferenceViewDelegate;
import mark.via.settings.search.SettingsSearchLocator;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class v4 extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public final u9.l f6102u0 = la.s.j();

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public int f6103v0 = -1;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public boolean f6104w0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements ib.n.a {
        public a() {
        }

        @Override // ib.n.a
        public void a(int i10) {
            v4.this.r3(i10);
        }

        @Override // ib.n.a
        public void b(int i10) {
            v4.this.q3(i10);
        }
    }

    public static /* synthetic */ void h3(v4 v4Var, String str, Bundle bundle) {
        if (v4Var.f6103v0 != -1 && bundle.containsKey(Name.MARK)) {
            v4Var.p3(v4Var.f6103v0, bundle.getInt(Name.MARK));
        }
        v4Var.f6103v0 = -1;
    }

    public static /* synthetic */ void i3(v4 v4Var, t5.f fVar, View view, int i10, v5.n nVar) {
        v4Var.getClass();
        int iC = nVar.c();
        if (iC == 1) {
            nVar.j(!nVar.i());
            v4Var.f6102u0.T1(nVar.i());
            fVar.m(i10);
        } else if (iC == 2) {
            nVar.j(!nVar.i());
            v4Var.f6102u0.O0(nVar.i());
            fVar.m(i10);
        }
    }

    public static /* synthetic */ void j3(v4 v4Var, View view, int i10, v5.q qVar) {
        v4Var.getClass();
        if (qVar.c() == 3) {
            FragmentUtils.i(v4Var, na.i.class);
        } else if (qVar.c() == 4) {
            FragmentUtils.i(v4Var, c8.class);
        }
    }

    public static /* synthetic */ void k3(v4 v4Var, int i10) {
        if (i10 == 1) {
            v4Var.r3(7);
            return;
        }
        if (i10 == 2) {
            v4Var.r3(8);
            return;
        }
        if (i10 == 4) {
            v4Var.r3(9);
        } else if (i10 != 8) {
            v4Var.getClass();
        } else {
            v4Var.r3(10);
        }
    }

    public static List o3(Context context) {
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, v4.class, w7.u.Fc, w7.u.Gc);
        hVar.b(1, w7.u.f14192q1, new String[0]);
        hVar.b(2, w7.u.ri, "音量键", "翻页", "滚动", "volume keys");
        hVar.b(4, w7.u.ki, new String[0]);
        hVar.b(3, w7.u.G7, new String[0]);
        hVar.b(-10001, w7.u.Sg, new String[0]);
        hVar.b(-10002, w7.u.f14238t5, "悬浮球", "悬浮按钮", "floating button");
        return hVar.f();
    }

    @Override // androidx.fragment.app.Fragment
    public void S1(Bundle bundle) {
        super.S1(bundle);
        bundle.putInt("pending_operation", this.f6103v0);
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        L0().z1(l6.f5953y0, b1(), new androidx.fragment.app.i0() { // from class: hb.p4
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle2) {
                v4.h3(this.f6025a, str, bundle2);
            }
        });
        final t5.f fVar = new t5.f(Collections.EMPTY_LIST);
        fVar.K(v5.n.class, new v5.p(new t5.g() { // from class: hb.q4
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                v4.i3(this.f6037a, fVar, view2, i10, (v5.n) obj);
            }
        }));
        fVar.K(v5.q.class, new v5.s(new t5.g() { // from class: hb.r4
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                v4.j3(this.f6052a, view2, i10, (v5.q) obj);
            }
        }));
        fVar.K(String.class, new ib.n(new a()));
        fVar.K(FabPreferenceViewDelegate.Item.class, new FabPreferenceViewDelegate(new FabPreferenceViewDelegate.a() { // from class: hb.s4
            @Override // mark.via.settings.helper.FabPreferenceViewDelegate.a
            public final void a(int i10) {
                v4.k3(this.f6061a, i10);
            }
        }));
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v5.n(1, X0(w7.u.f14192q1), this.f6102u0.x2()));
        arrayList.add(new v5.n(2, X0(w7.u.ri), this.f6102u0.z2()));
        arrayList.add(new v5.q(4, X0(w7.u.ki)));
        arrayList.add(new v5.q(3, X0(w7.u.G7)));
        arrayList.add("");
        arrayList.add(FabPreferenceViewDelegate.Item.INSTANCE);
        fVar.M(arrayList);
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(null);
        com.tuyafeng.support.widget.c0 c0Var = new com.tuyafeng.support.widget.c0(0);
        c0Var.l(com.tuyafeng.support.utils.x.h(G(), 48.0f));
        this.f7946t0.k(c0Var);
        this.f7946t0.setAdapter(fVar);
        SettingsSearchLocator.b(this, this.f7946t0);
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        x8.v3.a(e0Var, w7.u.Gc);
    }

    public final int n3(int i10) {
        switch (i10) {
            case 0:
                return this.f6102u0.n0();
            case 1:
                return this.f6102u0.d2();
            case 2:
                return this.f6102u0.F();
            case 3:
                return this.f6102u0.k0();
            case 4:
                return this.f6102u0.x1();
            case 5:
                return this.f6102u0.h2();
            case 6:
                return this.f6102u0.n1();
            case 7:
                return this.f6102u0.x0();
            case 8:
                return this.f6102u0.e1();
            case 9:
                return this.f6102u0.j2();
            case 10:
                return this.f6102u0.A2();
            default:
                throw new IllegalArgumentException("Unknown operation target: " + i10);
        }
    }

    public final void p3(int i10, int i11) {
        switch (i10) {
            case 0:
                this.f6102u0.R1(i11);
                return;
            case 1:
                this.f6102u0.u(i11);
                return;
            case 2:
                this.f6102u0.m2(i11);
                return;
            case 3:
                this.f6102u0.I0(i11);
                return;
            case 4:
                this.f6102u0.D0(i11);
                return;
            case 5:
                this.f6102u0.i0(i11);
                return;
            case 6:
                this.f6102u0.L0(i11);
                return;
            case 7:
                this.f6102u0.u0(i11);
                return;
            case 8:
                this.f6102u0.w1(i11);
                return;
            case 9:
                this.f6102u0.e2(i11);
                return;
            case 10:
                this.f6102u0.u2(i11);
                return;
            default:
                throw new IllegalArgumentException("Unknown operation target: " + i10);
        }
    }

    public final void q3(final int i10) {
        com.tuyafeng.support.utils.n.t(i0(), w4.b(G(), n3(i10)), X0(w7.u.N), new View.OnClickListener() { // from class: hb.t4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f6074a.r3(i10);
            }
        });
    }

    public final void r3(int i10) {
        if (this.f6104w0 || FragmentUtils.e(this)) {
            return;
        }
        this.f6104w0 = true;
        this.f6103v0 = i10;
        FragmentUtils.j(this, l6.class, l6.i3(n3(i10), true));
        this.f7946t0.post(new Runnable() { // from class: hb.u4
            @Override // java.lang.Runnable
            public final void run() {
                this.f6090c.f6104w0 = false;
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        if (bundle != null) {
            this.f6103v0 = bundle.getInt("pending_operation", -1);
        }
    }
}
