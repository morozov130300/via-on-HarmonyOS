package a9;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;
import x8.r3;
import x8.u3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class y extends t5.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f277d = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f278e = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f279f = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f280g = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f281h = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f282c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        boolean a(int i10);
    }

    public static /* synthetic */ void l(Context context, TextView textView) {
        textView.setTextColor(v8.h.p(context));
        v8.g.m(textView, v8.h.u(context));
        v8.g.d(textView);
    }

    public static /* synthetic */ void m(Context context, TextView textView) {
        textView.setTextColor(v8.h.p(context));
        v8.g.m(textView, v8.h.t(context));
        textView.setSingleLine();
        textView.setLines(1);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        v8.g.d(textView);
    }

    public static /* synthetic */ void n(Context context, ImageView imageView) {
        imageView.setImageDrawable(lb.g.a(context, w7.o.f13851z1, w7.u.Of));
        r3.n(imageView);
    }

    public static /* synthetic */ void o(Context context, TextView textView) {
        v8.g.l(textView);
        v8.g.m(textView, v8.h.q(context));
        v8.g.k(textView);
        v8.g.d(textView);
    }

    @Override // t5.d
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public void b(w5.g gVar, n9.r rVar) {
        super.b(gVar, rVar);
        gVar.X(f278e, com.tuyafeng.support.utils.p.n(rVar.d(), gVar.O().getString(w7.u.Ah)));
        gVar.X(f279f, com.tuyafeng.support.utils.p.n(rVar.e(), gVar.O().getString(w7.u.f13990b9)));
        gVar.X(f280g, u3.a(gVar.O(), rVar.f()));
        a aVar = this.f282c;
        s(gVar, aVar != null && aVar.a(gVar.l()));
    }

    @Override // t5.d
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void c(w5.g gVar, n9.r rVar, List list) {
        Iterator it = list.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof Boolean) {
                s(gVar, next == Boolean.TRUE);
                z10 = true;
            }
        }
        if (z10) {
            return;
        }
        super.c(gVar, rVar, list);
    }

    @Override // t5.d
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public w5.g d(final Context context, ViewGroup viewGroup) {
        RelativeLayout relativeLayout = (RelativeLayout) new b6.a(new RelativeLayout(context), new FrameLayout.LayoutParams(-1, -2)).o(f277d).d(w7.o.f13786e).l();
        b6.a aVar = new b6.a(new ImageView(context), new RelativeLayout.LayoutParams(-2, -2));
        int i10 = f281h;
        ImageView imageView = (ImageView) aVar.o(i10).Y(1, 48).n(1, 48).z(1, 3).N(1, 13).h(144).V(new b6.a.InterfaceC0033a() { // from class: a9.u
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                y.n(context, (ImageView) obj);
            }
        }).l();
        b6.a aVar2 = new b6.a(new TextView(context), new RelativeLayout.LayoutParams(-1, -2));
        int i11 = f278e;
        b6.a aVarT = aVar2.o(i11).B(1, 16).t(1, 2);
        int i12 = f280g;
        TextView textView = (TextView) aVarT.g(4, i12).g(2, i10).V(new b6.a.InterfaceC0033a() { // from class: a9.v
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                y.o(context, (TextView) obj);
            }
        }).l();
        TextView textView2 = (TextView) new b6.a(new TextView(context), new RelativeLayout.LayoutParams(-2, -2)).o(i12).g(16, i11).h(8).z(1, 2).v(1, 16).V(new b6.a.InterfaceC0033a() { // from class: a9.w
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                y.l(context, (TextView) obj);
            }
        }).l();
        TextView textView3 = (TextView) new b6.a(new TextView(context), new RelativeLayout.LayoutParams(-1, -2)).o(f279f).g(32, i11).g(1, i11).t(1, 16).v(1, 16).V(new b6.a.InterfaceC0033a() { // from class: a9.x
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                y.m(context, (TextView) obj);
            }
        }).l();
        relativeLayout.addView(imageView);
        relativeLayout.addView(textView);
        relativeLayout.addView(textView2);
        relativeLayout.addView(textView3);
        return new w5.g(relativeLayout);
    }

    public final void s(w5.g gVar, boolean z10) {
        Context contextO = gVar.O();
        if (z10) {
            gVar.R(f277d, com.tuyafeng.support.utils.f.b(contextO, w7.m.f13739c));
        } else {
            gVar.S(f277d, w7.o.f13786e);
        }
    }

    public void t(a aVar) {
        this.f282c = aVar;
    }
}
