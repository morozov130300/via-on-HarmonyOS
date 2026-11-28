package ib;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a0 extends RelativeLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f6340c = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f6341e = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f6342m = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f6343n = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements b6.a.InterfaceC0033a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f6344a;

        public a(Context context) {
            this.f6344a = context;
        }

        @Override // b6.a.InterfaceC0033a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(TextView textView) {
            textView.setTextColor(com.tuyafeng.support.utils.e.a(this.f6344a, w7.k.f13732l));
            textView.setMaxLines(1);
            textView.setLines(1);
            textView.setTextSize(0, v8.h.q(this.f6344a));
            textView.setEllipsize(TextUtils.TruncateAt.END);
            r3.o(textView);
            v8.g.d(textView);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements b6.a.InterfaceC0033a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f6346a;

        public b(Context context) {
            this.f6346a = context;
        }

        @Override // b6.a.InterfaceC0033a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(TextView textView) {
            textView.setMinWidth(com.tuyafeng.support.utils.x.h(this.f6346a, 32.0f));
            textView.setTextColor(com.tuyafeng.support.utils.e.a(this.f6346a, w7.k.f13733m));
            textView.setTextSize(0, v8.h.q(this.f6346a));
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setGravity(17);
            v8.g.d(textView);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c implements b6.a.InterfaceC0033a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f6348a;

        public c(Context context) {
            this.f6348a = context;
        }

        @Override // b6.a.InterfaceC0033a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(TextView textView) {
            textView.setMinHeight(com.tuyafeng.support.utils.x.h(this.f6348a, 36.0f));
            textView.setTextColor(v8.h.o(this.f6348a));
            textView.setMaxLines(3);
            textView.setTextSize(0, v8.h.r(this.f6348a));
            textView.setEllipsize(TextUtils.TruncateAt.END);
            r3.o(textView);
            v8.g.d(textView);
        }
    }

    public a0(Context context) {
        this(context, null);
    }

    public final void a() {
        Context context = getContext();
        int iH = com.tuyafeng.support.utils.x.h(context, 20.0f);
        int iH2 = com.tuyafeng.support.utils.x.h(context, 16.0f);
        setPadding(iH2, iH, iH2, iH);
        com.tuyafeng.support.utils.x.P(this, com.tuyafeng.support.utils.f.e(context, w7.o.f13786e));
        b6.a aVar = new b6.a(new TextView(context), new RelativeLayout.LayoutParams(-1, -2));
        int i10 = f6340c;
        TextView textView = (TextView) aVar.o(i10).V(new a(context)).l();
        b6.a aVar2 = new b6.a(new TextView(context), new RelativeLayout.LayoutParams(-2, -2));
        int i11 = f6342m;
        TextView textView2 = (TextView) aVar2.o(i11).h(1).g(32, i10).B(1, 2).V(new b(context)).l();
        SeekBar seekBar = (SeekBar) new b6.a(new SeekBar(new ContextThemeWrapper(context, w7.v.f14329f)), new RelativeLayout.LayoutParams(-1, -2)).o(f6341e).h(8).g(2, i11).g(16, i11).A((-com.tuyafeng.support.utils.x.h(context, 3.0f)) + (v8.h.t(context) / 2)).V(new e8.e()).l();
        TextView textView3 = (TextView) new b6.a(new TextView(context), new RelativeLayout.LayoutParams(-1, -2)).o(f6343n).g(32, i11).B(1, 12).F(1, 16).e(new com.tuyafeng.support.utils.g().h(813727872).c(com.tuyafeng.support.utils.f.d(context, w7.n.f13764q)).a()).V(new c(context)).l();
        addView(textView);
        addView(textView2);
        addView(seekBar);
        addView(textView3);
        setDescendantFocusability(262144);
    }

    public a0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a();
    }
}
