package mark.via.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class t0 implements View.OnTouchListener {

    /* renamed from: b, reason: collision with root package name */
    public final int f9772b;

    /* renamed from: c, reason: collision with root package name */
    public c f9773c;

    /* renamed from: g, reason: collision with root package name */
    public WeakReference f9777g;

    /* renamed from: h, reason: collision with root package name */
    public int f9778h;

    /* renamed from: i, reason: collision with root package name */
    public int f9779i;

    /* renamed from: j, reason: collision with root package name */
    public long f9780j;

    /* renamed from: k, reason: collision with root package name */
    public float f9781k;

    /* renamed from: m, reason: collision with root package name */
    public int f9783m;

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f9771a = new a();

    /* renamed from: d, reason: collision with root package name */
    public boolean f9774d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f9775e = true;

    /* renamed from: f, reason: collision with root package name */
    public int f9776f = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f9782l = 0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (t0.this.f9776f == 0 && t0.this.f9775e) {
                t0.this.f9774d = true;
                View view = (View) t0.this.f9777g.get();
                if (view == null) {
                    return;
                }
                view.performHapticFeedback(0);
                view.setAlpha(0.5f);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f9785a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MotionEvent f9786b;

        public b(View view, MotionEvent motionEvent) {
            this.f9785a = view;
            this.f9786b = motionEvent;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            t0.this.j(this.f9785a, this.f9786b);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface c {
        void a();

        void b(int i10);

        void c(int i10);

        void d();

        int[] e(View view, int i10, int i11);
    }

    public t0(View view) {
        if (view == null) {
            throw new NullPointerException("The drag view can not be null");
        }
        view.setOnTouchListener(this);
        this.f9772b = g6.y.h(view.getContext(), 6.0f);
        this.f9783m = g6.y.h(view.getContext(), 30.0f);
    }

    public static /* synthetic */ void a(int i10, int i11, int i12, int i13, View view, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        view.setTranslationX((int) ((i10 * fFloatValue) + i11));
        view.setTranslationY((int) ((i12 * fFloatValue) + i13));
    }

    public final void g(View view, MotionEvent motionEvent) {
        this.f9777g = new WeakReference(view);
        this.f9774d = false;
        view.postDelayed(this.f9771a, 300L);
        this.f9781k = view.getAlpha();
        this.f9778h = (int) motionEvent.getRawX();
        this.f9779i = (int) motionEvent.getRawY();
        this.f9780j = SystemClock.elapsedRealtime();
    }

    public final void h(View view, MotionEvent motionEvent) {
        int iMax;
        int iMax2;
        int rawX = (int) (motionEvent.getRawX() - this.f9778h);
        int rawY = (int) (motionEvent.getRawY() - this.f9779i);
        this.f9778h = (int) motionEvent.getRawX();
        this.f9779i = (int) motionEvent.getRawY();
        if (this.f9774d) {
            view.setTranslationX(view.getTranslationX() + rawX);
            view.setTranslationY(view.getTranslationY() + rawY);
            return;
        }
        if (this.f9776f == 0 && (Math.abs(rawX) > this.f9772b || Math.abs(rawY) > this.f9772b)) {
            this.f9776f = Math.abs(rawX) > Math.abs(rawY) ? 3 : 12;
            view.removeCallbacks(this.f9771a);
        }
        int i10 = this.f9776f;
        if (i10 == 0) {
            return;
        }
        if ((i10 & 3) != 0) {
            int i11 = (int) (rawX * 0.75f);
            iMax2 = (i10 & 1) == 0 ? Math.max(0, (int) (view.getTranslationX() + i11)) : (i10 & 2) == 0 ? Math.min(0, (int) (view.getTranslationX() + i11)) : (int) (view.getTranslationX() + i11);
            iMax = 0;
        } else {
            int i12 = (int) (rawY * 0.75f);
            iMax = (i10 & 4) == 0 ? Math.max(0, (int) (view.getTranslationY() + i12)) : (i10 & 8) == 0 ? Math.min(0, (int) (view.getTranslationY() + i12)) : (int) (view.getTranslationY() + i12);
            iMax2 = 0;
        }
        view.setTranslationX(iMax2);
        view.setTranslationY(iMax);
        if (Math.abs(iMax2) > this.f9783m) {
            this.f9782l = iMax2 <= 0 ? 1 : 2;
        } else if (Math.abs(iMax) > this.f9783m) {
            this.f9782l = iMax <= 0 ? 4 : 8;
        } else {
            this.f9782l = 0;
        }
        c cVar = this.f9773c;
        if (cVar != null) {
            cVar.c(this.f9782l);
        }
    }

    public final void i(final View view, MotionEvent motionEvent) {
        int left;
        int top;
        final int translationX = (int) view.getTranslationX();
        final int translationY = (int) view.getTranslationY();
        if (this.f9774d) {
            view.setAlpha(this.f9781k);
            c cVar = this.f9773c;
            int[] iArrE = cVar == null ? new int[]{this.f9778h, this.f9779i} : cVar.e(view, this.f9778h, this.f9779i);
            left = (iArrE[0] - view.getLeft()) - translationX;
            top = (iArrE[1] - view.getTop()) - translationY;
        } else {
            left = -translationX;
            top = -translationY;
            view.removeCallbacks(this.f9771a);
        }
        final int i10 = left;
        final int i11 = top;
        long jMin = (long) ((Math.min(1.0f, Math.max(Math.abs(i11), Math.abs(i10)) / (this.f9772b * 30.0f)) * 150.0f) + 100.0f);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: mark.via.common.widget.s0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                t0.a(i10, translationX, i11, translationY, view, valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new b(view, motionEvent));
        valueAnimatorOfFloat.setInterpolator(new AccelerateInterpolator());
        valueAnimatorOfFloat.setDuration(jMin);
        valueAnimatorOfFloat.start();
    }

    public final void j(View view, MotionEvent motionEvent) {
        c cVar = this.f9773c;
        if (cVar == null) {
            this.f9782l = 0;
            this.f9776f = 0;
            return;
        }
        if (this.f9774d) {
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            this.f9773c.a();
            return;
        }
        int i10 = this.f9782l;
        if (i10 != 0) {
            cVar.b(i10);
            this.f9782l = 0;
            this.f9773c.c(0);
        } else if (this.f9776f == 0 && SystemClock.elapsedRealtime() - this.f9780j < 300) {
            this.f9773c.d();
        }
        this.f9776f = 0;
    }

    public t0 k(c cVar) {
        this.f9773c = cVar;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0014  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            g(view, motionEvent);
        } else if (action == 1) {
            view.performClick();
            i(view, motionEvent);
        } else if (action == 2) {
            h(view, motionEvent);
        } else if (action == 3) {
        }
        return true;
    }
}
