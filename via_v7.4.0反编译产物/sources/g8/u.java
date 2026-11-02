package g8;

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
import g6.y;
import h6.a;
import i6.i0;
import z8.b0;
import z8.r3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class u extends y5.d {

    /* renamed from: b, reason: collision with root package name */
    public static final int f6299b = y.l();

    /* renamed from: c, reason: collision with root package name */
    public static final int f6300c = y.l();

    /* renamed from: d, reason: collision with root package name */
    public static final int f6301d = y.l();

    /* renamed from: e, reason: collision with root package name */
    public static final int f6302e = y.l();

    /* renamed from: a, reason: collision with root package name */
    public b f6303a = null;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends v5.c {
        public a() {
        }

        @Override // v5.c
        public void a(View view) {
            if (u.f6302e == view.getId()) {
                TextView textView = (TextView) view;
                if (textView.getMaxLines() <= 2) {
                    double length = textView.getText().length();
                    Double.isNaN(length);
                    int iMin = Math.min(12, Math.max(3, (int) Math.ceil(length / 40.0d)));
                    int i10 = iMin < 8 ? iMin >= 5 ? 13 : 14 : 12;
                    textView.setMaxLines(iMin);
                    textView.setTextSize(2, i10);
                } else {
                    textView.setMaxLines(2);
                    textView.setTextSize(2, 14.0f);
                }
            }
            if (u.this.f6303a == null) {
                return;
            }
            if (u.f6299b == view.getId()) {
                u.this.f6303a.b();
            } else if (u.f6300c == view.getId()) {
                u.this.f6303a.a();
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface b {
        void a();

        void b();
    }

    public static /* synthetic */ boolean i(Context context, String str, View view) {
        g6.n.a(context, str, x7.u.pg);
        return true;
    }

    public static /* synthetic */ void j(Context context, ImageView imageView) {
        r3.m(imageView);
        imageView.setImageDrawable(lb.b.a(context, x7.o.f13748n0, x7.u.ie));
    }

    public static /* synthetic */ void k(Context context, TextView textView) {
        textView.setTextSize(2, 14.0f);
        textView.setLineSpacing(y.h(context, 2.0f), 1.0f);
        textView.setTextColor(x8.h.q(context));
        textView.setMaxLines(2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        r3.n(textView);
        x8.g.d(textView);
    }

    public static /* synthetic */ void l(Context context, ImageView imageView) {
        r3.m(imageView);
        imageView.setImageDrawable(lb.b.a(context, x7.o.S0, x7.u.lf));
    }

    public static /* synthetic */ void m(Context context, TextView textView) {
        textView.setTextSize(0, x8.h.s(context));
        textView.setLineSpacing(y.h(context, 2.0f), 1.0f);
        textView.setTextColor(x8.h.p(context));
        textView.setMaxLines(2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        r3.n(textView);
        x8.g.d(textView);
    }

    public static /* synthetic */ boolean n(String str, Context context, View view) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        g6.n.a(context, str, x7.u.og);
        return true;
    }

    @Override // y5.d
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void b(b6.g gVar, m mVar) {
        final Context contextO = gVar.O();
        final String strB = mVar.b();
        final String strA = mVar.a();
        int i10 = f6301d;
        gVar.X(i10, (strA == null || strA.isEmpty()) ? contextO.getString(x7.u.bh) : strA);
        if (strB == null || strB.isEmpty() || u9.d.m(contextO, strB)) {
            gVar.Y(f6302e, false);
            gVar.Y(f6300c, false);
            gVar.Y(f6299b, false);
        } else {
            String strE = b0.E(strB);
            SpannableString spannableString = new SpannableString(strE);
            if (mVar.c() && i0.f7006a.n(strE)) {
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#238e45")), 0, 5, 34);
            }
            int iIndexOf = strE.indexOf("://") + 3;
            int iIndexOf2 = strE.indexOf(47, iIndexOf);
            if (iIndexOf < iIndexOf2) {
                spannableString.setSpan(new ForegroundColorSpan(((TextView) gVar.P(i10)).getTextColors().getDefaultColor()), iIndexOf, iIndexOf2, 34);
            }
            int i11 = f6302e;
            ((TextView) gVar.P(i11)).setText(spannableString);
            gVar.Y(i11, true);
            gVar.Y(f6299b, true);
        }
        a aVar = new a();
        gVar.P(f6299b).setOnClickListener(aVar);
        gVar.P(f6300c).setOnClickListener(aVar);
        gVar.P(i10).setOnClickListener(aVar);
        int i12 = f6302e;
        gVar.P(i12).setOnClickListener(aVar);
        gVar.P(i10).setOnLongClickListener(new View.OnLongClickListener() { // from class: g8.o
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return u.n(strA, contextO, view);
            }
        });
        gVar.P(i12).setOnLongClickListener(new View.OnLongClickListener() { // from class: g8.p
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return u.i(contextO, strB, view);
            }
        });
    }

    @Override // y5.d
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public b6.g d(final Context context, ViewGroup viewGroup) {
        RelativeLayout relativeLayout = (RelativeLayout) new h6.a(new RelativeLayout(context), new FrameLayout.LayoutParams(-1, -2)).l();
        int iD = g6.f.d(context, x7.n.E);
        int iD2 = g6.f.d(context, x7.n.D);
        ImageView imageView = (ImageView) new h6.a(new ImageView(context), new RelativeLayout.LayoutParams(iD, iD)).o(f6299b).j(context.getString(x7.u.Ca)).M(iD2).d(x7.o.f13726g).h(152).V(new a.InterfaceC0076a() { // from class: g8.q
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                u.l(context, (ImageView) obj);
            }
        }).l();
        ImageView imageView2 = (ImageView) new h6.a(new ImageView(context), new RelativeLayout.LayoutParams(iD, iD)).o(f6300c).j(context.getString(x7.u.H)).M(iD2).d(x7.o.f13726g).h(144).g(4, imageView.getId()).c(true).V(new a.InterfaceC0076a() { // from class: g8.r
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                u.j(context, (ImageView) obj);
            }
        }).l();
        TextView textView = (TextView) new h6.a(new TextView(context), new RelativeLayout.LayoutParams(-1, -2)).o(f6301d).R(1, 12).J(1, 2).P(1, 16).L(1, 4).g(4, imageView2.getId()).V(new a.InterfaceC0076a() { // from class: g8.s
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                u.m(context, (TextView) obj);
            }
        }).l();
        TextView textView2 = (TextView) new h6.a(new TextView(context), new RelativeLayout.LayoutParams(-1, -2)).o(f6302e).R(1, 2).J(1, 2).P(1, 4).L(1, 4).z(1, 12).t(1, 8).g(4, imageView2.getId()).g(32, textView.getId()).d(x7.o.f13711b).V(new a.InterfaceC0076a() { // from class: g8.t
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                u.k(context, (TextView) obj);
            }
        }).l();
        relativeLayout.addView(imageView);
        relativeLayout.addView(imageView2);
        relativeLayout.addView(textView2);
        relativeLayout.addView(textView);
        return new b6.g(relativeLayout);
    }

    public void u(b bVar) {
        this.f6303a = bVar;
    }
}
