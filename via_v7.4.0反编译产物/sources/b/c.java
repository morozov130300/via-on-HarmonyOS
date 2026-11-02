package b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public interface c extends IInterface {

    /* renamed from: c, reason: collision with root package name */
    public static final String f1772c = "android$support$customtabs$IEngagementSignalsCallback".replace('$', '.');

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class a extends Binder implements c {

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        /* renamed from: b.c$a$a, reason: collision with other inner class name */
        public static class C0032a implements c {

            /* renamed from: d, reason: collision with root package name */
            public IBinder f1773d;

            public C0032a(IBinder iBinder) {
                this.f1773d = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1773d;
            }
        }

        public static c Y(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(c.f1772c);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c)) ? new C0032a(iBinder) : (c) iInterfaceQueryLocalInterface;
        }
    }
}
