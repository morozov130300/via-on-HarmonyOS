package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class SavedStateHandleController implements f {

    /* renamed from: e, reason: collision with root package name */
    public final String f1024e;

    /* renamed from: j, reason: collision with root package name */
    public final t f1025j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1026k;

    public SavedStateHandleController(String key, t handle) {
        kotlin.jvm.internal.h.f(key, "key");
        kotlin.jvm.internal.h.f(handle, "handle");
        this.f1024e = key;
        this.f1025j = handle;
    }

    @Override // androidx.lifecycle.f
    public void a(h source, Lifecycle.Event event) {
        kotlin.jvm.internal.h.f(source, "source");
        kotlin.jvm.internal.h.f(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.f1026k = false;
            source.k0().c(this);
        }
    }

    public final void b(androidx.savedstate.a registry, Lifecycle lifecycle) {
        kotlin.jvm.internal.h.f(registry, "registry");
        kotlin.jvm.internal.h.f(lifecycle, "lifecycle");
        if (this.f1026k) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.f1026k = true;
        lifecycle.a(this);
        registry.h(this.f1024e, this.f1025j.c());
    }

    public final t c() {
        return this.f1025j;
    }

    public final boolean d() {
        return this.f1026k;
    }
}
