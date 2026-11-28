package mark.via.download;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.tuyafeng.support.utils.FragmentUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class h2 {
    public static /* synthetic */ String a(PackageManager packageManager, ResolveInfo resolveInfo) {
        CharSequence charSequenceLoadLabel = resolveInfo.loadLabel(packageManager);
        return charSequenceLoadLabel == null ? "" : charSequenceLoadLabel.toString();
    }

    public static void b(Context context, List list, Uri uri, String str) {
        Intent intentD = d(context, uri, str);
        final PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intentD, 0);
        listQueryIntentActivities.sort(Comparator.comparing(new Function() { // from class: mark.via.download.e2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return h2.a(packageManager, (ResolveInfo) obj);
            }
        }, new Comparator() { // from class: mark.via.download.f2
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((String) obj).compareToIgnoreCase((String) obj2);
            }
        }));
        for (ResolveInfo resolveInfo : listQueryIntentActivities) {
            if (resolveInfo.activityInfo != null) {
                Intent intent = new Intent(intentD);
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                intent.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
                list.add(new b2(resolveInfo.loadLabel(packageManager), resolveInfo.loadIcon(packageManager), intent));
            }
        }
    }

    public static void c(Context context, List list, String str) {
        if ("application/pdf".equals(str)) {
            Drawable drawableA = lb.g.a(context, w7.o.X, w7.u.f14066h1);
            com.tuyafeng.support.utils.h.a(drawableA, com.tuyafeng.support.utils.e.a(context, w7.k.f13729i));
            list.add(new b2(context.getString(w7.u.E9), new InsetDrawable(drawableA, (int) (context.getResources().getDisplayMetrics().density * 4.0f)), 2, null));
        }
    }

    public static Intent d(Context context, Uri uri, String str) {
        Intent intentI = x8.e1.i(context, uri, str);
        if ("application/vnd.android.package-archive".equals(str)) {
            intentI.setAction("android.intent.action.INSTALL_PACKAGE");
        } else {
            intentI.setAction("android.intent.action.VIEW");
        }
        if (Build.VERSION.SDK_INT >= 24) {
            intentI.addFlags(1);
        }
        return intentI;
    }

    public static boolean e(Fragment fragment, b2 b2Var, String str) {
        Uri uriF = f(str);
        if (Uri.EMPTY.equals(uriF)) {
            return false;
        }
        if (b2Var.f() != 2) {
            return b2Var.c() != null && x8.e1.j(fragment.G(), b2Var.c());
        }
        FragmentUtils.j(fragment, za.g.class, p5.a.b().e("pdfPath", uriF.toString()).e("pdfName", x8.b1.k(fragment.G(), uriF)).a());
        return true;
    }

    public static Uri f(String str) {
        if (TextUtils.isEmpty(str)) {
            return Uri.EMPTY;
        }
        Uri uri = Uri.parse(str);
        return (x8.b1.q(uri) || x8.b1.n(uri)) ? uri : Uri.fromFile(new File(str));
    }

    public static List g(Context context, String str, String str2) {
        Uri uriF = f(str);
        if (Uri.EMPTY.equals(uriF) || !x8.b1.p(context, uriF)) {
            return Collections.EMPTY_LIST;
        }
        String strK = x8.b1.k(context, uriF);
        if (TextUtils.isEmpty(str2)) {
            str2 = h(context, uriF, strK);
        }
        ArrayList arrayList = new ArrayList();
        c(context, arrayList, str2);
        b(context, arrayList, uriF, str2);
        return arrayList;
    }

    public static String h(Context context, Uri uri, String str) {
        int iLastIndexOf;
        String type = null;
        if (str != null && (iLastIndexOf = str.lastIndexOf(46)) > 0 && iLastIndexOf < str.length() - 1) {
            type = l5.c.c(str.substring(iLastIndexOf + 1), null);
        }
        if (type == null && x8.b1.n(uri)) {
            type = context.getContentResolver().getType(uri);
        }
        return type == null ? "application/octet-stream" : type;
    }
}
