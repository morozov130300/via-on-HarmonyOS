package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class je implements ie {

    /* renamed from: a, reason: collision with root package name */
    public static final v6 f3583a;

    /* renamed from: b, reason: collision with root package name */
    public static final v6 f3584b;

    static {
        r6 r6VarA = new r6(j6.a("com.google.android.gms.measurement")).b().a();
        f3583a = r6VarA.f("measurement.sfmc.client", true);
        f3584b = r6VarA.f("measurement.sfmc.service", true);
    }

    @Override // com.google.android.gms.internal.measurement.ie
    public final boolean a() {
        return ((Boolean) f3583a.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.ie
    public final boolean b() {
        return ((Boolean) f3584b.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.ie
    public final boolean zza() {
        return true;
    }
}
