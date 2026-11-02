package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k7.x;
import kotlin.Pair;
import kotlin.jvm.internal.h;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a extends x {
    public static Map d() {
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        h.d(emptyMap, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return emptyMap;
    }

    public static final Map e(Map map) {
        h.f(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? map : x.c(map) : d();
    }

    public static final void f(Map map, Iterable pairs) {
        h.f(map, "<this>");
        h.f(pairs, "pairs");
        Iterator it = pairs.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            map.put(pair.component1(), pair.component2());
        }
    }

    public static Map g(Iterable iterable) {
        h.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return e(h(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return d();
        }
        if (size != 1) {
            return h(iterable, new LinkedHashMap(x.a(collection.size())));
        }
        return x.b((Pair) (iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next()));
    }

    public static final Map h(Iterable iterable, Map destination) {
        h.f(iterable, "<this>");
        h.f(destination, "destination");
        f(destination, iterable);
        return destination;
    }

    public static Map i(Map map) {
        h.f(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? j(map) : x.c(map) : d();
    }

    public static final Map j(Map map) {
        h.f(map, "<this>");
        return new LinkedHashMap(map);
    }
}
