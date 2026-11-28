package b;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public interface b extends IInterface {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f1670b = "android$support$customtabs$ICustomTabsService".replace('$', '.');

    /* JADX INFO: renamed from: b.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class C0030b {
        public static Object c(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        public static void d(Parcel parcel, Parcelable parcelable, int i10) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, i10);
            }
        }
    }

    boolean A(b.a aVar);

    boolean B(b.a aVar, IBinder iBinder, Bundle bundle);

    boolean F(b.a aVar, Uri uri);

    boolean K(b.a aVar, Bundle bundle);

    boolean L(b.a aVar, int i10, Uri uri, Bundle bundle);

    boolean M(b.a aVar, Bundle bundle);

    boolean Q(b.a aVar, Bundle bundle);

    boolean h(b.a aVar, Uri uri, Bundle bundle);

    int k(b.a aVar, String str, Bundle bundle);

    Bundle t(String str, Bundle bundle);

    boolean u(b.a aVar, Uri uri, Bundle bundle, List list);

    boolean w(b.a aVar, Uri uri, int i10, Bundle bundle);

    boolean y(long j10);

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class a extends Binder implements b {
        public a() {
            attachInterface(this, b.f1670b);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            String str = b.f1670b;
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            switch (i10) {
                case 2:
                    boolean zY = y(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zY ? 1 : 0);
                    return true;
                case 3:
                    boolean zA = A(b.a.AbstractBinderC0028a.Y(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(zA ? 1 : 0);
                    return true;
                case 4:
                    b.a aVarY = b.a.AbstractBinderC0028a.Y(parcel.readStrongBinder());
                    Uri uri = (Uri) C0030b.c(parcel, Uri.CREATOR);
                    Parcelable.Creator creator = Bundle.CREATOR;
                    boolean zU = u(aVarY, uri, (Bundle) C0030b.c(parcel, creator), parcel.createTypedArrayList(creator));
                    parcel2.writeNoException();
                    parcel2.writeInt(zU ? 1 : 0);
                    return true;
                case 5:
                    Bundle bundleT = t(parcel.readString(), (Bundle) C0030b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    C0030b.d(parcel2, bundleT, 1);
                    return true;
                case 6:
                    boolean zM = M(b.a.AbstractBinderC0028a.Y(parcel.readStrongBinder()), (Bundle) C0030b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zM ? 1 : 0);
                    return true;
                case 7:
                    boolean zF = F(b.a.AbstractBinderC0028a.Y(parcel.readStrongBinder()), (Uri) C0030b.c(parcel, Uri.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zF ? 1 : 0);
                    return true;
                case 8:
                    int iK = k(b.a.AbstractBinderC0028a.Y(parcel.readStrongBinder()), parcel.readString(), (Bundle) C0030b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(iK);
                    return true;
                case 9:
                    boolean zL = L(b.a.AbstractBinderC0028a.Y(parcel.readStrongBinder()), parcel.readInt(), (Uri) C0030b.c(parcel, Uri.CREATOR), (Bundle) C0030b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zL ? 1 : 0);
                    return true;
                case 10:
                    boolean zQ = Q(b.a.AbstractBinderC0028a.Y(parcel.readStrongBinder()), (Bundle) C0030b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zQ ? 1 : 0);
                    return true;
                case 11:
                    boolean zH = h(b.a.AbstractBinderC0028a.Y(parcel.readStrongBinder()), (Uri) C0030b.c(parcel, Uri.CREATOR), (Bundle) C0030b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zH ? 1 : 0);
                    return true;
                case 12:
                    boolean zW = w(b.a.AbstractBinderC0028a.Y(parcel.readStrongBinder()), (Uri) C0030b.c(parcel, Uri.CREATOR), parcel.readInt(), (Bundle) C0030b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zW ? 1 : 0);
                    return true;
                case 13:
                    boolean zK = K(b.a.AbstractBinderC0028a.Y(parcel.readStrongBinder()), (Bundle) C0030b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zK ? 1 : 0);
                    return true;
                case 14:
                    boolean zB = B(b.a.AbstractBinderC0028a.Y(parcel.readStrongBinder()), parcel.readStrongBinder(), (Bundle) C0030b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zB ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
