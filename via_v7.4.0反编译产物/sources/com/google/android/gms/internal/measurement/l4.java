package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class l4 extends a9 implements ba {
    private static final l4 zza;
    private int zzd;
    private String zze = "";
    private long zzf;

    static {
        l4 l4Var = new l4();
        zza = l4Var;
        a9.y(l4.class, l4Var);
    }

    public static k4 D() {
        return (k4) zza.l();
    }

    public static /* synthetic */ void F(l4 l4Var, String str) {
        str.getClass();
        l4Var.zzd |= 1;
        l4Var.zze = str;
    }

    public static /* synthetic */ void G(l4 l4Var, long j10) {
        l4Var.zzd |= 2;
        l4Var.zzf = j10;
    }

    @Override // com.google.android.gms.internal.measurement.a9
    public final Object C(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return a9.v(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u1008\u0000\u0002\u1002\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i11 == 3) {
            return new l4();
        }
        a4 a4Var = null;
        if (i11 == 4) {
            return new k4(a4Var);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }
}
