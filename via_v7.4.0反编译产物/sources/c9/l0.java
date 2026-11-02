package c9;

import android.content.Context;
import android.graphics.Typeface;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import h6.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class l0 extends y5.a {

    /* renamed from: c, reason: collision with root package name */
    public static final int f3021c = g6.y.l();

    /* renamed from: d, reason: collision with root package name */
    public static final int f3022d = g6.y.l();

    public static /* synthetic */ void l(Context context, TextView textView) {
        x8.g.m(textView, x8.h.u(context));
        textView.setTextColor(x8.h.p(context));
        textView.setTypeface(Typeface.MONOSPACE);
    }

    public static /* synthetic */ void n(Context context, TextView textView) {
        textView.setGravity(8388613);
        x8.g.m(textView, x8.h.r(context));
        textView.setTextColor(x8.h.q(context));
    }

    @Override // y5.d
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void b(b6.g gVar, h0 h0Var) {
        super.b(gVar, h0Var);
        gVar.X(f3021c, h0Var.b());
        gVar.X(f3022d, h0Var.a());
    }

    @Override // y5.d
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public b6.g d(final Context context, ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) new h6.a(new LinearLayout(context), new FrameLayout.LayoutParams(-1, -2)).d(x7.o.f13723f).T(1, 12).M(g6.y.h(context, 16.0f)).V(new a.InterfaceC0076a() { // from class: c9.i0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(0);
            }
        }).l();
        TextView textView = (TextView) new h6.a(new TextView(context), new LinearLayout.LayoutParams(-2, -2)).o(f3021c).p(16).V(new a.InterfaceC0076a() { // from class: c9.j0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                l0.l(context, (TextView) obj);
            }
        }).l();
        TextView textView2 = (TextView) new h6.a(new TextView(context), new LinearLayout.LayoutParams(0, -2)).o(f3022d).p(16).P(1, 16).W(1.0f).V(new a.InterfaceC0076a() { // from class: c9.k0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                l0.n(context, (TextView) obj);
            }
        }).l();
        linearLayout.addView(textView);
        linearLayout.addView(textView2);
        return new b6.g(linearLayout);
    }
}
