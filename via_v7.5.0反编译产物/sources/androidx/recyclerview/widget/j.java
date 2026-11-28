package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class j extends RecyclerView.n implements RecyclerView.q {
    public g A;
    public Rect C;
    public long D;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f1421d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f1422e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f1423f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f1424g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f1425h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f1426i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f1427j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f1428k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public f f1430m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f1432o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f1434q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public RecyclerView f1435r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public VelocityTracker f1437t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public List f1438u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public List f1439v;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public y.d f1443z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f1418a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f1419b = new float[2];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecyclerView.d0 f1420c = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1429l = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f1431n = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public List f1433p = new ArrayList();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Runnable f1436s = new a();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public RecyclerView.j f1440w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public View f1441x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f1442y = -1;
    public final RecyclerView.s B = new b();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j jVar = j.this;
            if (jVar.f1420c == null || !jVar.E()) {
                return;
            }
            j jVar2 = j.this;
            RecyclerView.d0 d0Var = jVar2.f1420c;
            if (d0Var != null) {
                jVar2.z(d0Var);
            }
            j jVar3 = j.this;
            jVar3.f1435r.removeCallbacks(jVar3.f1436s);
            y.r.Q(j.this.f1435r, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements RecyclerView.s {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
            j.this.f1443z.a(motionEvent);
            VelocityTracker velocityTracker = j.this.f1437t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (j.this.f1429l == -1) {
                return;
            }
            int actionMasked = motionEvent.getActionMasked();
            int iFindPointerIndex = motionEvent.findPointerIndex(j.this.f1429l);
            if (iFindPointerIndex >= 0) {
                j.this.o(actionMasked, motionEvent, iFindPointerIndex);
            }
            j jVar = j.this;
            RecyclerView.d0 d0Var = jVar.f1420c;
            if (d0Var == null) {
                return;
            }
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (iFindPointerIndex >= 0) {
                        jVar.L(motionEvent, jVar.f1432o, iFindPointerIndex);
                        j.this.z(d0Var);
                        j jVar2 = j.this;
                        jVar2.f1435r.removeCallbacks(jVar2.f1436s);
                        j.this.f1436s.run();
                        j.this.f1435r.invalidate();
                        return;
                    }
                    return;
                }
                if (actionMasked != 3) {
                    if (actionMasked != 6) {
                        return;
                    }
                    int actionIndex = motionEvent.getActionIndex();
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    j jVar3 = j.this;
                    if (pointerId == jVar3.f1429l) {
                        jVar3.f1429l = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
                        j jVar4 = j.this;
                        jVar4.L(motionEvent, jVar4.f1432o, actionIndex);
                        return;
                    }
                    return;
                }
                VelocityTracker velocityTracker2 = jVar.f1437t;
                if (velocityTracker2 != null) {
                    velocityTracker2.clear();
                }
            }
            j.this.F(null, 0);
            j.this.f1429l = -1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public boolean c(RecyclerView recyclerView, MotionEvent motionEvent) {
            int iFindPointerIndex;
            h hVarS;
            j.this.f1443z.a(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                j.this.f1429l = motionEvent.getPointerId(0);
                j.this.f1421d = motionEvent.getX();
                j.this.f1422e = motionEvent.getY();
                j.this.A();
                j jVar = j.this;
                if (jVar.f1420c == null && (hVarS = jVar.s(motionEvent)) != null) {
                    j jVar2 = j.this;
                    jVar2.f1421d -= hVarS.f1467j;
                    jVar2.f1422e -= hVarS.f1468k;
                    jVar2.r(hVarS.f1462e, true);
                    if (j.this.f1418a.remove(hVarS.f1462e.f1138a)) {
                        j jVar3 = j.this;
                        jVar3.f1430m.c(jVar3.f1435r, hVarS.f1462e);
                    }
                    j.this.F(hVarS.f1462e, hVarS.f1463f);
                    j jVar4 = j.this;
                    jVar4.L(motionEvent, jVar4.f1432o, 0);
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                j jVar5 = j.this;
                jVar5.f1429l = -1;
                jVar5.F(null, 0);
            } else {
                int i10 = j.this.f1429l;
                if (i10 != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i10)) >= 0) {
                    j.this.o(actionMasked, motionEvent, iFindPointerIndex);
                }
            }
            VelocityTracker velocityTracker = j.this.f1437t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            return j.this.f1420c != null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void e(boolean z10) {
            if (z10) {
                j.this.F(null, 0);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c extends h {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ int f1446o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.d0 f1447p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(RecyclerView.d0 d0Var, int i10, int i11, float f10, float f11, float f12, float f13, int i12, RecyclerView.d0 d0Var2) {
            super(d0Var, i10, i11, f10, f11, f12, f13);
            this.f1446o = i12;
            this.f1447p = d0Var2;
        }

        @Override // androidx.recyclerview.widget.j.h, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (this.f1469l) {
                return;
            }
            if (this.f1446o <= 0) {
                j jVar = j.this;
                jVar.f1430m.c(jVar.f1435r, this.f1447p);
            } else {
                j.this.f1418a.add(this.f1447p.f1138a);
                this.f1466i = true;
                int i10 = this.f1446o;
                if (i10 > 0) {
                    j.this.B(this, i10);
                }
            }
            j jVar2 = j.this;
            View view = jVar2.f1441x;
            View view2 = this.f1447p.f1138a;
            if (view == view2) {
                jVar2.D(view2);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ h f1449c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f1450e;

        public d(h hVar, int i10) {
            this.f1449c = hVar;
            this.f1450e = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = j.this.f1435r;
            if (recyclerView == null || !recyclerView.isAttachedToWindow()) {
                return;
            }
            h hVar = this.f1449c;
            if (hVar.f1469l || hVar.f1462e.j() == -1) {
                return;
            }
            RecyclerView.l itemAnimator = j.this.f1435r.getItemAnimator();
            if ((itemAnimator == null || !itemAnimator.q(null)) && !j.this.x()) {
                j.this.f1430m.B(this.f1449c.f1462e, this.f1450e);
            } else {
                j.this.f1435r.post(this);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class e implements RecyclerView.j {
        public e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public int a(int i10, int i11) {
            j jVar = j.this;
            View view = jVar.f1441x;
            if (view != null) {
                int iIndexOfChild = jVar.f1442y;
                if (iIndexOfChild == -1) {
                    iIndexOfChild = jVar.f1435r.indexOfChild(view);
                    j.this.f1442y = iIndexOfChild;
                }
                if (i11 == i10 - 1) {
                    return iIndexOfChild;
                }
                if (i11 >= iIndexOfChild) {
                    return i11 + 1;
                }
            }
            return i11;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class g extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1456a = true;

        public g() {
        }

        public void a() {
            this.f1456a = false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            View viewT;
            RecyclerView.d0 d0VarK0;
            if (!this.f1456a || (viewT = j.this.t(motionEvent)) == null || (d0VarK0 = j.this.f1435r.k0(viewT)) == null) {
                return;
            }
            j jVar = j.this;
            if (jVar.f1430m.o(jVar.f1435r, d0VarK0)) {
                int pointerId = motionEvent.getPointerId(0);
                int i10 = j.this.f1429l;
                if (pointerId == i10) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(i10);
                    float x10 = motionEvent.getX(iFindPointerIndex);
                    float y10 = motionEvent.getY(iFindPointerIndex);
                    j jVar2 = j.this;
                    jVar2.f1421d = x10;
                    jVar2.f1422e = y10;
                    jVar2.f1426i = 0.0f;
                    jVar2.f1425h = 0.0f;
                    if (jVar2.f1430m.r()) {
                        j.this.F(d0VarK0, 2);
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class i extends f {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1473d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1474e;

        public i(int i10, int i11) {
            this.f1473d = i11;
            this.f1474e = i10;
        }

        public int C(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
            return this.f1474e;
        }

        public int D(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
            return this.f1473d;
        }

        @Override // androidx.recyclerview.widget.j.f
        public int k(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
            return f.t(C(recyclerView, d0Var), D(recyclerView, d0Var));
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.j$j, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface InterfaceC0022j {
        void b(View view, View view2, int i10, int i11);
    }

    public j(f fVar) {
        this.f1430m = fVar;
    }

    private void G() {
        this.f1434q = ViewConfiguration.get(this.f1435r.getContext()).getScaledTouchSlop();
        this.f1435r.k(this);
        this.f1435r.n(this.B);
        this.f1435r.m(this);
        I();
    }

    private void q() {
        this.f1435r.d1(this);
        this.f1435r.f1(this.B);
        this.f1435r.e1(this);
        for (int size = this.f1433p.size() - 1; size >= 0; size--) {
            h hVar = (h) this.f1433p.get(0);
            hVar.a();
            this.f1430m.c(this.f1435r, hVar.f1462e);
        }
        this.f1433p.clear();
        this.f1441x = null;
        this.f1442y = -1;
        C();
        J();
    }

    public static boolean y(View view, float f10, float f11, float f12, float f13) {
        return f10 >= f12 && f10 <= f12 + ((float) view.getWidth()) && f11 >= f13 && f11 <= f13 + ((float) view.getHeight());
    }

    public void A() {
        VelocityTracker velocityTracker = this.f1437t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.f1437t = VelocityTracker.obtain();
    }

    public void B(h hVar, int i10) {
        this.f1435r.post(new d(hVar, i10));
    }

    public final void C() {
        VelocityTracker velocityTracker = this.f1437t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f1437t = null;
        }
    }

    public void D(View view) {
        if (view == this.f1441x) {
            this.f1441x = null;
            if (this.f1440w != null) {
                this.f1435r.setChildDrawingOrderCallback(null);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x007d  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c4  */
    public boolean E() {
        int iP;
        int iP2;
        if (this.f1420c == null) {
            this.D = Long.MIN_VALUE;
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j10 = this.D;
        long j11 = j10 == Long.MIN_VALUE ? 0L : jCurrentTimeMillis - j10;
        RecyclerView.o layoutManager = this.f1435r.getLayoutManager();
        if (this.C == null) {
            this.C = new Rect();
        }
        layoutManager.k(this.f1420c.f1138a, this.C);
        if (layoutManager.l()) {
            int i10 = (int) (this.f1427j + this.f1425h);
            int paddingLeft = (i10 - this.C.left) - this.f1435r.getPaddingLeft();
            float f10 = this.f1425h;
            if ((f10 >= 0.0f || paddingLeft >= 0) && (f10 <= 0.0f || (paddingLeft = ((i10 + this.f1420c.f1138a.getWidth()) + this.C.right) - (this.f1435r.getWidth() - this.f1435r.getPaddingRight())) <= 0)) {
                iP = 0;
            } else {
                iP = paddingLeft;
            }
        } else {
            iP = 0;
        }
        if (layoutManager.m()) {
            int i11 = (int) (this.f1428k + this.f1426i);
            iP2 = (i11 - this.C.top) - this.f1435r.getPaddingTop();
            float f11 = this.f1426i;
            if ((f11 >= 0.0f || iP2 >= 0) && (f11 <= 0.0f || (iP2 = ((i11 + this.f1420c.f1138a.getHeight()) + this.C.bottom) - (this.f1435r.getHeight() - this.f1435r.getPaddingBottom())) <= 0)) {
                iP2 = 0;
            }
        } else {
            iP2 = 0;
        }
        if (iP != 0) {
            iP = this.f1430m.p(this.f1435r, this.f1420c.f1138a.getWidth(), iP, this.f1435r.getWidth(), j11);
        }
        int i12 = iP;
        if (iP2 != 0) {
            iP2 = this.f1430m.p(this.f1435r, this.f1420c.f1138a.getHeight(), iP2, this.f1435r.getHeight(), j11);
        }
        if (i12 == 0 && iP2 == 0) {
            this.D = Long.MIN_VALUE;
            return false;
        }
        if (this.D == Long.MIN_VALUE) {
            this.D = jCurrentTimeMillis;
        }
        this.f1435r.scrollBy(i12, iP2);
        return true;
    }

    public void F(RecyclerView.d0 d0Var, int i10) {
        boolean z10;
        boolean z11;
        float fSignum;
        float fSignum2;
        if (d0Var == this.f1420c && i10 == this.f1431n) {
            return;
        }
        this.D = Long.MIN_VALUE;
        int i11 = this.f1431n;
        r(d0Var, true);
        this.f1431n = i10;
        if (i10 == 2) {
            if (d0Var == null) {
                throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
            }
            this.f1441x = d0Var.f1138a;
            l();
        }
        int i12 = (1 << ((i10 * 8) + 8)) - 1;
        RecyclerView.d0 d0Var2 = this.f1420c;
        if (d0Var2 != null) {
            if (d0Var2.f1138a.getParent() != null) {
                int iK = i11 == 2 ? 0 : K(d0Var2);
                C();
                int i13 = 4;
                if (iK == 1 || iK == 2) {
                    fSignum = Math.signum(this.f1426i) * this.f1435r.getHeight();
                    fSignum2 = 0.0f;
                } else {
                    fSignum2 = (iK == 4 || iK == 8 || iK == 16 || iK == 32) ? Math.signum(this.f1425h) * this.f1435r.getWidth() : 0.0f;
                    fSignum = 0.0f;
                }
                if (i11 == 2) {
                    i13 = 8;
                } else if (iK > 0) {
                    i13 = 2;
                }
                w(this.f1419b);
                float[] fArr = this.f1419b;
                float f10 = fArr[0];
                float f11 = fArr[1];
                z10 = false;
                c cVar = new c(d0Var2, i13, i11, f10, f11, fSignum2, fSignum, iK, d0Var2);
                cVar.b(this.f1430m.g(this.f1435r, i13, fSignum2 - f10, fSignum - f11));
                this.f1433p.add(cVar);
                cVar.d();
                z11 = true;
            } else {
                z10 = false;
                D(d0Var2.f1138a);
                this.f1430m.c(this.f1435r, d0Var2);
                z11 = false;
            }
            this.f1420c = null;
        } else {
            z10 = false;
            z11 = false;
        }
        if (d0Var != null) {
            this.f1432o = (this.f1430m.f(this.f1435r, d0Var) & i12) >> (this.f1431n * 8);
            this.f1427j = d0Var.f1138a.getLeft();
            this.f1428k = d0Var.f1138a.getTop();
            this.f1420c = d0Var;
            if (i10 == 2) {
                d0Var.f1138a.performHapticFeedback(z10 ? 1 : 0);
            }
        }
        ViewParent parent = this.f1435r.getParent();
        if (parent != null) {
            if (this.f1420c != null) {
                z10 = true;
            }
            parent.requestDisallowInterceptTouchEvent(z10);
        }
        if (!z11) {
            this.f1435r.getLayoutManager().v1();
        }
        this.f1430m.A(this.f1420c, this.f1431n);
        this.f1435r.invalidate();
    }

    public void H(RecyclerView.d0 d0Var) {
        if (!this.f1430m.o(this.f1435r, d0Var)) {
            Log.e("ItemTouchHelper", "Start drag has been called but dragging is not enabled");
            return;
        }
        if (d0Var.f1138a.getParent() != this.f1435r) {
            Log.e("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
            return;
        }
        A();
        this.f1426i = 0.0f;
        this.f1425h = 0.0f;
        F(d0Var, 2);
    }

    public final void I() {
        this.A = new g();
        this.f1443z = new y.d(this.f1435r.getContext(), this.A);
    }

    public final void J() {
        g gVar = this.A;
        if (gVar != null) {
            gVar.a();
            this.A = null;
        }
        if (this.f1443z != null) {
            this.f1443z = null;
        }
    }

    public final int K(RecyclerView.d0 d0Var) {
        if (this.f1431n == 2) {
            return 0;
        }
        int iK = this.f1430m.k(this.f1435r, d0Var);
        int iD = (this.f1430m.d(iK, y.r.v(this.f1435r)) & 65280) >> 8;
        if (iD == 0) {
            return 0;
        }
        int i10 = (iK & 65280) >> 8;
        if (Math.abs(this.f1425h) > Math.abs(this.f1426i)) {
            int iN = n(d0Var, iD);
            if (iN > 0) {
                return (i10 & iN) == 0 ? f.e(iN, y.r.v(this.f1435r)) : iN;
            }
            int iP = p(d0Var, iD);
            if (iP > 0) {
                return iP;
            }
        } else {
            int iP2 = p(d0Var, iD);
            if (iP2 > 0) {
                return iP2;
            }
            int iN2 = n(d0Var, iD);
            if (iN2 > 0) {
                return (i10 & iN2) == 0 ? f.e(iN2, y.r.v(this.f1435r)) : iN2;
            }
        }
        return 0;
    }

    public void L(MotionEvent motionEvent, int i10, int i11) {
        float x10 = motionEvent.getX(i11);
        float y10 = motionEvent.getY(i11);
        float f10 = x10 - this.f1421d;
        this.f1425h = f10;
        this.f1426i = y10 - this.f1422e;
        if ((i10 & 4) == 0) {
            this.f1425h = Math.max(0.0f, f10);
        }
        if ((i10 & 8) == 0) {
            this.f1425h = Math.min(0.0f, this.f1425h);
        }
        if ((i10 & 1) == 0) {
            this.f1426i = Math.max(0.0f, this.f1426i);
        }
        if ((i10 & 2) == 0) {
            this.f1426i = Math.min(0.0f, this.f1426i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void b(View view) {
        D(view);
        RecyclerView.d0 d0VarK0 = this.f1435r.k0(view);
        if (d0VarK0 == null) {
            return;
        }
        RecyclerView.d0 d0Var = this.f1420c;
        if (d0Var != null && d0VarK0 == d0Var) {
            F(null, 0);
            return;
        }
        r(d0VarK0, false);
        if (this.f1418a.remove(d0VarK0.f1138a)) {
            this.f1430m.c(this.f1435r, d0VarK0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        rect.setEmpty();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        float f10;
        float f11;
        this.f1442y = -1;
        if (this.f1420c != null) {
            w(this.f1419b);
            float[] fArr = this.f1419b;
            float f12 = fArr[0];
            f11 = fArr[1];
            f10 = f12;
        } else {
            f10 = 0.0f;
            f11 = 0.0f;
        }
        this.f1430m.w(canvas, recyclerView, this.f1420c, this.f1433p, this.f1431n, f10, f11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        float f10;
        float f11;
        if (this.f1420c != null) {
            w(this.f1419b);
            float[] fArr = this.f1419b;
            float f12 = fArr[0];
            f11 = fArr[1];
            f10 = f12;
        } else {
            f10 = 0.0f;
            f11 = 0.0f;
        }
        this.f1430m.x(canvas, recyclerView, this.f1420c, this.f1433p, this.f1431n, f10, f11);
    }

    public final void l() {
        if (Build.VERSION.SDK_INT >= 21) {
            return;
        }
        if (this.f1440w == null) {
            this.f1440w = new e();
        }
        this.f1435r.setChildDrawingOrderCallback(this.f1440w);
    }

    public void m(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f1435r;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            q();
        }
        this.f1435r = recyclerView;
        if (recyclerView != null) {
            Resources resources = recyclerView.getResources();
            this.f1423f = resources.getDimension(l0.b.f7373f);
            this.f1424g = resources.getDimension(l0.b.f7372e);
            G();
        }
    }

    public final int n(RecyclerView.d0 d0Var, int i10) {
        if ((i10 & 12) == 0) {
            return 0;
        }
        int i11 = this.f1425h > 0.0f ? 8 : 4;
        VelocityTracker velocityTracker = this.f1437t;
        if (velocityTracker != null && this.f1429l > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.f1430m.n(this.f1424g));
            float xVelocity = this.f1437t.getXVelocity(this.f1429l);
            float yVelocity = this.f1437t.getYVelocity(this.f1429l);
            int i12 = xVelocity > 0.0f ? 8 : 4;
            float fAbs = Math.abs(xVelocity);
            if ((i12 & i10) != 0 && i11 == i12 && fAbs >= this.f1430m.l(this.f1423f) && fAbs > Math.abs(yVelocity)) {
                return i12;
            }
        }
        float width = this.f1435r.getWidth() * this.f1430m.m(d0Var);
        if ((i10 & i11) == 0 || Math.abs(this.f1425h) <= width) {
            return 0;
        }
        return i11;
    }

    public void o(int i10, MotionEvent motionEvent, int i11) {
        RecyclerView.d0 d0VarV;
        int iF;
        if (this.f1420c != null || i10 != 2 || this.f1431n == 2 || !this.f1430m.q() || this.f1435r.getScrollState() == 1 || (d0VarV = v(motionEvent)) == null || (iF = (this.f1430m.f(this.f1435r, d0VarV) & 65280) >> 8) == 0) {
            return;
        }
        float x10 = motionEvent.getX(i11);
        float y10 = motionEvent.getY(i11);
        float f10 = x10 - this.f1421d;
        float f11 = y10 - this.f1422e;
        float fAbs = Math.abs(f10);
        float fAbs2 = Math.abs(f11);
        int i12 = this.f1434q;
        if (fAbs >= i12 || fAbs2 >= i12) {
            if (fAbs > fAbs2) {
                if (f10 < 0.0f && (iF & 4) == 0) {
                    return;
                }
                if (f10 > 0.0f && (iF & 8) == 0) {
                    return;
                }
            } else {
                if (f11 < 0.0f && (iF & 1) == 0) {
                    return;
                }
                if (f11 > 0.0f && (iF & 2) == 0) {
                    return;
                }
            }
            this.f1426i = 0.0f;
            this.f1425h = 0.0f;
            this.f1429l = motionEvent.getPointerId(0);
            F(d0VarV, 1);
        }
    }

    public final int p(RecyclerView.d0 d0Var, int i10) {
        if ((i10 & 3) == 0) {
            return 0;
        }
        int i11 = this.f1426i > 0.0f ? 2 : 1;
        VelocityTracker velocityTracker = this.f1437t;
        if (velocityTracker != null && this.f1429l > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.f1430m.n(this.f1424g));
            float xVelocity = this.f1437t.getXVelocity(this.f1429l);
            float yVelocity = this.f1437t.getYVelocity(this.f1429l);
            int i12 = yVelocity > 0.0f ? 2 : 1;
            float fAbs = Math.abs(yVelocity);
            if ((i12 & i10) != 0 && i12 == i11 && fAbs >= this.f1430m.l(this.f1423f) && fAbs > Math.abs(xVelocity)) {
                return i12;
            }
        }
        float height = this.f1435r.getHeight() * this.f1430m.m(d0Var);
        if ((i10 & i11) == 0 || Math.abs(this.f1426i) <= height) {
            return 0;
        }
        return i11;
    }

    public void r(RecyclerView.d0 d0Var, boolean z10) {
        for (int size = this.f1433p.size() - 1; size >= 0; size--) {
            h hVar = (h) this.f1433p.get(size);
            if (hVar.f1462e == d0Var) {
                hVar.f1469l |= z10;
                if (!hVar.f1470m) {
                    hVar.a();
                }
                this.f1433p.remove(size);
                return;
            }
        }
    }

    public h s(MotionEvent motionEvent) {
        if (this.f1433p.isEmpty()) {
            return null;
        }
        View viewT = t(motionEvent);
        for (int size = this.f1433p.size() - 1; size >= 0; size--) {
            h hVar = (h) this.f1433p.get(size);
            if (hVar.f1462e.f1138a == viewT) {
                return hVar;
            }
        }
        return null;
    }

    public View t(MotionEvent motionEvent) {
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        RecyclerView.d0 d0Var = this.f1420c;
        if (d0Var != null) {
            View view = d0Var.f1138a;
            if (y(view, x10, y10, this.f1427j + this.f1425h, this.f1428k + this.f1426i)) {
                return view;
            }
        }
        for (int size = this.f1433p.size() - 1; size >= 0; size--) {
            h hVar = (h) this.f1433p.get(size);
            View view2 = hVar.f1462e.f1138a;
            if (y(view2, x10, y10, hVar.f1467j, hVar.f1468k)) {
                return view2;
            }
        }
        return this.f1435r.V(x10, y10);
    }

    public final List u(RecyclerView.d0 d0Var) {
        RecyclerView.d0 d0Var2 = d0Var;
        List list = this.f1438u;
        if (list == null) {
            this.f1438u = new ArrayList();
            this.f1439v = new ArrayList();
        } else {
            list.clear();
            this.f1439v.clear();
        }
        int iH = this.f1430m.h();
        int iRound = Math.round(this.f1427j + this.f1425h) - iH;
        int iRound2 = Math.round(this.f1428k + this.f1426i) - iH;
        int i10 = iH * 2;
        int width = d0Var2.f1138a.getWidth() + iRound + i10;
        int height = d0Var2.f1138a.getHeight() + iRound2 + i10;
        int i11 = (iRound + width) / 2;
        int i12 = (iRound2 + height) / 2;
        RecyclerView.o layoutManager = this.f1435r.getLayoutManager();
        int iK = layoutManager.K();
        int i13 = 0;
        while (i13 < iK) {
            View viewJ = layoutManager.J(i13);
            if (viewJ != d0Var2.f1138a && viewJ.getBottom() >= iRound2 && viewJ.getTop() <= height && viewJ.getRight() >= iRound && viewJ.getLeft() <= width) {
                RecyclerView.d0 d0VarK0 = this.f1435r.k0(viewJ);
                if (this.f1430m.a(this.f1435r, this.f1420c, d0VarK0)) {
                    int iAbs = Math.abs(i11 - ((viewJ.getLeft() + viewJ.getRight()) / 2));
                    int iAbs2 = Math.abs(i12 - ((viewJ.getTop() + viewJ.getBottom()) / 2));
                    int i14 = (iAbs * iAbs) + (iAbs2 * iAbs2);
                    int size = this.f1438u.size();
                    int i15 = 0;
                    for (int i16 = 0; i16 < size && i14 > ((Integer) this.f1439v.get(i16)).intValue(); i16++) {
                        i15++;
                    }
                    this.f1438u.add(i15, d0VarK0);
                    this.f1439v.add(i15, Integer.valueOf(i14));
                }
            }
            i13++;
            d0Var2 = d0Var;
        }
        return this.f1438u;
    }

    public final RecyclerView.d0 v(MotionEvent motionEvent) {
        View viewT;
        RecyclerView.o layoutManager = this.f1435r.getLayoutManager();
        int i10 = this.f1429l;
        if (i10 == -1) {
            return null;
        }
        int iFindPointerIndex = motionEvent.findPointerIndex(i10);
        float x10 = motionEvent.getX(iFindPointerIndex) - this.f1421d;
        float y10 = motionEvent.getY(iFindPointerIndex) - this.f1422e;
        float fAbs = Math.abs(x10);
        float fAbs2 = Math.abs(y10);
        int i11 = this.f1434q;
        if (fAbs < i11 && fAbs2 < i11) {
            return null;
        }
        if (fAbs > fAbs2 && layoutManager.l()) {
            return null;
        }
        if ((fAbs2 <= fAbs || !layoutManager.m()) && (viewT = t(motionEvent)) != null) {
            return this.f1435r.k0(viewT);
        }
        return null;
    }

    public final void w(float[] fArr) {
        if ((this.f1432o & 12) != 0) {
            fArr[0] = (this.f1427j + this.f1425h) - this.f1420c.f1138a.getLeft();
        } else {
            fArr[0] = this.f1420c.f1138a.getTranslationX();
        }
        if ((this.f1432o & 3) != 0) {
            fArr[1] = (this.f1428k + this.f1426i) - this.f1420c.f1138a.getTop();
        } else {
            fArr[1] = this.f1420c.f1138a.getTranslationY();
        }
    }

    public boolean x() {
        int size = this.f1433p.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!((h) this.f1433p.get(i10)).f1470m) {
                return true;
            }
        }
        return false;
    }

    public void z(RecyclerView.d0 d0Var) {
        if (!this.f1435r.isLayoutRequested() && this.f1431n == 2) {
            float fJ = this.f1430m.j(d0Var);
            int i10 = (int) (this.f1427j + this.f1425h);
            int i11 = (int) (this.f1428k + this.f1426i);
            if (Math.abs(i11 - d0Var.f1138a.getTop()) >= d0Var.f1138a.getHeight() * fJ || Math.abs(i10 - d0Var.f1138a.getLeft()) >= d0Var.f1138a.getWidth() * fJ) {
                List listU = u(d0Var);
                if (listU.size() == 0) {
                    return;
                }
                RecyclerView.d0 d0VarB = this.f1430m.b(d0Var, listU, i10, i11);
                if (d0VarB == null) {
                    this.f1438u.clear();
                    this.f1439v.clear();
                    return;
                }
                int iJ = d0VarB.j();
                int iJ2 = d0Var.j();
                if (this.f1430m.y(this.f1435r, d0Var, d0VarB)) {
                    this.f1430m.z(this.f1435r, d0Var, iJ2, d0VarB, iJ, i10, i11);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Interpolator f1453b = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Interpolator f1454c = new b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1455a = -1;

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class a implements Interpolator {
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f10) {
                return f10 * f10 * f10 * f10 * f10;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class b implements Interpolator {
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f10) {
                float f11 = f10 - 1.0f;
                return (f11 * f11 * f11 * f11 * f11) + 1.0f;
            }
        }

        public static int e(int i10, int i11) {
            int i12;
            int i13 = i10 & 789516;
            if (i13 == 0) {
                return i10;
            }
            int i14 = i10 & (i13 ^ (-1));
            if (i11 == 0) {
                i12 = i13 << 2;
            } else {
                int i15 = i13 << 1;
                i14 |= (-789517) & i15;
                i12 = (i15 & 789516) << 2;
            }
            return i14 | i12;
        }

        public static int s(int i10, int i11) {
            return i11 << (i10 * 8);
        }

        public static int t(int i10, int i11) {
            return s(2, i10) | s(1, i11) | s(0, i11 | i10);
        }

        public void A(RecyclerView.d0 d0Var, int i10) {
            if (d0Var != null) {
                l.f1475a.b(d0Var.f1138a);
            }
        }

        public abstract void B(RecyclerView.d0 d0Var, int i10);

        public boolean a(RecyclerView recyclerView, RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
            return true;
        }

        public RecyclerView.d0 b(RecyclerView.d0 d0Var, List list, int i10, int i11) {
            int bottom;
            int iAbs;
            int top;
            int iAbs2;
            int left;
            int iAbs3;
            int right;
            int iAbs4;
            int width = d0Var.f1138a.getWidth() + i10;
            int height = i11 + d0Var.f1138a.getHeight();
            int left2 = i10 - d0Var.f1138a.getLeft();
            int top2 = i11 - d0Var.f1138a.getTop();
            int size = list.size();
            RecyclerView.d0 d0Var2 = null;
            int i12 = -1;
            for (int i13 = 0; i13 < size; i13++) {
                RecyclerView.d0 d0Var3 = (RecyclerView.d0) list.get(i13);
                if (left2 > 0 && (right = d0Var3.f1138a.getRight() - width) < 0 && d0Var3.f1138a.getRight() > d0Var.f1138a.getRight() && (iAbs4 = Math.abs(right)) > i12) {
                    d0Var2 = d0Var3;
                    i12 = iAbs4;
                }
                if (left2 < 0 && (left = d0Var3.f1138a.getLeft() - i10) > 0 && d0Var3.f1138a.getLeft() < d0Var.f1138a.getLeft() && (iAbs3 = Math.abs(left)) > i12) {
                    d0Var2 = d0Var3;
                    i12 = iAbs3;
                }
                if (top2 < 0 && (top = d0Var3.f1138a.getTop() - i11) > 0 && d0Var3.f1138a.getTop() < d0Var.f1138a.getTop() && (iAbs2 = Math.abs(top)) > i12) {
                    d0Var2 = d0Var3;
                    i12 = iAbs2;
                }
                if (top2 > 0 && (bottom = d0Var3.f1138a.getBottom() - height) < 0 && d0Var3.f1138a.getBottom() > d0Var.f1138a.getBottom() && (iAbs = Math.abs(bottom)) > i12) {
                    d0Var2 = d0Var3;
                    i12 = iAbs;
                }
            }
            return d0Var2;
        }

        public void c(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
            l.f1475a.a(d0Var.f1138a);
        }

        public int d(int i10, int i11) {
            int i12;
            int i13 = i10 & 3158064;
            if (i13 == 0) {
                return i10;
            }
            int i14 = i10 & (i13 ^ (-1));
            if (i11 == 0) {
                i12 = i13 >> 2;
            } else {
                int i15 = i13 >> 1;
                i14 |= (-3158065) & i15;
                i12 = (i15 & 3158064) >> 2;
            }
            return i14 | i12;
        }

        public final int f(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
            return d(k(recyclerView, d0Var), y.r.v(recyclerView));
        }

        public long g(RecyclerView recyclerView, int i10, float f10, float f11) {
            RecyclerView.l itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator == null) {
                return i10 == 8 ? 200L : 250L;
            }
            return i10 == 8 ? itemAnimator.n() : itemAnimator.o();
        }

        public int h() {
            return 0;
        }

        public final int i(RecyclerView recyclerView) {
            if (this.f1455a == -1) {
                this.f1455a = recyclerView.getResources().getDimensionPixelSize(l0.b.f7371d);
            }
            return this.f1455a;
        }

        public float j(RecyclerView.d0 d0Var) {
            return 0.5f;
        }

        public abstract int k(RecyclerView recyclerView, RecyclerView.d0 d0Var);

        public float m(RecyclerView.d0 d0Var) {
            return 0.5f;
        }

        public boolean o(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
            return (f(recyclerView, d0Var) & 16711680) != 0;
        }

        public int p(RecyclerView recyclerView, int i10, int i11, int i12, long j10) {
            int iSignum = (int) (((int) (((int) Math.signum(i11)) * i(recyclerView) * f1454c.getInterpolation(Math.min(1.0f, (Math.abs(i11) * 1.0f) / i10)))) * f1453b.getInterpolation(j10 <= 2000 ? j10 / 2000.0f : 1.0f));
            if (iSignum == 0) {
                return i11 > 0 ? 1 : -1;
            }
            return iSignum;
        }

        public boolean q() {
            return true;
        }

        public boolean r() {
            return true;
        }

        public void u(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, float f10, float f11, int i10, boolean z10) {
            l.f1475a.d(canvas, recyclerView, d0Var.f1138a, f10, f11, i10, z10);
        }

        public void v(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, float f10, float f11, int i10, boolean z10) {
            l.f1475a.c(canvas, recyclerView, d0Var.f1138a, f10, f11, i10, z10);
        }

        public void w(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, List list, int i10, float f10, float f11) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                h hVar = (h) list.get(i11);
                hVar.e();
                int iSave = canvas.save();
                u(canvas, recyclerView, hVar.f1462e, hVar.f1467j, hVar.f1468k, hVar.f1463f, false);
                canvas.restoreToCount(iSave);
            }
            if (d0Var != null) {
                int iSave2 = canvas.save();
                u(canvas, recyclerView, d0Var, f10, f11, i10, true);
                canvas.restoreToCount(iSave2);
            }
        }

        public void x(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, List list, int i10, float f10, float f11) {
            int size = list.size();
            boolean z10 = false;
            for (int i11 = 0; i11 < size; i11++) {
                h hVar = (h) list.get(i11);
                int iSave = canvas.save();
                v(canvas, recyclerView, hVar.f1462e, hVar.f1467j, hVar.f1468k, hVar.f1463f, false);
                canvas.restoreToCount(iSave);
            }
            if (d0Var != null) {
                int iSave2 = canvas.save();
                v(canvas, recyclerView, d0Var, f10, f11, i10, true);
                canvas.restoreToCount(iSave2);
            }
            for (int i12 = size - 1; i12 >= 0; i12--) {
                h hVar2 = (h) list.get(i12);
                boolean z11 = hVar2.f1470m;
                if (z11 && !hVar2.f1466i) {
                    list.remove(i12);
                } else if (!z11) {
                    z10 = true;
                }
            }
            if (z10) {
                recyclerView.invalidate();
            }
        }

        public abstract boolean y(RecyclerView recyclerView, RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2);

        /* JADX WARN: Multi-variable type inference failed */
        public void z(RecyclerView recyclerView, RecyclerView.d0 d0Var, int i10, RecyclerView.d0 d0Var2, int i11, int i12, int i13) {
            RecyclerView.o layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof InterfaceC0022j) {
                ((InterfaceC0022j) layoutManager).b(d0Var.f1138a, d0Var2.f1138a, i12, i13);
                return;
            }
            if (layoutManager.l()) {
                if (layoutManager.R(d0Var2.f1138a) <= recyclerView.getPaddingLeft()) {
                    recyclerView.p1(i11);
                }
                if (layoutManager.U(d0Var2.f1138a) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.p1(i11);
                }
            }
            if (layoutManager.m()) {
                if (layoutManager.V(d0Var2.f1138a) <= recyclerView.getPaddingTop()) {
                    recyclerView.p1(i11);
                }
                if (layoutManager.P(d0Var2.f1138a) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.p1(i11);
                }
            }
        }

        public float l(float f10) {
            return f10;
        }

        public float n(float f10) {
            return f10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class h implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f1458a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f1459b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f1460c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f1461d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final RecyclerView.d0 f1462e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f1463f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final ValueAnimator f1464g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f1465h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f1466i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f1467j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f1468k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f1469l = false;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f1470m = false;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f1471n;

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                h.this.c(valueAnimator.getAnimatedFraction());
            }
        }

        public h(RecyclerView.d0 d0Var, int i10, int i11, float f10, float f11, float f12, float f13) {
            this.f1463f = i11;
            this.f1465h = i10;
            this.f1462e = d0Var;
            this.f1458a = f10;
            this.f1459b = f11;
            this.f1460c = f12;
            this.f1461d = f13;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f1464g = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new a());
            valueAnimatorOfFloat.setTarget(d0Var.f1138a);
            valueAnimatorOfFloat.addListener(this);
            c(0.0f);
        }

        public void a() {
            this.f1464g.cancel();
        }

        public void b(long j10) {
            this.f1464g.setDuration(j10);
        }

        public void c(float f10) {
            this.f1471n = f10;
        }

        public void d() {
            this.f1462e.I(false);
            this.f1464g.start();
        }

        public void e() {
            float f10 = this.f1458a;
            float f11 = this.f1460c;
            if (f10 == f11) {
                this.f1467j = this.f1462e.f1138a.getTranslationX();
            } else {
                this.f1467j = f10 + (this.f1471n * (f11 - f10));
            }
            float f12 = this.f1459b;
            float f13 = this.f1461d;
            if (f12 == f13) {
                this.f1468k = this.f1462e.f1138a.getTranslationY();
            } else {
                this.f1468k = f12 + (this.f1471n * (f13 - f12));
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            c(1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.f1470m) {
                this.f1462e.I(true);
            }
            this.f1470m = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void d(View view) {
    }
}
