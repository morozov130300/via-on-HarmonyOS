package g2;

import android.app.Activity;
import android.os.Bundle;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d8 extends c4 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile v7 f4703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile v7 f4704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public v7 f4705e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f4706f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Activity f4707g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f4708h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile v7 f4709i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public v7 f4710j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f4711k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Object f4712l;

    public d8(h5 h5Var) {
        super(h5Var);
        this.f4712l = new Object();
        this.f4706f = new ConcurrentHashMap();
    }

    public static /* bridge */ /* synthetic */ void w(d8 d8Var, Bundle bundle, v7 v7Var, v7 v7Var2, long j10) {
        bundle.remove("screen_name");
        bundle.remove("screen_class");
        d8Var.o(v7Var, v7Var2, j10, true, d8Var.f4646a.N().x0(null, "screen_view", bundle, null, false));
    }

    public final void A(Activity activity) {
        synchronized (this.f4712l) {
            this.f4711k = false;
            this.f4708h = true;
        }
        long jB = this.f4646a.a().b();
        if (!this.f4646a.z().D()) {
            this.f4703c = null;
            this.f4646a.f().z(new a8(this, jB));
        } else {
            v7 v7VarF = F(activity);
            this.f4704d = this.f4703c;
            this.f4703c = null;
            this.f4646a.f().z(new b8(this, v7VarF, jB));
        }
    }

    public final void B(Activity activity) {
        synchronized (this.f4712l) {
            this.f4711k = true;
            if (activity != this.f4707g) {
                synchronized (this.f4712l) {
                    this.f4707g = activity;
                    this.f4708h = false;
                }
                if (this.f4646a.z().D()) {
                    this.f4709i = null;
                    this.f4646a.f().z(new c8(this));
                }
            }
        }
        if (!this.f4646a.z().D()) {
            this.f4703c = this.f4709i;
            this.f4646a.f().z(new z7(this));
        } else {
            G(activity, F(activity), false);
            a2 a2VarY = this.f4646a.y();
            a2VarY.f4646a.f().z(new z0(a2VarY, a2VarY.f4646a.a().b()));
        }
    }

    public final void C(Activity activity, Bundle bundle) {
        v7 v7Var;
        if (!this.f4646a.z().D() || bundle == null || (v7Var = (v7) this.f4706f.get(activity)) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong(Name.MARK, v7Var.f5383c);
        bundle2.putString("name", v7Var.f5381a);
        bundle2.putString("referrer_name", v7Var.f5382b);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0088, code lost:
    
        if (r1 <= 100) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b4, code lost:
    
        if (r1 <= 100) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void D(android.app.Activity r4, java.lang.String r5, java.lang.String r6) {
        /*
            Method dump skipped, instruction units count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.d8.D(android.app.Activity, java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0035, code lost:
    
        if (r2 > 100) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0067, code lost:
    
        if (r4 > 100) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E(android.os.Bundle r13, long r14) {
        /*
            Method dump skipped, instruction units count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.d8.E(android.os.Bundle, long):void");
    }

    public final v7 F(Activity activity) {
        u1.f.h(activity);
        v7 v7Var = (v7) this.f4706f.get(activity);
        if (v7Var == null) {
            v7 v7Var2 = new v7(null, t(activity.getClass(), "Activity"), this.f4646a.N().t0());
            this.f4706f.put(activity, v7Var2);
            v7Var = v7Var2;
        }
        return this.f4709i != null ? this.f4709i : v7Var;
    }

    public final void G(Activity activity, v7 v7Var, boolean z10) {
        v7 v7Var2;
        v7 v7Var3 = this.f4703c == null ? this.f4704d : this.f4703c;
        if (v7Var.f5382b == null) {
            v7Var2 = new v7(v7Var.f5381a, activity != null ? t(activity.getClass(), "Activity") : null, v7Var.f5383c, v7Var.f5385e, v7Var.f5386f);
        } else {
            v7Var2 = v7Var;
        }
        this.f4704d = this.f4703c;
        this.f4703c = v7Var2;
        this.f4646a.f().z(new y7(this, v7Var2, v7Var3, this.f4646a.a().b(), z10));
    }

    @Override // g2.c4
    public final boolean n() {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00b9  */
    public final void o(v7 v7Var, v7 v7Var2, long j10, boolean z10, Bundle bundle) {
        long j11;
        h();
        boolean z11 = false;
        boolean z12 = (v7Var2 != null && v7Var2.f5383c == v7Var.f5383c && w7.a(v7Var2.f5382b, v7Var.f5382b) && w7.a(v7Var2.f5381a, v7Var.f5381a)) ? false : true;
        if (z10 && this.f4705e != null) {
            z11 = true;
        }
        if (z12) {
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            wa.y(v7Var, bundle2, true);
            if (v7Var2 != null) {
                String str = v7Var2.f5381a;
                if (str != null) {
                    bundle2.putString("_pn", str);
                }
                String str2 = v7Var2.f5382b;
                if (str2 != null) {
                    bundle2.putString("_pc", str2);
                }
                bundle2.putLong("_pi", v7Var2.f5383c);
            }
            if (z11) {
                s9 s9Var = this.f4646a.M().f5357f;
                long j12 = j10 - s9Var.f5300b;
                s9Var.f5300b = j10;
                if (j12 > 0) {
                    this.f4646a.N().w(bundle2, j12);
                }
            }
            if (!this.f4646a.z().D()) {
                bundle2.putLong("_mst", 1L);
            }
            String str3 = true != v7Var.f5385e ? "auto" : "app";
            long jA = this.f4646a.a().a();
            if (v7Var.f5385e) {
                long j13 = v7Var.f5386f;
                if (j13 == 0) {
                    j11 = jA;
                } else {
                    j11 = j13;
                }
            } else {
                j11 = jA;
            }
            this.f4646a.I().v(str3, "_vs", j11, bundle2);
        }
        if (z11) {
            p(this.f4705e, true, j10);
        }
        this.f4705e = v7Var;
        if (v7Var.f5385e) {
            this.f4710j = v7Var;
        }
        this.f4646a.L().u(v7Var);
    }

    public final void p(v7 v7Var, boolean z10, long j10) {
        this.f4646a.y().n(this.f4646a.a().b());
        if (!this.f4646a.M().f5357f.d(v7Var != null && v7Var.f5384d, z10, j10) || v7Var == null) {
            return;
        }
        v7Var.f5384d = false;
    }

    public final v7 r() {
        return this.f4703c;
    }

    public final v7 s(boolean z10) {
        i();
        h();
        if (!z10) {
            return this.f4705e;
        }
        v7 v7Var = this.f4705e;
        return v7Var != null ? v7Var : this.f4710j;
    }

    public final String t(Class cls, String str) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return "Activity";
        }
        String[] strArrSplit = canonicalName.split("\\.");
        int length = strArrSplit.length;
        String str2 = length > 0 ? strArrSplit[length - 1] : "";
        int length2 = str2.length();
        this.f4646a.z();
        if (length2 <= 100) {
            return str2;
        }
        this.f4646a.z();
        return str2.substring(0, 100);
    }

    public final void y(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (!this.f4646a.z().D() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.f4706f.put(activity, new v7(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong(Name.MARK)));
    }

    public final void z(Activity activity) {
        synchronized (this.f4712l) {
            try {
                if (activity == this.f4707g) {
                    this.f4707g = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.f4646a.z().D()) {
            this.f4706f.remove(activity);
        }
    }
}
