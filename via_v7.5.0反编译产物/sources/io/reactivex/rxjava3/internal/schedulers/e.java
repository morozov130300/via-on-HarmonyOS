package io.reactivex.rxjava3.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import r6.p;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class e extends p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final RxThreadFactory f6672d = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx3.newthread-priority", 5).intValue())));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ThreadFactory f6673c;

    public e() {
        this(f6672d);
    }

    @Override // r6.p
    public p.c c() {
        return new f(this.f6673c);
    }

    public e(ThreadFactory threadFactory) {
        this.f6673c = threadFactory;
    }
}
