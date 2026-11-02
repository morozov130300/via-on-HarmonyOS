package f2;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class y6 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f5847e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f5848j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f5849k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ o7 f5850l;

    public y6(o7 o7Var, AtomicReference atomicReference, String str, String str2, String str3) {
        this.f5850l = o7Var;
        this.f5847e = atomicReference;
        this.f5848j = str2;
        this.f5849k = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5850l.f5030a.L().U(this.f5847e, null, this.f5848j, this.f5849k);
    }
}
