package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class vb implements ub {

    /* renamed from: a, reason: collision with root package name */
    public static final v6 f3853a;

    /* renamed from: b, reason: collision with root package name */
    public static final v6 f3854b;

    /* renamed from: c, reason: collision with root package name */
    public static final v6 f3855c;

    static {
        r6 r6VarA = new r6(j6.a("com.google.android.gms.measurement")).b().a();
        f3853a = r6VarA.f("measurement.collection.event_safelist", true);
        f3854b = r6VarA.f("measurement.service.store_null_safelist", true);
        f3855c = r6VarA.f("measurement.service.store_safelist", true);
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final boolean a() {
        return ((Boolean) f3854b.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final boolean b() {
        return ((Boolean) f3855c.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.ub
    public final boolean zza() {
        return true;
    }
}
