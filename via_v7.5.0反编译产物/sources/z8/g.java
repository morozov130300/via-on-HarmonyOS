package z8;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class g extends i8.a {
    public e0 E0;
    public ViewPager2 F0;
    public int G0 = 80;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends Dialog {
        public a(Context context, int i10) {
            super(context, i10);
        }

        @Override // android.app.Dialog
        public void onBackPressed() {
            g.this.E0.J(g.this.F0.getCurrentItem());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b extends FragmentStateAdapter {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int[] f15419l;

        public b(FragmentManager fragmentManager, Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
            this.f15419l = new int[]{0, 1};
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment J(int i10) {
            int i11 = this.f15419l[i10];
            if (i11 != 0) {
                return i11 != 1 ? new Fragment() : new a2();
            }
            return new r2();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int g() {
            return this.f15419l.length;
        }
    }

    public static /* synthetic */ void m3(g gVar, Integer num) {
        if (num == null) {
            gVar.getClass();
        } else {
            gVar.F0.j(num.intValue(), true);
        }
    }

    public static g s3(String str, int i10) {
        return t3(str, null, i10);
    }

    public static g t3(String str, a9.a aVar, int i10) {
        g gVar = new g();
        Bundle bundle = new Bundle();
        if (str != null) {
            bundle.putString(Name.MARK, str);
        }
        Bundle bundleB = a9.f.b(aVar);
        if (bundleB != null) {
            bundle.putBundle("attachment", bundleB);
        }
        bundle.putInt("gravity", i10);
        gVar.F2(bundle);
        return gVar;
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewPager2 viewPager2 = (ViewPager2) new b6.a(new ViewPager2(G()), new FrameLayout.LayoutParams(-1, -1)).l();
        this.F0 = viewPager2;
        return viewPager2;
    }

    @Override // i8.a, androidx.fragment.app.Fragment
    public void R1() {
        super.R1();
        u3(G().getResources().getConfiguration().orientation);
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        a9.a aVarA;
        super.V1(view, bundle);
        com.tuyafeng.support.utils.x.J(this.F0);
        this.F0.setAdapter(new b(x0(), h0()));
        x0().m(new FragmentManager.m() { // from class: z8.a
            @Override // androidx.fragment.app.FragmentManager.m
            public /* synthetic */ void a(androidx.activity.b bVar) {
                androidx.fragment.app.e0.c(this, bVar);
            }

            @Override // androidx.fragment.app.FragmentManager.m
            public /* synthetic */ void d(Fragment fragment, boolean z10) {
                androidx.fragment.app.e0.b(this, fragment, z10);
            }

            @Override // androidx.fragment.app.FragmentManager.m
            public /* synthetic */ void h(Fragment fragment, boolean z10) {
                androidx.fragment.app.e0.d(this, fragment, z10);
            }

            @Override // androidx.fragment.app.FragmentManager.m
            public /* synthetic */ void k() {
                androidx.fragment.app.e0.a(this);
            }

            @Override // androidx.fragment.app.FragmentManager.m
            public final void onBackStackChanged() {
                g gVar = this.f15352c;
                gVar.E0.D0(gVar.x0().u0() == 0);
            }
        });
        this.E0.d0().g(b1(), new androidx.lifecycle.o() { // from class: z8.b
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                g.m3(this.f15371a, (Integer) obj);
            }
        });
        this.E0.n0().g(b1(), new androidx.lifecycle.o() { // from class: z8.c
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                this.f15375a.F0.setUserInputEnabled(((Boolean) obj).booleanValue());
            }
        });
        this.E0.P().g(b1(), new androidx.lifecycle.o() { // from class: z8.d
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                this.f15384a.r3(((Integer) obj).intValue());
            }
        });
        this.E0.V().g(b1(), new androidx.lifecycle.o() { // from class: z8.e
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                this.f15388a.V2();
            }
        });
        this.E0.l0().g(b1(), new androidx.lifecycle.o() { // from class: z8.f
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                g gVar = this.f15412a;
                new a6.h.b(gVar.G()).i((ViewGroup) gVar.A2().getParent()).h((String) obj).a().s();
            }
        });
        this.E0.s0();
        if (w0() != null) {
            this.G0 = w0().getInt("gravity", 80);
            Bundle bundle2 = w0().getBundle("attachment");
            if (bundle2 != null && (aVarA = a9.f.a(bundle2)) != null) {
                this.F0.j(1, false);
                this.E0.A0(aVarA);
            }
            String string = w0().getString(Name.MARK);
            if (string != null) {
                this.F0.j(1, false);
                this.E0.t0(string);
            }
        }
        this.E0.v0();
    }

    @Override // androidx.fragment.app.k
    public Dialog Z2(Bundle bundle) {
        return new a(G(), Y2());
    }

    @Override // i8.a
    public int i3() {
        return 2;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        u3(configuration.orientation);
    }

    public final void r3(int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt("action", i10);
        L0().y1("result", bundle);
        V2();
    }

    public final void u3(int i10) {
        Window window;
        int iMax;
        Dialog dialogX2 = X2();
        if (dialogX2 == null || (window = dialogX2.getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        int iQ = com.tuyafeng.support.utils.x.q(G());
        int iS = com.tuyafeng.support.utils.x.s(G());
        int iMin = -1;
        if (i10 != 0 ? i10 != 2 : Resources.getSystem().getConfiguration().orientation != 2) {
            iMax = (Math.max(iS, iQ) / 9) * 5;
        } else {
            iMin = Math.min(com.tuyafeng.support.utils.x.h(G(), 440.0f), Math.max(iS, iQ) / 2);
            iMax = -1;
        }
        if (attributes.width == iMin && attributes.height == iMax) {
            return;
        }
        attributes.width = iMin;
        attributes.height = iMax;
        int i11 = this.G0;
        attributes.gravity = i11;
        attributes.dimAmount = 0.2f;
        attributes.windowAnimations = (i11 & 48) == 48 ? w7.v.f14328e : w7.v.f14327d;
        window.setAttributes(attributes);
    }

    @Override // i8.a, androidx.fragment.app.k, androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.E0 = (e0) new androidx.lifecycle.a0(this, la.s.n()).a(e0.class);
    }
}
