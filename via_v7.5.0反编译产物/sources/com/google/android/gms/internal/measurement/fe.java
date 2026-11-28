package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class fe implements ee {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v6 f2803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v6 f2804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v6 f2805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final v6 f2806d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final v6 f2807e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final v6 f2808f;

    static {
        r6 r6VarA = new r6(j6.a("com.google.android.gms.measurement")).b().a();
        f2803a = r6VarA.f("measurement.client.sessions.background_sessions_enabled", true);
        f2804b = r6VarA.f("measurement.client.sessions.enable_fix_background_engagement", false);
        f2805c = r6VarA.f("measurement.client.sessions.immediate_start_enabled_foreground", true);
        f2806d = r6VarA.f("measurement.client.sessions.remove_expired_session_properties_enabled", true);
        f2807e = r6VarA.f("measurement.client.sessions.session_id_enabled", true);
        f2808f = r6VarA.d("measurement.id.client.sessions.enable_fix_background_engagement", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.ee
    public final boolean zza() {
        return ((Boolean) f2804b.b()).booleanValue();
    }
}
