package x8;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.chromium.support_lib_boundary.ProcessGlobalConfigConstants;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class q2 {
    public static int a() {
        return c6.r1.f2100c.b(Locale.getDefault().getCountry());
    }

    public static List b(Context context) {
        ArrayList arrayList = new ArrayList();
        Locale locale = Locale.getDefault();
        Iterator it = c6.r1.f2100c.a(locale.getCountry(), locale.getLanguage(), !a0.i()).iterator();
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            arrayList.add(ga.c.i(iIntValue, context.getString(h(iIntValue))));
        }
        return arrayList;
    }

    public static c6.r1 c(int i10, String str) {
        return c6.r1.f2100c.d(i10, str, Locale.getDefault().getCountry());
    }

    public static String d(Context context, int i10) {
        if (i10 <= 0) {
            int iH = h(i10);
            return iH == 0 ? "" : context.getString(iH);
        }
        ga.c cVarC = la.s.f().z().c(i10);
        return (cVarC == null || cVarC.h() != 2) ? "" : cVarC.g();
    }

    public static List e(Context context) {
        List listB = b(context);
        listB.addAll(la.s.f().z().b(2));
        return listB;
    }

    public static int f(int i10, int i11) {
        return c6.r1.f2100c.e(i10, i11);
    }

    public static boolean g(int i10) {
        return c6.r1.f2100c.c(i10);
    }

    public static int h(int i10) {
        switch (i10) {
            case -12:
                return w7.u.f14320z8;
            case -11:
                return w7.u.Vg;
            case -10:
                return w7.u.f14290x4;
            case -9:
                return w7.u.zd;
            case -8:
                return w7.u.Ai;
            case -7:
                return w7.u.Bi;
            case -6:
                return w7.u.pd;
            case -5:
                return w7.u.f14127l6;
            case -4:
                return w7.u.Mc;
            case -3:
                return w7.u.f14248u1;
            case -2:
                return w7.u.f14234t1;
            case ProcessGlobalConfigConstants.UI_THREAD_STARTUP_MODE_DEFAULT /* -1 */:
                return w7.u.f14085i6;
            default:
                return 0;
        }
    }
}
