package a6;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class j extends y5.a {
    @Override // y5.d
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public long a(g gVar) {
        return gVar.c();
    }

    @Override // y5.d
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void b(b6.g gVar, g gVar2) {
        super.b(gVar, gVar2);
        gVar.X(i.f108e, gVar2.a());
        int i10 = i.f109j;
        gVar.X(i10, gVar2.d());
        gVar.Y(i10, !TextUtils.isEmpty(gVar2.d()));
        gVar.T(i.f110k, gVar2.i());
        gVar.f1219a.setAlpha(gVar2.e() ? 0.5f : 1.0f);
        gVar.f1219a.setEnabled(!gVar2.e());
    }

    @Override // y5.d
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public b6.g d(Context context, ViewGroup viewGroup) {
        i iVar = new i(context);
        iVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return new b6.g(iVar);
    }
}
