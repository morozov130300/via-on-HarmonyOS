package mark.via.common.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class g0 extends LinearLayout {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f9929q = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f9930r = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f9931s = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f9932t = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f9933u = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f9934v = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View.OnClickListener f9935c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View.OnLongClickListener f9936e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f9937m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ImageView f9938n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public FrameLayout f9939o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public FrameLayout f9940p;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends p5.c {
        public a() {
        }

        @Override // p5.c
        public void a(View view) {
            if (g0.this.f9935c != null) {
                g0.this.f9935c.onClick(view);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements View.OnLongClickListener {
        public b() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return g0.this.f9936e != null && g0.this.f9936e.onLongClick(view);
        }
    }

    public g0(Context context) {
        this(context, null);
    }

    public static /* synthetic */ void a(g0 g0Var, ImageView imageView) {
        imageView.setImageDrawable(lb.g.a(g0Var.getContext(), w7.o.f13845x1, w7.u.Nf));
        imageView.setImportantForAccessibility(2);
        r3.n(imageView);
    }

    public static /* synthetic */ void b(g0 g0Var, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener, TextView textView) {
        g0Var.getClass();
        textView.setOnClickListener(onClickListener);
        textView.setOnLongClickListener(onLongClickListener);
        textView.setGravity(17);
        textView.setTextColor(com.tuyafeng.support.utils.e.a(g0Var.getContext(), w7.k.f13729i));
        textView.setTextSize(1, 11.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setText("1");
    }

    public static /* synthetic */ void c(g0 g0Var, int i10, int i11, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener, ImageView imageView) {
        imageView.setImageDrawable(lb.g.a(g0Var.getContext(), i10, i11));
        imageView.setOnClickListener(onClickListener);
        imageView.setOnLongClickListener(onLongClickListener);
        r3.n(imageView);
    }

    public void f(View view) {
        if (view == null) {
            return;
        }
        if (this.f9940p.getChildCount() == 0) {
            this.f9940p.addView(view);
        } else {
            if (this.f9940p.getChildAt(0) == view) {
                return;
            }
            this.f9940p.removeAllViews();
            this.f9940p.addView(view);
        }
        int measuredWidth = getMeasuredWidth();
        if (measuredWidth > 0) {
            l(measuredWidth);
        }
    }

    public final ImageView g(int i10, final int i11, int i12, final int i13, final View.OnClickListener onClickListener, final View.OnLongClickListener onLongClickListener) {
        return (ImageView) new b6.a(new ImageView(getContext()), new LinearLayout.LayoutParams(0, -1)).o(i10).W(1.0f).i(i12).E(com.tuyafeng.support.utils.f.d(getContext(), w7.n.f13748a)).d(w7.o.f13783d).V(new b6.a.InterfaceC0033a() { // from class: mark.via.common.widget.f0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                g0.c(this.f9923a, i11, i13, onClickListener, onLongClickListener, (ImageView) obj);
            }
        }).l();
    }

    public final View h(final View.OnClickListener onClickListener, final View.OnLongClickListener onLongClickListener) {
        this.f9939o = (FrameLayout) new b6.a(new FrameLayout(getContext()), new LinearLayout.LayoutParams(0, -1)).W(1.0f).l();
        this.f9938n = (ImageView) new b6.a(new ImageView(getContext()), new FrameLayout.LayoutParams(-1, -1)).E(com.tuyafeng.support.utils.f.d(getContext(), w7.n.f13748a)).V(new b6.a.InterfaceC0033a() { // from class: mark.via.common.widget.c0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                g0.a(this.f9905a, (ImageView) obj);
            }
        }).l();
        this.f9937m = (TextView) new b6.a(new TextView(getContext()), new FrameLayout.LayoutParams(-1, -1)).o(f9933u).d(w7.o.f13783d).J(1, 1).V(new b6.a.InterfaceC0033a() { // from class: mark.via.common.widget.d0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                g0.b(this.f9907a, onClickListener, onLongClickListener, (TextView) obj);
            }
        }).l();
        this.f9939o.addView(this.f9938n);
        this.f9939o.addView(this.f9937m);
        return this.f9939o;
    }

    public final void i() {
        setOrientation(0);
        FrameLayout frameLayout = (FrameLayout) new b6.a(new FrameLayout(getContext()), new LinearLayout.LayoutParams(0, -1)).o(f9929q).W(0.0f).P(1, 12).L(1, 0).l();
        this.f9940p = frameLayout;
        addView(frameLayout);
        View.OnClickListener aVar = new a();
        View.OnLongClickListener bVar = new b();
        addView(g(f9930r, w7.o.f13822q, w7.u.M9, w7.u.he, aVar, bVar));
        addView(g(f9931s, w7.o.f13802j0, w7.u.N9, w7.u.we, aVar, bVar));
        addView(g(f9932t, w7.o.f13823q0, w7.u.C3, w7.u.ze, aVar, bVar));
        addView(h(aVar, bVar));
        addView(g(f9934v, w7.o.C0, w7.u.D3, w7.u.De, aVar, bVar));
        postInvalidate();
    }

    public void j() {
        FrameLayout frameLayout = this.f9939o;
        ObjectAnimator duration = ObjectAnimator.ofFloat(frameLayout, "translationY", 0.0f, frameLayout.getHeight() * (-0.3f), 0.0f).setDuration(280L);
        duration.setInterpolator(v8.h.b());
        duration.start();
    }

    public void k() {
        if (this.f9940p.getChildCount() == 0) {
            return;
        }
        findViewById(f9930r).setVisibility(0);
        findViewById(f9931s).setVisibility(0);
        ((LinearLayout.LayoutParams) this.f9940p.getLayoutParams()).weight = 0.0f;
        this.f9940p.removeAllViews();
    }

    public final void l(int i10) {
        int i11;
        if (this.f9940p.getChildCount() == 0) {
            return;
        }
        int I = com.tuyafeng.support.utils.x.I(getContext(), i10);
        if (I < 420) {
            i11 = I / 7;
        } else {
            i11 = I > 900 ? 72 : 60;
        }
        int i12 = i11 <= 0 ? 6 : I / i11;
        boolean z10 = i12 > 8;
        int i13 = (i12 - 3) - (z10 ? 2 : 0);
        findViewById(f9930r).setVisibility(z10 ? 0 : 8);
        findViewById(f9931s).setVisibility(z10 ? 0 : 8);
        ((LinearLayout.LayoutParams) this.f9940p.getLayoutParams()).weight = i13;
        post(new Runnable() { // from class: mark.via.common.widget.e0
            @Override // java.lang.Runnable
            public final void run() {
                this.f9911c.requestLayout();
            }
        });
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        l(i10);
    }

    public void setAccentColor(int i10) {
        com.tuyafeng.support.utils.x.T(i10, (ImageView) findViewById(f9930r), (ImageView) findViewById(f9931s), (ImageView) findViewById(f9932t), (ImageView) findViewById(f9934v), this.f9938n);
        this.f9937m.setTextColor(i10);
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.f9935c = onClickListener;
    }

    public void setOnItemLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f9936e = onLongClickListener;
    }

    public void setTabSize(int i10) {
        this.f9937m.setText(i10 <= 99 ? String.valueOf(i10) : ":)");
        this.f9937m.setContentDescription(getResources().getQuantityString(w7.t.f13963e, i10, Integer.valueOf(i10)));
    }

    public g0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public g0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f9935c = null;
        this.f9936e = null;
        i();
    }
}
