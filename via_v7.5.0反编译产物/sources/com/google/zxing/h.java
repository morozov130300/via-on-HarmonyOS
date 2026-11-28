package com.google.zxing;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class h extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f3427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3428d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f3429e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f3430f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f3431g;

    public h(int i10, int i11, int[] iArr) {
        super(i10, i11);
        this.f3428d = i10;
        this.f3429e = i11;
        this.f3430f = 0;
        this.f3431g = 0;
        int i12 = i10 * i11;
        this.f3427c = new byte[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = iArr[i13];
            this.f3427c[i13] = (byte) (((((i14 >> 16) & 255) + ((i14 >> 7) & 510)) + (i14 & 255)) / 4);
        }
    }

    @Override // com.google.zxing.d
    public byte[] b() {
        int iD = d();
        int iA = a();
        int i10 = this.f3428d;
        if (iD == i10 && iA == this.f3429e) {
            return this.f3427c;
        }
        int i11 = iD * iA;
        byte[] bArr = new byte[i11];
        int i12 = (this.f3431g * i10) + this.f3430f;
        if (iD == i10) {
            System.arraycopy(this.f3427c, i12, bArr, 0, i11);
            return bArr;
        }
        for (int i13 = 0; i13 < iA; i13++) {
            System.arraycopy(this.f3427c, i12, bArr, i13 * iD, iD);
            i12 += this.f3428d;
        }
        return bArr;
    }

    @Override // com.google.zxing.d
    public byte[] c(int i10, byte[] bArr) {
        if (i10 < 0 || i10 >= a()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i10);
        }
        int iD = d();
        if (bArr == null || bArr.length < iD) {
            bArr = new byte[iD];
        }
        System.arraycopy(this.f3427c, ((i10 + this.f3431g) * this.f3428d) + this.f3430f, bArr, 0, iD);
        return bArr;
    }
}
