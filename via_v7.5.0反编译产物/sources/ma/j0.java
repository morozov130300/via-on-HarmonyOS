package ma;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import x8.w3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class j0 extends t5.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f8021d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f8022e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f8023f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f8024g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f8025h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f8026i;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        void a(View view, int i10);
    }

    public j0(String str, g9.c cVar, Resources resources) {
        this.f8020c = str;
        int iB = cVar.b();
        int iD = cVar.d();
        iB = iB == 0 ? iD : iB;
        iD = iD == 0 ? iB : iD;
        if (iB == 0) {
            iB = 54;
            iD = 54;
        }
        float f10 = resources.getDisplayMetrics().density;
        int i10 = (int) ((iD * f10) + 0.5f);
        this.f8024g = i10;
        int i11 = (int) ((iB * f10) + 0.5f);
        this.f8023f = i11;
        this.f8025h = (int) (((cVar.c() / 100.0f) * Math.min(i11, i10)) / 2.0f);
        this.f8022e = cVar.e();
        this.f8021d = cVar.f();
    }

    public static /* synthetic */ void l(j0 j0Var, w5.g gVar, View view) {
        a aVar;
        j0Var.getClass();
        int iL = gVar.l();
        if (iL == -1 || (aVar = j0Var.f8026i) == null) {
            return;
        }
        aVar.a(view, iL);
    }

    public int m() {
        return this.f8024g;
    }

    @Override // t5.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public void b(final w5.g gVar, l9.b bVar) {
        super.b(gVar, bVar);
        gVar.X(w7.p.f13893n1, bVar.e());
        Drawable drawableJ = this.f8021d ? null : w3.j(this.f8020c, bVar.g(), this.f8024g, this.f8023f, this.f8025h);
        if (drawableJ == null) {
            if (bVar.e().length() > 0) {
                gVar.X(w7.p.f13890m1, com.tuyafeng.support.utils.p.a(bVar.e()));
            }
            if (!this.f8022e) {
                com.tuyafeng.support.utils.x.P(gVar.P(w7.p.f13890m1), w3.o(this.f8025h, p8.d.j(bVar.g())));
            }
        } else {
            gVar.X(w7.p.f13890m1, "");
            com.tuyafeng.support.utils.x.P(gVar.P(w7.p.f13890m1), drawableJ);
        }
        gVar.P(w7.p.K).setOnClickListener(new View.OnClickListener() { // from class: ma.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j0.l(this.f8017a, gVar, view);
            }
        });
    }

    @Override // t5.d
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public w5.g d(Context context, ViewGroup viewGroup) {
        View viewA = w5.c.e(w7.r.f13956y).a(viewGroup);
        TextView textView = (TextView) viewA.findViewById(w7.p.f13890m1);
        if (this.f8022e) {
            textView.setTextColor(com.tuyafeng.support.utils.e.a(viewA.getContext(), w7.k.f13732l));
        }
        v8.g.d(textView);
        v8.g.d((TextView) viewA.findViewById(w7.p.f13893n1));
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.height = this.f8023f;
        layoutParams.width = this.f8024g;
        textView.setLayoutParams(layoutParams);
        TextView textView2 = (TextView) viewA.findViewById(w7.p.f13893n1);
        ViewGroup.LayoutParams layoutParams2 = textView2.getLayoutParams();
        layoutParams2.width = this.f8024g;
        textView2.setLayoutParams(layoutParams2);
        return new w5.g(viewA);
    }

    public void p(a aVar) {
        this.f8026i = aVar;
    }
}
