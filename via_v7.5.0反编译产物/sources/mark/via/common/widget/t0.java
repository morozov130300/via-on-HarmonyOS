package mark.via.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class t0 implements View.OnTouchListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f10076c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WeakReference f10080g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f10081h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f10082i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f10083j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f10084k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f10086m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f10074a = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10077d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f10078e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f10079f = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f10085l = 0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (t0.this.f10079f == 0 && t0.this.f10078e) {
                t0.this.f10077d = true;
                View view = (View) t0.this.f10080g.get();
                if (view == null) {
                    return;
                }
                view.performHapticFeedback(0);
                view.setAlpha(0.5f);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f10088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MotionEvent f10089b;

        public b(View view, MotionEvent motionEvent) {
            this.f10088a = view;
            this.f10089b = motionEvent;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            t0.this.j(this.f10088a, this.f10089b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
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
        this.f10075b = com.tuyafeng.support.utils.x.h(view.getContext(), 6.0f);
        this.f10086m = com.tuyafeng.support.utils.x.h(view.getContext(), 30.0f);
    }

    public static /* synthetic */ void a(int i10, int i11, int i12, int i13, View view, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        view.setTranslationX((int) ((i10 * fFloatValue) + i11));
        view.setTranslationY((int) ((i12 * fFloatValue) + i13));
    }

    public final void g(View view, MotionEvent motionEvent) {
        this.f10080g = new WeakReference(view);
        this.f10077d = false;
        view.postDelayed(this.f10074a, 300L);
        this.f10084k = view.getAlpha();
        this.f10081h = (int) motionEvent.getRawX();
        this.f10082i = (int) motionEvent.getRawY();
        this.f10083j = SystemClock.elapsedRealtime();
    }

    public final void h(View view, MotionEvent motionEvent) {
        int iMin;
        int i10;
        int iMin2;
        int rawX = (int) (motionEvent.getRawX() - this.f10081h);
        int rawY = (int) (motionEvent.getRawY() - this.f10082i);
        this.f10081h = (int) motionEvent.getRawX();
        this.f10082i = (int) motionEvent.getRawY();
        if (this.f10077d) {
            view.setTranslationX(view.getTranslationX() + rawX);
            view.setTranslationY(view.getTranslationY() + rawY);
            return;
        }
        if (this.f10079f == 0 && (Math.abs(rawX) > this.f10075b || Math.abs(rawY) > this.f10075b)) {
            this.f10079f = Math.abs(rawX) > Math.abs(rawY) ? 3 : 12;
            view.removeCallbacks(this.f10074a);
        }
        int i11 = this.f10079f;
        if (i11 == 0) {
            return;
        }
        if ((i11 & 3) != 0) {
            int i12 = (int) (rawX * 0.75f);
            if ((i11 & 1) == 0) {
                iMin2 = Math.max(0, (int) (view.getTranslationX() + i12));
            } else {
                iMin2 = (i11 & 2) == 0 ? Math.min(0, (int) (view.getTranslationX() + i12)) : (int) (view.getTranslationX() + i12);
            }
            i10 = 0;
        } else {
            int i13 = (int) (rawY * 0.75f);
            if ((i11 & 4) == 0) {
                iMin = Math.max(0, (int) (view.getTranslationY() + i13));
            } else {
                iMin = (i11 & 8) == 0 ? Math.min(0, (int) (view.getTranslationY() + i13)) : (int) (view.getTranslationY() + i13);
            }
            i10 = iMin;
            iMin2 = 0;
        }
        view.setTranslationX(iMin2);
        view.setTranslationY(i10);
        if (Math.abs(iMin2) > this.f10086m) {
            this.f10085l = iMin2 <= 0 ? 1 : 2;
        } else if (Math.abs(i10) > this.f10086m) {
            this.f10085l = i10 <= 0 ? 4 : 8;
        } else {
            this.f10085l = 0;
        }
        c cVar = this.f10076c;
        if (cVar != null) {
            cVar.c(this.f10085l);
        }
    }

    public final void i(final View view, MotionEvent motionEvent) {
        int left;
        int top;
        final int translationX = (int) view.getTranslationX();
        final int translationY = (int) view.getTranslationY();
        if (this.f10077d) {
            view.setAlpha(this.f10084k);
            c cVar = this.f10076c;
            int[] iArrE = cVar == null ? new int[]{this.f10081h, this.f10082i} : cVar.e(view, this.f10081h, this.f10082i);
            left = (iArrE[0] - view.getLeft()) - translationX;
            top = (iArrE[1] - view.getTop()) - translationY;
        } else {
            left = -translationX;
            top = -translationY;
            view.removeCallbacks(this.f10074a);
        }
        final int i10 = left;
        final int i11 = top;
        long jMin = (long) ((Math.min(1.0f, Math.max(Math.abs(i11), Math.abs(i10)) / (this.f10075b * 30.0f)) * 150.0f) + 100.0f);
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
        c cVar = this.f10076c;
        if (cVar == null) {
            this.f10085l = 0;
            this.f10079f = 0;
            return;
        }
        if (this.f10077d) {
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            this.f10076c.a();
            return;
        }
        int i10 = this.f10085l;
        if (i10 != 0) {
            cVar.b(i10);
            this.f10085l = 0;
            this.f10076c.c(0);
        } else if (this.f10079f == 0 && SystemClock.elapsedRealtime() - this.f10083j < 300) {
            this.f10076c.d();
        }
        this.f10079f = 0;
    }

    public t0 k(c cVar) {
        this.f10076c = cVar;
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0014  */
    @Override // android.view.View.OnTouchListener
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
            view.performClick();
            i(view, motionEvent);
        }
        return true;
    }
}
