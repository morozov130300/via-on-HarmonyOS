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
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class j extends RecyclerView.n implements RecyclerView.q {
    public g A;
    public Rect C;
    public long D;

    /* renamed from: d, reason: collision with root package name */
    public float f1520d;

    /* renamed from: e, reason: collision with root package name */
    public float f1521e;

    /* renamed from: f, reason: collision with root package name */
    public float f1522f;

    /* renamed from: g, reason: collision with root package name */
    public float f1523g;

    /* renamed from: h, reason: collision with root package name */
    public float f1524h;

    /* renamed from: i, reason: collision with root package name */
    public float f1525i;

    /* renamed from: j, reason: collision with root package name */
    public float f1526j;

    /* renamed from: k, reason: collision with root package name */
    public float f1527k;

    /* renamed from: m, reason: collision with root package name */
    public f f1529m;

    /* renamed from: o, reason: collision with root package name */
    public int f1531o;

    /* renamed from: q, reason: collision with root package name */
    public int f1533q;

    /* renamed from: r, reason: collision with root package name */
    public RecyclerView f1534r;

    /* renamed from: t, reason: collision with root package name */
    public VelocityTracker f1536t;

    /* renamed from: u, reason: collision with root package name */
    public List f1537u;

    /* renamed from: v, reason: collision with root package name */
    public List f1538v;

    /* renamed from: z, reason: collision with root package name */
    public x.d f1542z;

    /* renamed from: a, reason: collision with root package name */
    public final List f1517a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final float[] f1518b = new float[2];

    /* renamed from: c, reason: collision with root package name */
    public RecyclerView.c0 f1519c = null;

    /* renamed from: l, reason: collision with root package name */
    public int f1528l = -1;

    /* renamed from: n, reason: collision with root package name */
    public int f1530n = 0;

    /* renamed from: p, reason: collision with root package name */
    public List f1532p = new ArrayList();

    /* renamed from: s, reason: collision with root package name */
    public final Runnable f1535s = new a();

    /* renamed from: w, reason: collision with root package name */
    public RecyclerView.j f1539w = null;

    /* renamed from: x, reason: collision with root package name */
    public View f1540x = null;

    /* renamed from: y, reason: collision with root package name */
    public int f1541y = -1;
    public final RecyclerView.s B = new b();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j jVar = j.this;
            if (jVar.f1519c == null || !jVar.E()) {
                return;
            }
            j jVar2 = j.this;
            RecyclerView.c0 c0Var = jVar2.f1519c;
            if (c0Var != null) {
                jVar2.z(c0Var);
            }
            j jVar3 = j.this;
            jVar3.f1534r.removeCallbacks(jVar3.f1535s);
            x.r.P(j.this.f1534r, this);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements RecyclerView.s {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
            j.this.f1542z.a(motionEvent);
            VelocityTracker velocityTracker = j.this.f1536t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (j.this.f1528l == -1) {
                return;
            }
            int actionMasked = motionEvent.getActionMasked();
            int iFindPointerIndex = motionEvent.findPointerIndex(j.this.f1528l);
            if (iFindPointerIndex >= 0) {
                j.this.o(actionMasked, motionEvent, iFindPointerIndex);
            }
            j jVar = j.this;
            RecyclerView.c0 c0Var = jVar.f1519c;
            if (c0Var == null) {
                return;
            }
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (iFindPointerIndex >= 0) {
                        jVar.L(motionEvent, jVar.f1531o, iFindPointerIndex);
                        j.this.z(c0Var);
                        j jVar2 = j.this;
                        jVar2.f1534r.removeCallbacks(jVar2.f1535s);
                        j.this.f1535s.run();
                        j.this.f1534r.invalidate();
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
                    if (pointerId == jVar3.f1528l) {
                        jVar3.f1528l = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
                        j jVar4 = j.this;
                        jVar4.L(motionEvent, jVar4.f1531o, actionIndex);
                        return;
                    }
                    return;
                }
                VelocityTracker velocityTracker2 = jVar.f1536t;
                if (velocityTracker2 != null) {
                    velocityTracker2.clear();
                }
            }
            j.this.F(null, 0);
            j.this.f1528l = -1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public boolean c(RecyclerView recyclerView, MotionEvent motionEvent) {
            int iFindPointerIndex;
            h hVarS;
            j.this.f1542z.a(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                j.this.f1528l = motionEvent.getPointerId(0);
                j.this.f1520d = motionEvent.getX();
                j.this.f1521e = motionEvent.getY();
                j.this.A();
                j jVar = j.this;
                if (jVar.f1519c == null && (hVarS = jVar.s(motionEvent)) != null) {
                    j jVar2 = j.this;
                    jVar2.f1520d -= hVarS.f1566j;
                    jVar2.f1521e -= hVarS.f1567k;
                    jVar2.r(hVarS.f1561e, true);
                    if (j.this.f1517a.remove(hVarS.f1561e.f1219a)) {
                        j jVar3 = j.this;
                        jVar3.f1529m.c(jVar3.f1534r, hVarS.f1561e);
                    }
                    j.this.F(hVarS.f1561e, hVarS.f1562f);
                    j jVar4 = j.this;
                    jVar4.L(motionEvent, jVar4.f1531o, 0);
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                j jVar5 = j.this;
                jVar5.f1528l = -1;
                jVar5.F(null, 0);
            } else {
                int i10 = j.this.f1528l;
                if (i10 != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i10)) >= 0) {
                    j.this.o(actionMasked, motionEvent, iFindPointerIndex);
                }
            }
            VelocityTracker velocityTracker = j.this.f1536t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            return j.this.f1519c != null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void e(boolean z10) {
            if (z10) {
                j.this.F(null, 0);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c extends h {

        /* renamed from: o, reason: collision with root package name */
        public final /* synthetic */ int f1545o;

        /* renamed from: p, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.c0 f1546p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(RecyclerView.c0 c0Var, int i10, int i11, float f10, float f11, float f12, float f13, int i12, RecyclerView.c0 c0Var2) {
            super(c0Var, i10, i11, f10, f11, f12, f13);
            this.f1545o = i12;
            this.f1546p = c0Var2;
        }

        @Override // androidx.recyclerview.widget.j.h, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (this.f1568l) {
                return;
            }
            if (this.f1545o <= 0) {
                j jVar = j.this;
                jVar.f1529m.c(jVar.f1534r, this.f1546p);
            } else {
                j.this.f1517a.add(this.f1546p.f1219a);
                this.f1565i = true;
                int i10 = this.f1545o;
                if (i10 > 0) {
                    j.this.B(this, i10);
                }
            }
            j jVar2 = j.this;
            View view = jVar2.f1540x;
            View view2 = this.f1546p.f1219a;
            if (view == view2) {
                jVar2.D(view2);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class d implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ h f1548e;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f1549j;

        public d(h hVar, int i10) {
            this.f1548e = hVar;
            this.f1549j = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = j.this.f1534r;
            if (recyclerView == null || !recyclerView.isAttachedToWindow()) {
                return;
            }
            h hVar = this.f1548e;
            if (hVar.f1568l || hVar.f1561e.j() == -1) {
                return;
            }
            RecyclerView.l itemAnimator = j.this.f1534r.getItemAnimator();
            if ((itemAnimator == null || !itemAnimator.q(null)) && !j.this.x()) {
                j.this.f1529m.B(this.f1548e.f1561e, this.f1549j);
            } else {
                j.this.f1534r.post(this);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class e implements RecyclerView.j {
        public e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public int a(int i10, int i11) {
            j jVar = j.this;
            View view = jVar.f1540x;
            if (view != null) {
                int iIndexOfChild = jVar.f1541y;
                if (iIndexOfChild == -1) {
                    iIndexOfChild = jVar.f1534r.indexOfChild(view);
                    j.this.f1541y = iIndexOfChild;
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

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class f {

        /* renamed from: b, reason: collision with root package name */
        public static final Interpolator f1552b = new a();

        /* renamed from: c, reason: collision with root package name */
        public static final Interpolator f1553c = new b();

        /* renamed from: a, reason: collision with root package name */
        public int f1554a = -1;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public class a implements Interpolator {
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f10) {
                return f10 * f10 * f10 * f10 * f10;
            }
        }

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
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

        public void A(RecyclerView.c0 c0Var, int i10) {
            if (c0Var != null) {
                l.f1574a.b(c0Var.f1219a);
            }
        }

        public abstract void B(RecyclerView.c0 c0Var, int i10);

        public boolean a(RecyclerView recyclerView, RecyclerView.c0 c0Var, RecyclerView.c0 c0Var2) {
            return true;
        }

        public RecyclerView.c0 b(RecyclerView.c0 c0Var, List list, int i10, int i11) {
            int bottom;
            int iAbs;
            int top;
            int iAbs2;
            int left;
            int iAbs3;
            int right;
            int iAbs4;
            int width = c0Var.f1219a.getWidth() + i10;
            int height = i11 + c0Var.f1219a.getHeight();
            int left2 = i10 - c0Var.f1219a.getLeft();
            int top2 = i11 - c0Var.f1219a.getTop();
            int size = list.size();
            RecyclerView.c0 c0Var2 = null;
            int i12 = -1;
            for (int i13 = 0; i13 < size; i13++) {
                RecyclerView.c0 c0Var3 = (RecyclerView.c0) list.get(i13);
                if (left2 > 0 && (right = c0Var3.f1219a.getRight() - width) < 0 && c0Var3.f1219a.getRight() > c0Var.f1219a.getRight() && (iAbs4 = Math.abs(right)) > i12) {
                    c0Var2 = c0Var3;
                    i12 = iAbs4;
                }
                if (left2 < 0 && (left = c0Var3.f1219a.getLeft() - i10) > 0 && c0Var3.f1219a.getLeft() < c0Var.f1219a.getLeft() && (iAbs3 = Math.abs(left)) > i12) {
                    c0Var2 = c0Var3;
                    i12 = iAbs3;
                }
                if (top2 < 0 && (top = c0Var3.f1219a.getTop() - i11) > 0 && c0Var3.f1219a.getTop() < c0Var.f1219a.getTop() && (iAbs2 = Math.abs(top)) > i12) {
                    c0Var2 = c0Var3;
                    i12 = iAbs2;
                }
                if (top2 > 0 && (bottom = c0Var3.f1219a.getBottom() - height) < 0 && c0Var3.f1219a.getBottom() > c0Var.f1219a.getBottom() && (iAbs = Math.abs(bottom)) > i12) {
                    c0Var2 = c0Var3;
                    i12 = iAbs;
                }
            }
            return c0Var2;
        }

        public void c(RecyclerView recyclerView, RecyclerView.c0 c0Var) {
            l.f1574a.a(c0Var.f1219a);
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

        public final int f(RecyclerView recyclerView, RecyclerView.c0 c0Var) {
            return d(k(recyclerView, c0Var), x.r.v(recyclerView));
        }

        public long g(RecyclerView recyclerView, int i10, float f10, float f11) {
            RecyclerView.l itemAnimator = recyclerView.getItemAnimator();
            return itemAnimator == null ? i10 == 8 ? 200L : 250L : i10 == 8 ? itemAnimator.n() : itemAnimator.o();
        }

        public int h() {
            return 0;
        }

        public final int i(RecyclerView recyclerView) {
            if (this.f1554a == -1) {
                this.f1554a = recyclerView.getResources().getDimensionPixelSize(k0.b.f8024d);
            }
            return this.f1554a;
        }

        public float j(RecyclerView.c0 c0Var) {
            return 0.5f;
        }

        public abstract int k(RecyclerView recyclerView, RecyclerView.c0 c0Var);

        public float l(float f10) {
            return f10;
        }

        public float m(RecyclerView.c0 c0Var) {
            return 0.5f;
        }

        public float n(float f10) {
            return f10;
        }

        public boolean o(RecyclerView recyclerView, RecyclerView.c0 c0Var) {
            return (f(recyclerView, c0Var) & 16711680) != 0;
        }

        public int p(RecyclerView recyclerView, int i10, int i11, int i12, long j10) {
            int iSignum = (int) (((int) (((int) Math.signum(i11)) * i(recyclerView) * f1553c.getInterpolation(Math.min(1.0f, (Math.abs(i11) * 1.0f) / i10)))) * f1552b.getInterpolation(j10 <= 2000 ? j10 / 2000.0f : 1.0f));
            return iSignum == 0 ? i11 > 0 ? 1 : -1 : iSignum;
        }

        public boolean q() {
            return true;
        }

        public boolean r() {
            return true;
        }

        public void u(Canvas canvas, RecyclerView recyclerView, RecyclerView.c0 c0Var, float f10, float f11, int i10, boolean z10) {
            l.f1574a.d(canvas, recyclerView, c0Var.f1219a, f10, f11, i10, z10);
        }

        public void v(Canvas canvas, RecyclerView recyclerView, RecyclerView.c0 c0Var, float f10, float f11, int i10, boolean z10) {
            l.f1574a.c(canvas, recyclerView, c0Var.f1219a, f10, f11, i10, z10);
        }

        public void w(Canvas canvas, RecyclerView recyclerView, RecyclerView.c0 c0Var, List list, int i10, float f10, float f11) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                h hVar = (h) list.get(i11);
                hVar.e();
                int iSave = canvas.save();
                u(canvas, recyclerView, hVar.f1561e, hVar.f1566j, hVar.f1567k, hVar.f1562f, false);
                canvas.restoreToCount(iSave);
            }
            if (c0Var != null) {
                int iSave2 = canvas.save();
                u(canvas, recyclerView, c0Var, f10, f11, i10, true);
                canvas.restoreToCount(iSave2);
            }
        }

        public void x(Canvas canvas, RecyclerView recyclerView, RecyclerView.c0 c0Var, List list, int i10, float f10, float f11) {
            int size = list.size();
            boolean z10 = false;
            for (int i11 = 0; i11 < size; i11++) {
                h hVar = (h) list.get(i11);
                int iSave = canvas.save();
                v(canvas, recyclerView, hVar.f1561e, hVar.f1566j, hVar.f1567k, hVar.f1562f, false);
                canvas.restoreToCount(iSave);
            }
            if (c0Var != null) {
                int iSave2 = canvas.save();
                v(canvas, recyclerView, c0Var, f10, f11, i10, true);
                canvas.restoreToCount(iSave2);
            }
            for (int i12 = size - 1; i12 >= 0; i12--) {
                h hVar2 = (h) list.get(i12);
                boolean z11 = hVar2.f1569m;
                if (z11 && !hVar2.f1565i) {
                    list.remove(i12);
                } else if (!z11) {
                    z10 = true;
                }
            }
            if (z10) {
                recyclerView.invalidate();
            }
        }

        public abstract boolean y(RecyclerView recyclerView, RecyclerView.c0 c0Var, RecyclerView.c0 c0Var2);

        /* JADX WARN: Multi-variable type inference failed */
        public void z(RecyclerView recyclerView, RecyclerView.c0 c0Var, int i10, RecyclerView.c0 c0Var2, int i11, int i12, int i13) {
            RecyclerView.o layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof InterfaceC0023j) {
                ((InterfaceC0023j) layoutManager).b(c0Var.f1219a, c0Var2.f1219a, i12, i13);
                return;
            }
            if (layoutManager.l()) {
                if (layoutManager.R(c0Var2.f1219a) <= recyclerView.getPaddingLeft()) {
                    recyclerView.p1(i11);
                }
                if (layoutManager.U(c0Var2.f1219a) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.p1(i11);
                }
            }
            if (layoutManager.m()) {
                if (layoutManager.V(c0Var2.f1219a) <= recyclerView.getPaddingTop()) {
                    recyclerView.p1(i11);
                }
                if (layoutManager.P(c0Var2.f1219a) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.p1(i11);
                }
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class g extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: a, reason: collision with root package name */
        public boolean f1555a = true;

        public g() {
        }

        public void a() {
            this.f1555a = false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            View viewT;
            RecyclerView.c0 c0VarK0;
            if (!this.f1555a || (viewT = j.this.t(motionEvent)) == null || (c0VarK0 = j.this.f1534r.k0(viewT)) == null) {
                return;
            }
            j jVar = j.this;
            if (jVar.f1529m.o(jVar.f1534r, c0VarK0)) {
                int pointerId = motionEvent.getPointerId(0);
                int i10 = j.this.f1528l;
                if (pointerId == i10) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(i10);
                    float x10 = motionEvent.getX(iFindPointerIndex);
                    float y10 = motionEvent.getY(iFindPointerIndex);
                    j jVar2 = j.this;
                    jVar2.f1520d = x10;
                    jVar2.f1521e = y10;
                    jVar2.f1525i = 0.0f;
                    jVar2.f1524h = 0.0f;
                    if (jVar2.f1529m.r()) {
                        j.this.F(c0VarK0, 2);
                    }
                }
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class h implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        public final float f1557a;

        /* renamed from: b, reason: collision with root package name */
        public final float f1558b;

        /* renamed from: c, reason: collision with root package name */
        public final float f1559c;

        /* renamed from: d, reason: collision with root package name */
        public final float f1560d;

        /* renamed from: e, reason: collision with root package name */
        public final RecyclerView.c0 f1561e;

        /* renamed from: f, reason: collision with root package name */
        public final int f1562f;

        /* renamed from: g, reason: collision with root package name */
        public final ValueAnimator f1563g;

        /* renamed from: h, reason: collision with root package name */
        public final int f1564h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f1565i;

        /* renamed from: j, reason: collision with root package name */
        public float f1566j;

        /* renamed from: k, reason: collision with root package name */
        public float f1567k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f1568l = false;

        /* renamed from: m, reason: collision with root package name */
        public boolean f1569m = false;

        /* renamed from: n, reason: collision with root package name */
        public float f1570n;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                h.this.c(valueAnimator.getAnimatedFraction());
            }
        }

        public h(RecyclerView.c0 c0Var, int i10, int i11, float f10, float f11, float f12, float f13) {
            this.f1562f = i11;
            this.f1564h = i10;
            this.f1561e = c0Var;
            this.f1557a = f10;
            this.f1558b = f11;
            this.f1559c = f12;
            this.f1560d = f13;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f1563g = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new a());
            valueAnimatorOfFloat.setTarget(c0Var.f1219a);
            valueAnimatorOfFloat.addListener(this);
            c(0.0f);
        }

        public void a() {
            this.f1563g.cancel();
        }

        public void b(long j10) {
            this.f1563g.setDuration(j10);
        }

        public void c(float f10) {
            this.f1570n = f10;
        }

        public void d() {
            this.f1561e.I(false);
            this.f1563g.start();
        }

        public void e() {
            float f10 = this.f1557a;
            float f11 = this.f1559c;
            if (f10 == f11) {
                this.f1566j = this.f1561e.f1219a.getTranslationX();
            } else {
                this.f1566j = f10 + (this.f1570n * (f11 - f10));
            }
            float f12 = this.f1558b;
            float f13 = this.f1560d;
            if (f12 == f13) {
                this.f1567k = this.f1561e.f1219a.getTranslationY();
            } else {
                this.f1567k = f12 + (this.f1570n * (f13 - f12));
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            c(1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.f1569m) {
                this.f1561e.I(true);
            }
            this.f1569m = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class i extends f {

        /* renamed from: d, reason: collision with root package name */
        public int f1572d;

        /* renamed from: e, reason: collision with root package name */
        public int f1573e;

        public i(int i10, int i11) {
            this.f1572d = i11;
            this.f1573e = i10;
        }

        public int C(RecyclerView recyclerView, RecyclerView.c0 c0Var) {
            return this.f1573e;
        }

        public int D(RecyclerView recyclerView, RecyclerView.c0 c0Var) {
            return this.f1572d;
        }

        @Override // androidx.recyclerview.widget.j.f
        public int k(RecyclerView recyclerView, RecyclerView.c0 c0Var) {
            return f.t(C(recyclerView, c0Var), D(recyclerView, c0Var));
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: androidx.recyclerview.widget.j$j, reason: collision with other inner class name */
    public interface InterfaceC0023j {
        void b(View view, View view2, int i10, int i11);
    }

    public j(f fVar) {
        this.f1529m = fVar;
    }

    private void G() {
        this.f1533q = ViewConfiguration.get(this.f1534r.getContext()).getScaledTouchSlop();
        this.f1534r.k(this);
        this.f1534r.n(this.B);
        this.f1534r.m(this);
        I();
    }

    private void q() {
        this.f1534r.d1(this);
        this.f1534r.f1(this.B);
        this.f1534r.e1(this);
        for (int size = this.f1532p.size() - 1; size >= 0; size--) {
            h hVar = (h) this.f1532p.get(0);
            hVar.a();
            this.f1529m.c(this.f1534r, hVar.f1561e);
        }
        this.f1532p.clear();
        this.f1540x = null;
        this.f1541y = -1;
        C();
        J();
    }

    public static boolean y(View view, float f10, float f11, float f12, float f13) {
        return f10 >= f12 && f10 <= f12 + ((float) view.getWidth()) && f11 >= f13 && f11 <= f13 + ((float) view.getHeight());
    }

    public void A() {
        VelocityTracker velocityTracker = this.f1536t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.f1536t = VelocityTracker.obtain();
    }

    public void B(h hVar, int i10) {
        this.f1534r.post(new d(hVar, i10));
    }

    public final void C() {
        VelocityTracker velocityTracker = this.f1536t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f1536t = null;
        }
    }

    public void D(View view) {
        if (view == this.f1540x) {
            this.f1540x = null;
            if (this.f1539w != null) {
                this.f1534r.setChildDrawingOrderCallback(null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean E() {
        int iP;
        int iP2;
        if (this.f1519c == null) {
            this.D = Long.MIN_VALUE;
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j10 = this.D;
        long j11 = j10 == Long.MIN_VALUE ? 0L : jCurrentTimeMillis - j10;
        RecyclerView.o layoutManager = this.f1534r.getLayoutManager();
        if (this.C == null) {
            this.C = new Rect();
        }
        layoutManager.k(this.f1519c.f1219a, this.C);
        if (layoutManager.l()) {
            int i10 = (int) (this.f1526j + this.f1524h);
            int paddingLeft = (i10 - this.C.left) - this.f1534r.getPaddingLeft();
            float f10 = this.f1524h;
            iP = ((f10 >= 0.0f || paddingLeft >= 0) && (f10 <= 0.0f || (paddingLeft = ((i10 + this.f1519c.f1219a.getWidth()) + this.C.right) - (this.f1534r.getWidth() - this.f1534r.getPaddingRight())) <= 0)) ? 0 : paddingLeft;
        }
        if (layoutManager.m()) {
            int i11 = (int) (this.f1527k + this.f1525i);
            iP2 = (i11 - this.C.top) - this.f1534r.getPaddingTop();
            float f11 = this.f1525i;
            if ((f11 >= 0.0f || iP2 >= 0) && (f11 <= 0.0f || (iP2 = ((i11 + this.f1519c.f1219a.getHeight()) + this.C.bottom) - (this.f1534r.getHeight() - this.f1534r.getPaddingBottom())) <= 0)) {
                iP2 = 0;
            }
        }
        if (iP != 0) {
            iP = this.f1529m.p(this.f1534r, this.f1519c.f1219a.getWidth(), iP, this.f1534r.getWidth(), j11);
        }
        int i12 = iP;
        if (iP2 != 0) {
            iP2 = this.f1529m.p(this.f1534r, this.f1519c.f1219a.getHeight(), iP2, this.f1534r.getHeight(), j11);
        }
        if (i12 == 0 && iP2 == 0) {
            this.D = Long.MIN_VALUE;
            return false;
        }
        if (this.D == Long.MIN_VALUE) {
            this.D = jCurrentTimeMillis;
        }
        this.f1534r.scrollBy(i12, iP2);
        return true;
    }

    public void F(RecyclerView.c0 c0Var, int i10) {
        boolean z10;
        boolean z11;
        float fSignum;
        float fSignum2;
        if (c0Var == this.f1519c && i10 == this.f1530n) {
            return;
        }
        this.D = Long.MIN_VALUE;
        int i11 = this.f1530n;
        r(c0Var, true);
        this.f1530n = i10;
        if (i10 == 2) {
            if (c0Var == null) {
                throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
            }
            this.f1540x = c0Var.f1219a;
            l();
        }
        int i12 = (1 << ((i10 * 8) + 8)) - 1;
        RecyclerView.c0 c0Var2 = this.f1519c;
        if (c0Var2 != null) {
            if (c0Var2.f1219a.getParent() != null) {
                int iK = i11 == 2 ? 0 : K(c0Var2);
                C();
                int i13 = 4;
                if (iK == 1 || iK == 2) {
                    fSignum = Math.signum(this.f1525i) * this.f1534r.getHeight();
                    fSignum2 = 0.0f;
                } else {
                    fSignum2 = (iK == 4 || iK == 8 || iK == 16 || iK == 32) ? Math.signum(this.f1524h) * this.f1534r.getWidth() : 0.0f;
                    fSignum = 0.0f;
                }
                if (i11 == 2) {
                    i13 = 8;
                } else if (iK > 0) {
                    i13 = 2;
                }
                w(this.f1518b);
                float[] fArr = this.f1518b;
                float f10 = fArr[0];
                float f11 = fArr[1];
                z10 = false;
                c cVar = new c(c0Var2, i13, i11, f10, f11, fSignum2, fSignum, iK, c0Var2);
                cVar.b(this.f1529m.g(this.f1534r, i13, fSignum2 - f10, fSignum - f11));
                this.f1532p.add(cVar);
                cVar.d();
                z11 = true;
            } else {
                z10 = false;
                D(c0Var2.f1219a);
                this.f1529m.c(this.f1534r, c0Var2);
                z11 = false;
            }
            this.f1519c = null;
        } else {
            z10 = false;
            z11 = false;
        }
        if (c0Var != null) {
            this.f1531o = (this.f1529m.f(this.f1534r, c0Var) & i12) >> (this.f1530n * 8);
            this.f1526j = c0Var.f1219a.getLeft();
            this.f1527k = c0Var.f1219a.getTop();
            this.f1519c = c0Var;
            if (i10 == 2) {
                c0Var.f1219a.performHapticFeedback(z10 ? 1 : 0);
            }
        }
        ViewParent parent = this.f1534r.getParent();
        if (parent != null) {
            if (this.f1519c != null) {
                z10 = true;
            }
            parent.requestDisallowInterceptTouchEvent(z10);
        }
        if (!z11) {
            this.f1534r.getLayoutManager().v1();
        }
        this.f1529m.A(this.f1519c, this.f1530n);
        this.f1534r.invalidate();
    }

    public void H(RecyclerView.c0 c0Var) {
        if (!this.f1529m.o(this.f1534r, c0Var)) {
            Log.e("ItemTouchHelper", "Start drag has been called but dragging is not enabled");
            return;
        }
        if (c0Var.f1219a.getParent() != this.f1534r) {
            Log.e("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
            return;
        }
        A();
        this.f1525i = 0.0f;
        this.f1524h = 0.0f;
        F(c0Var, 2);
    }

    public final void I() {
        this.A = new g();
        this.f1542z = new x.d(this.f1534r.getContext(), this.A);
    }

    public final void J() {
        g gVar = this.A;
        if (gVar != null) {
            gVar.a();
            this.A = null;
        }
        if (this.f1542z != null) {
            this.f1542z = null;
        }
    }

    public final int K(RecyclerView.c0 c0Var) {
        if (this.f1530n == 2) {
            return 0;
        }
        int iK = this.f1529m.k(this.f1534r, c0Var);
        int iD = (this.f1529m.d(iK, x.r.v(this.f1534r)) & 65280) >> 8;
        if (iD == 0) {
            return 0;
        }
        int i10 = (iK & 65280) >> 8;
        if (Math.abs(this.f1524h) > Math.abs(this.f1525i)) {
            int iN = n(c0Var, iD);
            if (iN > 0) {
                return (i10 & iN) == 0 ? f.e(iN, x.r.v(this.f1534r)) : iN;
            }
            int iP = p(c0Var, iD);
            if (iP > 0) {
                return iP;
            }
        } else {
            int iP2 = p(c0Var, iD);
            if (iP2 > 0) {
                return iP2;
            }
            int iN2 = n(c0Var, iD);
            if (iN2 > 0) {
                return (i10 & iN2) == 0 ? f.e(iN2, x.r.v(this.f1534r)) : iN2;
            }
        }
        return 0;
    }

    public void L(MotionEvent motionEvent, int i10, int i11) {
        float x10 = motionEvent.getX(i11);
        float y10 = motionEvent.getY(i11);
        float f10 = x10 - this.f1520d;
        this.f1524h = f10;
        this.f1525i = y10 - this.f1521e;
        if ((i10 & 4) == 0) {
            this.f1524h = Math.max(0.0f, f10);
        }
        if ((i10 & 8) == 0) {
            this.f1524h = Math.min(0.0f, this.f1524h);
        }
        if ((i10 & 1) == 0) {
            this.f1525i = Math.max(0.0f, this.f1525i);
        }
        if ((i10 & 2) == 0) {
            this.f1525i = Math.min(0.0f, this.f1525i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void b(View view) {
        D(view);
        RecyclerView.c0 c0VarK0 = this.f1534r.k0(view);
        if (c0VarK0 == null) {
            return;
        }
        RecyclerView.c0 c0Var = this.f1519c;
        if (c0Var != null && c0VarK0 == c0Var) {
            F(null, 0);
            return;
        }
        r(c0VarK0, false);
        if (this.f1517a.remove(c0VarK0.f1219a)) {
            this.f1529m.c(this.f1534r, c0VarK0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void d(View view) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
        rect.setEmpty();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
        float f10;
        float f11;
        this.f1541y = -1;
        if (this.f1519c != null) {
            w(this.f1518b);
            float[] fArr = this.f1518b;
            float f12 = fArr[0];
            f11 = fArr[1];
            f10 = f12;
        } else {
            f10 = 0.0f;
            f11 = 0.0f;
        }
        this.f1529m.w(canvas, recyclerView, this.f1519c, this.f1532p, this.f1530n, f10, f11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
        float f10;
        float f11;
        if (this.f1519c != null) {
            w(this.f1518b);
            float[] fArr = this.f1518b;
            float f12 = fArr[0];
            f11 = fArr[1];
            f10 = f12;
        } else {
            f10 = 0.0f;
            f11 = 0.0f;
        }
        this.f1529m.x(canvas, recyclerView, this.f1519c, this.f1532p, this.f1530n, f10, f11);
    }

    public final void l() {
        if (Build.VERSION.SDK_INT >= 21) {
            return;
        }
        if (this.f1539w == null) {
            this.f1539w = new e();
        }
        this.f1534r.setChildDrawingOrderCallback(this.f1539w);
    }

    public void m(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f1534r;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            q();
        }
        this.f1534r = recyclerView;
        if (recyclerView != null) {
            Resources resources = recyclerView.getResources();
            this.f1522f = resources.getDimension(k0.b.f8026f);
            this.f1523g = resources.getDimension(k0.b.f8025e);
            G();
        }
    }

    public final int n(RecyclerView.c0 c0Var, int i10) {
        if ((i10 & 12) == 0) {
            return 0;
        }
        int i11 = this.f1524h > 0.0f ? 8 : 4;
        VelocityTracker velocityTracker = this.f1536t;
        if (velocityTracker != null && this.f1528l > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.f1529m.n(this.f1523g));
            float xVelocity = this.f1536t.getXVelocity(this.f1528l);
            float yVelocity = this.f1536t.getYVelocity(this.f1528l);
            int i12 = xVelocity > 0.0f ? 8 : 4;
            float fAbs = Math.abs(xVelocity);
            if ((i12 & i10) != 0 && i11 == i12 && fAbs >= this.f1529m.l(this.f1522f) && fAbs > Math.abs(yVelocity)) {
                return i12;
            }
        }
        float width = this.f1534r.getWidth() * this.f1529m.m(c0Var);
        if ((i10 & i11) == 0 || Math.abs(this.f1524h) <= width) {
            return 0;
        }
        return i11;
    }

    public void o(int i10, MotionEvent motionEvent, int i11) {
        RecyclerView.c0 c0VarV;
        int iF;
        if (this.f1519c != null || i10 != 2 || this.f1530n == 2 || !this.f1529m.q() || this.f1534r.getScrollState() == 1 || (c0VarV = v(motionEvent)) == null || (iF = (this.f1529m.f(this.f1534r, c0VarV) & 65280) >> 8) == 0) {
            return;
        }
        float x10 = motionEvent.getX(i11);
        float y10 = motionEvent.getY(i11);
        float f10 = x10 - this.f1520d;
        float f11 = y10 - this.f1521e;
        float fAbs = Math.abs(f10);
        float fAbs2 = Math.abs(f11);
        int i12 = this.f1533q;
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
            this.f1525i = 0.0f;
            this.f1524h = 0.0f;
            this.f1528l = motionEvent.getPointerId(0);
            F(c0VarV, 1);
        }
    }

    public final int p(RecyclerView.c0 c0Var, int i10) {
        if ((i10 & 3) == 0) {
            return 0;
        }
        int i11 = this.f1525i > 0.0f ? 2 : 1;
        VelocityTracker velocityTracker = this.f1536t;
        if (velocityTracker != null && this.f1528l > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.f1529m.n(this.f1523g));
            float xVelocity = this.f1536t.getXVelocity(this.f1528l);
            float yVelocity = this.f1536t.getYVelocity(this.f1528l);
            int i12 = yVelocity > 0.0f ? 2 : 1;
            float fAbs = Math.abs(yVelocity);
            if ((i12 & i10) != 0 && i12 == i11 && fAbs >= this.f1529m.l(this.f1522f) && fAbs > Math.abs(xVelocity)) {
                return i12;
            }
        }
        float height = this.f1534r.getHeight() * this.f1529m.m(c0Var);
        if ((i10 & i11) == 0 || Math.abs(this.f1525i) <= height) {
            return 0;
        }
        return i11;
    }

    public void r(RecyclerView.c0 c0Var, boolean z10) {
        for (int size = this.f1532p.size() - 1; size >= 0; size--) {
            h hVar = (h) this.f1532p.get(size);
            if (hVar.f1561e == c0Var) {
                hVar.f1568l |= z10;
                if (!hVar.f1569m) {
                    hVar.a();
                }
                this.f1532p.remove(size);
                return;
            }
        }
    }

    public h s(MotionEvent motionEvent) {
        if (this.f1532p.isEmpty()) {
            return null;
        }
        View viewT = t(motionEvent);
        for (int size = this.f1532p.size() - 1; size >= 0; size--) {
            h hVar = (h) this.f1532p.get(size);
            if (hVar.f1561e.f1219a == viewT) {
                return hVar;
            }
        }
        return null;
    }

    public View t(MotionEvent motionEvent) {
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        RecyclerView.c0 c0Var = this.f1519c;
        if (c0Var != null) {
            View view = c0Var.f1219a;
            if (y(view, x10, y10, this.f1526j + this.f1524h, this.f1527k + this.f1525i)) {
                return view;
            }
        }
        for (int size = this.f1532p.size() - 1; size >= 0; size--) {
            h hVar = (h) this.f1532p.get(size);
            View view2 = hVar.f1561e.f1219a;
            if (y(view2, x10, y10, hVar.f1566j, hVar.f1567k)) {
                return view2;
            }
        }
        return this.f1534r.V(x10, y10);
    }

    public final List u(RecyclerView.c0 c0Var) {
        RecyclerView.c0 c0Var2 = c0Var;
        List list = this.f1537u;
        if (list == null) {
            this.f1537u = new ArrayList();
            this.f1538v = new ArrayList();
        } else {
            list.clear();
            this.f1538v.clear();
        }
        int iH = this.f1529m.h();
        int iRound = Math.round(this.f1526j + this.f1524h) - iH;
        int iRound2 = Math.round(this.f1527k + this.f1525i) - iH;
        int i10 = iH * 2;
        int width = c0Var2.f1219a.getWidth() + iRound + i10;
        int height = c0Var2.f1219a.getHeight() + iRound2 + i10;
        int i11 = (iRound + width) / 2;
        int i12 = (iRound2 + height) / 2;
        RecyclerView.o layoutManager = this.f1534r.getLayoutManager();
        int iK = layoutManager.K();
        int i13 = 0;
        while (i13 < iK) {
            View viewJ = layoutManager.J(i13);
            if (viewJ != c0Var2.f1219a && viewJ.getBottom() >= iRound2 && viewJ.getTop() <= height && viewJ.getRight() >= iRound && viewJ.getLeft() <= width) {
                RecyclerView.c0 c0VarK0 = this.f1534r.k0(viewJ);
                if (this.f1529m.a(this.f1534r, this.f1519c, c0VarK0)) {
                    int iAbs = Math.abs(i11 - ((viewJ.getLeft() + viewJ.getRight()) / 2));
                    int iAbs2 = Math.abs(i12 - ((viewJ.getTop() + viewJ.getBottom()) / 2));
                    int i14 = (iAbs * iAbs) + (iAbs2 * iAbs2);
                    int size = this.f1537u.size();
                    int i15 = 0;
                    for (int i16 = 0; i16 < size && i14 > ((Integer) this.f1538v.get(i16)).intValue(); i16++) {
                        i15++;
                    }
                    this.f1537u.add(i15, c0VarK0);
                    this.f1538v.add(i15, Integer.valueOf(i14));
                }
            }
            i13++;
            c0Var2 = c0Var;
        }
        return this.f1537u;
    }

    public final RecyclerView.c0 v(MotionEvent motionEvent) {
        View viewT;
        RecyclerView.o layoutManager = this.f1534r.getLayoutManager();
        int i10 = this.f1528l;
        if (i10 == -1) {
            return null;
        }
        int iFindPointerIndex = motionEvent.findPointerIndex(i10);
        float x10 = motionEvent.getX(iFindPointerIndex) - this.f1520d;
        float y10 = motionEvent.getY(iFindPointerIndex) - this.f1521e;
        float fAbs = Math.abs(x10);
        float fAbs2 = Math.abs(y10);
        int i11 = this.f1533q;
        if (fAbs < i11 && fAbs2 < i11) {
            return null;
        }
        if (fAbs > fAbs2 && layoutManager.l()) {
            return null;
        }
        if ((fAbs2 <= fAbs || !layoutManager.m()) && (viewT = t(motionEvent)) != null) {
            return this.f1534r.k0(viewT);
        }
        return null;
    }

    public final void w(float[] fArr) {
        if ((this.f1531o & 12) != 0) {
            fArr[0] = (this.f1526j + this.f1524h) - this.f1519c.f1219a.getLeft();
        } else {
            fArr[0] = this.f1519c.f1219a.getTranslationX();
        }
        if ((this.f1531o & 3) != 0) {
            fArr[1] = (this.f1527k + this.f1525i) - this.f1519c.f1219a.getTop();
        } else {
            fArr[1] = this.f1519c.f1219a.getTranslationY();
        }
    }

    public boolean x() {
        int size = this.f1532p.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!((h) this.f1532p.get(i10)).f1569m) {
                return true;
            }
        }
        return false;
    }

    public void z(RecyclerView.c0 c0Var) {
        if (!this.f1534r.isLayoutRequested() && this.f1530n == 2) {
            float fJ = this.f1529m.j(c0Var);
            int i10 = (int) (this.f1526j + this.f1524h);
            int i11 = (int) (this.f1527k + this.f1525i);
            if (Math.abs(i11 - c0Var.f1219a.getTop()) >= c0Var.f1219a.getHeight() * fJ || Math.abs(i10 - c0Var.f1219a.getLeft()) >= c0Var.f1219a.getWidth() * fJ) {
                List listU = u(c0Var);
                if (listU.size() == 0) {
                    return;
                }
                RecyclerView.c0 c0VarB = this.f1529m.b(c0Var, listU, i10, i11);
                if (c0VarB == null) {
                    this.f1537u.clear();
                    this.f1538v.clear();
                    return;
                }
                int iJ = c0VarB.j();
                int iJ2 = c0Var.j();
                if (this.f1529m.y(this.f1534r, c0Var, c0VarB)) {
                    this.f1529m.z(this.f1534r, c0Var, iJ2, c0VarB, iJ, i10, i11);
                }
            }
        }
    }
}
