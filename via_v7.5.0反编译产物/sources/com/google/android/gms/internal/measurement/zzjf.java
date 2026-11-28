package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
final class zzjf extends zzjb {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Object[] f3234p;
    static final zzjf zza;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final transient int f3235m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final transient int f3236n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final transient int f3237o;
    final transient Object[] zzb;
    final transient Object[] zzc;

    static {
        Object[] objArr = new Object[0];
        f3234p = objArr;
        zza = new zzjf(objArr, 0, objArr, 0, 0);
    }

    public zzjf(Object[] objArr, int i10, Object[] objArr2, int i11, int i12) {
        this.zzb = objArr;
        this.f3235m = i10;
        this.zzc = objArr2;
        this.f3236n = i11;
        this.f3237o = i12;
    }

    @Override // com.google.android.gms.internal.measurement.zziw, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        Object[] objArr = this.zzc;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int iA = i7.a(obj.hashCode());
        while (true) {
            int i10 = iA & this.f3236n;
            Object obj2 = objArr[i10];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            iA = i10 + 1;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjb, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f3235m;
    }

    @Override // com.google.android.gms.internal.measurement.zzjb, com.google.android.gms.internal.measurement.zziw, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zzg().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f3237o;
    }

    @Override // com.google.android.gms.internal.measurement.zziw
    public final int zza(Object[] objArr, int i10) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.f3237o);
        return this.f3237o;
    }

    @Override // com.google.android.gms.internal.measurement.zziw
    public final int zzb() {
        return this.f3237o;
    }

    @Override // com.google.android.gms.internal.measurement.zziw
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzjb, com.google.android.gms.internal.measurement.zziw
    /* JADX INFO: renamed from: zzd */
    public final q7 iterator() {
        return zzg().listIterator(0);
    }

    @Override // com.google.android.gms.internal.measurement.zziw
    public final Object[] zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzjb
    public final zzja zzh() {
        return zzja.zzg(this.zzb, this.f3237o);
    }

    @Override // com.google.android.gms.internal.measurement.zzjb
    public final boolean zzj() {
        return true;
    }
}
