package a6;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import g6.y;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class s extends y5.a {
    public s() {
    }

    public s(y5.g gVar) {
        super(gVar);
    }

    @Override // y5.d
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public long a(q qVar) {
        return qVar.c();
    }

    @Override // y5.d
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void b(b6.g gVar, q qVar) {
        super.b(gVar, qVar);
        int i10 = r.f134e;
        gVar.X(i10, qVar.a());
        int i11 = r.f135j;
        gVar.X(i11, qVar.d());
        gVar.Y(i11, !TextUtils.isEmpty(qVar.d()));
        y.O(gVar.f1219a, qVar.f() ? new ColorDrawable(g6.f.b(gVar.O(), x7.m.f13672b)) : g6.f.e(gVar.O(), x7.o.f13723f));
        gVar.P(i10).setAlpha(qVar.e() ? 0.5f : 1.0f);
        gVar.P(i11).setAlpha(qVar.e() ? 0.5f : 1.0f);
        gVar.f1219a.setEnabled(!qVar.e());
    }

    @Override // y5.d
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public b6.g d(Context context, ViewGroup viewGroup) {
        r rVar = new r(context);
        rVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return new b6.g(rVar);
    }
}
