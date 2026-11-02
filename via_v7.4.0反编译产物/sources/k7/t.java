package k7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class t extends s {
    public static Set A(Iterable iterable) {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return z.c((Set) w(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return z.b();
        }
        if (size != 1) {
            return (Set) w(iterable, new LinkedHashSet(x.a(collection.size())));
        }
        return y.a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static List B(Iterable iterable, Iterable other) {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        kotlin.jvm.internal.h.f(other, "other");
        Iterator it = iterable.iterator();
        Iterator it2 = other.iterator();
        ArrayList arrayList = new ArrayList(Math.min(m.j(iterable, 10), m.j(other, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(j7.d.a(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static boolean o(Iterable iterable, Object obj) {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).contains(obj) : q(iterable, obj) >= 0;
    }

    public static Object p(List list) {
        kotlin.jvm.internal.h.f(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static final int q(Iterable iterable, Object obj) {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(obj);
        }
        int i10 = 0;
        for (Object obj2 : iterable) {
            if (i10 < 0) {
                l.i();
            }
            if (kotlin.jvm.internal.h.a(obj, obj2)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static final Appendable r(Iterable iterable, Appendable buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, q7.l lVar) throws IOException {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        kotlin.jvm.internal.h.f(buffer, "buffer");
        kotlin.jvm.internal.h.f(separator, "separator");
        kotlin.jvm.internal.h.f(prefix, "prefix");
        kotlin.jvm.internal.h.f(postfix, "postfix");
        kotlin.jvm.internal.h.f(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (Object obj : iterable) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            v7.d.a(buffer, obj, lVar);
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final String s(Iterable iterable, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, q7.l lVar) {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        kotlin.jvm.internal.h.f(separator, "separator");
        kotlin.jvm.internal.h.f(prefix, "prefix");
        kotlin.jvm.internal.h.f(postfix, "postfix");
        kotlin.jvm.internal.h.f(truncated, "truncated");
        String string = ((StringBuilder) r(iterable, new StringBuilder(), separator, prefix, postfix, i10, truncated, lVar)).toString();
        kotlin.jvm.internal.h.e(string, "joinTo(StringBuilder(), \u2026ed, transform).toString()");
        return string;
    }

    public static /* synthetic */ String t(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, q7.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i11 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i11 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        CharSequence charSequence5 = charSequence4;
        q7.l lVar2 = lVar;
        return s(iterable, charSequence, charSequence2, charSequence3, i10, charSequence5, lVar2);
    }

    public static Object u(List list) {
        kotlin.jvm.internal.h.f(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(l.e(list));
    }

    public static Comparable v(Iterable iterable) {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Comparable comparable = (Comparable) it.next();
        while (it.hasNext()) {
            Comparable comparable2 = (Comparable) it.next();
            if (comparable.compareTo(comparable2) > 0) {
                comparable = comparable2;
            }
        }
        return comparable;
    }

    public static final Collection w(Iterable iterable, Collection destination) {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        kotlin.jvm.internal.h.f(destination, "destination");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    public static List x(Iterable iterable) {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return l.h(y(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return l.d();
        }
        if (size != 1) {
            return z(collection);
        }
        return k.b(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final List y(Iterable iterable) {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        return iterable instanceof Collection ? z((Collection) iterable) : (List) w(iterable, new ArrayList());
    }

    public static List z(Collection collection) {
        kotlin.jvm.internal.h.f(collection, "<this>");
        return new ArrayList(collection);
    }
}
