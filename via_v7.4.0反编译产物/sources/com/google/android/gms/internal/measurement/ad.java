package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class ad implements zc {

    /* renamed from: a, reason: collision with root package name */
    public static final v6 f3397a;

    /* renamed from: b, reason: collision with root package name */
    public static final v6 f3398b;

    /* renamed from: c, reason: collision with root package name */
    public static final v6 f3399c;

    /* renamed from: d, reason: collision with root package name */
    public static final v6 f3400d;

    static {
        r6 r6VarA = new r6(j6.a("com.google.android.gms.measurement")).a();
        f3397a = r6VarA.f("measurement.sdk.collection.enable_extend_user_property_size", true);
        f3398b = r6VarA.f("measurement.sdk.collection.last_deep_link_referrer2", true);
        f3399c = r6VarA.f("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        f3400d = r6VarA.d("measurement.id.sdk.collection.last_deep_link_referrer2", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zc
    public final boolean zza() {
        return ((Boolean) f3399c.b()).booleanValue();
    }
}
