package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public boolean f506a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f507b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    public q7.a f508c;

    public o(boolean z10) {
        this.f506a = z10;
    }

    public final void a(c cancellable) {
        kotlin.jvm.internal.h.f(cancellable, "cancellable");
        this.f507b.add(cancellable);
    }

    public final q7.a b() {
        return this.f508c;
    }

    public void c() {
    }

    public abstract void d();

    public void e(b backEvent) {
        kotlin.jvm.internal.h.f(backEvent, "backEvent");
    }

    public void f(b backEvent) {
        kotlin.jvm.internal.h.f(backEvent, "backEvent");
    }

    public final boolean g() {
        return this.f506a;
    }

    public final void h() {
        Iterator it = this.f507b.iterator();
        while (it.hasNext()) {
            ((c) it.next()).cancel();
        }
    }

    public final void i(c cancellable) {
        kotlin.jvm.internal.h.f(cancellable, "cancellable");
        this.f507b.remove(cancellable);
    }

    public final void j(boolean z10) {
        this.f506a = z10;
        q7.a aVar = this.f508c;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    public final void k(q7.a aVar) {
        this.f508c = aVar;
    }
}
