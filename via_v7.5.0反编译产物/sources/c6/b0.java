package c6;

import kotlin.text.Regex;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f1960a = new b0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Regex f1961b = new Regex("&(amp|lt|gt|quot|apos|#[0-9]+|#x[0-9a-fA-F]+);");

    public static final CharSequence b(kotlin.text.i it) {
        Integer numK;
        kotlin.jvm.internal.h.f(it, "it");
        String str = (String) it.a().get(1);
        int iHashCode = str.hashCode();
        if (iHashCode != 3309) {
            if (iHashCode != 3464) {
                if (iHashCode != 96708) {
                    if (iHashCode != 3000915) {
                        if (iHashCode == 3482377 && str.equals("quot")) {
                            return "\"";
                        }
                    } else if (str.equals("apos")) {
                        return "'";
                    }
                } else if (str.equals("amp")) {
                    return "&";
                }
            } else if (str.equals("lt")) {
                return "<";
            }
        } else if (str.equals("gt")) {
            return ">";
        }
        if (kotlin.text.x.D(str, "#x", false, 2, null)) {
            String strSubstring = str.substring(2);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            numK = kotlin.text.w.l(strSubstring, 16);
        } else {
            String strSubstring2 = str.substring(1);
            kotlin.jvm.internal.h.e(strSubstring2, "substring(...)");
            numK = kotlin.text.w.k(strSubstring2);
        }
        if (numK == null) {
            return it.getValue();
        }
        int iIntValue = numK.intValue();
        if (iIntValue >= 0 && iIntValue < 65536) {
            return String.valueOf((char) iIntValue);
        }
        if (65536 > iIntValue || iIntValue >= 1114112) {
            return it.getValue();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append((char) (((iIntValue - 65536) >> 10) + 55296));
        sb2.append((char) ((iIntValue & 1023) + 56320));
        return sb2.toString();
    }

    public final String c(String text) {
        kotlin.jvm.internal.h.f(text, "text");
        return f1961b.replace(text, new p7.l() { // from class: c6.a0
            @Override // p7.l
            public final Object invoke(Object obj) {
                return b0.b((kotlin.text.i) obj);
            }
        });
    }

    public final String d(String str) {
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

    public final String e(String str) {
        return z0.f2141a.e(str);
    }

    public final String f(String str) {
        return y0.c(str);
    }

    public final String g(String str) {
        return y0.d(str);
    }
}
