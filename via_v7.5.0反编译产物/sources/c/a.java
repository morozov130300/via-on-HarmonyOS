package c;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class AbstractBinderC0035a extends Binder implements a {

        /* JADX INFO: renamed from: c.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public static class C0036a implements a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static a f1902e;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public IBinder f1903d;

            public C0036a(IBinder iBinder) {
                this.f1903d = iBinder;
            }

            @Override // c.a
            public void J(String str, int i10, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str2);
                    if (this.f1903d.transact(2, parcelObtain, null, 1) || AbstractBinderC0035a.Z() == null) {
                        return;
                    }
                    AbstractBinderC0035a.Z().J(str, i10, str2);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // c.a
            public void U(String str, int i10, String str2, Notification notification) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str2);
                    if (notification != null) {
                        parcelObtain.writeInt(1);
                        notification.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f1903d.transact(1, parcelObtain, null, 1) || AbstractBinderC0035a.Z() == null) {
                        return;
                    }
                    AbstractBinderC0035a.Z().U(str, i10, str2, notification);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1903d;
            }

            @Override // c.a
            public void r(String str) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    parcelObtain.writeString(str);
                    if (this.f1903d.transact(3, parcelObtain, null, 1) || AbstractBinderC0035a.Z() == null) {
                        return;
                    }
                    AbstractBinderC0035a.Z().r(str);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public static a Y(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0036a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static a Z() {
            return C0036a.f1902e;
        }
    }

    void J(String str, int i10, String str2);

    void U(String str, int i10, String str2, Notification notification);

    void r(String str);
}
