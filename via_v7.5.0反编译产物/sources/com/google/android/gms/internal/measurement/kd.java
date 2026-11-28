package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class kd implements jd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v6 f2897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v6 f2898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v6 f2899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final v6 f2900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final v6 f2901e;

    static {
        r6 r6VarA = new r6(j6.a("com.google.android.gms.measurement")).a();
        f2897a = r6VarA.f("measurement.test.boolean_flag", false);
        f2898b = r6VarA.c("measurement.test.double_flag", -3.0d);
        f2899c = r6VarA.d("measurement.test.int_flag", -2L);
        f2900d = r6VarA.d("measurement.test.long_flag", -1L);
        f2901e = r6VarA.e("measurement.test.string_flag", "---");
    }

    @Override // com.google.android.gms.internal.measurement.jd
    public final long a() {
        return ((Long) f2899c.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.jd
    public final long b() {
        return ((Long) f2900d.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.jd
    public final String c() {
        return (String) f2901e.b();
    }

    @Override // com.google.android.gms.internal.measurement.jd
    public final boolean d() {
        return ((Boolean) f2897a.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.jd
    public final double zza() {
        return ((Double) f2898b.b()).doubleValue();
    }
}
