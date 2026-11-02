package z8;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class b {
    public static String b(Context context, Uri uri, String str, String str2) {
        return d(context, uri, c1.v(context, "content"), str, str2);
    }

    public static x6.f c(final Context context, final Uri uri, final String str, final String str2) {
        return x6.f.h(new Callable() { // from class: z8.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return b.b(context, uri, str, str2);
            }
        }).n(g7.a.c());
    }

    public static String d(Context context, Uri uri, String str, String str2, String str3) {
        String strA;
        if (uri == null || str == null || str.isEmpty() || str2 == null || str2.isEmpty() || (strA = c1.A(context, uri)) == null || strA.isEmpty()) {
            return null;
        }
        int iLastIndexOf = strA.lastIndexOf(46);
        if (iLastIndexOf >= 0) {
            str3 = strA.substring(iLastIndexOf);
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
