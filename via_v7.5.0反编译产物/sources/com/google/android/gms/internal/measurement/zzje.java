package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
final class zzje extends zzja {
    static final zzja zza = new zzje(new Object[0], 0);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final transient int f3233m;
    final transient Object[] zzb;

    public zzje(Object[] objArr, int i10) {
        this.zzb = objArr;
        this.f3233m = i10;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        b7.a(i10, this.f3233m, "index");
        Object obj = this.zzb[i10];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3233m;
    }

    @Override // com.google.android.gms.internal.measurement.zzja, com.google.android.gms.internal.measurement.zziw
    public final int zza(Object[] objArr, int i10) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.f3233m);
        return this.f3233m;
    }

    @Override // com.google.android.gms.internal.measurement.zziw
    public final int zzb() {
        return this.f3233m;
    }

    @Override // com.google.android.gms.internal.measurement.zziw
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zziw
    public final Object[] zze() {
        return this.zzb;
    }
}
