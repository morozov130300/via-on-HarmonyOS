package k1;

import android.content.Context;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import l1.m0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class i implements g1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f7166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f7167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c7.a f7168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c7.a f7169d;

    public i(c7.a aVar, c7.a aVar2, c7.a aVar3, c7.a aVar4) {
        this.f7166a = aVar;
        this.f7167b = aVar2;
        this.f7168c = aVar3;
        this.f7169d = aVar4;
    }

    public static i a(c7.a aVar, c7.a aVar2, c7.a aVar3, c7.a aVar4) {
        return new i(aVar, aVar2, aVar3, aVar4);
    }

    public static m0 c(Context context, m1.d dVar, SchedulerConfig schedulerConfig, o1.a aVar) {
        return (m0) g1.d.c(h.a(context, dVar, schedulerConfig, aVar), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public m0 get() {
        return c((Context) this.f7166a.get(), (m1.d) this.f7167b.get(), (SchedulerConfig) this.f7168c.get(), (o1.a) this.f7169d.get());
    }
}
