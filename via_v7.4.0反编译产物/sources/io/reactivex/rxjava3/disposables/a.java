package io.reactivex.rxjava3.disposables;

import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;
import y6.b;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static b a() {
        return EmptyDisposable.INSTANCE;
    }

    public static b b() {
        return c(c7.a.f2309b);
    }

    public static b c(Runnable runnable) {
        Objects.requireNonNull(runnable, "run is null");
        return new RunnableDisposable(runnable);
    }
}
