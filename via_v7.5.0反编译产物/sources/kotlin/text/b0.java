package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class b0 extends a0 {
    public static char A0(CharSequence charSequence) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(z.N(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static Character B0(CharSequence charSequence) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(charSequence.length() - 1));
    }

    public static String C0(String str, int i10) {
        kotlin.jvm.internal.h.f(str, "<this>");
        if (i10 >= 0) {
            String strSubstring = str.substring(0, s7.e.b(i10, str.length()));
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }

    public static final Collection D0(CharSequence charSequence, Collection destination) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        kotlin.jvm.internal.h.f(destination, "destination");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            destination.add(Character.valueOf(charSequence.charAt(i10)));
        }
        return destination;
    }

    public static List E0(CharSequence charSequence) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        int length = charSequence.length();
        if (length != 0) {
            return length != 1 ? F0(charSequence) : e7.n.e(Character.valueOf(charSequence.charAt(0)));
        }
        return e7.o.h();
    }

    public static final List F0(CharSequence charSequence) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        return (List) D0(charSequence, new ArrayList(charSequence.length()));
    }

    public static String x0(String str, int i10) {
        kotlin.jvm.internal.h.f(str, "<this>");
        if (i10 >= 0) {
            String strSubstring = str.substring(s7.e.b(i10, str.length()));
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }

    public static char y0(CharSequence charSequence) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(0);
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static Character z0(CharSequence charSequence, int i10) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        if (i10 < 0 || i10 >= charSequence.length()) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(i10));
    }
}
