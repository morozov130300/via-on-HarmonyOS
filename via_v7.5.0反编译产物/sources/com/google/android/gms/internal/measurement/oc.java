package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class oc implements nc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v6 f2948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v6 f2949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v6 f2950c;

    static {
        r6 r6VarA = new r6(j6.a("com.google.android.gms.measurement")).a();
        f2948a = r6VarA.f("measurement.client.sessions.check_on_reset_and_enable2", true);
        f2949b = r6VarA.f("measurement.client.sessions.check_on_startup", true);
        f2950c = r6VarA.f("measurement.client.sessions.start_session_before_view_screen", true);
    }

    @Override // com.google.android.gms.internal.measurement.nc
    public final boolean a() {
        return ((Boolean) f2948a.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.nc
    public final boolean zza() {
        return true;
    }
}
