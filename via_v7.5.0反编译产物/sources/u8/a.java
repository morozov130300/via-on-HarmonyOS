package u8;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f12904b = Build.MANUFACTURER.toLowerCase(Locale.ROOT);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f12905a;

    public a(Context context) {
        this.f12905a = context;
    }

    public static Intent a(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        return intent;
    }

    public static String b(String str) throws Throwable {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                String line = bufferedReader2.readLine();
                try {
                    bufferedReader2.close();
                } catch (IOException unused) {
                }
                return line;
            } catch (IOException unused2) {
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused3) {
                    }
                }
                return "";
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (IOException unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean c(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public static Intent d(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a(context);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
        return intent;
    }

    public static Intent e(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return a(context);
        }
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra("packageName", context.getPackageName());
        intent.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
        return intent;
    }

    public static Intent f(Context context) {
        Intent intent = new Intent();
        intent.putExtra("packageName", context.getPackageName());
        intent.setClassName("com.oppo.launcher", "com.oppo.launcher.shortcut.ShortcutSettingsActivity");
        if (c(context, intent)) {
            return intent;
        }
        intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
        return intent;
    }

    public static Intent h(Context context) {
        Intent intent = new Intent();
        intent.putExtra("packagename", context.getPackageName());
        intent.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity"));
        if (c(context, intent)) {
            return intent;
        }
        intent.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
        return intent;
    }

    public static Intent i(Context context) throws Throwable {
        String strB = b("ro.miui.ui.version.name");
        if (TextUtils.isEmpty(strB)) {
            return a(context);
        }
        try {
            int i10 = Integer.parseInt(strB.substring(1));
            if (i10 >= 9) {
                Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
                intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity"));
                intent.putExtra("extra_pkgname", context.getPackageName());
                return intent;
            }
            if (i10 < 7) {
                return a(context);
            }
            Intent intent2 = new Intent("miui.intent.action.APP_PERM_EDITOR");
            intent2.putExtra("extra_pkgname", context.getPackageName());
            return intent2;
        } catch (NumberFormatException e10) {
            e10.printStackTrace();
            return a(context);
        }
    }

    public void g() throws Throwable {
        Intent intentF;
        String str = f12904b;
        if (str.contains("huawei")) {
            intentF = d(this.f12905a);
        } else if (str.contains("xiaomi")) {
            intentF = i(this.f12905a);
        } else if (str.contains("oppo") || str.contains("realme") || str.equals("oneplus")) {
            intentF = f(this.f12905a);
        } else if (str.contains("vivo")) {
            intentF = h(this.f12905a);
        } else {
            intentF = str.contains("meizu") ? e(this.f12905a) : a(this.f12905a);
        }
        try {
            this.f12905a.startActivity(intentF);
        } catch (Exception e10) {
            e10.printStackTrace();
            this.f12905a.startActivity(a(this.f12905a));
        }
    }
}
