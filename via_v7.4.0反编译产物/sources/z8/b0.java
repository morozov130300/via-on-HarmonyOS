package z8;

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
import android.webkit.WebIconDatabase;
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
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.json.JSONObject;
import org.simpleframework.xml.strategy.Name;
import w5.k;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class b0 {

    /* renamed from: a, reason: collision with root package name */
    public static WeakHashMap f14682a;

    public static String A(Intent intent, String str) {
        String stringExtra;
        String strV = null;
        if (intent == null) {
            return null;
        }
        String action = intent.getAction();
        if (action != null) {
            if (action.equalsIgnoreCase("mark.via.BOOKMARK")) {
                strV = "v://bookmarks";
            } else if (action.equalsIgnoreCase("mark.via.HISTORY")) {
                strV = "v://history";
            } else if ("mark.via.SCAN".equalsIgnoreCase(intent.getAction())) {
                strV = "v://scanner";
            } else if ("mark.via.DOWNLOADER".equalsIgnoreCase(intent.getAction())) {
                strV = "v://downloader";
            } else if ("mark.via.READ_ALOUD".equalsIgnoreCase(intent.getAction())) {
                strV = "v://readaloud";
            } else if ("mark.via.SEARCH".equalsIgnoreCase(intent.getAction())) {
                strV = "v://search";
            } else if (action.equalsIgnoreCase("android.intent.action.SEND") && (stringExtra = intent.getStringExtra("android.intent.extra.TEXT")) != null && !stringExtra.isEmpty()) {
                strV = i6.i0.f7006a.v(stringExtra, str);
            }
        }
        return (strV == null || strV.isEmpty()) ? intent.hasExtra("OPEN") ? intent.getStringExtra("OPEN") : intent.hasExtra("query") ? i6.g0.f6993a.h(str, intent.getStringExtra("query")) : (Build.VERSION.SDK_INT < 23 || !intent.hasExtra("android.intent.extra.PROCESS_TEXT")) ? intent.getDataString() != null ? intent.getDataString() : strV : "mark.via.TRANSLATE".equals(action) ? w2.n(intent.getStringExtra("android.intent.extra.PROCESS_TEXT")) : i6.g0.f6993a.h(str, intent.getStringExtra("android.intent.extra.PROCESS_TEXT")) : strV;
    }

    public static int B(Context context) {
        int iA = k5.t.a(context);
        if (iA != 0) {
            return iA != 2 ? 1 : 2;
        }
        return 0;
    }

    public static int C(String str) throws NoSuchAlgorithmException {
        String strI = I(str);
        int i10 = Integer.parseInt(strI.substring(0, 3), 16) + Integer.parseInt(strI.substring((strI.length() / 2) - 3, strI.length() / 2), 16) + Integer.parseInt(strI.substring(strI.length() - 3), 16);
        do {
            i10 /= 2;
        } while (i10 > 80);
        return i10;
    }

    public static String D(String str) {
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

    public static String E(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        String strF = i6.g0.f6993a.f(str);
        return strF.length() <= 8192 ? strF : strF.substring(0, 8192);
    }

    public static String F(String str) {
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

    public static String G(String str, String str2) {
        String strG;
        if (str2 == null || str == null) {
            return str;
        }
        if (str2.length() > 38 && ((str.length() == 7 && "QQ\u6d4f\u89c8\u5668\u641c\u7d22".equals(str)) || (str.length() == 8 && "QQ \u6d4f\u89c8\u5668\u641c\u7d22".equals(str)))) {
            String strG2 = i6.g0.f6993a.g(str2, "https://wap.sogou.com/web/sl?keyword=");
            if (strG2 != null && !strG2.isEmpty()) {
                return strG2 + " - " + str;
            }
        } else if (str2.length() > 47 && (((str.length() == 6 && "\u79d8\u5854AI\u641c\u7d22".equals(str)) || (str.length() == 8 && "\u79d8\u5854 AI \u641c\u7d22".equals(str))) && (strG = i6.g0.f6993a.g(str2, "https://metaso.cn/search/3333?q=")) != null && !strG.isEmpty())) {
            return strG + " - " + str;
        }
        return ((str.length() == 6 && "\u7f51\u9875\u65e0\u6cd5\u6253\u5f00".equals(str)) || (str.length() == 21 && "Webpage not available".equals(str))) ? i6.g0.f6993a.b(str2) : str;
    }

    public static boolean H(Intent intent) {
        if (intent == null) {
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

    public static String I(String str) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes(m8.a.f8676a));
            return h(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return String.valueOf(str.hashCode());
        }
    }

    public static boolean J(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        return (str.startsWith("192.168.") || "x.com".equals(str) || "metaso.cn".equals(str) || str.contains("forum.softpedia.com") || str.contains("3g.163.com") || str.contains("bbs.binmt.cc") || str.contains("www.giant.com.cn") || str.contains("www.10099.com.cn") || str.contains(".10086.cn") || str.contains(".10010.com") || str.contains("myaccount.google.com") || str.contains("accounts.google.com")) ? false : true;
    }

    public static boolean K(String str) {
        if (str == null || str.length() < 5) {
            return false;
        }
        String[] strArr = {"login", "signup", "signin", "register", "sign-up", "create-account", "createaccount", "auth"};
        int iD = -1;
        int length = 0;
        for (int i10 = 0; i10 < 8; i10++) {
            String str2 = strArr[i10];
            length = str2.length();
            iD = g6.p.d(str, str2);
            if (iD > 0) {
                break;
            }
        }
        if (iD <= 0) {
            return false;
        }
        char cCharAt = str.charAt(iD - 1);
        if (i6.f.f6990a.f(cCharAt, 3, new int[]{61})) {
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
        return !r3.f(cCharAt2, 3, null);
    }

    public static boolean L(Intent intent) {
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

    public static boolean M(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return URLUtil.isValidUrl(str) || str.startsWith("ftp://") || str.startsWith("view-source:") || N(str);
    }

    public static boolean N(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return w2.z(str) || w2.t(str) || w2.u(str);
    }

    public static void O(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        context.startActivity(Intent.createChooser(intent, context.getString(x7.u.Nf)));
    }

    public static void P(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.setComponent(new ComponentName(context, (Class<?>) Shell.class));
        intent.putExtra("intent", "mark.via.BROWSER");
        context.startActivity(intent);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static w.d Q(String str) {
        int i10 = 3;
        char c10 = 0;
        String strSubstring = null;
        if (w2.z(str)) {
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
                        c10 = '\uffff';
                        break;
                    }
                    break;
                case 107332:
                    if (strSubstring2.equals("log")) {
                        c10 = 1;
                        break;
                    }
                    break;
                case 3208415:
                    if (strSubstring2.equals("home")) {
                        c10 = 2;
                        break;
                    }
                    break;
                case 92611469:
                    if (strSubstring2.equals("about")) {
                        c10 = 3;
                        break;
                    }
                    break;
                case 926934164:
                    if (strSubstring2.equals("history")) {
                        c10 = 4;
                        break;
                    }
                    break;
                case 2037187069:
                    if (strSubstring2.equals("bookmarks")) {
                        c10 = 5;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                    i10 = 7;
                    break;
                case 1:
                    i10 = 6;
                    break;
                case 2:
                    i10 = 1;
                    break;
                case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                    i10 = 4;
                    break;
                case 4:
                    break;
                case 5:
                    i10 = 2;
                    break;
                default:
                    i10 = 5;
                    break;
            }
        } else if (!w2.u(str)) {
            if (w2.t(str)) {
                strSubstring = str.substring(9);
                i10 = 2;
            } else {
                i10 = 0;
            }
        }
        return new w.d(Integer.valueOf(i10), strSubstring);
    }

    public static boolean R(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        return (str.contains("youku.com") || str.contains("youtube.com") || str.contains("v.qq.com") || str.contains("film.qq.com") || str.contains("mgtv.com") || str.contains("iqiyi.com") || str.contains("douyin.com")) ? false : true;
    }

    public static boolean S(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        return (str.contains("youku.com") || str.contains("youtube.com") || str.contains("v.qq.com") || str.contains("film.qq.com") || str.contains("mgtv.com") || str.contains("iqiyi.com") || str.contains("douyin.com")) ? false : true;
    }

    public static void T(final Context context, final String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        w5.k.l(context).e0(context.getString(x7.u.f14008h9)).J(str).V(R.string.ok, new k.m() { // from class: z8.v
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                b0.P(context, str);
            }
        }).N(R.string.cancel, null).R(R.string.copy, new View.OnClickListener() { // from class: z8.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g6.n.a(context, str, x7.u.pg);
            }
        }).f0();
    }

    public static void U() {
        GeolocationPermissions.getInstance().clearAll();
    }

    public static void V(WebView webView, int i10) {
        Animator animator;
        if (webView == null || webView.getContext() == null) {
            return;
        }
        WeakHashMap weakHashMap = f14682a;
        if (weakHashMap == null || (animator = (Animator) weakHashMap.get(webView)) == null || !animator.isRunning()) {
            float f10 = webView.getContext().getResources().getDisplayMetrics().density;
            int measuredHeight = webView.getMeasuredHeight();
            int scrollY = webView.getScrollY();
            int iMin = i10 != 1 ? i10 != 2 ? i10 != 3 ? -scrollY : Math.min((measuredHeight / 5) * 4, (int) (((webView.getContentHeight() * f10) - measuredHeight) - scrollY)) : -Math.min((measuredHeight / 5) * 4, scrollY) : ((int) (webView.getContentHeight() * f10)) - scrollY;
            if (iMin == 0) {
                return;
            }
            long jMin = (long) ((Math.min(1.0f, Math.abs(iMin) / 3000.0f) * 400.0f) + 100.0f);
            if (f14682a == null) {
                f14682a = new WeakHashMap();
            }
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(webView, "scrollY", scrollY, iMin + scrollY);
            objectAnimatorOfInt.setDuration(jMin);
            objectAnimatorOfInt.setInterpolator(new AccelerateDecelerateInterpolator());
            objectAnimatorOfInt.setAutoCancel(true);
            f14682a.put(webView, objectAnimatorOfInt);
            objectAnimatorOfInt.start();
        }
    }

    public static void W(final Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            f1.j(context, new Intent("android.settings.MANAGE_DEFAULT_APPS_SETTINGS"));
            return;
        }
        String str = m8.a.f8679d;
        final Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        String str2 = resolveInfoResolveActivity == null ? null : resolveInfoResolveActivity.activityInfo.packageName;
        if ("android".equals(str2)) {
            g6.n.n(context, context.getString(x7.u.f14081mc), context.getString(x7.u.f14067lc, i6.g0.f6993a.d(str)), new k.m() { // from class: z8.a0
                @Override // w5.k.m
                public final void a(View view, k.p pVar) {
                    context.startActivity(intent);
                }
            });
            return;
        }
        if ("mark.via".equals(str2)) {
            g6.n.s(context, context.getString(x7.u.f13902a1));
            return;
        }
        final Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + str2));
        g6.n.n(context, context.getString(x7.u.f14081mc), context.getResources().getString(x7.u.mg), new k.m() { // from class: z8.u
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                context.startActivity(intent2);
            }
        });
    }

    public static boolean X(String str) {
        return str == null || str.isEmpty() || !str.contains("youtube.com");
    }

    public static boolean Y(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        return (str.contains("youku.com") || str.contains("youtube.com") || str.contains("douyin.com") || str.contains("gaze.run")) ? false : true;
    }

    public static /* synthetic */ void a(Context context) {
        pa.r.f().w();
        c1.g(c1.v(context, "favicons"));
        c1.g(c1.z(context));
        x0.c().a();
    }

    public static /* synthetic */ void b(Context context) {
        try {
            o0.a(context);
            x0.c().a();
            o0.b(context, pa.r.j());
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ void c(Context context) {
        WebViewDatabase webViewDatabase = WebViewDatabase.getInstance(context);
        webViewDatabase.clearFormData();
        webViewDatabase.clearHttpAuthUsernamePassword();
        if (m8.a.f8678c < 18) {
            webViewDatabase.clearUsernamePassword();
        }
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
        h.b(new Runnable() { // from class: z8.y
            @Override // java.lang.Runnable
            public final void run() {
                b0.b(context);
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
        h.b(new Runnable() { // from class: z8.z
            @Override // java.lang.Runnable
            public final void run() {
                b0.c(context);
            }
        });
    }

    public static void m(Context context) {
        WebViewDatabase.getInstance(context).clearFormData();
    }

    public static void n(final Context context) {
        h.b(new Runnable() { // from class: z8.x
            @Override // java.lang.Runnable
            public final void run() {
                b0.a(context);
            }
        });
        if (m8.a.f8678c < 18) {
            WebIconDatabase.getInstance().removeAllIcons();
        }
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
            String strB = rVarK.B();
            if (strB != null) {
                while (!strL.equals(strB)) {
                    strL = strL.substring(strL.indexOf(46) + 1);
                    arrayList2.add(strL);
                }
            }
            arrayList2.add("");
            CookieManager cookieManager = CookieManager.getInstance();
            Iterator it2 = u(str).iterator();
            while (it2.hasNext()) {
                String[] strArrSplit = ((String) it2.next()).split(";");
                ArrayList<w.d> arrayList3 = new ArrayList();
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
                    arrayList3.add(new w.d(strTrim2, strTrim));
                    i11++;
                }
                String str3 = (String) ((w.d) arrayList3.get(i10)).f13207a;
                w.d dVar = null;
                w.d dVar2 = null;
                for (w.d dVar3 : arrayList3) {
                    if ("path".equalsIgnoreCase((String) dVar3.f13207a)) {
                        dVar = dVar3;
                    }
                    if ("domain".equalsIgnoreCase((String) dVar3.f13207a)) {
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
                    cookieManager.setCookie(str, str3 + "=;Path=" + ((String) dVar.f13208b) + ";Max-Age=0", null);
                    cookieManager.setCookie(str, str3 + "=;Domain=" + ((String) dVar2.f13208b) + ";Path=" + ((String) dVar.f13208b) + ";Max-Age=0", null);
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
                String strB = rVarK.B();
                while (true) {
                    arrayList.add(strL);
                    arrayList.add("." + strL);
                    if (strL.equals(strB)) {
                        break;
                    }
                    int iIndexOf = strL.indexOf(46);
                    if (strB == null || iIndexOf < 0) {
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
                    } finally {
                    }
                } catch (Exception e10) {
                    pc.a.j(e10, "Failed to delete cookies for host: %s", rVarK.l());
                }
            } catch (IllegalArgumentException unused) {
            }
        }
        return false;
    }

    public static n9.a s(String str) {
        if (str == null || str.length() <= 10) {
            return null;
        }
        n9.a aVar = new n9.a();
        try {
            JSONObject jSONObject = new JSONObject(v0.a(str));
            if (!jSONObject.isNull(Name.MARK) && !jSONObject.isNull("code")) {
                aVar.s(jSONObject.optInt(Name.MARK));
                aVar.r(jSONObject.optString("name"));
                aVar.m(jSONObject.optString("author"));
                aVar.u(jSONObject.optString("url"));
                aVar.q(jSONObject.optString("info"));
                aVar.n(jSONObject.optString("code"));
                return aVar;
            }
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            return aVar;
        }
    }

    public static CharSequence t(Context context, SslCertificate sslCertificate) {
        X509Certificate x509Certificate;
        if (sslCertificate == null) {
            return context.getString(x7.u.M8);
        }
        DateFormat dateTimeInstance = DateFormat.getDateTimeInstance(1, 3);
        Spanned spannedA = v.a.a(context.getString(x7.u.T1, g6.p.n(sslCertificate.getIssuedTo().getCName(), " - "), g6.p.n(sslCertificate.getIssuedTo().getOName(), " - "), g6.p.n(sslCertificate.getIssuedTo().getUName(), " - "), g6.p.n(sslCertificate.getIssuedBy().getCName(), " - "), g6.p.n(sslCertificate.getIssuedBy().getOName(), " - "), dateTimeInstance.format(sslCertificate.getValidNotBeforeDate()), dateTimeInstance.format(sslCertificate.getValidNotAfterDate())), 0);
        if (Build.VERSION.SDK_INT < 29 || (x509Certificate = sslCertificate.getX509Certificate()) == null) {
            return spannedA;
        }
        try {
            return TextUtils.concat(spannedA, "\n", v.a.a(context.getString(x7.u.U1, g6.p.n(v0.f(x509Certificate.getEncoded()), " - "), g6.p.n(v0.f(x509Certificate.getPublicKey().getEncoded()), " - ")), 0));
        } catch (NullPointerException | CertificateEncodingException e10) {
            pc.a.b(e10);
            return spannedA;
        }
    }

    public static List u(String str) {
        CookieManager cookieManager = CookieManager.getInstance();
        if (q0.g.a("GET_COOKIE_INFO")) {
            return q0.a.b(cookieManager, str);
        }
        String cookie = cookieManager.getCookie(str);
        return (cookie == null || cookie.isEmpty()) ? Collections.EMPTY_LIST : g6.p.o(cookie, ';');
    }

    public static String v(String str) {
        return CookieManager.getInstance().getCookie(str);
    }

    public static String w(Context context, long j10) {
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

    public static String x(Context context, long j10) {
        return w(context, j10 * 1024);
    }

    public static int y(String str) {
        return z(str, 100);
    }

    public static int z(String str, int i10) throws NoSuchAlgorithmException {
        String strI = I(str);
        String strSubstring = strI.substring(0, 3);
        String strSubstring2 = strI.substring((strI.length() / 2) - 3, strI.length() / 2);
        String strSubstring3 = strI.substring(strI.length() - 3);
        return Color.rgb((Integer.parseInt(strSubstring, 16) % 128) + i10, (Integer.parseInt(strSubstring3, 16) % 128) + i10, (Integer.parseInt(strSubstring2, 16) % 128) + i10);
    }
}
