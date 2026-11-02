package b9;

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
import f6.h;
import org.simpleframework.xml.strategy.Name;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class g extends k8.a {
    public e0 C0;
    public ViewPager2 D0;
    public int E0 = 80;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends Dialog {
        public a(Context context, int i10) {
            super(context, i10);
        }

        @Override // android.app.Dialog
        public void onBackPressed() {
            g.this.C0.J(g.this.D0.getCurrentItem());
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b extends FragmentStateAdapter {

        /* renamed from: l, reason: collision with root package name */
        public final int[] f1990l;

        public b(FragmentManager fragmentManager, Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
            this.f1990l = new int[]{0, 1};
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment J(int i10) {
            int i11 = this.f1990l[i10];
            return i11 != 0 ? i11 != 1 ? new Fragment() : new a2() : new r2();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int g() {
            return this.f1990l.length;
        }
    }

    public static /* synthetic */ void m3(g gVar, Integer num) {
        if (num == null) {
            gVar.getClass();
        } else {
            gVar.D0.j(num.intValue(), true);
        }
    }

    public static g s3(String str, int i10) {
        return t3(str, null, i10);
    }

    public static g t3(String str, c9.a aVar, int i10) {
        g gVar = new g();
        Bundle bundle = new Bundle();
        if (str != null) {
            bundle.putString(Name.MARK, str);
        }
        Bundle bundleB = c9.f.b(aVar);
        if (bundleB != null) {
            bundle.putBundle("attachment", bundleB);
        }
        bundle.putInt("gravity", i10);
        gVar.H2(bundle);
        return gVar;
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewPager2 viewPager2 = (ViewPager2) new h6.a(new ViewPager2(I()), new FrameLayout.LayoutParams(-1, -1)).l();
        this.D0 = viewPager2;
        return viewPager2;
    }

    @Override // k8.a, androidx.fragment.app.Fragment
    public void T1() {
        super.T1();
        u3(I().getResources().getConfiguration().orientation);
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        c9.a aVarA;
        super.X1(view, bundle);
        g6.y.J(this.D0);
        this.D0.setAdapter(new b(z0(), k0()));
        z0().m(new FragmentManager.m() { // from class: b9.a
            @Override // androidx.fragment.app.FragmentManager.m
            public /* synthetic */ void a(androidx.activity.b bVar) {
                androidx.fragment.app.e0.c(this, bVar);
            }

            @Override // androidx.fragment.app.FragmentManager.m
            public /* synthetic */ void b(Fragment fragment, boolean z10) {
                androidx.fragment.app.e0.b(this, fragment, z10);
            }

            @Override // androidx.fragment.app.FragmentManager.m
            public /* synthetic */ void c(Fragment fragment, boolean z10) {
                androidx.fragment.app.e0.d(this, fragment, z10);
            }

            @Override // androidx.fragment.app.FragmentManager.m
            public /* synthetic */ void d() {
                androidx.fragment.app.e0.a(this);
            }

            @Override // androidx.fragment.app.FragmentManager.m
            public final void onBackStackChanged() {
                g gVar = this.f1922a;
                gVar.C0.D0(gVar.z0().u0() == 0);
            }
        });
        this.C0.d0().g(d1(), new androidx.lifecycle.m() { // from class: b9.b
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                g.m3(this.f1942a, (Integer) obj);
            }
        });
        this.C0.n0().g(d1(), new androidx.lifecycle.m() { // from class: b9.c
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                this.f1946a.D0.setUserInputEnabled(((Boolean) obj).booleanValue());
            }
        });
        this.C0.P().g(d1(), new androidx.lifecycle.m() { // from class: b9.d
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                this.f1955a.r3(((Integer) obj).intValue());
            }
        });
        this.C0.V().g(d1(), new androidx.lifecycle.m() { // from class: b9.e
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                this.f1959a.X2();
            }
        });
        this.C0.l0().g(d1(), new androidx.lifecycle.m() { // from class: b9.f
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                g gVar = this.f1983a;
                new h.b(gVar.I()).i((ViewGroup) gVar.C2().getParent()).h((String) obj).a().s();
            }
        });
        this.C0.s0();
        if (y0() != null) {
            this.E0 = y0().getInt("gravity", 80);
            Bundle bundle2 = y0().getBundle("attachment");
            if (bundle2 != null && (aVarA = c9.f.a(bundle2)) != null) {
                this.D0.j(1, false);
                this.C0.A0(aVarA);
            }
            String string = y0().getString(Name.MARK);
            if (string != null) {
                this.D0.j(1, false);
                this.C0.t0(string);
            }
        }
        this.C0.v0();
    }

    @Override // androidx.fragment.app.k
    public Dialog b3(Bundle bundle) {
        return new a(I(), a3());
    }

    @Override // k8.a
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
        N0().x1("result", bundle);
        X2();
    }

    public final void u3(int i10) {
        Window window;
        int iMax;
        Dialog dialogZ2 = Z2();
        if (dialogZ2 == null || (window = dialogZ2.getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        int iQ = g6.y.q(I());
        int iS = g6.y.s(I());
        int iMin = -1;
        if (i10 != 0 ? i10 != 2 : Resources.getSystem().getConfiguration().orientation != 2) {
            iMax = (Math.max(iS, iQ) / 9) * 5;
        } else {
            iMin = Math.min(g6.y.h(I(), 440.0f), Math.max(iS, iQ) / 2);
            iMax = -1;
        }
        if (attributes.width == iMin && attributes.height == iMax) {
            return;
        }
        attributes.width = iMin;
        attributes.height = iMax;
        int i11 = this.E0;
        attributes.gravity = i11;
        attributes.dimAmount = 0.2f;
        attributes.windowAnimations = (i11 & 48) == 48 ? x7.v.f14258e : x7.v.f14257d;
        window.setAttributes(attributes);
    }

    @Override // k8.a, androidx.fragment.app.k, androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        this.C0 = (e0) new androidx.lifecycle.y(this, pa.r.n()).a(e0.class);
    }
}
