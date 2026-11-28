package z7;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f extends t5.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f15246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15247d = 14;

    public static /* synthetic */ void l(Context context, com.tuyafeng.support.widget.d dVar) {
        dVar.d(com.tuyafeng.support.utils.f.d(context, w7.n.f13753f), com.tuyafeng.support.utils.f.d(context, w7.n.f13753f));
        dVar.setCompoundDrawablePadding(com.tuyafeng.support.utils.x.h(context, 16.0f));
        dVar.setDrawableTint(com.tuyafeng.support.utils.e.a(context, w7.k.f13732l));
        dVar.setTextColor(com.tuyafeng.support.utils.e.a(context, w7.k.f13732l));
        dVar.setTextSize(0, v8.h.q(dVar.getContext()));
        androidx.core.widget.d.a(dVar, lb.g.a(context, w7.o.f13784d0, w7.u.te), null, null, null);
        r3.q(dVar);
        r3.o(dVar);
        v8.g.d(dVar);
    }

    @Override // t5.d
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public void b(w5.g gVar, a aVar) {
        Drawable drawableE;
        super.b(gVar, aVar);
        Context contextO = gVar.O();
        com.tuyafeng.support.widget.d dVar = (com.tuyafeng.support.widget.d) gVar.f1138a;
        dVar.setText(com.tuyafeng.support.utils.p.f(aVar.a().b()) ? contextO.getString(w7.u.Eb) : aVar.a().e());
        y.r.f0(dVar, com.tuyafeng.support.utils.x.h(contextO, 16.0f) * Math.min(10, aVar.b() + 1), com.tuyafeng.support.utils.x.h(contextO, this.f15247d), com.tuyafeng.support.utils.x.h(contextO, 16.0f), com.tuyafeng.support.utils.x.h(contextO, this.f15247d));
        if (aVar.c()) {
            drawableE = this.f15246c ? new com.tuyafeng.support.utils.g().h(com.tuyafeng.support.utils.f.b(contextO, w7.m.f13738b)).c(com.tuyafeng.support.utils.f.d(contextO, w7.n.f13763p)).a() : new ColorDrawable(com.tuyafeng.support.utils.f.b(contextO, w7.m.f13738b));
        } else {
            drawableE = com.tuyafeng.support.utils.f.e(contextO, this.f15246c ? w7.o.f13783d : w7.o.f13786e);
        }
        com.tuyafeng.support.utils.x.P(dVar, drawableE);
    }

    @Override // t5.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public w5.g d(final Context context, ViewGroup viewGroup) {
        return new w5.g((TextView) new b6.a(new com.tuyafeng.support.widget.d(context), new FrameLayout.LayoutParams(-1, -2)).S(com.tuyafeng.support.utils.x.h(context, 20.0f)).M(com.tuyafeng.support.utils.x.h(context, 16.0f)).e(com.tuyafeng.support.utils.f.e(context, w7.o.f13786e)).V(new b6.a.InterfaceC0033a() { // from class: z7.e
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                f.l(context, (com.tuyafeng.support.widget.d) obj);
            }
        }).l());
    }

    public void o(boolean z10) {
        this.f15246c = z10;
    }
}
