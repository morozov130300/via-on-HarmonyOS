package g8;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class y extends t5.d {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements b6.a.InterfaceC0033a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f5586a;

        public a(Context context) {
            this.f5586a = context;
        }

        @Override // b6.a.InterfaceC0033a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(TextView textView) {
            textView.setTextColor(com.tuyafeng.support.utils.e.a(this.f5586a, w7.k.f13733m));
            textView.setTextSize(0, com.tuyafeng.support.utils.f.d(this.f5586a, w7.n.f13759l));
            textView.setGravity(17);
            v8.g.d(textView);
        }
    }

    @Override // t5.d
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public void b(w5.g gVar, x xVar) {
        ((TextView) gVar.f1138a).setText(xVar.a());
    }

    @Override // t5.d
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public w5.g d(Context context, ViewGroup viewGroup) {
        return new w5.g((TextView) new b6.a(new TextView(context), new FrameLayout.LayoutParams(-1, -2)).M(com.tuyafeng.support.utils.x.h(context, 16.0f)).B(1, 16).t(1, 16).V(new a(context)).l());
    }
}
