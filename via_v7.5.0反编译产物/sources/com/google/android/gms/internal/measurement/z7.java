package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class z7 extends b8 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3209c = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f3210e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzka f3211m;

    public z7(zzka zzkaVar) {
        this.f3211m = zzkaVar;
        this.f3210e = zzkaVar.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3209c < this.f3210e;
    }

    @Override // com.google.android.gms.internal.measurement.c8
    public final byte zza() {
        int i10 = this.f3209c;
        if (i10 >= this.f3210e) {
            throw new NoSuchElementException();
        }
        this.f3209c = i10 + 1;
        return this.f3211m.zzb(i10);
    }
}
