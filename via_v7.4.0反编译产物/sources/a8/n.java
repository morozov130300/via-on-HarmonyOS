package a8;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import h6.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class n extends y5.a {

    /* renamed from: c, reason: collision with root package name */
    public final boolean f231c;

    public n(boolean z10) {
        this.f231c = z10;
    }

    public static /* synthetic */ void l(Context context, com.tuyafeng.support.widget.d dVar) {
        dVar.d(g6.f.d(context, x7.n.f13687f), g6.f.d(context, x7.n.f13687f));
        dVar.setCompoundDrawablePadding(g6.y.h(context, 18.0f));
        dVar.setDrawableTint(g6.e.a(context, x7.k.f13665k));
        dVar.setTextColor(g6.e.a(context, x7.k.f13665k));
        dVar.setTextSize(0, x8.h.r(context));
        dVar.setMaxLines(1);
        dVar.setEllipsize(TextUtils.TruncateAt.END);
    }

    @Override // y5.d
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void b(b6.g gVar, l lVar) {
        super.b(gVar, lVar);
        Context contextO = gVar.O();
        com.tuyafeng.support.widget.d dVar = (com.tuyafeng.support.widget.d) gVar.f1219a;
        dVar.setText(lVar.b());
        x.r.e0(dVar, g6.y.h(contextO, 16.0f), g6.y.h(contextO, 14.0f), g6.y.h(contextO, 16.0f), g6.y.h(contextO, 14.0f));
        if (this.f231c) {
            g6.y.O(dVar, g6.f.e(contextO, x7.o.f13720e));
        } else {
            g6.y.O(dVar, g6.f.e(contextO, x7.o.f13723f));
        }
        androidx.core.widget.c.a(dVar, lVar.a(), null, null, null);
    }

    @Override // y5.d
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public b6.g d(final Context context, ViewGroup viewGroup) {
        return new b6.g((TextView) new h6.a(new com.tuyafeng.support.widget.d(context), new FrameLayout.LayoutParams(-1, -2)).S(g6.y.h(context, 20.0f)).M(g6.y.h(context, 16.0f)).V(new a.InterfaceC0076a() { // from class: a8.m
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                n.l(context, (com.tuyafeng.support.widget.d) obj);
            }
        }).l());
    }
}
