package v5;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tuyafeng.support.utils.x;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class i extends RelativeLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f13392c = x.l();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f13393e = x.l();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f13394m = x.l();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements b6.a.InterfaceC0033a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f13395a;

        public a(Context context) {
            this.f13395a = context;
        }

        @Override // b6.a.InterfaceC0033a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(TextView textView) {
            textView.setTextColor(com.tuyafeng.support.utils.e.a(this.f13395a, w7.k.f13732l));
            textView.setMaxLines(1);
            textView.setLines(1);
            textView.setTextSize(0, com.tuyafeng.support.utils.f.d(this.f13395a, w7.n.f13759l));
            textView.setEllipsize(TextUtils.TruncateAt.END);
            r3.o(textView);
            v8.g.d(textView);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements b6.a.InterfaceC0033a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f13397a;

        public b(Context context) {
            this.f13397a = context;
        }

        @Override // b6.a.InterfaceC0033a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(TextView textView) {
            textView.setTextColor(com.tuyafeng.support.utils.e.a(this.f13397a, w7.k.f13733m));
            textView.setMaxLines(3);
            textView.setTextSize(0, com.tuyafeng.support.utils.f.d(this.f13397a, w7.n.f13760m));
            textView.setEllipsize(TextUtils.TruncateAt.END);
            r3.o(textView);
        }
    }

    public i(Context context) {
        this(context, null);
    }

    public static /* synthetic */ void a(CheckBox checkBox) {
        checkBox.setClickable(false);
        checkBox.setFocusable(false);
        checkBox.setButtonDrawable(v8.h.d(checkBox.getContext()));
    }

    public final void b() {
        Context context = getContext();
        int iH = x.h(context, 20.0f);
        int iH2 = x.h(context, 16.0f);
        setPadding(iH2, iH, iH2, iH);
        x.P(this, com.tuyafeng.support.utils.f.e(context, w7.o.f13786e));
        b6.a aVar = new b6.a(new TextView(context), new RelativeLayout.LayoutParams(-1, -2));
        int i10 = f13392c;
        b6.a aVarH = aVar.o(i10).h(8);
        int i11 = f13394m;
        TextView textView = (TextView) aVarH.g(2, i11).V(new a(context)).l();
        TextView textView2 = (TextView) new b6.a(new TextView(context), new RelativeLayout.LayoutParams(-1, -2)).o(f13393e).h(8).g(2, i11).g(32, i10).B(1, 0).V(new b(context)).l();
        CheckBox checkBox = (CheckBox) new b6.a(new CheckBox(context), new RelativeLayout.LayoutParams(-2, x.h(context, 20.0f))).o(i11).h(1).h(144).u(x.h(context, 18.0f)).V(new b6.a.InterfaceC0033a() { // from class: v5.h
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                i.a((CheckBox) obj);
            }
        }).l();
        addView(textView);
        addView(textView2);
        addView(checkBox);
    }

    public i(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public i(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        b();
    }
}
