package a1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a.C0002a f9a = new a.C0002a();

    @Override // a1.j
    public List a(Collection collection) {
        if (collection == null) {
            return null;
        }
        ArrayList<ec.a> arrayList = new ArrayList(collection);
        Collections.sort(arrayList, f9a);
        TreeSet treeSet = new TreeSet();
        int iC = -1;
        for (ec.a aVar : arrayList) {
            if (aVar.b() <= iC || aVar.c() <= iC) {
                treeSet.add(aVar);
            } else {
                iC = aVar.c();
            }
        }
        arrayList.removeAll(treeSet);
        return arrayList;
    }
}
