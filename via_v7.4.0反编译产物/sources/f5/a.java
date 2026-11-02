package f5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public final b f5899a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f5900b = new HashMap();

    public a(b bVar) {
        this.f5899a = bVar;
    }

    @Override // f5.c
    public List a() {
        return this.f5899a.a();
    }

    @Override // f5.c
    public boolean b(g5.c cVar) {
        return this.f5899a.b(cVar);
    }

    @Override // f5.c
    public boolean c(g5.a aVar) {
        if (!this.f5899a.n(aVar.d(), aVar.b())) {
            return false;
        }
        List list = (List) this.f5900b.get(Long.valueOf(aVar.h()));
        if (list == null) {
            return true;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (((g5.a) list.get(i10)).d() == aVar.d()) {
                list.set(i10, aVar);
                return true;
            }
        }
        return true;
    }

    @Override // f5.c
    public boolean d(List list) {
        return this.f5899a.d(list);
    }

    @Override // f5.c
    public boolean e(long j10) {
        if (!this.f5899a.o(j10)) {
            return false;
        }
        List list = (List) this.f5900b.get(Long.valueOf(j10));
        if (list == null) {
            return true;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((g5.a) it.next()).i(0L);
        }
        return true;
    }

    @Override // f5.c
    public List f(int[] iArr) {
        return this.f5899a.f(iArr);
    }

    @Override // f5.c
    public boolean g(long j10) {
        return this.f5899a.g(j10);
    }

    @Override // f5.c
    public long h(g5.c cVar) {
        return this.f5899a.h(cVar);
    }

    @Override // f5.c
    public List i(long j10) {
        List listI = (List) this.f5900b.get(Long.valueOf(j10));
        if (listI == null && (listI = this.f5899a.i(j10)) != null) {
            this.f5900b.put(Long.valueOf(j10), listI);
        }
        return listI;
    }

    @Override // f5.c
    public boolean j(int[] iArr) {
        return this.f5899a.j(iArr);
    }

    @Override // f5.c
    public boolean k(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.f5900b.remove(Long.valueOf(((g5.a) it.next()).h()));
        }
        return this.f5899a.k(list);
    }

    @Override // f5.c
    public g5.c l(long j10) {
        return this.f5899a.l(j10);
    }

    @Override // f5.c
    public boolean m(long j10) {
        if (!this.f5899a.m(j10)) {
            return false;
        }
        this.f5900b.remove(Long.valueOf(j10));
        return true;
    }
}
