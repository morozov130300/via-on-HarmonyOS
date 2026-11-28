package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class fc implements dc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v6 f2799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v6 f2800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v6 f2801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final v6 f2802d;

    static {
        r6 r6VarA = new r6(j6.a("com.google.android.gms.measurement")).a();
        f2799a = r6VarA.f("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        f2800b = r6VarA.f("measurement.audience.refresh_event_count_filters_timestamp", false);
        f2801c = r6VarA.f("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        f2802d = r6VarA.f("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final boolean a() {
        return ((Boolean) f2800b.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final boolean b() {
        return ((Boolean) f2801c.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final boolean c() {
        return ((Boolean) f2802d.b()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final boolean zza() {
        return true;
    }
}
