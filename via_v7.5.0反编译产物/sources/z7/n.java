package z7;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class n extends t5.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f15302c;

    public n(boolean z10) {
        this.f15302c = z10;
    }

    public static /* synthetic */ void l(Context context, com.tuyafeng.support.widget.d dVar) {
        dVar.d(com.tuyafeng.support.utils.f.d(context, w7.n.f13753f), com.tuyafeng.support.utils.f.d(context, w7.n.f13753f));
        dVar.setCompoundDrawablePadding(com.tuyafeng.support.utils.x.h(context, 18.0f));
        dVar.setDrawableTint(com.tuyafeng.support.utils.e.a(context, w7.k.f13732l));
        dVar.setTextColor(com.tuyafeng.support.utils.e.a(context, w7.k.f13732l));
        dVar.setTextSize(0, v8.h.q(context));
        dVar.setMaxLines(1);
        dVar.setEllipsize(TextUtils.TruncateAt.END);
    }

    @Override // t5.d
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public void b(w5.g gVar, l lVar) {
        super.b(gVar, lVar);
        Context contextO = gVar.O();
        com.tuyafeng.support.widget.d dVar = (com.tuyafeng.support.widget.d) gVar.f1138a;
        dVar.setText(lVar.b());
        y.r.f0(dVar, com.tuyafeng.support.utils.x.h(contextO, 16.0f), com.tuyafeng.support.utils.x.h(contextO, 14.0f), com.tuyafeng.support.utils.x.h(contextO, 16.0f), com.tuyafeng.support.utils.x.h(contextO, 14.0f));
        if (this.f15302c) {
            com.tuyafeng.support.utils.x.P(dVar, com.tuyafeng.support.utils.f.e(contextO, w7.o.f13783d));
        } else {
            com.tuyafeng.support.utils.x.P(dVar, com.tuyafeng.support.utils.f.e(contextO, w7.o.f13786e));
        }
        androidx.core.widget.d.a(dVar, lVar.a(), null, null, null);
    }

    @Override // t5.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public w5.g d(final Context context, ViewGroup viewGroup) {
        return new w5.g((TextView) new b6.a(new com.tuyafeng.support.widget.d(context), new FrameLayout.LayoutParams(-1, -2)).S(com.tuyafeng.support.utils.x.h(context, 20.0f)).M(com.tuyafeng.support.utils.x.h(context, 16.0f)).V(new b6.a.InterfaceC0033a() { // from class: z7.m
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                n.l(context, (com.tuyafeng.support.widget.d) obj);
            }
        }).l());
    }
}
