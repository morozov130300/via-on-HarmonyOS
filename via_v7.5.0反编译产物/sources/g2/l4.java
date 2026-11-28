package g2;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zb;
import com.google.android.gms.measurement.internal.zzha;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class l4 extends b6 {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Pair f5044y = new Pair("", 0L);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SharedPreferences f5045c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j4 f5046d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h4 f5047e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h4 f5048f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final k4 f5049g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f5050h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5051i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f5052j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final h4 f5053k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final f4 f5054l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final k4 f5055m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final f4 f5056n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final h4 f5057o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final h4 f5058p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f5059q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final f4 f5060r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final f4 f5061s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final h4 f5062t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final k4 f5063u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final k4 f5064v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final h4 f5065w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final g4 f5066x;

    public l4(h5 h5Var) {
        super(h5Var);
        this.f5053k = new h4(this, "session_timeout", 1800000L);
        this.f5054l = new f4(this, "start_new_session", true);
        this.f5057o = new h4(this, "last_pause_time", 0L);
        this.f5058p = new h4(this, "session_id", 0L);
        this.f5055m = new k4(this, "non_personalized_ads", null);
        this.f5056n = new f4(this, "allow_remote_dynamite", false);
        this.f5047e = new h4(this, "first_open_time", 0L);
        this.f5048f = new h4(this, "app_install_time", 0L);
        this.f5049g = new k4(this, "app_instance_id", null);
        this.f5060r = new f4(this, "app_backgrounded", false);
        this.f5061s = new f4(this, "deep_link_retrieval_complete", false);
        this.f5062t = new h4(this, "deep_link_retrieval_attempts", 0L);
        this.f5063u = new k4(this, "firebase_feature_rollouts", null);
        this.f5064v = new k4(this, "deferred_attribution_cache", null);
        this.f5065w = new h4(this, "deferred_attribution_cache_timestamp", 0L);
        this.f5066x = new g4(this, "default_event_parameters", null);
    }

    @Override // g2.b6
    public final void i() {
        SharedPreferences sharedPreferences = this.f4646a.c().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.f5045c = sharedPreferences;
        boolean z10 = sharedPreferences.getBoolean("has_been_opened", false);
        this.f5059q = z10;
        if (!z10) {
            SharedPreferences.Editor editorEdit = this.f5045c.edit();
            editorEdit.putBoolean("has_been_opened", true);
            editorEdit.apply();
        }
        this.f4646a.z();
        this.f5046d = new j4(this, "health_monitor", Math.max(0L, ((Long) i3.f4919e.a(null)).longValue()), null);
    }

    @Override // g2.b6
    public final boolean j() {
        return true;
    }

    public final SharedPreferences o() {
        h();
        k();
        u1.f.h(this.f5045c);
        return this.f5045c;
    }

    public final Pair p(String str) {
        h();
        zb.b();
        if (this.f4646a.z().B(null, i3.K0) && !q().j(zzha.AD_STORAGE)) {
            return new Pair("", Boolean.FALSE);
        }
        long jB = this.f4646a.a().b();
        String str2 = this.f5050h;
        if (str2 != null && jB < this.f5052j) {
            return new Pair(str2, Boolean.valueOf(this.f5051i));
        }
        this.f5052j = jB + this.f4646a.z().r(str, i3.f4915c);
        q1.a.b(true);
        try {
            q1.a.C0113a c0113aA = q1.a.a(this.f4646a.c());
            this.f5050h = "";
            String strA = c0113aA.a();
            if (strA != null) {
                this.f5050h = strA;
            }
            this.f5051i = c0113aA.b();
        } catch (Exception e10) {
            this.f4646a.d().q().b("Unable to get advertising id", e10);
            this.f5050h = "";
        }
        q1.a.b(false);
        return new Pair(this.f5050h, Boolean.valueOf(this.f5051i));
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
        this.f4646a.d().v().b("App measurement setting deferred collection", Boolean.valueOf(z10));
        SharedPreferences.Editor editorEdit = o().edit();
        editorEdit.putBoolean("deferred_analytics_collection", z10);
        editorEdit.apply();
    }

    public final boolean u() {
        SharedPreferences sharedPreferences = this.f5045c;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains("deferred_analytics_collection");
    }

    public final boolean v(long j10) {
        return j10 - this.f5053k.a() > this.f5057o.a();
    }

    public final boolean w(int i10) {
        return f6.k(i10, o().getInt("consent_source", 100));
    }
}
