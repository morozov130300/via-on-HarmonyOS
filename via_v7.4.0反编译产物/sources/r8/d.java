package r8;

import a7.f;
import android.content.Context;
import android.util.Pair;
import g6.p;
import g6.y;
import i6.m;
import i6.o;
import i9.e;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import pa.r;
import w9.l;
import w9.n;
import x6.j;
import x7.u;
import z8.b0;
import z8.w2;
import z8.w3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class d {
    public static /* synthetic */ String c(String str, String str2) {
        return "file://" + str2;
    }

    public static j d(Context context) {
        m mVarL = l(context);
        String absolutePath = new File(context.getFilesDir(), "homepage.css").getAbsolutePath();
        return j.L(g(absolutePath, mVarL), e(context, new File(context.getFilesDir(), "homepage2.html").getAbsolutePath(), absolutePath, mVarL), new a7.b() { // from class: r8.a
            @Override // a7.b
            public final Object apply(Object obj, Object obj2) {
                return d.c((String) obj, (String) obj2);
            }
        });
    }

    public static j e(final Context context, final String str, final String str2, final m mVar) {
        return j.s(new Callable() { // from class: r8.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return d.h(context, str, str2, mVar);
            }
        }).D(g7.a.c());
    }

    public static String f(Context context) {
        m mVarL = l(context);
        String absolutePath = new File(context.getFilesDir(), "homepage.css").getAbsolutePath();
        String absolutePath2 = new File(context.getFilesDir(), "homepage2.html").getAbsolutePath();
        i(absolutePath, mVarL);
        h(context, absolutePath2, absolutePath, mVarL);
        return "file://" + absolutePath2;
    }

    public static j g(String str, m mVar) {
        return j.w(new Pair(mVar, str)).x(new f() { // from class: r8.b
            @Override // a7.f
            public final Object apply(Object obj) {
                Pair pair = (Pair) obj;
                return d.i((String) pair.second, (m) pair.first);
            }
        }).D(g7.a.c());
    }

    public static String h(Context context, String str, String str2, m mVar) {
        if (!n.e().l() && new File(str).exists()) {
            return str;
        }
        List<n9.b> listH = r.f().h();
        ArrayList arrayList = new ArrayList();
        for (n9.b bVar : listH) {
            String strReplaceAll = bVar.e().trim().replaceAll("<.*?>", "");
            String strG = bVar.g();
            String strReplace = w2.g(strG).replace("\"", "&quot;");
            String strK = k(strG);
            arrayList.add(new i6.n(strReplace, strReplaceAll, p.a(strReplaceAll), w3.n(strG), strK));
        }
        o.f7043a.a(new i6.c(str), mVar, str2, r.j().a0(), arrayList, context.getString(u.f14144r6), context.getString(u.f14026j), context.getString(u.Tb));
        n.e().w(false);
        return str;
    }

    public static String i(String str, m mVar) {
        if (!n.e().k() && new File(str).exists()) {
            return str;
        }
        o.f7043a.b(new i6.c(str), mVar);
        n.e().v(false);
        return str;
    }

    public static int j(String str) {
        return m(str) | (-16777216);
    }

    public static String k(String str) {
        return "#" + Integer.toHexString(m(str));
    }

    public static m l(Context context) {
        l lVarJ = r.j();
        m mVar = new m();
        mVar.P(lVarJ.d());
        mVar.Q(g6.l.d(context));
        mVar.z(lVarJ.c0());
        mVar.C(lVarJ.c());
        i9.c cVarX2 = lVarJ.X2();
        int iB = cVarX2.b();
        int iD = cVarX2.d();
        if (iB == 0) {
            iB = iD == 0 ? 54 : iD;
        }
        if (iD == 0) {
            iD = iB;
        }
        mVar.F(iB);
        mVar.H(iD);
        mVar.G((int) ((Math.min(iD, iB) / 2.0f) * (cVarX2.c() / 100.0f)));
        mVar.D(cVarX2.e());
        mVar.E(cVarX2.f());
        i9.d dVarR0 = lVarJ.r0();
        mVar.L(dVarR0.c());
        mVar.O(dVarR0.e());
        if (mVar.m() == 0 && mVar.j() == 0) {
            mVar.L(72);
        }
        mVar.N((int) ((Math.max(mVar.j(), mVar.m()) / 2.0f) * (dVarR0.d() / 100.0f)));
        mVar.K(dVarR0.b());
        mVar.J(dVarR0.f());
        mVar.M(dVarR0.g());
        e eVarV2 = lVarJ.V2();
        mVar.T(eVarV2.l());
        mVar.R(mVar.p() ? 0.0f : eVarV2.a() / 100.0f);
        mVar.V(eVarV2.d() / 100.0f);
        mVar.W(eVarV2.e());
        mVar.U(mVar.p() ? 0 : (int) ((eVarV2.c() / 100.0f) * (mVar.s() + 23.0f)));
        i9.b bVarX = lVarJ.X();
        mVar.S(!bVarX.d());
        mVar.X(bVarX.c());
        i9.a aVarM2 = lVarJ.M2();
        mVar.I(aVarM2.c() ? aVarM2.d() : y.C(mVar.a()));
        mVar.B(Math.min(0.8f, aVarM2.b() / 100.0f));
        mVar.A(lVarJ.d0());
        return mVar;
    }

    public static int m(String str) throws NoSuchAlgorithmException {
        String strI = b0.I(str);
        String strSubstring = strI.substring(0, 3);
        String strSubstring2 = strI.substring((strI.length() / 2) - 3, strI.length() / 2);
        String strSubstring3 = strI.substring(strI.length() - 3);
        int i10 = Integer.parseInt(strSubstring, 16) % 128;
        int i11 = Integer.parseInt(strSubstring2, 16) % 128;
        return ((Integer.parseInt(strSubstring3, 16) % 128) + 90) | ((i10 + 90) << 16) | ((i11 + 90) << 8);
    }
}
