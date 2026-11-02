package f2;

import com.google.android.gms.measurement.internal.zzac;
import com.google.android.gms.measurement.internal.zzq;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class t8 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzq f5708e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ boolean f5709j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ zzac f5710k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ zzac f5711l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ d9 f5712m;

    public t8(d9 d9Var, boolean z10, zzq zzqVar, boolean z11, zzac zzacVar, zzac zzacVar2) {
        this.f5712m = d9Var;
        this.f5708e = zzqVar;
        this.f5709j = z11;
        this.f5710k = zzacVar;
        this.f5711l = zzacVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d9 d9Var = this.f5712m;
        l3 l3Var = d9Var.f5098d;
        if (l3Var == null) {
            d9Var.f5030a.d().r().a("Discarding data. Failed to send conditional user property to service");
            return;
        }
        t1.f.h(this.f5708e);
        this.f5712m.r(l3Var, this.f5709j ? null : this.f5710k, this.f5708e);
        this.f5712m.E();
    }
}
