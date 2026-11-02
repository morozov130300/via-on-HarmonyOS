package z8;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class f1 {
    public static String a(Context context, Intent intent) {
        PackageManager packageManager = context.getPackageManager();
        ActivityInfo activityInfoResolveActivityInfo = intent.resolveActivityInfo(packageManager, 128);
        if (activityInfoResolveActivityInfo != null) {
            return "android".equals(activityInfoResolveActivityInfo.packageName) ? "" : packageManager.getApplicationLabel(activityInfoResolveActivityInfo.applicationInfo).toString();
        }
        return null;
    }

    public static Intent b(g5.c cVar) {
        String strC = null;
        if (!g5.b.e(cVar.q()) || cVar.f() == null) {
            return null;
        }
        String strK = cVar.k();
        String strL = cVar.l();
        int iLastIndexOf = strL.lastIndexOf(46);
        if (iLastIndexOf > 0 && iLastIndexOf < strL.length() - 1) {
            strC = l5.c.c(strL.substring(iLastIndexOf + 1), null);
        }
        if (strC != null) {
            strK = strC;
        }
        if (strK == null) {
            strK = "application/octet-stream";
        }
        Uri uriF = cVar.f();
        Intent intent = new Intent("application/vnd.android.package-archive".equals(strK) ? "android.intent.action.INSTALL_PACKAGE" : "android.intent.action.VIEW");
        intent.addFlags(268435456);
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
        }
        intent.setDataAndType(uriF, strK);
        if (strK.startsWith("image/") && (g6.o.i() || g6.o.h())) {
            intent.putExtra("SingleItemOnly", true);
        }
        return intent;
    }

    public static Intent c(Context context, String str) throws URISyntaxException {
        try {
            Intent uri = Intent.parseUri(str, 1);
            uri.addFlags(268435456);
            uri.addCategory("android.intent.category.BROWSABLE");
            return uri;
        } catch (URISyntaxException e10) {
            pc.a.i(e10);
            return null;
        }
    }

    public static Intent d() {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:mark.via"));
        intent.setFlags(805306368);
        return intent;
    }

    public static Intent e() {
        Intent intent = new Intent();
        intent.setAction("com.android.settings.TTS_SETTINGS");
        intent.setFlags(268435456);
        return intent;
    }

    public static Intent f(Context context, String str) throws URISyntaxException {
        if (str != null && !str.isEmpty() && !u9.d.m(context, str)) {
            try {
                Intent uri = Intent.parseUri(str, 1);
                uri.addFlags(268435456);
                uri.addCategory("android.intent.category.BROWSABLE");
                List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(uri, 0);
                ArrayList arrayList = new ArrayList();
                Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
                while (it.hasNext()) {
                    String str2 = it.next().activityInfo.packageName;
                    if (!str2.equals("mark.via")) {
                        Intent intent = new Intent(uri);
                        intent.setPackage(str2);
                        arrayList.add(intent);
                    }
                }
                if (arrayList.isEmpty()) {
                    return null;
                }
                if (arrayList.size() == 1) {
                    return (Intent) arrayList.get(0);
                }
                Intent intentCreateChooser = Intent.createChooser((Intent) arrayList.remove(0), context.getString(x7.u.f14199v9));
                intentCreateChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
                return intentCreateChooser;
            } catch (URISyntaxException unused) {
            }
        }
        return null;
    }

    public static Intent g(String str, String str2, String str3, String str4) {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", TextUtils.isEmpty(str) ? "" : str, null));
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("android.intent.extra.EMAIL", str.split("\\s*,\\s*"));
        }
        if (!TextUtils.isEmpty(str3)) {
            intent.putExtra("android.intent.extra.TEXT", str3);
        }
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("android.intent.extra.SUBJECT", str2);
        }
        if (!TextUtils.isEmpty(str4)) {
            intent.putExtra("android.intent.extra.CC", str4.split("\\s*,\\s*"));
        }
        return intent;
    }

    public static Intent h(String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setDataAndType(Uri.parse(str), "video/*");
        if (str2 != null && !str2.isEmpty()) {
            intent.putExtra("android.intent.extra.TITLE", str2);
            intent.putExtra("title", str2);
        }
        return intent;
    }

    public static Intent i(Context context, Uri uri, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        if (Build.VERSION.SDK_INT >= 24) {
            if (b1.q(uri) && uri.getPath() != null) {
                uri = FileProvider.f(context, "mark.via.provider", new File(uri.getPath()));
            }
            intent.addFlags(1);
        }
        intent.setDataAndType(uri, str);
        if (str != null && str.startsWith("image/") && (g6.o.i() || g6.o.h())) {
            intent.putExtra("SingleItemOnly", true);
        }
        return intent;
    }

    public static boolean j(Context context, Intent intent) {
        if (context != null && intent != null) {
            try {
                context.startActivity(intent);
                return true;
            } catch (ActivityNotFoundException unused) {
            }
        }
        return false;
    }

    public static void k(Context context, String str) {
        l(context, null, str);
    }

    public static void l(Context context, String str, String str2) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("android.intent.extra.TITLE", str);
            intent.putExtra("title", str);
        }
        intent.putExtra("android.intent.extra.TEXT", str2);
        context.startActivity(Intent.createChooser(intent, context.getResources().getString(x7.u.f13943d0)));
    }

    public static boolean m(Context context, Uri uri, String str) {
        if (uri == null) {
            return false;
        }
        if (b1.q(uri)) {
            return n(context, uri.getPath(), str);
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
        }
        intent.setType(str);
        intent.putExtra("android.intent.extra.STREAM", uri);
        try {
            context.startActivity(Intent.createChooser(intent, context.getString(x7.u.f13943d0)));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean n(Context context, String str, String str2) {
        if (str != null && str.length() > 0) {
            File file = new File(str);
            if (file.exists()) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                Uri uriFromFile = Uri.fromFile(file);
                if (Build.VERSION.SDK_INT >= 24) {
                    try {
                        uriFromFile = FileProvider.f(context, context.getPackageName() + ".provider", file);
                        intent.addFlags(3);
                    } catch (IllegalArgumentException unused) {
                        return false;
                    } catch (Exception e10) {
                        pc.a.i(e10);
                    }
                }
                if (str2 == null) {
                    str2 = l5.c.c(c1.r(str), "image/*");
                }
                intent.setType(str2);
                intent.putExtra("android.intent.extra.STREAM", uriFromFile);
                try {
                    context.startActivity(Intent.createChooser(intent, context.getResources().getString(x7.u.f13943d0)));
                    return true;
                } catch (Exception unused2) {
                }
            }
        }
        return false;
    }
}
