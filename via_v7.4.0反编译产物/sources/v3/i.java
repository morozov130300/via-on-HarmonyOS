package v3;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import java.util.Collection;
import java.util.Collections;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class i extends y {
    @Override // v3.r
    public boolean[] d(String str) {
        int length = str.length();
        if (length == 12) {
            try {
                str = str + x.r(str);
            } catch (FormatException e10) {
                throw new IllegalArgumentException(e10);
            }
        } else {
            if (length != 13) {
                throw new IllegalArgumentException("Requested contents should be 12 or 13 digits long, but got " + length);
            }
            try {
                if (!x.i(str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (FormatException unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        }
        r.c(str);
        int i10 = h.f12985j[Character.digit(str.charAt(0), 10)];
        boolean[] zArr = new boolean[95];
        int iB = r.b(zArr, 0, x.f13013d, true);
        for (int i11 = 1; i11 <= 6; i11++) {
            int iDigit = Character.digit(str.charAt(i11), 10);
            if (((i10 >> (6 - i11)) & 1) == 1) {
                iDigit += 10;
            }
            iB += r.b(zArr, iB, x.f13017h[iDigit], false);
        }
        int iB2 = iB + r.b(zArr, iB, x.f13014e, false);
        for (int i12 = 7; i12 <= 12; i12++) {
            iB2 += r.b(zArr, iB2, x.f13016g[Character.digit(str.charAt(i12), 10)], true);
        }
        r.b(zArr, iB2, x.f13013d, true);
        return zArr;
    }

    @Override // v3.r
    public Collection g() {
        return Collections.singleton(BarcodeFormat.EAN_13);
    }
}
