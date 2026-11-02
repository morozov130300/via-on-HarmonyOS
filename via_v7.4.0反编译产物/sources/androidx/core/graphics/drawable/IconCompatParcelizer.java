package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import o0.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f588a = aVar.p(iconCompat.f588a, 1);
        iconCompat.f590c = aVar.j(iconCompat.f590c, 2);
        iconCompat.f591d = aVar.r(iconCompat.f591d, 3);
        iconCompat.f592e = aVar.p(iconCompat.f592e, 4);
        iconCompat.f593f = aVar.p(iconCompat.f593f, 5);
        iconCompat.f594g = (ColorStateList) aVar.r(iconCompat.f594g, 6);
        iconCompat.f596i = aVar.t(iconCompat.f596i, 7);
        iconCompat.f597j = aVar.t(iconCompat.f597j, 8);
        iconCompat.n();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, a aVar) {
        aVar.x(true, true);
        iconCompat.o(aVar.f());
        int i10 = iconCompat.f588a;
        if (-1 != i10) {
            aVar.F(i10, 1);
        }
        byte[] bArr = iconCompat.f590c;
        if (bArr != null) {
            aVar.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f591d;
        if (parcelable != null) {
            aVar.H(parcelable, 3);
        }
        int i11 = iconCompat.f592e;
        if (i11 != 0) {
            aVar.F(i11, 4);
        }
        int i12 = iconCompat.f593f;
        if (i12 != 0) {
            aVar.F(i12, 5);
        }
        ColorStateList colorStateList = iconCompat.f594g;
        if (colorStateList != null) {
            aVar.H(colorStateList, 6);
        }
        String str = iconCompat.f596i;
        if (str != null) {
            aVar.J(str, 7);
        }
        String str2 = iconCompat.f597j;
        if (str2 != null) {
            aVar.J(str2, 8);
        }
    }
}
