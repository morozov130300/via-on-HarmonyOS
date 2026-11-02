package androidx.recyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class h extends RecyclerView.n implements RecyclerView.s {
    public static final int[] D = {R.attr.state_pressed};
    public static final int[] E = new int[0];
    public int A;
    public final Runnable B;
    public final RecyclerView.t C;

    /* renamed from: a, reason: collision with root package name */
    public final int f1471a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1472b;

    /* renamed from: c, reason: collision with root package name */
    public final StateListDrawable f1473c;

    /* renamed from: d, reason: collision with root package name */
    public final Drawable f1474d;

    /* renamed from: e, reason: collision with root package name */
    public final int f1475e;

    /* renamed from: f, reason: collision with root package name */
    public final int f1476f;

    /* renamed from: g, reason: collision with root package name */
    public final StateListDrawable f1477g;

    /* renamed from: h, reason: collision with root package name */
    public final Drawable f1478h;

    /* renamed from: i, reason: collision with root package name */
    public final int f1479i;

    /* renamed from: j, reason: collision with root package name */
    public final int f1480j;

    /* renamed from: k, reason: collision with root package name */
    public int f1481k;

    /* renamed from: l, reason: collision with root package name */
    public int f1482l;

    /* renamed from: m, reason: collision with root package name */
    public float f1483m;

    /* renamed from: n, reason: collision with root package name */
    public int f1484n;

    /* renamed from: o, reason: collision with root package name */
    public int f1485o;

    /* renamed from: p, reason: collision with root package name */
    public float f1486p;

    /* renamed from: s, reason: collision with root package name */
    public RecyclerView f1489s;

    /* renamed from: z, reason: collision with root package name */
    public final ValueAnimator f1496z;

    /* renamed from: q, reason: collision with root package name */
    public int f1487q = 0;

    /* renamed from: r, reason: collision with root package name */
    public int f1488r = 0;

    /* renamed from: t, reason: collision with root package name */
    public boolean f1490t = false;

    /* renamed from: u, reason: collision with root package name */
    public boolean f1491u = false;

    /* renamed from: v, reason: collision with root package name */
    public int f1492v = 0;

    /* renamed from: w, reason: collision with root package name */
    public int f1493w = 0;

    /* renamed from: x, reason: collision with root package name */
    public final int[] f1494x = new int[2];

    /* renamed from: y, reason: collision with root package name */
    public final int[] f1495y = new int[2];

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.s(500);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b extends RecyclerView.t {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i10, int i11) {
            h.this.D(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public boolean f1499a = false;

        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f1499a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f1499a) {
                this.f1499a = false;
                return;
            }
            if (((Float) h.this.f1496z.getAnimatedValue()).floatValue() == 0.0f) {
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

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            h.this.f1473c.setAlpha(iFloatValue);
            h.this.f1474d.setAlpha(iFloatValue);
            h.this.x();
        }
    }

    public h(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i10, int i11, int i12) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f1496z = valueAnimatorOfFloat;
        this.A = 0;
        this.B = new a();
        this.C = new b();
        this.f1473c = stateListDrawable;
        this.f1474d = drawable;
        this.f1477g = stateListDrawable2;
        this.f1478h = drawable2;
        this.f1475e = Math.max(i10, stateListDrawable.getIntrinsicWidth());
        this.f1476f = Math.max(i10, drawable.getIntrinsicWidth());
        this.f1479i = Math.max(i10, stateListDrawable2.getIntrinsicWidth());
        this.f1480j = Math.max(i10, drawable2.getIntrinsicWidth());
        this.f1471a = i11;
        this.f1472b = i12;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        valueAnimatorOfFloat.addListener(new c());
        valueAnimatorOfFloat.addUpdateListener(new d());
        l(recyclerView);
    }

    public void A(int i10) {
        if (i10 == 2 && this.f1492v != 2) {
            this.f1473c.setState(D);
            m();
        }
        if (i10 == 0) {
            x();
        } else {
            C();
        }
        if (this.f1492v == 2 && i10 != 2) {
            this.f1473c.setState(E);
            y(1200);
        } else if (i10 == 1) {
            y(1500);
        }
        this.f1492v = i10;
    }

    public final void B() {
        this.f1489s.k(this);
        this.f1489s.n(this);
        this.f1489s.o(this.C);
    }

    public void C() {
        int i10 = this.A;
        if (i10 != 0) {
            if (i10 != 3) {
                return;
            } else {
                this.f1496z.cancel();
            }
        }
        this.A = 1;
        ValueAnimator valueAnimator = this.f1496z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.f1496z.setDuration(500L);
        this.f1496z.setStartDelay(0L);
        this.f1496z.start();
    }

    public void D(int i10, int i11) {
        int iComputeVerticalScrollRange = this.f1489s.computeVerticalScrollRange();
        int i12 = this.f1488r;
        this.f1490t = iComputeVerticalScrollRange - i12 > 0 && i12 >= this.f1471a;
        int iComputeHorizontalScrollRange = this.f1489s.computeHorizontalScrollRange();
        int i13 = this.f1487q;
        boolean z10 = iComputeHorizontalScrollRange - i13 > 0 && i13 >= this.f1471a;
        this.f1491u = z10;
        boolean z11 = this.f1490t;
        if (!z11 && !z10) {
            if (this.f1492v != 0) {
                A(0);
                return;
            }
            return;
        }
        if (z11) {
            float f10 = i12;
            this.f1482l = (int) ((f10 * (i11 + (f10 / 2.0f))) / iComputeVerticalScrollRange);
            this.f1481k = Math.min(i12, (i12 * i12) / iComputeVerticalScrollRange);
        }
        if (this.f1491u) {
            float f11 = i13;
            this.f1485o = (int) ((f11 * (i10 + (f11 / 2.0f))) / iComputeHorizontalScrollRange);
            this.f1484n = Math.min(i13, (i13 * i13) / iComputeHorizontalScrollRange);
        }
        int i14 = this.f1492v;
        if (i14 == 0 || i14 == 1) {
            A(1);
        }
    }

    public final void E(float f10) {
        int[] iArrR = r();
        float fMax = Math.max(iArrR[0], Math.min(iArrR[1], f10));
        if (Math.abs(this.f1482l - fMax) < 2.0f) {
            return;
        }
        int iZ = z(this.f1483m, fMax, iArrR, this.f1489s.computeVerticalScrollRange(), this.f1489s.computeVerticalScrollOffset(), this.f1488r);
        if (iZ != 0) {
            this.f1489s.scrollBy(0, iZ);
        }
        this.f1483m = fMax;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f1492v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean zW = w(motionEvent.getX(), motionEvent.getY());
            boolean zV = v(motionEvent.getX(), motionEvent.getY());
            if (zW || zV) {
                if (zV) {
                    this.f1493w = 1;
                    this.f1486p = (int) motionEvent.getX();
                } else if (zW) {
                    this.f1493w = 2;
                    this.f1483m = (int) motionEvent.getY();
                }
                A(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.f1492v == 2) {
            this.f1483m = 0.0f;
            this.f1486p = 0.0f;
            A(1);
            this.f1493w = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.f1492v == 2) {
            C();
            if (this.f1493w == 1) {
                t(motionEvent.getX());
            }
            if (this.f1493w == 2) {
                E(motionEvent.getY());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public boolean c(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i10 = this.f1492v;
        if (i10 != 1) {
            return i10 == 2;
        }
        boolean zW = w(motionEvent.getX(), motionEvent.getY());
        boolean zV = v(motionEvent.getX(), motionEvent.getY());
        if (motionEvent.getAction() != 0 || (!zW && !zV)) {
            return false;
        }
        if (zV) {
            this.f1493w = 1;
            this.f1486p = (int) motionEvent.getX();
        } else if (zW) {
            this.f1493w = 2;
            this.f1483m = (int) motionEvent.getY();
        }
        A(2);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void e(boolean z10) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
        if (this.f1487q != this.f1489s.getWidth() || this.f1488r != this.f1489s.getHeight()) {
            this.f1487q = this.f1489s.getWidth();
            this.f1488r = this.f1489s.getHeight();
            A(0);
        } else if (this.A != 0) {
            if (this.f1490t) {
                p(canvas);
            }
            if (this.f1491u) {
                o(canvas);
            }
        }
    }

    public void l(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f1489s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            n();
        }
        this.f1489s = recyclerView;
        if (recyclerView != null) {
            B();
        }
    }

    public final void m() {
        this.f1489s.removeCallbacks(this.B);
    }

    public final void n() {
        this.f1489s.d1(this);
        this.f1489s.f1(this);
        this.f1489s.g1(this.C);
        m();
    }

    public final void o(Canvas canvas) {
        int i10 = this.f1488r;
        int i11 = this.f1479i;
        int i12 = this.f1485o;
        int i13 = this.f1484n;
        this.f1477g.setBounds(0, 0, i13, i11);
        this.f1478h.setBounds(0, 0, this.f1487q, this.f1480j);
        canvas.translate(0.0f, i10 - i11);
        this.f1478h.draw(canvas);
        canvas.translate(i12 - (i13 / 2), 0.0f);
        this.f1477g.draw(canvas);
        canvas.translate(-r2, -r0);
    }

    public final void p(Canvas canvas) {
        int i10 = this.f1487q;
        int i11 = this.f1475e;
        int i12 = i10 - i11;
        int i13 = this.f1482l;
        int i14 = this.f1481k;
        int i15 = i13 - (i14 / 2);
        this.f1473c.setBounds(0, 0, i11, i14);
        this.f1474d.setBounds(0, 0, this.f1476f, this.f1488r);
        if (!u()) {
            canvas.translate(i12, 0.0f);
            this.f1474d.draw(canvas);
            canvas.translate(0.0f, i15);
            this.f1473c.draw(canvas);
            canvas.translate(-i12, -i15);
            return;
        }
        this.f1474d.draw(canvas);
        canvas.translate(this.f1475e, i15);
        canvas.scale(-1.0f, 1.0f);
        this.f1473c.draw(canvas);
        canvas.scale(-1.0f, 1.0f);
        canvas.translate(-this.f1475e, -i15);
    }

    public final int[] q() {
        int[] iArr = this.f1495y;
        int i10 = this.f1472b;
        iArr[0] = i10;
        iArr[1] = this.f1487q - i10;
        return iArr;
    }

    public final int[] r() {
        int[] iArr = this.f1494x;
        int i10 = this.f1472b;
        iArr[0] = i10;
        iArr[1] = this.f1488r - i10;
        return iArr;
    }

    public void s(int i10) {
        int i11 = this.A;
        if (i11 == 1) {
            this.f1496z.cancel();
        } else if (i11 != 2) {
            return;
        }
        this.A = 3;
        ValueAnimator valueAnimator = this.f1496z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.f1496z.setDuration(i10);
        this.f1496z.start();
    }

    public final void t(float f10) {
        int[] iArrQ = q();
        float fMax = Math.max(iArrQ[0], Math.min(iArrQ[1], f10));
        if (Math.abs(this.f1485o - fMax) < 2.0f) {
            return;
        }
        int iZ = z(this.f1486p, fMax, iArrQ, this.f1489s.computeHorizontalScrollRange(), this.f1489s.computeHorizontalScrollOffset(), this.f1487q);
        if (iZ != 0) {
            this.f1489s.scrollBy(iZ, 0);
        }
        this.f1486p = fMax;
    }

    public final boolean u() {
        return x.r.v(this.f1489s) == 1;
    }

    public boolean v(float f10, float f11) {
        if (f11 < this.f1488r - this.f1479i) {
            return false;
        }
        int i10 = this.f1485o;
        int i11 = this.f1484n;
        return f10 >= ((float) (i10 - (i11 / 2))) && f10 <= ((float) (i10 + (i11 / 2)));
    }

    public boolean w(float f10, float f11) {
        if (u()) {
            if (f10 > this.f1475e) {
                return false;
            }
        } else if (f10 < this.f1487q - this.f1475e) {
            return false;
        }
        int i10 = this.f1482l;
        int i11 = this.f1481k;
        return f11 >= ((float) (i10 - (i11 / 2))) && f11 <= ((float) (i10 + (i11 / 2)));
    }

    public void x() {
        this.f1489s.invalidate();
    }

    public final void y(int i10) {
        m();
        this.f1489s.postDelayed(this.B, i10);
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
}
