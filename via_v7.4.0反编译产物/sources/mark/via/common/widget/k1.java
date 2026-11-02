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
import h6.a;
import z8.r3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class k1 extends LinearLayout {

    /* renamed from: e, reason: collision with root package name */
    public ImageView f9670e;

    /* renamed from: j, reason: collision with root package name */
    public ImageView f9671j;

    /* renamed from: k, reason: collision with root package name */
    public ImageView f9672k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f9673l;

    /* renamed from: m, reason: collision with root package name */
    public a f9674m;

    /* renamed from: n, reason: collision with root package name */
    public ObjectAnimator f9675n;

    /* renamed from: o, reason: collision with root package name */
    public int f9676o;

    /* renamed from: p, reason: collision with root package name */
    public float f9677p;

    /* renamed from: q, reason: collision with root package name */
    public float f9678q;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {
        void a(int i10);
    }

    public k1(Context context) {
        this(context, null);
    }

    public k1(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public k1(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        g();
    }

    public static /* synthetic */ void a(ImageView imageView) {
        imageView.setImageResource(x7.o.f13783z);
        r3.m(imageView);
    }

    public static /* synthetic */ void b(ImageView imageView) {
        imageView.setImageResource(x7.o.U0);
        r3.m(imageView);
    }

    public static /* synthetic */ void c(k1 k1Var, View view) {
        a aVar = k1Var.f9674m;
        if (aVar != null) {
            aVar.a(k1Var.f9673l ? 2 : 1);
        }
    }

    public static /* synthetic */ void d(ImageView imageView) {
        imageView.setImageResource(x7.o.f13741l);
        r3.m(imageView);
    }

    public static /* synthetic */ void e(k1 k1Var, View view) {
        a aVar = k1Var.f9674m;
        if (aVar != null) {
            aVar.a(4);
        }
    }

    public static /* synthetic */ void f(k1 k1Var, View view) {
        a aVar = k1Var.f9674m;
        if (aVar != null) {
            aVar.a(3);
        }
    }

    public final void g() {
        this.f9676o = g6.y.h(getContext(), 4.0f) + g6.f.d(getContext(), x7.n.f13704w) + Math.max(g6.f.d(getContext(), x7.n.F), g6.f.d(getContext(), x7.n.f13683b));
        setOrientation(0);
        float fD = g6.f.d(getContext(), x7.n.f13697p);
        g6.y.O(this, new g6.g().h(g6.e.a(getContext(), x7.k.f13656b)).e(0.0f, fD, fD, 0.0f).a());
        int iH = g6.y.h(getContext(), 36.0f);
        int iH2 = g6.y.h(getContext(), 6.0f);
        int iH3 = g6.y.h(getContext(), 36.0f);
        int iH4 = g6.y.h(getContext(), 7.0f);
        this.f9670e = (ImageView) new h6.a(new ImageView(getContext()), new LinearLayout.LayoutParams(iH, iH)).F(0, iH2).i(x7.u.Ja).V(new a.InterfaceC0076a() { // from class: mark.via.common.widget.e1
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                k1.b((ImageView) obj);
            }
        }).l();
        this.f9671j = (ImageView) new h6.a(new ImageView(getContext()), new LinearLayout.LayoutParams(iH3, iH3)).F(0, iH4).V(new a.InterfaceC0076a() { // from class: mark.via.common.widget.f1
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                k1.d((ImageView) obj);
            }
        }).l();
        this.f9672k = (ImageView) new h6.a(new ImageView(getContext()), new LinearLayout.LayoutParams(iH3, iH3)).F(0, iH4).i(x7.u.od).V(new a.InterfaceC0076a() { // from class: mark.via.common.widget.g1
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                k1.a((ImageView) obj);
            }
        }).l();
        this.f9670e.setOnClickListener(new View.OnClickListener() { // from class: mark.via.common.widget.h1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k1.e(this.f9657a, view);
            }
        });
        this.f9671j.setOnClickListener(new View.OnClickListener() { // from class: mark.via.common.widget.i1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k1.c(this.f9664a, view);
            }
        });
        this.f9672k.setOnClickListener(new View.OnClickListener() { // from class: mark.via.common.widget.j1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k1.f(this.f9667a, view);
            }
        });
        addView(this.f9670e);
        addView(this.f9671j);
        addView(this.f9672k);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f9677p = motionEvent.getRawX();
            this.f9678q = motionEvent.getRawY();
        } else if (action == 2 && Math.abs(motionEvent.getRawX() - this.f9677p) < Math.abs(motionEvent.getRawY() - this.f9678q)) {
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
            this.f9677p = rawX;
            this.f9678q = rawY;
        } else {
            if (action != 2) {
                return true;
            }
            float f10 = rawY - this.f9678q;
            int height = viewGroup.getHeight();
            setTranslationY(Math.max(this.f9676o, Math.min(getTranslationY() + f10, (height - getHeight()) - this.f9676o)));
            this.f9677p = rawX;
            this.f9678q = rawY;
        }
        return true;
    }

    public void setCallback(a aVar) {
        this.f9674m = aVar;
    }

    public void setPlaying(boolean z10) {
        if (this.f9673l == z10) {
            return;
        }
        this.f9673l = z10;
        if (!z10) {
            ObjectAnimator objectAnimator = this.f9675n;
            if (objectAnimator != null) {
                if (objectAnimator.isStarted()) {
                    this.f9675n.cancel();
                }
                this.f9675n = null;
            }
        } else if (this.f9675n == null) {
            ImageView imageView = this.f9670e;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "rotation", imageView.getRotation(), this.f9670e.getRotation() + 360.0f);
            this.f9675n = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(3000L);
            this.f9675n.setRepeatCount(-1);
            this.f9675n.setInterpolator(new LinearInterpolator());
            this.f9675n.start();
        }
        this.f9671j.setImageResource(z10 ? x7.o.M0 : x7.o.O0);
        this.f9671j.setContentDescription(getContext().getString(z10 ? x7.u.N3 : x7.u.O3));
        int i10 = z10 ? 8 : 0;
        if (this.f9672k.getVisibility() != i10) {
            this.f9672k.setVisibility(i10);
        }
    }
}
