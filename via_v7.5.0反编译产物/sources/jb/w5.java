package jb;

import androidx.lifecycle.LiveData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import mark.via.common.rx.AutoDisposeViewModel;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class w5 extends AutoDisposeViewModel {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final w9.a f7024f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final z9.d f7025g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final u9.l f7026h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final androidx.lifecycle.n f7027i = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.n f7028j = new androidx.lifecycle.n();

    public w5(w9.a aVar, z9.d dVar, u9.l lVar) {
        this.f7024f = aVar;
        this.f7025g = dVar;
        this.f7026h = lVar;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void l(String str, ga.c cVar) {
        String strA = kb.c.a(str);
        List listO = o();
        if (listO == null || strA == null || strA.isEmpty() || cVar == null) {
            return;
        }
        y9.a aVarH = this.f7025g.h(strA);
        aVarH.S(true);
        aVarH.e0(cVar.d());
        if (cVar.d() == -999) {
            aVarH.Q(cVar.a());
        }
        kb.b bVarD = kb.b.d(strA, cVar);
        bVarD.i(aVarH.c(null));
        listO.remove(bVarD);
        listO.add(bVarD);
        Collections.sort(listO);
        this.f7028j.m(listO);
        this.f7025g.k(strA, aVarH);
    }

    public List m() {
        return this.f7024f.z().b(1);
    }

    public ga.c n() {
        return (ga.c) this.f7027i.e();
    }

    public List o() {
        return (List) this.f7028j.e();
    }

    public LiveData p() {
        return this.f7028j;
    }

    public ga.c q(String str) {
        return r(str, n());
    }

    public ga.c r(String str, ga.c cVar) {
        if (str != null && !str.isEmpty()) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            List<kb.b> listO = o();
            if (listO != null && !listO.isEmpty()) {
                for (kb.b bVar : listO) {
                    if (lowerCase.equals(bVar.h())) {
                        return bVar.j();
                    }
                }
            }
        }
        return cVar;
    }

    public LiveData s() {
        return this.f7027i;
    }

    public void t(List list) {
        ArrayList<ga.c> arrayList = new ArrayList(list);
        arrayList.addAll(this.f7024f.z().b(1));
        int iO0 = this.f7026h.o0();
        for (ga.c cVar : arrayList) {
            if (cVar.d() == iO0) {
                this.f7027i.m(cVar);
                break;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str : this.f7025g.i()) {
            y9.b bVarE = this.f7025g.e(str);
            if (bVarE != null && bVarE.s() && bVarE.j() != -1000) {
                String strC = bVarE.c(null);
                if (bVarE.j() != -999) {
                    for (ga.c cVar2 : arrayList) {
                        if (cVar2.d() == bVarE.j()) {
                            kb.b bVarD = kb.b.d(str, cVar2);
                            bVarD.i(strC);
                            arrayList2.add(bVarD);
                            break;
                        }
                    }
                } else {
                    arrayList2.add(new kb.b(str, -999, strC, strC));
                }
            }
        }
        this.f7028j.m(arrayList2);
    }

    public void u(String str) {
        String strA = kb.c.a(str);
        List listO = o();
        if (listO == null || strA == null || strA.isEmpty() || !listO.remove(new kb.b(strA))) {
            return;
        }
        this.f7028j.m(listO);
        y9.a aVarH = this.f7025g.h(strA);
        aVarH.e0(-1000);
        if (aVarH.r()) {
            this.f7025g.b(strA);
        } else {
            this.f7025g.k(strA, aVarH);
        }
    }
}
