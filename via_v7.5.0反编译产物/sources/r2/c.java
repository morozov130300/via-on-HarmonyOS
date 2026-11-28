package r2;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c implements b, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f11958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f11960c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CountDownLatch f11962e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f11961d = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f11963f = false;

    public c(e eVar, int i10, TimeUnit timeUnit) {
        this.f11958a = eVar;
        this.f11959b = i10;
        this.f11960c = timeUnit;
    }

    @Override // r2.a
    public void a(String str, Bundle bundle) {
        synchronized (this.f11961d) {
            try {
                q2.f.f().i("Logging event " + str + " to Firebase Analytics with params " + bundle);
                this.f11962e = new CountDownLatch(1);
                this.f11963f = false;
                this.f11958a.a(str, bundle);
                q2.f.f().i("Awaiting app exception callback from Analytics...");
                try {
                    if (this.f11962e.await(this.f11959b, this.f11960c)) {
                        this.f11963f = true;
                        q2.f.f().i("App exception callback received from Analytics listener.");
                    } else {
                        q2.f.f().k("Timeout exceeded while awaiting app exception callback from Analytics listener.");
                    }
                } catch (InterruptedException unused) {
                    q2.f.f().d("Interrupted while awaiting app exception callback from Analytics listener.");
                }
                this.f11962e = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // r2.b
    public void onEvent(String str, Bundle bundle) {
        CountDownLatch countDownLatch = this.f11962e;
        if (countDownLatch != null && "_ae".equals(str)) {
            countDownLatch.countDown();
        }
    }
}
