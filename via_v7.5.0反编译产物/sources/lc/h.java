package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import oc.v;
import oc.z;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class h implements qc.h {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Set f7672p = new LinkedHashSet(Arrays.asList(oc.b.class, oc.k.class, oc.i.class, oc.l.class, z.class, oc.r.class, oc.o.class));

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Map f7673q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f7674a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f7677d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f7681h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List f7682i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final pc.c f7683j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List f7684k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final g f7685l;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7675b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7676c = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f7678e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f7679f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f7680g = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map f7686m = new LinkedHashMap();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List f7687n = new ArrayList();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Set f7688o = new LinkedHashSet();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a implements qc.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final qc.d f7689a;

        public a(qc.d dVar) {
            this.f7689a = dVar;
        }

        @Override // qc.g
        public qc.d a() {
            return this.f7689a;
        }

        @Override // qc.g
        public CharSequence b() {
            qc.d dVar = this.f7689a;
            if (!(dVar instanceof q)) {
                return null;
            }
            CharSequence charSequenceI = ((q) dVar).i();
            if (charSequenceI.length() == 0) {
                return null;
            }
            return charSequenceI;
        }
    }

    static {
        HashMap map = new HashMap();
        map.put(oc.b.class, new c.a());
        map.put(oc.k.class, new j.a());
        map.put(oc.i.class, new i.a());
        map.put(oc.l.class, new k.b());
        map.put(z.class, new s.a());
        map.put(oc.r.class, new o.a());
        map.put(oc.o.class, new l.a());
        f7673q = Collections.unmodifiableMap(map);
    }

    public h(List list, pc.c cVar, List list2) {
        this.f7682i = list;
        this.f7683j = cVar;
        this.f7684k = list2;
        g gVar = new g();
        this.f7685l = gVar;
        f(gVar);
    }

    public static List k(List list, Set set) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(f7673q.get((Class) it.next()));
        }
        return arrayList;
    }

    public static Set r() {
        return f7672p;
    }

    @Override // qc.h
    public boolean a() {
        return this.f7681h;
    }

    @Override // qc.h
    public int b() {
        return this.f7680g;
    }

    @Override // qc.h
    public int c() {
        return this.f7678e;
    }

    @Override // qc.h
    public qc.d d() {
        List list = this.f7687n;
        return (qc.d) list.get(list.size() - 1);
    }

    @Override // qc.h
    public int e() {
        return this.f7676c;
    }

    public final void f(qc.d dVar) {
        this.f7687n.add(dVar);
        this.f7688o.add(dVar);
    }

    public final qc.d g(qc.d dVar) {
        while (!d().a(dVar.f())) {
            m(d());
        }
        d().f().b(dVar.f());
        f(dVar);
        return dVar;
    }

    @Override // qc.h
    public int getIndex() {
        return this.f7675b;
    }

    @Override // qc.h
    public CharSequence getLine() {
        return this.f7674a;
    }

    public final void h(q qVar) {
        for (oc.q qVar2 : qVar.j()) {
            qVar.f().i(qVar2);
            String strN = qVar2.n();
            if (!this.f7686m.containsKey(strN)) {
                this.f7686m.put(strN, qVar2);
            }
        }
    }

    public final void i() {
        CharSequence charSequenceSubSequence;
        if (this.f7677d) {
            int i10 = this.f7675b + 1;
            CharSequence charSequence = this.f7674a;
            CharSequence charSequenceSubSequence2 = charSequence.subSequence(i10, charSequence.length());
            int iA = nc.d.a(this.f7676c);
            StringBuilder sb2 = new StringBuilder(charSequenceSubSequence2.length() + iA);
            for (int i11 = 0; i11 < iA; i11++) {
                sb2.append(' ');
            }
            sb2.append(charSequenceSubSequence2);
            charSequenceSubSequence = sb2.toString();
        } else {
            CharSequence charSequence2 = this.f7674a;
            charSequenceSubSequence = charSequence2.subSequence(this.f7675b, charSequence2.length());
        }
        d().h(charSequenceSubSequence);
    }

    public final void j() {
        if (this.f7674a.charAt(this.f7675b) != '\t') {
            this.f7675b++;
            this.f7676c++;
        } else {
            this.f7675b++;
            int i10 = this.f7676c;
            this.f7676c = i10 + nc.d.a(i10);
        }
    }

    public final void l() {
        List list = this.f7687n;
        list.remove(list.size() - 1);
    }

    public final void m(qc.d dVar) {
        if (d() == dVar) {
            l();
        }
        if (dVar instanceof q) {
            h((q) dVar);
        }
        dVar.c();
    }

    public final oc.g n() {
        o(this.f7687n);
        v();
        return this.f7685l.f();
    }

    public final void o(List list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            m((qc.d) list.get(size));
        }
    }

    public final d p(qc.d dVar) {
        a aVar = new a(dVar);
        Iterator it = this.f7682i.iterator();
        while (it.hasNext()) {
            qc.f fVarA = ((qc.e) it.next()).a(this, aVar);
            if (fVarA instanceof d) {
                return (d) fVarA;
            }
        }
        return null;
    }

    public final void q() {
        int i10 = this.f7675b;
        int i11 = this.f7676c;
        this.f7681h = true;
        int length = this.f7674a.length();
        while (i10 < length) {
            char cCharAt = this.f7674a.charAt(i10);
            if (cCharAt == '\t') {
                i10++;
                i11 += 4 - (i11 % 4);
            } else if (cCharAt != ' ') {
                this.f7681h = false;
                break;
            } else {
                i10++;
                i11++;
            }
        }
        this.f7678e = i10;
        this.f7679f = i11;
        this.f7680g = i11 - this.f7676c;
    }

    public final void s(CharSequence charSequence) {
        this.f7674a = nc.d.j(charSequence);
        this.f7675b = 0;
        this.f7676c = 0;
        this.f7677d = false;
        List list = this.f7687n;
        int i10 = 1;
        for (qc.d dVar : list.subList(1, list.size())) {
            q();
            qc.c cVarG = dVar.g(this);
            if (!(cVarG instanceof b)) {
                break;
            }
            b bVar = (b) cVarG;
            if (bVar.g()) {
                m(dVar);
                return;
            }
            if (bVar.f() != -1) {
                x(bVar.f());
            } else if (bVar.e() != -1) {
                w(bVar.e());
            }
            i10++;
        }
        List list2 = this.f7687n;
        ArrayList arrayList = new ArrayList(list2.subList(i10, list2.size()));
        qc.d dVar2 = (qc.d) this.f7687n.get(i10 - 1);
        boolean zIsEmpty = arrayList.isEmpty();
        boolean zB = (dVar2.f() instanceof v) || dVar2.b();
        while (zB) {
            q();
            if (a() || (this.f7680g < nc.d.f10854a && nc.d.h(this.f7674a, this.f7678e))) {
                x(this.f7678e);
                break;
            }
            d dVarP = p(dVar2);
            if (dVarP == null) {
                x(this.f7678e);
                break;
            }
            if (!zIsEmpty) {
                o(arrayList);
                zIsEmpty = true;
            }
            if (dVarP.h() != -1) {
                x(dVarP.h());
            } else if (dVarP.g() != -1) {
                w(dVarP.g());
            }
            if (dVarP.i()) {
                u();
            }
            qc.d[] dVarArrF = dVarP.f();
            int length = dVarArrF.length;
            int i11 = 0;
            while (i11 < length) {
                qc.d dVar3 = dVarArrF[i11];
                qc.d dVarG = g(dVar3);
                i11++;
                zB = dVar3.b();
                dVar2 = dVarG;
            }
        }
        if (!zIsEmpty && !a() && d().e()) {
            i();
            return;
        }
        if (!zIsEmpty) {
            o(arrayList);
        }
        if (!dVar2.b()) {
            i();
        } else {
            if (a()) {
                return;
            }
            g(new q());
            i();
        }
    }

    public oc.g t(String str) {
        int i10 = 0;
        while (true) {
            int iC = nc.d.c(str, i10);
            if (iC == -1) {
                break;
            }
            s(str.substring(i10, iC));
            i10 = iC + 1;
            if (i10 < str.length() && str.charAt(iC) == '\r' && str.charAt(i10) == '\n') {
                i10 = iC + 2;
            }
        }
        if (str.length() > 0 && (i10 == 0 || i10 < str.length())) {
            s(str.substring(i10));
        }
        return n();
    }

    public final void u() {
        qc.d dVarD = d();
        l();
        this.f7688o.remove(dVarD);
        if (dVarD instanceof q) {
            h((q) dVarD);
        }
        dVarD.f().l();
    }

    public final void v() {
        pc.a aVarA = this.f7683j.a(new m(this.f7684k, this.f7686m));
        Iterator it = this.f7688o.iterator();
        while (it.hasNext()) {
            ((qc.d) it.next()).d(aVarA);
        }
    }

    public final void w(int i10) {
        int i11;
        int i12 = this.f7679f;
        if (i10 >= i12) {
            this.f7675b = this.f7678e;
            this.f7676c = i12;
        }
        int length = this.f7674a.length();
        while (true) {
            i11 = this.f7676c;
            if (i11 >= i10 || this.f7675b == length) {
                break;
            } else {
                j();
            }
        }
        if (i11 <= i10) {
            this.f7677d = false;
            return;
        }
        this.f7675b--;
        this.f7676c = i10;
        this.f7677d = true;
    }

    public final void x(int i10) {
        int i11 = this.f7678e;
        if (i10 >= i11) {
            this.f7675b = i11;
            this.f7676c = this.f7679f;
        }
        int length = this.f7674a.length();
        while (true) {
            int i12 = this.f7675b;
            if (i12 >= i10 || i12 == length) {
                break;
            } else {
                j();
            }
        }
        this.f7677d = false;
    }
}
