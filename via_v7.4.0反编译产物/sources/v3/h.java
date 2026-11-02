package v3;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class h extends x {

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f12985j = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};

    /* renamed from: i, reason: collision with root package name */
    public final int[] f12986i = new int[4];

    public static void s(StringBuilder sb2, int i10) throws NotFoundException {
        for (int i11 = 0; i11 < 10; i11++) {
            if (i10 == f12985j[i11]) {
                sb2.insert(0, (char) (i11 + 48));
                return;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // v3.x
    public int l(s3.a aVar, int[] iArr, StringBuilder sb2) throws NotFoundException {
        int[] iArr2 = this.f12986i;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iN = aVar.n();
        int i10 = iArr[1];
        int i11 = 0;
        for (int i12 = 0; i12 < 6 && i10 < iN; i12++) {
            int iJ = x.j(aVar, iArr2, i10, x.f13017h);
            sb2.append((char) ((iJ % 10) + 48));
            for (int i13 : iArr2) {
                i10 += i13;
            }
            if (iJ >= 10) {
                i11 |= 1 << (5 - i12);
            }
        }
        s(sb2, i11);
        int i14 = x.n(aVar, i10, true, x.f13014e)[1];
        for (int i15 = 0; i15 < 6 && i14 < iN; i15++) {
            sb2.append((char) (x.j(aVar, iArr2, i14, x.f13016g) + 48));
            for (int i16 : iArr2) {
                i14 += i16;
            }
        }
        return i14;
    }

    @Override // v3.x
    public BarcodeFormat q() {
        return BarcodeFormat.EAN_13;
    }
}
