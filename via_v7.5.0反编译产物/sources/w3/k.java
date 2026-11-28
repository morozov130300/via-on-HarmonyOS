package w3;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class k extends y {
    @Override // w3.r
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
        int iB = r.b(zArr, 0, x.f13628d, true);
        for (int i10 = 0; i10 <= 3; i10++) {
            iB += r.b(zArr, iB, x.f13631g[Character.digit(str.charAt(i10), 10)], false);
        }
        int iB2 = iB + r.b(zArr, iB, x.f13629e, false);
        for (int i11 = 4; i11 <= 7; i11++) {
            iB2 += r.b(zArr, iB2, x.f13631g[Character.digit(str.charAt(i11), 10)], true);
        }
        r.b(zArr, iB2, x.f13628d, true);
        return zArr;
    }

    @Override // w3.r
    public Collection g() {
        return Collections.singleton(BarcodeFormat.EAN_8);
    }
}
