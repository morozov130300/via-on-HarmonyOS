package ma;

import java.util.ArrayList;
import java.util.List;
import ka.i;
import org.json.JSONArray;
import org.json.JSONObject;
import z8.v0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a implements f {
    @Override // ma.f
    public List a(String str, int i10) throws Throwable {
        if (i10 > 0 && str != null && str.length() != 0) {
            String strB = i.b("https://suggestion.baidu.com/su?wd=" + v0.j(str) + "&cb=suggestion", "GB2312");
            if (strB != null && strB.length() >= 15 && strB.startsWith("suggestion({")) {
                int iLastIndexOf = strB.lastIndexOf(41);
                if (iLastIndexOf <= 0) {
                    iLastIndexOf = strB.length();
                }
                try {
                    JSONArray jSONArrayOptJSONArray = new JSONObject(strB.substring(11, iLastIndexOf)).optJSONArray("s");
                    if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
                        ArrayList arrayList = new ArrayList();
                        int iMin = Math.min(jSONArrayOptJSONArray.length(), i10);
                        for (int i11 = 0; i11 < iMin; i11++) {
                            String strB2 = b(jSONArrayOptJSONArray.optString(i11));
                            if (strB2 != null && !strB2.isEmpty()) {
                                arrayList.add(ka.a.g(strB2));
                            }
                        }
                        if (arrayList.size() > 0) {
                            return arrayList;
                        }
                    }
                    return null;
                } catch (Exception e10) {
                    pc.a.b(e10);
                }
            }
        }
        return null;
    }

    public final String b(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return str.replace("&amp;", "&").replace("&lt;", "<").replace("&gt;", ">").replace("&quot;", "\"").replace("&apos;", "'").replace("&#39;", "'");
    }
}
