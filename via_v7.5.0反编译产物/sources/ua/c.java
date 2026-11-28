package ua;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static List a(String str) {
        ArrayList arrayList = new ArrayList();
        if (str != null && !str.isEmpty()) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i10 = 0; i10 < length; i10++) {
                    arrayList.add(jSONArray.optString(i10));
                }
            } catch (Exception e10) {
                tc.a.i("Invalid userscript JSON (%s)", e10.getClass().getSimpleName());
            }
        }
        return arrayList;
    }

    public static List b(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return a(str2);
        }
        if (str2 == null || str2.isEmpty()) {
            return a(str);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(a(str));
        arrayList.addAll(a(str2));
        return arrayList;
    }

    public static HashMap c(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        HashMap map = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.optString(next));
            }
            return map;
        } catch (Exception e10) {
            tc.a.i("Invalid userscript JSON (%s)", e10.getClass().getSimpleName());
            return map;
        }
    }

    public static String d(List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str != null && !str.isEmpty()) {
                jSONArray.put(str);
            }
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        return jSONArray.toString();
    }

    public static String e(Map map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (str != null && !str.isEmpty() && str2 != null && !str2.isEmpty()) {
                try {
                    jSONObject.put(str, str2);
                } catch (Exception e10) {
                    tc.a.i("Invalid userscript JSON (%s)", e10.getClass().getSimpleName());
                }
            }
        }
        if (jSONObject.length() == 0) {
            return null;
        }
        return jSONObject.toString();
    }
}
