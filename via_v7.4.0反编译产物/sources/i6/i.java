package i6;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f7005a = new i();

    public final String a(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(Math.max(16, str.length()));
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '\"') {
                sb2.append("&quot;");
            } else if (cCharAt == '<') {
                sb2.append("&lt;");
            } else if (cCharAt == '>') {
                sb2.append("&gt;");
            } else if (cCharAt == '&') {
                sb2.append("&amp;");
            } else if (cCharAt != '\'') {
                sb2.append(cCharAt);
            } else {
                sb2.append("&#039;");
            }
        }
        String string = sb2.toString();
        kotlin.jvm.internal.h.e(string, "toString(...)");
        return string;
    }

    public final String b(String str) {
        return v.f7049a.e(str);
    }

    public final String c(String str) {
        return u.a(str);
    }

    public final String d(String str) {
        return u.b(str);
    }
}
