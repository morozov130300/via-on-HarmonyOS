package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class ya extends za {
    public ya(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.measurement.za
    public final double a(Object obj, long j10) {
        return Double.longBitsToDouble(this.f3914a.getLong(obj, j10));
    }

    @Override // com.google.android.gms.internal.measurement.za
    public final float b(Object obj, long j10) {
        return Float.intBitsToFloat(this.f3914a.getInt(obj, j10));
    }

    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.measurement.ab.n(java.lang.Object, long, boolean):void */
    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.measurement.ab.o(java.lang.Object, long, boolean):void */
    /* JADX WARN: Failed to replace arg (r3v0 'z' boolean A[IMMUTABLE_TYPE, METHOD_ARGUMENT]) for method inline: com.google.android.gms.internal.measurement.ab.n(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 boolean)' in method call: com.google.android.gms.internal.measurement.ab.o(java.lang.Object, long, boolean):void */
    @Override // com.google.android.gms.internal.measurement.za
    public final void c(Object obj, long j10, boolean z10) {
        if (ab.f3396h) {
            ab.n(obj, j10, z10);
        } else {
            ab.o(obj, j10, z10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.za
    public final void d(Object obj, long j10, byte b10) {
        if (ab.f3396h) {
            ab.d(obj, j10, b10);
        } else {
            ab.e(obj, j10, b10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.za
    public final void e(Object obj, long j10, double d10) {
        this.f3914a.putLong(obj, j10, Double.doubleToLongBits(d10));
    }

    @Override // com.google.android.gms.internal.measurement.za
    public final void f(Object obj, long j10, float f10) {
        this.f3914a.putInt(obj, j10, Float.floatToIntBits(f10));
    }

    @Override // com.google.android.gms.internal.measurement.za
    public final boolean g(Object obj, long j10) {
        return ab.f3396h ? ab.y(obj, j10) : ab.z(obj, j10);
    }
}
