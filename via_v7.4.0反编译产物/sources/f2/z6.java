package f2;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class z6 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f5874e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ o7 f5875j;

    public z6(o7 o7Var, AtomicReference atomicReference) {
        this.f5875j = o7Var;
        this.f5874e = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f5874e) {
            try {
                try {
                    this.f5874e.set(Boolean.valueOf(this.f5875j.f5030a.z().B(this.f5875j.f5030a.B().s(), i3.M)));
                } finally {
                    this.f5874e.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
