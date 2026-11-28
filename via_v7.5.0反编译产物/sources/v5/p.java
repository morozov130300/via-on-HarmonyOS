package v5;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class p extends t5.a {
    public p() {
    }

    @Override // t5.d
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public long a(n nVar) {
        return nVar.c();
    }

    @Override // t5.d
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public void b(w5.g gVar, n nVar) {
        super.b(gVar, nVar);
        int i10 = o.f13406c;
        gVar.X(i10, nVar.a());
        int i11 = o.f13407e;
        gVar.X(i11, nVar.d());
        gVar.Y(i11, !TextUtils.isEmpty(nVar.d()));
        int i12 = o.f13408m;
        gVar.T(i12, nVar.i());
        gVar.P(i10).setAlpha(nVar.e() ? 0.5f : 1.0f);
        gVar.P(i11).setAlpha(nVar.e() ? 0.5f : 1.0f);
        gVar.P(i12).setAlpha(nVar.e() ? 0.5f : 1.0f);
        gVar.f1138a.setEnabled(!nVar.e());
    }

    @Override // t5.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public w5.g d(Context context, ViewGroup viewGroup) {
        o oVar = new o(context);
        oVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return new w5.g(oVar);
    }

    public p(t5.g gVar) {
        super(gVar);
    }
}
