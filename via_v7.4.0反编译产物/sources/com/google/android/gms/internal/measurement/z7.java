package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class z7 extends b8 {

    /* renamed from: e, reason: collision with root package name */
    public int f3910e = 0;

    /* renamed from: j, reason: collision with root package name */
    public final int f3911j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ zzka f3912k;

    public z7(zzka zzkaVar) {
        this.f3912k = zzkaVar;
        this.f3911j = zzkaVar.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3910e < this.f3911j;
    }

    @Override // com.google.android.gms.internal.measurement.c8
    public final byte zza() {
        int i10 = this.f3910e;
        if (i10 >= this.f3911j) {
            throw new NoSuchElementException();
        }
        this.f3910e = i10 + 1;
        return this.f3912k.zzb(i10);
    }
}
