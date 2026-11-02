package f9;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import b6.c;
import b6.g;
import g6.e;
import g6.f;
import g6.y;
import java.util.List;
import x7.k;
import x7.m;
import x7.o;
import x7.u;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a extends y5.a {

    /* renamed from: c, reason: collision with root package name */
    public final List f6060c;

    /* renamed from: d, reason: collision with root package name */
    public int f6061d = -1;

    public a(List list) {
        this.f6060c = list;
    }

    public final Drawable l(Context context, int i10) {
        return m(context, i10, 0, 0);
    }

    public final Drawable m(Context context, int i10, int i11, int i12) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i10);
        gradientDrawable.setCornerRadius(y.h(context, 32.0f));
        if (i11 != 0) {
            gradientDrawable.setStroke(y.h(context, i12), i11);
        }
        return gradientDrawable;
    }

    public final Drawable n(Context context) {
        int iA = e.a(context, k.f13662h);
        Drawable drawableM = m(context, 0, iA, 2);
        Drawable drawableE = f.e(context, o.f13757q0);
        if (drawableE != null) {
            drawableE.setColorFilter(iA, PorterDuff.Mode.SRC_IN);
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawableM, drawableE});
        int iH = y.h(context, 16.0f);
        layerDrawable.setLayerInset(1, iH, iH, iH, iH);
        return layerDrawable;
    }

    public g9.a o() {
        int i10 = this.f6061d;
        if (i10 < 0 || i10 >= this.f6060c.size()) {
            return null;
        }
        return (g9.a) this.f6060c.get(this.f6061d);
    }

    public int p() {
        return this.f6061d;
    }

    public final void q(y5.f fVar, int i10) {
        if (i10 < 0 || i10 >= fVar.g()) {
            return;
        }
        fVar.m(i10);
    }

    @Override // y5.d
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void b(g gVar, g9.a aVar) {
        super.b(gVar, aVar);
        Context context = gVar.f1219a.getContext();
        gVar.f1219a.setLayoutParams(new ViewGroup.LayoutParams(y.h(context, 48.0f), -1));
        ImageView imageView = (ImageView) gVar.P(c.f1830e);
        if (aVar instanceof g9.b) {
            g9.b bVar = (g9.b) aVar;
            int iA = bVar.a();
            imageView.setImageDrawable(iA == 0 ? m(context, 0, e.a(context, k.f13662h), 1) : l(context, iA));
            imageView.setContentDescription(bVar.b());
        } else if (aVar instanceof g9.c) {
            imageView.setImageDrawable(n(context));
            imageView.setContentDescription(context.getString(u.f14174ta));
        }
        y.O(imageView, gVar.l() == this.f6061d ? l(context, f.b(context, m.f13680j)) : f.e(context, o.f13726g));
    }

    @Override // y5.d
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public g d(Context context, ViewGroup viewGroup) {
        return new g(c.d().a(viewGroup));
    }

    public void t(y5.f fVar, int i10) {
        int i11 = this.f6061d;
        if (i11 == i10) {
            return;
        }
        this.f6061d = i10;
        q(fVar, i11);
        q(fVar, this.f6061d);
    }

    public void u(g9.a aVar) {
        this.f6061d = -1;
        if (aVar == null) {
            return;
        }
        int size = this.f6060c.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (aVar.equals(this.f6060c.get(i10))) {
                this.f6061d = i10;
                return;
            }
        }
    }
}
