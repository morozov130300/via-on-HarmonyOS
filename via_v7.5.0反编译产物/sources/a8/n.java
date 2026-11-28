package a8;

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

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class n extends i8.a {
    public a0 E0;
    public ViewPager2 F0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a extends FragmentStateAdapter {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int[] f160l;

        public a(FragmentManager fragmentManager, Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
            this.f160l = new int[]{0, 1};
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment J(int i10) {
            return this.f160l[i10] != 0 ? new s0() : new h();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int g() {
            return this.f160l.length;
        }
    }

    public static /* synthetic */ void j3(n nVar, Void r10) {
        m9.b bVarR = nVar.E0.R();
        com.tuyafeng.support.utils.n.s(nVar.G(), nVar.Y0(w7.u.f14293x7, bVarR.e()));
        Bundle bundle = new Bundle();
        bundle.putString(Name.MARK, bVarR.c());
        bundle.putInt("position", nVar.E0.J());
        nVar.i0().K().y1("bookmarkDialogResult2", bundle);
    }

    public static /* synthetic */ void k3(n nVar, Void r10) {
        com.tuyafeng.support.utils.n.q(nVar.G(), w7.u.f14017d8);
        m9.b bVarR = nVar.E0.R();
        Bundle bundle = new Bundle();
        bundle.putString(Name.MARK, bVarR.c());
        bundle.putInt("position", nVar.E0.J());
        nVar.i0().K().y1("bookmarkDialogResult2", bundle);
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
        nVar.F2(bundle);
        return nVar;
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
        x8.n0.b(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.F0.setUserInputEnabled(false);
        this.F0.setAdapter(new a(x0(), h0()));
        this.E0.I().g(b1(), new androidx.lifecycle.o() { // from class: a8.i
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                this.f150a.F0.j(((Integer) obj).intValue(), true);
            }
        });
        this.E0.G().g(b1(), new androidx.lifecycle.o() { // from class: a8.j
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                this.f152a.V2();
            }
        });
        this.E0.K().g(b1(), new androidx.lifecycle.o() { // from class: a8.k
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                n.k3(this.f154a, (Void) obj);
            }
        });
        this.E0.F().g(b1(), new androidx.lifecycle.o() { // from class: a8.l
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                n.j3(this.f156a, (Void) obj);
            }
        });
        this.E0.H().g(b1(), new androidx.lifecycle.o() { // from class: a8.m
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                this.f158a.s3(((Integer) obj).intValue());
            }
        });
    }

    public final void s3(int i10) {
        ViewPager2 viewPager2 = this.F0;
        if (viewPager2 == null || i10 <= 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewPager2.getLayoutParams();
        if (layoutParams.height == i10) {
            return;
        }
        layoutParams.height = i10;
        this.F0.setLayoutParams(layoutParams);
    }

    @Override // i8.a, androidx.fragment.app.k, androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.E0 = (a0) new androidx.lifecycle.a0(this, la.s.n()).a(a0.class);
        this.E0.X(w0() != null ? w0().getInt("position", 0) : 0);
        this.E0.O(w0() == null ? null : w0().getString(Name.MARK), w0() == null ? null : w0().getString("url"), w0() != null ? w0().getString("title") : null);
    }
}
