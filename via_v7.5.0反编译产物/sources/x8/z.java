package x8;

import android.R;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Build;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.GeolocationPermissions;
import android.webkit.URLUtil;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewDatabase;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.WeakHashMap;
import mark.via.Shell;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakHashMap f14659a;

    public static int A(Context context) {
        int iA = k5.t.a(context);
        if (iA != 0) {
            return iA != 2 ? 1 : 2;
        }
        return 0;
    }

    public static int B(String str) {
        String strH = H(str);
        int i10 = Integer.parseInt(strH.substring(0, 3), 16) + Integer.parseInt(strH.substring((strH.length() / 2) - 3, strH.length() / 2), 16) + Integer.parseInt(strH.substring(strH.length() - 3), 16);
        do {
            i10 /= 2;
        } while (i10 > 80);
        return i10;
    }

    public static String C(String str) {
        String strReplace = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String strTrim = str.trim();
        if (strTrim.startsWith("thunder://")) {
            String strA = v0.a(strTrim.replace("thunder://", ""));
            if (strA.length() > 4) {
                strReplace = strA.substring(2, strA.length() - 2);
            }
        } else if (strTrim.startsWith("qqdl://")) {
            strReplace = v0.a(strTrim.replace("qqdl://", ""));
        } else if (strTrim.startsWith("flashget://")) {
            strReplace = v0.a(strTrim.replace("flashget://", "")).replace("[FLASHGET]", "");
        }
        return strReplace.trim();
    }

    public static String D(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        String strF = c6.y1.f2139a.f(str);
        return strF.length() <= 8192 ? strF : strF.substring(0, 8192);
    }

    public static String E(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf("?");
        if (iLastIndexOf > -1) {
            str = str.substring(0, iLastIndexOf);
        }
        int iLastIndexOf2 = str.lastIndexOf("/");
        if (iLastIndexOf2 > -1) {
            str = str.substring(iLastIndexOf2);
        }
        int iLastIndexOf3 = str.lastIndexOf(".");
        if (iLastIndexOf3 > -1) {
            str = str.substring(iLastIndexOf3);
        }
        return (str.length() >= 7 || str.length() < 2 || !str.startsWith(".")) ? "" : str;
    }

    public static String F(String str, String str2) {
        String strG;
        if (str2 == null || str == null) {
            return str;
        }
        if (str2.length() > 38 && ((str.length() == 7 && "QQ浏览器搜索".equals(str)) || (str.length() == 8 && "QQ 浏览器搜索".equals(str)))) {
            String strG2 = c6.y1.f2139a.g(str2, "https://wap.sogou.com/web/sl?keyword=");
            if (strG2 != null && !strG2.isEmpty()) {
                return strG2 + " - " + str;
            }
        } else if (str2.length() > 47 && (((str.length() == 6 && "秘塔AI搜索".equals(str)) || (str.length() == 8 && "秘塔 AI 搜索".equals(str))) && (strG = c6.y1.f2139a.g(str2, "https://metaso.cn/search/3333?q=")) != null && !strG.isEmpty())) {
            return strG + " - " + str;
        }
        return ((str.length() == 6 && "网页无法打开".equals(str)) || (str.length() == 21 && "Webpage not available".equals(str))) ? c6.y1.f2139a.b(str2) : str;
    }

    public static boolean G(Intent intent) {
        if (intent == null || (intent.getFlags() & 1048576) != 0) {
            return false;
        }
        if ("mark.via.BROWSER".equalsIgnoreCase(intent.getStringExtra("intent"))) {
            return true;
        }
        String action = intent.getAction();
        if ("android.intent.action.SEND".equals(action) && intent.hasExtra("android.intent.extra.TEXT")) {
            return true;
        }
        return (action != null && action.startsWith("mark.via.")) || intent.hasExtra("OPEN") || intent.hasExtra("query") || (Build.VERSION.SDK_INT >= 23 && intent.hasExtra("android.intent.extra.PROCESS_TEXT")) || intent.getDataString() != null;
    }

    public static String H(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes(k8.a.f7218a));
            return h(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return String.valueOf(str.hashCode());
        }
    }

    public static boolean I(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        return (str.startsWith("192.168.") || "x.com".equals(str) || "metaso.cn".equals(str) || str.contains("forum.softpedia.com") || str.contains("3g.163.com") || str.contains("bbs.binmt.cc") || str.contains("www.giant.com.cn") || str.contains("www.10099.com.cn") || str.contains(".10086.cn") || str.contains(".10010.com") || str.contains("myaccount.google.com") || str.contains("accounts.google.com")) ? false : true;
    }

    public static boolean J(String str) {
        if (str == null || str.length() < 5) {
            return false;
        }
        String[] strArr = {"login", "signup", "signin", "register", "sign-up", "create-account", "createaccount", "auth"};
        int iD = -1;
        int length = 0;
        for (int i10 = 0; i10 < 8; i10++) {
            String str2 = strArr[i10];
            length = str2.length();
            iD = com.tuyafeng.support.utils.p.d(str, str2);
            if (iD > 0) {
                break;
            }
        }
        if (iD <= 0) {
            return false;
        }
        char cCharAt = str.charAt(iD - 1);
        c6.w wVar = c6.w.f2124a;
        if (wVar.f(cCharAt, 3, new int[]{61})) {
            return false;
        }
        int i11 = iD + length;
        if (str.length() <= i11) {
            return true;
        }
        char cCharAt2 = str.charAt(i11);
        if (cCharAt == '.' && cCharAt2 == '.') {
            return false;
        }
        return !wVar.f(cCharAt2, 3, null);
    }

    public static boolean K(Intent intent) {
        boolean zEqualsIgnoreCase = false;
        if (intent != null) {
            if (intent.getAction() != null && (intent.getAction().startsWith("mark.via.") || "android.intent.action.WEB_SEARCH".equalsIgnoreCase(intent.getAction()) || (Build.VERSION.SDK_INT >= 23 && "android.intent.extra.PROCESS_TEXT".equalsIgnoreCase(intent.getAction())))) {
                zEqualsIgnoreCase = true;
            }
            if (intent.hasExtra("intent")) {
                zEqualsIgnoreCase = "mark.via.BROWSER".equalsIgnoreCase(intent.getStringExtra("intent"));
            }
        }
        return !zEqualsIgnoreCase;
    }

    public static boolean L(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return URLUtil.isValidUrl(str) || str.startsWith("ftp://") || str.startsWith("view-source:") || M(str);
    }

    public static boolean M(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return r2.x(str) || r2.r(str) || r2.s(str);
    }

    public static void N(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        context.startActivity(Intent.createChooser(intent, context.getString(w7.u.dg)));
    }

    public static void O(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.setComponent(new ComponentName(context, (Class<?>) Shell.class));
        intent.putExtra("intent", "mark.via.BROWSER");
        context.startActivity(intent);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:11:0x002f  */
    public static x.d P(String str) {
        int i10 = 3;
        byte b10 = 0;
        String strSubstring = null;
        if (r2.x(str)) {
            int iIndexOf = str.indexOf(47, 4);
            if (iIndexOf < 0) {
                iIndexOf = str.indexOf(63, 4);
            }
            if (iIndexOf < 0) {
                iIndexOf = str.length();
            }
            String strSubstring2 = str.substring(4, iIndexOf);
            strSubstring2.getClass();
            switch (strSubstring2.hashCode()) {
                case -1548612125:
                    if (!strSubstring2.equals("offline")) {
                        b10 = -1;
                    }
                    break;
                case 107332:
                    if (!strSubstring2.equals("log")) {
                        b10 = -1;
                    } else {
                        b10 = 1;
                    }
                    break;
                case 3208415:
                    if (!strSubstring2.equals("home")) {
                        b10 = -1;
                    } else {
                        b10 = 2;
                    }
                    break;
                case 926934164:
                    if (!strSubstring2.equals("history")) {
                        b10 = -1;
                    } else {
                        b10 = 3;
                    }
                    break;
                case 2037187069:
                    if (!strSubstring2.equals("bookmarks")) {
                        b10 = -1;
                    } else {
                        b10 = 4;
                    }
                    break;
                default:
                    b10 = -1;
                    break;
            }
            switch (b10) {
                case 0:
                    i10 = 7;
                    break;
                case 1:
                    i10 = 6;
                    break;
                case 2:
                    i10 = 1;
                    break;
                case 3:
                    break;
                case 4:
                    i10 = 2;
                    break;
                default:
                    i10 = 5;
                    break;
            }
        } else if (!r2.s(str)) {
            if (r2.r(str)) {
                strSubstring = str.substring(9);
                i10 = 2;
            } else {
                i10 = 0;
            }
        }
        return new x.d(Integer.valueOf(i10), strSubstring);
    }

    public static boolean Q(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        return (str.contains("youku.com") || str.contains("youtube.com") || str.contains("v.qq.com") || str.contains("film.qq.com") || str.contains("mgtv.com") || str.contains("iqiyi.com") || str.contains("douyin.com")) ? false : true;
    }

    public static boolean R(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        return (str.contains("youku.com") || str.contains("youtube.com") || str.contains("v.qq.com") || str.contains("film.qq.com") || str.contains("mgtv.com") || str.contains("iqiyi.com") || str.contains("douyin.com")) ? false : true;
    }

    public static void S(final Context context, final String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        q5.k.l(context).g0(context.getString(w7.u.f14228s9)).K(str).X(R.string.ok, new q5.k.m() { // from class: x8.t
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                z.O(context, str);
            }
        }).P(R.string.cancel, null).T(R.string.copy, new View.OnClickListener() { // from class: x8.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.tuyafeng.support.utils.n.a(context, str, w7.u.Fg);
            }
        }).h0();
    }

    public static void T() {
        GeolocationPermissions.getInstance().clearAll();
    }

    public static void U(WebView webView, int i10) {
        int contentHeight;
        Animator animator;
        if (webView == null || webView.getContext() == null) {
            return;
        }
        WeakHashMap weakHashMap = f14659a;
        if (weakHashMap == null || (animator = (Animator) weakHashMap.get(webView)) == null || !animator.isRunning()) {
            float f10 = webView.getContext().getResources().getDisplayMetrics().density;
            int measuredHeight = webView.getMeasuredHeight();
            int scrollY = webView.getScrollY();
            if (i10 == 1) {
                contentHeight = ((int) (webView.getContentHeight() * f10)) - scrollY;
            } else if (i10 != 2) {
                contentHeight = i10 != 3 ? -scrollY : Math.min((measuredHeight / 5) * 4, (int) (((webView.getContentHeight() * f10) - measuredHeight) - scrollY));
            } else {
                contentHeight = -Math.min((measuredHeight / 5) * 4, scrollY);
            }
            if (contentHeight == 0) {
                return;
            }
            long jMin = (long) ((Math.min(1.0f, Math.abs(contentHeight) / 3000.0f) * 400.0f) + 100.0f);
            if (f14659a == null) {
                f14659a = new WeakHashMap();
            }
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(webView, "scrollY", scrollY, contentHeight + scrollY);
            objectAnimatorOfInt.setDuration(jMin);
            objectAnimatorOfInt.setInterpolator(new AccelerateDecelerateInterpolator());
            objectAnimatorOfInt.setAutoCancel(true);
            f14659a.put(webView, objectAnimatorOfInt);
            objectAnimatorOfInt.start();
        }
    }

    public static void V(final Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            e1.j(context, new Intent("android.settings.MANAGE_DEFAULT_APPS_SETTINGS"));
            return;
        }
        String str = k8.a.f7220c;
        final Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        String str2 = resolveInfoResolveActivity == null ? null : resolveInfoResolveActivity.activityInfo.packageName;
        if ("android".equals(str2)) {
            com.tuyafeng.support.utils.n.n(context, context.getString(w7.u.Ac), context.getString(w7.u.zc, c6.y1.f2139a.d(str)), new q5.k.m() { // from class: x8.y
                @Override // q5.k.m
                public final void a(View view, q5.k.p pVar) {
                    context.startActivity(intent);
                }
            });
            return;
        }
        if ("mark.via".equals(str2)) {
            com.tuyafeng.support.utils.n.s(context, context.getString(w7.u.f14010d1));
            return;
        }
        final Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + str2));
        com.tuyafeng.support.utils.n.n(context, context.getString(w7.u.Ac), context.getResources().getString(w7.u.Bg), new q5.k.m() { // from class: x8.s
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                context.startActivity(intent2);
            }
        });
    }

    public static boolean W(String str) {
        return str == null || str.isEmpty() || !str.contains("youtube.com");
    }

    public static boolean X(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        return (str.contains("youku.com") || str.contains("youtube.com") || str.contains("douyin.com") || str.contains("gaze.run")) ? false : true;
    }

    public static /* synthetic */ void a(Context context) {
        la.s.f().w();
        c1.g(c1.x(context, "favicons"));
        c1.g(c1.B(context));
        x0.c().a();
    }

    public static /* synthetic */ void b(Context context) {
        try {
            o0.a(context);
            x0.c().a();
            o0.b(context, la.s.j());
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ void c(Context context) {
        WebViewDatabase webViewDatabase = WebViewDatabase.getInstance(context);
        webViewDatabase.clearFormData();
        webViewDatabase.clearHttpAuthUsernamePassword();
        CookieSyncManager.createInstance(context);
        CookieManager cookieManager = CookieManager.getInstance();
        if (Build.VERSION.SDK_INT < 21) {
            cookieManager.removeAllCookie();
        } else {
            cookieManager.removeAllCookies(null);
            cookieManager.flush();
        }
    }

    public static String h(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() == 1) {
                sb2.append('0');
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }

    public static void i(final Context context) {
        h.b(new Runnable() { // from class: x8.w
            @Override // java.lang.Runnable
            public final void run() {
                z.b(context);
            }
        });
    }

    public static void j() {
        WebStorage.getInstance().deleteAllData();
    }

    public static void k(Context context) {
        if (context == null) {
            return;
        }
        WebView webView = new WebView(context);
        webView.clearCache(true);
        webView.clearSslPreferences();
        webView.destroy();
    }

    public static void l(final Context context) {
        h.b(new Runnable() { // from class: x8.x
            @Override // java.lang.Runnable
            public final void run() {
                z.c(context);
            }
        });
    }

    public static void m(Context context) {
        WebViewDatabase.getInstance(context).clearFormData();
    }

    public static void n(final Context context) {
        h.b(new Runnable() { // from class: x8.v
            @Override // java.lang.Runnable
            public final void run() {
                z.a(context);
            }
        });
    }

    public static void o(Context context) {
        File dataDir = Build.VERSION.SDK_INT >= 24 ? context.getDataDir() : new File(context.getApplicationInfo().dataDir);
        if (dataDir == null || !dataDir.exists()) {
            return;
        }
        String[] strArr = {"app_webview/Default/Service Worker/CacheStorage", "app_webview/Default/Service Worker/ScriptCache", "app_webview/Default/GPUCache", "app_webview/BrowserMetrics"};
        for (int i10 = 0; i10 < 4; i10++) {
            c1.f(new File(dataDir, strArr[i10]));
        }
    }

    public static boolean p(String str) {
        boolean z10 = r(str) || q(str);
        if (z10 && Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().flush();
        }
        return z10;
    }

    public static boolean q(String str) {
        int i10 = 0;
        if (str == null || str.isEmpty() || Build.VERSION.SDK_INT < 21) {
            return false;
        }
        try {
            okhttp3.r rVarK = okhttp3.r.k(str);
            ArrayList arrayList = new ArrayList();
            arrayList.add("");
            Iterator it = rVarK.h().iterator();
            String str2 = "";
            while (it.hasNext()) {
                str2 = str2 + "/" + ((String) it.next());
                arrayList.add(str2);
            }
            ArrayList<String> arrayList2 = new ArrayList();
            String strL = rVarK.l();
            arrayList2.add(strL);
            String strC = rVarK.C();
            if (strC != null) {
                while (!strL.equals(strC)) {
                    strL = strL.substring(strL.indexOf(46) + 1);
                    arrayList2.add(strL);
                }
            }
            arrayList2.add("");
            CookieManager cookieManager = CookieManager.getInstance();
            Iterator it2 = t(str).iterator();
            while (it2.hasNext()) {
                String[] strArrSplit = ((String) it2.next()).split(";");
                ArrayList<x.d> arrayList3 = new ArrayList();
                int length = strArrSplit.length;
                int i11 = 0;
                while (true) {
                    String strTrim = null;
                    if (i11 >= length) {
                        break;
                    }
                    String[] strArrSplit2 = strArrSplit[i11].split("=", 2);
                    String strTrim2 = strArrSplit2[i10].trim();
                    if (strArrSplit2.length == 2) {
                        strTrim = strArrSplit2[1].trim();
                    }
                    arrayList3.add(new x.d(strTrim2, strTrim));
                    i11++;
                }
                String str3 = (String) ((x.d) arrayList3.get(i10)).f14455a;
                x.d dVar = null;
                x.d dVar2 = null;
                for (x.d dVar3 : arrayList3) {
                    if ("path".equalsIgnoreCase((String) dVar3.f14455a)) {
                        dVar = dVar3;
                    }
                    if ("domain".equalsIgnoreCase((String) dVar3.f14455a)) {
                        dVar2 = dVar3;
                    }
                }
                if (dVar == null || dVar2 == null) {
                    for (String str4 : arrayList2) {
                        Iterator it3 = arrayList.iterator();
                        while (it3.hasNext()) {
                            cookieManager.setCookie(str, str3 + "=;Domain=" + str4 + ";Path=" + ((String) it3.next()) + ";Max-Age=0", null);
                        }
                    }
                } else {
                    cookieManager.setCookie(str, str3 + "=;Path=" + ((String) dVar.f14456b) + ";Max-Age=0", null);
                    cookieManager.setCookie(str, str3 + "=;Domain=" + ((String) dVar2.f14456b) + ";Path=" + ((String) dVar.f14456b) + ";Max-Age=0", null);
                }
                i10 = 0;
            }
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public static boolean r(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                okhttp3.r rVarK = okhttp3.r.k(str);
                ArrayList arrayList = new ArrayList();
                String strL = rVarK.l();
                String strC = rVarK.C();
                while (true) {
                    arrayList.add(strL);
                    arrayList.add("." + strL);
                    if (strL.equals(strC)) {
                        break;
                    }
                    int iIndexOf = strL.indexOf(46);
                    if (strC == null || iIndexOf < 0) {
                        break;
                    }
                    strL = strL.substring(iIndexOf + 1);
                }
                File file = new File("/data/user/0/mark.via", "app_webview/Default/Cookies");
                if (!file.isFile()) {
                    return false;
                }
                try {
                    SQLiteDatabase sQLiteDatabaseOpenDatabase = SQLiteDatabase.openDatabase(file.getAbsolutePath(), null, 0);
                    try {
                        sQLiteDatabaseOpenDatabase.beginTransaction();
                        try {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                sQLiteDatabaseOpenDatabase.delete("cookies", "host_key = ?", new String[]{(String) it.next()});
                            }
                            sQLiteDatabaseOpenDatabase.setTransactionSuccessful();
                            sQLiteDatabaseOpenDatabase.endTransaction();
                            sQLiteDatabaseOpenDatabase.close();
                            return true;
                        } catch (Throwable th) {
                            sQLiteDatabaseOpenDatabase.endTransaction();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        if (sQLiteDatabaseOpenDatabase != null) {
                            try {
                                sQLiteDatabaseOpenDatabase.close();
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                } catch (Exception e10) {
                    tc.a.k(e10, "Failed to delete cookies for host: %s", rVarK.l());
                }
            } catch (IllegalArgumentException unused) {
            }
        }
        return false;
    }

    public static CharSequence s(Context context, SslCertificate sslCertificate) {
        X509Certificate x509Certificate;
        if (sslCertificate == null) {
            return context.getString(w7.u.Y8);
        }
        DateFormat dateTimeInstance = DateFormat.getDateTimeInstance(1, 3);
        Spanned spannedA = w.a.a(context.getString(w7.u.f14053g2, com.tuyafeng.support.utils.p.n(sslCertificate.getIssuedTo().getCName(), " - "), com.tuyafeng.support.utils.p.n(sslCertificate.getIssuedTo().getOName(), " - "), com.tuyafeng.support.utils.p.n(sslCertificate.getIssuedTo().getUName(), " - "), com.tuyafeng.support.utils.p.n(sslCertificate.getIssuedBy().getCName(), " - "), com.tuyafeng.support.utils.p.n(sslCertificate.getIssuedBy().getOName(), " - "), dateTimeInstance.format(sslCertificate.getValidNotBeforeDate()), dateTimeInstance.format(sslCertificate.getValidNotAfterDate())), 0);
        if (Build.VERSION.SDK_INT < 29 || (x509Certificate = sslCertificate.getX509Certificate()) == null) {
            return spannedA;
        }
        try {
            return TextUtils.concat(spannedA, "\n", w.a.a(context.getString(w7.u.f14067h2, com.tuyafeng.support.utils.p.n(v0.f(x509Certificate.getEncoded()), " - "), com.tuyafeng.support.utils.p.n(v0.f(x509Certificate.getPublicKey().getEncoded()), " - ")), 0));
        } catch (NullPointerException | CertificateEncodingException e10) {
            tc.a.b(e10);
            return spannedA;
        }
    }

    public static List t(String str) {
        CookieManager cookieManager = CookieManager.getInstance();
        if (Build.VERSION.SDK_INT >= 24 && r0.l.a("GET_COOKIE_INFO")) {
            return r0.a.b(cookieManager, str);
        }
        String cookie = cookieManager.getCookie(str);
        return (cookie == null || cookie.isEmpty()) ? Collections.EMPTY_LIST : com.tuyafeng.support.utils.p.o(cookie, ';');
    }

    public static String u(String str) {
        return CookieManager.getInstance().getCookie(str);
    }

    public static String v(Context context, long j10) {
        String str;
        double d10 = j10;
        if (d10 >= 8.589934592E8d) {
            Double.isNaN(d10);
            d10 = ((d10 / 1024.0d) / 1024.0d) / 1024.0d;
            str = "GB";
        } else if (d10 >= 838860.8d) {
            Double.isNaN(d10);
            d10 = (d10 / 1024.0d) / 1024.0d;
            str = "MB";
        } else if (d10 >= 819.2d) {
            Double.isNaN(d10);
            d10 /= 1024.0d;
            str = "KB";
        } else {
            str = "B";
        }
        return String.format(Locale.ROOT, "%.1f %s", Double.valueOf(d10), str);
    }

    public static String w(Context context, long j10) {
        return v(context, j10 * 1024);
    }

    public static int x(String str) {
        return y(str, 100);
    }

    public static int y(String str, int i10) {
        String strH = H(str);
        String strSubstring = strH.substring(0, 3);
        String strSubstring2 = strH.substring((strH.length() / 2) - 3, strH.length() / 2);
        String strSubstring3 = strH.substring(strH.length() - 3);
        return Color.rgb((Integer.parseInt(strSubstring, 16) % 128) + i10, (Integer.parseInt(strSubstring3, 16) % 128) + i10, (Integer.parseInt(strSubstring2, 16) % 128) + i10);
    }

    public static String z(Intent intent, String str) {
        String stringExtra;
        String strW = null;
        if (intent != null && (intent.getFlags() & 1048576) == 0) {
            String action = intent.getAction();
            if (action != null) {
                if (action.equalsIgnoreCase("mark.via.BOOKMARK")) {
                    strW = "v://bookmarks";
                } else if (action.equalsIgnoreCase("mark.via.HISTORY")) {
                    strW = "v://history";
                } else if ("mark.via.SCAN".equalsIgnoreCase(intent.getAction())) {
                    strW = "v://scanner";
                } else if ("mark.via.DOWNLOADER".equalsIgnoreCase(intent.getAction())) {
                    strW = "v://downloader";
                } else if ("mark.via.READ_ALOUD".equalsIgnoreCase(intent.getAction())) {
                    strW = "v://readaloud";
                } else if ("mark.via.SEARCH".equalsIgnoreCase(intent.getAction())) {
                    strW = "v://search";
                } else if (action.equalsIgnoreCase("android.intent.action.SEND") && (stringExtra = intent.getStringExtra("android.intent.extra.TEXT")) != null && !stringExtra.isEmpty()) {
                    strW = c6.a2.f1958a.w(stringExtra, str);
                }
            }
            if (strW != null && !strW.isEmpty()) {
                return strW;
            }
            if (intent.hasExtra("OPEN")) {
                return intent.getStringExtra("OPEN");
            }
            if (intent.hasExtra("query")) {
                return c6.y1.f2139a.h(str, intent.getStringExtra("query"));
            }
            if (Build.VERSION.SDK_INT >= 23 && intent.hasExtra("android.intent.extra.PROCESS_TEXT")) {
                return c6.y1.f2139a.h(str, intent.getStringExtra("android.intent.extra.PROCESS_TEXT"));
            }
            if (intent.getDataString() != null) {
                return intent.getDataString();
            }
        }
        return strW;
    }
}
