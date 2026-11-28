package sa;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class j0 extends t5.a {
    @Override // t5.d
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public void b(w5.g gVar, i0 i0Var) {
        super.b(gVar, i0Var);
        gVar.X(v5.r.f13418c, i0Var.a());
        gVar.Y(v5.r.f13419e, false);
        com.tuyafeng.support.utils.x.P(gVar.f1138a, com.tuyafeng.support.utils.f.e(gVar.O(), w7.o.f13786e));
    }

    @Override // t5.d
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public w5.g d(Context context, ViewGroup viewGroup) {
        v5.r rVar = new v5.r(context);
        rVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return new w5.g(rVar);
    }
}
