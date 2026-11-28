package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class s4 extends a9 implements ba {
    private static final s4 zza;
    private g9 zzd = a9.s();

    static {
        s4 s4Var = new s4();
        zza = s4Var;
        a9.y(s4.class, s4Var);
    }

    public static r4 D() {
        return (r4) zza.l();
    }

    public static /* synthetic */ void H(s4 s4Var, u4 u4Var) {
        u4Var.getClass();
        g9 g9Var = s4Var.zzd;
        if (!g9Var.b()) {
            s4Var.zzd = a9.t(g9Var);
        }
        s4Var.zzd.add(u4Var);
    }

    @Override // com.google.android.gms.internal.measurement.a9
    public final Object C(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return a9.v(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", u4.class});
        }
        if (i11 == 3) {
            return new s4();
        }
        a4 a4Var = null;
        if (i11 == 4) {
            return new r4(a4Var);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }

    public final u4 F(int i10) {
        return (u4) this.zzd.get(0);
    }

    public final List G() {
        return this.zzd;
    }
}
