package a4;

import a4.f;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f62a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f63b;

    public a(int i10, byte[] bArr) {
        this.f62a = i10;
        this.f63b = bArr;
    }

    public static a[] b(byte[] bArr, f fVar, ErrorCorrectionLevel errorCorrectionLevel) {
        if (bArr.length != fVar.h()) {
            throw new IllegalArgumentException();
        }
        f.b bVarF = fVar.f(errorCorrectionLevel);
        f.a[] aVarArrA = bVarF.a();
        int iA = 0;
        for (f.a aVar : aVarArrA) {
            iA += aVar.a();
        }
        a[] aVarArr = new a[iA];
        int i10 = 0;
        for (f.a aVar2 : aVarArrA) {
            int i11 = 0;
            while (i11 < aVar2.a()) {
                int iB = aVar2.b();
                aVarArr[i10] = new a(iB, new byte[bVarF.b() + iB]);
                i11++;
                i10++;
            }
        }
        int length = aVarArr[0].f63b.length;
        int i12 = iA - 1;
        while (i12 >= 0 && aVarArr[i12].f63b.length != length) {
            i12--;
        }
        int i13 = i12 + 1;
        int iB2 = length - bVarF.b();
        int i14 = 0;
        for (int i15 = 0; i15 < iB2; i15++) {
            int i16 = 0;
            while (i16 < i10) {
                aVarArr[i16].f63b[i15] = bArr[i14];
                i16++;
                i14++;
            }
        }
        int i17 = i13;
        while (i17 < i10) {
            aVarArr[i17].f63b[iB2] = bArr[i14];
            i17++;
            i14++;
        }
        int length2 = aVarArr[0].f63b.length;
        while (iB2 < length2) {
            int i18 = 0;
            while (i18 < i10) {
                aVarArr[i18].f63b[i18 < i13 ? iB2 : iB2 + 1] = bArr[i14];
                i18++;
                i14++;
            }
            iB2++;
        }
        return aVarArr;
    }

    public byte[] a() {
        return this.f63b;
    }

    public int c() {
        return this.f62a;
    }
}
