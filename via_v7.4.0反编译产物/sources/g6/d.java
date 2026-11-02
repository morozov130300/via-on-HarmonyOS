package g6;

import android.os.Build;
import android.os.Bundle;
import java.util.ArrayList;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class d {
    public static Object a(Bundle bundle, String str, Class cls) {
        if (bundle == null || str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 33) {
            return bundle.getParcelable(str);
        }
        if (cls == null) {
            return null;
        }
        return bundle.getParcelable(str, cls);
    }

    public static ArrayList b(Bundle bundle, String str, Class cls) {
        if (bundle == null || str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 33) {
            return bundle.getParcelableArrayList(str);
        }
        if (cls == null) {
            return null;
        }
        return bundle.getParcelableArrayList(str, cls);
    }
}
