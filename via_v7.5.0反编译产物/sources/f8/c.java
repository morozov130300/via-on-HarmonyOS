package f8;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tuyafeng.support.utils.f;
import com.tuyafeng.support.utils.x;
import v8.h;
import w5.g;
import w7.n;
import w7.o;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c extends t5.a {
    public static /* synthetic */ void l(Context context, TextView textView) {
        textView.setCompoundDrawablePadding(x.h(context, 2.0f));
        textView.setTextSize(0, h.u(context));
        textView.setGravity(17);
        textView.setLines(2);
        textView.setMaxLines(2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTypeface(Typeface.DEFAULT);
    }

    @Override // t5.d
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public long a(a aVar) {
        return aVar.c();
    }

    @Override // t5.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public void b(g gVar, a aVar) {
        super.b(gVar, aVar);
        if (aVar.c() == 22) {
            gVar.f1138a.setVisibility(8);
            return;
        }
        gVar.f1138a.setVisibility(0);
        Context context = gVar.f1138a.getContext();
        TextView textView = (TextView) gVar.f1138a;
        textView.setText(aVar.d());
        textView.setContentDescription(aVar.a());
        if (aVar.f()) {
            int iJ = h.j(context);
            com.tuyafeng.support.utils.h.a(aVar.b(), iJ);
            textView.setTextColor(iJ);
        } else {
            com.tuyafeng.support.utils.h.a(aVar.b(), h.l(context));
            textView.setTextColor(h.o(context));
        }
        v8.g.e(textView, aVar.f() ? 1 : 0);
        int iD = f.d(context, n.f13768u);
        aVar.b().setBounds(0, 0, iD, iD);
        textView.setCompoundDrawables(null, aVar.b(), null, null);
        textView.setEnabled(aVar.e());
        textView.setAlpha(aVar.e() ? 1.0f : 0.35f);
    }

    @Override // t5.d
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public g d(final Context context, ViewGroup viewGroup) {
        int measuredWidth = viewGroup.getMeasuredWidth() / 5;
        if (measuredWidth <= 0) {
            measuredWidth = x.h(context, 64.0f);
        }
        return new g((TextView) new b6.a(new TextView(context), new FrameLayout.LayoutParams(measuredWidth, -2)).e(f.e(context, o.f13783d)).S(x.h(context, 15.0f)).M(x.h(context, 5.0f)).V(new b6.a.InterfaceC0033a() { // from class: f8.b
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                c.l(context, (TextView) obj);
            }
        }).l());
    }
}
