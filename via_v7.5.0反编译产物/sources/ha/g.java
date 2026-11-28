package ha;

import c6.a2;
import c6.y1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import r6.j;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f5777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f5778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f5779c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5781e = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k.e f5780d = null;

    public g(h hVar, h hVar2, h hVar3) {
        this.f5777a = hVar;
        this.f5778b = hVar2;
        this.f5779c = hVar3;
    }

    public void e(String str) {
        h hVar = this.f5779c;
        if (hVar instanceof ia.b) {
            ((ia.b) hVar).b(str);
        }
    }

    public final void f(String str, List list) {
        if (str == null || list == null) {
            return;
        }
        if (this.f5780d == null) {
            this.f5780d = new k.e(128);
        }
        this.f5780d.e(str, list);
    }

    public final List g(String str) {
        k.e eVar;
        if (str == null || (eVar = this.f5780d) == null) {
            return null;
        }
        return (List) eVar.d(str);
    }

    public final void h() {
        k.e eVar = this.f5780d;
        if (eVar == null) {
            return;
        }
        eVar.c();
        this.f5780d = null;
    }

    public void i(String str) {
        h hVar = this.f5779c;
        if (hVar instanceof ia.b) {
            ((ia.b) hVar).c(str);
        }
    }

    public final List j(String str, int i10) {
        h hVar;
        List listA;
        if (str != null) {
            str = str.trim();
            if (!str.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                if (str.length() < 10000) {
                    for (String str2 : y1.f2139a.e(str)) {
                        String strF = a2.f1958a.f(str2);
                        if (!strF.isEmpty()) {
                            arrayList.add(new a(0, strF, str2, 0));
                        }
                    }
                }
                if ((i10 & 15) != 0 && str.length() < 500 && (hVar = this.f5777a) != null && (listA = hVar.a(str, 5, i10)) != null) {
                    arrayList.addAll(listA);
                }
                return arrayList;
            }
        }
        return (i10 & 32) != 0 ? this.f5779c.a(str, 5, i10) : Collections.EMPTY_LIST;
    }

    public j k(final String str, final int i10) {
        return (str == null || str.length() < 10000) ? j.v(new Callable() { // from class: ha.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f5764c.j(str, i10);
            }
        }) : j.v(new b());
    }

    public final List l(String str, int i10) {
        if ((i10 & 32) == 0) {
            return Collections.EMPTY_LIST;
        }
        if (str != null) {
            str = str.trim();
            if (!str.isEmpty()) {
                return Collections.EMPTY_LIST;
            }
        }
        return this.f5779c.a(str, 5, i10);
    }

    public j m(final String str, final int i10) {
        return (i10 & 32) == 0 ? j.v(new b()) : j.v(new Callable() { // from class: ha.f
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f5774c.l(str, i10);
            }
        });
    }

    public final List n(String str, int i10) {
        if (str != null) {
            String strTrim = str.trim();
            if (!strTrim.isEmpty() && (i10 & 16) != 0) {
                ArrayList arrayList = new ArrayList();
                List listG = g(strTrim);
                h hVar = this.f5778b;
                if (hVar != null && listG == null && (listG = hVar.a(strTrim, 5, i10)) != null) {
                    f(strTrim, listG);
                }
                if (listG != null) {
                    arrayList.addAll(listG);
                }
                return arrayList;
            }
        }
        return Collections.EMPTY_LIST;
    }

    public final List o(String str, int i10, int i11) {
        if (str != null) {
            String strTrim = str.trim();
            if (!strTrim.isEmpty() && (i10 & 16) != 0) {
                String str2 = i11 + ":" + strTrim;
                List listG = g(str2);
                if (listG == null) {
                    h hVar = this.f5778b;
                    if ((hVar instanceof ja.a) && (listG = ((ja.a) hVar).b(strTrim, 5, i10, i11)) != null) {
                        f(str2, listG);
                    }
                }
                return listG == null ? Collections.EMPTY_LIST : new ArrayList(listG);
            }
        }
        return Collections.EMPTY_LIST;
    }

    public j p(final String str, final int i10) {
        return ((i10 & 16) == 0 || (str != null && str.length() > 200) || a2.f1958a.t(str)) ? j.v(new b()) : j.v(new Callable() { // from class: ha.e
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f5771c.n(str, i10);
            }
        });
    }

    public j q(final String str, final int i10, final int i11) {
        return ((i10 & 16) == 0 || (str != null && str.length() > 200) || a2.f1958a.t(str)) ? j.v(new b()) : j.v(new Callable() { // from class: ha.d
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f5767c.o(str, i10, i11);
            }
        });
    }

    public j r(String str, int i10, int i11) {
        return j.B(k(str, i10), q(str, i10, i11));
    }

    public void s(int i10) {
        if (this.f5781e == i10) {
            return;
        }
        h hVar = this.f5778b;
        if (hVar instanceof ja.a) {
            this.f5781e = i10;
            ((ja.a) hVar).c(i10);
            h();
        }
    }

    public void t(List list) {
        h hVar = this.f5777a;
        if (hVar instanceof ia.a) {
            ((ia.a) hVar).e(list);
        }
    }
}
