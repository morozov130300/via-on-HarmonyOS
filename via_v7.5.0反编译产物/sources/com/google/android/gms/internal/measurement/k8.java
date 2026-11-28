package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class k8 extends m8 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f2888d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f2889e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2890f;

    public k8(byte[] bArr, int i10, int i11) {
        super(null);
        if (bArr == null) {
            throw new NullPointerException("buffer");
        }
        int length = bArr.length;
        if (((length - i11) | i11) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i11)));
        }
        this.f2888d = bArr;
        this.f2890f = 0;
        this.f2889e = i11;
    }

    public final void B(byte[] bArr, int i10, int i11) {
        try {
            System.arraycopy(bArr, 0, this.f2888d, this.f2890f, i11);
            this.f2890f += i11;
        } catch (IndexOutOfBoundsException e10) {
            throw new zzkg(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2890f), Integer.valueOf(this.f2889e), Integer.valueOf(i11)), e10);
        }
    }

    public final void C(String str) throws zzkg {
        int i10 = this.f2890f;
        try {
            int iY = m8.y(str.length() * 3);
            int iY2 = m8.y(str.length());
            if (iY2 != iY) {
                r(eb.c(str));
                byte[] bArr = this.f2888d;
                int i11 = this.f2890f;
                this.f2890f = eb.b(str, bArr, i11, this.f2889e - i11);
                return;
            }
            int i12 = i10 + iY2;
            this.f2890f = i12;
            int iB = eb.b(str, this.f2888d, i12, this.f2889e - i12);
            this.f2890f = i10;
            r((iB - i10) - iY2);
            this.f2890f = iB;
        } catch (zzny e10) {
            this.f2890f = i10;
            b(str, e10);
        } catch (IndexOutOfBoundsException e11) {
            throw new zzkg(e11);
        }
    }

    @Override // com.google.android.gms.internal.measurement.m8
    public final int d() {
        return this.f2889e - this.f2890f;
    }

    @Override // com.google.android.gms.internal.measurement.m8
    public final void e(byte b10) throws zzkg {
        try {
            byte[] bArr = this.f2888d;
            int i10 = this.f2890f;
            this.f2890f = i10 + 1;
            bArr[i10] = b10;
        } catch (IndexOutOfBoundsException e10) {
            throw new zzkg(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2890f), Integer.valueOf(this.f2889e), 1), e10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.m8
    public final void f(int i10, boolean z10) throws zzkg {
        r(i10 << 3);
        e(z10 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.measurement.m8
    public final void g(int i10, zzka zzkaVar) throws zzkg {
        r((i10 << 3) | 2);
        r(zzkaVar.zzd());
        zzkaVar.zzh(this);
    }

    @Override // com.google.android.gms.internal.measurement.m8
    public final void h(int i10, int i11) throws zzkg {
        r((i10 << 3) | 5);
        i(i11);
    }

    @Override // com.google.android.gms.internal.measurement.m8
    public final void i(int i10) throws zzkg {
        try {
            byte[] bArr = this.f2888d;
            int i11 = this.f2890f;
            int i12 = i11 + 1;
            this.f2890f = i12;
            bArr[i11] = (byte) (i10 & 255);
            int i13 = i11 + 2;
            this.f2890f = i13;
            bArr[i12] = (byte) ((i10 >> 8) & 255);
            int i14 = i11 + 3;
            this.f2890f = i14;
            bArr[i13] = (byte) ((i10 >> 16) & 255);
            this.f2890f = i11 + 4;
            bArr[i14] = (byte) ((i10 >> 24) & 255);
        } catch (IndexOutOfBoundsException e10) {
            throw new zzkg(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2890f), Integer.valueOf(this.f2889e), 1), e10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.m8
    public final void j(int i10, long j10) throws zzkg {
        r((i10 << 3) | 1);
        k(j10);
    }

    @Override // com.google.android.gms.internal.measurement.m8
    public final void k(long j10) throws zzkg {
        try {
            byte[] bArr = this.f2888d;
            int i10 = this.f2890f;
            int i11 = i10 + 1;
            this.f2890f = i11;
            bArr[i10] = (byte) (((int) j10) & 255);
            int i12 = i10 + 2;
            this.f2890f = i12;
            bArr[i11] = (byte) (((int) (j10 >> 8)) & 255);
            int i13 = i10 + 3;
            this.f2890f = i13;
            bArr[i12] = (byte) (((int) (j10 >> 16)) & 255);
            int i14 = i10 + 4;
            this.f2890f = i14;
            bArr[i13] = (byte) (((int) (j10 >> 24)) & 255);
            int i15 = i10 + 5;
            this.f2890f = i15;
            bArr[i14] = (byte) (((int) (j10 >> 32)) & 255);
            int i16 = i10 + 6;
            this.f2890f = i16;
            bArr[i15] = (byte) (((int) (j10 >> 40)) & 255);
            int i17 = i10 + 7;
            this.f2890f = i17;
            bArr[i16] = (byte) (((int) (j10 >> 48)) & 255);
            this.f2890f = i10 + 8;
            bArr[i17] = (byte) (((int) (j10 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e10) {
            throw new zzkg(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2890f), Integer.valueOf(this.f2889e), 1), e10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.m8
    public final void l(int i10, int i11) throws zzkg {
        r(i10 << 3);
        m(i11);
    }

    @Override // com.google.android.gms.internal.measurement.m8
    public final void m(int i10) throws zzkg {
        if (i10 >= 0) {
            r(i10);
        } else {
            t(i10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.m8
    public final void n(byte[] bArr, int i10, int i11) {
        B(bArr, 0, i11);
    }

    @Override // com.google.android.gms.internal.measurement.m8
    public final void o(int i10, String str) throws zzkg {
        r((i10 << 3) | 2);
        C(str);
    }

    @Override // com.google.android.gms.internal.measurement.m8
    public final void p(int i10, int i11) throws zzkg {
        r((i10 << 3) | i11);
    }

    @Override // com.google.android.gms.internal.measurement.m8
    public final void q(int i10, int i11) throws zzkg {
        r(i10 << 3);
        r(i11);
    }

    @Override // com.google.android.gms.internal.measurement.m8
    public final void r(int i10) throws zzkg {
        while ((i10 & (-128)) != 0) {
            try {
                byte[] bArr = this.f2888d;
                int i11 = this.f2890f;
                this.f2890f = i11 + 1;
                bArr[i11] = (byte) ((i10 & 127) | 128);
                i10 >>>= 7;
            } catch (IndexOutOfBoundsException e10) {
                throw new zzkg(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2890f), Integer.valueOf(this.f2889e), 1), e10);
            }
        }
        byte[] bArr2 = this.f2888d;
        int i12 = this.f2890f;
        this.f2890f = i12 + 1;
        bArr2[i12] = (byte) i10;
    }

    @Override // com.google.android.gms.internal.measurement.m8
    public final void s(int i10, long j10) throws zzkg {
        r(i10 << 3);
        t(j10);
    }

    @Override // com.google.android.gms.internal.measurement.m8
    public final void t(long j10) throws zzkg {
        if (m8.f2920c && this.f2889e - this.f2890f >= 10) {
            while ((j10 & (-128)) != 0) {
                byte[] bArr = this.f2888d;
                int i10 = this.f2890f;
                this.f2890f = i10 + 1;
                ab.s(bArr, i10, (byte) ((((int) j10) & 127) | 128));
                j10 >>>= 7;
            }
            byte[] bArr2 = this.f2888d;
            int i11 = this.f2890f;
            this.f2890f = i11 + 1;
            ab.s(bArr2, i11, (byte) j10);
            return;
        }
        while ((j10 & (-128)) != 0) {
            try {
                byte[] bArr3 = this.f2888d;
                int i12 = this.f2890f;
                this.f2890f = i12 + 1;
                bArr3[i12] = (byte) ((((int) j10) & 127) | 128);
                j10 >>>= 7;
            } catch (IndexOutOfBoundsException e10) {
                throw new zzkg(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2890f), Integer.valueOf(this.f2889e), 1), e10);
            }
        }
        byte[] bArr4 = this.f2888d;
        int i13 = this.f2890f;
        this.f2890f = i13 + 1;
        bArr4[i13] = (byte) j10;
    }
}
