package f2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class h3 {

    /* renamed from: h, reason: collision with root package name */
    public static final Object f5233h = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final String f5234a;

    /* renamed from: b, reason: collision with root package name */
    public final e3 f5235b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f5236c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f5237d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f5238e = new Object();

    /* renamed from: f, reason: collision with root package name */
    public volatile Object f5239f = null;

    /* renamed from: g, reason: collision with root package name */
    public volatile Object f5240g = null;

    public /* synthetic */ h3(String str, Object obj, Object obj2, e3 e3Var, g3 g3Var) {
        this.f5234a = str;
        this.f5236c = obj;
        this.f5237d = obj2;
        this.f5235b = e3Var;
    }

    public final Object a(Object obj) {
        synchronized (this.f5238e) {
        }
        if (obj != null) {
            return obj;
        }
        if (f3.f5171a == null) {
            return this.f5236c;
        }
        synchronized (f5233h) {
            try {
                if (c.a()) {
                    return this.f5240g == null ? this.f5236c : this.f5240g;
                }
                try {
                    for (h3 h3Var : i3.f5295a) {
                        if (c.a()) {
                            throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                        }
                        Object objZza = null;
                        try {
                            e3 e3Var = h3Var.f5235b;
                            if (e3Var != null) {
                                objZza = e3Var.zza();
                            }
                        } catch (IllegalStateException unused) {
                        }
                        synchronized (f5233h) {
                            h3Var.f5240g = objZza;
                        }
                    }
                } catch (SecurityException unused2) {
                }
                e3 e3Var2 = this.f5235b;
                if (e3Var2 == null) {
                    return this.f5236c;
                }
                try {
                    return e3Var2.zza();
                } catch (IllegalStateException unused3) {
                    return this.f5236c;
                } catch (SecurityException unused4) {
                    return this.f5236c;
                }
            } finally {
            }
        }
    }

    public final String b() {
        return this.f5234a;
    }
}
