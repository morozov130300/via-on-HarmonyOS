package a1;

import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class k {
    public static ec.c a(List list) {
        TreeSet treeSet = new TreeSet();
        ec.c.b bVarD = ec.c.d();
        if (list == null) {
            return null;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            if (hVar != null && hVar.a() != null) {
                treeSet.addAll(hVar.a());
            }
        }
        if (treeSet.size() <= 0) {
            return null;
        }
        Iterator it2 = treeSet.iterator();
        while (it2.hasNext()) {
            bVarD.a((String) it2.next());
        }
        return bVarD.b();
    }
}
