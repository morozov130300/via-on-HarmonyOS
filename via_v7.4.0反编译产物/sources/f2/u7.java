package f2;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class u7 {
    public static String a(String str, String[] strArr, String[] strArr2) {
        t1.f.h(strArr);
        t1.f.h(strArr2);
        int iMin = Math.min(strArr.length, strArr2.length);
        for (int i10 = 0; i10 < iMin; i10++) {
            String str2 = strArr[i10];
            if ((str == null && str2 == null) || (str != null && str.equals(str2))) {
                return strArr2[i10];
            }
        }
        return null;
    }

    public static String b(Context context, String str, String str2) {
        t1.f.h(context);
        Resources resources = context.getResources();
        if (TextUtils.isEmpty(str2)) {
            str2 = z4.a(context);
        }
        return z4.b("google_app_id", resources, str2);
    }
}
