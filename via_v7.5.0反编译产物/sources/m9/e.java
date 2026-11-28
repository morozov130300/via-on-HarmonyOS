package m9;

import com.tuyafeng.support.utils.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import x8.n;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f7971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f7972b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7973c;

    public e(d dVar) {
        this.f7971a = dVar;
    }

    @Override // m9.c
    public int A(x.d dVar) {
        if (dVar == null) {
            return -1;
        }
        n.e(dVar, j(), a.r());
        int iX = this.f7971a.x((List) dVar.f14455a, (List) dVar.f14456b);
        if (iX > 0) {
            for (a aVar : (List) dVar.f14455a) {
                this.f7972b.put(aVar.b(), aVar);
            }
        }
        return iX;
    }

    public final List B(String str) {
        List listJ = j();
        if (str == null || listJ.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        a aVarE = e(str);
        if (aVarE == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVarE);
        int i10 = 0;
        for (int size = arrayList.size(); i10 < size; size = arrayList.size()) {
            a aVar = (a) arrayList.get(i10);
            i10++;
            for (int size2 = listJ.size() - 1; size2 >= 0; size2--) {
                a aVar2 = (a) listJ.get(size2);
                if (aVar2.d().equals(aVar.b())) {
                    arrayList.add(i10, aVar2);
                    listJ.remove(size2);
                }
            }
        }
        return arrayList;
    }

    @Override // m9.c
    public b a(String str) {
        if (str == null) {
            return null;
        }
        return this.f7971a.a(str);
    }

    @Override // m9.c
    public boolean b(String... strArr) {
        return strArr != null && strArr.length > 0 && this.f7971a.b(strArr);
    }

    @Override // m9.c
    public boolean c(String str) {
        return str != null && this.f7971a.c(str);
    }

    @Override // m9.c
    public boolean d(List list) {
        return list != null && list.size() > 0 && this.f7971a.d(list);
    }

    @Override // m9.c
    public a e(String str) {
        if (str == null) {
            return null;
        }
        a aVarE = (a) this.f7972b.get(str);
        if (aVarE == null && (aVarE = this.f7971a.e(str)) != null) {
            this.f7972b.put(str, aVarE);
        }
        return aVarE;
    }

    @Override // m9.c
    public boolean f(List list) {
        if (list == null || list.size() <= 0 || !this.f7971a.f(list)) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            this.f7972b.put(aVar.b(), aVar);
        }
        return true;
    }

    @Override // m9.c
    public int g(String str) {
        return this.f7971a.g(str);
    }

    @Override // m9.c
    public a h(String str) {
        a aVar = null;
        if (p.f(str)) {
            return null;
        }
        for (a aVar2 : this.f7972b.values()) {
            if (str.equalsIgnoreCase(aVar2.e())) {
                aVar = aVar2;
                break;
            }
        }
        if (aVar != null) {
            return aVar;
        }
        a aVarH = this.f7971a.h(str);
        if (aVarH != null) {
            this.f7972b.put(aVarH.b(), aVarH);
        }
        return aVarH;
    }

    @Override // m9.c
    public boolean i(b bVar) {
        return bVar != null && this.f7971a.i(bVar);
    }

    @Override // m9.c
    public List j() {
        if (this.f7973c) {
            return new ArrayList(this.f7972b.values());
        }
        this.f7973c = true;
        List<a> listJ = this.f7971a.j();
        for (a aVar : listJ) {
            this.f7972b.put(aVar.b(), aVar);
        }
        return listJ;
    }

    @Override // m9.c
    public boolean k(String str, b bVar) {
        return (str == null || bVar == null || !this.f7971a.k(str, bVar)) ? false : true;
    }

    @Override // m9.c
    public boolean l() {
        if (!this.f7971a.l()) {
            return false;
        }
        this.f7973c = true;
        this.f7972b.clear();
        return true;
    }

    @Override // m9.c
    public boolean m(String str, a aVar) {
        if (str == null || aVar == null || !this.f7971a.m(str, aVar)) {
            return false;
        }
        this.f7972b.put(str, aVar);
        return true;
    }

    @Override // m9.c
    public int n(String str) {
        if (str == null) {
            return 0;
        }
        return this.f7971a.n(str);
    }

    @Override // m9.c
    public List o(String str) {
        return str == null ? Collections.EMPTY_LIST : this.f7971a.o(str);
    }

    @Override // m9.c
    public boolean p(String... strArr) {
        if (strArr != null && strArr.length != 0) {
            HashSet hashSet = new HashSet();
            for (String str : strArr) {
                Iterator it = B(str).iterator();
                while (it.hasNext()) {
                    hashSet.add(((a) it.next()).b());
                }
            }
            String[] strArr2 = (String[]) hashSet.toArray(new String[0]);
            if (this.f7971a.p(strArr2)) {
                this.f7971a.B(strArr2);
                for (String str2 : strArr2) {
                    this.f7972b.remove(str2);
                }
                return true;
            }
        }
        return false;
    }

    @Override // m9.c
    public boolean q(a aVar) {
        if (aVar == null || !this.f7971a.q(aVar)) {
            return false;
        }
        this.f7972b.put(aVar.b(), aVar);
        return true;
    }

    @Override // m9.c
    public boolean r(String str) {
        return str != null && this.f7971a.r(str);
    }

    @Override // m9.c
    public b s(String str) {
        if (str == null) {
            return null;
        }
        return this.f7971a.s(str);
    }

    @Override // m9.c
    public List t(String str) {
        if (str == null) {
            return Collections.EMPTY_LIST;
        }
        if (!this.f7973c) {
            List<a> listT = this.f7971a.t(str);
            for (a aVar : listT) {
                this.f7972b.put(aVar.b(), aVar);
            }
            return listT;
        }
        ArrayList arrayList = new ArrayList();
        for (a aVar2 : this.f7972b.values()) {
            if (str.equals(aVar2.d())) {
                arrayList.add(aVar2);
            }
        }
        return arrayList;
    }

    @Override // m9.c
    public List u() {
        return this.f7971a.u();
    }

    @Override // m9.c
    public boolean v() {
        return this.f7971a.v();
    }

    @Override // m9.c
    public List w(String str, String str2, int i10) {
        if (str2 == null) {
            return Collections.EMPTY_LIST;
        }
        if (a.g(str2)) {
            return this.f7971a.z(str, null, i10);
        }
        List listB = B(str2);
        if (listB.size() <= 1) {
            return Collections.EMPTY_LIST;
        }
        String[] strArr = new String[listB.size()];
        int size = listB.size();
        for (int i11 = 0; i11 < size; i11++) {
            strArr[i11] = ((a) listB.get(i11)).b();
        }
        return this.f7971a.z(str, strArr, i10);
    }

    @Override // m9.c
    public boolean x(String str) {
        if (str == null) {
            return false;
        }
        if (!this.f7973c || this.f7972b.containsKey(str)) {
            return p(str);
        }
        return false;
    }

    @Override // m9.c
    public Map y(String... strArr) {
        Map mapW = this.f7971a.w(strArr);
        Map mapY = this.f7971a.y(strArr);
        if (mapW.isEmpty()) {
            return mapY;
        }
        if (!mapY.isEmpty()) {
            for (Map.Entry entry : mapY.entrySet()) {
                String str = (String) entry.getKey();
                Integer num = (Integer) mapW.get(str);
                mapW.put(str, Integer.valueOf(num == null ? ((Integer) entry.getValue()).intValue() : ((Integer) entry.getValue()).intValue() + num.intValue()));
            }
        }
        return mapW;
    }

    @Override // m9.c
    public List z(String str, String str2, int i10) {
        if (str2 == null) {
            return Collections.EMPTY_LIST;
        }
        if (a.g(str2)) {
            return this.f7971a.A(str, null, i10);
        }
        List listB = B(str2);
        if (listB.size() <= 0) {
            return Collections.EMPTY_LIST;
        }
        String[] strArr = new String[listB.size()];
        int size = listB.size();
        for (int i11 = 0; i11 < size; i11++) {
            strArr[i11] = ((a) listB.get(i11)).b();
        }
        return this.f7971a.A(str, strArr, i10);
    }
}
