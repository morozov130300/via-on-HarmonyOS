package f2;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class v6 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f5763e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ o7 f5764j;

    public v6(o7 o7Var, long j10) {
        this.f5764j = o7Var;
        this.f5763e = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5764j.z(this.f5763e, true);
        this.f5764j.f5030a.L().S(new AtomicReference());
    }
}
