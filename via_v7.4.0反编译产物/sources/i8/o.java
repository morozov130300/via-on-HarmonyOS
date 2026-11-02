package i8;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import h6.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class o extends y5.a {
    public static /* synthetic */ void l(Context context, com.tuyafeng.support.widget.d dVar) {
        dVar.setCompoundDrawablePadding(g6.y.h(context, 2.0f));
        dVar.setTextSize(0, x8.h.v(context));
        dVar.d(g6.f.d(context, x7.n.f13702u), g6.f.d(context, x7.n.f13702u));
        dVar.setDrawableTint(g6.e.a(context, x7.k.f13662h));
        dVar.setGravity(17);
        dVar.setLines(2);
        dVar.setMaxLines(2);
        dVar.setEllipsize(TextUtils.TruncateAt.END);
        x8.g.d(dVar);
    }

    @Override // y5.d
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void b(b6.g gVar, m mVar) {
        super.b(gVar, mVar);
        if (mVar.b() == 22) {
            gVar.f1219a.setVisibility(8);
            return;
        }
        gVar.f1219a.setVisibility(0);
        gVar.f1219a.getContext();
        com.tuyafeng.support.widget.d dVar = (com.tuyafeng.support.widget.d) gVar.f1219a;
        dVar.setText(mVar.c());
        dVar.setCompoundDrawables(null, mVar.a(), null, null);
    }

    @Override // y5.d
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public b6.g d(final Context context, ViewGroup viewGroup) {
        return new b6.g((com.tuyafeng.support.widget.d) new h6.a(new com.tuyafeng.support.widget.d(context), new FrameLayout.LayoutParams(-1, -2)).e(g6.f.e(context, x7.o.f13720e)).S(g6.y.h(context, 15.0f)).M(g6.y.h(context, 5.0f)).V(new a.InterfaceC0076a() { // from class: i8.n
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                o.l(context, (com.tuyafeng.support.widget.d) obj);
            }
        }).l());
    }
}
