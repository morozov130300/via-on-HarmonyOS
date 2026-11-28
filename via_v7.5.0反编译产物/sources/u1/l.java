package u1;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.zzo;
import com.google.android.gms.common.zzq;
import com.google.android.gms.common.zzs;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class l extends c2.a implements n {
    public l(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // u1.n
    public final zzq H(zzo zzoVar) {
        Parcel parcelZ = Z();
        c2.c.d(parcelZ, zzoVar);
        Parcel parcelY = Y(8, parcelZ);
        zzq zzqVar = (zzq) c2.c.a(parcelY, zzq.CREATOR);
        parcelY.recycle();
        return zzqVar;
    }

    @Override // u1.n
    public final boolean T(zzs zzsVar, z1.a aVar) {
        Parcel parcelZ = Z();
        c2.c.d(parcelZ, zzsVar);
        c2.c.e(parcelZ, aVar);
        Parcel parcelY = Y(5, parcelZ);
        boolean zF = c2.c.f(parcelY);
        parcelY.recycle();
        return zF;
    }

    @Override // u1.n
    public final boolean f() {
        Parcel parcelY = Y(7, Z());
        boolean zF = c2.c.f(parcelY);
        parcelY.recycle();
        return zF;
    }

    @Override // u1.n
    public final zzq z(zzo zzoVar) {
        Parcel parcelZ = Z();
        c2.c.d(parcelZ, zzoVar);
        Parcel parcelY = Y(6, parcelZ);
        zzq zzqVar = (zzq) c2.c.a(parcelY, zzq.CREATOR);
        parcelY.recycle();
        return zzqVar;
    }
}
