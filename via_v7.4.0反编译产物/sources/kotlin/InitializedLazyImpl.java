package kotlin;

import j7.c;
import java.io.Serializable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class InitializedLazyImpl<T> implements c, Serializable {
    private final T value;

    public InitializedLazyImpl(T t10) {
        this.value = t10;
    }

    @Override // j7.c
    public T getValue() {
        return this.value;
    }

    public boolean isInitialized() {
        return true;
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
