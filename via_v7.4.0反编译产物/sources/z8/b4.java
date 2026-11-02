package z8;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class b4 {
    public static String a(Context context) {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        try {
            return WebSettings.getDefaultUserAgent(context);
        } catch (Exception e10) {
            pc.a.i(e10);
            return null;
        }
    }

    public static List b(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ja.c.l(0, context.getString(x7.u.Y2), null));
        arrayList.add(ja.c.l(-1, context.getString(x7.u.E0), "Mozilla/5.0 (Linux; Android 13; Pixel 7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Mobile Safari/537.36"));
        arrayList.add(ja.c.l(-2, context.getString(x7.u.F0), "Mozilla/5.0 (Linux; Android 8.1.0; SM-T837A) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Safari/537.36"));
        arrayList.add(ja.c.l(-3, context.getString(x7.u.L0), "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Safari/537.36"));
        arrayList.add(ja.c.l(-4, context.getString(x7.u.M0), "Mozilla/5.0 (Windows NT 10.0; Trident/7.0; rv:11.0) like Gecko"));
        arrayList.add(ja.c.l(-5, context.getString(x7.u.J0), "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Safari/537.36"));
        arrayList.add(ja.c.l(-6, context.getString(x7.u.I0), "Mozilla/5.0 (iPhone; CPU iPhone OS 18_5 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/18.5 Mobile/15E148 Safari/604.1"));
        arrayList.add(ja.c.l(-7, context.getString(x7.u.H0), "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/18.5 Safari/605.1.15"));
        arrayList.add(ja.c.l(-8, context.getString(x7.u.K0), "Mozilla/5.0 (Symbian/3; Series60/5.2 NokiaN8-00/012.002; Profile/MIDP-2.1 Configuration/CLDC-1.1 ) AppleWebKit/533.4 (KHTML, like Gecko) NokiaBrowser/7.3.0 Mobile Safari/533.4 3gpp-gba"));
        return arrayList;
    }

    public static String c(int i10, String str, String str2, boolean z10, int i11, String str3, boolean z11) {
        if (z10) {
            if (i11 == 0) {
                return "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Safari/537.36";
            }
            str = TextUtils.isEmpty(str3) ? "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Safari/537.36" : str3;
            i10 = i11;
        }
        switch (i10) {
            case -8:
                str2 = "Mozilla/5.0 (Symbian/3; Series60/5.2 NokiaN8-00/012.002; Profile/MIDP-2.1 Configuration/CLDC-1.1 ) AppleWebKit/533.4 (KHTML, like Gecko) NokiaBrowser/7.3.0 Mobile Safari/533.4 3gpp-gba";
                break;
            case -7:
                str2 = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/18.5 Safari/605.1.15";
                break;
            case -6:
                str2 = "Mozilla/5.0 (iPhone; CPU iPhone OS 18_5 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/18.5 Mobile/15E148 Safari/604.1";
                break;
            case -5:
                str2 = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Safari/537.36";
                break;
            case -4:
                str2 = "Mozilla/5.0 (Windows NT 10.0; Trident/7.0; rv:11.0) like Gecko";
                break;
            case -3:
                str2 = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Safari/537.36";
                break;
            case -2:
                str2 = "Mozilla/5.0 (Linux; Android 8.1.0; SM-T837A) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Safari/537.36";
                break;
            case -1:
                str2 = "Mozilla/5.0 (Linux; Android 13; Pixel 7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Mobile Safari/537.36";
                break;
            case 0:
                break;
            default:
                str2 = str;
                break;
        }
        return z11 ? h(str2) : str2;
    }

    public static String d(Context context, int i10) {
        if (i10 > 0) {
            ja.c cVarD = pa.r.f().z().d(i10);
            return (cVarD == null || cVarD.h() != 1) ? "" : cVarD.g();
        }
        for (ja.c cVar : b(context)) {
            if (cVar.d() == i10) {
                return cVar.g();
            }
        }
        return "";
    }

    public static List e(Context context) {
        List listB = b(context);
        listB.addAll(pa.r.f().z().c(1));
        return listB;
    }

    public static boolean f(int i10) {
        return i10 > 0 || i10 <= -999;
    }

    public static String g(String str) {
        return str.replaceAll("[\\t\\n\\r]+", " ").trim();
    }

    public static String h(String str) {
        int iIndexOf;
        int iIndexOf2;
        if (str == null || str.length() < 8 || (iIndexOf = str.indexOf("Android")) < 0 || (iIndexOf2 = str.indexOf(") AppleWebKit", iIndexOf)) < 0) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) str, 0, iIndexOf + 7);
        sb2.append(" 10; K");
        int iIndexOf3 = str.indexOf("Chrome/", iIndexOf2);
        if (iIndexOf3 < 0) {
            sb2.append((CharSequence) str, iIndexOf2, str.length());
        } else {
            int iIndexOf4 = str.indexOf(".", iIndexOf3 + 7);
            sb2.append((CharSequence) str, iIndexOf2, iIndexOf4 + 1);
            sb2.append("0.0.0");
            int iIndexOf5 = str.indexOf(" ", iIndexOf4);
            if (iIndexOf5 > 0) {
                sb2.append((CharSequence) str, iIndexOf5, str.length());
            }
        }
        return sb2.toString();
    }

    public static String i(String str) {
        int iIndexOf;
        if (str == null || str.isEmpty() || (iIndexOf = str.indexOf("; wv")) < 0) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder(str);
        sb2.delete(iIndexOf, iIndexOf + 4);
        int iIndexOf2 = sb2.indexOf(" Version/");
        if (iIndexOf2 >= 0) {
            int iIndexOf3 = sb2.indexOf(" ", iIndexOf2 + 1);
            if (iIndexOf3 < 0) {
                iIndexOf3 = sb2.length();
            }
            if (iIndexOf3 > iIndexOf2) {
                sb2.delete(iIndexOf2, iIndexOf3);
            }
        }
        return sb2.toString();
    }
}
