package b4;

import com.google.zxing.k;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d extends k {

    /* renamed from: c, reason: collision with root package name */
    public final float f1816c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1817d;

    public d(float f10, float f11, float f12) {
        this(f10, f11, f12, 1);
    }

    public d(float f10, float f11, float f12, int i10) {
        super(f10, f11);
        this.f1816c = f12;
        this.f1817d = i10;
    }

    public boolean f(float f10, float f11, float f12) {
        if (Math.abs(f11 - d()) > f10 || Math.abs(f12 - c()) > f10) {
            return false;
        }
        float fAbs = Math.abs(f10 - this.f1816c);
        return fAbs <= 1.0f || fAbs <= this.f1816c;
    }

    public d g(float f10, float f11, float f12) {
        int i10 = this.f1817d;
        int i11 = i10 + 1;
        float fC = (i10 * c()) + f11;
        float f13 = i11;
        return new d(fC / f13, ((this.f1817d * d()) + f10) / f13, ((this.f1817d * this.f1816c) + f12) / f13, i11);
    }

    public int h() {
        return this.f1817d;
    }

    public float i() {
        return this.f1816c;
    }
}
