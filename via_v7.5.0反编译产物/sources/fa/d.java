package fa;

import android.util.Base64;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    public static void a(qa.c cVar, List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ra.a aVar = (ra.a) it.next();
            ra.c cVarH = cVar.h(aVar.d(), aVar.c().b());
            if (cVarH == null) {
                cVar.a(aVar);
            } else {
                cVar.p(cVarH.e(), aVar);
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
            ra.a aVarD = d((l9.a) it.next());
            if (aVarD != null) {
                arrayList.add(aVarD);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public static String c(l9.a aVar) {
        Scanner scanner;
        if (aVar == null || aVar.k()) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("// ==UserScript==");
        sb2.append("\n");
        String strE = aVar.e();
        if (e(strE)) {
            strE = aVar.d();
        }
        if (e(strE)) {
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
        if (!e(aVar.a())) {
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
                } else if (!strTrim.startsWith("// ==/UserScript==")) {
                    if (!z10) {
                        sb2.append(strTrim);
                        sb2.append("\n");
                    }
                }
            }
            return sb2.toString();
        }
    }

    public static ra.a d(l9.a aVar) {
        String strC;
        ra.a aVarE;
        if (aVar == null || aVar.k() || (strC = c(aVar)) == null || strC.isEmpty() || (aVarE = ra.a.e(strC, null)) == null) {
            return null;
        }
        aVarE.f(!aVar.i());
        return aVarE;
    }

    public static boolean e(String str) {
        return str == null || str.isEmpty();
    }

    public static void f(w9.a aVar, qa.c cVar) {
        List listB;
        if (aVar == null || cVar == null || (listB = b(aVar.v())) == null) {
            return;
        }
        a(cVar, listB);
        aVar.c();
    }
}
