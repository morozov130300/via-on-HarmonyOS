package j1;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class g implements f1.b {

    /* renamed from: a, reason: collision with root package name */
    public final i7.a f7533a;

    public g(i7.a aVar) {
        this.f7533a = aVar;
    }

    public static SchedulerConfig a(n1.a aVar) {
        return (SchedulerConfig) f1.d.c(f.a(aVar), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static g b(i7.a aVar) {
        return new g(aVar);
    }

    @Override // i7.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public SchedulerConfig get() {
        return a((n1.a) this.f7533a.get());
    }
}
