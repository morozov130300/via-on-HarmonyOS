package ta;

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
import c6.a2;
import com.tuyafeng.support.utils.FragmentUtils;
import java.util.concurrent.Callable;
import oa.f1;
import w7.e0;
import x8.n0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class y extends i8.a {
    public c0 E0;
    public ViewPager2 F0;
    public b G0;
    public a H0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        void a(String str, String str2);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b extends FragmentStateAdapter {
        public b(FragmentManager fragmentManager, Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment J(int i10) {
            if (i10 == 0) {
                return new t();
            }
            return i10 == 1 ? new i() : new Fragment();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int g() {
            return 2;
        }
    }

    public static /* synthetic */ void l3(final y yVar, v5.q qVar) {
        yVar.getClass();
        int iC = qVar.c();
        if (iC == -1) {
            String strS = yVar.E0.s();
            String strA = qVar.a();
            if (yVar.H0 == null || strS == null || strA == null) {
                return;
            }
            yVar.V2();
            yVar.H0.a(strS, strA);
            return;
        }
        if (iC == 0 || iC == 1) {
            Fragment fragmentD = FragmentUtils.d(yVar.i0());
            if (fragmentD != null) {
                yVar.V2();
                if (qVar.c() == 0) {
                    FragmentUtils.j(fragmentD, oa.q.class, oa.q.q3(yVar.E0.v()));
                    return;
                } else {
                    FragmentUtils.j(fragmentD, sa.y.class, sa.y.D3(yVar.E0.r()));
                    return;
                }
            }
            return;
        }
        if (iC == 2) {
            yVar.E0.o();
            return;
        }
        if (iC != 3) {
            if (iC != 4) {
                return;
            }
            ((autodispose2.r) r6.q.f(new Callable() { // from class: ta.w
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return Boolean.valueOf(this.f12650c.E0.p());
                }
            }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(yVar.b1()))).a(new u6.f() { // from class: ta.x
                @Override // u6.f
                public final void accept(Object obj) {
                    y.m3(this.f12651c, (Boolean) obj);
                }
            }, new e0());
        } else {
            Fragment fragmentD2 = FragmentUtils.d(yVar.i0());
            if (fragmentD2 != null) {
                yVar.V2();
                FragmentUtils.j(fragmentD2, f1.class, f1.V3(yVar.E0.r()));
            }
        }
    }

    public static /* synthetic */ void m3(y yVar, Boolean bool) {
        yVar.getClass();
        if (bool.booleanValue()) {
            yVar.V2();
            com.tuyafeng.support.utils.n.s(yVar.G(), yVar.Y0(w7.u.Y4, yVar.E0.u() == null ? null : yVar.E0.u().g(), a2.f1958a.g(yVar.E0.v())));
        }
    }

    public static y n3(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        y yVar = new y();
        yVar.F2(bundle);
        return yVar;
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
        n0.b(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.F0.setUserInputEnabled(false);
        b bVar = new b(x0(), h0());
        this.G0 = bVar;
        this.F0.setAdapter(bVar);
        Bundle bundleW0 = w0();
        this.E0.C((bundleW0 == null || bundleW0.isEmpty()) ? null : bundleW0.getString("url"));
        this.E0.f12608i.g(b1(), new androidx.lifecycle.o() { // from class: ta.u
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                this.f12648a.F0.j(((Integer) obj).intValue(), true);
            }
        });
        this.E0.f12614o.g(b1(), new androidx.lifecycle.o() { // from class: ta.v
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                y.l3(this.f12649a, (v5.q) obj);
            }
        });
    }

    public void o3(a aVar) {
        this.H0 = aVar;
    }

    public void p3(String str) {
        this.E0.A(str);
    }

    @Override // i8.a, androidx.fragment.app.k, androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.E0 = (c0) new androidx.lifecycle.a0(this).a(c0.class);
    }
}
