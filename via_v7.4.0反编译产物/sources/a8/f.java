package a8;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import h6.a;
import z8.r3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class f extends y5.a {

    /* renamed from: c, reason: collision with root package name */
    public boolean f174c;

    /* renamed from: d, reason: collision with root package name */
    public int f175d = 14;

    public static /* synthetic */ void l(Context context, com.tuyafeng.support.widget.d dVar) {
        dVar.d(g6.f.d(context, x7.n.f13687f), g6.f.d(context, x7.n.f13687f));
        dVar.setCompoundDrawablePadding(g6.y.h(context, 16.0f));
        dVar.setDrawableTint(g6.e.a(context, x7.k.f13665k));
        dVar.setTextColor(g6.e.a(context, x7.k.f13665k));
        dVar.setTextSize(0, x8.h.r(dVar.getContext()));
        androidx.core.widget.c.a(dVar, lb.b.a(context, x7.o.f13721e0, x7.u.ee), null, null, null);
        r3.p(dVar);
        r3.n(dVar);
        x8.g.d(dVar);
    }

    @Override // y5.d
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void b(b6.g gVar, a aVar) {
        Drawable drawableE;
        super.b(gVar, aVar);
        Context contextO = gVar.O();
        com.tuyafeng.support.widget.d dVar = (com.tuyafeng.support.widget.d) gVar.f1219a;
        dVar.setText(g6.p.f(aVar.a().b()) ? contextO.getString(x7.u.f14149rb) : aVar.a().e());
        x.r.e0(dVar, g6.y.h(contextO, 16.0f) * Math.min(10, aVar.b() + 1), g6.y.h(contextO, this.f175d), g6.y.h(contextO, 16.0f), g6.y.h(contextO, this.f175d));
        if (aVar.c()) {
            drawableE = this.f174c ? new g6.g().h(g6.f.b(contextO, x7.m.f13672b)).c(g6.f.d(contextO, x7.n.f13697p)).a() : new ColorDrawable(g6.f.b(contextO, x7.m.f13672b));
        } else {
            drawableE = g6.f.e(contextO, this.f174c ? x7.o.f13720e : x7.o.f13723f);
        }
        g6.y.O(dVar, drawableE);
    }

    @Override // y5.d
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public b6.g d(final Context context, ViewGroup viewGroup) {
        return new b6.g((TextView) new h6.a(new com.tuyafeng.support.widget.d(context), new FrameLayout.LayoutParams(-1, -2)).S(g6.y.h(context, 20.0f)).M(g6.y.h(context, 16.0f)).e(g6.f.e(context, x7.o.f13723f)).V(new a.InterfaceC0076a() { // from class: a8.e
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                f.l(context, (com.tuyafeng.support.widget.d) obj);
            }
        }).l());
    }

    public void o(int i10) {
        this.f175d = i10;
    }

    public void p(boolean z10) {
        this.f174c = z10;
    }
}
