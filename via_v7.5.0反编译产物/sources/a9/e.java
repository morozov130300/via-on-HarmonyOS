package a9;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import x8.r3;
import x8.x0;
import x8.y0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e extends t5.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f210d = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f211e = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f212f = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f213c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends p5.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a9.a f214c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ w5.g f215d;

        public a(a9.a aVar, w5.g gVar) {
            this.f214c = aVar;
            this.f215d = gVar;
        }

        @Override // p5.c
        public void a(View view) {
            if (e.this.f213c != null) {
                e.this.f213c.a(view, this.f214c, this.f215d.l());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface b {
        void a(View view, a9.a aVar, int i10);
    }

    public static /* synthetic */ void l(Context context, TextView textView) {
        v8.g.l(textView);
        v8.g.m(textView, v8.h.t(context));
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMinWidth(com.tuyafeng.support.utils.x.h(context, 56.0f));
        textView.setMaxWidth(com.tuyafeng.support.utils.x.h(context, 120.0f));
        v8.g.d(textView);
    }

    public static /* synthetic */ void m(Context context, ImageView imageView) {
        r3.n(imageView);
        imageView.setImageDrawable(lb.g.a(context, w7.o.f13846y, w7.u.je));
    }

    @Override // t5.d
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public void b(w5.g gVar, a9.a aVar) {
        super.b(gVar, aVar);
        if (aVar instanceof z) {
            ImageView imageView = (ImageView) gVar.P(f210d);
            Bitmap bitmapD = x0.c().d(gVar.O(), ((z) aVar).c());
            if (bitmapD != null) {
                y0.i(imageView, bitmapD, null);
            } else {
                Drawable drawableA = lb.g.a(gVar.O(), w7.o.I1, w7.u.Rf);
                com.tuyafeng.support.utils.h.a(drawableA, com.tuyafeng.support.utils.e.a(gVar.O(), w7.k.f13729i));
                imageView.setImageDrawable(drawableA);
            }
        }
        gVar.X(f211e, aVar.getTitle());
        gVar.P(f212f).setOnClickListener(new a(aVar, gVar));
    }

    @Override // t5.d
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public w5.g d(final Context context, ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) new b6.a(new LinearLayout(context), new FrameLayout.LayoutParams(-2, -1)).e(new com.tuyafeng.support.utils.g().h(545292416).c(v8.h.e(context)).a()).V(new b6.a.InterfaceC0033a() { // from class: a9.b
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(0);
            }
        }).l();
        ImageView imageView = (ImageView) new b6.a(new ImageView(context), new LinearLayout.LayoutParams(-2, -2)).o(f210d).Y(1, 36).n(1, 36).p(16).F(1, 9).l();
        TextView textView = (TextView) new b6.a(new TextView(context), new LinearLayout.LayoutParams(-2, -2)).p(16).o(f211e).V(new b6.a.InterfaceC0033a() { // from class: a9.c
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                e.l(context, (TextView) obj);
            }
        }).l();
        ImageView imageView2 = (ImageView) new b6.a(new ImageView(context), new LinearLayout.LayoutParams(-2, -2)).o(f212f).Y(1, 36).n(1, 36).p(16).F(1, 9).d(w7.o.f13789f).V(new b6.a.InterfaceC0033a() { // from class: a9.d
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                e.m(context, (ImageView) obj);
            }
        }).l();
        linearLayout.addView(imageView);
        linearLayout.addView(textView);
        linearLayout.addView(imageView2);
        return new w5.g(linearLayout);
    }

    public void r(b bVar) {
        this.f213c = bVar;
    }
}
