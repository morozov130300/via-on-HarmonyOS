package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class x3 extends a9 implements ba {
    private static final x3 zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        x3 x3Var = new x3();
        zza = x3Var;
        a9.y(x3.class, x3Var);
    }

    @Override // com.google.android.gms.internal.measurement.a9
    public final Object C(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return a9.v(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i11 == 3) {
            return new x3();
        }
        o3 o3Var = null;
        if (i11 == 4) {
            return new w3(o3Var);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }
}
