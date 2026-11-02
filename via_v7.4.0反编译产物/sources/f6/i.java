package f6;

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

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class i extends Handler {

    /* renamed from: b, reason: collision with root package name */
    public static volatile i f5934b;

    /* renamed from: a, reason: collision with root package name */
    public h f5935a;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ View f5936e;

        public a(View view) {
            this.f5936e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5936e.sendAccessibilityEvent(128);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f5938e;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ View f5939j;

        public b(ViewGroup viewGroup, View view) {
            this.f5938e = viewGroup;
            this.f5939j = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5938e.removeView(this.f5939j);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f5941a;

        public c(Runnable runnable) {
            this.f5941a = runnable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.f5941a.run();
        }
    }

    public i() {
        super(Looper.getMainLooper());
    }

    public static i e() {
        if (f5934b == null) {
            synchronized (i.class) {
                try {
                    if (f5934b == null) {
                        f5934b = new i();
                    }
                } finally {
                }
            }
        }
        return f5934b;
    }

    public void a(h hVar) {
        removeMessages(1);
        removeMessages(16);
        f(false);
        if (hVar == null || hVar.q() || hVar.r()) {
            return;
        }
        this.f5935a = hVar;
        sendMessage(obtainMessage(1));
    }

    public final void b() {
        h hVar = this.f5935a;
        if (hVar == null || hVar.q() || this.f5935a.r()) {
            return;
        }
        ViewGroup viewGroupO = this.f5935a.o();
        View viewP = this.f5935a.p();
        try {
            viewGroupO.addView(viewP);
            c(viewP);
            viewP.postDelayed(new a(viewP), 30L);
        } catch (Exception e10) {
            pc.a.b(e10);
        }
        sendMessageDelayed(obtainMessage(16), this.f5935a.n());
    }

    public final void c(View view) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "translationY", 20.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
        animatorSet.setDuration(180L);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.start();
    }

    public final void d(View view, Runnable runnable) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "translationY", 0.0f, 20.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
        animatorSet.setDuration(180L);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.addListener(new c(runnable));
        animatorSet.start();
    }

    public void f(boolean z10) {
        h hVar = this.f5935a;
        if (hVar == null || hVar.q()) {
            return;
        }
        ViewGroup viewGroupO = this.f5935a.o();
        View viewP = this.f5935a.p();
        if (this.f5935a.r() && z10) {
            d(viewP, new b(viewGroupO, viewP));
        } else {
            viewGroupO.removeView(viewP);
        }
        this.f5935a.j();
        this.f5935a = null;
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
