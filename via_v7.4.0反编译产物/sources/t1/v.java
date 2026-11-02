package t1;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class v implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final int f12077a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f12078b;

    public v(a aVar, int i10) {
        this.f12078b = aVar;
        this.f12077a = i10;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        a aVar = this.f12078b;
        if (iBinder == null) {
            a.Q(aVar, 16);
            return;
        }
        synchronized (aVar.f12012n) {
            try {
                a aVar2 = this.f12078b;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                aVar2.f12013o = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof d)) ? new k(iBinder) : (d) iInterfaceQueryLocalInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f12078b.R(0, null, this.f12077a);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f12078b.f12012n) {
            this.f12078b.f12013o = null;
        }
        Handler handler = this.f12078b.f12010l;
        handler.sendMessage(handler.obtainMessage(6, this.f12077a, 1));
    }
}
