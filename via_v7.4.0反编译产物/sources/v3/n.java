package v3;

import com.google.zxing.BarcodeFormat;
import java.util.Collection;
import java.util.Collections;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class n extends r {

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f12995b = {1, 1, 1, 1};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f12996c = {3, 1, 1};

    /* renamed from: d, reason: collision with root package name */
    public static final int[][] f12997d = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    @Override // v3.r
    public boolean[] d(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The length of the input should be even");
        }
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        }
        r.c(str);
        boolean[] zArr = new boolean[(length * 9) + 9];
        int iB = r.b(zArr, 0, f12995b, true);
        for (int i10 = 0; i10 < length; i10 += 2) {
            int iDigit = Character.digit(str.charAt(i10), 10);
            int iDigit2 = Character.digit(str.charAt(i10 + 1), 10);
            int[] iArr = new int[10];
            for (int i11 = 0; i11 < 5; i11++) {
                int i12 = i11 * 2;
                int[][] iArr2 = f12997d;
                iArr[i12] = iArr2[iDigit][i11];
                iArr[i12 + 1] = iArr2[iDigit2][i11];
            }
            iB += r.b(zArr, iB, iArr, true);
        }
        r.b(zArr, iB, f12996c, true);
        return zArr;
    }

    @Override // v3.r
    public Collection g() {
        return Collections.singleton(BarcodeFormat.ITF);
    }
}
