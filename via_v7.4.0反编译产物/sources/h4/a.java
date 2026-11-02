package h4;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import java.io.File;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f6372a;

    public static String a(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                return null;
            }
            return applicationInfo.sourceDir;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String b(Context context) {
        if (f6372a == null) {
            String strD = d(context);
            if (strD == null) {
                strD = c(context);
            }
            f6372a = strD;
        }
        return f6372a;
    }

    public static String c(Context context) {
        String strA = i4.a.a(new File(a(context)));
        Log.i("ChannelReaderUtil", "getChannelByV1 , channel = " + strA);
        return strA;
    }

    public static String d(Context context) {
        String strB = i4.a.b(new File(a(context)));
        Log.i("ChannelReaderUtil", "getChannelByV2 , channel = " + strB);
        return strB;
    }
}
