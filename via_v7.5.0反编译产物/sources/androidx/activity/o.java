package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f410b = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p7.a f411c;

    public o(boolean z10) {
        this.f409a = z10;
    }

    public final void a(c cancellable) {
        kotlin.jvm.internal.h.f(cancellable, "cancellable");
        this.f410b.add(cancellable);
    }

    public final p7.a b() {
        return this.f411c;
    }

    public abstract void d();

    public void e(b backEvent) {
        kotlin.jvm.internal.h.f(backEvent, "backEvent");
    }

    public void f(b backEvent) {
        kotlin.jvm.internal.h.f(backEvent, "backEvent");
    }

    public final boolean g() {
        return this.f409a;
    }

    public final void h() {
        Iterator it = this.f410b.iterator();
        while (it.hasNext()) {
            ((c) it.next()).cancel();
        }
    }

    public final void i(c cancellable) {
        kotlin.jvm.internal.h.f(cancellable, "cancellable");
        this.f410b.remove(cancellable);
    }

    public final void j(boolean z10) {
        this.f409a = z10;
        p7.a aVar = this.f411c;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    public final void k(p7.a aVar) {
        this.f411c = aVar;
    }

    public void c() {
    }
}
