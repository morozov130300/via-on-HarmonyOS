package a2;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d extends a implements f {
    public d(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    @Override // a2.f
    public final String b() {
        Parcel parcelZ = Z(1, Y());
        String string = parcelZ.readString();
        parcelZ.recycle();
        return string;
    }

    @Override // a2.f
    public final boolean n(boolean z10) {
        Parcel parcelY = Y();
        c.a(parcelY, true);
        Parcel parcelZ = Z(2, parcelY);
        boolean zB = c.b(parcelZ);
        parcelZ.recycle();
        return zB;
    }
}
