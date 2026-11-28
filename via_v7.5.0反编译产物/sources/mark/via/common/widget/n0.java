package mark.via.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class n0 extends LinearLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f9996c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f9997e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ImageView f9998m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f9999n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View.OnClickListener f10000o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View.OnLongClickListener f10001p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f10002q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f10003r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f10004s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f10005t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f10006u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Runnable f10007v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public WeakReference f10008w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f9993x = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f9994y = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f9995z = com.tuyafeng.support.utils.x.l();
    public static final int A = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends p5.c {
        public a() {
        }

        @Override // p5.c
        public void a(View view) {
            if (n0.this.f10000o != null) {
                n0.this.f10000o.onClick(view);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements View.OnLongClickListener {
        public b() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return n0.this.f10001p != null && n0.this.f10001p.onLongClick(view);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            n0.this.f9996c.setScaleX(1.0f);
            n0.this.f9996c.setScaleY(1.0f);
        }
    }

    public n0(Context context) {
        this(context, null);
    }

    public static /* synthetic */ void a(n0 n0Var, ValueAnimator valueAnimator) {
        n0Var.getClass();
        float f10 = Float.parseFloat(valueAnimator.getAnimatedValue().toString());
        n0Var.f9996c.setScaleX(f10);
        n0Var.f9996c.setScaleY(f10);
    }

    public static /* synthetic */ void c(n0 n0Var, int i10, int i11, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener, ImageView imageView) {
        imageView.setImageDrawable(lb.g.a(n0Var.getContext(), i10, i11));
        imageView.setOnClickListener(onClickListener);
        imageView.setOnLongClickListener(onLongClickListener);
        r3.n(imageView);
    }

    public static /* synthetic */ void d(n0 n0Var, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener, TextView textView) {
        n0Var.getClass();
        textView.setGravity(16);
        textView.setTextColor(com.tuyafeng.support.utils.e.a(n0Var.getContext(), w7.k.f13732l));
        textView.setTextSize(0, v8.h.r(n0Var.getContext()));
        textView.setText(w7.u.D6);
        textView.setOnClickListener(onClickListener);
        textView.setOnLongClickListener(onLongClickListener);
        r3.o(textView);
        r3.q(textView);
    }

    public final ImageView j(int i10, final int i11, int i12, final int i13, final View.OnClickListener onClickListener, final View.OnLongClickListener onLongClickListener) {
        return (ImageView) new b6.a(new ImageView(getContext()), new LinearLayout.LayoutParams(com.tuyafeng.support.utils.f.d(getContext(), w7.n.G), -1)).o(i10).i(i12).M(com.tuyafeng.support.utils.f.d(getContext(), w7.n.F)).d(w7.o.f13789f).V(new b6.a.InterfaceC0033a() { // from class: mark.via.common.widget.i0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                n0.c(this.f9950a, i11, i13, onClickListener, onLongClickListener, (ImageView) obj);
            }
        }).l();
    }

    public final TextView k(final View.OnClickListener onClickListener, final View.OnLongClickListener onLongClickListener) {
        return (TextView) new b6.a(new TextView(getContext()), new LinearLayout.LayoutParams(0, -1)).o(A).W(1.0f).d(w7.o.f13774a).V(new b6.a.InterfaceC0033a() { // from class: mark.via.common.widget.h0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                n0.d(this.f9945a, onClickListener, onLongClickListener, (TextView) obj);
            }
        }).l();
    }

    public final void l() {
        WeakReference weakReference = this.f10008w;
        if (weakReference == null) {
            return;
        }
        ValueAnimator valueAnimator = (ValueAnimator) weakReference.get();
        if (valueAnimator == null) {
            this.f10008w = null;
        } else {
            valueAnimator.cancel();
            this.f10008w = null;
        }
    }

    public final void m() {
        setOrientation(0);
        a aVar = new a();
        b bVar = new b();
        this.f9996c = j(f9993x, w7.o.f13797h1, w7.u.ad, w7.u.Hf, aVar, bVar);
        ImageView imageViewJ = j(f9994y, w7.o.Y0, w7.u.f14271vb, w7.u.Ff, aVar, bVar);
        this.f9997e = imageViewJ;
        imageViewJ.setVisibility(8);
        this.f9998m = j(f9995z, w7.o.V0, w7.u.Y9, w7.u.Ef, aVar, bVar);
        this.f9999n = k(aVar, bVar);
        addView(this.f9996c);
        addView(this.f9999n);
        addView(this.f9997e);
        addView(this.f9998m);
    }

    public boolean n() {
        return this.f10003r;
    }

    public boolean o() {
        return this.f10006u;
    }

    public boolean p() {
        return this.f10004s;
    }

    public final void q() {
        l();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 1.15f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: mark.via.common.widget.m0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                n0.a(this.f9983a, valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new c());
        valueAnimatorOfFloat.setInterpolator(v8.h.b());
        valueAnimatorOfFloat.setDuration(1200L);
        valueAnimatorOfFloat.start();
        this.f10008w = new WeakReference(valueAnimatorOfFloat);
    }

    public void r(int i10, int i11) {
        com.tuyafeng.support.utils.x.T(i10, (ImageView) findViewById(f9994y), (ImageView) findViewById(f9995z), (ImageView) findViewById(f9993x));
        this.f9999n.setTextColor(i11);
    }

    public void s(boolean z10, boolean z11) {
        if (z10 == this.f10003r && z11 == this.f10004s) {
            return;
        }
        this.f10003r = z10;
        this.f10004s = z11;
        if (z10) {
            this.f9998m.setImageDrawable(lb.g.a(getContext(), w7.o.f13846y, w7.u.je));
            this.f9998m.setContentDescription(getContext().getString(w7.u.Y9));
        } else if (z11) {
            this.f9998m.setImageDrawable(lb.g.a(getContext(), w7.o.f13788e1, w7.u.Gf));
            this.f9998m.setContentDescription(getContext().getString(w7.u.Qb));
        } else {
            this.f9998m.setImageDrawable(lb.g.a(getContext(), w7.o.V0, w7.u.Ef));
            this.f9998m.setContentDescription(getContext().getString(w7.u.Y9));
        }
    }

    public void setIncognitoModeEnabled(boolean z10) {
        if (z10 == this.f10005t) {
            return;
        }
        this.f10005t = z10;
        boolean z11 = this.f10002q;
        this.f10002q = !z11;
        setSecureCnnection(z11);
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.f10000o = onClickListener;
    }

    public void setOnItemLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f10001p = onLongClickListener;
    }

    public void setSecureCnnection(boolean z10) {
        if (this.f10006u || this.f10002q != z10) {
            this.f10006u = false;
            this.f10002q = z10;
            this.f9996c.setContentDescription(getContext().getString(w7.u.ad));
            if (this.f10005t && this.f10002q) {
                this.f9996c.setImageDrawable(lb.g.a(getContext(), w7.o.f13832t0, w7.u.Be));
            } else if (this.f10002q) {
                this.f9996c.setImageDrawable(lb.g.a(getContext(), w7.o.f13847y0, w7.u.Ce));
            } else {
                this.f9996c.setImageDrawable(lb.g.a(getContext(), w7.o.f13797h1, w7.u.Hf));
            }
            if (this.f10007v != null) {
                l();
                this.f9996c.removeCallbacks(this.f10007v);
                this.f10007v = null;
            }
        }
    }

    public void setTitle(String str) {
        if (this.f9999n.getText() == null || this.f9999n.getText().equals(str)) {
            return;
        }
        this.f9999n.setText(str);
    }

    public void t(boolean z10, boolean z11) {
        y.r.c(this.f9997e).b();
        if (!z11) {
            this.f9997e.setVisibility(z10 ? 8 : 0);
        } else if (z10) {
            y.r.c(this.f9997e).g(this.f9997e.getWidth()).a(0.0f).d(150L).e(v8.h.b()).i(new Runnable() { // from class: mark.via.common.widget.k0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f9960c.f9997e.setVisibility(8);
                }
            }).f();
        } else {
            y.r.c(this.f9997e).g(0.0f).a(1.0f).d(150L).e(v8.h.b()).j(new Runnable() { // from class: mark.via.common.widget.l0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f9970c.f9997e.setVisibility(0);
                }
            }).f();
        }
    }

    public void u(boolean z10, boolean z11) {
        if (this.f10002q == z10 && (!z10 || this.f10005t == z11)) {
            this.f10005t = z11;
            return;
        }
        this.f10005t = z11;
        this.f10002q = !z10;
        setSecureCnnection(z10);
    }

    public void v(boolean z10) {
        if (z10 || this.f10006u) {
            this.f10006u = z10;
            if (!z10) {
                boolean z11 = this.f10002q;
                this.f10002q = !z11;
                setSecureCnnection(z11);
                return;
            }
            this.f9996c.setContentDescription(getContext().getString(w7.u.Qc));
            this.f9996c.setImageDrawable(lb.g.a(getContext(), w7.o.T0, w7.u.Df));
            Runnable runnable = this.f10007v;
            if (runnable != null) {
                this.f9996c.removeCallbacks(runnable);
            }
            Runnable runnable2 = new Runnable() { // from class: mark.via.common.widget.j0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f9957c.v(false);
                }
            };
            this.f10007v = runnable2;
            this.f9996c.postDelayed(runnable2, 3000L);
            q();
        }
    }

    public n0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public n0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f10007v = null;
        this.f10008w = null;
        m();
    }
}
