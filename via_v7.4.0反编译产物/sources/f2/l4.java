package f2;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zb;
import com.google.android.gms.measurement.internal.zzha;
import p1.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class l4 extends b6 {

    /* renamed from: y, reason: collision with root package name */
    public static final Pair f5428y = new Pair("", 0L);

    /* renamed from: c, reason: collision with root package name */
    public SharedPreferences f5429c;

    /* renamed from: d, reason: collision with root package name */
    public j4 f5430d;

    /* renamed from: e, reason: collision with root package name */
    public final h4 f5431e;

    /* renamed from: f, reason: collision with root package name */
    public final h4 f5432f;

    /* renamed from: g, reason: collision with root package name */
    public final k4 f5433g;

    /* renamed from: h, reason: collision with root package name */
    public String f5434h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f5435i;

    /* renamed from: j, reason: collision with root package name */
    public long f5436j;

    /* renamed from: k, reason: collision with root package name */
    public final h4 f5437k;

    /* renamed from: l, reason: collision with root package name */
    public final f4 f5438l;

    /* renamed from: m, reason: collision with root package name */
    public final k4 f5439m;

    /* renamed from: n, reason: collision with root package name */
    public final f4 f5440n;

    /* renamed from: o, reason: collision with root package name */
    public final h4 f5441o;

    /* renamed from: p, reason: collision with root package name */
    public final h4 f5442p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f5443q;

    /* renamed from: r, reason: collision with root package name */
    public final f4 f5444r;

    /* renamed from: s, reason: collision with root package name */
    public final f4 f5445s;

    /* renamed from: t, reason: collision with root package name */
    public final h4 f5446t;

    /* renamed from: u, reason: collision with root package name */
    public final k4 f5447u;

    /* renamed from: v, reason: collision with root package name */
    public final k4 f5448v;

    /* renamed from: w, reason: collision with root package name */
    public final h4 f5449w;

    /* renamed from: x, reason: collision with root package name */
    public final g4 f5450x;

    public l4(h5 h5Var) {
        super(h5Var);
        this.f5437k = new h4(this, "session_timeout", 1800000L);
        this.f5438l = new f4(this, "start_new_session", true);
        this.f5441o = new h4(this, "last_pause_time", 0L);
        this.f5442p = new h4(this, "session_id", 0L);
        this.f5439m = new k4(this, "non_personalized_ads", null);
        this.f5440n = new f4(this, "allow_remote_dynamite", false);
        this.f5431e = new h4(this, "first_open_time", 0L);
        this.f5432f = new h4(this, "app_install_time", 0L);
        this.f5433g = new k4(this, "app_instance_id", null);
        this.f5444r = new f4(this, "app_backgrounded", false);
        this.f5445s = new f4(this, "deep_link_retrieval_complete", false);
        this.f5446t = new h4(this, "deep_link_retrieval_attempts", 0L);
        this.f5447u = new k4(this, "firebase_feature_rollouts", null);
        this.f5448v = new k4(this, "deferred_attribution_cache", null);
        this.f5449w = new h4(this, "deferred_attribution_cache_timestamp", 0L);
        this.f5450x = new g4(this, "default_event_parameters", null);
    }

    @Override // f2.b6
    public final void i() {
        SharedPreferences sharedPreferences = this.f5030a.c().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.f5429c = sharedPreferences;
        boolean z10 = sharedPreferences.getBoolean("has_been_opened", false);
        this.f5443q = z10;
        if (!z10) {
            SharedPreferences.Editor editorEdit = this.f5429c.edit();
            editorEdit.putBoolean("has_been_opened", true);
            editorEdit.apply();
        }
        this.f5030a.z();
        this.f5430d = new j4(this, "health_monitor", Math.max(0L, ((Long) i3.f5303e.a(null)).longValue()), null);
    }

    @Override // f2.b6
    public final boolean j() {
        return true;
    }

    public final SharedPreferences o() {
        h();
        k();
        t1.f.h(this.f5429c);
        return this.f5429c;
    }

    public final Pair p(String str) {
        h();
        zb.b();
        if (this.f5030a.z().B(null, i3.K0) && !q().j(zzha.AD_STORAGE)) {
            return new Pair("", Boolean.FALSE);
        }
        long jB = this.f5030a.a().b();
        String str2 = this.f5434h;
        if (str2 != null && jB < this.f5436j) {
            return new Pair(str2, Boolean.valueOf(this.f5435i));
        }
        this.f5436j = jB + this.f5030a.z().r(str, i3.f5299c);
        p1.a.b(true);
        try {
            a.C0109a c0109aA = p1.a.a(this.f5030a.c());
            this.f5434h = "";
            String strA = c0109aA.a();
            if (strA != null) {
                this.f5434h = strA;
            }
            this.f5435i = c0109aA.b();
        } catch (Exception e10) {
            this.f5030a.d().q().b("Unable to get advertising id", e10);
            this.f5434h = "";
        }
        p1.a.b(false);
        return new Pair(this.f5434h, Boolean.valueOf(this.f5435i));
    }

    public final f6 q() {
        h();
        return f6.c(o().getString("consent_settings", "G1"), o().getInt("consent_source", 100));
    }

    public final Boolean r() {
        h();
        if (o().contains("measurement_enabled")) {
            return Boolean.valueOf(o().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    public final void s(Boolean bool) {
        h();
        SharedPreferences.Editor editorEdit = o().edit();
        if (bool != null) {
            editorEdit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            editorEdit.remove("measurement_enabled");
        }
        editorEdit.apply();
    }

    public final void t(boolean z10) {
        h();
        this.f5030a.d().v().b("App measurement setting deferred collection", Boolean.valueOf(z10));
        SharedPreferences.Editor editorEdit = o().edit();
        editorEdit.putBoolean("deferred_analytics_collection", z10);
        editorEdit.apply();
    }

    public final boolean u() {
        SharedPreferences sharedPreferences = this.f5429c;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains("deferred_analytics_collection");
    }

    public final boolean v(long j10) {
        return j10 - this.f5437k.a() > this.f5441o.a();
    }

    public final boolean w(int i10) {
        return f6.k(i10, o().getInt("consent_source", 100));
    }
}
