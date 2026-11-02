package b5;

import android.webkit.MimeTypeMap;
import android.webkit.WebResourceRequest;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class c {
    public static boolean a(String str) {
        if (str != null && str.length() >= 5) {
            int iIndexOf = str.indexOf("://");
            int i10 = iIndexOf < 0 ? 0 : iIndexOf + 3;
            int iIndexOf2 = str.indexOf(36, i10);
            if (iIndexOf2 < 0) {
                iIndexOf2 = str.length();
            }
            int i11 = 0;
            while (i10 < iIndexOf2) {
                char cCharAt = str.charAt(i10);
                if (cCharAt == '@' || cCharAt == '|' || cCharAt == '*' || cCharAt == '^') {
                    i11 = 0;
                } else {
                    i11++;
                    if (i11 >= 5) {
                        return true;
                    }
                }
                i10++;
            }
        }
        return false;
    }

    public static void b(Closeable closeable) throws IOException {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static w4.c c(w4.c cVar) throws Throwable {
        LineNumberReader lineNumberReader;
        String line;
        if (cVar != null && cVar.a() != null) {
            File file = new File(cVar.a());
            if (file.exists()) {
                LineNumberReader lineNumberReader2 = null;
                try {
                    try {
                        lineNumberReader = new LineNumberReader(new FileReader(file));
                    } catch (IOException e10) {
                        e = e10;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    String[] strArr = {"Title:", "Homepage:", "License:"};
                    int i10 = 20;
                    while (true) {
                        int i11 = i10 - 1;
                        if (i10 <= 0 || (line = lineNumberReader.readLine()) == null) {
                            break;
                        }
                        if (!line.isEmpty()) {
                            if (line.charAt(0) == '!') {
                                for (int i12 = 0; i12 < 3; i12++) {
                                    int iIndexOf = line.indexOf(strArr[i12]);
                                    if (iIndexOf >= 0) {
                                        line = line.substring(iIndexOf + strArr[i12].length()).trim();
                                        if (i12 == 0) {
                                            cVar.m(line);
                                        } else if (i12 == 1) {
                                            cVar.j(line);
                                        } else if (i12 == 2) {
                                            cVar.k(line);
                                        }
                                    }
                                }
                            }
                        }
                        i10 = i11;
                    }
                    lineNumberReader.skip(Long.MAX_VALUE);
                    cVar.l(lineNumberReader.getLineNumber() + 1);
                    b(lineNumberReader);
                    return cVar;
                } catch (IOException e11) {
                    e = e11;
                    lineNumberReader2 = lineNumberReader;
                    e.printStackTrace();
                    b(lineNumberReader2);
                    return cVar;
                } catch (Throwable th2) {
                    th = th2;
                    lineNumberReader2 = lineNumberReader;
                    b(lineNumberReader2);
                    throw th;
                }
            }
        }
        return cVar;
    }

    public static boolean d(String str, String str2) {
        if (e(str, str2)) {
            return true;
        }
        String strI = i(str);
        if (strI != null) {
            return e(strI, str2);
        }
        return false;
    }

    public static boolean e(String str, String str2) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        HttpURLConnection httpURLConnection;
        int responseCode;
        String headerField;
        boolean z10 = false;
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
            return false;
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoOutput(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36");
            httpURLConnection.connect();
            responseCode = httpURLConnection.getResponseCode();
            headerField = httpURLConnection.getHeaderField("Content-Type");
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
            bufferedOutputStream = null;
        }
        if (responseCode == 200 && headerField != null && headerField.trim().startsWith("text/plain")) {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
            } catch (Exception unused2) {
                bufferedOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = null;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i10 = bufferedInputStream2.read(bArr);
                    if (i10 == -1) {
                        break;
                    }
                    bufferedOutputStream.write(bArr, 0, i10);
                }
                bufferedInputStream = bufferedInputStream2;
                z10 = true;
            } catch (Exception unused3) {
                bufferedInputStream = bufferedInputStream2;
                b(bufferedInputStream);
                b(bufferedOutputStream);
                return z10;
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = bufferedInputStream2;
                b(bufferedInputStream);
                b(bufferedOutputStream);
                throw th;
            }
        } else {
            bufferedOutputStream = null;
        }
        b(bufferedInputStream);
        b(bufferedOutputStream);
        return z10;
    }

    public static String[] f(String str, char c10) {
        int length = str == null ? 0 : str.length();
        if (length == 0) {
            return new String[0];
        }
        boolean z10 = false;
        int i10 = 0;
        boolean z11 = false;
        for (int i11 = 0; i11 < length; i11++) {
            if (str.charAt(i11) == c10) {
                if (z10) {
                    i10++;
                    z10 = false;
                }
                z11 = true;
            } else {
                z10 = true;
            }
        }
        if (z10) {
            i10++;
        }
        if (!z11) {
            return new String[]{str};
        }
        if (i10 == 0) {
            return new String[0];
        }
        String[] strArr = new String[i10];
        int i12 = 0;
        int i13 = -1;
        for (int i14 = 0; i14 < length; i14++) {
            if (str.charAt(i14) == c10) {
                if (i13 >= 0) {
                    strArr[i12] = str.substring(i13, i14);
                    i12++;
                    i13 = -1;
                }
            } else if (i13 < 0) {
                i13 = i14;
            }
        }
        if (i13 >= 0) {
            strArr[i12] = str.substring(i13, length);
        }
        return strArr;
    }

    public static String g(String str, Set set) {
        if (str != null && str.length() >= 5) {
            int iIndexOf = str.indexOf("://");
            int i10 = iIndexOf < 0 ? 0 : iIndexOf + 3;
            int iIndexOf2 = str.indexOf(36, i10);
            if (iIndexOf2 < 0) {
                iIndexOf2 = str.length();
            }
            int i11 = iIndexOf2 - 5;
            while (i10 <= i11) {
                int i12 = 0;
                while (i12 < 5) {
                    char cCharAt = str.charAt(i10 + i12);
                    if (cCharAt == '@' || cCharAt == '|' || cCharAt == '*' || cCharAt == '^') {
                        break;
                    }
                    i12++;
                }
                if (i12 < 5) {
                    i10 += i12 + 1;
                } else {
                    String strSubstring = str.substring(i10, i10 + 5);
                    if (!set.contains(strSubstring)) {
                        return strSubstring;
                    }
                    i10++;
                }
            }
        }
        return null;
    }

    public static String[] h(String str) {
        if (str == null || str.length() < 5) {
            return null;
        }
        int iIndexOf = str.indexOf("://");
        int i10 = iIndexOf < 0 ? 0 : iIndexOf + 3;
        int iIndexOf2 = str.indexOf(36);
        if (iIndexOf2 == -1) {
            iIndexOf2 = str.length();
        }
        if (iIndexOf2 - i10 < 5) {
            return null;
        }
        int i11 = iIndexOf2 - 5;
        int i12 = (i11 - i10) + 1;
        String[] strArr = new String[i12];
        int i13 = 0;
        while (i10 <= i11) {
            int i14 = 0;
            while (i14 < 5) {
                char cCharAt = str.charAt(i10 + i14);
                if (cCharAt == '@' || cCharAt == '|' || cCharAt == '*' || cCharAt == '^') {
                    break;
                }
                i14++;
            }
            if (i14 < 5) {
                i10 += i14 + 1;
            } else {
                strArr[i13] = str.substring(i10, i10 + 5);
                i10++;
                i13++;
            }
        }
        if (i13 == 0) {
            return null;
        }
        return i13 == i12 ? strArr : (String[]) Arrays.copyOf(strArr, i13);
    }

    public static String i(String str) {
        int iIndexOf;
        if (str != null && !str.isEmpty() && !str.startsWith("https://fastly.jsdelivr.net/")) {
            if (str.length() > 25 && str.startsWith("https://cdn.jsdelivr.net/")) {
                return "https://fastly.jsdelivr.net/" + str.substring(25);
            }
            if (str.length() > 34 && str.startsWith("https://raw.githubusercontent.com/")) {
                int iIndexOf2 = str.indexOf(47, 34);
                if (iIndexOf2 < 0 || (iIndexOf = str.indexOf(47, iIndexOf2 + 1)) <= 0) {
                    return null;
                }
                return "https://fastly.jsdelivr.net/gh/" + str.substring(34, iIndexOf) + '@' + str.substring(iIndexOf + 1);
            }
            if (str.length() > 19 && str.startsWith("https://github.com/")) {
                return "https://fastly.jsdelivr.net/gh/" + str.substring(19).replace("/blob/", "@");
            }
            if (str.length() > 18 && str.startsWith("https://unpkg.com/")) {
                return "https://fastly.jsdelivr.net/npm/" + str.substring(18);
            }
        }
        return null;
    }

    public static int j(WebResourceRequest webResourceRequest, String str) {
        boolean z10;
        int i10;
        String string = webResourceRequest.getUrl().toString();
        Map requestHeaders = webResourceRequest.getRequestHeaders();
        if (webResourceRequest.isForMainFrame() && string.equals(str)) {
            z10 = true;
            i10 = 512;
        } else {
            z10 = false;
            i10 = 0;
        }
        if (string.startsWith("ws")) {
            i10 |= 8192;
        }
        if (requestHeaders != null && "XMLHttpRequest".equals(requestHeaders.get("X-Requested-With"))) {
            i10 |= 16384;
        }
        String strN = n(string);
        if ("js".equals(strN)) {
            return i10 | 32;
        }
        if ("css".equals(strN)) {
            return i10 | 128;
        }
        if ("otf".equals(strN) || "ttf".equals(strN) || "ttc".equals(strN) || "woff".equals(strN) || "woff2".equals(strN)) {
            return i10 | 2048;
        }
        if (!"php".equals(strN)) {
            String strO = o(strN);
            if (!"application/octet-stream".equals(strO)) {
                return l(strO) | i10;
            }
        }
        if (z10) {
            return i10 | 16;
        }
        String strTrim = requestHeaders == null ? null : (String) requestHeaders.get("Accept");
        if (strTrim == null || "*/*".equals(strTrim)) {
            return i10 | 3312;
        }
        int iIndexOf = strTrim.indexOf(44);
        if (iIndexOf > 0) {
            strTrim = strTrim.substring(0, iIndexOf).trim();
        }
        return l(strTrim) | i10;
    }

    public static int k(String str, String str2) {
        boolean z10;
        int i10;
        if (str.equals(str2)) {
            z10 = true;
            i10 = 512;
        } else {
            z10 = false;
            i10 = 0;
        }
        if (str.startsWith("ws")) {
            i10 |= 8192;
        }
        String strN = n(str);
        if ("js".equals(strN)) {
            return i10 | 32;
        }
        if ("css".equals(strN)) {
            return i10 | 128;
        }
        if ("otf".equals(strN) || "ttf".equals(strN) || "ttc".equals(strN) || "woff".equals(strN) || "woff2".equals(strN)) {
            return i10 | 2048;
        }
        if (!"php".equals(strN)) {
            String strO = o(strN);
            if (!"application/octet-stream".equals(strO)) {
                return l(strO) | i10;
            }
        }
        return z10 ? i10 | 16 : i10 | 3312;
    }

    public static int l(String str) {
        if (str == null || str.isEmpty()) {
            return 16;
        }
        if ("application/javascript".equals(str) || "application/x-javascript".equals(str) || "text/javascript".equals(str) || "application/json".equals(str)) {
            return 32;
        }
        if ("text/css".equals(str)) {
            return 128;
        }
        if (str.startsWith("image/")) {
            return 64;
        }
        if (str.startsWith("video/") || str.startsWith("audio/")) {
            return 1024;
        }
        return str.startsWith("font/") ? 2048 : 16;
    }

    public static String m(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        int iIndexOf = str.indexOf("://");
        if (iIndexOf >= 0) {
            str = str.substring(iIndexOf + 3);
        }
        int iIndexOf2 = str.indexOf(47);
        if (iIndexOf2 > 0) {
            str = str.substring(0, iIndexOf2);
        }
        int iLastIndexOf = str.lastIndexOf(58);
        return iLastIndexOf > 0 ? str.substring(0, iLastIndexOf) : str;
    }

    public static String n(String str) {
        if (str != null && !str.isEmpty()) {
            int iIndexOf = str.indexOf(63);
            if (iIndexOf > 0) {
                str = str.substring(0, iIndexOf);
            }
            int iLastIndexOf = str.lastIndexOf(47);
            if (iLastIndexOf > 0) {
                str = str.substring(iLastIndexOf + 1);
            }
            int iIndexOf2 = str.indexOf(46);
            if (iIndexOf2 > 0) {
                String lowerCase = str.substring(iIndexOf2 + 1).toLowerCase(Locale.ROOT);
                if (!lowerCase.isEmpty() && lowerCase.length() <= 8) {
                    return lowerCase;
                }
            }
        }
        return null;
    }

    public static String o(String str) {
        if ("js".equals(str)) {
            return "application/javascript";
        }
        if ("mhtml".equals(str) || "mht".equals(str)) {
            return "multipart/related";
        }
        if ("json".equals(str)) {
            return "application/json";
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
        return (mimeTypeFromExtension == null || mimeTypeFromExtension.isEmpty()) ? "application/octet-stream" : mimeTypeFromExtension;
    }

    public static String p(String str) {
        int iLastIndexOf;
        int iLastIndexOf2;
        if (str.isEmpty() || (iLastIndexOf = str.lastIndexOf(46)) < 0 || (iLastIndexOf2 = str.lastIndexOf(46, iLastIndexOf - 1)) < 0) {
            return str;
        }
        if ("|com|net|org|gov|co|".contains("|" + str.substring(iLastIndexOf2 + 1, iLastIndexOf) + "|")) {
            iLastIndexOf2 = str.lastIndexOf(".", iLastIndexOf2 - 1);
        }
        return str.substring(iLastIndexOf2 + 1);
    }

    public static boolean q(char c10) {
        return c10 == '/' || c10 == '.';
    }

    public static boolean r(char c10) {
        if (c10 >= '0' && c10 <= '9') {
            return false;
        }
        if (c10 < 'A' || c10 > 'Z') {
            return ((c10 >= 'a' && c10 <= 'z') || c10 == '_' || c10 == '-' || c10 == '.' || c10 == '%') ? false : true;
        }
        return false;
    }

    public static boolean s(String str, String str2) {
        return (str == null || str2 == null || str.equals(str2) || str.contains(p(str2))) ? false : true;
    }

    public static List t(String str) throws Throwable {
        if (str != null && !str.isEmpty()) {
            File file = new File(str);
            if (!file.isDirectory() && file.exists()) {
                ArrayList arrayList = new ArrayList();
                BufferedReader bufferedReader = null;
                try {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                        while (true) {
                            try {
                                String line = bufferedReader2.readLine();
                                if (line == null) {
                                    b(bufferedReader2);
                                    return arrayList;
                                }
                                w4.b bVarV = v(line);
                                if (bVarV != null) {
                                    arrayList.add(bVarV);
                                }
                            } catch (Exception e10) {
                                e = e10;
                                bufferedReader = bufferedReader2;
                                e.printStackTrace();
                                b(bufferedReader);
                                return arrayList;
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                b(bufferedReader);
                                throw th;
                            }
                        }
                    } catch (Exception e11) {
                        e = e11;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return Collections.EMPTY_LIST;
    }

    public static boolean u(String str, String str2) {
        int i10 = 0;
        int i11 = 0;
        int i12 = -1;
        int i13 = -1;
        while (i10 < str2.length()) {
            if (i11 < str.length() && ((str.charAt(i11) == '^' && r(str2.charAt(i10))) || ((str.charAt(i11) == '|' && q(str2.charAt(i10))) || str.charAt(i11) == str2.charAt(i10)))) {
                i10++;
                i11++;
            } else if (i11 < str.length() && str.charAt(i11) == '*') {
                i12 = i11;
                i11++;
                i13 = i10;
            } else {
                if (i12 == -1) {
                    return false;
                }
                i11 = i12 + 1;
                i13++;
                i10 = i13;
            }
        }
        while (i11 < str.length() && str.charAt(i11) == '*') {
            i11++;
        }
        return i11 == str.length();
    }

    public static w4.b v(String str) {
        if (str == null || str.isEmpty() || str.charAt(0) == '!') {
            return null;
        }
        return (str.contains("##") || str.contains("#@#")) ? w4.a.d(str) : w4.d.i(str);
    }

    public static String w(String str) {
        if (str.isEmpty()) {
            return str;
        }
        if (str.charAt(0) != '*') {
            str = '*' + str;
        }
        if (str.charAt(str.length() - 1) == '*') {
            return str;
        }
        return str + '*';
    }

    public static String x(String str, String str2) {
        String strM;
        if (str2 == null || str2.isEmpty() || (strM = m(str)) == null || strM.isEmpty()) {
            return null;
        }
        return String.format("%s##%s", strM, str2.trim());
    }

    public static String y(String str, boolean z10) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return z10 ? String.format("||%s^", m(str)) : String.format("|%s", str);
    }
}
