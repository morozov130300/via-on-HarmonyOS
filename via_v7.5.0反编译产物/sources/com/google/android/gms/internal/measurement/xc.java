package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class xc implements wc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v6 f3183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v6 f3184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v6 f3185c;

    static {
        r6 r6VarA = new r6(j6.a("com.google.android.gms.measurement")).b().a();
        f3183a = r6VarA.f("measurement.item_scoped_custom_parameters.client", true);
        f3184b = r6VarA.f("measurement.item_scoped_custom_parameters.service", false);
        f3185c = r6VarA.d("measurement.id.item_scoped_custom_parameters.service", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.wc
    public final boolean a() {
        return ((Boolean) f3183a.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.wc
    public final boolean b() {
        return ((Boolean) f3184b.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.wc
    public final boolean zza() {
        return true;
    }
}
