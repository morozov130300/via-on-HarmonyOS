package com.google.zxing.qrcode.decoder;

import b4.d;
import b4.f;
import com.google.zxing.FormatException;
import t3.b;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f3455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f3456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f3457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3458d;

    public a(b bVar) throws FormatException {
        int iK = bVar.k();
        if (iK < 21 || (iK & 3) != 1) {
            throw FormatException.getFormatInstance();
        }
        this.f3455a = bVar;
    }

    public final int a(int i10, int i11, int i12) {
        return this.f3458d ? this.f3455a.i(i11, i10) : this.f3455a.i(i10, i11) ? (i12 << 1) | 1 : i12 << 1;
    }

    public void b() {
        int i10 = 0;
        while (i10 < this.f3455a.m()) {
            int i11 = i10 + 1;
            for (int i12 = i11; i12 < this.f3455a.k(); i12++) {
                if (this.f3455a.i(i10, i12) != this.f3455a.i(i12, i10)) {
                    this.f3455a.e(i12, i10);
                    this.f3455a.e(i10, i12);
                }
            }
            i10 = i11;
        }
    }

    public byte[] c() throws FormatException {
        d dVarD = d();
        f fVarE = e();
        DataMask dataMask = DataMask.values()[dVarD.c()];
        int iK = this.f3455a.k();
        dataMask.unmaskBitMatrix(this.f3455a, iK);
        b bVarA = fVarE.a();
        byte[] bArr = new byte[fVarE.h()];
        int i10 = iK - 1;
        boolean z10 = true;
        int i11 = i10;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i11 > 0) {
            if (i11 == 6) {
                i11--;
            }
            for (int i15 = 0; i15 < iK; i15++) {
                int i16 = z10 ? i10 - i15 : i15;
                for (int i17 = 0; i17 < 2; i17++) {
                    int i18 = i11 - i17;
                    if (!bVarA.i(i18, i16)) {
                        i13++;
                        i14 <<= 1;
                        if (this.f3455a.i(i18, i16)) {
                            i14 |= 1;
                        }
                        if (i13 == 8) {
                            bArr[i12] = (byte) i14;
                            i12++;
                            i13 = 0;
                            i14 = 0;
                        }
                    }
                }
            }
            z10 = !z10;
            i11 -= 2;
        }
        if (i12 == fVarE.h()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }

    public d d() throws FormatException {
        d dVar = this.f3457c;
        if (dVar != null) {
            return dVar;
        }
        int iA = 0;
        int iA2 = 0;
        for (int i10 = 0; i10 < 6; i10++) {
            iA2 = a(i10, 8, iA2);
        }
        int iA3 = a(8, 7, a(8, 8, a(7, 8, iA2)));
        for (int i11 = 5; i11 >= 0; i11--) {
            iA3 = a(8, i11, iA3);
        }
        int iK = this.f3455a.k();
        int i12 = iK - 7;
        for (int i13 = iK - 1; i13 >= i12; i13--) {
            iA = a(8, i13, iA);
        }
        for (int i14 = iK - 8; i14 < iK; i14++) {
            iA = a(i14, 8, iA);
        }
        d dVarA = d.a(iA3, iA);
        this.f3457c = dVarA;
        if (dVarA != null) {
            return dVarA;
        }
        throw FormatException.getFormatInstance();
    }

    public f e() throws FormatException {
        f fVar = this.f3456b;
        if (fVar != null) {
            return fVar;
        }
        int iK = this.f3455a.k();
        int i10 = (iK - 17) / 4;
        if (i10 <= 6) {
            return f.i(i10);
        }
        int i11 = iK - 11;
        int iA = 0;
        int iA2 = 0;
        for (int i12 = 5; i12 >= 0; i12--) {
            for (int i13 = iK - 9; i13 >= i11; i13--) {
                iA2 = a(i13, i12, iA2);
            }
        }
        f fVarC = f.c(iA2);
        if (fVarC != null && fVarC.e() == iK) {
            this.f3456b = fVarC;
            return fVarC;
        }
        for (int i14 = 5; i14 >= 0; i14--) {
            for (int i15 = iK - 9; i15 >= i11; i15--) {
                iA = a(i14, i15, iA);
            }
        }
        f fVarC2 = f.c(iA);
        if (fVarC2 == null || fVarC2.e() != iK) {
            throw FormatException.getFormatInstance();
        }
        this.f3456b = fVarC2;
        return fVarC2;
    }

    public void f() {
        if (this.f3457c == null) {
            return;
        }
        DataMask.values()[this.f3457c.c()].unmaskBitMatrix(this.f3455a, this.f3455a.k());
    }

    public void g(boolean z10) {
        this.f3456b = null;
        this.f3457c = null;
        this.f3458d = z10;
    }
}
