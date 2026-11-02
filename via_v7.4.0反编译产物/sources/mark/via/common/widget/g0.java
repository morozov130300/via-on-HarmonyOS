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
import h6.a;
import java.util.Locale;
import z8.r3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class g0 extends LinearLayout {

    /* renamed from: o, reason: collision with root package name */
    public static final int f9638o = g6.y.l();

    /* renamed from: p, reason: collision with root package name */
    public static final int f9639p = g6.y.l();

    /* renamed from: q, reason: collision with root package name */
    public static final int f9640q = g6.y.l();

    /* renamed from: r, reason: collision with root package name */
    public static final int f9641r = g6.y.l();

    /* renamed from: s, reason: collision with root package name */
    public static final int f9642s = g6.y.l();

    /* renamed from: t, reason: collision with root package name */
    public static final int f9643t = g6.y.l();

    /* renamed from: e, reason: collision with root package name */
    public View.OnClickListener f9644e;

    /* renamed from: j, reason: collision with root package name */
    public View.OnLongClickListener f9645j;

    /* renamed from: k, reason: collision with root package name */
    public TextView f9646k;

    /* renamed from: l, reason: collision with root package name */
    public ImageView f9647l;

    /* renamed from: m, reason: collision with root package name */
    public FrameLayout f9648m;

    /* renamed from: n, reason: collision with root package name */
    public FrameLayout f9649n;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends v5.c {
        public a() {
        }

        @Override // v5.c
        public void a(View view) {
            if (g0.this.f9644e != null) {
                g0.this.f9644e.onClick(view);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements View.OnLongClickListener {
        public b() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return g0.this.f9645j != null && g0.this.f9645j.onLongClick(view);
        }
    }

    public g0(Context context) {
        this(context, null);
    }

    public g0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public g0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f9644e = null;
        this.f9645j = null;
        i();
    }

    public static /* synthetic */ void a(g0 g0Var, ImageView imageView) {
        imageView.setImageDrawable(lb.b.a(g0Var.getContext(), x7.o.f13785z1, x7.u.wf));
        imageView.setImportantForAccessibility(2);
        r3.m(imageView);
    }

    public static /* synthetic */ void b(g0 g0Var, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener, TextView textView) {
        g0Var.getClass();
        textView.setOnClickListener(onClickListener);
        textView.setOnLongClickListener(onLongClickListener);
        textView.setGravity(17);
        textView.setTextColor(g6.e.a(g0Var.getContext(), x7.k.f13662h));
        textView.setTextSize(1, 11.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setText("1");
    }

    public static /* synthetic */ void c(g0 g0Var, int i10, int i11, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener, ImageView imageView) {
        imageView.setImageDrawable(lb.b.a(g0Var.getContext(), i10, i11));
        imageView.setOnClickListener(onClickListener);
        imageView.setOnLongClickListener(onLongClickListener);
        r3.m(imageView);
    }

    public void f(View view) {
        if (view == null) {
            return;
        }
        if (this.f9649n.getChildCount() == 0) {
            this.f9649n.addView(view);
        } else {
            if (this.f9649n.getChildAt(0) == view) {
                return;
            }
            this.f9649n.removeAllViews();
            this.f9649n.addView(view);
        }
        int measuredWidth = getMeasuredWidth();
        if (measuredWidth > 0) {
            m(measuredWidth);
        }
    }

    public final ImageView g(int i10, final int i11, int i12, final int i13, final View.OnClickListener onClickListener, final View.OnLongClickListener onLongClickListener) {
        return (ImageView) new h6.a(new ImageView(getContext()), new LinearLayout.LayoutParams(0, -1)).o(i10).W(1.0f).i(i12).E(g6.f.d(getContext(), x7.n.f13682a)).d(x7.o.f13720e).V(new a.InterfaceC0076a() { // from class: mark.via.common.widget.f0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                g0.c(this.f9632a, i11, i13, onClickListener, onLongClickListener, (ImageView) obj);
            }
        }).l();
    }

    public final View h(final View.OnClickListener onClickListener, final View.OnLongClickListener onLongClickListener) {
        this.f9648m = (FrameLayout) new h6.a(new FrameLayout(getContext()), new LinearLayout.LayoutParams(0, -1)).W(1.0f).l();
        this.f9647l = (ImageView) new h6.a(new ImageView(getContext()), new FrameLayout.LayoutParams(-1, -1)).E(g6.f.d(getContext(), x7.n.f13682a)).V(new a.InterfaceC0076a() { // from class: mark.via.common.widget.c0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                g0.a(this.f9614a, (ImageView) obj);
            }
        }).l();
        this.f9646k = (TextView) new h6.a(new TextView(getContext()), new FrameLayout.LayoutParams(-1, -1)).o(f9642s).d(x7.o.f13720e).J(1, 1).V(new a.InterfaceC0076a() { // from class: mark.via.common.widget.d0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                g0.b(this.f9616a, onClickListener, onLongClickListener, (TextView) obj);
            }
        }).l();
        this.f9648m.addView(this.f9647l);
        this.f9648m.addView(this.f9646k);
        return this.f9648m;
    }

    public final void i() {
        setOrientation(0);
        FrameLayout frameLayout = (FrameLayout) new h6.a(new FrameLayout(getContext()), new LinearLayout.LayoutParams(0, -1)).o(f9638o).W(0.0f).P(1, 12).L(1, 0).l();
        this.f9649n = frameLayout;
        addView(frameLayout);
        View.OnClickListener aVar = new a();
        View.OnLongClickListener bVar = new b();
        addView(g(f9639p, x7.o.f13759r, x7.u.A9, x7.u.Sd, aVar, bVar));
        addView(g(f9640q, x7.o.f13736j0, x7.u.B9, x7.u.ge, aVar, bVar));
        addView(g(f9641r, x7.o.f13754p0, x7.u.f14100o3, x7.u.je, aVar, bVar));
        addView(h(aVar, bVar));
        addView(g(f9643t, x7.o.E0, x7.u.f14114p3, x7.u.ne, aVar, bVar));
        postInvalidate();
    }

    public void j() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.f9648m, "translationY", 0.0f, r0.getHeight() * (-0.3f), 0.0f).setDuration(280L);
        duration.setInterpolator(x8.h.b());
        duration.start();
    }

    public void k() {
        if (this.f9649n.getChildCount() == 0) {
            return;
        }
        findViewById(f9639p).setVisibility(0);
        findViewById(f9640q).setVisibility(0);
        ((LinearLayout.LayoutParams) this.f9649n.getLayoutParams()).weight = 0.0f;
        this.f9649n.removeAllViews();
    }

    public void l(int i10, int i11) {
        if (i10 < 0) {
            this.f9647l.setAlpha(1.0f);
            setTabSize(i11);
        } else {
            this.f9646k.setText(String.format(Locale.ROOT, "%d/%d", Integer.valueOf(i10), Integer.valueOf(i11)));
            this.f9646k.setContentDescription(getResources().getString(x7.u.Od, Integer.valueOf(i10), Integer.valueOf(i11)));
            this.f9647l.setAlpha(0.15f);
        }
    }

    public final void m(int i10) {
        if (this.f9649n.getChildCount() == 0) {
            return;
        }
        int I = g6.y.I(getContext(), i10);
        int i11 = I < 420 ? I / 7 : I > 900 ? 72 : 60;
        int i12 = i11 <= 0 ? 6 : I / i11;
        boolean z10 = i12 > 8;
        int i13 = (i12 - 3) - (z10 ? 2 : 0);
        findViewById(f9639p).setVisibility(z10 ? 0 : 8);
        findViewById(f9640q).setVisibility(z10 ? 0 : 8);
        ((LinearLayout.LayoutParams) this.f9649n.getLayoutParams()).weight = i13;
        post(new Runnable() { // from class: mark.via.common.widget.e0
            @Override // java.lang.Runnable
            public final void run() {
                this.f9620e.requestLayout();
            }
        });
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        m(i10);
    }

    public void setAccentColor(int i10) {
        g6.y.S(i10, (ImageView) findViewById(f9639p), (ImageView) findViewById(f9640q), (ImageView) findViewById(f9641r), (ImageView) findViewById(f9643t), this.f9647l);
        this.f9646k.setTextColor(i10);
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.f9644e = onClickListener;
    }

    public void setOnItemLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f9645j = onLongClickListener;
    }

    public void setTabSize(int i10) {
        this.f9646k.setText(i10 <= 99 ? String.valueOf(i10) : ":)");
        this.f9646k.setContentDescription(getResources().getQuantityString(x7.t.f13897e, i10, Integer.valueOf(i10)));
    }
}
