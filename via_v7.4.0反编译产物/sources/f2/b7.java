package f2;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.xd;
import com.google.android.gms.measurement.internal.zzha;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b7 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.k1 f5055e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ o7 f5056j;

    public b7(o7 o7Var, com.google.android.gms.internal.measurement.k1 k1Var) {
        this.f5056j = o7Var;
        this.f5055e = k1Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        Long lValueOf;
        u9 u9VarM = this.f5056j.f5030a.M();
        xd.b();
        if (!u9VarM.f5030a.z().B(null, i3.f5340w0)) {
            u9VarM.f5030a.d().x().a("getSessionId has been disabled.");
        } else {
            if (u9VarM.f5030a.F().q().j(zzha.ANALYTICS_STORAGE)) {
                if (!u9VarM.f5030a.F().v(u9VarM.f5030a.a().a()) && u9VarM.f5030a.F().f5442p.a() != 0) {
                    lValueOf = Long.valueOf(u9VarM.f5030a.F().f5442p.a());
                }
                if (lValueOf == null) {
                    this.f5056j.f5030a.N().J(this.f5055e, lValueOf.longValue());
                    return;
                }
                try {
                    this.f5055e.w(null);
                    return;
                } catch (RemoteException e10) {
                    this.f5056j.f5030a.d().r().b("getSessionId failed with exception", e10);
                    return;
                }
            }
            u9VarM.f5030a.d().x().a("Analytics storage consent denied; will not get session id");
        }
        lValueOf = null;
        if (lValueOf == null) {
        }
    }
}
