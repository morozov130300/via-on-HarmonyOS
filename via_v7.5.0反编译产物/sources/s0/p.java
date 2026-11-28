package s0;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class p {
    public static Map a(r0.g gVar) {
        HashMap map = new HashMap();
        map.put("BRAND_VERSION_LIST", b(gVar.d()));
        map.put("FULL_VERSION", gVar.f());
        map.put("PLATFORM", gVar.h());
        map.put("PLATFORM_VERSION", gVar.i());
        map.put("ARCHITECTURE", gVar.b());
        map.put("MODEL", gVar.g());
        map.put("MOBILE", Boolean.valueOf(gVar.j()));
        map.put("BITNESS", Integer.valueOf(gVar.c()));
        map.put("WOW64", Boolean.valueOf(gVar.k()));
        if (v.f12158d0.d()) {
            map.put("FORM_FACTORS", c(gVar.e()));
        }
        return map;
    }

    public static String[][] b(List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        String[][] strArr = (String[][]) Array.newInstance((Class<?>) String.class, list.size(), 3);
        for (int i10 = 0; i10 < list.size(); i10++) {
            strArr[i10][0] = ((r0.g.b) list.get(i10)).a();
            strArr[i10][1] = ((r0.g.b) list.get(i10)).c();
            strArr[i10][2] = ((r0.g.b) list.get(i10)).b();
        }
        return strArr;
    }

    public static String[] c(List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        String[] strArr = new String[list.size()];
        for (int i10 = 0; i10 < list.size(); i10++) {
            strArr[i10] = (String) list.get(i10);
        }
        return strArr;
    }

    public static r0.g d(Map map) {
        r0.g.c cVar = new r0.g.c();
        Object obj = map.get("BRAND_VERSION_LIST");
        if (obj != null) {
            ArrayList arrayList = new ArrayList();
            for (String[] strArr : (String[][]) obj) {
                arrayList.add(new r0.g.b.a().b(strArr[0]).d(strArr[1]).c(strArr[2]).a());
            }
            cVar.d(arrayList);
        }
        String str = (String) map.get("FULL_VERSION");
        if (str != null) {
            cVar.f(str);
        }
        String str2 = (String) map.get("PLATFORM");
        if (str2 != null) {
            cVar.i(str2);
        }
        String str3 = (String) map.get("PLATFORM_VERSION");
        if (str3 != null) {
            cVar.j(str3);
        }
        String str4 = (String) map.get("ARCHITECTURE");
        if (str4 != null) {
            cVar.b(str4);
        }
        String str5 = (String) map.get("MODEL");
        if (str5 != null) {
            cVar.h(str5);
        }
        Boolean bool = (Boolean) map.get("MOBILE");
        if (bool != null) {
            cVar.g(bool.booleanValue());
        }
        Integer num = (Integer) map.get("BITNESS");
        if (num != null) {
            cVar.c(num.intValue());
        }
        Boolean bool2 = (Boolean) map.get("WOW64");
        if (bool2 != null) {
            cVar.k(bool2.booleanValue());
        }
        String[] strArr2 = (String[]) map.get("FORM_FACTORS");
        if (strArr2 != null) {
            ArrayList arrayList2 = new ArrayList();
            for (String str6 : strArr2) {
                arrayList2.add(str6);
            }
            cVar.e(arrayList2);
        }
        return cVar.a();
    }
}
