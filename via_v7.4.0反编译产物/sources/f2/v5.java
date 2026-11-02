package f2;

import com.google.android.gms.measurement.internal.zzlk;
import com.google.android.gms.measurement.internal.zzq;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class v5 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzlk f5760e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ zzq f5761j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ z5 f5762k;

    public v5(z5 z5Var, zzlk zzlkVar, zzq zzqVar) {
        this.f5762k = z5Var;
        this.f5760e = zzlkVar;
        this.f5761j = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5762k.f5871d.e();
        if (this.f5760e.c() == null) {
            this.f5762k.f5871d.u(this.f5760e.f3970j, this.f5761j);
        } else {
            this.f5762k.f5871d.B(this.f5760e, this.f5761j);
        }
    }
}
