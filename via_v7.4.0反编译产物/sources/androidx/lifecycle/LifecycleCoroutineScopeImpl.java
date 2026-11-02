package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class LifecycleCoroutineScopeImpl extends e implements f {

    /* renamed from: e, reason: collision with root package name */
    public final Lifecycle f1001e;

    @Override // androidx.lifecycle.f
    public void a(h source, Lifecycle.Event event) {
        kotlin.jvm.internal.h.f(source, "source");
        kotlin.jvm.internal.h.f(event, "event");
        if (c().b().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            c().c(this);
            b();
            w7.c.b(null, null, 1, null);
        }
    }

    public l7.a b() {
        return null;
    }

    public Lifecycle c() {
        return this.f1001e;
    }
}
