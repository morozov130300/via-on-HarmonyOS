package g2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class k implements l {

    /* renamed from: a, reason: collision with root package name */
    public final CountDownLatch f6152a = new CountDownLatch(1);

    public /* synthetic */ k(j jVar) {
    }

    public final void a() throws InterruptedException {
        this.f6152a.await();
    }

    @Override // g2.b
    public final void b() {
        this.f6152a.countDown();
    }

    @Override // g2.c
    public final void c(Exception exc) {
        this.f6152a.countDown();
    }

    public final boolean d(long j10, TimeUnit timeUnit) {
        return this.f6152a.await(j10, timeUnit);
    }

    @Override // g2.d
    public final void onSuccess(Object obj) {
        this.f6152a.countDown();
    }
}
