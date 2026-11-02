package m5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public final e5.g f8664a;

    /* renamed from: b, reason: collision with root package name */
    public final f5.c f8665b;

    /* renamed from: c, reason: collision with root package name */
    public final h5.c f8666c;

    /* renamed from: d, reason: collision with root package name */
    public final m f8667d;

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f8668e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public final c f8669f = new c();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements j5.c {
        public a() {
        }

        @Override // j5.c
        public void J(g5.c cVar, int i10, int i11) {
            d5.a.a("DownloadQueue", "task: " + cVar.l() + ", status: " + i10 + "->" + i11);
            if (g5.b.a(i11) || g5.b.c(i11)) {
                i.this.f8668e.remove(Long.valueOf(cVar.j()));
                i.this.f8669f.c(cVar.j());
                i.this.o();
            } else if (i11 == 95) {
                i.this.f8668e.remove(Long.valueOf(cVar.j()));
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(g5.c cVar, g5.c cVar2) {
            if (cVar.q() != cVar2.q()) {
                return cVar.q() > cVar2.q() ? 1 : -1;
            }
            if (cVar.b() != cVar2.b()) {
                return cVar.b() < cVar2.b() ? 1 : -1;
            }
            return 0;
        }
    }

    public i(m mVar, e5.g gVar, f5.c cVar, h5.c cVar2) {
        this.f8667d = mVar;
        this.f8664a = gVar;
        this.f8665b = cVar;
        this.f8666c = cVar2;
        h();
    }

    public boolean d(long j10) {
        if (this.f8668e.containsKey(Long.valueOf(j10)) && !j(j10)) {
            return false;
        }
        if (this.f8665b.l(j10) == null) {
            return true;
        }
        this.f8665b.m(j10);
        this.f8665b.g(j10);
        return true;
    }

    public l e(g5.c cVar) {
        return this.f8667d.b(cVar);
    }

    public long f(g5.c cVar) {
        String strT = cVar.t();
        if (l5.a.e(strT)) {
            cVar.S(null);
        }
        long jH = this.f8665b.h(cVar);
        if (jH <= 0) {
            cVar.S(strT);
            return 0L;
        }
        cVar.H(jH);
        if (cVar.t() == null && strT != null) {
            this.f8669f.a(jH, strT);
            cVar.S(strT);
        }
        o();
        return jH;
    }

    public boolean g() {
        return this.f8665b.j(new int[]{90, 95});
    }

    public final void h() {
        this.f8666c.e(new a());
    }

    public boolean i() {
        return !this.f8668e.isEmpty();
    }

    public boolean j(long j10) {
        l lVar = (l) this.f8668e.get(Long.valueOf(j10));
        if (lVar != null) {
            lVar.a();
            return true;
        }
        g5.c cVarL = this.f8665b.l(j10);
        if (cVarL != null && !g5.b.a(cVarL.q())) {
            int iQ = cVarL.q();
            cVarL.P(80);
            this.f8665b.b(cVarL);
            this.f8666c.b(cVarL, iQ, 80);
        }
        return true;
    }

    public boolean k() {
        List<g5.c> listA = this.f8665b.a();
        ArrayList arrayList = new ArrayList();
        for (g5.c cVar : listA) {
            if (!this.f8668e.containsKey(Long.valueOf(cVar.j())) && g5.b.d(cVar.q())) {
                cVar.P(80);
                arrayList.add(cVar);
            }
        }
        if (arrayList.size() > 0) {
            this.f8665b.d(arrayList);
        }
        if (this.f8668e.isEmpty()) {
            return true;
        }
        Iterator it = this.f8668e.entrySet().iterator();
        while (it.hasNext()) {
            ((l) ((Map.Entry) it.next()).getValue()).a();
        }
        this.f8668e.clear();
        return true;
    }

    public boolean l(long j10) {
        g5.c cVarL;
        if ((this.f8668e.containsKey(Long.valueOf(j10)) && !j(j10)) || (cVarL = this.f8665b.l(j10)) == null) {
            return false;
        }
        cVarL.w("ETag", null);
        cVarL.F(false);
        cVarL.x(8);
        if (this.f8665b.b(cVarL) && this.f8665b.m(j10)) {
            return m(j10);
        }
        return false;
    }

    public boolean m(long j10) {
        if (((l) this.f8668e.get(Long.valueOf(j10))) != null) {
            return true;
        }
        g5.c cVarL = this.f8665b.l(j10);
        if (cVarL == null) {
            return false;
        }
        int iQ = cVarL.q();
        if (iQ != 90 && iQ != 95) {
            cVarL.P(90);
            this.f8665b.b(cVarL);
            this.f8666c.b(cVarL, iQ, 90);
        }
        o();
        return true;
    }

    public boolean n() {
        return o() > 0;
    }

    public final int o() {
        int size = this.f8668e.size();
        if (size >= 3) {
            return size;
        }
        List<g5.c> listF = this.f8665b.f(new int[]{95, 90});
        Collections.sort(listF, new b());
        for (g5.c cVar : listF) {
            if (!this.f8668e.containsKey(Long.valueOf(cVar.j()))) {
                if (cVar.t() == null) {
                    cVar.S(this.f8669f.b(cVar.j()));
                }
                l lVarA = this.f8667d.a(cVar);
                this.f8668e.put(Long.valueOf(cVar.j()), lVarA);
                this.f8664a.b().submit(lVarA);
                size++;
                if (size >= 3) {
                    break;
                }
            }
        }
        return size;
    }
}
