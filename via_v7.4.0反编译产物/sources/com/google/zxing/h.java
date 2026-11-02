package com.google.zxing;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class h extends d {

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f4130c;

    /* renamed from: d, reason: collision with root package name */
    public final int f4131d;

    /* renamed from: e, reason: collision with root package name */
    public final int f4132e;

    /* renamed from: f, reason: collision with root package name */
    public final int f4133f;

    /* renamed from: g, reason: collision with root package name */
    public final int f4134g;

    public h(int i10, int i11, int[] iArr) {
        super(i10, i11);
        this.f4131d = i10;
        this.f4132e = i11;
        this.f4133f = 0;
        this.f4134g = 0;
        int i12 = i10 * i11;
        this.f4130c = new byte[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = iArr[i13];
            this.f4130c[i13] = (byte) (((((i14 >> 16) & 255) + ((i14 >> 7) & 510)) + (i14 & 255)) / 4);
        }
    }

    @Override // com.google.zxing.d
    public byte[] b() {
        int iD = d();
        int iA = a();
        int i10 = this.f4131d;
        if (iD == i10 && iA == this.f4132e) {
            return this.f4130c;
        }
        int i11 = iD * iA;
        byte[] bArr = new byte[i11];
        int i12 = (this.f4134g * i10) + this.f4133f;
        if (iD == i10) {
            System.arraycopy(this.f4130c, i12, bArr, 0, i11);
            return bArr;
        }
        for (int i13 = 0; i13 < iA; i13++) {
            System.arraycopy(this.f4130c, i12, bArr, i13 * iD, iD);
            i12 += this.f4131d;
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
        System.arraycopy(this.f4130c, ((i10 + this.f4134g) * this.f4131d) + this.f4133f, bArr, 0, iD);
        return bArr;
    }
}
