package ib;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import z8.c1;
import z8.u3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class g extends y5.a {
    @Override // y5.d
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void b(b6.g gVar, w4.c cVar) {
        int iIndexOf;
        super.b(gVar, cVar);
        Context contextO = gVar.O();
        int i10 = a6.o.f122e;
        ((TextView) gVar.P(i10)).setEllipsize(TextUtils.TruncateAt.MIDDLE);
        String strD = cVar.d();
        if ((strD == null || strD.isEmpty()) && (iIndexOf = (strD = cVar.e()).indexOf("://")) >= 0) {
            strD = strD.substring(iIndexOf + 3);
        }
        gVar.X(i10, strD);
        long jS = c1.s(cVar.a());
        gVar.X(a6.o.f123j, contextO.getString(x7.u.B5, contextO.getResources().getQuantityString(x7.t.f13893a, cVar.c(), Integer.valueOf(cVar.c())), jS == 0 ? contextO.getString(x7.u.f13921b6) : contextO.getString(x7.u.kh, u3.a(contextO, jS))));
        gVar.T(a6.o.f124k, cVar.f());
    }

    @Override // y5.d
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public b6.g d(Context context, ViewGroup viewGroup) {
        a6.o oVar = new a6.o(context);
        oVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return new b6.g(oVar);
    }
}
