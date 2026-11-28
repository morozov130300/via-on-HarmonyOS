package u1;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class v implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f12811b;

    public v(a aVar, int i10) {
        this.f12811b = aVar;
        this.f12810a = i10;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        a aVar = this.f12811b;
        if (iBinder == null) {
            a.Q(aVar, 16);
            return;
        }
        synchronized (aVar.f12745n) {
            try {
                a aVar2 = this.f12811b;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                aVar2.f12746o = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof d)) ? new k(iBinder) : (d) iInterfaceQueryLocalInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f12811b.R(0, null, this.f12810a);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f12811b.f12745n) {
            this.f12811b.f12746o = null;
        }
        Handler handler = this.f12811b.f12743l;
        handler.sendMessage(handler.obtainMessage(6, this.f12810a, 1));
    }
}
