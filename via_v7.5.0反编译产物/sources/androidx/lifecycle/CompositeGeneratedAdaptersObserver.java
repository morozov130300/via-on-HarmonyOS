package androidx.lifecycle;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class CompositeGeneratedAdaptersObserver implements h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e[] f892c;

    public CompositeGeneratedAdaptersObserver(e[] generatedAdapters) {
        kotlin.jvm.internal.h.f(generatedAdapters, "generatedAdapters");
        this.f892c = generatedAdapters;
    }

    @Override // androidx.lifecycle.h
    public void e(j source, Lifecycle.Event event) {
        kotlin.jvm.internal.h.f(source, "source");
        kotlin.jvm.internal.h.f(event, "event");
        m mVar = new m();
        for (e eVar : this.f892c) {
            eVar.a(source, event, false, mVar);
        }
        for (e eVar2 : this.f892c) {
            eVar2.a(source, event, true, mVar);
        }
    }
}
