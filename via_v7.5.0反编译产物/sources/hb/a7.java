package hb;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a7 extends m8.g {

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final int f5790t0 = y.r.j();

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final int f5791u0 = y.r.j();

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final int f5792v0 = y.r.j();

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public com.tuyafeng.support.widget.e0 f5793r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public u9.l f5794s0;

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f5794s0 = la.s.j();
        int iC3 = c3();
        if (bundle == null) {
            e3(iC3);
        } else {
            f3(iC3 == 0);
        }
    }

    @Override // m8.g
    public View Y2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(G());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setId(f5790t0);
        return frameLayout;
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        this.f5793r0 = e0Var;
        x8.v3.a(e0Var, w7.u.Id);
        e0Var.c(new com.tuyafeng.support.widget.e0.b(f5791u0, 1, null, X0(w7.u.Xd)), new View.OnClickListener() { // from class: hb.y6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f6165a.d3(1);
            }
        });
        e0Var.c(new com.tuyafeng.support.widget.e0.b(f5792v0, 1, null, X0(w7.u.Ec)), new View.OnClickListener() { // from class: hb.z6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f6179a.d3(0);
            }
        });
    }

    public final int c3() {
        int iL1 = this.f5794s0.l1();
        Bundle bundleW0 = w0();
        return bundleW0 == null ? iL1 : bundleW0.getInt("settings_search_sync_mode", iL1);
    }

    public final void d3(int i10) {
        Bundle bundleW0 = w0();
        if (bundleW0 != null) {
            bundleW0.remove("settings_search_sync_mode");
            bundleW0.remove("settings_search_target");
        }
        this.f5794s0.j(i10);
        e3(i10);
    }

    public final void e3(int i10) {
        f3(i10 == 0);
        Bundle bundleW0 = w0();
        x0().q().u(f5790t0, i10 == 0 ? u.class : nb.n.class, bundleW0 == null ? null : new Bundle(bundleW0), null).i();
    }

    public final void f3(boolean z10) {
        this.f5793r0.k(f5792v0, !z10);
        this.f5793r0.k(f5791u0, z10);
    }
}
