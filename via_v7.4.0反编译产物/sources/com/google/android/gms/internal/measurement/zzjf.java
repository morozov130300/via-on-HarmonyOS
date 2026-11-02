package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
final class zzjf extends zzjb {

    /* renamed from: n, reason: collision with root package name */
    public static final Object[] f3935n;
    static final zzjf zza;

    /* renamed from: k, reason: collision with root package name */
    public final transient int f3936k;

    /* renamed from: l, reason: collision with root package name */
    public final transient int f3937l;

    /* renamed from: m, reason: collision with root package name */
    public final transient int f3938m;
    final transient Object[] zzb;
    final transient Object[] zzc;

    static {
        Object[] objArr = new Object[0];
        f3935n = objArr;
        zza = new zzjf(objArr, 0, objArr, 0, 0);
    }

    public zzjf(Object[] objArr, int i10, Object[] objArr2, int i11, int i12) {
        this.zzb = objArr;
        this.f3936k = i10;
        this.zzc = objArr2;
        this.f3937l = i11;
        this.f3938m = i12;
    }

    @Override // com.google.android.gms.internal.measurement.zziw, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        Object[] objArr = this.zzc;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int iA = i7.a(obj.hashCode());
        while (true) {
            int i10 = iA & this.f3937l;
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
        return this.f3936k;
    }

    @Override // com.google.android.gms.internal.measurement.zzjb, com.google.android.gms.internal.measurement.zziw, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zzg().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f3938m;
    }

    @Override // com.google.android.gms.internal.measurement.zziw
    public final int zza(Object[] objArr, int i10) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.f3938m);
        return this.f3938m;
    }

    @Override // com.google.android.gms.internal.measurement.zziw
    public final int zzb() {
        return this.f3938m;
    }

    @Override // com.google.android.gms.internal.measurement.zziw
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzjb, com.google.android.gms.internal.measurement.zziw
    /* renamed from: zzd */
    public final q7 iterator() {
        return zzg().listIterator(0);
    }

    @Override // com.google.android.gms.internal.measurement.zziw
    public final Object[] zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzjb
    public final zzja zzh() {
        return zzja.zzg(this.zzb, this.f3938m);
    }

    @Override // com.google.android.gms.internal.measurement.zzjb
    public final boolean zzj() {
        return true;
    }
}
