package ua;

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
import i6.i0;
import java.util.concurrent.Callable;
import sa.d1;
import x7.g0;
import z8.n0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class y extends k8.a {
    public c0 C0;
    public ViewPager2 D0;
    public b E0;
    public a F0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {
        void a(String str, String str2);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b extends FragmentStateAdapter {
        public b(FragmentManager fragmentManager, Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment J(int i10) {
            return i10 == 0 ? new t() : i10 == 1 ? new i() : new Fragment();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int g() {
            return 2;
        }
    }

    public static /* synthetic */ void l3(final y yVar, a6.q qVar) {
        yVar.getClass();
        int iC = qVar.c();
        if (iC == -1) {
            String strS = yVar.C0.s();
            String strA = qVar.a();
            if (yVar.F0 == null || strS == null || strA == null) {
                return;
            }
            yVar.X2();
            yVar.F0.a(strS, strA);
            return;
        }
        if (iC == 0 || iC == 1) {
            Fragment fragmentC = g6.i.c(yVar.l0());
            if (fragmentC != null) {
                yVar.X2();
                if (qVar.c() == 0) {
                    g6.i.h(fragmentC, sa.o.class, sa.o.q3(yVar.C0.v()));
                    return;
                } else {
                    g6.i.h(fragmentC, ta.u.class, ta.u.E3(yVar.C0.r()));
                    return;
                }
            }
            return;
        }
        if (iC == 2) {
            yVar.C0.o();
            return;
        }
        if (iC != 3) {
            if (iC != 4) {
                return;
            }
            ((autodispose2.r) x6.o.g(new Callable() { // from class: ua.w
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return Boolean.valueOf(this.f12930e.C0.p());
                }
            }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(yVar.d1()))).a(new a7.e() { // from class: ua.x
                @Override // a7.e
                public final void accept(Object obj) {
                    y.m3(this.f12931e, (Boolean) obj);
                }
            }, new g0());
        } else {
            Fragment fragmentC2 = g6.i.c(yVar.l0());
            if (fragmentC2 != null) {
                yVar.X2();
                g6.i.h(fragmentC2, d1.class, d1.W3(yVar.C0.r()));
            }
        }
    }

    public static /* synthetic */ void m3(y yVar, Boolean bool) {
        yVar.getClass();
        if (bool.booleanValue()) {
            yVar.X2();
            g6.n.s(yVar.I(), yVar.a1(x7.u.L4, yVar.C0.u() == null ? null : yVar.C0.u().g(), i0.f7006a.f(yVar.C0.v())));
        }
    }

    public static y n3(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        y yVar = new y();
        yVar.H2(bundle);
        return yVar;
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
        n0.b(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.D0.setUserInputEnabled(false);
        b bVar = new b(z0(), k0());
        this.E0 = bVar;
        this.D0.setAdapter(bVar);
        Bundle bundleY0 = y0();
        this.C0.C((bundleY0 == null || bundleY0.isEmpty()) ? null : bundleY0.getString("url"));
        this.C0.f12888i.g(d1(), new androidx.lifecycle.m() { // from class: ua.u
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                this.f12928a.D0.j(((Integer) obj).intValue(), true);
            }
        });
        this.C0.f12894o.g(d1(), new androidx.lifecycle.m() { // from class: ua.v
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                y.l3(this.f12929a, (a6.q) obj);
            }
        });
    }

    public void o3(a aVar) {
        this.F0 = aVar;
    }

    public void p3(String str) {
        this.C0.A(str);
    }

    @Override // k8.a, androidx.fragment.app.k, androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        this.C0 = (c0) new androidx.lifecycle.y(this).a(c0.class);
    }
}
