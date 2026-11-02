package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class td implements sd {

    /* renamed from: a, reason: collision with root package name */
    public static final v6 f3788a;

    /* renamed from: b, reason: collision with root package name */
    public static final v6 f3789b;

    /* renamed from: c, reason: collision with root package name */
    public static final v6 f3790c;

    /* renamed from: d, reason: collision with root package name */
    public static final v6 f3791d;

    /* renamed from: e, reason: collision with root package name */
    public static final v6 f3792e;

    /* renamed from: f, reason: collision with root package name */
    public static final v6 f3793f;

    /* renamed from: g, reason: collision with root package name */
    public static final v6 f3794g;

    /* renamed from: h, reason: collision with root package name */
    public static final v6 f3795h;

    /* renamed from: i, reason: collision with root package name */
    public static final v6 f3796i;

    /* renamed from: j, reason: collision with root package name */
    public static final v6 f3797j;

    /* renamed from: k, reason: collision with root package name */
    public static final v6 f3798k;

    /* renamed from: l, reason: collision with root package name */
    public static final v6 f3799l;

    /* renamed from: m, reason: collision with root package name */
    public static final v6 f3800m;

    /* renamed from: n, reason: collision with root package name */
    public static final v6 f3801n;

    static {
        r6 r6VarA = new r6(j6.a("com.google.android.gms.measurement")).b().a();
        f3788a = r6VarA.f("measurement.redaction.app_instance_id", true);
        f3789b = r6VarA.f("measurement.redaction.client_ephemeral_aiid_generation", true);
        f3790c = r6VarA.f("measurement.redaction.config_redacted_fields", true);
        f3791d = r6VarA.f("measurement.redaction.device_info", true);
        f3792e = r6VarA.f("measurement.redaction.e_tag", true);
        f3793f = r6VarA.f("measurement.redaction.enhanced_uid", true);
        f3794g = r6VarA.f("measurement.redaction.populate_ephemeral_app_instance_id", true);
        f3795h = r6VarA.f("measurement.redaction.google_signals", true);
        f3796i = r6VarA.f("measurement.redaction.no_aiid_in_config_request", true);
        f3797j = r6VarA.f("measurement.redaction.retain_major_os_version", true);
        f3798k = r6VarA.f("measurement.redaction.scion_payload_generator", true);
        f3799l = r6VarA.f("measurement.redaction.upload_redacted_fields", true);
        f3800m = r6VarA.f("measurement.redaction.upload_subdomain_override", true);
        f3801n = r6VarA.f("measurement.redaction.user_id", true);
    }

    @Override // com.google.android.gms.internal.measurement.sd
    public final boolean a() {
        return ((Boolean) f3798k.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.sd
    public final boolean zza() {
        return ((Boolean) f3797j.b()).booleanValue();
    }
}
