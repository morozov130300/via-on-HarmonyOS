package g2;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class r3 extends u1.a {
    public r3(Context context, Looper looper, u1.a.InterfaceC0128a interfaceC0128a, u1.a.b bVar) {
        super(context, looper, 93, interfaceC0128a, bVar, null);
    }

    @Override // u1.a
    public final /* synthetic */ IInterface d(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        return iInterfaceQueryLocalInterface instanceof l3 ? (l3) iInterfaceQueryLocalInterface : new j3(iBinder);
    }

    @Override // u1.a
    public final int n() {
        return 12451000;
    }

    @Override // u1.a
    public final String r() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }

    @Override // u1.a
    public final String s() {
        return "com.google.android.gms.measurement.START";
    }
}
