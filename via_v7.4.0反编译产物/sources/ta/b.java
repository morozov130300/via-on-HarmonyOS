package ta;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import i6.g0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b extends y5.a {
    @Override // y5.d
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void b(b6.g gVar, a aVar) {
        super.b(gVar, aVar);
        TextView textView = (TextView) gVar.P(a6.r.f134e);
        textView.setText(g0.f6993a.d(aVar.b()));
        textView.setAlpha(aVar.c() ? 1.0f : 0.5f);
        gVar.Y(a6.r.f135j, false);
        g6.y.O(gVar.f1219a, g6.f.e(gVar.O(), x7.o.f13723f));
    }

    @Override // y5.d
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public b6.g d(Context context, ViewGroup viewGroup) {
        a6.r rVar = new a6.r(context);
        rVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return new b6.g(rVar);
    }
}
