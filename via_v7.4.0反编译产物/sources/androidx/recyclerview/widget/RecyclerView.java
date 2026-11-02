package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.widget.a;
import androidx.recyclerview.widget.d;
import androidx.recyclerview.widget.i;
import androidx.recyclerview.widget.s;
import androidx.recyclerview.widget.w;
import androidx.recyclerview.widget.x;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import y.d0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements x.k {
    public static final int[] J0 = {R.attr.nestedScrollingEnabled};
    public static final boolean K0;
    public static final boolean L0;
    public static final boolean M0;
    public static final boolean N0;
    public static final boolean O0;
    public static final boolean P0;
    public static final Class[] Q0;
    public static final Interpolator R0;
    public boolean A;
    public final int[] A0;
    public boolean B;
    public final int[] B0;
    public boolean C;
    public final int[] C0;
    public int D;
    public final List D0;
    public boolean E;
    public Runnable E0;
    public boolean F;
    public boolean F0;
    public boolean G;
    public int G0;
    public int H;
    public int H0;
    public boolean I;
    public final x.b I0;
    public final AccessibilityManager J;
    public List K;
    public boolean L;
    public boolean M;
    public int N;
    public int O;
    public k P;
    public EdgeEffect Q;
    public EdgeEffect R;
    public EdgeEffect S;
    public EdgeEffect T;
    public l U;
    public int V;
    public int W;

    /* renamed from: a0, reason: collision with root package name */
    public VelocityTracker f1160a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f1161b0;

    /* renamed from: c0, reason: collision with root package name */
    public int f1162c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f1163d0;

    /* renamed from: e, reason: collision with root package name */
    public final x f1164e;

    /* renamed from: e0, reason: collision with root package name */
    public int f1165e0;

    /* renamed from: f0, reason: collision with root package name */
    public int f1166f0;

    /* renamed from: g0, reason: collision with root package name */
    public r f1167g0;

    /* renamed from: h0, reason: collision with root package name */
    public final int f1168h0;

    /* renamed from: i0, reason: collision with root package name */
    public final int f1169i0;

    /* renamed from: j, reason: collision with root package name */
    public final v f1170j;

    /* renamed from: j0, reason: collision with root package name */
    public float f1171j0;

    /* renamed from: k, reason: collision with root package name */
    public SavedState f1172k;

    /* renamed from: k0, reason: collision with root package name */
    public float f1173k0;

    /* renamed from: l, reason: collision with root package name */
    public androidx.recyclerview.widget.a f1174l;

    /* renamed from: l0, reason: collision with root package name */
    public boolean f1175l0;

    /* renamed from: m, reason: collision with root package name */
    public androidx.recyclerview.widget.d f1176m;

    /* renamed from: m0, reason: collision with root package name */
    public final b0 f1177m0;

    /* renamed from: n, reason: collision with root package name */
    public final androidx.recyclerview.widget.x f1178n;

    /* renamed from: n0, reason: collision with root package name */
    public androidx.recyclerview.widget.i f1179n0;

    /* renamed from: o, reason: collision with root package name */
    public boolean f1180o;

    /* renamed from: o0, reason: collision with root package name */
    public i.b f1181o0;

    /* renamed from: p, reason: collision with root package name */
    public final Runnable f1182p;

    /* renamed from: p0, reason: collision with root package name */
    public final z f1183p0;

    /* renamed from: q, reason: collision with root package name */
    public final Rect f1184q;

    /* renamed from: q0, reason: collision with root package name */
    public t f1185q0;

    /* renamed from: r, reason: collision with root package name */
    public final Rect f1186r;

    /* renamed from: r0, reason: collision with root package name */
    public List f1187r0;

    /* renamed from: s, reason: collision with root package name */
    public final RectF f1188s;

    /* renamed from: s0, reason: collision with root package name */
    public boolean f1189s0;

    /* renamed from: t, reason: collision with root package name */
    public Adapter f1190t;

    /* renamed from: t0, reason: collision with root package name */
    public boolean f1191t0;

    /* renamed from: u, reason: collision with root package name */
    public o f1192u;

    /* renamed from: u0, reason: collision with root package name */
    public l.b f1193u0;

    /* renamed from: v, reason: collision with root package name */
    public final List f1194v;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f1195v0;

    /* renamed from: w, reason: collision with root package name */
    public final ArrayList f1196w;

    /* renamed from: w0, reason: collision with root package name */
    public androidx.recyclerview.widget.s f1197w0;

    /* renamed from: x, reason: collision with root package name */
    public final ArrayList f1198x;

    /* renamed from: x0, reason: collision with root package name */
    public j f1199x0;

    /* renamed from: y, reason: collision with root package name */
    public s f1200y;

    /* renamed from: y0, reason: collision with root package name */
    public final int[] f1201y0;

    /* renamed from: z, reason: collision with root package name */
    public boolean f1202z;

    /* renamed from: z0, reason: collision with root package name */
    public x.l f1203z0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class Adapter {

        /* renamed from: a, reason: collision with root package name */
        public final h f1204a = new h();

        /* renamed from: b, reason: collision with root package name */
        public boolean f1205b = false;

        /* renamed from: c, reason: collision with root package name */
        public StateRestorationPolicy f1206c = StateRestorationPolicy.ALLOW;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public enum StateRestorationPolicy {
            ALLOW,
            PREVENT_WHEN_EMPTY,
            PREVENT
        }

        public boolean A(c0 c0Var) {
            return false;
        }

        public void B(c0 c0Var) {
        }

        public void C(c0 c0Var) {
        }

        public void D(c0 c0Var) {
        }

        public void E(i iVar) {
            this.f1204a.registerObserver(iVar);
        }

        public void F(boolean z10) {
            if (j()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.f1205b = z10;
        }

        public void G(i iVar) {
            this.f1204a.unregisterObserver(iVar);
        }

        public final void c(c0 c0Var, int i10) {
            boolean z10 = c0Var.f1237s == null;
            if (z10) {
                c0Var.f1221c = i10;
                if (k()) {
                    c0Var.f1223e = h(i10);
                }
                c0Var.H(1, 519);
                u.t.a("RV OnBindView");
            }
            c0Var.f1237s = this;
            x(c0Var, i10, c0Var.q());
            if (z10) {
                c0Var.d();
                ViewGroup.LayoutParams layoutParams = c0Var.f1219a.getLayoutParams();
                if (layoutParams instanceof p) {
                    ((p) layoutParams).f1279c = true;
                }
                u.t.b();
            }
        }

        public boolean d() {
            int i10 = g.f1241a[this.f1206c.ordinal()];
            return i10 != 1 && (i10 != 2 || g() > 0);
        }

        public final c0 e(ViewGroup viewGroup, int i10) {
            try {
                u.t.a("RV CreateView");
                c0 c0VarY = y(viewGroup, i10);
                if (c0VarY.f1219a.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                c0VarY.f1224f = i10;
                return c0VarY;
            } finally {
                u.t.b();
            }
        }

        public int f(Adapter adapter, c0 c0Var, int i10) {
            if (adapter == this) {
                return i10;
            }
            return -1;
        }

        public abstract int g();

        public long h(int i10) {
            return -1L;
        }

        public int i(int i10) {
            return 0;
        }

        public final boolean j() {
            return this.f1204a.a();
        }

        public final boolean k() {
            return this.f1205b;
        }

        public final void l() {
            this.f1204a.b();
        }

        public final void m(int i10) {
            this.f1204a.d(i10, 1);
        }

        public final void n(int i10, Object obj) {
            this.f1204a.e(i10, 1, obj);
        }

        public final void o(int i10) {
            this.f1204a.f(i10, 1);
        }

        public final void p(int i10, int i11) {
            this.f1204a.c(i10, i11);
        }

        public final void q(int i10, int i11) {
            this.f1204a.d(i10, i11);
        }

        public final void r(int i10, int i11, Object obj) {
            this.f1204a.e(i10, i11, obj);
        }

        public final void s(int i10, int i11) {
            this.f1204a.f(i10, i11);
        }

        public final void t(int i10, int i11) {
            this.f1204a.g(i10, i11);
        }

        public final void u(int i10) {
            this.f1204a.g(i10, 1);
        }

        public void v(RecyclerView recyclerView) {
        }

        public abstract void w(c0 c0Var, int i10);

        public void x(c0 c0Var, int i10, List list) {
            w(c0Var, i10);
        }

        public abstract c0 y(ViewGroup viewGroup, int i10);

        public void z(RecyclerView recyclerView) {
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: k, reason: collision with root package name */
        public Parcelable f1208k;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public class a implements Parcelable.ClassLoaderCreator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1208k = parcel.readParcelable(classLoader == null ? o.class.getClassLoader() : classLoader);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void b(SavedState savedState) {
            this.f1208k = savedState.f1208k;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeParcelable(this.f1208k, 0);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.C || recyclerView.isLayoutRequested()) {
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            if (!recyclerView2.f1202z) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.F) {
                recyclerView2.E = true;
            } else {
                recyclerView2.y();
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class a0 {
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar = RecyclerView.this.U;
            if (lVar != null) {
                lVar.v();
            }
            RecyclerView.this.f1195v0 = false;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b0 implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public int f1211e;

        /* renamed from: j, reason: collision with root package name */
        public int f1212j;

        /* renamed from: k, reason: collision with root package name */
        public OverScroller f1213k;

        /* renamed from: l, reason: collision with root package name */
        public Interpolator f1214l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f1215m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f1216n;

        public b0() {
            Interpolator interpolator = RecyclerView.R0;
            this.f1214l = interpolator;
            this.f1215m = false;
            this.f1216n = false;
            this.f1213k = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        public final int a(int i10, int i11) {
            int iAbs = Math.abs(i10);
            int iAbs2 = Math.abs(i11);
            boolean z10 = iAbs > iAbs2;
            RecyclerView recyclerView = RecyclerView.this;
            int width = z10 ? recyclerView.getWidth() : recyclerView.getHeight();
            if (!z10) {
                iAbs = iAbs2;
            }
            return Math.min((int) (((iAbs / width) + 1.0f) * 300.0f), 2000);
        }

        public void b(int i10, int i11) {
            RecyclerView.this.setScrollState(2);
            this.f1212j = 0;
            this.f1211e = 0;
            Interpolator interpolator = this.f1214l;
            Interpolator interpolator2 = RecyclerView.R0;
            if (interpolator != interpolator2) {
                this.f1214l = interpolator2;
                this.f1213k = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            this.f1213k.fling(0, 0, i10, i11, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            d();
        }

        public final void c() {
            RecyclerView.this.removeCallbacks(this);
            x.r.P(RecyclerView.this, this);
        }

        public void d() {
            if (this.f1215m) {
                this.f1216n = true;
            } else {
                c();
            }
        }

        public void e(int i10, int i11, int i12, Interpolator interpolator) {
            if (i12 == Integer.MIN_VALUE) {
                i12 = a(i10, i11);
            }
            int i13 = i12;
            if (interpolator == null) {
                interpolator = RecyclerView.R0;
            }
            if (this.f1214l != interpolator) {
                this.f1214l = interpolator;
                this.f1213k = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f1212j = 0;
            this.f1211e = 0;
            RecyclerView.this.setScrollState(2);
            this.f1213k.startScroll(0, 0, i10, i11, i13);
            if (Build.VERSION.SDK_INT < 23) {
                this.f1213k.computeScrollOffset();
            }
            d();
        }

        public void f() {
            RecyclerView.this.removeCallbacks(this);
            this.f1213k.abortAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10;
            int i11;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f1192u == null) {
                f();
                return;
            }
            this.f1216n = false;
            this.f1215m = true;
            recyclerView.y();
            OverScroller overScroller = this.f1213k;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i12 = currX - this.f1211e;
                int i13 = currY - this.f1212j;
                this.f1211e = currX;
                this.f1212j = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.C0;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.J(i12, i13, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.C0;
                    i12 -= iArr2[0];
                    i13 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.x(i12, i13);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.f1190t != null) {
                    int[] iArr3 = recyclerView3.C0;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.o1(i12, i13, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.C0;
                    int i14 = iArr4[0];
                    int i15 = iArr4[1];
                    i12 -= i14;
                    i13 -= i15;
                    y yVar = recyclerView4.f1192u.f1259g;
                    if (yVar != null && !yVar.g() && yVar.h()) {
                        int iB = RecyclerView.this.f1183p0.b();
                        if (iB == 0) {
                            yVar.r();
                        } else if (yVar.f() >= iB) {
                            yVar.p(iB - 1);
                            yVar.j(i14, i15);
                        } else {
                            yVar.j(i14, i15);
                        }
                    }
                    i11 = i15;
                    i10 = i14;
                } else {
                    i10 = 0;
                    i11 = 0;
                }
                int i16 = i12;
                int i17 = i13;
                if (!RecyclerView.this.f1196w.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.C0;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.K(i10, i11, i16, i17, null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.C0;
                int i18 = i16 - iArr6[0];
                int i19 = i17 - iArr6[1];
                if (i10 != 0 || i11 != 0) {
                    recyclerView6.M(i10, i11);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z10 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i18 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i19 != 0));
                y yVar2 = RecyclerView.this.f1192u.f1259g;
                if ((yVar2 == null || !yVar2.g()) && z10) {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i20 = i18 < 0 ? -currVelocity : i18 > 0 ? currVelocity : 0;
                        if (i19 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i19 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.e(i20, currVelocity);
                    }
                    if (RecyclerView.N0) {
                        RecyclerView.this.f1181o0.b();
                    }
                } else {
                    d();
                    RecyclerView recyclerView7 = RecyclerView.this;
                    androidx.recyclerview.widget.i iVar = recyclerView7.f1179n0;
                    if (iVar != null) {
                        iVar.f(recyclerView7, i10, i11);
                    }
                }
            }
            y yVar3 = RecyclerView.this.f1192u.f1259g;
            if (yVar3 != null && yVar3.g()) {
                yVar3.j(0, 0);
            }
            this.f1215m = false;
            if (this.f1216n) {
                c();
            } else {
                RecyclerView.this.setScrollState(0);
                RecyclerView.this.B1(1);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class c0 {

        /* renamed from: t, reason: collision with root package name */
        public static final List f1218t = Collections.EMPTY_LIST;

        /* renamed from: a, reason: collision with root package name */
        public final View f1219a;

        /* renamed from: b, reason: collision with root package name */
        public WeakReference f1220b;

        /* renamed from: j, reason: collision with root package name */
        public int f1228j;

        /* renamed from: r, reason: collision with root package name */
        public RecyclerView f1236r;

        /* renamed from: s, reason: collision with root package name */
        public Adapter f1237s;

        /* renamed from: c, reason: collision with root package name */
        public int f1221c = -1;

        /* renamed from: d, reason: collision with root package name */
        public int f1222d = -1;

        /* renamed from: e, reason: collision with root package name */
        public long f1223e = -1;

        /* renamed from: f, reason: collision with root package name */
        public int f1224f = -1;

        /* renamed from: g, reason: collision with root package name */
        public int f1225g = -1;

        /* renamed from: h, reason: collision with root package name */
        public c0 f1226h = null;

        /* renamed from: i, reason: collision with root package name */
        public c0 f1227i = null;

        /* renamed from: k, reason: collision with root package name */
        public List f1229k = null;

        /* renamed from: l, reason: collision with root package name */
        public List f1230l = null;

        /* renamed from: m, reason: collision with root package name */
        public int f1231m = 0;

        /* renamed from: n, reason: collision with root package name */
        public v f1232n = null;

        /* renamed from: o, reason: collision with root package name */
        public boolean f1233o = false;

        /* renamed from: p, reason: collision with root package name */
        public int f1234p = 0;

        /* renamed from: q, reason: collision with root package name */
        public int f1235q = -1;

        public c0(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.f1219a = view;
        }

        public boolean A() {
            return (this.f1228j & 2) != 0;
        }

        public boolean B() {
            return (this.f1228j & 2) != 0;
        }

        public void C(int i10, boolean z10) {
            if (this.f1222d == -1) {
                this.f1222d = this.f1221c;
            }
            if (this.f1225g == -1) {
                this.f1225g = this.f1221c;
            }
            if (z10) {
                this.f1225g += i10;
            }
            this.f1221c += i10;
            if (this.f1219a.getLayoutParams() != null) {
                ((p) this.f1219a.getLayoutParams()).f1279c = true;
            }
        }

        public void D(RecyclerView recyclerView) {
            int i10 = this.f1235q;
            if (i10 != -1) {
                this.f1234p = i10;
            } else {
                this.f1234p = x.r.t(this.f1219a);
            }
            recyclerView.r1(this, 4);
        }

        public void E(RecyclerView recyclerView) {
            recyclerView.r1(this, this.f1234p);
            this.f1234p = 0;
        }

        public void F() {
            this.f1228j = 0;
            this.f1221c = -1;
            this.f1222d = -1;
            this.f1223e = -1L;
            this.f1225g = -1;
            this.f1231m = 0;
            this.f1226h = null;
            this.f1227i = null;
            d();
            this.f1234p = 0;
            this.f1235q = -1;
            RecyclerView.v(this);
        }

        public void G() {
            if (this.f1222d == -1) {
                this.f1222d = this.f1221c;
            }
        }

        public void H(int i10, int i11) {
            this.f1228j = (i10 & i11) | (this.f1228j & (i11 ^ (-1)));
        }

        public final void I(boolean z10) {
            int i10 = this.f1231m;
            int i11 = z10 ? i10 - 1 : i10 + 1;
            this.f1231m = i11;
            if (i11 < 0) {
                this.f1231m = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z10 && i11 == 1) {
                this.f1228j |= 16;
            } else if (z10 && i11 == 0) {
                this.f1228j &= -17;
            }
        }

        public void J(v vVar, boolean z10) {
            this.f1232n = vVar;
            this.f1233o = z10;
        }

        public boolean K() {
            return (this.f1228j & 16) != 0;
        }

        public boolean L() {
            return (this.f1228j & 128) != 0;
        }

        public void M() {
            this.f1232n.J(this);
        }

        public boolean N() {
            return (this.f1228j & 32) != 0;
        }

        public void a(Object obj) {
            if (obj == null) {
                b(1024);
            } else if ((1024 & this.f1228j) == 0) {
                g();
                this.f1229k.add(obj);
            }
        }

        public void b(int i10) {
            this.f1228j = i10 | this.f1228j;
        }

        public void c() {
            this.f1222d = -1;
            this.f1225g = -1;
        }

        public void d() {
            List list = this.f1229k;
            if (list != null) {
                list.clear();
            }
            this.f1228j &= -1025;
        }

        public void e() {
            this.f1228j &= -33;
        }

        public void f() {
            this.f1228j &= -257;
        }

        public final void g() {
            if (this.f1229k == null) {
                ArrayList arrayList = new ArrayList();
                this.f1229k = arrayList;
                this.f1230l = Collections.unmodifiableList(arrayList);
            }
        }

        public boolean h() {
            return (this.f1228j & 16) == 0 && x.r.D(this.f1219a);
        }

        public void i(int i10, int i11, boolean z10) {
            b(8);
            C(i11, z10);
            this.f1221c = i10;
        }

        public final int j() {
            RecyclerView recyclerView = this.f1236r;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.g0(this);
        }

        public final int k() {
            return l();
        }

        public final int l() {
            RecyclerView recyclerView;
            Adapter adapter;
            int iG0;
            if (this.f1237s == null || (recyclerView = this.f1236r) == null || (adapter = recyclerView.getAdapter()) == null || (iG0 = this.f1236r.g0(this)) == -1) {
                return -1;
            }
            return adapter.f(this.f1237s, this, iG0);
        }

        public final long m() {
            return this.f1223e;
        }

        public final int n() {
            return this.f1224f;
        }

        public final int o() {
            int i10 = this.f1225g;
            return i10 == -1 ? this.f1221c : i10;
        }

        public final int p() {
            return this.f1222d;
        }

        public List q() {
            if ((this.f1228j & 1024) != 0) {
                return f1218t;
            }
            List list = this.f1229k;
            return (list == null || list.size() == 0) ? f1218t : this.f1230l;
        }

        public boolean r(int i10) {
            return (i10 & this.f1228j) != 0;
        }

        public boolean s() {
            return (this.f1228j & 512) != 0 || v();
        }

        public boolean t() {
            return (this.f1219a.getParent() == null || this.f1219a.getParent() == this.f1236r) ? false : true;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.f1221c + " id=" + this.f1223e + ", oldPos=" + this.f1222d + ", pLpos:" + this.f1225g);
            if (y()) {
                sb2.append(" scrap ");
                sb2.append(this.f1233o ? "[changeScrap]" : "[attachedScrap]");
            }
            if (v()) {
                sb2.append(" invalid");
            }
            if (!u()) {
                sb2.append(" unbound");
            }
            if (B()) {
                sb2.append(" update");
            }
            if (x()) {
                sb2.append(" removed");
            }
            if (L()) {
                sb2.append(" ignored");
            }
            if (z()) {
                sb2.append(" tmpDetached");
            }
            if (!w()) {
                sb2.append(" not recyclable(" + this.f1231m + ")");
            }
            if (s()) {
                sb2.append(" undefined adapter position");
            }
            if (this.f1219a.getParent() == null) {
                sb2.append(" no parent");
            }
            sb2.append("}");
            return sb2.toString();
        }

        public boolean u() {
            return (this.f1228j & 1) != 0;
        }

        public boolean v() {
            return (this.f1228j & 4) != 0;
        }

        public final boolean w() {
            return (this.f1228j & 16) == 0 && !x.r.D(this.f1219a);
        }

        public boolean x() {
            return (this.f1228j & 8) != 0;
        }

        public boolean y() {
            return this.f1232n != null;
        }

        public boolean z() {
            return (this.f1228j & 256) != 0;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class d implements x.b {
        public d() {
        }

        @Override // androidx.recyclerview.widget.x.b
        public void a(c0 c0Var) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f1192u.n1(c0Var.f1219a, recyclerView.f1170j);
        }

        @Override // androidx.recyclerview.widget.x.b
        public void b(c0 c0Var, l.c cVar, l.c cVar2) {
            RecyclerView.this.p(c0Var, cVar, cVar2);
        }

        @Override // androidx.recyclerview.widget.x.b
        public void c(c0 c0Var, l.c cVar, l.c cVar2) {
            RecyclerView.this.f1170j.J(c0Var);
            RecyclerView.this.r(c0Var, cVar, cVar2);
        }

        @Override // androidx.recyclerview.widget.x.b
        public void d(c0 c0Var, l.c cVar, l.c cVar2) {
            c0Var.I(false);
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.L) {
                if (recyclerView.U.b(c0Var, c0Var, cVar, cVar2)) {
                    RecyclerView.this.T0();
                }
            } else if (recyclerView.U.d(c0Var, cVar, cVar2)) {
                RecyclerView.this.T0();
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class e implements d.b {
        public e() {
        }

        @Override // androidx.recyclerview.widget.d.b
        public View a(int i10) {
            return RecyclerView.this.getChildAt(i10);
        }

        @Override // androidx.recyclerview.widget.d.b
        public void b(View view) {
            c0 c0VarL0 = RecyclerView.l0(view);
            if (c0VarL0 != null) {
                c0VarL0.D(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.d.b
        public int c() {
            return RecyclerView.this.getChildCount();
        }

        @Override // androidx.recyclerview.widget.d.b
        public void d() {
            int iC = c();
            for (int i10 = 0; i10 < iC; i10++) {
                View viewA = a(i10);
                RecyclerView.this.D(viewA);
                viewA.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        @Override // androidx.recyclerview.widget.d.b
        public int e(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        @Override // androidx.recyclerview.widget.d.b
        public c0 f(View view) {
            return RecyclerView.l0(view);
        }

        @Override // androidx.recyclerview.widget.d.b
        public void g(int i10) {
            c0 c0VarL0;
            View viewA = a(i10);
            if (viewA != null && (c0VarL0 = RecyclerView.l0(viewA)) != null) {
                if (c0VarL0.z() && !c0VarL0.L()) {
                    throw new IllegalArgumentException("called detach on an already detached child " + c0VarL0 + RecyclerView.this.T());
                }
                c0VarL0.b(256);
            }
            RecyclerView.this.detachViewFromParent(i10);
        }

        @Override // androidx.recyclerview.widget.d.b
        public void h(View view) {
            c0 c0VarL0 = RecyclerView.l0(view);
            if (c0VarL0 != null) {
                c0VarL0.E(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.d.b
        public void i(View view, int i10) {
            RecyclerView.this.addView(view, i10);
            RecyclerView.this.C(view);
        }

        @Override // androidx.recyclerview.widget.d.b
        public void j(int i10) {
            View childAt = RecyclerView.this.getChildAt(i10);
            if (childAt != null) {
                RecyclerView.this.D(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i10);
        }

        @Override // androidx.recyclerview.widget.d.b
        public void k(View view, int i10, ViewGroup.LayoutParams layoutParams) {
            c0 c0VarL0 = RecyclerView.l0(view);
            if (c0VarL0 != null) {
                if (!c0VarL0.z() && !c0VarL0.L()) {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + c0VarL0 + RecyclerView.this.T());
                }
                c0VarL0.f();
            }
            RecyclerView.this.attachViewToParent(view, i10, layoutParams);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class f implements a.InterfaceC0020a {
        public f() {
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0020a
        public void a(int i10, int i11) {
            RecyclerView.this.J0(i10, i11);
            RecyclerView.this.f1189s0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0020a
        public void b(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0020a
        public void c(int i10, int i11, Object obj) {
            RecyclerView.this.E1(i10, i11, obj);
            RecyclerView.this.f1191t0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0020a
        public void d(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0020a
        public c0 e(int i10) {
            c0 c0VarE0 = RecyclerView.this.e0(i10, true);
            if (c0VarE0 == null || RecyclerView.this.f1176m.n(c0VarE0.f1219a)) {
                return null;
            }
            return c0VarE0;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0020a
        public void f(int i10, int i11) {
            RecyclerView.this.K0(i10, i11, false);
            RecyclerView.this.f1189s0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0020a
        public void g(int i10, int i11) {
            RecyclerView.this.I0(i10, i11);
            RecyclerView.this.f1189s0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0020a
        public void h(int i10, int i11) {
            RecyclerView.this.K0(i10, i11, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f1189s0 = true;
            recyclerView.f1183p0.f1314d += i11;
        }

        public void i(a.b bVar) {
            int i10 = bVar.f1376a;
            if (i10 == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.f1192u.S0(recyclerView, bVar.f1377b, bVar.f1379d);
                return;
            }
            if (i10 == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.f1192u.V0(recyclerView2, bVar.f1377b, bVar.f1379d);
            } else if (i10 == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.f1192u.X0(recyclerView3, bVar.f1377b, bVar.f1379d, bVar.f1378c);
            } else {
                if (i10 != 8) {
                    return;
                }
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.f1192u.U0(recyclerView4, bVar.f1377b, bVar.f1379d, 1);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static /* synthetic */ class g {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1241a;

        static {
            int[] iArr = new int[Adapter.StateRestorationPolicy.values().length];
            f1241a = iArr;
            try {
                iArr[Adapter.StateRestorationPolicy.PREVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1241a[Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class h extends Observable {
        public boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).a();
            }
        }

        public void c(int i10, int i11) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).d(i10, i11, 1);
            }
        }

        public void d(int i10, int i11) {
            e(i10, i11, null);
        }

        public void e(int i10, int i11, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).b(i10, i11, obj);
            }
        }

        public void f(int i10, int i11) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).c(i10, i11);
            }
        }

        public void g(int i10, int i11) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).e(i10, i11);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class i {
        public abstract void a();

        public abstract void b(int i10, int i11, Object obj);

        public abstract void c(int i10, int i11);

        public abstract void d(int i10, int i11, int i12);

        public abstract void e(int i10, int i11);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface j {
        int a(int i10, int i11);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class k {
        public EdgeEffect a(RecyclerView recyclerView, int i10) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class l {

        /* renamed from: a, reason: collision with root package name */
        public b f1242a = null;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList f1243b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public long f1244c = 120;

        /* renamed from: d, reason: collision with root package name */
        public long f1245d = 120;

        /* renamed from: e, reason: collision with root package name */
        public long f1246e = 250;

        /* renamed from: f, reason: collision with root package name */
        public long f1247f = 250;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public interface a {
            void a();
        }

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public interface b {
            void a(c0 c0Var);
        }

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public static class c {

            /* renamed from: a, reason: collision with root package name */
            public int f1248a;

            /* renamed from: b, reason: collision with root package name */
            public int f1249b;

            /* renamed from: c, reason: collision with root package name */
            public int f1250c;

            /* renamed from: d, reason: collision with root package name */
            public int f1251d;

            public c a(c0 c0Var) {
                return b(c0Var, 0);
            }

            public c b(c0 c0Var, int i10) {
                View view = c0Var.f1219a;
                this.f1248a = view.getLeft();
                this.f1249b = view.getTop();
                this.f1250c = view.getRight();
                this.f1251d = view.getBottom();
                return this;
            }
        }

        public static int e(c0 c0Var) {
            int i10 = c0Var.f1228j;
            int i11 = i10 & 14;
            if (c0Var.v()) {
                return 4;
            }
            if ((i10 & 4) == 0) {
                int iP = c0Var.p();
                int iJ = c0Var.j();
                if (iP != -1 && iJ != -1 && iP != iJ) {
                    return i11 | 2048;
                }
            }
            return i11;
        }

        public abstract boolean a(c0 c0Var, c cVar, c cVar2);

        public abstract boolean b(c0 c0Var, c0 c0Var2, c cVar, c cVar2);

        public abstract boolean c(c0 c0Var, c cVar, c cVar2);

        public abstract boolean d(c0 c0Var, c cVar, c cVar2);

        public abstract boolean f(c0 c0Var);

        public boolean g(c0 c0Var, List list) {
            return f(c0Var);
        }

        public final void h(c0 c0Var) {
            s(c0Var);
            b bVar = this.f1242a;
            if (bVar != null) {
                bVar.a(c0Var);
            }
        }

        public final void i() {
            if (this.f1243b.size() <= 0) {
                this.f1243b.clear();
            } else {
                n.g.a(this.f1243b.get(0));
                throw null;
            }
        }

        public abstract void j(c0 c0Var);

        public abstract void k();

        public long l() {
            return this.f1244c;
        }

        public long m() {
            return this.f1247f;
        }

        public long n() {
            return this.f1246e;
        }

        public long o() {
            return this.f1245d;
        }

        public abstract boolean p();

        public final boolean q(a aVar) {
            boolean zP = p();
            if (aVar != null) {
                if (!zP) {
                    aVar.a();
                    return zP;
                }
                this.f1243b.add(aVar);
            }
            return zP;
        }

        public c r() {
            return new c();
        }

        public void s(c0 c0Var) {
        }

        public c t(z zVar, c0 c0Var) {
            return r().a(c0Var);
        }

        public c u(z zVar, c0 c0Var, int i10, List list) {
            return r().a(c0Var);
        }

        public abstract void v();

        public void w(long j10) {
            this.f1244c = j10;
        }

        public void x(long j10) {
            this.f1247f = j10;
        }

        public void y(b bVar) {
            this.f1242a = bVar;
        }

        public void z(long j10) {
            this.f1245d = j10;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class m implements l.b {
        public m() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l.b
        public void a(c0 c0Var) {
            c0Var.I(true);
            if (c0Var.f1226h != null && c0Var.f1227i == null) {
                c0Var.f1226h = null;
            }
            c0Var.f1227i = null;
            if (c0Var.K() || RecyclerView.this.c1(c0Var.f1219a) || !c0Var.z()) {
                return;
            }
            RecyclerView.this.removeDetachedView(c0Var.f1219a, false);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class n {
        public void f(Rect rect, int i10, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void g(Rect rect, View view, RecyclerView recyclerView, z zVar) {
            f(rect, ((p) view.getLayoutParams()).a(), recyclerView);
        }

        public void h(Canvas canvas, RecyclerView recyclerView) {
        }

        public void i(Canvas canvas, RecyclerView recyclerView, z zVar) {
            h(canvas, recyclerView);
        }

        public void j(Canvas canvas, RecyclerView recyclerView) {
        }

        public void k(Canvas canvas, RecyclerView recyclerView, z zVar) {
            j(canvas, recyclerView);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class o {

        /* renamed from: a, reason: collision with root package name */
        public androidx.recyclerview.widget.d f1253a;

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView f1254b;

        /* renamed from: c, reason: collision with root package name */
        public final w.b f1255c;

        /* renamed from: d, reason: collision with root package name */
        public final w.b f1256d;

        /* renamed from: e, reason: collision with root package name */
        public androidx.recyclerview.widget.w f1257e;

        /* renamed from: f, reason: collision with root package name */
        public androidx.recyclerview.widget.w f1258f;

        /* renamed from: g, reason: collision with root package name */
        public y f1259g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f1260h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f1261i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f1262j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f1263k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f1264l;

        /* renamed from: m, reason: collision with root package name */
        public int f1265m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f1266n;

        /* renamed from: o, reason: collision with root package name */
        public int f1267o;

        /* renamed from: p, reason: collision with root package name */
        public int f1268p;

        /* renamed from: q, reason: collision with root package name */
        public int f1269q;

        /* renamed from: r, reason: collision with root package name */
        public int f1270r;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public class a implements w.b {
            public a() {
            }

            @Override // androidx.recyclerview.widget.w.b
            public View a(int i10) {
                return o.this.J(i10);
            }

            @Override // androidx.recyclerview.widget.w.b
            public int b(View view) {
                return o.this.R(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).leftMargin;
            }

            @Override // androidx.recyclerview.widget.w.b
            public int c() {
                return o.this.f0();
            }

            @Override // androidx.recyclerview.widget.w.b
            public int d() {
                return o.this.p0() - o.this.g0();
            }

            @Override // androidx.recyclerview.widget.w.b
            public int e(View view) {
                return o.this.U(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).rightMargin;
            }
        }

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public class b implements w.b {
            public b() {
            }

            @Override // androidx.recyclerview.widget.w.b
            public View a(int i10) {
                return o.this.J(i10);
            }

            @Override // androidx.recyclerview.widget.w.b
            public int b(View view) {
                return o.this.V(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).topMargin;
            }

            @Override // androidx.recyclerview.widget.w.b
            public int c() {
                return o.this.h0();
            }

            @Override // androidx.recyclerview.widget.w.b
            public int d() {
                return o.this.X() - o.this.e0();
            }

            @Override // androidx.recyclerview.widget.w.b
            public int e(View view) {
                return o.this.P(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).bottomMargin;
            }
        }

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public interface c {
            void a(int i10, int i11);
        }

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public static class d {

            /* renamed from: a, reason: collision with root package name */
            public int f1273a;

            /* renamed from: b, reason: collision with root package name */
            public int f1274b;

            /* renamed from: c, reason: collision with root package name */
            public boolean f1275c;

            /* renamed from: d, reason: collision with root package name */
            public boolean f1276d;
        }

        public o() {
            a aVar = new a();
            this.f1255c = aVar;
            b bVar = new b();
            this.f1256d = bVar;
            this.f1257e = new androidx.recyclerview.widget.w(aVar);
            this.f1258f = new androidx.recyclerview.widget.w(bVar);
            this.f1260h = false;
            this.f1261i = false;
            this.f1262j = false;
            this.f1263k = true;
            this.f1264l = true;
        }

        public static int L(int i10, int i11, int i12, int i13, boolean z10) {
            int iMax = Math.max(0, i10 - i12);
            if (z10) {
                if (i13 < 0) {
                    if (i13 != -1 || (i11 != Integer.MIN_VALUE && (i11 == 0 || i11 != 1073741824))) {
                        i11 = 0;
                        i13 = 0;
                    } else {
                        i13 = iMax;
                    }
                }
                i11 = 1073741824;
            } else {
                if (i13 < 0) {
                    if (i13 != -1) {
                        if (i13 == -2) {
                            i11 = (i11 == Integer.MIN_VALUE || i11 == 1073741824) ? Integer.MIN_VALUE : 0;
                        }
                        i11 = 0;
                        i13 = 0;
                    }
                    i13 = iMax;
                }
                i11 = 1073741824;
            }
            return View.MeasureSpec.makeMeasureSpec(i13, i11);
        }

        public static d j0(Context context, AttributeSet attributeSet, int i10, int i11) {
            d dVar = new d();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k0.d.f8033f, i10, i11);
            dVar.f1273a = typedArrayObtainStyledAttributes.getInt(k0.d.f8034g, 1);
            dVar.f1274b = typedArrayObtainStyledAttributes.getInt(k0.d.f8044q, 1);
            dVar.f1275c = typedArrayObtainStyledAttributes.getBoolean(k0.d.f8043p, false);
            dVar.f1276d = typedArrayObtainStyledAttributes.getBoolean(k0.d.f8045r, false);
            typedArrayObtainStyledAttributes.recycle();
            return dVar;
        }

        public static int o(int i10, int i11, int i12) {
            int mode = View.MeasureSpec.getMode(i10);
            int size = View.MeasureSpec.getSize(i10);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i11, i12) : size : Math.min(size, Math.max(i11, i12));
        }

        public static boolean x0(int i10, int i11, int i12) {
            int mode = View.MeasureSpec.getMode(i11);
            int size = View.MeasureSpec.getSize(i11);
            if (i12 > 0 && i10 != i12) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i10;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i10;
            }
            return true;
        }

        public void A(RecyclerView recyclerView) {
            this.f1261i = true;
            H0(recyclerView);
        }

        public void A0(View view, int i10, int i11, int i12, int i13) {
            p pVar = (p) view.getLayoutParams();
            Rect rect = pVar.f1278b;
            view.layout(i10 + rect.left + ((ViewGroup.MarginLayoutParams) pVar).leftMargin, i11 + rect.top + ((ViewGroup.MarginLayoutParams) pVar).topMargin, (i12 - rect.right) - ((ViewGroup.MarginLayoutParams) pVar).rightMargin, (i13 - rect.bottom) - ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
        }

        public void A1(RecyclerView recyclerView) {
            B1(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public void B(RecyclerView recyclerView, v vVar) {
            this.f1261i = false;
            J0(recyclerView, vVar);
        }

        public void B0(View view, int i10, int i11) {
            p pVar = (p) view.getLayoutParams();
            Rect rectQ0 = this.f1254b.q0(view);
            int i12 = i10 + rectQ0.left + rectQ0.right;
            int i13 = i11 + rectQ0.top + rectQ0.bottom;
            int iL = L(p0(), q0(), f0() + g0() + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin + i12, ((ViewGroup.MarginLayoutParams) pVar).width, l());
            int iL2 = L(X(), Y(), h0() + e0() + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin + i13, ((ViewGroup.MarginLayoutParams) pVar).height, m());
            if (G1(view, iL, iL2, pVar)) {
                view.measure(iL, iL2);
            }
        }

        public void B1(int i10, int i11) {
            this.f1269q = View.MeasureSpec.getSize(i10);
            int mode = View.MeasureSpec.getMode(i10);
            this.f1267o = mode;
            if (mode == 0 && !RecyclerView.L0) {
                this.f1269q = 0;
            }
            this.f1270r = View.MeasureSpec.getSize(i11);
            int mode2 = View.MeasureSpec.getMode(i11);
            this.f1268p = mode2;
            if (mode2 != 0 || RecyclerView.L0) {
                return;
            }
            this.f1270r = 0;
        }

        public View C(View view) {
            View viewW;
            RecyclerView recyclerView = this.f1254b;
            if (recyclerView == null || (viewW = recyclerView.W(view)) == null || this.f1253a.n(viewW)) {
                return null;
            }
            return viewW;
        }

        public void C0(int i10, int i11) {
            View viewJ = J(i10);
            if (viewJ != null) {
                y(i10);
                i(viewJ, i11);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i10 + this.f1254b.toString());
            }
        }

        public void C1(int i10, int i11) {
            this.f1254b.setMeasuredDimension(i10, i11);
        }

        public View D(int i10) {
            int iK = K();
            for (int i11 = 0; i11 < iK; i11++) {
                View viewJ = J(i11);
                c0 c0VarL0 = RecyclerView.l0(viewJ);
                if (c0VarL0 != null && c0VarL0.o() == i10 && !c0VarL0.L() && (this.f1254b.f1183p0.e() || !c0VarL0.x())) {
                    return viewJ;
                }
            }
            return null;
        }

        public void D0(int i10) {
            RecyclerView recyclerView = this.f1254b;
            if (recyclerView != null) {
                recyclerView.G0(i10);
            }
        }

        public void D1(Rect rect, int i10, int i11) {
            C1(o(i10, rect.width() + f0() + g0(), d0()), o(i11, rect.height() + h0() + e0(), c0()));
        }

        public abstract p E();

        public void E0(int i10) {
            RecyclerView recyclerView = this.f1254b;
            if (recyclerView != null) {
                recyclerView.H0(i10);
            }
        }

        public void E1(int i10, int i11) {
            int iK = K();
            if (iK == 0) {
                this.f1254b.A(i10, i11);
                return;
            }
            int i12 = Integer.MIN_VALUE;
            int i13 = Integer.MIN_VALUE;
            int i14 = Integer.MAX_VALUE;
            int i15 = Integer.MAX_VALUE;
            for (int i16 = 0; i16 < iK; i16++) {
                View viewJ = J(i16);
                Rect rect = this.f1254b.f1184q;
                Q(viewJ, rect);
                int i17 = rect.left;
                if (i17 < i14) {
                    i14 = i17;
                }
                int i18 = rect.right;
                if (i18 > i12) {
                    i12 = i18;
                }
                int i19 = rect.top;
                if (i19 < i15) {
                    i15 = i19;
                }
                int i20 = rect.bottom;
                if (i20 > i13) {
                    i13 = i20;
                }
            }
            this.f1254b.f1184q.set(i14, i15, i12, i13);
            D1(this.f1254b.f1184q, i10, i11);
        }

        public p F(Context context, AttributeSet attributeSet) {
            return new p(context, attributeSet);
        }

        public void F0(Adapter adapter, Adapter adapter2) {
        }

        public void F1(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f1254b = null;
                this.f1253a = null;
                this.f1269q = 0;
                this.f1270r = 0;
            } else {
                this.f1254b = recyclerView;
                this.f1253a = recyclerView.f1176m;
                this.f1269q = recyclerView.getWidth();
                this.f1270r = recyclerView.getHeight();
            }
            this.f1267o = 1073741824;
            this.f1268p = 1073741824;
        }

        public p G(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof p ? new p((p) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new p((ViewGroup.MarginLayoutParams) layoutParams) : new p(layoutParams);
        }

        public boolean G0(RecyclerView recyclerView, ArrayList arrayList, int i10, int i11) {
            return false;
        }

        public boolean G1(View view, int i10, int i11, p pVar) {
            return (!view.isLayoutRequested() && this.f1263k && x0(view.getWidth(), i10, ((ViewGroup.MarginLayoutParams) pVar).width) && x0(view.getHeight(), i11, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public int H() {
            return -1;
        }

        public void H0(RecyclerView recyclerView) {
        }

        public boolean H1() {
            return false;
        }

        public int I(View view) {
            return ((p) view.getLayoutParams()).f1278b.bottom;
        }

        public void I0(RecyclerView recyclerView) {
        }

        public boolean I1(View view, int i10, int i11, p pVar) {
            return (this.f1263k && x0(view.getMeasuredWidth(), i10, ((ViewGroup.MarginLayoutParams) pVar).width) && x0(view.getMeasuredHeight(), i11, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public View J(int i10) {
            androidx.recyclerview.widget.d dVar = this.f1253a;
            if (dVar != null) {
                return dVar.f(i10);
            }
            return null;
        }

        public void J0(RecyclerView recyclerView, v vVar) {
            I0(recyclerView);
        }

        public abstract void J1(RecyclerView recyclerView, z zVar, int i10);

        public int K() {
            androidx.recyclerview.widget.d dVar = this.f1253a;
            if (dVar != null) {
                return dVar.g();
            }
            return 0;
        }

        public abstract View K0(View view, int i10, v vVar, z zVar);

        public void K1(y yVar) {
            y yVar2 = this.f1259g;
            if (yVar2 != null && yVar != yVar2 && yVar2.h()) {
                this.f1259g.r();
            }
            this.f1259g = yVar;
            yVar.q(this.f1254b, this);
        }

        public void L0(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f1254b;
            M0(recyclerView.f1170j, recyclerView.f1183p0, accessibilityEvent);
        }

        public void L1() {
            y yVar = this.f1259g;
            if (yVar != null) {
                yVar.r();
            }
        }

        public final int[] M(View view, Rect rect) {
            int iF0 = f0();
            int iH0 = h0();
            int iP0 = p0() - g0();
            int iX = X() - e0();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i10 = left - iF0;
            int iMin = Math.min(0, i10);
            int i11 = top - iH0;
            int iMin2 = Math.min(0, i11);
            int i12 = iWidth - iP0;
            int iMax = Math.max(0, i12);
            int iMax2 = Math.max(0, iHeight - iX);
            if (a0() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i10, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i12);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i11, iMax2);
            }
            return new int[]{iMax, iMin2};
        }

        public void M0(v vVar, z zVar, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f1254b;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z10 = true;
            if (!recyclerView.canScrollVertically(1) && !this.f1254b.canScrollVertically(-1) && !this.f1254b.canScrollHorizontally(-1) && !this.f1254b.canScrollHorizontally(1)) {
                z10 = false;
            }
            accessibilityEvent.setScrollable(z10);
            Adapter adapter = this.f1254b.f1190t;
            if (adapter != null) {
                accessibilityEvent.setItemCount(adapter.g());
            }
        }

        public abstract boolean M1();

        public boolean N() {
            RecyclerView recyclerView = this.f1254b;
            return recyclerView != null && recyclerView.f1180o;
        }

        public void N0(v vVar, z zVar, d0 d0Var) {
            if (this.f1254b.canScrollVertically(-1) || this.f1254b.canScrollHorizontally(-1)) {
                d0Var.a(8192);
                d0Var.h0(true);
            }
            if (this.f1254b.canScrollVertically(1) || this.f1254b.canScrollHorizontally(1)) {
                d0Var.a(4096);
                d0Var.h0(true);
            }
            d0Var.V(d0.b.a(l0(vVar, zVar), O(vVar, zVar), w0(vVar, zVar), m0(vVar, zVar)));
        }

        public int O(v vVar, z zVar) {
            return -1;
        }

        public void O0(d0 d0Var) {
            RecyclerView recyclerView = this.f1254b;
            N0(recyclerView.f1170j, recyclerView.f1183p0, d0Var);
        }

        public int P(View view) {
            return view.getBottom() + I(view);
        }

        public void P0(View view, d0 d0Var) {
            c0 c0VarL0 = RecyclerView.l0(view);
            if (c0VarL0 == null || c0VarL0.x() || this.f1253a.n(c0VarL0.f1219a)) {
                return;
            }
            RecyclerView recyclerView = this.f1254b;
            Q0(recyclerView.f1170j, recyclerView.f1183p0, view, d0Var);
        }

        public void Q(View view, Rect rect) {
            RecyclerView.n0(view, rect);
        }

        public void Q0(v vVar, z zVar, View view, d0 d0Var) {
        }

        public int R(View view) {
            return view.getLeft() - b0(view);
        }

        public View R0(View view, int i10) {
            return null;
        }

        public int S(View view) {
            Rect rect = ((p) view.getLayoutParams()).f1278b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void S0(RecyclerView recyclerView, int i10, int i11) {
        }

        public int T(View view) {
            Rect rect = ((p) view.getLayoutParams()).f1278b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public void T0(RecyclerView recyclerView) {
        }

        public int U(View view) {
            return view.getRight() + k0(view);
        }

        public void U0(RecyclerView recyclerView, int i10, int i11, int i12) {
        }

        public int V(View view) {
            return view.getTop() - n0(view);
        }

        public void V0(RecyclerView recyclerView, int i10, int i11) {
        }

        public View W() {
            View focusedChild;
            RecyclerView recyclerView = this.f1254b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f1253a.n(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void W0(RecyclerView recyclerView, int i10, int i11) {
        }

        public int X() {
            return this.f1270r;
        }

        public void X0(RecyclerView recyclerView, int i10, int i11, Object obj) {
            W0(recyclerView, i10, i11);
        }

        public int Y() {
            return this.f1268p;
        }

        public abstract void Y0(v vVar, z zVar);

        public int Z() {
            RecyclerView recyclerView = this.f1254b;
            Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.g();
            }
            return 0;
        }

        public void Z0(z zVar) {
        }

        public int a0() {
            return x.r.v(this.f1254b);
        }

        public void a1(v vVar, z zVar, int i10, int i11) {
            this.f1254b.A(i10, i11);
        }

        public int b0(View view) {
            return ((p) view.getLayoutParams()).f1278b.left;
        }

        public boolean b1(RecyclerView recyclerView, View view, View view2) {
            return y0() || recyclerView.A0();
        }

        public void c(View view) {
            d(view, -1);
        }

        public int c0() {
            return x.r.w(this.f1254b);
        }

        public boolean c1(RecyclerView recyclerView, z zVar, View view, View view2) {
            return b1(recyclerView, view, view2);
        }

        public void d(View view, int i10) {
            g(view, i10, true);
        }

        public int d0() {
            return x.r.x(this.f1254b);
        }

        public abstract void d1(Parcelable parcelable);

        public void e(View view) {
            f(view, -1);
        }

        public int e0() {
            RecyclerView recyclerView = this.f1254b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public abstract Parcelable e1();

        public void f(View view, int i10) {
            g(view, i10, false);
        }

        public int f0() {
            RecyclerView recyclerView = this.f1254b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public void f1(int i10) {
        }

        public final void g(View view, int i10, boolean z10) {
            c0 c0VarL0 = RecyclerView.l0(view);
            if (z10 || c0VarL0.x()) {
                this.f1254b.f1178n.b(c0VarL0);
            } else {
                this.f1254b.f1178n.p(c0VarL0);
            }
            p pVar = (p) view.getLayoutParams();
            if (c0VarL0.N() || c0VarL0.y()) {
                if (c0VarL0.y()) {
                    c0VarL0.M();
                } else {
                    c0VarL0.e();
                }
                this.f1253a.c(view, i10, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f1254b) {
                int iM = this.f1253a.m(view);
                if (i10 == -1) {
                    i10 = this.f1253a.g();
                }
                if (iM == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f1254b.indexOfChild(view) + this.f1254b.T());
                }
                if (iM != i10) {
                    this.f1254b.f1192u.C0(iM, i10);
                }
            } else {
                this.f1253a.a(view, i10, false);
                pVar.f1279c = true;
                y yVar = this.f1259g;
                if (yVar != null && yVar.h()) {
                    this.f1259g.k(view);
                }
            }
            if (pVar.f1280d) {
                c0VarL0.f1219a.invalidate();
                pVar.f1280d = false;
            }
        }

        public int g0() {
            RecyclerView recyclerView = this.f1254b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public void g1(y yVar) {
            if (this.f1259g == yVar) {
                this.f1259g = null;
            }
        }

        public void h(String str) {
            RecyclerView recyclerView = this.f1254b;
            if (recyclerView != null) {
                recyclerView.s(str);
            }
        }

        public int h0() {
            RecyclerView recyclerView = this.f1254b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public boolean h1(int i10, Bundle bundle) {
            RecyclerView recyclerView = this.f1254b;
            return i1(recyclerView.f1170j, recyclerView.f1183p0, i10, bundle);
        }

        public void i(View view, int i10) {
            j(view, i10, (p) view.getLayoutParams());
        }

        public int i0(View view) {
            return ((p) view.getLayoutParams()).a();
        }

        public boolean i1(v vVar, z zVar, int i10, Bundle bundle) {
            int iX;
            int iP0;
            int i11;
            int i12;
            RecyclerView recyclerView = this.f1254b;
            if (recyclerView == null) {
                return false;
            }
            if (i10 == 4096) {
                iX = recyclerView.canScrollVertically(1) ? (X() - h0()) - e0() : 0;
                if (this.f1254b.canScrollHorizontally(1)) {
                    iP0 = (p0() - f0()) - g0();
                    i11 = iX;
                    i12 = iP0;
                }
                i11 = iX;
                i12 = 0;
            } else if (i10 != 8192) {
                i12 = 0;
                i11 = 0;
            } else {
                iX = recyclerView.canScrollVertically(-1) ? -((X() - h0()) - e0()) : 0;
                if (this.f1254b.canScrollHorizontally(-1)) {
                    iP0 = -((p0() - f0()) - g0());
                    i11 = iX;
                    i12 = iP0;
                }
                i11 = iX;
                i12 = 0;
            }
            if (i11 == 0 && i12 == 0) {
                return false;
            }
            this.f1254b.w1(i12, i11, null, Integer.MIN_VALUE, true);
            return true;
        }

        public void j(View view, int i10, p pVar) {
            c0 c0VarL0 = RecyclerView.l0(view);
            if (c0VarL0.x()) {
                this.f1254b.f1178n.b(c0VarL0);
            } else {
                this.f1254b.f1178n.p(c0VarL0);
            }
            this.f1253a.c(view, i10, pVar, c0VarL0.x());
        }

        public boolean j1(View view, int i10, Bundle bundle) {
            RecyclerView recyclerView = this.f1254b;
            return k1(recyclerView.f1170j, recyclerView.f1183p0, view, i10, bundle);
        }

        public void k(View view, Rect rect) {
            RecyclerView recyclerView = this.f1254b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.q0(view));
            }
        }

        public int k0(View view) {
            return ((p) view.getLayoutParams()).f1278b.right;
        }

        public boolean k1(v vVar, z zVar, View view, int i10, Bundle bundle) {
            return false;
        }

        public abstract boolean l();

        public int l0(v vVar, z zVar) {
            return -1;
        }

        public void l1(v vVar) {
            for (int iK = K() - 1; iK >= 0; iK--) {
                if (!RecyclerView.l0(J(iK)).L()) {
                    o1(iK, vVar);
                }
            }
        }

        public abstract boolean m();

        public int m0(v vVar, z zVar) {
            return 0;
        }

        public void m1(v vVar) {
            int iJ = vVar.j();
            for (int i10 = iJ - 1; i10 >= 0; i10--) {
                View viewN = vVar.n(i10);
                c0 c0VarL0 = RecyclerView.l0(viewN);
                if (!c0VarL0.L()) {
                    c0VarL0.I(false);
                    if (c0VarL0.z()) {
                        this.f1254b.removeDetachedView(viewN, false);
                    }
                    l lVar = this.f1254b.U;
                    if (lVar != null) {
                        lVar.j(c0VarL0);
                    }
                    c0VarL0.I(true);
                    vVar.y(viewN);
                }
            }
            vVar.e();
            if (iJ > 0) {
                this.f1254b.invalidate();
            }
        }

        public boolean n(p pVar) {
            return pVar != null;
        }

        public int n0(View view) {
            return ((p) view.getLayoutParams()).f1278b.top;
        }

        public void n1(View view, v vVar) {
            q1(view);
            vVar.B(view);
        }

        public void o0(View view, boolean z10, Rect rect) {
            Matrix matrix;
            if (z10) {
                Rect rect2 = ((p) view.getLayoutParams()).f1278b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.f1254b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.f1254b.f1188s;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void o1(int i10, v vVar) {
            View viewJ = J(i10);
            r1(i10);
            vVar.B(viewJ);
        }

        public abstract void p(int i10, int i11, z zVar, c cVar);

        public int p0() {
            return this.f1269q;
        }

        public boolean p1(Runnable runnable) {
            RecyclerView recyclerView = this.f1254b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void q(int i10, c cVar) {
        }

        public int q0() {
            return this.f1267o;
        }

        public void q1(View view) {
            this.f1253a.p(view);
        }

        public abstract int r(z zVar);

        public boolean r0() {
            int iK = K();
            for (int i10 = 0; i10 < iK; i10++) {
                ViewGroup.LayoutParams layoutParams = J(i10).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public void r1(int i10) {
            if (J(i10) != null) {
                this.f1253a.q(i10);
            }
        }

        public abstract int s(z zVar);

        public boolean s0() {
            return this.f1261i;
        }

        public boolean s1(RecyclerView recyclerView, View view, Rect rect, boolean z10) {
            return t1(recyclerView, view, rect, z10, false);
        }

        public abstract int t(z zVar);

        public abstract boolean t0();

        public boolean t1(RecyclerView recyclerView, View view, Rect rect, boolean z10, boolean z11) {
            int[] iArrM = M(view, rect);
            int i10 = iArrM[0];
            int i11 = iArrM[1];
            if ((z11 && !u0(recyclerView, i10, i11)) || (i10 == 0 && i11 == 0)) {
                return false;
            }
            if (z10) {
                recyclerView.scrollBy(i10, i11);
            } else {
                recyclerView.t1(i10, i11);
            }
            return true;
        }

        public abstract int u(z zVar);

        public final boolean u0(RecyclerView recyclerView, int i10, int i11) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int iF0 = f0();
            int iH0 = h0();
            int iP0 = p0() - g0();
            int iX = X() - e0();
            Rect rect = this.f1254b.f1184q;
            Q(focusedChild, rect);
            return rect.left - i10 < iP0 && rect.right - i10 > iF0 && rect.top - i11 < iX && rect.bottom - i11 > iH0;
        }

        public void u1() {
            RecyclerView recyclerView = this.f1254b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public abstract int v(z zVar);

        public final boolean v0() {
            return this.f1264l;
        }

        public void v1() {
            this.f1260h = true;
        }

        public abstract int w(z zVar);

        public boolean w0(v vVar, z zVar) {
            return false;
        }

        public final void w1(v vVar, int i10, View view) {
            c0 c0VarL0 = RecyclerView.l0(view);
            if (c0VarL0.L()) {
                return;
            }
            if (c0VarL0.v() && !c0VarL0.x() && !this.f1254b.f1190t.k()) {
                r1(i10);
                vVar.C(c0VarL0);
            } else {
                y(i10);
                vVar.D(view);
                this.f1254b.f1178n.k(c0VarL0);
            }
        }

        public void x(v vVar) {
            for (int iK = K() - 1; iK >= 0; iK--) {
                w1(vVar, iK, J(iK));
            }
        }

        public abstract int x1(int i10, v vVar, z zVar);

        public void y(int i10) {
            z(i10, J(i10));
        }

        public boolean y0() {
            y yVar = this.f1259g;
            return yVar != null && yVar.h();
        }

        public abstract void y1(int i10);

        public final void z(int i10, View view) {
            this.f1253a.d(i10);
        }

        public boolean z0(View view, boolean z10, boolean z11) {
            boolean z12 = this.f1257e.b(view, 24579) && this.f1258f.b(view, 24579);
            return z10 ? z12 : !z12;
        }

        public abstract int z1(int i10, v vVar, z zVar);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class p extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public c0 f1277a;

        /* renamed from: b, reason: collision with root package name */
        public final Rect f1278b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f1279c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f1280d;

        public p(int i10, int i11) {
            super(i10, i11);
            this.f1278b = new Rect();
            this.f1279c = true;
            this.f1280d = false;
        }

        public p(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1278b = new Rect();
            this.f1279c = true;
            this.f1280d = false;
        }

        public p(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1278b = new Rect();
            this.f1279c = true;
            this.f1280d = false;
        }

        public p(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1278b = new Rect();
            this.f1279c = true;
            this.f1280d = false;
        }

        public p(p pVar) {
            super((ViewGroup.LayoutParams) pVar);
            this.f1278b = new Rect();
            this.f1279c = true;
            this.f1280d = false;
        }

        public int a() {
            return this.f1277a.o();
        }

        public boolean b() {
            return this.f1277a.A();
        }

        public boolean c() {
            return this.f1277a.x();
        }

        public boolean d() {
            return this.f1277a.v();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface q {
        void b(View view);

        void d(View view);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class r {
        public abstract boolean a(int i10, int i11);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface s {
        void a(RecyclerView recyclerView, MotionEvent motionEvent);

        boolean c(RecyclerView recyclerView, MotionEvent motionEvent);

        void e(boolean z10);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class t {
        public void a(RecyclerView recyclerView, int i10) {
        }

        public void b(RecyclerView recyclerView, int i10, int i11) {
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class u {

        /* renamed from: a, reason: collision with root package name */
        public SparseArray f1281a = new SparseArray();

        /* renamed from: b, reason: collision with root package name */
        public int f1282b = 0;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public final ArrayList f1283a = new ArrayList();

            /* renamed from: b, reason: collision with root package name */
            public int f1284b = 5;

            /* renamed from: c, reason: collision with root package name */
            public long f1285c = 0;

            /* renamed from: d, reason: collision with root package name */
            public long f1286d = 0;
        }

        public void a() {
            this.f1282b++;
        }

        public void b() {
            for (int i10 = 0; i10 < this.f1281a.size(); i10++) {
                ((a) this.f1281a.valueAt(i10)).f1283a.clear();
            }
        }

        public void c() {
            this.f1282b--;
        }

        public void d(int i10, long j10) {
            a aVarG = g(i10);
            aVarG.f1286d = j(aVarG.f1286d, j10);
        }

        public void e(int i10, long j10) {
            a aVarG = g(i10);
            aVarG.f1285c = j(aVarG.f1285c, j10);
        }

        public c0 f(int i10) {
            a aVar = (a) this.f1281a.get(i10);
            if (aVar == null || aVar.f1283a.isEmpty()) {
                return null;
            }
            ArrayList arrayList = aVar.f1283a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!((c0) arrayList.get(size)).t()) {
                    return (c0) arrayList.remove(size);
                }
            }
            return null;
        }

        public final a g(int i10) {
            a aVar = (a) this.f1281a.get(i10);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f1281a.put(i10, aVar2);
            return aVar2;
        }

        public void h(Adapter adapter, Adapter adapter2, boolean z10) {
            if (adapter != null) {
                c();
            }
            if (!z10 && this.f1282b == 0) {
                b();
            }
            if (adapter2 != null) {
                a();
            }
        }

        public void i(c0 c0Var) {
            int iN = c0Var.n();
            ArrayList arrayList = g(iN).f1283a;
            if (((a) this.f1281a.get(iN)).f1284b <= arrayList.size()) {
                return;
            }
            c0Var.F();
            arrayList.add(c0Var);
        }

        public long j(long j10, long j11) {
            return j10 == 0 ? j11 : ((j10 / 4) * 3) + (j11 / 4);
        }

        public boolean k(int i10, long j10, long j11) {
            long j12 = g(i10).f1286d;
            return j12 == 0 || j10 + j12 < j11;
        }

        public boolean l(int i10, long j10, long j11) {
            long j12 = g(i10).f1285c;
            return j12 == 0 || j10 + j12 < j11;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public final class v {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f1287a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList f1288b;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f1289c;

        /* renamed from: d, reason: collision with root package name */
        public final List f1290d;

        /* renamed from: e, reason: collision with root package name */
        public int f1291e;

        /* renamed from: f, reason: collision with root package name */
        public int f1292f;

        /* renamed from: g, reason: collision with root package name */
        public u f1293g;

        public v() {
            ArrayList arrayList = new ArrayList();
            this.f1287a = arrayList;
            this.f1288b = null;
            this.f1289c = new ArrayList();
            this.f1290d = Collections.unmodifiableList(arrayList);
            this.f1291e = 2;
            this.f1292f = 2;
        }

        public void A(int i10) {
            a((c0) this.f1289c.get(i10), true);
            this.f1289c.remove(i10);
        }

        public void B(View view) {
            c0 c0VarL0 = RecyclerView.l0(view);
            if (c0VarL0.z()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (c0VarL0.y()) {
                c0VarL0.M();
            } else if (c0VarL0.N()) {
                c0VarL0.e();
            }
            C(c0VarL0);
            if (RecyclerView.this.U == null || c0VarL0.w()) {
                return;
            }
            RecyclerView.this.U.j(c0VarL0);
        }

        public void C(c0 c0Var) {
            boolean z10;
            boolean z11 = true;
            if (c0Var.y() || c0Var.f1219a.getParent() != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Scrapped or attached views may not be recycled. isScrap:");
                sb2.append(c0Var.y());
                sb2.append(" isAttached:");
                sb2.append(c0Var.f1219a.getParent() != null);
                sb2.append(RecyclerView.this.T());
                throw new IllegalArgumentException(sb2.toString());
            }
            if (c0Var.z()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + c0Var + RecyclerView.this.T());
            }
            if (c0Var.L()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.T());
            }
            boolean zH = c0Var.h();
            Adapter adapter = RecyclerView.this.f1190t;
            if ((adapter != null && zH && adapter.A(c0Var)) || c0Var.w()) {
                if (this.f1292f <= 0 || c0Var.r(526)) {
                    z10 = false;
                } else {
                    int size = this.f1289c.size();
                    if (size >= this.f1292f && size > 0) {
                        A(0);
                        size--;
                    }
                    if (RecyclerView.N0 && size > 0 && !RecyclerView.this.f1181o0.d(c0Var.f1221c)) {
                        int i10 = size - 1;
                        while (i10 >= 0) {
                            if (!RecyclerView.this.f1181o0.d(((c0) this.f1289c.get(i10)).f1221c)) {
                                break;
                            } else {
                                i10--;
                            }
                        }
                        size = i10 + 1;
                    }
                    this.f1289c.add(size, c0Var);
                    z10 = true;
                }
                if (z10) {
                    z = z10;
                    z11 = false;
                } else {
                    a(c0Var, true);
                    z = z10;
                }
            } else {
                z11 = false;
            }
            RecyclerView.this.f1178n.q(c0Var);
            if (z || z11 || !zH) {
                return;
            }
            c0Var.f1237s = null;
            c0Var.f1236r = null;
        }

        public void D(View view) {
            c0 c0VarL0 = RecyclerView.l0(view);
            if (!c0VarL0.r(12) && c0VarL0.A() && !RecyclerView.this.t(c0VarL0)) {
                if (this.f1288b == null) {
                    this.f1288b = new ArrayList();
                }
                c0VarL0.J(this, true);
                this.f1288b.add(c0VarL0);
                return;
            }
            if (!c0VarL0.v() || c0VarL0.x() || RecyclerView.this.f1190t.k()) {
                c0VarL0.J(this, false);
                this.f1287a.add(c0VarL0);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.T());
            }
        }

        public void E(u uVar) {
            u uVar2 = this.f1293g;
            if (uVar2 != null) {
                uVar2.c();
            }
            this.f1293g = uVar;
            if (uVar == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.f1293g.a();
        }

        public void F(a0 a0Var) {
        }

        public void G(int i10) {
            this.f1291e = i10;
            K();
        }

        public final boolean H(c0 c0Var, int i10, int i11, long j10) {
            c0Var.f1237s = null;
            c0Var.f1236r = RecyclerView.this;
            int iN = c0Var.n();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j10 != Long.MAX_VALUE && !this.f1293g.k(iN, nanoTime, j10)) {
                return false;
            }
            RecyclerView.this.f1190t.c(c0Var, i10);
            this.f1293g.d(c0Var.n(), RecyclerView.this.getNanoTime() - nanoTime);
            b(c0Var);
            if (!RecyclerView.this.f1183p0.e()) {
                return true;
            }
            c0Var.f1225g = i11;
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x014a  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0176  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x01a1  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x01af  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x01cb A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:93:0x01ce  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public c0 I(int i10, boolean z10, long j10) {
            c0 c0VarE;
            c0 c0Var;
            boolean z11;
            ViewGroup.LayoutParams layoutParams;
            p pVar;
            RecyclerView recyclerViewA0;
            if (i10 < 0 || i10 >= RecyclerView.this.f1183p0.b()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i10 + "(" + i10 + "). Item count:" + RecyclerView.this.f1183p0.b() + RecyclerView.this.T());
            }
            if (RecyclerView.this.f1183p0.e()) {
                c0VarE = h(i10);
                boolean z12 = c0VarE != null;
                if (c0VarE == null && (c0VarE = m(i10, z10)) != null) {
                    if (L(c0VarE)) {
                        if (!z10) {
                            c0VarE.b(4);
                            if (c0VarE.y()) {
                                RecyclerView.this.removeDetachedView(c0VarE.f1219a, false);
                                c0VarE.M();
                            } else if (c0VarE.N()) {
                                c0VarE.e();
                            }
                            C(c0VarE);
                        }
                        c0VarE = null;
                    } else {
                        z12 = true;
                    }
                }
                if (c0VarE == null) {
                    int iM = RecyclerView.this.f1174l.m(i10);
                    if (iM < 0 || iM >= RecyclerView.this.f1190t.g()) {
                        throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i10 + "(offset:" + iM + ").state:" + RecyclerView.this.f1183p0.b() + RecyclerView.this.T());
                    }
                    int i11 = RecyclerView.this.f1190t.i(iM);
                    if (RecyclerView.this.f1190t.k() && (c0VarE = l(RecyclerView.this.f1190t.h(iM), i11, z10)) != null) {
                        c0VarE.f1221c = iM;
                        z12 = true;
                    }
                    if (c0VarE == null) {
                        c0 c0VarF = i().f(i11);
                        if (c0VarF != null) {
                            c0VarF.F();
                            if (RecyclerView.K0) {
                                r(c0VarF);
                            }
                        }
                        c0VarE = c0VarF;
                    }
                    if (c0VarE == null) {
                        long nanoTime = RecyclerView.this.getNanoTime();
                        if (j10 != Long.MAX_VALUE && !this.f1293g.l(i11, nanoTime, j10)) {
                            return null;
                        }
                        RecyclerView recyclerView = RecyclerView.this;
                        c0VarE = recyclerView.f1190t.e(recyclerView, i11);
                        if (RecyclerView.N0 && (recyclerViewA0 = RecyclerView.a0(c0VarE.f1219a)) != null) {
                            c0VarE.f1220b = new WeakReference(recyclerViewA0);
                        }
                        this.f1293g.e(i11, RecyclerView.this.getNanoTime() - nanoTime);
                    }
                }
                c0Var = c0VarE;
                z11 = z12;
                if (z11 && !RecyclerView.this.f1183p0.e() && c0Var.r(8192)) {
                    c0Var.H(0, 8192);
                    if (RecyclerView.this.f1183p0.f1321k) {
                        int iE = l.e(c0Var) | 4096;
                        RecyclerView recyclerView2 = RecyclerView.this;
                        RecyclerView.this.Y0(c0Var, recyclerView2.U.u(recyclerView2.f1183p0, c0Var, iE, c0Var.q()));
                    }
                }
                if (RecyclerView.this.f1183p0.e() || !c0Var.u()) {
                    boolean zH = (c0Var.u() || c0Var.B() || c0Var.v()) ? H(c0Var, RecyclerView.this.f1174l.m(i10), i10, j10) : false;
                    layoutParams = c0Var.f1219a.getLayoutParams();
                    if (layoutParams == null) {
                        pVar = (p) RecyclerView.this.generateDefaultLayoutParams();
                        c0Var.f1219a.setLayoutParams(pVar);
                    } else if (RecyclerView.this.checkLayoutParams(layoutParams)) {
                        pVar = (p) layoutParams;
                    } else {
                        pVar = (p) RecyclerView.this.generateLayoutParams(layoutParams);
                        c0Var.f1219a.setLayoutParams(pVar);
                    }
                    pVar.f1277a = c0Var;
                    pVar.f1280d = z11 && zH;
                    return c0Var;
                }
                c0Var.f1225g = i10;
                layoutParams = c0Var.f1219a.getLayoutParams();
                if (layoutParams == null) {
                }
                pVar.f1277a = c0Var;
                pVar.f1280d = z11 && zH;
                return c0Var;
            }
            c0VarE = null;
            if (c0VarE == null) {
                if (L(c0VarE)) {
                }
            }
            if (c0VarE == null) {
            }
            c0Var = c0VarE;
            z11 = z12;
            if (z11) {
                c0Var.H(0, 8192);
                if (RecyclerView.this.f1183p0.f1321k) {
                }
            }
            if (RecyclerView.this.f1183p0.e()) {
                if (c0Var.u()) {
                }
            }
            layoutParams = c0Var.f1219a.getLayoutParams();
            if (layoutParams == null) {
            }
            pVar.f1277a = c0Var;
            pVar.f1280d = z11 && zH;
            return c0Var;
        }

        public void J(c0 c0Var) {
            if (c0Var.f1233o) {
                this.f1288b.remove(c0Var);
            } else {
                this.f1287a.remove(c0Var);
            }
            c0Var.f1232n = null;
            c0Var.f1233o = false;
            c0Var.e();
        }

        public void K() {
            o oVar = RecyclerView.this.f1192u;
            this.f1292f = this.f1291e + (oVar != null ? oVar.f1265m : 0);
            for (int size = this.f1289c.size() - 1; size >= 0 && this.f1289c.size() > this.f1292f; size--) {
                A(size);
            }
        }

        public boolean L(c0 c0Var) {
            if (c0Var.x()) {
                return RecyclerView.this.f1183p0.e();
            }
            int i10 = c0Var.f1221c;
            if (i10 >= 0 && i10 < RecyclerView.this.f1190t.g()) {
                if (RecyclerView.this.f1183p0.e() || RecyclerView.this.f1190t.i(c0Var.f1221c) == c0Var.n()) {
                    return !RecyclerView.this.f1190t.k() || c0Var.m() == RecyclerView.this.f1190t.h(c0Var.f1221c);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + c0Var + RecyclerView.this.T());
        }

        public void M(int i10, int i11) {
            int i12;
            int i13 = i11 + i10;
            for (int size = this.f1289c.size() - 1; size >= 0; size--) {
                c0 c0Var = (c0) this.f1289c.get(size);
                if (c0Var != null && (i12 = c0Var.f1221c) >= i10 && i12 < i13) {
                    c0Var.b(2);
                    A(size);
                }
            }
        }

        public void a(c0 c0Var, boolean z10) {
            RecyclerView.v(c0Var);
            View view = c0Var.f1219a;
            androidx.recyclerview.widget.s sVar = RecyclerView.this.f1197w0;
            if (sVar != null) {
                x.a aVarN = sVar.n();
                x.r.X(view, aVarN instanceof s.a ? ((s.a) aVarN).n(view) : null);
            }
            if (z10) {
                g(c0Var);
            }
            c0Var.f1237s = null;
            c0Var.f1236r = null;
            i().i(c0Var);
        }

        public final void b(c0 c0Var) {
            if (RecyclerView.this.z0()) {
                View view = c0Var.f1219a;
                if (x.r.t(view) == 0) {
                    x.r.b0(view, 1);
                }
                androidx.recyclerview.widget.s sVar = RecyclerView.this.f1197w0;
                if (sVar == null) {
                    return;
                }
                x.a aVarN = sVar.n();
                if (aVarN instanceof s.a) {
                    ((s.a) aVarN).o(view);
                }
                x.r.X(view, aVarN);
            }
        }

        public void c() {
            this.f1287a.clear();
            z();
        }

        public void d() {
            int size = this.f1289c.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((c0) this.f1289c.get(i10)).c();
            }
            int size2 = this.f1287a.size();
            for (int i11 = 0; i11 < size2; i11++) {
                ((c0) this.f1287a.get(i11)).c();
            }
            ArrayList arrayList = this.f1288b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i12 = 0; i12 < size3; i12++) {
                    ((c0) this.f1288b.get(i12)).c();
                }
            }
        }

        public void e() {
            this.f1287a.clear();
            ArrayList arrayList = this.f1288b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int f(int i10) {
            if (i10 >= 0 && i10 < RecyclerView.this.f1183p0.b()) {
                return !RecyclerView.this.f1183p0.e() ? i10 : RecyclerView.this.f1174l.m(i10);
            }
            throw new IndexOutOfBoundsException("invalid position " + i10 + ". State item count is " + RecyclerView.this.f1183p0.b() + RecyclerView.this.T());
        }

        public void g(c0 c0Var) {
            RecyclerView.this.getClass();
            if (RecyclerView.this.f1194v.size() > 0) {
                n.g.a(RecyclerView.this.f1194v.get(0));
                throw null;
            }
            Adapter adapter = RecyclerView.this.f1190t;
            if (adapter != null) {
                adapter.D(c0Var);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f1183p0 != null) {
                recyclerView.f1178n.q(c0Var);
            }
        }

        public c0 h(int i10) {
            int size;
            int iM;
            ArrayList arrayList = this.f1288b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i11 = 0; i11 < size; i11++) {
                    c0 c0Var = (c0) this.f1288b.get(i11);
                    if (!c0Var.N() && c0Var.o() == i10) {
                        c0Var.b(32);
                        return c0Var;
                    }
                }
                if (RecyclerView.this.f1190t.k() && (iM = RecyclerView.this.f1174l.m(i10)) > 0 && iM < RecyclerView.this.f1190t.g()) {
                    long jH = RecyclerView.this.f1190t.h(iM);
                    for (int i12 = 0; i12 < size; i12++) {
                        c0 c0Var2 = (c0) this.f1288b.get(i12);
                        if (!c0Var2.N() && c0Var2.m() == jH) {
                            c0Var2.b(32);
                            return c0Var2;
                        }
                    }
                }
            }
            return null;
        }

        public u i() {
            if (this.f1293g == null) {
                this.f1293g = new u();
            }
            return this.f1293g;
        }

        public int j() {
            return this.f1287a.size();
        }

        public List k() {
            return this.f1290d;
        }

        public c0 l(long j10, int i10, boolean z10) {
            for (int size = this.f1287a.size() - 1; size >= 0; size--) {
                c0 c0Var = (c0) this.f1287a.get(size);
                if (c0Var.m() == j10 && !c0Var.N()) {
                    if (i10 == c0Var.n()) {
                        c0Var.b(32);
                        if (c0Var.x() && !RecyclerView.this.f1183p0.e()) {
                            c0Var.H(2, 14);
                        }
                        return c0Var;
                    }
                    if (!z10) {
                        this.f1287a.remove(size);
                        RecyclerView.this.removeDetachedView(c0Var.f1219a, false);
                        y(c0Var.f1219a);
                    }
                }
            }
            int size2 = this.f1289c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                c0 c0Var2 = (c0) this.f1289c.get(size2);
                if (c0Var2.m() == j10 && !c0Var2.t()) {
                    if (i10 == c0Var2.n()) {
                        if (!z10) {
                            this.f1289c.remove(size2);
                        }
                        return c0Var2;
                    }
                    if (!z10) {
                        A(size2);
                        return null;
                    }
                }
            }
        }

        public c0 m(int i10, boolean z10) {
            View viewE;
            int size = this.f1287a.size();
            for (int i11 = 0; i11 < size; i11++) {
                c0 c0Var = (c0) this.f1287a.get(i11);
                if (!c0Var.N() && c0Var.o() == i10 && !c0Var.v() && (RecyclerView.this.f1183p0.f1318h || !c0Var.x())) {
                    c0Var.b(32);
                    return c0Var;
                }
            }
            if (z10 || (viewE = RecyclerView.this.f1176m.e(i10)) == null) {
                int size2 = this.f1289c.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    c0 c0Var2 = (c0) this.f1289c.get(i12);
                    if (!c0Var2.v() && c0Var2.o() == i10 && !c0Var2.t()) {
                        if (!z10) {
                            this.f1289c.remove(i12);
                        }
                        return c0Var2;
                    }
                }
                return null;
            }
            c0 c0VarL0 = RecyclerView.l0(viewE);
            RecyclerView.this.f1176m.s(viewE);
            int iM = RecyclerView.this.f1176m.m(viewE);
            if (iM != -1) {
                RecyclerView.this.f1176m.d(iM);
                D(viewE);
                c0VarL0.b(8224);
                return c0VarL0;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + c0VarL0 + RecyclerView.this.T());
        }

        public View n(int i10) {
            return ((c0) this.f1287a.get(i10)).f1219a;
        }

        public View o(int i10) {
            return p(i10, false);
        }

        public View p(int i10, boolean z10) {
            return I(i10, z10, Long.MAX_VALUE).f1219a;
        }

        public final void q(ViewGroup viewGroup, boolean z10) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    q((ViewGroup) childAt, true);
                }
            }
            if (z10) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        public final void r(c0 c0Var) {
            View view = c0Var.f1219a;
            if (view instanceof ViewGroup) {
                q((ViewGroup) view, false);
            }
        }

        public void s() {
            int size = this.f1289c.size();
            for (int i10 = 0; i10 < size; i10++) {
                p pVar = (p) ((c0) this.f1289c.get(i10)).f1219a.getLayoutParams();
                if (pVar != null) {
                    pVar.f1279c = true;
                }
            }
        }

        public void t() {
            int size = this.f1289c.size();
            for (int i10 = 0; i10 < size; i10++) {
                c0 c0Var = (c0) this.f1289c.get(i10);
                if (c0Var != null) {
                    c0Var.b(6);
                    c0Var.a(null);
                }
            }
            Adapter adapter = RecyclerView.this.f1190t;
            if (adapter == null || !adapter.k()) {
                z();
            }
        }

        public void u(int i10, int i11) {
            int size = this.f1289c.size();
            for (int i12 = 0; i12 < size; i12++) {
                c0 c0Var = (c0) this.f1289c.get(i12);
                if (c0Var != null && c0Var.f1221c >= i10) {
                    c0Var.C(i11, false);
                }
            }
        }

        public void v(int i10, int i11) {
            int i12;
            int i13;
            int i14;
            int i15;
            if (i10 < i11) {
                i12 = -1;
                i14 = i10;
                i13 = i11;
            } else {
                i12 = 1;
                i13 = i10;
                i14 = i11;
            }
            int size = this.f1289c.size();
            for (int i16 = 0; i16 < size; i16++) {
                c0 c0Var = (c0) this.f1289c.get(i16);
                if (c0Var != null && (i15 = c0Var.f1221c) >= i14 && i15 <= i13) {
                    if (i15 == i10) {
                        c0Var.C(i11 - i10, false);
                    } else {
                        c0Var.C(i12, false);
                    }
                }
            }
        }

        public void w(int i10, int i11, boolean z10) {
            int i12 = i10 + i11;
            for (int size = this.f1289c.size() - 1; size >= 0; size--) {
                c0 c0Var = (c0) this.f1289c.get(size);
                if (c0Var != null) {
                    int i13 = c0Var.f1221c;
                    if (i13 >= i12) {
                        c0Var.C(-i11, z10);
                    } else if (i13 >= i10) {
                        c0Var.b(8);
                        A(size);
                    }
                }
            }
        }

        public void x(Adapter adapter, Adapter adapter2, boolean z10) {
            c();
            i().h(adapter, adapter2, z10);
        }

        public void y(View view) {
            c0 c0VarL0 = RecyclerView.l0(view);
            c0VarL0.f1232n = null;
            c0VarL0.f1233o = false;
            c0VarL0.e();
            C(c0VarL0);
        }

        public void z() {
            for (int size = this.f1289c.size() - 1; size >= 0; size--) {
                A(size);
            }
            this.f1289c.clear();
            if (RecyclerView.N0) {
                RecyclerView.this.f1181o0.b();
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface w {
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class x extends i {
        public x() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void a() {
            RecyclerView.this.s(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f1183p0.f1317g = true;
            recyclerView.W0(true);
            if (RecyclerView.this.f1174l.p()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void b(int i10, int i11, Object obj) {
            RecyclerView.this.s(null);
            if (RecyclerView.this.f1174l.r(i10, i11, obj)) {
                f();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void c(int i10, int i11) {
            RecyclerView.this.s(null);
            if (RecyclerView.this.f1174l.s(i10, i11)) {
                f();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void d(int i10, int i11, int i12) {
            RecyclerView.this.s(null);
            if (RecyclerView.this.f1174l.t(i10, i11, i12)) {
                f();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void e(int i10, int i11) {
            RecyclerView.this.s(null);
            if (RecyclerView.this.f1174l.u(i10, i11)) {
                f();
            }
        }

        public void f() {
            if (RecyclerView.M0) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.A && recyclerView.f1202z) {
                    x.r.P(recyclerView, recyclerView.f1182p);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.I = true;
            recyclerView2.requestLayout();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class y {

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView f1297b;

        /* renamed from: c, reason: collision with root package name */
        public o f1298c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f1299d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f1300e;

        /* renamed from: f, reason: collision with root package name */
        public View f1301f;

        /* renamed from: h, reason: collision with root package name */
        public boolean f1303h;

        /* renamed from: a, reason: collision with root package name */
        public int f1296a = -1;

        /* renamed from: g, reason: collision with root package name */
        public final a f1302g = new a(0, 0);

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public int f1304a;

            /* renamed from: b, reason: collision with root package name */
            public int f1305b;

            /* renamed from: c, reason: collision with root package name */
            public int f1306c;

            /* renamed from: d, reason: collision with root package name */
            public int f1307d;

            /* renamed from: e, reason: collision with root package name */
            public Interpolator f1308e;

            /* renamed from: f, reason: collision with root package name */
            public boolean f1309f;

            /* renamed from: g, reason: collision with root package name */
            public int f1310g;

            public a(int i10, int i11) {
                this(i10, i11, Integer.MIN_VALUE, null);
            }

            public a(int i10, int i11, int i12, Interpolator interpolator) {
                this.f1307d = -1;
                this.f1309f = false;
                this.f1310g = 0;
                this.f1304a = i10;
                this.f1305b = i11;
                this.f1306c = i12;
                this.f1308e = interpolator;
            }

            public boolean a() {
                return this.f1307d >= 0;
            }

            public void b(int i10) {
                this.f1307d = i10;
            }

            public void c(RecyclerView recyclerView) {
                int i10 = this.f1307d;
                if (i10 >= 0) {
                    this.f1307d = -1;
                    recyclerView.C0(i10);
                    this.f1309f = false;
                } else {
                    if (!this.f1309f) {
                        this.f1310g = 0;
                        return;
                    }
                    e();
                    recyclerView.f1177m0.e(this.f1304a, this.f1305b, this.f1306c, this.f1308e);
                    int i11 = this.f1310g + 1;
                    this.f1310g = i11;
                    if (i11 > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f1309f = false;
                }
            }

            public void d(int i10, int i11, int i12, Interpolator interpolator) {
                this.f1304a = i10;
                this.f1305b = i11;
                this.f1306c = i12;
                this.f1308e = interpolator;
                this.f1309f = true;
            }

            public final void e() {
                if (this.f1308e != null && this.f1306c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.f1306c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }
        }

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public interface b {
            PointF a(int i10);
        }

        public PointF a(int i10) {
            Object objE = e();
            if (objE instanceof b) {
                return ((b) objE).a(i10);
            }
            Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        }

        public View b(int i10) {
            return this.f1297b.f1192u.D(i10);
        }

        public int c() {
            return this.f1297b.f1192u.K();
        }

        public int d(View view) {
            return this.f1297b.j0(view);
        }

        public o e() {
            return this.f1298c;
        }

        public int f() {
            return this.f1296a;
        }

        public boolean g() {
            return this.f1299d;
        }

        public boolean h() {
            return this.f1300e;
        }

        public void i(PointF pointF) {
            float f10 = pointF.x;
            float f11 = pointF.y;
            float fSqrt = (float) Math.sqrt((f10 * f10) + (f11 * f11));
            pointF.x /= fSqrt;
            pointF.y /= fSqrt;
        }

        public void j(int i10, int i11) {
            PointF pointFA;
            RecyclerView recyclerView = this.f1297b;
            if (this.f1296a == -1 || recyclerView == null) {
                r();
            }
            if (this.f1299d && this.f1301f == null && this.f1298c != null && (pointFA = a(this.f1296a)) != null) {
                float f10 = pointFA.x;
                if (f10 != 0.0f || pointFA.y != 0.0f) {
                    recyclerView.o1((int) Math.signum(f10), (int) Math.signum(pointFA.y), null);
                }
            }
            this.f1299d = false;
            View view = this.f1301f;
            if (view != null) {
                if (d(view) == this.f1296a) {
                    o(this.f1301f, recyclerView.f1183p0, this.f1302g);
                    this.f1302g.c(recyclerView);
                    r();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f1301f = null;
                }
            }
            if (this.f1300e) {
                l(i10, i11, recyclerView.f1183p0, this.f1302g);
                boolean zA = this.f1302g.a();
                this.f1302g.c(recyclerView);
                if (zA && this.f1300e) {
                    this.f1299d = true;
                    recyclerView.f1177m0.d();
                }
            }
        }

        public void k(View view) {
            if (d(view) == f()) {
                this.f1301f = view;
            }
        }

        public abstract void l(int i10, int i11, z zVar, a aVar);

        public abstract void m();

        public abstract void n();

        public abstract void o(View view, z zVar, a aVar);

        public void p(int i10) {
            this.f1296a = i10;
        }

        public void q(RecyclerView recyclerView, o oVar) {
            recyclerView.f1177m0.f();
            if (this.f1303h) {
                Log.w("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.f1297b = recyclerView;
            this.f1298c = oVar;
            int i10 = this.f1296a;
            if (i10 == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.f1183p0.f1311a = i10;
            this.f1300e = true;
            this.f1299d = true;
            this.f1301f = b(f());
            m();
            this.f1297b.f1177m0.d();
            this.f1303h = true;
        }

        public final void r() {
            if (this.f1300e) {
                this.f1300e = false;
                n();
                this.f1297b.f1183p0.f1311a = -1;
                this.f1301f = null;
                this.f1296a = -1;
                this.f1299d = false;
                this.f1298c.g1(this);
                this.f1298c = null;
                this.f1297b = null;
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class z {

        /* renamed from: b, reason: collision with root package name */
        public SparseArray f1312b;

        /* renamed from: m, reason: collision with root package name */
        public int f1323m;

        /* renamed from: n, reason: collision with root package name */
        public long f1324n;

        /* renamed from: o, reason: collision with root package name */
        public int f1325o;

        /* renamed from: p, reason: collision with root package name */
        public int f1326p;

        /* renamed from: q, reason: collision with root package name */
        public int f1327q;

        /* renamed from: a, reason: collision with root package name */
        public int f1311a = -1;

        /* renamed from: c, reason: collision with root package name */
        public int f1313c = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f1314d = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f1315e = 1;

        /* renamed from: f, reason: collision with root package name */
        public int f1316f = 0;

        /* renamed from: g, reason: collision with root package name */
        public boolean f1317g = false;

        /* renamed from: h, reason: collision with root package name */
        public boolean f1318h = false;

        /* renamed from: i, reason: collision with root package name */
        public boolean f1319i = false;

        /* renamed from: j, reason: collision with root package name */
        public boolean f1320j = false;

        /* renamed from: k, reason: collision with root package name */
        public boolean f1321k = false;

        /* renamed from: l, reason: collision with root package name */
        public boolean f1322l = false;

        public void a(int i10) {
            if ((this.f1315e & i10) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i10) + " but it is " + Integer.toBinaryString(this.f1315e));
        }

        public int b() {
            return this.f1318h ? this.f1313c - this.f1314d : this.f1316f;
        }

        public int c() {
            return this.f1311a;
        }

        public boolean d() {
            return this.f1311a != -1;
        }

        public boolean e() {
            return this.f1318h;
        }

        public void f(Adapter adapter) {
            this.f1315e = 1;
            this.f1316f = adapter.g();
            this.f1318h = false;
            this.f1319i = false;
            this.f1320j = false;
        }

        public boolean g() {
            return this.f1322l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f1311a + ", mData=" + this.f1312b + ", mItemCount=" + this.f1316f + ", mIsMeasuring=" + this.f1320j + ", mPreviousLayoutItemCount=" + this.f1313c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f1314d + ", mStructureChanged=" + this.f1317g + ", mInPreLayout=" + this.f1318h + ", mRunSimpleAnimations=" + this.f1321k + ", mRunPredictiveAnimations=" + this.f1322l + '}';
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        K0 = i10 == 19 || i10 == 20;
        L0 = i10 >= 23;
        M0 = true;
        N0 = i10 >= 21;
        O0 = false;
        P0 = false;
        Class cls = Integer.TYPE;
        Q0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        R0 = new c();
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, k0.a.f8020a);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i10) throws NoSuchMethodException, SecurityException {
        super(context, attributeSet, i10);
        this.f1164e = new x();
        this.f1170j = new v();
        this.f1178n = new androidx.recyclerview.widget.x();
        this.f1182p = new a();
        this.f1184q = new Rect();
        this.f1186r = new Rect();
        this.f1188s = new RectF();
        this.f1194v = new ArrayList();
        this.f1196w = new ArrayList();
        this.f1198x = new ArrayList();
        this.D = 0;
        this.L = false;
        this.M = false;
        this.N = 0;
        this.O = 0;
        this.P = new k();
        this.U = new androidx.recyclerview.widget.e();
        this.V = 0;
        this.W = -1;
        this.f1171j0 = Float.MIN_VALUE;
        this.f1173k0 = Float.MIN_VALUE;
        boolean z10 = true;
        this.f1175l0 = true;
        this.f1177m0 = new b0();
        this.f1181o0 = N0 ? new i.b() : null;
        this.f1183p0 = new z();
        this.f1189s0 = false;
        this.f1191t0 = false;
        this.f1193u0 = new m();
        this.f1195v0 = false;
        this.f1201y0 = new int[2];
        this.A0 = new int[2];
        this.B0 = new int[2];
        this.C0 = new int[2];
        this.D0 = new ArrayList();
        this.E0 = new b();
        this.G0 = 0;
        this.H0 = 0;
        this.I0 = new d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f1166f0 = viewConfiguration.getScaledTouchSlop();
        this.f1171j0 = x.t.b(viewConfiguration, context);
        this.f1173k0 = x.t.c(viewConfiguration, context);
        this.f1168h0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1169i0 = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.U.y(this.f1193u0);
        u0();
        w0();
        v0();
        if (x.r.t(this) == 0) {
            x.r.b0(this, 1);
        }
        this.J = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new androidx.recyclerview.widget.s(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k0.d.f8033f, i10, 0);
        x.r.V(this, context, k0.d.f8033f, attributeSet, typedArrayObtainStyledAttributes, i10, 0);
        String string = typedArrayObtainStyledAttributes.getString(k0.d.f8042o);
        if (typedArrayObtainStyledAttributes.getInt(k0.d.f8036i, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.f1180o = typedArrayObtainStyledAttributes.getBoolean(k0.d.f8035h, true);
        boolean z11 = typedArrayObtainStyledAttributes.getBoolean(k0.d.f8037j, false);
        this.B = z11;
        if (z11) {
            x0((StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(k0.d.f8040m), typedArrayObtainStyledAttributes.getDrawable(k0.d.f8041n), (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(k0.d.f8038k), typedArrayObtainStyledAttributes.getDrawable(k0.d.f8039l));
        }
        typedArrayObtainStyledAttributes.recycle();
        z(context, string, attributeSet, i10, 0);
        if (Build.VERSION.SDK_INT >= 21) {
            int[] iArr = J0;
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i10, 0);
            x.r.V(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes2, i10, 0);
            z10 = typedArrayObtainStyledAttributes2.getBoolean(0, true);
            typedArrayObtainStyledAttributes2.recycle();
        }
        setNestedScrollingEnabled(z10);
    }

    public static RecyclerView a0(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            RecyclerView recyclerViewA0 = a0(viewGroup.getChildAt(i10));
            if (recyclerViewA0 != null) {
                return recyclerViewA0;
            }
        }
        return null;
    }

    private x.l getScrollingChildHelper() {
        if (this.f1203z0 == null) {
            this.f1203z0 = new x.l(this);
        }
        return this.f1203z0;
    }

    public static c0 l0(View view) {
        if (view == null) {
            return null;
        }
        return ((p) view.getLayoutParams()).f1277a;
    }

    public static void n0(View view, Rect rect) {
        p pVar = (p) view.getLayoutParams();
        Rect rect2 = pVar.f1278b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) pVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) pVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
    }

    public static void v(c0 c0Var) {
        WeakReference weakReference = c0Var.f1220b;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            while (view != null) {
                if (view == c0Var.f1219a) {
                    return;
                }
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            c0Var.f1220b = null;
        }
    }

    public void A(int i10, int i11) {
        setMeasuredDimension(o.o(i10, getPaddingLeft() + getPaddingRight(), x.r.x(this)), o.o(i11, getPaddingTop() + getPaddingBottom(), x.r.w(this)));
    }

    public boolean A0() {
        return this.N > 0;
    }

    public void A1(boolean z10) {
        if (this.D < 1) {
            this.D = 1;
        }
        if (!z10 && !this.F) {
            this.E = false;
        }
        if (this.D == 1) {
            if (z10 && this.E && !this.F && this.f1192u != null && this.f1190t != null) {
                F();
            }
            if (!this.F) {
                this.E = false;
            }
        }
        this.D--;
    }

    public final boolean B(int i10, int i11) {
        Z(this.f1201y0);
        int[] iArr = this.f1201y0;
        return (iArr[0] == i10 && iArr[1] == i11) ? false : true;
    }

    public final boolean B0(View view, View view2, int i10) {
        int i11;
        if (view2 == null || view2 == this || view2 == view || W(view2) == null) {
            return false;
        }
        if (view == null || W(view) == null) {
            return true;
        }
        this.f1184q.set(0, 0, view.getWidth(), view.getHeight());
        this.f1186r.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.f1184q);
        offsetDescendantRectToMyCoords(view2, this.f1186r);
        char c10 = '\uffff';
        int i12 = this.f1192u.a0() == 1 ? -1 : 1;
        Rect rect = this.f1184q;
        int i13 = rect.left;
        Rect rect2 = this.f1186r;
        int i14 = rect2.left;
        if ((i13 < i14 || rect.right <= i14) && rect.right < rect2.right) {
            i11 = 1;
        } else {
            int i15 = rect.right;
            int i16 = rect2.right;
            i11 = ((i15 > i16 || i13 >= i16) && i13 > i14) ? -1 : 0;
        }
        int i17 = rect.top;
        int i18 = rect2.top;
        if ((i17 < i18 || rect.bottom <= i18) && rect.bottom < rect2.bottom) {
            c10 = 1;
        } else {
            int i19 = rect.bottom;
            int i20 = rect2.bottom;
            if ((i19 <= i20 && i17 < i20) || i17 <= i18) {
                c10 = 0;
            }
        }
        if (i10 == 1) {
            return c10 < 0 || (c10 == 0 && i11 * i12 < 0);
        }
        if (i10 == 2) {
            return c10 > 0 || (c10 == 0 && i11 * i12 > 0);
        }
        if (i10 == 17) {
            return i11 < 0;
        }
        if (i10 == 33) {
            return c10 < 0;
        }
        if (i10 == 66) {
            return i11 > 0;
        }
        if (i10 == 130) {
            return c10 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i10 + T());
    }

    public void B1(int i10) {
        getScrollingChildHelper().r(i10);
    }

    public void C(View view) {
        c0 c0VarL0 = l0(view);
        L0(view);
        Adapter adapter = this.f1190t;
        if (adapter != null && c0VarL0 != null) {
            adapter.B(c0VarL0);
        }
        List list = this.K;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((q) this.K.get(size)).d(view);
            }
        }
    }

    public void C0(int i10) {
        if (this.f1192u == null) {
            return;
        }
        setScrollState(2);
        this.f1192u.y1(i10);
        awakenScrollBars();
    }

    public void C1() {
        setScrollState(0);
        D1();
    }

    public void D(View view) {
        c0 c0VarL0 = l0(view);
        M0(view);
        Adapter adapter = this.f1190t;
        if (adapter != null && c0VarL0 != null) {
            adapter.C(c0VarL0);
        }
        List list = this.K;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((q) this.K.get(size)).b(view);
            }
        }
    }

    public void D0() {
        int iJ = this.f1176m.j();
        for (int i10 = 0; i10 < iJ; i10++) {
            ((p) this.f1176m.i(i10).getLayoutParams()).f1279c = true;
        }
        this.f1170j.s();
    }

    public final void D1() {
        this.f1177m0.f();
        o oVar = this.f1192u;
        if (oVar != null) {
            oVar.L1();
        }
    }

    public final void E() {
        int i10 = this.H;
        this.H = 0;
        if (i10 == 0 || !z0()) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
        accessibilityEventObtain.setEventType(2048);
        y.b.b(accessibilityEventObtain, i10);
        sendAccessibilityEventUnchecked(accessibilityEventObtain);
    }

    public void E0() {
        int iJ = this.f1176m.j();
        for (int i10 = 0; i10 < iJ; i10++) {
            c0 c0VarL0 = l0(this.f1176m.i(i10));
            if (c0VarL0 != null && !c0VarL0.L()) {
                c0VarL0.b(6);
            }
        }
        D0();
        this.f1170j.t();
    }

    public void E1(int i10, int i11, Object obj) {
        int i12;
        int iJ = this.f1176m.j();
        int i13 = i10 + i11;
        for (int i14 = 0; i14 < iJ; i14++) {
            View viewI = this.f1176m.i(i14);
            c0 c0VarL0 = l0(viewI);
            if (c0VarL0 != null && !c0VarL0.L() && (i12 = c0VarL0.f1221c) >= i10 && i12 < i13) {
                c0VarL0.b(2);
                c0VarL0.a(obj);
                ((p) viewI.getLayoutParams()).f1279c = true;
            }
        }
        this.f1170j.M(i10, i11);
    }

    public void F() {
        if (this.f1190t == null) {
            Log.w("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.f1192u == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        this.f1183p0.f1320j = false;
        boolean z10 = this.F0 && !(this.G0 == getWidth() && this.H0 == getHeight());
        this.G0 = 0;
        this.H0 = 0;
        this.F0 = false;
        if (this.f1183p0.f1315e == 1) {
            G();
            this.f1192u.A1(this);
            H();
        } else if (this.f1174l.q() || z10 || this.f1192u.p0() != getWidth() || this.f1192u.X() != getHeight()) {
            this.f1192u.A1(this);
            H();
        } else {
            this.f1192u.A1(this);
        }
        I();
    }

    public final void F0(int i10, int i11, MotionEvent motionEvent, int i12) {
        o oVar = this.f1192u;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.F) {
            return;
        }
        int[] iArr = this.C0;
        iArr[0] = 0;
        iArr[1] = 0;
        boolean zL = oVar.l();
        boolean zM = this.f1192u.m();
        z1(zM ? (zL ? 1 : 0) | 2 : zL ? 1 : 0, i12);
        if (J(zL ? i10 : 0, zM ? i11 : 0, this.C0, this.A0, i12)) {
            int[] iArr2 = this.C0;
            i10 -= iArr2[0];
            i11 -= iArr2[1];
        }
        n1(zL ? i10 : 0, zM ? i11 : 0, motionEvent, i12);
        androidx.recyclerview.widget.i iVar = this.f1179n0;
        if (iVar != null && (i10 != 0 || i11 != 0)) {
            iVar.f(this, i10, i11);
        }
        B1(i12);
    }

    public final void G() {
        this.f1183p0.a(1);
        U(this.f1183p0);
        this.f1183p0.f1320j = false;
        y1();
        this.f1178n.f();
        N0();
        V0();
        l1();
        z zVar = this.f1183p0;
        zVar.f1319i = zVar.f1321k && this.f1191t0;
        this.f1191t0 = false;
        this.f1189s0 = false;
        zVar.f1318h = zVar.f1322l;
        zVar.f1316f = this.f1190t.g();
        Z(this.f1201y0);
        if (this.f1183p0.f1321k) {
            int iG = this.f1176m.g();
            for (int i10 = 0; i10 < iG; i10++) {
                c0 c0VarL0 = l0(this.f1176m.f(i10));
                if (!c0VarL0.L() && (!c0VarL0.v() || this.f1190t.k())) {
                    this.f1178n.e(c0VarL0, this.U.u(this.f1183p0, c0VarL0, l.e(c0VarL0), c0VarL0.q()));
                    if (this.f1183p0.f1319i && c0VarL0.A() && !c0VarL0.x() && !c0VarL0.L() && !c0VarL0.v()) {
                        this.f1178n.c(h0(c0VarL0), c0VarL0);
                    }
                }
            }
        }
        if (this.f1183p0.f1322l) {
            m1();
            z zVar2 = this.f1183p0;
            boolean z10 = zVar2.f1317g;
            zVar2.f1317g = false;
            this.f1192u.Y0(this.f1170j, zVar2);
            this.f1183p0.f1317g = z10;
            for (int i11 = 0; i11 < this.f1176m.g(); i11++) {
                c0 c0VarL02 = l0(this.f1176m.f(i11));
                if (!c0VarL02.L() && !this.f1178n.i(c0VarL02)) {
                    int iE = l.e(c0VarL02);
                    boolean zR = c0VarL02.r(8192);
                    if (!zR) {
                        iE |= 4096;
                    }
                    l.c cVarU = this.U.u(this.f1183p0, c0VarL02, iE, c0VarL02.q());
                    if (zR) {
                        Y0(c0VarL02, cVarU);
                    } else {
                        this.f1178n.a(c0VarL02, cVarU);
                    }
                }
            }
            w();
        } else {
            w();
        }
        O0();
        A1(false);
        this.f1183p0.f1315e = 2;
    }

    public void G0(int i10) {
        int iG = this.f1176m.g();
        for (int i11 = 0; i11 < iG; i11++) {
            this.f1176m.f(i11).offsetLeftAndRight(i10);
        }
    }

    public final void H() {
        y1();
        N0();
        this.f1183p0.a(6);
        this.f1174l.j();
        this.f1183p0.f1316f = this.f1190t.g();
        this.f1183p0.f1314d = 0;
        if (this.f1172k != null && this.f1190t.d()) {
            Parcelable parcelable = this.f1172k.f1208k;
            if (parcelable != null) {
                this.f1192u.d1(parcelable);
            }
            this.f1172k = null;
        }
        z zVar = this.f1183p0;
        zVar.f1318h = false;
        this.f1192u.Y0(this.f1170j, zVar);
        z zVar2 = this.f1183p0;
        zVar2.f1317g = false;
        zVar2.f1321k = zVar2.f1321k && this.U != null;
        zVar2.f1315e = 4;
        O0();
        A1(false);
    }

    public void H0(int i10) {
        int iG = this.f1176m.g();
        for (int i11 = 0; i11 < iG; i11++) {
            this.f1176m.f(i11).offsetTopAndBottom(i10);
        }
    }

    public final void I() {
        RecyclerView recyclerView;
        this.f1183p0.a(4);
        y1();
        N0();
        z zVar = this.f1183p0;
        zVar.f1315e = 1;
        if (zVar.f1321k) {
            for (int iG = this.f1176m.g() - 1; iG >= 0; iG--) {
                c0 c0VarL0 = l0(this.f1176m.f(iG));
                if (!c0VarL0.L()) {
                    long jH0 = h0(c0VarL0);
                    l.c cVarT = this.U.t(this.f1183p0, c0VarL0);
                    c0 c0VarG = this.f1178n.g(jH0);
                    if (c0VarG == null || c0VarG.L()) {
                        this.f1178n.d(c0VarL0, cVarT);
                    } else {
                        boolean zH = this.f1178n.h(c0VarG);
                        boolean zH2 = this.f1178n.h(c0VarL0);
                        if (zH && c0VarG == c0VarL0) {
                            this.f1178n.d(c0VarL0, cVarT);
                        } else {
                            l.c cVarN = this.f1178n.n(c0VarG);
                            this.f1178n.d(c0VarL0, cVarT);
                            l.c cVarM = this.f1178n.m(c0VarL0);
                            if (cVarN == null) {
                                r0(jH0, c0VarL0, c0VarG);
                            } else {
                                q(c0VarG, c0VarL0, cVarN, cVarM, zH, zH2);
                            }
                        }
                    }
                }
            }
            recyclerView = this;
            recyclerView.f1178n.o(recyclerView.I0);
        } else {
            recyclerView = this;
        }
        recyclerView.f1192u.m1(recyclerView.f1170j);
        z zVar2 = recyclerView.f1183p0;
        zVar2.f1313c = zVar2.f1316f;
        recyclerView.L = false;
        recyclerView.M = false;
        zVar2.f1321k = false;
        zVar2.f1322l = false;
        recyclerView.f1192u.f1260h = false;
        ArrayList arrayList = recyclerView.f1170j.f1288b;
        if (arrayList != null) {
            arrayList.clear();
        }
        o oVar = recyclerView.f1192u;
        if (oVar.f1266n) {
            oVar.f1265m = 0;
            oVar.f1266n = false;
            recyclerView.f1170j.K();
        }
        recyclerView.f1192u.Z0(recyclerView.f1183p0);
        O0();
        A1(false);
        recyclerView.f1178n.f();
        int[] iArr = recyclerView.f1201y0;
        if (B(iArr[0], iArr[1])) {
            M(0, 0);
        }
        Z0();
        j1();
    }

    public void I0(int i10, int i11) {
        int iJ = this.f1176m.j();
        for (int i12 = 0; i12 < iJ; i12++) {
            c0 c0VarL0 = l0(this.f1176m.i(i12));
            if (c0VarL0 != null && !c0VarL0.L() && c0VarL0.f1221c >= i10) {
                c0VarL0.C(i11, false);
                this.f1183p0.f1317g = true;
            }
        }
        this.f1170j.u(i10, i11);
        requestLayout();
    }

    public boolean J(int i10, int i11, int[] iArr, int[] iArr2, int i12) {
        return getScrollingChildHelper().d(i10, i11, iArr, iArr2, i12);
    }

    public void J0(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int iJ = this.f1176m.j();
        if (i10 < i11) {
            i14 = -1;
            i13 = i10;
            i12 = i11;
        } else {
            i12 = i10;
            i13 = i11;
            i14 = 1;
        }
        for (int i16 = 0; i16 < iJ; i16++) {
            c0 c0VarL0 = l0(this.f1176m.i(i16));
            if (c0VarL0 != null && (i15 = c0VarL0.f1221c) >= i13 && i15 <= i12) {
                if (i15 == i10) {
                    c0VarL0.C(i11 - i10, false);
                } else {
                    c0VarL0.C(i14, false);
                }
                this.f1183p0.f1317g = true;
            }
        }
        this.f1170j.v(i10, i11);
        requestLayout();
    }

    public final void K(int i10, int i11, int i12, int i13, int[] iArr, int i14, int[] iArr2) {
        getScrollingChildHelper().e(i10, i11, i12, i13, iArr, i14, iArr2);
    }

    public void K0(int i10, int i11, boolean z10) {
        int i12 = i10 + i11;
        int iJ = this.f1176m.j();
        for (int i13 = 0; i13 < iJ; i13++) {
            c0 c0VarL0 = l0(this.f1176m.i(i13));
            if (c0VarL0 != null && !c0VarL0.L()) {
                int i14 = c0VarL0.f1221c;
                if (i14 >= i12) {
                    c0VarL0.C(-i11, z10);
                    this.f1183p0.f1317g = true;
                } else if (i14 >= i10) {
                    c0VarL0.i(i10 - 1, -i11, z10);
                    this.f1183p0.f1317g = true;
                }
            }
        }
        this.f1170j.w(i10, i11, z10);
        requestLayout();
    }

    public void L(int i10) {
        o oVar = this.f1192u;
        if (oVar != null) {
            oVar.f1(i10);
        }
        R0(i10);
        t tVar = this.f1185q0;
        if (tVar != null) {
            tVar.a(this, i10);
        }
        List list = this.f1187r0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((t) this.f1187r0.get(size)).a(this, i10);
            }
        }
    }

    public void L0(View view) {
    }

    public void M(int i10, int i11) {
        this.O++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i10, scrollY - i11);
        S0(i10, i11);
        t tVar = this.f1185q0;
        if (tVar != null) {
            tVar.b(this, i10, i11);
        }
        List list = this.f1187r0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((t) this.f1187r0.get(size)).b(this, i10, i11);
            }
        }
        this.O--;
    }

    public void M0(View view) {
    }

    public void N() {
        int i10;
        for (int size = this.D0.size() - 1; size >= 0; size--) {
            c0 c0Var = (c0) this.D0.get(size);
            if (c0Var.f1219a.getParent() == this && !c0Var.L() && (i10 = c0Var.f1235q) != -1) {
                x.r.b0(c0Var.f1219a, i10);
                c0Var.f1235q = -1;
            }
        }
        this.D0.clear();
    }

    public void N0() {
        this.N++;
    }

    public final boolean O(MotionEvent motionEvent) {
        s sVar = this.f1200y;
        if (sVar == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return Y(motionEvent);
        }
        sVar.a(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.f1200y = null;
        }
        return true;
    }

    public void O0() {
        P0(true);
    }

    public void P() {
        if (this.T != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.P.a(this, 3);
        this.T = edgeEffectA;
        if (this.f1180o) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void P0(boolean z10) {
        int i10 = this.N - 1;
        this.N = i10;
        if (i10 < 1) {
            this.N = 0;
            if (z10) {
                E();
                N();
            }
        }
    }

    public void Q() {
        if (this.Q != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.P.a(this, 0);
        this.Q = edgeEffectA;
        if (this.f1180o) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final void Q0(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.W) {
            int i10 = actionIndex == 0 ? 1 : 0;
            this.W = motionEvent.getPointerId(i10);
            int x10 = (int) (motionEvent.getX(i10) + 0.5f);
            this.f1163d0 = x10;
            this.f1161b0 = x10;
            int y10 = (int) (motionEvent.getY(i10) + 0.5f);
            this.f1165e0 = y10;
            this.f1162c0 = y10;
        }
    }

    public void R() {
        if (this.S != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.P.a(this, 2);
        this.S = edgeEffectA;
        if (this.f1180o) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void R0(int i10) {
    }

    public void S() {
        if (this.R != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.P.a(this, 1);
        this.R = edgeEffectA;
        if (this.f1180o) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void S0(int i10, int i11) {
    }

    public String T() {
        return " " + super.toString() + ", adapter:" + this.f1190t + ", layout:" + this.f1192u + ", context:" + getContext();
    }

    public void T0() {
        if (this.f1195v0 || !this.f1202z) {
            return;
        }
        x.r.P(this, this.E0);
        this.f1195v0 = true;
    }

    public final void U(z zVar) {
        if (getScrollState() != 2) {
            zVar.f1326p = 0;
            zVar.f1327q = 0;
        } else {
            OverScroller overScroller = this.f1177m0.f1213k;
            zVar.f1326p = overScroller.getFinalX() - overScroller.getCurrX();
            zVar.f1327q = overScroller.getFinalY() - overScroller.getCurrY();
        }
    }

    public final boolean U0() {
        return this.U != null && this.f1192u.M1();
    }

    public View V(float f10, float f11) {
        for (int iG = this.f1176m.g() - 1; iG >= 0; iG--) {
            View viewF = this.f1176m.f(iG);
            float translationX = viewF.getTranslationX();
            float translationY = viewF.getTranslationY();
            if (f10 >= viewF.getLeft() + translationX && f10 <= viewF.getRight() + translationX && f11 >= viewF.getTop() + translationY && f11 <= viewF.getBottom() + translationY) {
                return viewF;
            }
        }
        return null;
    }

    public final void V0() {
        boolean z10;
        if (this.L) {
            this.f1174l.y();
            if (this.M) {
                this.f1192u.T0(this);
            }
        }
        if (U0()) {
            this.f1174l.w();
        } else {
            this.f1174l.j();
        }
        boolean z11 = this.f1189s0 || this.f1191t0;
        this.f1183p0.f1321k = this.C && this.U != null && ((z10 = this.L) || z11 || this.f1192u.f1260h) && (!z10 || this.f1190t.k());
        z zVar = this.f1183p0;
        zVar.f1322l = zVar.f1321k && z11 && !this.L && U0();
    }

    public View W(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public void W0(boolean z10) {
        this.M = z10 | this.M;
        this.L = true;
        E0();
    }

    public c0 X(View view) {
        View viewW = W(view);
        if (viewW == null) {
            return null;
        }
        return k0(viewW);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void X0(float f10, float f11, float f12, float f13) {
        boolean z10;
        boolean z11 = true;
        if (f11 < 0.0f) {
            Q();
            androidx.core.widget.a.a(this.Q, (-f11) / getWidth(), 1.0f - (f12 / getHeight()));
        } else {
            if (f11 <= 0.0f) {
                z10 = false;
                if (f13 >= 0.0f) {
                    S();
                    androidx.core.widget.a.a(this.R, (-f13) / getHeight(), f10 / getWidth());
                } else if (f13 > 0.0f) {
                    P();
                    androidx.core.widget.a.a(this.T, f13 / getHeight(), 1.0f - (f10 / getWidth()));
                } else {
                    z11 = z10;
                }
                if (z11 && f11 == 0.0f && f13 == 0.0f) {
                    return;
                }
                x.r.O(this);
            }
            R();
            androidx.core.widget.a.a(this.S, f11 / getWidth(), f12 / getHeight());
        }
        z10 = true;
        if (f13 >= 0.0f) {
        }
        if (z11) {
        }
        x.r.O(this);
    }

    public final boolean Y(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.f1198x.size();
        for (int i10 = 0; i10 < size; i10++) {
            s sVar = (s) this.f1198x.get(i10);
            if (sVar.c(this, motionEvent) && action != 3) {
                this.f1200y = sVar;
                return true;
            }
        }
        return false;
    }

    public void Y0(c0 c0Var, l.c cVar) {
        c0Var.H(0, 8192);
        if (this.f1183p0.f1319i && c0Var.A() && !c0Var.x() && !c0Var.L()) {
            this.f1178n.c(h0(c0Var), c0Var);
        }
        this.f1178n.e(c0Var, cVar);
    }

    public final void Z(int[] iArr) {
        int iG = this.f1176m.g();
        if (iG == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i10 = Integer.MAX_VALUE;
        int i11 = Integer.MIN_VALUE;
        for (int i12 = 0; i12 < iG; i12++) {
            c0 c0VarL0 = l0(this.f1176m.f(i12));
            if (!c0VarL0.L()) {
                int iO = c0VarL0.o();
                if (iO < i10) {
                    i10 = iO;
                }
                if (iO > i11) {
                    i11 = iO;
                }
            }
        }
        iArr[0] = i10;
        iArr[1] = i11;
    }

    public final void Z0() {
        View viewFindViewById;
        if (!this.f1175l0 || this.f1190t == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (!P0 || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                if (!this.f1176m.n(focusedChild)) {
                    return;
                }
            } else if (this.f1176m.g() == 0) {
                requestFocus();
                return;
            }
        }
        View viewB0 = null;
        c0 c0VarD0 = (this.f1183p0.f1324n == -1 || !this.f1190t.k()) ? null : d0(this.f1183p0.f1324n);
        if (c0VarD0 != null && !this.f1176m.n(c0VarD0.f1219a) && c0VarD0.f1219a.hasFocusable()) {
            viewB0 = c0VarD0.f1219a;
        } else if (this.f1176m.g() > 0) {
            viewB0 = b0();
        }
        if (viewB0 != null) {
            int i10 = this.f1183p0.f1325o;
            if (i10 != -1 && (viewFindViewById = viewB0.findViewById(i10)) != null && viewFindViewById.isFocusable()) {
                viewB0 = viewFindViewById;
            }
            viewB0.requestFocus();
        }
    }

    public final void a1() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.Q;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.Q.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.R;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.R.isFinished();
        }
        EdgeEffect edgeEffect3 = this.S;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.S.isFinished();
        }
        EdgeEffect edgeEffect4 = this.T;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.T.isFinished();
        }
        if (zIsFinished) {
            x.r.O(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList arrayList, int i10, int i11) {
        o oVar = this.f1192u;
        if (oVar == null || !oVar.G0(this, arrayList, i10, i11)) {
            super.addFocusables(arrayList, i10, i11);
        }
    }

    public final View b0() {
        c0 c0VarC0;
        z zVar = this.f1183p0;
        int i10 = zVar.f1323m;
        if (i10 == -1) {
            i10 = 0;
        }
        int iB = zVar.b();
        for (int i11 = i10; i11 < iB; i11++) {
            c0 c0VarC02 = c0(i11);
            if (c0VarC02 == null) {
                break;
            }
            if (c0VarC02.f1219a.hasFocusable()) {
                return c0VarC02.f1219a;
            }
        }
        int iMin = Math.min(iB, i10);
        do {
            iMin--;
            if (iMin < 0 || (c0VarC0 = c0(iMin)) == null) {
                return null;
            }
        } while (!c0VarC0.f1219a.hasFocusable());
        return c0VarC0.f1219a;
    }

    public void b1() {
        l lVar = this.U;
        if (lVar != null) {
            lVar.k();
        }
        o oVar = this.f1192u;
        if (oVar != null) {
            oVar.l1(this.f1170j);
            this.f1192u.m1(this.f1170j);
        }
        this.f1170j.c();
    }

    public c0 c0(int i10) {
        c0 c0Var = null;
        if (this.L) {
            return null;
        }
        int iJ = this.f1176m.j();
        for (int i11 = 0; i11 < iJ; i11++) {
            c0 c0VarL0 = l0(this.f1176m.i(i11));
            if (c0VarL0 != null && !c0VarL0.x() && g0(c0VarL0) == i10) {
                if (!this.f1176m.n(c0VarL0.f1219a)) {
                    return c0VarL0;
                }
                c0Var = c0VarL0;
            }
        }
        return c0Var;
    }

    public boolean c1(View view) {
        y1();
        boolean zR = this.f1176m.r(view);
        if (zR) {
            c0 c0VarL0 = l0(view);
            this.f1170j.J(c0VarL0);
            this.f1170j.C(c0VarL0);
        }
        A1(!zR);
        return zR;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof p) && this.f1192u.n((p) layoutParams);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        o oVar = this.f1192u;
        if (oVar != null && oVar.l()) {
            return this.f1192u.r(this.f1183p0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        o oVar = this.f1192u;
        if (oVar != null && oVar.l()) {
            return this.f1192u.s(this.f1183p0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        o oVar = this.f1192u;
        if (oVar != null && oVar.l()) {
            return this.f1192u.t(this.f1183p0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        o oVar = this.f1192u;
        if (oVar != null && oVar.m()) {
            return this.f1192u.u(this.f1183p0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        o oVar = this.f1192u;
        if (oVar != null && oVar.m()) {
            return this.f1192u.v(this.f1183p0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        o oVar = this.f1192u;
        if (oVar != null && oVar.m()) {
            return this.f1192u.w(this.f1183p0);
        }
        return 0;
    }

    public c0 d0(long j10) {
        Adapter adapter = this.f1190t;
        c0 c0Var = null;
        if (adapter != null && adapter.k()) {
            int iJ = this.f1176m.j();
            for (int i10 = 0; i10 < iJ; i10++) {
                c0 c0VarL0 = l0(this.f1176m.i(i10));
                if (c0VarL0 != null && !c0VarL0.x() && c0VarL0.m() == j10) {
                    if (!this.f1176m.n(c0VarL0.f1219a)) {
                        return c0VarL0;
                    }
                    c0Var = c0VarL0;
                }
            }
        }
        return c0Var;
    }

    public void d1(n nVar) {
        o oVar = this.f1192u;
        if (oVar != null) {
            oVar.h("Cannot remove item decoration during a scroll  or layout");
        }
        this.f1196w.remove(nVar);
        if (this.f1196w.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        D0();
        requestLayout();
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        return getScrollingChildHelper().a(f10, f11, z10);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f10, float f11) {
        return getScrollingChildHelper().b(f10, f11);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i10, i11, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr) {
        return getScrollingChildHelper().f(i10, i11, i12, i13, iArr);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z10;
        super.draw(canvas);
        int size = this.f1196w.size();
        boolean z11 = false;
        for (int i10 = 0; i10 < size; i10++) {
            ((n) this.f1196w.get(i10)).k(canvas, this, this.f1183p0);
        }
        EdgeEffect edgeEffect = this.Q;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z10 = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.f1180o ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.Q;
            z10 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.R;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.f1180o) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.R;
            z10 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.S;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f1180o ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(paddingTop, -width);
            EdgeEffect edgeEffect6 = this.S;
            z10 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.T;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f1180o) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.T;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z11 = true;
            }
            z10 |= z11;
            canvas.restoreToCount(iSave4);
        }
        if ((z10 || this.U == null || this.f1196w.size() <= 0 || !this.U.p()) ? z10 : true) {
            x.r.O(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j10) {
        return super.drawChild(canvas, view, j10);
    }

    public void e(int i10, int i11) {
        if (i10 < 0) {
            Q();
            if (this.Q.isFinished()) {
                this.Q.onAbsorb(-i10);
            }
        } else if (i10 > 0) {
            R();
            if (this.S.isFinished()) {
                this.S.onAbsorb(i10);
            }
        }
        if (i11 < 0) {
            S();
            if (this.R.isFinished()) {
                this.R.onAbsorb(-i11);
            }
        } else if (i11 > 0) {
            P();
            if (this.T.isFinished()) {
                this.T.onAbsorb(i11);
            }
        }
        if (i10 == 0 && i11 == 0) {
            return;
        }
        x.r.O(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c0 e0(int i10, boolean z10) {
        int iJ = this.f1176m.j();
        c0 c0Var = null;
        for (int i11 = 0; i11 < iJ; i11++) {
            c0 c0VarL0 = l0(this.f1176m.i(i11));
            if (c0VarL0 != null && !c0VarL0.x()) {
                if (z10) {
                    if (c0VarL0.f1221c != i10) {
                        continue;
                    } else {
                        if (!this.f1176m.n(c0VarL0.f1219a)) {
                            return c0VarL0;
                        }
                        c0Var = c0VarL0;
                    }
                } else if (c0VarL0.o() != i10) {
                    continue;
                }
            }
        }
        return c0Var;
    }

    public void e1(q qVar) {
        List list = this.K;
        if (list == null) {
            return;
        }
        list.remove(qVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public boolean f0(int i10, int i11) {
        o oVar = this.f1192u;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.F) {
            return false;
        }
        int iL = oVar.l();
        boolean zM = this.f1192u.m();
        if (iL == 0 || Math.abs(i10) < this.f1168h0) {
            i10 = 0;
        }
        if (!zM || Math.abs(i11) < this.f1168h0) {
            i11 = 0;
        }
        if (i10 == 0 && i11 == 0) {
            return false;
        }
        float f10 = i10;
        float f11 = i11;
        if (!dispatchNestedPreFling(f10, f11)) {
            boolean z10 = iL != 0 || zM;
            dispatchNestedFling(f10, f11, z10);
            r rVar = this.f1167g0;
            if (rVar != null && rVar.a(i10, i11)) {
                return true;
            }
            if (z10) {
                if (zM) {
                    iL = (iL == true ? 1 : 0) | 2;
                }
                z1(iL, 1);
                int i12 = this.f1169i0;
                int iMax = Math.max(-i12, Math.min(i10, i12));
                int i13 = this.f1169i0;
                this.f1177m0.b(iMax, Math.max(-i13, Math.min(i11, i13)));
                return true;
            }
        }
        return false;
    }

    public void f1(s sVar) {
        this.f1198x.remove(sVar);
        if (this.f1200y == sVar) {
            this.f1200y = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i10) {
        View viewK0;
        boolean z10;
        View viewR0 = this.f1192u.R0(view, i10);
        if (viewR0 != null) {
            return viewR0;
        }
        boolean z11 = (this.f1190t == null || this.f1192u == null || A0() || this.F) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z11 && (i10 == 2 || i10 == 1)) {
            if (this.f1192u.m()) {
                int i11 = i10 == 2 ? 130 : 33;
                z10 = focusFinder.findNextFocus(this, view, i11) == null;
                if (O0) {
                    i10 = i11;
                }
            } else {
                z10 = false;
            }
            if (!z10 && this.f1192u.l()) {
                int i12 = (this.f1192u.a0() == 1) ^ (i10 == 2) ? 66 : 17;
                boolean z12 = focusFinder.findNextFocus(this, view, i12) == null;
                if (O0) {
                    i10 = i12;
                }
                z10 = z12;
            }
            if (z10) {
                y();
                if (W(view) == null) {
                    return null;
                }
                y1();
                this.f1192u.K0(view, i10, this.f1170j, this.f1183p0);
                A1(false);
            }
            viewK0 = focusFinder.findNextFocus(this, view, i10);
        } else {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i10);
            if (viewFindNextFocus == null && z11) {
                y();
                if (W(view) == null) {
                    return null;
                }
                y1();
                viewK0 = this.f1192u.K0(view, i10, this.f1170j, this.f1183p0);
                A1(false);
            } else {
                viewK0 = viewFindNextFocus;
            }
        }
        if (viewK0 == null || viewK0.hasFocusable()) {
            return B0(view, viewK0, i10) ? viewK0 : super.focusSearch(view, i10);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i10);
        }
        i1(viewK0, null);
        return view;
    }

    public int g0(c0 c0Var) {
        if (c0Var.r(524) || !c0Var.u()) {
            return -1;
        }
        return this.f1174l.e(c0Var.f1221c);
    }

    public void g1(t tVar) {
        List list = this.f1187r0;
        if (list != null) {
            list.remove(tVar);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        o oVar = this.f1192u;
        if (oVar != null) {
            return oVar.E();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + T());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        o oVar = this.f1192u;
        if (oVar != null) {
            return oVar.F(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + T());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        o oVar = this.f1192u;
        if (oVar != null) {
            return oVar.G(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + T());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public Adapter getAdapter() {
        return this.f1190t;
    }

    @Override // android.view.View
    public int getBaseline() {
        o oVar = this.f1192u;
        return oVar != null ? oVar.H() : super.getBaseline();
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i10, int i11) {
        j jVar = this.f1199x0;
        return jVar == null ? super.getChildDrawingOrder(i10, i11) : jVar.a(i10, i11);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f1180o;
    }

    public androidx.recyclerview.widget.s getCompatAccessibilityDelegate() {
        return this.f1197w0;
    }

    public k getEdgeEffectFactory() {
        return this.P;
    }

    public l getItemAnimator() {
        return this.U;
    }

    public int getItemDecorationCount() {
        return this.f1196w.size();
    }

    public o getLayoutManager() {
        return this.f1192u;
    }

    public int getMaxFlingVelocity() {
        return this.f1169i0;
    }

    public int getMinFlingVelocity() {
        return this.f1168h0;
    }

    public long getNanoTime() {
        if (N0) {
            return System.nanoTime();
        }
        return 0L;
    }

    public r getOnFlingListener() {
        return this.f1167g0;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f1175l0;
    }

    public u getRecycledViewPool() {
        return this.f1170j.i();
    }

    public int getScrollState() {
        return this.V;
    }

    public long h0(c0 c0Var) {
        return this.f1190t.k() ? c0Var.m() : c0Var.f1221c;
    }

    public void h1() {
        c0 c0Var;
        int iG = this.f1176m.g();
        for (int i10 = 0; i10 < iG; i10++) {
            View viewF = this.f1176m.f(i10);
            c0 c0VarK0 = k0(viewF);
            if (c0VarK0 != null && (c0Var = c0VarK0.f1227i) != null) {
                View view = c0Var.f1219a;
                int left = viewF.getLeft();
                int top = viewF.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().j();
    }

    public int i0(View view) {
        c0 c0VarL0 = l0(view);
        if (c0VarL0 != null) {
            return c0VarL0.j();
        }
        return -1;
    }

    public final void i1(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.f1184q.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof p) {
            p pVar = (p) layoutParams;
            if (!pVar.f1279c) {
                Rect rect = pVar.f1278b;
                Rect rect2 = this.f1184q;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f1184q);
            offsetRectIntoDescendantCoords(view, this.f1184q);
        }
        this.f1192u.t1(this, view, this.f1184q, !this.C, view2 == null);
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.f1202z;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.F;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().l();
    }

    public final void j(c0 c0Var) {
        View view = c0Var.f1219a;
        boolean z10 = view.getParent() == this;
        this.f1170j.J(k0(view));
        if (c0Var.z()) {
            this.f1176m.c(view, -1, view.getLayoutParams(), true);
        } else if (z10) {
            this.f1176m.k(view);
        } else {
            this.f1176m.b(view, true);
        }
    }

    public int j0(View view) {
        c0 c0VarL0 = l0(view);
        if (c0VarL0 != null) {
            return c0VarL0.o();
        }
        return -1;
    }

    public final void j1() {
        z zVar = this.f1183p0;
        zVar.f1324n = -1L;
        zVar.f1323m = -1;
        zVar.f1325o = -1;
    }

    public void k(n nVar) {
        l(nVar, -1);
    }

    public c0 k0(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return l0(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public final void k1() {
        VelocityTracker velocityTracker = this.f1160a0;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        B1(0);
        a1();
    }

    public void l(n nVar, int i10) {
        o oVar = this.f1192u;
        if (oVar != null) {
            oVar.h("Cannot add item decoration during a scroll  or layout");
        }
        if (this.f1196w.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i10 < 0) {
            this.f1196w.add(nVar);
        } else {
            this.f1196w.add(i10, nVar);
        }
        D0();
        requestLayout();
    }

    public final void l1() {
        View focusedChild = (this.f1175l0 && hasFocus() && this.f1190t != null) ? getFocusedChild() : null;
        c0 c0VarX = focusedChild != null ? X(focusedChild) : null;
        if (c0VarX == null) {
            j1();
            return;
        }
        this.f1183p0.f1324n = this.f1190t.k() ? c0VarX.m() : -1L;
        this.f1183p0.f1323m = this.L ? -1 : c0VarX.x() ? c0VarX.f1222d : c0VarX.j();
        this.f1183p0.f1325o = o0(c0VarX.f1219a);
    }

    public void m(q qVar) {
        if (this.K == null) {
            this.K = new ArrayList();
        }
        this.K.add(qVar);
    }

    public void m0(View view, Rect rect) {
        n0(view, rect);
    }

    public void m1() {
        int iJ = this.f1176m.j();
        for (int i10 = 0; i10 < iJ; i10++) {
            c0 c0VarL0 = l0(this.f1176m.i(i10));
            if (!c0VarL0.L()) {
                c0VarL0.G();
            }
        }
    }

    public void n(s sVar) {
        this.f1198x.add(sVar);
    }

    public boolean n1(int i10, int i11, MotionEvent motionEvent, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        y();
        if (this.f1190t != null) {
            int[] iArr = this.C0;
            iArr[0] = 0;
            iArr[1] = 0;
            o1(i10, i11, iArr);
            int[] iArr2 = this.C0;
            int i17 = iArr2[0];
            int i18 = iArr2[1];
            i15 = i10 - i17;
            i16 = i11 - i18;
            i14 = i18;
            i13 = i17;
        } else {
            i13 = 0;
            i14 = 0;
            i15 = 0;
            i16 = 0;
        }
        if (!this.f1196w.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.C0;
        iArr3[0] = 0;
        iArr3[1] = 0;
        K(i13, i14, i15, i16, this.A0, i12, iArr3);
        int[] iArr4 = this.C0;
        int i19 = iArr4[0];
        int i20 = i15 - i19;
        int i21 = iArr4[1];
        int i22 = i16 - i21;
        boolean z10 = (i19 == 0 && i21 == 0) ? false : true;
        int i23 = this.f1163d0;
        int[] iArr5 = this.A0;
        int i24 = iArr5[0];
        this.f1163d0 = i23 - i24;
        int i25 = this.f1165e0;
        int i26 = iArr5[1];
        this.f1165e0 = i25 - i26;
        int[] iArr6 = this.B0;
        iArr6[0] = iArr6[0] + i24;
        iArr6[1] = iArr6[1] + i26;
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !x.j.a(motionEvent, 8194)) {
                X0(motionEvent.getX(), i20, motionEvent.getY(), i22);
            }
            x(i10, i11);
        }
        if (i13 != 0 || i14 != 0) {
            M(i13, i14);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z10 && i13 == 0 && i14 == 0) ? false : true;
    }

    public void o(t tVar) {
        if (this.f1187r0 == null) {
            this.f1187r0 = new ArrayList();
        }
        this.f1187r0.add(tVar);
    }

    public final int o0(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    public void o1(int i10, int i11, int[] iArr) {
        y1();
        N0();
        u.t.a("RV Scroll");
        U(this.f1183p0);
        int iX1 = i10 != 0 ? this.f1192u.x1(i10, this.f1170j, this.f1183p0) : 0;
        int iZ1 = i11 != 0 ? this.f1192u.z1(i11, this.f1170j, this.f1183p0) : 0;
        u.t.b();
        h1();
        O0();
        A1(false);
        if (iArr != null) {
            iArr[0] = iX1;
            iArr[1] = iZ1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onAttachedToWindow() {
        float refreshRate;
        super.onAttachedToWindow();
        this.N = 0;
        this.f1202z = true;
        this.C = this.C && !isLayoutRequested();
        o oVar = this.f1192u;
        if (oVar != null) {
            oVar.A(this);
        }
        this.f1195v0 = false;
        if (N0) {
            ThreadLocal threadLocal = androidx.recyclerview.widget.i.f1502m;
            androidx.recyclerview.widget.i iVar = (androidx.recyclerview.widget.i) threadLocal.get();
            this.f1179n0 = iVar;
            if (iVar == null) {
                this.f1179n0 = new androidx.recyclerview.widget.i();
                Display displayQ = x.r.q(this);
                if (isInEditMode() || displayQ == null) {
                    refreshRate = 60.0f;
                    androidx.recyclerview.widget.i iVar2 = this.f1179n0;
                    iVar2.f1506k = (long) (1.0E9f / refreshRate);
                    threadLocal.set(iVar2);
                } else {
                    refreshRate = displayQ.getRefreshRate();
                    if (refreshRate < 30.0f) {
                    }
                    androidx.recyclerview.widget.i iVar22 = this.f1179n0;
                    iVar22.f1506k = (long) (1.0E9f / refreshRate);
                    threadLocal.set(iVar22);
                }
            }
            this.f1179n0.a(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        androidx.recyclerview.widget.i iVar;
        super.onDetachedFromWindow();
        l lVar = this.U;
        if (lVar != null) {
            lVar.k();
        }
        C1();
        this.f1202z = false;
        o oVar = this.f1192u;
        if (oVar != null) {
            oVar.B(this, this.f1170j);
        }
        this.D0.clear();
        removeCallbacks(this.E0);
        this.f1178n.j();
        if (!N0 || (iVar = this.f1179n0) == null) {
            return;
        }
        iVar.j(this);
        this.f1179n0 = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f1196w.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((n) this.f1196w.get(i10)).i(canvas, this, this.f1183p0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f10;
        float axisValue;
        if (this.f1192u != null && !this.F && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f10 = this.f1192u.m() ? -motionEvent.getAxisValue(9) : 0.0f;
                axisValue = this.f1192u.l() ? motionEvent.getAxisValue(10) : 0.0f;
                if (f10 != 0.0f || axisValue != 0.0f) {
                    F0((int) (axisValue * this.f1171j0), (int) (f10 * this.f1173k0), motionEvent, 1);
                }
            } else if ((motionEvent.getSource() & 4194304) != 0) {
                float axisValue2 = motionEvent.getAxisValue(26);
                if (this.f1192u.m()) {
                    f10 = -axisValue2;
                    if (f10 != 0.0f) {
                        F0((int) (axisValue * this.f1171j0), (int) (f10 * this.f1173k0), motionEvent, 1);
                    }
                } else {
                    if (this.f1192u.l()) {
                        axisValue = axisValue2;
                        f10 = 0.0f;
                        if (f10 != 0.0f) {
                        }
                    }
                    f10 = 0.0f;
                    if (f10 != 0.0f) {
                    }
                }
            } else {
                f10 = 0.0f;
                if (f10 != 0.0f) {
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        if (this.F) {
            return false;
        }
        this.f1200y = null;
        if (Y(motionEvent)) {
            u();
            return true;
        }
        o oVar = this.f1192u;
        if (oVar == null) {
            return false;
        }
        boolean zL = oVar.l();
        boolean zM = this.f1192u.m();
        if (this.f1160a0 == null) {
            this.f1160a0 = VelocityTracker.obtain();
        }
        this.f1160a0.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.G) {
                this.G = false;
            }
            this.W = motionEvent.getPointerId(0);
            int x10 = (int) (motionEvent.getX() + 0.5f);
            this.f1163d0 = x10;
            this.f1161b0 = x10;
            int y10 = (int) (motionEvent.getY() + 0.5f);
            this.f1165e0 = y10;
            this.f1162c0 = y10;
            if (this.V == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                B1(1);
            }
            int[] iArr = this.B0;
            iArr[1] = 0;
            iArr[0] = 0;
            int i10 = zL;
            if (zM) {
                i10 = (zL ? 1 : 0) | 2;
            }
            z1(i10, 0);
        } else if (actionMasked == 1) {
            this.f1160a0.clear();
            B1(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.W);
            if (iFindPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.W + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x11 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y11 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.V != 1) {
                int i11 = x11 - this.f1161b0;
                int i12 = y11 - this.f1162c0;
                if (zL == 0 || Math.abs(i11) <= this.f1166f0) {
                    z10 = false;
                } else {
                    this.f1163d0 = x11;
                    z10 = true;
                }
                if (zM && Math.abs(i12) > this.f1166f0) {
                    this.f1165e0 = y11;
                    z10 = true;
                }
                if (z10) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            u();
        } else if (actionMasked == 5) {
            this.W = motionEvent.getPointerId(actionIndex);
            int x12 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.f1163d0 = x12;
            this.f1161b0 = x12;
            int y12 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.f1165e0 = y12;
            this.f1162c0 = y12;
        } else if (actionMasked == 6) {
            Q0(motionEvent);
        }
        return this.V == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        u.t.a("RV OnLayout");
        F();
        u.t.b();
        this.C = true;
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        o oVar = this.f1192u;
        if (oVar == null) {
            A(i10, i11);
            return;
        }
        boolean z10 = false;
        if (oVar.t0()) {
            int mode = View.MeasureSpec.getMode(i10);
            int mode2 = View.MeasureSpec.getMode(i11);
            this.f1192u.a1(this.f1170j, this.f1183p0, i10, i11);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z10 = true;
            }
            this.F0 = z10;
            if (z10 || this.f1190t == null) {
                return;
            }
            if (this.f1183p0.f1315e == 1) {
                G();
            }
            this.f1192u.B1(i10, i11);
            this.f1183p0.f1320j = true;
            H();
            this.f1192u.E1(i10, i11);
            if (this.f1192u.H1()) {
                this.f1192u.B1(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.f1183p0.f1320j = true;
                H();
                this.f1192u.E1(i10, i11);
            }
            this.G0 = getMeasuredWidth();
            this.H0 = getMeasuredHeight();
            return;
        }
        if (this.A) {
            this.f1192u.a1(this.f1170j, this.f1183p0, i10, i11);
            return;
        }
        if (this.I) {
            y1();
            N0();
            V0();
            O0();
            z zVar = this.f1183p0;
            if (zVar.f1322l) {
                zVar.f1318h = true;
            } else {
                this.f1174l.j();
                this.f1183p0.f1318h = false;
            }
            this.I = false;
            A1(false);
        } else if (this.f1183p0.f1322l) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        Adapter adapter = this.f1190t;
        if (adapter != null) {
            this.f1183p0.f1316f = adapter.g();
        } else {
            this.f1183p0.f1316f = 0;
        }
        y1();
        this.f1192u.a1(this.f1170j, this.f1183p0, i10, i11);
        A1(false);
        this.f1183p0.f1318h = false;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i10, Rect rect) {
        if (A0()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i10, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.f1172k = savedState;
        super.onRestoreInstanceState(savedState.a());
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.f1172k;
        if (savedState2 != null) {
            savedState.b(savedState2);
            return savedState;
        }
        o oVar = this.f1192u;
        if (oVar != null) {
            savedState.f1208k = oVar.e1();
            return savedState;
        }
        savedState.f1208k = null;
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 == i12 && i11 == i13) {
            return;
        }
        y0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00df A[PHI: r1
  0x00df: PHI (r1v45 int) = (r1v26 int), (r1v49 int) binds: [B:41:0x00c8, B:45:0x00db] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        if (this.F || this.G) {
            return false;
        }
        if (O(motionEvent)) {
            u();
            return true;
        }
        o oVar = this.f1192u;
        if (oVar == null) {
            return false;
        }
        boolean zL = oVar.l();
        boolean zM = this.f1192u.m();
        if (this.f1160a0 == null) {
            this.f1160a0 = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.B0;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        int[] iArr2 = this.B0;
        motionEventObtain.offsetLocation(iArr2[0], iArr2[1]);
        if (actionMasked == 0) {
            this.W = motionEvent.getPointerId(0);
            int x10 = (int) (motionEvent.getX() + 0.5f);
            this.f1163d0 = x10;
            this.f1161b0 = x10;
            int y10 = (int) (motionEvent.getY() + 0.5f);
            this.f1165e0 = y10;
            this.f1162c0 = y10;
            int i10 = zL;
            if (zM) {
                i10 = (zL ? 1 : 0) | 2;
            }
            z1(i10, 0);
        } else {
            if (actionMasked == 1) {
                this.f1160a0.addMovement(motionEventObtain);
                this.f1160a0.computeCurrentVelocity(1000, this.f1169i0);
                float f10 = zL != 0 ? -this.f1160a0.getXVelocity(this.W) : 0.0f;
                float f11 = zM ? -this.f1160a0.getYVelocity(this.W) : 0.0f;
                if ((f10 == 0.0f && f11 == 0.0f) || !f0((int) f10, (int) f11)) {
                    setScrollState(0);
                }
                k1();
                motionEventObtain.recycle();
                return true;
            }
            if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.W);
                if (iFindPointerIndex < 0) {
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.W + " not found. Did any MotionEvents get skipped?");
                    return false;
                }
                int x11 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
                int y11 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                int iMax = this.f1163d0 - x11;
                int iMax2 = this.f1165e0 - y11;
                if (this.V != 1) {
                    if (zL == 0) {
                        z10 = false;
                        if (zM) {
                            iMax2 = iMax2 > 0 ? Math.max(0, iMax2 - this.f1166f0) : Math.min(0, iMax2 + this.f1166f0);
                            if (iMax2 != 0) {
                                z10 = true;
                            }
                        }
                        if (z10) {
                            setScrollState(1);
                        }
                    } else {
                        iMax = iMax > 0 ? Math.max(0, iMax - this.f1166f0) : Math.min(0, iMax + this.f1166f0);
                        if (iMax != 0) {
                            z10 = true;
                        }
                        if (zM) {
                        }
                        if (z10) {
                        }
                    }
                    motionEventObtain.recycle();
                    return true;
                }
                int i11 = iMax;
                int i12 = iMax2;
                if (this.V == 1) {
                    int[] iArr3 = this.C0;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    if (J(zL != 0 ? i11 : 0, zM ? i12 : 0, iArr3, this.A0, 0)) {
                        int[] iArr4 = this.C0;
                        i11 -= iArr4[0];
                        i12 -= iArr4[1];
                        int[] iArr5 = this.B0;
                        int i13 = iArr5[0];
                        int[] iArr6 = this.A0;
                        iArr5[0] = i13 + iArr6[0];
                        iArr5[1] = iArr5[1] + iArr6[1];
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    int[] iArr7 = this.A0;
                    this.f1163d0 = x11 - iArr7[0];
                    this.f1165e0 = y11 - iArr7[1];
                    if (n1(zL != 0 ? i11 : 0, zM ? i12 : 0, motionEvent, 0)) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    androidx.recyclerview.widget.i iVar = this.f1179n0;
                    if (iVar != null && (i11 != 0 || i12 != 0)) {
                        iVar.f(this, i11, i12);
                    }
                }
            } else if (actionMasked == 3) {
                u();
            } else if (actionMasked == 5) {
                this.W = motionEvent.getPointerId(actionIndex);
                int x12 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                this.f1163d0 = x12;
                this.f1161b0 = x12;
                int y12 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                this.f1165e0 = y12;
                this.f1162c0 = y12;
            } else if (actionMasked == 6) {
                Q0(motionEvent);
            }
        }
        this.f1160a0.addMovement(motionEventObtain);
        motionEventObtain.recycle();
        return true;
    }

    public void p(c0 c0Var, l.c cVar, l.c cVar2) {
        c0Var.I(false);
        if (this.U.a(c0Var, cVar, cVar2)) {
            T0();
        }
    }

    public final String p0(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(".")) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + '.' + str;
    }

    public void p1(int i10) {
        if (this.F) {
            return;
        }
        C1();
        o oVar = this.f1192u;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            oVar.y1(i10);
            awakenScrollBars();
        }
    }

    public final void q(c0 c0Var, c0 c0Var2, l.c cVar, l.c cVar2, boolean z10, boolean z11) {
        c0Var.I(false);
        if (z10) {
            j(c0Var);
        }
        if (c0Var != c0Var2) {
            if (z11) {
                j(c0Var2);
            }
            c0Var.f1226h = c0Var2;
            j(c0Var);
            this.f1170j.J(c0Var);
            c0Var2.I(false);
            c0Var2.f1227i = c0Var;
        }
        if (this.U.b(c0Var, c0Var2, cVar, cVar2)) {
            T0();
        }
    }

    public Rect q0(View view) {
        p pVar = (p) view.getLayoutParams();
        if (!pVar.f1279c) {
            return pVar.f1278b;
        }
        if (this.f1183p0.e() && (pVar.b() || pVar.d())) {
            return pVar.f1278b;
        }
        Rect rect = pVar.f1278b;
        rect.set(0, 0, 0, 0);
        int size = this.f1196w.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f1184q.set(0, 0, 0, 0);
            ((n) this.f1196w.get(i10)).g(this.f1184q, view, this, this.f1183p0);
            int i11 = rect.left;
            Rect rect2 = this.f1184q;
            rect.left = i11 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        pVar.f1279c = false;
        return rect;
    }

    public final void q1(Adapter adapter, boolean z10, boolean z11) {
        Adapter adapter2 = this.f1190t;
        if (adapter2 != null) {
            adapter2.G(this.f1164e);
            this.f1190t.z(this);
        }
        if (!z10 || z11) {
            b1();
        }
        this.f1174l.y();
        Adapter adapter3 = this.f1190t;
        this.f1190t = adapter;
        if (adapter != null) {
            adapter.E(this.f1164e);
            adapter.v(this);
        }
        o oVar = this.f1192u;
        if (oVar != null) {
            oVar.F0(adapter3, this.f1190t);
        }
        this.f1170j.x(adapter3, this.f1190t, z10);
        this.f1183p0.f1317g = true;
    }

    public void r(c0 c0Var, l.c cVar, l.c cVar2) {
        j(c0Var);
        c0Var.I(false);
        if (this.U.c(c0Var, cVar, cVar2)) {
            T0();
        }
    }

    public final void r0(long j10, c0 c0Var, c0 c0Var2) {
        int iG = this.f1176m.g();
        for (int i10 = 0; i10 < iG; i10++) {
            c0 c0VarL0 = l0(this.f1176m.f(i10));
            if (c0VarL0 != c0Var && h0(c0VarL0) == j10) {
                Adapter adapter = this.f1190t;
                if (adapter == null || !adapter.k()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + c0VarL0 + " \n View Holder 2:" + c0Var + T());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + c0VarL0 + " \n View Holder 2:" + c0Var + T());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + c0Var2 + " cannot be found but it is necessary for " + c0Var + T());
    }

    public boolean r1(c0 c0Var, int i10) {
        if (!A0()) {
            x.r.b0(c0Var.f1219a, i10);
            return true;
        }
        c0Var.f1235q = i10;
        this.D0.add(c0Var);
        return false;
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z10) {
        c0 c0VarL0 = l0(view);
        if (c0VarL0 != null) {
            if (c0VarL0.z()) {
                c0VarL0.f();
            } else if (!c0VarL0.L()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + c0VarL0 + T());
            }
        }
        view.clearAnimation();
        D(view);
        super.removeDetachedView(view, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f1192u.c1(this, this.f1183p0, view, view2) && view2 != null) {
            i1(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        return this.f1192u.s1(this, view, rect, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        int size = this.f1198x.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((s) this.f1198x.get(i10)).e(z10);
        }
        super.requestDisallowInterceptTouchEvent(z10);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.D != 0 || this.F) {
            this.E = true;
        } else {
            super.requestLayout();
        }
    }

    public void s(String str) {
        if (A0()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + T());
        }
        if (this.O > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + T()));
        }
    }

    public boolean s0() {
        return !this.C || this.L || this.f1174l.p();
    }

    public boolean s1(AccessibilityEvent accessibilityEvent) {
        if (!A0()) {
            return false;
        }
        int iA = accessibilityEvent != null ? y.b.a(accessibilityEvent) : 0;
        this.H |= iA != 0 ? iA : 0;
        return true;
    }

    @Override // android.view.View
    public void scrollBy(int i10, int i11) {
        o oVar = this.f1192u;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.F) {
            return;
        }
        boolean zL = oVar.l();
        boolean zM = this.f1192u.m();
        if (zL || zM) {
            if (!zL) {
                i10 = 0;
            }
            if (!zM) {
                i11 = 0;
            }
            n1(i10, i11, null, 0);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i10, int i11) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (s1(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(androidx.recyclerview.widget.s sVar) {
        this.f1197w0 = sVar;
        x.r.X(this, sVar);
    }

    public void setAdapter(Adapter adapter) {
        setLayoutFrozen(false);
        q1(adapter, false, true);
        W0(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(j jVar) {
        if (jVar == this.f1199x0) {
            return;
        }
        this.f1199x0 = jVar;
        setChildrenDrawingOrderEnabled(jVar != null);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z10) {
        if (z10 != this.f1180o) {
            y0();
        }
        this.f1180o = z10;
        super.setClipToPadding(z10);
        if (this.C) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(k kVar) {
        w.g.b(kVar);
        this.P = kVar;
        y0();
    }

    public void setHasFixedSize(boolean z10) {
        this.A = z10;
    }

    public void setItemAnimator(l lVar) {
        l lVar2 = this.U;
        if (lVar2 != null) {
            lVar2.k();
            this.U.y(null);
        }
        this.U = lVar;
        if (lVar != null) {
            lVar.y(this.f1193u0);
        }
    }

    public void setItemViewCacheSize(int i10) {
        this.f1170j.G(i10);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z10) {
        suppressLayout(z10);
    }

    public void setLayoutManager(o oVar) {
        if (oVar == this.f1192u) {
            return;
        }
        C1();
        if (this.f1192u != null) {
            l lVar = this.U;
            if (lVar != null) {
                lVar.k();
            }
            this.f1192u.l1(this.f1170j);
            this.f1192u.m1(this.f1170j);
            this.f1170j.c();
            if (this.f1202z) {
                this.f1192u.B(this, this.f1170j);
            }
            this.f1192u.F1(null);
            this.f1192u = null;
        } else {
            this.f1170j.c();
        }
        this.f1176m.o();
        this.f1192u = oVar;
        if (oVar != null) {
            if (oVar.f1254b != null) {
                throw new IllegalArgumentException("LayoutManager " + oVar + " is already attached to a RecyclerView:" + oVar.f1254b.T());
            }
            oVar.F1(this);
            if (this.f1202z) {
                this.f1192u.A(this);
            }
        }
        this.f1170j.K();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z10) {
        getScrollingChildHelper().m(z10);
    }

    public void setOnFlingListener(r rVar) {
        this.f1167g0 = rVar;
    }

    @Deprecated
    public void setOnScrollListener(t tVar) {
        this.f1185q0 = tVar;
    }

    public void setPreserveFocusAfterLayout(boolean z10) {
        this.f1175l0 = z10;
    }

    public void setRecycledViewPool(u uVar) {
        this.f1170j.E(uVar);
    }

    @Deprecated
    public void setRecyclerListener(w wVar) {
    }

    public void setScrollState(int i10) {
        if (i10 == this.V) {
            return;
        }
        this.V = i10;
        if (i10 != 2) {
            D1();
        }
        L(i10);
    }

    public void setScrollingTouchSlop(int i10) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i10 != 0) {
            if (i10 == 1) {
                this.f1166f0 = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i10 + "; using default value");
        }
        this.f1166f0 = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(a0 a0Var) {
        this.f1170j.F(a0Var);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i10) {
        return getScrollingChildHelper().o(i10);
    }

    @Override // android.view.View, x.k
    public void stopNestedScroll() {
        getScrollingChildHelper().q();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z10) {
        if (z10 != this.F) {
            s("Do not suppressLayout in layout or scroll");
            if (z10) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
                this.F = true;
                this.G = true;
                C1();
                return;
            }
            this.F = false;
            if (this.E && this.f1192u != null && this.f1190t != null) {
                requestLayout();
            }
            this.E = false;
        }
    }

    public boolean t(c0 c0Var) {
        l lVar = this.U;
        return lVar == null || lVar.g(c0Var, c0Var.q());
    }

    public final boolean t0() {
        int iG = this.f1176m.g();
        for (int i10 = 0; i10 < iG; i10++) {
            c0 c0VarL0 = l0(this.f1176m.f(i10));
            if (c0VarL0 != null && !c0VarL0.L() && c0VarL0.A()) {
                return true;
            }
        }
        return false;
    }

    public void t1(int i10, int i11) {
        u1(i10, i11, null);
    }

    public final void u() {
        k1();
        setScrollState(0);
    }

    public void u0() {
        this.f1174l = new androidx.recyclerview.widget.a(new f());
    }

    public void u1(int i10, int i11, Interpolator interpolator) {
        v1(i10, i11, interpolator, Integer.MIN_VALUE);
    }

    public final void v0() {
        if (x.r.u(this) == 0) {
            x.r.c0(this, 8);
        }
    }

    public void v1(int i10, int i11, Interpolator interpolator, int i12) {
        w1(i10, i11, interpolator, i12, false);
    }

    public void w() {
        int iJ = this.f1176m.j();
        for (int i10 = 0; i10 < iJ; i10++) {
            c0 c0VarL0 = l0(this.f1176m.i(i10));
            if (!c0VarL0.L()) {
                c0VarL0.c();
            }
        }
        this.f1170j.d();
    }

    public final void w0() {
        this.f1176m = new androidx.recyclerview.widget.d(new e());
    }

    public void w1(int i10, int i11, Interpolator interpolator, int i12, boolean z10) {
        o oVar = this.f1192u;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.F) {
            return;
        }
        if (!oVar.l()) {
            i10 = 0;
        }
        if (!this.f1192u.m()) {
            i11 = 0;
        }
        if (i10 == 0 && i11 == 0) {
            return;
        }
        if (i12 != Integer.MIN_VALUE && i12 <= 0) {
            scrollBy(i10, i11);
            return;
        }
        if (z10) {
            int i13 = i10 != 0 ? 1 : 0;
            if (i11 != 0) {
                i13 |= 2;
            }
            z1(i13, 1);
        }
        this.f1177m0.e(i10, i11, i12, interpolator);
    }

    public void x(int i10, int i11) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.Q;
        if (edgeEffect == null || edgeEffect.isFinished() || i10 <= 0) {
            zIsFinished = false;
        } else {
            this.Q.onRelease();
            zIsFinished = this.Q.isFinished();
        }
        EdgeEffect edgeEffect2 = this.S;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i10 < 0) {
            this.S.onRelease();
            zIsFinished |= this.S.isFinished();
        }
        EdgeEffect edgeEffect3 = this.R;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i11 > 0) {
            this.R.onRelease();
            zIsFinished |= this.R.isFinished();
        }
        EdgeEffect edgeEffect4 = this.T;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i11 < 0) {
            this.T.onRelease();
            zIsFinished |= this.T.isFinished();
        }
        if (zIsFinished) {
            x.r.O(this);
        }
    }

    public void x0(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new androidx.recyclerview.widget.h(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(k0.b.f8021a), resources.getDimensionPixelSize(k0.b.f8023c), resources.getDimensionPixelOffset(k0.b.f8022b));
        } else {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + T());
        }
    }

    public void x1(int i10) {
        if (this.F) {
            return;
        }
        o oVar = this.f1192u;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            oVar.J1(this, this.f1183p0, i10);
        }
    }

    public void y() {
        if (!this.C || this.L) {
            u.t.a("RV FullInvalidate");
            F();
            u.t.b();
            return;
        }
        if (this.f1174l.p()) {
            if (!this.f1174l.o(4) || this.f1174l.o(11)) {
                if (this.f1174l.p()) {
                    u.t.a("RV FullInvalidate");
                    F();
                    u.t.b();
                    return;
                }
                return;
            }
            u.t.a("RV PartialInvalidate");
            y1();
            N0();
            this.f1174l.w();
            if (!this.E) {
                if (t0()) {
                    F();
                } else {
                    this.f1174l.i();
                }
            }
            A1(true);
            O0();
            u.t.b();
        }
    }

    public void y0() {
        this.T = null;
        this.R = null;
        this.S = null;
        this.Q = null;
    }

    public void y1() {
        int i10 = this.D + 1;
        this.D = i10;
        if (i10 != 1 || this.F) {
            return;
        }
        this.E = false;
    }

    public final void z(Context context, String str, AttributeSet attributeSet, int i10, int i11) throws NoSuchMethodException, SecurityException {
        Object[] objArr;
        Constructor constructor;
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            String strP0 = p0(context, strTrim);
            try {
                Class<? extends U> clsAsSubclass = Class.forName(strP0, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(o.class);
                try {
                    constructor = clsAsSubclass.getConstructor(Q0);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i10), Integer.valueOf(i11)};
                } catch (NoSuchMethodException e10) {
                    objArr = null;
                    try {
                        constructor = clsAsSubclass.getConstructor(null);
                    } catch (NoSuchMethodException e11) {
                        e11.initCause(e10);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + strP0, e11);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((o) constructor.newInstance(objArr));
            } catch (ClassCastException e12) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + strP0, e12);
            } catch (ClassNotFoundException e13) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + strP0, e13);
            } catch (IllegalAccessException e14) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + strP0, e14);
            } catch (InstantiationException e15) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strP0, e15);
            } catch (InvocationTargetException e16) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strP0, e16);
            }
        }
    }

    public boolean z0() {
        AccessibilityManager accessibilityManager = this.J;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean z1(int i10, int i11) {
        return getScrollingChildHelper().p(i10, i11);
    }
}
