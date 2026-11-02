package l5;

import android.util.Base64;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.UUID;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a {
    public static byte[] a(String str, boolean z10, int[] iArr) throws UnsupportedEncodingException {
        if (str == null || str.isEmpty()) {
            return new byte[0];
        }
        int length = str.length();
        int iLastIndexOf = str.lastIndexOf(37);
        if (iLastIndexOf > 0) {
            while (iLastIndexOf >= 1 && str.charAt(iLastIndexOf - 1) == '%') {
                iLastIndexOf--;
            }
            if (iLastIndexOf == 0) {
                iLastIndexOf = -1;
            }
            if (iLastIndexOf > 0) {
                length -= str.length() - iLastIndexOf;
                str = str.substring(0, iLastIndexOf);
            }
        }
        if (str.indexOf(37) >= 0) {
            str = g(str, z10);
        }
        int iMin = Math.min(str.length() - 4, 12);
        byte[] bArrDecode = new byte[0];
        if (z10) {
            do {
                try {
                    bArrDecode = Base64.decode(str, 0);
                    iMin = 0;
                } catch (IllegalArgumentException unused) {
                    iMin--;
                    length--;
                    str = str.substring(0, str.length() - 1);
                }
            } while (iMin > 0);
        } else {
            try {
                bArrDecode = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused2) {
            }
        }
        if (iArr != null && iArr.length > 0) {
            iArr[0] = length;
        }
        return bArrDecode;
    }

    public static long b(String str) throws UnsupportedEncodingException {
        int iIndexOf;
        if (!e(str) || (iIndexOf = str.indexOf(44)) < 0) {
            return 0L;
        }
        boolean z10 = str.indexOf(";base64") > 0;
        int length = (str.length() - iIndexOf) - 1;
        String strSubstring = str.substring(iIndexOf + 1, Math.min(iIndexOf + 257, str.length()));
        if (strSubstring.isEmpty()) {
            return 0L;
        }
        int[] iArr = new int[1];
        byte[] bArrA = a(strSubstring, z10, iArr);
        int i10 = iArr[0];
        if (i10 <= 0) {
            return 0L;
        }
        return (long) (bArrA.length * (length / i10));
    }

    public static String c(String str, String str2) {
        String strB = c.b(str);
        if (strB != null || str2 == null || str2.isEmpty()) {
            str2 = strB;
        }
        String strReplace = UUID.randomUUID().toString().replace("-", "");
        if (str2 == null) {
            return strReplace;
        }
        return strReplace + "." + str2;
    }

    public static String d(String str) {
        int i10;
        String strTrim;
        if (!e(str)) {
            return null;
        }
        int iIndexOf = str.indexOf(";base64,");
        boolean z10 = iIndexOf > 0;
        if (iIndexOf > 0) {
            strTrim = str.substring(5, iIndexOf).trim();
            i10 = iIndexOf + 8;
        } else {
            int iIndexOf2 = str.indexOf(44);
            if (iIndexOf2 < 0) {
                return null;
            }
            String strTrim2 = str.substring(5, iIndexOf2).trim();
            i10 = iIndexOf2 + 1;
            strTrim = strTrim2;
        }
        if (!strTrim.isEmpty() && !"application/octet-stream".equals(strTrim)) {
            return strTrim;
        }
        String strTrim3 = str.substring(i10, Math.min(i10 + 144, str.length())).trim();
        String strD = c.d(a(strTrim3, z10, null));
        if (strD != null) {
            return strD;
        }
        if (strTrim3.contains("<svg ") || strTrim3.contains("<SVG ") || strTrim3.contains("%3Csvg") || strTrim3.contains("%3CSVG")) {
            return "image/svg+xml";
        }
        return null;
    }

    public static boolean e(String str) {
        return str != null && str.startsWith("data:");
    }

    public static boolean f(String str) {
        if (str != null && str.length() > 6) {
            if (str.substring(0, 7).equalsIgnoreCase("http://")) {
                return true;
            }
            if (str.length() > 7 && str.substring(0, 8).equalsIgnoreCase("https://")) {
                return true;
            }
        }
        return false;
    }

    public static String g(String str, boolean z10) throws UnsupportedEncodingException {
        try {
            String strDecode = URLDecoder.decode(str, "UTF-8");
            return z10 ? strDecode.replace(" ", "+").replace("\r\n", "").replace("\n", "") : strDecode;
        } catch (Exception unused) {
            return str;
        }
    }

    public static boolean h(String str, OutputStream outputStream) throws IOException {
        int iIndexOf;
        if (!e(str) || outputStream == null || (iIndexOf = str.indexOf(44)) < 0) {
            return false;
        }
        int length = str.length();
        boolean z10 = str.indexOf(";base64") > 0;
        int i10 = iIndexOf + 1;
        while (i10 < length && str.charAt(i10) == ' ') {
            i10++;
        }
        while (length > 0 && str.charAt(length - 1) == ' ') {
            length--;
        }
        int[] iArr = new int[1];
        while (i10 < length) {
            try {
                byte[] bArrA = a(str.substring(i10, Math.min(length, i10 + 1024)), z10, iArr);
                int i11 = iArr[0];
                if (i11 == 0) {
                    break;
                }
                i10 += i11;
                outputStream.write(bArrA);
            } catch (IOException e10) {
                e10.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public static boolean i(String str, k5.c cVar) {
        int iIndexOf;
        if (!e(str) || cVar == null || (iIndexOf = str.indexOf(44)) < 0) {
            return false;
        }
        int length = str.length();
        boolean z10 = str.indexOf(";base64") > 0;
        int i10 = iIndexOf + 1;
        while (i10 < length && str.charAt(i10) == ' ') {
            i10++;
        }
        while (length > 0 && str.charAt(length - 1) == ' ') {
            length--;
        }
        int[] iArr = new int[1];
        while (i10 < length) {
            try {
                byte[] bArrA = a(str.substring(i10, Math.min(length, i10 + 1024)), z10, iArr);
                int i11 = iArr[0];
                if (i11 == 0) {
                    break;
                }
                i10 += i11;
                cVar.write(bArrA, 0, bArrA.length);
            } catch (IOException e10) {
                e10.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
