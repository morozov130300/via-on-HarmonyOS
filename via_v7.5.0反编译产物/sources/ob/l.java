package ob;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.a0;
import androidx.lifecycle.o;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import x8.n0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class l extends i8.a {
    public ViewPager2 E0;
    public m F0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends FragmentStateAdapter {
        public a(FragmentManager fragmentManager, Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment J(int i10) {
            if (i10 != 0) {
                return i10 != 1 ? new Fragment() : new d();
            }
            return new i();
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
                lVar.i0().K().y1("syncingDialogResult", bundleB);
            }
        }
        lVar.V2();
    }

    public static l l3(qb.f fVar) {
        l lVar = new l();
        lVar.F2(qb.g.b(fVar));
        return lVar;
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewPager2 viewPager2 = (ViewPager2) new b6.a(new ViewPager2(G()), new FrameLayout.LayoutParams(-1, -1)).l();
        this.E0 = viewPager2;
        return viewPager2;
    }

    @Override // i8.a, androidx.fragment.app.Fragment
    public void R1() {
        super.R1();
        n0.b(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.F0.u(qb.g.a(w0()));
        this.E0.setUserInputEnabled(false);
        this.E0.setAdapter(new a(x0(), h0()));
        this.F0.o().g(this, new o() { // from class: ob.j
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                this.f11100a.E0.j(((Integer) obj).intValue(), true);
            }
        });
        this.F0.q().g(this, new o() { // from class: ob.k
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                l.k3(this.f11101a, (qb.f) obj);
            }
        });
    }

    @Override // i8.a
    public int i3() {
        return 2;
    }

    @Override // i8.a, androidx.fragment.app.k, androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.F0 = (m) new a0(this).a(m.class);
    }
}
