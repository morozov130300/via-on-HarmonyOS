package mark.via.browser;

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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class p8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r8 f9415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u9.l f9416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u4.a f9417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w9.a f9418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final z9.d f9419e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final pb.b f9420f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final m9.c f9421g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ha.g f9422h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ka.h f9423i;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f9427m;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f9424j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f9425k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f9426l = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f9430p = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final HashSet f9431q = new HashSet();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f9432r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public s6.b f9433s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Map f9434t = new HashMap();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f9435u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f9436v = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f9428n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List f9429o = new ArrayList();

    public p8(r8 r8Var, u9.l lVar, w9.a aVar, z9.d dVar, u4.a aVar2, pb.b bVar, m9.c cVar, ha.g gVar, ka.h hVar) {
        this.f9416b = lVar;
        this.f9418d = aVar;
        this.f9419e = dVar;
        this.f9415a = r8Var;
        this.f9417c = aVar2;
        this.f9420f = bVar;
        this.f9421g = cVar;
        this.f9422h = gVar;
        this.f9423i = hVar;
    }

    public static /* synthetic */ void B(p8 p8Var, boolean z10, int i10) {
        if (z10) {
            p8Var.Y1(i10);
        } else {
            p8Var.getClass();
        }
    }

    public static /* synthetic */ void D(final p8 p8Var, View view) {
        p8Var.getClass();
        p8Var.E0(new Runnable() { // from class: mark.via.browser.c8
            @Override // java.lang.Runnable
            public final void run() {
                p8 p8Var2 = this.f9060c;
                ((autodispose2.n) p8Var2.H1().G(a7.a.c()).C(q6.b.b()).L(s8.b.c(p8Var2.P0()))).b(new u6.f() { // from class: mark.via.browser.g8
                    @Override // u6.f
                    public final void accept(Object obj) {
                        p8Var2.y0((r4.g) obj, false);
                    }
                }, new w7.a0(), new u6.a() { // from class: mark.via.browser.h8
                    @Override // u6.a
                    public final void run() {
                        p8 p8Var3 = p8Var2;
                        p8Var3.Y1(Math.min(p8Var3.T0() - 1, Math.max(0, p8Var3.f9430p)));
                    }
                });
            }
        });
    }

    public static /* synthetic */ String E(p8 p8Var, String str, Integer num) {
        p8Var.getClass();
        tc.a.a("generate page at %s", Thread.currentThread().getName());
        return p8Var.I0(num.intValue(), str);
    }

    public static /* synthetic */ void F(p8 p8Var, Bundle bundle, ka.f fVar, long j10) {
        if (bundle != null) {
            p8Var.getClass();
            if (!bundle.isEmpty()) {
                String strJ = x8.c1.J(p8Var.f9415a.G(), fVar.c());
                if (ka.j.d(bundle, strJ)) {
                    fVar.j(j10);
                    fVar.g(strJ);
                }
            }
        }
        p8Var.f9423i.a(fVar);
    }

    public static /* synthetic */ Integer H(p8 p8Var) {
        List listU = p8Var.f9418d.u();
        if (listU.isEmpty()) {
            return 1;
        }
        return Integer.valueOf(p8Var.f9421g.A(x8.n.c(listU)));
    }

    public static /* synthetic */ void I(p8 p8Var, List list) {
        p8Var.getClass();
        int size = list.size();
        int size2 = 0;
        while (true) {
            if (size2 >= size) {
                size2 = -1;
                break;
            } else if ((((ka.f) list.get(size2)).b() & 4) == 4) {
                break;
            } else {
                size2++;
            }
        }
        if (size2 <= -1) {
            size2 = list.size() + p8Var.T0();
        }
        p8Var.f9430p = size2;
    }

    public static /* synthetic */ void M(p8 p8Var, ka.k kVar) {
        p8Var.getClass();
        p8Var.f9430p = kVar.a() + p8Var.T0();
    }

    public static /* synthetic */ String N(p8 p8Var, Bundle bundle, ka.f fVar, int i10) {
        p8Var.getClass();
        if (bundle != null && !bundle.isEmpty()) {
            String strJ = x8.c1.J(p8Var.f9415a.G(), fVar.c());
            if (ka.j.d(bundle, strJ)) {
                fVar.g(strJ);
            }
        }
        fVar.j(System.currentTimeMillis());
        if (!p8Var.f9423i.a(fVar)) {
            return "";
        }
        p8Var.f9434t.remove(Integer.valueOf(i10));
        return fVar.c();
    }

    public static /* synthetic */ void O(List list) {
        if (list.isEmpty()) {
            tc.a.a("sync data done", new Object[0]);
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            tc.a.a("sync data error: %s", ((rb.f) it.next()).a());
        }
    }

    public static /* synthetic */ void Q(p8 p8Var, x.d dVar, View view) {
        p8Var.getClass();
        p8Var.G1((String[]) dVar.f14455a, (String) ((x.d) dVar.f14456b).f14455a);
    }

    public static /* synthetic */ void S(final p8 p8Var, int i10, final x.d dVar) {
        p8Var.getClass();
        if (((String[]) dVar.f14455a).length <= 0 || !p8Var.f9416b.v().s()) {
            return;
        }
        p8Var.f9415a.U((((String[]) dVar.f14455a).length != 1 || TextUtils.isEmpty((CharSequence) ((x.d) dVar.f14456b).f14456b)) ? p8Var.f9415a.G().getResources().getQuantityString(w7.t.f13965g, i10, Integer.valueOf(i10)) : p8Var.f9415a.G().getString(w7.u.A2, ((x.d) dVar.f14456b).f14456b), w7.u.th, new View.OnClickListener() { // from class: mark.via.browser.b7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p8.Q(this.f9031a, dVar, view);
            }
        });
    }

    public static /* synthetic */ boolean T(ka.k kVar) {
        return !kVar.c();
    }

    public static /* synthetic */ x.d a(p8 p8Var, List list, List list2, Map map, String str) {
        p8Var.f9423i.i(list);
        int size = list2.size();
        if (size != 0) {
            String[] strArr = new String[size];
            Iterator it = list2.iterator();
            String strC = null;
            while (it.hasNext()) {
                ka.f fVar = (ka.f) it.next();
                Bundle bundle = (Bundle) map.get(fVar.c());
                if (bundle != null && !bundle.isEmpty()) {
                    String strJ = x8.c1.J(p8Var.f9415a.G(), fVar.c());
                    if (ka.j.d(bundle, strJ)) {
                        fVar.g(strJ);
                    }
                }
                fVar.j(System.currentTimeMillis());
                if (strC == null) {
                    strC = c6.y1.f2139a.c(fVar.e(), fVar.f(), p8Var.f9415a.G().getString(w7.u.Ah), 128);
                }
                size--;
                strArr[size] = fVar.c();
            }
            if (p8Var.f9423i.d(list2)) {
                return x.d.a(strArr, x.d.a(str, strC));
            }
        }
        return null;
    }

    public static /* synthetic */ Boolean a0(p8 p8Var, String str, boolean z10) {
        if (p8Var.L0() == null || p8Var.L0().o() == null) {
            return Boolean.FALSE;
        }
        String strD = x8.c1.D(p8Var.f9415a.G());
        File file = new File(strD, x8.c1.L(strD, x8.c1.o(str), z10 ? ".pdf" : ".mht"));
        if (Build.VERSION.SDK_INT < 21 || !z10) {
            s4.b.j(p8Var.L0().o(), file.getAbsolutePath());
            return Boolean.TRUE;
        }
        x8.u1.a(p8Var.L0().o(), file.getParent(), file.getName());
        return Boolean.TRUE;
    }

    public static /* synthetic */ boolean b(List list) {
        return !list.isEmpty();
    }

    public static /* synthetic */ boolean b0(Integer num) {
        return num.intValue() > 0;
    }

    public static /* synthetic */ void c0(p8 p8Var, r4.g gVar) {
        p8Var.y0(gVar, false);
        tc.a.a("create tab", new Object[0]);
    }

    public static /* synthetic */ void d(p8 p8Var, List list, List list2, Map map, long j10) {
        ka.e.a(p8Var.f9415a.G());
        p8Var.f9423i.i(list);
        p8Var.f9423i.d(list2);
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            ka.f fVar = (ka.f) it.next();
            Bundle bundle = (Bundle) map.get(fVar.c());
            if (bundle != null && !bundle.isEmpty()) {
                String strJ = x8.c1.J(p8Var.f9415a.G(), fVar.c());
                if (ka.j.d(bundle, strJ)) {
                    fVar.j(System.currentTimeMillis());
                    fVar.g(strJ);
                }
            }
        }
        p8Var.f9423i.d(list2);
        tc.a.a("save open tabs, cost: %dms", Long.valueOf(SystemClock.uptimeMillis() - j10));
    }

    public static /* synthetic */ void d0(final p8 p8Var, final String[] strArr, final String str, View view) {
        p8Var.getClass();
        p8Var.E0(new Runnable() { // from class: mark.via.browser.e8
            @Override // java.lang.Runnable
            public final void run() {
                this.f9110c.G1(strArr, str);
            }
        });
    }

    public static /* synthetic */ r4.g f(p8 p8Var, String str) {
        p8Var.getClass();
        if (URLUtil.isContentUrl(str)) {
            String strA = x8.c1.A(p8Var.f9415a.G(), str);
            if (strA != null) {
                str = Uri.fromFile(new File(strA)).toString();
            }
        } else if (x8.z.M(str)) {
            x.d dVarP = x8.z.P(str);
            str = p8Var.I0(((Integer) dVarP.f14455a).intValue(), (String) dVarP.f14456b);
        }
        return new r4.h(str);
    }

    public static /* synthetic */ void f0(final p8 p8Var, int i10, String str, final boolean z10, final String str2) {
        if (p8Var.f9435u == i10) {
            p8Var.f9436v = str2;
        }
        if (str2.isEmpty() || !p8Var.f9416b.v().s()) {
            return;
        }
        p8Var.f9415a.U(p8Var.f9415a.G().getString(w7.u.A2, str), w7.u.th, new View.OnClickListener() { // from class: mark.via.browser.e7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p8.i(this.f9107a, str2, z10, view);
            }
        });
    }

    public static /* synthetic */ void h(p8 p8Var, int i10, String str) {
        if (p8Var.L0() != null && s9.d.l(p8Var.f9415a.G(), p8Var.L0().getUrl())) {
            p8Var.L0().u(str);
        } else if (i10 == 10 || i10 == 6) {
            p8Var.j1(str, true);
        } else {
            p8Var.k1(str, true);
        }
    }

    public static /* synthetic */ void i(p8 p8Var, String str, boolean z10, View view) {
        p8Var.getClass();
        String[] strArr = {str};
        if (!z10) {
            str = null;
        }
        p8Var.G1(strArr, str);
    }

    public static /* synthetic */ void j(p8 p8Var, ka.k kVar) {
        p8Var.getClass();
        p8Var.f9430p = kVar.a() + 1;
    }

    public static /* synthetic */ ka.k k(p8 p8Var, boolean z10) {
        p8Var.f9423i.k();
        boolean zD = ka.e.d(p8Var.f9415a.G());
        if (z10 && zD) {
            return ka.e.c(p8Var.f9415a.G());
        }
        int iV1 = p8Var.f9416b.v1();
        if (!zD || iV1 == 0 || p8Var.f9416b.n2().s()) {
            return null;
        }
        if (iV1 != 2) {
            return ka.e.c(p8Var.f9415a.G());
        }
        p8Var.E1();
        return null;
    }

    public static /* synthetic */ void l(Reference reference, String str) {
        r4.a aVar = (r4.a) reference.get();
        if (aVar == null) {
            return;
        }
        aVar.u(str);
    }

    public static /* synthetic */ String m(final p8 p8Var, Intent intent) {
        p8Var.getClass();
        tc.a.a("intentTab", new Object[0]);
        if (intent != null) {
            final String strZ = x8.z.z(intent, null);
            c6.a2 a2Var = c6.a2.f1958a;
            if (a2Var.u(strZ)) {
                strZ = a2Var.q(strZ) ? c6.y1.f2139a.h(p8Var.f9416b.b1(), strZ) : a2Var.w(strZ, p8Var.f9416b.b1());
            } else if (strZ != null && !strZ.isEmpty()) {
                final List listE = c6.y1.f2139a.e(strZ);
                if (listE.isEmpty()) {
                    strZ = a2Var.w(strZ, p8Var.f9416b.b1());
                } else if (listE.size() == 1) {
                    strZ = (String) listE.get(0);
                } else {
                    p8Var.E0(new Runnable() { // from class: mark.via.browser.f7
                        @Override // java.lang.Runnable
                        public final void run() {
                            p8 p8Var2 = this.f9135c;
                            p8Var2.f9415a.M(new Runnable() { // from class: mark.via.browser.x7
                                @Override // java.lang.Runnable
                                public final void run() {
                                    p8Var2.f9415a.p(str, list);
                                }
                            });
                        }
                    });
                    strZ = null;
                }
            }
            if (!TextUtils.isEmpty(strZ)) {
                if (x8.r2.x(strZ)) {
                    p8Var.E0(new Runnable() { // from class: mark.via.browser.g7
                        @Override // java.lang.Runnable
                        public final void run() {
                            p8 p8Var2 = this.f9158c;
                            p8Var2.f9415a.M(new Runnable() { // from class: mark.via.browser.z7
                                @Override // java.lang.Runnable
                                public final void run() {
                                    p8Var2.f9415a.t(str);
                                }
                            });
                        }
                    });
                    return null;
                }
                if (!a2Var.q(strZ)) {
                    if (!x8.z.L(strZ)) {
                        p8Var.E0(new Runnable() { // from class: mark.via.browser.i7
                            @Override // java.lang.Runnable
                            public final void run() {
                                p8 p8Var2 = this.f9227c;
                                p8Var2.f9415a.M(new Runnable() { // from class: mark.via.browser.a8
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f9003c.f9415a.t(str);
                                    }
                                });
                            }
                        });
                        return null;
                    }
                    p8Var.g2(intent);
                    p8Var.f9430p = -1;
                    return strZ;
                }
            }
        }
        return null;
    }

    public static /* synthetic */ List s(p8 p8Var, boolean z10) {
        p8Var.f9423i.k();
        List listF = p8Var.f9423i.f(z10);
        boolean zIsEmpty = listF.isEmpty();
        if (!z10 || zIsEmpty) {
            int iV1 = p8Var.f9416b.v1();
            if (zIsEmpty || iV1 == 0 || p8Var.f9416b.n2().s()) {
                p8Var.i2();
                return null;
            }
            if (iV1 == 2) {
                p8Var.F1();
                return null;
            }
        }
        return listF;
    }

    public static /* synthetic */ void t(p8 p8Var, List list) {
        t4.b bVarO;
        r4.a aVarD = p8Var.f9415a.d();
        if (aVarD == null || (bVarO = aVarD.o()) == null) {
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
            sb2.append(((ha.a) list.get(i10)).b());
            sb2.append('\'');
        }
        sb2.append("]);}catch(e){}");
        s4.b.g(bVarO, sb2.toString());
    }

    public static /* synthetic */ void u(p8 p8Var, r4.g gVar) {
        int i10;
        p8Var.getClass();
        String url = gVar.getUrl();
        if (!c6.a2.f1958a.t(url)) {
            i10 = -1;
            break;
        }
        List listS0 = p8Var.S0();
        int size = listS0.size();
        i10 = 0;
        while (true) {
            if (i10 >= size) {
                i10 = -1;
                break;
            } else if (url.equals(((r4.a) listS0.get(i10)).getUrl())) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 >= 0) {
            p8Var.Y1(i10);
        } else {
            p8Var.i1(gVar, true, p8Var.M0() + 1);
        }
    }

    public static /* synthetic */ r4.g v(p8 p8Var, String str) {
        int i10;
        p8Var.getClass();
        if (URLUtil.isAboutUrl(str)) {
            if ("about:home".equals(str)) {
                i10 = 1;
            } else if ("about:bookmarks".equals(str)) {
                i10 = 2;
            } else {
                i10 = "about:blank".equals(str) ? 12 : 0;
            }
            if (i10 != 0) {
                tc.a.a("get home init in %s", Thread.currentThread().getName());
                str = p8Var.I0(i10, null);
            }
        }
        return new r4.h(str);
    }

    public static /* synthetic */ void w(p8 p8Var, long j10) {
        if (p8Var.L0() == null) {
            int i10 = p8Var.f9430p;
            if (i10 < 0 || i10 >= p8Var.T0()) {
                p8Var.Y1(p8Var.T0() - 1);
            } else {
                p8Var.Y1(p8Var.f9430p);
            }
        }
        r4.a aVarL0 = p8Var.L0();
        if (aVarL0 != null) {
            aVarL0.w();
        }
        tc.a.a("is intent request: %s", Boolean.valueOf(p8Var.f9426l));
        p8Var.H0();
        tc.a.a("BrowserPresenter::setupTabs, cost time: %d", Long.valueOf(SystemClock.elapsedRealtime() - j10));
    }

    public static /* synthetic */ Iterable y(p8 p8Var, List list) {
        p8Var.getClass();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        boolean z10 = true;
        while (it.hasNext()) {
            ka.f fVar = (ka.f) it.next();
            if ((fVar.b() & 4) == 4) {
                z10 = false;
            }
            arrayList.add(ka.j.e(fVar));
        }
        if (z10) {
            arrayList.add(p8Var.O0());
        }
        return arrayList;
    }

    public static /* synthetic */ boolean z(ka.k kVar) {
        return !kVar.c();
    }

    public boolean A0(String str) {
        return this.f9421g.x(str);
    }

    public final void A1(final String str) {
        x8.h.b(new Runnable() { // from class: mark.via.browser.f8
            @Override // java.lang.Runnable
            public final void run() {
                this.f9138c.f9417c.o(str);
            }
        });
    }

    public boolean B0(String str) {
        return this.f9421g.c(str);
    }

    public void B1(String str) {
        A1(b5.c.y(str, true));
    }

    public void C0() {
        D0(M0());
    }

    public void C1(String str) {
        A1(b5.c.y(str, false));
    }

    public void D0(int i10) {
        tc.a.a("is intent request: %s", Boolean.valueOf(this.f9426l));
        int iT0 = T0();
        boolean z10 = this.f9426l && (i10 == M0()) && L0() != null && !s9.d.l(this.f9415a.G(), L0().getUrl()) && iT0 <= 1;
        this.f9415a.b(i10);
        this.f9426l = false;
        tc.a.a("delete tab at %d", Integer.valueOf(i10));
        if (!z10) {
            if (iT0 == 1) {
                h1(null, true, 0);
            }
        } else if (this.f9415a.i() > 0) {
            ((Activity) this.f9415a.G()).moveTaskToBack(true);
        } else {
            ((Activity) this.f9415a.G()).finish();
        }
    }

    public void D1(String str) {
        r6.j jVarM;
        s6.b bVar = this.f9433s;
        if (bVar != null) {
            if (!bVar.isDisposed()) {
                this.f9433s.dispose();
            }
            this.f9433s = null;
        }
        int iX1 = this.f9416b.X1();
        if (iX1 == 0) {
            return;
        }
        if (str == null || str.isEmpty()) {
            jVarM = this.f9422h.m(str, iX1);
        } else {
            this.f9422h.s(this.f9416b.Y());
            jVarM = this.f9422h.p(str, iX1);
        }
        this.f9433s = ((autodispose2.n) jVarM.G(a7.a.c()).C(q6.b.b()).L(s8.b.c(P0()))).a(new u6.f() { // from class: mark.via.browser.u7
            @Override // u6.f
            public final void accept(Object obj) {
                p8.t(this.f9687c, (List) obj);
            }
        }, new w7.e0());
    }

    public void E0(Runnable runnable) {
        if (this.f9428n) {
            runnable.run();
        } else {
            this.f9429o.add(runnable);
        }
    }

    public final void E1() {
        this.f9415a.R(w7.u.Bb, R.string.ok, new View.OnClickListener() { // from class: mark.via.browser.b8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p8.D(this.f9033a, view);
            }
        });
    }

    public WebResourceResponse F0(WebResourceRequest webResourceRequest, String str, String str2) {
        String str3 = this.f9432r;
        if (str3 != null && !str3.isEmpty() && str.endsWith(this.f9432r)) {
            return la.s.g().f(this.f9416b.c1());
        }
        if (str == null || !str.endsWith("via_inject_blocker.css")) {
            if (!V1(webResourceRequest, str, str2)) {
                return null;
            }
            if (str2 != null && !str.equals(str2)) {
                String strE = x8.z.E(str);
                return (strE.length() <= 1 || !"html|htm|css|js".contains(strE)) ? u4.a.f12861d : u4.a.f12860c;
            }
            if (this.f9431q.contains(c6.a2.f1958a.g(str))) {
                return null;
            }
            w4.d dVarL = this.f9417c.l(str, null);
            WebResourceResponse webResourceResponse = new WebResourceResponse("text/html", "UTF-8", new ByteArrayInputStream(s9.a.a(this.f9415a.G(), str, dVarL == null ? "" : dVarL.m()).getBytes(k8.a.f7218a)));
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
        String strE2 = this.f9417c.e(str);
        if (strE2 != null) {
            sb2.append(strE2);
        }
        String strC = k8.b.c(str);
        if (strC != null) {
            sb2.append(strC);
        }
        if (sb2.length() == 0) {
            return u4.a.f12860c;
        }
        WebResourceResponse webResourceResponse2 = new WebResourceResponse("text/css", "UTF-8", new ByteArrayInputStream(sb2.toString().getBytes(k8.a.f7218a)));
        if (Build.VERSION.SDK_INT >= 21) {
            HashMap map2 = new HashMap();
            map2.put("Cache-Control", "no-cache");
            map2.put("Access-Control-Allow-Origin", "*");
            map2.put("Content-Type", "text/css");
            webResourceResponse2.setResponseHeaders(map2);
        }
        return webResourceResponse2;
    }

    public final void F1() {
        List listF = this.f9423i.f(false);
        int size = listF.size();
        final String[] strArr = new String[size];
        final String str = null;
        for (int i10 = 0; i10 < size; i10++) {
            strArr[i10] = ((ka.f) listF.get(i10)).c();
            if ((((ka.f) listF.get(i10)).b() & 4) == 4) {
                str = strArr[i10];
            }
        }
        x8.h.b(new Runnable() { // from class: mark.via.browser.v7
            @Override // java.lang.Runnable
            public final void run() {
                this.f9707c.i2();
            }
        });
        this.f9415a.R(w7.u.Bb, R.string.ok, new View.OnClickListener() { // from class: mark.via.browser.w7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p8.d0(this.f9730a, strArr, str, view);
            }
        });
    }

    public int G0(int i10) {
        return this.f9415a.e(i10);
    }

    public void G1(String[] strArr, String str) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i10 = -1;
        int i11 = 0;
        for (String str2 : strArr) {
            ka.f fVarJ = this.f9423i.j(str2);
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
        final boolean z10 = T0() <= 0 || M0() < 0 || i10 >= 0;
        if (i10 < 0) {
            i10 = i11 - 1;
        }
        final int iT0 = T0() + Math.min(Math.max(i10, 0), i11 - 1);
        ((autodispose2.n) r6.j.w(arrayList).A(new u6.g() { // from class: mark.via.browser.h7
            @Override // u6.g
            public final Object apply(Object obj) {
                return ka.j.e((ka.f) obj);
            }
        }).G(a7.a.c()).C(q6.b.b()).L(s8.b.c(P0()))).b(new u6.f() { // from class: mark.via.browser.s7
            @Override // u6.f
            public final void accept(Object obj) {
                this.f9642c.y0((r4.g) obj, false);
            }
        }, new w7.e0(), new u6.a() { // from class: mark.via.browser.d8
            @Override // u6.a
            public final void run() {
                p8.B(this.f9088a, z10, iT0);
            }
        });
    }

    public final void H0() {
        this.f9428n = true;
        Iterator it = this.f9429o.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.f9429o.clear();
    }

    public final r6.j H1() {
        return r6.q.f(new Callable() { // from class: mark.via.browser.i8
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ka.e.c(this.f9229c.f9415a.G());
            }
        }).d(new u6.i() { // from class: mark.via.browser.j8
            @Override // u6.i
            public final boolean test(Object obj) {
                return p8.z((ka.k) obj);
            }
        }).d(new u6.f() { // from class: mark.via.browser.k8
            @Override // u6.f
            public final void accept(Object obj) {
                p8.j(this.f9282c, (ka.k) obj);
            }
        }).g(new r7());
    }

    public final String I0(int i10, String str) {
        switch (i10) {
            case 1:
                return p8.d.f(this.f9415a.G());
            case 2:
                return s9.c.c(this.f9415a.G(), null);
            case 3:
                return s9.c.f(this.f9415a.G());
            case 4:
            case 8:
            case 9:
            default:
                return null;
            case 5:
                return s9.c.e(this.f9415a.G());
            case 6:
            case 10:
                return s9.c.g(this.f9415a.G(), b8.d.c().d(this.f9427m), i10 == 10);
            case 7:
                return s9.c.h(this.f9415a.G());
            case 11:
                return s9.c.c(this.f9415a.G(), str);
            case 12:
                return s9.c.b(this.f9415a.G());
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
                                arrayList.add(new l9.b(strOptString, jSONObjectOptJSONObject.optString("alt")));
                            }
                        }
                    } catch (JSONException e10) {
                        tc.a.j(e10);
                    }
                }
                return s9.c.j(this.f9415a.G(), this.f9415a.a0(), arrayList);
        }
    }

    public final r6.j I1(boolean z10) {
        return ka.e.d(this.f9415a.G()) ? J1(z10) : K1(z10);
    }

    public String J0(String str) {
        return k8.b.a(this.f9417c.e(str));
    }

    public final r6.j J1(final boolean z10) {
        return r6.f.h(new Callable() { // from class: mark.via.browser.o7
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return p8.k(this.f9395c, z10);
            }
        }).e(new u6.i() { // from class: mark.via.browser.p7
            @Override // u6.i
            public final boolean test(Object obj) {
                return p8.T((ka.k) obj);
            }
        }).d(new u6.f() { // from class: mark.via.browser.q7
            @Override // u6.f
            public final void accept(Object obj) {
                p8.M(this.f9541c, (ka.k) obj);
            }
        }).g(new r7());
    }

    public int K0(String str) {
        y9.b bVarE = this.f9419e.e(c6.a2.f1958a.f(str));
        return (bVarE == null || !bVarE.s() || bVarE.b() == 0) ? this.f9416b.n2().e() : bVarE.b();
    }

    public final r6.j K1(final boolean z10) {
        return r6.f.h(new Callable() { // from class: mark.via.browser.j7
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return p8.s(this.f9256c, z10);
            }
        }).e(new u6.i() { // from class: mark.via.browser.k7
            @Override // u6.i
            public final boolean test(Object obj) {
                return p8.b((List) obj);
            }
        }).d(new u6.f() { // from class: mark.via.browser.l7
            @Override // u6.f
            public final void accept(Object obj) {
                p8.I(this.f9305c, (List) obj);
            }
        }).g(new u6.g() { // from class: mark.via.browser.m7
            @Override // u6.g
            public final Object apply(Object obj) {
                return p8.y(this.f9347a, (List) obj);
            }
        });
    }

    public r4.a L0() {
        return this.f9415a.d();
    }

    public void L1(r4.a aVar) {
        if (aVar == null) {
            return;
        }
        String url = aVar.getUrl();
        final int id = aVar.getId();
        if (!X1(url) || g1(url)) {
            final String str = (String) this.f9434t.get(Integer.valueOf(id));
            if (str != null) {
                this.f9434t.remove(Integer.valueOf(id));
                x8.h.b(new Runnable() { // from class: mark.via.browser.p6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f9413c.f9423i.b(str);
                    }
                });
                return;
            }
            return;
        }
        final int i10 = this.f9435u + 1;
        this.f9435u = i10;
        String title = aVar.getTitle();
        final ka.f fVarJ = this.f9423i.j((String) this.f9434t.get(Integer.valueOf(id)));
        if (fVarJ == null) {
            fVarJ = new ka.f(UUID.randomUUID().toString());
        }
        final Bundle bundleB = fVarJ.d() < aVar.g() ? aVar.b() : null;
        fVarJ.l(url);
        fVarJ.k(title);
        fVarJ.h(fVarJ.b() & (-8));
        final boolean zD = aVar.d();
        final String strC = c6.y1.f2139a.c(title, url, this.f9415a.G().getString(w7.u.Ah), 128);
        ((autodispose2.r) r6.q.f(new Callable() { // from class: mark.via.browser.q6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return p8.N(this.f9537c, bundleB, fVarJ, id);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.c(P0()))).a(new u6.f() { // from class: mark.via.browser.r6
            @Override // u6.f
            public final void accept(Object obj) {
                p8.f0(this.f9601c, i10, strC, zD, (String) obj);
            }
        }, new w7.e0());
    }

    public int M0() {
        return this.f9415a.k();
    }

    public void M1(List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (list.size() == 1) {
            L1((r4.a) list.get(0));
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
            if (url == null || url.isEmpty() || hashSet.contains(url) || !X1(url) || g1(url)) {
                String str = (String) this.f9434t.get(Integer.valueOf(id));
                if (str != null) {
                    arrayList.add(str);
                }
            } else {
                hashSet.add(url);
                ka.f fVarJ = this.f9423i.j((String) this.f9434t.get(Integer.valueOf(id)));
                if (fVarJ == null) {
                    fVarJ = new ka.f(UUID.randomUUID().toString());
                }
                fVarJ.l(url);
                fVarJ.k(aVar.getTitle());
                fVarJ.h(0);
                if (aVar.d()) {
                    strC = fVarJ.c();
                }
                if (fVarJ.d() < aVar.g()) {
                    map.put(fVarJ.c(), aVar.b());
                }
                arrayList2.add(fVarJ);
            }
        }
        final int size = list.size();
        final String str2 = strC;
        ((autodispose2.m) r6.f.h(new Callable() { // from class: mark.via.browser.d6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return p8.a(this.f9081c, arrayList, arrayList2, map, str2);
            }
        }).n(a7.a.c()).k(q6.b.b()).p(s8.b.c(P0()))).a(new u6.f() { // from class: mark.via.browser.e6
            @Override // u6.f
            public final void accept(Object obj) {
                p8.S(this.f9105c, size, (x.d) obj);
            }
        }, new w7.e0());
    }

    public final r6.j N0() {
        return r6.j.z(this.f9416b.p()).A(new u6.g() { // from class: mark.via.browser.a7
            @Override // u6.g
            public final Object apply(Object obj) {
                return p8.v(this.f9002a, (String) obj);
            }
        });
    }

    public void N1(r4.a aVar) {
        if (aVar == null) {
            return;
        }
        String url = aVar.getUrl();
        int id = aVar.getId();
        if (g1(url)) {
            final String str = (String) this.f9434t.get(Integer.valueOf(id));
            if (str != null) {
                this.f9434t.remove(Integer.valueOf(id));
                x8.h.b(new Runnable() { // from class: mark.via.browser.f6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f9133c.f9423i.b(str);
                    }
                });
                return;
            }
            return;
        }
        int i10 = !X1(url) ? 1 : 0;
        String title = aVar.getTitle();
        final long jG = aVar.g();
        ka.f fVarJ = this.f9423i.j((String) this.f9434t.get(Integer.valueOf(id)));
        final Bundle bundleB = (fVarJ == null || fVarJ.d() < jG) ? aVar.b() : null;
        if (fVarJ == null) {
            fVarJ = new ka.f(UUID.randomUUID().toString());
            this.f9434t.put(Integer.valueOf(id), fVarJ.c());
        }
        final ka.f fVar = fVarJ;
        fVar.k(title);
        fVar.l(url);
        fVar.h(i10 | 2);
        x8.h.b(new Runnable() { // from class: mark.via.browser.g6
            @Override // java.lang.Runnable
            public final void run() {
                p8.F(this.f9154c, bundleB, fVar, jG);
            }
        });
    }

    public final r4.g O0() {
        int i10;
        String strP = this.f9416b.p();
        if (URLUtil.isAboutUrl(strP)) {
            if ("about:home".equals(strP)) {
                i10 = 1;
            } else if ("about:bookmarks".equals(strP)) {
                i10 = 2;
            } else {
                i10 = "about:blank".equals(strP) ? 12 : 0;
            }
            if (i10 != 0) {
                strP = I0(i10, null);
            }
        }
        return new r4.h(strP);
    }

    public void O1() {
        if (this.f9428n) {
            final long jUptimeMillis = SystemClock.uptimeMillis();
            List<r4.a> listS0 = S0();
            final HashMap map = new HashMap();
            final ArrayList arrayList = new ArrayList();
            final ArrayList arrayList2 = new ArrayList();
            for (r4.a aVar : listS0) {
                String url = aVar.getUrl();
                if (g1(url)) {
                    String str = (String) this.f9434t.get(Integer.valueOf(aVar.getId()));
                    if (str != null) {
                        arrayList2.add(str);
                    }
                } else {
                    ka.f fVarJ = this.f9423i.j((String) this.f9434t.get(Integer.valueOf(aVar.getId())));
                    if (fVarJ == null) {
                        fVarJ = new ka.f(UUID.randomUUID().toString());
                        this.f9434t.put(Integer.valueOf(aVar.getId()), fVarJ.c());
                    }
                    if (fVarJ.d() < aVar.g()) {
                        map.put(fVarJ.c(), aVar.b());
                    }
                    fVarJ.l(url);
                    fVarJ.k(aVar.getTitle());
                    fVarJ.h((aVar.d() ? 4 : 0) | (!X1(url) ? 1 : 0) | 2);
                    arrayList.add(fVarJ);
                }
            }
            x8.h.b(new Runnable() { // from class: mark.via.browser.l8
                @Override // java.lang.Runnable
                public final void run() {
                    p8.d(this.f9306c, arrayList2, arrayList, map, jUptimeMillis);
                }
            });
        }
    }

    public final autodispose2.androidx.lifecycle.b P0() {
        return autodispose2.androidx.lifecycle.b.i(this.f9415a.i0());
    }

    public r6.j P1(final String str, final boolean z10) {
        return r6.j.v(new Callable() { // from class: mark.via.browser.n7
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return p8.a0(this.f9370c, str, z10);
            }
        }).G(q6.b.b()).C(q6.b.b());
    }

    public int Q0(String str) {
        y9.b bVarE = this.f9419e.e(c6.a2.f1958a.f(str));
        return (bVarE == null || !bVarE.s() || bVarE.h() == 0) ? this.f9416b.n2().f() : bVarE.h();
    }

    public void Q1() {
        t4.b bVarO = L0() != null ? L0().o() : null;
        if (c6.a2.f1958a.m(bVarO == null ? null : bVarO.getUrl())) {
            this.f9415a.n(w7.u.Z1);
        } else {
            this.f9415a.j0(com.tuyafeng.support.utils.p.n(bVarO != null ? bVarO.getTitle() : null, UUID.randomUUID().toString().toUpperCase(Locale.ROOT)));
        }
    }

    public final String R0(Intent intent) {
        Uri referrer;
        if (intent == null || !intent.hasExtra("mark.via.REFERER")) {
            referrer = null;
        } else {
            try {
                referrer = Build.VERSION.SDK_INT >= 33 ? (Uri) intent.getParcelableExtra("mark.via.REFERER", Uri.class) : (Uri) intent.getParcelableExtra("mark.via.REFERER");
            } catch (Exception e10) {
                tc.a.j(e10);
                referrer = null;
            }
        }
        if (referrer == null && Build.VERSION.SDK_INT >= 22) {
            referrer = com.tuyafeng.support.utils.f.a(this.f9415a.G()).getReferrer();
        }
        if (referrer == null) {
            return null;
        }
        return referrer.getHost();
    }

    public void R1(String str, int i10) {
        if (str == null || str.isEmpty()) {
            return;
        }
        String strF = c6.a2.f1958a.f(str);
        y9.a aVarH = this.f9419e.h(strF);
        aVarH.S(true);
        if (i10 == this.f9416b.H0()) {
            i10 = 0;
        }
        aVarH.d0(i10);
        if (aVarH.r()) {
            this.f9419e.b(strF);
        } else {
            this.f9419e.k(strF, aVarH);
        }
    }

    public List S0() {
        return this.f9415a.c();
    }

    public void S1(boolean z10) {
        tc.a.a("BrowserPresenter::setupTabs", new Object[0]);
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        ((autodispose2.n) a1(z10).G(a7.a.c()).C(q6.b.b()).L(s8.b.c(P0()))).b(new u6.f() { // from class: mark.via.browser.j6
            @Override // u6.f
            public final void accept(Object obj) {
                p8.c0(this.f9255c, (r4.g) obj);
            }
        }, new w7.a0(), new u6.a() { // from class: mark.via.browser.k6
            @Override // u6.a
            public final void run() {
                p8.w(this.f9280a, jElapsedRealtime);
            }
        });
    }

    public int T0() {
        return this.f9415a.i();
    }

    public void T1() {
        r4.a aVarL0 = L0();
        String url = aVarL0 == null ? null : aVarL0.getUrl();
        if (aVarL0 == null || TextUtils.isEmpty(url) || c6.a2.f1958a.m(url)) {
            url = "http://viayoo.com/";
        } else {
            String title = aVarL0.getTitle();
            if (title != null && !title.isEmpty()) {
                url = title + "\n" + url;
            }
        }
        x8.e1.k(this.f9415a.G(), url);
    }

    public int U0(String str) {
        y9.b bVarE = this.f9419e.e(c6.a2.f1958a.f(str));
        if (bVarE == null || !bVarE.s()) {
            return 0;
        }
        return bVarE.i(0);
    }

    public boolean U1(String str) {
        return !this.f9417c.t(str, null);
    }

    public void V0() {
        String str = this.f9436v;
        if (str == null || str.isEmpty()) {
            return;
        }
        String str2 = this.f9436v;
        G1(new String[]{str2}, str2);
        this.f9435u++;
        this.f9436v = null;
    }

    public final boolean V1(WebResourceRequest webResourceRequest, String str, String str2) {
        if (str == null) {
            return false;
        }
        c6.a2 a2Var = c6.a2.f1958a;
        if (a2Var.m(str) || a2Var.m(str2) || !c1(str2)) {
            return false;
        }
        boolean zS = webResourceRequest != null ? this.f9417c.s(webResourceRequest, str2) : this.f9417c.t(str, str2);
        if (zS) {
            this.f9424j++;
            this.f9425k += x8.z.B(str);
        }
        return zS;
    }

    public void W0() {
        final r4.a aVarL0 = L0();
        if (aVarL0 == null || s9.d.n(this.f9415a.G(), aVarL0.getUrl())) {
            return;
        }
        ((autodispose2.n) N0().A(new u6.g() { // from class: mark.via.browser.h6
            @Override // u6.g
            public final Object apply(Object obj) {
                return ((r4.g) obj).getUrl();
            }
        }).G(a7.a.c()).C(q6.b.b()).L(s8.b.c(P0()))).a(new u6.f() { // from class: mark.via.browser.i6
            @Override // u6.f
            public final void accept(Object obj) {
                aVarL0.u((String) obj);
            }
        }, new w7.a0());
    }

    public boolean W1(String str, String str2) {
        return this.f9417c.u(com.tuyafeng.support.utils.p.m(str), com.tuyafeng.support.utils.p.m(str2));
    }

    public boolean X0() {
        String str = this.f9436v;
        return (str == null || str.isEmpty()) ? false : true;
    }

    public boolean X1(String str) {
        y9.b bVarE = this.f9419e.e(c6.a2.f1958a.f(str));
        boolean zS = this.f9416b.n2().s();
        return (bVarE == null || !bVarE.s()) ? !zS : !bVarE.z(zS);
    }

    public boolean Y0(String str) {
        y9.b bVarE = this.f9419e.e(c6.a2.f1958a.f(str));
        return bVarE != null && bVarE.s();
    }

    public void Y1(int i10) {
        this.f9415a.j(i10);
    }

    public void Z1() {
        qb.a aVarD = this.f9420f.d();
        if (aVarD == null || !aVarD.g() || aVarD.e() == null || aVarD.e().a()) {
            return;
        }
        tc.a.a("sync data", new Object[0]);
        ((autodispose2.r) r6.q.f(new Callable() { // from class: mark.via.browser.v6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f9706c.f9420f.e(false);
            }
        }).k(a7.a.c()).l(s8.b.c(P0()))).a(new u6.f() { // from class: mark.via.browser.w6
            @Override // u6.f
            public final void accept(Object obj) {
                p8.O((List) obj);
            }
        }, new w7.e0());
    }

    public final r6.j a1(boolean z10) {
        return I1(z10).e(b1(this.f9415a.i0().getIntent())).l(new u6.a() { // from class: mark.via.browser.z6
            @Override // u6.a
            public final void run() {
                this.f9822a.o0();
            }
        }).H(N0());
    }

    public void a2() {
        if ((x8.a0.f() || x8.f.h()) && this.f9416b.M1() != -1) {
            c2();
        } else {
            b2();
        }
    }

    public final r6.f b1(final Intent intent) {
        return r6.f.h(new Callable() { // from class: mark.via.browser.x6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return p8.m(this.f9751c, intent);
            }
        }).j(new u6.g() { // from class: mark.via.browser.y6
            @Override // u6.g
            public final Object apply(Object obj) {
                return p8.f(this.f9780a, (String) obj);
            }
        });
    }

    public void b2() {
        r4.a aVarL0 = L0();
        if (aVarL0 == null || !c6.a2.f1958a.t(aVarL0.getUrl())) {
            this.f9415a.n(w7.u.Z1);
            return;
        }
        c6.x1.f2137a.j(new c6.f(aVarL0.o()), x8.s1.g(), this.f9415a.a0());
        this.f9415a.n(w7.u.si);
    }

    public boolean c1(String str) {
        if (p9.a.a().p(str)) {
            return false;
        }
        String strF = c6.a2.f1958a.f(str);
        boolean zG = this.f9416b.n2().g();
        y9.b bVarE = this.f9419e.e(strF);
        return (bVarE == null || !bVarE.s()) ? zG : bVarE.l(zG);
    }

    public void c2() {
        r4.a aVarL0 = L0();
        if (aVarL0 == null || !c6.a2.f1958a.t(aVarL0.getUrl())) {
            this.f9415a.n(w7.u.Z1);
            return;
        }
        c6.x1.f2137a.k(new c6.f(aVarL0.o()), x8.s1.g(), this.f9415a.a0());
        this.f9415a.n(w7.u.si);
    }

    public boolean d1(String str) {
        boolean zK = this.f9416b.n2().k();
        y9.b bVarE = this.f9419e.e(c6.a2.f1958a.f(str));
        return (bVarE == null || !bVarE.s()) ? zK : bVarE.n(zK);
    }

    public final void d2() {
        int i10 = this.f9424j;
        if (i10 > 0) {
            this.f9416b.N2(i10);
            this.f9416b.H2(this.f9425k);
            this.f9424j = 0;
            this.f9425k = 0;
        }
    }

    public boolean e1(String str) {
        y9.b bVarE = this.f9419e.e(c6.a2.f1958a.f(str));
        boolean zL = this.f9416b.n2().l();
        return (bVarE == null || !bVarE.s()) ? zL : bVarE.p(zL);
    }

    public final void e2() {
        if (this.f9416b.M1() == -999) {
            this.f9416b.s(this.f9418d.z().d(ga.c.k(this.f9415a.G().getString(w7.u.J0), this.f9416b.O())));
        }
    }

    public boolean f1(String str) {
        boolean zT = this.f9416b.n2().t();
        y9.b bVarE = this.f9419e.e(c6.a2.f1958a.f(str));
        return (bVarE == null || !bVarE.s()) ? zT : bVarE.B(zT);
    }

    public final void f2() {
        if (this.f9416b.o0() == -999) {
            this.f9416b.J(this.f9418d.z().d(ga.c.m(this.f9415a.G().getString(w7.u.J0), this.f9416b.L(null))));
        }
    }

    public final boolean g1(String str) {
        return str == null || str.isEmpty() || s9.d.l(this.f9415a.G(), str) || c6.a2.f1958a.j(str);
    }

    public final void g2(Intent intent) {
        final boolean z10 = !"mark.via".equals(R0(intent)) && x8.z.K(intent);
        E0(new Runnable() { // from class: mark.via.browser.y7
            @Override // java.lang.Runnable
            public final void run() {
                this.f9781c.f9426l = z10;
            }
        });
    }

    public void h0(String str, String str2) {
        i0(b5.c.x(str, str2));
    }

    public void h1(String str, final boolean z10, final int i10) {
        if (str == null) {
            ((autodispose2.n) N0().G(a7.a.c()).C(q6.b.b()).L(s8.b.c(P0()))).a(new u6.f() { // from class: mark.via.browser.m8
                @Override // u6.f
                public final void accept(Object obj) {
                    this.f9348c.z0((r4.g) obj, z10, i10);
                }
            }, new w7.a0());
        } else {
            t0();
            z0(new r4.h(str), z10, i10);
        }
    }

    public void h2() {
        this.f9432r = c6.b0.f1960a.g(this.f9416b.c1());
    }

    public final void i0(final String str) {
        x8.h.b(new Runnable() { // from class: mark.via.browser.t7
            @Override // java.lang.Runnable
            public final void run() {
                this.f9665c.f9417c.a(str);
            }
        });
    }

    public void i1(r4.g gVar, boolean z10, int i10) {
        t0();
        z0(gVar, z10, i10);
    }

    public void i2() {
        List<ka.f> listF = this.f9423i.f(true);
        if (listF.isEmpty()) {
            return;
        }
        for (ka.f fVar : listF) {
            if ((fVar.b() & 1) == 1) {
                this.f9423i.b(fVar.c());
            } else {
                fVar.h(fVar.b() & (-7));
                this.f9423i.a(fVar);
            }
        }
    }

    public void j0(String str) {
        i0(b5.c.y(str, true));
    }

    public void j1(String str, boolean z10) {
        h1(str, z10, M0() + 1);
    }

    public void j2() {
        r4.a aVarL0 = L0();
        if (aVarL0 != null) {
            String url = aVarL0.getUrl();
            if (!TextUtils.isEmpty(url)) {
                if (Build.VERSION.SDK_INT < 21) {
                    aVarL0.u("javascript:(function(){s=document.documentElement.outerHTML;a=window.open(\"\");a.document.write(\"<html><head><meta charset='utf-8'><meta name='viewport' content='width=device-width, initial-scale=1, user-scalable=no, minimal-ui'><title>Source</title><style type='text/css'>* {padding: 0; margin: 0} body{padding: 5px 10px;word-break:break-all;color: #666;line-height: 1.4;}</style></head><body></body></html>\");a.document.body.innerText=s})();");
                    this.f9415a.n(w7.u.si);
                    return;
                } else {
                    j1("view-source:" + url, true);
                    return;
                }
            }
        }
        this.f9415a.n(w7.u.Z1);
    }

    public void k0(String str) {
        i0(b5.c.y(str, false));
    }

    public void k1(String str, boolean z10) {
        h1(str, z10, T0());
    }

    public boolean l0(String str) {
        m9.b bVarA = this.f9421g.a(str);
        return bVarA != null && this.f9418d.s(l9.b.i(0, bVarA.g(), bVarA.e())) > 0;
    }

    public void l1(String str, boolean z10) {
        String strF = c6.a2.f1958a.f(str);
        y9.a aVarH = this.f9419e.h(strF);
        aVarH.S(true);
        aVarH.X(true);
        this.f9419e.g(strF, new y9.d(aVarH));
        h1(str, z10, M0() + 1);
        this.f9419e.j(strF);
    }

    public void m0(String str) {
        if (this.f9416b.n2().s() || (this.f9416b.X1() & 32) == 0) {
            return;
        }
        this.f9422h.e(str);
    }

    public void m1() {
        o1(false, false);
    }

    public void n0(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.f9431q.add(str);
    }

    public void n1(boolean z10) {
        o1(z10, false);
    }

    public final void o0() {
        int I = this.f9416b.I();
        r8.f.a().b(I == 0);
        if (20261125 <= I) {
            return;
        }
        u9.n.e().n(true);
        if (I < 20201231) {
            this.f9416b.w(false);
        }
        f2();
        e2();
        this.f9416b.J1(20261125);
    }

    public void o1(boolean z10, boolean z11) {
        t4.b bVarO;
        if (L0() == null) {
            return;
        }
        this.f9416b.y2();
        for (r4.a aVar : S0()) {
            if (aVar != null && (bVarO = aVar.o()) != null) {
                String url = bVarO.getUrl();
                if (z10) {
                    bVarO.setTag(c8.i.f2217e, null);
                }
                aVar.s();
                if (z11 && bVarO.getProgress() >= 100 && !TextUtils.isEmpty(url) && !c6.a2.f1958a.m(url)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("javascript:");
                    sb2.append((this.f9416b.e() && this.f9416b.C1()) ? "(function(){if(!document.getElementById('via_inject_css_night')){var css=document.createElement('style');css.id='via_inject_css_night';css.type='text/css';css.rel=\"stylesheet\";var textNode=document.createTextNode('html{background-color:#000!important}*{color:#999!important;box-shadow:none!important;background-color:transparent!important;border-color:#444!important;border-top-color:#444!important;border-bottom-color:#444!important;border-left-color:#444!important;border-right-color:#444!important}body{background-color:transparent!important}:after,:before{background-color:transparent!important;border-color:#444!important}a,a *{color:#409B9B!important;text-decoration:none!important}.link:hover,.link:hover *,[role=button]:hover *,[role=link]:hover,[role=link]:hover *,[role=menuitem]:hover,[role=menuitem]:hover *,a:hover,a:hover *,a:visited:hover,a:visited:hover *,div[onclick]:hover,span[onclick]:hover{color:#F0F0F0!important}a:visited,a:visited *{color:#607069!important}.selected,.selected *,[href=\"#\"],a.active,a.active *,a.highlight,a.highlight *{color:#DDD!important;font-weight:700!important}[class*=header],[class*=header] td,[class*=headline],[id*=header],[id*=headline],h1,h1 *,h2,h2 *,h3,h3 *,h4,h5,h6,strong{color:#DDD!important}[class*=alert],[class*=error],code,div[onclick],span[onclick]{color:#900!important}::-moz-selection{background-color:#377!important;color:#000!important}::selection{background-color:#377!important;color:#000!important}:focus{outline:0!important}div[role=navigation],div[style=\"display: block;\"]{background-color:rgba(0,0,0,.5)!important}table{background-color:rgba(40,30,30,.6)!important;border-radius:6px!important}table>tbody>tr:nth-child(even),table>tbody>tr>td:nth-child(even){background-color:rgba(0,0,0,.2)!important}#ghostery-purple-bubble,#translator-popup,.hovercard,.menu,.tooltip,.vbmenu_popup,[class*=dropdown],[class*=nav] ul,[class*=popup],[class=title],[id*=Menu],[id*=menu],[id*=nav] ul,a[id*=ghosteryfirefox],a[onclick][style*=display],div[role=dialog],div[role=menu],div[style*=\"position:\"][style*=\"left:\"][style*=visible],div[style*=\"z-index:\"][style*=\"left:\"][style*=visible],div[style*=\"-moz-user-select\"],embed,iframe,label [onclick],nav,nav ul,span[class*=script] div,ul[class*=menu],ul[style*=\"display:\"],ul[style*=\"visibility:\"] ul{background-color:rgba(5,5,5,.9)!important;border-radius:5px;box-shadow:1px 1px 5px #000!important}#footer,#header,footer,header{background-color:rgba(19,19,19,.9)!important;box-shadow:0 0 5px #000!important}body>#dialog,body>.xenOverlay{background-color:rgba(19,19,19,.96)!important;background-clip:padding-box!important;box-shadow:0 0 15px #000,inset 0 0 0 1px rgba(200,200,200,.5),inset 0 0 5px #111!important}[id*=lightbox],[id*=overlay],blockquote{background-color:rgba(35,35,35,.9)!important;border-radius:5px}.Message code,dl,pre{background-color:rgba(5,5,5,.5)!important}.install[onclick],[role=button],a.BigButton,a.TabLink,a.button,a.submit,button,input,select{-moz-appearance:none!important;-webkit-appearance:none!important;transition:border-color .3s!important;background-color:#060606!important;color:#BBB!important;box-shadow:0 0 2px rgba(0,0,0,.9)!important}a[class*=button]:not(:empty),a[href=\"javascript:;\"],a[id*=Button]:not(:empty),a[id*=button]:not(:empty),div[class*=button][onclick]{transition:border-color .3s!important;background-color:#060606!important;color:#BBB!important;border-color:#333!important;box-shadow:0 0 2px rgba(0,0,0,.9)!important}a[class*=button]:not(:empty):hover,a[href=\"javascript:;\"]:hover,a[id*=Button]:not(:empty):hover,a[id*=button]:hover,div[class*=button][onclick]:hover{background-color:#151515!important;color:#FFF!important}a.button *,a.submit *,button *,input *,select *{color:#BBB!important}[role=button]:hover,a.BigButton:hover,a.TabLink:hover,a.button:hover,a.submit:hover,button:hover,input:hover,input[type=button]:hover,select:hover{border-top-color:#555!important;border-bottom-color:#555!important;border-left-color:#555!important;border-right-color:#555!important}input:focus,select:focus{box-shadow:0 0 5px #077!important}input :hover *{color:#F0F0F0!important}button[disabled],button[disabled]:focus,button[disabled]:hover,input[disabled],input[disabled]:focus,input[disabled]:hover,select[disabled],select[disabled]:focus,select[disabled]:hover{opacity:.5!important;border-color:#333!important}input[type=checkbox]{border-radius:1px!important}input[type=radio],input[type=radio]:focus{border-radius:100%!important}input[type=checkbox],input[type=radio]{min-width:12px;min-height:12px}input[type=checkbox]:checked,input[type=radio]:checked{border-color:#077!important;box-shadow:0 0 5px #077!important}select{padding-right:15px!important;background-color:#060606!important;transition:border-color .3s,background-position .3s!important}.Active .TabLink,a.BigButton:active,a.TabLink:active,a.button:active,a.submit:active,a[class*=button]:not(:empty):active,button:active,input[type=button]:active,input[type=submit]:active{background-color:#292929!important;color:#FFF!important}textarea{-moz-appearance:none!important;-webkit-appearance:none!important;background-color:rgba(0,0,0,.3)!important;border-radius:3px!important;box-shadow:inset 0 0 8px #000!important;transition:border-color,background,.3s!important}textarea,textarea *{color:#C8C8C8!important}textarea:focus:hover,textarea:hover{border-color:#333!important}textarea:focus{background-color:rgba(0,0,0,.5)!important;border-color:#222!important}textarea:focus,textarea:focus>*{box-shadow:none!important}optgroup,option{-moz-appearance:none!important;-webkit-appearance:none!important;background-color:0 0!important;color:#666!important}optgroup{background-color:#222!important;color:#DDD!important}option:checked,option:focus,option:not([disabled]):hover{background-color:linear-gradient(#333,#292929)!important;color:#DDD!important}img{opacity:.7!important;transition:opacity .2s}#mpiv-popup,a:hover img,img:hover{opacity:1!important}.read-whole-mask .exp-mask,.se-head-tabcover,.wgt-exp-content .exp-img-mask{background-image:none!important}.s_card{background:0 0!important}');css.appendChild(textNode);(document.head||document.documentElement).appendChild(css);};})();" : "(function(){if(document.getElementById(\"via_inject_css_night\")){var e=document.getElementById(\"via_inject_css_night\");e.parentNode.removeChild(e)}})();");
                    bVarO.loadUrl(sb2.toString());
                }
            }
        }
        u9.n.e().w(false);
    }

    public void p0(final String str, int i10, boolean z10) {
        ka.f fVarJ;
        if (str == null || str.isEmpty() || (fVarJ = this.f9423i.j(str)) == null) {
            return;
        }
        if (i10 < 0) {
            this.f9434t.remove(Integer.valueOf(i10));
            x8.h.b(new Runnable() { // from class: mark.via.browser.o6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f9393c.f9423i.b(str);
                }
            });
            return;
        }
        int iB = fVarJ.b() & (-8);
        int i11 = iB | 2;
        if (!X1(fVarJ.f())) {
            i11 = iB | 3;
        }
        if (z10) {
            i11 |= 4;
        }
        fVarJ.h(i11);
        fVarJ.j(System.currentTimeMillis());
        this.f9423i.a(fVarJ);
        this.f9434t.put(Integer.valueOf(i10), str);
    }

    public void q0() {
        if (this.f9416b.t1() < 2) {
            ((autodispose2.m) r6.q.f(new Callable() { // from class: mark.via.browser.l6
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return p8.H(this.f9304c);
                }
            }).d(new u6.i() { // from class: mark.via.browser.m6
                @Override // u6.i
                public final boolean test(Object obj) {
                    return p8.b0((Integer) obj);
                }
            }).n(a7.a.c()).k(q6.b.b()).p(s8.b.c(P0()))).a(new u6.f() { // from class: mark.via.browser.n6
                @Override // u6.f
                public final void accept(Object obj) {
                    this.f9369c.f9416b.Q0(2);
                }
            }, new w7.e0());
        }
    }

    public void q1() {
        this.f9426l = false;
        this.f9416b.r2(u9.n.e().a());
        d2();
    }

    public void r0() {
        tc.a.a("Check for update", new Object[0]);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new sb.g(this.f9416b, this.f9417c));
        arrayList.add(new sb.q(this.f9416b, kd.c().f()));
        ((autodispose2.n) new sb.i(arrayList).b().G(a7.a.c()).L(s8.b.c(P0()))).b(new u6.f() { // from class: mark.via.browser.n8
            @Override // u6.f
            public final void accept(Object obj) {
                tc.a.a("Update result: %s", (sb.r) obj);
            }
        }, new w7.e0(), new u6.a() { // from class: mark.via.browser.o8
            @Override // u6.a
            public final void run() {
                tc.a.a("Update completed", new Object[0]);
            }
        });
    }

    public void r1(Intent intent) {
        ((autodispose2.m) b1(intent).n(a7.a.c()).k(q6.b.b()).p(s8.b.b(this.f9415a.i0(), Lifecycle.Event.ON_DESTROY))).a(new u6.f() { // from class: mark.via.browser.u6
            @Override // u6.f
            public final void accept(Object obj) {
                p8.u(this.f9686c, (r4.g) obj);
            }
        }, new w7.e0());
    }

    public void s0() {
        x8.f0.c(this.f9415a.G(), this.f9416b, null, this.f9423i, this.f9418d);
    }

    public void s1() {
        r4.a aVarL0 = L0();
        if (aVarL0 != null && !s9.d.l(this.f9415a.G(), aVarL0.getUrl())) {
            this.f9427m = aVarL0.getId();
        }
        if (G0(this.f9427m) == -1 || !b8.d.c().f(this.f9427m)) {
            this.f9415a.n(w7.u.f14018d9);
        } else {
            t1(6, null);
        }
    }

    public void t0() {
        this.f9436v = null;
        this.f9435u++;
    }

    public void t1(final int i10, final String str) {
        ((autodispose2.r) r6.q.g(Integer.valueOf(i10)).h(new u6.g() { // from class: mark.via.browser.c7
            @Override // u6.g
            public final Object apply(Object obj) {
                return p8.E(this.f9058a, str, (Integer) obj);
            }
        }).i(q6.b.b()).k(a7.a.c()).l(s8.b.c(P0()))).b(new u6.f() { // from class: mark.via.browser.d7
            @Override // u6.f
            public final void accept(Object obj) {
                p8.h(this.f9086c, i10, (String) obj);
            }
        });
    }

    public void u0() {
        if (G0(this.f9427m) != -1) {
            b8.d.c().b(this.f9427m);
            y1(M0());
        }
    }

    public void u1() {
        r4.a aVarL0 = L0();
        if (aVarL0 != null && p9.a.a().s(aVarL0.getUrl())) {
            r8 r8Var = this.f9415a;
            r8Var.L(r8Var.G().getString(w7.u.Pg));
            return;
        }
        if (aVarL0 != null && !s9.d.l(this.f9415a.G(), aVarL0.getUrl())) {
            this.f9427m = aVarL0.getId();
        }
        int iG0 = G0(this.f9427m);
        if (aVarL0 != null) {
            tc.a.a("log id: %d, resource id: %d, has resource: %s", Integer.valueOf(aVarL0.getId()), Integer.valueOf(aVarL0.o().getId()), Boolean.valueOf(b8.d.c().g(this.f9427m)));
        }
        if (iG0 != -1 && b8.d.c().g(this.f9427m)) {
            t1(10, null);
            return;
        }
        this.f9415a.L(this.f9415a.G().getString(w7.u.f14046f9) + this.f9415a.G().getString(w7.u.f14284wb));
    }

    public final boolean v0(String str) {
        return this.f9417c.b(str);
    }

    public void v1() {
        r4.a aVarL0 = L0();
        if (aVarL0 == null || !p9.a.a().s(aVarL0.getUrl())) {
            if (aVarL0 != null && b8.d.c().g(aVarL0.getId())) {
                List<l9.c> listD = b8.d.c().d(aVarL0.getId());
                if (!listD.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    for (l9.c cVar : listD) {
                        if (cVar != null && cVar.e()) {
                            arrayList.add(cVar.c());
                        }
                    }
                    this.f9415a.d0((String[]) arrayList.toArray(new String[0]), aVarL0.getTitle());
                    return;
                }
            }
            this.f9415a.d0(new String[0], null);
        }
    }

    public boolean w0(String str) {
        return v0(b5.c.y(str, true));
    }

    public void w1(String str) {
        t4.b bVarO;
        r4.a aVarL0 = L0();
        if (aVarL0 == null || (bVarO = aVarL0.o()) == null) {
            return;
        }
        bVarO.setTag(c8.i.f2217e, null);
        aVarL0.s();
        bVarO.reload();
    }

    public boolean x0(String str) {
        return v0(b5.c.y(str, false));
    }

    public void x1() {
        for (int iT0 = T0() - 1; iT0 >= 0; iT0--) {
            y1(iT0);
        }
    }

    public final void y0(r4.g gVar, boolean z10) {
        z0(gVar, z10, T0());
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0052  */
    public final void y1(int i10) {
        r4.a aVar;
        int iLastIndexOf;
        if (i10 < 0 || i10 >= T0() || (aVar = (r4.a) S0().get(i10)) == null) {
            return;
        }
        String url = aVar.getUrl();
        final int iC = s9.d.c(this.f9415a.G(), url);
        if (s9.d.k(iC)) {
            boolean z10 = true;
            boolean zG = false;
            if (iC == 1) {
                if (!u9.n.e().k() && !u9.n.e().j()) {
                    z10 = false;
                }
                zG = z10;
            } else if (iC == 2) {
                zG = u9.n.e().g();
            } else if (iC == 3) {
                zG = u9.n.e().i();
            } else if (iC == 5) {
                zG = u9.n.e().h();
            } else if (iC == 11) {
                zG = u9.n.e().g();
            }
            if (zG) {
                final String strTrim = (iC != 11 || (iLastIndexOf = url.lastIndexOf("?folder=")) <= 0) ? null : url.substring(iLastIndexOf + 8).trim();
                final WeakReference weakReference = new WeakReference(aVar);
                ((autodispose2.r) r6.q.f(new Callable() { // from class: mark.via.browser.s6
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.f9639c.I0(iC, strTrim);
                    }
                }).k(a7.a.c()).i(q6.b.b()).l(s8.b.c(P0()))).a(new u6.f() { // from class: mark.via.browser.t6
                    @Override // u6.f
                    public final void accept(Object obj) {
                        p8.l(weakReference, (String) obj);
                    }
                }, new w7.e0());
            }
        }
    }

    public final void z0(r4.g gVar, boolean z10, int i10) {
        this.f9415a.g(gVar, i10, z10);
    }

    public void z1() {
        y1(M0());
    }

    public void Z0() {
    }

    public void p1() {
    }
}
