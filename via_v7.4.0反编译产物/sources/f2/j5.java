package f2;

import com.google.android.gms.measurement.internal.zzac;
import com.google.android.gms.measurement.internal.zzq;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class j5 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzac f5378e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ zzq f5379j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ z5 f5380k;

    public j5(z5 z5Var, zzac zzacVar, zzq zzqVar) {
        this.f5380k = z5Var;
        this.f5378e = zzacVar;
        this.f5379j = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5380k.f5871d.e();
        if (this.f5378e.f3954k.c() == null) {
            this.f5380k.f5871d.t(this.f5378e, this.f5379j);
        } else {
            this.f5380k.f5871d.z(this.f5378e, this.f5379j);
        }
    }
}
