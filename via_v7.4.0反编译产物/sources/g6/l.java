package g6;

import android.content.Context;
import android.os.Build;
import java.util.Locale;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class l {
    public static Locale a(Context context) {
        return context == null ? Locale.getDefault() : Build.VERSION.SDK_INT >= 24 ? context.getResources().getConfiguration().getLocales().get(0) : context.getResources().getConfiguration().locale;
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
        return v.b.a(locale) == 1;
    }
}
