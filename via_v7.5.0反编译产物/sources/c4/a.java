package c4;

import com.google.zxing.k;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a extends k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f1934c;

    public a(float f10, float f11, float f12) {
        super(f10, f11);
        this.f1934c = f12;
    }

    public boolean f(float f10, float f11, float f12) {
        if (Math.abs(f11 - d()) > f10 || Math.abs(f12 - c()) > f10) {
            return false;
        }
        float fAbs = Math.abs(f10 - this.f1934c);
        return fAbs <= 1.0f || fAbs <= this.f1934c;
    }

    public a g(float f10, float f11, float f12) {
        return new a((c() + f11) / 2.0f, (d() + f10) / 2.0f, (this.f1934c + f12) / 2.0f);
    }
}
