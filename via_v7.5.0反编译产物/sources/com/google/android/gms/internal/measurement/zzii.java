package com.google.android.gms.internal.measurement;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzii implements Serializable {
    public static zzii zzc() {
        return zzie.zza;
    }

    public static zzii zzd(Object obj) {
        return new zzik(obj);
    }

    public abstract Object zza();

    public abstract boolean zzb();
}
