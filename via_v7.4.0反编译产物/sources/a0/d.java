package a0;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;
import x.r;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d {

    /* renamed from: x, reason: collision with root package name */
    public static final Interpolator f20x = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f21a;

    /* renamed from: b, reason: collision with root package name */
    public int f22b;

    /* renamed from: d, reason: collision with root package name */
    public float[] f24d;

    /* renamed from: e, reason: collision with root package name */
    public float[] f25e;

    /* renamed from: f, reason: collision with root package name */
    public float[] f26f;

    /* renamed from: g, reason: collision with root package name */
    public float[] f27g;

    /* renamed from: h, reason: collision with root package name */
    public int[] f28h;

    /* renamed from: i, reason: collision with root package name */
    public int[] f29i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f30j;

    /* renamed from: k, reason: collision with root package name */
    public int f31k;

    /* renamed from: l, reason: collision with root package name */
    public VelocityTracker f32l;

    /* renamed from: m, reason: collision with root package name */
    public float f33m;

    /* renamed from: n, reason: collision with root package name */
    public float f34n;

    /* renamed from: o, reason: collision with root package name */
    public int f35o;

    /* renamed from: p, reason: collision with root package name */
    public final int f36p;

    /* renamed from: q, reason: collision with root package name */
    public int f37q;

    /* renamed from: r, reason: collision with root package name */
    public OverScroller f38r;

    /* renamed from: s, reason: collision with root package name */
    public final c f39s;

    /* renamed from: t, reason: collision with root package name */
    public View f40t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f41u;

    /* renamed from: v, reason: collision with root package name */
    public final ViewGroup f42v;

    /* renamed from: c, reason: collision with root package name */
    public int f23c = -1;

    /* renamed from: w, reason: collision with root package name */
    public final Runnable f43w = new b();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.F(0);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class c {
        public abstract int a(View view, int i10, int i11);

        public int b(View view, int i10, int i11) {
            return 0;
        }

        public int c(int i10) {
            return i10;
        }

        public abstract int d(View view);

        public int e(View view) {
            return 0;
        }

        public void f(int i10, int i11) {
        }

        public boolean g(int i10) {
            return false;
        }

        public void h(int i10, int i11) {
        }

        public void i(View view, int i10) {
        }

        public void j(int i10) {
        }

        public void k(View view, int i10, int i11, int i12, int i13) {
        }

        public abstract void l(View view, float f10, float f11);

        public abstract boolean m(View view, int i10);
    }

    public d(Context context, ViewGroup viewGroup, c cVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (cVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f42v = viewGroup;
        this.f39s = cVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int i10 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f36p = i10;
        this.f35o = i10;
        this.f22b = viewConfiguration.getScaledTouchSlop();
        this.f33m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f34n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f38r = new OverScroller(context, f20x);
    }

    public static d l(ViewGroup viewGroup, float f10, c cVar) {
        d dVarM = m(viewGroup, cVar);
        dVarM.f22b = (int) (dVarM.f22b * (1.0f / f10));
        return dVarM;
    }

    public static d m(ViewGroup viewGroup, c cVar) {
        return new d(viewGroup.getContext(), viewGroup, cVar);
    }

    public void A(MotionEvent motionEvent) {
        int i10;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f32l == null) {
            this.f32l = VelocityTracker.obtain();
        }
        this.f32l.addMovement(motionEvent);
        int i11 = 0;
        if (actionMasked == 0) {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewR = r((int) x10, (int) y10);
            D(x10, y10, pointerId);
            L(viewR, pointerId);
            int i12 = this.f28h[pointerId];
            int i13 = this.f37q;
            if ((i12 & i13) != 0) {
                this.f39s.h(i12 & i13, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f21a == 1) {
                B();
            }
            a();
            return;
        }
        if (actionMasked == 2) {
            if (this.f21a == 1) {
                if (y(this.f23c)) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.f23c);
                    float x11 = motionEvent.getX(iFindPointerIndex);
                    float y11 = motionEvent.getY(iFindPointerIndex);
                    float[] fArr = this.f26f;
                    int i14 = this.f23c;
                    int i15 = (int) (x11 - fArr[i14]);
                    int i16 = (int) (y11 - this.f27g[i14]);
                    p(this.f40t.getLeft() + i15, this.f40t.getTop() + i16, i15, i16);
                    E(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i11 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i11);
                if (y(pointerId2)) {
                    float x12 = motionEvent.getX(i11);
                    float y12 = motionEvent.getY(i11);
                    float f10 = x12 - this.f24d[pointerId2];
                    float f11 = y12 - this.f25e[pointerId2];
                    C(f10, f11, pointerId2);
                    if (this.f21a != 1) {
                        View viewR2 = r((int) x12, (int) y12);
                        if (d(viewR2, f10, f11) && L(viewR2, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i11++;
            }
            E(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.f21a == 1) {
                n(0.0f, 0.0f);
            }
            a();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x13 = motionEvent.getX(actionIndex);
            float y13 = motionEvent.getY(actionIndex);
            D(x13, y13, pointerId3);
            if (this.f21a != 0) {
                if (v((int) x13, (int) y13)) {
                    L(this.f40t, pointerId3);
                    return;
                }
                return;
            } else {
                L(r((int) x13, (int) y13), pointerId3);
                int i17 = this.f28h[pointerId3];
                int i18 = this.f37q;
                if ((i17 & i18) != 0) {
                    this.f39s.h(i17 & i18, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.f21a == 1 && pointerId4 == this.f23c) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i11 >= pointerCount2) {
                    i10 = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i11);
                if (pointerId5 != this.f23c) {
                    View viewR3 = r((int) motionEvent.getX(i11), (int) motionEvent.getY(i11));
                    View view = this.f40t;
                    if (viewR3 == view && L(view, pointerId5)) {
                        i10 = this.f23c;
                        break;
                    }
                }
                i11++;
            }
            if (i10 == -1) {
                B();
            }
        }
        h(pointerId4);
    }

    public final void B() {
        this.f32l.computeCurrentVelocity(1000, this.f33m);
        n(e(this.f32l.getXVelocity(this.f23c), this.f34n, this.f33m), e(this.f32l.getYVelocity(this.f23c), this.f34n, this.f33m));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r3v3, types: [a0.d$c] */
    public final void C(float f10, float f11, int i10) {
        boolean zC = c(f10, f11, i10, 1);
        boolean z10 = zC;
        if (c(f11, f10, i10, 4)) {
            z10 = (zC ? 1 : 0) | 4;
        }
        boolean z11 = z10;
        if (c(f10, f11, i10, 2)) {
            z11 = (z10 ? 1 : 0) | 2;
        }
        ?? r02 = z11;
        if (c(f11, f10, i10, 8)) {
            r02 = (z11 ? 1 : 0) | 8;
        }
        if (r02 != 0) {
            int[] iArr = this.f29i;
            iArr[i10] = iArr[i10] | r02;
            this.f39s.f(r02, i10);
        }
    }

    public final void D(float f10, float f11, int i10) {
        q(i10);
        float[] fArr = this.f24d;
        this.f26f[i10] = f10;
        fArr[i10] = f10;
        float[] fArr2 = this.f25e;
        this.f27g[i10] = f11;
        fArr2[i10] = f11;
        this.f28h[i10] = t((int) f10, (int) f11);
        this.f31k |= 1 << i10;
    }

    public final void E(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i10 = 0; i10 < pointerCount; i10++) {
            int pointerId = motionEvent.getPointerId(i10);
            if (y(pointerId)) {
                float x10 = motionEvent.getX(i10);
                float y10 = motionEvent.getY(i10);
                this.f26f[pointerId] = x10;
                this.f27g[pointerId] = y10;
            }
        }
    }

    public void F(int i10) {
        this.f42v.removeCallbacks(this.f43w);
        if (this.f21a != i10) {
            this.f21a = i10;
            this.f39s.j(i10);
            if (this.f21a == 0) {
                this.f40t = null;
            }
        }
    }

    public void G(int i10) {
        this.f35o = i10;
    }

    public void H(int i10) {
        this.f37q = i10;
    }

    public boolean I(int i10, int i11) {
        if (this.f41u) {
            return s(i10, i11, (int) this.f32l.getXVelocity(this.f23c), (int) this.f32l.getYVelocity(this.f23c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean J(MotionEvent motionEvent) {
        View viewR;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f32l == null) {
            this.f32l = VelocityTracker.obtain();
        }
        this.f32l.addMovement(motionEvent);
        if (actionMasked == 0) {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            D(x10, y10, pointerId);
            View viewR2 = r((int) x10, (int) y10);
            if (viewR2 == this.f40t && this.f21a == 2) {
                L(viewR2, pointerId);
            }
            int i10 = this.f28h[pointerId];
            int i11 = this.f37q;
            if ((i10 & i11) != 0) {
                this.f39s.h(i10 & i11, pointerId);
            }
        } else if (actionMasked == 1) {
            a();
        } else if (actionMasked != 2) {
            if (actionMasked != 3) {
                if (actionMasked == 5) {
                    int pointerId2 = motionEvent.getPointerId(actionIndex);
                    float x11 = motionEvent.getX(actionIndex);
                    float y11 = motionEvent.getY(actionIndex);
                    D(x11, y11, pointerId2);
                    int i12 = this.f21a;
                    if (i12 == 0) {
                        int i13 = this.f28h[pointerId2];
                        int i14 = this.f37q;
                        if ((i13 & i14) != 0) {
                            this.f39s.h(i13 & i14, pointerId2);
                        }
                    } else if (i12 == 2 && (viewR = r((int) x11, (int) y11)) == this.f40t) {
                        L(viewR, pointerId2);
                    }
                } else if (actionMasked == 6) {
                    h(motionEvent.getPointerId(actionIndex));
                }
            }
        } else if (this.f24d != null && this.f25e != null) {
            int pointerCount = motionEvent.getPointerCount();
            for (int i15 = 0; i15 < pointerCount; i15++) {
                int pointerId3 = motionEvent.getPointerId(i15);
                if (y(pointerId3)) {
                    float x12 = motionEvent.getX(i15);
                    float y12 = motionEvent.getY(i15);
                    float f10 = x12 - this.f24d[pointerId3];
                    float f11 = y12 - this.f25e[pointerId3];
                    View viewR3 = r((int) x12, (int) y12);
                    boolean z10 = viewR3 != null && d(viewR3, f10, f11);
                    if (z10) {
                        int left = viewR3.getLeft();
                        int i16 = (int) f10;
                        int iA = this.f39s.a(viewR3, left + i16, i16);
                        int top = viewR3.getTop();
                        int i17 = (int) f11;
                        int iB = this.f39s.b(viewR3, top + i17, i17);
                        int iD = this.f39s.d(viewR3);
                        int iE = this.f39s.e(viewR3);
                        if ((iD == 0 || (iD > 0 && iA == left)) && (iE == 0 || (iE > 0 && iB == top))) {
                            break;
                        }
                        C(f10, f11, pointerId3);
                        if (this.f21a == 1 || (z10 && L(viewR3, pointerId3))) {
                            break;
                        }
                    }
                }
            }
            E(motionEvent);
        }
        return this.f21a == 1;
    }

    public boolean K(View view, int i10, int i11) {
        this.f40t = view;
        this.f23c = -1;
        boolean zS = s(i10, i11, 0, 0);
        if (!zS && this.f21a == 0 && this.f40t != null) {
            this.f40t = null;
        }
        return zS;
    }

    public boolean L(View view, int i10) {
        if (view == this.f40t && this.f23c == i10) {
            return true;
        }
        if (view == null || !this.f39s.m(view, i10)) {
            return false;
        }
        this.f23c = i10;
        b(view, i10);
        return true;
    }

    public void a() {
        this.f23c = -1;
        g();
        VelocityTracker velocityTracker = this.f32l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f32l = null;
        }
    }

    public void b(View view, int i10) {
        if (view.getParent() == this.f42v) {
            this.f40t = view;
            this.f23c = i10;
            this.f39s.i(view, i10);
            F(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f42v + ")");
    }

    public final boolean c(float f10, float f11, int i10, int i11) {
        float fAbs = Math.abs(f10);
        float fAbs2 = Math.abs(f11);
        if ((this.f28h[i10] & i11) == i11 && (this.f37q & i11) != 0 && (this.f30j[i10] & i11) != i11 && (this.f29i[i10] & i11) != i11) {
            int i12 = this.f22b;
            if (fAbs > i12 || fAbs2 > i12) {
                if (fAbs < fAbs2 * 0.5f && this.f39s.g(i11)) {
                    int[] iArr = this.f30j;
                    iArr[i10] = iArr[i10] | i11;
                    return false;
                }
                if ((this.f29i[i10] & i11) == 0 && fAbs > this.f22b) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean d(View view, float f10, float f11) {
        if (view == null) {
            return false;
        }
        boolean z10 = this.f39s.d(view) > 0;
        boolean z11 = this.f39s.e(view) > 0;
        if (!z10 || !z11) {
            return z10 ? Math.abs(f10) > ((float) this.f22b) : z11 && Math.abs(f11) > ((float) this.f22b);
        }
        float f12 = (f10 * f10) + (f11 * f11);
        int i10 = this.f22b;
        return f12 > ((float) (i10 * i10));
    }

    public final float e(float f10, float f11, float f12) {
        float fAbs = Math.abs(f10);
        if (fAbs < f11) {
            return 0.0f;
        }
        return fAbs > f12 ? f10 > 0.0f ? f12 : -f12 : f10;
    }

    public final int f(int i10, int i11, int i12) {
        int iAbs = Math.abs(i10);
        if (iAbs < i11) {
            return 0;
        }
        return iAbs > i12 ? i10 > 0 ? i12 : -i12 : i10;
    }

    public final void g() {
        float[] fArr = this.f24d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f25e, 0.0f);
        Arrays.fill(this.f26f, 0.0f);
        Arrays.fill(this.f27g, 0.0f);
        Arrays.fill(this.f28h, 0);
        Arrays.fill(this.f29i, 0);
        Arrays.fill(this.f30j, 0);
        this.f31k = 0;
    }

    public final void h(int i10) {
        if (this.f24d == null || !x(i10)) {
            return;
        }
        this.f24d[i10] = 0.0f;
        this.f25e[i10] = 0.0f;
        this.f26f[i10] = 0.0f;
        this.f27g[i10] = 0.0f;
        this.f28h[i10] = 0;
        this.f29i[i10] = 0;
        this.f30j[i10] = 0;
        this.f31k = ((1 << i10) ^ (-1)) & this.f31k;
    }

    public final int i(int i10, int i11, int i12) {
        if (i10 == 0) {
            return 0;
        }
        int width = this.f42v.getWidth();
        float f10 = width / 2;
        float fO = f10 + (o(Math.min(1.0f, Math.abs(i10) / width)) * f10);
        int iAbs = Math.abs(i11);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fO / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i10) / i12) + 1.0f) * 256.0f), 600);
    }

    public final int j(View view, int i10, int i11, int i12, int i13) {
        float f10;
        float f11;
        float f12;
        float f13;
        int iF = f(i12, (int) this.f34n, (int) this.f33m);
        int iF2 = f(i13, (int) this.f34n, (int) this.f33m);
        int iAbs = Math.abs(i10);
        int iAbs2 = Math.abs(i11);
        int iAbs3 = Math.abs(iF);
        int iAbs4 = Math.abs(iF2);
        int i14 = iAbs3 + iAbs4;
        int i15 = iAbs + iAbs2;
        if (iF != 0) {
            f10 = iAbs3;
            f11 = i14;
        } else {
            f10 = iAbs;
            f11 = i15;
        }
        float f14 = f10 / f11;
        if (iF2 != 0) {
            f12 = iAbs4;
            f13 = i14;
        } else {
            f12 = iAbs2;
            f13 = i15;
        }
        return (int) ((i(i10, iF, this.f39s.d(view)) * f14) + (i(i11, iF2, this.f39s.e(view)) * (f12 / f13)));
    }

    public boolean k(boolean z10) {
        if (this.f21a == 2) {
            boolean zComputeScrollOffset = this.f38r.computeScrollOffset();
            int currX = this.f38r.getCurrX();
            int currY = this.f38r.getCurrY();
            int left = currX - this.f40t.getLeft();
            int top = currY - this.f40t.getTop();
            if (left != 0) {
                r.I(this.f40t, left);
            }
            if (top != 0) {
                r.J(this.f40t, top);
            }
            if (left != 0 || top != 0) {
                this.f39s.k(this.f40t, currX, currY, left, top);
            }
            if (zComputeScrollOffset && currX == this.f38r.getFinalX() && currY == this.f38r.getFinalY()) {
                this.f38r.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                if (z10) {
                    this.f42v.post(this.f43w);
                } else {
                    F(0);
                }
            }
        }
        return this.f21a == 2;
    }

    public final void n(float f10, float f11) {
        this.f41u = true;
        this.f39s.l(this.f40t, f10, f11);
        this.f41u = false;
        if (this.f21a == 1) {
            F(0);
        }
    }

    public final float o(float f10) {
        return (float) Math.sin((f10 - 0.5f) * 0.47123894f);
    }

    public final void p(int i10, int i11, int i12, int i13) {
        int left = this.f40t.getLeft();
        int top = this.f40t.getTop();
        if (i12 != 0) {
            i10 = this.f39s.a(this.f40t, i10, i12);
            r.I(this.f40t, i10 - left);
        }
        int i14 = i10;
        if (i13 != 0) {
            i11 = this.f39s.b(this.f40t, i11, i13);
            r.J(this.f40t, i11 - top);
        }
        int i15 = i11;
        if (i12 == 0 && i13 == 0) {
            return;
        }
        this.f39s.k(this.f40t, i14, i15, i14 - left, i15 - top);
    }

    public final void q(int i10) {
        float[] fArr = this.f24d;
        if (fArr == null || fArr.length <= i10) {
            int i11 = i10 + 1;
            float[] fArr2 = new float[i11];
            float[] fArr3 = new float[i11];
            float[] fArr4 = new float[i11];
            float[] fArr5 = new float[i11];
            int[] iArr = new int[i11];
            int[] iArr2 = new int[i11];
            int[] iArr3 = new int[i11];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f25e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f26f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f27g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f28h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f29i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f30j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f24d = fArr2;
            this.f25e = fArr3;
            this.f26f = fArr4;
            this.f27g = fArr5;
            this.f28h = iArr;
            this.f29i = iArr2;
            this.f30j = iArr3;
        }
    }

    public View r(int i10, int i11) {
        for (int childCount = this.f42v.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f42v.getChildAt(this.f39s.c(childCount));
            if (i10 >= childAt.getLeft() && i10 < childAt.getRight() && i11 >= childAt.getTop() && i11 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean s(int i10, int i11, int i12, int i13) {
        int left = this.f40t.getLeft();
        int top = this.f40t.getTop();
        int i14 = i10 - left;
        int i15 = i11 - top;
        if (i14 == 0 && i15 == 0) {
            this.f38r.abortAnimation();
            F(0);
            return false;
        }
        this.f38r.startScroll(left, top, i14, i15, j(this.f40t, i14, i15, i12, i13));
        F(2);
        return true;
    }

    public final int t(int i10, int i11) {
        int i12 = i10 < this.f42v.getLeft() + this.f35o ? 1 : 0;
        if (i11 < this.f42v.getTop() + this.f35o) {
            i12 |= 4;
        }
        if (i10 > this.f42v.getRight() - this.f35o) {
            i12 |= 2;
        }
        return i11 > this.f42v.getBottom() - this.f35o ? i12 | 8 : i12;
    }

    public int u() {
        return this.f21a;
    }

    public boolean v(int i10, int i11) {
        return z(this.f40t, i10, i11);
    }

    public boolean w(int i10, int i11) {
        return x(i11) && (i10 & this.f28h[i11]) != 0;
    }

    public boolean x(int i10) {
        return ((1 << i10) & this.f31k) != 0;
    }

    public final boolean y(int i10) {
        if (x(i10)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i10 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public boolean z(View view, int i10, int i11) {
        return view != null && i10 >= view.getLeft() && i10 < view.getRight() && i11 >= view.getTop() && i11 < view.getBottom();
    }
}
