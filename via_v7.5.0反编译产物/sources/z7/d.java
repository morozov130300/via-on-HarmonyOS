package z7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    public static /* synthetic */ int a(m9.a aVar, m9.a aVar2) {
        int iX0 = la.s.j().X0();
        if (iX0 == 1) {
            return Integer.compare(aVar2.c(), aVar.c());
        }
        return (iX0 != 2 || aVar.e() == null || aVar2.e() == null) ? Integer.compare(aVar.c(), aVar2.c()) : x8.z1.a(aVar.e(), aVar2.e());
    }

    public static List b(List list, String str) {
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        arrayList.add(new a(m9.a.r(), 0, m9.a.g(str)));
        if (list != null && !list.isEmpty()) {
            Collections.sort(list, new Comparator() { // from class: z7.c
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return d.a((m9.a) obj, (m9.a) obj2);
                }
            });
            for (int size = arrayList.size(); i10 < size; size = arrayList.size()) {
                a aVar = (a) arrayList.get(i10);
                i10++;
                for (int size2 = list.size() - 1; size2 >= 0; size2--) {
                    m9.a aVar2 = (m9.a) list.get(size2);
                    if (aVar.a().b().equals(aVar2.d())) {
                        arrayList.add(i10, new a(aVar2, aVar.b() + 1, aVar2.b().equals(str)));
                        list.remove(size2);
                    }
                }
            }
        }
        return arrayList;
    }
}
