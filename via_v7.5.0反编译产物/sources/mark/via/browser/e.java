package mark.via.browser;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e extends LayerDrawable {
    public e() {
        super(new Drawable[]{new ColorDrawable(0), new ColorDrawable(0), new ColorDrawable(0)});
        setId(0, 1);
    }

    public e a(int i10) {
        e eVar = new e();
        Drawable.ConstantState constantState = getDrawable(0).getConstantState();
        if (constantState == null) {
            eVar.g(i10);
            return eVar;
        }
        eVar.e(constantState.newDrawable());
        eVar.f(b());
        eVar.g(((ColorDrawable) getDrawable(1)).getColor());
        return eVar;
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
