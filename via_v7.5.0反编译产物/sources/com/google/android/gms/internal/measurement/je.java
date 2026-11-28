package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class je implements ie {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v6 f2882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v6 f2883b;

    static {
        r6 r6VarA = new r6(j6.a("com.google.android.gms.measurement")).b().a();
        f2882a = r6VarA.f("measurement.sfmc.client", true);
        f2883b = r6VarA.f("measurement.sfmc.service", true);
    }

    @Override // com.google.android.gms.internal.measurement.ie
    public final boolean a() {
        return ((Boolean) f2882a.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.ie
    public final boolean b() {
        return ((Boolean) f2883b.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.ie
    public final boolean zza() {
        return true;
    }
}
