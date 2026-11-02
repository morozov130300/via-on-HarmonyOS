package mark.via.download;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class r1 extends y5.a {
    public r1(y5.g gVar) {
        super(gVar);
    }

    @Override // y5.d
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public long a(q1 q1Var) {
        return q1Var.d();
    }

    @Override // y5.d
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void b(b6.g gVar, q1 q1Var) {
        super.b(gVar, q1Var);
        gVar.V(x7.p.S, q1Var.b());
        gVar.X(x7.p.H1, q1Var.e());
        x8.g.d((TextView) gVar.P(x7.p.H1));
    }

    @Override // y5.d
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public b6.g d(Context context, ViewGroup viewGroup) {
        return new b6.g(LayoutInflater.from(context).inflate(x7.r.B, viewGroup, false));
    }
}
