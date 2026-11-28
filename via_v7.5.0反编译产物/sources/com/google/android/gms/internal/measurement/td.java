package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class td implements sd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v6 f3087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v6 f3088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v6 f3089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final v6 f3090d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final v6 f3091e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final v6 f3092f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final v6 f3093g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final v6 f3094h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final v6 f3095i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final v6 f3096j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final v6 f3097k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final v6 f3098l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final v6 f3099m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final v6 f3100n;

    static {
        r6 r6VarA = new r6(j6.a("com.google.android.gms.measurement")).b().a();
        f3087a = r6VarA.f("measurement.redaction.app_instance_id", true);
        f3088b = r6VarA.f("measurement.redaction.client_ephemeral_aiid_generation", true);
        f3089c = r6VarA.f("measurement.redaction.config_redacted_fields", true);
        f3090d = r6VarA.f("measurement.redaction.device_info", true);
        f3091e = r6VarA.f("measurement.redaction.e_tag", true);
        f3092f = r6VarA.f("measurement.redaction.enhanced_uid", true);
        f3093g = r6VarA.f("measurement.redaction.populate_ephemeral_app_instance_id", true);
        f3094h = r6VarA.f("measurement.redaction.google_signals", true);
        f3095i = r6VarA.f("measurement.redaction.no_aiid_in_config_request", true);
        f3096j = r6VarA.f("measurement.redaction.retain_major_os_version", true);
        f3097k = r6VarA.f("measurement.redaction.scion_payload_generator", true);
        f3098l = r6VarA.f("measurement.redaction.upload_redacted_fields", true);
        f3099m = r6VarA.f("measurement.redaction.upload_subdomain_override", true);
        f3100n = r6VarA.f("measurement.redaction.user_id", true);
    }

    @Override // com.google.android.gms.internal.measurement.sd
    public final boolean a() {
        return ((Boolean) f3097k.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.sd
    public final boolean zza() {
        return ((Boolean) f3096j.b()).booleanValue();
    }
}
