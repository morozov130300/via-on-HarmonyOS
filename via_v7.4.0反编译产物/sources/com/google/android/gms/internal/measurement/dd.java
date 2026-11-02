package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class dd implements cd {

    /* renamed from: a, reason: collision with root package name */
    public static final v6 f3464a;

    /* renamed from: b, reason: collision with root package name */
    public static final v6 f3465b;

    /* renamed from: c, reason: collision with root package name */
    public static final v6 f3466c;

    static {
        r6 r6VarA = new r6(j6.a("com.google.android.gms.measurement")).a();
        f3464a = r6VarA.d("measurement.id.lifecycle.app_in_background_parameter", 0L);
        f3465b = r6VarA.f("measurement.lifecycle.app_backgrounded_tracking", true);
        f3466c = r6VarA.f("measurement.lifecycle.app_in_background_parameter", false);
    }

    @Override // com.google.android.gms.internal.measurement.cd
    public final boolean zza() {
        return ((Boolean) f3466c.b()).booleanValue();
    }
}
