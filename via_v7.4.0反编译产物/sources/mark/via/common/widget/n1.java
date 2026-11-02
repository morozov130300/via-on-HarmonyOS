package mark.via.common.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class n1 extends ImageView {

    /* renamed from: e, reason: collision with root package name */
    public int f9722e;

    /* renamed from: j, reason: collision with root package name */
    public int f9723j;

    public n1(Context context) {
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
        if (z10 && this.f9722e == paddingLeft && paddingTop < (i12 = this.f9723j)) {
            paddingTop = i12;
        } else {
            this.f9722e = paddingLeft;
            this.f9723j = paddingTop;
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
