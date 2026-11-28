package u1;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class m0 extends c2.b implements n0 {
    public m0() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    public static n0 Z(IBinder iBinder) {
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        return iInterfaceQueryLocalInterface instanceof n0 ? (n0) iInterfaceQueryLocalInterface : new l0(iBinder);
    }

    @Override // c2.b
    public final boolean Y(int i10, Parcel parcel, Parcel parcel2, int i11) {
        if (i10 == 1) {
            z1.a aVarC = c();
            parcel2.writeNoException();
            c2.c.e(parcel2, aVarC);
        } else {
            if (i10 != 2) {
                return false;
            }
            int iB = b();
            parcel2.writeNoException();
            parcel2.writeInt(iB);
        }
        return true;
    }
}
