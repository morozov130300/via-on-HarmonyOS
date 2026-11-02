package jb;

import androidx.lifecycle.LiveData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mark.via.common.rx.AutoDisposeViewModel;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class w5 extends AutoDisposeViewModel {

    /* renamed from: f, reason: collision with root package name */
    public final y9.a f7914f;

    /* renamed from: g, reason: collision with root package name */
    public final ca.d f7915g;

    /* renamed from: h, reason: collision with root package name */
    public final w9.l f7916h;

    /* renamed from: i, reason: collision with root package name */
    public final androidx.lifecycle.l f7917i = new androidx.lifecycle.l();

    /* renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.l f7918j = new androidx.lifecycle.l();

    public w5(y9.a aVar, ca.d dVar, w9.l lVar) {
        this.f7914f = aVar;
        this.f7915g = dVar;
        this.f7916h = lVar;
    }

    public void l(String str, ja.c cVar) {
        String strA = kb.c.a(str);
        List listO = o();
        if (listO == null || strA == null || strA.isEmpty() || cVar == null) {
            return;
        }
        kb.b bVarB = kb.b.b(strA, cVar);
        String strA2 = cVar.d() == -999 ? cVar.a() : null;
        int iIndexOf = listO.indexOf(bVarB);
        if (iIndexOf >= 0) {
            if (cVar.d() != -999) {
                strA2 = ((kb.b) listO.get(iIndexOf)).c();
            }
            listO.remove(iIndexOf);
        }
        bVarB.g(strA2);
        listO.add(bVarB);
        Collections.sort(listO);
        this.f7918j.m(listO);
        ba.a aVarI = this.f7915g.i(strA);
        aVarI.S(true);
        aVarI.e0(cVar.d());
        aVarI.Q(cVar.a());
        this.f7915g.g(strA, aVarI);
    }

    public List m() {
        return this.f7914f.z().c(1);
    }

    public ja.c n() {
        return (ja.c) this.f7917i.e();
    }

    public List o() {
        return (List) this.f7918j.e();
    }

    public LiveData p() {
        return this.f7918j;
    }

    public ja.c q(String str) {
        return r(str, n());
    }

    public ja.c r(String str, ja.c cVar) {
        if (str != null && !str.isEmpty()) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            List<kb.b> listO = o();
            if (listO != null && !listO.isEmpty()) {
                for (kb.b bVar : listO) {
                    if (lowerCase.equals(bVar.f())) {
                        return bVar.h();
                    }
                }
            }
        }
        return cVar;
    }

    public LiveData s() {
        return this.f7917i;
    }

    public void t(List list) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.addAll(this.f7914f.z().c(1));
        int iL0 = this.f7916h.l0();
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ja.c cVar = (ja.c) it.next();
            if (cVar.d() == iL0) {
                this.f7917i.m(cVar);
                break;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str : this.f7915g.j()) {
            ba.b bVarE = this.f7915g.e(str);
            if (bVarE != null && bVarE.s() && bVarE.j() != -1000) {
                String strC = bVarE.c(null);
                if (bVarE.j() == -999) {
                    arrayList2.add(new kb.b(str, -999, strC, strC));
                } else {
                    Iterator it2 = arrayList.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            ja.c cVar2 = (ja.c) it2.next();
                            if (cVar2.d() == bVarE.j()) {
                                kb.b bVarB = kb.b.b(str, cVar2);
                                bVarB.g(strC);
                                arrayList2.add(bVarB);
                                break;
                            }
                        }
                    }
                }
            }
        }
        this.f7918j.m(arrayList2);
    }

    public void u(String str) {
        String strA = kb.c.a(str);
        List listO = o();
        if (listO == null || strA == null || strA.isEmpty() || !listO.remove(new kb.b(strA))) {
            return;
        }
        this.f7918j.m(listO);
        ba.a aVarI = this.f7915g.i(strA);
        aVarI.e0(-1000);
        if (aVarI.r()) {
            this.f7915g.b(strA);
        } else {
            this.f7915g.g(strA, aVarI);
        }
    }
}
