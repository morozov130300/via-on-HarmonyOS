package z8;

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

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e0 extends AutoDisposeViewModel {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n9.o f15389f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u9.l f15390g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e6.e f15391h;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f15395l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f15396m;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f15392i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f15393j = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List f15394k = new ArrayList();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public n9.l f15397n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final androidx.lifecycle.n f15398o = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final androidx.lifecycle.n f15399p = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final androidx.lifecycle.n f15400q = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final androidx.lifecycle.n f15401r = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final androidx.lifecycle.n f15402s = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final androidx.lifecycle.n f15403t = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final androidx.lifecycle.n f15404u = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final i8.n f15405v = new i8.n();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final androidx.lifecycle.n f15406w = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final androidx.lifecycle.n f15407x = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final androidx.lifecycle.n f15408y = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final i8.n f15409z = new i8.n();
    public final i8.n A = new i8.n();
    public final i8.n B = new i8.n();

    public e0(u9.l lVar, n9.o oVar, e6.e eVar) {
        this.f15389f = oVar;
        this.f15390g = lVar;
        this.f15391h = eVar;
    }

    public static /* synthetic */ void A(e0 e0Var, s5.a aVar) {
        e0Var.getClass();
        e0Var.f15397n = (n9.l) aVar.c();
    }

    public static /* synthetic */ Boolean B(e0 e0Var, n9.r rVar) {
        if (!e0Var.f15389f.f(rVar.c())) {
            return Boolean.FALSE;
        }
        rVar.k(null);
        rVar.l(System.currentTimeMillis());
        e0Var.f15389f.o(rVar.c(), rVar);
        return Boolean.TRUE;
    }

    public static /* synthetic */ void C(e0 e0Var, x.d dVar) {
        e0Var.getClass();
        Object obj = dVar.f14455a;
        if (obj != null) {
            e0Var.f15399p.m((n9.r) obj);
            e0Var.f15400q.m((List) dVar.f14456b);
            e0Var.f15401r.m(Boolean.FALSE);
        }
        e0Var.v0();
    }

    public static /* synthetic */ List D(e0 e0Var) {
        boolean z10 = e0Var.h0() == null;
        ArrayList arrayList = new ArrayList();
        List<n9.q> listK = e0Var.f15389f.k(z10 ? 1 : 2);
        boolean z11 = z10 && e0Var.q0();
        for (n9.q qVar : listK) {
            if (!z10 || qVar.g() != 2) {
                if (z10 || qVar.g() != 1) {
                    if (z11 != ((qVar.c() & 1) == 0)) {
                        arrayList.add(new a9.q(qVar, false));
                    }
                }
            }
        }
        if (!arrayList.isEmpty()) {
            n9.q qVar2 = new n9.q();
            qVar2.o("default");
            qVar2.p("Casual chat");
            arrayList.add(0, new a9.q(qVar2, true));
        }
        return arrayList;
    }

    public static /* synthetic */ void E(e0 e0Var, n9.r rVar, Boolean bool) {
        e0Var.getClass();
        if (bool.booleanValue()) {
            e0Var.u0(rVar.c(), true);
            e0Var.A.o();
        }
    }

    public static /* synthetic */ void F(e0 e0Var, boolean z10, int i10) {
        if (z10) {
            e0Var.getClass();
            tc.a.a("message completed", new Object[0]);
            e0Var.f15401r.m(Boolean.FALSE);
        }
        e0Var.f15402s.m(Integer.valueOf(i10));
    }

    public static /* synthetic */ void G(e0 e0Var, String str, Boolean bool) {
        List list;
        boolean z10;
        boolean z11;
        e0Var.getClass();
        if (!bool.booleanValue() || (list = (List) e0Var.f15400q.e()) == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        int size = arrayList.size() - 1;
        int i10 = size;
        while (true) {
            z10 = false;
            if (i10 < 0) {
                z11 = false;
                break;
            } else {
                if (str.equals(((a9.a0) arrayList.get(i10)).getId())) {
                    arrayList.remove(i10);
                    z11 = i10 == size;
                    z10 = true;
                    break;
                }
                i10--;
            }
        }
        if (z10) {
            n9.r rVarH0 = e0Var.h0();
            if (z11 && rVarH0 != null) {
                if (arrayList.isEmpty()) {
                    rVarH0.k(null);
                } else {
                    CharSequence charSequenceI = com.tuyafeng.support.utils.p.i(((a9.a0) arrayList.get(arrayList.size() - 1)).a(), 200);
                    rVarH0.k(com.tuyafeng.support.utils.p.n(charSequenceI != null ? charSequenceI.toString() : null, " "));
                }
                e0Var.f15389f.o(rVarH0.c(), rVarH0);
                e0Var.A.o();
            }
            e0Var.f15400q.m(arrayList);
        }
    }

    public static /* synthetic */ Boolean l(e0 e0Var, String str, n9.r rVar) {
        e0Var.getClass();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new n9.e("Act as an Expert Title Summarizer. Generate a concise summary title (max 10 words, one sentence) in the same language as the input text. If the input contains proper terms (e.g., 'Java/Python'), prioritize the user's language context over term language. Avoid markdown formatting.", "system"));
        a9.a aVar = (a9.a) e0Var.f15404u.e();
        if (aVar != null) {
            arrayList.add(n9.e.l(aVar.getTitle()));
        }
        arrayList.add(n9.e.l(str));
        n9.g gVarB = e0Var.f15389f.B(arrayList, e0Var.f15390g.q0(), e0Var.U());
        if (!gVarB.i() || gVarB.d() == null || TextUtils.isEmpty(gVarB.d().b())) {
            rVar.j(com.tuyafeng.support.utils.p.j(str, 20));
        } else {
            rVar.j(gVarB.d().b().trim());
        }
        return Boolean.valueOf(e0Var.f15389f.o(rVar.c(), rVar));
    }

    public static /* synthetic */ Boolean m(e0 e0Var, String str) {
        if (!e0Var.f15389f.m(str)) {
            return Boolean.FALSE;
        }
        int iIndexOf = e0Var.f15394k.indexOf(str);
        if (iIndexOf >= 0) {
            e0Var.f15394k.remove(iIndexOf);
            e0Var.f15393j.remove(iIndexOf);
        }
        return Boolean.TRUE;
    }

    public static /* synthetic */ String n(e0 e0Var) {
        n9.r rVarH0 = e0Var.h0();
        if (rVarH0 == null) {
            return null;
        }
        List<n9.n> listX = e0Var.f15389f.x(rVarH0.c());
        StringBuilder sb2 = new StringBuilder();
        boolean z10 = true;
        for (n9.n nVar : listX) {
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

    public static /* synthetic */ x.d o(e0 e0Var, String[] strArr) {
        n9.r rVarH0 = e0Var.h0();
        boolean z10 = false;
        if (rVarH0 != null) {
            for (String str : strArr) {
                if (str.equals(rVarH0.c())) {
                    z10 = true;
                    break;
                }
            }
        }
        return x.d.a(Boolean.valueOf(e0Var.f15389f.l(strArr)), Boolean.valueOf(z10));
    }

    public static /* synthetic */ void p(final e0 e0Var, n9.n nVar, WeakReference weakReference, int i10, a9.g gVar, final int i11, n9.g gVar2) {
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
            nVar.k(String.format(Locale.getDefault(), "❗%s", n9.s.e((Context) weakReference.get(), gVar2)));
        }
        if (e0Var.f15396m != i10) {
            return;
        }
        gVar.b(e0Var.W(nVar));
        if (z10 || System.currentTimeMillis() - e0Var.f15395l > 2000) {
            e0Var.f15389f.g(nVar.e(), nVar);
            e0Var.f15395l = System.currentTimeMillis();
        }
        if (z10) {
            n9.r rVarH0 = e0Var.h0();
            rVarH0.l(System.currentTimeMillis());
            CharSequence charSequenceI = com.tuyafeng.support.utils.p.i(gVar.a(), 200);
            rVarH0.k(com.tuyafeng.support.utils.p.n(charSequenceI == null ? null : charSequenceI.toString(), " "));
            e0Var.A.k(null);
            if (z11) {
                e0Var.H(nVar);
            }
            e0Var.f15389f.o(rVarH0.c(), rVarH0);
        }
        q6.b.b().d(new Runnable() { // from class: z8.k
            @Override // java.lang.Runnable
            public final void run() {
                e0.F(this.f15435c, z10, i11);
            }
        });
    }

    public static /* synthetic */ x.d q(e0 e0Var, String str) {
        n9.r rVarS = e0Var.f15389f.s(str);
        List listX = e0Var.f15389f.x(str);
        e0Var.f15392i = null;
        int size = listX.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            if (e0Var.f15392i == null && "system".equals(((n9.n) listX.get(i11)).g())) {
                e0Var.f15392i = ((n9.n) listX.get(i11)).b();
                i10 = i11;
                break;
            }
        }
        e0Var.f15393j.clear();
        e0Var.f15394k.clear();
        int size2 = listX.size();
        int i12 = i10 + 1;
        int iMax = Math.max(i12, size2 - 18);
        ArrayList arrayList = new ArrayList();
        while (i12 < size2) {
            n9.n nVar = (n9.n) listX.get(i12);
            arrayList.add(e0Var.Z(nVar));
            if (i12 >= iMax && (nVar.d() & 1) == 0 && nVar.b() != null && !nVar.b().isEmpty()) {
                e0Var.f15393j.add(nVar.t());
                e0Var.f15394k.add(nVar.e());
            }
            i12++;
        }
        return x.d.a(rVarS, arrayList);
    }

    public static /* synthetic */ void v(e0 e0Var, int i10, Boolean bool) {
        e0Var.getClass();
        if (bool.booleanValue() && i10 == e0Var.f15396m) {
            androidx.lifecycle.n nVar = e0Var.f15399p;
            nVar.m((n9.r) nVar.e());
        }
    }

    public static /* synthetic */ void w(e0 e0Var, x.d dVar) {
        e0Var.getClass();
        if (((Boolean) dVar.f14455a).booleanValue()) {
            e0Var.w0();
            if (((Boolean) dVar.f14456b).booleanValue()) {
                e0Var.t0(null);
            }
        }
    }

    public static /* synthetic */ String y(e0 e0Var, String str) {
        n9.n nVarQ;
        e0Var.getClass();
        if (str == null || str.isEmpty() || (nVarQ = e0Var.f15389f.q(str)) == null) {
            return null;
        }
        return e0Var.X(nVarQ);
    }

    public void A0(a9.a aVar) {
        this.f15404u.m(aVar);
    }

    public void B0(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.f15390g.f(str);
    }

    public void C0(String str) {
        List<a9.q> list = (List) this.f15407x.e();
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (a9.q qVar : list) {
            boolean z10 = str != null && str.equals(qVar.a().d());
            if (z10 != qVar.b()) {
                arrayList.add(new a9.q(qVar.a(), z10));
                i10++;
            } else {
                arrayList.add(qVar);
            }
        }
        if (i10 > 0) {
            this.f15407x.m(arrayList);
        }
    }

    public void D0(boolean z10) {
        this.f15406w.m(Boolean.valueOf(z10));
    }

    public void E0(String str) {
        this.B.m(str);
    }

    public void F0() {
        final n9.o oVar = this.f15389f;
        Objects.requireNonNull(oVar);
        ((autodispose2.m) r6.q.f(new Callable() { // from class: z8.d0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Boolean.valueOf(oVar.C());
            }
        }).d(new u6.i() { // from class: z8.i
            @Override // u6.i
            public final boolean test(Object obj) {
                return ((Boolean) obj).booleanValue();
            }
        }).n(a7.a.c()).k(q6.b.b()).p(s8.b.c(this))).a(new u6.f() { // from class: z8.j
            @Override // u6.f
            public final void accept(Object obj) {
                this.f15430c.f15401r.m(Boolean.FALSE);
            }
        }, new w7.e0());
    }

    public final void H(n9.n nVar) {
        if (nVar == null || (nVar.d() & 1) != 0 || TextUtils.isEmpty(nVar.b())) {
            return;
        }
        if (this.f15393j.size() > 18) {
            this.f15393j.remove(0);
            this.f15394k.remove(0);
        }
        this.f15393j.add(nVar.t());
        this.f15394k.add(nVar.e());
    }

    public final void I(a9.a0... a0VarArr) {
        if (a0VarArr == null || a0VarArr.length == 0) {
            return;
        }
        ArrayList arrayList = this.f15400q.e() == null ? new ArrayList() : new ArrayList((Collection) this.f15400q.e());
        for (a9.a0 a0Var : a0VarArr) {
            arrayList.add(a0Var);
        }
        this.f15400q.m(arrayList);
    }

    public void J(int i10) {
        this.f15408y.m(Integer.valueOf(i10));
    }

    public void K() {
        this.f15409z.o();
    }

    public void L(int i10) {
        this.f15405v.m(Integer.valueOf(i10));
    }

    public void M() {
        final n9.r rVarH0 = h0();
        if (rVarH0 == null) {
            return;
        }
        ((autodispose2.r) r6.q.f(new Callable() { // from class: z8.t
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return e0.B(this.f15506c, rVarH0);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.c(this))).a(new u6.f() { // from class: z8.u
            @Override // u6.f
            public final void accept(Object obj) {
                e0.E(this.f15509c, rVarH0, (Boolean) obj);
            }
        }, new w7.e0());
    }

    public void N(final String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        ((autodispose2.r) r6.q.f(new Callable() { // from class: z8.o
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return e0.m(this.f15458c, str);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.c(this))).a(new u6.f() { // from class: z8.p
            @Override // u6.f
            public final void accept(Object obj) {
                e0.G(this.f15465c, str, (Boolean) obj);
            }
        }, new w7.e0());
    }

    public void O(final String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        ((autodispose2.r) r6.q.f(new Callable() { // from class: z8.q
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return e0.o(this.f15470c, strArr);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.c(this))).a(new u6.f() { // from class: z8.r
            @Override // u6.f
            public final void accept(Object obj) {
                e0.w(this.f15486c, (x.d) obj);
            }
        }, new w7.e0());
    }

    public LiveData P() {
        return this.f15405v;
    }

    public r6.f Q() {
        return r6.f.h(new Callable() { // from class: z8.v
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return e0.n(this.f15511c);
            }
        });
    }

    public LiveData R() {
        return this.f15404u;
    }

    public List S() {
        n9.l lVar = this.f15397n;
        if (lVar == null) {
            return null;
        }
        return lVar.f();
    }

    public LiveData T() {
        return this.f15408y;
    }

    public String U() {
        n9.l lVar = this.f15397n;
        if (lVar == null || lVar.f() == null) {
            return null;
        }
        String strW0 = this.f15390g.W0();
        return this.f15397n.f().contains(strW0) ? strW0 : this.f15397n.b();
    }

    public LiveData V() {
        return this.f15409z;
    }

    public final CharSequence W(n9.n nVar) {
        return this.f15391h.b(X(nVar));
    }

    public final String X(n9.n nVar) {
        if (nVar.f() == null || nVar.f().isEmpty()) {
            return com.tuyafeng.support.utils.p.m(nVar.b());
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
        n9.q qVarE0 = e0();
        if (qVarE0 == null || "default".equals(qVarE0.d())) {
            return str;
        }
        if (qVarE0.i()) {
            return qVarE0.a() + "\n" + str;
        }
        String strA = qVarE0.a();
        for (String str2 : qVarE0.f()) {
            strA = strA.replace(str2, com.tuyafeng.support.utils.p.m(o0(str2, null, str)));
        }
        return strA;
    }

    public final a9.a0 Z(n9.n nVar) {
        return "user".equals(nVar.g()) ? new a9.d0(nVar.e(), this.f15391h.b(nVar.b())) : new a9.g(nVar.e(), W(nVar));
    }

    public r6.f a0(final String str) {
        return r6.f.h(new Callable() { // from class: z8.n
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return e0.y(this.f15453c, str);
            }
        });
    }

    public LiveData b0() {
        return this.f15401r;
    }

    public LiveData c0() {
        return this.f15400q;
    }

    public LiveData d0() {
        return this.f15403t;
    }

    public final n9.q e0() {
        List<a9.q> list = (List) this.f15407x.e();
        if (list != null && !list.isEmpty()) {
            for (a9.q qVar : list) {
                if (qVar.b()) {
                    return qVar.a();
                }
            }
        }
        return null;
    }

    public LiveData f0() {
        return this.f15407x;
    }

    public final String g0(a9.a aVar) {
        n9.q qVarE0 = e0();
        if (qVarE0 == null || "default".equals(qVarE0.d())) {
            return n9.s.h(aVar, null);
        }
        if (qVarE0.i()) {
            return qVarE0.a();
        }
        String strA = qVarE0.a();
        for (String str : qVarE0.f()) {
            if (str != null && !str.isEmpty()) {
                strA = strA.replace(str, com.tuyafeng.support.utils.p.m(o0(str, aVar, null)));
            }
        }
        return strA;
    }

    public final n9.r h0() {
        return (n9.r) this.f15399p.e();
    }

    public LiveData i0() {
        return this.A;
    }

    public LiveData j0() {
        return this.f15399p;
    }

    public LiveData k0() {
        return this.f15398o;
    }

    public LiveData l0() {
        return this.B;
    }

    public LiveData m0() {
        return this.f15402s;
    }

    public LiveData n0() {
        return this.f15406w;
    }

    public final String o0(String str, a9.a aVar, String str2) {
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
            if (aVar instanceof a9.z) {
                return ((a9.z) aVar).b();
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
        final n9.r rVarH0 = h0();
        if (rVarH0 == null) {
            return;
        }
        final int i10 = this.f15396m;
        ((autodispose2.r) r6.q.f(new Callable() { // from class: z8.l
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return e0.l(this.f15441c, str, rVarH0);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.c(this))).a(new u6.f() { // from class: z8.m
            @Override // u6.f
            public final void accept(Object obj) {
                e0.v(this.f15448c, i10, (Boolean) obj);
            }
        }, new w7.e0());
    }

    public boolean q0() {
        return this.f15404u.e() != null;
    }

    public boolean r0() {
        return this.f15401r.e() != null && this.f15401r.e() == Boolean.TRUE;
    }

    public void s0() {
        ((autodispose2.r) r6.q.f(new Callable() { // from class: z8.y
            @Override // java.util.concurrent.Callable
            public final Object call() {
                e0 e0Var = this.f15521c;
                return s5.a.f(e0Var.f15389f.h(e0Var.f15390g.q0()));
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.c(this))).a(new u6.f() { // from class: z8.z
            @Override // u6.f
            public final void accept(Object obj) {
                e0.A(this.f15524c, (s5.a) obj);
            }
        }, new w7.e0());
    }

    public void t0(String str) {
        u0(str, false);
    }

    public void u0(final String str, boolean z10) {
        n9.r rVarH0 = h0();
        if (!z10) {
            if (TextUtils.isEmpty(str)) {
                if (rVarH0 == null) {
                    return;
                }
            } else if (rVarH0 != null && str.equals(rVarH0.c())) {
                return;
            }
        }
        this.f15396m++;
        F0();
        if (str != null && !str.isEmpty()) {
            ((autodispose2.r) r6.q.f(new Callable() { // from class: z8.w
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return e0.q(this.f15514c, str);
                }
            }).k(a7.a.c()).i(q6.b.b()).l(s8.b.c(this))).a(new u6.f() { // from class: z8.x
                @Override // u6.f
                public final void accept(Object obj) {
                    e0.C(this.f15517c, (x.d) obj);
                }
            }, new w7.e0());
            return;
        }
        this.f15392i = null;
        this.f15393j.clear();
        this.f15394k.clear();
        this.f15399p.m(null);
        this.f15400q.m(new ArrayList());
        this.f15401r.m(Boolean.FALSE);
        v0();
    }

    public void v0() {
        ((autodispose2.r) r6.q.f(new Callable() { // from class: z8.h
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return e0.D(this.f15422c);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.c(this))).a(new u6.f() { // from class: z8.s
            @Override // u6.f
            public final void accept(Object obj) {
                this.f15503c.f15407x.m((List) obj);
            }
        }, new w7.e0());
    }

    public void w0() {
        ((autodispose2.r) r6.q.f(new Callable() { // from class: z8.a0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f15353c.f15389f.p();
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.c(this))).a(new u6.f() { // from class: z8.b0
            @Override // u6.f
            public final void accept(Object obj) {
                this.f15372c.f15398o.m((List) obj);
            }
        }, new w7.e0());
    }

    public final n9.r x0(String str) {
        n9.r rVar = new n9.r();
        rVar.i(UUID.randomUUID().toString());
        rVar.g(System.currentTimeMillis());
        rVar.l(rVar.a());
        rVar.k(com.tuyafeng.support.utils.p.n(com.tuyafeng.support.utils.p.j(str, 200), " "));
        this.A.o();
        this.f15399p.m(rVar);
        a9.a aVar = (a9.a) this.f15404u.e();
        this.f15392i = g0(aVar);
        this.f15389f.j(rVar);
        this.f15389f.a(n9.n.s(this.f15392i, rVar.c()));
        p0(str);
        if (aVar instanceof a9.z) {
            this.f15389f.y(rVar.c(), ((a9.z) aVar).c());
        }
        return rVar;
    }

    public void y0(int i10) {
        this.f15403t.m(Integer.valueOf(i10));
    }

    public void z0(String str, final WeakReference weakReference) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.f15396m++;
        this.f15401r.m(Boolean.TRUE);
        n9.r rVarH0 = h0();
        if (rVarH0 == null) {
            rVarH0 = x0(str);
            v0();
        } else {
            str = Y(str);
        }
        ArrayList arrayList = new ArrayList();
        String str2 = this.f15392i;
        if (str2 != null && !str2.isEmpty()) {
            arrayList.add(new n9.e(this.f15392i, "system"));
        }
        n9.n nVarU = n9.n.u(str, rVarH0.c());
        this.f15389f.a(nVarU);
        H(nVarU);
        arrayList.addAll(this.f15393j);
        final n9.n nVarA = n9.n.a("", rVarH0.c());
        final a9.g gVar = (a9.g) Z(nVarA);
        I(Z(nVarU), gVar);
        final int size = ((List) this.f15400q.e()).size() - 1;
        String strQ0 = this.f15390g.q0();
        String strU = U();
        this.f15389f.a(nVarA);
        final int i10 = this.f15396m;
        tc.a.a("send message", new Object[0]);
        this.f15389f.D(arrayList, strQ0, strU, new n9.h() { // from class: z8.c0
            @Override // n9.h
            public final void a(n9.g gVar2) {
                e0.p(this.f15376a, nVarA, weakReference, i10, gVar, size, gVar2);
            }
        });
    }
}
