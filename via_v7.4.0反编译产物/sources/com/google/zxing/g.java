package com.google.zxing;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class g extends d {

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f4125c;

    /* renamed from: d, reason: collision with root package name */
    public final int f4126d;

    /* renamed from: e, reason: collision with root package name */
    public final int f4127e;

    /* renamed from: f, reason: collision with root package name */
    public final int f4128f;

    /* renamed from: g, reason: collision with root package name */
    public final int f4129g;

    public g(byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15, boolean z10) {
        super(i14, i15);
        if (i12 + i14 > i10 || i13 + i15 > i11) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f4125c = bArr;
        this.f4126d = i10;
        this.f4127e = i11;
        this.f4128f = i12;
        this.f4129g = i13;
        if (z10) {
            h(i14, i15);
        }
    }

    @Override // com.google.zxing.d
    public byte[] b() {
        int iD = d();
        int iA = a();
        int i10 = this.f4126d;
        if (iD == i10 && iA == this.f4127e) {
            return this.f4125c;
        }
        int i11 = iD * iA;
        byte[] bArr = new byte[i11];
        int i12 = (this.f4129g * i10) + this.f4128f;
        if (iD == i10) {
            System.arraycopy(this.f4125c, i12, bArr, 0, i11);
            return bArr;
        }
        for (int i13 = 0; i13 < iA; i13++) {
            System.arraycopy(this.f4125c, i12, bArr, i13 * iD, iD);
            i12 += this.f4126d;
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
        System.arraycopy(this.f4125c, ((i10 + this.f4129g) * this.f4126d) + this.f4128f, bArr, 0, iD);
        return bArr;
    }

    public final void h(int i10, int i11) {
        byte[] bArr = this.f4125c;
        int i12 = (this.f4129g * this.f4126d) + this.f4128f;
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
            i12 += this.f4126d;
        }
    }
}
