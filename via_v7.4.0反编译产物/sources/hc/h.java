package hc;

import hc.c;
import hc.i;
import hc.j;
import hc.k;
import hc.l;
import hc.o;
import hc.s;
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
import kc.v;
import kc.z;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class h implements mc.h {

    /* renamed from: p, reason: collision with root package name */
    public static final Set f6894p = new LinkedHashSet(Arrays.asList(kc.b.class, kc.k.class, kc.i.class, kc.l.class, z.class, kc.r.class, kc.o.class));

    /* renamed from: q, reason: collision with root package name */
    public static final Map f6895q;

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f6896a;

    /* renamed from: d, reason: collision with root package name */
    public boolean f6899d;

    /* renamed from: h, reason: collision with root package name */
    public boolean f6903h;

    /* renamed from: i, reason: collision with root package name */
    public final List f6904i;

    /* renamed from: j, reason: collision with root package name */
    public final lc.c f6905j;

    /* renamed from: k, reason: collision with root package name */
    public final List f6906k;

    /* renamed from: l, reason: collision with root package name */
    public final g f6907l;

    /* renamed from: b, reason: collision with root package name */
    public int f6897b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f6898c = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f6900e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f6901f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f6902g = 0;

    /* renamed from: m, reason: collision with root package name */
    public final Map f6908m = new LinkedHashMap();

    /* renamed from: n, reason: collision with root package name */
    public List f6909n = new ArrayList();

    /* renamed from: o, reason: collision with root package name */
    public Set f6910o = new LinkedHashSet();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a implements mc.g {

        /* renamed from: a, reason: collision with root package name */
        public final mc.d f6911a;

        public a(mc.d dVar) {
            this.f6911a = dVar;
        }

        @Override // mc.g
        public mc.d a() {
            return this.f6911a;
        }

        @Override // mc.g
        public CharSequence b() {
            mc.d dVar = this.f6911a;
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
        map.put(kc.b.class, new c.a());
        map.put(kc.k.class, new j.a());
        map.put(kc.i.class, new i.a());
        map.put(kc.l.class, new k.b());
        map.put(z.class, new s.a());
        map.put(kc.r.class, new o.a());
        map.put(kc.o.class, new l.a());
        f6895q = Collections.unmodifiableMap(map);
    }

    public h(List list, lc.c cVar, List list2) {
        this.f6904i = list;
        this.f6905j = cVar;
        this.f6906k = list2;
        g gVar = new g();
        this.f6907l = gVar;
        f(gVar);
    }

    public static List k(List list, Set set) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(f6895q.get((Class) it.next()));
        }
        return arrayList;
    }

    public static Set r() {
        return f6894p;
    }

    @Override // mc.h
    public boolean a() {
        return this.f6903h;
    }

    @Override // mc.h
    public int b() {
        return this.f6902g;
    }

    @Override // mc.h
    public int c() {
        return this.f6900e;
    }

    @Override // mc.h
    public mc.d d() {
        return (mc.d) this.f6909n.get(r0.size() - 1);
    }

    @Override // mc.h
    public int e() {
        return this.f6898c;
    }

    public final void f(mc.d dVar) {
        this.f6909n.add(dVar);
        this.f6910o.add(dVar);
    }

    public final mc.d g(mc.d dVar) {
        while (!d().f(dVar.e())) {
            m(d());
        }
        d().e().b(dVar.e());
        f(dVar);
        return dVar;
    }

    @Override // mc.h
    public int getIndex() {
        return this.f6897b;
    }

    @Override // mc.h
    public CharSequence getLine() {
        return this.f6896a;
    }

    public final void h(q qVar) {
        for (kc.q qVar2 : qVar.j()) {
            qVar.e().i(qVar2);
            String strN = qVar2.n();
            if (!this.f6908m.containsKey(strN)) {
                this.f6908m.put(strN, qVar2);
            }
        }
    }

    public final void i() {
        CharSequence charSequenceSubSequence;
        if (this.f6899d) {
            int i10 = this.f6897b + 1;
            CharSequence charSequence = this.f6896a;
            CharSequence charSequenceSubSequence2 = charSequence.subSequence(i10, charSequence.length());
            int iA = jc.d.a(this.f6898c);
            StringBuilder sb2 = new StringBuilder(charSequenceSubSequence2.length() + iA);
            for (int i11 = 0; i11 < iA; i11++) {
                sb2.append(' ');
            }
            sb2.append(charSequenceSubSequence2);
            charSequenceSubSequence = sb2.toString();
        } else {
            CharSequence charSequence2 = this.f6896a;
            charSequenceSubSequence = charSequence2.subSequence(this.f6897b, charSequence2.length());
        }
        d().h(charSequenceSubSequence);
    }

    public final void j() {
        if (this.f6896a.charAt(this.f6897b) != '\t') {
            this.f6897b++;
            this.f6898c++;
        } else {
            this.f6897b++;
            int i10 = this.f6898c;
            this.f6898c = i10 + jc.d.a(i10);
        }
    }

    public final void l() {
        this.f6909n.remove(r0.size() - 1);
    }

    public final void m(mc.d dVar) {
        if (d() == dVar) {
            l();
        }
        if (dVar instanceof q) {
            h((q) dVar);
        }
        dVar.b();
    }

    public final kc.g n() {
        o(this.f6909n);
        v();
        return this.f6907l.e();
    }

    public final void o(List list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            m((mc.d) list.get(size));
        }
    }

    public final d p(mc.d dVar) {
        a aVar = new a(dVar);
        Iterator it = this.f6904i.iterator();
        while (it.hasNext()) {
            mc.f fVarA = ((mc.e) it.next()).a(this, aVar);
            if (fVarA instanceof d) {
                return (d) fVarA;
            }
        }
        return null;
    }

    public final void q() {
        int i10 = this.f6897b;
        int i11 = this.f6898c;
        this.f6903h = true;
        int length = this.f6896a.length();
        while (true) {
            if (i10 >= length) {
                break;
            }
            char cCharAt = this.f6896a.charAt(i10);
            if (cCharAt == '\t') {
                i10++;
                i11 += 4 - (i11 % 4);
            } else if (cCharAt != ' ') {
                this.f6903h = false;
                break;
            } else {
                i10++;
                i11++;
            }
        }
        this.f6900e = i10;
        this.f6901f = i11;
        this.f6902g = i11 - this.f6898c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00f7, code lost:
    
        x(r10.f6900e);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void s(CharSequence charSequence) {
        this.f6896a = jc.d.j(charSequence);
        this.f6897b = 0;
        this.f6898c = 0;
        this.f6899d = false;
        List list = this.f6909n;
        int i10 = 1;
        for (mc.d dVar : list.subList(1, list.size())) {
            q();
            mc.c cVarG = dVar.g(this);
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
        List list2 = this.f6909n;
        ArrayList arrayList = new ArrayList(list2.subList(i10, list2.size()));
        mc.d dVar2 = (mc.d) this.f6909n.get(i10 - 1);
        boolean zIsEmpty = arrayList.isEmpty();
        boolean zA = (dVar2.e() instanceof v) || dVar2.a();
        while (true) {
            if (!zA) {
                break;
            }
            q();
            if (a() || (this.f6902g < jc.d.f7963a && jc.d.h(this.f6896a, this.f6900e))) {
                break;
            }
            d dVarP = p(dVar2);
            if (dVarP == null) {
                x(this.f6900e);
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
            mc.d[] dVarArrF = dVarP.f();
            int length = dVarArrF.length;
            int i11 = 0;
            while (i11 < length) {
                mc.d dVar3 = dVarArrF[i11];
                mc.d dVarG = g(dVar3);
                i11++;
                zA = dVar3.a();
                dVar2 = dVarG;
            }
        }
        if (!zIsEmpty && !a() && d().c()) {
            i();
            return;
        }
        if (!zIsEmpty) {
            o(arrayList);
        }
        if (!dVar2.a()) {
            i();
        } else {
            if (a()) {
                return;
            }
            g(new q());
            i();
        }
    }

    public kc.g t(String str) {
        int i10 = 0;
        while (true) {
            int iC = jc.d.c(str, i10);
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
        mc.d dVarD = d();
        l();
        this.f6910o.remove(dVarD);
        if (dVarD instanceof q) {
            h((q) dVarD);
        }
        dVarD.e().l();
    }

    public final void v() {
        lc.a aVarA = this.f6905j.a(new m(this.f6906k, this.f6908m));
        Iterator it = this.f6910o.iterator();
        while (it.hasNext()) {
            ((mc.d) it.next()).d(aVarA);
        }
    }

    public final void w(int i10) {
        int i11;
        int i12 = this.f6901f;
        if (i10 >= i12) {
            this.f6897b = this.f6900e;
            this.f6898c = i12;
        }
        int length = this.f6896a.length();
        while (true) {
            i11 = this.f6898c;
            if (i11 >= i10 || this.f6897b == length) {
                break;
            } else {
                j();
            }
        }
        if (i11 <= i10) {
            this.f6899d = false;
            return;
        }
        this.f6897b--;
        this.f6898c = i10;
        this.f6899d = true;
    }

    public final void x(int i10) {
        int i11 = this.f6900e;
        if (i10 >= i11) {
            this.f6897b = i11;
            this.f6898c = this.f6901f;
        }
        int length = this.f6896a.length();
        while (true) {
            int i12 = this.f6897b;
            if (i12 >= i10 || i12 == length) {
                break;
            } else {
                j();
            }
        }
        this.f6899d = false;
    }
}
