package t3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f12505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f12506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f12507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f12508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f12509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f12510f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f12511g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f12512h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f12513i;

    public k(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18) {
        this.f12505a = f10;
        this.f12506b = f13;
        this.f12507c = f16;
        this.f12508d = f11;
        this.f12509e = f14;
        this.f12510f = f17;
        this.f12511g = f12;
        this.f12512h = f15;
        this.f12513i = f18;
    }

    public static k b(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, float f22, float f23, float f24, float f25) {
        return d(f18, f19, f20, f21, f22, f23, f24, f25).e(c(f10, f11, f12, f13, f14, f15, f16, f17));
    }

    public static k c(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        return d(f10, f11, f12, f13, f14, f15, f16, f17).a();
    }

    public static k d(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        float f18 = ((f10 - f12) + f14) - f16;
        float f19 = ((f11 - f13) + f15) - f17;
        if (f18 == 0.0f && f19 == 0.0f) {
            return new k(f12 - f10, f14 - f12, f10, f13 - f11, f15 - f13, f11, 0.0f, 0.0f, 1.0f);
        }
        float f20 = f12 - f14;
        float f21 = f16 - f14;
        float f22 = f13 - f15;
        float f23 = f17 - f15;
        float f24 = (f20 * f23) - (f21 * f22);
        float f25 = ((f23 * f18) - (f21 * f19)) / f24;
        float f26 = ((f20 * f19) - (f18 * f22)) / f24;
        return new k((f12 - f10) + (f25 * f12), (f16 - f10) + (f26 * f16), f10, (f13 - f11) + (f25 * f13), (f17 - f11) + (f26 * f17), f11, f25, f26, 1.0f);
    }

    public k a() {
        float f10 = this.f12509e;
        float f11 = this.f12513i;
        float f12 = this.f12510f;
        float f13 = this.f12512h;
        float f14 = (f10 * f11) - (f12 * f13);
        float f15 = this.f12511g;
        float f16 = this.f12508d;
        float f17 = (f12 * f15) - (f16 * f11);
        float f18 = (f16 * f13) - (f10 * f15);
        float f19 = this.f12507c;
        float f20 = this.f12506b;
        float f21 = (f19 * f13) - (f20 * f11);
        float f22 = this.f12505a;
        return new k(f14, f17, f18, f21, (f11 * f22) - (f19 * f15), (f15 * f20) - (f13 * f22), (f20 * f12) - (f19 * f10), (f19 * f16) - (f12 * f22), (f22 * f10) - (f20 * f16));
    }

    public k e(k kVar) {
        float f10 = this.f12505a;
        float f11 = kVar.f12505a;
        float f12 = this.f12508d;
        float f13 = kVar.f12506b;
        float f14 = this.f12511g;
        float f15 = kVar.f12507c;
        float f16 = (f10 * f11) + (f12 * f13) + (f14 * f15);
        float f17 = kVar.f12508d;
        float f18 = kVar.f12509e;
        float f19 = kVar.f12510f;
        float f20 = (f10 * f17) + (f12 * f18) + (f14 * f19);
        float f21 = kVar.f12511g;
        float f22 = kVar.f12512h;
        float f23 = kVar.f12513i;
        float f24 = (f10 * f21) + (f12 * f22) + (f14 * f23);
        float f25 = this.f12506b;
        float f26 = this.f12509e;
        float f27 = (f25 * f11) + (f26 * f13);
        float f28 = this.f12512h;
        float f29 = f27 + (f28 * f15);
        float f30 = (f25 * f17) + (f26 * f18) + (f28 * f19);
        float f31 = (f25 * f21) + (f26 * f22) + (f28 * f23);
        float f32 = this.f12507c;
        float f33 = f11 * f32;
        float f34 = this.f12510f;
        float f35 = f33 + (f13 * f34);
        float f36 = this.f12513i;
        return new k(f16, f20, f24, f29, f30, f31, f35 + (f15 * f36), (f32 * f17) + (f18 * f34) + (f19 * f36), (f32 * f21) + (f34 * f22) + (f36 * f23));
    }

    public void f(float[] fArr) {
        float f10 = this.f12505a;
        float f11 = this.f12506b;
        float f12 = this.f12507c;
        float f13 = this.f12508d;
        float f14 = this.f12509e;
        float f15 = this.f12510f;
        float f16 = this.f12511g;
        float f17 = this.f12512h;
        float f18 = this.f12513i;
        int length = fArr.length - 1;
        for (int i10 = 0; i10 < length; i10 += 2) {
            float f19 = fArr[i10];
            int i11 = i10 + 1;
            float f20 = fArr[i11];
            float f21 = (f12 * f19) + (f15 * f20) + f18;
            fArr[i10] = (((f10 * f19) + (f13 * f20)) + f16) / f21;
            fArr[i11] = (((f19 * f11) + (f20 * f14)) + f17) / f21;
        }
    }
}
