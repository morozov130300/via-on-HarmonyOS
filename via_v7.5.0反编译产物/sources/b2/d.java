package b2;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d extends a implements f {
    public d(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    @Override // b2.f
    public final String b() {
        Parcel parcelZ = Z(1, Y());
        String string = parcelZ.readString();
        parcelZ.recycle();
        return string;
    }

    @Override // b2.f
    public final boolean n(boolean z10) {
        Parcel parcelY = Y();
        c.a(parcelY, true);
        Parcel parcelZ = Z(2, parcelY);
        boolean zB = c.b(parcelZ);
        parcelZ.recycle();
        return zB;
    }
}
