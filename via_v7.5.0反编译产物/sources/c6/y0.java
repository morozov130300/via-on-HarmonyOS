package c6;

import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class y0 {
    public static final long a() {
        return System.currentTimeMillis();
    }

    public static final String b(String value, String str) {
        URL url;
        kotlin.jvm.internal.h.f(value, "value");
        if (value.length() > 5 && kotlin.text.x.B(value, "data:", true)) {
            return value;
        }
        if (str != null) {
            try {
                url = new URL(str);
            } catch (Exception unused) {
                return null;
            }
        } else {
            url = null;
        }
        return new URL(url, value).toURI().toString();
    }

    public static final String c(String str) {
        if (str != null && str.length() != 0) {
            try {
                String strDecode = URLDecoder.decode(str, "UTF-8");
                kotlin.jvm.internal.h.c(strDecode);
                if (kotlin.text.z.S(strDecode, (char) 65533, 0, false, 6, null) < 0) {
                    return strDecode;
                }
            } catch (Exception unused) {
            }
        }
        return str;
    }

    public static final String d(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        try {
            String strEncode = URLEncoder.encode(str, "UTF-8");
            kotlin.jvm.internal.h.e(strEncode, "encode(...)");
            return kotlin.text.x.z(strEncode, "+", "%20", false, 4, null);
        } catch (Exception unused) {
            return str;
        }
    }

    public static final String e() {
        String string = UUID.randomUUID().toString();
        kotlin.jvm.internal.h.e(string, "toString(...)");
        return string;
    }
}
