package x8;

import com.tuyafeng.wormhole.AndroidBookmarkHtml;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class n {
    public static /* synthetic */ int a(m9.b bVar, m9.b bVar2) {
        int iCompareToIgnoreCase = bVar.b().compareToIgnoreCase(bVar2.b());
        return iCompareToIgnoreCase == 0 ? Integer.compare(bVar.d(), bVar2.d()) : iCompareToIgnoreCase;
    }

    public static List b(x.d dVar) {
        if (dVar == null || (((List) dVar.f14455a).isEmpty() && ((List) dVar.f14456b).isEmpty())) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        ArrayList arrayList2 = new ArrayList((Collection) dVar.f14455a);
        ArrayList<m9.b> arrayList3 = new ArrayList((Collection) dVar.f14456b);
        Collections.sort(arrayList3, new Comparator() { // from class: x8.m
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return n.a((m9.b) obj, (m9.b) obj2);
            }
        });
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(m9.a.r());
        int i10 = 0;
        for (int size = arrayList4.size(); i10 < size; size = arrayList4.size()) {
            m9.a aVar = (m9.a) arrayList4.get(i10);
            String str = (String) map.get(aVar.b());
            String str2 = str == null ? "" : str + "/";
            i10++;
            for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                m9.a aVar2 = (m9.a) arrayList2.get(size2);
                if (aVar.b().equals(aVar2.d())) {
                    arrayList4.add(i10, aVar2);
                    map.put(aVar2.b(), str2 + aVar2.e().replace("/", "\\/"));
                    arrayList2.remove(size2);
                }
            }
        }
        for (m9.b bVar : arrayList3) {
            l9.b bVar2 = new l9.b();
            bVar2.o(bVar.e());
            bVar2.q(bVar.g());
            bVar2.n(bVar.d());
            bVar2.l((String) map.get(bVar.b()));
            bVar2.k(bVar.a());
            bVar2.p(bVar.f());
            arrayList.add(bVar2);
        }
        return arrayList;
    }

    public static x.d c(List list) {
        long j10;
        long jA;
        if (list == null || list.isEmpty()) {
            List list2 = Collections.EMPTY_LIST;
            return x.d.a(list2, list2);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        HashMap map = new HashMap();
        map.put("", "");
        long jCurrentTimeMillis = (System.currentTimeMillis() / 1000) - ((long) list.size());
        Iterator it = list.iterator();
        int i10 = 0;
        int i11 = 0;
        while (it.hasNext()) {
            l9.b bVar = (l9.b) it.next();
            if (!d(bVar.g())) {
                m9.b bVar2 = new m9.b();
                bVar2.j(UUID.randomUUID().toString());
                bVar2.l(bVar.e());
                bVar2.n(bVar.g());
                bVar2.k(bVar.d());
                if (bVar.a() == 0) {
                    jA = jCurrentTimeMillis + 1;
                    j10 = jA;
                } else {
                    j10 = jCurrentTimeMillis;
                    jA = bVar.a();
                }
                bVar2.h(jA);
                bVar2.m(bVar.f() == 0 ? bVar2.a() : bVar.f());
                String str = (String) map.get(bVar.b() == null ? "" : bVar.b());
                if (str == null) {
                    String strB = bVar.b();
                    int i12 = 0;
                    while (i12 < strB.length()) {
                        int iIndexOf = strB.indexOf(47, i12);
                        while (iIndexOf > 0 && strB.charAt(iIndexOf - 1) == '\\') {
                            iIndexOf = strB.indexOf(47, iIndexOf + 1);
                        }
                        if (iIndexOf == -1) {
                            iIndexOf = strB.length();
                        }
                        String strSubstring = strB.substring(i10, iIndexOf);
                        if (map.containsKey(strSubstring)) {
                            i12 = iIndexOf + 1;
                        } else {
                            String strSubstring2 = strB.substring(i10, Math.max(i10, i12 - 1));
                            String strReplace = strB.substring(i12, iIndexOf).replace("\\/", "/");
                            String strB2 = (String) map.get(strSubstring2);
                            if (strB2 == null) {
                                strB2 = m9.a.r().b();
                            }
                            m9.a aVarJ = m9.a.j(UUID.randomUUID().toString(), strReplace, strB2);
                            i11++;
                            aVarJ.n(i11);
                            map.put(strSubstring, aVarJ.b());
                            arrayList.add(aVarJ);
                            i12 = iIndexOf + 1;
                            i10 = 0;
                        }
                    }
                    str = (String) map.get(strB);
                }
                if (str == null) {
                    str = "";
                }
                bVar2.i(str);
                arrayList2.add(bVar2);
                jCurrentTimeMillis = j10;
                i10 = 0;
            }
        }
        return x.d.a(arrayList, arrayList2);
    }

    public static boolean d(String str) {
        return !c6.u.f2105a.g(str);
    }

    public static void e(x.d dVar, List list, m9.a aVar) {
        String str;
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            m9.a aVar2 = (m9.a) it.next();
            if (aVar.b().equals(aVar2.d()) && aVar2.e() != null) {
                map.put(aVar2.e(), aVar2.b());
            }
        }
        if (map.isEmpty()) {
            return;
        }
        HashMap map2 = new HashMap();
        for (m9.a aVar3 : (List) dVar.f14455a) {
            if (aVar.b().equals(aVar3.d()) && aVar3.e() != null && (str = (String) map.get(aVar3.e())) != null) {
                map2.put(aVar3.b(), str);
            }
        }
        if (map2.isEmpty()) {
            return;
        }
        for (m9.b bVar : (List) dVar.f14456b) {
            String str2 = (String) map2.get(bVar.b());
            if (str2 != null) {
                bVar.i(str2);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (m9.a aVar4 : (List) dVar.f14455a) {
            String str3 = (String) map2.get(aVar4.b());
            String str4 = (String) map2.get(aVar4.d());
            if (str3 != null || str4 != null) {
                if (str3 != null) {
                    aVar4.m(str3);
                }
                if (str4 != null) {
                    aVar4.o(str4);
                }
                arrayList.add(aVar4);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            e(dVar, list, (m9.a) it2.next());
        }
    }

    public static x.d f(InputStream inputStream) {
        if (inputStream == null) {
            List list = Collections.EMPTY_LIST;
            return x.d.a(list, list);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (c6.r rVar : AndroidBookmarkHtml.f3781a.a(inputStream)) {
            if (rVar.g() == null) {
                arrayList.add(new m9.a(rVar.b(), rVar.e(), rVar.d(), rVar.c(), rVar.a(), rVar.f()));
            } else {
                arrayList2.add(new m9.b(rVar.b(), rVar.g(), rVar.e(), rVar.d(), rVar.c(), rVar.a(), rVar.f()));
            }
        }
        return x.d.a(arrayList, arrayList2);
    }

    public static int g(OutputStream outputStream, x.d dVar) {
        if (outputStream == null || dVar == null) {
            return -1;
        }
        ArrayList arrayList = new ArrayList(((List) dVar.f14455a).size() + ((List) dVar.f14456b).size());
        Iterator it = ((List) dVar.f14455a).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            m9.a aVar = (m9.a) it.next();
            arrayList.add(new c6.r(aVar.b(), aVar.d(), aVar.e() != null ? aVar.e() : "", null, aVar.c(), aVar.a(), aVar.f()));
        }
        for (m9.b bVar : (List) dVar.f14456b) {
            arrayList.add(new c6.r(bVar.c(), bVar.b(), bVar.e() == null ? "" : bVar.e(), bVar.g(), bVar.d(), bVar.a(), bVar.f()));
        }
        return AndroidBookmarkHtml.f3781a.b(outputStream, arrayList);
    }
}
