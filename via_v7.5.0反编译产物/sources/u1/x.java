package u1;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class x extends i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ a f12814g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(a aVar, int i10, Bundle bundle) {
        super(aVar, i10, null);
        this.f12814g = aVar;
    }

    @Override // u1.i
    public final void f(ConnectionResult connectionResult) {
        if (this.f12814g.f() && a.U(this.f12814g)) {
            a.Q(this.f12814g, 16);
        } else {
            this.f12814g.f12747p.a(connectionResult);
            this.f12814g.y(connectionResult);
        }
    }

    @Override // u1.i
    public final boolean g() {
        this.f12814g.f12747p.a(ConnectionResult.f2577o);
        return true;
    }
}
