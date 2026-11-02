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
import androidx.lifecycle.f;
import androidx.lifecycle.h;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Iterator;
import w.g;
import x.r;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class FragmentStateAdapter extends RecyclerView.Adapter implements androidx.viewpager2.adapter.b {

    /* renamed from: d, reason: collision with root package name */
    public final Lifecycle f1636d;

    /* renamed from: e, reason: collision with root package name */
    public final FragmentManager f1637e;

    /* renamed from: i, reason: collision with root package name */
    public FragmentMaxLifecycleEnforcer f1641i;

    /* renamed from: f, reason: collision with root package name */
    public final k.d f1638f = new k.d();

    /* renamed from: g, reason: collision with root package name */
    public final k.d f1639g = new k.d();

    /* renamed from: h, reason: collision with root package name */
    public final k.d f1640h = new k.d();

    /* renamed from: j, reason: collision with root package name */
    public boolean f1642j = false;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1643k = false;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class FragmentMaxLifecycleEnforcer {

        /* renamed from: a, reason: collision with root package name */
        public ViewPager2.i f1649a;

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView.i f1650b;

        /* renamed from: c, reason: collision with root package name */
        public f f1651c;

        /* renamed from: d, reason: collision with root package name */
        public ViewPager2 f1652d;

        /* renamed from: e, reason: collision with root package name */
        public long f1653e = -1;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
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

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
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
            this.f1652d = a(recyclerView);
            a aVar = new a();
            this.f1649a = aVar;
            this.f1652d.g(aVar);
            b bVar = new b();
            this.f1650b = bVar;
            FragmentStateAdapter.this.E(bVar);
            f fVar = new f() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.3
                @Override // androidx.lifecycle.f
                public void a(h hVar, Lifecycle.Event event) {
                    FragmentMaxLifecycleEnforcer.this.d(false);
                }
            };
            this.f1651c = fVar;
            FragmentStateAdapter.this.f1636d.a(fVar);
        }

        public void c(RecyclerView recyclerView) {
            a(recyclerView).n(this.f1649a);
            FragmentStateAdapter.this.G(this.f1650b);
            FragmentStateAdapter.this.f1636d.c(this.f1651c);
            this.f1652d = null;
        }

        public void d(boolean z10) {
            int currentItem;
            Fragment fragment;
            if (FragmentStateAdapter.this.a0() || this.f1652d.getScrollState() != 0 || FragmentStateAdapter.this.f1638f.l() || FragmentStateAdapter.this.g() == 0 || (currentItem = this.f1652d.getCurrentItem()) >= FragmentStateAdapter.this.g()) {
                return;
            }
            long jH = FragmentStateAdapter.this.h(currentItem);
            if ((jH != this.f1653e || z10) && (fragment = (Fragment) FragmentStateAdapter.this.f1638f.e(jH)) != null && fragment.i1()) {
                this.f1653e = jH;
                l0 l0VarQ = FragmentStateAdapter.this.f1637e.q();
                Fragment fragment2 = null;
                for (int i10 = 0; i10 < FragmentStateAdapter.this.f1638f.q(); i10++) {
                    long jM = FragmentStateAdapter.this.f1638f.m(i10);
                    Fragment fragment3 = (Fragment) FragmentStateAdapter.this.f1638f.r(i10);
                    if (fragment3.i1()) {
                        if (jM != this.f1653e) {
                            l0VarQ.w(fragment3, Lifecycle.State.STARTED);
                        } else {
                            fragment2 = fragment3;
                        }
                        fragment3.K2(jM == this.f1653e);
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

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements View.OnLayoutChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f1658a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ androidx.viewpager2.adapter.a f1659b;

        public a(FrameLayout frameLayout, androidx.viewpager2.adapter.a aVar) {
            this.f1658a = frameLayout;
            this.f1659b = aVar;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            if (this.f1658a.getParent() != null) {
                this.f1658a.removeOnLayoutChangeListener(this);
                FragmentStateAdapter.this.W(this.f1659b);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b extends FragmentManager.k {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f1661a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f1662b;

        public b(Fragment fragment, FrameLayout frameLayout) {
            this.f1661a = fragment;
            this.f1662b = frameLayout;
        }

        @Override // androidx.fragment.app.FragmentManager.k
        public void m(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
            if (fragment == this.f1661a) {
                fragmentManager.F1(this);
                FragmentStateAdapter.this.H(view, this.f1662b);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentStateAdapter fragmentStateAdapter = FragmentStateAdapter.this;
            fragmentStateAdapter.f1642j = false;
            fragmentStateAdapter.M();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class d extends RecyclerView.i {
        public d() {
        }

        public /* synthetic */ d(a aVar) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public abstract void a();

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void b(int i10, int i11, Object obj) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void c(int i10, int i11) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void d(int i10, int i11, int i12) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void e(int i10, int i11) {
            a();
        }
    }

    public FragmentStateAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        this.f1637e = fragmentManager;
        this.f1636d = lifecycle;
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
        if (this.f1638f.c(jH)) {
            return;
        }
        Fragment fragmentJ = J(i10);
        fragmentJ.J2((Fragment.SavedState) this.f1639g.e(jH));
        this.f1638f.n(jH, fragmentJ);
    }

    public void M() {
        if (!this.f1643k || a0()) {
            return;
        }
        k.b bVar = new k.b();
        for (int i10 = 0; i10 < this.f1638f.q(); i10++) {
            long jM = this.f1638f.m(i10);
            if (!I(jM)) {
                bVar.add(Long.valueOf(jM));
                this.f1640h.o(jM);
            }
        }
        if (!this.f1642j) {
            this.f1643k = false;
            for (int i11 = 0; i11 < this.f1638f.q(); i11++) {
                long jM2 = this.f1638f.m(i11);
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
        View viewC1;
        if (this.f1640h.c(j10)) {
            return true;
        }
        Fragment fragment = (Fragment) this.f1638f.e(j10);
        return (fragment == null || (viewC1 = fragment.c1()) == null || viewC1.getParent() == null) ? false : true;
    }

    public final Long P(int i10) {
        Long lValueOf = null;
        for (int i11 = 0; i11 < this.f1640h.q(); i11++) {
            if (((Integer) this.f1640h.r(i11)).intValue() == i10) {
                if (lValueOf != null) {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
                lValueOf = Long.valueOf(this.f1640h.m(i11));
            }
        }
        return lValueOf;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public final void w(androidx.viewpager2.adapter.a aVar, int i10) {
        long jM = aVar.m();
        int id = aVar.P().getId();
        Long lP = P(id);
        if (lP != null && lP.longValue() != jM) {
            X(lP.longValue());
            this.f1640h.o(lP.longValue());
        }
        this.f1640h.n(jM, Integer.valueOf(id));
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
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public final androidx.viewpager2.adapter.a y(ViewGroup viewGroup, int i10) {
        return androidx.viewpager2.adapter.a.O(viewGroup);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public final boolean A(androidx.viewpager2.adapter.a aVar) {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public final void B(androidx.viewpager2.adapter.a aVar) {
        W(aVar);
        M();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public final void D(androidx.viewpager2.adapter.a aVar) {
        Long lP = P(aVar.P().getId());
        if (lP != null) {
            X(lP.longValue());
            this.f1640h.o(lP.longValue());
        }
    }

    public void W(final androidx.viewpager2.adapter.a aVar) {
        Fragment fragment = (Fragment) this.f1638f.e(aVar.m());
        if (fragment == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        FrameLayout frameLayoutP = aVar.P();
        View viewC1 = fragment.c1();
        if (!fragment.i1() && viewC1 != null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (fragment.i1() && viewC1 == null) {
            Z(fragment, frameLayoutP);
            return;
        }
        if (fragment.i1() && viewC1.getParent() != null) {
            if (viewC1.getParent() != frameLayoutP) {
                H(viewC1, frameLayoutP);
                return;
            }
            return;
        }
        if (fragment.i1()) {
            H(viewC1, frameLayoutP);
            return;
        }
        if (a0()) {
            if (this.f1637e.N0()) {
                return;
            }
            this.f1636d.a(new f() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.2
                @Override // androidx.lifecycle.f
                public void a(h hVar, Lifecycle.Event event) {
                    if (FragmentStateAdapter.this.a0()) {
                        return;
                    }
                    hVar.k0().c(this);
                    if (r.F(aVar.P())) {
                        FragmentStateAdapter.this.W(aVar);
                    }
                }
            });
            return;
        }
        Z(fragment, frameLayoutP);
        this.f1637e.q().e(fragment, "f" + aVar.m()).w(fragment, Lifecycle.State.STARTED).k();
        this.f1641i.d(false);
    }

    public final void X(long j10) {
        ViewParent parent;
        Fragment fragment = (Fragment) this.f1638f.e(j10);
        if (fragment == null) {
            return;
        }
        if (fragment.c1() != null && (parent = fragment.c1().getParent()) != null) {
            ((FrameLayout) parent).removeAllViews();
        }
        if (!I(j10)) {
            this.f1639g.o(j10);
        }
        if (!fragment.i1()) {
            this.f1638f.o(j10);
            return;
        }
        if (a0()) {
            this.f1643k = true;
            return;
        }
        if (fragment.i1() && I(j10)) {
            this.f1639g.n(j10, this.f1637e.u1(fragment));
        }
        this.f1637e.q().s(fragment).k();
        this.f1638f.o(j10);
    }

    public final void Y() {
        final Handler handler = new Handler(Looper.getMainLooper());
        final c cVar = new c();
        this.f1636d.a(new f() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.5
            @Override // androidx.lifecycle.f
            public void a(h hVar, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    handler.removeCallbacks(cVar);
                    hVar.k0().c(this);
                }
            }
        });
        handler.postDelayed(cVar, 10000L);
    }

    public final void Z(Fragment fragment, FrameLayout frameLayout) {
        this.f1637e.m1(new b(fragment, frameLayout), false);
    }

    @Override // androidx.viewpager2.adapter.b
    public final void a(Parcelable parcelable) {
        if (!this.f1639g.l() || !this.f1638f.l()) {
            throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
        }
        Bundle bundle = (Bundle) parcelable;
        if (bundle.getClassLoader() == null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        for (String str : bundle.keySet()) {
            if (O(str, "f#")) {
                this.f1638f.n(V(str, "f#"), this.f1637e.x0(bundle, str));
            } else {
                if (!O(str, "s#")) {
                    throw new IllegalArgumentException("Unexpected key in savedState: " + str);
                }
                long jV = V(str, "s#");
                Fragment.SavedState savedState = (Fragment.SavedState) bundle.getParcelable(str);
                if (I(jV)) {
                    this.f1639g.n(jV, savedState);
                }
            }
        }
        if (this.f1638f.l()) {
            return;
        }
        this.f1643k = true;
        this.f1642j = true;
        M();
        Y();
    }

    public boolean a0() {
        return this.f1637e.V0();
    }

    @Override // androidx.viewpager2.adapter.b
    public final Parcelable b() {
        Bundle bundle = new Bundle(this.f1638f.q() + this.f1639g.q());
        for (int i10 = 0; i10 < this.f1638f.q(); i10++) {
            long jM = this.f1638f.m(i10);
            Fragment fragment = (Fragment) this.f1638f.e(jM);
            if (fragment != null && fragment.i1()) {
                this.f1637e.l1(bundle, K("f#", jM), fragment);
            }
        }
        for (int i11 = 0; i11 < this.f1639g.q(); i11++) {
            long jM2 = this.f1639g.m(i11);
            if (I(jM2)) {
                bundle.putParcelable(K("s#", jM2), (Parcelable) this.f1639g.e(jM2));
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
        g.a(this.f1641i == null);
        FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer = new FragmentMaxLifecycleEnforcer();
        this.f1641i = fragmentMaxLifecycleEnforcer;
        fragmentMaxLifecycleEnforcer.b(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void z(RecyclerView recyclerView) {
        this.f1641i.c(recyclerView);
        this.f1641i = null;
    }
}
