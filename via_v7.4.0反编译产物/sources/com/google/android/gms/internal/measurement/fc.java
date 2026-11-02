package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class fc implements dc {

    /* renamed from: a, reason: collision with root package name */
    public static final v6 f3500a;

    /* renamed from: b, reason: collision with root package name */
    public static final v6 f3501b;

    /* renamed from: c, reason: collision with root package name */
    public static final v6 f3502c;

    /* renamed from: d, reason: collision with root package name */
    public static final v6 f3503d;

    static {
        r6 r6VarA = new r6(j6.a("com.google.android.gms.measurement")).a();
        f3500a = r6VarA.f("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        f3501b = r6VarA.f("measurement.audience.refresh_event_count_filters_timestamp", false);
        f3502c = r6VarA.f("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        f3503d = r6VarA.f("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final boolean a() {
        return ((Boolean) f3501b.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final boolean b() {
        return ((Boolean) f3502c.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final boolean c() {
        return ((Boolean) f3503d.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final boolean zza() {
        return true;
    }
}
