package a1;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0002a f8a = new C0002a();

    /* JADX INFO: renamed from: a1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class C0002a implements Comparator {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ec.a aVar, ec.a aVar2) {
            if (aVar.b() == aVar2.b()) {
                if (aVar.size() < aVar2.size()) {
                    return 1;
                }
                return aVar.size() == aVar2.size() ? 0 : -1;
            }
            if (aVar.b() < aVar2.b()) {
                return -1;
            }
            return aVar.b() == aVar2.b() ? 0 : 1;
        }
    }

    public static String[] a(String str, List list) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                h hVar = (h) it.next();
                if (hVar != null && hVar.a() != null && hVar.a().contains(str)) {
                    return hVar.b(str);
                }
            }
        }
        throw new IllegalArgumentException("No pinyin dict contains word: " + str);
    }

    public static String b(String str, ec.c cVar, List list, String str2, j jVar) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (cVar == null || jVar == null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i10 = 0; i10 < str.length(); i10++) {
                stringBuffer.append(c.f(str.charAt(i10)));
                if (i10 != str.length() - 1) {
                    stringBuffer.append(str2);
                }
            }
            return stringBuffer.toString();
        }
        List listA = jVar.a(cVar.h(str));
        Collections.sort(listA, f8a);
        StringBuffer stringBuffer2 = new StringBuffer();
        int size = 0;
        int i11 = 0;
        while (size < str.length()) {
            if (i11 >= listA.size() || size != ((ec.a) listA.get(i11)).b()) {
                stringBuffer2.append(c.f(str.charAt(size)));
                size++;
            } else {
                String[] strArrA = a(((ec.a) listA.get(i11)).a(), list);
                for (int i12 = 0; i12 < strArrA.length; i12++) {
                    stringBuffer2.append(strArrA[i12].toUpperCase());
                    if (i12 != strArrA.length - 1) {
                        stringBuffer2.append(str2);
                    }
                }
                size += ((ec.a) listA.get(i11)).size();
                i11++;
            }
            if (size != str.length()) {
                stringBuffer2.append(str2);
            }
        }
        return stringBuffer2.toString();
    }
}
