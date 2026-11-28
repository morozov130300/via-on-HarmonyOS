package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class rc implements qc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v6 f3037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v6 f3038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v6 f3039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final v6 f3040d;

    static {
        r6 r6VarA = new r6(j6.a("com.google.android.gms.measurement")).b().a();
        f3037a = r6VarA.f("measurement.client.global_params", true);
        f3038b = r6VarA.f("measurement.service.global_params_in_payload", true);
        f3039c = r6VarA.f("measurement.service.clear_global_params_on_uninstall", true);
        f3040d = r6VarA.f("measurement.service.global_params", true);
    }

    @Override // com.google.android.gms.internal.measurement.qc
    public final boolean a() {
        return ((Boolean) f3039c.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.qc
    public final boolean zza() {
        return true;
    }
}
