package a9;

import android.content.Context;
import android.graphics.Typeface;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class l0 extends t5.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f250c = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f251d = com.tuyafeng.support.utils.x.l();

    public static /* synthetic */ void l(Context context, TextView textView) {
        v8.g.m(textView, v8.h.t(context));
        textView.setTextColor(v8.h.o(context));
        textView.setTypeface(Typeface.MONOSPACE);
    }

    public static /* synthetic */ void n(Context context, TextView textView) {
        textView.setGravity(8388613);
        v8.g.m(textView, v8.h.q(context));
        textView.setTextColor(v8.h.p(context));
    }

    @Override // t5.d
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void b(w5.g gVar, h0 h0Var) {
        super.b(gVar, h0Var);
        gVar.X(f250c, h0Var.b());
        gVar.X(f251d, h0Var.a());
    }

    @Override // t5.d
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public w5.g d(final Context context, ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) new b6.a(new LinearLayout(context), new FrameLayout.LayoutParams(-1, -2)).d(w7.o.f13786e).T(1, 12).M(com.tuyafeng.support.utils.x.h(context, 16.0f)).V(new b6.a.InterfaceC0033a() { // from class: a9.i0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(0);
            }
        }).l();
        TextView textView = (TextView) new b6.a(new TextView(context), new LinearLayout.LayoutParams(-2, -2)).o(f250c).p(16).V(new b6.a.InterfaceC0033a() { // from class: a9.j0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                l0.l(context, (TextView) obj);
            }
        }).l();
        TextView textView2 = (TextView) new b6.a(new TextView(context), new LinearLayout.LayoutParams(0, -2)).o(f251d).p(16).P(1, 16).W(1.0f).V(new b6.a.InterfaceC0033a() { // from class: a9.k0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                l0.n(context, (TextView) obj);
            }
        }).l();
        linearLayout.addView(textView);
        linearLayout.addView(textView2);
        return new w5.g(linearLayout);
    }
}
