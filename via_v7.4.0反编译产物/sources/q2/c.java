package q2;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c implements b, a {

    /* renamed from: a, reason: collision with root package name */
    public final e f11268a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11269b;

    /* renamed from: c, reason: collision with root package name */
    public final TimeUnit f11270c;

    /* renamed from: e, reason: collision with root package name */
    public CountDownLatch f11272e;

    /* renamed from: d, reason: collision with root package name */
    public final Object f11271d = new Object();

    /* renamed from: f, reason: collision with root package name */
    public boolean f11273f = false;

    public c(e eVar, int i10, TimeUnit timeUnit) {
        this.f11268a = eVar;
        this.f11269b = i10;
        this.f11270c = timeUnit;
    }

    @Override // q2.a
    public void a(String str, Bundle bundle) {
        synchronized (this.f11271d) {
            try {
                p2.f.f().i("Logging event " + str + " to Firebase Analytics with params " + bundle);
                this.f11272e = new CountDownLatch(1);
                this.f11273f = false;
                this.f11268a.a(str, bundle);
                p2.f.f().i("Awaiting app exception callback from Analytics...");
                try {
                    if (this.f11272e.await(this.f11269b, this.f11270c)) {
                        this.f11273f = true;
                        p2.f.f().i("App exception callback received from Analytics listener.");
                    } else {
                        p2.f.f().k("Timeout exceeded while awaiting app exception callback from Analytics listener.");
                    }
                } catch (InterruptedException unused) {
                    p2.f.f().d("Interrupted while awaiting app exception callback from Analytics listener.");
                }
                this.f11272e = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // q2.b
    public void onEvent(String str, Bundle bundle) {
        CountDownLatch countDownLatch = this.f11272e;
        if (countDownLatch != null && "_ae".equals(str)) {
            countDownLatch.countDown();
        }
    }
}
