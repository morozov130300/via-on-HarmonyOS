package mark.via.common.widget;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import hb.v4;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class u0 {
    /* JADX WARN: Removed duplicated region for block: B:32:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(ImageView imageView, int i10, w9.l lVar) {
        int iV0;
        int i11;
        int i12;
        int i13;
        int i14;
        Drawable drawableA;
        if (i10 == 1) {
            iV0 = lVar.v0();
            boolean zD = g6.l.d(imageView.getContext());
            i11 = zD ? x7.o.f13736j0 : x7.o.f13759r;
            i12 = zD ? x7.u.ge : x7.u.Sd;
        } else {
            if (i10 != 2) {
                if (i10 == 4) {
                    iV0 = lVar.i2();
                    i14 = x7.o.P0;
                    i13 = x7.u.kf;
                } else if (i10 != 8) {
                    imageView.setImageDrawable(lb.b.a(imageView.getContext(), x7.o.E0, x7.u.ne));
                    return;
                } else {
                    iV0 = lVar.z2();
                    i14 = x7.o.G0;
                    i13 = x7.u.bf;
                }
                drawableA = v4.a(imageView.getContext(), iV0);
                if (drawableA == null) {
                    drawableA = lb.b.a(imageView.getContext(), i14, i13);
                }
                imageView.setImageDrawable(drawableA);
            }
            iV0 = lVar.c1();
            boolean zD2 = g6.l.d(imageView.getContext());
            i11 = zD2 ? x7.o.f13759r : x7.o.f13736j0;
            i12 = zD2 ? x7.u.Sd : x7.u.ge;
        }
        int i15 = i11;
        i13 = i12;
        i14 = i15;
        drawableA = v4.a(imageView.getContext(), iV0);
        if (drawableA == null) {
        }
        imageView.setImageDrawable(drawableA);
    }
}
