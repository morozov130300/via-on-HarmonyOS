package z8;

import android.R;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.Fragment;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import mark.via.Shell;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class f {
    public static /* synthetic */ void a(Context context, View view) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:mark.via"));
        intent.setFlags(805306368);
        context.startActivity(intent);
    }

    public static String b(Context context) {
        try {
            return Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + pa.r.j().x() + "/";
        } catch (Exception unused) {
            return null;
        }
    }

    public static String c() {
        return h() ? "\u83ab\u5fe7\u4e16\u4e8b\u517c\u8eab\u4e8b\uff0c\u987b\u8457\u4eba\u95f4\u6bd4\u68a6\u95f4\u3002" : "Less is more.";
    }

    public static String d(Context context) {
        StringBuilder sb2 = new StringBuilder();
        Locale locale = Locale.getDefault();
        sb2.append(String.format("Device: %s %s(%s)\n", l0.a(), l0.d(), l0.e()));
        sb2.append(String.format("Package Name: %s\n", "mark.via"));
        sb2.append(String.format("App Version: %s(%s)\n", "7.4.0.b13.edf6737e", 20260920));
        sb2.append(String.format("Snapshot Time: %s\n", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale).format(Long.valueOf(System.currentTimeMillis()))));
        sb2.append(String.format("Supported ABIs: %s\n", l0.f()));
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        sb2.append(String.format(locale, "Display Size: %dx%d\n", Integer.valueOf(displayMetrics.heightPixels), Integer.valueOf(displayMetrics.widthPixels)));
        sb2.append(String.format(locale, "Android Version: %s API%d\n", l0.g(), Integer.valueOf(l0.f14716b)));
        sb2.append(String.format("Language: %s\n", t1.n(locale)));
        w9.r rVarO = pa.r.o();
        if (rVarO != null && rVarO.c() != null) {
            sb2.append(String.format("WebView Impl: %s\n", rVarO.c()));
            sb2.append(String.format(locale, "WebView Version: %s(%d)\n", rVarO.e(), Long.valueOf(rVarO.d())));
        }
        return sb2.toString().trim();
    }

    public static void e(View view) {
        InputMethodManager inputMethodManager;
        if (view == null || (inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void f(Activity activity) {
        t8.f.a().h(activity);
        w9.l lVarJ = pa.r.j();
        lVarJ.C2(b4.i(b4.a(activity)));
        lVarJ.m2().Z(Build.VERSION.SDK_INT >= 26 || !g6.o.d());
        lVarJ.m2().a0(b0.B(activity) != 2);
    }

    public static void g(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setComponent(null);
        intent.setSelector(null);
        intent.setData(Uri.parse("market://details?id=" + str));
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(g6.l.b(context) ? "http://coolapk.com/apk/" : "https://play.google.com/store/apps/details?id=");
            sb2.append(str);
            b0.O(context, sb2.toString());
        }
    }

    public static boolean h() {
        return "CN".equalsIgnoreCase(Locale.getDefault().getCountry());
    }

    public static boolean i(Fragment fragment, String... strArr) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (fragment.I().checkSelfPermission(str) != 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() > 0) {
            fragment.A2((String[]) arrayList.toArray(new String[0]), 111);
        }
        return arrayList.size() <= 0;
    }

    public static boolean j(Fragment fragment, int i10) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 29) {
            return true;
        }
        return i11 >= 26 ? i10 != 0 ? i10 != 1 ? i(fragment, "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE") : i(fragment, "android.permission.WRITE_EXTERNAL_STORAGE") : i(fragment, "android.permission.READ_EXTERNAL_STORAGE") : i(fragment, "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    public static void k(Context context) {
        Intent intentMakeRestartActivityTask = Intent.makeRestartActivityTask(new ComponentName(context, (Class<?>) Shell.class));
        intentMakeRestartActivityTask.setPackage(context.getPackageName());
        context.startActivity(intentMakeRestartActivityTask);
        System.exit(0);
    }

    public static void l(View view) {
        if (view != null && view.requestFocus()) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 1);
        }
    }

    public static void m(final Context context) {
        g6.n.r(context, x7.u.X1, R.string.ok, new View.OnClickListener() { // from class: z8.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.a(context, view);
            }
        });
    }
}
