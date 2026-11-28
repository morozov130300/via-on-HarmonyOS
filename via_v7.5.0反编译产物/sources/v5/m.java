package v5;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tuyafeng.support.utils.x;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class m extends t5.d {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements b6.a.InterfaceC0033a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f13401a;

        public a(Context context) {
            this.f13401a = context;
        }

        @Override // b6.a.InterfaceC0033a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(TextView textView) {
            textView.setTextColor(v8.h.j(this.f13401a));
            textView.setTextSize(0, com.tuyafeng.support.utils.f.d(this.f13401a, w7.n.f13760m));
            v8.g.d(textView);
            textView.setTypeface(textView.getTypeface(), 1);
            r3.o(textView);
        }
    }

    @Override // t5.d
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public void b(w5.g gVar, l lVar) {
        ((TextView) gVar.f1138a).setText(lVar.a());
    }

    @Override // t5.d
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public w5.g d(Context context, ViewGroup viewGroup) {
        return new w5.g((TextView) new b6.a(new TextView(context), new FrameLayout.LayoutParams(-1, -2)).M(x.h(context, 16.0f)).Q(x.h(context, 12.0f)).I(x.h(context, 4.0f)).V(new a(context)).l());
    }
}
