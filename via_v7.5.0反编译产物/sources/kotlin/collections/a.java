package kotlin.collections;

import e7.a0;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends a0 {
    public static Map f() {
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        h.d(emptyMap, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return emptyMap;
    }

    public static Map g(Pair... pairs) {
        h.f(pairs, "pairs");
        return pairs.length > 0 ? o(pairs, new LinkedHashMap(a0.c(pairs.length))) : f();
    }

    public static Map h(Pair... pairs) {
        h.f(pairs, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(a0.c(pairs.length));
        k(linkedHashMap, pairs);
        return linkedHashMap;
    }

    public static final Map i(Map map) {
        h.f(map, "<this>");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? map : a0.e(map);
        }
        return f();
    }

    public static final void j(Map map, Iterable pairs) {
        h.f(map, "<this>");
        h.f(pairs, "pairs");
        Iterator it = pairs.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            map.put(pair.component1(), pair.component2());
        }
    }

    public static final void k(Map map, Pair[] pairs) {
        h.f(map, "<this>");
        h.f(pairs, "pairs");
        for (Pair pair : pairs) {
            map.put(pair.component1(), pair.component2());
        }
    }

    public static Map l(Iterable iterable) {
        h.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return i(m(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return f();
        }
        if (size != 1) {
            return m(iterable, new LinkedHashMap(a0.c(collection.size())));
        }
        return a0.d((Pair) (iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next()));
    }

    public static final Map m(Iterable iterable, Map destination) {
        h.f(iterable, "<this>");
        h.f(destination, "destination");
        j(destination, iterable);
        return destination;
    }

    public static Map n(Map map) {
        h.f(map, "<this>");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? p(map) : a0.e(map);
        }
        return f();
    }

    public static final Map o(Pair[] pairArr, Map destination) {
        h.f(pairArr, "<this>");
        h.f(destination, "destination");
        k(destination, pairArr);
        return destination;
    }

    public static final Map p(Map map) {
        h.f(map, "<this>");
        return new LinkedHashMap(map);
    }
}
