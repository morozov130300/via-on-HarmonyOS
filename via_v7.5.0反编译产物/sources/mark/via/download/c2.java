package mark.via.download;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c2 extends t5.a {
    public c2(t5.g gVar) {
        super(gVar);
    }

    @Override // t5.d
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public long a(b2 b2Var) {
        return b2Var.d();
    }

    @Override // t5.d
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public void b(w5.g gVar, b2 b2Var) {
        super.b(gVar, b2Var);
        gVar.V(w7.p.R, b2Var.b());
        gVar.X(w7.p.H1, b2Var.e());
        v8.g.d((TextView) gVar.P(w7.p.H1));
    }

    @Override // t5.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public w5.g d(Context context, ViewGroup viewGroup) {
        return new w5.g(LayoutInflater.from(context).inflate(w7.r.A, viewGroup, false));
    }
}
