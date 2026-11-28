package m8;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.tuyafeng.support.utils.x;
import com.tuyafeng.support.widget.e0;
import x8.h3;
import x8.v3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class g extends m8.a {

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public LinearLayout f7947o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public Runnable f7948p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public final h f7949q0 = new a(this);

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends h {
        public a(Fragment fragment) {
            super(fragment);
        }

        @Override // m8.h
        public boolean l() {
            return g.this.l();
        }

        @Override // m8.h
        public void n() {
            g.this.T2();
        }

        @Override // m8.h
        public boolean o() {
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements b6.a.InterfaceC0033a {
        public b() {
        }

        @Override // b6.a.InterfaceC0033a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(LinearLayout linearLayout) {
            linearLayout.setOrientation(1);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c implements b6.a.InterfaceC0033a {

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class a extends p5.d {
            public a() {
            }

            @Override // p5.d
            public void a(View view) {
                x.O(g.this.f7947o0);
            }
        }

        public c() {
        }

        @Override // b6.a.InterfaceC0033a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(e0 e0Var) {
            e0Var.setOnClickListener(new a());
            g.this.Z2(e0Var);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f7947o0 = (LinearLayout) new b6.a(new LinearLayout(G()), new LinearLayout.LayoutParams(-1, -1)).V(new b()).l();
        if (V2()) {
            this.f7947o0.addView((e0) new b6.a(new e0(G()), new LinearLayout.LayoutParams(-1, -2)).V(new c()).l());
        }
        this.f7947o0.addView(Y2(layoutInflater, viewGroup));
        return x.a0(this, this.f7947o0, U2(), W2());
    }

    @Override // androidx.fragment.app.Fragment
    public void D1() {
        this.f7948p0 = null;
        super.D1();
    }

    public void S2() {
        h3.e(this.f7947o0);
    }

    public void T2() {
        if (L0().V0()) {
            return;
        }
        L0().e1();
    }

    public boolean U2() {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        if (view.findViewById(x.f3593a) != null) {
            i0().h().h(b1(), this.f7949q0);
        }
        S2();
    }

    public boolean V2() {
        return true;
    }

    public boolean W2() {
        return true;
    }

    public final void X2(Runnable runnable) {
        this.f7948p0 = runnable;
        runnable.run();
    }

    public abstract View Y2(LayoutInflater layoutInflater, ViewGroup viewGroup);

    @Override // m8.a, m8.b
    public void b0(boolean z10) {
        if (a1() == null) {
            return;
        }
        if (this.f7948p0 == null) {
            super.b0(z10);
            return;
        }
        x.K(this.f7947o0);
        e0 e0Var = (e0) this.f7947o0.findViewById(v3.f14644a);
        if (e0Var != null) {
            e0Var.i();
        }
        this.f7948p0.run();
    }

    public boolean l() {
        return true;
    }

    public void Z2(e0 e0Var) {
    }
}
