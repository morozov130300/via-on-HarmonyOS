package x8;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static String b(Context context, Uri uri, String str, String str2) {
        return d(context, uri, c1.x(context, "content"), str, str2);
    }

    public static r6.f c(final Context context, final Uri uri, final String str, final String str2) {
        return r6.f.h(new Callable() { // from class: x8.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return b.b(context, uri, str, str2);
            }
        }).n(a7.a.c());
    }

    public static String d(Context context, Uri uri, String str, String str2, String str3) {
        String strC;
        if (uri == null || str == null || str.isEmpty() || str2 == null || str2.isEmpty() || (strC = c1.C(context, uri)) == null || strC.isEmpty()) {
            return null;
        }
        int iLastIndexOf = strC.lastIndexOf(46);
        if (iLastIndexOf >= 0) {
            str3 = strC.substring(iLastIndexOf);
        }
        if (str3 == null) {
            str3 = "";
        }
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            return null;
        }
        if (file.isFile() && !file.delete()) {
            return null;
        }
        return c1.b(context, uri, new File(file, str2 + str3));
    }
}
