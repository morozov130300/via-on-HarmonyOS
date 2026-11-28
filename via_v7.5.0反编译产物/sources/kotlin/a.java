package kotlin;

import d7.e;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static e a(p7.a initializer) {
        h.f(initializer, "initializer");
        return new SynchronizedLazyImpl(initializer, null, 2, null);
    }
}
