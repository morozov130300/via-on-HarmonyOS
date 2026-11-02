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
import p.s;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class z {

    /* renamed from: a, reason: collision with root package name */
    public static volatile s f10912a;

    /* renamed from: b, reason: collision with root package name */
    public static volatile List f10913b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IntentSender f10914a;

        public a(IntentSender intentSender) {
            this.f10914a = intentSender;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws IntentSender.SendIntentException {
            try {
                this.f10914a.sendIntent(context, 0, null, null, null);
            } catch (IntentSender.SendIntentException unused) {
            }
        }
    }

    public static boolean a(Context context, r rVar) {
        Bitmap bitmapDecodeStream;
        IconCompat iconCompat = rVar.f10897h;
        if (iconCompat == null) {
            return false;
        }
        int i10 = iconCompat.f588a;
        if (i10 != 6 && i10 != 4) {
            return true;
        }
        InputStream inputStreamM = iconCompat.m(context);
        if (inputStreamM == null || (bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamM)) == null) {
            return false;
        }
        rVar.f10897h = i10 == 6 ? IconCompat.d(bitmapDecodeStream) : IconCompat.e(bitmapDecodeStream);
        return true;
    }

    public static void b(Context context, List list) {
        for (r rVar : new ArrayList(list)) {
            if (!a(context, rVar)) {
                list.remove(rVar);
            }
        }
    }

    public static List c(Context context) {
        Bundle bundle;
        String string;
        if (f10913b == null) {
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
                            n.g.a(Class.forName(string, false, z.class.getClassLoader()).getMethod("getInstance", Context.class).invoke(null, context));
                            arrayList.add(null);
                        } catch (Exception unused) {
                        }
                    }
                }
            }
            if (f10913b == null) {
                f10913b = arrayList;
            }
        }
        return f10913b;
    }

    public static s d(Context context) {
        if (f10912a == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    f10912a = (s) Class.forName("androidx.sharetarget.ShortcutInfoCompatSaverImpl", false, z.class.getClassLoader()).getMethod("getInstance", Context.class).invoke(null, context);
                } catch (Exception unused) {
                }
            }
            if (f10912a == null) {
                f10912a = new s.a();
            }
        }
        return f10912a;
    }

    public static boolean e(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return v.a(context.getSystemService(t.a())).isRequestPinShortcutSupported();
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
            r rVar = (r) it.next();
            if (rVar.d(i10)) {
                arrayList.remove(rVar);
            }
        }
        return arrayList;
    }

    public static boolean g(Context context, r rVar, IntentSender intentSender) throws PackageManager.NameNotFoundException {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 <= 31 && rVar.d(1)) {
            return false;
        }
        if (i10 >= 26) {
            return v.a(context.getSystemService(t.a())).requestPinShortcut(rVar.e(), intentSender);
        }
        if (!e(context)) {
            return false;
        }
        Intent intentA = rVar.a(new Intent("com.android.launcher.action.INSTALL_SHORTCUT"));
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
                arrayList.add(((r) it.next()).e());
            }
            if (!v.a(context.getSystemService(t.a())).updateShortcuts(arrayList)) {
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
