package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class rc implements qc {

    /* renamed from: a, reason: collision with root package name */
    public static final v6 f3738a;

    /* renamed from: b, reason: collision with root package name */
    public static final v6 f3739b;

    /* renamed from: c, reason: collision with root package name */
    public static final v6 f3740c;

    /* renamed from: d, reason: collision with root package name */
    public static final v6 f3741d;

    static {
        r6 r6VarA = new r6(j6.a("com.google.android.gms.measurement")).b().a();
        f3738a = r6VarA.f("measurement.client.global_params", true);
        f3739b = r6VarA.f("measurement.service.global_params_in_payload", true);
        f3740c = r6VarA.f("measurement.service.clear_global_params_on_uninstall", true);
        f3741d = r6VarA.f("measurement.service.global_params", true);
    }

    @Override // com.google.android.gms.internal.measurement.qc
    public final boolean a() {
        return ((Boolean) f3740c.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.qc
    public final boolean zza() {
        return true;
    }
}
