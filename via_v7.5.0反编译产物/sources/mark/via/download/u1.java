package mark.via.download;

import android.app.DownloadManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.CookieManager;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class u1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile u1 f10301b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i2 f10302a;

    public static u1 d() {
        if (f10301b == null) {
            synchronized (u1.class) {
                try {
                    if (f10301b == null) {
                        f10301b = new u1();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f10301b;
    }

    public boolean a(Context context, String str) {
        if (this.f10302a != null && !TextUtils.isEmpty(str)) {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setType("text/plain");
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", str);
            String strC = this.f10302a.c();
            String[] strArrA = this.f10302a.a();
            if (strArrA == null) {
                return false;
            }
            for (String str2 : strArrA) {
                intent.setComponent(new ComponentName(strC, str2));
                try {
                    context.startActivity(intent);
                    return true;
                } catch (Exception e10) {
                    tc.a.b(e10);
                }
            }
        }
        return false;
    }

    public long b(Context context, String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
                request.setNotificationVisibility(1);
                int i10 = Build.VERSION.SDK_INT;
                if (i10 < 29) {
                    request.allowScanningByMediaScanner();
                }
                request.setTitle(str2);
                request.setDescription(str);
                if (str4 != null) {
                    request.setMimeType(str4);
                }
                request.addRequestHeader("Cookie", CookieManager.getInstance().getCookie(str));
                request.addRequestHeader("Referer", str);
                if (str3 != null) {
                    request.addRequestHeader("User-Agent", str3);
                }
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, str2);
                if (i10 < 29) {
                    request.setVisibleInDownloadsUi(true);
                }
                return ((DownloadManager) context.getSystemService("download")).enqueue(request);
            } catch (Exception e10) {
                tc.a.b(e10);
            }
        }
        return 0L;
    }

    public String[][] c(Context context) {
        PackageInfo packageInfo;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add("");
        arrayList2.add(context.getString(w7.u.R1));
        Iterator it = j2.a().iterator();
        while (it.hasNext()) {
            String strC = ((i2) it.next()).c();
            if ("system".equals(strC)) {
                arrayList.add(strC);
                arrayList2.add(context.getString(w7.u.be));
            } else {
                try {
                    packageInfo = packageManager.getPackageInfo(strC, 1);
                } catch (Exception unused) {
                    packageInfo = null;
                }
                if (packageInfo != null && packageInfo.applicationInfo.enabled) {
                    arrayList.add(strC);
                    arrayList2.add(packageManager.getApplicationLabel(packageInfo.applicationInfo).toString());
                }
            }
        }
        return new String[][]{(String[]) arrayList.toArray(new String[0]), (String[]) arrayList2.toArray(new String[0])};
    }

    public boolean e() {
        i2 i2Var = this.f10302a;
        return (i2Var == null || "system".equals(i2Var.c())) ? false : true;
    }

    public boolean f() {
        i2 i2Var = this.f10302a;
        return i2Var != null && "system".equals(i2Var.c());
    }

    public boolean g(Context context) {
        if (this.f10302a == null) {
            return false;
        }
        Intent intent = new Intent();
        String strC = this.f10302a.c();
        if ("system".equals(strC)) {
            intent.setAction("android.intent.action.VIEW_DOWNLOADS");
            try {
                context.startActivity(intent);
                return true;
            } catch (Exception e10) {
                tc.a.b(e10);
                return false;
            }
        }
        String[] strArrB = this.f10302a.b();
        if (strArrB == null) {
            return false;
        }
        for (String str : strArrB) {
            intent.setClassName(strC, str);
            try {
                context.startActivity(intent);
                return true;
            } catch (Exception e11) {
                tc.a.b(e11);
            }
        }
        return false;
    }

    public void h(String str) {
        this.f10302a = null;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (i2 i2Var : j2.a()) {
            if (str.equals(i2Var.c())) {
                this.f10302a = i2Var;
                return;
            }
        }
    }
}
