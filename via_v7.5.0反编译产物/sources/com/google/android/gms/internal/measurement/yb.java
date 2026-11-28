package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class yb implements xb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v6 f3200a = new r6(j6.a("com.google.android.gms.measurement")).a().f("measurement.client.firebase_feature_rollout.v1.enable", true);

    @Override // com.google.android.gms.internal.measurement.xb
    public final boolean a() {
        return ((Boolean) f3200a.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.xb
    public final boolean zza() {
        return true;
    }
}
