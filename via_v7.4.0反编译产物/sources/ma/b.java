package ma;

import java.util.ArrayList;
import java.util.List;
import ka.i;
import org.json.JSONArray;
import org.json.JSONObject;
import z8.v0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b implements f {
    @Override // ma.f
    public List a(String str, int i10) throws Throwable {
        if (i10 <= 0 || str == null || str.length() == 0) {
            return null;
        }
        String strB = i.b("https://api.bing.com/qsonhs.aspx?type=cb&cb=s&q=" + v0.j(str), "UTF-8");
        if (strB == null || strB.length() < 20) {
            return null;
        }
        int iIndexOf = strB.indexOf(",\"Suggests\":[");
        int iIndexOf2 = iIndexOf < 0 ? -1 : strB.indexOf("]}]}}", iIndexOf + 13);
        if (iIndexOf < 0 || iIndexOf2 <= iIndexOf + 13) {
            return null;
        }
        int i11 = iIndexOf + 12;
        int i12 = iIndexOf2 + 1;
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(strB.substring(i11, i12));
            int iMin = Math.min(jSONArray.length(), i10);
            for (int i13 = 0; i13 < iMin; i13++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i13);
                String strOptString = jSONObjectOptJSONObject == null ? null : jSONObjectOptJSONObject.optString("Txt");
                if (strOptString != null && !strOptString.isEmpty()) {
                    arrayList.add(ka.a.g(strOptString));
                }
            }
        } catch (Exception e10) {
            pc.a.b(e10);
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }
}
