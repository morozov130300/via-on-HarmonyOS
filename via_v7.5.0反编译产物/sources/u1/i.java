package u1;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class i extends t {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f12785d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bundle f12786e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ a f12787f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(a aVar, int i10, Bundle bundle) {
        super(aVar, Boolean.TRUE);
        this.f12787f = aVar;
        this.f12785d = i10;
        this.f12786e = bundle;
    }

    @Override // u1.t
    public final /* bridge */ /* synthetic */ void a(Object obj) {
        if (this.f12785d != 0) {
            this.f12787f.V(1, null);
            Bundle bundle = this.f12786e;
            f(new ConnectionResult(this.f12785d, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
        } else {
            if (g()) {
                return;
            }
            this.f12787f.V(1, null);
            f(new ConnectionResult(8, null));
        }
    }

    public abstract void f(ConnectionResult connectionResult);

    public abstract boolean g();

    @Override // u1.t
    public final void b() {
    }
}
