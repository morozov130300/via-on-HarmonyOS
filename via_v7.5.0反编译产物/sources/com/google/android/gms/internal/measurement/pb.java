package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v6 f2963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v6 f2964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v6 f2965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final v6 f2966d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final v6 f2967e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final v6 f2968f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final v6 f2969g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final v6 f2970h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final v6 f2971i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final v6 f2972j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final v6 f2973k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final v6 f2974l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final v6 f2975m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final v6 f2976n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final v6 f2977o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final v6 f2978p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final v6 f2979q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final v6 f2980r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final v6 f2981s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final v6 f2982t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final v6 f2983u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final v6 f2984v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final v6 f2985w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final v6 f2986x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final v6 f2987y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final v6 f2988z;

    static {
        r6 r6VarA = new r6(j6.a("com.google.android.gms.measurement")).a();
        f2963a = r6VarA.d("measurement.ad_id_cache_time", 10000L);
        f2964b = r6VarA.d("measurement.app_uninstalled_additional_ad_id_cache_time", 3600000L);
        f2965c = r6VarA.d("measurement.max_bundles_per_iteration", 100L);
        f2966d = r6VarA.d("measurement.config.cache_time", 86400000L);
        f2967e = r6VarA.e("measurement.log_tag", "FA");
        f2968f = r6VarA.e("measurement.config.url_authority", "app-measurement.com");
        f2969g = r6VarA.e("measurement.config.url_scheme", "https");
        f2970h = r6VarA.d("measurement.upload.debug_upload_interval", 1000L);
        f2971i = r6VarA.d("measurement.lifetimevalue.max_currency_tracked", 4L);
        f2972j = r6VarA.d("measurement.store.max_stored_events_per_app", 100000L);
        f2973k = r6VarA.d("measurement.experiment.max_ids", 50L);
        f2974l = r6VarA.d("measurement.audience.filter_result_max_count", 200L);
        f2975m = r6VarA.d("measurement.upload.max_item_scoped_custom_parameters", 27L);
        f2976n = r6VarA.d("measurement.alarm_manager.minimum_interval", 60000L);
        f2977o = r6VarA.d("measurement.upload.minimum_delay", 500L);
        f2978p = r6VarA.d("measurement.monitoring.sample_period_millis", 86400000L);
        f2979q = r6VarA.d("measurement.upload.realtime_upload_interval", 10000L);
        f2980r = r6VarA.d("measurement.upload.refresh_blacklisted_config_interval", 604800000L);
        f2981s = r6VarA.d("measurement.config.cache_time.service", 3600000L);
        f2982t = r6VarA.d("measurement.service_client.idle_disconnect_millis", 5000L);
        f2983u = r6VarA.e("measurement.log_tag.service", "FA-SVC");
        f2984v = r6VarA.d("measurement.upload.stale_data_deletion_interval", 86400000L);
        f2985w = r6VarA.d("measurement.sdk.attribution.cache.ttl", 604800000L);
        f2986x = r6VarA.d("measurement.redaction.app_instance_id.ttl", 7200000L);
        f2987y = r6VarA.d("measurement.upload.backoff_period", 43200000L);
        f2988z = r6VarA.d("measurement.upload.initial_upload_delay_time", 15000L);
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
        return ((Long) f2988z.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long C() {
        return ((Long) f2978p.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final String D() {
        return (String) f2969g.b();
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
        return ((Long) f2986x.b()).longValue();
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
        return ((Long) f2987y.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long a() {
        return ((Long) f2964b.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long b() {
        return ((Long) f2965c.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long c() {
        return ((Long) f2966d.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long d() {
        return ((Long) f2970h.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long e() {
        return ((Long) f2973k.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long f() {
        return ((Long) f2974l.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long g() {
        return ((Long) f2972j.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long h() {
        return ((Long) f2977o.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long i() {
        return ((Long) f2975m.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long j() {
        return ((Long) f2976n.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long k() {
        return ((Long) f2982t.b()).longValue();
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
        return ((Long) f2984v.b()).longValue();
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
        return ((Long) f2985w.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long r() {
        return ((Long) f2979q.b()).longValue();
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
        return ((Long) f2971i.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long v() {
        return ((Long) I.b()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long w() {
        return ((Long) f2980r.b()).longValue();
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
        return (String) f2968f.b();
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final long zza() {
        return ((Long) f2963a.b()).longValue();
    }
}
