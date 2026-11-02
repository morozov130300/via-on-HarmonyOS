package k7;

import java.util.Collection;
import java.util.Iterator;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class q extends p {
    public static boolean l(Collection collection, Iterable elements) {
        kotlin.jvm.internal.h.f(collection, "<this>");
        kotlin.jvm.internal.h.f(elements, "elements");
        if (elements instanceof Collection) {
            return collection.addAll((Collection) elements);
        }
        Iterator it = elements.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z10 = true;
            }
        }
        return z10;
    }

    public static final boolean m(Iterable iterable, q7.l lVar, boolean z10) {
        Iterator it = iterable.iterator();
        boolean z11 = false;
        while (it.hasNext()) {
            if (((Boolean) lVar.invoke(it.next())).booleanValue() == z10) {
                it.remove();
                z11 = true;
            }
        }
        return z11;
    }

    public static boolean n(Iterable iterable, q7.l predicate) {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        kotlin.jvm.internal.h.f(predicate, "predicate");
        return m(iterable, predicate, false);
    }
}
