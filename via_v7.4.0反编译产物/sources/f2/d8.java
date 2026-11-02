package f2;

import android.app.Activity;
import android.os.Bundle;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.simpleframework.xml.strategy.Name;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d8 extends c4 {

    /* renamed from: c, reason: collision with root package name */
    public volatile v7 f5087c;

    /* renamed from: d, reason: collision with root package name */
    public volatile v7 f5088d;

    /* renamed from: e, reason: collision with root package name */
    public v7 f5089e;

    /* renamed from: f, reason: collision with root package name */
    public final Map f5090f;

    /* renamed from: g, reason: collision with root package name */
    public Activity f5091g;

    /* renamed from: h, reason: collision with root package name */
    public volatile boolean f5092h;

    /* renamed from: i, reason: collision with root package name */
    public volatile v7 f5093i;

    /* renamed from: j, reason: collision with root package name */
    public v7 f5094j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f5095k;

    /* renamed from: l, reason: collision with root package name */
    public final Object f5096l;

    public d8(h5 h5Var) {
        super(h5Var);
        this.f5096l = new Object();
        this.f5090f = new ConcurrentHashMap();
    }

    public static /* bridge */ /* synthetic */ void w(d8 d8Var, Bundle bundle, v7 v7Var, v7 v7Var2, long j10) {
        bundle.remove("screen_name");
        bundle.remove("screen_class");
        d8Var.o(v7Var, v7Var2, j10, true, d8Var.f5030a.N().x0(null, "screen_view", bundle, null, false));
    }

    public final void A(Activity activity) {
        synchronized (this.f5096l) {
            this.f5095k = false;
            this.f5092h = true;
        }
        long jB = this.f5030a.a().b();
        if (!this.f5030a.z().D()) {
            this.f5087c = null;
            this.f5030a.f().z(new a8(this, jB));
        } else {
            v7 v7VarF = F(activity);
            this.f5088d = this.f5087c;
            this.f5087c = null;
            this.f5030a.f().z(new b8(this, v7VarF, jB));
        }
    }

    public final void B(Activity activity) {
        synchronized (this.f5096l) {
            this.f5095k = true;
            if (activity != this.f5091g) {
                synchronized (this.f5096l) {
                    this.f5091g = activity;
                    this.f5092h = false;
                }
                if (this.f5030a.z().D()) {
                    this.f5093i = null;
                    this.f5030a.f().z(new c8(this));
                }
            }
        }
        if (!this.f5030a.z().D()) {
            this.f5087c = this.f5093i;
            this.f5030a.f().z(new z7(this));
        } else {
            G(activity, F(activity), false);
            a2 a2VarY = this.f5030a.y();
            a2VarY.f5030a.f().z(new z0(a2VarY, a2VarY.f5030a.a().b()));
        }
    }

    public final void C(Activity activity, Bundle bundle) {
        v7 v7Var;
        if (!this.f5030a.z().D() || bundle == null || (v7Var = (v7) this.f5090f.get(activity)) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong(Name.MARK, v7Var.f5767c);
        bundle2.putString("name", v7Var.f5765a);
        bundle2.putString("referrer_name", v7Var.f5766b);
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
    */
    public final void D(Activity activity, String str, String str2) {
        if (!this.f5030a.z().D()) {
            this.f5030a.d().x().a("setCurrentScreen cannot be called while screen reporting is disabled.");
            return;
        }
        v7 v7Var = this.f5087c;
        if (v7Var == null) {
            this.f5030a.d().x().a("setCurrentScreen cannot be called while no activity active");
            return;
        }
        if (this.f5090f.get(activity) == null) {
            this.f5030a.d().x().a("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = t(activity.getClass(), "Activity");
        }
        boolean zA = w7.a(v7Var.f5766b, str2);
        boolean zA2 = w7.a(v7Var.f5765a, str);
        if (zA && zA2) {
            this.f5030a.d().x().a("setCurrentScreen cannot be called with the same class and name");
            return;
        }
        if (str != null) {
            if (str.length() > 0) {
                int length = str.length();
                this.f5030a.z();
            }
            this.f5030a.d().x().b("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            return;
        }
        if (str2 != null) {
            if (str2.length() > 0) {
                int length2 = str2.length();
                this.f5030a.z();
            }
            this.f5030a.d().x().b("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            return;
        }
        this.f5030a.d().v().c("Setting current screen to name, class", str == null ? "null" : str, str2);
        v7 v7Var2 = new v7(str, str2, this.f5030a.N().t0());
        this.f5090f.put(activity, v7Var2);
        G(activity, v7Var2, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0035, code lost:
    
        if (r2 > 100) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0067, code lost:
    
        if (r4 > 100) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void E(Bundle bundle, long j10) {
        synchronized (this.f5096l) {
            try {
                if (!this.f5095k) {
                    this.f5030a.d().x().a("Cannot log screen view event when the app is in the background.");
                    return;
                }
                String string = bundle.getString("screen_name");
                if (string != null) {
                    if (string.length() > 0) {
                        int length = string.length();
                        this.f5030a.z();
                    }
                    this.f5030a.d().x().b("Invalid screen name length for screen view. Length", Integer.valueOf(string.length()));
                    return;
                }
                String string2 = bundle.getString("screen_class");
                if (string2 != null) {
                    if (string2.length() > 0) {
                        int length2 = string2.length();
                        this.f5030a.z();
                    }
                    this.f5030a.d().x().b("Invalid screen class length for screen view. Length", Integer.valueOf(string2.length()));
                    return;
                }
                if (string2 == null) {
                    Activity activity = this.f5091g;
                    string2 = activity != null ? t(activity.getClass(), "Activity") : "Activity";
                }
                String str = string2;
                v7 v7Var = this.f5087c;
                if (this.f5092h && v7Var != null) {
                    this.f5092h = false;
                    boolean zA = w7.a(v7Var.f5766b, str);
                    boolean zA2 = w7.a(v7Var.f5765a, string);
                    if (zA && zA2) {
                        this.f5030a.d().x().a("Ignoring call to log screen view event with duplicate parameters.");
                        return;
                    }
                }
                this.f5030a.d().v().c("Logging screen view with name, class", string == null ? "null" : string, str == null ? "null" : str);
                v7 v7Var2 = this.f5087c == null ? this.f5088d : this.f5087c;
                v7 v7Var3 = new v7(string, str, this.f5030a.N().t0(), true, j10);
                this.f5087c = v7Var3;
                this.f5088d = v7Var2;
                this.f5093i = v7Var3;
                this.f5030a.f().z(new x7(this, bundle, v7Var3, v7Var2, this.f5030a.a().b()));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final v7 F(Activity activity) {
        t1.f.h(activity);
        v7 v7Var = (v7) this.f5090f.get(activity);
        if (v7Var == null) {
            v7 v7Var2 = new v7(null, t(activity.getClass(), "Activity"), this.f5030a.N().t0());
            this.f5090f.put(activity, v7Var2);
            v7Var = v7Var2;
        }
        return this.f5093i != null ? this.f5093i : v7Var;
    }

    public final void G(Activity activity, v7 v7Var, boolean z10) {
        v7 v7Var2;
        v7 v7Var3 = this.f5087c == null ? this.f5088d : this.f5087c;
        if (v7Var.f5766b == null) {
            v7Var2 = new v7(v7Var.f5765a, activity != null ? t(activity.getClass(), "Activity") : null, v7Var.f5767c, v7Var.f5769e, v7Var.f5770f);
        } else {
            v7Var2 = v7Var;
        }
        this.f5088d = this.f5087c;
        this.f5087c = v7Var2;
        this.f5030a.f().z(new y7(this, v7Var2, v7Var3, this.f5030a.a().b(), z10));
    }

    @Override // f2.c4
    public final boolean n() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o(v7 v7Var, v7 v7Var2, long j10, boolean z10, Bundle bundle) {
        h();
        boolean z11 = false;
        boolean z12 = (v7Var2 != null && v7Var2.f5767c == v7Var.f5767c && w7.a(v7Var2.f5766b, v7Var.f5766b) && w7.a(v7Var2.f5765a, v7Var.f5765a)) ? false : true;
        if (z10 && this.f5089e != null) {
            z11 = true;
        }
        if (z12) {
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            wa.y(v7Var, bundle2, true);
            if (v7Var2 != null) {
                String str = v7Var2.f5765a;
                if (str != null) {
                    bundle2.putString("_pn", str);
                }
                String str2 = v7Var2.f5766b;
                if (str2 != null) {
                    bundle2.putString("_pc", str2);
                }
                bundle2.putLong("_pi", v7Var2.f5767c);
            }
            if (z11) {
                s9 s9Var = this.f5030a.M().f5741f;
                long j11 = j10 - s9Var.f5684b;
                s9Var.f5684b = j10;
                if (j11 > 0) {
                    this.f5030a.N().w(bundle2, j11);
                }
            }
            if (!this.f5030a.z().D()) {
                bundle2.putLong("_mst", 1L);
            }
            String str3 = true != v7Var.f5769e ? "auto" : "app";
            long jA = this.f5030a.a().a();
            if (v7Var.f5769e) {
                long j12 = v7Var.f5770f;
                long j13 = j12 == 0 ? jA : j12;
                this.f5030a.I().v(str3, "_vs", j13, bundle2);
            }
        }
        if (z11) {
            p(this.f5089e, true, j10);
        }
        this.f5089e = v7Var;
        if (v7Var.f5769e) {
            this.f5094j = v7Var;
        }
        this.f5030a.L().u(v7Var);
    }

    public final void p(v7 v7Var, boolean z10, long j10) {
        this.f5030a.y().n(this.f5030a.a().b());
        if (!this.f5030a.M().f5741f.d(v7Var != null && v7Var.f5768d, z10, j10) || v7Var == null) {
            return;
        }
        v7Var.f5768d = false;
    }

    public final v7 r() {
        return this.f5087c;
    }

    public final v7 s(boolean z10) {
        i();
        h();
        if (!z10) {
            return this.f5089e;
        }
        v7 v7Var = this.f5089e;
        return v7Var != null ? v7Var : this.f5094j;
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
        this.f5030a.z();
        if (length2 <= 100) {
            return str2;
        }
        this.f5030a.z();
        return str2.substring(0, 100);
    }

    public final void y(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (!this.f5030a.z().D() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.f5090f.put(activity, new v7(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong(Name.MARK)));
    }

    public final void z(Activity activity) {
        synchronized (this.f5096l) {
            try {
                if (activity == this.f5091g) {
                    this.f5091g = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.f5030a.z().D()) {
            this.f5090f.remove(activity);
        }
    }
}
