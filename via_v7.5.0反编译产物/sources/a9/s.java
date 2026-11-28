package a9;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class s extends t5.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f270c = com.tuyafeng.support.utils.x.l();

    public static /* synthetic */ void l(Context context, TextView textView) {
        v8.g.m(textView, v8.h.t(textView.getContext()));
        textView.setGravity(17);
        textView.setSingleLine();
        textView.setLines(1);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxWidth(com.tuyafeng.support.utils.x.h(textView.getContext(), 96.0f));
        textView.setTextColor(v8.h.g(context, v8.h.o(context)));
        v8.g.d(textView);
    }

    @Override // t5.d
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public void b(w5.g gVar, q qVar) {
        super.b(gVar, qVar);
        TextView textView = (TextView) gVar.P(f270c);
        if ("default".equals(qVar.a().d())) {
            textView.setText(gVar.O().getString(w7.u.f13997c2));
        } else {
            textView.setText(qVar.a().e());
        }
        textView.setSelected(qVar.b());
    }

    @Override // t5.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public w5.g d(final Context context, ViewGroup viewGroup) {
        return new w5.g((TextView) new b6.a(new TextView(context), new FrameLayout.LayoutParams(-2, -1)).o(f270c).e(v8.h.f(context)).N(1, 9).V(new b6.a.InterfaceC0033a() { // from class: a9.r
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                s.l(context, (TextView) obj);
            }
        }).l());
    }
}
