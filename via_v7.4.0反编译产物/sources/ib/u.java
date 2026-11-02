package ib;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import h6.a;
import z8.r3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class u extends RelativeLayout {

    /* renamed from: e, reason: collision with root package name */
    public static final int f7164e = g6.y.l();

    /* renamed from: j, reason: collision with root package name */
    public static final int f7165j = g6.y.l();

    /* renamed from: k, reason: collision with root package name */
    public static final int f7166k = g6.y.l();

    /* renamed from: l, reason: collision with root package name */
    public static final int f7167l = g6.y.l();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f7168a;

        public a(Context context) {
            this.f7168a = context;
        }

        @Override // h6.a.InterfaceC0076a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(TextView textView) {
            textView.setTextColor(g6.e.a(this.f7168a, x7.k.f13665k));
            textView.setMaxLines(1);
            textView.setLines(1);
            textView.setTextSize(0, g6.f.d(this.f7168a, x7.n.f13693l));
            textView.setEllipsize(TextUtils.TruncateAt.END);
            r3.n(textView);
            x8.g.d(textView);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f7170a;

        public b(Context context) {
            this.f7170a = context;
        }

        @Override // h6.a.InterfaceC0076a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(TextView textView) {
            textView.setTextColor(g6.e.a(this.f7170a, x7.k.f13666l));
            textView.setMaxLines(3);
            textView.setTextSize(0, g6.f.d(this.f7170a, x7.n.f13694m));
            textView.setEllipsize(TextUtils.TruncateAt.END);
            r3.n(textView);
            x8.g.d(textView);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c implements a.InterfaceC0076a {
        public c() {
        }

        @Override // h6.a.InterfaceC0076a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CheckBox checkBox) {
            checkBox.setClickable(false);
            checkBox.setFocusable(false);
            checkBox.setButtonDrawable(x8.h.d(checkBox.getContext()));
        }
    }

    public u(Context context) {
        this(context, null);
    }

    public u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public u(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        b();
    }

    public static /* synthetic */ void a(Context context, ImageView imageView) {
        imageView.setImageDrawable(g6.f.e(context, x7.o.J));
        r3.m(imageView);
    }

    public final void b() {
        final Context context = getContext();
        int iH = g6.y.h(context, 20.0f);
        int iH2 = g6.y.h(context, 16.0f);
        setPadding(iH2, iH, iH2, iH);
        g6.y.O(this, g6.f.e(context, x7.o.f13723f));
        h6.a aVar = new h6.a(new TextView(context), new RelativeLayout.LayoutParams(-1, -2));
        int i10 = f7164e;
        h6.a aVarH = aVar.o(i10).h(1);
        int i11 = f7166k;
        TextView textView = (TextView) aVarH.g(4, i11).V(new a(context)).l();
        TextView textView2 = (TextView) new h6.a(new TextView(context), new RelativeLayout.LayoutParams(-1, -2)).o(f7165j).h(1).g(4, i11).g(32, i10).B(1, 0).V(new b(context)).l();
        h6.a aVarY = new h6.a(new ImageView(context), new RelativeLayout.LayoutParams(-2, -2)).o(i11).Y(1, 48);
        int i12 = f7167l;
        ImageView imageView = (ImageView) aVarY.g(4, i12).h(144).N(1, 13).x(1, 16).V(new a.InterfaceC0076a() { // from class: ib.t
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                u.a(context, (ImageView) obj);
            }
        }).l();
        CheckBox checkBox = (CheckBox) new h6.a(new CheckBox(context), new RelativeLayout.LayoutParams(-2, g6.y.h(context, 20.0f))).o(i12).h(8).h(144).V(new c()).l();
        addView(textView);
        addView(textView2);
        addView(imageView);
        addView(checkBox);
    }
}
