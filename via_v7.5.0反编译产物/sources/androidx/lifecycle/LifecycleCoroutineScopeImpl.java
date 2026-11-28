package androidx.lifecycle;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class LifecycleCoroutineScopeImpl extends g implements h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lifecycle f903c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final kotlin.coroutines.b f904e;

    public kotlin.coroutines.b a() {
        return this.f904e;
    }

    public Lifecycle d() {
        return this.f903c;
    }

    @Override // androidx.lifecycle.h
    public void e(j source, Lifecycle.Event event) {
        kotlin.jvm.internal.h.f(source, "source");
        kotlin.jvm.internal.h.f(event, "event");
        if (d().b().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            d().c(this);
            v7.c.b(a(), null, 1, null);
        }
    }
}
