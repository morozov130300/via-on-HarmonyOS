package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class x4 extends a9 implements ba {
    private static final x4 zza;
    private int zzd;
    private int zze = 1;
    private g9 zzf = a9.s();

    static {
        x4 x4Var = new x4();
        zza = x4Var;
        a9.y(x4.class, x4Var);
    }

    public static v4 D() {
        return (v4) zza.l();
    }

    public static /* synthetic */ void F(x4 x4Var, l4 l4Var) {
        l4Var.getClass();
        g9 g9Var = x4Var.zzf;
        if (!g9Var.b()) {
            x4Var.zzf = a9.t(g9Var);
        }
        x4Var.zzf.add(l4Var);
    }

    @Override // com.google.android.gms.internal.measurement.a9
    public final Object C(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return a9.v(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u100c\u0000\u0002\u001b", new Object[]{"zzd", "zze", w4.f3861a, "zzf", l4.class});
        }
        if (i11 == 3) {
            return new x4();
        }
        a4 a4Var = null;
        if (i11 == 4) {
            return new v4(a4Var);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }
}
