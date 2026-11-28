package v5;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tuyafeng.support.utils.x;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class r extends LinearLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f13418c = x.l();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f13419e = x.l();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements b6.a.InterfaceC0033a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f13420a;

        public a(Context context) {
            this.f13420a = context;
        }

        @Override // b6.a.InterfaceC0033a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(TextView textView) {
            textView.setTextColor(com.tuyafeng.support.utils.e.a(this.f13420a, w7.k.f13732l));
            textView.setMaxLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setTextSize(0, com.tuyafeng.support.utils.f.d(this.f13420a, w7.n.f13759l));
            r3.o(textView);
            v8.g.d(textView);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements b6.a.InterfaceC0033a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f13422a;

        public b(Context context) {
            this.f13422a = context;
        }

        @Override // b6.a.InterfaceC0033a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(TextView textView) {
            textView.setTextColor(com.tuyafeng.support.utils.e.a(this.f13422a, w7.k.f13733m));
            textView.setMaxLines(3);
            textView.setTextSize(0, com.tuyafeng.support.utils.f.d(this.f13422a, w7.n.f13760m));
            textView.setEllipsize(TextUtils.TruncateAt.END);
            r3.o(textView);
            v8.g.d(textView);
        }
    }

    public r(Context context) {
        this(context, null);
    }

    public final void a() {
        Context context = getContext();
        int iH = x.h(context, 20.0f);
        int iH2 = x.h(context, 16.0f);
        setPadding(iH2, iH, iH2, iH);
        x.P(this, com.tuyafeng.support.utils.f.e(context, w7.o.f13786e));
        setOrientation(1);
        TextView textView = (TextView) new b6.a(new TextView(context), new FrameLayout.LayoutParams(-1, -2)).o(f13418c).V(new a(context)).l();
        TextView textView2 = (TextView) new b6.a(new TextView(context), new FrameLayout.LayoutParams(-2, -2)).o(f13419e).B(1, 0).V(new b(context)).l();
        addView(textView);
        addView(textView2);
    }

    public r(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public r(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a();
    }
}
