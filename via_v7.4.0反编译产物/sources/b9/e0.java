package b9;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import mark.via.common.rx.AutoDisposeViewModel;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e0 extends AutoDisposeViewModel {

    /* renamed from: f, reason: collision with root package name */
    public final p9.o f1960f;

    /* renamed from: g, reason: collision with root package name */
    public final w9.l f1961g;

    /* renamed from: h, reason: collision with root package name */
    public final k6.e f1962h;

    /* renamed from: l, reason: collision with root package name */
    public long f1966l;

    /* renamed from: m, reason: collision with root package name */
    public int f1967m;

    /* renamed from: i, reason: collision with root package name */
    public String f1963i = null;

    /* renamed from: j, reason: collision with root package name */
    public final List f1964j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public final List f1965k = new ArrayList();

    /* renamed from: n, reason: collision with root package name */
    public p9.l f1968n = null;

    /* renamed from: o, reason: collision with root package name */
    public final androidx.lifecycle.l f1969o = new androidx.lifecycle.l();

    /* renamed from: p, reason: collision with root package name */
    public final androidx.lifecycle.l f1970p = new androidx.lifecycle.l();

    /* renamed from: q, reason: collision with root package name */
    public final androidx.lifecycle.l f1971q = new androidx.lifecycle.l();

    /* renamed from: r, reason: collision with root package name */
    public final androidx.lifecycle.l f1972r = new androidx.lifecycle.l();

    /* renamed from: s, reason: collision with root package name */
    public final androidx.lifecycle.l f1973s = new androidx.lifecycle.l();

    /* renamed from: t, reason: collision with root package name */
    public final androidx.lifecycle.l f1974t = new androidx.lifecycle.l();

    /* renamed from: u, reason: collision with root package name */
    public final androidx.lifecycle.l f1975u = new androidx.lifecycle.l();

    /* renamed from: v, reason: collision with root package name */
    public final k8.n f1976v = new k8.n();

    /* renamed from: w, reason: collision with root package name */
    public final androidx.lifecycle.l f1977w = new androidx.lifecycle.l();

    /* renamed from: x, reason: collision with root package name */
    public final androidx.lifecycle.l f1978x = new androidx.lifecycle.l();

    /* renamed from: y, reason: collision with root package name */
    public final androidx.lifecycle.l f1979y = new androidx.lifecycle.l();

    /* renamed from: z, reason: collision with root package name */
    public final k8.n f1980z = new k8.n();
    public final k8.n A = new k8.n();
    public final k8.n B = new k8.n();

    public e0(w9.l lVar, p9.o oVar, k6.e eVar) {
        this.f1960f = oVar;
        this.f1961g = lVar;
        this.f1962h = eVar;
    }

    public static /* synthetic */ void A(e0 e0Var, x5.a aVar) {
        e0Var.getClass();
        e0Var.f1968n = (p9.l) aVar.c();
    }

    public static /* synthetic */ Boolean B(e0 e0Var, p9.r rVar) {
        if (!e0Var.f1960f.a(rVar.c())) {
            return Boolean.FALSE;
        }
        rVar.k(null);
        rVar.l(System.currentTimeMillis());
        e0Var.f1960f.q(rVar.c(), rVar);
        return Boolean.TRUE;
    }

    public static /* synthetic */ void C(e0 e0Var, w.d dVar) {
        e0Var.getClass();
        Object obj = dVar.f13207a;
        if (obj != null) {
            e0Var.f1970p.m((p9.r) obj);
            e0Var.f1971q.m((List) dVar.f13208b);
            e0Var.f1972r.m(Boolean.FALSE);
        }
        e0Var.v0();
    }

    public static /* synthetic */ List D(e0 e0Var) {
        boolean z10 = e0Var.h0() == null;
        ArrayList arrayList = new ArrayList();
        List<p9.q> listG = e0Var.f1960f.g(z10 ? 1 : 2);
        boolean z11 = z10 && e0Var.q0();
        for (p9.q qVar : listG) {
            if (!z10 || qVar.g() != 2) {
                if (z10 || qVar.g() != 1) {
                    if (z11 != ((qVar.c() & 1) == 0)) {
                        arrayList.add(new c9.q(qVar, false));
                    }
                }
            }
        }
        if (!arrayList.isEmpty()) {
            p9.q qVar2 = new p9.q();
            qVar2.o("default");
            qVar2.p("Casual chat");
            arrayList.add(0, new c9.q(qVar2, true));
        }
        return arrayList;
    }

    public static /* synthetic */ void E(e0 e0Var, p9.r rVar, Boolean bool) {
        e0Var.getClass();
        if (bool.booleanValue()) {
            e0Var.u0(rVar.c(), true);
            e0Var.A.o();
        }
    }

    public static /* synthetic */ void F(e0 e0Var, boolean z10, int i10) {
        if (z10) {
            e0Var.getClass();
            pc.a.a("message completed", new Object[0]);
            e0Var.f1972r.m(Boolean.FALSE);
        }
        e0Var.f1973s.m(Integer.valueOf(i10));
    }

    public static /* synthetic */ void G(e0 e0Var, String str, Boolean bool) {
        List list;
        boolean z10;
        boolean z11;
        e0Var.getClass();
        if (!bool.booleanValue() || (list = (List) e0Var.f1971q.e()) == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        int size = arrayList.size() - 1;
        int i10 = size;
        while (true) {
            if (i10 < 0) {
                z11 = false;
                break;
            } else if (str.equals(((c9.a0) arrayList.get(i10)).getId())) {
                arrayList.remove(i10);
                z11 = i10 == size;
                z10 = true;
            } else {
                i10--;
            }
        }
        if (z10) {
            p9.r rVarH0 = e0Var.h0();
            if (z11 && rVarH0 != null) {
                if (arrayList.isEmpty()) {
                    rVarH0.k(null);
                } else {
                    CharSequence charSequenceI = g6.p.i(((c9.a0) arrayList.get(arrayList.size() - 1)).a(), 200);
                    rVarH0.k(g6.p.n(charSequenceI != null ? charSequenceI.toString() : null, " "));
                }
                e0Var.f1960f.q(rVarH0.c(), rVarH0);
                e0Var.A.o();
            }
            e0Var.f1971q.m(arrayList);
        }
    }

    public static /* synthetic */ Boolean l(e0 e0Var, String str, p9.r rVar) {
        e0Var.getClass();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new p9.e("Act as an Expert Title Summarizer. Generate a concise summary title (max 10 words, one sentence) in the same language as the input text. If the input contains proper terms (e.g., 'Java/Python'), prioritize the user's language context over term language. Avoid markdown formatting.", "system"));
        c9.a aVar = (c9.a) e0Var.f1975u.e();
        if (aVar != null) {
            arrayList.add(p9.e.l(aVar.getTitle()));
        }
        arrayList.add(p9.e.l(str));
        p9.g gVarB = e0Var.f1960f.B(arrayList, e0Var.f1961g.n0(), e0Var.U());
        if (!gVarB.i() || gVarB.d() == null || TextUtils.isEmpty(gVarB.d().b())) {
            rVar.j(g6.p.j(str, 20));
        } else {
            rVar.j(gVarB.d().b().trim());
        }
        return Boolean.valueOf(e0Var.f1960f.q(rVar.c(), rVar));
    }

    public static /* synthetic */ Boolean m(e0 e0Var, String str) {
        if (!e0Var.f1960f.j(str)) {
            return Boolean.FALSE;
        }
        int iIndexOf = e0Var.f1965k.indexOf(str);
        if (iIndexOf >= 0) {
            e0Var.f1965k.remove(iIndexOf);
            e0Var.f1964j.remove(iIndexOf);
        }
        return Boolean.TRUE;
    }

    public static /* synthetic */ String n(e0 e0Var) {
        p9.r rVarH0 = e0Var.h0();
        if (rVarH0 == null) {
            return null;
        }
        List<p9.n> listX = e0Var.f1960f.x(rVarH0.c());
        StringBuilder sb2 = new StringBuilder();
        boolean z10 = true;
        for (p9.n nVar : listX) {
            if (z10) {
                if (!"system".equals(nVar.g())) {
                    z10 = false;
                }
            }
            if ("user".equals(nVar.g())) {
                sb2.append("## ");
                sb2.append(nVar.b());
                sb2.append("\n\n");
            } else {
                if (!TextUtils.isEmpty(nVar.f())) {
                    sb2.append("> ");
                    sb2.append(nVar.f().replace("\n", "\n> "));
                }
                sb2.append(nVar.b());
                sb2.append("\n\n");
            }
        }
        if (sb2.length() <= 0) {
            return null;
        }
        return sb2.toString();
    }

    public static /* synthetic */ w.d o(e0 e0Var, String[] strArr) {
        p9.r rVarH0 = e0Var.h0();
        boolean z10 = false;
        if (rVarH0 != null) {
            int length = strArr.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                if (strArr[i10].equals(rVarH0.c())) {
                    z10 = true;
                    break;
                }
                i10++;
            }
        }
        return w.d.a(Boolean.valueOf(e0Var.f1960f.h(strArr)), Boolean.valueOf(z10));
    }

    public static /* synthetic */ void p(final e0 e0Var, p9.n nVar, WeakReference weakReference, int i10, c9.g gVar, final int i11, p9.g gVar2) {
        e0Var.getClass();
        if (gVar2.d() != null) {
            nVar.o(gVar2.d().c());
            nVar.k(gVar2.d().b());
            nVar.r(System.currentTimeMillis());
        }
        final boolean z10 = gVar2.i() || gVar2.h();
        boolean z11 = (!gVar2.i() && TextUtils.isEmpty(nVar.b()) && TextUtils.isEmpty(nVar.f())) ? false : true;
        if (z10 && !z11) {
            nVar.m(1);
            nVar.k(String.format(Locale.getDefault(), "\u2757%s", p9.s.e((Context) weakReference.get(), gVar2)));
        }
        if (e0Var.f1967m != i10) {
            return;
        }
        gVar.b(e0Var.W(nVar));
        if (z10 || System.currentTimeMillis() - e0Var.f1966l > 2000) {
            e0Var.f1960f.i(nVar.e(), nVar);
            e0Var.f1966l = System.currentTimeMillis();
        }
        if (z10) {
            p9.r rVarH0 = e0Var.h0();
            rVarH0.l(System.currentTimeMillis());
            CharSequence charSequenceI = g6.p.i(gVar.a(), 200);
            rVarH0.k(g6.p.n(charSequenceI == null ? null : charSequenceI.toString(), " "));
            e0Var.A.k(null);
            if (z11) {
                e0Var.H(nVar);
            }
            e0Var.f1960f.q(rVarH0.c(), rVarH0);
        }
        w6.b.b().d(new Runnable() { // from class: b9.r
            @Override // java.lang.Runnable
            public final void run() {
                e0.F(this.f2055e, z10, i11);
            }
        });
    }

    public static /* synthetic */ w.d q(e0 e0Var, String str) {
        p9.r rVarN = e0Var.f1960f.n(str);
        List listX = e0Var.f1960f.x(str);
        e0Var.f1963i = null;
        int size = listX.size();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i11 < size) {
                if (e0Var.f1963i == null && "system".equals(((p9.n) listX.get(i11)).g())) {
                    e0Var.f1963i = ((p9.n) listX.get(i11)).b();
                    i10 = i11;
                    break;
                }
                i11++;
            } else {
                break;
            }
        }
        e0Var.f1964j.clear();
        e0Var.f1965k.clear();
        int size2 = listX.size();
        int i12 = i10 + 1;
        int iMax = Math.max(i12, size2 - 18);
        ArrayList arrayList = new ArrayList();
        while (i12 < size2) {
            p9.n nVar = (p9.n) listX.get(i12);
            arrayList.add(e0Var.Z(nVar));
            if (i12 >= iMax && (nVar.d() & 1) == 0 && nVar.b() != null && !nVar.b().isEmpty()) {
                e0Var.f1964j.add(nVar.t());
                e0Var.f1965k.add(nVar.e());
            }
            i12++;
        }
        return w.d.a(rVarN, arrayList);
    }

    public static /* synthetic */ void v(e0 e0Var, int i10, Boolean bool) {
        e0Var.getClass();
        if (bool.booleanValue() && i10 == e0Var.f1967m) {
            androidx.lifecycle.l lVar = e0Var.f1970p;
            lVar.m((p9.r) lVar.e());
        }
    }

    public static /* synthetic */ void w(e0 e0Var, w.d dVar) {
        e0Var.getClass();
        if (((Boolean) dVar.f13207a).booleanValue()) {
            e0Var.w0();
            if (((Boolean) dVar.f13208b).booleanValue()) {
                e0Var.t0(null);
            }
        }
    }

    public static /* synthetic */ String y(e0 e0Var, String str) {
        p9.n nVarM;
        e0Var.getClass();
        if (str == null || str.isEmpty() || (nVarM = e0Var.f1960f.m(str)) == null) {
            return null;
        }
        return e0Var.X(nVarM);
    }

    public void A0(c9.a aVar) {
        this.f1975u.m(aVar);
    }

    public void B0(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.f1961g.e(str);
    }

    public void C0(String str) {
        List<c9.q> list = (List) this.f1978x.e();
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (c9.q qVar : list) {
            boolean z10 = str != null && str.equals(qVar.a().d());
            if (z10 != qVar.b()) {
                arrayList.add(new c9.q(qVar.a(), z10));
                i10++;
            } else {
                arrayList.add(qVar);
            }
        }
        if (i10 > 0) {
            this.f1978x.m(arrayList);
        }
    }

    public void D0(boolean z10) {
        this.f1977w.m(Boolean.valueOf(z10));
    }

    public void E0(String str) {
        this.B.m(str);
    }

    public void F0() {
        final p9.o oVar = this.f1960f;
        Objects.requireNonNull(oVar);
        ((autodispose2.m) x6.o.g(new Callable() { // from class: b9.d0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Boolean.valueOf(oVar.C());
            }
        }).e(new a7.h() { // from class: b9.i
            @Override // a7.h
            public final boolean test(Object obj) {
                return ((Boolean) obj).booleanValue();
            }
        }).n(g7.a.c()).k(w6.b.b()).p(u8.b.c(this))).a(new a7.e() { // from class: b9.j
            @Override // a7.e
            public final void accept(Object obj) {
                this.f2001e.f1972r.m(Boolean.FALSE);
            }
        }, new x7.g0());
    }

    public final void H(p9.n nVar) {
        if (nVar == null || (nVar.d() & 1) != 0 || TextUtils.isEmpty(nVar.b())) {
            return;
        }
        if (this.f1964j.size() > 18) {
            this.f1964j.remove(0);
            this.f1965k.remove(0);
        }
        this.f1964j.add(nVar.t());
        this.f1965k.add(nVar.e());
    }

    public final void I(c9.a0... a0VarArr) {
        if (a0VarArr == null || a0VarArr.length == 0) {
            return;
        }
        ArrayList arrayList = this.f1971q.e() == null ? new ArrayList() : new ArrayList((Collection) this.f1971q.e());
        for (c9.a0 a0Var : a0VarArr) {
            arrayList.add(a0Var);
        }
        this.f1971q.m(arrayList);
    }

    public void J(int i10) {
        this.f1979y.m(Integer.valueOf(i10));
    }

    public void K() {
        this.f1980z.o();
    }

    public void L(int i10) {
        this.f1976v.m(Integer.valueOf(i10));
    }

    public void M() {
        final p9.r rVarH0 = h0();
        if (rVarH0 == null) {
            return;
        }
        ((autodispose2.r) x6.o.g(new Callable() { // from class: b9.t
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return e0.B(this.f2077e, rVarH0);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this))).a(new a7.e() { // from class: b9.u
            @Override // a7.e
            public final void accept(Object obj) {
                e0.E(this.f2080e, rVarH0, (Boolean) obj);
            }
        }, new x7.g0());
    }

    public void N(final String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        ((autodispose2.r) x6.o.g(new Callable() { // from class: b9.n
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return e0.m(this.f2023e, str);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this))).a(new a7.e() { // from class: b9.o
            @Override // a7.e
            public final void accept(Object obj) {
                e0.G(this.f2028e, str, (Boolean) obj);
            }
        }, new x7.g0());
    }

    public void O(final String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        ((autodispose2.r) x6.o.g(new Callable() { // from class: b9.p
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return e0.o(this.f2035e, strArr);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this))).a(new a7.e() { // from class: b9.q
            @Override // a7.e
            public final void accept(Object obj) {
                e0.w(this.f2040e, (w.d) obj);
            }
        }, new x7.g0());
    }

    public LiveData P() {
        return this.f1976v;
    }

    public x6.f Q() {
        return x6.f.h(new Callable() { // from class: b9.v
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return e0.n(this.f2082e);
            }
        });
    }

    public LiveData R() {
        return this.f1975u;
    }

    public List S() {
        p9.l lVar = this.f1968n;
        if (lVar == null) {
            return null;
        }
        return lVar.f();
    }

    public LiveData T() {
        return this.f1979y;
    }

    public String U() {
        p9.l lVar = this.f1968n;
        if (lVar == null || lVar.f() == null) {
            return null;
        }
        String strU0 = this.f1961g.U0();
        return this.f1968n.f().contains(strU0) ? strU0 : this.f1968n.b();
    }

    public LiveData V() {
        return this.f1980z;
    }

    public final CharSequence W(p9.n nVar) {
        return this.f1962h.b(X(nVar));
    }

    public final String X(p9.n nVar) {
        if (nVar.f() == null || nVar.f().isEmpty()) {
            return g6.p.m(nVar.b());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(">");
        sb2.append(nVar.f().replace("\n", "\n>"));
        if (nVar.b() != null && !nVar.b().isEmpty()) {
            sb2.append("\n\n");
            sb2.append(nVar.b());
        }
        return sb2.toString();
    }

    public final String Y(String str) {
        p9.q qVarE0 = e0();
        if (qVarE0 == null || "default".equals(qVarE0.d())) {
            return str;
        }
        if (qVarE0.i()) {
            return qVarE0.a() + "\n" + str;
        }
        String strA = qVarE0.a();
        for (String str2 : qVarE0.f()) {
            strA = strA.replace(str2, g6.p.m(o0(str2, null, str)));
        }
        return strA;
    }

    public final c9.a0 Z(p9.n nVar) {
        return "user".equals(nVar.g()) ? new c9.d0(nVar.e(), this.f1962h.b(nVar.b())) : new c9.g(nVar.e(), W(nVar));
    }

    public x6.f a0(final String str) {
        return x6.f.h(new Callable() { // from class: b9.m
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return e0.y(this.f2018e, str);
            }
        });
    }

    public LiveData b0() {
        return this.f1972r;
    }

    public LiveData c0() {
        return this.f1971q;
    }

    public LiveData d0() {
        return this.f1974t;
    }

    public final p9.q e0() {
        List<c9.q> list = (List) this.f1978x.e();
        if (list != null && !list.isEmpty()) {
            for (c9.q qVar : list) {
                if (qVar.b()) {
                    return qVar.a();
                }
            }
        }
        return null;
    }

    public LiveData f0() {
        return this.f1978x;
    }

    public final String g0(c9.a aVar) {
        p9.q qVarE0 = e0();
        if (qVarE0 == null || "default".equals(qVarE0.d())) {
            return p9.s.h(aVar, null);
        }
        if (qVarE0.i()) {
            return qVarE0.a();
        }
        String strA = qVarE0.a();
        for (String str : qVarE0.f()) {
            if (str != null && !str.isEmpty()) {
                strA = strA.replace(str, g6.p.m(o0(str, aVar, null)));
            }
        }
        return strA;
    }

    public final p9.r h0() {
        return (p9.r) this.f1970p.e();
    }

    public LiveData i0() {
        return this.A;
    }

    public LiveData j0() {
        return this.f1970p;
    }

    public LiveData k0() {
        return this.f1969o;
    }

    public LiveData l0() {
        return this.B;
    }

    public LiveData m0() {
        return this.f1973s;
    }

    public LiveData n0() {
        return this.f1977w;
    }

    public final String o0(String str, c9.a aVar, String str2) {
        if ("{{webpage_url}}".equals(str)) {
            if (aVar == null) {
                return null;
            }
            return aVar.a();
        }
        if ("{{webpage_title}}".equals(str)) {
            if (aVar == null) {
                return null;
            }
            return aVar.getTitle();
        }
        if ("{{webpage_content}}".equals(str)) {
            if (aVar instanceof c9.z) {
                return ((c9.z) aVar).b();
            }
            return null;
        }
        if ("{{time}}".equals(str)) {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEEE (ZZZZ)", Locale.getDefault()).format(new Date());
        }
        if ("{{input}}".equals(str)) {
            return str2;
        }
        return null;
    }

    public final void p0(final String str) {
        final p9.r rVarH0 = h0();
        if (rVarH0 == null) {
            return;
        }
        final int i10 = this.f1967m;
        ((autodispose2.r) x6.o.g(new Callable() { // from class: b9.k
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return e0.l(this.f2006e, str, rVarH0);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this))).a(new a7.e() { // from class: b9.l
            @Override // a7.e
            public final void accept(Object obj) {
                e0.v(this.f2012e, i10, (Boolean) obj);
            }
        }, new x7.g0());
    }

    public boolean q0() {
        return this.f1975u.e() != null;
    }

    public boolean r0() {
        return this.f1972r.e() != null && this.f1972r.e() == Boolean.TRUE;
    }

    public void s0() {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: b9.y
            @Override // java.util.concurrent.Callable
            public final Object call() {
                e0 e0Var = this.f2092e;
                return x5.a.f(e0Var.f1960f.b(e0Var.f1961g.n0()));
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this))).a(new a7.e() { // from class: b9.z
            @Override // a7.e
            public final void accept(Object obj) {
                e0.A(this.f2095e, (x5.a) obj);
            }
        }, new x7.g0());
    }

    public void t0(String str) {
        u0(str, false);
    }

    public void u0(final String str, boolean z10) {
        p9.r rVarH0 = h0();
        if (!z10) {
            if (TextUtils.isEmpty(str)) {
                if (rVarH0 == null) {
                    return;
                }
            } else if (rVarH0 != null && str.equals(rVarH0.c())) {
                return;
            }
        }
        this.f1967m++;
        F0();
        if (str != null && !str.isEmpty()) {
            ((autodispose2.r) x6.o.g(new Callable() { // from class: b9.w
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return e0.q(this.f2085e, str);
                }
            }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this))).a(new a7.e() { // from class: b9.x
                @Override // a7.e
                public final void accept(Object obj) {
                    e0.C(this.f2088e, (w.d) obj);
                }
            }, new x7.g0());
            return;
        }
        this.f1963i = null;
        this.f1964j.clear();
        this.f1965k.clear();
        this.f1970p.m(null);
        this.f1971q.m(new ArrayList());
        this.f1972r.m(Boolean.FALSE);
        v0();
    }

    public void v0() {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: b9.h
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return e0.D(this.f1993e);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this))).a(new a7.e() { // from class: b9.s
            @Override // a7.e
            public final void accept(Object obj) {
                this.f2074e.f1978x.m((List) obj);
            }
        }, new x7.g0());
    }

    public void w0() {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: b9.a0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f1923e.f1960f.l();
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this))).a(new a7.e() { // from class: b9.b0
            @Override // a7.e
            public final void accept(Object obj) {
                this.f1943e.f1969o.m((List) obj);
            }
        }, new x7.g0());
    }

    public final p9.r x0(String str) {
        p9.r rVar = new p9.r();
        rVar.i(UUID.randomUUID().toString());
        rVar.g(System.currentTimeMillis());
        rVar.l(rVar.a());
        rVar.k(g6.p.n(g6.p.j(str, 200), " "));
        this.A.o();
        this.f1970p.m(rVar);
        c9.a aVar = (c9.a) this.f1975u.e();
        this.f1963i = g0(aVar);
        this.f1960f.w(rVar);
        this.f1960f.f(p9.n.s(this.f1963i, rVar.c()));
        p0(str);
        if (aVar instanceof c9.z) {
            this.f1960f.y(rVar.c(), ((c9.z) aVar).c());
        }
        return rVar;
    }

    public void y0(int i10) {
        this.f1974t.m(Integer.valueOf(i10));
    }

    public void z0(String str, final WeakReference weakReference) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.f1967m++;
        this.f1972r.m(Boolean.TRUE);
        p9.r rVarH0 = h0();
        if (rVarH0 == null) {
            rVarH0 = x0(str);
            v0();
        } else {
            str = Y(str);
        }
        ArrayList arrayList = new ArrayList();
        String str2 = this.f1963i;
        if (str2 != null && !str2.isEmpty()) {
            arrayList.add(new p9.e(this.f1963i, "system"));
        }
        p9.n nVarU = p9.n.u(str, rVarH0.c());
        this.f1960f.f(nVarU);
        H(nVarU);
        arrayList.addAll(this.f1964j);
        final p9.n nVarA = p9.n.a("", rVarH0.c());
        final c9.g gVar = (c9.g) Z(nVarA);
        I(Z(nVarU), gVar);
        final int size = ((List) this.f1971q.e()).size() - 1;
        String strN0 = this.f1961g.n0();
        String strU = U();
        this.f1960f.f(nVarA);
        final int i10 = this.f1967m;
        pc.a.a("send message", new Object[0]);
        this.f1960f.D(arrayList, strN0, strU, new p9.h() { // from class: b9.c0
            @Override // p9.h
            public final void a(p9.g gVar2) {
                e0.p(this.f1947a, nVarA, weakReference, i10, gVar, size, gVar2);
            }
        });
    }
}
