package h2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class k implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CountDownLatch f5649a = new CountDownLatch(1);

    public /* synthetic */ k(j jVar) {
    }

    public final void a() throws InterruptedException {
        this.f5649a.await();
    }

    @Override // h2.b
    public final void b() {
        this.f5649a.countDown();
    }

    @Override // h2.c
    public final void c(Exception exc) {
        this.f5649a.countDown();
    }

    public final boolean d(long j10, TimeUnit timeUnit) {
        return this.f5649a.await(j10, timeUnit);
    }

    @Override // h2.d
    public final void onSuccess(Object obj) {
        this.f5649a.countDown();
    }
}
