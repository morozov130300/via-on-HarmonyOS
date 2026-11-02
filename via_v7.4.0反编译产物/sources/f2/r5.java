package f2;

import com.google.android.gms.measurement.internal.zzq;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class r5 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzq f5652e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ z5 f5653j;

    public r5(z5 z5Var, zzq zzqVar) {
        this.f5653j = z5Var;
        this.f5652e = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5653j.f5871d.e();
        pa paVar = this.f5653j.f5871d;
        zzq zzqVar = this.f5652e;
        paVar.f().h();
        paVar.g();
        t1.f.d(zzqVar.f3976e);
        f6 f6VarC = f6.c(zzqVar.D, 100);
        f6 f6VarC0 = paVar.c0(zzqVar.f3976e);
        paVar.d().v().c("Setting consent, package, consent", zzqVar.f3976e, f6VarC);
        paVar.A(zzqVar.f3976e, f6VarC);
        if (f6VarC.m(f6VarC0)) {
            paVar.v(zzqVar);
        }
    }
}
