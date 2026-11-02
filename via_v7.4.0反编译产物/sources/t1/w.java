package t1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class w extends i {

    /* renamed from: g, reason: collision with root package name */
    public final IBinder f12079g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ a f12080h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(a aVar, int i10, IBinder iBinder, Bundle bundle) {
        super(aVar, i10, bundle);
        this.f12080h = aVar;
        this.f12079g = iBinder;
    }

    @Override // t1.i
    public final void f(ConnectionResult connectionResult) {
        if (this.f12080h.f12020v != null) {
            this.f12080h.f12020v.b(connectionResult);
        }
        this.f12080h.y(connectionResult);
    }

    @Override // t1.i
    public final boolean g() throws RemoteException {
        try {
            IBinder iBinder = this.f12079g;
            f.h(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            if (!this.f12080h.r().equals(interfaceDescriptor)) {
                Log.w("GmsClient", "service descriptor mismatch: " + this.f12080h.r() + " vs. " + interfaceDescriptor);
                return false;
            }
            IInterface iInterfaceD = this.f12080h.d(this.f12079g);
            if (iInterfaceD == null || !(a.T(this.f12080h, 2, 4, iInterfaceD) || a.T(this.f12080h, 3, 4, iInterfaceD))) {
                return false;
            }
            this.f12080h.f12024z = null;
            Bundle bundleJ = this.f12080h.j();
            a aVar = this.f12080h;
            if (aVar.f12019u == null) {
                return true;
            }
            aVar.f12019u.c(bundleJ);
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
