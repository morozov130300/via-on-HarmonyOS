package f5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f4480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f4481b = new HashMap();

    public a(b bVar) {
        this.f4480a = bVar;
    }

    @Override // f5.c
    public List a() {
        return this.f4480a.a();
    }

    @Override // f5.c
    public boolean b(g5.c cVar) {
        return this.f4480a.b(cVar);
    }

    @Override // f5.c
    public boolean c(List list) {
        return this.f4480a.c(list);
    }

    @Override // f5.c
    public boolean d(g5.a aVar) {
        if (!this.f4480a.n(aVar.d(), aVar.b())) {
            return false;
        }
        List list = (List) this.f4481b.get(Long.valueOf(aVar.h()));
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
    public List e(int[] iArr) {
        return this.f4480a.e(iArr);
    }

    @Override // f5.c
    public boolean f(long j10) {
        return this.f4480a.f(j10);
    }

    @Override // f5.c
    public long g(g5.c cVar) {
        return this.f4480a.g(cVar);
    }

    @Override // f5.c
    public List h(long j10) {
        List listH = (List) this.f4481b.get(Long.valueOf(j10));
        if (listH == null && (listH = this.f4480a.h(j10)) != null) {
            this.f4481b.put(Long.valueOf(j10), listH);
        }
        return listH;
    }

    @Override // f5.c
    public boolean i(long j10) {
        if (!this.f4480a.o(j10)) {
            return false;
        }
        List list = (List) this.f4481b.get(Long.valueOf(j10));
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
    public boolean j(int[] iArr) {
        return this.f4480a.j(iArr);
    }

    @Override // f5.c
    public boolean k(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.f4481b.remove(Long.valueOf(((g5.a) it.next()).h()));
        }
        return this.f4480a.k(list);
    }

    @Override // f5.c
    public g5.c l(long j10) {
        return this.f4480a.l(j10);
    }

    @Override // f5.c
    public boolean m(long j10) {
        if (!this.f4480a.m(j10)) {
            return false;
        }
        this.f4481b.remove(Long.valueOf(j10));
        return true;
    }
}
