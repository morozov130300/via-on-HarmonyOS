package v9;

import i6.i0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import w9.l;
import z8.w0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d implements g {

    /* renamed from: a, reason: collision with root package name */
    public final ya.e f13068a;

    /* renamed from: b, reason: collision with root package name */
    public final h f13069b;

    /* renamed from: c, reason: collision with root package name */
    public final l f13070c;

    /* renamed from: d, reason: collision with root package name */
    public final j f13071d;

    /* renamed from: e, reason: collision with root package name */
    public final CountDownLatch f13072e = new CountDownLatch(1);

    /* renamed from: f, reason: collision with root package name */
    public byte[] f13073f;

    public d(ya.e eVar, l lVar, h hVar, j jVar) {
        this.f13068a = eVar;
        this.f13070c = lVar;
        this.f13069b = hVar;
        this.f13071d = jVar;
        v();
        u();
    }

    public static /* synthetic */ int p(d dVar, String str, String str2, f fVar, f fVar2) {
        int iT = dVar.t(fVar, str, str2);
        int iT2 = dVar.t(fVar2, str, str2);
        if (iT2 > iT) {
            return 1;
        }
        return (iT2 >= iT && fVar.a() >= fVar2.a()) ? 1 : -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void q(d dVar, byte[] bArr, boolean z10) {
        dVar.getClass();
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    byte[] bArrD = w0.d(dVar.f13068a, bArr);
                    if ("Hello".equals(w0.b(bArrD, w0.g(bArrD, "Hello")))) {
                        pc.a.a("Encrypt passed", new Object[0]);
                        dVar.f13073f = bArr;
                    } else {
                        if (!z10) {
                            pc.a.a("Init key pair", new Object[0]);
                            w0.l(dVar.f13068a);
                        }
                        byte[] bArrE = w0.e(dVar.f13068a, w0.j(UUID.randomUUID().toString().replace("-", ""), dVar.f13070c.y1()));
                        if (bArrE == null || bArrE.length == 0) {
                            pc.a.h("Failed to generate password secret", new Object[0]);
                        } else {
                            dVar.f13070c.T2(w0.i(bArrE));
                            dVar.f13073f = bArrE;
                            pc.a.a("Generate a new secret", new Object[0]);
                        }
                    }
                }
            } finally {
                dVar.f13072e.countDown();
            }
        }
    }

    @Override // v9.g
    public boolean a(String str) {
        return this.f13069b.a(str);
    }

    @Override // v9.g
    public boolean b(String str, f fVar) {
        if (str == null || str.isEmpty() || fVar == null) {
            return false;
        }
        if (fVar.e() != null) {
            fVar.m(w0.g(s(), fVar.e()));
        }
        return this.f13069b.l(str, fVar);
    }

    @Override // v9.g
    public void c(String str, boolean z10) {
        if (this.f13071d.g(str, z10)) {
            this.f13071d.b();
        }
    }

    @Override // v9.g
    public List d(String str) {
        return this.f13069b.k(str);
    }

    @Override // v9.g
    public List e(String str) {
        List listB;
        i0 i0Var = i0.f7006a;
        final String strE = i0Var.e(str);
        if (strE.isEmpty()) {
            return new ArrayList();
        }
        final String strB = i0Var.b(str);
        if (strB.equals(strE)) {
            listB = this.f13069b.b(new String[]{strE, '.' + strE});
        } else {
            listB = this.f13069b.b(new String[]{strE, strB, '.' + strB});
        }
        Collections.sort(listB, new Comparator() { // from class: v9.c
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return d.p(this.f13065e, strE, strB, (f) obj, (f) obj2);
            }
        });
        return listB;
    }

    @Override // v9.g
    public f f(String str) {
        f fVarH = this.f13069b.h(str);
        if (fVarH != null && fVarH.e() != null) {
            fVarH.m(w0.b(s(), fVarH.e()));
        }
        return fVarH;
    }

    @Override // v9.g
    public List g() {
        return this.f13069b.f();
    }

    @Override // v9.g
    public f h(String str) {
        return this.f13069b.h(str);
    }

    @Override // v9.g
    public boolean i(List list) throws InterruptedException {
        if (list == null || list.isEmpty()) {
            return false;
        }
        byte[] bArrS = s();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            fVar.m(w0.g(bArrS, fVar.e()));
        }
        return this.f13069b.j(list);
    }

    @Override // v9.g
    public boolean j() {
        return this.f13069b.i() <= 0;
    }

    @Override // v9.g
    public boolean k(f fVar) {
        if (fVar == null) {
            return false;
        }
        if (fVar.e() != null) {
            fVar.m(w0.g(s(), fVar.e()));
        }
        return this.f13069b.g(fVar);
    }

    @Override // v9.g
    public List l() {
        return this.f13071d.d();
    }

    @Override // v9.g
    public String m(String str, String str2) {
        return this.f13069b.d(str, str2);
    }

    @Override // v9.g
    public List n() throws InterruptedException {
        List<f> listF = this.f13069b.f();
        if (listF != null && !listF.isEmpty()) {
            byte[] bArrS = s();
            for (f fVar : listF) {
                if (fVar.e() != null) {
                    fVar.m(w0.b(bArrS, fVar.e()));
                }
            }
        }
        return listF;
    }

    @Override // v9.g
    public boolean o(String str) {
        return this.f13071d.e(str, this.f13070c.v().q());
    }

    public final byte[] s() throws InterruptedException {
        try {
            this.f13072e.await();
            return w0.d(this.f13068a, this.f13073f);
        } catch (InterruptedException e10) {
            Thread.currentThread().interrupt();
            pc.a.i(e10);
            return null;
        }
    }

    public final int t(f fVar, String str, String str2) {
        if (str.equalsIgnoreCase(fVar.c())) {
            return 3;
        }
        return str2.equalsIgnoreCase(fVar.c()) ? 2 : 1;
    }

    public final void u() {
        g7.a.c().d(new Runnable() { // from class: v9.b
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f13064e.f13071d.f();
            }
        });
    }

    public final void v() {
        String strS2 = this.f13070c.s2();
        final boolean zM = w0.m(this.f13068a);
        final byte[] bArrK = (strS2 == null || strS2.isEmpty() || !zM) ? null : w0.k(strS2);
        g7.a.c().d(new Runnable() { // from class: v9.a
            @Override // java.lang.Runnable
            public final void run() {
                d.q(this.f13061e, bArrK, zM);
            }
        });
    }
}
