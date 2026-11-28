package n5;

import android.graphics.Rect;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f10678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Rect f10681d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10682e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f10683f;

    public w(byte[] bArr, int i10, int i11, int i12, int i13) {
        this.f10678a = new s(bArr, i10, i11);
        this.f10680c = i13;
        this.f10679b = i12;
        if (i10 * i11 <= bArr.length) {
            return;
        }
        throw new IllegalArgumentException("Image data does not match the resolution. " + i10 + "x" + i11 + " > " + bArr.length);
    }

    public com.google.zxing.g a() {
        s sVarA = this.f10678a.h(this.f10680c).a(this.f10681d, this.f10682e);
        return new com.google.zxing.g(sVarA.b(), sVarA.d(), sVarA.c(), 0, 0, sVarA.d(), sVarA.c(), false);
    }

    public void b(Rect rect) {
        this.f10681d = rect;
    }

    public void c(boolean z10) {
        this.f10683f = z10;
    }

    public com.google.zxing.k d(com.google.zxing.k kVar) {
        float fC = (kVar.c() * this.f10682e) + this.f10681d.left;
        float fD = (kVar.d() * this.f10682e) + this.f10681d.top;
        if (this.f10683f) {
            fC = this.f10678a.d() - fC;
        }
        return new com.google.zxing.k(fC, fD);
    }
}
