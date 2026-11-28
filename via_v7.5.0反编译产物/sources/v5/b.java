package v5;

import android.content.Context;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tuyafeng.support.utils.x;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b extends RelativeLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f13369c = x.l();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f13370e = x.l();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f13371m = x.l();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements b6.a.InterfaceC0033a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f13372a;

        public a(Context context) {
            this.f13372a = context;
        }

        @Override // b6.a.InterfaceC0033a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(TextView textView) {
            textView.setTextColor(com.tuyafeng.support.utils.e.a(this.f13372a, w7.k.f13732l));
            textView.setMaxLines(1);
            textView.setLines(1);
            textView.setTextSize(0, com.tuyafeng.support.utils.f.d(this.f13372a, w7.n.f13759l));
            textView.setEllipsize(TextUtils.TruncateAt.END);
            r3.o(textView);
            v8.g.d(textView);
        }
    }

    /* JADX INFO: renamed from: v5.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class C0149b implements b6.a.InterfaceC0033a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f13374a;

        public C0149b(Context context) {
            this.f13374a = context;
        }

        @Override // b6.a.InterfaceC0033a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(TextView textView) {
            textView.setTextColor(com.tuyafeng.support.utils.e.a(this.f13374a, w7.k.f13733m));
            textView.setMaxLines(3);
            textView.setTextSize(0, com.tuyafeng.support.utils.f.d(this.f13374a, w7.n.f13760m));
            textView.setEllipsize(TextUtils.TruncateAt.END);
            r3.o(textView);
            v8.g.d(textView);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c implements b6.a.InterfaceC0033a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f13376a;

        public c(Context context) {
            this.f13376a = context;
        }

        @Override // b6.a.InterfaceC0033a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ImageView imageView) {
            imageView.setMaxHeight(x.h(this.f13376a, 48.0f));
            imageView.setColorFilter(v8.h.j(this.f13376a), PorterDuff.Mode.SRC_IN);
        }
    }

    public b(Context context) {
        this(context, null);
    }

    public final void a() {
        Context context = getContext();
        int iH = x.h(context, 20.0f);
        int iH2 = x.h(context, 16.0f);
        x.P(this, com.tuyafeng.support.utils.f.e(context, w7.o.f13786e));
        y.r.f0(this, iH2, iH, iH2 / 5, iH);
        b6.a aVar = new b6.a(new TextView(context), new RelativeLayout.LayoutParams(-1, -2));
        int i10 = f13369c;
        b6.a aVarH = aVar.o(i10).h(1);
        int i11 = f13371m;
        TextView textView = (TextView) aVarH.g(4, i11).V(new a(context)).l();
        b6.a aVar2 = new b6.a(new TextView(context), new RelativeLayout.LayoutParams(-1, -2));
        int i12 = f13370e;
        TextView textView2 = (TextView) aVar2.o(i12).h(1).g(4, i11).g(32, i10).B(1, 0).V(new C0149b(context)).l();
        ImageView imageView = (ImageView) new b6.a(new ImageView(context), new RelativeLayout.LayoutParams(-2, -2)).o(i11).Y(1, 48).h(8).g(16, i10).g(128, i12).y(x.h(context, 12.0f)).F(1, 8).d(w7.o.f13783d).V(new c(context)).l();
        addView(textView);
        addView(textView2);
        addView(imageView);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a();
    }
}
