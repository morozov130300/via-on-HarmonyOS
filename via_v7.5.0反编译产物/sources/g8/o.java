package g8;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class o extends t5.a {
    public static /* synthetic */ void l(Context context, com.tuyafeng.support.widget.d dVar) {
        dVar.setCompoundDrawablePadding(com.tuyafeng.support.utils.x.h(context, 2.0f));
        dVar.setTextSize(0, v8.h.u(context));
        dVar.d(com.tuyafeng.support.utils.f.d(context, w7.n.f13768u), com.tuyafeng.support.utils.f.d(context, w7.n.f13768u));
        dVar.setDrawableTint(com.tuyafeng.support.utils.e.a(context, w7.k.f13729i));
        dVar.setGravity(17);
        dVar.setLines(2);
        dVar.setMaxLines(2);
        dVar.setEllipsize(TextUtils.TruncateAt.END);
        v8.g.d(dVar);
    }

    @Override // t5.d
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public void b(w5.g gVar, m mVar) {
        super.b(gVar, mVar);
        if (mVar.b() == 22) {
            gVar.f1138a.setVisibility(8);
            return;
        }
        gVar.f1138a.setVisibility(0);
        gVar.f1138a.getContext();
        com.tuyafeng.support.widget.d dVar = (com.tuyafeng.support.widget.d) gVar.f1138a;
        dVar.setText(mVar.c());
        dVar.setCompoundDrawables(null, mVar.a(), null, null);
    }

    @Override // t5.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public w5.g d(final Context context, ViewGroup viewGroup) {
        return new w5.g((com.tuyafeng.support.widget.d) new b6.a(new com.tuyafeng.support.widget.d(context), new FrameLayout.LayoutParams(-1, -2)).e(com.tuyafeng.support.utils.f.e(context, w7.o.f13783d)).S(com.tuyafeng.support.utils.x.h(context, 15.0f)).M(com.tuyafeng.support.utils.x.h(context, 5.0f)).V(new b6.a.InterfaceC0033a() { // from class: g8.n
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                o.l(context, (com.tuyafeng.support.widget.d) obj);
            }
        }).l());
    }
}
