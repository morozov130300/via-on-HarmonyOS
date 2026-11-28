package u8;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.tuyafeng.support.utils.f;
import com.tuyafeng.support.utils.x;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Locale;
import p.u;
import p.w;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f12906a = Build.MANUFACTURER.toLowerCase(Locale.ROOT);

    public static int a(Context context) {
        Intent intent = new Intent("android.intent.action.CREATE_SHORTCUT");
        try {
            Class<?> cls = Class.forName("com.huawei.hsm.permission.PermissionManager");
            return ((Boolean) cls.getDeclaredMethod("canSendBroadcast", Context.class, Intent.class).invoke(cls, context, intent)).booleanValue() ? 0 : -1;
        } catch (ClassNotFoundException e10) {
            tc.a.b(e10);
            return 2;
        } catch (IllegalAccessException e11) {
            tc.a.b(e11);
            return 2;
        } catch (NoSuchMethodException e12) {
            tc.a.b(e12);
            return 2;
        } catch (NullPointerException e13) {
            tc.a.b(e13);
            return 2;
        } catch (InvocationTargetException e14) {
            tc.a.b(e14);
            return 2;
        }
    }

    public static int b(Context context) {
        try {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            String packageName = context.getApplicationContext().getPackageName();
            int i10 = context.getApplicationInfo().uid;
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            Object objInvoke = cls.getDeclaredMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, 10017, Integer.valueOf(i10), packageName);
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
        } catch (Exception unused) {
        }
        return 2;
    }

    public static int c(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            return 2;
        }
        try {
            Cursor cursorQuery = contentResolver.query(Uri.parse("content://settings/secure/launcher_shortcut_permission_settings"), new String[]{"value"}, null, null, null);
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
                    return 2;
                } catch (Throwable th) {
                    try {
                        cursorQuery.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                        throw th;
                    }
                }
                tc.a.b(e);
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return 2;
        } catch (Exception e10) {
            tc.a.b(e10);
        }
    }

    public static int d(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            return 2;
        }
        try {
            Cursor cursorQuery = contentResolver.query(Uri.parse("content://com.bbk.launcher2.settings/favorites"), new String[]{"shortcutPermission"}, "itemType = ? and intent like ?", new String[]{"30", "mark.via/%"}, null);
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
                    return 2;
                } catch (Throwable th) {
                    try {
                        cursorQuery.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                        throw th;
                    }
                }
                e.printStackTrace();
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return 2;
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static int e(Context context) {
        String str = f12906a;
        if (str.contains("huawei")) {
            return a(context);
        }
        if (str.contains("xiaomi")) {
            return b(context);
        }
        if (str.contains("oppo") || str.contains("realme") || str.equals("oneplus")) {
            return c(context);
        }
        if (str.contains("vivo")) {
            return d(context);
        }
        return (str.contains("samsung") || str.contains("meizu")) ? 0 : 2;
    }

    public static int f(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return x.h(context, 108.0f);
        }
        ActivityManager activityManager = (ActivityManager) f.f(context, ActivityManager.class);
        return activityManager != null ? activityManager.getLauncherLargeIconSize() : x.h(context, 48.0f);
    }

    public static void g(Context context) throws Throwable {
        new a(context).g();
    }

    public static boolean h(Context context, String str) {
        ShortcutManager shortcutManagerA;
        if (str == null || str.isEmpty() || Build.VERSION.SDK_INT < 25 || (shortcutManagerA = w.a(f.f(context, u.a()))) == null) {
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
