package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class xa extends za {
    public xa(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.measurement.za
    public final double a(Object obj, long j10) {
        return Double.longBitsToDouble(this.f3213a.getLong(obj, j10));
    }

    @Override // com.google.android.gms.internal.measurement.za
    public final float b(Object obj, long j10) {
        return Float.intBitsToFloat(this.f3213a.getInt(obj, j10));
    }

    @Override // com.google.android.gms.internal.measurement.za
    public final void c(Object obj, long j10, boolean z10) {
        if (ab.f2695h) {
            ab.d(obj, j10, z10 ? (byte) 1 : (byte) 0);
        } else {
            ab.e(obj, j10, z10 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.measurement.za
    public final void d(Object obj, long j10, byte b10) {
        if (ab.f2695h) {
            ab.d(obj, j10, b10);
        } else {
            ab.e(obj, j10, b10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.za
    public final void e(Object obj, long j10, double d10) {
        this.f3213a.putLong(obj, j10, Double.doubleToLongBits(d10));
    }

    @Override // com.google.android.gms.internal.measurement.za
    public final void f(Object obj, long j10, float f10) {
        this.f3213a.putInt(obj, j10, Float.floatToIntBits(f10));
    }

    @Override // com.google.android.gms.internal.measurement.za
    public final boolean g(Object obj, long j10) {
        return ab.f2695h ? ab.y(obj, j10) : ab.z(obj, j10);
    }
}
