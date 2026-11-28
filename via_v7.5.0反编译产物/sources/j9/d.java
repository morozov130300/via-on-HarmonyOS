package j9;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import u9.l;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    public static Map a(l lVar, w9.a aVar, z9.d dVar, u4.a aVar2, qa.c cVar, m9.c cVar2, boolean z10) {
        ArrayList<c> arrayList = new ArrayList();
        arrayList.add(new a(aVar2, z10 ? 30720 : -1));
        arrayList.add(new b(cVar2));
        arrayList.add(new f(lVar, z10));
        arrayList.add(new h(cVar, z10));
        if (!z10) {
            arrayList.add(new e(aVar));
            arrayList.add(new i(aVar, lVar));
            arrayList.add(new j(dVar));
        }
        HashMap map = new HashMap();
        for (c cVar3 : arrayList) {
            if (cVar3.getKey() != null) {
                map.put(cVar3.getKey(), c(cVar3.a(), z10));
            }
        }
        return map;
    }

    public static boolean b(l lVar, w9.a aVar, z9.d dVar, u4.a aVar2, qa.c cVar, m9.c cVar2, String str) {
        JSONObject jSONObject;
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e10) {
            tc.a.j(e10);
            jSONObject = null;
        }
        if (jSONObject == null) {
            return false;
        }
        ArrayList<c> arrayList = new ArrayList();
        arrayList.add(new a(aVar2, -1));
        arrayList.add(new b(cVar2));
        arrayList.add(new f(lVar, false));
        arrayList.add(new h(cVar, false));
        arrayList.add(new e(aVar));
        arrayList.add(new i(aVar, lVar));
        arrayList.add(new j(dVar));
        int i10 = 0;
        for (c cVar3 : arrayList) {
            if (cVar3.getKey() != null) {
                String strOptString = jSONObject.optString(cVar3.getKey());
                if (!strOptString.isEmpty() && cVar3.b(strOptString)) {
                    i10++;
                }
            }
        }
        return i10 > 0;
    }

    public static String c(String str, boolean z10) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        if (!z10) {
            return str;
        }
        try {
            return URLEncoder.encode(str, k8.a.f7219b);
        } catch (UnsupportedEncodingException e10) {
            tc.a.e(e10);
            return "";
        }
    }
}
