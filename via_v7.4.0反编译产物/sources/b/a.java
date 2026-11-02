package b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public interface a extends IInterface {

    /* renamed from: a, reason: collision with root package name */
    public static final String f1769a = "android$support$customtabs$ICustomTabsCallback".replace('$', '.');

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: b.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0029a extends Binder implements a {

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        /* renamed from: b.a$a$a, reason: collision with other inner class name */
        public static class C0030a implements a {

            /* renamed from: d, reason: collision with root package name */
            public IBinder f1770d;

            public C0030a(IBinder iBinder) {
                this.f1770d = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1770d;
            }
        }

        public static a Y(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a.f1769a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0030a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }
    }
}
