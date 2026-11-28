package e7;

import java.util.Collections;
import java.util.Set;
import kotlin.collections.builders.SetBuilder;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class b0 {
    public static Set a(Set builder) {
        kotlin.jvm.internal.h.f(builder, "builder");
        return ((SetBuilder) builder).build();
    }

    public static Set b(int i10) {
        return new SetBuilder(i10);
    }

    public static final Set c(Object obj) {
        Set setSingleton = Collections.singleton(obj);
        kotlin.jvm.internal.h.e(setSingleton, "singleton(...)");
        return setSingleton;
    }
}
