package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class me implements le {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v6 f2925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v6 f2926b;

    static {
        r6 r6VarA = new r6(j6.a("com.google.android.gms.measurement")).b().a();
        f2925a = r6VarA.f("measurement.sgtm.client.dev", false);
        f2926b = r6VarA.f("measurement.sgtm.service", false);
    }

    @Override // com.google.android.gms.internal.measurement.le
    public final boolean a() {
        return ((Boolean) f2925a.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.le
    public final boolean b() {
        return ((Boolean) f2926b.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.le
    public final boolean zza() {
        return true;
    }
}
