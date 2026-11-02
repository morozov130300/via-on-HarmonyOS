package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class zzjx extends zzjw {
    protected final byte[] zza;

    public zzjx(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzka
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzka) || zzd() != ((zzka) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzjx)) {
            return obj.equals(this);
        }
        zzjx zzjxVar = (zzjx) obj;
        int iZzk = zzk();
        int iZzk2 = zzjxVar.zzk();
        if (iZzk != 0 && iZzk2 != 0 && iZzk != iZzk2) {
            return false;
        }
        int iZzd = zzd();
        if (iZzd > zzjxVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + iZzd + zzd());
        }
        if (iZzd > zzjxVar.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + iZzd + ", " + zzjxVar.zzd());
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzjxVar.zza;
        zzjxVar.zzc();
        int i10 = 0;
        int i11 = 0;
        while (i10 < iZzd) {
            if (bArr[i10] != bArr2[i11]) {
                return false;
            }
            i10++;
            i11++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzka
    public byte zza(int i10) {
        return this.zza[i10];
    }

    @Override // com.google.android.gms.internal.measurement.zzka
    public byte zzb(int i10) {
        return this.zza[i10];
    }

    public int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzka
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.measurement.zzka
    public final int zze(int i10, int i11, int i12) {
        return h9.b(i10, this.zza, 0, i12);
    }

    @Override // com.google.android.gms.internal.measurement.zzka
    public final zzka zzf(int i10, int i11) {
        int iZzj = zzka.zzj(0, i11, zzd());
        return iZzj == 0 ? zzka.zzb : new zzju(this.zza, 0, iZzj);
    }

    @Override // com.google.android.gms.internal.measurement.zzka
    public final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    @Override // com.google.android.gms.internal.measurement.zzka
    public final void zzh(y7 y7Var) {
        ((k8) y7Var).B(this.zza, 0, zzd());
    }

    @Override // com.google.android.gms.internal.measurement.zzka
    public final boolean zzi() {
        return eb.e(this.zza, 0, zzd());
    }
}
