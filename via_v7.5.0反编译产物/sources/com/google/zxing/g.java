package com.google.zxing;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class g extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f3422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3423d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f3424e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f3425f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f3426g;

    public g(byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15, boolean z10) {
        super(i14, i15);
        if (i12 + i14 > i10 || i13 + i15 > i11) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f3422c = bArr;
        this.f3423d = i10;
        this.f3424e = i11;
        this.f3425f = i12;
        this.f3426g = i13;
        if (z10) {
            h(i14, i15);
        }
    }

    @Override // com.google.zxing.d
    public byte[] b() {
        int iD = d();
        int iA = a();
        int i10 = this.f3423d;
        if (iD == i10 && iA == this.f3424e) {
            return this.f3422c;
        }
        int i11 = iD * iA;
        byte[] bArr = new byte[i11];
        int i12 = (this.f3426g * i10) + this.f3425f;
        if (iD == i10) {
            System.arraycopy(this.f3422c, i12, bArr, 0, i11);
            return bArr;
        }
        for (int i13 = 0; i13 < iA; i13++) {
            System.arraycopy(this.f3422c, i12, bArr, i13 * iD, iD);
            i12 += this.f3423d;
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
        System.arraycopy(this.f3422c, ((i10 + this.f3426g) * this.f3423d) + this.f3425f, bArr, 0, iD);
        return bArr;
    }

    public final void h(int i10, int i11) {
        byte[] bArr = this.f3422c;
        int i12 = (this.f3426g * this.f3423d) + this.f3425f;
        int i13 = 0;
        while (i13 < i11) {
            int i14 = (i10 / 2) + i12;
            int i15 = (i12 + i10) - 1;
            int i16 = i12;
            while (i16 < i14) {
                byte b10 = bArr[i16];
                bArr[i16] = bArr[i15];
                bArr[i15] = b10;
                i16++;
                i15--;
            }
            i13++;
            i12 += this.f3423d;
        }
    }
}
