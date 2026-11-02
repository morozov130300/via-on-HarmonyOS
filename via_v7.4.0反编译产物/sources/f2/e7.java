package f2;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class e7 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f5147e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ o7 f5148j;

    public e7(o7 o7Var, AtomicReference atomicReference) {
        this.f5148j = o7Var;
        this.f5147e = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f5147e) {
            try {
                try {
                    this.f5147e.set(this.f5148j.f5030a.z().x(this.f5148j.f5030a.B().s(), i3.N));
                } finally {
                    this.f5147e.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
