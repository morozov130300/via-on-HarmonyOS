package z8;

import java.util.Scanner;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class u2 {
    public static String a(String str) {
        int iIndexOf;
        if (str == null) {
            return "";
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return "";
        }
        if (strTrim.startsWith("/*")) {
            int iIndexOf2 = strTrim.indexOf("*/");
            if (iIndexOf2 > 0) {
                strTrim = strTrim.substring(0, iIndexOf2 + 2);
            }
            String[] strArr = {"name:", "title:", "name ", "title "};
            int iIndexOf3 = -1;
            for (int i10 = 0; iIndexOf3 < 0 && i10 < 4; i10++) {
                iIndexOf3 = strTrim.indexOf(strArr[i10]);
                if (iIndexOf3 >= 0) {
                    iIndexOf3 += strArr[i10].length();
                }
            }
            int iMax = Math.max(2, iIndexOf3);
            int iIndexOf4 = strTrim.indexOf("\n", iMax);
            if (iIndexOf4 < 0) {
                iIndexOf4 = strTrim.length() - 2;
            }
            return strTrim.substring(iMax, iIndexOf4).trim();
        }
        try {
            Scanner scanner = new Scanner(strTrim);
            boolean z10 = false;
            while (scanner.hasNextLine()) {
                try {
                    String strTrim2 = scanner.nextLine().trim();
                    if (!strTrim2.isEmpty()) {
                        if (!strTrim2.startsWith("//")) {
                            break;
                        }
                        if ("// ==UserScript==".equals(strTrim2)) {
                            z10 = true;
                        } else if (z10 && (iIndexOf = strTrim2.indexOf("@name")) > 0) {
                            String strTrim3 = strTrim2.substring(iIndexOf + 5).trim();
                            scanner.close();
                            return strTrim3;
                        }
                        if ("// ==/UserScript==".equals(strTrim2)) {
                            break;
                        }
                    }
                } finally {
                }
            }
            scanner.close();
        } catch (Exception e10) {
            pc.a.d(e10);
        }
        if (strTrim.length() > 128) {
            strTrim = strTrim.substring(0, 128);
        }
        return strTrim.replace("\n", " ").trim();
    }
}
