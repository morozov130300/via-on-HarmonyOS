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
import h6.a;
import java.lang.ref.WeakReference;
import z8.r3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class n0 extends LinearLayout {

    /* renamed from: v, reason: collision with root package name */
    public static final int f9702v = g6.y.l();

    /* renamed from: w, reason: collision with root package name */
    public static final int f9703w = g6.y.l();

    /* renamed from: x, reason: collision with root package name */
    public static final int f9704x = g6.y.l();

    /* renamed from: y, reason: collision with root package name */
    public static final int f9705y = g6.y.l();

    /* renamed from: e, reason: collision with root package name */
    public ImageView f9706e;

    /* renamed from: j, reason: collision with root package name */
    public ImageView f9707j;

    /* renamed from: k, reason: collision with root package name */
    public ImageView f9708k;

    /* renamed from: l, reason: collision with root package name */
    public TextView f9709l;

    /* renamed from: m, reason: collision with root package name */
    public View.OnClickListener f9710m;

    /* renamed from: n, reason: collision with root package name */
    public View.OnLongClickListener f9711n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f9712o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f9713p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f9714q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f9715r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f9716s;

    /* renamed from: t, reason: collision with root package name */
    public Runnable f9717t;

    /* renamed from: u, reason: collision with root package name */
    public WeakReference f9718u;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends v5.c {
        public a() {
        }

        @Override // v5.c
        public void a(View view) {
            if (n0.this.f9710m != null) {
                n0.this.f9710m.onClick(view);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements View.OnLongClickListener {
        public b() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return n0.this.f9711n != null && n0.this.f9711n.onLongClick(view);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            n0.this.f9706e.setScaleX(1.0f);
            n0.this.f9706e.setScaleY(1.0f);
        }
    }

    public n0(Context context) {
        this(context, null);
    }

    public n0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public n0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f9717t = null;
        this.f9718u = null;
        m();
    }

    public static /* synthetic */ void a(n0 n0Var, ValueAnimator valueAnimator) throws NumberFormatException {
        n0Var.getClass();
        float f10 = Float.parseFloat(valueAnimator.getAnimatedValue().toString());
        n0Var.f9706e.setScaleX(f10);
        n0Var.f9706e.setScaleY(f10);
    }

    public static /* synthetic */ void c(n0 n0Var, int i10, int i11, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener, ImageView imageView) {
        imageView.setImageDrawable(lb.b.a(n0Var.getContext(), i10, i11));
        imageView.setOnClickListener(onClickListener);
        imageView.setOnLongClickListener(onLongClickListener);
        r3.m(imageView);
    }

    public static /* synthetic */ void d(n0 n0Var, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener, TextView textView) {
        n0Var.getClass();
        textView.setGravity(16);
        textView.setTextColor(g6.e.a(n0Var.getContext(), x7.k.f13665k));
        textView.setTextSize(0, x8.h.s(n0Var.getContext()));
        textView.setText(x7.u.f14144r6);
        textView.setOnClickListener(onClickListener);
        textView.setOnLongClickListener(onLongClickListener);
        r3.n(textView);
        r3.p(textView);
    }

    public final ImageView j(int i10, final int i11, int i12, final int i13, final View.OnClickListener onClickListener, final View.OnLongClickListener onLongClickListener) {
        return (ImageView) new h6.a(new ImageView(getContext()), new LinearLayout.LayoutParams(g6.f.d(getContext(), x7.n.E), -1)).o(i10).i(i12).M(g6.f.d(getContext(), x7.n.D)).d(x7.o.f13726g).V(new a.InterfaceC0076a() { // from class: mark.via.common.widget.i0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                n0.c(this.f9659a, i11, i13, onClickListener, onLongClickListener, (ImageView) obj);
            }
        }).l();
    }

    public final TextView k(final View.OnClickListener onClickListener, final View.OnLongClickListener onLongClickListener) {
        return (TextView) new h6.a(new TextView(getContext()), new LinearLayout.LayoutParams(0, -1)).o(f9705y).W(1.0f).d(x7.o.f13711b).V(new a.InterfaceC0076a() { // from class: mark.via.common.widget.h0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                n0.d(this.f9654a, onClickListener, onLongClickListener, (TextView) obj);
            }
        }).l();
    }

    public final void l() {
        WeakReference weakReference = this.f9718u;
        if (weakReference == null) {
            return;
        }
        ValueAnimator valueAnimator = (ValueAnimator) weakReference.get();
        if (valueAnimator == null) {
            this.f9718u = null;
        } else {
            valueAnimator.cancel();
            this.f9718u = null;
        }
    }

    public final void m() {
        setOrientation(0);
        a aVar = new a();
        b bVar = new b();
        this.f9706e = j(f9702v, x7.o.f13737j1, x7.u.Lc, x7.u.qf, aVar, bVar);
        ImageView imageViewJ = j(f9703w, x7.o.f13710a1, x7.u.f14038jb, x7.u.of, aVar, bVar);
        this.f9707j = imageViewJ;
        imageViewJ.setVisibility(8);
        this.f9708k = j(f9704x, x7.o.X0, x7.u.M9, x7.u.nf, aVar, bVar);
        this.f9709l = k(aVar, bVar);
        addView(this.f9706e);
        addView(this.f9709l);
        addView(this.f9707j);
        addView(this.f9708k);
    }

    public boolean n() {
        return this.f9713p;
    }

    public boolean o() {
        return this.f9716s;
    }

    public boolean p() {
        return this.f9714q;
    }

    public final void q() {
        l();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 1.15f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: mark.via.common.widget.m0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) throws NumberFormatException {
                n0.a(this.f9692a, valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new c());
        valueAnimatorOfFloat.setInterpolator(x8.h.b());
        valueAnimatorOfFloat.setDuration(1200L);
        valueAnimatorOfFloat.start();
        this.f9718u = new WeakReference(valueAnimatorOfFloat);
    }

    public void r(int i10, int i11) {
        g6.y.S(i10, (ImageView) findViewById(f9703w), (ImageView) findViewById(f9704x), (ImageView) findViewById(f9702v));
        this.f9709l.setTextColor(i11);
    }

    public void s(boolean z10, boolean z11) {
        if (z10 == this.f9713p && z11 == this.f9714q) {
            return;
        }
        this.f9713p = z10;
        this.f9714q = z11;
        if (z10) {
            this.f9708k.setImageDrawable(lb.b.a(getContext(), x7.o.f13783z, x7.u.Ud));
            this.f9708k.setContentDescription(getContext().getString(x7.u.M9));
        } else if (z11) {
            this.f9708k.setImageDrawable(lb.b.a(getContext(), x7.o.f13728g1, x7.u.pf));
            this.f9708k.setContentDescription(getContext().getString(x7.u.Db));
        } else {
            this.f9708k.setImageDrawable(lb.b.a(getContext(), x7.o.X0, x7.u.nf));
            this.f9708k.setContentDescription(getContext().getString(x7.u.M9));
        }
    }

    public void setIncognitoModeEnabled(boolean z10) {
        if (z10 == this.f9715r) {
            return;
        }
        this.f9715r = z10;
        boolean z11 = this.f9712o;
        this.f9712o = !z11;
        setSecureCnnection(z11);
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.f9710m = onClickListener;
    }

    public void setOnItemLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f9711n = onLongClickListener;
    }

    public void setSecureCnnection(boolean z10) {
        if (this.f9716s || this.f9712o != z10) {
            this.f9716s = false;
            this.f9712o = z10;
            this.f9706e.setContentDescription(getContext().getString(x7.u.Lc));
            if (this.f9715r && this.f9712o) {
                this.f9706e.setImageDrawable(lb.b.a(getContext(), x7.o.f13763s0, x7.u.le));
            } else if (this.f9712o) {
                this.f9706e.setImageDrawable(lb.b.a(getContext(), x7.o.A0, x7.u.me));
            } else {
                this.f9706e.setImageDrawable(lb.b.a(getContext(), x7.o.f13737j1, x7.u.qf));
            }
            if (this.f9717t != null) {
                l();
                this.f9706e.removeCallbacks(this.f9717t);
                this.f9717t = null;
            }
        }
    }

    public void setTitle(String str) {
        if (this.f9709l.getText() == null || this.f9709l.getText().equals(str)) {
            return;
        }
        this.f9709l.setText(str);
    }

    public void t(boolean z10, boolean z11) {
        x.r.c(this.f9707j).b();
        if (!z11) {
            this.f9707j.setVisibility(z10 ? 8 : 0);
        } else if (z10) {
            x.r.c(this.f9707j).g(this.f9707j.getWidth()).a(0.0f).d(150L).e(x8.h.b()).i(new Runnable() { // from class: mark.via.common.widget.k0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f9669e.f9707j.setVisibility(8);
                }
            }).f();
        } else {
            x.r.c(this.f9707j).g(0.0f).a(1.0f).d(150L).e(x8.h.b()).j(new Runnable() { // from class: mark.via.common.widget.l0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f9679e.f9707j.setVisibility(0);
                }
            }).f();
        }
    }

    public void u(boolean z10, boolean z11) {
        if (this.f9712o == z10 && (!z10 || this.f9715r == z11)) {
            this.f9715r = z11;
            return;
        }
        this.f9715r = z11;
        this.f9712o = !z10;
        setSecureCnnection(z10);
    }

    public void v(boolean z10) {
        if (z10 || this.f9716s) {
            this.f9716s = z10;
            if (!z10) {
                boolean z11 = this.f9712o;
                this.f9712o = !z11;
                setSecureCnnection(z11);
                return;
            }
            this.f9706e.setContentDescription(getContext().getString(x7.u.Bc));
            this.f9706e.setImageDrawable(lb.b.a(getContext(), x7.o.V0, x7.u.mf));
            Runnable runnable = this.f9717t;
            if (runnable != null) {
                this.f9706e.removeCallbacks(runnable);
            }
            Runnable runnable2 = new Runnable() { // from class: mark.via.common.widget.j0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f9666e.v(false);
                }
            };
            this.f9717t = runnable2;
            this.f9706e.postDelayed(runnable2, 3000L);
            q();
        }
    }
}
