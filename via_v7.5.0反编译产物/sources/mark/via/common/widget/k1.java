package mark.via.common.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class k1 extends LinearLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f9961c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f9962e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ImageView f9963m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f9964n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public a f9965o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ObjectAnimator f9966p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f9967q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f9968r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f9969s;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        void a(int i10);
    }

    public k1(Context context) {
        this(context, null);
    }

    public static /* synthetic */ void a(ImageView imageView) {
        imageView.setImageResource(w7.o.f13846y);
        r3.n(imageView);
    }

    public static /* synthetic */ void b(ImageView imageView) {
        imageView.setImageResource(w7.o.S0);
        r3.n(imageView);
    }

    public static /* synthetic */ void c(k1 k1Var, View view) {
        a aVar = k1Var.f9965o;
        if (aVar != null) {
            aVar.a(k1Var.f9964n ? 2 : 1);
        }
    }

    public static /* synthetic */ void d(ImageView imageView) {
        imageView.setImageResource(w7.o.f13804k);
        r3.n(imageView);
    }

    public static /* synthetic */ void e(k1 k1Var, View view) {
        a aVar = k1Var.f9965o;
        if (aVar != null) {
            aVar.a(4);
        }
    }

    public static /* synthetic */ void f(k1 k1Var, View view) {
        a aVar = k1Var.f9965o;
        if (aVar != null) {
            aVar.a(3);
        }
    }

    public final void g() {
        this.f9967q = com.tuyafeng.support.utils.x.h(getContext(), 4.0f) + com.tuyafeng.support.utils.f.d(getContext(), w7.n.f13772y) + Math.max(com.tuyafeng.support.utils.f.d(getContext(), w7.n.H), com.tuyafeng.support.utils.f.d(getContext(), w7.n.f13749b));
        setOrientation(0);
        float fD = com.tuyafeng.support.utils.f.d(getContext(), w7.n.f13763p);
        com.tuyafeng.support.utils.x.P(this, new com.tuyafeng.support.utils.g().h(com.tuyafeng.support.utils.e.a(getContext(), w7.k.f13723c)).e(0.0f, fD, fD, 0.0f).a());
        int iH = com.tuyafeng.support.utils.x.h(getContext(), 36.0f);
        int iH2 = com.tuyafeng.support.utils.x.h(getContext(), 6.0f);
        int iH3 = com.tuyafeng.support.utils.x.h(getContext(), 36.0f);
        int iH4 = com.tuyafeng.support.utils.x.h(getContext(), 7.0f);
        this.f9961c = (ImageView) new b6.a(new ImageView(getContext()), new LinearLayout.LayoutParams(iH, iH)).F(0, iH2).i(w7.u.Va).V(new b6.a.InterfaceC0033a() { // from class: mark.via.common.widget.e1
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                k1.b((ImageView) obj);
            }
        }).l();
        this.f9962e = (ImageView) new b6.a(new ImageView(getContext()), new LinearLayout.LayoutParams(iH3, iH3)).F(0, iH4).V(new b6.a.InterfaceC0033a() { // from class: mark.via.common.widget.f1
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                k1.d((ImageView) obj);
            }
        }).l();
        this.f9963m = (ImageView) new b6.a(new ImageView(getContext()), new LinearLayout.LayoutParams(iH3, iH3)).F(0, iH4).i(w7.u.Ed).V(new b6.a.InterfaceC0033a() { // from class: mark.via.common.widget.g1
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                k1.a((ImageView) obj);
            }
        }).l();
        this.f9961c.setOnClickListener(new View.OnClickListener() { // from class: mark.via.common.widget.h1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k1.e(this.f9948a, view);
            }
        });
        this.f9962e.setOnClickListener(new View.OnClickListener() { // from class: mark.via.common.widget.i1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k1.c(this.f9955a, view);
            }
        });
        this.f9963m.setOnClickListener(new View.OnClickListener() { // from class: mark.via.common.widget.j1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k1.f(this.f9958a, view);
            }
        });
        addView(this.f9961c);
        addView(this.f9962e);
        addView(this.f9963m);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f9968r = motionEvent.getRawX();
            this.f9969s = motionEvent.getRawY();
        } else if (action == 2 && Math.abs(motionEvent.getRawX() - this.f9968r) < Math.abs(motionEvent.getRawY() - this.f9969s)) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup == null) {
            return false;
        }
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f9968r = rawX;
            this.f9969s = rawY;
        } else {
            if (action != 2) {
                return true;
            }
            setTranslationY(Math.max(this.f9967q, Math.min(getTranslationY() + (rawY - this.f9969s), (viewGroup.getHeight() - getHeight()) - this.f9967q)));
            this.f9968r = rawX;
            this.f9969s = rawY;
        }
        return true;
    }

    public void setCallback(a aVar) {
        this.f9965o = aVar;
    }

    public void setPlaying(boolean z10) {
        if (this.f9964n == z10) {
            return;
        }
        this.f9964n = z10;
        if (!z10) {
            ObjectAnimator objectAnimator = this.f9966p;
            if (objectAnimator != null) {
                if (objectAnimator.isStarted()) {
                    this.f9966p.cancel();
                }
                this.f9966p = null;
            }
        } else if (this.f9966p == null) {
            ImageView imageView = this.f9961c;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "rotation", imageView.getRotation(), this.f9961c.getRotation() + 360.0f);
            this.f9966p = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(3000L);
            this.f9966p.setRepeatCount(-1);
            this.f9966p.setInterpolator(new LinearInterpolator());
            this.f9966p.start();
        }
        this.f9962e.setImageResource(z10 ? w7.o.K0 : w7.o.M0);
        this.f9962e.setContentDescription(getContext().getString(z10 ? w7.u.f13971a4 : w7.u.f13985b4));
        int i10 = z10 ? 8 : 0;
        if (this.f9963m.getVisibility() != i10) {
            this.f9963m.setVisibility(i10);
        }
    }

    public k1(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public k1(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        g();
    }
}
