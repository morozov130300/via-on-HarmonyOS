package xa;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import b6.g;
import com.tuyafeng.support.widget.d;
import g6.e;
import g6.y;
import java.io.File;
import v9.f;
import x7.k;
import x7.n;
import x7.o;
import x7.u;
import z8.y0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b extends y5.a {

    /* renamed from: c, reason: collision with root package name */
    public Drawable f14316c;

    @Override // y5.d
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void b(g gVar, f fVar) {
        Drawable drawableCreateFromPath;
        super.b(gVar, fVar);
        Context contextO = gVar.O();
        d dVar = (d) gVar.f1219a.findViewById(b6.c.f1831f);
        dVar.setText(fVar.h());
        String strD = y0.d(contextO, fVar.c());
        if (strD == null || strD.isEmpty() || !new File(strD).exists()) {
            if (this.f14316c == null) {
                this.f14316c = e.f(lb.b.a(contextO, o.L1, u.Bf), e.a(contextO, k.f13662h));
                int iD = g6.f.d(contextO, n.f13687f);
                this.f14316c.setBounds(0, 0, iD, iD);
            }
            drawableCreateFromPath = this.f14316c;
        } else {
            drawableCreateFromPath = Drawable.createFromPath(strD);
        }
        androidx.core.widget.c.a(dVar, drawableCreateFromPath, null, null, null);
    }

    @Override // y5.d
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public g d(Context context, ViewGroup viewGroup) {
        View viewA = b6.c.b().a(viewGroup);
        d dVar = (d) viewA.findViewById(b6.c.f1831f);
        int iH = y.h(context, 16.0f);
        int iH2 = y.h(context, 12.0f);
        dVar.setPadding(iH, iH2, iH, iH2);
        dVar.setDrawableTint(0);
        return new g(viewA);
    }
}
