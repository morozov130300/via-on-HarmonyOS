package c8;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b extends LayerDrawable {
    public b() {
        super(new Drawable[]{new ColorDrawable(0), new ColorDrawable(0), new ColorDrawable(0)});
        setId(0, 1);
    }

    public b a(int i10) {
        b bVar = new b();
        Drawable.ConstantState constantState = getDrawable(0).getConstantState();
        if (constantState == null) {
            bVar.g(i10);
            return bVar;
        }
        bVar.e(constantState.newDrawable());
        bVar.f(b());
        bVar.g(((ColorDrawable) getDrawable(1)).getColor());
        return bVar;
    }

    public int b() {
        return ((ColorDrawable) getDrawable(2)).getColor();
    }

    public boolean c() {
        return !(getDrawable(0) instanceof ColorDrawable);
    }

    public final void d() {
        Drawable drawable = getDrawable(0);
        if (drawable instanceof ColorDrawable) {
            ((ColorDrawable) drawable).setColor(0);
        } else {
            setDrawableByLayerId(1, new ColorDrawable(0));
        }
    }

    public void e(Drawable drawable) {
        if (drawable == null) {
            d();
            invalidateDrawable(getDrawable(0));
        } else {
            setDrawableByLayerId(1, drawable);
            invalidateDrawable(getDrawable(0));
        }
    }

    public void f(int i10) {
        ((ColorDrawable) getDrawable(2)).setColor(i10);
    }

    public void g(int i10) {
        ((ColorDrawable) getDrawable(1)).setColor(i10);
        invalidateDrawable(getDrawable(1));
    }
}
