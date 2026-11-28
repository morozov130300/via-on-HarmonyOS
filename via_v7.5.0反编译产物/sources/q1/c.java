package q1;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c extends Thread {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference f11711c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f11712e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final CountDownLatch f11713m = new CountDownLatch(1);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f11714n = false;

    public c(a aVar, long j10) {
        this.f11711c = new WeakReference(aVar);
        this.f11712e = j10;
        start();
    }

    public final void a() {
        a aVar = (a) this.f11711c.get();
        if (aVar != null) {
            aVar.c();
            this.f11714n = true;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            if (this.f11713m.await(this.f11712e, TimeUnit.MILLISECONDS)) {
                return;
            }
            a();
        } catch (InterruptedException unused) {
            a();
        }
    }
}
