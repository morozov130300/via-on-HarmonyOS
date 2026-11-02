package b8;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import org.simpleframework.xml.strategy.Name;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class n extends k8.a {
    public y C0;
    public ViewPager2 D0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a extends FragmentStateAdapter {

        /* renamed from: l, reason: collision with root package name */
        public final int[] f1878l;

        public a(FragmentManager fragmentManager, Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
            this.f1878l = new int[]{0, 1};
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment J(int i10) {
            return this.f1878l[i10] != 0 ? new n0() : new h();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int g() {
            return this.f1878l.length;
        }
    }

    public static /* synthetic */ void j3(n nVar, Void r62) {
        o9.b bVarL = nVar.C0.L();
        g6.n.s(nVar.I(), nVar.a1(x7.u.f14062l7, bVarL.e()));
        Bundle bundle = new Bundle();
        bundle.putString(Name.MARK, bVarL.c());
        bundle.putInt("position", nVar.C0.G());
        nVar.l0().L().x1("bookmarkDialogResult2", bundle);
    }

    public static /* synthetic */ void k3(n nVar, Void r32) {
        g6.n.q(nVar.I(), x7.u.R7);
        o9.b bVarL = nVar.C0.L();
        Bundle bundle = new Bundle();
        bundle.putString(Name.MARK, bVarL.c());
        bundle.putInt("position", nVar.C0.G());
        nVar.l0().L().x1("bookmarkDialogResult2", bundle);
    }

    public static n o3(String str) {
        return p3(str, -1);
    }

    public static n p3(String str, int i10) {
        return r3(str, null, null, i10);
    }

    public static n q3(String str, String str2) {
        return r3(null, str, str2, -1);
    }

    public static n r3(String str, String str2, String str3, int i10) {
        Bundle bundle = new Bundle();
        n nVar = new n();
        if (str != null) {
            bundle.putString(Name.MARK, str);
        }
        if (str3 != null) {
            bundle.putString("title", str3);
        }
        if (str2 != null) {
            bundle.putString("url", str2);
        }
        bundle.putInt("position", i10);
        nVar.H2(bundle);
        return nVar;
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
        z8.n0.b(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.D0.setUserInputEnabled(false);
        this.D0.setAdapter(new a(z0(), k0()));
        this.C0.F().g(d1(), new androidx.lifecycle.m() { // from class: b8.i
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                this.f1866a.D0.j(((Integer) obj).intValue(), true);
            }
        });
        this.C0.D().g(d1(), new androidx.lifecycle.m() { // from class: b8.j
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                this.f1868a.X2();
            }
        });
        this.C0.H().g(d1(), new androidx.lifecycle.m() { // from class: b8.k
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                n.k3(this.f1871a, (Void) obj);
            }
        });
        this.C0.C().g(d1(), new androidx.lifecycle.m() { // from class: b8.l
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                n.j3(this.f1873a, (Void) obj);
            }
        });
        this.C0.E().g(d1(), new androidx.lifecycle.m() { // from class: b8.m
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                this.f1875a.s3(((Integer) obj).intValue());
            }
        });
    }

    public final void s3(int i10) {
        ViewPager2 viewPager2 = this.D0;
        if (viewPager2 == null || i10 <= 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewPager2.getLayoutParams();
        if (layoutParams.height == i10) {
            return;
        }
        layoutParams.height = i10;
        this.D0.setLayoutParams(layoutParams);
    }

    @Override // k8.a, androidx.fragment.app.k, androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        this.C0 = (y) new androidx.lifecycle.y(this, pa.r.n()).a(y.class);
        this.C0.Q(y0() != null ? y0().getInt("position", 0) : 0);
        this.C0.J(y0() == null ? null : y0().getString(Name.MARK), y0() == null ? null : y0().getString("url"), y0() != null ? y0().getString("title") : null);
    }
}
