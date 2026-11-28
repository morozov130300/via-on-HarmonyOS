package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class sb implements rb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v6 f3065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v6 f3066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v6 f3067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final v6 f3068d;

    static {
        r6 r6VarA = new r6(j6.a("com.google.android.gms.measurement")).a();
        f3065a = r6VarA.f("measurement.client.consent_state_v1", true);
        f3066b = r6VarA.f("measurement.client.3p_consent_state_v1", true);
        f3067c = r6VarA.f("measurement.service.consent_state_v1_W36", true);
        f3068d = r6VarA.d("measurement.service.storage_consent_support_version", 203600L);
    }

    @Override // com.google.android.gms.internal.measurement.rb
    public final long zza() {
        return ((Long) f3068d.b()).longValue();
    }
}
