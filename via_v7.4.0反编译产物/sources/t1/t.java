package t1;

import android.util.Log;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class t {

    /* renamed from: a, reason: collision with root package name */
    public Object f12072a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f12073b = false;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f12074c;

    public t(a aVar, Object obj) {
        this.f12074c = aVar;
        this.f12072a = obj;
    }

    public abstract void a(Object obj);

    public abstract void b();

    public final void c() {
        Object obj;
        synchronized (this) {
            try {
                obj = this.f12072a;
                if (this.f12073b) {
                    Log.w("GmsClient", "Callback proxy " + toString() + " being reused. This is not safe.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (obj != null) {
            a(obj);
        }
        synchronized (this) {
            this.f12073b = true;
        }
        e();
    }

    public final void d() {
        synchronized (this) {
            this.f12072a = null;
        }
    }

    public final void e() {
        d();
        synchronized (this.f12074c.f12016r) {
            this.f12074c.f12016r.remove(this);
        }
    }
}
