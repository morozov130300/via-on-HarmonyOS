package u1;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.internal.zzj;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class u extends j {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f12808d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f12809e;

    public u(a aVar, int i10) {
        this.f12808d = aVar;
        this.f12809e = i10;
    }

    @Override // u1.c
    public final void E(int i10, IBinder iBinder, Bundle bundle) {
        f.i(this.f12808d, "onPostInitComplete can be called only once per call to getRemoteService");
        this.f12808d.A(i10, iBinder, bundle, this.f12809e);
        this.f12808d = null;
    }

    @Override // u1.c
    public final void I(int i10, IBinder iBinder, zzj zzjVar) {
        a aVar = this.f12808d;
        f.i(aVar, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        f.h(zzjVar);
        a.P(aVar, zzjVar);
        E(i10, iBinder, zzjVar.f2630c);
    }

    @Override // u1.c
    public final void s(int i10, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }
}
