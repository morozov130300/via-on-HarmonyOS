package kotlin;

import j7.c;
import j7.e;
import java.io.Serializable;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
final class SynchronizedLazyImpl<T> implements c, Serializable {
    private volatile Object _value;
    private q7.a initializer;
    private final Object lock;

    public SynchronizedLazyImpl(q7.a initializer, Object obj) {
        h.f(initializer, "initializer");
        this.initializer = initializer;
        this._value = e.f7593a;
        this.lock = obj == null ? this : obj;
    }

    public /* synthetic */ SynchronizedLazyImpl(q7.a aVar, Object obj, int i10, f fVar) {
        this(aVar, (i10 & 2) != 0 ? null : obj);
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // j7.c
    public T getValue() {
        T t10;
        T t11 = (T) this._value;
        e eVar = e.f7593a;
        if (t11 != eVar) {
            return t11;
        }
        synchronized (this.lock) {
            t10 = (T) this._value;
            if (t10 == eVar) {
                q7.a aVar = this.initializer;
                h.c(aVar);
                t10 = (T) aVar.invoke();
                this._value = t10;
                this.initializer = null;
            }
        }
        return t10;
    }

    public boolean isInitialized() {
        return this._value != e.f7593a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
