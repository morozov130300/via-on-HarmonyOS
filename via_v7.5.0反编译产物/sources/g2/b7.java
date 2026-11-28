package g2;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.xd;
import com.google.android.gms.measurement.internal.zzha;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b7 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.k1 f4671c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ o7 f4672e;

    public b7(o7 o7Var, com.google.android.gms.internal.measurement.k1 k1Var) {
        this.f4672e = o7Var;
        this.f4671c = k1Var;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0089  */
    /* JADX WARN: Code duplicated, block: B:23:0x009b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    public final void run() {
        Long lValueOf;
        u9 u9VarM = this.f4672e.f4646a.M();
        xd.b();
        if (!u9VarM.f4646a.z().B(null, i3.f4956w0)) {
            u9VarM.f4646a.d().x().a("getSessionId has been disabled.");
        } else {
            if (u9VarM.f4646a.F().q().j(zzha.ANALYTICS_STORAGE)) {
                if (!u9VarM.f4646a.F().v(u9VarM.f4646a.a().a()) && u9VarM.f4646a.F().f5058p.a() != 0) {
                    lValueOf = Long.valueOf(u9VarM.f4646a.F().f5058p.a());
                }
                if (lValueOf != null) {
                    this.f4672e.f4646a.N().J(this.f4671c, lValueOf.longValue());
                }
                try {
                    this.f4671c.v(null);
                } catch (RemoteException e10) {
                    this.f4672e.f4646a.d().r().b("getSessionId failed with exception", e10);
                    return;
                }
            }
            u9VarM.f4646a.d().x().a("Analytics storage consent denied; will not get session id");
        }
        lValueOf = null;
        if (lValueOf != null) {
            this.f4672e.f4646a.N().J(this.f4671c, lValueOf.longValue());
        } else {
            this.f4671c.v(null);
        }
    }
}
