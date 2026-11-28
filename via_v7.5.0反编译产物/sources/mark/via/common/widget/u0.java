package mark.via.common.widget;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import hb.w4;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class u0 {
    /* JADX WARN: Code duplicated, block: B:32:0x0073  */
    public static void a(ImageView imageView, int i10, u9.l lVar) {
        int iX0;
        int i11;
        int i12;
        int i13;
        int i14;
        Drawable drawableA;
        if (i10 != 1) {
            if (i10 == 2) {
                iX0 = lVar.e1();
                boolean zD = com.tuyafeng.support.utils.l.d(imageView.getContext());
                i11 = zD ? w7.o.f13822q : w7.o.f13802j0;
                i12 = zD ? w7.u.he : w7.u.we;
            } else if (i10 == 4) {
                iX0 = lVar.j2();
                i14 = w7.o.N0;
                i13 = w7.u.Bf;
            } else if (i10 != 8) {
                imageView.setImageDrawable(lb.g.a(imageView.getContext(), w7.o.C0, w7.u.De));
                return;
            } else {
                iX0 = lVar.A2();
                i14 = w7.o.E0;
                i13 = w7.u.sf;
            }
            drawableA = w4.a(imageView.getContext(), iX0);
            if (drawableA == null) {
                drawableA = lb.g.a(imageView.getContext(), i14, i13);
            }
            imageView.setImageDrawable(drawableA);
        }
        iX0 = lVar.x0();
        boolean zD2 = com.tuyafeng.support.utils.l.d(imageView.getContext());
        i11 = zD2 ? w7.o.f13802j0 : w7.o.f13822q;
        i12 = zD2 ? w7.u.we : w7.u.he;
        int i15 = i11;
        i13 = i12;
        i14 = i15;
        drawableA = w4.a(imageView.getContext(), iX0);
        if (drawableA == null) {
            drawableA = lb.g.a(imageView.getContext(), i14, i13);
        }
        imageView.setImageDrawable(drawableA);
    }
}
