package k7;

import java.util.Collection;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class m extends l {
    public static int j(Iterable iterable, int i10) {
        kotlin.jvm.internal.h.f(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i10;
    }
}
