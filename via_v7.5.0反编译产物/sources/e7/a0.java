package e7;

import java.util.Collections;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.builders.MapBuilder;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a0 extends z {
    public static Map a(Map builder) {
        kotlin.jvm.internal.h.f(builder, "builder");
        return ((MapBuilder) builder).build();
    }

    public static Map b(int i10) {
        return new MapBuilder(i10);
    }

    public static int c(int i10) {
        if (i10 < 0) {
            return i10;
        }
        if (i10 < 3) {
            return i10 + 1;
        }
        if (i10 < 1073741824) {
            return (int) ((i10 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static Map d(Pair pair) {
        kotlin.jvm.internal.h.f(pair, "pair");
        Map mapSingletonMap = Collections.singletonMap(pair.getFirst(), pair.getSecond());
        kotlin.jvm.internal.h.e(mapSingletonMap, "singletonMap(...)");
        return mapSingletonMap;
    }

    public static final Map e(Map map) {
        kotlin.jvm.internal.h.f(map, "<this>");
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        kotlin.jvm.internal.h.e(mapSingletonMap, "with(...)");
        return mapSingletonMap;
    }
}
