package androidx.viewpager2.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.r;
import z.d0;
import z.i0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class ViewPager2 extends ViewGroup {
    public static boolean E = true;
    public boolean A;
    public boolean B;
    public int C;
    public e D;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f1566c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f1567e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public androidx.viewpager2.widget.b f1568m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f1569n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f1570o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public RecyclerView.i f1571p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public LinearLayoutManager f1572q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f1573r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Parcelable f1574s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public RecyclerView f1575t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public r f1576u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public androidx.viewpager2.widget.e f1577v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public androidx.viewpager2.widget.b f1578w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public androidx.viewpager2.widget.c f1579x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public androidx.viewpager2.widget.d f1580y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public RecyclerView.l f1581z;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends g {
        public a() {
            super(null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.g, androidx.recyclerview.widget.RecyclerView.i
        public void a() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.f1570o = true;
            viewPager2.f1577v.l();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends i {
        public b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void a(int i10) {
            if (i10 == 0) {
                ViewPager2.this.o();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void c(int i10) {
            ViewPager2 viewPager2 = ViewPager2.this;
            if (viewPager2.f1569n != i10) {
                viewPager2.f1569n = i10;
                viewPager2.D.q();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c extends i {
        public c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void c(int i10) {
            ViewPager2.this.clearFocus();
            if (ViewPager2.this.hasFocus()) {
                ViewPager2.this.f1575t.requestFocus(2);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public abstract class e {
        public e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int i10) {
            return false;
        }

        public boolean c(int i10, Bundle bundle) {
            return false;
        }

        public boolean d() {
            return false;
        }

        public String g() {
            throw new IllegalStateException("Not implemented.");
        }

        public boolean k(int i10) {
            throw new IllegalStateException("Not implemented.");
        }

        public boolean l(int i10, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        public CharSequence n() {
            throw new IllegalStateException("Not implemented.");
        }

        public /* synthetic */ e(ViewPager2 viewPager2, a aVar) {
            this();
        }

        public void e(RecyclerView.Adapter adapter) {
        }

        public void f(RecyclerView.Adapter adapter) {
        }

        public void i(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        public void j(d0 d0Var) {
        }

        public void m() {
        }

        public void o(AccessibilityEvent accessibilityEvent) {
        }

        public void p() {
        }

        public void q() {
        }

        public void r() {
        }

        public void s() {
        }

        public void h(androidx.viewpager2.widget.b bVar, RecyclerView recyclerView) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class f extends e {
        public f() {
            super(ViewPager2.this, null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean b(int i10) {
            return (i10 == 8192 || i10 == 4096) && !ViewPager2.this.e();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean d() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void j(d0 d0Var) {
            if (ViewPager2.this.e()) {
                return;
            }
            d0Var.N(d0.a.f15098r);
            d0Var.N(d0.a.f15097q);
            d0Var.h0(false);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean k(int i10) {
            if (b(i10)) {
                return false;
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public CharSequence n() {
            if (d()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class g extends RecyclerView.i {
        public g() {
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

        public /* synthetic */ g(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class h extends LinearLayoutManager {
        public h(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public void N0(RecyclerView.v vVar, RecyclerView.a0 a0Var, d0 d0Var) {
            super.N0(vVar, a0Var, d0Var);
            ViewPager2.this.D.j(d0Var);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void N1(RecyclerView.a0 a0Var, int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.N1(a0Var, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public boolean i1(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i10, Bundle bundle) {
            return ViewPager2.this.D.b(i10) ? ViewPager2.this.D.k(i10) : super.i1(vVar, a0Var, i10, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public boolean t1(RecyclerView recyclerView, View view, Rect rect, boolean z10, boolean z11) {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class j extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final i0 f1591b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final i0 f1592c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public RecyclerView.i f1593d;

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class a implements i0 {
            public a() {
            }

            @Override // z.i0
            public boolean a(View view, i0.a aVar) {
                j.this.v(((ViewPager2) view).getCurrentItem() + 1);
                return true;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class b implements i0 {
            public b() {
            }

            @Override // z.i0
            public boolean a(View view, i0.a aVar) {
                j.this.v(((ViewPager2) view).getCurrentItem() - 1);
                return true;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class c extends g {
            public c() {
                super(null);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.g, androidx.recyclerview.widget.RecyclerView.i
            public void a() {
                j.this.w();
            }
        }

        public j() {
            super(ViewPager2.this, null);
            this.f1591b = new a();
            this.f1592c = new b();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean a() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean c(int i10, Bundle bundle) {
            return i10 == 8192 || i10 == 4096;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void e(RecyclerView.Adapter adapter) {
            w();
            if (adapter != null) {
                adapter.E(this.f1593d);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void f(RecyclerView.Adapter adapter) {
            if (adapter != null) {
                adapter.G(this.f1593d);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public String g() {
            if (a()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void h(androidx.viewpager2.widget.b bVar, RecyclerView recyclerView) {
            y.r.c0(recyclerView, 2);
            this.f1593d = new c();
            if (y.r.t(ViewPager2.this) == 0) {
                y.r.c0(ViewPager2.this, 1);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void i(AccessibilityNodeInfo accessibilityNodeInfo) {
            t(accessibilityNodeInfo);
            u(accessibilityNodeInfo);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean l(int i10, Bundle bundle) {
            if (!c(i10, bundle)) {
                throw new IllegalStateException();
            }
            v(i10 == 8192 ? ViewPager2.this.getCurrentItem() - 1 : ViewPager2.this.getCurrentItem() + 1);
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void m() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void o(AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName(g());
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void p() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void q() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void r() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void s() {
            w();
            if (Build.VERSION.SDK_INT < 21) {
                ViewPager2.this.sendAccessibilityEvent(2048);
            }
        }

        public final void t(AccessibilityNodeInfo accessibilityNodeInfo) {
            int iG;
            int iG2;
            if (ViewPager2.this.getAdapter() != null) {
                if (ViewPager2.this.getOrientation() == 1) {
                    iG = ViewPager2.this.getAdapter().g();
                } else {
                    iG2 = ViewPager2.this.getAdapter().g();
                    iG = 0;
                }
                d0.n0(accessibilityNodeInfo).V(d0.b.a(iG, iG2, false, 0));
            }
            iG = 0;
            iG2 = 0;
            d0.n0(accessibilityNodeInfo).V(d0.b.a(iG, iG2, false, 0));
        }

        public final void u(AccessibilityNodeInfo accessibilityNodeInfo) {
            int iG;
            RecyclerView.Adapter adapter = ViewPager2.this.getAdapter();
            if (adapter == null || (iG = adapter.g()) == 0 || !ViewPager2.this.e()) {
                return;
            }
            if (ViewPager2.this.f1569n > 0) {
                accessibilityNodeInfo.addAction(8192);
            }
            if (ViewPager2.this.f1569n < iG - 1) {
                accessibilityNodeInfo.addAction(4096);
            }
            accessibilityNodeInfo.setScrollable(true);
        }

        public void v(int i10) {
            if (ViewPager2.this.e()) {
                ViewPager2.this.k(i10, true);
            }
        }

        public void w() {
            int iG;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i10 = R.id.accessibilityActionPageLeft;
            y.r.S(viewPager2, R.id.accessibilityActionPageLeft);
            y.r.S(viewPager2, R.id.accessibilityActionPageRight);
            y.r.S(viewPager2, R.id.accessibilityActionPageUp);
            y.r.S(viewPager2, R.id.accessibilityActionPageDown);
            if (ViewPager2.this.getAdapter() == null || (iG = ViewPager2.this.getAdapter().g()) == 0 || !ViewPager2.this.e()) {
                return;
            }
            if (ViewPager2.this.getOrientation() != 0) {
                if (ViewPager2.this.f1569n < iG - 1) {
                    y.r.U(viewPager2, new d0.a(R.id.accessibilityActionPageDown, null), null, this.f1591b);
                }
                if (ViewPager2.this.f1569n > 0) {
                    y.r.U(viewPager2, new d0.a(R.id.accessibilityActionPageUp, null), null, this.f1592c);
                    return;
                }
                return;
            }
            boolean zD = ViewPager2.this.d();
            int i11 = zD ? R.id.accessibilityActionPageLeft : R.id.accessibilityActionPageRight;
            if (zD) {
                i10 = R.id.accessibilityActionPageRight;
            }
            if (ViewPager2.this.f1569n < iG - 1) {
                y.r.U(viewPager2, new d0.a(i11, null), null, this.f1591b);
            }
            if (ViewPager2.this.f1569n > 0) {
                y.r.U(viewPager2, new d0.a(i10, null), null, this.f1592c);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface k {
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class l extends r {
        public l() {
        }

        @Override // androidx.recyclerview.widget.r, androidx.recyclerview.widget.v
        public View f(RecyclerView.o oVar) {
            if (ViewPager2.this.c()) {
                return null;
            }
            return super.f(oVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class m extends RecyclerView {
        public m(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        public CharSequence getAccessibilityClassName() {
            return ViewPager2.this.D.d() ? ViewPager2.this.D.n() : super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.f1569n);
            accessibilityEvent.setToIndex(ViewPager2.this.f1569n);
            ViewPager2.this.D.o(accessibilityEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.e() && super.onInterceptTouchEvent(motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.e() && super.onTouchEvent(motionEvent);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class n implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f1599c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final RecyclerView f1600e;

        public n(int i10, RecyclerView recyclerView) {
            this.f1599c = i10;
            this.f1600e = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1600e.x1(this.f1599c);
        }
    }

    public ViewPager2(Context context) {
        super(context);
        this.f1566c = new Rect();
        this.f1567e = new Rect();
        this.f1568m = new androidx.viewpager2.widget.b(3);
        this.f1570o = false;
        this.f1571p = new a();
        this.f1573r = -1;
        this.f1581z = null;
        this.A = false;
        this.B = true;
        this.C = -1;
        b(context, null);
    }

    public final RecyclerView.q a() {
        return new d();
    }

    public final void b(Context context, AttributeSet attributeSet) {
        this.D = E ? new j() : new f();
        m mVar = new m(context);
        this.f1575t = mVar;
        mVar.setId(y.r.j());
        this.f1575t.setDescendantFocusability(131072);
        h hVar = new h(context);
        this.f1572q = hVar;
        this.f1575t.setLayoutManager(hVar);
        this.f1575t.setScrollingTouchSlop(1);
        l(context, attributeSet);
        this.f1575t.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f1575t.m(a());
        androidx.viewpager2.widget.e eVar = new androidx.viewpager2.widget.e(this);
        this.f1577v = eVar;
        this.f1579x = new androidx.viewpager2.widget.c(this, eVar, this.f1575t);
        l lVar = new l();
        this.f1576u = lVar;
        lVar.b(this.f1575t);
        this.f1575t.o(this.f1577v);
        androidx.viewpager2.widget.b bVar = new androidx.viewpager2.widget.b(3);
        this.f1578w = bVar;
        this.f1577v.o(bVar);
        b bVar2 = new b();
        c cVar = new c();
        this.f1578w.d(bVar2);
        this.f1578w.d(cVar);
        this.D.h(this.f1578w, this.f1575t);
        this.f1578w.d(this.f1568m);
        androidx.viewpager2.widget.d dVar = new androidx.viewpager2.widget.d(this.f1572q);
        this.f1580y = dVar;
        this.f1578w.d(dVar);
        RecyclerView recyclerView = this.f1575t;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    public boolean c() {
        return this.f1579x.a();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i10) {
        return this.f1575t.canScrollHorizontally(i10);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i10) {
        return this.f1575t.canScrollVertically(i10);
    }

    public boolean d() {
        return this.f1572q.a0() == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray sparseArray) {
        Parcelable parcelable = (Parcelable) sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i10 = ((SavedState) parcelable).f1582c;
            sparseArray.put(this.f1575t.getId(), sparseArray.get(i10));
            sparseArray.remove(i10);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        i();
    }

    public boolean e() {
        return this.B;
    }

    public final void f(RecyclerView.Adapter adapter) {
        if (adapter != null) {
            adapter.E(this.f1571p);
        }
    }

    public void g(i iVar) {
        this.f1568m.d(iVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return this.D.a() ? this.D.g() : super.getAccessibilityClassName();
    }

    public RecyclerView.Adapter getAdapter() {
        return this.f1575t.getAdapter();
    }

    public int getCurrentItem() {
        return this.f1569n;
    }

    public int getItemDecorationCount() {
        return this.f1575t.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.C;
    }

    public int getOrientation() {
        return this.f1572q.o2();
    }

    public int getPageSize() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.f1575t;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public int getScrollState() {
        return this.f1577v.h();
    }

    public void h() {
        this.f1580y.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i() {
        RecyclerView.Adapter adapter;
        if (this.f1573r == -1 || (adapter = getAdapter()) == 0) {
            return;
        }
        Parcelable parcelable = this.f1574s;
        if (parcelable != null) {
            if (adapter instanceof androidx.viewpager2.adapter.b) {
                ((androidx.viewpager2.adapter.b) adapter).a(parcelable);
            }
            this.f1574s = null;
        }
        int iMax = Math.max(0, Math.min(this.f1573r, adapter.g() - 1));
        this.f1569n = iMax;
        this.f1573r = -1;
        this.f1575t.p1(iMax);
        this.D.m();
    }

    public void j(int i10, boolean z10) {
        if (c()) {
            throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
        }
        k(i10, z10);
    }

    public void k(int i10, boolean z10) {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            if (this.f1573r != -1) {
                this.f1573r = Math.max(i10, 0);
                return;
            }
            return;
        }
        if (adapter.g() <= 0) {
            return;
        }
        int iMin = Math.min(Math.max(i10, 0), adapter.g() - 1);
        if (iMin == this.f1569n && this.f1577v.j()) {
            return;
        }
        int i11 = this.f1569n;
        if (iMin == i11 && z10) {
            return;
        }
        double dG = i11;
        this.f1569n = iMin;
        this.D.q();
        if (!this.f1577v.j()) {
            dG = this.f1577v.g();
        }
        this.f1577v.m(iMin, z10);
        if (!z10) {
            this.f1575t.p1(iMin);
            return;
        }
        double d10 = iMin;
        Double.isNaN(d10);
        if (Math.abs(d10 - dG) <= 3.0d) {
            this.f1575t.x1(iMin);
            return;
        }
        this.f1575t.p1(d10 > dG ? iMin - 3 : iMin + 3);
        RecyclerView recyclerView = this.f1575t;
        recyclerView.post(new n(iMin, recyclerView));
    }

    public final void l(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, q0.a.f11699g);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, q0.a.f11699g, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        }
        try {
            setOrientation(typedArrayObtainStyledAttributes.getInt(q0.a.f11700h, 0));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final void m(RecyclerView.Adapter adapter) {
        if (adapter != null) {
            adapter.G(this.f1571p);
        }
    }

    public void n(i iVar) {
        this.f1568m.e(iVar);
    }

    public void o() {
        r rVar = this.f1576u;
        if (rVar == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        View viewF = rVar.f(this.f1572q);
        if (viewF == null) {
            return;
        }
        int iI0 = this.f1572q.i0(viewF);
        if (iI0 != this.f1569n && getScrollState() == 0) {
            this.f1578w.c(iI0);
        }
        this.f1570o = false;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.D.i(accessibilityNodeInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int measuredWidth = this.f1575t.getMeasuredWidth();
        int measuredHeight = this.f1575t.getMeasuredHeight();
        this.f1566c.left = getPaddingLeft();
        this.f1566c.right = (i12 - i10) - getPaddingRight();
        this.f1566c.top = getPaddingTop();
        this.f1566c.bottom = (i13 - i11) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.f1566c, this.f1567e);
        RecyclerView recyclerView = this.f1575t;
        Rect rect = this.f1567e;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.f1570o) {
            o();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        measureChild(this.f1575t, i10, i11);
        int measuredWidth = this.f1575t.getMeasuredWidth();
        int measuredHeight = this.f1575t.getMeasuredHeight();
        int measuredState = this.f1575t.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i10, measuredState), View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i11, measuredState << 16));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f1573r = savedState.f1583e;
        this.f1574s = savedState.f1584m;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1582c = this.f1575t.getId();
        int i10 = this.f1573r;
        if (i10 == -1) {
            i10 = this.f1569n;
        }
        savedState.f1583e = i10;
        Parcelable parcelable = this.f1574s;
        if (parcelable != null) {
            savedState.f1584m = parcelable;
            return savedState;
        }
        Object adapter = this.f1575t.getAdapter();
        if (adapter instanceof androidx.viewpager2.adapter.b) {
            savedState.f1584m = ((androidx.viewpager2.adapter.b) adapter).b();
        }
        return savedState;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        throw new IllegalStateException(ViewPager2.class.getSimpleName() + " does not support direct child views");
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i10, Bundle bundle) {
        return this.D.c(i10, bundle) ? this.D.l(i10, bundle) : super.performAccessibilityAction(i10, bundle);
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = this.f1575t.getAdapter();
        this.D.f(adapter2);
        m(adapter2);
        this.f1575t.setAdapter(adapter);
        this.f1569n = 0;
        i();
        this.D.e(adapter);
        f(adapter);
    }

    public void setCurrentItem(int i10) {
        j(i10, true);
    }

    @Override // android.view.View
    public void setLayoutDirection(int i10) {
        super.setLayoutDirection(i10);
        this.D.p();
    }

    public void setOffscreenPageLimit(int i10) {
        if (i10 < 1 && i10 != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.C = i10;
        this.f1575t.requestLayout();
    }

    public void setOrientation(int i10) {
        this.f1572q.C2(i10);
        this.D.r();
    }

    public void setPageTransformer(k kVar) {
        if (kVar != null) {
            if (!this.A) {
                this.f1581z = this.f1575t.getItemAnimator();
                this.A = true;
            }
            this.f1575t.setItemAnimator(null);
        } else if (this.A) {
            this.f1575t.setItemAnimator(this.f1581z);
            this.f1581z = null;
            this.A = false;
        }
        this.f1580y.d();
        if (kVar == null) {
            return;
        }
        this.f1580y.e(kVar);
        h();
    }

    public void setUserInputEnabled(boolean z10) {
        this.B = z10;
        this.D.s();
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1582c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1583e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Parcelable f1584m;

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public static class a implements Parcelable.ClassLoaderCreator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return Build.VERSION.SDK_INT >= 24 ? new SavedState(parcel, classLoader) : new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader);
        }

        public final void a(Parcel parcel, ClassLoader classLoader) {
            this.f1582c = parcel.readInt();
            this.f1583e = parcel.readInt();
            this.f1584m = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f1582c);
            parcel.writeInt(this.f1583e);
            parcel.writeParcelable(this.f1584m, i10);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            a(parcel, null);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d implements RecyclerView.q {
        public d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.q
        public void d(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            if (((ViewGroup.MarginLayoutParams) pVar).width != -1 || ((ViewGroup.MarginLayoutParams) pVar).height != -1) {
                throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.q
        public void b(View view) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class i {
        public abstract void c(int i10);

        public void a(int i10) {
        }

        public void b(int i10, float f10, int i11) {
        }
    }
}
