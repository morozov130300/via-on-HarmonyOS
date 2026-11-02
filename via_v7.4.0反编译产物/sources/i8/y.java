package i8;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import h6.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class y extends y5.d {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f7099a;

        public a(Context context) {
            this.f7099a = context;
        }

        @Override // h6.a.InterfaceC0076a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(TextView textView) {
            textView.setTextColor(g6.e.a(this.f7099a, x7.k.f13666l));
            textView.setTextSize(0, g6.f.d(this.f7099a, x7.n.f13693l));
            textView.setGravity(17);
            x8.g.d(textView);
        }
    }

    @Override // y5.d
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void b(b6.g gVar, x xVar) {
        ((TextView) gVar.f1219a).setText(xVar.a());
    }

    @Override // y5.d
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public b6.g d(Context context, ViewGroup viewGroup) {
        return new b6.g((TextView) new h6.a(new TextView(context), new FrameLayout.LayoutParams(-1, -2)).M(g6.y.h(context, 16.0f)).B(1, 16).t(1, 16).V(new a(context)).l());
    }
}
