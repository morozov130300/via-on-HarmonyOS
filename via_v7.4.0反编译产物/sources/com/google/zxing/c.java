package com.google.zxing;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c extends d {

    /* renamed from: c, reason: collision with root package name */
    public final d f4115c;

    public c(d dVar) {
        super(dVar.d(), dVar.a());
        this.f4115c = dVar;
    }

    @Override // com.google.zxing.d
    public byte[] b() {
        byte[] bArrB = this.f4115c.b();
        int iD = d() * a();
        byte[] bArr = new byte[iD];
        for (int i10 = 0; i10 < iD; i10++) {
            bArr[i10] = (byte) (255 - (bArrB[i10] & 255));
        }
        return bArr;
    }

    @Override // com.google.zxing.d
    public byte[] c(int i10, byte[] bArr) {
        byte[] bArrC = this.f4115c.c(i10, bArr);
        int iD = d();
        for (int i11 = 0; i11 < iD; i11++) {
            bArrC[i11] = (byte) (255 - (bArrC[i11] & 255));
        }
        return bArrC;
    }

    @Override // com.google.zxing.d
    public d e() {
        return this.f4115c;
    }

    @Override // com.google.zxing.d
    public boolean f() {
        return this.f4115c.f();
    }

    @Override // com.google.zxing.d
    public d g() {
        return new c(this.f4115c.g());
    }
}
