package f2;

import com.google.android.gms.measurement.internal.zzau;
import com.google.android.gms.measurement.internal.zzq;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class s5 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzau f5673e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ zzq f5674j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ z5 f5675k;

    public s5(z5 z5Var, zzau zzauVar, zzq zzqVar) {
        this.f5675k = z5Var;
        this.f5673e = zzauVar;
        this.f5674j = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5675k.c0(this.f5675k.a0(this.f5673e, this.f5674j), this.f5674j);
    }
}
