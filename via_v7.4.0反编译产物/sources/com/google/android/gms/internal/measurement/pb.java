package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class pb implements ob {
    public static final v6 A;
    public static final v6 B;
    public static final v6 C;
    public static final v6 D;
    public static final v6 E;
    public static final v6 F;
    public static final v6 G;
    public static final v6 H;
    public static final v6 I;
    public static final v6 J;
    public static final v6 K;
    public static final v6 L;
    public static final v6 M;
    public static final v6 N;
    public static final v6 O;

    /* renamed from: a, reason: collision with root package name */
    public static final v6 f3664a;

    /* renamed from: b, reason: collision with root package name */
    public static final v6 f3665b;

    /* renamed from: c, reason: collision with root package name */
    public static final v6 f3666c;

    /* renamed from: d, reason: collision with root package name */
    public static final v6 f3667d;

    /* renamed from: e, reason: collision with root package name */
    public static final v6 f3668e;

    /* renamed from: f, reason: collision with root package name */
    public static final v6 f3669f;

    /* renamed from: g, reason: collision with root package name */
    public static final v6 f3670g;

    /* renamed from: h, reason: collision with root package name */
    public static final v6 f3671h;

    /* renamed from: i, reason: collision with root package name */
    public static final v6 f3672i;

    /* renamed from: j, reason: collision with root package name */
    public static final v6 f3673j;

    /* renamed from: k, reason: collision with root package name */
    public static final v6 f3674k;

    /* renamed from: l, reason: collision with root package name */
    public static final v6 f3675l;

    /* renamed from: m, reason: collision with root package name */
    public static final v6 f3676m;

    /* renamed from: n, reason: collision with root package name */
    public static final v6 f3677n;

    /* renamed from: o, reason: collision with root package name */
    public static final v6 f3678o;

    /* renamed from: p, reason: collision with root package name */
    public static final v6 f3679p;

    /* renamed from: q, reason: collision with root package name */
    public static final v6 f3680q;

    /* renamed from: r, reason: collision with root package name */
    public static final v6 f3681r;

    /* renamed from: s, reason: collision with root package name */
    public static final v6 f3682s;

    /* renamed from: t, reason: collision with root package name */
    public static final v6 f3683t;

    /* renamed from: u, reason: collision with root package name */
    public static final v6 f3684u;

    /* renamed from: v, reason: collision with root package name */
    public static final v6 f3685v;

    /* renamed from: w, reason: collision with root package name */
    public static final v6 f3686w;

    /* renamed from: x, reason: collision with root package name */
    public static final v6 f3687x;

    /* renamed from: y, reason: collision with root package name */
    public static final v6 f3688y;

    /* renamed from: z, reason: collision with root package name */
    public static final v6 f3689z;

    static {
        r6 r6VarA = new r6(j6.a("com.google.android.gms.measurement")).a();
        f3664a = r6VarA.d("measurement.ad_id_cache_time", 10000L);
        f3665b = r6VarA.d("measurement.app_uninstalled_additional_ad_id_cache_time", 3600000L);
        f3666c = r6VarA.d("measurement.max_bundles_per_iteration", 100L);
        f3667d = r6VarA.d("measurement.config.cache_time", 86400000L);
        f3668e = r6VarA.e("measurement.log_tag", "FA");
        f3669f = r6VarA.e("measurement.config.url_authority", "app-measurement.com");
        f3670g = r6VarA.e("measurement.config.url_scheme", "https");
        f3671h = r6VarA.d("measurement.upload.debug_upload_interval", 1000L);
        f3672i = r6VarA.d("measurement.lifetimevalue.max_currency_tracked", 4L);
        f3673j = r6VarA.d("measurement.store.max_stored_events_per_app", 100000L);
        f3674k = r6VarA.d("measurement.experiment.max_ids", 50L);
        f3675l = r6VarA.d("measurement.audience.filter_result_max_count", 200L);
        f3676m = r6VarA.d("measurement.upload.max_item_scoped_custom_parameters", 27L);
        f3677n = r6VarA.d("measurement.alarm_manager.minimum_interval", 60000L);
        f3678o = r6VarA.d("measurement.upload.minimum_delay", 500L);
        f3679p = r6VarA.d("measurement.monitoring.sample_period_millis", 86400000L);
        f3680q = r6VarA.d("measurement.upload.realtime_upload_interval", 10000L);
        f3681r = r6VarA.d("measurement.upload.refresh_blacklisted_config_interval", 604800000L);
        f3682s = r6VarA.d("measurement.config.cache_time.service", 3600000L);
        f3683t = r6VarA.d("measurement.service_client.idle_disconnect_millis", 5000L);
        f3684u = r6VarA.e("measurement.log_tag.service", "FA-SVC");
        f3685v = r6VarA.d("measurement.upload.stale_data_deletion_interval", 86400000L);
        f3686w = r6VarA.d("measurement.sdk.attribution.cache.ttl", 604800000L);
        f3687x = r6VarA.d("measurement.redaction.app_instance_id.ttl", 7200000L);
        f3688y = r6VarA.d("measurement.upload.backoff_period", 43200000L);
        f3689z = r6VarA.d("measurement.upload.initial_upload_delay_time", 15000L);
        A = r6VarA.d("measurement.upload.interval", 3600000L);
        B = r6VarA.d("measurement.upload.max_bundle_size", 65536L);
        C = r6VarA.d("measurement.upload.max_bundles", 100L);
        D = r6VarA.d("measurement.upload.max_conversions_per_day", 500L);
        E = r6VarA.d("measurement.upload.max_error_events_per_day", 1000L);
        F = r6VarA.d("measurement.upload.max_events_per_bundle", 1000L);
        G = r6VarA.d("measurement.upload.max_events_per_day", 100000L);
        H = r6VarA.d("measurement.upload.max_public_events_per_day", 50000L);
        I = r6VarA.d("measurement.upload.max_queue_time", 2419200000L);
        J = r6VarA.d("measurement.upload.max_realtime_events_per_day", 10L);
        K = r6VarA.d("measurement.upload.max_batch_size", 65536L);
        L = r6VarA.d("measurement.upload.retry_count", 6L);
        M = r6VarA.d("measurement.upload.retry_time", 1800000L);
        N = r6VarA.e("measurement.upload.url", "https://app-measurement.com/a");
        O = r6VarA.d("measurement.upload.window_interval", 3600000L);
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long A() {
        return ((Long) G.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long B() {
        return ((Long) f3689z.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long C() {
        return ((Long) f3679p.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final String D() {
        return (String) f3670g.b();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long E() {
        return ((Long) A.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long F() {
        return ((Long) H.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long G() {
        return ((Long) M.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long H() {
        return ((Long) f3687x.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long I() {
        return ((Long) O.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long J() {
        return ((Long) F.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long K() {
        return ((Long) f3688y.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long a() {
        return ((Long) f3665b.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long b() {
        return ((Long) f3666c.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long c() {
        return ((Long) f3667d.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long d() {
        return ((Long) f3671h.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long e() {
        return ((Long) f3674k.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long f() {
        return ((Long) f3675l.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long g() {
        return ((Long) f3673j.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long h() {
        return ((Long) f3678o.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long i() {
        return ((Long) f3676m.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long j() {
        return ((Long) f3677n.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long k() {
        return ((Long) f3683t.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long l() {
        return ((Long) K.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long m() {
        return ((Long) D.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long n() {
        return ((Long) f3685v.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long o() {
        return ((Long) E.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long p() {
        return ((Long) L.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long q() {
        return ((Long) f3686w.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long r() {
        return ((Long) f3680q.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final String s() {
        return (String) N.b();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long t() {
        return ((Long) B.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long u() {
        return ((Long) f3672i.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long v() {
        return ((Long) I.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long w() {
        return ((Long) f3681r.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long x() {
        return ((Long) J.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long y() {
        return ((Long) C.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final String z() {
        return (String) f3669f.b();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long zza() {
        return ((Long) f3664a.b()).longValue();
    }
}
