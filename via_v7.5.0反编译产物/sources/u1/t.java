package u1;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f12805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12806b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f12807c;

    public t(a aVar, Object obj) {
        this.f12807c = aVar;
        this.f12805a = obj;
    }

    public abstract void a(Object obj);

    public abstract void b();

    public final void c() {
        Object obj;
        synchronized (this) {
            try {
                obj = this.f12805a;
                if (this.f12806b) {
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
            this.f12806b = true;
        }
        e();
    }

    public final void d() {
        synchronized (this) {
            this.f12805a = null;
        }
    }

    public final void e() {
        d();
        synchronized (this.f12807c.f12749r) {
            this.f12807c.f12749r.remove(this);
        }
    }
}
