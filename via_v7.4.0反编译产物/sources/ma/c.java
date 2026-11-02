package ma;

import android.os.Build;
import android.text.Html;
import java.util.ArrayList;
import java.util.List;
import ka.i;
import z8.t1;
import z8.v0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c implements f {
    @Override // ma.f
    public List a(String str, int i10) throws Throwable {
        int length;
        int iIndexOf;
        if (i10 > 0 && str != null && !str.isEmpty()) {
            String strB = i.b("https://clients1.google.com/complete/search?hl=" + b(t1.g()) + "&output=toolbar&q=" + v0.j(str), "UTF-8");
            if (strB != null && (length = strB.length()) >= 20) {
                ArrayList arrayList = new ArrayList();
                int i11 = 0;
                int i12 = 0;
                do {
                    int iIndexOf2 = strB.indexOf("<suggestion data=\"", i11);
                    if (iIndexOf2 < 0 || (iIndexOf = strB.indexOf("\"/>", (i11 = iIndexOf2 + 18))) < 0) {
                        break;
                    }
                    if (iIndexOf > i11) {
                        String strSubstring = strB.substring(i11, iIndexOf);
                        arrayList.add(ka.a.g(Build.VERSION.SDK_INT >= 24 ? Html.fromHtml(strSubstring, 0).toString() : Html.fromHtml(strSubstring).toString()));
                        i12++;
                    }
                    if (i11 < 0 || i11 >= length) {
                        break;
                    }
                } while (i12 < i10);
                if (arrayList.size() > 0) {
                    return arrayList;
                }
            }
        }
        return null;
    }

    public final String b(String str) {
        String strM = t1.m(str);
        return "zh".equals(strM) ? (str.endsWith("TW") || str.endsWith("HK")) ? "zh-hant" : "zh" : strM;
    }
}
