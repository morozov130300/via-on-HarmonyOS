package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class vb implements ub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v6 f3152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v6 f3153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v6 f3154c;

    static {
        r6 r6VarA = new r6(j6.a("com.google.android.gms.measurement")).b().a();
        f3152a = r6VarA.f("measurement.collection.event_safelist", true);
        f3153b = r6VarA.f("measurement.service.store_null_safelist", true);
        f3154c = r6VarA.f("measurement.service.store_safelist", true);
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final boolean a() {
        return ((Boolean) f3153b.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final boolean b() {
        return ((Boolean) f3154c.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final boolean zza() {
        return true;
    }
}
