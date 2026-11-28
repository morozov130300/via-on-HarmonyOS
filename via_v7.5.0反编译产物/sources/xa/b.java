package xa;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.tuyafeng.support.utils.e;
import com.tuyafeng.support.utils.x;
import com.tuyafeng.support.widget.d;
import java.io.File;
import t9.f;
import w5.g;
import w7.k;
import w7.n;
import w7.o;
import w7.u;
import x8.y0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b extends t5.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f14662c;

    @Override // t5.d
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public void b(g gVar, f fVar) {
        Drawable drawableA;
        super.b(gVar, fVar);
        Context contextO = gVar.O();
        d dVar = (d) gVar.f1138a.findViewById(w5.c.f13662f);
        dVar.setText(fVar.h());
        String strE = y0.e(contextO, fVar.c());
        if (strE == null || strE.isEmpty() || !new File(strE).exists()) {
            if (this.f14662c == null) {
                this.f14662c = e.f(lb.g.c(contextO, o.I1, u.Rf), e.a(contextO, k.f13729i));
                int iD = com.tuyafeng.support.utils.f.d(contextO, n.f13753f);
                this.f14662c.setBounds(0, 0, iD, iD);
            }
            drawableA = this.f14662c;
        } else {
            drawableA = y0.a(Drawable.createFromPath(strE));
        }
        androidx.core.widget.d.a(dVar, drawableA, null, null, null);
    }

    @Override // t5.d
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public g d(Context context, ViewGroup viewGroup) {
        View viewA = w5.c.b().a(viewGroup);
        d dVar = (d) viewA.findViewById(w5.c.f13662f);
        int iH = x.h(context, 16.0f);
        int iH2 = x.h(context, 12.0f);
        dVar.setPadding(iH, iH2, iH, iH2);
        dVar.setDrawableTint(0);
        return new g(viewA);
    }
}
