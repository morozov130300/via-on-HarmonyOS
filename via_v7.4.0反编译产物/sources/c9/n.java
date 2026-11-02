package c9;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import h6.a;
import z8.r3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class n extends y5.a {

    /* renamed from: d, reason: collision with root package name */
    public static final int f3023d = g6.y.l();

    /* renamed from: e, reason: collision with root package name */
    public static final int f3024e = g6.y.l();

    /* renamed from: c, reason: collision with root package name */
    public c f3025c;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f3026a;

        public a(Context context) {
            this.f3026a = context;
        }

        @Override // h6.a.InterfaceC0076a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(TextView textView) {
            textView.setTextColor(x8.h.p(this.f3026a));
            x8.g.m(textView, x8.h.r(this.f3026a));
            x8.g.k(textView);
            x8.g.d(textView);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b extends v5.c {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f3028c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b6.g f3029d;

        public b(String str, b6.g gVar) {
            this.f3028c = str;
            this.f3029d = gVar;
        }

        @Override // v5.c
        public void a(View view) {
            if (n.this.f3025c != null) {
                n.this.f3025c.a(view, this.f3028c, this.f3029d.l());
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface c {
        void a(View view, String str, int i10);
    }

    public static /* synthetic */ void l(ImageView imageView) {
        r3.m(imageView);
        imageView.setImageDrawable(lb.b.a(imageView.getContext(), x7.o.f13783z, x7.u.Ud));
    }

    @Override // y5.d
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void b(b6.g gVar, String str) {
        super.b(gVar, str);
        gVar.X(f3023d, str);
        gVar.P(f3024e).setOnClickListener(new b(str, gVar));
    }

    @Override // y5.d
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public b6.g d(Context context, ViewGroup viewGroup) {
        FrameLayout frameLayout = (FrameLayout) new h6.a(new FrameLayout(context), new FrameLayout.LayoutParams(-1, -2)).d(x7.o.f13723f).l();
        TextView textView = (TextView) new h6.a(new TextView(context), new FrameLayout.LayoutParams(-1, -2)).o(f3023d).P(1, 16).T(1, 12).p(16).v(1, 40).V(new a(context)).l();
        ImageView imageView = (ImageView) new h6.a(new ImageView(context), new FrameLayout.LayoutParams(-2, -2)).o(f3024e).Y(1, 40).n(1, 40).N(1, 9).v(1, 10).p(8388629).i(x7.u.f14215x).d(x7.o.f13720e).V(new a.InterfaceC0076a() { // from class: c9.m
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                n.l((ImageView) obj);
            }
        }).l();
        frameLayout.addView(textView);
        frameLayout.addView(imageView);
        return new b6.g(frameLayout);
    }

    public void p(c cVar) {
        this.f3025c = cVar;
    }
}
