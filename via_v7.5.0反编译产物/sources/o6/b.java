package o6;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements s6.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f10973c = new AtomicBoolean();

    public abstract void a();

    @Override // s6.b
    public final void dispose() {
        if (this.f10973c.compareAndSet(false, true)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                a();
            } else {
                q6.b.b().d(new Runnable() { // from class: o6.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f10972c.a();
                    }
                });
            }
        }
    }

    @Override // s6.b
    public final boolean isDisposed() {
        return this.f10973c.get();
    }
}
