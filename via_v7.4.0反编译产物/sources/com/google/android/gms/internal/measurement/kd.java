package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class kd implements jd {

    /* renamed from: a, reason: collision with root package name */
    public static final v6 f3598a;

    /* renamed from: b, reason: collision with root package name */
    public static final v6 f3599b;

    /* renamed from: c, reason: collision with root package name */
    public static final v6 f3600c;

    /* renamed from: d, reason: collision with root package name */
    public static final v6 f3601d;

    /* renamed from: e, reason: collision with root package name */
    public static final v6 f3602e;

    static {
        r6 r6VarA = new r6(j6.a("com.google.android.gms.measurement")).a();
        f3598a = r6VarA.f("measurement.test.boolean_flag", false);
        f3599b = r6VarA.c("measurement.test.double_flag", -3.0d);
        f3600c = r6VarA.d("measurement.test.int_flag", -2L);
        f3601d = r6VarA.d("measurement.test.long_flag", -1L);
        f3602e = r6VarA.e("measurement.test.string_flag", "---");
    }

    @Override // com.google.android.gms.internal.measurement.jd
    public final long a() {
        return ((Long) f3600c.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.jd
    public final long b() {
        return ((Long) f3601d.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.jd
    public final String c() {
        return (String) f3602e.b();
    }

    @Override // com.google.android.gms.internal.measurement.jd
    public final boolean d() {
        return ((Boolean) f3598a.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.jd
    public final double zza() {
        return ((Double) f3599b.b()).doubleValue();
    }
}
