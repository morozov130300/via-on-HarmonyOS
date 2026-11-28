package androidx.lifecycle;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class SingleGeneratedAdapterObserver implements h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f937c;

    public SingleGeneratedAdapterObserver(e generatedAdapter) {
        kotlin.jvm.internal.h.f(generatedAdapter, "generatedAdapter");
        this.f937c = generatedAdapter;
    }

    @Override // androidx.lifecycle.h
    public void e(j source, Lifecycle.Event event) {
        kotlin.jvm.internal.h.f(source, "source");
        kotlin.jvm.internal.h.f(event, "event");
        this.f937c.a(source, event, false, null);
        this.f937c.a(source, event, true, null);
    }
}
