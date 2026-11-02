package l9;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import w9.l;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class d {
    public static Map a(l lVar, y9.a aVar, ca.d dVar, u4.a aVar2, p5.c cVar, o9.c cVar2, boolean z10) {
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

    public static boolean b(l lVar, y9.a aVar, ca.d dVar, u4.a aVar2, p5.c cVar, o9.c cVar2, String str) {
        JSONObject jSONObject;
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e10) {
            pc.a.i(e10);
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
            return URLEncoder.encode(str, m8.a.f8677b);
        } catch (UnsupportedEncodingException e10) {
            pc.a.d(e10);
            return "";
        }
    }
}
