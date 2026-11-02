package ia;

import android.util.Base64;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import z8.b0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class d {
    public static void a(p5.c cVar, List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            r5.a aVar = (r5.a) it.next();
            r5.c cVarI = cVar.i(aVar.e(), aVar.d().b());
            if (cVarI == null) {
                cVar.h(aVar);
            } else {
                cVar.p(cVarI.e(), aVar);
            }
        }
    }

    public static List b(List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            r5.a aVarD = d((n9.a) it.next());
            if (aVarD != null) {
                arrayList.add(aVarD);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public static String c(n9.a aVar) {
        Scanner scanner;
        if (aVar == null || aVar.k()) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("// ==UserScript==");
        sb2.append("\n");
        String strE = aVar.e();
        if (f(strE)) {
            strE = aVar.d();
        }
        if (f(strE)) {
            strE = "Untitled Script - " + (Math.max(aVar.c(), aVar.f()) + 10000);
        }
        sb2.append("// @name         ");
        sb2.append(strE);
        sb2.append("\n");
        sb2.append("// @namespace    https://viayoo.com/");
        sb2.append("\n");
        sb2.append("// @version      0.1");
        sb2.append("\n");
        if (aVar.f() > 0) {
            sb2.append("// @homepageURL  ");
            sb2.append("https://app.viayoo.com/addons/");
            sb2.append(aVar.f());
            sb2.append("\n");
        }
        if (!f(aVar.a())) {
            sb2.append("// @author       ");
            sb2.append(aVar.a());
            sb2.append("\n");
        }
        sb2.append("// @run-at       document-end\n");
        for (String str : aVar.g()) {
            if (str != null && !str.isEmpty()) {
                sb2.append("// @match        ");
                if (str.charAt(0) != '*') {
                    sb2.append('*');
                }
                sb2.append(str);
                if (str.charAt(str.length() - 1) != '*') {
                    sb2.append('*');
                }
                sb2.append("\n");
            }
        }
        sb2.append("// @grant        none\n");
        sb2.append("// ==/UserScript==\n");
        try {
            scanner = new Scanner(new String(Base64.decode(aVar.b(), 0), "UTF-8"));
        } catch (Exception e10) {
            e10.printStackTrace();
            scanner = null;
        }
        if (scanner == null) {
            return null;
        }
        while (true) {
            boolean z10 = false;
            while (scanner.hasNextLine()) {
                String strTrim = scanner.nextLine().trim();
                if (strTrim.startsWith("// ==UserScript==")) {
                    z10 = true;
                } else {
                    if (strTrim.startsWith("// ==/UserScript==")) {
                        break;
                    }
                    if (!z10) {
                        sb2.append(strTrim);
                        sb2.append("\n");
                    }
                }
            }
            return sb2.toString();
        }
    }

    public static r5.a d(n9.a aVar) {
        String strC;
        r5.a aVarF;
        if (aVar == null || aVar.k() || (strC = c(aVar)) == null || strC.isEmpty() || (aVarF = r5.a.f(strC, null)) == null) {
            return null;
        }
        aVarF.g(!aVar.i());
        return aVarF;
    }

    public static r5.a e(String str) {
        n9.a aVarS;
        if (str == null || str.isEmpty() || (aVarS = b0.s(str)) == null) {
            return null;
        }
        return r5.a.f(c(aVarS), null);
    }

    public static boolean f(String str) {
        return str == null || str.isEmpty();
    }

    public static void g(y9.a aVar, p5.c cVar) {
        List listB;
        if (aVar == null || cVar == null || (listB = b(aVar.v())) == null) {
            return;
        }
        a(cVar, listB);
        aVar.c();
    }
}
