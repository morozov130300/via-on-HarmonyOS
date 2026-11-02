package c9;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import h6.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class s extends y5.a {

    /* renamed from: c, reason: collision with root package name */
    public static final int f3041c = g6.y.l();

    public static /* synthetic */ void l(Context context, TextView textView) {
        x8.g.m(textView, x8.h.u(textView.getContext()));
        textView.setGravity(17);
        textView.setSingleLine();
        textView.setLines(1);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxWidth(g6.y.h(textView.getContext(), 96.0f));
        textView.setTextColor(x8.h.g(context, x8.h.p(context)));
        x8.g.d(textView);
    }

    @Override // y5.d
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void b(b6.g gVar, q qVar) {
        super.b(gVar, qVar);
        TextView textView = (TextView) gVar.P(f3041c);
        if ("default".equals(qVar.a().d())) {
            textView.setText(gVar.O().getString(x7.u.P1));
        } else {
            textView.setText(qVar.a().e());
        }
        textView.setSelected(qVar.b());
    }

    @Override // y5.d
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public b6.g d(final Context context, ViewGroup viewGroup) {
        return new b6.g((TextView) new h6.a(new TextView(context), new FrameLayout.LayoutParams(-2, -1)).o(f3041c).e(x8.h.f(context)).N(1, 9).V(new a.InterfaceC0076a() { // from class: c9.r
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                s.l(context, (TextView) obj);
            }
        }).l());
    }
}
