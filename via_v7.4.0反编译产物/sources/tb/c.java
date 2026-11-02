package tb;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class c {
    public static Map a() {
        HashMap map = new HashMap();
        map.put(-1, "gg");
        map.put(-3, "bn");
        map.put(-2, "bd");
        map.put(-10, "dd");
        map.put(-12, "mt");
        map.put(-5, "qh");
        map.put(-4, "sm");
        map.put(-6, "sg");
        map.put(-11, "tt");
        map.put(-9, "sp");
        map.put(-8, "yh");
        map.put(-7, "yd");
        return map;
    }

    public static int b(Map map, String str) {
        if (str == null) {
            str = "";
        }
        int iE = g6.p.e(str);
        if (iE <= 0) {
            return 0;
        }
        String strE = e(str.substring(0, iE));
        for (Map.Entry entry : map.entrySet()) {
            if (!((String) entry.getValue()).isEmpty() && ((String) entry.getValue()).equals(strE)) {
                return ((Integer) entry.getKey()).intValue();
            }
        }
        return 0;
    }

    public static boolean c(Map map, int i10, String str) {
        if (str.isEmpty()) {
            return false;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (((Integer) entry.getKey()).intValue() != i10 && str.equals(entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    public static boolean d(String str) {
        if (str.isEmpty()) {
            return true;
        }
        if (str.codePointCount(0, str.length()) > 16) {
            return false;
        }
        for (int i10 = 0; i10 < str.length(); i10++) {
            if (Character.isWhitespace(str.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    public static String e(String str) {
        return str == null ? "" : str.trim().toLowerCase(Locale.ROOT);
    }

    public static Map f(w9.l lVar) {
        Map mapA = a();
        String strF1 = lVar.f1();
        if (strF1 != null && !strF1.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(strF1);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    mapA.put(Integer.valueOf(Integer.parseInt(next)), jSONObject.optString(next, ""));
                }
            } catch (Exception unused) {
            }
        }
        return mapA;
    }

    public static void g(w9.l lVar, Map map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry entry : map.entrySet()) {
                jSONObject.put(String.valueOf(entry.getKey()), entry.getValue());
            }
        } catch (JSONException unused) {
        }
        lVar.l1(jSONObject.toString());
    }
}
