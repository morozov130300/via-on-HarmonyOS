package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.l0;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.h;
import androidx.lifecycle.j;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Iterator;
import x.g;
import y.r;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentStateAdapter extends RecyclerView.Adapter implements androidx.viewpager2.adapter.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lifecycle f1537d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FragmentManager f1538e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FragmentMaxLifecycleEnforcer f1542i;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k.d f1539f = new k.d();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final k.d f1540g = new k.d();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final k.d f1541h = new k.d();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1543j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f1544k = false;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class FragmentMaxLifecycleEnforcer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ViewPager2.i f1550a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView.i f1551b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public h f1552c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ViewPager2 f1553d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f1554e = -1;

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class a extends ViewPager2.i {
            public a() {
            }

            @Override // androidx.viewpager2.widget.ViewPager2.i
            public void a(int i10) {
                FragmentMaxLifecycleEnforcer.this.d(false);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.i
            public void c(int i10) {
                FragmentMaxLifecycleEnforcer.this.d(false);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class b extends d {
            public b() {
                super(null);
            }

            @Override // androidx.viewpager2.adapter.FragmentStateAdapter.d, androidx.recyclerview.widget.RecyclerView.i
            public void a() {
                FragmentMaxLifecycleEnforcer.this.d(true);
            }
        }

        public FragmentMaxLifecycleEnforcer() {
        }

        public final ViewPager2 a(RecyclerView recyclerView) {
            ViewParent parent = recyclerView.getParent();
            if (parent instanceof ViewPager2) {
                return (ViewPager2) parent;
            }
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
        }

        public void b(RecyclerView recyclerView) {
            this.f1553d = a(recyclerView);
            a aVar = new a();
            this.f1550a = aVar;
            this.f1553d.g(aVar);
            b bVar = new b();
            this.f1551b = bVar;
            FragmentStateAdapter.this.E(bVar);
            h hVar = new h() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.3
                @Override // androidx.lifecycle.h
                public void e(j jVar, Lifecycle.Event event) {
                    FragmentMaxLifecycleEnforcer.this.d(false);
                }
            };
            this.f1552c = hVar;
            FragmentStateAdapter.this.f1537d.a(hVar);
        }

        public void c(RecyclerView recyclerView) {
            a(recyclerView).n(this.f1550a);
            FragmentStateAdapter.this.G(this.f1551b);
            FragmentStateAdapter.this.f1537d.c(this.f1552c);
            this.f1553d = null;
        }

        public void d(boolean z10) {
            int currentItem;
            Fragment fragment;
            if (FragmentStateAdapter.this.a0() || this.f1553d.getScrollState() != 0 || FragmentStateAdapter.this.f1539f.l() || FragmentStateAdapter.this.g() == 0 || (currentItem = this.f1553d.getCurrentItem()) >= FragmentStateAdapter.this.g()) {
                return;
            }
            long jH = FragmentStateAdapter.this.h(currentItem);
            if ((jH != this.f1554e || z10) && (fragment = (Fragment) FragmentStateAdapter.this.f1539f.i(jH)) != null && fragment.g1()) {
                this.f1554e = jH;
                l0 l0VarQ = FragmentStateAdapter.this.f1538e.q();
                Fragment fragment2 = null;
                for (int i10 = 0; i10 < FragmentStateAdapter.this.f1539f.q(); i10++) {
                    long jM = FragmentStateAdapter.this.f1539f.m(i10);
                    Fragment fragment3 = (Fragment) FragmentStateAdapter.this.f1539f.r(i10);
                    if (fragment3.g1()) {
                        if (jM != this.f1554e) {
                            l0VarQ.w(fragment3, Lifecycle.State.STARTED);
                        } else {
                            fragment2 = fragment3;
                        }
                        fragment3.I2(jM == this.f1554e);
                    }
                }
                if (fragment2 != null) {
                    l0VarQ.w(fragment2, Lifecycle.State.RESUMED);
                }
                if (l0VarQ.r()) {
                    return;
                }
                l0VarQ.k();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f1559a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ androidx.viewpager2.adapter.a f1560b;

        public a(FrameLayout frameLayout, androidx.viewpager2.adapter.a aVar) {
            this.f1559a = frameLayout;
            this.f1560b = aVar;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            if (this.f1559a.getParent() != null) {
                this.f1559a.removeOnLayoutChangeListener(this);
                FragmentStateAdapter.this.W(this.f1560b);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends FragmentManager.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f1562a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f1563b;

        public b(Fragment fragment, FrameLayout frameLayout) {
            this.f1562a = fragment;
            this.f1563b = frameLayout;
        }

        @Override // androidx.fragment.app.FragmentManager.k
        public void m(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
            if (fragment == this.f1562a) {
                fragmentManager.G1(this);
                FragmentStateAdapter.this.H(view, this.f1563b);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentStateAdapter fragmentStateAdapter = FragmentStateAdapter.this;
            fragmentStateAdapter.f1543j = false;
            fragmentStateAdapter.M();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class d extends RecyclerView.i {
        public d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public abstract void a();

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void d(int i10, int i11) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void h(int i10, int i11, Object obj) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void k(int i10, int i11) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void l(int i10, int i11, int i12) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void m(int i10, int i11) {
            a();
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    public FragmentStateAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        this.f1538e = fragmentManager;
        this.f1537d = lifecycle;
        super.F(true);
    }

    public static String K(String str, long j10) {
        return str + j10;
    }

    public static boolean O(String str, String str2) {
        return str.startsWith(str2) && str.length() > str2.length();
    }

    public static long V(String str, String str2) {
        return Long.parseLong(str.substring(str2.length()));
    }

    public void H(View view, FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (view.getParent() == frameLayout) {
            return;
        }
        if (frameLayout.getChildCount() > 0) {
            frameLayout.removeAllViews();
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        frameLayout.addView(view);
    }

    public boolean I(long j10) {
        return j10 >= 0 && j10 < ((long) g());
    }

    public abstract Fragment J(int i10);

    public final void L(int i10) {
        long jH = h(i10);
        if (this.f1539f.d(jH)) {
            return;
        }
        Fragment fragmentJ = J(i10);
        fragmentJ.H2((Fragment.SavedState) this.f1540g.i(jH));
        this.f1539f.n(jH, fragmentJ);
    }

    public void M() {
        if (!this.f1544k || a0()) {
            return;
        }
        k.b bVar = new k.b();
        for (int i10 = 0; i10 < this.f1539f.q(); i10++) {
            long jM = this.f1539f.m(i10);
            if (!I(jM)) {
                bVar.add(Long.valueOf(jM));
                this.f1541h.o(jM);
            }
        }
        if (!this.f1543j) {
            this.f1544k = false;
            for (int i11 = 0; i11 < this.f1539f.q(); i11++) {
                long jM2 = this.f1539f.m(i11);
                if (!N(jM2)) {
                    bVar.add(Long.valueOf(jM2));
                }
            }
        }
        Iterator it = bVar.iterator();
        while (it.hasNext()) {
            X(((Long) it.next()).longValue());
        }
    }

    public final boolean N(long j10) {
        View viewA1;
        if (this.f1541h.d(j10)) {
            return true;
        }
        Fragment fragment = (Fragment) this.f1539f.i(j10);
        return (fragment == null || (viewA1 = fragment.a1()) == null || viewA1.getParent() == null) ? false : true;
    }

    public final Long P(int i10) {
        Long lValueOf = null;
        for (int i11 = 0; i11 < this.f1541h.q(); i11++) {
            if (((Integer) this.f1541h.r(i11)).intValue() == i10) {
                if (lValueOf != null) {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
                lValueOf = Long.valueOf(this.f1541h.m(i11));
            }
        }
        return lValueOf;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public final void w(androidx.viewpager2.adapter.a aVar, int i10) {
        long jM = aVar.m();
        int id = aVar.P().getId();
        Long lP = P(id);
        if (lP != null && lP.longValue() != jM) {
            X(lP.longValue());
            this.f1541h.o(lP.longValue());
        }
        this.f1541h.n(jM, Integer.valueOf(id));
        L(i10);
        FrameLayout frameLayoutP = aVar.P();
        if (r.F(frameLayoutP)) {
            if (frameLayoutP.getParent() != null) {
                throw new IllegalStateException("Design assumption violated.");
            }
            frameLayoutP.addOnLayoutChangeListener(new a(frameLayoutP, aVar));
        }
        M();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public final androidx.viewpager2.adapter.a y(ViewGroup viewGroup, int i10) {
        return androidx.viewpager2.adapter.a.O(viewGroup);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public final boolean A(androidx.viewpager2.adapter.a aVar) {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public final void B(androidx.viewpager2.adapter.a aVar) {
        W(aVar);
        M();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final void D(androidx.viewpager2.adapter.a aVar) {
        Long lP = P(aVar.P().getId());
        if (lP != null) {
            X(lP.longValue());
            this.f1541h.o(lP.longValue());
        }
    }

    public void W(final androidx.viewpager2.adapter.a aVar) {
        Fragment fragment = (Fragment) this.f1539f.i(aVar.m());
        if (fragment == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        FrameLayout frameLayoutP = aVar.P();
        View viewA1 = fragment.a1();
        if (!fragment.g1() && viewA1 != null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (fragment.g1() && viewA1 == null) {
            Z(fragment, frameLayoutP);
            return;
        }
        if (fragment.g1() && viewA1.getParent() != null) {
            if (viewA1.getParent() != frameLayoutP) {
                H(viewA1, frameLayoutP);
                return;
            }
            return;
        }
        if (fragment.g1()) {
            H(viewA1, frameLayoutP);
            return;
        }
        if (a0()) {
            if (this.f1538e.N0()) {
                return;
            }
            this.f1537d.a(new h() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.2
                @Override // androidx.lifecycle.h
                public void e(j jVar, Lifecycle.Event event) {
                    if (FragmentStateAdapter.this.a0()) {
                        return;
                    }
                    jVar.h0().c(this);
                    if (r.F(aVar.P())) {
                        FragmentStateAdapter.this.W(aVar);
                    }
                }
            });
            return;
        }
        Z(fragment, frameLayoutP);
        this.f1538e.q().e(fragment, "f" + aVar.m()).w(fragment, Lifecycle.State.STARTED).k();
        this.f1542i.d(false);
    }

    public final void X(long j10) {
        ViewParent parent;
        Fragment fragment = (Fragment) this.f1539f.i(j10);
        if (fragment == null) {
            return;
        }
        if (fragment.a1() != null && (parent = fragment.a1().getParent()) != null) {
            ((FrameLayout) parent).removeAllViews();
        }
        if (!I(j10)) {
            this.f1540g.o(j10);
        }
        if (!fragment.g1()) {
            this.f1539f.o(j10);
            return;
        }
        if (a0()) {
            this.f1544k = true;
            return;
        }
        if (fragment.g1() && I(j10)) {
            this.f1540g.n(j10, this.f1538e.v1(fragment));
        }
        this.f1538e.q().s(fragment).k();
        this.f1539f.o(j10);
    }

    public final void Y() {
        final Handler handler = new Handler(Looper.getMainLooper());
        final c cVar = new c();
        this.f1537d.a(new h() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.5
            @Override // androidx.lifecycle.h
            public void e(j jVar, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    handler.removeCallbacks(cVar);
                    jVar.h0().c(this);
                }
            }
        });
        handler.postDelayed(cVar, 10000L);
    }

    public final void Z(Fragment fragment, FrameLayout frameLayout) {
        this.f1538e.m1(new b(fragment, frameLayout), false);
    }

    @Override // androidx.viewpager2.adapter.b
    public final void a(Parcelable parcelable) {
        if (!this.f1540g.l() || !this.f1539f.l()) {
            throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
        }
        Bundle bundle = (Bundle) parcelable;
        if (bundle.getClassLoader() == null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        for (String str : bundle.keySet()) {
            if (O(str, "f#")) {
                this.f1539f.n(V(str, "f#"), this.f1538e.x0(bundle, str));
            } else {
                if (!O(str, "s#")) {
                    throw new IllegalArgumentException("Unexpected key in savedState: " + str);
                }
                long jV = V(str, "s#");
                Fragment.SavedState savedState = (Fragment.SavedState) bundle.getParcelable(str);
                if (I(jV)) {
                    this.f1540g.n(jV, savedState);
                }
            }
        }
        if (this.f1539f.l()) {
            return;
        }
        this.f1544k = true;
        this.f1543j = true;
        M();
        Y();
    }

    public boolean a0() {
        return this.f1538e.V0();
    }

    @Override // androidx.viewpager2.adapter.b
    public final Parcelable b() {
        Bundle bundle = new Bundle(this.f1539f.q() + this.f1540g.q());
        for (int i10 = 0; i10 < this.f1539f.q(); i10++) {
            long jM = this.f1539f.m(i10);
            Fragment fragment = (Fragment) this.f1539f.i(jM);
            if (fragment != null && fragment.g1()) {
                this.f1538e.l1(bundle, K("f#", jM), fragment);
            }
        }
        for (int i11 = 0; i11 < this.f1540g.q(); i11++) {
            long jM2 = this.f1540g.m(i11);
            if (I(jM2)) {
                bundle.putParcelable(K("s#", jM2), (Parcelable) this.f1540g.i(jM2));
            }
        }
        return bundle;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long h(int i10) {
        return i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void v(RecyclerView recyclerView) {
        g.a(this.f1542i == null);
        FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer = new FragmentMaxLifecycleEnforcer();
        this.f1542i = fragmentMaxLifecycleEnforcer;
        fragmentMaxLifecycleEnforcer.b(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void z(RecyclerView recyclerView) {
        this.f1542i.c(recyclerView);
        this.f1542i = null;
    }
}
