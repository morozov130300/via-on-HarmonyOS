package c8;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import androidx.lifecycle.Lifecycle;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class na {

    /* renamed from: a, reason: collision with root package name */
    public final pa f2700a;

    /* renamed from: b, reason: collision with root package name */
    public final w9.l f2701b;

    /* renamed from: c, reason: collision with root package name */
    public final u4.a f2702c;

    /* renamed from: d, reason: collision with root package name */
    public final y9.a f2703d;

    /* renamed from: e, reason: collision with root package name */
    public final ca.d f2704e;

    /* renamed from: f, reason: collision with root package name */
    public final pb.b f2705f;

    /* renamed from: g, reason: collision with root package name */
    public final o9.c f2706g;

    /* renamed from: h, reason: collision with root package name */
    public final ka.g f2707h;

    /* renamed from: i, reason: collision with root package name */
    public final na.h f2708i;

    /* renamed from: m, reason: collision with root package name */
    public int f2712m;

    /* renamed from: j, reason: collision with root package name */
    public int f2709j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f2710k = 0;

    /* renamed from: l, reason: collision with root package name */
    public boolean f2711l = false;

    /* renamed from: p, reason: collision with root package name */
    public int f2715p = -1;

    /* renamed from: q, reason: collision with root package name */
    public final HashSet f2716q = new HashSet();

    /* renamed from: r, reason: collision with root package name */
    public String f2717r = null;

    /* renamed from: s, reason: collision with root package name */
    public y6.b f2718s = null;

    /* renamed from: t, reason: collision with root package name */
    public final Map f2719t = new HashMap();

    /* renamed from: u, reason: collision with root package name */
    public int f2720u = 0;

    /* renamed from: v, reason: collision with root package name */
    public String f2721v = null;

    /* renamed from: n, reason: collision with root package name */
    public boolean f2713n = false;

    /* renamed from: o, reason: collision with root package name */
    public final List f2714o = new ArrayList();

    public na(pa paVar, w9.l lVar, y9.a aVar, ca.d dVar, u4.a aVar2, pb.b bVar, o9.c cVar, ka.g gVar, na.h hVar) {
        this.f2701b = lVar;
        this.f2703d = aVar;
        this.f2704e = dVar;
        this.f2700a = paVar;
        this.f2702c = aVar2;
        this.f2705f = bVar;
        this.f2706g = cVar;
        this.f2707h = gVar;
        this.f2708i = hVar;
    }

    public static /* synthetic */ void B(final na naVar, View view) {
        naVar.getClass();
        naVar.D0(new Runnable() { // from class: c8.x9
            @Override // java.lang.Runnable
            public final void run() {
                na naVar2 = this.f2918e;
                ((autodispose2.n) naVar2.G1().D(g7.a.c()).z(w6.b.b()).I(u8.b.c(naVar2.O0()))).c(new a7.e() { // from class: c8.ea
                    @Override // a7.e
                    public final void accept(Object obj) {
                        this.f2429e.x0((r4.g) obj, false);
                    }
                }, new x7.c0(), new a7.a() { // from class: c8.fa
                    @Override // a7.a
                    public final void run() {
                        na naVar3 = this.f2454a;
                        naVar3.X1(Math.min(naVar3.S0() - 1, Math.max(0, naVar3.f2715p)));
                    }
                });
            }
        });
    }

    public static /* synthetic */ void C(na naVar, Bundle bundle, na.f fVar, long j10) {
        if (bundle != null) {
            naVar.getClass();
            if (!bundle.isEmpty()) {
                String strJ = z8.c1.J(naVar.f2700a.I(), fVar.c());
                if (na.j.d(bundle, strJ)) {
                    fVar.j(j10);
                    fVar.g(strJ);
                }
            }
        }
        naVar.f2708i.c(fVar);
    }

    public static /* synthetic */ Integer E(na naVar) {
        List listU = naVar.f2703d.u();
        if (listU.isEmpty()) {
            return 1;
        }
        return Integer.valueOf(naVar.f2706g.z(z8.p.e(listU)));
    }

    public static /* synthetic */ void G(na naVar, List list) {
        naVar.getClass();
        int size = list.size();
        int size2 = 0;
        while (true) {
            if (size2 >= size) {
                size2 = -1;
                break;
            } else if ((((na.f) list.get(size2)).b() & 4) == 4) {
                break;
            } else {
                size2++;
            }
        }
        if (size2 <= -1) {
            size2 = list.size() + naVar.S0();
        }
        naVar.f2715p = size2;
    }

    public static /* synthetic */ r4.g J(na naVar, String str) {
        naVar.getClass();
        if (URLUtil.isAboutUrl(str)) {
            int i10 = "about:home".equals(str) ? 1 : "about:bookmarks".equals(str) ? 2 : "about:blank".equals(str) ? 12 : 0;
            if (i10 != 0) {
                pc.a.a("get home init in %s", Thread.currentThread().getName());
                str = naVar.H0(i10, null);
            }
        }
        return new r4.h(str);
    }

    public static /* synthetic */ void L(na naVar, na.k kVar) {
        naVar.getClass();
        naVar.f2715p = kVar.a() + naVar.S0();
    }

    public static /* synthetic */ String M(na naVar, Bundle bundle, na.f fVar, int i10) {
        naVar.getClass();
        if (bundle != null && !bundle.isEmpty()) {
            String strJ = z8.c1.J(naVar.f2700a.I(), fVar.c());
            if (na.j.d(bundle, strJ)) {
                fVar.g(strJ);
            }
        }
        fVar.j(System.currentTimeMillis());
        if (!naVar.f2708i.c(fVar)) {
            return "";
        }
        naVar.f2719t.remove(Integer.valueOf(i10));
        return fVar.c();
    }

    public static /* synthetic */ void N(List list) {
        if (list.isEmpty()) {
            pc.a.a("sync data done", new Object[0]);
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            pc.a.a("sync data error: %s", ((rb.f) it.next()).a());
        }
    }

    public static /* synthetic */ void P(na naVar, w.d dVar, View view) {
        naVar.getClass();
        naVar.F1((String[]) dVar.f13207a, (String) ((w.d) dVar.f13208b).f13207a);
    }

    public static /* synthetic */ void R(final na naVar, int i10, final w.d dVar) {
        naVar.getClass();
        if (((String[]) dVar.f13207a).length <= 0 || !naVar.f2701b.v().s()) {
            return;
        }
        naVar.f2700a.Y((((String[]) dVar.f13207a).length != 1 || TextUtils.isEmpty((CharSequence) ((w.d) dVar.f13208b).f13208b)) ? naVar.f2700a.I().getResources().getQuantityString(x7.t.f13899g, i10, Integer.valueOf(i10)) : naVar.f2700a.I().getString(x7.u.f14085n2, ((w.d) dVar.f13208b).f13208b), x7.u.Ug, new View.OnClickListener() { // from class: c8.j9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                na.P(this.f2547a, dVar, view);
            }
        });
    }

    public static /* synthetic */ boolean S(na.k kVar) {
        return !kVar.c();
    }

    public static /* synthetic */ Boolean X(na naVar, String str, boolean z10) {
        if (naVar.K0() == null || naVar.K0().p() == null) {
            return Boolean.FALSE;
        }
        String strD = z8.c1.D(naVar.f2700a.I());
        File file = new File(strD, z8.c1.L(strD, z8.c1.n(str), z10 ? ".pdf" : ".mht"));
        if (Build.VERSION.SDK_INT < 21 || !z10) {
            s4.b.j(naVar.K0().p(), file.getAbsolutePath());
            return Boolean.TRUE;
        }
        z8.v1.a(naVar.K0().p(), file.getParent(), file.getName());
        return Boolean.TRUE;
    }

    public static /* synthetic */ boolean Y(Integer num) {
        return num.intValue() > 0;
    }

    public static /* synthetic */ void Z(na naVar, r4.g gVar) {
        naVar.x0(gVar, false);
        pc.a.a("create tab", new Object[0]);
    }

    public static /* synthetic */ w.d a(na naVar, List list, List list2, Map map, String str) {
        naVar.f2708i.i(list);
        int size = list2.size();
        if (size != 0) {
            String[] strArr = new String[size];
            Iterator it = list2.iterator();
            String strC = null;
            while (it.hasNext()) {
                na.f fVar = (na.f) it.next();
                Bundle bundle = (Bundle) map.get(fVar.c());
                if (bundle != null && !bundle.isEmpty()) {
                    String strJ = z8.c1.J(naVar.f2700a.I(), fVar.c());
                    if (na.j.d(bundle, strJ)) {
                        fVar.g(strJ);
                    }
                }
                fVar.j(System.currentTimeMillis());
                if (strC == null) {
                    strC = i6.g0.f6993a.c(fVar.e(), fVar.f(), naVar.f2700a.I().getString(x7.u.bh), 128);
                }
                size--;
                strArr[size] = fVar.c();
            }
            if (naVar.f2708i.d(list2)) {
                return w.d.a(strArr, w.d.a(str, strC));
            }
        }
        return null;
    }

    public static /* synthetic */ boolean b(List list) {
        return !list.isEmpty();
    }

    public static /* synthetic */ r4.g b0(final na naVar) {
        naVar.getClass();
        pc.a.a("aboutTab", new Object[0]);
        int iH = naVar.f2701b.H();
        t8.f.a().b(iH == 0);
        naVar.d2();
        if (20260920 > iH) {
            w9.n.e().p(true);
            if (iH < 20201231) {
                naVar.f2701b.w(false);
            }
            naVar.e2();
            naVar.d2();
            naVar.f2701b.J1(20260920);
            if (z8.c0.g() && g6.l.b(naVar.f2700a.I())) {
                naVar.f2715p = -1;
                naVar.D0(new Runnable() { // from class: c8.v9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2886e.f2711l = false;
                    }
                });
                return new r4.h(naVar.H0(4, null));
            }
        }
        return null;
    }

    public static /* synthetic */ String c(na naVar, String str, Integer num) {
        naVar.getClass();
        pc.a.a("generate page at %s", Thread.currentThread().getName());
        return naVar.H0(num.intValue(), str);
    }

    public static /* synthetic */ void c0(final na naVar, final String[] strArr, final String str, View view) {
        naVar.getClass();
        naVar.D0(new Runnable() { // from class: c8.ba
            @Override // java.lang.Runnable
            public final void run() {
                this.f2357e.F1(strArr, str);
            }
        });
    }

    public static /* synthetic */ void d(na naVar, List list, List list2, Map map, long j10) {
        na.e.a(naVar.f2700a.I());
        naVar.f2708i.i(list);
        naVar.f2708i.d(list2);
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            na.f fVar = (na.f) it.next();
            Bundle bundle = (Bundle) map.get(fVar.c());
            if (bundle != null && !bundle.isEmpty()) {
                String strJ = z8.c1.J(naVar.f2700a.I(), fVar.c());
                if (na.j.d(bundle, strJ)) {
                    fVar.j(System.currentTimeMillis());
                    fVar.g(strJ);
                }
            }
        }
        naVar.f2708i.d(list2);
        pc.a.a("save open tabs, cost: %dms", Long.valueOf(SystemClock.uptimeMillis() - j10));
    }

    public static /* synthetic */ r4.g f(na naVar, String str) {
        naVar.getClass();
        if (URLUtil.isContentUrl(str)) {
            String strY = z8.c1.y(naVar.f2700a.I(), str);
            if (strY != null) {
                str = Uri.fromFile(new File(strY)).toString();
            }
        } else if (z8.b0.N(str)) {
            w.d dVarQ = z8.b0.Q(str);
            str = naVar.H0(((Integer) dVarQ.f13207a).intValue(), (String) dVarQ.f13208b);
        }
        return new r4.h(str);
    }

    public static /* synthetic */ void f0(final na naVar, int i10, String str, final boolean z10, final String str2) {
        if (naVar.f2720u == i10) {
            naVar.f2721v = str2;
        }
        if (str2.isEmpty() || !naVar.f2701b.v().s()) {
            return;
        }
        naVar.f2700a.Y(naVar.f2700a.I().getString(x7.u.f14085n2, str), x7.u.Ug, new View.OnClickListener() { // from class: c8.m9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                na.i(this.f2680a, str2, z10, view);
            }
        });
    }

    public static /* synthetic */ void h(na naVar, int i10, String str) {
        if (naVar.K0() != null && u9.d.m(naVar.f2700a.I(), naVar.K0().getUrl())) {
            naVar.K0().v(str);
        } else if (i10 == 10 || i10 == 6) {
            naVar.i1(str, true);
        } else {
            naVar.j1(str, true);
        }
    }

    public static /* synthetic */ void i(na naVar, String str, boolean z10, View view) {
        naVar.getClass();
        String[] strArr = {str};
        if (!z10) {
            str = null;
        }
        naVar.F1(strArr, str);
    }

    public static /* synthetic */ void j(na naVar, na.k kVar) {
        naVar.getClass();
        naVar.f2715p = kVar.a() + 1;
    }

    public static /* synthetic */ na.k k(na naVar, boolean z10) {
        naVar.f2708i.k();
        boolean zD = na.e.d(naVar.f2700a.I());
        if (z10 && zD) {
            return na.e.c(naVar.f2700a.I());
        }
        int iU1 = naVar.f2701b.u1();
        if (!zD || iU1 == 0 || naVar.f2701b.m2().s()) {
            return null;
        }
        if (iU1 != 2) {
            return na.e.c(naVar.f2700a.I());
        }
        naVar.D1();
        return null;
    }

    public static /* synthetic */ String l(final na naVar, Intent intent) {
        naVar.getClass();
        pc.a.a("intentTab", new Object[0]);
        if (intent != null) {
            final String strA = z8.b0.A(intent, null);
            i6.i0 i0Var = i6.i0.f7006a;
            if (i0Var.t(strA)) {
                strA = i0Var.p(strA) ? i6.g0.f6993a.h(naVar.f2701b.Z0(), strA) : i0Var.v(strA, naVar.f2701b.Z0());
            } else if (strA != null && !strA.isEmpty()) {
                final List listE = i6.g0.f6993a.e(strA);
                if (listE.isEmpty()) {
                    strA = i0Var.v(strA, naVar.f2701b.Z0());
                } else if (listE.size() == 1) {
                    strA = (String) listE.get(0);
                } else {
                    naVar.D0(new Runnable() { // from class: c8.o9
                        @Override // java.lang.Runnable
                        public final void run() {
                            na naVar2 = this.f2743e;
                            naVar2.f2700a.O(new Runnable() { // from class: c8.y9
                                @Override // java.lang.Runnable
                                public final void run() {
                                    naVar2.f2700a.p(str, list);
                                }
                            });
                        }
                    });
                    strA = null;
                }
            }
            if (!TextUtils.isEmpty(strA)) {
                if (z8.w2.z(strA)) {
                    naVar.D0(new Runnable() { // from class: c8.p9
                        @Override // java.lang.Runnable
                        public final void run() {
                            na naVar2 = this.f2771e;
                            naVar2.f2700a.O(new Runnable() { // from class: c8.aa
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f2339e.f2700a.u(str);
                                }
                            });
                        }
                    });
                    return null;
                }
                if (!i0Var.p(strA)) {
                    if (!z8.b0.M(strA)) {
                        naVar.D0(new Runnable() { // from class: c8.q9
                            @Override // java.lang.Runnable
                            public final void run() {
                                na naVar2 = this.f2787e;
                                naVar2.f2700a.O(new Runnable() { // from class: c8.da
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f2405e.f2700a.u(str);
                                    }
                                });
                            }
                        });
                        return null;
                    }
                    naVar.f2(intent);
                    naVar.f2715p = -1;
                    return strA;
                }
            }
        }
        return null;
    }

    public static /* synthetic */ void q(Reference reference, String str) {
        r4.a aVar = (r4.a) reference.get();
        if (aVar == null) {
            return;
        }
        aVar.v(str);
    }

    public static /* synthetic */ List s(na naVar, boolean z10) {
        naVar.f2708i.k();
        List listF = naVar.f2708i.f(z10);
        boolean zIsEmpty = listF.isEmpty();
        if (!z10 || zIsEmpty) {
            int iU1 = naVar.f2701b.u1();
            if (zIsEmpty || iU1 == 0 || naVar.f2701b.m2().s()) {
                naVar.h2();
                return null;
            }
            if (iU1 == 2) {
                naVar.E1();
                return null;
            }
        }
        return listF;
    }

    public static /* synthetic */ void t(na naVar, List list) {
        t4.b bVarP;
        r4.a aVarD = naVar.f2700a.d();
        if (aVarD == null || (bVarP = aVarD.p()) == null) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("javascript:try{OpenSuggestion.pushSuggestions([");
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 != 0) {
                sb2.append(',');
            }
            sb2.append('\'');
            sb2.append(((ka.a) list.get(i10)).b());
            sb2.append('\'');
        }
        sb2.append("]);}catch(e){}");
        s4.b.g(bVarP, sb2.toString());
    }

    public static /* synthetic */ void u(na naVar, long j10) {
        if (naVar.K0() == null) {
            int i10 = naVar.f2715p;
            if (i10 < 0 || i10 >= naVar.S0()) {
                naVar.X1(naVar.S0() - 1);
            } else {
                naVar.X1(naVar.f2715p);
            }
        }
        r4.a aVarK0 = naVar.K0();
        if (aVarK0 != null) {
            aVarK0.x();
        }
        pc.a.a("is intent request: %s", Boolean.valueOf(naVar.f2711l));
        naVar.G0();
        pc.a.a("BrowserPresenter::setupTabs, cost time: %d", Long.valueOf(SystemClock.elapsedRealtime() - j10));
    }

    public static /* synthetic */ Iterable v(na naVar, List list) {
        naVar.getClass();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        boolean z10 = true;
        while (it.hasNext()) {
            na.f fVar = (na.f) it.next();
            if ((fVar.b() & 4) == 4) {
                z10 = false;
            }
            arrayList.add(na.j.e(fVar));
        }
        if (z10) {
            arrayList.add(naVar.N0());
        }
        return arrayList;
    }

    public static /* synthetic */ boolean w(na.k kVar) {
        return !kVar.c();
    }

    public static /* synthetic */ void y(na naVar, r4.g gVar) {
        int i10;
        naVar.getClass();
        String url = gVar.getUrl();
        if (i6.i0.f7006a.s(url)) {
            List listR0 = naVar.R0();
            int size = listR0.size();
            i10 = 0;
            while (i10 < size) {
                if (url.equals(((r4.a) listR0.get(i10)).getUrl())) {
                    break;
                } else {
                    i10++;
                }
            }
            i10 = -1;
        } else {
            i10 = -1;
        }
        if (i10 >= 0) {
            naVar.X1(i10);
        } else {
            naVar.h1(gVar, true, naVar.L0() + 1);
        }
    }

    public static /* synthetic */ void z(na naVar, boolean z10, int i10) {
        if (z10) {
            naVar.X1(i10);
        } else {
            naVar.getClass();
        }
    }

    public boolean A0(String str) {
        return this.f2706g.d(str);
    }

    public void A1(String str) {
        z1(b5.c.y(str, true));
    }

    public void B0() {
        C0(L0());
    }

    public void B1(String str) {
        z1(b5.c.y(str, false));
    }

    public void C0(int i10) {
        pc.a.a("is intent request: %s", Boolean.valueOf(this.f2711l));
        int iS0 = S0();
        boolean z10 = this.f2711l && (i10 == L0()) && K0() != null && !u9.d.m(this.f2700a.I(), K0().getUrl()) && iS0 <= 1;
        this.f2700a.b(i10);
        this.f2711l = false;
        pc.a.a("delete tab at %d", Integer.valueOf(i10));
        if (!z10) {
            if (iS0 == 1) {
                g1(null, true, 0);
            }
        } else if (this.f2700a.i() > 0) {
            ((Activity) this.f2700a.I()).moveTaskToBack(true);
        } else {
            ((Activity) this.f2700a.I()).finish();
        }
    }

    public void C1(String str) {
        x6.j jVarM;
        y6.b bVar = this.f2718s;
        if (bVar != null) {
            if (!bVar.isDisposed()) {
                this.f2718s.dispose();
            }
            this.f2718s = null;
        }
        int iX1 = this.f2701b.X1();
        if (iX1 == 0) {
            return;
        }
        if (str == null || str.isEmpty()) {
            jVarM = this.f2707h.m(str, iX1);
        } else {
            this.f2707h.s(this.f2701b.W());
            jVarM = this.f2707h.p(str, iX1);
        }
        this.f2718s = ((autodispose2.n) jVarM.D(g7.a.c()).z(w6.b.b()).I(u8.b.c(O0()))).a(new a7.e() { // from class: c8.n9
            @Override // a7.e
            public final void accept(Object obj) {
                na.t(this.f2699e, (List) obj);
            }
        }, new x7.g0());
    }

    public void D0(Runnable runnable) {
        if (this.f2713n) {
            runnable.run();
        } else {
            this.f2714o.add(runnable);
        }
    }

    public final void D1() {
        this.f2700a.U(x7.u.f14108ob, R.string.ok, new View.OnClickListener() { // from class: c8.w9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                na.B(this.f2903a, view);
            }
        });
    }

    public WebResourceResponse E0(WebResourceRequest webResourceRequest, String str, String str2) {
        String str3 = this.f2717r;
        if (str3 != null && !str3.isEmpty() && str.endsWith(this.f2717r)) {
            return pa.r.g().f(this.f2701b.a1());
        }
        if (str == null || !str.endsWith("via_inject_blocker.css")) {
            if (!U1(webResourceRequest, str, str2)) {
                return null;
            }
            if (str2 != null && !str.equals(str2)) {
                String strF = z8.b0.F(str);
                return (strF.length() <= 1 || !"html|htm|css|js".contains(strF)) ? u4.a.f12819d : u4.a.f12818c;
            }
            if (this.f2716q.contains(i6.i0.f7006a.f(str))) {
                return null;
            }
            w4.d dVarL = this.f2702c.l(str, null);
            WebResourceResponse webResourceResponse = new WebResourceResponse("text/html", "UTF-8", new ByteArrayInputStream(u9.a.a(this.f2700a.I(), str, dVarL == null ? "" : dVarL.m()).getBytes(m8.a.f8676a)));
            if (Build.VERSION.SDK_INT >= 21) {
                HashMap map = new HashMap();
                map.put("Cache-Control", "no-cache");
                map.put("Access-Control-Allow-Origin", "*");
                map.put("Content-Type", "text/css");
                webResourceResponse.setResponseHeaders(map);
            }
            return webResourceResponse;
        }
        StringBuilder sb2 = new StringBuilder();
        String strE = this.f2702c.e(str);
        if (strE != null) {
            sb2.append(strE);
        }
        String strC = m8.b.c(str);
        if (strC != null) {
            sb2.append(strC);
        }
        if (sb2.length() == 0) {
            return u4.a.f12818c;
        }
        WebResourceResponse webResourceResponse2 = new WebResourceResponse("text/css", "UTF-8", new ByteArrayInputStream(sb2.toString().getBytes(m8.a.f8676a)));
        if (Build.VERSION.SDK_INT >= 21) {
            HashMap map2 = new HashMap();
            map2.put("Cache-Control", "no-cache");
            map2.put("Access-Control-Allow-Origin", "*");
            map2.put("Content-Type", "text/css");
            webResourceResponse2.setResponseHeaders(map2);
        }
        return webResourceResponse2;
    }

    public final void E1() {
        List listF = this.f2708i.f(false);
        int size = listF.size();
        final String[] strArr = new String[size];
        final String str = null;
        for (int i10 = 0; i10 < size; i10++) {
            strArr[i10] = ((na.f) listF.get(i10)).c();
            if ((((na.f) listF.get(i10)).b() & 4) == 4) {
                str = strArr[i10];
            }
        }
        z8.h.b(new Runnable() { // from class: c8.s9
            @Override // java.lang.Runnable
            public final void run() {
                this.f2830e.h2();
            }
        });
        this.f2700a.U(x7.u.f14108ob, R.string.ok, new View.OnClickListener() { // from class: c8.t9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                na.c0(this.f2847a, strArr, str, view);
            }
        });
    }

    public int F0(int i10) {
        return this.f2700a.e(i10);
    }

    public void F1(String[] strArr, String str) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i10 = -1;
        int i11 = 0;
        for (String str2 : strArr) {
            na.f fVarJ = this.f2708i.j(str2);
            if (fVarJ != null) {
                arrayList.add(fVarJ);
                if (str != null && str.equals(fVarJ.c())) {
                    i10 = i11;
                }
                i11++;
            }
        }
        if (i11 == 0) {
            return;
        }
        final boolean z10 = S0() <= 0 || L0() < 0 || i10 >= 0;
        if (i10 < 0) {
            i10 = i11 - 1;
        }
        final int iS0 = S0() + Math.min(Math.max(i10, 0), i11 - 1);
        ((autodispose2.n) x6.j.t(arrayList).x(new a7.f() { // from class: c8.g9
            @Override // a7.f
            public final Object apply(Object obj) {
                return na.j.e((na.f) obj);
            }
        }).D(g7.a.c()).z(w6.b.b()).I(u8.b.c(O0()))).c(new a7.e() { // from class: c8.r9
            @Override // a7.e
            public final void accept(Object obj) {
                this.f2809e.x0((r4.g) obj, false);
            }
        }, new x7.g0(), new a7.a() { // from class: c8.ca
            @Override // a7.a
            public final void run() {
                na.z(this.f2385a, z10, iS0);
            }
        });
    }

    public final void G0() {
        this.f2713n = true;
        Iterator it = this.f2714o.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.f2714o.clear();
    }

    public final x6.j G1() {
        return x6.o.g(new Callable() { // from class: c8.ga
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return na.e.c(this.f2468e.f2700a.I());
            }
        }).e(new a7.h() { // from class: c8.ha
            @Override // a7.h
            public final boolean test(Object obj) {
                return na.w((na.k) obj);
            }
        }).d(new a7.e() { // from class: c8.ia
            @Override // a7.e
            public final void accept(Object obj) {
                na.j(this.f2503e, (na.k) obj);
            }
        }).g(new f9());
    }

    public final String H0(int i10, String str) {
        switch (i10) {
            case 1:
                return r8.d.f(this.f2700a.I());
            case 2:
                return u9.c.d(this.f2700a.I(), null);
            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                return u9.c.g(this.f2700a.I());
            case 4:
                return u9.c.b(this.f2700a.I());
            case 5:
                return u9.c.f(this.f2700a.I());
            case 6:
            case 10:
                return u9.c.h(this.f2700a.I(), d8.d.c().d(this.f2712m), i10 == 10);
            case 7:
                return u9.c.i(this.f2700a.I());
            case 8:
            case 9:
            default:
                return null;
            case 11:
                return u9.c.d(this.f2700a.I(), str);
            case 12:
                return u9.c.c(this.f2700a.I());
            case 13:
                ArrayList arrayList = new ArrayList();
                if (str != null && str.length() > 2) {
                    try {
                        JSONArray jSONArray = new JSONArray(str.substring(1, str.length() - 1).replace("\\\"", "\""));
                        int length = jSONArray.length();
                        for (int i11 = 0; i11 < length; i11++) {
                            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i11);
                            String strOptString = jSONObjectOptJSONObject.optString("url");
                            if (!strOptString.isEmpty()) {
                                arrayList.add(new n9.b(strOptString, jSONObjectOptJSONObject.optString("alt")));
                            }
                        }
                    } catch (JSONException e10) {
                        pc.a.i(e10);
                    }
                }
                return u9.c.k(this.f2700a.I(), this.f2700a.e0(), arrayList);
        }
    }

    public final x6.j H1(boolean z10) {
        return na.e.d(this.f2700a.I()) ? I1(z10) : J1(z10);
    }

    public String I0(String str) {
        return m8.b.a(this.f2702c.e(str));
    }

    public final x6.j I1(final boolean z10) {
        return x6.f.h(new Callable() { // from class: c8.c9
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return na.k(this.f2383e, z10);
            }
        }).e(new a7.h() { // from class: c8.d9
            @Override // a7.h
            public final boolean test(Object obj) {
                return na.S((na.k) obj);
            }
        }).d(new a7.e() { // from class: c8.e9
            @Override // a7.e
            public final void accept(Object obj) {
                na.L(this.f2428e, (na.k) obj);
            }
        }).g(new f9());
    }

    public int J0(String str) {
        ba.b bVarE = this.f2704e.e(i6.i0.f7006a.e(str));
        return (bVarE == null || !bVarE.s() || bVarE.b() == 0) ? this.f2701b.m2().e() : bVarE.b();
    }

    public final x6.j J1(final boolean z10) {
        return x6.f.h(new Callable() { // from class: c8.y8
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return na.s(this.f2944e, z10);
            }
        }).e(new a7.h() { // from class: c8.z8
            @Override // a7.h
            public final boolean test(Object obj) {
                return na.b((List) obj);
            }
        }).d(new a7.e() { // from class: c8.a9
            @Override // a7.e
            public final void accept(Object obj) {
                na.G(this.f2338e, (List) obj);
            }
        }).g(new a7.f() { // from class: c8.b9
            @Override // a7.f
            public final Object apply(Object obj) {
                return na.v(this.f2356a, (List) obj);
            }
        });
    }

    public r4.a K0() {
        return this.f2700a.d();
    }

    public void K1(r4.a aVar) {
        if (aVar == null) {
            return;
        }
        String url = aVar.getUrl();
        final int id = aVar.getId();
        if (!W1(url) || f1(url)) {
            final String str = (String) this.f2719t.get(Integer.valueOf(id));
            if (str != null) {
                this.f2719t.remove(Integer.valueOf(id));
                z8.h.b(new Runnable() { // from class: c8.o8
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2741e.f2708i.a(str);
                    }
                });
                return;
            }
            return;
        }
        final int i10 = this.f2720u + 1;
        this.f2720u = i10;
        String title = aVar.getTitle();
        final na.f fVarJ = this.f2708i.j((String) this.f2719t.get(Integer.valueOf(id)));
        if (fVarJ == null) {
            fVarJ = new na.f(UUID.randomUUID().toString());
        }
        final Bundle bundleB = fVarJ.d() < aVar.i() ? aVar.b() : null;
        fVarJ.l(url);
        fVarJ.k(title);
        fVarJ.h(fVarJ.b() & (-8));
        final boolean zD = aVar.d();
        final String strC = i6.g0.f6993a.c(title, url, this.f2700a.I().getString(x7.u.bh), 128);
        ((autodispose2.r) x6.o.g(new Callable() { // from class: c8.p8
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return na.M(this.f2767e, bundleB, fVarJ, id);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(O0()))).a(new a7.e() { // from class: c8.q8
            @Override // a7.e
            public final void accept(Object obj) {
                na.f0(this.f2783e, i10, strC, zD, (String) obj);
            }
        }, new x7.g0());
    }

    public int L0() {
        return this.f2700a.k();
    }

    public void L1(List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (list.size() == 1) {
            K1((r4.a) list.get(0));
            return;
        }
        final HashMap map = new HashMap();
        HashSet hashSet = new HashSet();
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        String strC = null;
        while (it.hasNext()) {
            r4.a aVar = (r4.a) it.next();
            String url = aVar.getUrl();
            int id = aVar.getId();
            if (url == null || url.isEmpty() || hashSet.contains(url) || !W1(url) || f1(url)) {
                String str = (String) this.f2719t.get(Integer.valueOf(id));
                if (str != null) {
                    arrayList.add(str);
                }
            } else {
                hashSet.add(url);
                na.f fVarJ = this.f2708i.j((String) this.f2719t.get(Integer.valueOf(id)));
                if (fVarJ == null) {
                    fVarJ = new na.f(UUID.randomUUID().toString());
                }
                fVarJ.l(url);
                fVarJ.k(aVar.getTitle());
                fVarJ.h(0);
                if (aVar.d()) {
                    strC = fVarJ.c();
                }
                if (fVarJ.d() < aVar.i()) {
                    map.put(fVarJ.c(), aVar.b());
                }
                arrayList2.add(fVarJ);
            }
        }
        final int size = list.size();
        final String str2 = strC;
        ((autodispose2.m) x6.f.h(new Callable() { // from class: c8.c8
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return na.a(this.f2378e, arrayList, arrayList2, map, str2);
            }
        }).n(g7.a.c()).k(w6.b.b()).p(u8.b.c(O0()))).a(new a7.e() { // from class: c8.d8
            @Override // a7.e
            public final void accept(Object obj) {
                na.R(this.f2403e, size, (w.d) obj);
            }
        }, new x7.g0());
    }

    public final x6.j M0() {
        return x6.j.w(this.f2701b.n()).x(new a7.f() { // from class: c8.i9
            @Override // a7.f
            public final Object apply(Object obj) {
                return na.J(this.f2502a, (String) obj);
            }
        });
    }

    public void M1(r4.a aVar) {
        if (aVar == null) {
            return;
        }
        String url = aVar.getUrl();
        int id = aVar.getId();
        if (f1(url)) {
            final String str = (String) this.f2719t.get(Integer.valueOf(id));
            if (str != null) {
                this.f2719t.remove(Integer.valueOf(id));
                z8.h.b(new Runnable() { // from class: c8.e8
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2426e.f2708i.a(str);
                    }
                });
                return;
            }
            return;
        }
        int i10 = !W1(url) ? 1 : 0;
        String title = aVar.getTitle();
        final long jI = aVar.i();
        na.f fVarJ = this.f2708i.j((String) this.f2719t.get(Integer.valueOf(id)));
        final Bundle bundleB = (fVarJ == null || fVarJ.d() < jI) ? aVar.b() : null;
        if (fVarJ == null) {
            fVarJ = new na.f(UUID.randomUUID().toString());
            this.f2719t.put(Integer.valueOf(id), fVarJ.c());
        }
        final na.f fVar = fVarJ;
        fVar.k(title);
        fVar.l(url);
        fVar.h(i10 | 2);
        z8.h.b(new Runnable() { // from class: c8.f8
            @Override // java.lang.Runnable
            public final void run() {
                na.C(this.f2450e, bundleB, fVar, jI);
            }
        });
    }

    public final r4.g N0() {
        String strN = this.f2701b.n();
        if (URLUtil.isAboutUrl(strN)) {
            int i10 = "about:home".equals(strN) ? 1 : "about:bookmarks".equals(strN) ? 2 : "about:blank".equals(strN) ? 12 : 0;
            if (i10 != 0) {
                strN = H0(i10, null);
            }
        }
        return new r4.h(strN);
    }

    public void N1() {
        if (this.f2713n) {
            final long jUptimeMillis = SystemClock.uptimeMillis();
            List<r4.a> listR0 = R0();
            final HashMap map = new HashMap();
            final ArrayList arrayList = new ArrayList();
            final ArrayList arrayList2 = new ArrayList();
            for (r4.a aVar : listR0) {
                String url = aVar.getUrl();
                if (f1(url)) {
                    String str = (String) this.f2719t.get(Integer.valueOf(aVar.getId()));
                    if (str != null) {
                        arrayList2.add(str);
                    }
                } else {
                    na.f fVarJ = this.f2708i.j((String) this.f2719t.get(Integer.valueOf(aVar.getId())));
                    if (fVarJ == null) {
                        fVarJ = new na.f(UUID.randomUUID().toString());
                        this.f2719t.put(Integer.valueOf(aVar.getId()), fVarJ.c());
                    }
                    if (fVarJ.d() < aVar.i()) {
                        map.put(fVarJ.c(), aVar.b());
                    }
                    fVarJ.l(url);
                    fVarJ.k(aVar.getTitle());
                    fVarJ.h((aVar.d() ? 4 : 0) | (!W1(url) ? 1 : 0) | 2);
                    arrayList.add(fVarJ);
                }
            }
            z8.h.b(new Runnable() { // from class: c8.ja
                @Override // java.lang.Runnable
                public final void run() {
                    na.d(this.f2549e, arrayList2, arrayList, map, jUptimeMillis);
                }
            });
        }
    }

    public final autodispose2.androidx.lifecycle.b O0() {
        return autodispose2.androidx.lifecycle.b.i(this.f2700a.l0());
    }

    public x6.j O1(final String str, final boolean z10) {
        return x6.j.s(new Callable() { // from class: c8.u9
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return na.X(this.f2868e, str, z10);
            }
        }).D(w6.b.b()).z(w6.b.b());
    }

    public int P0(String str) {
        ba.b bVarE = this.f2704e.e(i6.i0.f7006a.e(str));
        return (bVarE == null || !bVarE.s() || bVarE.h() == 0) ? this.f2701b.m2().f() : bVarE.h();
    }

    public void P1() {
        t4.b bVarP = K0() != null ? K0().p() : null;
        if (i6.i0.f7006a.l(bVarP == null ? null : bVarP.getUrl())) {
            this.f2700a.n(x7.u.M1);
        } else {
            this.f2700a.m0(g6.p.n(bVarP != null ? bVarP.getTitle() : null, UUID.randomUUID().toString().toUpperCase(Locale.ROOT)));
        }
    }

    public final String Q0(Intent intent) {
        Uri referrer;
        if (intent == null || !intent.hasExtra("mark.via.REFERER")) {
            referrer = null;
        } else {
            try {
                referrer = Build.VERSION.SDK_INT >= 33 ? (Uri) intent.getParcelableExtra("mark.via.REFERER", Uri.class) : (Uri) intent.getParcelableExtra("mark.via.REFERER");
            } catch (Exception e10) {
                pc.a.i(e10);
            }
        }
        if (referrer == null && Build.VERSION.SDK_INT >= 22) {
            referrer = g6.f.a(this.f2700a.I()).getReferrer();
        }
        if (referrer == null) {
            return null;
        }
        return referrer.getHost();
    }

    public void Q1(String str, int i10) {
        if (str == null || str.isEmpty()) {
            return;
        }
        String strE = i6.i0.f7006a.e(str);
        ba.a aVarI = this.f2704e.i(strE);
        aVarI.S(true);
        if (i10 == this.f2701b.F0()) {
            i10 = 0;
        }
        aVarI.d0(i10);
        if (aVarI.r()) {
            this.f2704e.b(strE);
        } else {
            this.f2704e.g(strE, aVarI);
        }
    }

    public List R0() {
        return this.f2700a.c();
    }

    public void R1(boolean z10) {
        pc.a.a("BrowserPresenter::setupTabs", new Object[0]);
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        ((autodispose2.n) Z0(z10).D(g7.a.c()).z(w6.b.b()).I(u8.b.c(O0()))).c(new a7.e() { // from class: c8.i8
            @Override // a7.e
            public final void accept(Object obj) {
                na.Z(this.f2501e, (r4.g) obj);
            }
        }, new x7.c0(), new a7.a() { // from class: c8.j8
            @Override // a7.a
            public final void run() {
                na.u(this.f2545a, jElapsedRealtime);
            }
        });
    }

    public int S0() {
        return this.f2700a.i();
    }

    public void S1() {
        r4.a aVarK0 = K0();
        String url = aVarK0 == null ? null : aVarK0.getUrl();
        if (aVarK0 == null || TextUtils.isEmpty(url) || i6.i0.f7006a.l(url)) {
            url = "http://viayoo.com/";
        } else {
            String title = aVarK0.getTitle();
            if (title != null && !title.isEmpty()) {
                url = title + "\n" + url;
            }
        }
        z8.f1.k(this.f2700a.I(), url);
    }

    public int T0(String str) {
        ba.b bVarE = this.f2704e.e(i6.i0.f7006a.e(str));
        if (bVarE == null || !bVarE.s()) {
            return 0;
        }
        return bVarE.i(0);
    }

    public boolean T1(String str) {
        return !this.f2702c.r(str, null);
    }

    public void U0() {
        String str = this.f2721v;
        if (str == null || str.isEmpty()) {
            return;
        }
        String str2 = this.f2721v;
        F1(new String[]{str2}, str2);
        this.f2720u++;
        this.f2721v = null;
    }

    public final boolean U1(WebResourceRequest webResourceRequest, String str, String str2) {
        if (str == null) {
            return false;
        }
        i6.i0 i0Var = i6.i0.f7006a;
        if (i0Var.l(str) || i0Var.l(str2) || !b1(str2)) {
            return false;
        }
        boolean zQ = webResourceRequest != null ? this.f2702c.q(webResourceRequest, str2) : this.f2702c.r(str, str2);
        if (zQ) {
            this.f2709j++;
            this.f2710k += z8.b0.C(str);
        }
        return zQ;
    }

    public void V0() {
        final r4.a aVarK0 = K0();
        if (aVarK0 == null || u9.d.o(this.f2700a.I(), aVarK0.getUrl())) {
            return;
        }
        ((autodispose2.n) M0().x(new a7.f() { // from class: c8.g8
            @Override // a7.f
            public final Object apply(Object obj) {
                return ((r4.g) obj).getUrl();
            }
        }).D(g7.a.c()).z(w6.b.b()).I(u8.b.c(O0()))).a(new a7.e() { // from class: c8.h8
            @Override // a7.e
            public final void accept(Object obj) {
                aVarK0.v((String) obj);
            }
        }, new x7.c0());
    }

    public boolean V1(String str, String str2) {
        return this.f2702c.s(g6.p.m(str), g6.p.m(str2));
    }

    public boolean W0() {
        String str = this.f2721v;
        return (str == null || str.isEmpty()) ? false : true;
    }

    public boolean W1(String str) {
        ba.b bVarE = this.f2704e.e(i6.i0.f7006a.e(str));
        return (bVarE == null || !bVarE.s()) ? !this.f2701b.m2().s() : !bVarE.z(r0);
    }

    public boolean X0(String str) {
        ba.b bVarE = this.f2704e.e(i6.i0.f7006a.e(str));
        return bVarE != null && bVarE.s();
    }

    public void X1(int i10) {
        this.f2700a.j(i10);
    }

    public void Y0() {
    }

    public void Y1() {
        qb.a aVarD = this.f2705f.d();
        if (aVarD == null || !aVarD.g() || aVarD.e() == null || aVarD.e().a()) {
            return;
        }
        pc.a.a("sync data", new Object[0]);
        ((autodispose2.r) x6.o.g(new Callable() { // from class: c8.u8
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f2867e.f2705f.e(false);
            }
        }).l(g7.a.c()).m(u8.b.c(O0()))).a(new a7.e() { // from class: c8.v8
            @Override // a7.e
            public final void accept(Object obj) {
                na.N((List) obj);
            }
        }, new x7.g0());
    }

    public final x6.j Z0(boolean z10) {
        return H1(z10).e(a1(this.f2700a.l0().getIntent())).e(g0()).E(M0());
    }

    public void Z1() {
        if ((z8.c0.f() || z8.f.h()) && this.f2701b.M1() != -1) {
            b2();
        } else {
            a2();
        }
    }

    public final x6.f a1(final Intent intent) {
        return x6.f.h(new Callable() { // from class: c8.w8
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return na.l(this.f2901e, intent);
            }
        }).j(new a7.f() { // from class: c8.x8
            @Override // a7.f
            public final Object apply(Object obj) {
                return na.f(this.f2917a, (String) obj);
            }
        });
    }

    public void a2() {
        r4.a aVarK0 = K0();
        if (aVarK0 == null || !i6.i0.f7006a.s(aVarK0.getUrl())) {
            this.f2700a.n(x7.u.M1);
            return;
        }
        i6.f0.f6991a.f(new i6.e(aVarK0.p()), z8.t1.g(), this.f2700a.e0());
        this.f2700a.n(x7.u.Nh);
    }

    public boolean b1(String str) {
        if (r9.g.a().n(str)) {
            return false;
        }
        String strE = i6.i0.f7006a.e(str);
        boolean zG = this.f2701b.m2().g();
        ba.b bVarE = this.f2704e.e(strE);
        return (bVarE == null || !bVarE.s()) ? zG : bVarE.l(zG);
    }

    public void b2() {
        r4.a aVarK0 = K0();
        if (aVarK0 == null || !i6.i0.f7006a.s(aVarK0.getUrl())) {
            this.f2700a.n(x7.u.M1);
            return;
        }
        i6.f0.f6991a.g(new i6.e(aVarK0.p()), z8.t1.g(), this.f2700a.e0());
        this.f2700a.n(x7.u.Nh);
    }

    public boolean c1(String str) {
        boolean zK = this.f2701b.m2().k();
        ba.b bVarE = this.f2704e.e(i6.i0.f7006a.e(str));
        return (bVarE == null || !bVarE.s()) ? zK : bVarE.n(zK);
    }

    public final void c2() {
        int i10 = this.f2709j;
        if (i10 > 0) {
            this.f2701b.J2(i10);
            this.f2701b.E2(this.f2710k);
            this.f2709j = 0;
            this.f2710k = 0;
        }
    }

    public boolean d1(String str) {
        ba.b bVarE = this.f2704e.e(i6.i0.f7006a.e(str));
        boolean zL = this.f2701b.m2().l();
        return (bVarE == null || !bVarE.s()) ? zL : bVarE.p(zL);
    }

    public final void d2() {
        if (this.f2701b.M1() == -999) {
            this.f2701b.q(this.f2703d.z().h(ja.c.k(this.f2700a.I().getString(x7.u.G0), this.f2701b.N())));
        }
    }

    public boolean e1(String str) {
        boolean zT = this.f2701b.m2().t();
        ba.b bVarE = this.f2704e.e(i6.i0.f7006a.e(str));
        return (bVarE == null || !bVarE.s()) ? zT : bVarE.B(zT);
    }

    public final void e2() {
        if (this.f2701b.l0() == -999) {
            this.f2701b.I(this.f2703d.z().h(ja.c.m(this.f2700a.I().getString(x7.u.G0), this.f2701b.K(null))));
        }
    }

    public final boolean f1(String str) {
        return str == null || str.isEmpty() || u9.d.m(this.f2700a.I(), str) || i6.i0.f7006a.i(str);
    }

    public final void f2(Intent intent) {
        final boolean z10 = !"mark.via".equals(Q0(intent)) && z8.b0.L(intent);
        D0(new Runnable() { // from class: c8.z9
            @Override // java.lang.Runnable
            public final void run() {
                this.f2966e.f2711l = z10;
            }
        });
    }

    public final x6.f g0() {
        return x6.f.h(new Callable() { // from class: c8.h9
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return na.b0(this.f2488e);
            }
        });
    }

    public void g1(String str, final boolean z10, final int i10) {
        if (str == null) {
            ((autodispose2.n) M0().D(g7.a.c()).z(w6.b.b()).I(u8.b.c(O0()))).a(new a7.e() { // from class: c8.ka
                @Override // a7.e
                public final void accept(Object obj) {
                    this.f2644e.y0((r4.g) obj, z10, i10);
                }
            }, new x7.c0());
        } else {
            s0();
            y0(new r4.h(str), z10, i10);
        }
    }

    public void g2() {
        this.f2717r = i6.i.f7005a.d(this.f2701b.a1());
    }

    public void h0(String str, String str2) {
        i0(b5.c.x(str, str2));
    }

    public void h1(r4.g gVar, boolean z10, int i10) {
        s0();
        y0(gVar, z10, i10);
    }

    public void h2() {
        List<na.f> listF = this.f2708i.f(true);
        if (listF.isEmpty()) {
            return;
        }
        for (na.f fVar : listF) {
            if ((fVar.b() & 1) == 1) {
                this.f2708i.a(fVar.c());
            } else {
                fVar.h(fVar.b() & (-7));
                this.f2708i.c(fVar);
            }
        }
    }

    public final void i0(String str) {
        this.f2702c.a(str);
    }

    public void i1(String str, boolean z10) {
        g1(str, z10, L0() + 1);
    }

    public void i2() {
        r4.a aVarK0 = K0();
        if (aVarK0 != null) {
            String url = aVarK0.getUrl();
            if (!TextUtils.isEmpty(url)) {
                if (Build.VERSION.SDK_INT < 21) {
                    aVarK0.v("javascript:(function(){s=document.documentElement.outerHTML;a=window.open('');a.document.write(\"<html><head><meta charset='utf-8'><meta name='viewport' content='width=device-width, initial-scale=1, user-scalable=no, minimal-ui'><title>Source</title><style type='text/css'>* {padding: 0; margin: 0} body{padding: 5px 10px;word-break:break-all;color: #666;line-height: 1.4;}</style></head><body></body></html>\");a.document.body.innerText=s;})();");
                    this.f2700a.n(x7.u.Nh);
                    return;
                } else {
                    i1("view-source:" + url, true);
                    return;
                }
            }
        }
        this.f2700a.n(x7.u.M1);
    }

    public void j0(String str) {
        i0(b5.c.y(str, true));
    }

    public void j1(String str, boolean z10) {
        g1(str, z10, S0());
    }

    public void k0(String str) {
        i0(b5.c.y(str, false));
    }

    public void k1(String str, boolean z10) {
        String strE = i6.i0.f7006a.e(str);
        ba.a aVarI = this.f2704e.i(strE);
        aVarI.S(true);
        aVarI.X(true);
        this.f2704e.f(strE, new ba.d(aVarI));
        g1(str, z10, L0() + 1);
        this.f2704e.k(strE);
    }

    public boolean l0(String str) {
        o9.b bVarA = this.f2706g.a(str);
        return bVarA != null && this.f2703d.s(n9.b.i(0, bVarA.g(), bVarA.e())) > 0;
    }

    public void l1() {
        n1(false, false);
    }

    public void m0(String str) {
        if (this.f2701b.m2().s() || (this.f2701b.X1() & 32) == 0) {
            return;
        }
        this.f2707h.e(str);
    }

    public void m1(boolean z10) {
        n1(z10, false);
    }

    public void n0(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.f2716q.add(str);
    }

    public void n1(boolean z10, boolean z11) {
        t4.b bVarP;
        if (K0() == null) {
            return;
        }
        this.f2701b.x2();
        for (r4.a aVar : R0()) {
            if (aVar != null && (bVarP = aVar.p()) != null) {
                String url = bVarP.getUrl();
                if (z10) {
                    bVarP.setTag(e8.i.f4822e, null);
                }
                aVar.t();
                if (z11 && bVarP.getProgress() >= 100 && !TextUtils.isEmpty(url) && !i6.i0.f7006a.l(url)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("javascript:");
                    sb2.append((this.f2701b.d() && this.f2701b.B1()) ? "(function(){if(!document.getElementById('via_inject_css_night')){var css=document.createElement('style');css.id='via_inject_css_night';css.type='text/css';css.rel=\"stylesheet\";var textNode=document.createTextNode('html{background-color:#000!important}*{color:#999!important;box-shadow:none!important;background-color:transparent!important;border-color:#444!important;border-top-color:#444!important;border-bottom-color:#444!important;border-left-color:#444!important;border-right-color:#444!important}body{background-color:transparent!important}:after,:before{background-color:transparent!important;border-color:#444!important}a,a *{color:#409B9B!important;text-decoration:none!important}.link:hover,.link:hover *,[role=button]:hover *,[role=link]:hover,[role=link]:hover *,[role=menuitem]:hover,[role=menuitem]:hover *,a:hover,a:hover *,a:visited:hover,a:visited:hover *,div[onclick]:hover,span[onclick]:hover{color:#F0F0F0!important}a:visited,a:visited *{color:#607069!important}.selected,.selected *,[href=\"#\"],a.active,a.active *,a.highlight,a.highlight *{color:#DDD!important;font-weight:700!important}[class*=header],[class*=header] td,[class*=headline],[id*=header],[id*=headline],h1,h1 *,h2,h2 *,h3,h3 *,h4,h5,h6,strong{color:#DDD!important}[class*=alert],[class*=error],code,div[onclick],span[onclick]{color:#900!important}::-moz-selection{background-color:#377!important;color:#000!important}::selection{background-color:#377!important;color:#000!important}:focus{outline:0!important}div[role=navigation],div[style=\"display: block;\"]{background-color:rgba(0,0,0,.5)!important}table{background-color:rgba(40,30,30,.6)!important;border-radius:6px!important}table>tbody>tr:nth-child(even),table>tbody>tr>td:nth-child(even){background-color:rgba(0,0,0,.2)!important}#ghostery-purple-bubble,#translator-popup,.hovercard,.menu,.tooltip,.vbmenu_popup,[class*=dropdown],[class*=nav] ul,[class*=popup],[class=title],[id*=Menu],[id*=menu],[id*=nav] ul,a[id*=ghosteryfirefox],a[onclick][style*=display],div[role=dialog],div[role=menu],div[style*=\"position:\"][style*=\"left:\"][style*=visible],div[style*=\"z-index:\"][style*=\"left:\"][style*=visible],div[style*=\"-moz-user-select\"],embed,iframe,label [onclick],nav,nav ul,span[class*=script] div,ul[class*=menu],ul[style*=\"display:\"],ul[style*=\"visibility:\"] ul{background-color:rgba(5,5,5,.9)!important;border-radius:5px;box-shadow:1px 1px 5px #000!important}#footer,#header,footer,header{background-color:rgba(19,19,19,.9)!important;box-shadow:0 0 5px #000!important}body>#dialog,body>.xenOverlay{background-color:rgba(19,19,19,.96)!important;background-clip:padding-box!important;box-shadow:0 0 15px #000,inset 0 0 0 1px rgba(200,200,200,.5),inset 0 0 5px #111!important}[id*=lightbox],[id*=overlay],blockquote{background-color:rgba(35,35,35,.9)!important;border-radius:5px}.Message code,dl,pre{background-color:rgba(5,5,5,.5)!important}.install[onclick],[role=button],a.BigButton,a.TabLink,a.button,a.submit,button,input,select{-moz-appearance:none!important;-webkit-appearance:none!important;transition:border-color .3s!important;background-color:#060606!important;color:#BBB!important;box-shadow:0 0 2px rgba(0,0,0,.9)!important}a[class*=button]:not(:empty),a[href=\"javascript:;\"],a[id*=Button]:not(:empty),a[id*=button]:not(:empty),div[class*=button][onclick]{transition:border-color .3s!important;background-color:#060606!important;color:#BBB!important;border-color:#333!important;box-shadow:0 0 2px rgba(0,0,0,.9)!important}a[class*=button]:not(:empty):hover,a[href=\"javascript:;\"]:hover,a[id*=Button]:not(:empty):hover,a[id*=button]:hover,div[class*=button][onclick]:hover{background-color:#151515!important;color:#FFF!important}a.button *,a.submit *,button *,input *,select *{color:#BBB!important}[role=button]:hover,a.BigButton:hover,a.TabLink:hover,a.button:hover,a.submit:hover,button:hover,input:hover,input[type=button]:hover,select:hover{border-top-color:#555!important;border-bottom-color:#555!important;border-left-color:#555!important;border-right-color:#555!important}input:focus,select:focus{box-shadow:0 0 5px #077!important}input :hover *{color:#F0F0F0!important}button[disabled],button[disabled]:focus,button[disabled]:hover,input[disabled],input[disabled]:focus,input[disabled]:hover,select[disabled],select[disabled]:focus,select[disabled]:hover{opacity:.5!important;border-color:#333!important}input[type=checkbox]{border-radius:1px!important}input[type=radio],input[type=radio]:focus{border-radius:100%!important}input[type=checkbox],input[type=radio]{min-width:12px;min-height:12px}input[type=checkbox]:checked,input[type=radio]:checked{border-color:#077!important;box-shadow:0 0 5px #077!important}select{padding-right:15px!important;background-color:#060606!important;transition:border-color .3s,background-position .3s!important}.Active .TabLink,a.BigButton:active,a.TabLink:active,a.button:active,a.submit:active,a[class*=button]:not(:empty):active,button:active,input[type=button]:active,input[type=submit]:active{background-color:#292929!important;color:#FFF!important}textarea{-moz-appearance:none!important;-webkit-appearance:none!important;background-color:rgba(0,0,0,.3)!important;border-radius:3px!important;box-shadow:inset 0 0 8px #000!important;transition:border-color,background,.3s!important}textarea,textarea *{color:#C8C8C8!important}textarea:focus:hover,textarea:hover{border-color:#333!important}textarea:focus{background-color:rgba(0,0,0,.5)!important;border-color:#222!important}textarea:focus,textarea:focus>*{box-shadow:none!important}optgroup,option{-moz-appearance:none!important;-webkit-appearance:none!important;background-color:0 0!important;color:#666!important}optgroup{background-color:#222!important;color:#DDD!important}option:checked,option:focus,option:not([disabled]):hover{background-color:linear-gradient(#333,#292929)!important;color:#DDD!important}img{opacity:.7!important;transition:opacity .2s}#mpiv-popup,a:hover img,img:hover{opacity:1!important}.read-whole-mask .exp-mask,.se-head-tabcover,.wgt-exp-content .exp-img-mask{background-image:none!important}.s_card{background:0 0!important}');css.appendChild(textNode);var o=document.getElementsByTagName(\"head\");if(o.length>0&&o[0].appendChild(css)){}};})();" : "(function(){if(document.getElementById(\"via_inject_css_night\")){var night_e=document.getElementById(\"via_inject_css_night\");night_e.parentNode.removeChild(night_e)};})();");
                    bVarP.loadUrl(sb2.toString());
                }
            }
        }
        w9.n.e().y(false);
    }

    public void o0(final String str, int i10, boolean z10) {
        na.f fVarJ;
        if (str == null || str.isEmpty() || (fVarJ = this.f2708i.j(str)) == null) {
            return;
        }
        if (i10 < 0) {
            this.f2719t.remove(Integer.valueOf(i10));
            z8.h.b(new Runnable() { // from class: c8.n8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2697e.f2708i.a(str);
                }
            });
            return;
        }
        int iB = fVarJ.b() & (-8);
        int i11 = iB | 2;
        if (!W1(fVarJ.f())) {
            i11 = iB | 3;
        }
        if (z10) {
            i11 |= 4;
        }
        fVarJ.h(i11);
        fVarJ.j(System.currentTimeMillis());
        this.f2708i.c(fVarJ);
        this.f2719t.put(Integer.valueOf(i10), str);
    }

    public void o1() {
    }

    public void p0() {
        if (this.f2701b.s1() < 2) {
            ((autodispose2.m) x6.o.g(new Callable() { // from class: c8.k8
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return na.E(this.f2641e);
                }
            }).e(new a7.h() { // from class: c8.l8
                @Override // a7.h
                public final boolean test(Object obj) {
                    return na.Y((Integer) obj);
                }
            }).n(g7.a.c()).k(w6.b.b()).p(u8.b.c(O0()))).a(new a7.e() { // from class: c8.m8
                @Override // a7.e
                public final void accept(Object obj) {
                    this.f2679e.f2701b.N0(2);
                }
            }, new x7.g0());
        }
    }

    public void p1() {
        this.f2711l = false;
        this.f2701b.q2(w9.n.e().a());
        c2();
    }

    public void q0() {
        pc.a.a("Check for update", new Object[0]);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new sb.g(this.f2701b, this.f2702c));
        arrayList.add(new sb.q(this.f2701b, lc.c().d()));
        ((autodispose2.n) new sb.i(arrayList).b().D(g7.a.c()).I(u8.b.c(O0()))).c(new a7.e() { // from class: c8.la
            @Override // a7.e
            public final void accept(Object obj) {
                pc.a.a("Update result: %s", (sb.r) obj);
            }
        }, new x7.g0(), new a7.a() { // from class: c8.ma
            @Override // a7.a
            public final void run() {
                pc.a.a("Update completed", new Object[0]);
            }
        });
    }

    public void q1(Intent intent) {
        ((autodispose2.m) a1(intent).n(g7.a.c()).k(w6.b.b()).p(u8.b.b(this.f2700a.l0(), Lifecycle.Event.ON_DESTROY))).a(new a7.e() { // from class: c8.t8
            @Override // a7.e
            public final void accept(Object obj) {
                na.y(this.f2846e, (r4.g) obj);
            }
        }, new x7.g0());
    }

    public void r0() {
        z8.h0.c(this.f2700a.I(), this.f2701b, null, this.f2708i, this.f2703d);
    }

    public void r1() {
        r4.a aVarK0 = K0();
        if (aVarK0 != null && !u9.d.m(this.f2700a.I(), aVarK0.getUrl())) {
            this.f2712m = aVarK0.getId();
        }
        if (F0(this.f2712m) == -1 || !d8.d.c().f(this.f2712m)) {
            this.f2700a.n(x7.u.R8);
        } else {
            s1(6, null);
        }
    }

    public void s0() {
        this.f2721v = null;
        this.f2720u++;
    }

    public void s1(final int i10, final String str) {
        ((autodispose2.r) x6.o.h(Integer.valueOf(i10)).i(new a7.f() { // from class: c8.k9
            @Override // a7.f
            public final Object apply(Object obj) {
                return na.c(this.f2642a, str, (Integer) obj);
            }
        }).j(w6.b.b()).l(g7.a.c()).m(u8.b.c(O0()))).b(new a7.e() { // from class: c8.l9
            @Override // a7.e
            public final void accept(Object obj) {
                na.h(this.f2666e, i10, (String) obj);
            }
        });
    }

    public void t0() {
        if (F0(this.f2712m) != -1) {
            d8.d.c().b(this.f2712m);
            x1(L0());
        }
    }

    public void t1() {
        r4.a aVarK0 = K0();
        if (aVarK0 != null && r9.g.a().a(aVarK0.getUrl())) {
            pa paVar = this.f2700a;
            paVar.N(paVar.I().getString(x7.u.zg));
            return;
        }
        if (aVarK0 != null && !u9.d.m(this.f2700a.I(), aVarK0.getUrl())) {
            this.f2712m = aVarK0.getId();
        }
        int iF0 = F0(this.f2712m);
        if (aVarK0 != null) {
            pc.a.a("log id: %d, resource id: %d, has resource: %s", Integer.valueOf(aVarK0.getId()), Integer.valueOf(aVarK0.p().getId()), Boolean.valueOf(d8.d.c().g(this.f2712m)));
        }
        if (iF0 != -1 && d8.d.c().g(this.f2712m)) {
            s1(10, null);
            return;
        }
        this.f2700a.N(this.f2700a.I().getString(x7.u.T8) + this.f2700a.I().getString(x7.u.f14052kb));
    }

    public final boolean u0(String str) {
        return this.f2702c.b(str);
    }

    public void u1() {
        r4.a aVarK0 = K0();
        if (aVarK0 == null || !r9.g.a().a(aVarK0.getUrl())) {
            if (aVarK0 != null && d8.d.c().g(aVarK0.getId())) {
                List<n9.c> listD = d8.d.c().d(aVarK0.getId());
                if (!listD.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    for (n9.c cVar : listD) {
                        if (cVar != null && cVar.e()) {
                            arrayList.add(cVar.c());
                        }
                    }
                    this.f2700a.g0((String[]) arrayList.toArray(new String[0]), aVarK0.getTitle());
                    return;
                }
            }
            this.f2700a.g0(new String[0], null);
        }
    }

    public boolean v0(String str) {
        return u0(b5.c.y(str, true));
    }

    public void v1(String str) {
        t4.b bVarP;
        r4.a aVarK0 = K0();
        if (aVarK0 == null || (bVarP = aVarK0.p()) == null) {
            return;
        }
        bVarP.setTag(e8.i.f4822e, null);
        aVarK0.t();
        bVarP.reload();
    }

    public boolean w0(String str) {
        return u0(b5.c.y(str, false));
    }

    public void w1() {
        for (int iS0 = S0() - 1; iS0 >= 0; iS0--) {
            x1(iS0);
        }
    }

    public final void x0(r4.g gVar, boolean z10) {
        y0(gVar, z10, S0());
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void x1(int i10) {
        r4.a aVar;
        int iLastIndexOf;
        if (i10 < 0 || i10 >= S0() || (aVar = (r4.a) R0().get(i10)) == null) {
            return;
        }
        String url = aVar.getUrl();
        final int iD = u9.d.d(this.f2700a.I(), url);
        if (u9.d.l(iD)) {
            boolean z10 = true;
            boolean zH = false;
            if (iD == 1) {
                if (!w9.n.e().l() && !w9.n.e().k()) {
                    z10 = false;
                }
                zH = z10;
            } else if (iD == 2) {
                zH = w9.n.e().h();
            } else if (iD == 3) {
                zH = w9.n.e().j();
            } else if (iD == 4) {
                zH = w9.n.e().f();
            } else if (iD == 5) {
                zH = w9.n.e().i();
            } else if (iD == 11) {
            }
            if (zH) {
                final String strTrim = (iD != 11 || (iLastIndexOf = url.lastIndexOf("?folder=")) <= 0) ? null : url.substring(iLastIndexOf + 8).trim();
                final WeakReference weakReference = new WeakReference(aVar);
                ((autodispose2.r) x6.o.g(new Callable() { // from class: c8.r8
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.f2806e.H0(iD, strTrim);
                    }
                }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(O0()))).a(new a7.e() { // from class: c8.s8
                    @Override // a7.e
                    public final void accept(Object obj) {
                        na.q(weakReference, (String) obj);
                    }
                }, new x7.g0());
            }
        }
    }

    public final void y0(r4.g gVar, boolean z10, int i10) {
        this.f2700a.g(gVar, i10, z10);
    }

    public void y1() {
        x1(L0());
    }

    public boolean z0(String str) {
        return this.f2706g.x(str);
    }

    public final void z1(String str) {
        this.f2702c.n(str);
    }
}
