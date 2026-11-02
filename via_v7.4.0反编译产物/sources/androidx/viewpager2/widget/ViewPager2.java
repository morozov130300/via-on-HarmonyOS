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
import y.d0;
import y.i0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class ViewPager2 extends ViewGroup {
    public static boolean C = true;
    public int A;
    public e B;

    /* renamed from: e, reason: collision with root package name */
    public final Rect f1665e;

    /* renamed from: j, reason: collision with root package name */
    public final Rect f1666j;

    /* renamed from: k, reason: collision with root package name */
    public androidx.viewpager2.widget.b f1667k;

    /* renamed from: l, reason: collision with root package name */
    public int f1668l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1669m;

    /* renamed from: n, reason: collision with root package name */
    public RecyclerView.i f1670n;

    /* renamed from: o, reason: collision with root package name */
    public LinearLayoutManager f1671o;

    /* renamed from: p, reason: collision with root package name */
    public int f1672p;

    /* renamed from: q, reason: collision with root package name */
    public Parcelable f1673q;

    /* renamed from: r, reason: collision with root package name */
    public RecyclerView f1674r;

    /* renamed from: s, reason: collision with root package name */
    public r f1675s;

    /* renamed from: t, reason: collision with root package name */
    public androidx.viewpager2.widget.e f1676t;

    /* renamed from: u, reason: collision with root package name */
    public androidx.viewpager2.widget.b f1677u;

    /* renamed from: v, reason: collision with root package name */
    public androidx.viewpager2.widget.c f1678v;

    /* renamed from: w, reason: collision with root package name */
    public androidx.viewpager2.widget.d f1679w;

    /* renamed from: x, reason: collision with root package name */
    public RecyclerView.l f1680x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f1681y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f1682z;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        public int f1683e;

        /* renamed from: j, reason: collision with root package name */
        public int f1684j;

        /* renamed from: k, reason: collision with root package name */
        public Parcelable f1685k;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public static class a implements Parcelable.ClassLoaderCreator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return Build.VERSION.SDK_INT >= 24 ? new SavedState(parcel, classLoader) : new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            a(parcel, null);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public final void a(Parcel parcel, ClassLoader classLoader) {
            this.f1683e = parcel.readInt();
            this.f1684j = parcel.readInt();
            this.f1685k = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f1683e);
            parcel.writeInt(this.f1684j);
            parcel.writeParcelable(this.f1685k, i10);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends g {
        public a() {
            super(null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.g, androidx.recyclerview.widget.RecyclerView.i
        public void a() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.f1669m = true;
            viewPager2.f1676t.l();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
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
            if (viewPager2.f1668l != i10) {
                viewPager2.f1668l = i10;
                viewPager2.B.q();
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c extends i {
        public c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void c(int i10) {
            ViewPager2.this.clearFocus();
            if (ViewPager2.this.hasFocus()) {
                ViewPager2.this.f1674r.requestFocus(2);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class d implements RecyclerView.q {
        public d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.q
        public void b(View view) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.q
        public void d(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            if (((ViewGroup.MarginLayoutParams) pVar).width != -1 || ((ViewGroup.MarginLayoutParams) pVar).height != -1) {
                throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public abstract class e {
        public e() {
        }

        public /* synthetic */ e(ViewPager2 viewPager2, a aVar) {
            this();
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

        public void e(RecyclerView.Adapter adapter) {
        }

        public void f(RecyclerView.Adapter adapter) {
        }

        public String g() {
            throw new IllegalStateException("Not implemented.");
        }

        public void h(androidx.viewpager2.widget.b bVar, RecyclerView recyclerView) {
        }

        public void i(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        public void j(d0 d0Var) {
        }

        public boolean k(int i10) {
            throw new IllegalStateException("Not implemented.");
        }

        public boolean l(int i10, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        public void m() {
        }

        public CharSequence n() {
            throw new IllegalStateException("Not implemented.");
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
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
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
            d0Var.N(d0.a.f14370r);
            d0Var.N(d0.a.f14369q);
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

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class g extends RecyclerView.i {
        public g() {
        }

        public /* synthetic */ g(a aVar) {
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

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class h extends LinearLayoutManager {
        public h(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public void N0(RecyclerView.v vVar, RecyclerView.z zVar, d0 d0Var) {
            super.N0(vVar, zVar, d0Var);
            ViewPager2.this.B.j(d0Var);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void N1(RecyclerView.z zVar, int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.N1(zVar, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public boolean i1(RecyclerView.v vVar, RecyclerView.z zVar, int i10, Bundle bundle) {
            return ViewPager2.this.B.b(i10) ? ViewPager2.this.B.k(i10) : super.i1(vVar, zVar, i10, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public boolean t1(RecyclerView recyclerView, View view, Rect rect, boolean z10, boolean z11) {
            return false;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class i {
        public void a(int i10) {
        }

        public void b(int i10, float f10, int i11) {
        }

        public abstract void c(int i10);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class j extends e {

        /* renamed from: b, reason: collision with root package name */
        public final i0 f1692b;

        /* renamed from: c, reason: collision with root package name */
        public final i0 f1693c;

        /* renamed from: d, reason: collision with root package name */
        public RecyclerView.i f1694d;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public class a implements i0 {
            public a() {
            }

            @Override // y.i0
            public boolean a(View view, i0.a aVar) {
                j.this.v(((ViewPager2) view).getCurrentItem() + 1);
                return true;
            }
        }

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public class b implements i0 {
            public b() {
            }

            @Override // y.i0
            public boolean a(View view, i0.a aVar) {
                j.this.v(((ViewPager2) view).getCurrentItem() - 1);
                return true;
            }
        }

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
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
            this.f1692b = new a();
            this.f1693c = new b();
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
                adapter.E(this.f1694d);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void f(RecyclerView.Adapter adapter) {
            if (adapter != null) {
                adapter.G(this.f1694d);
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
            x.r.b0(recyclerView, 2);
            this.f1694d = new c();
            if (x.r.t(ViewPager2.this) == 0) {
                x.r.b0(ViewPager2.this, 1);
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
            if (ViewPager2.this.getAdapter() == null) {
                iG = 0;
            } else {
                if (ViewPager2.this.getOrientation() != 1) {
                    iG2 = ViewPager2.this.getAdapter().g();
                    iG = 0;
                    d0.n0(accessibilityNodeInfo).V(d0.b.a(iG, iG2, false, 0));
                }
                iG = ViewPager2.this.getAdapter().g();
            }
            iG2 = 0;
            d0.n0(accessibilityNodeInfo).V(d0.b.a(iG, iG2, false, 0));
        }

        public final void u(AccessibilityNodeInfo accessibilityNodeInfo) {
            int iG;
            RecyclerView.Adapter adapter = ViewPager2.this.getAdapter();
            if (adapter == null || (iG = adapter.g()) == 0 || !ViewPager2.this.e()) {
                return;
            }
            if (ViewPager2.this.f1668l > 0) {
                accessibilityNodeInfo.addAction(8192);
            }
            if (ViewPager2.this.f1668l < iG - 1) {
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
            x.r.R(viewPager2, R.id.accessibilityActionPageLeft);
            x.r.R(viewPager2, R.id.accessibilityActionPageRight);
            x.r.R(viewPager2, R.id.accessibilityActionPageUp);
            x.r.R(viewPager2, R.id.accessibilityActionPageDown);
            if (ViewPager2.this.getAdapter() == null || (iG = ViewPager2.this.getAdapter().g()) == 0 || !ViewPager2.this.e()) {
                return;
            }
            if (ViewPager2.this.getOrientation() != 0) {
                if (ViewPager2.this.f1668l < iG - 1) {
                    x.r.T(viewPager2, new d0.a(R.id.accessibilityActionPageDown, null), null, this.f1692b);
                }
                if (ViewPager2.this.f1668l > 0) {
                    x.r.T(viewPager2, new d0.a(R.id.accessibilityActionPageUp, null), null, this.f1693c);
                    return;
                }
                return;
            }
            boolean zD = ViewPager2.this.d();
            int i11 = zD ? R.id.accessibilityActionPageLeft : R.id.accessibilityActionPageRight;
            if (zD) {
                i10 = R.id.accessibilityActionPageRight;
            }
            if (ViewPager2.this.f1668l < iG - 1) {
                x.r.T(viewPager2, new d0.a(i11, null), null, this.f1692b);
            }
            if (ViewPager2.this.f1668l > 0) {
                x.r.T(viewPager2, new d0.a(i10, null), null, this.f1693c);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface k {
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
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

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class m extends RecyclerView {
        public m(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        public CharSequence getAccessibilityClassName() {
            return ViewPager2.this.B.d() ? ViewPager2.this.B.n() : super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.f1668l);
            accessibilityEvent.setToIndex(ViewPager2.this.f1668l);
            ViewPager2.this.B.o(accessibilityEvent);
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

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class n implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final int f1700e;

        /* renamed from: j, reason: collision with root package name */
        public final RecyclerView f1701j;

        public n(int i10, RecyclerView recyclerView) {
            this.f1700e = i10;
            this.f1701j = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1701j.x1(this.f1700e);
        }
    }

    public ViewPager2(Context context) {
        super(context);
        this.f1665e = new Rect();
        this.f1666j = new Rect();
        this.f1667k = new androidx.viewpager2.widget.b(3);
        this.f1669m = false;
        this.f1670n = new a();
        this.f1672p = -1;
        this.f1680x = null;
        this.f1681y = false;
        this.f1682z = true;
        this.A = -1;
        b(context, null);
    }

    public final RecyclerView.q a() {
        return new d();
    }

    public final void b(Context context, AttributeSet attributeSet) {
        this.B = C ? new j() : new f();
        m mVar = new m(context);
        this.f1674r = mVar;
        mVar.setId(x.r.j());
        this.f1674r.setDescendantFocusability(131072);
        h hVar = new h(context);
        this.f1671o = hVar;
        this.f1674r.setLayoutManager(hVar);
        this.f1674r.setScrollingTouchSlop(1);
        l(context, attributeSet);
        this.f1674r.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f1674r.m(a());
        androidx.viewpager2.widget.e eVar = new androidx.viewpager2.widget.e(this);
        this.f1676t = eVar;
        this.f1678v = new androidx.viewpager2.widget.c(this, eVar, this.f1674r);
        l lVar = new l();
        this.f1675s = lVar;
        lVar.b(this.f1674r);
        this.f1674r.o(this.f1676t);
        androidx.viewpager2.widget.b bVar = new androidx.viewpager2.widget.b(3);
        this.f1677u = bVar;
        this.f1676t.o(bVar);
        b bVar2 = new b();
        c cVar = new c();
        this.f1677u.d(bVar2);
        this.f1677u.d(cVar);
        this.B.h(this.f1677u, this.f1674r);
        this.f1677u.d(this.f1667k);
        androidx.viewpager2.widget.d dVar = new androidx.viewpager2.widget.d(this.f1671o);
        this.f1679w = dVar;
        this.f1677u.d(dVar);
        RecyclerView recyclerView = this.f1674r;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    public boolean c() {
        return this.f1678v.a();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i10) {
        return this.f1674r.canScrollHorizontally(i10);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i10) {
        return this.f1674r.canScrollVertically(i10);
    }

    public boolean d() {
        return this.f1671o.a0() == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray sparseArray) {
        Parcelable parcelable = (Parcelable) sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i10 = ((SavedState) parcelable).f1683e;
            sparseArray.put(this.f1674r.getId(), sparseArray.get(i10));
            sparseArray.remove(i10);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        i();
    }

    public boolean e() {
        return this.f1682z;
    }

    public final void f(RecyclerView.Adapter adapter) {
        if (adapter != null) {
            adapter.E(this.f1670n);
        }
    }

    public void g(i iVar) {
        this.f1667k.d(iVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return this.B.a() ? this.B.g() : super.getAccessibilityClassName();
    }

    public RecyclerView.Adapter getAdapter() {
        return this.f1674r.getAdapter();
    }

    public int getCurrentItem() {
        return this.f1668l;
    }

    public int getItemDecorationCount() {
        return this.f1674r.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.A;
    }

    public int getOrientation() {
        return this.f1671o.o2();
    }

    public int getPageSize() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.f1674r;
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
        return this.f1676t.h();
    }

    public void h() {
        this.f1679w.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i() {
        RecyclerView.Adapter adapter;
        if (this.f1672p == -1 || (adapter = getAdapter()) == 0) {
            return;
        }
        Parcelable parcelable = this.f1673q;
        if (parcelable != null) {
            if (adapter instanceof androidx.viewpager2.adapter.b) {
                ((androidx.viewpager2.adapter.b) adapter).a(parcelable);
            }
            this.f1673q = null;
        }
        int iMax = Math.max(0, Math.min(this.f1672p, adapter.g() - 1));
        this.f1668l = iMax;
        this.f1672p = -1;
        this.f1674r.p1(iMax);
        this.B.m();
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
            if (this.f1672p != -1) {
                this.f1672p = Math.max(i10, 0);
                return;
            }
            return;
        }
        if (adapter.g() <= 0) {
            return;
        }
        int iMin = Math.min(Math.max(i10, 0), adapter.g() - 1);
        if (iMin == this.f1668l && this.f1676t.j()) {
            return;
        }
        int i11 = this.f1668l;
        if (iMin == i11 && z10) {
            return;
        }
        double dG = i11;
        this.f1668l = iMin;
        this.B.q();
        if (!this.f1676t.j()) {
            dG = this.f1676t.g();
        }
        this.f1676t.m(iMin, z10);
        if (!z10) {
            this.f1674r.p1(iMin);
            return;
        }
        double d10 = iMin;
        Double.isNaN(d10);
        if (Math.abs(d10 - dG) <= 3.0d) {
            this.f1674r.x1(iMin);
            return;
        }
        this.f1674r.p1(d10 > dG ? iMin - 3 : iMin + 3);
        RecyclerView recyclerView = this.f1674r;
        recyclerView.post(new n(iMin, recyclerView));
    }

    public final void l(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p0.a.f10921g);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, p0.a.f10921g, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        }
        try {
            setOrientation(typedArrayObtainStyledAttributes.getInt(p0.a.f10922h, 0));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final void m(RecyclerView.Adapter adapter) {
        if (adapter != null) {
            adapter.G(this.f1670n);
        }
    }

    public void n(i iVar) {
        this.f1667k.e(iVar);
    }

    public void o() {
        r rVar = this.f1675s;
        if (rVar == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        View viewF = rVar.f(this.f1671o);
        if (viewF == null) {
            return;
        }
        int iI0 = this.f1671o.i0(viewF);
        if (iI0 != this.f1668l && getScrollState() == 0) {
            this.f1677u.c(iI0);
        }
        this.f1669m = false;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.B.i(accessibilityNodeInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int measuredWidth = this.f1674r.getMeasuredWidth();
        int measuredHeight = this.f1674r.getMeasuredHeight();
        this.f1665e.left = getPaddingLeft();
        this.f1665e.right = (i12 - i10) - getPaddingRight();
        this.f1665e.top = getPaddingTop();
        this.f1665e.bottom = (i13 - i11) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.f1665e, this.f1666j);
        RecyclerView recyclerView = this.f1674r;
        Rect rect = this.f1666j;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.f1669m) {
            o();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        measureChild(this.f1674r, i10, i11);
        int measuredWidth = this.f1674r.getMeasuredWidth();
        int measuredHeight = this.f1674r.getMeasuredHeight();
        int measuredState = this.f1674r.getMeasuredState();
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
        this.f1672p = savedState.f1684j;
        this.f1673q = savedState.f1685k;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1683e = this.f1674r.getId();
        int i10 = this.f1672p;
        if (i10 == -1) {
            i10 = this.f1668l;
        }
        savedState.f1684j = i10;
        Parcelable parcelable = this.f1673q;
        if (parcelable != null) {
            savedState.f1685k = parcelable;
            return savedState;
        }
        Object adapter = this.f1674r.getAdapter();
        if (adapter instanceof androidx.viewpager2.adapter.b) {
            savedState.f1685k = ((androidx.viewpager2.adapter.b) adapter).b();
        }
        return savedState;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        throw new IllegalStateException(ViewPager2.class.getSimpleName() + " does not support direct child views");
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i10, Bundle bundle) {
        return this.B.c(i10, bundle) ? this.B.l(i10, bundle) : super.performAccessibilityAction(i10, bundle);
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = this.f1674r.getAdapter();
        this.B.f(adapter2);
        m(adapter2);
        this.f1674r.setAdapter(adapter);
        this.f1668l = 0;
        i();
        this.B.e(adapter);
        f(adapter);
    }

    public void setCurrentItem(int i10) {
        j(i10, true);
    }

    @Override // android.view.View
    public void setLayoutDirection(int i10) {
        super.setLayoutDirection(i10);
        this.B.p();
    }

    public void setOffscreenPageLimit(int i10) {
        if (i10 < 1 && i10 != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.A = i10;
        this.f1674r.requestLayout();
    }

    public void setOrientation(int i10) {
        this.f1671o.C2(i10);
        this.B.r();
    }

    public void setPageTransformer(k kVar) {
        if (kVar != null) {
            if (!this.f1681y) {
                this.f1680x = this.f1674r.getItemAnimator();
                this.f1681y = true;
            }
            this.f1674r.setItemAnimator(null);
        } else if (this.f1681y) {
            this.f1674r.setItemAnimator(this.f1680x);
            this.f1680x = null;
            this.f1681y = false;
        }
        this.f1679w.d();
        if (kVar == null) {
            return;
        }
        this.f1679w.e(kVar);
        h();
    }

    public void setUserInputEnabled(boolean z10) {
        this.f1682z = z10;
        this.B.s();
    }
}
