package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class sb implements rb {

    /* renamed from: a, reason: collision with root package name */
    public static final v6 f3766a;

    /* renamed from: b, reason: collision with root package name */
    public static final v6 f3767b;

    /* renamed from: c, reason: collision with root package name */
    public static final v6 f3768c;

    /* renamed from: d, reason: collision with root package name */
    public static final v6 f3769d;

    static {
        r6 r6VarA = new r6(j6.a("com.google.android.gms.measurement")).a();
        f3766a = r6VarA.f("measurement.client.consent_state_v1", true);
        f3767b = r6VarA.f("measurement.client.3p_consent_state_v1", true);
        f3768c = r6VarA.f("measurement.service.consent_state_v1_W36", true);
        f3769d = r6VarA.d("measurement.service.storage_consent_support_version", 203600L);
    }

    @Override // com.google.android.gms.internal.measurement.rb
    public final long zza() {
        return ((Long) f3769d.b()).longValue();
    }
}
