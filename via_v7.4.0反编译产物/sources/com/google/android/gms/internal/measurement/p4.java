package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class p4 extends a9 implements ba {
    private static final p4 zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private d4 zzg;

    static {
        p4 p4Var = new p4();
        zza = p4Var;
        a9.y(p4.class, p4Var);
    }

    @Override // com.google.android.gms.internal.measurement.a9
    public final Object C(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return a9.v(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u1008\u0000\u0002\u1008\u0001\u0003\u1009\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i11 == 3) {
            return new p4();
        }
        a4 a4Var = null;
        if (i11 == 4) {
            return new o4(a4Var);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }
}
