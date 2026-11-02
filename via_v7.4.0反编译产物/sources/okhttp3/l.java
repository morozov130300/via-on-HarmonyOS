package okhttp3;

import java.nio.charset.Charset;
import okio.ByteString;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class l {
    public static String a(String str, String str2) {
        return b(str, str2, ub.c.f12945k);
    }

    public static String b(String str, String str2, Charset charset) {
        return "Basic " + ByteString.encodeString(str + ":" + str2, charset).base64();
    }
}
