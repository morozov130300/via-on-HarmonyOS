package m5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e5.g f7922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f5.c f7923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h5.c f7924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n f7925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap f7926e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set f7927f = new HashSet();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f7928g = new c();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
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

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public final class b implements Callable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final g5.c f7930c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final m f7931e;

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                i.this.h(bVar);
            }
        }

        public b(g5.c cVar, m mVar) {
            this.f7930c = cVar;
            this.f7931e = mVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public j call() {
            try {
                return (j) this.f7931e.call();
            } finally {
                i.this.f7922a.a().execute(new a());
            }
        }
    }

    public i(n nVar, e5.g gVar, f5.c cVar, h5.c cVar2) {
        this.f7925d = nVar;
        this.f7922a = gVar;
        this.f7923b = cVar;
        this.f7924c = cVar2;
    }

    public boolean c(long j10) {
        if (this.f7926e.containsKey(Long.valueOf(j10))) {
            i(j10);
        }
        if (this.f7923b.l(j10) == null) {
            return true;
        }
        this.f7923b.m(j10);
        this.f7923b.f(j10);
        return true;
    }

    public m d(g5.c cVar) {
        return this.f7925d.b(cVar);
    }

    public long e(g5.c cVar) {
        String strT = cVar.t();
        if (l5.a.e(strT)) {
            cVar.T(null);
        }
        long jG = this.f7923b.g(cVar);
        if (jG <= 0) {
            cVar.T(strT);
            return 0L;
        }
        cVar.H(jG);
        if (cVar.t() == null && strT != null) {
            this.f7928g.a(jG, strT);
            cVar.T(strT);
        }
        n();
        return jG;
    }

    public boolean f() {
        return this.f7923b.j(new int[]{90, 95});
    }

    public boolean g() {
        if (!this.f7927f.isEmpty()) {
            return true;
        }
        Iterator it = this.f7926e.values().iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            int iQ = ((b) it.next()).f7930c.q();
            if (!g5.b.a(iQ) && !g5.b.c(iQ) && !g5.b.f(iQ)) {
                return true;
            }
            z10 |= !g5.b.f(iQ);
        }
        if (z10) {
            Iterator it2 = this.f7923b.e(new int[]{90, 95}).iterator();
            while (it2.hasNext()) {
                if (!this.f7926e.containsKey(Long.valueOf(((g5.c) it2.next()).j()))) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void h(b bVar) {
        g5.c cVar = bVar.f7930c;
        long j10 = cVar.j();
        if (this.f7926e.get(Long.valueOf(j10)) != bVar) {
            return;
        }
        this.f7926e.remove(Long.valueOf(j10));
        if (this.f7927f.remove(Long.valueOf(j10))) {
            if (k(j10)) {
                return;
            }
            d5.a.d("DownloadQueue", "Could not restart task: " + j10);
        }
        this.f7928g.c(j10);
        if (g5.b.a(cVar.q()) || g5.b.c(cVar.q())) {
            n();
        }
    }

    public boolean i(long j10) {
        this.f7927f.remove(Long.valueOf(j10));
        b bVar = (b) this.f7926e.get(Long.valueOf(j10));
        if (bVar != null) {
            bVar.f7931e.a();
            return true;
        }
        g5.c cVarL = this.f7923b.l(j10);
        if (cVarL != null && !g5.b.a(cVarL.q())) {
            int iQ = cVarL.q();
            cVarL.Q(80);
            this.f7923b.b(cVarL);
            this.f7924c.b(cVarL, iQ, 80);
        }
        return true;
    }

    public boolean j() {
        this.f7927f.clear();
        List<g5.c> listA = this.f7923b.a();
        ArrayList arrayList = new ArrayList();
        for (g5.c cVar : listA) {
            if (!this.f7926e.containsKey(Long.valueOf(cVar.j())) && g5.b.d(cVar.q())) {
                cVar.Q(80);
                arrayList.add(cVar);
            }
        }
        if (arrayList.size() > 0) {
            this.f7923b.c(arrayList);
        }
        Iterator it = this.f7926e.values().iterator();
        while (it.hasNext()) {
            ((b) it.next()).f7931e.a();
        }
        return true;
    }

    public boolean k(long j10) {
        b bVar = (b) this.f7926e.get(Long.valueOf(j10));
        if (bVar != null) {
            if (this.f7927f.add(Long.valueOf(j10))) {
                bVar.f7931e.a();
            }
            return true;
        }
        g5.c cVarL = this.f7923b.l(j10);
        if (cVarL == null) {
            return false;
        }
        cVarL.w("ETag", null);
        cVarL.F(false);
        cVarL.x(8);
        return this.f7923b.b(cVarL) && this.f7923b.m(j10) && l(j10);
    }

    public boolean l(long j10) {
        if (this.f7926e.containsKey(Long.valueOf(j10))) {
            return true;
        }
        g5.c cVarL = this.f7923b.l(j10);
        if (cVarL == null) {
            return false;
        }
        int iQ = cVarL.q();
        if (iQ != 90 && iQ != 95) {
            cVarL.Q(90);
            this.f7923b.b(cVarL);
            this.f7924c.b(cVarL, iQ, 90);
        }
        n();
        return true;
    }

    public boolean m() {
        return n() > 0;
    }

    public final int n() {
        int size = this.f7926e.size();
        if (size >= 3) {
            return size;
        }
        List<g5.c> listE = this.f7923b.e(new int[]{95, 90});
        Collections.sort(listE, new a());
        for (g5.c cVar : listE) {
            if (!this.f7926e.containsKey(Long.valueOf(cVar.j()))) {
                if (cVar.t() == null) {
                    cVar.T(this.f7928g.b(cVar.j()));
                }
                b bVar = new b(cVar, this.f7925d.a(cVar));
                this.f7926e.put(Long.valueOf(cVar.j()), bVar);
                this.f7922a.b().submit(bVar);
                size++;
                if (size >= 3) {
                    break;
                }
            }
        }
        return size;
    }
}
