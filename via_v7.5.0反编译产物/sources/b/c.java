package b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public interface c extends IInterface {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f1671c = "android$support$customtabs$IEngagementSignalsCallback".replace('$', '.');

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class a extends Binder implements c {

        /* JADX INFO: renamed from: b.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public static class C0031a implements c {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public IBinder f1672d;

            public C0031a(IBinder iBinder) {
                this.f1672d = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1672d;
            }
        }

        public static c Y(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(c.f1671c);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c)) ? new C0031a(iBinder) : (c) iInterfaceQueryLocalInterface;
        }
    }
}
