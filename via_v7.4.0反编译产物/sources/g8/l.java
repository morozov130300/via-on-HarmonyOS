package g8;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import h6.a;
import z8.r3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class l extends y5.a {
    public static /* synthetic */ void l(Context context, TextView textView) {
        textView.setTextColor(x8.h.j(context));
        textView.setTextSize(0, x8.h.r(context));
        textView.setLines(1);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        r3.n(textView);
        x8.g.d(textView);
    }

    @Override // y5.d
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void b(b6.g gVar, a6.q qVar) {
        super.b(gVar, qVar);
        ((TextView) gVar.f1219a).setText(qVar.a());
    }

    @Override // y5.d
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public b6.g d(final Context context, ViewGroup viewGroup) {
        return new b6.g((TextView) new h6.a(new TextView(context), new FrameLayout.LayoutParams(-1, -2)).d(x7.o.f13723f).T(1, 12).N(1, 16).V(new a.InterfaceC0076a() { // from class: g8.k
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                l.l(context, (TextView) obj);
            }
        }).l());
    }
}
