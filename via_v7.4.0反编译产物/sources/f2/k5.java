package f2;

import com.google.android.gms.measurement.internal.zzac;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class k5 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzac f5415e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ z5 f5416j;

    public k5(z5 z5Var, zzac zzacVar) {
        this.f5416j = z5Var;
        this.f5415e = zzacVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5416j.f5871d.e();
        if (this.f5415e.f3954k.c() == null) {
            this.f5416j.f5871d.s(this.f5415e);
        } else {
            this.f5416j.f5871d.y(this.f5415e);
        }
    }
}
