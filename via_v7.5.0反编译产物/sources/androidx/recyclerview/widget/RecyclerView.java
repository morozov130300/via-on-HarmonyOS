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
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements y.k {
    public static final int[] L0 = {R.attr.nestedScrollingEnabled};
    public static final boolean M0;
    public static final boolean N0;
    public static final boolean O0;
    public static final boolean P0;
    public static final boolean Q0;
    public static final boolean R0;
    public static final Class[] S0;
    public static final Interpolator T0;
    public s A;
    public final int[] A0;
    public boolean B;
    public y.l B0;
    public boolean C;
    public final int[] C0;
    public boolean D;
    public final int[] D0;
    public boolean E;
    public final int[] E0;
    public int F;
    public final List F0;
    public boolean G;
    public Runnable G0;
    public boolean H;
    public boolean H0;
    public boolean I;
    public int I0;
    public int J;
    public int J0;
    public boolean K;
    public final androidx.recyclerview.widget.x.b K0;
    public final AccessibilityManager L;
    public List M;
    public boolean N;
    public boolean O;
    public int P;
    public int Q;
    public k R;
    public EdgeEffect S;
    public EdgeEffect T;
    public EdgeEffect U;
    public EdgeEffect V;
    public l W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f1063a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f1064b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x f1065c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public VelocityTracker f1066c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f1067d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final v f1068e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f1069e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public int f1070f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public int f1071g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public int f1072h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public r f1073i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public final int f1074j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final int f1075k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public float f1076l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public SavedState f1077m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public float f1078m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public androidx.recyclerview.widget.a f1079n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public boolean f1080n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public androidx.recyclerview.widget.d f1081o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public final c0 f1082o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final androidx.recyclerview.widget.x f1083p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public androidx.recyclerview.widget.i f1084p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f1085q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public androidx.recyclerview.widget.i.b f1086q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Runnable f1087r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public final a0 f1088r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Rect f1089s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public t f1090s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Rect f1091t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public List f1092t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final RectF f1093u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public boolean f1094u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Adapter f1095v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public boolean f1096v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public o f1097w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public l.b f1098w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final List f1099x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public boolean f1100x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ArrayList f1101y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public androidx.recyclerview.widget.s f1102y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ArrayList f1103z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public j f1104z0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.E || recyclerView.isLayoutRequested()) {
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            if (!recyclerView2.B) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.H) {
                recyclerView2.G = true;
            } else {
                recyclerView2.y();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SparseArray f1112b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f1123m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public long f1124n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f1125o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f1126p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f1127q;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1111a = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1113c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1114d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1115e = 1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f1116f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f1117g = false;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f1118h = false;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f1119i = false;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f1120j = false;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f1121k = false;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f1122l = false;

        public void a(int i10) {
            if ((this.f1115e & i10) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i10) + " but it is " + Integer.toBinaryString(this.f1115e));
        }

        public int b() {
            return this.f1118h ? this.f1113c - this.f1114d : this.f1116f;
        }

        public int c() {
            return this.f1111a;
        }

        public boolean d() {
            return this.f1111a != -1;
        }

        public boolean e() {
            return this.f1118h;
        }

        public void f(Adapter adapter) {
            this.f1115e = 1;
            this.f1116f = adapter.g();
            this.f1118h = false;
            this.f1119i = false;
            this.f1120j = false;
        }

        public boolean g() {
            return this.f1122l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f1111a + ", mData=" + this.f1112b + ", mItemCount=" + this.f1116f + ", mIsMeasuring=" + this.f1120j + ", mPreviousLayoutItemCount=" + this.f1113c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f1114d + ", mStructureChanged=" + this.f1117g + ", mInPreLayout=" + this.f1118h + ", mRunSimpleAnimations=" + this.f1121k + ", mRunPredictiveAnimations=" + this.f1122l + '}';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar = RecyclerView.this.W;
            if (lVar != null) {
                lVar.v();
            }
            RecyclerView.this.f1100x0 = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class b0 {
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c0 implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1129c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1130e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public OverScroller f1131m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Interpolator f1132n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f1133o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f1134p;

        public c0() {
            Interpolator interpolator = RecyclerView.T0;
            this.f1132n = interpolator;
            this.f1133o = false;
            this.f1134p = false;
            this.f1131m = new OverScroller(RecyclerView.this.getContext(), interpolator);
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
            this.f1130e = 0;
            this.f1129c = 0;
            Interpolator interpolator = this.f1132n;
            Interpolator interpolator2 = RecyclerView.T0;
            if (interpolator != interpolator2) {
                this.f1132n = interpolator2;
                this.f1131m = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            this.f1131m.fling(0, 0, i10, i11, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            d();
        }

        public final void c() {
            RecyclerView.this.removeCallbacks(this);
            y.r.Q(RecyclerView.this, this);
        }

        public void d() {
            if (this.f1133o) {
                this.f1134p = true;
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
                interpolator = RecyclerView.T0;
            }
            if (this.f1132n != interpolator) {
                this.f1132n = interpolator;
                this.f1131m = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f1130e = 0;
            this.f1129c = 0;
            RecyclerView.this.setScrollState(2);
            this.f1131m.startScroll(0, 0, i10, i11, i13);
            if (Build.VERSION.SDK_INT < 23) {
                this.f1131m.computeScrollOffset();
            }
            d();
        }

        public void f() {
            RecyclerView.this.removeCallbacks(this);
            this.f1131m.abortAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10;
            int i11;
            int i12;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f1097w == null) {
                f();
                return;
            }
            this.f1134p = false;
            this.f1133o = true;
            recyclerView.y();
            OverScroller overScroller = this.f1131m;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i13 = currX - this.f1129c;
                int i14 = currY - this.f1130e;
                this.f1129c = currX;
                this.f1130e = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.E0;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.J(i13, i14, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.E0;
                    i13 -= iArr2[0];
                    i14 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.x(i13, i14);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.f1095v != null) {
                    int[] iArr3 = recyclerView3.E0;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.o1(i13, i14, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.E0;
                    int i15 = iArr4[0];
                    int i16 = iArr4[1];
                    i13 -= i15;
                    i14 -= i16;
                    z zVar = recyclerView4.f1097w.f1177g;
                    if (zVar != null && !zVar.g() && zVar.h()) {
                        int iB = RecyclerView.this.f1088r0.b();
                        if (iB == 0) {
                            zVar.r();
                        } else if (zVar.f() >= iB) {
                            zVar.p(iB - 1);
                            zVar.j(i15, i16);
                        } else {
                            zVar.j(i15, i16);
                        }
                    }
                    i11 = i16;
                    i10 = i15;
                } else {
                    i10 = 0;
                    i11 = 0;
                }
                int i17 = i13;
                int i18 = i14;
                if (!RecyclerView.this.f1101y.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.E0;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.K(i10, i11, i17, i18, null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.E0;
                int i19 = i17 - iArr6[0];
                int i20 = i18 - iArr6[1];
                if (i10 != 0 || i11 != 0) {
                    recyclerView6.M(i10, i11);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z10 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i19 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i20 != 0));
                z zVar2 = RecyclerView.this.f1097w.f1177g;
                if ((zVar2 == null || !zVar2.g()) && z10) {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        if (i19 < 0) {
                            i12 = -currVelocity;
                        } else {
                            i12 = i19 > 0 ? currVelocity : 0;
                        }
                        if (i20 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i20 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.e(i12, currVelocity);
                    }
                    if (RecyclerView.P0) {
                        RecyclerView.this.f1086q0.b();
                    }
                } else {
                    d();
                    RecyclerView recyclerView7 = RecyclerView.this;
                    androidx.recyclerview.widget.i iVar = recyclerView7.f1084p0;
                    if (iVar != null) {
                        iVar.f(recyclerView7, i10, i11);
                    }
                }
            }
            z zVar3 = RecyclerView.this.f1097w.f1177g;
            if (zVar3 != null && zVar3.g()) {
                zVar3.j(0, 0);
            }
            this.f1133o = false;
            if (this.f1134p) {
                c();
            } else {
                RecyclerView.this.setScrollState(0);
                RecyclerView.this.B1(1);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d implements androidx.recyclerview.widget.x.b {
        public d() {
        }

        @Override // androidx.recyclerview.widget.x.b
        public void a(d0 d0Var) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f1097w.n1(d0Var.f1138a, recyclerView.f1068e);
        }

        @Override // androidx.recyclerview.widget.x.b
        public void b(d0 d0Var, l.c cVar, l.c cVar2) {
            RecyclerView.this.p(d0Var, cVar, cVar2);
        }

        @Override // androidx.recyclerview.widget.x.b
        public void c(d0 d0Var, l.c cVar, l.c cVar2) {
            RecyclerView.this.f1068e.J(d0Var);
            RecyclerView.this.r(d0Var, cVar, cVar2);
        }

        @Override // androidx.recyclerview.widget.x.b
        public void d(d0 d0Var, l.c cVar, l.c cVar2) {
            d0Var.I(false);
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.N) {
                if (recyclerView.W.b(d0Var, d0Var, cVar, cVar2)) {
                    RecyclerView.this.T0();
                }
            } else if (recyclerView.W.d(d0Var, cVar, cVar2)) {
                RecyclerView.this.T0();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class d0 {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final List f1137t = Collections.EMPTY_LIST;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f1138a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public WeakReference f1139b;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f1147j;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public RecyclerView f1155r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public Adapter f1156s;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1140c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1141d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f1142e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f1143f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f1144g = -1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public d0 f1145h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public d0 f1146i = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public List f1148k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public List f1149l = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f1150m = 0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public v f1151n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f1152o = false;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f1153p = 0;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f1154q = -1;

        public d0(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.f1138a = view;
        }

        public boolean A() {
            return (this.f1147j & 2) != 0;
        }

        public boolean B() {
            return (this.f1147j & 2) != 0;
        }

        public void C(int i10, boolean z10) {
            if (this.f1141d == -1) {
                this.f1141d = this.f1140c;
            }
            if (this.f1144g == -1) {
                this.f1144g = this.f1140c;
            }
            if (z10) {
                this.f1144g += i10;
            }
            this.f1140c += i10;
            if (this.f1138a.getLayoutParams() != null) {
                ((p) this.f1138a.getLayoutParams()).f1197c = true;
            }
        }

        public void D(RecyclerView recyclerView) {
            int i10 = this.f1154q;
            if (i10 != -1) {
                this.f1153p = i10;
            } else {
                this.f1153p = y.r.t(this.f1138a);
            }
            recyclerView.r1(this, 4);
        }

        public void E(RecyclerView recyclerView) {
            recyclerView.r1(this, this.f1153p);
            this.f1153p = 0;
        }

        public void F() {
            this.f1147j = 0;
            this.f1140c = -1;
            this.f1141d = -1;
            this.f1142e = -1L;
            this.f1144g = -1;
            this.f1150m = 0;
            this.f1145h = null;
            this.f1146i = null;
            d();
            this.f1153p = 0;
            this.f1154q = -1;
            RecyclerView.v(this);
        }

        public void G() {
            if (this.f1141d == -1) {
                this.f1141d = this.f1140c;
            }
        }

        public void H(int i10, int i11) {
            this.f1147j = (i10 & i11) | (this.f1147j & (i11 ^ (-1)));
        }

        public final void I(boolean z10) {
            int i10 = this.f1150m;
            int i11 = z10 ? i10 - 1 : i10 + 1;
            this.f1150m = i11;
            if (i11 < 0) {
                this.f1150m = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z10 && i11 == 1) {
                this.f1147j |= 16;
            } else if (z10 && i11 == 0) {
                this.f1147j &= -17;
            }
        }

        public void J(v vVar, boolean z10) {
            this.f1151n = vVar;
            this.f1152o = z10;
        }

        public boolean K() {
            return (this.f1147j & 16) != 0;
        }

        public boolean L() {
            return (this.f1147j & 128) != 0;
        }

        public void M() {
            this.f1151n.J(this);
        }

        public boolean N() {
            return (this.f1147j & 32) != 0;
        }

        public void a(Object obj) {
            if (obj == null) {
                b(1024);
            } else if ((1024 & this.f1147j) == 0) {
                g();
                this.f1148k.add(obj);
            }
        }

        public void b(int i10) {
            this.f1147j = i10 | this.f1147j;
        }

        public void c() {
            this.f1141d = -1;
            this.f1144g = -1;
        }

        public void d() {
            List list = this.f1148k;
            if (list != null) {
                list.clear();
            }
            this.f1147j &= -1025;
        }

        public void e() {
            this.f1147j &= -33;
        }

        public void f() {
            this.f1147j &= -257;
        }

        public final void g() {
            if (this.f1148k == null) {
                ArrayList arrayList = new ArrayList();
                this.f1148k = arrayList;
                this.f1149l = Collections.unmodifiableList(arrayList);
            }
        }

        public boolean h() {
            return (this.f1147j & 16) == 0 && y.r.D(this.f1138a);
        }

        public void i(int i10, int i11, boolean z10) {
            b(8);
            C(i11, z10);
            this.f1140c = i10;
        }

        public final int j() {
            RecyclerView recyclerView = this.f1155r;
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
            if (this.f1156s == null || (recyclerView = this.f1155r) == null || (adapter = recyclerView.getAdapter()) == null || (iG0 = this.f1155r.g0(this)) == -1) {
                return -1;
            }
            return adapter.f(this.f1156s, this, iG0);
        }

        public final long m() {
            return this.f1142e;
        }

        public final int n() {
            return this.f1143f;
        }

        public final int o() {
            int i10 = this.f1144g;
            return i10 == -1 ? this.f1140c : i10;
        }

        public final int p() {
            return this.f1141d;
        }

        public List q() {
            if ((this.f1147j & 1024) != 0) {
                return f1137t;
            }
            List list = this.f1148k;
            return (list == null || list.size() == 0) ? f1137t : this.f1149l;
        }

        public boolean r(int i10) {
            return (i10 & this.f1147j) != 0;
        }

        public boolean s() {
            return (this.f1147j & 512) != 0 || v();
        }

        public boolean t() {
            return (this.f1138a.getParent() == null || this.f1138a.getParent() == this.f1155r) ? false : true;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.f1140c + " id=" + this.f1142e + ", oldPos=" + this.f1141d + ", pLpos:" + this.f1144g);
            if (y()) {
                sb2.append(" scrap ");
                sb2.append(this.f1152o ? "[changeScrap]" : "[attachedScrap]");
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
                sb2.append(" not recyclable(" + this.f1150m + ")");
            }
            if (s()) {
                sb2.append(" undefined adapter position");
            }
            if (this.f1138a.getParent() == null) {
                sb2.append(" no parent");
            }
            sb2.append("}");
            return sb2.toString();
        }

        public boolean u() {
            return (this.f1147j & 1) != 0;
        }

        public boolean v() {
            return (this.f1147j & 4) != 0;
        }

        public final boolean w() {
            return (this.f1147j & 16) == 0 && !y.r.D(this.f1138a);
        }

        public boolean x() {
            return (this.f1147j & 8) != 0;
        }

        public boolean y() {
            return this.f1151n != null;
        }

        public boolean z() {
            return (this.f1147j & 256) != 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class e implements androidx.recyclerview.widget.d.b {
        public e() {
        }

        @Override // androidx.recyclerview.widget.d.b
        public View a(int i10) {
            return RecyclerView.this.getChildAt(i10);
        }

        @Override // androidx.recyclerview.widget.d.b
        public void b(View view) {
            d0 d0VarL0 = RecyclerView.l0(view);
            if (d0VarL0 != null) {
                d0VarL0.D(RecyclerView.this);
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
        public d0 f(View view) {
            return RecyclerView.l0(view);
        }

        @Override // androidx.recyclerview.widget.d.b
        public void g(int i10) {
            d0 d0VarL0;
            View viewA = a(i10);
            if (viewA != null && (d0VarL0 = RecyclerView.l0(viewA)) != null) {
                if (d0VarL0.z() && !d0VarL0.L()) {
                    throw new IllegalArgumentException("called detach on an already detached child " + d0VarL0 + RecyclerView.this.T());
                }
                d0VarL0.b(256);
            }
            RecyclerView.this.detachViewFromParent(i10);
        }

        @Override // androidx.recyclerview.widget.d.b
        public void h(View view) {
            d0 d0VarL0 = RecyclerView.l0(view);
            if (d0VarL0 != null) {
                d0VarL0.E(RecyclerView.this);
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
            d0 d0VarL0 = RecyclerView.l0(view);
            if (d0VarL0 != null) {
                if (!d0VarL0.z() && !d0VarL0.L()) {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + d0VarL0 + RecyclerView.this.T());
                }
                d0VarL0.f();
            }
            RecyclerView.this.attachViewToParent(view, i10, layoutParams);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class f implements androidx.recyclerview.widget.a.InterfaceC0019a {
        public f() {
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0019a
        public void a(int i10, int i11) {
            RecyclerView.this.J0(i10, i11);
            RecyclerView.this.f1094u0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0019a
        public void b(androidx.recyclerview.widget.a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0019a
        public void c(int i10, int i11, Object obj) {
            RecyclerView.this.F1(i10, i11, obj);
            RecyclerView.this.f1096v0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0019a
        public void d(androidx.recyclerview.widget.a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0019a
        public d0 e(int i10) {
            d0 d0VarE0 = RecyclerView.this.e0(i10, true);
            if (d0VarE0 == null || RecyclerView.this.f1081o.n(d0VarE0.f1138a)) {
                return null;
            }
            return d0VarE0;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0019a
        public void f(int i10, int i11) {
            RecyclerView.this.K0(i10, i11, false);
            RecyclerView.this.f1094u0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0019a
        public void g(int i10, int i11) {
            RecyclerView.this.I0(i10, i11);
            RecyclerView.this.f1094u0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0019a
        public void h(int i10, int i11) {
            RecyclerView.this.K0(i10, i11, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f1094u0 = true;
            recyclerView.f1088r0.f1114d += i11;
        }

        public void i(androidx.recyclerview.widget.a.b bVar) {
            int i10 = bVar.f1277a;
            if (i10 == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.f1097w.S0(recyclerView, bVar.f1278b, bVar.f1280d);
                return;
            }
            if (i10 == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.f1097w.V0(recyclerView2, bVar.f1278b, bVar.f1280d);
            } else if (i10 == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.f1097w.X0(recyclerView3, bVar.f1278b, bVar.f1280d, bVar.f1279c);
            } else {
                if (i10 != 8) {
                    return;
                }
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.f1097w.U0(recyclerView4, bVar.f1278b, bVar.f1280d, 1);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static /* synthetic */ class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1159a;

        static {
            int[] iArr = new int[Adapter.StateRestorationPolicy.values().length];
            f1159a = iArr;
            try {
                iArr[Adapter.StateRestorationPolicy.PREVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1159a[Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
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
                ((i) ((Observable) this).mObservers.get(size)).l(i10, i11, 1);
            }
        }

        public void d(int i10, int i11) {
            e(i10, i11, null);
        }

        public void e(int i10, int i11, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).h(i10, i11, obj);
            }
        }

        public void f(int i10, int i11) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).k(i10, i11);
            }
        }

        public void g(int i10, int i11) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).m(i10, i11);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface j {
        int a(int i10, int i11);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class k {
        public EdgeEffect a(RecyclerView recyclerView, int i10) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class m implements l.b {
        public m() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l.b
        public void a(d0 d0Var) {
            d0Var.I(true);
            if (d0Var.f1145h != null && d0Var.f1146i == null) {
                d0Var.f1145h = null;
            }
            d0Var.f1146i = null;
            if (d0Var.K() || RecyclerView.this.c1(d0Var.f1138a) || !d0Var.z()) {
                return;
            }
            RecyclerView.this.removeDetachedView(d0Var.f1138a, false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface q {
        void b(View view);

        void d(View view);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class r {
        public abstract boolean a(int i10, int i11);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface s {
        void a(RecyclerView recyclerView, MotionEvent motionEvent);

        boolean c(RecyclerView recyclerView, MotionEvent motionEvent);

        void e(boolean z10);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SparseArray f1199a = new SparseArray();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1200b = 0;

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ArrayList f1201a = new ArrayList();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f1202b = 5;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public long f1203c = 0;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public long f1204d = 0;
        }

        public void a() {
            this.f1200b++;
        }

        public void b() {
            for (int i10 = 0; i10 < this.f1199a.size(); i10++) {
                ((a) this.f1199a.valueAt(i10)).f1201a.clear();
            }
        }

        public void c() {
            this.f1200b--;
        }

        public void d(int i10, long j10) {
            a aVarG = g(i10);
            aVarG.f1204d = j(aVarG.f1204d, j10);
        }

        public void e(int i10, long j10) {
            a aVarG = g(i10);
            aVarG.f1203c = j(aVarG.f1203c, j10);
        }

        public d0 f(int i10) {
            a aVar = (a) this.f1199a.get(i10);
            if (aVar == null || aVar.f1201a.isEmpty()) {
                return null;
            }
            ArrayList arrayList = aVar.f1201a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!((d0) arrayList.get(size)).t()) {
                    return (d0) arrayList.remove(size);
                }
            }
            return null;
        }

        public final a g(int i10) {
            a aVar = (a) this.f1199a.get(i10);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f1199a.put(i10, aVar2);
            return aVar2;
        }

        public void h(Adapter adapter, Adapter adapter2, boolean z10) {
            if (adapter != null) {
                c();
            }
            if (!z10 && this.f1200b == 0) {
                b();
            }
            if (adapter2 != null) {
                a();
            }
        }

        public void i(d0 d0Var) {
            int iN = d0Var.n();
            ArrayList arrayList = g(iN).f1201a;
            if (((a) this.f1199a.get(iN)).f1202b <= arrayList.size()) {
                return;
            }
            d0Var.F();
            arrayList.add(d0Var);
        }

        public long j(long j10, long j11) {
            return j10 == 0 ? j11 : ((j10 / 4) * 3) + (j11 / 4);
        }

        public boolean k(int i10, long j10, long j11) {
            long j12 = g(i10).f1204d;
            return j12 == 0 || j10 + j12 < j11;
        }

        public boolean l(int i10, long j10, long j11) {
            long j12 = g(i10).f1203c;
            return j12 == 0 || j10 + j12 < j11;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface w {
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class x extends i {
        public x() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void a() {
            RecyclerView.this.s(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f1088r0.f1117g = true;
            recyclerView.W0(true);
            if (RecyclerView.this.f1079n.p()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void h(int i10, int i11, Object obj) {
            RecyclerView.this.s(null);
            if (RecyclerView.this.f1079n.r(i10, i11, obj)) {
                n();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void k(int i10, int i11) {
            RecyclerView.this.s(null);
            if (RecyclerView.this.f1079n.s(i10, i11)) {
                n();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void l(int i10, int i11, int i12) {
            RecyclerView.this.s(null);
            if (RecyclerView.this.f1079n.t(i10, i11, i12)) {
                n();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void m(int i10, int i11) {
            RecyclerView.this.s(null);
            if (RecyclerView.this.f1079n.u(i10, i11)) {
                n();
            }
        }

        public void n() {
            if (RecyclerView.O0) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.C && recyclerView.B) {
                    y.r.Q(recyclerView, recyclerView.f1087r);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.K = true;
            recyclerView2.requestLayout();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class z {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView f1215b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public o f1216c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f1217d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f1218e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View f1219f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f1221h;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1214a = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final a f1220g = new a(0, 0);

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f1222a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f1223b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f1224c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f1225d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Interpolator f1226e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public boolean f1227f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public int f1228g;

            public a(int i10, int i11) {
                this(i10, i11, Integer.MIN_VALUE, null);
            }

            public boolean a() {
                return this.f1225d >= 0;
            }

            public void b(int i10) {
                this.f1225d = i10;
            }

            public void c(RecyclerView recyclerView) {
                int i10 = this.f1225d;
                if (i10 >= 0) {
                    this.f1225d = -1;
                    recyclerView.C0(i10);
                    this.f1227f = false;
                } else {
                    if (!this.f1227f) {
                        this.f1228g = 0;
                        return;
                    }
                    e();
                    recyclerView.f1082o0.e(this.f1222a, this.f1223b, this.f1224c, this.f1226e);
                    int i11 = this.f1228g + 1;
                    this.f1228g = i11;
                    if (i11 > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f1227f = false;
                }
            }

            public void d(int i10, int i11, int i12, Interpolator interpolator) {
                this.f1222a = i10;
                this.f1223b = i11;
                this.f1224c = i12;
                this.f1226e = interpolator;
                this.f1227f = true;
            }

            public final void e() {
                if (this.f1226e != null && this.f1224c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.f1224c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public a(int i10, int i11, int i12, Interpolator interpolator) {
                this.f1225d = -1;
                this.f1227f = false;
                this.f1228g = 0;
                this.f1222a = i10;
                this.f1223b = i11;
                this.f1224c = i12;
                this.f1226e = interpolator;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
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
            return this.f1215b.f1097w.D(i10);
        }

        public int c() {
            return this.f1215b.f1097w.K();
        }

        public int d(View view) {
            return this.f1215b.j0(view);
        }

        public o e() {
            return this.f1216c;
        }

        public int f() {
            return this.f1214a;
        }

        public boolean g() {
            return this.f1217d;
        }

        public boolean h() {
            return this.f1218e;
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
            RecyclerView recyclerView = this.f1215b;
            if (this.f1214a == -1 || recyclerView == null) {
                r();
            }
            if (this.f1217d && this.f1219f == null && this.f1216c != null && (pointFA = a(this.f1214a)) != null) {
                float f10 = pointFA.x;
                if (f10 != 0.0f || pointFA.y != 0.0f) {
                    recyclerView.o1((int) Math.signum(f10), (int) Math.signum(pointFA.y), null);
                }
            }
            this.f1217d = false;
            View view = this.f1219f;
            if (view != null) {
                if (d(view) == this.f1214a) {
                    o(this.f1219f, recyclerView.f1088r0, this.f1220g);
                    this.f1220g.c(recyclerView);
                    r();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f1219f = null;
                }
            }
            if (this.f1218e) {
                l(i10, i11, recyclerView.f1088r0, this.f1220g);
                boolean zA = this.f1220g.a();
                this.f1220g.c(recyclerView);
                if (zA && this.f1218e) {
                    this.f1217d = true;
                    recyclerView.f1082o0.d();
                }
            }
        }

        public void k(View view) {
            if (d(view) == f()) {
                this.f1219f = view;
            }
        }

        public abstract void l(int i10, int i11, a0 a0Var, a aVar);

        public abstract void m();

        public abstract void n();

        public abstract void o(View view, a0 a0Var, a aVar);

        public void p(int i10) {
            this.f1214a = i10;
        }

        public void q(RecyclerView recyclerView, o oVar) {
            recyclerView.f1082o0.f();
            if (this.f1221h) {
                Log.w("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.f1215b = recyclerView;
            this.f1216c = oVar;
            int i10 = this.f1214a;
            if (i10 == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.f1088r0.f1111a = i10;
            this.f1218e = true;
            this.f1217d = true;
            this.f1219f = b(f());
            m();
            this.f1215b.f1082o0.d();
            this.f1221h = true;
        }

        public final void r() {
            if (this.f1218e) {
                this.f1218e = false;
                n();
                this.f1215b.f1088r0.f1111a = -1;
                this.f1219f = null;
                this.f1214a = -1;
                this.f1217d = false;
                this.f1216c.g1(this);
                this.f1216c = null;
                this.f1215b = null;
            }
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        M0 = i10 == 19 || i10 == 20;
        N0 = i10 >= 23;
        O0 = true;
        P0 = i10 >= 21;
        Q0 = false;
        R0 = false;
        Class cls = Integer.TYPE;
        S0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        T0 = new c();
    }

    public RecyclerView(Context context) {
        this(context, null);
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

    private y.l getScrollingChildHelper() {
        if (this.B0 == null) {
            this.B0 = new y.l(this);
        }
        return this.B0;
    }

    public static d0 l0(View view) {
        if (view == null) {
            return null;
        }
        return ((p) view.getLayoutParams()).f1195a;
    }

    public static void n0(View view, Rect rect) {
        p pVar = (p) view.getLayoutParams();
        Rect rect2 = pVar.f1196b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) pVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) pVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
    }

    public static void v(d0 d0Var) {
        WeakReference weakReference = d0Var.f1139b;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            while (view != null) {
                if (view == d0Var.f1138a) {
                    return;
                }
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            d0Var.f1139b = null;
        }
    }

    public void A(int i10, int i11) {
        setMeasuredDimension(o.o(i10, getPaddingLeft() + getPaddingRight(), y.r.x(this)), o.o(i11, getPaddingTop() + getPaddingBottom(), y.r.w(this)));
    }

    public boolean A0() {
        return this.P > 0;
    }

    public void A1(boolean z10) {
        if (this.F < 1) {
            this.F = 1;
        }
        if (!z10 && !this.H) {
            this.G = false;
        }
        if (this.F == 1) {
            if (z10 && this.G && !this.H && this.f1097w != null && this.f1095v != null) {
                F();
            }
            if (!this.H) {
                this.G = false;
            }
        }
        this.F--;
    }

    public final boolean B(int i10, int i11) {
        Z(this.A0);
        int[] iArr = this.A0;
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
        this.f1089s.set(0, 0, view.getWidth(), view.getHeight());
        this.f1091t.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.f1089s);
        offsetDescendantRectToMyCoords(view2, this.f1091t);
        byte b10 = -1;
        int i12 = this.f1097w.a0() == 1 ? -1 : 1;
        Rect rect = this.f1089s;
        int i13 = rect.left;
        Rect rect2 = this.f1091t;
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
            b10 = 1;
        } else {
            int i19 = rect.bottom;
            int i20 = rect2.bottom;
            if ((i19 <= i20 && i17 < i20) || i17 <= i18) {
                b10 = 0;
            }
        }
        if (i10 == 1) {
            return b10 < 0 || (b10 == 0 && i11 * i12 < 0);
        }
        if (i10 == 2) {
            return b10 > 0 || (b10 == 0 && i11 * i12 > 0);
        }
        if (i10 == 17) {
            return i11 < 0;
        }
        if (i10 == 33) {
            return b10 < 0;
        }
        if (i10 == 66) {
            return i11 > 0;
        }
        if (i10 == 130) {
            return b10 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i10 + T());
    }

    public void B1(int i10) {
        getScrollingChildHelper().r(i10);
    }

    public void C(View view) {
        d0 d0VarL0 = l0(view);
        L0(view);
        Adapter adapter = this.f1095v;
        if (adapter != null && d0VarL0 != null) {
            adapter.B(d0VarL0);
        }
        List list = this.M;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((q) this.M.get(size)).d(view);
            }
        }
    }

    public void C0(int i10) {
        if (this.f1097w == null) {
            return;
        }
        setScrollState(2);
        this.f1097w.y1(i10);
        awakenScrollBars();
    }

    public void C1() {
        setScrollState(0);
        D1();
    }

    public void D(View view) {
        d0 d0VarL0 = l0(view);
        M0(view);
        Adapter adapter = this.f1095v;
        if (adapter != null && d0VarL0 != null) {
            adapter.C(d0VarL0);
        }
        List list = this.M;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((q) this.M.get(size)).b(view);
            }
        }
    }

    public void D0() {
        int iJ = this.f1081o.j();
        for (int i10 = 0; i10 < iJ; i10++) {
            ((p) this.f1081o.i(i10).getLayoutParams()).f1197c = true;
        }
        this.f1068e.s();
    }

    public final void D1() {
        this.f1082o0.f();
        o oVar = this.f1097w;
        if (oVar != null) {
            oVar.L1();
        }
    }

    public final void E() {
        int i10 = this.J;
        this.J = 0;
        if (i10 == 0 || !z0()) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
        accessibilityEventObtain.setEventType(2048);
        z.b.b(accessibilityEventObtain, i10);
        sendAccessibilityEventUnchecked(accessibilityEventObtain);
    }

    public void E0() {
        int iJ = this.f1081o.j();
        for (int i10 = 0; i10 < iJ; i10++) {
            d0 d0VarL0 = l0(this.f1081o.i(i10));
            if (d0VarL0 != null && !d0VarL0.L()) {
                d0VarL0.b(6);
            }
        }
        D0();
        this.f1068e.t();
    }

    public void E1(Adapter adapter, boolean z10) {
        setLayoutFrozen(false);
        q1(adapter, true, z10);
        W0(true);
        requestLayout();
    }

    public void F() {
        if (this.f1095v == null) {
            Log.w("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.f1097w == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        this.f1088r0.f1120j = false;
        boolean z10 = this.H0 && !(this.I0 == getWidth() && this.J0 == getHeight());
        this.I0 = 0;
        this.J0 = 0;
        this.H0 = false;
        if (this.f1088r0.f1115e == 1) {
            G();
            this.f1097w.A1(this);
            H();
        } else if (this.f1079n.q() || z10 || this.f1097w.p0() != getWidth() || this.f1097w.X() != getHeight()) {
            this.f1097w.A1(this);
            H();
        } else {
            this.f1097w.A1(this);
        }
        I();
    }

    public final void F0(int i10, int i11, MotionEvent motionEvent, int i12) {
        o oVar = this.f1097w;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.H) {
            return;
        }
        int[] iArr = this.E0;
        iArr[0] = 0;
        iArr[1] = 0;
        boolean zL = oVar.l();
        boolean zM = this.f1097w.m();
        z1(zM ? (zL ? 1 : 0) | 2 : zL ? 1 : 0, i12);
        if (J(zL ? i10 : 0, zM ? i11 : 0, this.E0, this.C0, i12)) {
            int[] iArr2 = this.E0;
            i10 -= iArr2[0];
            i11 -= iArr2[1];
        }
        n1(zL ? i10 : 0, zM ? i11 : 0, motionEvent, i12);
        androidx.recyclerview.widget.i iVar = this.f1084p0;
        if (iVar != null && (i10 != 0 || i11 != 0)) {
            iVar.f(this, i10, i11);
        }
        B1(i12);
    }

    public void F1(int i10, int i11, Object obj) {
        int i12;
        int iJ = this.f1081o.j();
        int i13 = i10 + i11;
        for (int i14 = 0; i14 < iJ; i14++) {
            View viewI = this.f1081o.i(i14);
            d0 d0VarL0 = l0(viewI);
            if (d0VarL0 != null && !d0VarL0.L() && (i12 = d0VarL0.f1140c) >= i10 && i12 < i13) {
                d0VarL0.b(2);
                d0VarL0.a(obj);
                ((p) viewI.getLayoutParams()).f1197c = true;
            }
        }
        this.f1068e.M(i10, i11);
    }

    public final void G() {
        this.f1088r0.a(1);
        U(this.f1088r0);
        this.f1088r0.f1120j = false;
        y1();
        this.f1083p.f();
        N0();
        V0();
        l1();
        a0 a0Var = this.f1088r0;
        a0Var.f1119i = a0Var.f1121k && this.f1096v0;
        this.f1096v0 = false;
        this.f1094u0 = false;
        a0Var.f1118h = a0Var.f1122l;
        a0Var.f1116f = this.f1095v.g();
        Z(this.A0);
        if (this.f1088r0.f1121k) {
            int iG = this.f1081o.g();
            for (int i10 = 0; i10 < iG; i10++) {
                d0 d0VarL0 = l0(this.f1081o.f(i10));
                if (!d0VarL0.L() && (!d0VarL0.v() || this.f1095v.k())) {
                    this.f1083p.e(d0VarL0, this.W.u(this.f1088r0, d0VarL0, l.e(d0VarL0), d0VarL0.q()));
                    if (this.f1088r0.f1119i && d0VarL0.A() && !d0VarL0.x() && !d0VarL0.L() && !d0VarL0.v()) {
                        this.f1083p.c(h0(d0VarL0), d0VarL0);
                    }
                }
            }
        }
        if (this.f1088r0.f1122l) {
            m1();
            a0 a0Var2 = this.f1088r0;
            boolean z10 = a0Var2.f1117g;
            a0Var2.f1117g = false;
            this.f1097w.Y0(this.f1068e, a0Var2);
            this.f1088r0.f1117g = z10;
            for (int i11 = 0; i11 < this.f1081o.g(); i11++) {
                d0 d0VarL1 = l0(this.f1081o.f(i11));
                if (!d0VarL1.L() && !this.f1083p.i(d0VarL1)) {
                    int iE = l.e(d0VarL1);
                    boolean zR = d0VarL1.r(8192);
                    if (!zR) {
                        iE |= 4096;
                    }
                    l.c cVarU = this.W.u(this.f1088r0, d0VarL1, iE, d0VarL1.q());
                    if (zR) {
                        Y0(d0VarL1, cVarU);
                    } else {
                        this.f1083p.a(d0VarL1, cVarU);
                    }
                }
            }
            w();
        } else {
            w();
        }
        O0();
        A1(false);
        this.f1088r0.f1115e = 2;
    }

    public void G0(int i10) {
        int iG = this.f1081o.g();
        for (int i11 = 0; i11 < iG; i11++) {
            this.f1081o.f(i11).offsetLeftAndRight(i10);
        }
    }

    public final void H() {
        y1();
        N0();
        this.f1088r0.a(6);
        this.f1079n.j();
        this.f1088r0.f1116f = this.f1095v.g();
        this.f1088r0.f1114d = 0;
        if (this.f1077m != null && this.f1095v.d()) {
            Parcelable parcelable = this.f1077m.f1109m;
            if (parcelable != null) {
                this.f1097w.d1(parcelable);
            }
            this.f1077m = null;
        }
        a0 a0Var = this.f1088r0;
        a0Var.f1118h = false;
        this.f1097w.Y0(this.f1068e, a0Var);
        a0 a0Var2 = this.f1088r0;
        a0Var2.f1117g = false;
        a0Var2.f1121k = a0Var2.f1121k && this.W != null;
        a0Var2.f1115e = 4;
        O0();
        A1(false);
    }

    public void H0(int i10) {
        int iG = this.f1081o.g();
        for (int i11 = 0; i11 < iG; i11++) {
            this.f1081o.f(i11).offsetTopAndBottom(i10);
        }
    }

    public final void I() {
        RecyclerView recyclerView;
        this.f1088r0.a(4);
        y1();
        N0();
        a0 a0Var = this.f1088r0;
        a0Var.f1115e = 1;
        if (a0Var.f1121k) {
            for (int iG = this.f1081o.g() - 1; iG >= 0; iG--) {
                d0 d0VarL0 = l0(this.f1081o.f(iG));
                if (!d0VarL0.L()) {
                    long jH0 = h0(d0VarL0);
                    l.c cVarT = this.W.t(this.f1088r0, d0VarL0);
                    d0 d0VarG = this.f1083p.g(jH0);
                    if (d0VarG == null || d0VarG.L()) {
                        this.f1083p.d(d0VarL0, cVarT);
                    } else {
                        boolean zH = this.f1083p.h(d0VarG);
                        boolean zH2 = this.f1083p.h(d0VarL0);
                        if (zH && d0VarG == d0VarL0) {
                            this.f1083p.d(d0VarL0, cVarT);
                        } else {
                            l.c cVarN = this.f1083p.n(d0VarG);
                            this.f1083p.d(d0VarL0, cVarT);
                            l.c cVarM = this.f1083p.m(d0VarL0);
                            if (cVarN == null) {
                                r0(jH0, d0VarL0, d0VarG);
                            } else {
                                q(d0VarG, d0VarL0, cVarN, cVarM, zH, zH2);
                            }
                        }
                    }
                }
            }
            recyclerView = this;
            recyclerView.f1083p.o(recyclerView.K0);
        } else {
            recyclerView = this;
        }
        recyclerView.f1097w.m1(recyclerView.f1068e);
        a0 a0Var2 = recyclerView.f1088r0;
        a0Var2.f1113c = a0Var2.f1116f;
        recyclerView.N = false;
        recyclerView.O = false;
        a0Var2.f1121k = false;
        a0Var2.f1122l = false;
        recyclerView.f1097w.f1178h = false;
        ArrayList arrayList = recyclerView.f1068e.f1206b;
        if (arrayList != null) {
            arrayList.clear();
        }
        o oVar = recyclerView.f1097w;
        if (oVar.f1184n) {
            oVar.f1183m = 0;
            oVar.f1184n = false;
            recyclerView.f1068e.K();
        }
        recyclerView.f1097w.Z0(recyclerView.f1088r0);
        O0();
        A1(false);
        recyclerView.f1083p.f();
        int[] iArr = recyclerView.A0;
        if (B(iArr[0], iArr[1])) {
            M(0, 0);
        }
        Z0();
        j1();
    }

    public void I0(int i10, int i11) {
        int iJ = this.f1081o.j();
        for (int i12 = 0; i12 < iJ; i12++) {
            d0 d0VarL0 = l0(this.f1081o.i(i12));
            if (d0VarL0 != null && !d0VarL0.L() && d0VarL0.f1140c >= i10) {
                d0VarL0.C(i11, false);
                this.f1088r0.f1117g = true;
            }
        }
        this.f1068e.u(i10, i11);
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
        int iJ = this.f1081o.j();
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
            d0 d0VarL0 = l0(this.f1081o.i(i16));
            if (d0VarL0 != null && (i15 = d0VarL0.f1140c) >= i13 && i15 <= i12) {
                if (i15 == i10) {
                    d0VarL0.C(i11 - i10, false);
                } else {
                    d0VarL0.C(i14, false);
                }
                this.f1088r0.f1117g = true;
            }
        }
        this.f1068e.v(i10, i11);
        requestLayout();
    }

    public final void K(int i10, int i11, int i12, int i13, int[] iArr, int i14, int[] iArr2) {
        getScrollingChildHelper().e(i10, i11, i12, i13, iArr, i14, iArr2);
    }

    public void K0(int i10, int i11, boolean z10) {
        int i12 = i10 + i11;
        int iJ = this.f1081o.j();
        for (int i13 = 0; i13 < iJ; i13++) {
            d0 d0VarL0 = l0(this.f1081o.i(i13));
            if (d0VarL0 != null && !d0VarL0.L()) {
                int i14 = d0VarL0.f1140c;
                if (i14 >= i12) {
                    d0VarL0.C(-i11, z10);
                    this.f1088r0.f1117g = true;
                } else if (i14 >= i10) {
                    d0VarL0.i(i10 - 1, -i11, z10);
                    this.f1088r0.f1117g = true;
                }
            }
        }
        this.f1068e.w(i10, i11, z10);
        requestLayout();
    }

    public void L(int i10) {
        o oVar = this.f1097w;
        if (oVar != null) {
            oVar.f1(i10);
        }
        R0(i10);
        t tVar = this.f1090s0;
        if (tVar != null) {
            tVar.a(this, i10);
        }
        List list = this.f1092t0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((t) this.f1092t0.get(size)).a(this, i10);
            }
        }
    }

    public void M(int i10, int i11) {
        this.Q++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i10, scrollY - i11);
        S0(i10, i11);
        t tVar = this.f1090s0;
        if (tVar != null) {
            tVar.b(this, i10, i11);
        }
        List list = this.f1092t0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((t) this.f1092t0.get(size)).b(this, i10, i11);
            }
        }
        this.Q--;
    }

    public void N() {
        int i10;
        for (int size = this.F0.size() - 1; size >= 0; size--) {
            d0 d0Var = (d0) this.F0.get(size);
            if (d0Var.f1138a.getParent() == this && !d0Var.L() && (i10 = d0Var.f1154q) != -1) {
                y.r.c0(d0Var.f1138a, i10);
                d0Var.f1154q = -1;
            }
        }
        this.F0.clear();
    }

    public void N0() {
        this.P++;
    }

    public final boolean O(MotionEvent motionEvent) {
        s sVar = this.A;
        if (sVar == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return Y(motionEvent);
        }
        sVar.a(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.A = null;
        }
        return true;
    }

    public void O0() {
        P0(true);
    }

    public void P() {
        if (this.V != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.R.a(this, 3);
        this.V = edgeEffectA;
        if (this.f1085q) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void P0(boolean z10) {
        int i10 = this.P - 1;
        this.P = i10;
        if (i10 < 1) {
            this.P = 0;
            if (z10) {
                E();
                N();
            }
        }
    }

    public void Q() {
        if (this.S != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.R.a(this, 0);
        this.S = edgeEffectA;
        if (this.f1085q) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final void Q0(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f1064b0) {
            int i10 = actionIndex == 0 ? 1 : 0;
            this.f1064b0 = motionEvent.getPointerId(i10);
            int x10 = (int) (motionEvent.getX(i10) + 0.5f);
            this.f1070f0 = x10;
            this.f1067d0 = x10;
            int y10 = (int) (motionEvent.getY(i10) + 0.5f);
            this.f1071g0 = y10;
            this.f1069e0 = y10;
        }
    }

    public void R() {
        if (this.U != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.R.a(this, 2);
        this.U = edgeEffectA;
        if (this.f1085q) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void S() {
        if (this.T != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.R.a(this, 1);
        this.T = edgeEffectA;
        if (this.f1085q) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public String T() {
        return " " + super.toString() + ", adapter:" + this.f1095v + ", layout:" + this.f1097w + ", context:" + getContext();
    }

    public void T0() {
        if (this.f1100x0 || !this.B) {
            return;
        }
        y.r.Q(this, this.G0);
        this.f1100x0 = true;
    }

    public final void U(a0 a0Var) {
        if (getScrollState() != 2) {
            a0Var.f1126p = 0;
            a0Var.f1127q = 0;
        } else {
            OverScroller overScroller = this.f1082o0.f1131m;
            a0Var.f1126p = overScroller.getFinalX() - overScroller.getCurrX();
            a0Var.f1127q = overScroller.getFinalY() - overScroller.getCurrY();
        }
    }

    public final boolean U0() {
        return this.W != null && this.f1097w.M1();
    }

    public View V(float f10, float f11) {
        for (int iG = this.f1081o.g() - 1; iG >= 0; iG--) {
            View viewF = this.f1081o.f(iG);
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
        if (this.N) {
            this.f1079n.y();
            if (this.O) {
                this.f1097w.T0(this);
            }
        }
        if (U0()) {
            this.f1079n.w();
        } else {
            this.f1079n.j();
        }
        boolean z11 = this.f1094u0 || this.f1096v0;
        this.f1088r0.f1121k = this.E && this.W != null && ((z10 = this.N) || z11 || this.f1097w.f1178h) && (!z10 || this.f1095v.k());
        a0 a0Var = this.f1088r0;
        a0Var.f1122l = a0Var.f1121k && z11 && !this.N && U0();
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
        this.O = z10 | this.O;
        this.N = true;
        E0();
    }

    public d0 X(View view) {
        View viewW = W(view);
        if (viewW == null) {
            return null;
        }
        return k0(viewW);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0040  */
    /* JADX WARN: Code duplicated, block: B:13:0x0056  */
    /* JADX WARN: Code duplicated, block: B:15:0x005a  */
    /* JADX WARN: Code duplicated, block: B:16:0x0071  */
    public final void X0(float f10, float f11, float f12, float f13) {
        boolean z10;
        boolean z11 = true;
        if (f11 >= 0.0f) {
            if (f11 > 0.0f) {
                R();
                androidx.core.widget.a.a(this.U, f11 / getWidth(), f12 / getHeight());
            } else {
                z10 = false;
            }
            if (f13 < 0.0f) {
                S();
                androidx.core.widget.a.a(this.T, (-f13) / getHeight(), f10 / getWidth());
            } else if (f13 > 0.0f) {
                P();
                androidx.core.widget.a.a(this.V, f13 / getHeight(), 1.0f - (f10 / getWidth()));
            } else {
                z11 = z10;
            }
            if (z11 && f11 == 0.0f && f13 == 0.0f) {
                return;
            }
            y.r.P(this);
        }
        Q();
        androidx.core.widget.a.a(this.S, (-f11) / getWidth(), 1.0f - (f12 / getHeight()));
        z10 = true;
        if (f13 < 0.0f) {
            S();
            androidx.core.widget.a.a(this.T, (-f13) / getHeight(), f10 / getWidth());
        } else if (f13 > 0.0f) {
            P();
            androidx.core.widget.a.a(this.V, f13 / getHeight(), 1.0f - (f10 / getWidth()));
        } else {
            z11 = z10;
        }
        if (z11) {
        }
        y.r.P(this);
    }

    public final boolean Y(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.f1103z.size();
        for (int i10 = 0; i10 < size; i10++) {
            s sVar = (s) this.f1103z.get(i10);
            if (sVar.c(this, motionEvent) && action != 3) {
                this.A = sVar;
                return true;
            }
        }
        return false;
    }

    public void Y0(d0 d0Var, l.c cVar) {
        d0Var.H(0, 8192);
        if (this.f1088r0.f1119i && d0Var.A() && !d0Var.x() && !d0Var.L()) {
            this.f1083p.c(h0(d0Var), d0Var);
        }
        this.f1083p.e(d0Var, cVar);
    }

    public final void Z(int[] iArr) {
        int iG = this.f1081o.g();
        if (iG == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i10 = Integer.MAX_VALUE;
        int i11 = Integer.MIN_VALUE;
        for (int i12 = 0; i12 < iG; i12++) {
            d0 d0VarL0 = l0(this.f1081o.f(i12));
            if (!d0VarL0.L()) {
                int iO = d0VarL0.o();
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
        if (!this.f1080n0 || this.f1095v == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (!R0 || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                if (!this.f1081o.n(focusedChild)) {
                    return;
                }
            } else if (this.f1081o.g() == 0) {
                requestFocus();
                return;
            }
        }
        View viewB0 = null;
        d0 d0VarD0 = (this.f1088r0.f1124n == -1 || !this.f1095v.k()) ? null : d0(this.f1088r0.f1124n);
        if (d0VarD0 != null && !this.f1081o.n(d0VarD0.f1138a) && d0VarD0.f1138a.hasFocusable()) {
            viewB0 = d0VarD0.f1138a;
        } else if (this.f1081o.g() > 0) {
            viewB0 = b0();
        }
        if (viewB0 != null) {
            int i10 = this.f1088r0.f1125o;
            if (i10 != -1 && (viewFindViewById = viewB0.findViewById(i10)) != null && viewFindViewById.isFocusable()) {
                viewB0 = viewFindViewById;
            }
            viewB0.requestFocus();
        }
    }

    public final void a1() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.S;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.S.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.T;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.T.isFinished();
        }
        EdgeEffect edgeEffect3 = this.U;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.U.isFinished();
        }
        EdgeEffect edgeEffect4 = this.V;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.V.isFinished();
        }
        if (zIsFinished) {
            y.r.P(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList arrayList, int i10, int i11) {
        o oVar = this.f1097w;
        if (oVar == null || !oVar.G0(this, arrayList, i10, i11)) {
            super.addFocusables(arrayList, i10, i11);
        }
    }

    public final View b0() {
        d0 d0VarC0;
        a0 a0Var = this.f1088r0;
        int i10 = a0Var.f1123m;
        if (i10 == -1) {
            i10 = 0;
        }
        int iB = a0Var.b();
        for (int i11 = i10; i11 < iB; i11++) {
            d0 d0VarC1 = c0(i11);
            if (d0VarC1 == null) {
                break;
            }
            if (d0VarC1.f1138a.hasFocusable()) {
                return d0VarC1.f1138a;
            }
        }
        int iMin = Math.min(iB, i10);
        do {
            iMin--;
            if (iMin < 0 || (d0VarC0 = c0(iMin)) == null) {
                return null;
            }
        } while (!d0VarC0.f1138a.hasFocusable());
        return d0VarC0.f1138a;
    }

    public void b1() {
        l lVar = this.W;
        if (lVar != null) {
            lVar.k();
        }
        o oVar = this.f1097w;
        if (oVar != null) {
            oVar.l1(this.f1068e);
            this.f1097w.m1(this.f1068e);
        }
        this.f1068e.c();
    }

    public d0 c0(int i10) {
        d0 d0Var = null;
        if (this.N) {
            return null;
        }
        int iJ = this.f1081o.j();
        for (int i11 = 0; i11 < iJ; i11++) {
            d0 d0VarL0 = l0(this.f1081o.i(i11));
            if (d0VarL0 != null && !d0VarL0.x() && g0(d0VarL0) == i10) {
                if (!this.f1081o.n(d0VarL0.f1138a)) {
                    return d0VarL0;
                }
                d0Var = d0VarL0;
            }
        }
        return d0Var;
    }

    public boolean c1(View view) {
        y1();
        boolean zR = this.f1081o.r(view);
        if (zR) {
            d0 d0VarL0 = l0(view);
            this.f1068e.J(d0VarL0);
            this.f1068e.C(d0VarL0);
        }
        A1(!zR);
        return zR;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof p) && this.f1097w.n((p) layoutParams);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        o oVar = this.f1097w;
        if (oVar != null && oVar.l()) {
            return this.f1097w.r(this.f1088r0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        o oVar = this.f1097w;
        if (oVar != null && oVar.l()) {
            return this.f1097w.s(this.f1088r0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        o oVar = this.f1097w;
        if (oVar != null && oVar.l()) {
            return this.f1097w.t(this.f1088r0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        o oVar = this.f1097w;
        if (oVar != null && oVar.m()) {
            return this.f1097w.u(this.f1088r0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        o oVar = this.f1097w;
        if (oVar != null && oVar.m()) {
            return this.f1097w.v(this.f1088r0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        o oVar = this.f1097w;
        if (oVar != null && oVar.m()) {
            return this.f1097w.w(this.f1088r0);
        }
        return 0;
    }

    public d0 d0(long j10) {
        Adapter adapter = this.f1095v;
        d0 d0Var = null;
        if (adapter != null && adapter.k()) {
            int iJ = this.f1081o.j();
            for (int i10 = 0; i10 < iJ; i10++) {
                d0 d0VarL0 = l0(this.f1081o.i(i10));
                if (d0VarL0 != null && !d0VarL0.x() && d0VarL0.m() == j10) {
                    if (!this.f1081o.n(d0VarL0.f1138a)) {
                        return d0VarL0;
                    }
                    d0Var = d0VarL0;
                }
            }
        }
        return d0Var;
    }

    public void d1(n nVar) {
        o oVar = this.f1097w;
        if (oVar != null) {
            oVar.h("Cannot remove item decoration during a scroll  or layout");
        }
        this.f1101y.remove(nVar);
        if (this.f1101y.isEmpty()) {
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
        int size = this.f1101y.size();
        boolean z11 = false;
        for (int i10 = 0; i10 < size; i10++) {
            ((n) this.f1101y.get(i10)).k(canvas, this, this.f1088r0);
        }
        EdgeEffect edgeEffect = this.S;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z10 = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.f1085q ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.S;
            z10 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.T;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.f1085q) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.T;
            z10 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.U;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f1085q ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(paddingTop, -width);
            EdgeEffect edgeEffect6 = this.U;
            z10 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.V;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f1085q) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.V;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z11 = true;
            }
            z10 |= z11;
            canvas.restoreToCount(iSave4);
        }
        if ((z10 || this.W == null || this.f1101y.size() <= 0 || !this.W.p()) ? z10 : true) {
            y.r.P(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j10) {
        return super.drawChild(canvas, view, j10);
    }

    public void e(int i10, int i11) {
        if (i10 < 0) {
            Q();
            if (this.S.isFinished()) {
                this.S.onAbsorb(-i10);
            }
        } else if (i10 > 0) {
            R();
            if (this.U.isFinished()) {
                this.U.onAbsorb(i10);
            }
        }
        if (i11 < 0) {
            S();
            if (this.T.isFinished()) {
                this.T.onAbsorb(-i11);
            }
        } else if (i11 > 0) {
            P();
            if (this.V.isFinished()) {
                this.V.onAbsorb(i11);
            }
        }
        if (i10 == 0 && i11 == 0) {
            return;
        }
        y.r.P(this);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002a  */
    /* JADX WARN: Code duplicated, block: B:17:0x0034  */
    /* JADX WARN: Code duplicated, block: B:22:0x0036 A[SYNTHETIC] */
    public d0 e0(int i10, boolean z10) {
        int iJ = this.f1081o.j();
        d0 d0Var = null;
        for (int i11 = 0; i11 < iJ; i11++) {
            d0 d0VarL0 = l0(this.f1081o.i(i11));
            if (d0VarL0 != null && !d0VarL0.x()) {
                if (z10) {
                    if (d0VarL0.f1140c != i10) {
                        continue;
                    } else {
                        if (this.f1081o.n(d0VarL0.f1138a)) {
                            return d0VarL0;
                        }
                        d0Var = d0VarL0;
                    }
                } else if (d0VarL0.o() != i10) {
                    continue;
                } else {
                    if (this.f1081o.n(d0VarL0.f1138a)) {
                        return d0VarL0;
                    }
                    d0Var = d0VarL0;
                }
            }
        }
        return d0Var;
    }

    public void e1(q qVar) {
        List list = this.M;
        if (list == null) {
            return;
        }
        list.remove(qVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public boolean f0(int i10, int i11) {
        o oVar = this.f1097w;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.H) {
            return false;
        }
        int iL = oVar.l();
        boolean zM = this.f1097w.m();
        if (iL == 0 || Math.abs(i10) < this.f1074j0) {
            i10 = 0;
        }
        if (!zM || Math.abs(i11) < this.f1074j0) {
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
            r rVar = this.f1073i0;
            if (rVar != null && rVar.a(i10, i11)) {
                return true;
            }
            if (z10) {
                if (zM) {
                    iL = (iL == true ? 1 : 0) | 2;
                }
                z1(iL, 1);
                int i12 = this.f1075k0;
                int iMax = Math.max(-i12, Math.min(i10, i12));
                int i13 = this.f1075k0;
                this.f1082o0.b(iMax, Math.max(-i13, Math.min(i11, i13)));
                return true;
            }
        }
        return false;
    }

    public void f1(s sVar) {
        this.f1103z.remove(sVar);
        if (this.A == sVar) {
            this.A = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i10) {
        View viewK0;
        boolean z10;
        View viewR0 = this.f1097w.R0(view, i10);
        if (viewR0 != null) {
            return viewR0;
        }
        boolean z11 = (this.f1095v == null || this.f1097w == null || A0() || this.H) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z11 && (i10 == 2 || i10 == 1)) {
            if (this.f1097w.m()) {
                int i11 = i10 == 2 ? 130 : 33;
                z10 = focusFinder.findNextFocus(this, view, i11) == null;
                if (Q0) {
                    i10 = i11;
                }
            } else {
                z10 = false;
            }
            if (!z10 && this.f1097w.l()) {
                int i12 = (this.f1097w.a0() == 1) ^ (i10 == 2) ? 66 : 17;
                boolean z12 = focusFinder.findNextFocus(this, view, i12) == null;
                if (Q0) {
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
                this.f1097w.K0(view, i10, this.f1068e, this.f1088r0);
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
                viewK0 = this.f1097w.K0(view, i10, this.f1068e, this.f1088r0);
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

    public int g0(d0 d0Var) {
        if (d0Var.r(524) || !d0Var.u()) {
            return -1;
        }
        return this.f1079n.e(d0Var.f1140c);
    }

    public void g1(t tVar) {
        List list = this.f1092t0;
        if (list != null) {
            list.remove(tVar);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        o oVar = this.f1097w;
        if (oVar != null) {
            return oVar.E();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + T());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        o oVar = this.f1097w;
        if (oVar != null) {
            return oVar.F(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + T());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public Adapter getAdapter() {
        return this.f1095v;
    }

    @Override // android.view.View
    public int getBaseline() {
        o oVar = this.f1097w;
        return oVar != null ? oVar.H() : super.getBaseline();
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i10, int i11) {
        j jVar = this.f1104z0;
        return jVar == null ? super.getChildDrawingOrder(i10, i11) : jVar.a(i10, i11);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f1085q;
    }

    public androidx.recyclerview.widget.s getCompatAccessibilityDelegate() {
        return this.f1102y0;
    }

    public k getEdgeEffectFactory() {
        return this.R;
    }

    public l getItemAnimator() {
        return this.W;
    }

    public int getItemDecorationCount() {
        return this.f1101y.size();
    }

    public o getLayoutManager() {
        return this.f1097w;
    }

    public int getMaxFlingVelocity() {
        return this.f1075k0;
    }

    public int getMinFlingVelocity() {
        return this.f1074j0;
    }

    public long getNanoTime() {
        if (P0) {
            return System.nanoTime();
        }
        return 0L;
    }

    public r getOnFlingListener() {
        return this.f1073i0;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f1080n0;
    }

    public u getRecycledViewPool() {
        return this.f1068e.i();
    }

    public int getScrollState() {
        return this.f1063a0;
    }

    public long h0(d0 d0Var) {
        return this.f1095v.k() ? d0Var.m() : d0Var.f1140c;
    }

    public void h1() {
        d0 d0Var;
        int iG = this.f1081o.g();
        for (int i10 = 0; i10 < iG; i10++) {
            View viewF = this.f1081o.f(i10);
            d0 d0VarK0 = k0(viewF);
            if (d0VarK0 != null && (d0Var = d0VarK0.f1146i) != null) {
                View view = d0Var.f1138a;
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
        d0 d0VarL0 = l0(view);
        if (d0VarL0 != null) {
            return d0VarL0.j();
        }
        return -1;
    }

    public final void i1(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.f1089s.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof p) {
            p pVar = (p) layoutParams;
            if (!pVar.f1197c) {
                Rect rect = pVar.f1196b;
                Rect rect2 = this.f1089s;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f1089s);
            offsetRectIntoDescendantCoords(view, this.f1089s);
        }
        this.f1097w.t1(this, view, this.f1089s, !this.E, view2 == null);
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.B;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.H;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().l();
    }

    public final void j(d0 d0Var) {
        View view = d0Var.f1138a;
        boolean z10 = view.getParent() == this;
        this.f1068e.J(k0(view));
        if (d0Var.z()) {
            this.f1081o.c(view, -1, view.getLayoutParams(), true);
        } else if (z10) {
            this.f1081o.k(view);
        } else {
            this.f1081o.b(view, true);
        }
    }

    public int j0(View view) {
        d0 d0VarL0 = l0(view);
        if (d0VarL0 != null) {
            return d0VarL0.o();
        }
        return -1;
    }

    public final void j1() {
        a0 a0Var = this.f1088r0;
        a0Var.f1124n = -1L;
        a0Var.f1123m = -1;
        a0Var.f1125o = -1;
    }

    public void k(n nVar) {
        l(nVar, -1);
    }

    public d0 k0(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return l0(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public final void k1() {
        VelocityTracker velocityTracker = this.f1066c0;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        B1(0);
        a1();
    }

    public void l(n nVar, int i10) {
        o oVar = this.f1097w;
        if (oVar != null) {
            oVar.h("Cannot add item decoration during a scroll  or layout");
        }
        if (this.f1101y.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i10 < 0) {
            this.f1101y.add(nVar);
        } else {
            this.f1101y.add(i10, nVar);
        }
        D0();
        requestLayout();
    }

    public final void l1() {
        int iJ;
        View focusedChild = (this.f1080n0 && hasFocus() && this.f1095v != null) ? getFocusedChild() : null;
        d0 d0VarX = focusedChild != null ? X(focusedChild) : null;
        if (d0VarX == null) {
            j1();
            return;
        }
        this.f1088r0.f1124n = this.f1095v.k() ? d0VarX.m() : -1L;
        a0 a0Var = this.f1088r0;
        if (this.N) {
            iJ = -1;
        } else {
            iJ = d0VarX.x() ? d0VarX.f1141d : d0VarX.j();
        }
        a0Var.f1123m = iJ;
        this.f1088r0.f1125o = o0(d0VarX.f1138a);
    }

    public void m(q qVar) {
        if (this.M == null) {
            this.M = new ArrayList();
        }
        this.M.add(qVar);
    }

    public void m0(View view, Rect rect) {
        n0(view, rect);
    }

    public void m1() {
        int iJ = this.f1081o.j();
        for (int i10 = 0; i10 < iJ; i10++) {
            d0 d0VarL0 = l0(this.f1081o.i(i10));
            if (!d0VarL0.L()) {
                d0VarL0.G();
            }
        }
    }

    public void n(s sVar) {
        this.f1103z.add(sVar);
    }

    public boolean n1(int i10, int i11, MotionEvent motionEvent, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        y();
        if (this.f1095v != null) {
            int[] iArr = this.E0;
            iArr[0] = 0;
            iArr[1] = 0;
            o1(i10, i11, iArr);
            int[] iArr2 = this.E0;
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
        if (!this.f1101y.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.E0;
        iArr3[0] = 0;
        iArr3[1] = 0;
        K(i13, i14, i15, i16, this.C0, i12, iArr3);
        int[] iArr4 = this.E0;
        int i19 = iArr4[0];
        int i20 = i15 - i19;
        int i21 = iArr4[1];
        int i22 = i16 - i21;
        boolean z10 = (i19 == 0 && i21 == 0) ? false : true;
        int i23 = this.f1070f0;
        int[] iArr5 = this.C0;
        int i24 = iArr5[0];
        this.f1070f0 = i23 - i24;
        int i25 = this.f1071g0;
        int i26 = iArr5[1];
        this.f1071g0 = i25 - i26;
        int[] iArr6 = this.D0;
        iArr6[0] = iArr6[0] + i24;
        iArr6[1] = iArr6[1] + i26;
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !y.j.a(motionEvent, 8194)) {
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
        if (this.f1092t0 == null) {
            this.f1092t0 = new ArrayList();
        }
        this.f1092t0.add(tVar);
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
        v.t.a("RV Scroll");
        U(this.f1088r0);
        int iX1 = i10 != 0 ? this.f1097w.x1(i10, this.f1068e, this.f1088r0) : 0;
        int iZ1 = i11 != 0 ? this.f1097w.z1(i11, this.f1068e, this.f1088r0) : 0;
        v.t.b();
        h1();
        O0();
        A1(false);
        if (iArr != null) {
            iArr[0] = iX1;
            iArr[1] = iZ1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004e  */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        float refreshRate;
        super.onAttachedToWindow();
        this.P = 0;
        this.B = true;
        this.E = this.E && !isLayoutRequested();
        o oVar = this.f1097w;
        if (oVar != null) {
            oVar.A(this);
        }
        this.f1100x0 = false;
        if (P0) {
            ThreadLocal threadLocal = androidx.recyclerview.widget.i.f1403o;
            androidx.recyclerview.widget.i iVar = (androidx.recyclerview.widget.i) threadLocal.get();
            this.f1084p0 = iVar;
            if (iVar == null) {
                this.f1084p0 = new androidx.recyclerview.widget.i();
                Display displayQ = y.r.q(this);
                if (isInEditMode() || displayQ == null) {
                    refreshRate = 60.0f;
                } else {
                    refreshRate = displayQ.getRefreshRate();
                    if (refreshRate < 30.0f) {
                        refreshRate = 60.0f;
                    }
                }
                androidx.recyclerview.widget.i iVar2 = this.f1084p0;
                iVar2.f1407m = (long) (1.0E9f / refreshRate);
                threadLocal.set(iVar2);
            }
            this.f1084p0.a(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        androidx.recyclerview.widget.i iVar;
        super.onDetachedFromWindow();
        l lVar = this.W;
        if (lVar != null) {
            lVar.k();
        }
        C1();
        this.B = false;
        o oVar = this.f1097w;
        if (oVar != null) {
            oVar.B(this, this.f1068e);
        }
        this.F0.clear();
        removeCallbacks(this.G0);
        this.f1083p.j();
        if (!P0 || (iVar = this.f1084p0) == null) {
            return;
        }
        iVar.j(this);
        this.f1084p0 = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f1101y.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((n) this.f1101y.get(i10)).i(canvas, this, this.f1088r0);
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0062  */
    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f10;
        float axisValue;
        if (this.f1097w != null && !this.H && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f10 = this.f1097w.m() ? -motionEvent.getAxisValue(9) : 0.0f;
                axisValue = this.f1097w.l() ? motionEvent.getAxisValue(10) : 0.0f;
            } else if ((motionEvent.getSource() & 4194304) != 0) {
                float axisValue2 = motionEvent.getAxisValue(26);
                if (this.f1097w.m()) {
                    f10 = -axisValue2;
                } else if (this.f1097w.l()) {
                    axisValue = axisValue2;
                    f10 = 0.0f;
                } else {
                    f10 = 0.0f;
                }
            } else {
                f10 = 0.0f;
            }
            if (f10 != 0.0f || axisValue != 0.0f) {
                F0((int) (axisValue * this.f1076l0), (int) (f10 * this.f1078m0), motionEvent, 1);
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        if (this.H) {
            return false;
        }
        this.A = null;
        if (Y(motionEvent)) {
            u();
            return true;
        }
        o oVar = this.f1097w;
        if (oVar == null) {
            return false;
        }
        boolean zL = oVar.l();
        boolean zM = this.f1097w.m();
        if (this.f1066c0 == null) {
            this.f1066c0 = VelocityTracker.obtain();
        }
        this.f1066c0.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.I) {
                this.I = false;
            }
            this.f1064b0 = motionEvent.getPointerId(0);
            int x10 = (int) (motionEvent.getX() + 0.5f);
            this.f1070f0 = x10;
            this.f1067d0 = x10;
            int y10 = (int) (motionEvent.getY() + 0.5f);
            this.f1071g0 = y10;
            this.f1069e0 = y10;
            if (this.f1063a0 == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                B1(1);
            }
            int[] iArr = this.D0;
            iArr[1] = 0;
            iArr[0] = 0;
            int i10 = zL;
            if (zM) {
                i10 = (zL ? 1 : 0) | 2;
            }
            z1(i10, 0);
        } else if (actionMasked == 1) {
            this.f1066c0.clear();
            B1(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f1064b0);
            if (iFindPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f1064b0 + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x11 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y11 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.f1063a0 != 1) {
                int i11 = x11 - this.f1067d0;
                int i12 = y11 - this.f1069e0;
                if (!zL || Math.abs(i11) <= this.f1072h0) {
                    z10 = false;
                } else {
                    this.f1070f0 = x11;
                    z10 = true;
                }
                if (zM && Math.abs(i12) > this.f1072h0) {
                    this.f1071g0 = y11;
                    z10 = true;
                }
                if (z10) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            u();
        } else if (actionMasked == 5) {
            this.f1064b0 = motionEvent.getPointerId(actionIndex);
            int x12 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.f1070f0 = x12;
            this.f1067d0 = x12;
            int y12 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.f1071g0 = y12;
            this.f1069e0 = y12;
        } else if (actionMasked == 6) {
            Q0(motionEvent);
        }
        return this.f1063a0 == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        v.t.a("RV OnLayout");
        F();
        v.t.b();
        this.E = true;
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        o oVar = this.f1097w;
        if (oVar == null) {
            A(i10, i11);
            return;
        }
        boolean z10 = false;
        if (oVar.t0()) {
            int mode = View.MeasureSpec.getMode(i10);
            int mode2 = View.MeasureSpec.getMode(i11);
            this.f1097w.a1(this.f1068e, this.f1088r0, i10, i11);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z10 = true;
            }
            this.H0 = z10;
            if (z10 || this.f1095v == null) {
                return;
            }
            if (this.f1088r0.f1115e == 1) {
                G();
            }
            this.f1097w.B1(i10, i11);
            this.f1088r0.f1120j = true;
            H();
            this.f1097w.E1(i10, i11);
            if (this.f1097w.H1()) {
                this.f1097w.B1(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.f1088r0.f1120j = true;
                H();
                this.f1097w.E1(i10, i11);
            }
            this.I0 = getMeasuredWidth();
            this.J0 = getMeasuredHeight();
            return;
        }
        if (this.C) {
            this.f1097w.a1(this.f1068e, this.f1088r0, i10, i11);
            return;
        }
        if (this.K) {
            y1();
            N0();
            V0();
            O0();
            a0 a0Var = this.f1088r0;
            if (a0Var.f1122l) {
                a0Var.f1118h = true;
            } else {
                this.f1079n.j();
                this.f1088r0.f1118h = false;
            }
            this.K = false;
            A1(false);
        } else if (this.f1088r0.f1122l) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        Adapter adapter = this.f1095v;
        if (adapter != null) {
            this.f1088r0.f1116f = adapter.g();
        } else {
            this.f1088r0.f1116f = 0;
        }
        y1();
        this.f1097w.a1(this.f1068e, this.f1088r0, i10, i11);
        A1(false);
        this.f1088r0.f1118h = false;
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
        this.f1077m = savedState;
        super.onRestoreInstanceState(savedState.a());
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.f1077m;
        if (savedState2 != null) {
            savedState.b(savedState2);
            return savedState;
        }
        o oVar = this.f1097w;
        if (oVar != null) {
            savedState.f1109m = oVar.e1();
            return savedState;
        }
        savedState.f1109m = null;
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

    /* JADX WARN: Code duplicated, block: B:47:0x00df A[PHI: r1
  0x00df: PHI (r1v45 int) = (r1v26 int), (r1v49 int) binds: [B:41:0x00c8, B:45:0x00db] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        if (this.H || this.I) {
            return false;
        }
        if (O(motionEvent)) {
            u();
            return true;
        }
        o oVar = this.f1097w;
        if (oVar == null) {
            return false;
        }
        boolean zL = oVar.l();
        boolean zM = this.f1097w.m();
        if (this.f1066c0 == null) {
            this.f1066c0 = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.D0;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        int[] iArr2 = this.D0;
        motionEventObtain.offsetLocation(iArr2[0], iArr2[1]);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                this.f1066c0.addMovement(motionEventObtain);
                this.f1066c0.computeCurrentVelocity(1000, this.f1075k0);
                float f10 = zL ? -this.f1066c0.getXVelocity(this.f1064b0) : 0.0f;
                float f11 = zM ? -this.f1066c0.getYVelocity(this.f1064b0) : 0.0f;
                if ((f10 == 0.0f && f11 == 0.0f) || !f0((int) f10, (int) f11)) {
                    setScrollState(0);
                }
                k1();
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f1064b0);
                if (iFindPointerIndex < 0) {
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f1064b0 + " not found. Did any MotionEvents get skipped?");
                    return false;
                }
                int x10 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
                int y10 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                int iMax = this.f1070f0 - x10;
                int iMax2 = this.f1071g0 - y10;
                if (this.f1063a0 != 1) {
                    if (zL) {
                        iMax = iMax > 0 ? Math.max(0, iMax - this.f1072h0) : Math.min(0, iMax + this.f1072h0);
                        if (iMax != 0) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                    } else {
                        z10 = false;
                    }
                    if (zM) {
                        iMax2 = iMax2 > 0 ? Math.max(0, iMax2 - this.f1072h0) : Math.min(0, iMax2 + this.f1072h0);
                        if (iMax2 != 0) {
                            z10 = true;
                        }
                    }
                    if (z10) {
                        setScrollState(1);
                    }
                }
                int i10 = iMax;
                int i11 = iMax2;
                if (this.f1063a0 == 1) {
                    int[] iArr3 = this.E0;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    if (J(zL ? i10 : 0, zM ? i11 : 0, iArr3, this.C0, 0)) {
                        int[] iArr4 = this.E0;
                        i10 -= iArr4[0];
                        i11 -= iArr4[1];
                        int[] iArr5 = this.D0;
                        int i12 = iArr5[0];
                        int[] iArr6 = this.C0;
                        iArr5[0] = i12 + iArr6[0];
                        iArr5[1] = iArr5[1] + iArr6[1];
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    int[] iArr7 = this.C0;
                    this.f1070f0 = x10 - iArr7[0];
                    this.f1071g0 = y10 - iArr7[1];
                    if (n1(zL ? i10 : 0, zM ? i11 : 0, motionEvent, 0)) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    androidx.recyclerview.widget.i iVar = this.f1084p0;
                    if (iVar != null && (i10 != 0 || i11 != 0)) {
                        iVar.f(this, i10, i11);
                    }
                }
            } else if (actionMasked == 3) {
                u();
            } else if (actionMasked == 5) {
                this.f1064b0 = motionEvent.getPointerId(actionIndex);
                int x11 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                this.f1070f0 = x11;
                this.f1067d0 = x11;
                int y11 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                this.f1071g0 = y11;
                this.f1069e0 = y11;
            } else if (actionMasked == 6) {
                Q0(motionEvent);
            }
            motionEventObtain.recycle();
            return true;
        }
        this.f1064b0 = motionEvent.getPointerId(0);
        int x12 = (int) (motionEvent.getX() + 0.5f);
        this.f1070f0 = x12;
        this.f1067d0 = x12;
        int y12 = (int) (motionEvent.getY() + 0.5f);
        this.f1071g0 = y12;
        this.f1069e0 = y12;
        int i13 = zL;
        if (zM) {
            i13 = (zL ? 1 : 0) | 2;
        }
        z1(i13, 0);
        this.f1066c0.addMovement(motionEventObtain);
        motionEventObtain.recycle();
        return true;
    }

    public void p(d0 d0Var, l.c cVar, l.c cVar2) {
        d0Var.I(false);
        if (this.W.a(d0Var, cVar, cVar2)) {
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
        if (this.H) {
            return;
        }
        C1();
        o oVar = this.f1097w;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            oVar.y1(i10);
            awakenScrollBars();
        }
    }

    public final void q(d0 d0Var, d0 d0Var2, l.c cVar, l.c cVar2, boolean z10, boolean z11) {
        d0Var.I(false);
        if (z10) {
            j(d0Var);
        }
        if (d0Var != d0Var2) {
            if (z11) {
                j(d0Var2);
            }
            d0Var.f1145h = d0Var2;
            j(d0Var);
            this.f1068e.J(d0Var);
            d0Var2.I(false);
            d0Var2.f1146i = d0Var;
        }
        if (this.W.b(d0Var, d0Var2, cVar, cVar2)) {
            T0();
        }
    }

    public Rect q0(View view) {
        p pVar = (p) view.getLayoutParams();
        if (!pVar.f1197c) {
            return pVar.f1196b;
        }
        if (this.f1088r0.e() && (pVar.b() || pVar.d())) {
            return pVar.f1196b;
        }
        Rect rect = pVar.f1196b;
        rect.set(0, 0, 0, 0);
        int size = this.f1101y.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f1089s.set(0, 0, 0, 0);
            ((n) this.f1101y.get(i10)).g(this.f1089s, view, this, this.f1088r0);
            int i11 = rect.left;
            Rect rect2 = this.f1089s;
            rect.left = i11 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        pVar.f1197c = false;
        return rect;
    }

    public final void q1(Adapter adapter, boolean z10, boolean z11) {
        Adapter adapter2 = this.f1095v;
        if (adapter2 != null) {
            adapter2.G(this.f1065c);
            this.f1095v.z(this);
        }
        if (!z10 || z11) {
            b1();
        }
        this.f1079n.y();
        Adapter adapter3 = this.f1095v;
        this.f1095v = adapter;
        if (adapter != null) {
            adapter.E(this.f1065c);
            adapter.v(this);
        }
        o oVar = this.f1097w;
        if (oVar != null) {
            oVar.F0(adapter3, this.f1095v);
        }
        this.f1068e.x(adapter3, this.f1095v, z10);
        this.f1088r0.f1117g = true;
    }

    public void r(d0 d0Var, l.c cVar, l.c cVar2) {
        j(d0Var);
        d0Var.I(false);
        if (this.W.c(d0Var, cVar, cVar2)) {
            T0();
        }
    }

    public final void r0(long j10, d0 d0Var, d0 d0Var2) {
        int iG = this.f1081o.g();
        for (int i10 = 0; i10 < iG; i10++) {
            d0 d0VarL0 = l0(this.f1081o.f(i10));
            if (d0VarL0 != d0Var && h0(d0VarL0) == j10) {
                Adapter adapter = this.f1095v;
                if (adapter == null || !adapter.k()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + d0VarL0 + " \n View Holder 2:" + d0Var + T());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + d0VarL0 + " \n View Holder 2:" + d0Var + T());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + d0Var2 + " cannot be found but it is necessary for " + d0Var + T());
    }

    public boolean r1(d0 d0Var, int i10) {
        if (!A0()) {
            y.r.c0(d0Var.f1138a, i10);
            return true;
        }
        d0Var.f1154q = i10;
        this.F0.add(d0Var);
        return false;
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z10) {
        d0 d0VarL0 = l0(view);
        if (d0VarL0 != null) {
            if (d0VarL0.z()) {
                d0VarL0.f();
            } else if (!d0VarL0.L()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + d0VarL0 + T());
            }
        }
        view.clearAnimation();
        D(view);
        super.removeDetachedView(view, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f1097w.c1(this, this.f1088r0, view, view2) && view2 != null) {
            i1(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        return this.f1097w.s1(this, view, rect, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        int size = this.f1103z.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((s) this.f1103z.get(i10)).e(z10);
        }
        super.requestDisallowInterceptTouchEvent(z10);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.F != 0 || this.H) {
            this.G = true;
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
        if (this.Q > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + T()));
        }
    }

    public boolean s0() {
        return !this.E || this.N || this.f1079n.p();
    }

    public boolean s1(AccessibilityEvent accessibilityEvent) {
        if (!A0()) {
            return false;
        }
        int iA = accessibilityEvent != null ? z.b.a(accessibilityEvent) : 0;
        this.J |= iA != 0 ? iA : 0;
        return true;
    }

    @Override // android.view.View
    public void scrollBy(int i10, int i11) {
        o oVar = this.f1097w;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.H) {
            return;
        }
        boolean zL = oVar.l();
        boolean zM = this.f1097w.m();
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
        this.f1102y0 = sVar;
        y.r.Y(this, sVar);
    }

    public void setAdapter(Adapter adapter) {
        setLayoutFrozen(false);
        q1(adapter, false, true);
        W0(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(j jVar) {
        if (jVar == this.f1104z0) {
            return;
        }
        this.f1104z0 = jVar;
        setChildrenDrawingOrderEnabled(jVar != null);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z10) {
        if (z10 != this.f1085q) {
            y0();
        }
        this.f1085q = z10;
        super.setClipToPadding(z10);
        if (this.E) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(k kVar) {
        x.g.b(kVar);
        this.R = kVar;
        y0();
    }

    public void setHasFixedSize(boolean z10) {
        this.C = z10;
    }

    public void setItemAnimator(l lVar) {
        l lVar2 = this.W;
        if (lVar2 != null) {
            lVar2.k();
            this.W.y(null);
        }
        this.W = lVar;
        if (lVar != null) {
            lVar.y(this.f1098w0);
        }
    }

    public void setItemViewCacheSize(int i10) {
        this.f1068e.G(i10);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z10) {
        suppressLayout(z10);
    }

    public void setLayoutManager(o oVar) {
        if (oVar == this.f1097w) {
            return;
        }
        C1();
        if (this.f1097w != null) {
            l lVar = this.W;
            if (lVar != null) {
                lVar.k();
            }
            this.f1097w.l1(this.f1068e);
            this.f1097w.m1(this.f1068e);
            this.f1068e.c();
            if (this.B) {
                this.f1097w.B(this, this.f1068e);
            }
            this.f1097w.F1(null);
            this.f1097w = null;
        } else {
            this.f1068e.c();
        }
        this.f1081o.o();
        this.f1097w = oVar;
        if (oVar != null) {
            if (oVar.f1172b != null) {
                throw new IllegalArgumentException("LayoutManager " + oVar + " is already attached to a RecyclerView:" + oVar.f1172b.T());
            }
            oVar.F1(this);
            if (this.B) {
                this.f1097w.A(this);
            }
        }
        this.f1068e.K();
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
        this.f1073i0 = rVar;
    }

    @Deprecated
    public void setOnScrollListener(t tVar) {
        this.f1090s0 = tVar;
    }

    public void setPreserveFocusAfterLayout(boolean z10) {
        this.f1080n0 = z10;
    }

    public void setRecycledViewPool(u uVar) {
        this.f1068e.E(uVar);
    }

    public void setScrollState(int i10) {
        if (i10 == this.f1063a0) {
            return;
        }
        this.f1063a0 = i10;
        if (i10 != 2) {
            D1();
        }
        L(i10);
    }

    public void setScrollingTouchSlop(int i10) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i10 != 0) {
            if (i10 == 1) {
                this.f1072h0 = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i10 + "; using default value");
        }
        this.f1072h0 = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(b0 b0Var) {
        this.f1068e.F(b0Var);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i10) {
        return getScrollingChildHelper().o(i10);
    }

    @Override // android.view.View, y.k
    public void stopNestedScroll() {
        getScrollingChildHelper().q();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z10) {
        if (z10 != this.H) {
            s("Do not suppressLayout in layout or scroll");
            if (z10) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
                this.H = true;
                this.I = true;
                C1();
                return;
            }
            this.H = false;
            if (this.G && this.f1097w != null && this.f1095v != null) {
                requestLayout();
            }
            this.G = false;
        }
    }

    public boolean t(d0 d0Var) {
        l lVar = this.W;
        return lVar == null || lVar.g(d0Var, d0Var.q());
    }

    public final boolean t0() {
        int iG = this.f1081o.g();
        for (int i10 = 0; i10 < iG; i10++) {
            d0 d0VarL0 = l0(this.f1081o.f(i10));
            if (d0VarL0 != null && !d0VarL0.L() && d0VarL0.A()) {
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
        this.f1079n = new androidx.recyclerview.widget.a(new f());
    }

    public void u1(int i10, int i11, Interpolator interpolator) {
        v1(i10, i11, interpolator, Integer.MIN_VALUE);
    }

    public final void v0() {
        if (y.r.u(this) == 0) {
            y.r.d0(this, 8);
        }
    }

    public void v1(int i10, int i11, Interpolator interpolator, int i12) {
        w1(i10, i11, interpolator, i12, false);
    }

    public void w() {
        int iJ = this.f1081o.j();
        for (int i10 = 0; i10 < iJ; i10++) {
            d0 d0VarL0 = l0(this.f1081o.i(i10));
            if (!d0VarL0.L()) {
                d0VarL0.c();
            }
        }
        this.f1068e.d();
    }

    public final void w0() {
        this.f1081o = new androidx.recyclerview.widget.d(new e());
    }

    public void w1(int i10, int i11, Interpolator interpolator, int i12, boolean z10) {
        o oVar = this.f1097w;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.H) {
            return;
        }
        if (!oVar.l()) {
            i10 = 0;
        }
        if (!this.f1097w.m()) {
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
        this.f1082o0.e(i10, i11, i12, interpolator);
    }

    public void x(int i10, int i11) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.S;
        if (edgeEffect == null || edgeEffect.isFinished() || i10 <= 0) {
            zIsFinished = false;
        } else {
            this.S.onRelease();
            zIsFinished = this.S.isFinished();
        }
        EdgeEffect edgeEffect2 = this.U;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i10 < 0) {
            this.U.onRelease();
            zIsFinished |= this.U.isFinished();
        }
        EdgeEffect edgeEffect3 = this.T;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i11 > 0) {
            this.T.onRelease();
            zIsFinished |= this.T.isFinished();
        }
        EdgeEffect edgeEffect4 = this.V;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i11 < 0) {
            this.V.onRelease();
            zIsFinished |= this.V.isFinished();
        }
        if (zIsFinished) {
            y.r.P(this);
        }
    }

    public void x0(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new androidx.recyclerview.widget.h(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(l0.b.f7368a), resources.getDimensionPixelSize(l0.b.f7370c), resources.getDimensionPixelOffset(l0.b.f7369b));
        } else {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + T());
        }
    }

    public void x1(int i10) {
        if (this.H) {
            return;
        }
        o oVar = this.f1097w;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            oVar.J1(this, this.f1088r0, i10);
        }
    }

    public void y() {
        if (!this.E || this.N) {
            v.t.a("RV FullInvalidate");
            F();
            v.t.b();
            return;
        }
        if (this.f1079n.p()) {
            if (!this.f1079n.o(4) || this.f1079n.o(11)) {
                if (this.f1079n.p()) {
                    v.t.a("RV FullInvalidate");
                    F();
                    v.t.b();
                    return;
                }
                return;
            }
            v.t.a("RV PartialInvalidate");
            y1();
            N0();
            this.f1079n.w();
            if (!this.G) {
                if (t0()) {
                    F();
                } else {
                    this.f1079n.i();
                }
            }
            A1(true);
            O0();
            v.t.b();
        }
    }

    public void y0() {
        this.V = null;
        this.T = null;
        this.U = null;
        this.S = null;
    }

    public void y1() {
        int i10 = this.F + 1;
        this.F = i10;
        if (i10 != 1 || this.H) {
            return;
        }
        this.G = false;
    }

    public final void z(Context context, String str, AttributeSet attributeSet, int i10, int i11) {
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
                    constructor = clsAsSubclass.getConstructor(S0);
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
        AccessibilityManager accessibilityManager = this.L;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean z1(int i10, int i11) {
        return getScrollingChildHelper().p(i10, i11);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, l0.a.f7367a);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Parcelable f1109m;

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class a implements Parcelable.ClassLoaderCreator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1109m = parcel.readParcelable(classLoader == null ? o.class.getClassLoader() : classLoader);
        }

        public void b(SavedState savedState) {
            this.f1109m = savedState.f1109m;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeParcelable(this.f1109m, 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f1065c = new x();
        this.f1068e = new v();
        this.f1083p = new androidx.recyclerview.widget.x();
        this.f1087r = new a();
        this.f1089s = new Rect();
        this.f1091t = new Rect();
        this.f1093u = new RectF();
        this.f1099x = new ArrayList();
        this.f1101y = new ArrayList();
        this.f1103z = new ArrayList();
        this.F = 0;
        this.N = false;
        this.O = false;
        this.P = 0;
        this.Q = 0;
        this.R = new k();
        this.W = new androidx.recyclerview.widget.e();
        this.f1063a0 = 0;
        this.f1064b0 = -1;
        this.f1076l0 = Float.MIN_VALUE;
        this.f1078m0 = Float.MIN_VALUE;
        boolean z10 = true;
        this.f1080n0 = true;
        this.f1082o0 = new c0();
        this.f1086q0 = P0 ? new androidx.recyclerview.widget.i.b() : null;
        this.f1088r0 = new a0();
        this.f1094u0 = false;
        this.f1096v0 = false;
        this.f1098w0 = new m();
        this.f1100x0 = false;
        this.A0 = new int[2];
        this.C0 = new int[2];
        this.D0 = new int[2];
        this.E0 = new int[2];
        this.F0 = new ArrayList();
        this.G0 = new b();
        this.I0 = 0;
        this.J0 = 0;
        this.K0 = new d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f1072h0 = viewConfiguration.getScaledTouchSlop();
        this.f1076l0 = y.t.b(viewConfiguration, context);
        this.f1078m0 = y.t.c(viewConfiguration, context);
        this.f1074j0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1075k0 = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.W.y(this.f1098w0);
        u0();
        w0();
        v0();
        if (y.r.t(this) == 0) {
            y.r.c0(this, 1);
        }
        this.L = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new androidx.recyclerview.widget.s(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l0.d.f7380f, i10, 0);
        y.r.W(this, context, l0.d.f7380f, attributeSet, typedArrayObtainStyledAttributes, i10, 0);
        String string = typedArrayObtainStyledAttributes.getString(l0.d.f7389o);
        if (typedArrayObtainStyledAttributes.getInt(l0.d.f7383i, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.f1085q = typedArrayObtainStyledAttributes.getBoolean(l0.d.f7382h, true);
        boolean z11 = typedArrayObtainStyledAttributes.getBoolean(l0.d.f7384j, false);
        this.D = z11;
        if (z11) {
            x0((StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(l0.d.f7387m), typedArrayObtainStyledAttributes.getDrawable(l0.d.f7388n), (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(l0.d.f7385k), typedArrayObtainStyledAttributes.getDrawable(l0.d.f7386l));
        }
        typedArrayObtainStyledAttributes.recycle();
        z(context, string, attributeSet, i10, 0);
        if (Build.VERSION.SDK_INT >= 21) {
            int[] iArr = L0;
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i10, 0);
            y.r.W(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes2, i10, 0);
            z10 = typedArrayObtainStyledAttributes2.getBoolean(0, true);
            typedArrayObtainStyledAttributes2.recycle();
        }
        setNestedScrollingEnabled(z10);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class p extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d0 f1195a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f1196b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f1197c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f1198d;

        public p(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1196b = new Rect();
            this.f1197c = true;
            this.f1198d = false;
        }

        public int a() {
            return this.f1195a.o();
        }

        public boolean b() {
            return this.f1195a.A();
        }

        public boolean c() {
            return this.f1195a.x();
        }

        public boolean d() {
            return this.f1195a.v();
        }

        public p(int i10, int i11) {
            super(i10, i11);
            this.f1196b = new Rect();
            this.f1197c = true;
            this.f1198d = false;
        }

        public p(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1196b = new Rect();
            this.f1197c = true;
            this.f1198d = false;
        }

        public p(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1196b = new Rect();
            this.f1197c = true;
            this.f1198d = false;
        }

        public p(p pVar) {
            super((ViewGroup.LayoutParams) pVar);
            this.f1196b = new Rect();
            this.f1197c = true;
            this.f1198d = false;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        o oVar = this.f1097w;
        if (oVar != null) {
            return oVar.G(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + T());
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class Adapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h f1105a = new h();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1106b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public StateRestorationPolicy f1107c = StateRestorationPolicy.ALLOW;

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public enum StateRestorationPolicy {
            ALLOW,
            PREVENT_WHEN_EMPTY,
            PREVENT
        }

        public boolean A(d0 d0Var) {
            return false;
        }

        public void E(i iVar) {
            this.f1105a.registerObserver(iVar);
        }

        public void F(boolean z10) {
            if (j()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.f1106b = z10;
        }

        public void G(i iVar) {
            this.f1105a.unregisterObserver(iVar);
        }

        public final void c(d0 d0Var, int i10) {
            boolean z10 = d0Var.f1156s == null;
            if (z10) {
                d0Var.f1140c = i10;
                if (k()) {
                    d0Var.f1142e = h(i10);
                }
                d0Var.H(1, 519);
                v.t.a("RV OnBindView");
            }
            d0Var.f1156s = this;
            x(d0Var, i10, d0Var.q());
            if (z10) {
                d0Var.d();
                ViewGroup.LayoutParams layoutParams = d0Var.f1138a.getLayoutParams();
                if (layoutParams instanceof p) {
                    ((p) layoutParams).f1197c = true;
                }
                v.t.b();
            }
        }

        public boolean d() {
            int i10 = g.f1159a[this.f1107c.ordinal()];
            return i10 != 1 && (i10 != 2 || g() > 0);
        }

        public final d0 e(ViewGroup viewGroup, int i10) {
            try {
                v.t.a("RV CreateView");
                d0 d0VarY = y(viewGroup, i10);
                if (d0VarY.f1138a.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                d0VarY.f1143f = i10;
                v.t.b();
                return d0VarY;
            } catch (Throwable th) {
                v.t.b();
                throw th;
            }
        }

        public int f(Adapter adapter, d0 d0Var, int i10) {
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
            return this.f1105a.a();
        }

        public final boolean k() {
            return this.f1106b;
        }

        public final void l() {
            this.f1105a.b();
        }

        public final void m(int i10) {
            this.f1105a.d(i10, 1);
        }

        public final void n(int i10, Object obj) {
            this.f1105a.e(i10, 1, obj);
        }

        public final void o(int i10) {
            this.f1105a.f(i10, 1);
        }

        public final void p(int i10, int i11) {
            this.f1105a.c(i10, i11);
        }

        public final void q(int i10, int i11) {
            this.f1105a.d(i10, i11);
        }

        public final void r(int i10, int i11, Object obj) {
            this.f1105a.e(i10, i11, obj);
        }

        public final void s(int i10, int i11) {
            this.f1105a.f(i10, i11);
        }

        public final void t(int i10, int i11) {
            this.f1105a.g(i10, i11);
        }

        public final void u(int i10) {
            this.f1105a.g(i10, 1);
        }

        public abstract void w(d0 d0Var, int i10);

        public void x(d0 d0Var, int i10, List list) {
            w(d0Var, i10);
        }

        public abstract d0 y(ViewGroup viewGroup, int i10);

        public void B(d0 d0Var) {
        }

        public void C(d0 d0Var) {
        }

        public void D(d0 d0Var) {
        }

        public void v(RecyclerView recyclerView) {
        }

        public void z(RecyclerView recyclerView) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f1160a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList f1161b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f1162c = 120;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f1163d = 120;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f1164e = 250;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f1165f = 250;

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public interface a {
            void a();
        }

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public interface b {
            void a(d0 d0Var);
        }

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public static class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f1166a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f1167b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f1168c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f1169d;

            public c a(d0 d0Var) {
                return b(d0Var, 0);
            }

            public c b(d0 d0Var, int i10) {
                View view = d0Var.f1138a;
                this.f1166a = view.getLeft();
                this.f1167b = view.getTop();
                this.f1168c = view.getRight();
                this.f1169d = view.getBottom();
                return this;
            }
        }

        public static int e(d0 d0Var) {
            int i10 = d0Var.f1147j;
            int i11 = i10 & 14;
            if (d0Var.v()) {
                return 4;
            }
            if ((i10 & 4) == 0) {
                int iP = d0Var.p();
                int iJ = d0Var.j();
                if (iP != -1 && iJ != -1 && iP != iJ) {
                    return i11 | 2048;
                }
            }
            return i11;
        }

        public abstract boolean a(d0 d0Var, c cVar, c cVar2);

        public abstract boolean b(d0 d0Var, d0 d0Var2, c cVar, c cVar2);

        public abstract boolean c(d0 d0Var, c cVar, c cVar2);

        public abstract boolean d(d0 d0Var, c cVar, c cVar2);

        public abstract boolean f(d0 d0Var);

        public boolean g(d0 d0Var, List list) {
            return f(d0Var);
        }

        public final void h(d0 d0Var) {
            s(d0Var);
            b bVar = this.f1160a;
            if (bVar != null) {
                bVar.a(d0Var);
            }
        }

        public final void i() {
            if (this.f1161b.size() <= 0) {
                this.f1161b.clear();
            } else {
                n.g.a(this.f1161b.get(0));
                throw null;
            }
        }

        public abstract void j(d0 d0Var);

        public abstract void k();

        public long l() {
            return this.f1162c;
        }

        public long m() {
            return this.f1165f;
        }

        public long n() {
            return this.f1164e;
        }

        public long o() {
            return this.f1163d;
        }

        public abstract boolean p();

        public final boolean q(a aVar) {
            boolean zP = p();
            if (aVar != null) {
                if (!zP) {
                    aVar.a();
                    return zP;
                }
                this.f1161b.add(aVar);
            }
            return zP;
        }

        public c r() {
            return new c();
        }

        public c t(a0 a0Var, d0 d0Var) {
            return r().a(d0Var);
        }

        public c u(a0 a0Var, d0 d0Var, int i10, List list) {
            return r().a(d0Var);
        }

        public abstract void v();

        public void w(long j10) {
            this.f1162c = j10;
        }

        public void x(long j10) {
            this.f1165f = j10;
        }

        public void y(b bVar) {
            this.f1160a = bVar;
        }

        public void z(long j10) {
            this.f1163d = j10;
        }

        public void s(d0 d0Var) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public androidx.recyclerview.widget.d f1171a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView f1172b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final androidx.recyclerview.widget.w.b f1173c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final androidx.recyclerview.widget.w.b f1174d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public androidx.recyclerview.widget.w f1175e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public androidx.recyclerview.widget.w f1176f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public z f1177g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f1178h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f1179i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f1180j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f1181k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f1182l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f1183m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f1184n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f1185o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f1186p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f1187q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f1188r;

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class a implements androidx.recyclerview.widget.w.b {
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

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class b implements androidx.recyclerview.widget.w.b {
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

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public interface c {
            void a(int i10, int i11);
        }

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public static class d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f1191a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f1192b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f1193c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f1194d;
        }

        public o() {
            a aVar = new a();
            this.f1173c = aVar;
            b bVar = new b();
            this.f1174d = bVar;
            this.f1175e = new androidx.recyclerview.widget.w(aVar);
            this.f1176f = new androidx.recyclerview.widget.w(bVar);
            this.f1178h = false;
            this.f1179i = false;
            this.f1180j = false;
            this.f1181k = true;
            this.f1182l = true;
        }

        /* JADX WARN: Code duplicated, block: B:10:0x001b  */
        /* JADX WARN: Code duplicated, block: B:5:0x0010  */
        public static int L(int i10, int i11, int i12, int i13, boolean z10) {
            int iMax = Math.max(0, i10 - i12);
            if (z10) {
                if (i13 >= 0) {
                    i11 = 1073741824;
                } else if (i13 != -1 || (i11 != Integer.MIN_VALUE && (i11 == 0 || i11 != 1073741824))) {
                    i11 = 0;
                    i13 = 0;
                } else {
                    i13 = iMax;
                }
            } else if (i13 >= 0) {
                i11 = 1073741824;
            } else {
                if (i13 != -1) {
                    if (i13 == -2) {
                        i11 = (i11 == Integer.MIN_VALUE || i11 == 1073741824) ? Integer.MIN_VALUE : 0;
                    } else {
                        i11 = 0;
                        i13 = 0;
                    }
                }
                i13 = iMax;
            }
            return View.MeasureSpec.makeMeasureSpec(i13, i11);
        }

        public static d j0(Context context, AttributeSet attributeSet, int i10, int i11) {
            d dVar = new d();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l0.d.f7380f, i10, i11);
            dVar.f1191a = typedArrayObtainStyledAttributes.getInt(l0.d.f7381g, 1);
            dVar.f1192b = typedArrayObtainStyledAttributes.getInt(l0.d.f7391q, 1);
            dVar.f1193c = typedArrayObtainStyledAttributes.getBoolean(l0.d.f7390p, false);
            dVar.f1194d = typedArrayObtainStyledAttributes.getBoolean(l0.d.f7392r, false);
            typedArrayObtainStyledAttributes.recycle();
            return dVar;
        }

        public static int o(int i10, int i11, int i12) {
            int mode = View.MeasureSpec.getMode(i10);
            int size = View.MeasureSpec.getSize(i10);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i11, i12) : size;
            }
            return Math.min(size, Math.max(i11, i12));
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
            this.f1179i = true;
            H0(recyclerView);
        }

        public void A0(View view, int i10, int i11, int i12, int i13) {
            p pVar = (p) view.getLayoutParams();
            Rect rect = pVar.f1196b;
            view.layout(i10 + rect.left + ((ViewGroup.MarginLayoutParams) pVar).leftMargin, i11 + rect.top + ((ViewGroup.MarginLayoutParams) pVar).topMargin, (i12 - rect.right) - ((ViewGroup.MarginLayoutParams) pVar).rightMargin, (i13 - rect.bottom) - ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
        }

        public void A1(RecyclerView recyclerView) {
            B1(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public void B(RecyclerView recyclerView, v vVar) {
            this.f1179i = false;
            J0(recyclerView, vVar);
        }

        public void B0(View view, int i10, int i11) {
            p pVar = (p) view.getLayoutParams();
            Rect rectQ0 = this.f1172b.q0(view);
            int i12 = i10 + rectQ0.left + rectQ0.right;
            int i13 = i11 + rectQ0.top + rectQ0.bottom;
            int iL = L(p0(), q0(), f0() + g0() + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin + i12, ((ViewGroup.MarginLayoutParams) pVar).width, l());
            int iL2 = L(X(), Y(), h0() + e0() + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin + i13, ((ViewGroup.MarginLayoutParams) pVar).height, m());
            if (G1(view, iL, iL2, pVar)) {
                view.measure(iL, iL2);
            }
        }

        public void B1(int i10, int i11) {
            this.f1187q = View.MeasureSpec.getSize(i10);
            int mode = View.MeasureSpec.getMode(i10);
            this.f1185o = mode;
            if (mode == 0 && !RecyclerView.N0) {
                this.f1187q = 0;
            }
            this.f1188r = View.MeasureSpec.getSize(i11);
            int mode2 = View.MeasureSpec.getMode(i11);
            this.f1186p = mode2;
            if (mode2 != 0 || RecyclerView.N0) {
                return;
            }
            this.f1188r = 0;
        }

        public View C(View view) {
            View viewW;
            RecyclerView recyclerView = this.f1172b;
            if (recyclerView == null || (viewW = recyclerView.W(view)) == null || this.f1171a.n(viewW)) {
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
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i10 + this.f1172b.toString());
            }
        }

        public void C1(int i10, int i11) {
            this.f1172b.setMeasuredDimension(i10, i11);
        }

        public View D(int i10) {
            int iK = K();
            for (int i11 = 0; i11 < iK; i11++) {
                View viewJ = J(i11);
                d0 d0VarL0 = RecyclerView.l0(viewJ);
                if (d0VarL0 != null && d0VarL0.o() == i10 && !d0VarL0.L() && (this.f1172b.f1088r0.e() || !d0VarL0.x())) {
                    return viewJ;
                }
            }
            return null;
        }

        public void D0(int i10) {
            RecyclerView recyclerView = this.f1172b;
            if (recyclerView != null) {
                recyclerView.G0(i10);
            }
        }

        public void D1(Rect rect, int i10, int i11) {
            C1(o(i10, rect.width() + f0() + g0(), d0()), o(i11, rect.height() + h0() + e0(), c0()));
        }

        public abstract p E();

        public void E0(int i10) {
            RecyclerView recyclerView = this.f1172b;
            if (recyclerView != null) {
                recyclerView.H0(i10);
            }
        }

        public void E1(int i10, int i11) {
            int iK = K();
            if (iK == 0) {
                this.f1172b.A(i10, i11);
                return;
            }
            int i12 = Integer.MIN_VALUE;
            int i13 = Integer.MIN_VALUE;
            int i14 = Integer.MAX_VALUE;
            int i15 = Integer.MAX_VALUE;
            for (int i16 = 0; i16 < iK; i16++) {
                View viewJ = J(i16);
                Rect rect = this.f1172b.f1089s;
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
            this.f1172b.f1089s.set(i14, i15, i12, i13);
            D1(this.f1172b.f1089s, i10, i11);
        }

        public p F(Context context, AttributeSet attributeSet) {
            return new p(context, attributeSet);
        }

        public void F1(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f1172b = null;
                this.f1171a = null;
                this.f1187q = 0;
                this.f1188r = 0;
            } else {
                this.f1172b = recyclerView;
                this.f1171a = recyclerView.f1081o;
                this.f1187q = recyclerView.getWidth();
                this.f1188r = recyclerView.getHeight();
            }
            this.f1185o = 1073741824;
            this.f1186p = 1073741824;
        }

        public p G(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof p) {
                return new p((p) layoutParams);
            }
            return layoutParams instanceof ViewGroup.MarginLayoutParams ? new p((ViewGroup.MarginLayoutParams) layoutParams) : new p(layoutParams);
        }

        public boolean G0(RecyclerView recyclerView, ArrayList arrayList, int i10, int i11) {
            return false;
        }

        public boolean G1(View view, int i10, int i11, p pVar) {
            return (!view.isLayoutRequested() && this.f1181k && x0(view.getWidth(), i10, ((ViewGroup.MarginLayoutParams) pVar).width) && x0(view.getHeight(), i11, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public int H() {
            return -1;
        }

        public boolean H1() {
            return false;
        }

        public int I(View view) {
            return ((p) view.getLayoutParams()).f1196b.bottom;
        }

        public boolean I1(View view, int i10, int i11, p pVar) {
            return (this.f1181k && x0(view.getMeasuredWidth(), i10, ((ViewGroup.MarginLayoutParams) pVar).width) && x0(view.getMeasuredHeight(), i11, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public View J(int i10) {
            androidx.recyclerview.widget.d dVar = this.f1171a;
            if (dVar != null) {
                return dVar.f(i10);
            }
            return null;
        }

        public void J0(RecyclerView recyclerView, v vVar) {
            I0(recyclerView);
        }

        public abstract void J1(RecyclerView recyclerView, a0 a0Var, int i10);

        public int K() {
            androidx.recyclerview.widget.d dVar = this.f1171a;
            if (dVar != null) {
                return dVar.g();
            }
            return 0;
        }

        public abstract View K0(View view, int i10, v vVar, a0 a0Var);

        public void K1(z zVar) {
            z zVar2 = this.f1177g;
            if (zVar2 != null && zVar != zVar2 && zVar2.h()) {
                this.f1177g.r();
            }
            this.f1177g = zVar;
            zVar.q(this.f1172b, this);
        }

        public void L0(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f1172b;
            M0(recyclerView.f1068e, recyclerView.f1088r0, accessibilityEvent);
        }

        public void L1() {
            z zVar = this.f1177g;
            if (zVar != null) {
                zVar.r();
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

        public void M0(v vVar, a0 a0Var, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f1172b;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z10 = true;
            if (!recyclerView.canScrollVertically(1) && !this.f1172b.canScrollVertically(-1) && !this.f1172b.canScrollHorizontally(-1) && !this.f1172b.canScrollHorizontally(1)) {
                z10 = false;
            }
            accessibilityEvent.setScrollable(z10);
            Adapter adapter = this.f1172b.f1095v;
            if (adapter != null) {
                accessibilityEvent.setItemCount(adapter.g());
            }
        }

        public abstract boolean M1();

        public boolean N() {
            RecyclerView recyclerView = this.f1172b;
            return recyclerView != null && recyclerView.f1085q;
        }

        public void N0(v vVar, a0 a0Var, z.d0 d0Var) {
            if (this.f1172b.canScrollVertically(-1) || this.f1172b.canScrollHorizontally(-1)) {
                d0Var.a(8192);
                d0Var.h0(true);
            }
            if (this.f1172b.canScrollVertically(1) || this.f1172b.canScrollHorizontally(1)) {
                d0Var.a(4096);
                d0Var.h0(true);
            }
            d0Var.V(z.d0.b.a(l0(vVar, a0Var), O(vVar, a0Var), w0(vVar, a0Var), m0(vVar, a0Var)));
        }

        public int O(v vVar, a0 a0Var) {
            return -1;
        }

        public void O0(z.d0 d0Var) {
            RecyclerView recyclerView = this.f1172b;
            N0(recyclerView.f1068e, recyclerView.f1088r0, d0Var);
        }

        public int P(View view) {
            return view.getBottom() + I(view);
        }

        public void P0(View view, z.d0 d0Var) {
            d0 d0VarL0 = RecyclerView.l0(view);
            if (d0VarL0 == null || d0VarL0.x() || this.f1171a.n(d0VarL0.f1138a)) {
                return;
            }
            RecyclerView recyclerView = this.f1172b;
            Q0(recyclerView.f1068e, recyclerView.f1088r0, view, d0Var);
        }

        public void Q(View view, Rect rect) {
            RecyclerView.n0(view, rect);
        }

        public int R(View view) {
            return view.getLeft() - b0(view);
        }

        public View R0(View view, int i10) {
            return null;
        }

        public int S(View view) {
            Rect rect = ((p) view.getLayoutParams()).f1196b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int T(View view) {
            Rect rect = ((p) view.getLayoutParams()).f1196b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int U(View view) {
            return view.getRight() + k0(view);
        }

        public int V(View view) {
            return view.getTop() - n0(view);
        }

        public View W() {
            View focusedChild;
            RecyclerView recyclerView = this.f1172b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f1171a.n(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int X() {
            return this.f1188r;
        }

        public void X0(RecyclerView recyclerView, int i10, int i11, Object obj) {
            W0(recyclerView, i10, i11);
        }

        public int Y() {
            return this.f1186p;
        }

        public abstract void Y0(v vVar, a0 a0Var);

        public int Z() {
            RecyclerView recyclerView = this.f1172b;
            Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.g();
            }
            return 0;
        }

        public int a0() {
            return y.r.v(this.f1172b);
        }

        public void a1(v vVar, a0 a0Var, int i10, int i11) {
            this.f1172b.A(i10, i11);
        }

        public int b0(View view) {
            return ((p) view.getLayoutParams()).f1196b.left;
        }

        public boolean b1(RecyclerView recyclerView, View view, View view2) {
            return y0() || recyclerView.A0();
        }

        public void c(View view) {
            d(view, -1);
        }

        public int c0() {
            return y.r.w(this.f1172b);
        }

        public boolean c1(RecyclerView recyclerView, a0 a0Var, View view, View view2) {
            return b1(recyclerView, view, view2);
        }

        public void d(View view, int i10) {
            g(view, i10, true);
        }

        public int d0() {
            return y.r.x(this.f1172b);
        }

        public abstract void d1(Parcelable parcelable);

        public void e(View view) {
            f(view, -1);
        }

        public int e0() {
            RecyclerView recyclerView = this.f1172b;
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
            RecyclerView recyclerView = this.f1172b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public final void g(View view, int i10, boolean z10) {
            d0 d0VarL0 = RecyclerView.l0(view);
            if (z10 || d0VarL0.x()) {
                this.f1172b.f1083p.b(d0VarL0);
            } else {
                this.f1172b.f1083p.p(d0VarL0);
            }
            p pVar = (p) view.getLayoutParams();
            if (d0VarL0.N() || d0VarL0.y()) {
                if (d0VarL0.y()) {
                    d0VarL0.M();
                } else {
                    d0VarL0.e();
                }
                this.f1171a.c(view, i10, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f1172b) {
                int iM = this.f1171a.m(view);
                if (i10 == -1) {
                    i10 = this.f1171a.g();
                }
                if (iM == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f1172b.indexOfChild(view) + this.f1172b.T());
                }
                if (iM != i10) {
                    this.f1172b.f1097w.C0(iM, i10);
                }
            } else {
                this.f1171a.a(view, i10, false);
                pVar.f1197c = true;
                z zVar = this.f1177g;
                if (zVar != null && zVar.h()) {
                    this.f1177g.k(view);
                }
            }
            if (pVar.f1198d) {
                d0VarL0.f1138a.invalidate();
                pVar.f1198d = false;
            }
        }

        public int g0() {
            RecyclerView recyclerView = this.f1172b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public void g1(z zVar) {
            if (this.f1177g == zVar) {
                this.f1177g = null;
            }
        }

        public void h(String str) {
            RecyclerView recyclerView = this.f1172b;
            if (recyclerView != null) {
                recyclerView.s(str);
            }
        }

        public int h0() {
            RecyclerView recyclerView = this.f1172b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public boolean h1(int i10, Bundle bundle) {
            RecyclerView recyclerView = this.f1172b;
            return i1(recyclerView.f1068e, recyclerView.f1088r0, i10, bundle);
        }

        public void i(View view, int i10) {
            j(view, i10, (p) view.getLayoutParams());
        }

        public int i0(View view) {
            return ((p) view.getLayoutParams()).a();
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0044 A[PHI: r8
  0x0044: PHI (r8v8 int) = (r8v4 int), (r8v12 int) binds: [B:24:0x0063, B:15:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
        public boolean i1(v vVar, a0 a0Var, int i10, Bundle bundle) {
            int iX;
            int iP0;
            int i11;
            int i12;
            RecyclerView recyclerView = this.f1172b;
            if (recyclerView == null) {
                return false;
            }
            if (i10 == 4096) {
                iX = recyclerView.canScrollVertically(1) ? (X() - h0()) - e0() : 0;
                if (this.f1172b.canScrollHorizontally(1)) {
                    iP0 = (p0() - f0()) - g0();
                    i11 = iX;
                    i12 = iP0;
                } else {
                    i11 = iX;
                    i12 = 0;
                }
            } else if (i10 != 8192) {
                i12 = 0;
                i11 = 0;
            } else {
                iX = recyclerView.canScrollVertically(-1) ? -((X() - h0()) - e0()) : 0;
                if (this.f1172b.canScrollHorizontally(-1)) {
                    iP0 = -((p0() - f0()) - g0());
                    i11 = iX;
                    i12 = iP0;
                } else {
                    i11 = iX;
                    i12 = 0;
                }
            }
            if (i11 == 0 && i12 == 0) {
                return false;
            }
            this.f1172b.w1(i12, i11, null, Integer.MIN_VALUE, true);
            return true;
        }

        public void j(View view, int i10, p pVar) {
            d0 d0VarL0 = RecyclerView.l0(view);
            if (d0VarL0.x()) {
                this.f1172b.f1083p.b(d0VarL0);
            } else {
                this.f1172b.f1083p.p(d0VarL0);
            }
            this.f1171a.c(view, i10, pVar, d0VarL0.x());
        }

        public boolean j1(View view, int i10, Bundle bundle) {
            RecyclerView recyclerView = this.f1172b;
            return k1(recyclerView.f1068e, recyclerView.f1088r0, view, i10, bundle);
        }

        public void k(View view, Rect rect) {
            RecyclerView recyclerView = this.f1172b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.q0(view));
            }
        }

        public int k0(View view) {
            return ((p) view.getLayoutParams()).f1196b.right;
        }

        public boolean k1(v vVar, a0 a0Var, View view, int i10, Bundle bundle) {
            return false;
        }

        public abstract boolean l();

        public int l0(v vVar, a0 a0Var) {
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

        public int m0(v vVar, a0 a0Var) {
            return 0;
        }

        public void m1(v vVar) {
            int iJ = vVar.j();
            for (int i10 = iJ - 1; i10 >= 0; i10--) {
                View viewN = vVar.n(i10);
                d0 d0VarL0 = RecyclerView.l0(viewN);
                if (!d0VarL0.L()) {
                    d0VarL0.I(false);
                    if (d0VarL0.z()) {
                        this.f1172b.removeDetachedView(viewN, false);
                    }
                    l lVar = this.f1172b.W;
                    if (lVar != null) {
                        lVar.j(d0VarL0);
                    }
                    d0VarL0.I(true);
                    vVar.y(viewN);
                }
            }
            vVar.e();
            if (iJ > 0) {
                this.f1172b.invalidate();
            }
        }

        public boolean n(p pVar) {
            return pVar != null;
        }

        public int n0(View view) {
            return ((p) view.getLayoutParams()).f1196b.top;
        }

        public void n1(View view, v vVar) {
            q1(view);
            vVar.B(view);
        }

        public void o0(View view, boolean z10, Rect rect) {
            Matrix matrix;
            if (z10) {
                Rect rect2 = ((p) view.getLayoutParams()).f1196b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.f1172b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.f1172b.f1093u;
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

        public abstract void p(int i10, int i11, a0 a0Var, c cVar);

        public int p0() {
            return this.f1187q;
        }

        public boolean p1(Runnable runnable) {
            RecyclerView recyclerView = this.f1172b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public int q0() {
            return this.f1185o;
        }

        public void q1(View view) {
            this.f1171a.p(view);
        }

        public abstract int r(a0 a0Var);

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
                this.f1171a.q(i10);
            }
        }

        public abstract int s(a0 a0Var);

        public boolean s0() {
            return this.f1179i;
        }

        public boolean s1(RecyclerView recyclerView, View view, Rect rect, boolean z10) {
            return t1(recyclerView, view, rect, z10, false);
        }

        public abstract int t(a0 a0Var);

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

        public abstract int u(a0 a0Var);

        public final boolean u0(RecyclerView recyclerView, int i10, int i11) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int iF0 = f0();
            int iH0 = h0();
            int iP0 = p0() - g0();
            int iX = X() - e0();
            Rect rect = this.f1172b.f1089s;
            Q(focusedChild, rect);
            return rect.left - i10 < iP0 && rect.right - i10 > iF0 && rect.top - i11 < iX && rect.bottom - i11 > iH0;
        }

        public void u1() {
            RecyclerView recyclerView = this.f1172b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public abstract int v(a0 a0Var);

        public final boolean v0() {
            return this.f1182l;
        }

        public void v1() {
            this.f1178h = true;
        }

        public abstract int w(a0 a0Var);

        public boolean w0(v vVar, a0 a0Var) {
            return false;
        }

        public final void w1(v vVar, int i10, View view) {
            d0 d0VarL0 = RecyclerView.l0(view);
            if (d0VarL0.L()) {
                return;
            }
            if (d0VarL0.v() && !d0VarL0.x() && !this.f1172b.f1095v.k()) {
                r1(i10);
                vVar.C(d0VarL0);
            } else {
                y(i10);
                vVar.D(view);
                this.f1172b.f1083p.k(d0VarL0);
            }
        }

        public void x(v vVar) {
            for (int iK = K() - 1; iK >= 0; iK--) {
                w1(vVar, iK, J(iK));
            }
        }

        public abstract int x1(int i10, v vVar, a0 a0Var);

        public void y(int i10) {
            z(i10, J(i10));
        }

        public boolean y0() {
            z zVar = this.f1177g;
            return zVar != null && zVar.h();
        }

        public abstract void y1(int i10);

        public final void z(int i10, View view) {
            this.f1171a.d(i10);
        }

        public boolean z0(View view, boolean z10, boolean z11) {
            boolean z12 = this.f1175e.b(view, 24579) && this.f1176f.b(view, 24579);
            return z10 ? z12 : !z12;
        }

        public abstract int z1(int i10, v vVar, a0 a0Var);

        public void H0(RecyclerView recyclerView) {
        }

        public void I0(RecyclerView recyclerView) {
        }

        public void T0(RecyclerView recyclerView) {
        }

        public void Z0(a0 a0Var) {
        }

        public void f1(int i10) {
        }

        public void F0(Adapter adapter, Adapter adapter2) {
        }

        public void q(int i10, c cVar) {
        }

        public void S0(RecyclerView recyclerView, int i10, int i11) {
        }

        public void V0(RecyclerView recyclerView, int i10, int i11) {
        }

        public void W0(RecyclerView recyclerView, int i10, int i11) {
        }

        public void Q0(v vVar, a0 a0Var, View view, z.d0 d0Var) {
        }

        public void U0(RecyclerView recyclerView, int i10, int i11, int i12) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public final class v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList f1205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList f1206b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList f1207c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f1208d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1209e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f1210f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public u f1211g;

        public v() {
            ArrayList arrayList = new ArrayList();
            this.f1205a = arrayList;
            this.f1206b = null;
            this.f1207c = new ArrayList();
            this.f1208d = Collections.unmodifiableList(arrayList);
            this.f1209e = 2;
            this.f1210f = 2;
        }

        public void A(int i10) {
            a((d0) this.f1207c.get(i10), true);
            this.f1207c.remove(i10);
        }

        public void B(View view) {
            d0 d0VarL0 = RecyclerView.l0(view);
            if (d0VarL0.z()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (d0VarL0.y()) {
                d0VarL0.M();
            } else if (d0VarL0.N()) {
                d0VarL0.e();
            }
            C(d0VarL0);
            if (RecyclerView.this.W == null || d0VarL0.w()) {
                return;
            }
            RecyclerView.this.W.j(d0VarL0);
        }

        public void C(d0 d0Var) {
            boolean z10;
            boolean z11 = false;
            boolean z12 = true;
            if (d0Var.y() || d0Var.f1138a.getParent() != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Scrapped or attached views may not be recycled. isScrap:");
                sb2.append(d0Var.y());
                sb2.append(" isAttached:");
                sb2.append(d0Var.f1138a.getParent() != null);
                sb2.append(RecyclerView.this.T());
                throw new IllegalArgumentException(sb2.toString());
            }
            if (d0Var.z()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + d0Var + RecyclerView.this.T());
            }
            if (d0Var.L()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.T());
            }
            boolean zH = d0Var.h();
            Adapter adapter = RecyclerView.this.f1095v;
            if ((adapter != null && zH && adapter.A(d0Var)) || d0Var.w()) {
                if (this.f1210f <= 0 || d0Var.r(526)) {
                    z10 = false;
                } else {
                    int size = this.f1207c.size();
                    if (size >= this.f1210f && size > 0) {
                        A(0);
                        size--;
                    }
                    if (RecyclerView.P0 && size > 0 && !RecyclerView.this.f1086q0.d(d0Var.f1140c)) {
                        int i10 = size - 1;
                        while (i10 >= 0) {
                            if (!RecyclerView.this.f1086q0.d(((d0) this.f1207c.get(i10)).f1140c)) {
                                break;
                            } else {
                                i10--;
                            }
                        }
                        size = i10 + 1;
                    }
                    this.f1207c.add(size, d0Var);
                    z10 = true;
                }
                if (z10) {
                    z11 = z10;
                    z12 = false;
                } else {
                    a(d0Var, true);
                    z11 = z10;
                }
            } else {
                z12 = false;
            }
            RecyclerView.this.f1083p.q(d0Var);
            if (z11 || z12 || !zH) {
                return;
            }
            d0Var.f1156s = null;
            d0Var.f1155r = null;
        }

        public void D(View view) {
            d0 d0VarL0 = RecyclerView.l0(view);
            if (!d0VarL0.r(12) && d0VarL0.A() && !RecyclerView.this.t(d0VarL0)) {
                if (this.f1206b == null) {
                    this.f1206b = new ArrayList();
                }
                d0VarL0.J(this, true);
                this.f1206b.add(d0VarL0);
                return;
            }
            if (!d0VarL0.v() || d0VarL0.x() || RecyclerView.this.f1095v.k()) {
                d0VarL0.J(this, false);
                this.f1205a.add(d0VarL0);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.T());
            }
        }

        public void E(u uVar) {
            u uVar2 = this.f1211g;
            if (uVar2 != null) {
                uVar2.c();
            }
            this.f1211g = uVar;
            if (uVar == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.f1211g.a();
        }

        public void G(int i10) {
            this.f1209e = i10;
            K();
        }

        public final boolean H(d0 d0Var, int i10, int i11, long j10) {
            d0Var.f1156s = null;
            d0Var.f1155r = RecyclerView.this;
            int iN = d0Var.n();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j10 != Long.MAX_VALUE && !this.f1211g.k(iN, nanoTime, j10)) {
                return false;
            }
            RecyclerView.this.f1095v.c(d0Var, i10);
            this.f1211g.d(d0Var.n(), RecyclerView.this.getNanoTime() - nanoTime);
            b(d0Var);
            if (!RecyclerView.this.f1088r0.e()) {
                return true;
            }
            d0Var.f1144g = i11;
            return true;
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0037 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:19:0x0039  */
        /* JADX WARN: Code duplicated, block: B:21:0x0043  */
        /* JADX WARN: Code duplicated, block: B:22:0x004e  */
        /* JADX WARN: Code duplicated, block: B:24:0x0054  */
        /* JADX WARN: Code duplicated, block: B:27:0x005c  */
        /* JADX WARN: Code duplicated, block: B:29:0x005f  */
        /* JADX WARN: Code duplicated, block: B:67:0x014a  */
        /* JADX WARN: Code duplicated, block: B:73:0x0176  */
        /* JADX WARN: Code duplicated, block: B:75:0x017c  */
        /* JADX WARN: Code duplicated, block: B:84:0x01a1  */
        /* JADX WARN: Code duplicated, block: B:85:0x01af  */
        /* JADX WARN: Code duplicated, block: B:87:0x01b7  */
        /* JADX WARN: Code duplicated, block: B:88:0x01c5  */
        /* JADX WARN: Code duplicated, block: B:91:0x01cb A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:93:0x01ce  */
        public d0 I(int i10, boolean z10, long j10) {
            d0 d0VarE;
            boolean z11;
            d0 d0Var;
            boolean z12;
            ViewGroup.LayoutParams layoutParams;
            p pVar;
            int iM;
            RecyclerView recyclerViewA0;
            if (i10 < 0 || i10 >= RecyclerView.this.f1088r0.b()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i10 + "(" + i10 + "). Item count:" + RecyclerView.this.f1088r0.b() + RecyclerView.this.T());
            }
            if (RecyclerView.this.f1088r0.e()) {
                d0VarE = h(i10);
                z11 = d0VarE != null;
                if (d0VarE == null && (d0VarE = m(i10, z10)) != null) {
                    if (L(d0VarE)) {
                        z11 = true;
                    } else {
                        if (!z10) {
                            d0VarE.b(4);
                            if (d0VarE.y()) {
                                RecyclerView.this.removeDetachedView(d0VarE.f1138a, false);
                                d0VarE.M();
                            } else if (d0VarE.N()) {
                                d0VarE.e();
                            }
                            C(d0VarE);
                        }
                        d0VarE = null;
                    }
                }
                if (d0VarE == null) {
                    iM = RecyclerView.this.f1079n.m(i10);
                    if (iM >= 0 || iM >= RecyclerView.this.f1095v.g()) {
                        throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i10 + "(offset:" + iM + ").state:" + RecyclerView.this.f1088r0.b() + RecyclerView.this.T());
                    }
                    int i11 = RecyclerView.this.f1095v.i(iM);
                    if (RecyclerView.this.f1095v.k() && (d0VarE = l(RecyclerView.this.f1095v.h(iM), i11, z10)) != null) {
                        d0VarE.f1140c = iM;
                        z11 = true;
                    }
                    if (d0VarE == null) {
                        d0 d0VarF = i().f(i11);
                        if (d0VarF != null) {
                            d0VarF.F();
                            if (RecyclerView.M0) {
                                r(d0VarF);
                            }
                        }
                        d0VarE = d0VarF;
                    }
                    if (d0VarE == null) {
                        long nanoTime = RecyclerView.this.getNanoTime();
                        if (j10 != Long.MAX_VALUE && !this.f1211g.l(i11, nanoTime, j10)) {
                            return null;
                        }
                        RecyclerView recyclerView = RecyclerView.this;
                        d0VarE = recyclerView.f1095v.e(recyclerView, i11);
                        if (RecyclerView.P0 && (recyclerViewA0 = RecyclerView.a0(d0VarE.f1138a)) != null) {
                            d0VarE.f1139b = new WeakReference(recyclerViewA0);
                        }
                        this.f1211g.e(i11, RecyclerView.this.getNanoTime() - nanoTime);
                    }
                }
                d0Var = d0VarE;
                z12 = z11;
                if (z12 && !RecyclerView.this.f1088r0.e() && d0Var.r(8192)) {
                    d0Var.H(0, 8192);
                    if (RecyclerView.this.f1088r0.f1121k) {
                        int iE = l.e(d0Var) | 4096;
                        RecyclerView recyclerView2 = RecyclerView.this;
                        RecyclerView.this.Y0(d0Var, recyclerView2.W.u(recyclerView2.f1088r0, d0Var, iE, d0Var.q()));
                    }
                }
                if (RecyclerView.this.f1088r0.e() || !d0Var.u()) {
                    boolean zH = (d0Var.u() || d0Var.B() || d0Var.v()) ? H(d0Var, RecyclerView.this.f1079n.m(i10), i10, j10) : false;
                    layoutParams = d0Var.f1138a.getLayoutParams();
                    if (layoutParams == null) {
                        pVar = (p) RecyclerView.this.generateDefaultLayoutParams();
                        d0Var.f1138a.setLayoutParams(pVar);
                    } else if (RecyclerView.this.checkLayoutParams(layoutParams)) {
                        pVar = (p) layoutParams;
                    } else {
                        pVar = (p) RecyclerView.this.generateLayoutParams(layoutParams);
                        d0Var.f1138a.setLayoutParams(pVar);
                    }
                    pVar.f1195a = d0Var;
                    pVar.f1198d = !z12 && zH;
                    return d0Var;
                }
                d0Var.f1144g = i10;
                layoutParams = d0Var.f1138a.getLayoutParams();
                if (layoutParams == null) {
                    pVar = (p) RecyclerView.this.generateDefaultLayoutParams();
                    d0Var.f1138a.setLayoutParams(pVar);
                } else if (RecyclerView.this.checkLayoutParams(layoutParams)) {
                    pVar = (p) RecyclerView.this.generateLayoutParams(layoutParams);
                    d0Var.f1138a.setLayoutParams(pVar);
                } else {
                    pVar = (p) layoutParams;
                }
                pVar.f1195a = d0Var;
                pVar.f1198d = !z12 && zH;
                return d0Var;
            }
            d0VarE = null;
            if (d0VarE == null) {
                if (L(d0VarE)) {
                    if (!z10) {
                        d0VarE.b(4);
                        if (d0VarE.y()) {
                            RecyclerView.this.removeDetachedView(d0VarE.f1138a, false);
                            d0VarE.M();
                        } else if (d0VarE.N()) {
                            d0VarE.e();
                        }
                        C(d0VarE);
                    }
                    d0VarE = null;
                } else {
                    z11 = true;
                }
            }
            if (d0VarE == null) {
                iM = RecyclerView.this.f1079n.m(i10);
                if (iM >= 0) {
                }
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i10 + "(offset:" + iM + ").state:" + RecyclerView.this.f1088r0.b() + RecyclerView.this.T());
            }
            d0Var = d0VarE;
            z12 = z11;
            if (z12) {
                d0Var.H(0, 8192);
                if (RecyclerView.this.f1088r0.f1121k) {
                    int iE2 = l.e(d0Var) | 4096;
                    RecyclerView recyclerView3 = RecyclerView.this;
                    RecyclerView.this.Y0(d0Var, recyclerView3.W.u(recyclerView3.f1088r0, d0Var, iE2, d0Var.q()));
                }
            }
            if (RecyclerView.this.f1088r0.e()) {
                if (d0Var.u()) {
                }
            } else {
                if (d0Var.u()) {
                }
            }
            layoutParams = d0Var.f1138a.getLayoutParams();
            if (layoutParams == null) {
                pVar = (p) RecyclerView.this.generateDefaultLayoutParams();
                d0Var.f1138a.setLayoutParams(pVar);
            } else if (RecyclerView.this.checkLayoutParams(layoutParams)) {
                pVar = (p) RecyclerView.this.generateLayoutParams(layoutParams);
                d0Var.f1138a.setLayoutParams(pVar);
            } else {
                pVar = (p) layoutParams;
            }
            pVar.f1195a = d0Var;
            pVar.f1198d = !z12 && zH;
            return d0Var;
        }

        public void J(d0 d0Var) {
            if (d0Var.f1152o) {
                this.f1206b.remove(d0Var);
            } else {
                this.f1205a.remove(d0Var);
            }
            d0Var.f1151n = null;
            d0Var.f1152o = false;
            d0Var.e();
        }

        public void K() {
            o oVar = RecyclerView.this.f1097w;
            this.f1210f = this.f1209e + (oVar != null ? oVar.f1183m : 0);
            for (int size = this.f1207c.size() - 1; size >= 0 && this.f1207c.size() > this.f1210f; size--) {
                A(size);
            }
        }

        public boolean L(d0 d0Var) {
            if (d0Var.x()) {
                return RecyclerView.this.f1088r0.e();
            }
            int i10 = d0Var.f1140c;
            if (i10 >= 0 && i10 < RecyclerView.this.f1095v.g()) {
                if (RecyclerView.this.f1088r0.e() || RecyclerView.this.f1095v.i(d0Var.f1140c) == d0Var.n()) {
                    return !RecyclerView.this.f1095v.k() || d0Var.m() == RecyclerView.this.f1095v.h(d0Var.f1140c);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + d0Var + RecyclerView.this.T());
        }

        public void M(int i10, int i11) {
            int i12;
            int i13 = i11 + i10;
            for (int size = this.f1207c.size() - 1; size >= 0; size--) {
                d0 d0Var = (d0) this.f1207c.get(size);
                if (d0Var != null && (i12 = d0Var.f1140c) >= i10 && i12 < i13) {
                    d0Var.b(2);
                    A(size);
                }
            }
        }

        public void a(d0 d0Var, boolean z10) {
            RecyclerView.v(d0Var);
            View view = d0Var.f1138a;
            androidx.recyclerview.widget.s sVar = RecyclerView.this.f1102y0;
            if (sVar != null) {
                y.a aVarN = sVar.n();
                y.r.Y(view, aVarN instanceof androidx.recyclerview.widget.s.a ? ((androidx.recyclerview.widget.s.a) aVarN).n(view) : null);
            }
            if (z10) {
                g(d0Var);
            }
            d0Var.f1156s = null;
            d0Var.f1155r = null;
            i().i(d0Var);
        }

        public final void b(d0 d0Var) {
            if (RecyclerView.this.z0()) {
                View view = d0Var.f1138a;
                if (y.r.t(view) == 0) {
                    y.r.c0(view, 1);
                }
                androidx.recyclerview.widget.s sVar = RecyclerView.this.f1102y0;
                if (sVar == null) {
                    return;
                }
                y.a aVarN = sVar.n();
                if (aVarN instanceof androidx.recyclerview.widget.s.a) {
                    ((androidx.recyclerview.widget.s.a) aVarN).o(view);
                }
                y.r.Y(view, aVarN);
            }
        }

        public void c() {
            this.f1205a.clear();
            z();
        }

        public void d() {
            int size = this.f1207c.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((d0) this.f1207c.get(i10)).c();
            }
            int size2 = this.f1205a.size();
            for (int i11 = 0; i11 < size2; i11++) {
                ((d0) this.f1205a.get(i11)).c();
            }
            ArrayList arrayList = this.f1206b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i12 = 0; i12 < size3; i12++) {
                    ((d0) this.f1206b.get(i12)).c();
                }
            }
        }

        public void e() {
            this.f1205a.clear();
            ArrayList arrayList = this.f1206b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int f(int i10) {
            if (i10 >= 0 && i10 < RecyclerView.this.f1088r0.b()) {
                return !RecyclerView.this.f1088r0.e() ? i10 : RecyclerView.this.f1079n.m(i10);
            }
            throw new IndexOutOfBoundsException("invalid position " + i10 + ". State item count is " + RecyclerView.this.f1088r0.b() + RecyclerView.this.T());
        }

        public void g(d0 d0Var) {
            RecyclerView.this.getClass();
            if (RecyclerView.this.f1099x.size() > 0) {
                n.g.a(RecyclerView.this.f1099x.get(0));
                throw null;
            }
            Adapter adapter = RecyclerView.this.f1095v;
            if (adapter != null) {
                adapter.D(d0Var);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f1088r0 != null) {
                recyclerView.f1083p.q(d0Var);
            }
        }

        public d0 h(int i10) {
            int size;
            int iM;
            ArrayList arrayList = this.f1206b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i11 = 0; i11 < size; i11++) {
                    d0 d0Var = (d0) this.f1206b.get(i11);
                    if (!d0Var.N() && d0Var.o() == i10) {
                        d0Var.b(32);
                        return d0Var;
                    }
                }
                if (RecyclerView.this.f1095v.k() && (iM = RecyclerView.this.f1079n.m(i10)) > 0 && iM < RecyclerView.this.f1095v.g()) {
                    long jH = RecyclerView.this.f1095v.h(iM);
                    for (int i12 = 0; i12 < size; i12++) {
                        d0 d0Var2 = (d0) this.f1206b.get(i12);
                        if (!d0Var2.N() && d0Var2.m() == jH) {
                            d0Var2.b(32);
                            return d0Var2;
                        }
                    }
                }
            }
            return null;
        }

        public u i() {
            if (this.f1211g == null) {
                this.f1211g = new u();
            }
            return this.f1211g;
        }

        public int j() {
            return this.f1205a.size();
        }

        public List k() {
            return this.f1208d;
        }

        public d0 l(long j10, int i10, boolean z10) {
            for (int size = this.f1205a.size() - 1; size >= 0; size--) {
                d0 d0Var = (d0) this.f1205a.get(size);
                if (d0Var.m() == j10 && !d0Var.N()) {
                    if (i10 == d0Var.n()) {
                        d0Var.b(32);
                        if (d0Var.x() && !RecyclerView.this.f1088r0.e()) {
                            d0Var.H(2, 14);
                        }
                        return d0Var;
                    }
                    if (!z10) {
                        this.f1205a.remove(size);
                        RecyclerView.this.removeDetachedView(d0Var.f1138a, false);
                        y(d0Var.f1138a);
                    }
                }
            }
            int size2 = this.f1207c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                d0 d0Var2 = (d0) this.f1207c.get(size2);
                if (d0Var2.m() == j10 && !d0Var2.t()) {
                    if (i10 == d0Var2.n()) {
                        if (!z10) {
                            this.f1207c.remove(size2);
                        }
                        return d0Var2;
                    }
                    if (!z10) {
                        A(size2);
                        return null;
                    }
                }
            }
        }

        public d0 m(int i10, boolean z10) {
            View viewE;
            int size = this.f1205a.size();
            for (int i11 = 0; i11 < size; i11++) {
                d0 d0Var = (d0) this.f1205a.get(i11);
                if (!d0Var.N() && d0Var.o() == i10 && !d0Var.v() && (RecyclerView.this.f1088r0.f1118h || !d0Var.x())) {
                    d0Var.b(32);
                    return d0Var;
                }
            }
            if (z10 || (viewE = RecyclerView.this.f1081o.e(i10)) == null) {
                int size2 = this.f1207c.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    d0 d0Var2 = (d0) this.f1207c.get(i12);
                    if (!d0Var2.v() && d0Var2.o() == i10 && !d0Var2.t()) {
                        if (!z10) {
                            this.f1207c.remove(i12);
                        }
                        return d0Var2;
                    }
                }
                return null;
            }
            d0 d0VarL0 = RecyclerView.l0(viewE);
            RecyclerView.this.f1081o.s(viewE);
            int iM = RecyclerView.this.f1081o.m(viewE);
            if (iM != -1) {
                RecyclerView.this.f1081o.d(iM);
                D(viewE);
                d0VarL0.b(8224);
                return d0VarL0;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + d0VarL0 + RecyclerView.this.T());
        }

        public View n(int i10) {
            return ((d0) this.f1205a.get(i10)).f1138a;
        }

        public View o(int i10) {
            return p(i10, false);
        }

        public View p(int i10, boolean z10) {
            return I(i10, z10, Long.MAX_VALUE).f1138a;
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

        public final void r(d0 d0Var) {
            View view = d0Var.f1138a;
            if (view instanceof ViewGroup) {
                q((ViewGroup) view, false);
            }
        }

        public void s() {
            int size = this.f1207c.size();
            for (int i10 = 0; i10 < size; i10++) {
                p pVar = (p) ((d0) this.f1207c.get(i10)).f1138a.getLayoutParams();
                if (pVar != null) {
                    pVar.f1197c = true;
                }
            }
        }

        public void t() {
            int size = this.f1207c.size();
            for (int i10 = 0; i10 < size; i10++) {
                d0 d0Var = (d0) this.f1207c.get(i10);
                if (d0Var != null) {
                    d0Var.b(6);
                    d0Var.a(null);
                }
            }
            Adapter adapter = RecyclerView.this.f1095v;
            if (adapter == null || !adapter.k()) {
                z();
            }
        }

        public void u(int i10, int i11) {
            int size = this.f1207c.size();
            for (int i12 = 0; i12 < size; i12++) {
                d0 d0Var = (d0) this.f1207c.get(i12);
                if (d0Var != null && d0Var.f1140c >= i10) {
                    d0Var.C(i11, false);
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
            int size = this.f1207c.size();
            for (int i16 = 0; i16 < size; i16++) {
                d0 d0Var = (d0) this.f1207c.get(i16);
                if (d0Var != null && (i15 = d0Var.f1140c) >= i14 && i15 <= i13) {
                    if (i15 == i10) {
                        d0Var.C(i11 - i10, false);
                    } else {
                        d0Var.C(i12, false);
                    }
                }
            }
        }

        public void w(int i10, int i11, boolean z10) {
            int i12 = i10 + i11;
            for (int size = this.f1207c.size() - 1; size >= 0; size--) {
                d0 d0Var = (d0) this.f1207c.get(size);
                if (d0Var != null) {
                    int i13 = d0Var.f1140c;
                    if (i13 >= i12) {
                        d0Var.C(-i11, z10);
                    } else if (i13 >= i10) {
                        d0Var.b(8);
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
            d0 d0VarL0 = RecyclerView.l0(view);
            d0VarL0.f1151n = null;
            d0VarL0.f1152o = false;
            d0VarL0.e();
            C(d0VarL0);
        }

        public void z() {
            for (int size = this.f1207c.size() - 1; size >= 0; size--) {
                A(size);
            }
            this.f1207c.clear();
            if (RecyclerView.P0) {
                RecyclerView.this.f1086q0.b();
            }
        }

        public void F(b0 b0Var) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class y implements s {
        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void e(boolean z10) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
        }
    }

    public void L0(View view) {
    }

    public void M0(View view) {
    }

    public void R0(int i10) {
    }

    @Deprecated
    public void setRecyclerListener(w wVar) {
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class i {
        public abstract void a();

        public void h(int i10, int i11, Object obj) {
            d(i10, i11);
        }

        public abstract void k(int i10, int i11);

        public abstract void l(int i10, int i11, int i12);

        public abstract void m(int i10, int i11);

        public void d(int i10, int i11) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class n {
        public void f(Rect rect, int i10, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void g(Rect rect, View view, RecyclerView recyclerView, a0 a0Var) {
            f(rect, ((p) view.getLayoutParams()).a(), recyclerView);
        }

        public void i(Canvas canvas, RecyclerView recyclerView, a0 a0Var) {
            h(canvas, recyclerView);
        }

        public void k(Canvas canvas, RecyclerView recyclerView, a0 a0Var) {
            j(canvas, recyclerView);
        }

        public void h(Canvas canvas, RecyclerView recyclerView) {
        }

        public void j(Canvas canvas, RecyclerView recyclerView) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class t {
        public void a(RecyclerView recyclerView, int i10) {
        }

        public void b(RecyclerView recyclerView, int i10, int i11) {
        }
    }

    public void S0(int i10, int i11) {
    }
}
