package dc;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import org.ahocorasick.interval.IntervalNode;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IntervalNode f4053a;

    public b(List list) {
        this.f4053a = null;
        this.f4053a = new IntervalNode(list);
    }

    public List a(c cVar) {
        return this.f4053a.g(cVar);
    }

    public List b(List list) {
        Collections.sort(list, new e());
        TreeSet treeSet = new TreeSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (!treeSet.contains(cVar)) {
                treeSet.addAll(a(cVar));
            }
        }
        Iterator it2 = treeSet.iterator();
        while (it2.hasNext()) {
            list.remove((c) it2.next());
        }
        Collections.sort(list, new d());
        return list;
    }
}
