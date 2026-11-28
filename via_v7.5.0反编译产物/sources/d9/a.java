package d9;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tuyafeng.support.utils.e;
import com.tuyafeng.support.utils.f;
import com.tuyafeng.support.utils.x;
import java.util.List;
import w5.c;
import w5.g;
import w7.k;
import w7.m;
import w7.o;
import w7.u;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a extends t5.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f4010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4011d = -1;

    public a(List list) {
        this.f4010c = list;
    }

    public final Drawable l(Context context, int i10) {
        return m(context, i10, 0, 0);
    }

    public final Drawable m(Context context, int i10, int i11, int i12) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i10);
        gradientDrawable.setCornerRadius(x.h(context, 32.0f));
        if (i11 != 0) {
            gradientDrawable.setStroke(x.h(context, i12), i11);
        }
        return gradientDrawable;
    }

    public final Drawable n(Context context) {
        int iA = e.a(context, k.f13729i);
        Drawable drawableM = m(context, 0, iA, 2);
        Drawable drawableE = f.e(context, o.f13826r0);
        if (drawableE != null) {
            drawableE.setColorFilter(iA, PorterDuff.Mode.SRC_IN);
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawableM, drawableE});
        int iH = x.h(context, 16.0f);
        layerDrawable.setLayerInset(1, iH, iH, iH, iH);
        return layerDrawable;
    }

    public e9.a o() {
        int i10 = this.f4011d;
        if (i10 < 0 || i10 >= this.f4010c.size()) {
            return null;
        }
        return (e9.a) this.f4010c.get(this.f4011d);
    }

    public int p() {
        return this.f4011d;
    }

    public final void q(t5.f fVar, int i10) {
        if (i10 < 0 || i10 >= fVar.g()) {
            return;
        }
        fVar.m(i10);
    }

    @Override // t5.d
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public void b(g gVar, e9.a aVar) {
        super.b(gVar, aVar);
        Context context = gVar.f1138a.getContext();
        gVar.f1138a.setLayoutParams(new ViewGroup.LayoutParams(x.h(context, 48.0f), -1));
        ImageView imageView = (ImageView) gVar.P(c.f13661e);
        if (aVar instanceof e9.b) {
            e9.b bVar = (e9.b) aVar;
            int iA = bVar.a();
            imageView.setImageDrawable(iA == 0 ? m(context, 0, e.a(context, k.f13729i), 1) : l(context, iA));
            imageView.setContentDescription(bVar.b());
        } else if (aVar instanceof e9.c) {
            imageView.setImageDrawable(n(context));
            imageView.setContentDescription(context.getString(u.Fa));
        }
        x.P(imageView, gVar.l() == this.f4011d ? l(context, f.b(context, m.f13746j)) : f.e(context, o.f13789f));
    }

    @Override // t5.d
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public g d(Context context, ViewGroup viewGroup) {
        return new g(c.d().a(viewGroup));
    }

    public void t(t5.f fVar, int i10) {
        int i11 = this.f4011d;
        if (i11 == i10) {
            return;
        }
        this.f4011d = i10;
        q(fVar, i11);
        q(fVar, this.f4011d);
    }

    public void u(e9.a aVar) {
        this.f4011d = -1;
        if (aVar == null) {
            return;
        }
        int size = this.f4010c.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (aVar.equals(this.f4010c.get(i10))) {
                this.f4011d = i10;
                return;
            }
        }
    }
}
