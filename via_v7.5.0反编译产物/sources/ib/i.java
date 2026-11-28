package ib;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.util.Map;
import x8.u3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class i extends t5.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f6369c;

    public i(Map map) {
        this.f6369c = map;
    }

    @Override // t5.d
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public void b(w5.g gVar, w4.c cVar) {
        int iIndexOf;
        super.b(gVar, cVar);
        Context contextO = gVar.O();
        int i10 = v5.o.f13406c;
        ((TextView) gVar.P(i10)).setEllipsize(TextUtils.TruncateAt.MIDDLE);
        String strF = cVar.f();
        if ((strF == null || strF.isEmpty()) && (iIndexOf = (strF = cVar.g()).indexOf("://")) >= 0) {
            strF = strF.substring(iIndexOf + 3);
        }
        gVar.X(i10, strF);
        Long l10 = (Long) this.f6369c.get(cVar.a());
        gVar.X(v5.o.f13407e, contextO.getString(w7.u.N5, contextO.getResources().getQuantityString(w7.t.f13959a, cVar.e(), Integer.valueOf(cVar.e())), (l10 == null || l10.longValue() == 0) ? contextO.getString(w7.u.f14155n6) : contextO.getString(w7.u.Jh, u3.a(contextO, l10.longValue()))));
        gVar.T(v5.o.f13408m, cVar.h());
    }

    @Override // t5.d
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public w5.g d(Context context, ViewGroup viewGroup) {
        v5.o oVar = new v5.o(context);
        oVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return new w5.g(oVar);
    }
}
