package p1;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c extends Thread {

    /* renamed from: e, reason: collision with root package name */
    public final WeakReference f10933e;

    /* renamed from: j, reason: collision with root package name */
    public final long f10934j;

    /* renamed from: k, reason: collision with root package name */
    public final CountDownLatch f10935k = new CountDownLatch(1);

    /* renamed from: l, reason: collision with root package name */
    public boolean f10936l = false;

    public c(a aVar, long j10) {
        this.f10933e = new WeakReference(aVar);
        this.f10934j = j10;
        start();
    }

    public final void a() {
        a aVar = (a) this.f10933e.get();
        if (aVar != null) {
            aVar.c();
            this.f10936l = true;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            if (this.f10935k.await(this.f10934j, TimeUnit.MILLISECONDS)) {
                return;
            }
            a();
        } catch (InterruptedException unused) {
            a();
        }
    }
}
