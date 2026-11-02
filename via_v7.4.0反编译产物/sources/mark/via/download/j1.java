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

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class j1 {

    /* renamed from: b, reason: collision with root package name */
    public static volatile j1 f9922b;

    /* renamed from: a, reason: collision with root package name */
    public y1 f9923a;

    public static j1 e() {
        if (f9922b == null) {
            synchronized (j1.class) {
                try {
                    if (f9922b == null) {
                        f9922b = new j1();
                    }
                } finally {
                }
            }
        }
        return f9922b;
    }

    public boolean a(Context context, String str) {
        if (this.f9923a != null && !TextUtils.isEmpty(str)) {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setType("text/plain");
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", str);
            String strC = this.f9923a.c();
            String[] strArrA = this.f9923a.a();
            if (strArrA == null) {
                return false;
            }
            for (String str2 : strArrA) {
                intent.setComponent(new ComponentName(strC, str2));
                try {
                    context.startActivity(intent);
                    return true;
                } catch (Exception e10) {
                    pc.a.b(e10);
                }
            }
        }
        return false;
    }

    public x6.j b(x1 x1Var, String str, String str2) {
        return x6.j.l();
    }

    public long c(Context context, String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
                int i10 = Build.VERSION.SDK_INT;
                request.setNotificationVisibility(1);
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
                pc.a.b(e10);
            }
        }
        return 0L;
    }

    public String[][] d(Context context) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add("");
        arrayList2.add(context.getString(x7.u.E1));
        for (y1 y1Var : z1.a()) {
            String strC = y1Var.c();
            if ("system".equals(strC)) {
                arrayList.add(strC);
                arrayList2.add(context.getString(x7.u.Ld));
            } else if ("rpc".equals(strC)) {
                arrayList.add(strC);
                arrayList2.add(y1Var.d());
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

    public boolean f() {
        y1 y1Var = this.f9923a;
        return (y1Var == null || "system".equals(y1Var.c()) || "rpc".equals(this.f9923a.c())) ? false : true;
    }

    public boolean g() {
        y1 y1Var = this.f9923a;
        return y1Var != null && "rpc".equals(y1Var.c());
    }

    public boolean h() {
        y1 y1Var = this.f9923a;
        return y1Var != null && "system".equals(y1Var.c());
    }

    public boolean i(Context context) {
        if (this.f9923a == null) {
            return false;
        }
        Intent intent = new Intent();
        String strC = this.f9923a.c();
        if ("system".equals(strC)) {
            intent.setAction("android.intent.action.VIEW_DOWNLOADS");
            try {
                context.startActivity(intent);
                return true;
            } catch (Exception e10) {
                pc.a.b(e10);
                return false;
            }
        }
        String[] strArrB = this.f9923a.b();
        if (strArrB == null) {
            return false;
        }
        for (String str : strArrB) {
            intent.setClassName(strC, str);
            try {
                context.startActivity(intent);
                return true;
            } catch (Exception e11) {
                pc.a.b(e11);
            }
        }
        return false;
    }

    public void j(String str) {
        this.f9923a = null;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (y1 y1Var : z1.a()) {
            if (str.equals(y1Var.c())) {
                this.f9923a = y1Var;
                return;
            }
        }
    }
}
