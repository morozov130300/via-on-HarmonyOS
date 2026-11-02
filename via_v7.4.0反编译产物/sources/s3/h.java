package s3;

import com.google.zxing.NotFoundException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class h extends com.google.zxing.a {

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f11832d = new byte[0];

    /* renamed from: b, reason: collision with root package name */
    public byte[] f11833b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f11834c;

    public h(com.google.zxing.d dVar) {
        super(dVar);
        this.f11833b = f11832d;
        this.f11834c = new int[32];
    }

    public static int g(int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            int i14 = iArr[i13];
            if (i14 > i10) {
                i12 = i13;
                i10 = i14;
            }
            if (i14 > i11) {
                i11 = i14;
            }
        }
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < length; i17++) {
            int i18 = i17 - i12;
            int i19 = iArr[i17] * i18 * i18;
            if (i19 > i16) {
                i15 = i17;
                i16 = i19;
            }
        }
        if (i12 <= i15) {
            int i20 = i12;
            i12 = i15;
            i15 = i20;
        }
        if (i12 - i15 <= length / 16) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i21 = i12 - 1;
        int i22 = i21;
        int i23 = -1;
        while (i21 > i15) {
            int i24 = i21 - i15;
            int i25 = i24 * i24 * (i12 - i21) * (i11 - iArr[i21]);
            if (i25 > i23) {
                i22 = i21;
                i23 = i25;
            }
            i21--;
        }
        return i22 << 3;
    }

    @Override // com.google.zxing.a
    public b b() throws NotFoundException {
        com.google.zxing.d dVarE = e();
        int iD = dVarE.d();
        int iA = dVarE.a();
        b bVar = new b(iD, iA);
        h(iD);
        int[] iArr = this.f11834c;
        for (int i10 = 1; i10 < 5; i10++) {
            byte[] bArrC = dVarE.c((iA * i10) / 5, this.f11833b);
            int i11 = (iD * 4) / 5;
            for (int i12 = iD / 5; i12 < i11; i12++) {
                int i13 = (bArrC[i12] & 255) >> 3;
                iArr[i13] = iArr[i13] + 1;
            }
        }
        int iG = g(iArr);
        byte[] bArrB = dVarE.b();
        for (int i14 = 0; i14 < iA; i14++) {
            int i15 = i14 * iD;
            for (int i16 = 0; i16 < iD; i16++) {
                if ((bArrB[i15 + i16] & 255) < iG) {
                    bVar.n(i16, i14);
                }
            }
        }
        return bVar;
    }

    @Override // com.google.zxing.a
    public a c(int i10, a aVar) throws NotFoundException {
        com.google.zxing.d dVarE = e();
        int iD = dVarE.d();
        if (aVar == null || aVar.n() < iD) {
            aVar = new a(iD);
        } else {
            aVar.d();
        }
        h(iD);
        byte[] bArrC = dVarE.c(i10, this.f11833b);
        int[] iArr = this.f11834c;
        for (int i11 = 0; i11 < iD; i11++) {
            int i12 = (bArrC[i11] & 255) >> 3;
            iArr[i12] = iArr[i12] + 1;
        }
        int iG = g(iArr);
        if (iD < 3) {
            for (int i13 = 0; i13 < iD; i13++) {
                if ((bArrC[i13] & 255) < iG) {
                    aVar.s(i13);
                }
            }
        } else {
            int i14 = bArrC[0] & 255;
            int i15 = bArrC[1] & 255;
            int i16 = 1;
            while (i16 < iD - 1) {
                int i17 = i16 + 1;
                int i18 = bArrC[i17] & 255;
                if ((((i15 * 4) - i14) - i18) / 2 < iG) {
                    aVar.s(i16);
                }
                i14 = i15;
                i16 = i17;
                i15 = i18;
            }
        }
        return aVar;
    }

    public final void h(int i10) {
        if (this.f11833b.length < i10) {
            this.f11833b = new byte[i10];
        }
        for (int i11 = 0; i11 < 32; i11++) {
            this.f11834c[i11] = 0;
        }
    }
}
