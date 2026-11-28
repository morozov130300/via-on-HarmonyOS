package r5;

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

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static long f11996n = 1500;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int[] f11997o = {R.attr.state_pressed};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int[] f11998p = new int[0];

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static int f11999q = 20;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static int f12000r = 32;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static int f12001s = 4;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static int f12002t = 4;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static int f12003u = -2139062144;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static int f12004v = -16537100;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static int f12005w = 72;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static int f12006x = 24;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static int f12007y = 36;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static int f12008z = R.style.Animation.Dialog;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f12009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f12010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f12011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f12012d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f12013e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f12014f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12015g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f12016h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f12017i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f12018j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f12019k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f12020l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f12021m;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f12022a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c f12023b;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Drawable f12027f;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f12031j;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f12026e = true;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f12028g = a.f12003u;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f12029h = a.f12004v;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f12024c = b(a.f11999q);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f12025d = b(a.f12000r);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f12030i = 0.0f;

        public b(c cVar) {
            this.f12023b = cVar;
            this.f12022a = cVar.getFastScrollableView().getContext().getResources().getDisplayMetrics().density;
        }

        public a a() {
            if (this.f12027f == null) {
                this.f12027f = c();
            }
            return new a(this.f12023b, this.f12024c, this.f12025d, this.f12027f, this.f12026e, this.f12030i, this.f12031j);
        }

        public int b(float f10) {
            return (int) ((f10 * this.f12022a) + 0.5f);
        }

        public final Drawable c() {
            StateListDrawable stateListDrawable = new StateListDrawable();
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(this.f12029h);
            float f10 = this.f12024c / 2.0f;
            int iB = b(a.f12002t);
            int iB2 = (this.f12024c - iB) - b(a.f12001s);
            gradientDrawable.setCornerRadius(f10);
            stateListDrawable.addState(a.f11997o, new InsetDrawable((Drawable) gradientDrawable, iB2, iB, iB, iB));
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(this.f12028g);
            gradientDrawable2.setCornerRadius(f10);
            stateListDrawable.addState(a.f11998p, new InsetDrawable((Drawable) gradientDrawable2, iB2, iB, iB, iB));
            return stateListDrawable;
        }

        public b d(boolean z10) {
            this.f12031j = z10;
            return this;
        }

        public b e(float f10) {
            this.f12030i = f10;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface c {
        int a();

        void b(MotionEvent motionEvent);

        int c();

        int d();

        a getFastScrollDelegate();

        View getFastScrollableView();
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class d implements Runnable {

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final float[] f12032r = {255.0f};

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final float[] f12033s = {0.0f};

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float[] f12036m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public View f12037n;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public long f12039p;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final Interpolator f12038o = new Interpolator(1, 2);

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f12040q = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f12034c = ViewConfiguration.getScrollDefaultDelay();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f12035e = ViewConfiguration.getScrollBarFadeDuration();

        public d(ViewConfiguration viewConfiguration, View view) {
            this.f12037n = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (jCurrentAnimationTimeMillis >= this.f12039p) {
                int i10 = (int) jCurrentAnimationTimeMillis;
                Interpolator interpolator = this.f12038o;
                interpolator.setKeyFrame(0, i10, f12032r);
                interpolator.setKeyFrame(1, i10 + this.f12035e, f12033s);
                this.f12040q = 2;
                this.f12037n.invalidate();
            }
        }
    }

    public boolean c() {
        return d(f11996n);
    }

    public boolean d(long j10) {
        this.f12009a.postInvalidateOnAnimation();
        if (this.f12019k) {
            return false;
        }
        if (this.f12016h.f12040q == 0) {
            j10 = Math.max(750L, j10);
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() + j10;
        d dVar = this.f12016h;
        dVar.f12039p = jCurrentAnimationTimeMillis;
        dVar.f12040q = 1;
        this.f12009a.removeCallbacks(dVar);
        this.f12009a.postDelayed(this.f12016h, jCurrentAnimationTimeMillis - AnimationUtils.currentAnimationTimeMillis());
        return false;
    }

    public void e(Canvas canvas) {
        k(canvas);
    }

    public final int f(float f10) {
        return (int) ((this.f12010b * f10) + 0.5f);
    }

    public final boolean g() {
        return false;
    }

    public boolean h() {
        return this.f12019k;
    }

    public void i() {
        g();
    }

    public void j() {
        this.f12009a.removeCallbacks(this.f12016h);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0047  */
    /* JADX WARN: Code duplicated, block: B:23:0x006d  */
    /* JADX WARN: Code duplicated, block: B:25:? A[RETURN, SYNTHETIC] */
    public final void k(Canvas canvas) {
        boolean z10;
        if (!this.f12019k) {
            d dVar = this.f12016h;
            int i10 = dVar.f12040q;
            if (i10 == 0) {
                return;
            }
            if (i10 == 2) {
                z10 = true;
                if (dVar.f12036m == null) {
                    dVar.f12036m = new float[1];
                }
                float[] fArr = dVar.f12036m;
                if (dVar.f12038o.timeToValues(fArr) == Interpolator.Result.FREEZE_END) {
                    dVar.f12040q = 0;
                } else {
                    this.f12013e.setAlpha(Math.round(fArr[0]));
                }
            } else {
                this.f12013e.setAlpha(255);
            }
            if (x(0)) {
                int scrollY = this.f12009a.getScrollY();
                int scrollX = this.f12009a.getScrollX();
                Drawable drawable = this.f12013e;
                Rect rect = this.f12012d;
                drawable.setBounds(rect.left + scrollX, rect.top + scrollY, rect.right + scrollX, rect.bottom + scrollY);
                this.f12013e.draw(canvas);
            }
            if (z10) {
                this.f12009a.invalidate();
            }
        }
        this.f12013e.setAlpha(255);
        z10 = false;
        if (x(0)) {
            int scrollY2 = this.f12009a.getScrollY();
            int scrollX2 = this.f12009a.getScrollX();
            Drawable drawable2 = this.f12013e;
            Rect rect2 = this.f12012d;
            drawable2.setBounds(rect2.left + scrollX2, rect2.top + scrollY2, rect2.right + scrollX2, rect2.bottom + scrollY2);
            this.f12013e.draw(canvas);
        }
        if (z10) {
            this.f12009a.invalidate();
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

    /* JADX WARN: Code duplicated, block: B:24:0x004f  */
    /* JADX WARN: Code duplicated, block: B:26:0x0053  */
    public final boolean o(MotionEvent motionEvent) {
        int iRound;
        int actionMasked = motionEvent.getActionMasked();
        float y10 = motionEvent.getY();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                if (this.f12019k) {
                    r(false);
                    this.f12019k = false;
                    c();
                    if (actionMasked == 1 && !this.f12020l) {
                        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                        motionEventObtain.setAction(0);
                        this.f12014f.b(motionEventObtain);
                        this.f12014f.b(motionEvent);
                        motionEventObtain.recycle();
                    }
                }
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                    if (this.f12019k) {
                        r(false);
                        this.f12019k = false;
                        c();
                        if (actionMasked == 1) {
                            MotionEvent motionEventObtain2 = MotionEvent.obtain(motionEvent);
                            motionEventObtain2.setAction(0);
                            this.f12014f.b(motionEventObtain2);
                            this.f12014f.b(motionEvent);
                            motionEventObtain2.recycle();
                        }
                    }
                }
            } else if (this.f12019k && (iRound = Math.round(y10 - this.f12011c)) != 0) {
                if (this.f12020l) {
                    x(iRound);
                    this.f12011c = y10;
                } else {
                    float fAbs = Math.abs(iRound);
                    float f10 = this.f12018j;
                    if (fAbs > f10) {
                        x((int) (iRound > 0 ? iRound - f10 : iRound + f10));
                        this.f12020l = true;
                        this.f12011c = y10;
                    }
                }
            }
        } else {
            if (this.f12016h.f12040q == 0) {
                this.f12019k = false;
                return false;
            }
            if (!this.f12019k) {
                this.f12020l = false;
                x(0);
                float x10 = motionEvent.getX();
                Rect rect = this.f12012d;
                if (y10 >= rect.top && y10 <= rect.bottom && x10 >= rect.left && x10 <= rect.right) {
                    this.f12019k = true;
                    this.f12011c = y10;
                    this.f12014f.b(motionEvent);
                    MotionEvent motionEventObtain3 = MotionEvent.obtain(motionEvent);
                    motionEventObtain3.setAction(3);
                    this.f12014f.b(motionEventObtain3);
                    motionEventObtain3.recycle();
                    r(true);
                    y(0, true);
                    this.f12009a.removeCallbacks(this.f12016h);
                }
            }
        }
        if (!this.f12019k) {
            return false;
        }
        this.f12009a.invalidate();
        this.f12009a.getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    }

    public void p(View view, int i10) {
        if (i10 == 0 && this.f12009a.isAttachedToWindow()) {
            g();
        }
    }

    public void q(int i10) {
        if (i10 == 0) {
            g();
        }
    }

    public final void r(boolean z10) {
        this.f12013e.setState(z10 ? f11997o : f11998p);
        this.f12009a.invalidate();
    }

    public void s(boolean z10) {
        if (this.f12021m == z10) {
            return;
        }
        this.f12021m = z10;
        x(0);
    }

    public void t(Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("drawable == null");
        }
        this.f12013e = drawable;
        x(0);
    }

    public void u(boolean z10) {
        if (this.f12017i != z10) {
            this.f12017i = z10;
            x(0);
        }
    }

    public void v(int i10, int i11) {
        Rect rect = this.f12012d;
        rect.left = rect.right - f(i10);
        this.f12015g = f(i11);
        x(0);
    }

    public void w(int i10) {
        this.f12018j = Math.max(0, i10);
    }

    public final boolean x(int i10) {
        return y(i10, false);
    }

    public final boolean y(int i10, boolean z10) {
        int iA = this.f12014f.a();
        if (iA <= 0) {
            return false;
        }
        int iD = this.f12014f.d();
        int iC = this.f12014f.c();
        int i11 = iA - iC;
        int height = this.f12009a.getHeight();
        if (i11 <= height) {
            return false;
        }
        float f10 = i11;
        float f11 = (iD * 1.0f) / f10;
        float f12 = (iC * 1.0f) / iA;
        int iWidth = this.f12012d.width();
        if (this.f12021m) {
            Rect rect = this.f12012d;
            rect.left = 0;
            rect.right = iWidth;
        } else {
            this.f12012d.right = this.f12009a.getWidth();
            Rect rect2 = this.f12012d;
            rect2.left = rect2.right - iWidth;
        }
        int iMax = this.f12017i ? Math.max(this.f12015g, Math.round(Math.min(f12, 0.25f) * height)) : this.f12015g;
        Rect rect3 = this.f12012d;
        rect3.bottom = rect3.top + iMax;
        int i12 = height - iMax;
        float f13 = i12;
        int iRound = Math.round(f11 * f13);
        Rect rect4 = this.f12012d;
        rect4.offsetTo(rect4.left, iRound);
        if (i10 == 0) {
            return true;
        }
        int i13 = iRound + i10;
        if (i13 <= i12) {
            i12 = i13 < 0 ? 0 : i13;
        }
        int iRound2 = Math.round(f10 * ((i12 * 1.0f) / f13)) - iD;
        View view = this.f12009a;
        if (view instanceof AbsListView) {
            ((AbsListView) view).smoothScrollBy(iRound2, 0);
            return true;
        }
        view.scrollBy(0, iRound2);
        return true;
    }

    public a(c cVar, int i10, int i11, Drawable drawable, boolean z10, float f10, boolean z11) {
        this.f12019k = false;
        this.f12020l = false;
        this.f12021m = false;
        View fastScrollableView = cVar.getFastScrollableView();
        this.f12009a = fastScrollableView;
        fastScrollableView.setVerticalScrollBarEnabled(false);
        Context context = fastScrollableView.getContext();
        this.f12018j = f10;
        this.f12010b = context.getResources().getDisplayMetrics().density;
        this.f12015g = f(f12000r);
        this.f12012d = new Rect(0, 0, i10, i11);
        this.f12013e = drawable;
        this.f12014f = cVar;
        this.f12016h = new d(ViewConfiguration.get(context), fastScrollableView);
        this.f12017i = z10;
        this.f12021m = z11;
    }
}
