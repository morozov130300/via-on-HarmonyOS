package h8;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import b6.g;
import g6.f;
import g6.y;
import h6.a;
import x7.n;
import x7.o;
import x8.h;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c extends y5.a {
    public static /* synthetic */ void l(Context context, TextView textView) {
        textView.setCompoundDrawablePadding(y.h(context, 2.0f));
        textView.setTextSize(0, h.v(context));
        textView.setGravity(17);
        textView.setLines(2);
        textView.setMaxLines(2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTypeface(Typeface.DEFAULT);
    }

    @Override // y5.d
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public long a(a aVar) {
        return aVar.c();
    }

    @Override // y5.d
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void b(g gVar, a aVar) {
        super.b(gVar, aVar);
        if (aVar.c() == 22) {
            gVar.f1219a.setVisibility(8);
            return;
        }
        gVar.f1219a.setVisibility(0);
        Context context = gVar.f1219a.getContext();
        TextView textView = (TextView) gVar.f1219a;
        textView.setText(aVar.d());
        textView.setContentDescription(aVar.a());
        if (aVar.f()) {
            int iJ = h.j(context);
            g6.h.a(aVar.b(), iJ);
            textView.setTextColor(iJ);
        } else {
            g6.h.a(aVar.b(), h.l(context));
            textView.setTextColor(h.p(context));
        }
        x8.g.e(textView, aVar.f() ? 1 : 0);
        int iD = f.d(context, n.f13702u);
        aVar.b().setBounds(0, 0, iD, iD);
        textView.setCompoundDrawables(null, aVar.b(), null, null);
        textView.setEnabled(aVar.e());
        textView.setAlpha(aVar.e() ? 1.0f : 0.35f);
    }

    @Override // y5.d
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public g d(final Context context, ViewGroup viewGroup) {
        int measuredWidth = viewGroup.getMeasuredWidth() / 5;
        if (measuredWidth <= 0) {
            measuredWidth = y.h(context, 64.0f);
        }
        return new g((TextView) new h6.a(new TextView(context), new FrameLayout.LayoutParams(measuredWidth, -2)).e(f.e(context, o.f13720e)).S(y.h(context, 15.0f)).M(y.h(context, 5.0f)).V(new a.InterfaceC0076a() { // from class: h8.b
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                c.l(context, (TextView) obj);
            }
        }).l());
    }
}
