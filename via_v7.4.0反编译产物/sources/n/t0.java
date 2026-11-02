package n;

import android.app.Notification;
import android.os.Bundle;
import android.util.SparseArray;
import androidx.core.graphics.drawable.IconCompat;
import java.util.List;
import n.h;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class t0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f10107a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f10108b = new Object();

    public static SparseArray a(List list) {
        int size = list.size();
        SparseArray sparseArray = null;
        for (int i10 = 0; i10 < size; i10++) {
            Bundle bundle = (Bundle) list.get(i10);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                sparseArray.put(i10, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle b(h.a aVar) {
        Bundle bundle = new Bundle();
        IconCompat iconCompatE = aVar.e();
        bundle.putInt("icon", iconCompatE != null ? iconCompatE.h() : 0);
        bundle.putCharSequence("title", aVar.i());
        bundle.putParcelable("actionIntent", aVar.a());
        Bundle bundle2 = aVar.d() != null ? new Bundle(aVar.d()) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", d(aVar.f()));
        bundle.putBoolean("showsUserInterface", aVar.h());
        bundle.putInt("semanticAction", aVar.g());
        return bundle;
    }

    public static Bundle c(c1 c1Var) {
        new Bundle();
        throw null;
    }

    public static Bundle[] d(c1[] c1VarArr) {
        if (c1VarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[c1VarArr.length];
        for (int i10 = 0; i10 < c1VarArr.length; i10++) {
            c1 c1Var = c1VarArr[i10];
            bundleArr[i10] = c(null);
        }
        return bundleArr;
    }

    public static Bundle e(Notification.Builder builder, h.a aVar) {
        IconCompat iconCompatE = aVar.e();
        builder.addAction(iconCompatE != null ? iconCompatE.h() : 0, aVar.i(), aVar.a());
        Bundle bundle = new Bundle(aVar.d());
        if (aVar.f() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", d(aVar.f()));
        }
        if (aVar.c() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", d(aVar.c()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        return bundle;
    }
}
