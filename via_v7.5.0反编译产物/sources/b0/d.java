package b0;

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
import y.r;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Interpolator f1687x = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1689b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float[] f1691d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float[] f1692e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float[] f1693f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float[] f1694g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f1695h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f1696i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f1697j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1698k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public VelocityTracker f1699l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f1700m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f1701n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f1702o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f1703p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f1704q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public OverScroller f1705r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final c f1706s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f1707t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f1708u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ViewGroup f1709v;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1690c = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Runnable f1710w = new b();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.F(0);
        }
    }

    public d(Context context, ViewGroup viewGroup, c cVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (cVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f1709v = viewGroup;
        this.f1706s = cVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int i10 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f1703p = i10;
        this.f1702o = i10;
        this.f1689b = viewConfiguration.getScaledTouchSlop();
        this.f1700m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f1701n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1705r = new OverScroller(context, f1687x);
    }

    public static d l(ViewGroup viewGroup, float f10, c cVar) {
        d dVarM = m(viewGroup, cVar);
        dVarM.f1689b = (int) (dVarM.f1689b * (1.0f / f10));
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
        if (this.f1699l == null) {
            this.f1699l = VelocityTracker.obtain();
        }
        this.f1699l.addMovement(motionEvent);
        int i11 = 0;
        if (actionMasked == 0) {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewR = r((int) x10, (int) y10);
            D(x10, y10, pointerId);
            L(viewR, pointerId);
            int i12 = this.f1695h[pointerId];
            int i13 = this.f1704q;
            if ((i12 & i13) != 0) {
                this.f1706s.h(i12 & i13, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f1688a == 1) {
                B();
            }
            a();
            return;
        }
        if (actionMasked == 2) {
            if (this.f1688a == 1) {
                if (y(this.f1690c)) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.f1690c);
                    float x11 = motionEvent.getX(iFindPointerIndex);
                    float y11 = motionEvent.getY(iFindPointerIndex);
                    float[] fArr = this.f1693f;
                    int i14 = this.f1690c;
                    int i15 = (int) (x11 - fArr[i14]);
                    int i16 = (int) (y11 - this.f1694g[i14]);
                    p(this.f1707t.getLeft() + i15, this.f1707t.getTop() + i16, i15, i16);
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
                    float f10 = x12 - this.f1691d[pointerId2];
                    float f11 = y12 - this.f1692e[pointerId2];
                    C(f10, f11, pointerId2);
                    if (this.f1688a != 1) {
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
            if (this.f1688a == 1) {
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
            if (this.f1688a != 0) {
                if (v((int) x13, (int) y13)) {
                    L(this.f1707t, pointerId3);
                    return;
                }
                return;
            } else {
                L(r((int) x13, (int) y13), pointerId3);
                int i17 = this.f1695h[pointerId3];
                int i18 = this.f1704q;
                if ((i17 & i18) != 0) {
                    this.f1706s.h(i17 & i18, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.f1688a == 1 && pointerId4 == this.f1690c) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i11 >= pointerCount2) {
                    i10 = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i11);
                if (pointerId5 != this.f1690c) {
                    View viewR3 = r((int) motionEvent.getX(i11), (int) motionEvent.getY(i11));
                    View view = this.f1707t;
                    if (viewR3 == view && L(view, pointerId5)) {
                        i10 = this.f1690c;
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
        this.f1699l.computeCurrentVelocity(1000, this.f1700m);
        n(e(this.f1699l.getXVelocity(this.f1690c), this.f1701n, this.f1700m), e(this.f1699l.getYVelocity(this.f1690c), this.f1701n, this.f1700m));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3, types: [b0.d$c] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void C(float f10, float f11, int i10) {
        boolean zC = c(f10, f11, i10, 1);
        ?? r10 = zC;
        if (c(f11, f10, i10, 4)) {
            r10 = (zC ? 1 : 0) | 4;
        }
        ?? r11 = r10;
        if (c(f10, f11, i10, 2)) {
            r11 = (r10 == true ? 1 : 0) | 2;
        }
        ?? r12 = r11;
        if (c(f11, f10, i10, 8)) {
            r12 = (r11 == true ? 1 : 0) | 8;
        }
        if (r12 != 0) {
            int[] iArr = this.f1696i;
            iArr[i10] = (iArr[i10] | r12) == true ? 1 : 0;
            this.f1706s.f(r12, i10);
        }
    }

    public final void D(float f10, float f11, int i10) {
        q(i10);
        float[] fArr = this.f1691d;
        this.f1693f[i10] = f10;
        fArr[i10] = f10;
        float[] fArr2 = this.f1692e;
        this.f1694g[i10] = f11;
        fArr2[i10] = f11;
        this.f1695h[i10] = t((int) f10, (int) f11);
        this.f1698k |= 1 << i10;
    }

    public final void E(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i10 = 0; i10 < pointerCount; i10++) {
            int pointerId = motionEvent.getPointerId(i10);
            if (y(pointerId)) {
                float x10 = motionEvent.getX(i10);
                float y10 = motionEvent.getY(i10);
                this.f1693f[pointerId] = x10;
                this.f1694g[pointerId] = y10;
            }
        }
    }

    public void F(int i10) {
        this.f1709v.removeCallbacks(this.f1710w);
        if (this.f1688a != i10) {
            this.f1688a = i10;
            this.f1706s.j(i10);
            if (this.f1688a == 0) {
                this.f1707t = null;
            }
        }
    }

    public void G(int i10) {
        this.f1702o = i10;
    }

    public void H(int i10) {
        this.f1704q = i10;
    }

    public boolean I(int i10, int i11) {
        if (this.f1708u) {
            return s(i10, i11, (int) this.f1699l.getXVelocity(this.f1690c), (int) this.f1699l.getYVelocity(this.f1690c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:63:0x0101  */
    public boolean J(MotionEvent motionEvent) {
        View viewR;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f1699l == null) {
            this.f1699l = VelocityTracker.obtain();
        }
        this.f1699l.addMovement(motionEvent);
        if (actionMasked == 0) {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            D(x10, y10, pointerId);
            View viewR2 = r((int) x10, (int) y10);
            if (viewR2 == this.f1707t && this.f1688a == 2) {
                L(viewR2, pointerId);
            }
            int i10 = this.f1695h[pointerId];
            int i11 = this.f1704q;
            if ((i10 & i11) != 0) {
                this.f1706s.h(i10 & i11, pointerId);
            }
        } else if (actionMasked == 1) {
            a();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                a();
            } else if (actionMasked == 5) {
                int pointerId2 = motionEvent.getPointerId(actionIndex);
                float x11 = motionEvent.getX(actionIndex);
                float y11 = motionEvent.getY(actionIndex);
                D(x11, y11, pointerId2);
                int i12 = this.f1688a;
                if (i12 == 0) {
                    int i13 = this.f1695h[pointerId2];
                    int i14 = this.f1704q;
                    if ((i13 & i14) != 0) {
                        this.f1706s.h(i13 & i14, pointerId2);
                    }
                } else if (i12 == 2 && (viewR = r((int) x11, (int) y11)) == this.f1707t) {
                    L(viewR, pointerId2);
                }
            } else if (actionMasked == 6) {
                h(motionEvent.getPointerId(actionIndex));
            }
        } else if (this.f1691d != null && this.f1692e != null) {
            int pointerCount = motionEvent.getPointerCount();
            for (int i15 = 0; i15 < pointerCount; i15++) {
                int pointerId3 = motionEvent.getPointerId(i15);
                if (y(pointerId3)) {
                    float x12 = motionEvent.getX(i15);
                    float y12 = motionEvent.getY(i15);
                    float f10 = x12 - this.f1691d[pointerId3];
                    float f11 = y12 - this.f1692e[pointerId3];
                    View viewR3 = r((int) x12, (int) y12);
                    boolean z10 = viewR3 != null && d(viewR3, f10, f11);
                    if (!z10) {
                        C(f10, f11, pointerId3);
                        if (this.f1688a != 1) {
                            break;
                        }
                    } else {
                        int left = viewR3.getLeft();
                        int i16 = (int) f10;
                        int iA = this.f1706s.a(viewR3, left + i16, i16);
                        int top = viewR3.getTop();
                        int i17 = (int) f11;
                        int iB = this.f1706s.b(viewR3, top + i17, i17);
                        int iD = this.f1706s.d(viewR3);
                        int iE = this.f1706s.e(viewR3);
                        if ((iD == 0 || (iD > 0 && iA == left)) && (iE == 0 || (iE > 0 && iB == top))) {
                            break;
                        }
                        C(f10, f11, pointerId3);
                        if (this.f1688a != 1 || (z10 && L(viewR3, pointerId3))) {
                            break;
                        }
                    }
                }
            }
            E(motionEvent);
        }
        return this.f1688a == 1;
    }

    public boolean K(View view, int i10, int i11) {
        this.f1707t = view;
        this.f1690c = -1;
        boolean zS = s(i10, i11, 0, 0);
        if (!zS && this.f1688a == 0 && this.f1707t != null) {
            this.f1707t = null;
        }
        return zS;
    }

    public boolean L(View view, int i10) {
        if (view == this.f1707t && this.f1690c == i10) {
            return true;
        }
        if (view == null || !this.f1706s.m(view, i10)) {
            return false;
        }
        this.f1690c = i10;
        b(view, i10);
        return true;
    }

    public void a() {
        this.f1690c = -1;
        g();
        VelocityTracker velocityTracker = this.f1699l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f1699l = null;
        }
    }

    public void b(View view, int i10) {
        if (view.getParent() == this.f1709v) {
            this.f1707t = view;
            this.f1690c = i10;
            this.f1706s.i(view, i10);
            F(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f1709v + ")");
    }

    public final boolean c(float f10, float f11, int i10, int i11) {
        float fAbs = Math.abs(f10);
        float fAbs2 = Math.abs(f11);
        if ((this.f1695h[i10] & i11) == i11 && (this.f1704q & i11) != 0 && (this.f1697j[i10] & i11) != i11 && (this.f1696i[i10] & i11) != i11) {
            int i12 = this.f1689b;
            if (fAbs > i12 || fAbs2 > i12) {
                if (fAbs < fAbs2 * 0.5f && this.f1706s.g(i11)) {
                    int[] iArr = this.f1697j;
                    iArr[i10] = iArr[i10] | i11;
                    return false;
                }
                if ((this.f1696i[i10] & i11) == 0 && fAbs > this.f1689b) {
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
        boolean z10 = this.f1706s.d(view) > 0;
        boolean z11 = this.f1706s.e(view) > 0;
        if (z10 && z11) {
            float f12 = (f10 * f10) + (f11 * f11);
            int i10 = this.f1689b;
            return f12 > ((float) (i10 * i10));
        }
        if (z10) {
            return Math.abs(f10) > ((float) this.f1689b);
        }
        return z11 && Math.abs(f11) > ((float) this.f1689b);
    }

    public final float e(float f10, float f11, float f12) {
        float fAbs = Math.abs(f10);
        if (fAbs < f11) {
            return 0.0f;
        }
        if (fAbs > f12) {
            return f10 > 0.0f ? f12 : -f12;
        }
        return f10;
    }

    public final int f(int i10, int i11, int i12) {
        int iAbs = Math.abs(i10);
        if (iAbs < i11) {
            return 0;
        }
        if (iAbs > i12) {
            return i10 > 0 ? i12 : -i12;
        }
        return i10;
    }

    public final void g() {
        float[] fArr = this.f1691d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f1692e, 0.0f);
        Arrays.fill(this.f1693f, 0.0f);
        Arrays.fill(this.f1694g, 0.0f);
        Arrays.fill(this.f1695h, 0);
        Arrays.fill(this.f1696i, 0);
        Arrays.fill(this.f1697j, 0);
        this.f1698k = 0;
    }

    public final void h(int i10) {
        if (this.f1691d == null || !x(i10)) {
            return;
        }
        this.f1691d[i10] = 0.0f;
        this.f1692e[i10] = 0.0f;
        this.f1693f[i10] = 0.0f;
        this.f1694g[i10] = 0.0f;
        this.f1695h[i10] = 0;
        this.f1696i[i10] = 0;
        this.f1697j[i10] = 0;
        this.f1698k = ((1 << i10) ^ (-1)) & this.f1698k;
    }

    public final int i(int i10, int i11, int i12) {
        if (i10 == 0) {
            return 0;
        }
        int width = this.f1709v.getWidth();
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
        int iF = f(i12, (int) this.f1701n, (int) this.f1700m);
        int iF2 = f(i13, (int) this.f1701n, (int) this.f1700m);
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
        return (int) ((i(i10, iF, this.f1706s.d(view)) * f14) + (i(i11, iF2, this.f1706s.e(view)) * (f12 / f13)));
    }

    public boolean k(boolean z10) {
        if (this.f1688a == 2) {
            boolean zComputeScrollOffset = this.f1705r.computeScrollOffset();
            int currX = this.f1705r.getCurrX();
            int currY = this.f1705r.getCurrY();
            int left = currX - this.f1707t.getLeft();
            int top = currY - this.f1707t.getTop();
            if (left != 0) {
                r.J(this.f1707t, left);
            }
            if (top != 0) {
                r.K(this.f1707t, top);
            }
            if (left != 0 || top != 0) {
                this.f1706s.k(this.f1707t, currX, currY, left, top);
            }
            if (zComputeScrollOffset && currX == this.f1705r.getFinalX() && currY == this.f1705r.getFinalY()) {
                this.f1705r.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                if (z10) {
                    this.f1709v.post(this.f1710w);
                } else {
                    F(0);
                }
            }
        }
        return this.f1688a == 2;
    }

    public final void n(float f10, float f11) {
        this.f1708u = true;
        this.f1706s.l(this.f1707t, f10, f11);
        this.f1708u = false;
        if (this.f1688a == 1) {
            F(0);
        }
    }

    public final float o(float f10) {
        return (float) Math.sin((f10 - 0.5f) * 0.47123894f);
    }

    public final void p(int i10, int i11, int i12, int i13) {
        int left = this.f1707t.getLeft();
        int top = this.f1707t.getTop();
        if (i12 != 0) {
            i10 = this.f1706s.a(this.f1707t, i10, i12);
            r.J(this.f1707t, i10 - left);
        }
        int i14 = i10;
        if (i13 != 0) {
            i11 = this.f1706s.b(this.f1707t, i11, i13);
            r.K(this.f1707t, i11 - top);
        }
        int i15 = i11;
        if (i12 == 0 && i13 == 0) {
            return;
        }
        this.f1706s.k(this.f1707t, i14, i15, i14 - left, i15 - top);
    }

    public final void q(int i10) {
        float[] fArr = this.f1691d;
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
                float[] fArr6 = this.f1692e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f1693f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f1694g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f1695h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f1696i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f1697j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f1691d = fArr2;
            this.f1692e = fArr3;
            this.f1693f = fArr4;
            this.f1694g = fArr5;
            this.f1695h = iArr;
            this.f1696i = iArr2;
            this.f1697j = iArr3;
        }
    }

    public View r(int i10, int i11) {
        for (int childCount = this.f1709v.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f1709v.getChildAt(this.f1706s.c(childCount));
            if (i10 >= childAt.getLeft() && i10 < childAt.getRight() && i11 >= childAt.getTop() && i11 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean s(int i10, int i11, int i12, int i13) {
        int left = this.f1707t.getLeft();
        int top = this.f1707t.getTop();
        int i14 = i10 - left;
        int i15 = i11 - top;
        if (i14 == 0 && i15 == 0) {
            this.f1705r.abortAnimation();
            F(0);
            return false;
        }
        this.f1705r.startScroll(left, top, i14, i15, j(this.f1707t, i14, i15, i12, i13));
        F(2);
        return true;
    }

    public final int t(int i10, int i11) {
        int i12 = i10 < this.f1709v.getLeft() + this.f1702o ? 1 : 0;
        if (i11 < this.f1709v.getTop() + this.f1702o) {
            i12 |= 4;
        }
        if (i10 > this.f1709v.getRight() - this.f1702o) {
            i12 |= 2;
        }
        return i11 > this.f1709v.getBottom() - this.f1702o ? i12 | 8 : i12;
    }

    public int u() {
        return this.f1688a;
    }

    public boolean v(int i10, int i11) {
        return z(this.f1707t, i10, i11);
    }

    public boolean w(int i10, int i11) {
        return x(i11) && (i10 & this.f1695h[i11]) != 0;
    }

    public boolean x(int i10) {
        return ((1 << i10) & this.f1698k) != 0;
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

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class c {
        public abstract int a(View view, int i10, int i11);

        public int b(View view, int i10, int i11) {
            return 0;
        }

        public abstract int d(View view);

        public int e(View view) {
            return 0;
        }

        public boolean g(int i10) {
            return false;
        }

        public abstract void l(View view, float f10, float f11);

        public abstract boolean m(View view, int i10);

        public int c(int i10) {
            return i10;
        }

        public void j(int i10) {
        }

        public void f(int i10, int i11) {
        }

        public void h(int i10, int i11) {
        }

        public void i(View view, int i10) {
        }

        public void k(View view, int i10, int i11, int i12, int i13) {
        }
    }
}
