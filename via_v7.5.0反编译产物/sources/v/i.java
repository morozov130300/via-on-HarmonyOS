package v;

import android.os.CancellationSignal;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f12966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f12967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12968c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a {
        public static void a(Object obj) {
            ((CancellationSignal) obj).cancel();
        }

        public static CancellationSignal b() {
            return new CancellationSignal();
        }
    }

    public void a() {
        synchronized (this) {
            try {
                if (this.f12966a) {
                    return;
                }
                this.f12966a = true;
                this.f12968c = true;
                Object obj = this.f12967b;
                if (obj != null) {
                    try {
                        a.a(obj);
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.f12968c = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                synchronized (this) {
                    this.f12968c = false;
                    notifyAll();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
