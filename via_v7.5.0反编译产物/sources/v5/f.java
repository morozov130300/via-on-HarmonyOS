package v5;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tuyafeng.support.utils.x;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f extends t5.a {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements b6.a.InterfaceC0033a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f13390a;

        public a(Context context) {
            this.f13390a = context;
        }

        @Override // b6.a.InterfaceC0033a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(com.tuyafeng.support.widget.d dVar) {
            dVar.d(x.h(this.f13390a, 18.0f), x.h(this.f13390a, 18.0f));
            dVar.setCompoundDrawablePadding(x.h(this.f13390a, 18.0f));
            dVar.setDrawableTint(com.tuyafeng.support.utils.e.a(this.f13390a, w7.k.f13732l));
            dVar.setTextColor(com.tuyafeng.support.utils.e.a(this.f13390a, w7.k.f13732l));
            dVar.setTextSize(0, com.tuyafeng.support.utils.f.d(this.f13390a, w7.n.f13759l));
            dVar.setMaxLines(1);
            dVar.setEllipsize(TextUtils.TruncateAt.END);
            r3.o(dVar);
            v8.g.d(dVar);
        }
    }

    @Override // t5.d
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public long a(e eVar) {
        return eVar.d();
    }

    @Override // t5.d
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public void b(w5.g gVar, e eVar) {
        super.b(gVar, eVar);
        TextView textView = (TextView) gVar.f1138a;
        textView.setText(eVar.a());
        textView.setAlpha(eVar.e() ? 0.5f : 1.0f);
        textView.setEnabled(!eVar.e());
        androidx.core.widget.d.a(textView, eVar.c(), null, null, null);
    }

    @Override // t5.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public w5.g d(Context context, ViewGroup viewGroup) {
        return new w5.g((TextView) new b6.a(new com.tuyafeng.support.widget.d(context), new FrameLayout.LayoutParams(-1, -2)).S(x.h(context, 20.0f)).M(x.h(context, 16.0f)).e(com.tuyafeng.support.utils.f.e(context, w7.o.f13786e)).V(new a(context)).l());
    }
}
