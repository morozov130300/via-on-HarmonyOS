package e7;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a implements x6.b, y6.b {

    /* renamed from: e, reason: collision with root package name */
    public final AtomicReference f4786e = new AtomicReference();

    public void a() {
    }

    @Override // y6.b
    public final void dispose() {
        DisposableHelper.dispose(this.f4786e);
    }

    @Override // y6.b
    public final boolean isDisposed() {
        return this.f4786e.get() == DisposableHelper.DISPOSED;
    }

    @Override // x6.b
    public final void onSubscribe(y6.b bVar) {
        if (io.reactivex.rxjava3.internal.util.b.c(this.f4786e, bVar, getClass())) {
            a();
        }
    }
}
