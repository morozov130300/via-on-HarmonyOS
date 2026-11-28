package ia;

import c6.a2;
import ha.h;
import ha.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import m9.c;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w9.a f6330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f6331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f6332c = null;

    public a(w9.a aVar, c cVar) {
        this.f6330a = aVar;
        this.f6331b = cVar;
    }

    @Override // ha.h
    public List a(String str, int i10, int i11) {
        if (i10 <= 0 || str == null || str.isEmpty() || (i11 & 15) == 0) {
            return null;
        }
        List listA = i.a((i11 & 4) == 4 ? d(str, i10) : null, (i11 & 1) == 1 ? c(this.f6330a.o(str, i10), 1) : null, (i11 & 2) == 2 ? b(this.f6331b.z(str, "", i10), 2) : null, (i11 & 8) == 8 ? c(this.f6330a.l(str, i10), 8) : null);
        if (listA != null && listA.size() > 1) {
            HashSet hashSet = new HashSet();
            Iterator it = listA.iterator();
            while (it.hasNext()) {
                String strE = ((ha.a) it.next()).e();
                if (strE != null && !strE.isEmpty()) {
                    if (hashSet.contains(strE)) {
                        it.remove();
                    } else {
                        hashSet.add(strE);
                    }
                }
            }
        }
        return listA;
    }

    public final List b(List list, int i10) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            m9.b bVar = (m9.b) it.next();
            arrayList.add(ha.a.f(bVar.g(), bVar.e(), i10));
        }
        return arrayList;
    }

    public final List c(List list, int i10) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            l9.b bVar = (l9.b) it.next();
            arrayList.add(ha.a.f(bVar.g(), bVar.e(), i10));
        }
        return arrayList;
    }

    public final List d(String str, int i10) {
        List list;
        if (i10 <= 0 || (list = this.f6332c) == null || list.isEmpty() || str == null || str.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        for (l9.b bVar : this.f6332c) {
            if (a2.f1958a.t(bVar.g()) && ((bVar.e() != null && bVar.e().contains(str)) || (str.length() > 4 && bVar.g().contains(str)))) {
                arrayList.add(ha.a.i(bVar.c(), bVar.g(), bVar.e()));
                i11++;
                if (i11 >= i10) {
                    break;
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public void e(List list) {
        this.f6332c = list;
    }
}
