package i4;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f6241a;

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
        if (f6241a == null) {
            String strD = d(context);
            if (strD == null) {
                strD = c(context);
            }
            f6241a = strD;
        }
        return f6241a;
    }

    public static String c(Context context) {
        String strA = j4.a.a(new File(a(context)));
        Log.i("ChannelReaderUtil", "getChannelByV1 , channel = " + strA);
        return strA;
    }

    public static String d(Context context) {
        String strB = j4.a.b(new File(a(context)));
        Log.i("ChannelReaderUtil", "getChannelByV2 , channel = " + strB);
        return strB;
    }
}
