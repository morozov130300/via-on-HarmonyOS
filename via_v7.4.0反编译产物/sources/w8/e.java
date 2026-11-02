package w8;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import g6.f;
import g6.y;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Locale;
import p.t;
import p.v;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final String f13354a = Build.MANUFACTURER.toLowerCase(Locale.ROOT);

    public static int a(Context context) throws ClassNotFoundException {
        Intent intent = new Intent("android.intent.action.CREATE_SHORTCUT");
        try {
            Class<?> cls = Class.forName("com.huawei.hsm.permission.PermissionManager");
            return ((Boolean) cls.getDeclaredMethod("canSendBroadcast", Context.class, Intent.class).invoke(cls, context, intent)).booleanValue() ? 0 : -1;
        } catch (ClassNotFoundException e10) {
            pc.a.b(e10);
            return 2;
        } catch (IllegalAccessException e11) {
            pc.a.b(e11);
            return 2;
        } catch (NoSuchMethodException e12) {
            pc.a.b(e12);
            return 2;
        } catch (NullPointerException e13) {
            pc.a.b(e13);
            return 2;
        } catch (InvocationTargetException e14) {
            pc.a.b(e14);
            return 2;
        }
    }

    public static int b(Context context) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        Object objInvoke;
        try {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            String packageName = context.getApplicationContext().getPackageName();
            int i10 = context.getApplicationInfo().uid;
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            objInvoke = cls.getDeclaredMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, 10017, Integer.valueOf(i10), packageName);
        } catch (Exception unused) {
        }
        if (objInvoke == null) {
            return 2;
        }
        String string = objInvoke.toString();
        int iHashCode = string.hashCode();
        if (iHashCode != 48) {
            if (iHashCode != 49) {
                if (iHashCode == 53 && string.equals("5")) {
                    return 1;
                }
            } else if (string.equals("1")) {
                return -1;
            }
        } else if (string.equals("0")) {
            return 0;
        }
        return 2;
    }

    public static int c(Context context) {
        Cursor cursorQuery;
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            return 2;
        }
        try {
            cursorQuery = contentResolver.query(Uri.parse("content://settings/secure/launcher_shortcut_permission_settings"), new String[]{"value"}, null, null, null);
        } catch (Exception e10) {
            pc.a.b(e10);
        }
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() > 0) {
                    while (cursorQuery.moveToNext()) {
                        String string = cursorQuery.getString(0);
                        if (string.contains("mark.via, 1")) {
                            cursorQuery.close();
                            return 0;
                        }
                        if (string.contains("mark.via, 0")) {
                            cursorQuery.close();
                            return -1;
                        }
                    }
                    cursorQuery.close();
                    return 2;
                }
            } finally {
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return 2;
    }

    public static int d(Context context) {
        Cursor cursorQuery;
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            return 2;
        }
        try {
            cursorQuery = contentResolver.query(Uri.parse("content://com.bbk.launcher2.settings/favorites"), new String[]{"shortcutPermission"}, "itemType = ? and intent like ?", new String[]{"30", "mark.via/%"}, null);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() > 0) {
                    while (cursorQuery.moveToNext()) {
                        int i10 = cursorQuery.getInt(0);
                        if (i10 == 1 || i10 == 17) {
                            cursorQuery.close();
                            return -1;
                        }
                        if (i10 == 16) {
                            cursorQuery.close();
                            return 0;
                        }
                        if (i10 == 18) {
                            cursorQuery.close();
                            return 1;
                        }
                    }
                    cursorQuery.close();
                    return 2;
                }
            } finally {
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return 2;
    }

    public static int e(Context context) {
        String str = f13354a;
        return str.contains("huawei") ? a(context) : str.contains("xiaomi") ? b(context) : (str.contains("oppo") || str.contains("realme") || str.equals("oneplus")) ? c(context) : str.contains("vivo") ? d(context) : (str.contains("samsung") || str.contains("meizu")) ? 0 : 2;
    }

    public static int f(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return y.h(context, 108.0f);
        }
        ActivityManager activityManager = (ActivityManager) f.f(context, ActivityManager.class);
        return activityManager != null ? activityManager.getLauncherLargeIconSize() : y.h(context, 48.0f);
    }

    public static void g(Context context) {
        new a(context).g();
    }

    public static boolean h(Context context, String str) {
        ShortcutManager shortcutManagerA;
        if (str == null || str.isEmpty() || Build.VERSION.SDK_INT < 25 || (shortcutManagerA = v.a(f.f(context, t.a()))) == null) {
            return false;
        }
        Iterator it = shortcutManagerA.getPinnedShortcuts().iterator();
        while (it.hasNext()) {
            if (str.equals(c.a(it.next()).getId())) {
                return true;
            }
        }
        return false;
    }
}
