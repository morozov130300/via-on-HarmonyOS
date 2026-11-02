package y1;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public interface a extends IInterface {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: y1.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0155a extends b2.b implements a {
        public AbstractBinderC0155a() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static a Z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return iInterfaceQueryLocalInterface instanceof a ? (a) iInterfaceQueryLocalInterface : new c(iBinder);
        }
    }
}
