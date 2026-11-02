package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class r3 extends a9 implements ba {
    private static final r3 zza;
    private int zzd;
    private String zze = "";
    private g9 zzf = a9.s();
    private boolean zzg;

    static {
        r3 r3Var = new r3();
        zza = r3Var;
        a9.y(r3.class, r3Var);
    }

    @Override // com.google.android.gms.internal.measurement.a9
    public final Object C(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return a9.v(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u1008\u0000\u0002\u001b\u0003\u1007\u0001", new Object[]{"zzd", "zze", "zzf", x3.class, "zzg"});
        }
        if (i11 == 3) {
            return new r3();
        }
        o3 o3Var = null;
        if (i11 == 4) {
            return new q3(o3Var);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }

    public final String E() {
        return this.zze;
    }
}
