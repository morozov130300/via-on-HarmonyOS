package z8;

import android.util.Base64;
import java.net.IDN;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class v0 {
    public static String a(String str) {
        if (str == null) {
            str = "";
        }
        try {
            Charset charset = m8.a.f8676a;
            return new String(Base64.decode(str.getBytes(charset), 0), charset).trim();
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String b(String str) {
        if (str == null) {
            str = "";
        }
        return Base64.encodeToString(str.getBytes(m8.a.f8676a), 0);
    }

    public static String c(String str) {
        StringBuilder sb2 = new StringBuilder(Math.max(16, str.length()));
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt > '\u007f' || cCharAt == '\"' || cCharAt == '\'' || cCharAt == '<' || cCharAt == '>' || cCharAt == '&') {
                sb2.append("&#");
                sb2.append((int) cCharAt);
                sb2.append(';');
            } else {
                sb2.append(cCharAt);
            }
        }
        return sb2.toString();
    }

    public static String d(String... strArr) {
        String string;
        String strE = "";
        if (strArr != null && strArr.length != 0) {
            if (strArr.length == 1) {
                string = strArr[0];
            } else {
                StringBuilder sb2 = new StringBuilder();
                for (String str : strArr) {
                    if (str == null) {
                        str = "__NULL__";
                    }
                    sb2.append(str);
                }
                string = sb2.toString();
            }
            if (string != null && !string.isEmpty()) {
                strE = e(string);
                if (strE.isEmpty()) {
                    return Integer.toHexString(string.hashCode());
                }
            }
        }
        return strE;
    }

    public static String e(String str) {
        return (str == null || str.isEmpty()) ? "" : f(str.getBytes(m8.a.f8676a));
    }

    public static String f(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            try {
                byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(bArr);
                StringBuilder sb2 = new StringBuilder();
                for (byte b10 : bArrDigest) {
                    sb2.append(String.format("%02X", Byte.valueOf(b10)));
                }
                return sb2.toString();
            } catch (NoSuchAlgorithmException e10) {
                pc.a.b(e10);
            }
        }
        return "";
    }

    public static String g(String str) {
        byte[] bArrDigest;
        boolean z10;
        try {
            bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            z10 = true;
        } catch (Exception e10) {
            e10.printStackTrace();
            bArrDigest = null;
            z10 = false;
        }
        if (!z10 || bArrDigest == null) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder(bArrDigest.length * 2);
        for (byte b10 : bArrDigest) {
            int i10 = b10 & 255;
            if (i10 < 16) {
                sb2.append("0");
            }
            sb2.append(Integer.toHexString(i10));
        }
        return sb2.toString();
    }

    public static String h(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                return IDN.toUnicode(str);
            } catch (Exception e10) {
                pc.a.b(e10);
            }
        }
        return str;
    }

    public static String i(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        try {
            return URLDecoder.decode(str, m8.a.f8677b);
        } catch (Exception e10) {
            e10.printStackTrace();
            return str;
        }
    }

    public static String j(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        try {
            return URLEncoder.encode(str, m8.a.f8677b).replace("+", "%20");
        } catch (Exception e10) {
            e10.printStackTrace();
            return str;
        }
    }
}
