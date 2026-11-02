package ob;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.y;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import z8.n0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class l extends k8.a {
    public ViewPager2 C0;
    public m D0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends FragmentStateAdapter {
        public a(FragmentManager fragmentManager, Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment J(int i10) {
            return i10 != 0 ? i10 != 1 ? new Fragment() : new d() : new i();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int g() {
            return 2;
        }
    }

    public static /* synthetic */ void k3(l lVar, qb.f fVar) {
        if (fVar != null) {
            lVar.getClass();
            Bundle bundleB = qb.g.b(fVar);
            if (bundleB != null) {
                lVar.l0().L().x1("syncingDialogResult", bundleB);
            }
        }
        lVar.X2();
    }

    public static l l3(qb.f fVar) {
        l lVar = new l();
        lVar.H2(qb.g.b(fVar));
        return lVar;
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewPager2 viewPager2 = (ViewPager2) new h6.a(new ViewPager2(I()), new FrameLayout.LayoutParams(-1, -1)).l();
        this.C0 = viewPager2;
        return viewPager2;
    }

    @Override // k8.a, androidx.fragment.app.Fragment
    public void T1() {
        super.T1();
        n0.b(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.D0.u(qb.g.a(y0()));
        this.C0.setUserInputEnabled(false);
        this.C0.setAdapter(new a(z0(), k0()));
        this.D0.o().g(this, new androidx.lifecycle.m() { // from class: ob.j
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                this.f10514a.C0.j(((Integer) obj).intValue(), true);
            }
        });
        this.D0.q().g(this, new androidx.lifecycle.m() { // from class: ob.k
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                l.k3(this.f10515a, (qb.f) obj);
            }
        });
    }

    @Override // k8.a
    public int i3() {
        return 2;
    }

    @Override // k8.a, androidx.fragment.app.k, androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        this.D0 = (m) new y(this).a(m.class);
    }
}
