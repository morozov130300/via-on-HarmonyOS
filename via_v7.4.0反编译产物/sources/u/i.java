package u;

import android.os.CancellationSignal;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public boolean f12427a;

    /* renamed from: b, reason: collision with root package name */
    public Object f12428b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f12429c;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
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
                if (this.f12427a) {
                    return;
                }
                this.f12427a = true;
                this.f12429c = true;
                Object obj = this.f12428b;
                if (obj != null) {
                    try {
                        a.a(obj);
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.f12429c = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                synchronized (this) {
                    this.f12429c = false;
                    notifyAll();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
