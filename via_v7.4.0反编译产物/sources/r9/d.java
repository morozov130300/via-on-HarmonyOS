package r9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class d {
    public static c a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("name");
        if (strOptString.isEmpty()) {
            return null;
        }
        c cVar = new c(strOptString);
        cVar.e(jSONObject.optBoolean("enabled", false));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("variant");
        if (jSONObjectOptJSONObject != null) {
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("payload");
            if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.has("value")) {
                cVar.f(jSONObjectOptJSONObject2.optString("value"));
            }
            String strOptString2 = jSONObjectOptJSONObject.optString("name");
            boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("enabled", !cVar.d());
            if (!"disabled".equals(strOptString2) || zOptBoolean != (!cVar.d())) {
                cVar.g(strOptString2);
                return cVar;
            }
        }
        return cVar;
    }

    public static List b(String str) {
        JSONObject jSONObject;
        if (str == null || str.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e10) {
            pc.a.b(e10);
            jSONObject = null;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject != null ? jSONObject.optJSONArray("toggles") : null;
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArrayOptJSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            c cVarA = a(jSONArrayOptJSONArray.optJSONObject(i10));
            if (cVarA != null) {
                arrayList.add(cVarA);
            }
        }
        return arrayList;
    }
}
