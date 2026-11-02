package k7;

import java.util.Set;
import kotlin.collections.EmptySet;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class z extends y {
    public static Set b() {
        return EmptySet.INSTANCE;
    }

    public static final Set c(Set set) {
        kotlin.jvm.internal.h.f(set, "<this>");
        int size = set.size();
        return size != 0 ? size != 1 ? set : y.a(set.iterator().next()) : b();
    }
}
