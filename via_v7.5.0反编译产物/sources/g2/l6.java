package g2;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class l6 implements p3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h5 f5071a;

    public l6(m6 m6Var, h5 h5Var) {
        this.f5071a = h5Var;
    }

    @Override // g2.p3
    public final boolean zza() {
        return this.f5071a.q() && Log.isLoggable(this.f5071a.d().D(), 3);
    }
}
