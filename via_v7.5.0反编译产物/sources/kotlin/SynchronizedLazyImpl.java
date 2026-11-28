package kotlin;

import d7.e;
import d7.g;
import java.io.Serializable;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
final class SynchronizedLazyImpl<T> implements e, Serializable {
    private volatile Object _value;
    private p7.a initializer;
    private final Object lock;

    public SynchronizedLazyImpl(p7.a initializer, Object obj) {
        h.f(initializer, "initializer");
        this.initializer = initializer;
        this._value = g.f3934a;
        this.lock = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // d7.e
    public T getValue() {
        T t10;
        T t11 = (T) this._value;
        g gVar = g.f3934a;
        if (t11 != gVar) {
            return t11;
        }
        synchronized (this.lock) {
            t10 = (T) this._value;
            if (t10 == gVar) {
                p7.a aVar = this.initializer;
                h.c(aVar);
                t10 = (T) aVar.invoke();
                this._value = t10;
                this.initializer = null;
            }
        }
        return t10;
    }

    public boolean isInitialized() {
        return this._value != g.f3934a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ SynchronizedLazyImpl(p7.a aVar, Object obj, int i10, f fVar) {
        this(aVar, (i10 & 2) != 0 ? null : obj);
    }
}
