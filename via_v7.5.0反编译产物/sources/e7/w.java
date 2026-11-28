package e7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class w extends v {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a implements u7.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f4281a;

        public a(Iterable iterable) {
            this.f4281a = iterable;
        }

        @Override // u7.f
        public Iterator iterator() {
            return this.f4281a.iterator();
        }
    }

    public static final int A(Iterable iterable, Object obj) {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(obj);
        }
        int i10 = 0;
        for (Object obj2 : iterable) {
            if (i10 < 0) {
                o.n();
            }
            if (kotlin.jvm.internal.h.a(obj, obj2)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static final Appendable B(Iterable iterable, Appendable buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, p7.l lVar) throws IOException {
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
            kotlin.text.n.a(buffer, obj, lVar);
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final String D(Iterable iterable, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, p7.l lVar) {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        kotlin.jvm.internal.h.f(separator, "separator");
        kotlin.jvm.internal.h.f(prefix, "prefix");
        kotlin.jvm.internal.h.f(postfix, "postfix");
        kotlin.jvm.internal.h.f(truncated, "truncated");
        return ((StringBuilder) B(iterable, new StringBuilder(), separator, prefix, postfix, i10, truncated, lVar)).toString();
    }

    public static /* synthetic */ String E(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, p7.l lVar, int i11, Object obj) {
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
        p7.l lVar2 = lVar;
        return D(iterable, charSequence, charSequence2, charSequence3, i10, charSequence5, lVar2);
    }

    public static Object F(List list) {
        kotlin.jvm.internal.h.f(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(o.j(list));
    }

    public static Comparable G(Iterable iterable) {
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

    public static List H(Collection collection, Iterable elements) {
        kotlin.jvm.internal.h.f(collection, "<this>");
        kotlin.jvm.internal.h.f(elements, "elements");
        if (!(elements instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            t.r(arrayList, elements);
            return arrayList;
        }
        Collection collection2 = (Collection) elements;
        ArrayList arrayList2 = new ArrayList(collection.size() + collection2.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static List I(Iterable iterable, Comparator comparator) {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        kotlin.jvm.internal.h.f(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List listN = N(iterable);
            s.q(listN, comparator);
            return listN;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return M(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        k.i(array, comparator);
        return k.c(array);
    }

    public static List J(Iterable iterable, int i10) {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return o.h();
        }
        if (iterable instanceof Collection) {
            if (i10 >= ((Collection) iterable).size()) {
                return M(iterable);
            }
            if (i10 == 1) {
                return n.e(w(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i10);
        Iterator it = iterable.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return o.m(arrayList);
    }

    public static byte[] K(Collection collection) {
        kotlin.jvm.internal.h.f(collection, "<this>");
        byte[] bArr = new byte[collection.size()];
        Iterator it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            bArr[i10] = ((Number) it.next()).byteValue();
            i10++;
        }
        return bArr;
    }

    public static final Collection L(Iterable iterable, Collection destination) {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        kotlin.jvm.internal.h.f(destination, "destination");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    public static List M(Iterable iterable) {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return o.m(N(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return o.h();
        }
        if (size != 1) {
            return O(collection);
        }
        return n.e(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static final List N(Iterable iterable) {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        return iterable instanceof Collection ? O((Collection) iterable) : (List) L(iterable, new ArrayList());
    }

    public static List O(Collection collection) {
        kotlin.jvm.internal.h.f(collection, "<this>");
        return new ArrayList(collection);
    }

    public static Set P(Iterable iterable) {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return c0.e((Set) L(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return c0.d();
        }
        if (size != 1) {
            return (Set) L(iterable, new LinkedHashSet(a0.c(collection.size())));
        }
        return b0.c(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static List Q(Iterable iterable, Iterable other) {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        kotlin.jvm.internal.h.f(other, "other");
        Iterator it = iterable.iterator();
        Iterator it2 = other.iterator();
        ArrayList arrayList = new ArrayList(Math.min(p.o(iterable, 10), p.o(other, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(d7.f.a(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static u7.f u(Iterable iterable) {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        return new a(iterable);
    }

    public static boolean v(Iterable iterable, Object obj) {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(obj);
        }
        return A(iterable, obj) >= 0;
    }

    public static Object w(Iterable iterable) {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        if (iterable instanceof List) {
            return x((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final Object x(List list) {
        kotlin.jvm.internal.h.f(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static Object y(List list) {
        kotlin.jvm.internal.h.f(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static Object z(List list, int i10) {
        kotlin.jvm.internal.h.f(list, "<this>");
        if (i10 < 0 || i10 >= list.size()) {
            return null;
        }
        return list.get(i10);
    }
}
