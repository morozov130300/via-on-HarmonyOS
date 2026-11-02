package v3;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import java.util.Collection;
import java.util.Collections;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class k extends y {
    @Override // v3.r
    public boolean[] d(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + x.r(str);
            } catch (FormatException e10) {
                throw new IllegalArgumentException(e10);
            }
        } else {
            if (length != 8) {
                throw new IllegalArgumentException("Requested contents should be 7 or 8 digits long, but got " + length);
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
        boolean[] zArr = new boolean[67];
        int iB = r.b(zArr, 0, x.f13013d, true);
        for (int i10 = 0; i10 <= 3; i10++) {
            iB += r.b(zArr, iB, x.f13016g[Character.digit(str.charAt(i10), 10)], false);
        }
        int iB2 = iB + r.b(zArr, iB, x.f13014e, false);
        for (int i11 = 4; i11 <= 7; i11++) {
            iB2 += r.b(zArr, iB2, x.f13016g[Character.digit(str.charAt(i11), 10)], true);
        }
        r.b(zArr, iB2, x.f13013d, true);
        return zArr;
    }

    @Override // v3.r
    public Collection g() {
        return Collections.singleton(BarcodeFormat.EAN_8);
    }
}
