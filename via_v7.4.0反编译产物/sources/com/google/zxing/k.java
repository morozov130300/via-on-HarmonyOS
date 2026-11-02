package com.google.zxing;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public final float f4142a;

    /* renamed from: b, reason: collision with root package name */
    public final float f4143b;

    public k(float f10, float f11) {
        this.f4142a = f10;
        this.f4143b = f11;
    }

    public static float a(k kVar, k kVar2, k kVar3) {
        float f10 = kVar2.f4142a;
        float f11 = kVar2.f4143b;
        return ((kVar3.f4142a - f10) * (kVar.f4143b - f11)) - ((kVar3.f4143b - f11) * (kVar.f4142a - f10));
    }

    public static float b(k kVar, k kVar2) {
        return t3.a.a(kVar.f4142a, kVar.f4143b, kVar2.f4142a, kVar2.f4143b);
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
        return this.f4142a;
    }

    public final float d() {
        return this.f4143b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (this.f4142a == kVar.f4142a && this.f4143b == kVar.f4143b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f4142a) * 31) + Float.floatToIntBits(this.f4143b);
    }

    public final String toString() {
        return "(" + this.f4142a + ',' + this.f4143b + ')';
    }
}
