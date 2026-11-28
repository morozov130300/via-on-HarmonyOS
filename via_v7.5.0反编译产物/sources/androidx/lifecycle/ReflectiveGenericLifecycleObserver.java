package androidx.lifecycle;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
class ReflectiveGenericLifecycleObserver implements h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f924c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b.a f925e;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f924c = obj;
        this.f925e = b.f950c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.h
    public void e(j jVar, Lifecycle.Event event) {
        this.f925e.a(jVar, event, this.f924c);
    }
}
