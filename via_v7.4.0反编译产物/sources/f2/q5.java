package f2;

import com.google.android.gms.measurement.internal.zzq;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class q5 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzq f5632e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ z5 f5633j;

    public q5(z5 z5Var, zzq zzqVar) {
        this.f5633j = z5Var;
        this.f5632e = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5633j.f5871d.e();
        pa paVar = this.f5633j.f5871d;
        zzq zzqVar = this.f5632e;
        paVar.f().h();
        paVar.g();
        t1.f.d(zzqVar.f3976e);
        paVar.S(zzqVar);
    }
}
