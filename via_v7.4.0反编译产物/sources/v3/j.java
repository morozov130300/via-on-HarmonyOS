package v3;

import com.google.zxing.BarcodeFormat;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class j extends x {

    /* renamed from: i, reason: collision with root package name */
    public final int[] f12987i = new int[4];

    @Override // v3.x
    public int l(s3.a aVar, int[] iArr, StringBuilder sb2) {
        int[] iArr2 = this.f12987i;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iN = aVar.n();
        int i10 = iArr[1];
        for (int i11 = 0; i11 < 4 && i10 < iN; i11++) {
            sb2.append((char) (x.j(aVar, iArr2, i10, x.f13016g) + 48));
            for (int i12 : iArr2) {
                i10 += i12;
            }
        }
        int i13 = x.n(aVar, i10, true, x.f13014e)[1];
        for (int i14 = 0; i14 < 4 && i13 < iN; i14++) {
            sb2.append((char) (x.j(aVar, iArr2, i13, x.f13016g) + 48));
            for (int i15 : iArr2) {
                i13 += i15;
            }
        }
        return i13;
    }

    @Override // v3.x
    public BarcodeFormat q() {
        return BarcodeFormat.EAN_8;
    }
}
