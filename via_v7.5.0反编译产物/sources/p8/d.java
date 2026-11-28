package p8;

import android.content.Context;
import android.util.Pair;
import c6.f0;
import c6.g0;
import c6.h0;
import com.tuyafeng.support.utils.p;
import com.tuyafeng.support.utils.x;
import g9.e;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import la.s;
import r6.j;
import u6.g;
import u9.l;
import u9.n;
import w7.u;
import x8.r2;
import x8.w3;
import x8.z;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    public static /* synthetic */ String c(String str, String str2) {
        return "file://" + str2;
    }

    public static j d(Context context) {
        f0 f0VarL = l(context);
        String absolutePath = new File(context.getFilesDir(), "homepage.css").getAbsolutePath();
        return j.O(g(absolutePath, f0VarL), e(context, new File(context.getFilesDir(), "homepage2.html").getAbsolutePath(), absolutePath, f0VarL), new u6.b() { // from class: p8.a
            @Override // u6.b
            public final Object apply(Object obj, Object obj2) {
                return d.c((String) obj, (String) obj2);
            }
        });
    }

    public static j e(final Context context, final String str, final String str2, final f0 f0Var) {
        return j.v(new Callable() { // from class: p8.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return d.h(context, str, str2, f0Var);
            }
        }).G(a7.a.c());
    }

    public static String f(Context context) {
        f0 f0VarL = l(context);
        String absolutePath = new File(context.getFilesDir(), "homepage.css").getAbsolutePath();
        String absolutePath2 = new File(context.getFilesDir(), "homepage2.html").getAbsolutePath();
        i(absolutePath, f0VarL);
        h(context, absolutePath2, absolutePath, f0VarL);
        return "file://" + absolutePath2;
    }

    public static j g(String str, f0 f0Var) {
        return j.z(new Pair(f0Var, str)).A(new g() { // from class: p8.b
            @Override // u6.g
            public final Object apply(Object obj) {
                Pair pair = (Pair) obj;
                return d.i((String) pair.second, (f0) pair.first);
            }
        }).G(a7.a.c());
    }

    public static String h(Context context, String str, String str2, f0 f0Var) {
        if (!n.e().k() && new File(str).exists()) {
            return str;
        }
        List<l9.b> listH = s.f().h();
        ArrayList arrayList = new ArrayList();
        for (l9.b bVar : listH) {
            String strReplaceAll = bVar.e().trim().replaceAll("<.*?>", "");
            String strG = bVar.g();
            String strReplace = r2.g(strG).replace("\"", "&quot;");
            String strK = k(strG);
            arrayList.add(new g0(strReplace, strReplaceAll, p.a(strReplaceAll), w3.n(strG), strK));
        }
        h0.f2013a.a(new c6.d(str), f0Var, str2, s.j().d0(), arrayList, context.getString(u.D6), context.getString(u.f14092j), context.getString(u.f14063gc));
        n.e().u(false);
        return str;
    }

    public static String i(String str, f0 f0Var) {
        if (!n.e().j() && new File(str).exists()) {
            return str;
        }
        h0.f2013a.b(new c6.d(str), f0Var);
        n.e().t(false);
        return str;
    }

    public static int j(String str) {
        return m(str) | (-16777216);
    }

    public static String k(String str) {
        return "#" + Integer.toHexString(m(str));
    }

    public static f0 l(Context context) {
        l lVarJ = s.j();
        f0 f0Var = new f0();
        f0Var.L(lVarJ.e());
        f0Var.M(com.tuyafeng.support.utils.l.d(context));
        f0Var.A(lVarJ.f0());
        f0Var.C(lVarJ.d());
        g9.c cVarA3 = lVarJ.a3();
        f0Var.F(cVarA3.d(), cVarA3.b(), cVarA3.c());
        f0Var.D(cVarA3.e());
        f0Var.E(cVarA3.f());
        g9.d dVarT0 = lVarJ.t0();
        f0Var.K(dVarT0.e(), dVarT0.c(), dVarT0.d());
        f0Var.I(dVarT0.b());
        f0Var.H(dVarT0.f());
        f0Var.J(dVarT0.g());
        e eVarY2 = lVarJ.Y2();
        f0Var.O(eVarY2.l(), eVarY2.a(), eVarY2.d(), eVarY2.e(), eVarY2.c());
        g9.b bVarA0 = lVarJ.a0();
        f0Var.N(!bVarA0.e());
        f0Var.P(bVarA0.d());
        f0Var.Q(bVarA0.c());
        g9.a aVarQ2 = lVarJ.Q2();
        f0Var.G(aVarQ2.c() ? aVarQ2.d() : x.C(f0Var.a()));
        f0Var.B(lVarJ.g0());
        return f0Var;
    }

    public static int m(String str) {
        String strH = z.H(str);
        String strSubstring = strH.substring(0, 3);
        String strSubstring2 = strH.substring((strH.length() / 2) - 3, strH.length() / 2);
        String strSubstring3 = strH.substring(strH.length() - 3);
        int i10 = Integer.parseInt(strSubstring, 16) % 128;
        int i11 = Integer.parseInt(strSubstring2, 16) % 128;
        return ((Integer.parseInt(strSubstring3, 16) % 128) + 90) | ((i10 + 90) << 16) | ((i11 + 90) << 8);
    }
}
