package ib;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class u extends RelativeLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f6396c = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f6397e = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f6398m = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f6399n = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements b6.a.InterfaceC0033a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f6400a;

        public a(Context context) {
            this.f6400a = context;
        }

        @Override // b6.a.InterfaceC0033a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(TextView textView) {
            textView.setTextColor(com.tuyafeng.support.utils.e.a(this.f6400a, w7.k.f13732l));
            textView.setMaxLines(1);
            textView.setLines(1);
            textView.setTextSize(0, com.tuyafeng.support.utils.f.d(this.f6400a, w7.n.f13759l));
            textView.setEllipsize(TextUtils.TruncateAt.END);
            r3.o(textView);
            v8.g.d(textView);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements b6.a.InterfaceC0033a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f6402a;

        public b(Context context) {
            this.f6402a = context;
        }

        @Override // b6.a.InterfaceC0033a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(TextView textView) {
            textView.setTextColor(com.tuyafeng.support.utils.e.a(this.f6402a, w7.k.f13733m));
            textView.setMaxLines(3);
            textView.setTextSize(0, com.tuyafeng.support.utils.f.d(this.f6402a, w7.n.f13760m));
            textView.setEllipsize(TextUtils.TruncateAt.END);
            r3.o(textView);
            v8.g.d(textView);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c implements b6.a.InterfaceC0033a {
        public c() {
        }

        @Override // b6.a.InterfaceC0033a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CheckBox checkBox) {
            checkBox.setClickable(false);
            checkBox.setFocusable(false);
            checkBox.setButtonDrawable(v8.h.d(checkBox.getContext()));
        }
    }

    public u(Context context) {
        this(context, null);
    }

    public static /* synthetic */ void a(Context context, ImageView imageView) {
        imageView.setImageDrawable(com.tuyafeng.support.utils.f.e(context, w7.o.I));
        r3.n(imageView);
    }

    public final void b() {
        final Context context = getContext();
        int iH = com.tuyafeng.support.utils.x.h(context, 20.0f);
        int iH2 = com.tuyafeng.support.utils.x.h(context, 16.0f);
        setPadding(iH2, iH, iH2, iH);
        com.tuyafeng.support.utils.x.P(this, com.tuyafeng.support.utils.f.e(context, w7.o.f13786e));
        b6.a aVar = new b6.a(new TextView(context), new RelativeLayout.LayoutParams(-1, -2));
        int i10 = f6396c;
        b6.a aVarH = aVar.o(i10).h(1);
        int i11 = f6398m;
        TextView textView = (TextView) aVarH.g(4, i11).V(new a(context)).l();
        TextView textView2 = (TextView) new b6.a(new TextView(context), new RelativeLayout.LayoutParams(-1, -2)).o(f6397e).h(1).g(4, i11).g(32, i10).B(1, 0).V(new b(context)).l();
        b6.a aVarY = new b6.a(new ImageView(context), new RelativeLayout.LayoutParams(-2, -2)).o(i11).Y(1, 48);
        int i12 = f6399n;
        ImageView imageView = (ImageView) aVarY.g(4, i12).h(144).N(1, 13).x(1, 16).V(new b6.a.InterfaceC0033a() { // from class: ib.t
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                u.a(context, (ImageView) obj);
            }
        }).l();
        CheckBox checkBox = (CheckBox) new b6.a(new CheckBox(context), new RelativeLayout.LayoutParams(-2, com.tuyafeng.support.utils.x.h(context, 20.0f))).o(i12).h(8).h(144).V(new c()).l();
        addView(textView);
        addView(textView2);
        addView(imageView);
        addView(checkBox);
    }

    public u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public u(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        b();
    }
}
