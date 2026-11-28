package kb;

import android.util.SparseArray;
import i8.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray f7268a = new SparseArray();

    public boolean a(String str, int i10) {
        List list;
        String strC = c(str);
        if (strC == null || strC.isEmpty()) {
            return false;
        }
        int size = this.f7268a.size();
        for (int i11 = 0; i11 < size; i11++) {
            int iKeyAt = this.f7268a.keyAt(i11);
            if (iKeyAt != i10 && (list = (List) this.f7268a.get(iKeyAt)) != null) {
                list.remove(strC);
            }
        }
        List arrayList = (List) this.f7268a.get(i10);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.f7268a.put(i10, arrayList);
        }
        arrayList.add(strC);
        g(arrayList);
        return true;
    }

    public boolean b(List list, int i10) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            list.set(i11, c((String) list.get(i11)));
        }
        List list2 = (List) this.f7268a.get(i10);
        if (list2 == null || list2.isEmpty()) {
            g(list);
            this.f7268a.put(i10, list);
            return true;
        }
        HashSet hashSet = new HashSet(list2);
        hashSet.addAll(list);
        if (hashSet.size() == list2.size()) {
            return false;
        }
        ArrayList arrayList = new ArrayList(hashSet);
        g(arrayList);
        this.f7268a.put(i10, arrayList);
        return true;
    }

    public final String c(String str) {
        return c.a(str);
    }

    public int d(String str, int i10) {
        String strC = c(str);
        if (strC != null && !strC.isEmpty()) {
            int size = this.f7268a.size();
            for (int i11 = 0; i11 < size; i11++) {
                int iKeyAt = this.f7268a.keyAt(i11);
                List list = (List) this.f7268a.get(iKeyAt);
                if (list != null && list.contains(strC)) {
                    return iKeyAt;
                }
            }
        }
        return i10;
    }

    public List e(int i10) {
        List list = (List) this.f7268a.get(i10);
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public boolean f(String str) {
        String strC;
        String strC2 = c(str);
        if (strC2 != null && !strC2.isEmpty() && (strC = c(strC2)) != null && !strC.isEmpty()) {
            int size = this.f7268a.size();
            int i10 = 0;
            for (int i11 = 0; i11 < size; i11++) {
                List list = (List) this.f7268a.get(this.f7268a.keyAt(i11));
                if (list != null && list.remove(strC)) {
                    i10++;
                }
            }
            if (i10 > 0) {
                return true;
            }
        }
        return false;
    }

    public final void g(List list) {
        Collections.sort(list, new p());
    }
}
