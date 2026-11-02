package i6;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.UUID;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class u {
    public static final String a(String str) throws UnsupportedEncodingException {
        if (str != null && str.length() != 0) {
            try {
                String strDecode = URLDecoder.decode(str, "UTF-8");
                kotlin.jvm.internal.h.c(strDecode);
                if (v7.m.v(strDecode, '\ufffd', 0, false, 6, null) < 0) {
                    return strDecode;
                }
            } catch (Exception unused) {
            }
        }
        return str;
    }

    public static final String b(String str) throws UnsupportedEncodingException {
        if (str == null || str.length() == 0) {
            return str;
        }
        try {
            String strEncode = URLEncoder.encode(str, "UTF-8");
            kotlin.jvm.internal.h.e(strEncode, "encode(...)");
            return v7.l.j(strEncode, "+", "%20", false, 4, null);
        } catch (Exception unused) {
            return str;
        }
    }

    public static final String c() {
        String string = UUID.randomUUID().toString();
        kotlin.jvm.internal.h.e(string, "toString(...)");
        return string;
    }
}
