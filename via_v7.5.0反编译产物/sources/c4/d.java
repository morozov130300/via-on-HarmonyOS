package c4;

import com.google.zxing.k;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d extends k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f1946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1947d;

    public d(float f10, float f11, float f12) {
        this(f10, f11, f12, 1);
    }

    public boolean f(float f10, float f11, float f12) {
        if (Math.abs(f11 - d()) > f10 || Math.abs(f12 - c()) > f10) {
            return false;
        }
        float fAbs = Math.abs(f10 - this.f1946c);
        return fAbs <= 1.0f || fAbs <= this.f1946c;
    }

    public d g(float f10, float f11, float f12) {
        int i10 = this.f1947d;
        int i11 = i10 + 1;
        float fC = (i10 * c()) + f11;
        float f13 = i11;
        return new d(fC / f13, ((this.f1947d * d()) + f10) / f13, ((this.f1947d * this.f1946c) + f12) / f13, i11);
    }

    public int h() {
        return this.f1947d;
    }

    public float i() {
        return this.f1946c;
    }

    public d(float f10, float f11, float f12, int i10) {
        super(f10, f11);
        this.f1946c = f12;
        this.f1947d = i10;
    }
}
