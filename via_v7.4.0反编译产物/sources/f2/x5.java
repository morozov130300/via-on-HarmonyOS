package f2;

import com.google.android.gms.measurement.internal.zzq;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class x5 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzq f5810e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ z5 f5811j;

    public x5(z5 z5Var, zzq zzqVar) {
        this.f5811j = z5Var;
        this.f5810e = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5811j.f5871d.e();
        this.f5811j.f5871d.q(this.f5810e);
    }
}
