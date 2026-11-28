package g2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class h3 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f4849h = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e3 f4851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f4852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f4853d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f4854e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile Object f4855f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile Object f4856g = null;

    public /* synthetic */ h3(String str, Object obj, Object obj2, e3 e3Var, g3 g3Var) {
        this.f4850a = str;
        this.f4852c = obj;
        this.f4853d = obj2;
        this.f4851b = e3Var;
    }

    public final Object a(Object obj) {
        synchronized (this.f4854e) {
        }
        if (obj != null) {
            return obj;
        }
        if (f3.f4787a == null) {
            return this.f4852c;
        }
        synchronized (f4849h) {
            try {
                if (c.a()) {
                    return this.f4856g == null ? this.f4852c : this.f4856g;
                }
                try {
                    for (h3 h3Var : i3.f4911a) {
                        if (c.a()) {
                            throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                        }
                        Object objZza = null;
                        try {
                            e3 e3Var = h3Var.f4851b;
                            if (e3Var != null) {
                                objZza = e3Var.zza();
                            }
                        } catch (IllegalStateException unused) {
                        }
                        synchronized (f4849h) {
                            h3Var.f4856g = objZza;
                        }
                    }
                } catch (SecurityException unused2) {
                }
                e3 e3Var2 = this.f4851b;
                if (e3Var2 == null) {
                    return this.f4852c;
                }
                try {
                    return e3Var2.zza();
                } catch (IllegalStateException unused3) {
                    return this.f4852c;
                } catch (SecurityException unused4) {
                    return this.f4852c;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String b() {
        return this.f4850a;
    }
}
