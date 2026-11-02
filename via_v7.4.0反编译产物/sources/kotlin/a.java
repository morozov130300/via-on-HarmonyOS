package kotlin;

import j7.c;
import kotlin.jvm.internal.h;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a {
    public static c a(q7.a initializer) {
        h.f(initializer, "initializer");
        return new SynchronizedLazyImpl(initializer, null, 2, null);
    }
}
