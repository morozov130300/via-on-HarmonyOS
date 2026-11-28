package g2;

import com.google.android.gms.measurement.internal.zzha;
import com.google.android.gms.measurement.internal.zzq;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class ia implements Callable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzq f4977c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ pa f4978e;

    public ia(pa paVar, zzq zzqVar) {
        this.f4978e = paVar;
        this.f4977c = zzqVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        f6 f6VarC0 = this.f4978e.c0((String) u1.f.h(this.f4977c.f3275c));
        zzha zzhaVar = zzha.ANALYTICS_STORAGE;
        if (f6VarC0.j(zzhaVar) && f6.c(this.f4977c.F, 100).j(zzhaVar)) {
            return this.f4978e.S(this.f4977c).m0();
        }
        this.f4978e.d().v().a("Analytics storage consent denied. Returning null app instance id");
        return null;
    }
}
