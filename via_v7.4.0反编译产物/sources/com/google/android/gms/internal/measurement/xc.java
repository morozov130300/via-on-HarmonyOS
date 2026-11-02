package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class xc implements wc {

    /* renamed from: a, reason: collision with root package name */
    public static final v6 f3884a;

    /* renamed from: b, reason: collision with root package name */
    public static final v6 f3885b;

    /* renamed from: c, reason: collision with root package name */
    public static final v6 f3886c;

    static {
        r6 r6VarA = new r6(j6.a("com.google.android.gms.measurement")).b().a();
        f3884a = r6VarA.f("measurement.item_scoped_custom_parameters.client", true);
        f3885b = r6VarA.f("measurement.item_scoped_custom_parameters.service", false);
        f3886c = r6VarA.d("measurement.id.item_scoped_custom_parameters.service", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.wc
    public final boolean a() {
        return ((Boolean) f3884a.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.wc
    public final boolean b() {
        return ((Boolean) f3885b.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.wc
    public final boolean zza() {
        return true;
    }
}
