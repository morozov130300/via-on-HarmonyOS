package u1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzj;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class j extends c2.b implements c {
    public j() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // c2.b
    public final boolean Y(int i10, Parcel parcel, Parcel parcel2, int i11) {
        if (i10 == 1) {
            int i12 = parcel.readInt();
            IBinder strongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) c2.c.a(parcel, Bundle.CREATOR);
            c2.c.b(parcel);
            E(i12, strongBinder, bundle);
        } else if (i10 == 2) {
            int i13 = parcel.readInt();
            Bundle bundle2 = (Bundle) c2.c.a(parcel, Bundle.CREATOR);
            c2.c.b(parcel);
            s(i13, bundle2);
        } else {
            if (i10 != 3) {
                return false;
            }
            int i14 = parcel.readInt();
            IBinder strongBinder2 = parcel.readStrongBinder();
            zzj zzjVar = (zzj) c2.c.a(parcel, zzj.CREATOR);
            c2.c.b(parcel);
            I(i14, strongBinder2, zzjVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
