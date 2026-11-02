package io.reactivex.rxjava3.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import x6.n;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d extends n {

    /* renamed from: d, reason: collision with root package name */
    public static final RxThreadFactory f7437d = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx3.newthread-priority", 5).intValue())));

    /* renamed from: c, reason: collision with root package name */
    public final ThreadFactory f7438c;

    public d() {
        this(f7437d);
    }

    public d(ThreadFactory threadFactory) {
        this.f7438c = threadFactory;
    }

    @Override // x6.n
    public n.b c() {
        return new e(this.f7438c);
    }
}
