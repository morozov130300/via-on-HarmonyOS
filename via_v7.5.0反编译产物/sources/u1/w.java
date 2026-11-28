package u1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class w extends i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IBinder f12812g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ a f12813h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(a aVar, int i10, IBinder iBinder, Bundle bundle) {
        super(aVar, i10, bundle);
        this.f12813h = aVar;
        this.f12812g = iBinder;
    }

    @Override // u1.i
    public final void f(ConnectionResult connectionResult) {
        if (this.f12813h.f12753v != null) {
            this.f12813h.f12753v.b(connectionResult);
        }
        this.f12813h.y(connectionResult);
    }

    @Override // u1.i
    public final boolean g() {
        try {
            IBinder iBinder = this.f12812g;
            f.h(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            if (!this.f12813h.r().equals(interfaceDescriptor)) {
                Log.w("GmsClient", "service descriptor mismatch: " + this.f12813h.r() + " vs. " + interfaceDescriptor);
                return false;
            }
            IInterface iInterfaceD = this.f12813h.d(this.f12812g);
            if (iInterfaceD == null || !(a.T(this.f12813h, 2, 4, iInterfaceD) || a.T(this.f12813h, 3, 4, iInterfaceD))) {
                return false;
            }
            this.f12813h.f12757z = null;
            Bundle bundleJ = this.f12813h.j();
            a aVar = this.f12813h;
            if (aVar.f12752u == null) {
                return true;
            }
            aVar.f12752u.c(bundleJ);
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
