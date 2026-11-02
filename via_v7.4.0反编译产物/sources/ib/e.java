package ib;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import h6.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e extends y5.d {

    /* renamed from: c, reason: collision with root package name */
    public static final int f7130c = g6.y.l();

    /* renamed from: d, reason: collision with root package name */
    public static final int f7131d = g6.y.l();

    /* renamed from: e, reason: collision with root package name */
    public static final int f7132e = g6.y.l();

    /* renamed from: a, reason: collision with root package name */
    public d f7133a;

    /* renamed from: b, reason: collision with root package name */
    public InterfaceC0082e f7134b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends v5.c {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ib.a f7135c;

        public a(ib.a aVar) {
            this.f7135c = aVar;
        }

        @Override // v5.c
        public void a(View view) {
            if (this.f7135c.e() != null) {
                g6.n.m(view.getContext(), this.f7135c.d(), this.f7135c.e());
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b extends v5.c {
        public b() {
        }

        @Override // v5.c
        public void a(View view) {
            if (e.this.f7133a != null) {
                e.this.f7133a.a(view);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c implements View.OnLongClickListener {
        public c() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return e.this.f7134b != null && e.this.f7134b.a(view);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface d {
        void a(View view);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: ib.e$e, reason: collision with other inner class name */
    public interface InterfaceC0082e {
        boolean a(View view);
    }

    public static /* synthetic */ void i(LinearLayout linearLayout) {
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
    }

    public static /* synthetic */ void j(Context context, TextView textView) {
        x8.g.m(textView, x8.h.r(context));
        textView.setTextColor(x8.h.p(context));
        textView.setTypeface(Typeface.create("sans-serif-condensed", 0));
    }

    public static /* synthetic */ void k(Context context, TextView textView) {
        x8.g.l(textView);
        x8.g.m(textView, x8.h.s(context));
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        x8.g.d(textView);
    }

    @Override // y5.d
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void b(b6.g gVar, ib.a aVar) {
        gVar.X(f7130c, aVar.c());
        int i10 = f7131d;
        gVar.X(i10, aVar.d());
        gVar.P(i10).setOnClickListener(new a(aVar));
        int i11 = f7132e;
        gVar.W(i11, aVar.b());
        gVar.U(i11, aVar.a());
        gVar.P(i11).setOnClickListener(new b());
        gVar.P(i11).setOnLongClickListener(new c());
    }

    @Override // y5.d
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public b6.g d(final Context context, ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) new h6.a(new LinearLayout(context), new LinearLayout.LayoutParams(-1, -2)).S(g6.y.h(context, 24.0f)).V(new a.InterfaceC0076a() { // from class: ib.b
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                e.i((LinearLayout) obj);
            }
        }).l();
        ImageView imageView = (ImageView) new h6.a(new ImageView(context), new LinearLayout.LayoutParams(g6.y.h(context, 60.0f), g6.y.h(context, 60.0f))).o(f7132e).l();
        TextView textView = (TextView) new h6.a(new TextView(context), new LinearLayout.LayoutParams(-2, -2)).o(f7130c).A(g6.y.h(context, 12.0f)).V(new a.InterfaceC0076a() { // from class: ib.c
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                e.k(context, (TextView) obj);
            }
        }).l();
        TextView textView2 = (TextView) new h6.a(new TextView(context), new LinearLayout.LayoutParams(-2, -2)).o(f7131d).A(g6.y.h(context, 2.0f)).V(new a.InterfaceC0076a() { // from class: ib.d
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                e.j(context, (TextView) obj);
            }
        }).l();
        linearLayout.addView(imageView);
        linearLayout.addView(textView);
        linearLayout.addView(textView2);
        return new b6.g(linearLayout);
    }

    public void p(d dVar) {
        this.f7133a = dVar;
    }

    public void q(InterfaceC0082e interfaceC0082e) {
        this.f7134b = interfaceC0082e;
    }
}
