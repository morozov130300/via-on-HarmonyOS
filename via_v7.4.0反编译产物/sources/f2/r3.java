package f2;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import t1.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class r3 extends t1.a {
    public r3(Context context, Looper looper, a.InterfaceC0122a interfaceC0122a, a.b bVar) {
        super(context, looper, 93, interfaceC0122a, bVar, null);
    }

    @Override // t1.a
    public final /* synthetic */ IInterface d(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        return iInterfaceQueryLocalInterface instanceof l3 ? (l3) iInterfaceQueryLocalInterface : new j3(iBinder);
    }

    @Override // t1.a
    public final int n() {
        return 12451000;
    }

    @Override // t1.a
    public final String r() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }

    @Override // t1.a
    public final String s() {
        return "com.google.android.gms.measurement.START";
    }
}
