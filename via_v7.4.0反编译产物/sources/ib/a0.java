package ib;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import h6.a;
import z8.r3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a0 extends RelativeLayout {

    /* renamed from: e, reason: collision with root package name */
    public static final int f7113e = g6.y.l();

    /* renamed from: j, reason: collision with root package name */
    public static final int f7114j = g6.y.l();

    /* renamed from: k, reason: collision with root package name */
    public static final int f7115k = g6.y.l();

    /* renamed from: l, reason: collision with root package name */
    public static final int f7116l = g6.y.l();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f7117a;

        public a(Context context) {
            this.f7117a = context;
        }

        @Override // h6.a.InterfaceC0076a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(TextView textView) {
            textView.setTextColor(g6.e.a(this.f7117a, x7.k.f13665k));
            textView.setMaxLines(1);
            textView.setLines(1);
            textView.setTextSize(0, x8.h.r(this.f7117a));
            textView.setEllipsize(TextUtils.TruncateAt.END);
            r3.n(textView);
            x8.g.d(textView);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f7119a;

        public b(Context context) {
            this.f7119a = context;
        }

        @Override // h6.a.InterfaceC0076a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(TextView textView) {
            textView.setMinWidth(g6.y.h(this.f7119a, 32.0f));
            textView.setTextColor(g6.e.a(this.f7119a, x7.k.f13666l));
            textView.setTextSize(0, x8.h.r(this.f7119a));
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setGravity(17);
            x8.g.d(textView);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f7121a;

        public c(Context context) {
            this.f7121a = context;
        }

        @Override // h6.a.InterfaceC0076a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(TextView textView) {
            textView.setMinHeight(g6.y.h(this.f7121a, 36.0f));
            textView.setTextColor(x8.h.p(this.f7121a));
            textView.setMaxLines(3);
            textView.setTextSize(0, x8.h.s(this.f7121a));
            textView.setEllipsize(TextUtils.TruncateAt.END);
            r3.n(textView);
            x8.g.d(textView);
        }
    }

    public a0(Context context) {
        this(context, null);
    }

    public a0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a();
    }

    public final void a() {
        Context context = getContext();
        int iH = g6.y.h(context, 20.0f);
        int iH2 = g6.y.h(context, 16.0f);
        setPadding(iH2, iH, iH2, iH);
        g6.y.O(this, g6.f.e(context, x7.o.f13723f));
        h6.a aVar = new h6.a(new TextView(context), new RelativeLayout.LayoutParams(-1, -2));
        int i10 = f7113e;
        TextView textView = (TextView) aVar.o(i10).V(new a(context)).l();
        h6.a aVar2 = new h6.a(new TextView(context), new RelativeLayout.LayoutParams(-2, -2));
        int i11 = f7115k;
        TextView textView2 = (TextView) aVar2.o(i11).h(1).g(32, i10).B(1, 2).V(new b(context)).l();
        SeekBar seekBar = (SeekBar) new h6.a(new SeekBar(new ContextThemeWrapper(context, x7.v.f14259f)), new RelativeLayout.LayoutParams(-1, -2)).o(f7114j).h(8).g(2, i11).g(16, i11).A((-g6.y.h(context, 3.0f)) + (x8.h.u(context) / 2)).V(new g8.e()).l();
        TextView textView3 = (TextView) new h6.a(new TextView(context), new RelativeLayout.LayoutParams(-1, -2)).o(f7116l).g(32, i11).B(1, 12).F(1, 16).e(new g6.g().h(813727872).c(g6.f.d(context, x7.n.f13698q)).a()).V(new c(context)).l();
        addView(textView);
        addView(textView2);
        addView(seekBar);
        addView(textView3);
        setDescendantFocusability(262144);
    }
}
