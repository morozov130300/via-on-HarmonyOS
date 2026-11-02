package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class ce implements be {

    /* renamed from: a, reason: collision with root package name */
    public static final v6 f3429a;

    /* renamed from: b, reason: collision with root package name */
    public static final v6 f3430b;

    /* renamed from: c, reason: collision with root package name */
    public static final v6 f3431c;

    /* renamed from: d, reason: collision with root package name */
    public static final v6 f3432d;

    static {
        r6 r6VarA = new r6(j6.a("com.google.android.gms.measurement")).b().a();
        f3429a = r6VarA.f("measurement.collection.enable_session_stitching_token.client.dev", true);
        f3430b = r6VarA.f("measurement.collection.enable_session_stitching_token.first_open_fix", true);
        f3431c = r6VarA.f("measurement.session_stitching_token_enabled", false);
        f3432d = r6VarA.f("measurement.link_sst_to_sid", true);
    }

    @Override // com.google.android.gms.internal.measurement.be
    public final boolean a() {
        return ((Boolean) f3429a.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.be
    public final boolean b() {
        return ((Boolean) f3430b.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.be
    public final boolean c() {
        return ((Boolean) f3431c.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.be
    public final boolean d() {
        return ((Boolean) f3432d.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.be
    public final boolean zza() {
        return true;
    }
}
