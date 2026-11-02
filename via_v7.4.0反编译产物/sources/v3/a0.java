package v3;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import java.util.Collection;
import java.util.Collections;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a0 extends y {
    @Override // v3.r
    public boolean[] d(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + x.r(z.s(str));
            } catch (FormatException e10) {
                throw new IllegalArgumentException(e10);
            }
        } else {
            if (length != 8) {
                throw new IllegalArgumentException("Requested contents should be 7 or 8 digits long, but got " + length);
            }
            try {
                if (!x.i(z.s(str))) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (FormatException unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        }
        r.c(str);
        int iDigit = Character.digit(str.charAt(0), 10);
        if (iDigit != 0 && iDigit != 1) {
            throw new IllegalArgumentException("Number system must be 0 or 1");
        }
        int i10 = z.f13022k[iDigit][Character.digit(str.charAt(7), 10)];
        boolean[] zArr = new boolean[51];
        int iB = r.b(zArr, 0, x.f13013d, true);
        for (int i11 = 1; i11 <= 6; i11++) {
            int iDigit2 = Character.digit(str.charAt(i11), 10);
            if (((i10 >> (6 - i11)) & 1) == 1) {
                iDigit2 += 10;
            }
            iB += r.b(zArr, iB, x.f13017h[iDigit2], false);
        }
        r.b(zArr, iB, x.f13015f, false);
        return zArr;
    }

    @Override // v3.r
    public Collection g() {
        return Collections.singleton(BarcodeFormat.UPC_E);
    }
}
