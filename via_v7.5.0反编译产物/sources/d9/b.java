package d9;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import t5.f;
import v8.h;
import w5.c;
import w5.g;
import w7.p;
import w7.r;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b extends t5.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4012c = -1;

    private void m(f fVar, int i10) {
        if (i10 < 0 || i10 >= fVar.g()) {
            return;
        }
        fVar.m(i10);
    }

    public int l() {
        return this.f4012c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v3 */
    @Override // t5.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public void b(g gVar, f9.a aVar) {
        super.b(gVar, aVar);
        ?? r10 = gVar.l() == this.f4012c ? 1 : 0;
        Context context = gVar.f1138a.getContext();
        ImageView imageView = (ImageView) gVar.P(p.R);
        imageView.setVisibility(aVar.a() == null ? 8 : 0);
        imageView.setImageDrawable(aVar.a());
        imageView.setColorFilter(r10 != 0 ? h.j(context) : h.l(context));
        imageView.setImportantForAccessibility(2);
        TextView textView = (TextView) gVar.P(p.H1);
        textView.setText(aVar.d());
        TextView textView2 = (TextView) gVar.P(p.E1);
        textView2.setText(aVar.c());
        textView2.setVisibility(aVar.c() == null ? 8 : 0);
        textView.setSelected(r10);
        v8.g.e(textView, r10);
        textView2.setSelected(r10);
        v8.g.e(textView2, r10);
    }

    @Override // t5.d
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public g d(Context context, ViewGroup viewGroup) {
        return new g(c.e(r.f13954w).a(viewGroup));
    }

    public void p(f fVar, int i10) {
        int i11 = this.f4012c;
        if (i11 == i10) {
            return;
        }
        this.f4012c = i10;
        m(fVar, i11);
        m(fVar, this.f4012c);
    }
}
