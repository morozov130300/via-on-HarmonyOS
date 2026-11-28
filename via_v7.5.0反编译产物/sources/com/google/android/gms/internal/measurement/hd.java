package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class hd implements gd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v6 f2842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v6 f2843b;

    static {
        r6 r6VarA = new r6(j6.a("com.google.android.gms.measurement")).b().a();
        f2842a = r6VarA.f("measurement.collection.client.log_target_api_version", true);
        f2843b = r6VarA.f("measurement.collection.service.log_target_api_version", true);
    }

    @Override // com.google.android.gms.internal.measurement.gd
    public final boolean a() {
        return ((Boolean) f2842a.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.gd
    public final boolean b() {
        return ((Boolean) f2843b.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.gd
    public final boolean zza() {
        return true;
    }
}
