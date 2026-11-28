package a6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class i extends Handler {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile i f89b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f90a;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f91c;

        public a(View view) {
            this.f91c = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f91c.sendAccessibilityEvent(128);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f93c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ View f94e;

        public b(ViewGroup viewGroup, View view) {
            this.f93c = viewGroup;
            this.f94e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f93c.removeView(this.f94e);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f96a;

        public c(Runnable runnable) {
            this.f96a = runnable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.f96a.run();
        }
    }

    public i() {
        super(Looper.getMainLooper());
    }

    public static AnimatorSet c(View view) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "translationY", 20.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
        animatorSet.setDuration(180L);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.start();
        return animatorSet;
    }

    public static AnimatorSet d(View view, Runnable runnable) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "translationY", 20.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
        animatorSet.setDuration(180L);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.addListener(new c(runnable));
        animatorSet.start();
        return animatorSet;
    }

    public static i e() {
        if (f89b == null) {
            synchronized (i.class) {
                try {
                    if (f89b == null) {
                        f89b = new i();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f89b;
    }

    public void a(h hVar) {
        removeMessages(1);
        removeMessages(16);
        f(false);
        if (hVar == null || hVar.q() || hVar.r()) {
            return;
        }
        this.f90a = hVar;
        sendMessage(obtainMessage(1));
    }

    public final void b() {
        h hVar = this.f90a;
        if (hVar == null || hVar.q() || this.f90a.r()) {
            return;
        }
        ViewGroup viewGroupO = this.f90a.o();
        View viewP = this.f90a.p();
        try {
            viewGroupO.addView(viewP);
            c(viewP);
            viewP.postDelayed(new a(viewP), 30L);
        } catch (Exception e10) {
            tc.a.b(e10);
        }
        sendMessageDelayed(obtainMessage(16), this.f90a.n());
    }

    public void f(boolean z10) {
        h hVar = this.f90a;
        if (hVar == null || hVar.q()) {
            return;
        }
        ViewGroup viewGroupO = this.f90a.o();
        View viewP = this.f90a.p();
        if (this.f90a.r() && z10) {
            d(viewP, new b(viewGroupO, viewP));
        } else {
            viewGroupO.removeView(viewP);
        }
        this.f90a.j();
        this.f90a = null;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 1) {
            b();
        } else if (i10 != 16) {
            super.handleMessage(message);
        } else {
            f(true);
        }
    }
}
