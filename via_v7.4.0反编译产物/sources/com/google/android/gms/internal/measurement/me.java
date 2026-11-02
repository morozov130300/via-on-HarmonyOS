package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class me implements le {

    /* renamed from: a, reason: collision with root package name */
    public static final v6 f3626a;

    /* renamed from: b, reason: collision with root package name */
    public static final v6 f3627b;

    static {
        r6 r6VarA = new r6(j6.a("com.google.android.gms.measurement")).b().a();
        f3626a = r6VarA.f("measurement.sgtm.client.dev", false);
        f3627b = r6VarA.f("measurement.sgtm.service", false);
    }

    @Override // com.google.android.gms.internal.measurement.le
    public final boolean a() {
        return ((Boolean) f3626a.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.le
    public final boolean b() {
        return ((Boolean) f3627b.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.le
    public final boolean zza() {
        return true;
    }
}
