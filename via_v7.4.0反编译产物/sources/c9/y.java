package c9;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import h6.a;
import java.util.Iterator;
import java.util.List;
import z8.r3;
import z8.u3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class y extends y5.a {

    /* renamed from: d, reason: collision with root package name */
    public static final int f3048d = g6.y.l();

    /* renamed from: e, reason: collision with root package name */
    public static final int f3049e = g6.y.l();

    /* renamed from: f, reason: collision with root package name */
    public static final int f3050f = g6.y.l();

    /* renamed from: g, reason: collision with root package name */
    public static final int f3051g = g6.y.l();

    /* renamed from: h, reason: collision with root package name */
    public static final int f3052h = g6.y.l();

    /* renamed from: c, reason: collision with root package name */
    public a f3053c;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {
        boolean a(int i10);
    }

    public static /* synthetic */ void l(Context context, TextView textView) {
        textView.setTextColor(x8.h.q(context));
        x8.g.m(textView, x8.h.v(context));
        x8.g.d(textView);
    }

    public static /* synthetic */ void m(Context context, TextView textView) {
        textView.setTextColor(x8.h.q(context));
        x8.g.m(textView, x8.h.u(context));
        textView.setSingleLine();
        textView.setLines(1);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        x8.g.d(textView);
    }

    public static /* synthetic */ void n(Context context, ImageView imageView) {
        imageView.setImageDrawable(lb.b.a(context, x7.o.B1, x7.u.xf));
        r3.m(imageView);
    }

    public static /* synthetic */ void o(Context context, TextView textView) {
        x8.g.l(textView);
        x8.g.m(textView, x8.h.r(context));
        x8.g.k(textView);
        x8.g.d(textView);
    }

    @Override // y5.d
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void b(b6.g gVar, p9.r rVar) {
        super.b(gVar, rVar);
        gVar.X(f3049e, g6.p.n(rVar.d(), gVar.O().getString(x7.u.bh)));
        gVar.X(f3050f, g6.p.n(rVar.e(), gVar.O().getString(x7.u.P8)));
        gVar.X(f3051g, u3.a(gVar.O(), rVar.f()));
        a aVar = this.f3053c;
        s(gVar, aVar != null && aVar.a(gVar.l()));
    }

    @Override // y5.d
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void c(b6.g gVar, p9.r rVar, List list) {
        Iterator it = list.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof Boolean) {
                s(gVar, next == Boolean.TRUE);
                z10 = true;
            }
        }
        if (z10) {
            return;
        }
        super.c(gVar, rVar, list);
    }

    @Override // y5.d
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public b6.g d(final Context context, ViewGroup viewGroup) {
        RelativeLayout relativeLayout = (RelativeLayout) new h6.a(new RelativeLayout(context), new FrameLayout.LayoutParams(-1, -2)).o(f3048d).d(x7.o.f13723f).l();
        h6.a aVar = new h6.a(new ImageView(context), new RelativeLayout.LayoutParams(-2, -2));
        int i10 = f3052h;
        ImageView imageView = (ImageView) aVar.o(i10).Y(1, 48).n(1, 48).z(1, 3).N(1, 13).h(144).V(new a.InterfaceC0076a() { // from class: c9.u
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                y.n(context, (ImageView) obj);
            }
        }).l();
        h6.a aVar2 = new h6.a(new TextView(context), new RelativeLayout.LayoutParams(-1, -2));
        int i11 = f3049e;
        h6.a aVarT = aVar2.o(i11).B(1, 16).t(1, 2);
        int i12 = f3051g;
        TextView textView = (TextView) aVarT.g(4, i12).g(2, i10).V(new a.InterfaceC0076a() { // from class: c9.v
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                y.o(context, (TextView) obj);
            }
        }).l();
        TextView textView2 = (TextView) new h6.a(new TextView(context), new RelativeLayout.LayoutParams(-2, -2)).o(i12).g(16, i11).h(8).z(1, 2).v(1, 16).V(new a.InterfaceC0076a() { // from class: c9.w
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                y.l(context, (TextView) obj);
            }
        }).l();
        TextView textView3 = (TextView) new h6.a(new TextView(context), new RelativeLayout.LayoutParams(-1, -2)).o(f3050f).g(32, i11).g(1, i11).t(1, 16).v(1, 16).V(new a.InterfaceC0076a() { // from class: c9.x
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                y.m(context, (TextView) obj);
            }
        }).l();
        relativeLayout.addView(imageView);
        relativeLayout.addView(textView);
        relativeLayout.addView(textView2);
        relativeLayout.addView(textView3);
        return new b6.g(relativeLayout);
    }

    public final void s(b6.g gVar, boolean z10) {
        Context contextO = gVar.O();
        if (z10) {
            gVar.R(f3048d, g6.f.b(contextO, x7.m.f13673c));
        } else {
            gVar.S(f3048d, x7.o.f13723f);
        }
    }

    public void t(a aVar) {
        this.f3053c = aVar;
    }
}
