package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class oc implements nc {

    /* renamed from: a, reason: collision with root package name */
    public static final v6 f3649a;

    /* renamed from: b, reason: collision with root package name */
    public static final v6 f3650b;

    /* renamed from: c, reason: collision with root package name */
    public static final v6 f3651c;

    static {
        r6 r6VarA = new r6(j6.a("com.google.android.gms.measurement")).a();
        f3649a = r6VarA.f("measurement.client.sessions.check_on_reset_and_enable2", true);
        f3650b = r6VarA.f("measurement.client.sessions.check_on_startup", true);
        f3651c = r6VarA.f("measurement.client.sessions.start_session_before_view_screen", true);
    }

    @Override // com.google.android.gms.internal.measurement.nc
    public final boolean a() {
        return ((Boolean) f3649a.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.nc
    public final boolean zza() {
        return true;
    }
}
