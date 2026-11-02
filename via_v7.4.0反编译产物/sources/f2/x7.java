package f2;

import android.os.Bundle;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class x7 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Bundle f5814e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ v7 f5815j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ v7 f5816k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f5817l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ d8 f5818m;

    public x7(d8 d8Var, Bundle bundle, v7 v7Var, v7 v7Var2, long j10) {
        this.f5818m = d8Var;
        this.f5814e = bundle;
        this.f5815j = v7Var;
        this.f5816k = v7Var2;
        this.f5817l = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d8.w(this.f5818m, this.f5814e, this.f5815j, this.f5816k, this.f5817l);
    }
}
