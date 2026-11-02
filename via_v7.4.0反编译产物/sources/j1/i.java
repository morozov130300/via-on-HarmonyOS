package j1;

import android.content.Context;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import k1.m0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class i implements f1.b {

    /* renamed from: a, reason: collision with root package name */
    public final i7.a f7534a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f7535b;

    /* renamed from: c, reason: collision with root package name */
    public final i7.a f7536c;

    /* renamed from: d, reason: collision with root package name */
    public final i7.a f7537d;

    public i(i7.a aVar, i7.a aVar2, i7.a aVar3, i7.a aVar4) {
        this.f7534a = aVar;
        this.f7535b = aVar2;
        this.f7536c = aVar3;
        this.f7537d = aVar4;
    }

    public static i a(i7.a aVar, i7.a aVar2, i7.a aVar3, i7.a aVar4) {
        return new i(aVar, aVar2, aVar3, aVar4);
    }

    public static m0 c(Context context, l1.d dVar, SchedulerConfig schedulerConfig, n1.a aVar) {
        return (m0) f1.d.c(h.a(context, dVar, schedulerConfig, aVar), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public m0 get() {
        return c((Context) this.f7534a.get(), (l1.d) this.f7535b.get(), (SchedulerConfig) this.f7536c.get(), (n1.a) this.f7537d.get());
    }
}
