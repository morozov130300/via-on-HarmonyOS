package f2;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a7 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f5031e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f5032j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f5033k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ boolean f5034l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ o7 f5035m;

    public a7(o7 o7Var, AtomicReference atomicReference, String str, String str2, String str3, boolean z10) {
        this.f5035m = o7Var;
        this.f5031e = atomicReference;
        this.f5032j = str2;
        this.f5033k = str3;
        this.f5034l = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5035m.f5030a.L().W(this.f5031e, null, this.f5032j, this.f5033k, this.f5034l);
    }
}
