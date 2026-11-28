package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class wd implements vd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v6 f3172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v6 f3173b;

    static {
        r6 r6VarA = new r6(j6.a("com.google.android.gms.measurement")).b().a();
        f3172a = r6VarA.f("measurement.remove_app_background.client", false);
        f3173b = r6VarA.d("measurement.id.remove_app_background.client", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final boolean a() {
        return ((Boolean) f3172a.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final boolean zza() {
        return true;
    }
}
