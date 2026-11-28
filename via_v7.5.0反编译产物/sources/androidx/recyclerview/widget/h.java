package androidx.recyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class h extends RecyclerView.n implements RecyclerView.s {
    public static final int[] D = {R.attr.state_pressed};
    public static final int[] E = new int[0];
    public int A;
    public final Runnable B;
    public final RecyclerView.t C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StateListDrawable f1374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Drawable f1375d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f1376e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f1377f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final StateListDrawable f1378g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Drawable f1379h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f1380i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f1381j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1382k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1383l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f1384m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f1385n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f1386o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f1387p;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public RecyclerView f1390s;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ValueAnimator f1397z;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f1388q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f1389r = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f1391t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f1392u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f1393v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f1394w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int[] f1395x = new int[2];

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int[] f1396y = new int[2];

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.s(500);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends RecyclerView.t {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i10, int i11) {
            h.this.D(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1400a = false;

        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f1400a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f1400a) {
                this.f1400a = false;
                return;
            }
            if (((Float) h.this.f1397z.getAnimatedValue()).floatValue() == 0.0f) {
                h hVar = h.this;
                hVar.A = 0;
                hVar.A(0);
            } else {
                h hVar2 = h.this;
                hVar2.A = 2;
                hVar2.x();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            h.this.f1374c.setAlpha(iFloatValue);
            h.this.f1375d.setAlpha(iFloatValue);
            h.this.x();
        }
    }

    public h(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i10, int i11, int i12) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f1397z = valueAnimatorOfFloat;
        this.A = 0;
        this.B = new a();
        this.C = new b();
        this.f1374c = stateListDrawable;
        this.f1375d = drawable;
        this.f1378g = stateListDrawable2;
        this.f1379h = drawable2;
        this.f1376e = Math.max(i10, stateListDrawable.getIntrinsicWidth());
        this.f1377f = Math.max(i10, drawable.getIntrinsicWidth());
        this.f1380i = Math.max(i10, stateListDrawable2.getIntrinsicWidth());
        this.f1381j = Math.max(i10, drawable2.getIntrinsicWidth());
        this.f1372a = i11;
        this.f1373b = i12;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        valueAnimatorOfFloat.addListener(new c());
        valueAnimatorOfFloat.addUpdateListener(new d());
        l(recyclerView);
    }

    public void A(int i10) {
        if (i10 == 2 && this.f1393v != 2) {
            this.f1374c.setState(D);
            m();
        }
        if (i10 == 0) {
            x();
        } else {
            C();
        }
        if (this.f1393v == 2 && i10 != 2) {
            this.f1374c.setState(E);
            y(1200);
        } else if (i10 == 1) {
            y(1500);
        }
        this.f1393v = i10;
    }

    public final void B() {
        this.f1390s.k(this);
        this.f1390s.n(this);
        this.f1390s.o(this.C);
    }

    public void C() {
        int i10 = this.A;
        if (i10 != 0) {
            if (i10 != 3) {
                return;
            } else {
                this.f1397z.cancel();
            }
        }
        this.A = 1;
        ValueAnimator valueAnimator = this.f1397z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.f1397z.setDuration(500L);
        this.f1397z.setStartDelay(0L);
        this.f1397z.start();
    }

    public void D(int i10, int i11) {
        int iComputeVerticalScrollRange = this.f1390s.computeVerticalScrollRange();
        int i12 = this.f1389r;
        this.f1391t = iComputeVerticalScrollRange - i12 > 0 && i12 >= this.f1372a;
        int iComputeHorizontalScrollRange = this.f1390s.computeHorizontalScrollRange();
        int i13 = this.f1388q;
        boolean z10 = iComputeHorizontalScrollRange - i13 > 0 && i13 >= this.f1372a;
        this.f1392u = z10;
        boolean z11 = this.f1391t;
        if (!z11 && !z10) {
            if (this.f1393v != 0) {
                A(0);
                return;
            }
            return;
        }
        if (z11) {
            float f10 = i12;
            this.f1383l = (int) ((f10 * (i11 + (f10 / 2.0f))) / iComputeVerticalScrollRange);
            this.f1382k = Math.min(i12, (i12 * i12) / iComputeVerticalScrollRange);
        }
        if (this.f1392u) {
            float f11 = i13;
            this.f1386o = (int) ((f11 * (i10 + (f11 / 2.0f))) / iComputeHorizontalScrollRange);
            this.f1385n = Math.min(i13, (i13 * i13) / iComputeHorizontalScrollRange);
        }
        int i14 = this.f1393v;
        if (i14 == 0 || i14 == 1) {
            A(1);
        }
    }

    public final void E(float f10) {
        int[] iArrR = r();
        float fMax = Math.max(iArrR[0], Math.min(iArrR[1], f10));
        if (Math.abs(this.f1383l - fMax) < 2.0f) {
            return;
        }
        int iZ = z(this.f1384m, fMax, iArrR, this.f1390s.computeVerticalScrollRange(), this.f1390s.computeVerticalScrollOffset(), this.f1389r);
        if (iZ != 0) {
            this.f1390s.scrollBy(0, iZ);
        }
        this.f1384m = fMax;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f1393v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean zW = w(motionEvent.getX(), motionEvent.getY());
            boolean zV = v(motionEvent.getX(), motionEvent.getY());
            if (zW || zV) {
                if (zV) {
                    this.f1394w = 1;
                    this.f1387p = (int) motionEvent.getX();
                } else if (zW) {
                    this.f1394w = 2;
                    this.f1384m = (int) motionEvent.getY();
                }
                A(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.f1393v == 2) {
            this.f1384m = 0.0f;
            this.f1387p = 0.0f;
            A(1);
            this.f1394w = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.f1393v == 2) {
            C();
            if (this.f1394w == 1) {
                t(motionEvent.getX());
            }
            if (this.f1394w == 2) {
                E(motionEvent.getY());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public boolean c(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i10 = this.f1393v;
        if (i10 != 1) {
            return i10 == 2;
        }
        boolean zW = w(motionEvent.getX(), motionEvent.getY());
        boolean zV = v(motionEvent.getX(), motionEvent.getY());
        if (motionEvent.getAction() != 0 || (!zW && !zV)) {
            return false;
        }
        if (zV) {
            this.f1394w = 1;
            this.f1387p = (int) motionEvent.getX();
        } else if (zW) {
            this.f1394w = 2;
            this.f1384m = (int) motionEvent.getY();
        }
        A(2);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        if (this.f1388q != this.f1390s.getWidth() || this.f1389r != this.f1390s.getHeight()) {
            this.f1388q = this.f1390s.getWidth();
            this.f1389r = this.f1390s.getHeight();
            A(0);
        } else if (this.A != 0) {
            if (this.f1391t) {
                p(canvas);
            }
            if (this.f1392u) {
                o(canvas);
            }
        }
    }

    public void l(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f1390s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            n();
        }
        this.f1390s = recyclerView;
        if (recyclerView != null) {
            B();
        }
    }

    public final void m() {
        this.f1390s.removeCallbacks(this.B);
    }

    public final void n() {
        this.f1390s.d1(this);
        this.f1390s.f1(this);
        this.f1390s.g1(this.C);
        m();
    }

    public final void o(Canvas canvas) {
        int i10 = this.f1389r;
        int i11 = this.f1380i;
        int i12 = i10 - i11;
        int i13 = this.f1386o;
        int i14 = this.f1385n;
        int i15 = i13 - (i14 / 2);
        this.f1378g.setBounds(0, 0, i14, i11);
        this.f1379h.setBounds(0, 0, this.f1388q, this.f1381j);
        canvas.translate(0.0f, i12);
        this.f1379h.draw(canvas);
        canvas.translate(i15, 0.0f);
        this.f1378g.draw(canvas);
        canvas.translate(-i15, -i12);
    }

    public final void p(Canvas canvas) {
        int i10 = this.f1388q;
        int i11 = this.f1376e;
        int i12 = i10 - i11;
        int i13 = this.f1383l;
        int i14 = this.f1382k;
        int i15 = i13 - (i14 / 2);
        this.f1374c.setBounds(0, 0, i11, i14);
        this.f1375d.setBounds(0, 0, this.f1377f, this.f1389r);
        if (!u()) {
            canvas.translate(i12, 0.0f);
            this.f1375d.draw(canvas);
            canvas.translate(0.0f, i15);
            this.f1374c.draw(canvas);
            canvas.translate(-i12, -i15);
            return;
        }
        this.f1375d.draw(canvas);
        canvas.translate(this.f1376e, i15);
        canvas.scale(-1.0f, 1.0f);
        this.f1374c.draw(canvas);
        canvas.scale(-1.0f, 1.0f);
        canvas.translate(-this.f1376e, -i15);
    }

    public final int[] q() {
        int[] iArr = this.f1396y;
        int i10 = this.f1373b;
        iArr[0] = i10;
        iArr[1] = this.f1388q - i10;
        return iArr;
    }

    public final int[] r() {
        int[] iArr = this.f1395x;
        int i10 = this.f1373b;
        iArr[0] = i10;
        iArr[1] = this.f1389r - i10;
        return iArr;
    }

    public void s(int i10) {
        int i11 = this.A;
        if (i11 == 1) {
            this.f1397z.cancel();
        } else if (i11 != 2) {
            return;
        }
        this.A = 3;
        ValueAnimator valueAnimator = this.f1397z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.f1397z.setDuration(i10);
        this.f1397z.start();
    }

    public final void t(float f10) {
        int[] iArrQ = q();
        float fMax = Math.max(iArrQ[0], Math.min(iArrQ[1], f10));
        if (Math.abs(this.f1386o - fMax) < 2.0f) {
            return;
        }
        int iZ = z(this.f1387p, fMax, iArrQ, this.f1390s.computeHorizontalScrollRange(), this.f1390s.computeHorizontalScrollOffset(), this.f1388q);
        if (iZ != 0) {
            this.f1390s.scrollBy(iZ, 0);
        }
        this.f1387p = fMax;
    }

    public final boolean u() {
        return y.r.v(this.f1390s) == 1;
    }

    public boolean v(float f10, float f11) {
        if (f11 < this.f1389r - this.f1380i) {
            return false;
        }
        int i10 = this.f1386o;
        int i11 = this.f1385n;
        return f10 >= ((float) (i10 - (i11 / 2))) && f10 <= ((float) (i10 + (i11 / 2)));
    }

    public boolean w(float f10, float f11) {
        if (u()) {
            if (f10 > this.f1376e) {
                return false;
            }
        } else if (f10 < this.f1388q - this.f1376e) {
            return false;
        }
        int i10 = this.f1383l;
        int i11 = this.f1382k;
        return f11 >= ((float) (i10 - (i11 / 2))) && f11 <= ((float) (i10 + (i11 / 2)));
    }

    public void x() {
        this.f1390s.invalidate();
    }

    public final void y(int i10) {
        m();
        this.f1390s.postDelayed(this.B, i10);
    }

    public final int z(float f10, float f11, int[] iArr, int i10, int i11, int i12) {
        int i13 = iArr[1] - iArr[0];
        if (i13 == 0) {
            return 0;
        }
        int i14 = i10 - i12;
        int i15 = (int) (((f11 - f10) / i13) * i14);
        int i16 = i11 + i15;
        if (i16 >= i14 || i16 < 0) {
            return 0;
        }
        return i15;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void e(boolean z10) {
    }
}
