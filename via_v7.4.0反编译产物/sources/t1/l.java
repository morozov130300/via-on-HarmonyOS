package t1;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.zzo;
import com.google.android.gms.common.zzq;
import com.google.android.gms.common.zzs;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class l extends b2.a implements n {
    public l(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // t1.n
    public final zzq A(zzo zzoVar) {
        Parcel parcelZ = Z();
        b2.c.d(parcelZ, zzoVar);
        Parcel parcelY = Y(6, parcelZ);
        zzq zzqVar = (zzq) b2.c.a(parcelY, zzq.CREATOR);
        parcelY.recycle();
        return zzqVar;
    }

    @Override // t1.n
    public final zzq I(zzo zzoVar) {
        Parcel parcelZ = Z();
        b2.c.d(parcelZ, zzoVar);
        Parcel parcelY = Y(8, parcelZ);
        zzq zzqVar = (zzq) b2.c.a(parcelY, zzq.CREATOR);
        parcelY.recycle();
        return zzqVar;
    }

    @Override // t1.n
    public final boolean M(zzs zzsVar, y1.a aVar) {
        Parcel parcelZ = Z();
        b2.c.d(parcelZ, zzsVar);
        b2.c.e(parcelZ, aVar);
        Parcel parcelY = Y(5, parcelZ);
        boolean zF = b2.c.f(parcelY);
        parcelY.recycle();
        return zF;
    }

    @Override // t1.n
    public final boolean f() {
        Parcel parcelY = Y(7, Z());
        boolean zF = b2.c.f(parcelY);
        parcelY.recycle();
        return zF;
    }
}
