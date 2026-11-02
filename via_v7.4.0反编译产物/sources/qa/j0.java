package qa;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import z8.w3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class j0 extends y5.a {

    /* renamed from: c, reason: collision with root package name */
    public final String f11378c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f11379d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f11380e;

    /* renamed from: f, reason: collision with root package name */
    public final int f11381f;

    /* renamed from: g, reason: collision with root package name */
    public final int f11382g;

    /* renamed from: h, reason: collision with root package name */
    public final int f11383h;

    /* renamed from: i, reason: collision with root package name */
    public a f11384i;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {
        void a(View view, int i10);
    }

    public j0(String str, i9.c cVar, Resources resources) {
        this.f11378c = str;
        int iB = cVar.b();
        int iD = cVar.d();
        iB = iB == 0 ? iD : iB;
        iD = iD == 0 ? iB : iD;
        if (iB == 0) {
            iB = 54;
            iD = 54;
        }
        float f10 = resources.getDisplayMetrics().density;
        this.f11382g = (int) ((iD * f10) + 0.5f);
        this.f11381f = (int) ((iB * f10) + 0.5f);
        this.f11383h = (int) (((cVar.c() / 100.0f) * Math.min(r3, r0)) / 2.0f);
        this.f11380e = cVar.e();
        this.f11379d = cVar.f();
    }

    public static /* synthetic */ void l(j0 j0Var, b6.g gVar, View view) {
        a aVar;
        j0Var.getClass();
        int iL = gVar.l();
        if (iL == -1 || (aVar = j0Var.f11384i) == null) {
            return;
        }
        aVar.a(view, iL);
    }

    public int m() {
        return this.f11382g;
    }

    @Override // y5.d
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void b(final b6.g gVar, n9.b bVar) {
        super.b(gVar, bVar);
        gVar.X(x7.p.f13827n1, bVar.e());
        Drawable drawableJ = this.f11379d ? null : w3.j(this.f11378c, bVar.g(), this.f11382g, this.f11381f, this.f11383h);
        if (drawableJ == null) {
            if (bVar.e().length() > 0) {
                gVar.X(x7.p.f13824m1, g6.p.a(bVar.e()));
            }
            if (!this.f11380e) {
                g6.y.O(gVar.P(x7.p.f13824m1), w3.o(this.f11383h, r8.d.j(bVar.g())));
            }
        } else {
            gVar.X(x7.p.f13824m1, "");
            g6.y.O(gVar.P(x7.p.f13824m1), drawableJ);
        }
        gVar.P(x7.p.M).setOnClickListener(new View.OnClickListener() { // from class: qa.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j0.l(this.f11375a, gVar, view);
            }
        });
    }

    @Override // y5.d
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public b6.g d(Context context, ViewGroup viewGroup) {
        View viewA = b6.c.e(x7.r.f13891z).a(viewGroup);
        TextView textView = (TextView) viewA.findViewById(x7.p.f13824m1);
        if (this.f11380e) {
            textView.setTextColor(g6.e.a(viewA.getContext(), x7.k.f13665k));
        }
        x8.g.d(textView);
        x8.g.d((TextView) viewA.findViewById(x7.p.f13827n1));
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.height = this.f11381f;
        layoutParams.width = this.f11382g;
        textView.setLayoutParams(layoutParams);
        TextView textView2 = (TextView) viewA.findViewById(x7.p.f13827n1);
        ViewGroup.LayoutParams layoutParams2 = textView2.getLayoutParams();
        layoutParams2.width = this.f11382g;
        textView2.setLayoutParams(layoutParams2);
        return new b6.g(viewA);
    }

    public void p(a aVar) {
        this.f11384i = aVar;
    }
}
