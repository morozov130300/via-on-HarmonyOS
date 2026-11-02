package z8;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class v2 {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a() {
        char c10 = 0;
        boolean z10 = c0.i() && !f.h();
        String strO = z10 ? r9.g.a().o() : r9.g.a().b();
        if (strO == null || strO.isEmpty()) {
            return z10 ? -1 : -2;
        }
        switch (strO.hashCode()) {
            case 3138:
                if (!strO.equals("bd")) {
                    c10 = '\uffff';
                    break;
                }
                break;
            case 3148:
                if (strO.equals("bn")) {
                    c10 = 1;
                    break;
                }
                break;
            case 3296:
                if (strO.equals("gg")) {
                    c10 = 2;
                    break;
                }
                break;
            case 3339:
                if (strO.equals("hs")) {
                    c10 = 3;
                    break;
                }
                break;
            case 3495:
                if (strO.equals("mt")) {
                    c10 = 4;
                    break;
                }
                break;
            case 3668:
                if (strO.equals("sg")) {
                    c10 = 5;
                    break;
                }
                break;
            case 3674:
                if (strO.equals("sm")) {
                    c10 = 6;
                    break;
                }
                break;
            case 3712:
                if (strO.equals("tt")) {
                    c10 = 7;
                    break;
                }
                break;
            case 3855:
                if (strO.equals("yh")) {
                    c10 = '\b';
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return -2;
            case 1:
                return -3;
            case 2:
                return -1;
            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                return -5;
            case 4:
                return -12;
            case 5:
                return -6;
            case 6:
                return -4;
            case 7:
                return -11;
            case '\b':
                return -8;
            default:
                return z10 ? -1 : -2;
        }
    }

    public static List b(Context context) {
        ArrayList arrayList = new ArrayList();
        Locale locale = Locale.getDefault();
        String country = locale.getCountry();
        Locale locale2 = Locale.ROOT;
        String upperCase = country.toUpperCase(locale2);
        String upperCase2 = locale.getLanguage().toUpperCase(locale2);
        boolean zEquals = "CN".equals(upperCase);
        if (zEquals) {
            arrayList.add(ja.c.i(-2, context.getString(x7.u.f14112p1)));
        }
        arrayList.add(ja.c.i(-1, context.getString(x7.u.W5)));
        if ("RU".equals(upperCase2)) {
            arrayList.add(ja.c.i(-7, context.getString(x7.u.Wh)));
        }
        if (!zEquals) {
            arrayList.add(ja.c.i(-2, context.getString(x7.u.f14112p1)));
        }
        arrayList.add(ja.c.i(-3, context.getString(x7.u.f14126q1)));
        if (zEquals) {
            if (!c0.j()) {
                arrayList.add(ja.c.i(-12, context.getString(x7.u.f14091n8)));
            }
            arrayList.add(ja.c.i(-6, context.getString(x7.u.Zc)));
            arrayList.add(ja.c.i(-11, context.getString(x7.u.Ig)));
            arrayList.add(ja.c.i(-4, context.getString(x7.u.xc)));
            arrayList.add(ja.c.i(-5, context.getString(x7.u.Z5)));
        }
        if (!zEquals) {
            arrayList.add(ja.c.i(-8, context.getString(x7.u.Vh)));
            arrayList.add(ja.c.i(-9, context.getString(x7.u.jd)));
        }
        arrayList.add(ja.c.i(-10, context.getString(x7.u.f14045k4)));
        return arrayList;
    }

    public static z9.h c(int i10, String str) {
        switch (i10) {
            case -12:
                return new z9.g();
            case -11:
                return new z9.l();
            case -10:
                return new z9.d();
            case -9:
                return new z9.k();
            case -8:
                return new z9.m();
            case -7:
                return new z9.n();
            case -6:
                return new z9.j();
            case -5:
                return new z9.f();
            case -4:
                return new z9.i();
            case -3:
                return new z9.b();
            case -2:
                return new z9.a();
            case -1:
                return new z9.e();
            default:
                return (str == null || str.isEmpty()) ? c(a(), "https://www.google.com/search?q=") : new z9.c(str);
        }
    }

    public static String d(Context context, int i10) {
        if (i10 == 0) {
            return "";
        }
        if (i10 >= 0) {
            ja.c cVarD = pa.r.f().z().d(i10);
            return (cVarD == null || cVarD.h() != 2) ? "" : cVarD.g();
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
        listB.addAll(pa.r.f().z().c(2));
        return listB;
    }

    public static int f(int i10, int i11) {
        if (i10 == -5) {
            return 4;
        }
        if (i10 == -3) {
            return 3;
        }
        if (i10 == -2) {
            return 2;
        }
        if (i10 != -1) {
            return i11;
        }
        return 1;
    }

    public static boolean g(int i10) {
        return i10 > 0 || i10 <= -999;
    }
}
