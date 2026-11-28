package u1;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c0 implements Parcelable.Creator {
    public static void a(GetServiceRequest getServiceRequest, Parcel parcel, int i10) {
        int iA = v1.a.a(parcel);
        v1.a.j(parcel, 1, getServiceRequest.f2610c);
        v1.a.j(parcel, 2, getServiceRequest.f2611e);
        v1.a.j(parcel, 3, getServiceRequest.f2612m);
        v1.a.o(parcel, 4, getServiceRequest.f2613n, false);
        v1.a.i(parcel, 5, getServiceRequest.f2614o, false);
        v1.a.q(parcel, 6, getServiceRequest.f2615p, i10, false);
        v1.a.e(parcel, 7, getServiceRequest.f2616q, false);
        v1.a.n(parcel, 8, getServiceRequest.f2617r, i10, false);
        v1.a.q(parcel, 10, getServiceRequest.f2618s, i10, false);
        v1.a.q(parcel, 11, getServiceRequest.f2619t, i10, false);
        v1.a.c(parcel, 12, getServiceRequest.f2620u);
        v1.a.j(parcel, 13, getServiceRequest.f2621v);
        v1.a.c(parcel, 14, getServiceRequest.f2622w);
        v1.a.o(parcel, 15, getServiceRequest.c(), false);
        v1.a.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iU = SafeParcelReader.u(parcel);
        Scope[] scopeArr = GetServiceRequest.f2608y;
        Bundle bundle = new Bundle();
        Feature[] featureArr = GetServiceRequest.f2609z;
        Feature[] featureArr2 = featureArr;
        String strD = null;
        IBinder iBinderO = null;
        Account account = null;
        String strD2 = null;
        int iP = 0;
        int iP2 = 0;
        int iP3 = 0;
        boolean zI = false;
        int iP4 = 0;
        boolean zI2 = false;
        while (parcel.dataPosition() < iU) {
            int iN = SafeParcelReader.n(parcel);
            switch (SafeParcelReader.h(iN)) {
                case 1:
                    iP = SafeParcelReader.p(parcel, iN);
                    break;
                case 2:
                    iP2 = SafeParcelReader.p(parcel, iN);
                    break;
                case 3:
                    iP3 = SafeParcelReader.p(parcel, iN);
                    break;
                case 4:
                    strD = SafeParcelReader.d(parcel, iN);
                    break;
                case 5:
                    iBinderO = SafeParcelReader.o(parcel, iN);
                    break;
                case 6:
                    scopeArr = (Scope[]) SafeParcelReader.f(parcel, iN, Scope.CREATOR);
                    break;
                case 7:
                    bundle = SafeParcelReader.a(parcel, iN);
                    break;
                case 8:
                    account = (Account) SafeParcelReader.c(parcel, iN, Account.CREATOR);
                    break;
                case 9:
                default:
                    SafeParcelReader.t(parcel, iN);
                    break;
                case 10:
                    featureArr = (Feature[]) SafeParcelReader.f(parcel, iN, Feature.CREATOR);
                    break;
                case 11:
                    featureArr2 = (Feature[]) SafeParcelReader.f(parcel, iN, Feature.CREATOR);
                    break;
                case 12:
                    zI = SafeParcelReader.i(parcel, iN);
                    break;
                case 13:
                    iP4 = SafeParcelReader.p(parcel, iN);
                    break;
                case 14:
                    zI2 = SafeParcelReader.i(parcel, iN);
                    break;
                case 15:
                    strD2 = SafeParcelReader.d(parcel, iN);
                    break;
            }
        }
        SafeParcelReader.g(parcel, iU);
        return new GetServiceRequest(iP, iP2, iP3, strD, iBinderO, scopeArr, bundle, account, featureArr, featureArr2, zI, iP4, zI2, strD2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new GetServiceRequest[i10];
    }
}
