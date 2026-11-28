package k1;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class g implements g1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f7165a;

    public g(c7.a aVar) {
        this.f7165a = aVar;
    }

    public static SchedulerConfig a(o1.a aVar) {
        return (SchedulerConfig) g1.d.c(f.a(aVar), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static g b(c7.a aVar) {
        return new g(aVar);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public SchedulerConfig get() {
        return a((o1.a) this.f7165a.get());
    }
}
