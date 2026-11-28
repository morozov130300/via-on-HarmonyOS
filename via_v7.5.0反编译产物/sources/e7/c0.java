package e7;

import java.util.Set;
import kotlin.collections.EmptySet;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class c0 extends b0 {
    public static Set d() {
        return EmptySet.INSTANCE;
    }

    public static final Set e(Set set) {
        kotlin.jvm.internal.h.f(set, "<this>");
        int size = set.size();
        if (size != 0) {
            return size != 1 ? set : b0.c(set.iterator().next());
        }
        return d();
    }

    public static Set f(Object... elements) {
        kotlin.jvm.internal.h.f(elements, "elements");
        return l.w(elements);
    }
}
