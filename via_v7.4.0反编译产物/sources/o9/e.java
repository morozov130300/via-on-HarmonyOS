package o9;

import g6.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e implements c {

    /* renamed from: a, reason: collision with root package name */
    public final d f10483a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f10484b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public boolean f10485c;

    public e(d dVar) {
        this.f10483a = dVar;
    }

    @Override // o9.c
    public List A(String str, String str2, int i10) {
        if (str2 == null) {
            return Collections.EMPTY_LIST;
        }
        if (a.g(str2)) {
            return this.f10483a.A(str, null, i10);
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
        return this.f10483a.A(str, strArr, i10);
    }

    public final List B(String str) {
        List listK = k();
        if (str == null || listK.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        a aVarF = f(str);
        if (aVarF == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVarF);
        int i10 = 0;
        for (int size = arrayList.size(); i10 < size; size = arrayList.size()) {
            a aVar = (a) arrayList.get(i10);
            i10++;
            for (int size2 = listK.size() - 1; size2 >= 0; size2--) {
                a aVar2 = (a) listK.get(size2);
                if (aVar2.d().equals(aVar.b())) {
                    arrayList.add(i10, aVar2);
                    listK.remove(size2);
                }
            }
        }
        return arrayList;
    }

    @Override // o9.c
    public b a(String str) {
        if (str == null) {
            return null;
        }
        return this.f10483a.a(str);
    }

    @Override // o9.c
    public boolean b(String str, b bVar) {
        return (str == null || bVar == null || !this.f10483a.b(str, bVar)) ? false : true;
    }

    @Override // o9.c
    public boolean c(String... strArr) {
        return strArr != null && strArr.length > 0 && this.f10483a.c(strArr);
    }

    @Override // o9.c
    public boolean d(String str) {
        return str != null && this.f10483a.d(str);
    }

    @Override // o9.c
    public boolean e(List list) {
        return list != null && list.size() > 0 && this.f10483a.e(list);
    }

    @Override // o9.c
    public a f(String str) {
        if (str == null) {
            return null;
        }
        a aVarF = (a) this.f10484b.get(str);
        if (aVarF == null && (aVarF = this.f10483a.f(str)) != null) {
            this.f10484b.put(str, aVarF);
        }
        return aVarF;
    }

    @Override // o9.c
    public boolean g(a aVar) {
        if (aVar == null || !this.f10483a.g(aVar)) {
            return false;
        }
        this.f10484b.put(aVar.b(), aVar);
        return true;
    }

    @Override // o9.c
    public boolean h(List list) {
        if (list == null || list.size() <= 0 || !this.f10483a.h(list)) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            this.f10484b.put(aVar.b(), aVar);
        }
        return true;
    }

    @Override // o9.c
    public int i(String str) {
        return this.f10483a.i(str);
    }

    @Override // o9.c
    public a j(String str) {
        a aVar = null;
        if (p.f(str)) {
            return null;
        }
        Iterator it = this.f10484b.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a aVar2 = (a) it.next();
            if (str.equalsIgnoreCase(aVar2.e())) {
                aVar = aVar2;
                break;
            }
        }
        if (aVar != null) {
            return aVar;
        }
        a aVarJ = this.f10483a.j(str);
        if (aVarJ != null) {
            this.f10484b.put(aVarJ.b(), aVarJ);
        }
        return aVarJ;
    }

    @Override // o9.c
    public List k() {
        if (this.f10485c) {
            return new ArrayList(this.f10484b.values());
        }
        this.f10485c = true;
        List<a> listK = this.f10483a.k();
        for (a aVar : listK) {
            this.f10484b.put(aVar.b(), aVar);
        }
        return listK;
    }

    @Override // o9.c
    public boolean l() {
        if (!this.f10483a.l()) {
            return false;
        }
        this.f10485c = true;
        this.f10484b.clear();
        return true;
    }

    @Override // o9.c
    public int m(String str) {
        if (str == null) {
            return 0;
        }
        return this.f10483a.m(str);
    }

    @Override // o9.c
    public List n(String str) {
        return str == null ? Collections.EMPTY_LIST : this.f10483a.n(str);
    }

    @Override // o9.c
    public boolean o(b bVar) {
        return bVar != null && this.f10483a.o(bVar);
    }

    @Override // o9.c
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
            if (this.f10483a.p(strArr2)) {
                this.f10483a.B(strArr2);
                for (String str2 : strArr2) {
                    this.f10484b.remove(str2);
                }
                return true;
            }
        }
        return false;
    }

    @Override // o9.c
    public boolean q(String str) {
        return str != null && this.f10483a.q(str);
    }

    @Override // o9.c
    public b r(String str) {
        if (str == null) {
            return null;
        }
        return this.f10483a.r(str);
    }

    @Override // o9.c
    public List s(String str) {
        if (str == null) {
            return Collections.EMPTY_LIST;
        }
        if (!this.f10485c) {
            List<a> listS = this.f10483a.s(str);
            for (a aVar : listS) {
                this.f10484b.put(aVar.b(), aVar);
            }
            return listS;
        }
        ArrayList arrayList = new ArrayList();
        for (a aVar2 : this.f10484b.values()) {
            if (str.equals(aVar2.d())) {
                arrayList.add(aVar2);
            }
        }
        return arrayList;
    }

    @Override // o9.c
    public boolean t(String str, a aVar) {
        if (str == null || aVar == null || !this.f10483a.t(str, aVar)) {
            return false;
        }
        this.f10484b.put(str, aVar);
        return true;
    }

    @Override // o9.c
    public List u() {
        return this.f10483a.u();
    }

    @Override // o9.c
    public boolean v() {
        return this.f10483a.v();
    }

    @Override // o9.c
    public List w(String str, String str2, int i10) {
        if (str2 == null) {
            return Collections.EMPTY_LIST;
        }
        if (a.g(str2)) {
            return this.f10483a.z(str, null, i10);
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
        return this.f10483a.z(str, strArr, i10);
    }

    @Override // o9.c
    public boolean x(String str) {
        if (str == null) {
            return false;
        }
        if (!this.f10485c || this.f10484b.containsKey(str)) {
            return p(str);
        }
        return false;
    }

    @Override // o9.c
    public Map y(String... strArr) {
        Map mapW = this.f10483a.w(strArr);
        Map mapY = this.f10483a.y(strArr);
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

    @Override // o9.c
    public int z(w.d dVar) {
        if (dVar == null) {
            return -1;
        }
        z8.p.p(dVar, k(), a.r());
        int iX = this.f10483a.x((List) dVar.f13207a, (List) dVar.f13208b);
        if (iX > 0) {
            for (a aVar : (List) dVar.f13207a) {
                this.f10484b.put(aVar.b(), aVar);
            }
        }
        return iX;
    }
}
