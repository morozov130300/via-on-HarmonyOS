package g2;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.measurement.internal.zzac;
import com.google.android.gms.measurement.internal.zzau;
import com.google.android.gms.measurement.internal.zzlk;
import com.google.android.gms.measurement.internal.zzq;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class j3 extends com.google.android.gms.internal.measurement.o0 implements l3 {
    public j3(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // g2.l3
    public final void C(zzq zzqVar) {
        Parcel parcelY = Y();
        com.google.android.gms.internal.measurement.q0.d(parcelY, zzqVar);
        a0(4, parcelY);
    }

    @Override // g2.l3
    public final List D(String str, String str2, zzq zzqVar) {
        Parcel parcelY = Y();
        parcelY.writeString(str);
        parcelY.writeString(str2);
        com.google.android.gms.internal.measurement.q0.d(parcelY, zzqVar);
        Parcel parcelZ = Z(16, parcelY);
        ArrayList arrayListCreateTypedArrayList = parcelZ.createTypedArrayList(zzac.CREATOR);
        parcelZ.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // g2.l3
    public final void G(long j10, String str, String str2, String str3) {
        Parcel parcelY = Y();
        parcelY.writeLong(j10);
        parcelY.writeString(str);
        parcelY.writeString(str2);
        parcelY.writeString(str3);
        a0(10, parcelY);
    }

    @Override // g2.l3
    public final void O(zzq zzqVar) {
        Parcel parcelY = Y();
        com.google.android.gms.internal.measurement.q0.d(parcelY, zzqVar);
        a0(20, parcelY);
    }

    @Override // g2.l3
    public final List P(String str, String str2, boolean z10, zzq zzqVar) {
        Parcel parcelY = Y();
        parcelY.writeString(str);
        parcelY.writeString(str2);
        ClassLoader classLoader = com.google.android.gms.internal.measurement.q0.f2995a;
        parcelY.writeInt(z10 ? 1 : 0);
        com.google.android.gms.internal.measurement.q0.d(parcelY, zzqVar);
        Parcel parcelZ = Z(14, parcelY);
        ArrayList arrayListCreateTypedArrayList = parcelZ.createTypedArrayList(zzlk.CREATOR);
        parcelZ.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // g2.l3
    public final void R(zzq zzqVar) {
        Parcel parcelY = Y();
        com.google.android.gms.internal.measurement.q0.d(parcelY, zzqVar);
        a0(18, parcelY);
    }

    @Override // g2.l3
    public final void S(zzac zzacVar, zzq zzqVar) {
        Parcel parcelY = Y();
        com.google.android.gms.internal.measurement.q0.d(parcelY, zzacVar);
        com.google.android.gms.internal.measurement.q0.d(parcelY, zzqVar);
        a0(12, parcelY);
    }

    @Override // g2.l3
    public final byte[] V(zzau zzauVar, String str) {
        Parcel parcelY = Y();
        com.google.android.gms.internal.measurement.q0.d(parcelY, zzauVar);
        parcelY.writeString(str);
        Parcel parcelZ = Z(9, parcelY);
        byte[] bArrCreateByteArray = parcelZ.createByteArray();
        parcelZ.recycle();
        return bArrCreateByteArray;
    }

    @Override // g2.l3
    public final void W(zzlk zzlkVar, zzq zzqVar) {
        Parcel parcelY = Y();
        com.google.android.gms.internal.measurement.q0.d(parcelY, zzlkVar);
        com.google.android.gms.internal.measurement.q0.d(parcelY, zzqVar);
        a0(2, parcelY);
    }

    @Override // g2.l3
    public final void e(zzq zzqVar) {
        Parcel parcelY = Y();
        com.google.android.gms.internal.measurement.q0.d(parcelY, zzqVar);
        a0(6, parcelY);
    }

    @Override // g2.l3
    public final void i(Bundle bundle, zzq zzqVar) {
        Parcel parcelY = Y();
        com.google.android.gms.internal.measurement.q0.d(parcelY, bundle);
        com.google.android.gms.internal.measurement.q0.d(parcelY, zzqVar);
        a0(19, parcelY);
    }

    @Override // g2.l3
    public final List j(String str, String str2, String str3, boolean z10) {
        Parcel parcelY = Y();
        parcelY.writeString(null);
        parcelY.writeString(str2);
        parcelY.writeString(str3);
        ClassLoader classLoader = com.google.android.gms.internal.measurement.q0.f2995a;
        parcelY.writeInt(z10 ? 1 : 0);
        Parcel parcelZ = Z(15, parcelY);
        ArrayList arrayListCreateTypedArrayList = parcelZ.createTypedArrayList(zzlk.CREATOR);
        parcelZ.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // g2.l3
    public final String o(zzq zzqVar) {
        Parcel parcelY = Y();
        com.google.android.gms.internal.measurement.q0.d(parcelY, zzqVar);
        Parcel parcelZ = Z(11, parcelY);
        String string = parcelZ.readString();
        parcelZ.recycle();
        return string;
    }

    @Override // g2.l3
    public final void p(zzau zzauVar, zzq zzqVar) {
        Parcel parcelY = Y();
        com.google.android.gms.internal.measurement.q0.d(parcelY, zzauVar);
        com.google.android.gms.internal.measurement.q0.d(parcelY, zzqVar);
        a0(1, parcelY);
    }

    @Override // g2.l3
    public final List q(String str, String str2, String str3) {
        Parcel parcelY = Y();
        parcelY.writeString(null);
        parcelY.writeString(str2);
        parcelY.writeString(str3);
        Parcel parcelZ = Z(17, parcelY);
        ArrayList arrayListCreateTypedArrayList = parcelZ.createTypedArrayList(zzac.CREATOR);
        parcelZ.recycle();
        return arrayListCreateTypedArrayList;
    }
}
