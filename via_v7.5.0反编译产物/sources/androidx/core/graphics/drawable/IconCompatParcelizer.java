package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import p0.a;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f491a = aVar.p(iconCompat.f491a, 1);
        iconCompat.f493c = aVar.j(iconCompat.f493c, 2);
        iconCompat.f494d = aVar.r(iconCompat.f494d, 3);
        iconCompat.f495e = aVar.p(iconCompat.f495e, 4);
        iconCompat.f496f = aVar.p(iconCompat.f496f, 5);
        iconCompat.f497g = (ColorStateList) aVar.r(iconCompat.f497g, 6);
        iconCompat.f499i = aVar.t(iconCompat.f499i, 7);
        iconCompat.f500j = aVar.t(iconCompat.f500j, 8);
        iconCompat.n();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, a aVar) {
        aVar.x(true, true);
        iconCompat.o(aVar.f());
        int i10 = iconCompat.f491a;
        if (-1 != i10) {
            aVar.F(i10, 1);
        }
        byte[] bArr = iconCompat.f493c;
        if (bArr != null) {
            aVar.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f494d;
        if (parcelable != null) {
            aVar.H(parcelable, 3);
        }
        int i11 = iconCompat.f495e;
        if (i11 != 0) {
            aVar.F(i11, 4);
        }
        int i12 = iconCompat.f496f;
        if (i12 != 0) {
            aVar.F(i12, 5);
        }
        ColorStateList colorStateList = iconCompat.f497g;
        if (colorStateList != null) {
            aVar.H(colorStateList, 6);
        }
        String str = iconCompat.f499i;
        if (str != null) {
            aVar.J(str, 7);
        }
        String str2 = iconCompat.f500j;
        if (str2 != null) {
            aVar.J(str2, 8);
        }
    }
}
