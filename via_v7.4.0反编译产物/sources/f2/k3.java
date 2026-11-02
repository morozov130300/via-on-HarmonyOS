package f2;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.measurement.internal.zzac;
import com.google.android.gms.measurement.internal.zzau;
import com.google.android.gms.measurement.internal.zzlk;
import com.google.android.gms.measurement.internal.zzq;
import java.util.List;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class k3 extends com.google.android.gms.internal.measurement.p0 implements l3 {
    public k3() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.internal.measurement.p0
    public final boolean Y(int i10, Parcel parcel, Parcel parcel2, int i11) {
        switch (i10) {
            case 1:
                zzau zzauVar = (zzau) com.google.android.gms.internal.measurement.q0.a(parcel, zzau.CREATOR);
                zzq zzqVar = (zzq) com.google.android.gms.internal.measurement.q0.a(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.q0.c(parcel);
                p(zzauVar, zzqVar);
                parcel2.writeNoException();
                return true;
            case 2:
                zzlk zzlkVar = (zzlk) com.google.android.gms.internal.measurement.q0.a(parcel, zzlk.CREATOR);
                zzq zzqVar2 = (zzq) com.google.android.gms.internal.measurement.q0.a(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.q0.c(parcel);
                W(zzlkVar, zzqVar2);
                parcel2.writeNoException();
                return true;
            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
            case 8:
            default:
                return false;
            case 4:
                zzq zzqVar3 = (zzq) com.google.android.gms.internal.measurement.q0.a(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.q0.c(parcel);
                D(zzqVar3);
                parcel2.writeNoException();
                return true;
            case 5:
                zzau zzauVar2 = (zzau) com.google.android.gms.internal.measurement.q0.a(parcel, zzau.CREATOR);
                String string = parcel.readString();
                String string2 = parcel.readString();
                com.google.android.gms.internal.measurement.q0.c(parcel);
                g(zzauVar2, string, string2);
                parcel2.writeNoException();
                return true;
            case 6:
                zzq zzqVar4 = (zzq) com.google.android.gms.internal.measurement.q0.a(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.q0.c(parcel);
                e(zzqVar4);
                parcel2.writeNoException();
                return true;
            case 7:
                zzq zzqVar5 = (zzq) com.google.android.gms.internal.measurement.q0.a(parcel, zzq.CREATOR);
                boolean zF = com.google.android.gms.internal.measurement.q0.f(parcel);
                com.google.android.gms.internal.measurement.q0.c(parcel);
                List listM = m(zzqVar5, zF);
                parcel2.writeNoException();
                parcel2.writeTypedList(listM);
                return true;
            case 9:
                zzau zzauVar3 = (zzau) com.google.android.gms.internal.measurement.q0.a(parcel, zzau.CREATOR);
                String string3 = parcel.readString();
                com.google.android.gms.internal.measurement.q0.c(parcel);
                byte[] bArrV = V(zzauVar3, string3);
                parcel2.writeNoException();
                parcel2.writeByteArray(bArrV);
                return true;
            case 10:
                long j10 = parcel.readLong();
                String string4 = parcel.readString();
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                com.google.android.gms.internal.measurement.q0.c(parcel);
                H(j10, string4, string5, string6);
                parcel2.writeNoException();
                return true;
            case 11:
                zzq zzqVar6 = (zzq) com.google.android.gms.internal.measurement.q0.a(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.q0.c(parcel);
                String strO = o(zzqVar6);
                parcel2.writeNoException();
                parcel2.writeString(strO);
                break;
            case 12:
                zzac zzacVar = (zzac) com.google.android.gms.internal.measurement.q0.a(parcel, zzac.CREATOR);
                zzq zzqVar7 = (zzq) com.google.android.gms.internal.measurement.q0.a(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.q0.c(parcel);
                T(zzacVar, zzqVar7);
                parcel2.writeNoException();
                break;
            case 13:
                zzac zzacVar2 = (zzac) com.google.android.gms.internal.measurement.q0.a(parcel, zzac.CREATOR);
                com.google.android.gms.internal.measurement.q0.c(parcel);
                l(zzacVar2);
                parcel2.writeNoException();
                break;
            case 14:
                String string7 = parcel.readString();
                String string8 = parcel.readString();
                boolean zF2 = com.google.android.gms.internal.measurement.q0.f(parcel);
                zzq zzqVar8 = (zzq) com.google.android.gms.internal.measurement.q0.a(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.q0.c(parcel);
                List listQ = Q(string7, string8, zF2, zzqVar8);
                parcel2.writeNoException();
                parcel2.writeTypedList(listQ);
                break;
            case 15:
                String string9 = parcel.readString();
                String string10 = parcel.readString();
                String string11 = parcel.readString();
                boolean zF3 = com.google.android.gms.internal.measurement.q0.f(parcel);
                com.google.android.gms.internal.measurement.q0.c(parcel);
                List listJ = j(string9, string10, string11, zF3);
                parcel2.writeNoException();
                parcel2.writeTypedList(listJ);
                break;
            case 16:
                String string12 = parcel.readString();
                String string13 = parcel.readString();
                zzq zzqVar9 = (zzq) com.google.android.gms.internal.measurement.q0.a(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.q0.c(parcel);
                List listE = E(string12, string13, zzqVar9);
                parcel2.writeNoException();
                parcel2.writeTypedList(listE);
                break;
            case 17:
                String string14 = parcel.readString();
                String string15 = parcel.readString();
                String string16 = parcel.readString();
                com.google.android.gms.internal.measurement.q0.c(parcel);
                List listQ2 = q(string14, string15, string16);
                parcel2.writeNoException();
                parcel2.writeTypedList(listQ2);
                break;
            case 18:
                zzq zzqVar10 = (zzq) com.google.android.gms.internal.measurement.q0.a(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.q0.c(parcel);
                S(zzqVar10);
                parcel2.writeNoException();
                break;
            case 19:
                Bundle bundle = (Bundle) com.google.android.gms.internal.measurement.q0.a(parcel, Bundle.CREATOR);
                zzq zzqVar11 = (zzq) com.google.android.gms.internal.measurement.q0.a(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.q0.c(parcel);
                i(bundle, zzqVar11);
                parcel2.writeNoException();
                break;
            case 20:
                zzq zzqVar12 = (zzq) com.google.android.gms.internal.measurement.q0.a(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.q0.c(parcel);
                P(zzqVar12);
                parcel2.writeNoException();
                break;
        }
        return true;
    }
}
