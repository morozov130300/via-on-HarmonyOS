package p;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile t f11512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile List f11513b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IntentSender f11514a;

        public a(IntentSender intentSender) {
            this.f11514a = intentSender;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                this.f11514a.sendIntent(context, 0, null, null, null);
            } catch (IntentSender.SendIntentException unused) {
            }
        }
    }

    public static boolean a(Context context, s sVar) {
        Bitmap bitmapDecodeStream;
        IconCompat iconCompat = sVar.f11522h;
        if (iconCompat == null) {
            return false;
        }
        int i10 = iconCompat.f491a;
        if (i10 != 6 && i10 != 4) {
            return true;
        }
        InputStream inputStreamM = iconCompat.m(context);
        if (inputStreamM == null || (bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamM)) == null) {
            return false;
        }
        sVar.f11522h = i10 == 6 ? IconCompat.d(bitmapDecodeStream) : IconCompat.e(bitmapDecodeStream);
        return true;
    }

    public static void b(Context context, List list) {
        for (s sVar : new ArrayList(list)) {
            if (!a(context, sVar)) {
                list.remove(sVar);
            }
        }
    }

    public static List c(Context context) {
        Bundle bundle;
        String string;
        if (f11513b == null) {
            ArrayList arrayList = new ArrayList();
            if (Build.VERSION.SDK_INT >= 21) {
                PackageManager packageManager = context.getPackageManager();
                Intent intent = new Intent("androidx.core.content.pm.SHORTCUT_LISTENER");
                intent.setPackage(context.getPackageName());
                Iterator<ResolveInfo> it = packageManager.queryIntentActivities(intent, 128).iterator();
                while (it.hasNext()) {
                    ActivityInfo activityInfo = it.next().activityInfo;
                    if (activityInfo != null && (bundle = activityInfo.metaData) != null && (string = bundle.getString("androidx.core.content.pm.shortcut_listener_impl")) != null) {
                        try {
                            n.g.a(Class.forName(string, false, a0.class.getClassLoader()).getMethod("getInstance", Context.class).invoke(null, context));
                            arrayList.add(null);
                        } catch (Exception unused) {
                        }
                    }
                }
            }
            if (f11513b == null) {
                f11513b = arrayList;
            }
        }
        return f11513b;
    }

    public static t d(Context context) {
        if (f11512a == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    f11512a = (t) Class.forName("androidx.sharetarget.ShortcutInfoCompatSaverImpl", false, a0.class.getClassLoader()).getMethod("getInstance", Context.class).invoke(null, context);
                } catch (Exception unused) {
                }
            }
            if (f11512a == null) {
                f11512a = new t.a();
            }
        }
        return f11512a;
    }

    public static boolean e(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return w.a(context.getSystemService(u.a())).isRequestPinShortcutSupported();
        }
        if (o.a.a(context, "com.android.launcher.permission.INSTALL_SHORTCUT") != 0) {
            return false;
        }
        Iterator<ResolveInfo> it = context.getPackageManager().queryBroadcastReceivers(new Intent("com.android.launcher.action.INSTALL_SHORTCUT"), 0).iterator();
        while (it.hasNext()) {
            String str = it.next().activityInfo.permission;
            if (TextUtils.isEmpty(str) || "com.android.launcher.permission.INSTALL_SHORTCUT".equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static List f(List list, int i10) {
        Objects.requireNonNull(list);
        if (Build.VERSION.SDK_INT > 31) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            s sVar = (s) it.next();
            if (sVar.d(i10)) {
                arrayList.remove(sVar);
            }
        }
        return arrayList;
    }

    public static boolean g(Context context, s sVar, IntentSender intentSender) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 <= 31 && sVar.d(1)) {
            return false;
        }
        if (i10 >= 26) {
            return w.a(context.getSystemService(u.a())).requestPinShortcut(sVar.e(), intentSender);
        }
        if (!e(context)) {
            return false;
        }
        Intent intentA = sVar.a(new Intent("com.android.launcher.action.INSTALL_SHORTCUT"));
        if (intentSender == null) {
            context.sendBroadcast(intentA);
            return true;
        }
        context.sendOrderedBroadcast(intentA, null, new a(intentSender), null, -1, null, null);
        return true;
    }

    public static boolean h(Context context, List list) {
        List listF = f(list, 1);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 <= 29) {
            b(context, listF);
        }
        if (i10 >= 25) {
            ArrayList arrayList = new ArrayList();
            Iterator it = listF.iterator();
            while (it.hasNext()) {
                arrayList.add(((s) it.next()).e());
            }
            if (!w.a(context.getSystemService(u.a())).updateShortcuts(arrayList)) {
                return false;
            }
        }
        d(context).a(listF);
        Iterator it2 = c(context).iterator();
        if (!it2.hasNext()) {
            return true;
        }
        n.g.a(it2.next());
        throw null;
    }
}
