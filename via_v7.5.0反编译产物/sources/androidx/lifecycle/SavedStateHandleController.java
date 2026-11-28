package androidx.lifecycle;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandleController implements h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f927c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final v f928e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f929m;

    public SavedStateHandleController(String key, v handle) {
        kotlin.jvm.internal.h.f(key, "key");
        kotlin.jvm.internal.h.f(handle, "handle");
        this.f927c = key;
        this.f928e = handle;
    }

    public final void a(androidx.savedstate.a registry, Lifecycle lifecycle) {
        kotlin.jvm.internal.h.f(registry, "registry");
        kotlin.jvm.internal.h.f(lifecycle, "lifecycle");
        if (this.f929m) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.f929m = true;
        lifecycle.a(this);
        registry.h(this.f927c, this.f928e.c());
    }

    public final v d() {
        return this.f928e;
    }

    @Override // androidx.lifecycle.h
    public void e(j source, Lifecycle.Event event) {
        kotlin.jvm.internal.h.f(source, "source");
        kotlin.jvm.internal.h.f(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.f929m = false;
            source.h0().c(this);
        }
    }

    public final boolean h() {
        return this.f929m;
    }
}
