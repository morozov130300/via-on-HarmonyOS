package a6;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class p extends y5.a {
    public p() {
    }

    public p(y5.g gVar) {
        super(gVar);
    }

    @Override // y5.d
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public long a(n nVar) {
        return nVar.c();
    }

    @Override // y5.d
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void b(b6.g gVar, n nVar) {
        super.b(gVar, nVar);
        int i10 = o.f122e;
        gVar.X(i10, nVar.a());
        int i11 = o.f123j;
        gVar.X(i11, nVar.d());
        gVar.Y(i11, !TextUtils.isEmpty(nVar.d()));
        int i12 = o.f124k;
        gVar.T(i12, nVar.i());
        gVar.P(i10).setAlpha(nVar.e() ? 0.5f : 1.0f);
        gVar.P(i11).setAlpha(nVar.e() ? 0.5f : 1.0f);
        gVar.P(i12).setAlpha(nVar.e() ? 0.5f : 1.0f);
        gVar.f1219a.setEnabled(!nVar.e());
    }

    @Override // y5.d
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public b6.g d(Context context, ViewGroup viewGroup) {
        o oVar = new o(context);
        oVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return new b6.g(oVar);
    }
}
