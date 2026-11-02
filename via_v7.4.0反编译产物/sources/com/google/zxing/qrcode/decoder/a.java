package com.google.zxing.qrcode.decoder;

import a4.d;
import a4.f;
import com.google.zxing.FormatException;
import s3.b;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final b f4158a;

    /* renamed from: b, reason: collision with root package name */
    public f f4159b;

    /* renamed from: c, reason: collision with root package name */
    public d f4160c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4161d;

    public a(b bVar) throws FormatException {
        int iJ = bVar.j();
        if (iJ < 21 || (iJ & 3) != 1) {
            throw FormatException.getFormatInstance();
        }
        this.f4158a = bVar;
    }

    public final int a(int i10, int i11, int i12) {
        return this.f4161d ? this.f4158a.e(i11, i10) : this.f4158a.e(i10, i11) ? (i12 << 1) | 1 : i12 << 1;
    }

    public void b() {
        int i10 = 0;
        while (i10 < this.f4158a.m()) {
            int i11 = i10 + 1;
            for (int i12 = i11; i12 < this.f4158a.j(); i12++) {
                if (this.f4158a.e(i10, i12) != this.f4158a.e(i12, i10)) {
                    this.f4158a.d(i12, i10);
                    this.f4158a.d(i10, i12);
                }
            }
            i10 = i11;
        }
    }

    public byte[] c() throws FormatException {
        d dVarD = d();
        f fVarE = e();
        DataMask dataMask = DataMask.values()[dVarD.c()];
        int iJ = this.f4158a.j();
        dataMask.unmaskBitMatrix(this.f4158a, iJ);
        b bVarA = fVarE.a();
        byte[] bArr = new byte[fVarE.h()];
        int i10 = iJ - 1;
        boolean z10 = true;
        int i11 = i10;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i11 > 0) {
            if (i11 == 6) {
                i11--;
            }
            for (int i15 = 0; i15 < iJ; i15++) {
                int i16 = z10 ? i10 - i15 : i15;
                for (int i17 = 0; i17 < 2; i17++) {
                    int i18 = i11 - i17;
                    if (!bVarA.e(i18, i16)) {
                        i13++;
                        i14 <<= 1;
                        if (this.f4158a.e(i18, i16)) {
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
        d dVar = this.f4160c;
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
        int iJ = this.f4158a.j();
        int i12 = iJ - 7;
        for (int i13 = iJ - 1; i13 >= i12; i13--) {
            iA = a(8, i13, iA);
        }
        for (int i14 = iJ - 8; i14 < iJ; i14++) {
            iA = a(i14, 8, iA);
        }
        d dVarA = d.a(iA3, iA);
        this.f4160c = dVarA;
        if (dVarA != null) {
            return dVarA;
        }
        throw FormatException.getFormatInstance();
    }

    public f e() throws FormatException {
        f fVar = this.f4159b;
        if (fVar != null) {
            return fVar;
        }
        int iJ = this.f4158a.j();
        int i10 = (iJ - 17) / 4;
        if (i10 <= 6) {
            return f.i(i10);
        }
        int i11 = iJ - 11;
        int iA = 0;
        int iA2 = 0;
        for (int i12 = 5; i12 >= 0; i12--) {
            for (int i13 = iJ - 9; i13 >= i11; i13--) {
                iA2 = a(i13, i12, iA2);
            }
        }
        f fVarC = f.c(iA2);
        if (fVarC != null && fVarC.e() == iJ) {
            this.f4159b = fVarC;
            return fVarC;
        }
        for (int i14 = 5; i14 >= 0; i14--) {
            for (int i15 = iJ - 9; i15 >= i11; i15--) {
                iA = a(i14, i15, iA);
            }
        }
        f fVarC2 = f.c(iA);
        if (fVarC2 == null || fVarC2.e() != iJ) {
            throw FormatException.getFormatInstance();
        }
        this.f4159b = fVarC2;
        return fVarC2;
    }

    public void f() {
        if (this.f4160c == null) {
            return;
        }
        DataMask.values()[this.f4160c.c()].unmaskBitMatrix(this.f4158a, this.f4158a.j());
    }

    public void g(boolean z10) {
        this.f4159b = null;
        this.f4160c = null;
        this.f4161d = z10;
    }
}
