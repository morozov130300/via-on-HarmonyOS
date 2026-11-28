package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class dd implements cd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v6 f2763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v6 f2764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v6 f2765c;

    static {
        r6 r6VarA = new r6(j6.a("com.google.android.gms.measurement")).a();
        f2763a = r6VarA.d("measurement.id.lifecycle.app_in_background_parameter", 0L);
        f2764b = r6VarA.f("measurement.lifecycle.app_backgrounded_tracking", true);
        f2765c = r6VarA.f("measurement.lifecycle.app_in_background_parameter", false);
    }

    @Override // com.google.android.gms.internal.measurement.cd
    public final boolean zza() {
        return ((Boolean) f2765c.b()).booleanValue();
    }
}
