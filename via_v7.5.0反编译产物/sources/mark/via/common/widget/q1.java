package mark.via.common.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class q1 extends ImageView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10035c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10036e;

    public q1(Context context) {
        super(context);
        a();
    }

    public final void a() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public void b() {
        c(false, getWidth(), getHeight());
    }

    public final void c(boolean z10, int i10, int i11) {
        int i12;
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        int paddingLeft = (i10 - getPaddingLeft()) - getPaddingRight();
        int paddingTop = (i11 - getPaddingTop()) - getPaddingBottom();
        if (paddingLeft <= 0 || paddingTop <= 0) {
            return;
        }
        if (z10 && this.f10035c == paddingLeft && paddingTop < (i12 = this.f10036e)) {
            paddingTop = i12;
        } else {
            this.f10035c = paddingLeft;
            this.f10036e = paddingTop;
        }
        drawable.setBounds(0, 0, paddingLeft, paddingTop);
        Matrix imageMatrix = getImageMatrix();
        imageMatrix.reset();
        setImageMatrix(imageMatrix);
    }

    @Override // android.widget.ImageView
    public boolean setFrame(int i10, int i11, int i12, int i13) {
        boolean frame = super.setFrame(i10, i11, i12, i13);
        c(true, i12 - i10, i13 - i11);
        return frame;
    }
}
