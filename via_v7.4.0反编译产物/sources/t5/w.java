package t5;

import android.graphics.Rect;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    public s f12249a;

    /* renamed from: b, reason: collision with root package name */
    public int f12250b;

    /* renamed from: c, reason: collision with root package name */
    public int f12251c;

    /* renamed from: d, reason: collision with root package name */
    public Rect f12252d;

    /* renamed from: e, reason: collision with root package name */
    public int f12253e = 1;

    /* renamed from: f, reason: collision with root package name */
    public boolean f12254f;

    public w(byte[] bArr, int i10, int i11, int i12, int i13) {
        this.f12249a = new s(bArr, i10, i11);
        this.f12251c = i13;
        this.f12250b = i12;
        if (i10 * i11 <= bArr.length) {
            return;
        }
        throw new IllegalArgumentException("Image data does not match the resolution. " + i10 + "x" + i11 + " > " + bArr.length);
    }

    public com.google.zxing.g a() {
        s sVarA = this.f12249a.h(this.f12251c).a(this.f12252d, this.f12253e);
        return new com.google.zxing.g(sVarA.b(), sVarA.d(), sVarA.c(), 0, 0, sVarA.d(), sVarA.c(), false);
    }

    public void b(Rect rect) {
        this.f12252d = rect;
    }

    public void c(boolean z10) {
        this.f12254f = z10;
    }

    public com.google.zxing.k d(com.google.zxing.k kVar) {
        float fC = (kVar.c() * this.f12253e) + this.f12252d.left;
        float fD = (kVar.d() * this.f12253e) + this.f12252d.top;
        if (this.f12254f) {
            fC = this.f12249a.d() - fC;
        }
        return new com.google.zxing.k(fC, fD);
    }
}
