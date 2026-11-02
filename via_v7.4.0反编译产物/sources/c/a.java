package c;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public interface a extends IInterface {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: c.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0035a extends Binder implements a {

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        /* renamed from: c.a$a$a, reason: collision with other inner class name */
        public static class C0036a implements a {

            /* renamed from: e, reason: collision with root package name */
            public static a f2165e;

            /* renamed from: d, reason: collision with root package name */
            public IBinder f2166d;

            public C0036a(IBinder iBinder) {
                this.f2166d = iBinder;
            }

            @Override // c.a
            public void K(String str, int i10, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str2);
                    if (this.f2166d.transact(2, parcelObtain, null, 1) || AbstractBinderC0035a.Z() == null) {
                        return;
                    }
                    AbstractBinderC0035a.Z().K(str, i10, str2);
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
                    if (this.f2166d.transact(1, parcelObtain, null, 1) || AbstractBinderC0035a.Z() == null) {
                        parcelObtain.recycle();
                    } else {
                        AbstractBinderC0035a.Z().U(str, i10, str2, notification);
                        parcelObtain.recycle();
                    }
                } catch (Throwable th) {
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2166d;
            }

            @Override // c.a
            public void r(String str) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    parcelObtain.writeString(str);
                    if (this.f2166d.transact(3, parcelObtain, null, 1) || AbstractBinderC0035a.Z() == null) {
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
            return C0036a.f2165e;
        }
    }

    void K(String str, int i10, String str2);

    void U(String str, int i10, String str2, Notification notification);

    void r(String str);
}
