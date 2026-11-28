package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class ad implements zc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v6 f2696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v6 f2697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v6 f2698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final v6 f2699d;

    static {
        r6 r6VarA = new r6(j6.a("com.google.android.gms.measurement")).a();
        f2696a = r6VarA.f("measurement.sdk.collection.enable_extend_user_property_size", true);
        f2697b = r6VarA.f("measurement.sdk.collection.last_deep_link_referrer2", true);
        f2698c = r6VarA.f("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        f2699d = r6VarA.d("measurement.id.sdk.collection.last_deep_link_referrer2", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zc
    public final boolean zza() {
        return ((Boolean) f2698c.b()).booleanValue();
    }
}
