package e8;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class l extends t5.a {
    public static /* synthetic */ void l(Context context, TextView textView) {
        textView.setTextColor(v8.h.j(context));
        textView.setTextSize(0, v8.h.q(context));
        textView.setLines(1);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        r3.o(textView);
        v8.g.d(textView);
    }

    @Override // t5.d
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public void b(w5.g gVar, v5.q qVar) {
        super.b(gVar, qVar);
        ((TextView) gVar.f1138a).setText(qVar.a());
    }

    @Override // t5.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public w5.g d(final Context context, ViewGroup viewGroup) {
        return new w5.g((TextView) new b6.a(new TextView(context), new FrameLayout.LayoutParams(-1, -2)).d(w7.o.f13786e).T(1, 12).N(1, 16).V(new b6.a.InterfaceC0033a() { // from class: e8.k
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                l.l(context, (TextView) obj);
            }
        }).l());
    }
}
