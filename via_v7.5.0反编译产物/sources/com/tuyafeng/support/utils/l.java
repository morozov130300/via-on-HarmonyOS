package com.tuyafeng.support.utils;

import android.content.Context;
import android.os.Build;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class l {
    public static Locale a(Context context) {
        if (context == null) {
            return Locale.getDefault();
        }
        return Build.VERSION.SDK_INT >= 24 ? context.getResources().getConfiguration().getLocales().get(0) : context.getResources().getConfiguration().locale;
    }

    public static boolean b(Context context) {
        return c(a(context));
    }

    public static boolean c(Locale locale) {
        return locale != null && locale.getCountry().equals("CN");
    }

    public static boolean d(Context context) {
        return e(a(context));
    }

    public static boolean e(Locale locale) {
        return w.b.a(locale) == 1;
    }
}
