package n2;

import com.google.firebase.components.DependencyCycleException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class q {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n2.c f10558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set f10559b = new HashSet();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Set f10560c = new HashSet();

        public b(n2.c cVar) {
            this.f10558a = cVar;
        }

        public void a(b bVar) {
            this.f10559b.add(bVar);
        }

        public void b(b bVar) {
            this.f10560c.add(bVar);
        }

        public n2.c c() {
            return this.f10558a;
        }

        public Set d() {
            return this.f10559b;
        }

        public boolean e() {
            return this.f10559b.isEmpty();
        }

        public boolean f() {
            return this.f10560c.isEmpty();
        }

        public void g(b bVar) {
            this.f10560c.remove(bVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b0 f10561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f10562b;

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.f10561a.equals(this.f10561a) && cVar.f10562b == this.f10562b) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((this.f10561a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f10562b).hashCode();
        }

        public c(b0 b0Var, boolean z10) {
            this.f10561a = b0Var;
            this.f10562b = z10;
        }
    }

    public static void a(List list) {
        Set<b> setC = c(list);
        Set setB = b(setC);
        int i10 = 0;
        while (!setB.isEmpty()) {
            b bVar = (b) setB.iterator().next();
            setB.remove(bVar);
            i10++;
            for (b bVar2 : bVar.d()) {
                bVar2.g(bVar);
                if (bVar2.f()) {
                    setB.add(bVar2);
                }
            }
        }
        if (i10 == list.size()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (b bVar3 : setC) {
            if (!bVar3.f() && !bVar3.e()) {
                arrayList.add(bVar3.c());
            }
        }
        throw new DependencyCycleException(arrayList);
    }

    public static Set b(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.f()) {
                hashSet.add(bVar);
            }
        }
        return hashSet;
    }

    public static Set c(List list) {
        Set<b> set;
        HashMap map = new HashMap(list.size());
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                Iterator it2 = map.values().iterator();
                while (it2.hasNext()) {
                    for (b bVar : (Set) it2.next()) {
                        for (r rVar : bVar.c().g()) {
                            if (rVar.e() && (set = (Set) map.get(new c(rVar.c(), rVar.g()))) != null) {
                                for (b bVar2 : set) {
                                    bVar.a(bVar2);
                                    bVar2.b(bVar);
                                }
                            }
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                Iterator it3 = map.values().iterator();
                while (it3.hasNext()) {
                    hashSet.addAll((Set) it3.next());
                }
                return hashSet;
            }
            n2.c cVar = (n2.c) it.next();
            b bVar3 = new b(cVar);
            for (b0 b0Var : cVar.j()) {
                c cVar2 = new c(b0Var, !cVar.p());
                if (!map.containsKey(cVar2)) {
                    map.put(cVar2, new HashSet());
                }
                Set set2 = (Set) map.get(cVar2);
                if (!set2.isEmpty() && !cVar2.f10562b) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", b0Var));
                }
                set2.add(bVar3);
            }
        }
    }
}
