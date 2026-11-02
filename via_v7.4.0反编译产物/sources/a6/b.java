package a6;

import android.content.Context;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import g6.y;
import h6.a;
import z8.r3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b extends RelativeLayout {

    /* renamed from: e, reason: collision with root package name */
    public static final int f85e = y.l();

    /* renamed from: j, reason: collision with root package name */
    public static final int f86j = y.l();

    /* renamed from: k, reason: collision with root package name */
    public static final int f87k = y.l();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f88a;

        public a(Context context) {
            this.f88a = context;
        }

        @Override // h6.a.InterfaceC0076a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(TextView textView) {
            textView.setTextColor(g6.e.a(this.f88a, x7.k.f13665k));
            textView.setMaxLines(1);
            textView.setLines(1);
            textView.setTextSize(0, g6.f.d(this.f88a, x7.n.f13693l));
            textView.setEllipsize(TextUtils.TruncateAt.END);
            r3.n(textView);
            x8.g.d(textView);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: a6.b$b, reason: collision with other inner class name */
    public class C0003b implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f90a;

        public C0003b(Context context) {
            this.f90a = context;
        }

        @Override // h6.a.InterfaceC0076a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(TextView textView) {
            textView.setTextColor(g6.e.a(this.f90a, x7.k.f13666l));
            textView.setMaxLines(3);
            textView.setTextSize(0, g6.f.d(this.f90a, x7.n.f13694m));
            textView.setEllipsize(TextUtils.TruncateAt.END);
            r3.n(textView);
            x8.g.d(textView);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f92a;

        public c(Context context) {
            this.f92a = context;
        }

        @Override // h6.a.InterfaceC0076a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ImageView imageView) {
            imageView.setMaxHeight(y.h(this.f92a, 48.0f));
            imageView.setColorFilter(x8.h.j(this.f92a), PorterDuff.Mode.SRC_IN);
        }
    }

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a();
    }

    public final void a() {
        Context context = getContext();
        int iH = y.h(context, 20.0f);
        int iH2 = y.h(context, 16.0f);
        y.O(this, g6.f.e(context, x7.o.f13723f));
        x.r.e0(this, iH2, iH, iH2 / 5, iH);
        h6.a aVar = new h6.a(new TextView(context), new RelativeLayout.LayoutParams(-1, -2));
        int i10 = f85e;
        h6.a aVarH = aVar.o(i10).h(1);
        int i11 = f87k;
        TextView textView = (TextView) aVarH.g(4, i11).V(new a(context)).l();
        h6.a aVar2 = new h6.a(new TextView(context), new RelativeLayout.LayoutParams(-1, -2));
        int i12 = f86j;
        TextView textView2 = (TextView) aVar2.o(i12).h(1).g(4, i11).g(32, i10).B(1, 0).V(new C0003b(context)).l();
        ImageView imageView = (ImageView) new h6.a(new ImageView(context), new RelativeLayout.LayoutParams(-2, -2)).o(i11).Y(1, 48).h(8).g(16, i10).g(128, i12).y(y.h(context, 12.0f)).F(1, 8).d(x7.o.f13720e).V(new c(context)).l();
        addView(textView);
        addView(textView2);
        addView(imageView);
    }
}
