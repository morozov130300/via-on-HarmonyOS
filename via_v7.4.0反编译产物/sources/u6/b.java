package u6;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class b implements y6.b {

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f12874e = new AtomicBoolean();

    public abstract void a();

    @Override // y6.b
    public final void dispose() {
        if (this.f12874e.compareAndSet(false, true)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                a();
            } else {
                w6.b.b().d(new Runnable() { // from class: u6.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f12873e.a();
                    }
                });
            }
        }
    }

    @Override // y6.b
    public final boolean isDisposed() {
        return this.f12874e.get();
    }
}
