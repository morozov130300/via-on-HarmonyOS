package f2;

import com.google.android.gms.measurement.internal.zzha;
import com.google.android.gms.measurement.internal.zzq;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class ia implements Callable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzq f5361e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ pa f5362j;

    public ia(pa paVar, zzq zzqVar) {
        this.f5362j = paVar;
        this.f5361e = zzqVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        f6 f6VarC0 = this.f5362j.c0((String) t1.f.h(this.f5361e.f3976e));
        zzha zzhaVar = zzha.ANALYTICS_STORAGE;
        if (f6VarC0.j(zzhaVar) && f6.c(this.f5361e.D, 100).j(zzhaVar)) {
            return this.f5362j.S(this.f5361e).m0();
        }
        this.f5362j.d().v().a("Analytics storage consent denied. Returning null app instance id");
        return null;
    }
}
