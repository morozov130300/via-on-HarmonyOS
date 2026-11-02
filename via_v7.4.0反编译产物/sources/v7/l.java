package v7;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class l extends k {
    public static byte[] d(String str) {
        kotlin.jvm.internal.h.f(str, "<this>");
        byte[] bytes = str.getBytes(c.f13045b);
        kotlin.jvm.internal.h.e(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static final boolean e(String str, String suffix, boolean z10) {
        kotlin.jvm.internal.h.f(str, "<this>");
        kotlin.jvm.internal.h.f(suffix, "suffix");
        return !z10 ? str.endsWith(suffix) : h(str, str.length() - suffix.length(), suffix, 0, suffix.length(), true);
    }

    public static /* synthetic */ boolean f(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return e(str, str2, z10);
    }

    public static boolean g(String str, String str2, boolean z10) {
        return str == null ? str2 == null : !z10 ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static final boolean h(String str, int i10, String other, int i11, int i12, boolean z10) {
        kotlin.jvm.internal.h.f(str, "<this>");
        kotlin.jvm.internal.h.f(other, "other");
        return !z10 ? str.regionMatches(i10, other, i11, i12) : str.regionMatches(z10, i10, other, i11, i12);
    }

    public static final String i(String str, String oldValue, String newValue, boolean z10) {
        kotlin.jvm.internal.h.f(str, "<this>");
        kotlin.jvm.internal.h.f(oldValue, "oldValue");
        kotlin.jvm.internal.h.f(newValue, "newValue");
        int i10 = 0;
        int iS = m.s(str, oldValue, 0, z10);
        if (iS < 0) {
            return str;
        }
        int length = oldValue.length();
        int iA = t7.e.a(length, 1);
        int length2 = (str.length() - length) + newValue.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb2 = new StringBuilder(length2);
        do {
            sb2.append((CharSequence) str, i10, iS);
            sb2.append(newValue);
            i10 = iS + length;
            if (iS >= str.length()) {
                break;
            }
            iS = m.s(str, oldValue, iS + iA, z10);
        } while (iS > 0);
        sb2.append((CharSequence) str, i10, str.length());
        String string = sb2.toString();
        kotlin.jvm.internal.h.e(string, "stringBuilder.append(this, i, length).toString()");
        return string;
    }

    public static /* synthetic */ String j(String str, String str2, String str3, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return i(str, str2, str3, z10);
    }

    public static final boolean k(String str, String prefix, int i10, boolean z10) {
        kotlin.jvm.internal.h.f(str, "<this>");
        kotlin.jvm.internal.h.f(prefix, "prefix");
        return !z10 ? str.startsWith(prefix, i10) : h(str, i10, prefix, 0, prefix.length(), z10);
    }

    public static boolean l(String str, String prefix, boolean z10) {
        kotlin.jvm.internal.h.f(str, "<this>");
        kotlin.jvm.internal.h.f(prefix, "prefix");
        return !z10 ? str.startsWith(prefix) : h(str, 0, prefix, 0, prefix.length(), z10);
    }

    public static /* synthetic */ boolean m(String str, String str2, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return k(str, str2, i10, z10);
    }

    public static /* synthetic */ boolean n(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return l(str, str2, z10);
    }
}
