package e8;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c6.a2;
import com.tuyafeng.support.utils.x;
import x8.r3;
import x8.z;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class u extends t5.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f4314b = x.l();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f4315c = x.l();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f4316d = x.l();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f4317e = x.l();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f4318a = null;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends p5.c {
        public a() {
        }

        @Override // p5.c
        public void a(View view) {
            if (u.f4317e == view.getId()) {
                TextView textView = (TextView) view;
                if (textView.getMaxLines() <= 2) {
                    double length = textView.getText().length();
                    Double.isNaN(length);
                    int iMax = Math.max(3, (int) Math.ceil(length / 40.0d));
                    int i10 = 12;
                    int iMin = Math.min(12, iMax);
                    if (iMin < 8) {
                        i10 = iMin >= 5 ? 13 : 14;
                    }
                    textView.setMaxLines(iMin);
                    textView.setTextSize(2, i10);
                } else {
                    textView.setMaxLines(2);
                    textView.setTextSize(2, 14.0f);
                }
            }
            if (u.this.f4318a == null) {
                return;
            }
            if (u.f4314b == view.getId()) {
                u.this.f4318a.b();
            } else if (u.f4315c == view.getId()) {
                u.this.f4318a.a();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface b {
        void a();

        void b();
    }

    public static /* synthetic */ boolean i(Context context, String str, View view) {
        com.tuyafeng.support.utils.n.a(context, str, w7.u.Fg);
        return true;
    }

    public static /* synthetic */ void j(Context context, ImageView imageView) {
        r3.n(imageView);
        imageView.setImageDrawable(lb.g.a(context, w7.o.f13817o0, w7.u.ye));
    }

    public static /* synthetic */ void k(Context context, TextView textView) {
        textView.setTextSize(2, 14.0f);
        textView.setLineSpacing(x.h(context, 2.0f), 1.0f);
        textView.setTextColor(v8.h.p(context));
        textView.setMaxLines(2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        r3.o(textView);
        v8.g.d(textView);
    }

    public static /* synthetic */ void l(Context context, ImageView imageView) {
        r3.n(imageView);
        imageView.setImageDrawable(lb.g.a(context, w7.o.Q0, w7.u.Cf));
    }

    public static /* synthetic */ void m(Context context, TextView textView) {
        textView.setTextSize(0, v8.h.r(context));
        textView.setLineSpacing(x.h(context, 2.0f), 1.0f);
        textView.setTextColor(v8.h.o(context));
        textView.setMaxLines(2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        r3.o(textView);
        v8.g.d(textView);
    }

    public static /* synthetic */ boolean n(String str, Context context, View view) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        com.tuyafeng.support.utils.n.a(context, str, w7.u.Eg);
        return true;
    }

    @Override // t5.d
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public void b(w5.g gVar, m mVar) {
        final Context contextO = gVar.O();
        final String strB = mVar.b();
        final String strA = mVar.a();
        int i10 = f4316d;
        gVar.X(i10, (strA == null || strA.isEmpty()) ? contextO.getString(w7.u.Ah) : strA);
        if (strB == null || strB.isEmpty() || s9.d.l(contextO, strB)) {
            gVar.Y(f4317e, false);
            gVar.Y(f4315c, false);
            gVar.Y(f4314b, false);
        } else {
            String strD = z.D(strB);
            SpannableString spannableString = new SpannableString(strD);
            if (mVar.c() && a2.f1958a.o(strD)) {
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#238e45")), 0, 5, 34);
            }
            int iIndexOf = strD.indexOf("://") + 3;
            int iIndexOf2 = strD.indexOf(47, iIndexOf);
            if (iIndexOf < iIndexOf2) {
                spannableString.setSpan(new ForegroundColorSpan(((TextView) gVar.P(i10)).getTextColors().getDefaultColor()), iIndexOf, iIndexOf2, 34);
            }
            int i11 = f4317e;
            ((TextView) gVar.P(i11)).setText(spannableString);
            gVar.Y(i11, true);
            gVar.Y(f4314b, true);
        }
        a aVar = new a();
        gVar.P(f4314b).setOnClickListener(aVar);
        gVar.P(f4315c).setOnClickListener(aVar);
        gVar.P(i10).setOnClickListener(aVar);
        int i12 = f4317e;
        gVar.P(i12).setOnClickListener(aVar);
        gVar.P(i10).setOnLongClickListener(new View.OnLongClickListener() { // from class: e8.o
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return u.n(strA, contextO, view);
            }
        });
        gVar.P(i12).setOnLongClickListener(new View.OnLongClickListener() { // from class: e8.p
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return u.i(contextO, strB, view);
            }
        });
    }

    @Override // t5.d
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public w5.g d(final Context context, ViewGroup viewGroup) {
        RelativeLayout relativeLayout = (RelativeLayout) new b6.a(new RelativeLayout(context), new FrameLayout.LayoutParams(-1, -2)).l();
        int iD = com.tuyafeng.support.utils.f.d(context, w7.n.G);
        int iD2 = com.tuyafeng.support.utils.f.d(context, w7.n.F);
        ImageView imageView = (ImageView) new b6.a(new ImageView(context), new RelativeLayout.LayoutParams(iD, iD)).o(f4314b).j(context.getString(w7.u.Oa)).M(iD2).d(w7.o.f13789f).h(152).V(new b6.a.InterfaceC0033a() { // from class: e8.q
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                u.l(context, (ImageView) obj);
            }
        }).l();
        ImageView imageView2 = (ImageView) new b6.a(new ImageView(context), new RelativeLayout.LayoutParams(iD, iD)).o(f4315c).j(context.getString(w7.u.I)).M(iD2).d(w7.o.f13789f).h(144).g(4, imageView.getId()).c(true).V(new b6.a.InterfaceC0033a() { // from class: e8.r
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                u.j(context, (ImageView) obj);
            }
        }).l();
        TextView textView = (TextView) new b6.a(new TextView(context), new RelativeLayout.LayoutParams(-1, -2)).o(f4316d).R(1, 12).J(1, 2).P(1, 16).L(1, 4).g(4, imageView2.getId()).V(new b6.a.InterfaceC0033a() { // from class: e8.s
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                u.m(context, (TextView) obj);
            }
        }).l();
        TextView textView2 = (TextView) new b6.a(new TextView(context), new RelativeLayout.LayoutParams(-1, -2)).o(f4317e).R(1, 2).J(1, 2).P(1, 4).L(1, 4).z(1, 12).t(1, 8).g(4, imageView2.getId()).g(32, textView.getId()).d(w7.o.f13774a).V(new b6.a.InterfaceC0033a() { // from class: e8.t
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                u.k(context, (TextView) obj);
            }
        }).l();
        relativeLayout.addView(imageView);
        relativeLayout.addView(imageView2);
        relativeLayout.addView(textView2);
        relativeLayout.addView(textView);
        return new w5.g(relativeLayout);
    }

    public void u(b bVar) {
        this.f4318a = bVar;
    }
}
