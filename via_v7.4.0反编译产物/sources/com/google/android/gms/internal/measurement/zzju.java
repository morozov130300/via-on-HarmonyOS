package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
final class zzju extends zzjx {
    private final int zzc;

    public zzju(byte[] bArr, int i10, int i11) {
        super(bArr);
        zzka.zzj(0, i11, bArr.length);
        this.zzc = i11;
    }

    @Override // com.google.android.gms.internal.measurement.zzjx, com.google.android.gms.internal.measurement.zzka
    public final byte zza(int i10) {
        int i11 = this.zzc;
        if (((i11 - (i10 + 1)) | i10) >= 0) {
            return this.zza[i10];
        }
        if (i10 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i10);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i10 + ", " + i11);
    }

    @Override // com.google.android.gms.internal.measurement.zzjx, com.google.android.gms.internal.measurement.zzka
    public final byte zzb(int i10) {
        return this.zza[i10];
    }

    @Override // com.google.android.gms.internal.measurement.zzjx
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzjx, com.google.android.gms.internal.measurement.zzka
    public final int zzd() {
        return this.zzc;
    }
}
