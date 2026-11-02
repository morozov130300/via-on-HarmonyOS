package v3;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.Arrays;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a extends q {

    /* renamed from: d, reason: collision with root package name */
    public static final char[] f12964d = "0123456789-$:/.+ABCD".toCharArray();

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f12965e = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* renamed from: f, reason: collision with root package name */
    public static final char[] f12966f = {'A', 'B', 'C', 'D'};

    /* renamed from: a, reason: collision with root package name */
    public final StringBuilder f12967a = new StringBuilder(20);

    /* renamed from: b, reason: collision with root package name */
    public int[] f12968b = new int[80];

    /* renamed from: c, reason: collision with root package name */
    public int f12969c = 0;

    public static boolean h(char[] cArr, char c10) {
        if (cArr != null) {
            for (char c11 : cArr) {
                if (c11 == c10) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // v3.q
    public com.google.zxing.j c(int i10, s3.a aVar, Map map) throws NotFoundException {
        int i11;
        Arrays.fill(this.f12968b, 0);
        k(aVar);
        int iJ = j();
        this.f12967a.setLength(0);
        int i12 = iJ;
        while (true) {
            int iL = l(i12);
            if (iL == -1) {
                throw NotFoundException.getNotFoundInstance();
            }
            this.f12967a.append((char) iL);
            i11 = i12 + 8;
            if ((this.f12967a.length() > 1 && h(f12966f, f12964d[iL])) || i11 >= this.f12969c) {
                break;
            }
            i12 = i11;
        }
        int i13 = i12 + 7;
        int i14 = this.f12968b[i13];
        int i15 = 0;
        for (int i16 = -8; i16 < -1; i16++) {
            i15 += this.f12968b[i11 + i16];
        }
        if (i11 < this.f12969c && i14 < i15 / 2) {
            throw NotFoundException.getNotFoundInstance();
        }
        m(iJ);
        for (int i17 = 0; i17 < this.f12967a.length(); i17++) {
            StringBuilder sb2 = this.f12967a;
            sb2.setCharAt(i17, f12964d[sb2.charAt(i17)]);
        }
        char cCharAt = this.f12967a.charAt(0);
        char[] cArr = f12966f;
        if (!h(cArr, cCharAt)) {
            throw NotFoundException.getNotFoundInstance();
        }
        StringBuilder sb3 = this.f12967a;
        if (!h(cArr, sb3.charAt(sb3.length() - 1))) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (this.f12967a.length() <= 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (map == null || !map.containsKey(DecodeHintType.RETURN_CODABAR_START_END)) {
            StringBuilder sb4 = this.f12967a;
            sb4.deleteCharAt(sb4.length() - 1);
            this.f12967a.deleteCharAt(0);
        }
        int i18 = 0;
        for (int i19 = 0; i19 < iJ; i19++) {
            i18 += this.f12968b[i19];
        }
        float f10 = i18;
        while (iJ < i13) {
            i18 += this.f12968b[iJ];
            iJ++;
        }
        float f11 = i10;
        com.google.zxing.j jVar = new com.google.zxing.j(this.f12967a.toString(), null, new com.google.zxing.k[]{new com.google.zxing.k(f10, f11), new com.google.zxing.k(i18, f11)}, BarcodeFormat.CODABAR);
        jVar.h(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]F0");
        return jVar;
    }

    public final void i(int i10) {
        int[] iArr = this.f12968b;
        int i11 = this.f12969c;
        iArr[i11] = i10;
        int i12 = i11 + 1;
        this.f12969c = i12;
        if (i12 >= iArr.length) {
            int[] iArr2 = new int[i12 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i12);
            this.f12968b = iArr2;
        }
    }

    public final int j() throws NotFoundException {
        for (int i10 = 1; i10 < this.f12969c; i10 += 2) {
            int iL = l(i10);
            if (iL != -1 && h(f12966f, f12964d[iL])) {
                int i11 = 0;
                for (int i12 = i10; i12 < i10 + 7; i12++) {
                    i11 += this.f12968b[i12];
                }
                if (i10 == 1 || this.f12968b[i10 - 1] >= i11 / 2) {
                    return i10;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final void k(s3.a aVar) throws NotFoundException {
        int i10 = 0;
        this.f12969c = 0;
        int iM = aVar.m(0);
        int iN = aVar.n();
        if (iM >= iN) {
            throw NotFoundException.getNotFoundInstance();
        }
        boolean z10 = true;
        while (iM < iN) {
            if (aVar.j(iM) != z10) {
                i10++;
            } else {
                i(i10);
                z10 = !z10;
                i10 = 1;
            }
            iM++;
        }
        i(i10);
    }

    public final int l(int i10) {
        int i11 = i10 + 7;
        if (i11 >= this.f12969c) {
            return -1;
        }
        int[] iArr = this.f12968b;
        int i12 = Integer.MAX_VALUE;
        int i13 = 0;
        int i14 = Integer.MAX_VALUE;
        int i15 = 0;
        for (int i16 = i10; i16 < i11; i16 += 2) {
            int i17 = iArr[i16];
            if (i17 < i14) {
                i14 = i17;
            }
            if (i17 > i15) {
                i15 = i17;
            }
        }
        int i18 = (i14 + i15) / 2;
        int i19 = 0;
        for (int i20 = i10 + 1; i20 < i11; i20 += 2) {
            int i21 = iArr[i20];
            if (i21 < i12) {
                i12 = i21;
            }
            if (i21 > i19) {
                i19 = i21;
            }
        }
        int i22 = (i12 + i19) / 2;
        int i23 = 128;
        int i24 = 0;
        for (int i25 = 0; i25 < 7; i25++) {
            i23 >>= 1;
            if (iArr[i10 + i25] > ((i25 & 1) == 0 ? i18 : i22)) {
                i24 |= i23;
            }
        }
        while (true) {
            int[] iArr2 = f12965e;
            if (i13 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i13] == i24) {
                return i13;
            }
            i13++;
        }
    }

    public final void m(int i10) throws NotFoundException {
        int[] iArr = new int[4];
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        int[] iArr2 = new int[4];
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int length = this.f12967a.length() - 1;
        int i11 = i10;
        int i12 = 0;
        while (true) {
            if (i12 > length) {
                break;
            }
            int i13 = f12965e[this.f12967a.charAt(i12)];
            for (int i14 = 6; i14 >= 0; i14--) {
                int i15 = (i14 & 1) + ((i13 & 1) * 2);
                iArr[i15] = iArr[i15] + this.f12968b[i11 + i14];
                iArr2[i15] = iArr2[i15] + 1;
                i13 >>= 1;
            }
            i11 += 8;
            i12++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i16 = 0; i16 < 2; i16++) {
            fArr2[i16] = 0.0f;
            int i17 = i16 + 2;
            int i18 = iArr[i17];
            int i19 = iArr2[i17];
            float f10 = ((iArr[i16] / iArr2[i16]) + (i18 / i19)) / 2.0f;
            fArr2[i17] = f10;
            fArr[i16] = f10;
            fArr[i17] = ((i18 * 2.0f) + 1.5f) / i19;
        }
        int i20 = i10;
        for (int i21 = 0; i21 <= length; i21++) {
            int i22 = f12965e[this.f12967a.charAt(i21)];
            for (int i23 = 6; i23 >= 0; i23--) {
                int i24 = (i23 & 1) + ((i22 & 1) * 2);
                float f11 = this.f12968b[i20 + i23];
                if (f11 < fArr2[i24] || f11 > fArr[i24]) {
                    throw NotFoundException.getNotFoundInstance();
                }
                i22 >>= 1;
            }
            i20 += 8;
        }
    }
}
