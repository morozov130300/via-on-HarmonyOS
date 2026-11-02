package m2;

import com.google.firebase.components.DependencyCycleException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class q {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final m2.c f8594a;

        /* renamed from: b, reason: collision with root package name */
        public final Set f8595b = new HashSet();

        /* renamed from: c, reason: collision with root package name */
        public final Set f8596c = new HashSet();

        public b(m2.c cVar) {
            this.f8594a = cVar;
        }

        public void a(b bVar) {
            this.f8595b.add(bVar);
        }

        public void b(b bVar) {
            this.f8596c.add(bVar);
        }

        public m2.c c() {
            return this.f8594a;
        }

        public Set d() {
            return this.f8595b;
        }

        public boolean e() {
            return this.f8595b.isEmpty();
        }

        public boolean f() {
            return this.f8596c.isEmpty();
        }

        public void g(b bVar) {
            this.f8596c.remove(bVar);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final b0 f8597a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f8598b;

        public c(b0 b0Var, boolean z10) {
            this.f8597a = b0Var;
            this.f8598b = z10;
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.f8597a.equals(this.f8597a) && cVar.f8598b == this.f8598b) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((this.f8597a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f8598b).hashCode();
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
            m2.c cVar = (m2.c) it.next();
            b bVar3 = new b(cVar);
            for (b0 b0Var : cVar.j()) {
                c cVar2 = new c(b0Var, !cVar.p());
                if (!map.containsKey(cVar2)) {
                    map.put(cVar2, new HashSet());
                }
                Set set2 = (Set) map.get(cVar2);
                if (!set2.isEmpty() && !cVar2.f8598b) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", b0Var));
                }
                set2.add(bVar3);
            }
        }
    }
}
