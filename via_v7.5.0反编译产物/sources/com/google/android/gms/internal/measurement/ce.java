package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class ce implements be {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v6 f2728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v6 f2729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v6 f2730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final v6 f2731d;

    static {
        r6 r6VarA = new r6(j6.a("com.google.android.gms.measurement")).b().a();
        f2728a = r6VarA.f("measurement.collection.enable_session_stitching_token.client.dev", true);
        f2729b = r6VarA.f("measurement.collection.enable_session_stitching_token.first_open_fix", true);
        f2730c = r6VarA.f("measurement.session_stitching_token_enabled", false);
        f2731d = r6VarA.f("measurement.link_sst_to_sid", true);
    }

    @Override // com.google.android.gms.internal.measurement.be
    public final boolean a() {
        return ((Boolean) f2728a.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.be
    public final boolean b() {
        return ((Boolean) f2729b.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.be
    public final boolean c() {
        return ((Boolean) f2730c.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.be
    public final boolean d() {
        return ((Boolean) f2731d.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.be
    public final boolean zza() {
        return true;
    }
}
