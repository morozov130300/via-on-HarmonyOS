package t9;

import c6.a2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import u9.l;
import x8.w0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ya.e f12577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f12578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f12579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f12580d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CountDownLatch f12581e = new CountDownLatch(1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f12582f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f12583g;

    public d(ya.e eVar, l lVar, h hVar, j jVar) {
        this.f12577a = eVar;
        this.f12579c = lVar;
        this.f12578b = hVar;
        this.f12580d = jVar;
        x();
        w();
    }

    public static /* synthetic */ int p(d dVar, String str, String str2, f fVar, f fVar2) {
        int iV = dVar.v(fVar, str, str2);
        int iV2 = dVar.v(fVar2, str, str2);
        if (iV2 > iV) {
            return 1;
        }
        return (iV2 >= iV && fVar.a() >= fVar2.a()) ? 1 : -1;
    }

    public static /* synthetic */ void r(d dVar) {
        dVar.getClass();
        try {
            try {
                synchronized (dVar.f12582f) {
                    dVar.f12583g = dVar.f12579c.t2();
                    dVar.y();
                }
            } catch (Exception e10) {
                tc.a.j(e10);
            }
            dVar.f12581e.countDown();
        } catch (Throwable th) {
            dVar.f12581e.countDown();
            throw th;
        }
    }

    @Override // t9.g
    public boolean a(String str) {
        boolean zA;
        synchronized (this.f12582f) {
            zA = this.f12578b.a(str);
        }
        return zA;
    }

    @Override // t9.g
    public boolean b(f fVar) {
        boolean z10 = false;
        if (fVar == null || fVar.b() == null || fVar.b().isEmpty() || fVar.e() == null || !s()) {
            return false;
        }
        synchronized (this.f12582f) {
            try {
                f fVarT = t(fVar, u());
                if (fVarT != null && this.f12578b.f(fVarT)) {
                    z10 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    @Override // t9.g
    public void c(String str, boolean z10) {
        if (this.f12580d.g(str, z10)) {
            this.f12580d.b();
        }
    }

    @Override // t9.g
    public List d(String str) {
        return this.f12578b.k(str);
    }

    @Override // t9.g
    public List e(String str) {
        List listB;
        a2 a2Var = a2.f1958a;
        final String strF = a2Var.f(str);
        if (strF.isEmpty()) {
            return new ArrayList();
        }
        final String strC = a2Var.c(str);
        if (strC.equals(strF)) {
            listB = this.f12578b.b(new String[]{strF, '.' + strF});
        } else {
            listB = this.f12578b.b(new String[]{strF, strC, '.' + strC});
        }
        Collections.sort(listB, new Comparator() { // from class: t9.c
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return d.p(this.f12574c, strF, strC, (f) obj, (f) obj2);
            }
        });
        return listB;
    }

    @Override // t9.g
    public f f(String str) {
        f fVarG;
        boolean zS = s();
        synchronized (this.f12582f) {
            try {
                fVarG = this.f12578b.g(str);
                if (fVarG != null && fVarG.e() != null) {
                    fVarG.m(w0.b(zS ? y() : null, fVarG.e()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVarG;
    }

    @Override // t9.g
    public List g() {
        return this.f12578b.e();
    }

    @Override // t9.g
    public f h(String str) {
        return this.f12578b.g(str);
    }

    @Override // t9.g
    public boolean i(List list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (fVar == null || fVar.b() == null || fVar.b().isEmpty() || fVar.e() == null) {
                return false;
            }
        }
        if (!s()) {
            return false;
        }
        synchronized (this.f12582f) {
            try {
                byte[] bArrU = u();
                ArrayList arrayList = new ArrayList(list.size());
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    f fVarT = t((f) it2.next(), bArrU);
                    if (fVarT == null) {
                        return false;
                    }
                    arrayList.add(fVarT);
                }
                return this.f12578b.j(arrayList);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // t9.g
    public boolean j() {
        return this.f12578b.h() <= 0;
    }

    @Override // t9.g
    public boolean k(String str, f fVar) {
        boolean z10 = false;
        if (str == null || str.isEmpty() || fVar == null || !s()) {
            return false;
        }
        synchronized (this.f12582f) {
            try {
                if (fVar.e() == null) {
                    return this.f12578b.l(str, fVar);
                }
                f fVarT = t(fVar, u());
                if (fVarT != null && this.f12578b.l(str, fVarT)) {
                    z10 = true;
                }
                return z10;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // t9.g
    public List l() {
        return this.f12580d.d();
    }

    @Override // t9.g
    public String m(String str, String str2) {
        return this.f12578b.c(str, str2);
    }

    @Override // t9.g
    public List n() {
        boolean zS = s();
        synchronized (this.f12582f) {
            try {
                List<f> listE = this.f12578b.e();
                if (listE != null && !listE.isEmpty()) {
                    byte[] bArrY = zS ? y() : null;
                    for (f fVar : listE) {
                        if (fVar.e() != null) {
                            fVar.m(w0.b(bArrY, fVar.e()));
                        }
                    }
                    return listE;
                }
                return listE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // t9.g
    public boolean o(String str) {
        return this.f12580d.e(str, this.f12579c.v().q());
    }

    public final boolean s() {
        try {
            this.f12581e.await();
            return true;
        } catch (InterruptedException e10) {
            Thread.currentThread().interrupt();
            tc.a.j(e10);
            return false;
        }
    }

    public final f t(f fVar, byte[] bArr) {
        String strG = w0.g(bArr, fVar.e());
        if (strG == null) {
            return null;
        }
        f fVar2 = new f(fVar);
        fVar2.m(strG);
        return fVar2;
    }

    public final byte[] u() {
        String strJ;
        byte[] bArrY = y();
        if (bArrY != null) {
            return bArrY;
        }
        try {
            w0.i(this.f12577a);
            byte[] bArrK = w0.k(UUID.randomUUID().toString().replace("-", ""), this.f12579c.z1());
            byte[] bArrE = w0.e(this.f12577a, bArrK);
            if (bArrK == null || bArrE == null || !Arrays.equals(bArrK, w0.d(this.f12577a, bArrE)) || (strJ = w0.j(bArrE)) == null || !z(strJ)) {
                return null;
            }
            return bArrK;
        } catch (Exception e10) {
            tc.a.j(e10);
            return null;
        }
    }

    public final int v(f fVar, String str, String str2) {
        if (str.equalsIgnoreCase(fVar.c())) {
            return 3;
        }
        return str2.equalsIgnoreCase(fVar.c()) ? 2 : 1;
    }

    public final void w() {
        a7.a.c().d(new Runnable() { // from class: t9.b
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f12573c.f12580d.f();
            }
        });
    }

    public final void x() {
        a7.a.c().d(new Runnable() { // from class: t9.a
            @Override // java.lang.Runnable
            public final void run() {
                d.r(this.f12572c);
            }
        });
    }

    public final byte[] y() {
        byte[] bArrD;
        String str = this.f12583g;
        if (str == null || str.isEmpty() || (bArrD = w0.d(this.f12577a, w0.l(this.f12583g))) == null || bArrD.length < 32) {
            return null;
        }
        return bArrD;
    }

    public final boolean z(String str) {
        if (this.f12579c.W2(str)) {
            this.f12583g = str;
            return true;
        }
        if (!this.f12579c.W2(this.f12583g)) {
            tc.a.i("Failed to restore password secret preference", new Object[0]);
        }
        return false;
    }
}
