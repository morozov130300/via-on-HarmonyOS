package c6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class k {
    public static final String a(Map fields) {
        kotlin.jvm.internal.h.f(fields, "fields");
        String string = new JSONObject(fields).toString();
        kotlin.jvm.internal.h.e(string, "toString(...)");
        return string;
    }

    public static final Map b(JSONObject jSONObject) throws JSONException {
        Iterator<String> itKeys = jSONObject.keys();
        kotlin.jvm.internal.h.e(itKeys, "keys(...)");
        u7.f fVarC = u7.k.c(itKeys);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : fVarC) {
            Object obj2 = jSONObject.get((String) obj);
            kotlin.jvm.internal.h.e(obj2, "get(...)");
            linkedHashMap.put(obj, c(obj2));
        }
        return linkedHashMap;
    }

    public static final Object c(Object obj) throws JSONException {
        if (obj instanceof JSONObject) {
            return b((JSONObject) obj);
        }
        if (!(obj instanceof JSONArray)) {
            if (kotlin.jvm.internal.h.a(obj, JSONObject.NULL)) {
                return null;
            }
            return obj;
        }
        JSONArray jSONArray = (JSONArray) obj;
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        for (int i10 = 0; i10 < length; i10++) {
            Object obj2 = jSONArray.get(i10);
            kotlin.jvm.internal.h.e(obj2, "get(...)");
            arrayList.add(c(obj2));
        }
        return arrayList;
    }

    public static final Map d(String line) {
        kotlin.jvm.internal.h.f(line, "line");
        JSONObject jSONObjectE = e(line);
        if (jSONObjectE != null) {
            return b(jSONObjectE);
        }
        return null;
    }

    public static final JSONObject e(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static final m f(String line) {
        kotlin.jvm.internal.h.f(line, "line");
        JSONObject jSONObjectE = e(line);
        if (jSONObjectE != null) {
            return i.f2031a.e(new c(jSONObjectE));
        }
        return null;
    }

    public static final String g(String kind, JSONObject fields) {
        kotlin.jvm.internal.h.f(kind, "kind");
        kotlin.jvm.internal.h.f(fields, "fields");
        String string = new JSONObject().put(kind, fields).toString();
        kotlin.jvm.internal.h.e(string, "toString(...)");
        return string;
    }
}
