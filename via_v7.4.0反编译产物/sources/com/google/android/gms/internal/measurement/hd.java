package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class hd implements gd {

    /* renamed from: a, reason: collision with root package name */
    public static final v6 f3543a;

    /* renamed from: b, reason: collision with root package name */
    public static final v6 f3544b;

    static {
        r6 r6VarA = new r6(j6.a("com.google.android.gms.measurement")).b().a();
        f3543a = r6VarA.f("measurement.collection.client.log_target_api_version", true);
        f3544b = r6VarA.f("measurement.collection.service.log_target_api_version", true);
    }

    @Override // com.google.android.gms.internal.measurement.gd
    public final boolean a() {
        return ((Boolean) f3543a.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.gd
    public final boolean b() {
        return ((Boolean) f3544b.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.gd
    public final boolean zza() {
        return true;
    }
}
