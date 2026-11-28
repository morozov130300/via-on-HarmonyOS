package com.google.zxing;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f3412c;

    public c(d dVar) {
        super(dVar.d(), dVar.a());
        this.f3412c = dVar;
    }

    @Override // com.google.zxing.d
    public byte[] b() {
        byte[] bArrB = this.f3412c.b();
        int iD = d() * a();
        byte[] bArr = new byte[iD];
        for (int i10 = 0; i10 < iD; i10++) {
            bArr[i10] = (byte) (255 - (bArrB[i10] & 255));
        }
        return bArr;
    }

    @Override // com.google.zxing.d
    public byte[] c(int i10, byte[] bArr) {
        byte[] bArrC = this.f3412c.c(i10, bArr);
        int iD = d();
        for (int i11 = 0; i11 < iD; i11++) {
            bArrC[i11] = (byte) (255 - (bArrC[i11] & 255));
        }
        return bArrC;
    }

    @Override // com.google.zxing.d
    public d e() {
        return this.f3412c;
    }

    @Override // com.google.zxing.d
    public boolean f() {
        return this.f3412c.f();
    }

    @Override // com.google.zxing.d
    public d g() {
        return new c(this.f3412c.g());
    }
}
