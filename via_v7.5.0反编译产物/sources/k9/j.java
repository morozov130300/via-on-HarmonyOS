package k9;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class j {
    public static Integer a(int i10, Map map) {
        if (i10 < 0) {
            return Integer.valueOf(i10);
        }
        if (i10 > 0) {
            return (Integer) map.get(Integer.valueOf(i10));
        }
        return null;
    }

    public static String b(String str, Map map) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet();
        for (String str2 : str.split(",")) {
            try {
                Integer numA = a(Integer.parseInt(str2.trim()), map);
                if (numA != null) {
                    linkedHashSet.add(numA);
                }
            } catch (NumberFormatException unused) {
            }
        }
        StringBuilder sb2 = new StringBuilder();
        for (Integer num : linkedHashSet) {
            if (sb2.length() > 0) {
                sb2.append(',');
            }
            sb2.append(num);
        }
        return sb2.toString();
    }

    public static String c(String str, Map map) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Integer numA = a(Integer.parseInt(next), map);
                if (numA != null && !jSONObject2.has(String.valueOf(numA))) {
                    jSONObject2.put(String.valueOf(numA), jSONObject.optString(next, ""));
                }
            }
            return jSONObject2.toString();
        } catch (Exception unused) {
            return str;
        }
    }
}
