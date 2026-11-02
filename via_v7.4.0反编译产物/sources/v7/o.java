package v7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class o extends n {
    public static String J(String str, int i10) {
        kotlin.jvm.internal.h.f(str, "<this>");
        if (i10 >= 0) {
            String strSubstring = str.substring(t7.e.b(i10, str.length()));
            kotlin.jvm.internal.h.e(strSubstring, "this as java.lang.String).substring(startIndex)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }

    public static char K(CharSequence charSequence) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(m.q(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static String L(String str, int i10) {
        kotlin.jvm.internal.h.f(str, "<this>");
        if (i10 >= 0) {
            String strSubstring = str.substring(0, t7.e.b(i10, str.length()));
            kotlin.jvm.internal.h.e(strSubstring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }

    public static final Collection M(CharSequence charSequence, Collection destination) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        kotlin.jvm.internal.h.f(destination, "destination");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            destination.add(Character.valueOf(charSequence.charAt(i10)));
        }
        return destination;
    }

    public static List N(CharSequence charSequence) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        int length = charSequence.length();
        return length != 0 ? length != 1 ? O(charSequence) : k7.k.b(Character.valueOf(charSequence.charAt(0))) : k7.l.d();
    }

    public static final List O(CharSequence charSequence) {
        kotlin.jvm.internal.h.f(charSequence, "<this>");
        return (List) M(charSequence, new ArrayList(charSequence.length()));
    }
}
