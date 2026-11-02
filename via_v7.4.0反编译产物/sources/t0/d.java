package t0;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class d implements y6.b {

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f11998e = new AtomicBoolean();

    public abstract void b();

    @Override // y6.b
    public final void dispose() {
        if (this.f11998e.compareAndSet(false, true)) {
            if (b.b()) {
                b();
            } else {
                w6.b.b().d(new Runnable() { // from class: t0.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11997e.b();
                    }
                });
            }
        }
    }

    @Override // y6.b
    public final boolean isDisposed() {
        return this.f11998e.get();
    }
}
