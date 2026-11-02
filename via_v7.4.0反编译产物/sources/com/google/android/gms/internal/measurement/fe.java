package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class fe implements ee {

    /* renamed from: a, reason: collision with root package name */
    public static final v6 f3504a;

    /* renamed from: b, reason: collision with root package name */
    public static final v6 f3505b;

    /* renamed from: c, reason: collision with root package name */
    public static final v6 f3506c;

    /* renamed from: d, reason: collision with root package name */
    public static final v6 f3507d;

    /* renamed from: e, reason: collision with root package name */
    public static final v6 f3508e;

    /* renamed from: f, reason: collision with root package name */
    public static final v6 f3509f;

    static {
        r6 r6VarA = new r6(j6.a("com.google.android.gms.measurement")).b().a();
        f3504a = r6VarA.f("measurement.client.sessions.background_sessions_enabled", true);
        f3505b = r6VarA.f("measurement.client.sessions.enable_fix_background_engagement", false);
        f3506c = r6VarA.f("measurement.client.sessions.immediate_start_enabled_foreground", true);
        f3507d = r6VarA.f("measurement.client.sessions.remove_expired_session_properties_enabled", true);
        f3508e = r6VarA.f("measurement.client.sessions.session_id_enabled", true);
        f3509f = r6VarA.d("measurement.id.client.sessions.enable_fix_background_engagement", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.ee
    public final boolean zza() {
        return ((Boolean) f3505b.b()).booleanValue();
    }
}
