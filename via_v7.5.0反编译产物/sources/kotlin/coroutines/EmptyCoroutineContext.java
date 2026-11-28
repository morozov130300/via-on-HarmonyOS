package kotlin.coroutines;

import java.io.Serializable;
import kotlin.jvm.internal.h;
import p7.p;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class EmptyCoroutineContext implements b, Serializable {
    public static final EmptyCoroutineContext INSTANCE = new EmptyCoroutineContext();
    private static final long serialVersionUID = 0;

    private EmptyCoroutineContext() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    public <R> R fold(R r10, p operation) {
        h.f(operation, "operation");
        return r10;
    }

    @Override // kotlin.coroutines.b
    public <E extends b.a> E get(b.InterfaceC0091b key) {
        h.f(key, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    public b minusKey(b.InterfaceC0091b key) {
        h.f(key, "key");
        return this;
    }

    public b plus(b context) {
        h.f(context, "context");
        return context;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
