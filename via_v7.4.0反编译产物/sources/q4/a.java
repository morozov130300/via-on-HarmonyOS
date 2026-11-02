package q4;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Interpolator;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a {

    /* renamed from: n, reason: collision with root package name */
    public static long f11283n = 1500;

    /* renamed from: o, reason: collision with root package name */
    public static final int[] f11284o = {R.attr.state_pressed};

    /* renamed from: p, reason: collision with root package name */
    public static final int[] f11285p = new int[0];

    /* renamed from: q, reason: collision with root package name */
    public static int f11286q = 20;

    /* renamed from: r, reason: collision with root package name */
    public static int f11287r = 32;

    /* renamed from: s, reason: collision with root package name */
    public static int f11288s = 4;

    /* renamed from: t, reason: collision with root package name */
    public static int f11289t = 4;

    /* renamed from: u, reason: collision with root package name */
    public static int f11290u = -2139062144;

    /* renamed from: v, reason: collision with root package name */
    public static int f11291v = -16537100;

    /* renamed from: w, reason: collision with root package name */
    public static int f11292w = 72;

    /* renamed from: x, reason: collision with root package name */
    public static int f11293x = 24;

    /* renamed from: y, reason: collision with root package name */
    public static int f11294y = 36;

    /* renamed from: z, reason: collision with root package name */
    public static int f11295z = R.style.Animation.Dialog;

    /* renamed from: a, reason: collision with root package name */
    public final View f11296a;

    /* renamed from: b, reason: collision with root package name */
    public final float f11297b;

    /* renamed from: c, reason: collision with root package name */
    public float f11298c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f11299d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f11300e;

    /* renamed from: f, reason: collision with root package name */
    public final c f11301f;

    /* renamed from: g, reason: collision with root package name */
    public int f11302g;

    /* renamed from: h, reason: collision with root package name */
    public final d f11303h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f11304i;

    /* renamed from: j, reason: collision with root package name */
    public float f11305j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f11306k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f11307l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f11308m;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final float f11309a;

        /* renamed from: b, reason: collision with root package name */
        public final c f11310b;

        /* renamed from: f, reason: collision with root package name */
        public Drawable f11314f;

        /* renamed from: j, reason: collision with root package name */
        public boolean f11318j;

        /* renamed from: e, reason: collision with root package name */
        public boolean f11313e = true;

        /* renamed from: g, reason: collision with root package name */
        public int f11315g = a.f11290u;

        /* renamed from: h, reason: collision with root package name */
        public int f11316h = a.f11291v;

        /* renamed from: c, reason: collision with root package name */
        public int f11311c = b(a.f11286q);

        /* renamed from: d, reason: collision with root package name */
        public int f11312d = b(a.f11287r);

        /* renamed from: i, reason: collision with root package name */
        public float f11317i = 0.0f;

        public b(c cVar) {
            this.f11310b = cVar;
            this.f11309a = cVar.getFastScrollableView().getContext().getResources().getDisplayMetrics().density;
        }

        public a a() {
            if (this.f11314f == null) {
                this.f11314f = c();
            }
            return new a(this.f11310b, this.f11311c, this.f11312d, this.f11314f, this.f11313e, this.f11317i, this.f11318j);
        }

        public int b(float f10) {
            return (int) ((f10 * this.f11309a) + 0.5f);
        }

        public final Drawable c() {
            StateListDrawable stateListDrawable = new StateListDrawable();
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(this.f11316h);
            float f10 = this.f11311c / 2.0f;
            int iB = b(a.f11289t);
            int iB2 = (this.f11311c - iB) - b(a.f11288s);
            gradientDrawable.setCornerRadius(f10);
            stateListDrawable.addState(a.f11284o, new InsetDrawable((Drawable) gradientDrawable, iB2, iB, iB, iB));
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(this.f11315g);
            gradientDrawable2.setCornerRadius(f10);
            stateListDrawable.addState(a.f11285p, new InsetDrawable((Drawable) gradientDrawable2, iB2, iB, iB, iB));
            return stateListDrawable;
        }

        public b d(boolean z10) {
            this.f11318j = z10;
            return this;
        }

        public b e(float f10) {
            this.f11317i = f10;
            return this;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface c {
        int a();

        void b(MotionEvent motionEvent);

        int c();

        int d();

        a getFastScrollDelegate();

        View getFastScrollableView();
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class d implements Runnable {

        /* renamed from: p, reason: collision with root package name */
        public static final float[] f11319p = {255.0f};

        /* renamed from: q, reason: collision with root package name */
        public static final float[] f11320q = {0.0f};

        /* renamed from: k, reason: collision with root package name */
        public float[] f11323k;

        /* renamed from: l, reason: collision with root package name */
        public View f11324l;

        /* renamed from: n, reason: collision with root package name */
        public long f11326n;

        /* renamed from: m, reason: collision with root package name */
        public final Interpolator f11325m = new Interpolator(1, 2);

        /* renamed from: o, reason: collision with root package name */
        public int f11327o = 0;

        /* renamed from: e, reason: collision with root package name */
        public final int f11321e = ViewConfiguration.getScrollDefaultDelay();

        /* renamed from: j, reason: collision with root package name */
        public final int f11322j = ViewConfiguration.getScrollBarFadeDuration();

        public d(ViewConfiguration viewConfiguration, View view) {
            this.f11324l = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (jCurrentAnimationTimeMillis >= this.f11326n) {
                int i10 = (int) jCurrentAnimationTimeMillis;
                Interpolator interpolator = this.f11325m;
                interpolator.setKeyFrame(0, i10, f11319p);
                interpolator.setKeyFrame(1, i10 + this.f11322j, f11320q);
                this.f11327o = 2;
                this.f11324l.invalidate();
            }
        }
    }

    public a(c cVar, int i10, int i11, Drawable drawable, boolean z10, float f10, boolean z11) {
        this.f11306k = false;
        this.f11307l = false;
        this.f11308m = false;
        View fastScrollableView = cVar.getFastScrollableView();
        this.f11296a = fastScrollableView;
        fastScrollableView.setVerticalScrollBarEnabled(false);
        Context context = fastScrollableView.getContext();
        this.f11305j = f10;
        this.f11297b = context.getResources().getDisplayMetrics().density;
        this.f11302g = f(f11287r);
        this.f11299d = new Rect(0, 0, i10, i11);
        this.f11300e = drawable;
        this.f11301f = cVar;
        this.f11303h = new d(ViewConfiguration.get(context), fastScrollableView);
        this.f11304i = z10;
        this.f11308m = z11;
    }

    public boolean c() {
        return d(f11283n);
    }

    public boolean d(long j10) {
        this.f11296a.postInvalidateOnAnimation();
        if (this.f11306k) {
            return false;
        }
        if (this.f11303h.f11327o == 0) {
            j10 = Math.max(750L, j10);
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() + j10;
        d dVar = this.f11303h;
        dVar.f11326n = jCurrentAnimationTimeMillis;
        dVar.f11327o = 1;
        this.f11296a.removeCallbacks(dVar);
        this.f11296a.postDelayed(this.f11303h, jCurrentAnimationTimeMillis - AnimationUtils.currentAnimationTimeMillis());
        return false;
    }

    public void e(Canvas canvas) {
        k(canvas);
    }

    public final int f(float f10) {
        return (int) ((this.f11297b * f10) + 0.5f);
    }

    public final boolean g() {
        return false;
    }

    public boolean h() {
        return this.f11306k;
    }

    public void i() {
        g();
    }

    public void j() {
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k(Canvas canvas) {
        boolean z10;
        if (this.f11306k) {
            this.f11300e.setAlpha(255);
        } else {
            d dVar = this.f11303h;
            int i10 = dVar.f11327o;
            if (i10 == 0) {
                return;
            }
            if (i10 == 2) {
                z10 = true;
                if (dVar.f11323k == null) {
                    dVar.f11323k = new float[1];
                }
                float[] fArr = dVar.f11323k;
                if (dVar.f11325m.timeToValues(fArr) == Interpolator.Result.FREEZE_END) {
                    dVar.f11327o = 0;
                } else {
                    this.f11300e.setAlpha(Math.round(fArr[0]));
                }
                if (x(0)) {
                    int scrollY = this.f11296a.getScrollY();
                    int scrollX = this.f11296a.getScrollX();
                    Drawable drawable = this.f11300e;
                    Rect rect = this.f11299d;
                    drawable.setBounds(rect.left + scrollX, rect.top + scrollY, rect.right + scrollX, rect.bottom + scrollY);
                    this.f11300e.draw(canvas);
                }
                if (z10) {
                    return;
                }
                this.f11296a.invalidate();
                return;
            }
            this.f11300e.setAlpha(255);
        }
        z10 = false;
        if (x(0)) {
        }
        if (z10) {
        }
    }

    public boolean l(MotionEvent motionEvent) {
        return m(motionEvent);
    }

    public final boolean m(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            return o(motionEvent);
        }
        return false;
    }

    public boolean n(MotionEvent motionEvent) {
        return o(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean o(MotionEvent motionEvent) {
        int iRound;
        int actionMasked = motionEvent.getActionMasked();
        float y10 = motionEvent.getY();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                if (this.f11306k) {
                    r(false);
                    this.f11306k = false;
                    c();
                    if (actionMasked == 1 && !this.f11307l) {
                        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                        motionEventObtain.setAction(0);
                        this.f11301f.b(motionEventObtain);
                        this.f11301f.b(motionEvent);
                        motionEventObtain.recycle();
                    }
                }
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                }
            } else if (this.f11306k && (iRound = Math.round(y10 - this.f11298c)) != 0) {
                if (this.f11307l) {
                    x(iRound);
                    this.f11298c = y10;
                } else {
                    float fAbs = Math.abs(iRound);
                    float f10 = this.f11305j;
                    if (fAbs > f10) {
                        x((int) (iRound > 0 ? iRound - f10 : iRound + f10));
                        this.f11307l = true;
                        this.f11298c = y10;
                    }
                }
            }
        } else {
            if (this.f11303h.f11327o == 0) {
                this.f11306k = false;
                return false;
            }
            if (!this.f11306k) {
                this.f11307l = false;
                x(0);
                float x10 = motionEvent.getX();
                Rect rect = this.f11299d;
                if (y10 >= rect.top && y10 <= rect.bottom && x10 >= rect.left && x10 <= rect.right) {
                    this.f11306k = true;
                    this.f11298c = y10;
                    this.f11301f.b(motionEvent);
                    MotionEvent motionEventObtain2 = MotionEvent.obtain(motionEvent);
                    motionEventObtain2.setAction(3);
                    this.f11301f.b(motionEventObtain2);
                    motionEventObtain2.recycle();
                    r(true);
                    y(0, true);
                    this.f11296a.removeCallbacks(this.f11303h);
                }
            }
        }
        if (!this.f11306k) {
            return false;
        }
        this.f11296a.invalidate();
        this.f11296a.getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    }

    public void p(View view, int i10) {
        if (i10 == 0 && this.f11296a.isAttachedToWindow()) {
            g();
        }
    }

    public void q(int i10) {
        if (i10 == 0) {
            g();
        }
    }

    public final void r(boolean z10) {
        this.f11300e.setState(z10 ? f11284o : f11285p);
        this.f11296a.invalidate();
    }

    public void s(boolean z10) {
        if (this.f11308m == z10) {
            return;
        }
        this.f11308m = z10;
        x(0);
    }

    public void t(Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("drawable == null");
        }
        this.f11300e = drawable;
        x(0);
    }

    public void u(boolean z10) {
        if (this.f11304i != z10) {
            this.f11304i = z10;
            x(0);
        }
    }

    public void v(int i10, int i11) {
        Rect rect = this.f11299d;
        rect.left = rect.right - f(i10);
        this.f11302g = f(i11);
        x(0);
    }

    public void w(int i10) {
        this.f11305j = Math.max(0, i10);
    }

    public final boolean x(int i10) {
        return y(i10, false);
    }

    public final boolean y(int i10, boolean z10) {
        int iA = this.f11301f.a();
        if (iA <= 0) {
            return false;
        }
        int iD = this.f11301f.d();
        int iC = this.f11301f.c();
        int i11 = iA - iC;
        int height = this.f11296a.getHeight();
        if (i11 <= height) {
            return false;
        }
        float f10 = i11;
        float f11 = (iD * 1.0f) / f10;
        float f12 = (iC * 1.0f) / iA;
        int iWidth = this.f11299d.width();
        if (this.f11308m) {
            Rect rect = this.f11299d;
            rect.left = 0;
            rect.right = iWidth;
        } else {
            this.f11299d.right = this.f11296a.getWidth();
            Rect rect2 = this.f11299d;
            rect2.left = rect2.right - iWidth;
        }
        int iMax = this.f11304i ? Math.max(this.f11302g, Math.round(Math.min(f12, 0.25f) * height)) : this.f11302g;
        Rect rect3 = this.f11299d;
        rect3.bottom = rect3.top + iMax;
        int i12 = height - iMax;
        float f13 = i12;
        int iRound = Math.round(f11 * f13);
        Rect rect4 = this.f11299d;
        rect4.offsetTo(rect4.left, iRound);
        if (i10 == 0) {
            return true;
        }
        int i13 = iRound + i10;
        if (i13 <= i12) {
            i12 = i13 < 0 ? 0 : i13;
        }
        int iRound2 = Math.round(f10 * ((i12 * 1.0f) / f13)) - iD;
        View view = this.f11296a;
        if (view instanceof AbsListView) {
            ((AbsListView) view).smoothScrollBy(iRound2, 0);
            return true;
        }
        view.scrollBy(0, iRound2);
        return true;
    }
}
