package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class wd implements vd {

    /* renamed from: a, reason: collision with root package name */
    public static final v6 f3873a;

    /* renamed from: b, reason: collision with root package name */
    public static final v6 f3874b;

    static {
        r6 r6VarA = new r6(j6.a("com.google.android.gms.measurement")).b().a();
        f3873a = r6VarA.f("measurement.remove_app_background.client", false);
        f3874b = r6VarA.d("measurement.id.remove_app_background.client", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final boolean a() {
        return ((Boolean) f3873a.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.vd
    public final boolean zza() {
        return true;
    }
}
