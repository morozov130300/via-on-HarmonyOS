package bb;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.i0;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.a0;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import cb.f0;
import com.tuyafeng.support.utils.FragmentUtils;
import com.tuyafeng.support.widget.TabLayout;
import com.tuyafeng.support.widget.d0;
import com.tuyafeng.support.widget.e0;
import mark.via.browser.hd;
import x8.r2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class i extends m8.g {

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final int[] f1846w0 = {1, 2, 3};

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public ViewPager2 f1847r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public d0 f1848s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public TabLayout f1849t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public x f1850u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public int f1851v0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends p5.d {
        public a() {
        }

        @Override // p5.d
        public void a(View view) {
            for (Fragment fragment : i.this.x0().A0()) {
                if (fragment != null && fragment.m1()) {
                    com.tuyafeng.support.utils.x.O(fragment.a1());
                    return;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends ViewPager2.i {
        public b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void c(int i10) {
            i.this.f1848s0.setGestureEnabled(i10 == 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface c {
        boolean S();

        boolean l();
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class d extends FragmentStateAdapter {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int[] f1854l;

        public d(FragmentManager fragmentManager, Lifecycle lifecycle, int[] iArr) {
            super(fragmentManager, lifecycle);
            this.f1854l = iArr;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment J(int i10) {
            int[] iArr = this.f1854l;
            int i11 = iArr[i10 % iArr.length];
            if (i11 == 1) {
                return new f0();
            }
            if (i11 == 2) {
                return new db.o();
            }
            if (i11 == 3) {
                return new eb.t();
            }
            throw new NullPointerException("DataPagerAdapater can not find a fragment for " + this.f1854l[i10]);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int g() {
            return this.f1854l.length;
        }
    }

    public static /* synthetic */ void a3(final i iVar, Void r10) {
        iVar.L0().z1("restore_tabs", iVar, new i0() { // from class: bb.h
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                i.g3(this.f1845a, str, bundle);
            }
        });
        FragmentUtils.i(iVar, hd.class);
    }

    public static /* synthetic */ void b3(i iVar, Integer num) {
        iVar.getClass();
        int iK3 = iVar.k3(num.intValue());
        if (iK3 >= 0) {
            iVar.f1847r0.j(iK3, true);
        }
    }

    public static /* synthetic */ void c3(i iVar, Boolean bool) {
        iVar.f1847r0.setUserInputEnabled(bool.booleanValue());
        if (iVar.U2()) {
            iVar.f1848s0.setGestureEnabled(bool.booleanValue() && iVar.f1847r0.getCurrentItem() == 0);
        }
    }

    public static /* synthetic */ void e3(i iVar, TabLayout tabLayout) {
        iVar.getClass();
        tabLayout.setIndicatorColor(0);
        tabLayout.setTextColor(com.tuyafeng.support.utils.f.c(iVar.G(), com.tuyafeng.support.utils.e.b(iVar.G(), w7.k.f13735o)));
        tabLayout.setTextSize(v8.h.r(iVar.G()));
        tabLayout.setAllCaps(false);
        tabLayout.s(v8.g.i(), 0);
    }

    public static /* synthetic */ void g3(i iVar, String str, Bundle bundle) {
        iVar.getClass();
        String[] stringArray = bundle.getStringArray("tabs");
        String string = bundle.getString("selected");
        if (stringArray == null || stringArray.length <= 0) {
            return;
        }
        iVar.f1850u0.K(r2.l(stringArray, string), 0);
    }

    public static Bundle m3(boolean z10, int i10) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("draggable", z10);
        bundle.putInt("page", i10);
        return bundle;
    }

    @Override // androidx.fragment.app.Fragment
    public void B1() {
        i0().K().y1("result", j8.b.b(this.f1850u0.F()));
        super.B1();
    }

    @Override // androidx.fragment.app.Fragment
    public void E1() {
        Window window = i0().getWindow();
        int i10 = this.f1851v0;
        if (i10 != 0 && window != null) {
            window.setSoftInputMode(i10);
        }
        super.E1();
    }

    @Override // m8.g
    public void T2() {
        c cVarJ3 = j3();
        if (cVarJ3 == null || !cVarJ3.S()) {
            super.T2();
        }
    }

    @Override // m8.g
    public boolean U2() {
        return w0() == null || w0().getBoolean("draggable", true);
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        int iK3;
        super.V1(view, bundle);
        this.f1848s0 = (d0) view.findViewById(com.tuyafeng.support.utils.x.f3593a);
        com.tuyafeng.support.utils.x.J(this.f1847r0);
        this.f1847r0.setOrientation(0);
        ViewPager2 viewPager2 = this.f1847r0;
        FragmentManager fragmentManagerX0 = x0();
        Lifecycle lifecycleH0 = b1().h0();
        int[] iArr = f1846w0;
        viewPager2.setAdapter(new d(fragmentManagerX0, lifecycleH0, iArr));
        if (U2()) {
            this.f1847r0.g(new b());
        }
        String[] strArr = new String[iArr.length];
        int i10 = 0;
        while (true) {
            int[] iArr2 = f1846w0;
            if (i10 >= iArr2.length) {
                break;
            }
            strArr[i10] = l3(iArr2[i10]);
            i10++;
        }
        this.f1849t0.t(this.f1847r0, strArr);
        if (w0() != null && (iK3 = k3(w0().getInt("page", 0))) >= 0) {
            this.f1847r0.j(iK3, false);
        }
        this.f1850u0.f1882i.g(b1(), new androidx.lifecycle.o() { // from class: bb.a
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                i.b3(this.f1838a, (Integer) obj);
            }
        });
        this.f1850u0.f1884k.g(b1(), new androidx.lifecycle.o() { // from class: bb.b
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                this.f1839a.i0().K().c1();
            }
        });
        this.f1850u0.f1886m.g(b1(), new androidx.lifecycle.o() { // from class: bb.c
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                com.tuyafeng.support.utils.n.q(this.f1840a.G(), w7.u.I9);
            }
        });
        this.f1850u0.f1890q.g(b1(), new androidx.lifecycle.o() { // from class: bb.d
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                i.a3(this.f1841a, (Void) obj);
            }
        });
        this.f1850u0.f1892s.g(b1(), new androidx.lifecycle.o() { // from class: bb.e
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                i.c3(this.f1842a, (Boolean) obj);
            }
        });
    }

    @Override // m8.g
    public View Y2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        ViewPager2 viewPager2 = (ViewPager2) new b6.a(new ViewPager2(G()), new FrameLayout.LayoutParams(-1, -1)).l();
        this.f1847r0 = viewPager2;
        return viewPager2;
    }

    @Override // m8.g
    public void Z2(e0 e0Var) {
        super.Z2(e0Var);
        e0Var.m(lb.g.a(G(), w7.o.f13822q, w7.u.he), X0(w7.u.O8), new View.OnClickListener() { // from class: bb.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1843a.i0().K().c1();
            }
        });
        this.f1849t0 = (TabLayout) new b6.a(new TabLayout(G()), new FrameLayout.LayoutParams(-2, -1)).V(new b6.a.InterfaceC0033a() { // from class: bb.g
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                i.e3(this.f1844a, (TabLayout) obj);
            }
        }).l();
        e0Var.setOnClickListener(new a());
        e0Var.b(this.f1849t0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final c j3() {
        for (Fragment fragment : x0().A0()) {
            if (fragment != 0 && fragment.m1() && (fragment instanceof c)) {
                return (c) fragment;
            }
        }
        return null;
    }

    public final int k3(int i10) {
        int i11 = 0;
        while (true) {
            int[] iArr = f1846w0;
            if (i11 >= iArr.length) {
                return -1;
            }
            if (iArr[i11] == i10) {
                return i11;
            }
            i11++;
        }
    }

    @Override // m8.g
    public boolean l() {
        c cVarJ3 = j3();
        return cVarJ3 == null || cVarJ3.l();
    }

    public final String l3(int i10) {
        if (i10 == 1) {
            return X0(w7.u.f14092j);
        }
        if (i10 == 2) {
            return X0(w7.u.I);
        }
        if (i10 != 3) {
            return null;
        }
        return X0(w7.u.f14009d0);
    }

    @Override // androidx.fragment.app.Fragment
    public void t1(Context context) {
        super.t1(context);
        Window window = i0().getWindow();
        if (window == null) {
            this.f1851v0 = 0;
        } else {
            this.f1851v0 = window.getAttributes().softInputMode;
            window.setSoftInputMode(48);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.f1850u0 = (x) new a0(this, la.s.n()).a(x.class);
    }
}
