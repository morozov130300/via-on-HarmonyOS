package x8;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.tuyafeng.wormhole.UserAgentPreset;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class c4 {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14553a;

        static {
            int[] iArr = new int[UserAgentPreset.values().length];
            f14553a = iArr;
            try {
                iArr[UserAgentPreset.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14553a[UserAgentPreset.ANDROID_PHONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14553a[UserAgentPreset.ANDROID_TABLET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14553a[UserAgentPreset.WINDOWS_CHROME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14553a[UserAgentPreset.WINDOWS_IE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14553a[UserAgentPreset.OSX_CHROME.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14553a[UserAgentPreset.IPHONE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f14553a[UserAgentPreset.IPAD.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f14553a[UserAgentPreset.SYMBIAN.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public static String a(Context context) {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        try {
            return WebSettings.getDefaultUserAgent(context);
        } catch (Exception e10) {
            tc.a.j(e10);
            return null;
        }
    }

    public static List b(Context context) {
        ArrayList arrayList = new ArrayList();
        for (UserAgentPreset userAgentPreset : UserAgentPreset.values()) {
            arrayList.add(ga.c.l(userAgentPreset.getPresetId(), context.getString(l(userAgentPreset)), userAgentPreset.getUserAgent()));
        }
        return arrayList;
    }

    public static String c(int i10, String str, String str2, boolean z10, int i11, String str3, boolean z11) {
        String strC;
        if (z10) {
            if (i11 == 0) {
                return UserAgentPreset.WINDOWS_CHROME.getUserAgent();
            }
            str = TextUtils.isEmpty(str3) ? UserAgentPreset.WINDOWS_CHROME.getUserAgent() : str3;
            i10 = i11;
        }
        if (i10 > 0 && (strC = w9.d.d().c(i10)) != null) {
            str = strC;
        }
        String strK = k(i10, str, str2);
        return z11 ? i(strK) : strK;
    }

    public static String d(Context context, int i10) {
        if (i10 <= 0) {
            UserAgentPreset userAgentPresetA = UserAgentPreset.Companion.a(i10);
            return userAgentPresetA != null ? context.getString(l(userAgentPresetA)) : "";
        }
        ga.c cVarC = la.s.f().z().c(i10);
        return (cVarC == null || cVarC.h() != 1) ? "" : cVarC.g();
    }

    public static List e(Context context) {
        List listB = b(context);
        listB.addAll(la.s.f().z().b(1));
        return listB;
    }

    public static boolean f(int i10) {
        return i10 == UserAgentPreset.WINDOWS_CHROME.getPresetId() || i10 == UserAgentPreset.WINDOWS_IE.getPresetId() || i10 == UserAgentPreset.OSX_CHROME.getPresetId();
    }

    public static boolean g(int i10) {
        return i10 > 0 || i10 <= -999;
    }

    public static String h(String str) {
        return str.replaceAll("[\\t\\n\\r]+", " ").trim();
    }

    public static String i(String str) {
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

    public static String j(String str) {
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

    public static String k(int i10, String str, String str2) {
        if (i10 == UserAgentPreset.DEFAULT.getPresetId()) {
            return str2;
        }
        UserAgentPreset userAgentPresetA = UserAgentPreset.Companion.a(i10);
        return userAgentPresetA != null ? userAgentPresetA.getUserAgent() : str;
    }

    public static int l(UserAgentPreset userAgentPreset) {
        switch (a.f14553a[userAgentPreset.ordinal()]) {
            case 1:
                return w7.u.f14110k3;
            case 2:
                return w7.u.H0;
            case 3:
                return w7.u.I0;
            case 4:
                return w7.u.O0;
            case 5:
                return w7.u.P0;
            case 6:
                return w7.u.M0;
            case 7:
                return w7.u.L0;
            case 8:
                return w7.u.K0;
            case 9:
                return w7.u.N0;
            default:
                throw new AssertionError(userAgentPreset);
        }
    }
}
