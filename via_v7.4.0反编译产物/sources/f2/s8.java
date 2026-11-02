package f2;

import com.google.android.gms.measurement.internal.zzau;
import com.google.android.gms.measurement.internal.zzq;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class s8 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzq f5678e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ boolean f5679j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ zzau f5680k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f5681l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ d9 f5682m;

    public s8(d9 d9Var, boolean z10, zzq zzqVar, boolean z11, zzau zzauVar, String str) {
        this.f5682m = d9Var;
        this.f5678e = zzqVar;
        this.f5679j = z11;
        this.f5680k = zzauVar;
        this.f5681l = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d9 d9Var = this.f5682m;
        l3 l3Var = d9Var.f5098d;
        if (l3Var == null) {
            d9Var.f5030a.d().r().a("Discarding data. Failed to send event to service");
            return;
        }
        t1.f.h(this.f5678e);
        this.f5682m.r(l3Var, this.f5679j ? null : this.f5680k, this.f5678e);
        this.f5682m.E();
    }
}
