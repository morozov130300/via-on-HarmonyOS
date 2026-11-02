package la;

import i6.i0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import ka.h;
import ka.i;
import o9.c;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a implements h {

    /* renamed from: a, reason: collision with root package name */
    public final y9.a f8462a;

    /* renamed from: b, reason: collision with root package name */
    public final c f8463b;

    /* renamed from: c, reason: collision with root package name */
    public List f8464c = null;

    public a(y9.a aVar, c cVar) {
        this.f8462a = aVar;
        this.f8463b = cVar;
    }

    @Override // ka.h
    public List a(String str, int i10, int i11) {
        if (i10 <= 0 || str == null || str.isEmpty() || (i11 & 15) == 0) {
            return null;
        }
        List listA = i.a((i11 & 4) == 4 ? d(str, i10) : null, (i11 & 1) == 1 ? c(this.f8462a.o(str, i10), 1) : null, (i11 & 2) == 2 ? b(this.f8463b.A(str, "", i10), 2) : null, (i11 & 8) == 8 ? c(this.f8462a.l(str, i10), 8) : null);
        if (listA != null && listA.size() > 1) {
            HashSet hashSet = new HashSet();
            Iterator it = listA.iterator();
            while (it.hasNext()) {
                String strE = ((ka.a) it.next()).e();
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
            o9.b bVar = (o9.b) it.next();
            arrayList.add(ka.a.f(bVar.g(), bVar.e(), i10));
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
            n9.b bVar = (n9.b) it.next();
            arrayList.add(ka.a.f(bVar.g(), bVar.e(), i10));
        }
        return arrayList;
    }

    public final List d(String str, int i10) {
        List list;
        if (i10 <= 0 || (list = this.f8464c) == null || list.isEmpty() || str == null || str.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        for (n9.b bVar : this.f8464c) {
            if (i0.f7006a.s(bVar.g()) && ((bVar.e() != null && bVar.e().contains(str)) || (str.length() > 4 && bVar.g().contains(str)))) {
                arrayList.add(ka.a.i(bVar.c(), bVar.g(), bVar.e()));
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
        this.f8464c = list;
    }
}
