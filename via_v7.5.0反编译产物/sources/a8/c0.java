package a8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f131a = Collections.EMPTY_LIST;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f132b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f133c = new HashSet();

    public static List b(List list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            m9.a aVar = (m9.a) it.next();
            arrayList.add(new t0(aVar, 0, aVar.b().equals(str), false));
        }
        return arrayList;
    }

    public void a(String str) {
        m9.a aVar = (m9.a) this.f132b.get(str);
        HashSet hashSet = new HashSet();
        while (aVar != null && !m9.a.g(aVar.b()) && hashSet.add(aVar.b())) {
            this.f133c.remove(aVar.d());
            aVar = (m9.a) this.f132b.get(aVar.d());
        }
    }

    public void c(List list) {
        this.f131a = new ArrayList(list);
        int i10 = 0;
        while (i10 < list.size()) {
            z7.a aVar = (z7.a) list.get(i10);
            String strB = aVar.a().b();
            i10++;
            boolean z10 = i10 < list.size() && ((z7.a) list.get(i10)).b() > aVar.b();
            if (!this.f132b.containsKey(strB) && !z10) {
                this.f133c.add(strB);
            }
        }
        this.f132b.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            m9.a aVarA = ((z7.a) it.next()).a();
            this.f132b.put(aVarA.b(), aVarA);
        }
        this.f133c.retainAll(this.f132b.keySet());
    }

    public boolean d(String str) {
        if (!this.f132b.containsKey(str)) {
            return false;
        }
        if (this.f133c.remove(str)) {
            return true;
        }
        int iB = -1;
        for (z7.a aVar : this.f131a) {
            if (iB >= 0) {
                if (aVar.b() <= iB) {
                    break;
                }
                this.f133c.add(aVar.a().b());
            } else if (str.equals(aVar.a().b())) {
                iB = aVar.b();
                this.f133c.add(str);
            }
        }
        return true;
    }

    public List e(String str) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            int iB = -1;
            for (z7.a aVar : this.f131a) {
                m9.a aVarA = aVar.a();
                if (iB < 0 || aVar.b() <= iB) {
                    boolean zContains = this.f133c.contains(aVarA.b());
                    arrayList.add(new t0(aVarA, aVar.b(), aVarA.b().equals(str), !zContains));
                    if (zContains) {
                        iB = aVar.b();
                    }
                }
            }
            return arrayList;
        }
    }
}
