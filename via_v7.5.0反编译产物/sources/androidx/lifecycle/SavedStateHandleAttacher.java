package androidx.lifecycle;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandleAttacher implements h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SavedStateHandlesProvider f926c;

    public SavedStateHandleAttacher(SavedStateHandlesProvider provider) {
        kotlin.jvm.internal.h.f(provider, "provider");
        this.f926c = provider;
    }

    @Override // androidx.lifecycle.h
    public void e(j source, Lifecycle.Event event) {
        kotlin.jvm.internal.h.f(source, "source");
        kotlin.jvm.internal.h.f(event, "event");
        if (event == Lifecycle.Event.ON_CREATE) {
            source.h0().c(this);
            this.f926c.d();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + event).toString());
        }
    }
}
