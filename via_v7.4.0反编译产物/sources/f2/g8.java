package f2;

import com.google.android.gms.measurement.internal.zzlk;
import com.google.android.gms.measurement.internal.zzq;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class g8 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzq f5212e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ boolean f5213j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ zzlk f5214k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ d9 f5215l;

    public g8(d9 d9Var, zzq zzqVar, boolean z10, zzlk zzlkVar) {
        this.f5215l = d9Var;
        this.f5212e = zzqVar;
        this.f5213j = z10;
        this.f5214k = zzlkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d9 d9Var = this.f5215l;
        l3 l3Var = d9Var.f5098d;
        if (l3Var == null) {
            d9Var.f5030a.d().r().a("Discarding data. Failed to set user property");
            return;
        }
        t1.f.h(this.f5212e);
        this.f5215l.r(l3Var, this.f5213j ? null : this.f5214k, this.f5212e);
        this.f5215l.E();
    }
}
