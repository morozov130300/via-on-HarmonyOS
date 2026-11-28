package com.google.zxing;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f3439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f3440b;

    public k(float f10, float f11) {
        this.f3439a = f10;
        this.f3440b = f11;
    }

    public static float a(k kVar, k kVar2, k kVar3) {
        float f10 = kVar2.f3439a;
        float f11 = kVar2.f3440b;
        return ((kVar3.f3439a - f10) * (kVar.f3440b - f11)) - ((kVar3.f3440b - f11) * (kVar.f3439a - f10));
    }

    public static float b(k kVar, k kVar2) {
        return u3.a.a(kVar.f3439a, kVar.f3440b, kVar2.f3439a, kVar2.f3440b);
    }

    public static void e(k[] kVarArr) {
        k kVar;
        k kVar2;
        k kVar3;
        float fB = b(kVarArr[0], kVarArr[1]);
        float fB2 = b(kVarArr[1], kVarArr[2]);
        float fB3 = b(kVarArr[0], kVarArr[2]);
        if (fB2 >= fB && fB2 >= fB3) {
            kVar = kVarArr[0];
            kVar2 = kVarArr[1];
            kVar3 = kVarArr[2];
        } else if (fB3 < fB2 || fB3 < fB) {
            kVar = kVarArr[2];
            kVar2 = kVarArr[0];
            kVar3 = kVarArr[1];
        } else {
            kVar = kVarArr[1];
            kVar2 = kVarArr[0];
            kVar3 = kVarArr[2];
        }
        if (a(kVar2, kVar, kVar3) < 0.0f) {
            k kVar4 = kVar3;
            kVar3 = kVar2;
            kVar2 = kVar4;
        }
        kVarArr[0] = kVar2;
        kVarArr[1] = kVar;
        kVarArr[2] = kVar3;
    }

    public final float c() {
        return this.f3439a;
    }

    public final float d() {
        return this.f3440b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (this.f3439a == kVar.f3439a && this.f3440b == kVar.f3440b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f3439a) * 31) + Float.floatToIntBits(this.f3440b);
    }

    public final String toString() {
        return "(" + this.f3439a + ',' + this.f3440b + ')';
    }
}
