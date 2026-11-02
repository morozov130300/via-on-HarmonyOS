package r0;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import q0.d;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class m {
    public static Map a(q0.d dVar) {
        HashMap map = new HashMap();
        map.put("BRAND_VERSION_LIST", b(dVar.c()));
        map.put("FULL_VERSION", dVar.d());
        map.put("PLATFORM", dVar.f());
        map.put("PLATFORM_VERSION", dVar.g());
        map.put("ARCHITECTURE", dVar.a());
        map.put("MODEL", dVar.e());
        map.put("MOBILE", Boolean.valueOf(dVar.h()));
        map.put("BITNESS", Integer.valueOf(dVar.b()));
        map.put("WOW64", Boolean.valueOf(dVar.i()));
        return map;
    }

    public static String[][] b(List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        String[][] strArr = (String[][]) Array.newInstance((Class<?>) String.class, list.size(), 3);
        for (int i10 = 0; i10 < list.size(); i10++) {
            strArr[i10][0] = ((d.b) list.get(i10)).a();
            strArr[i10][1] = ((d.b) list.get(i10)).c();
            strArr[i10][2] = ((d.b) list.get(i10)).b();
        }
        return strArr;
    }

    public static q0.d c(Map map) {
        d.c cVar = new d.c();
        Object obj = map.get("BRAND_VERSION_LIST");
        if (obj != null) {
            ArrayList arrayList = new ArrayList();
            for (String[] strArr : (String[][]) obj) {
                arrayList.add(new d.b.a().b(strArr[0]).d(strArr[1]).c(strArr[2]).a());
            }
            cVar.d(arrayList);
        }
        String str = (String) map.get("FULL_VERSION");
        if (str != null) {
            cVar.e(str);
        }
        String str2 = (String) map.get("PLATFORM");
        if (str2 != null) {
            cVar.h(str2);
        }
        String str3 = (String) map.get("PLATFORM_VERSION");
        if (str3 != null) {
            cVar.i(str3);
        }
        String str4 = (String) map.get("ARCHITECTURE");
        if (str4 != null) {
            cVar.b(str4);
        }
        String str5 = (String) map.get("MODEL");
        if (str5 != null) {
            cVar.g(str5);
        }
        Boolean bool = (Boolean) map.get("MOBILE");
        if (bool != null) {
            cVar.f(bool.booleanValue());
        }
        Integer num = (Integer) map.get("BITNESS");
        if (num != null) {
            cVar.c(num.intValue());
        }
        Boolean bool2 = (Boolean) map.get("WOW64");
        if (bool2 != null) {
            cVar.j(bool2.booleanValue());
        }
        return cVar.a();
    }
}
