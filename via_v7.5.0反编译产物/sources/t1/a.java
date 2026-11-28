package t1;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f12318o = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f12319c = new AtomicBoolean();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f12320e = new AtomicBoolean();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList f12321m = new ArrayList();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f12322n = false;

    /* JADX INFO: renamed from: t1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface InterfaceC0122a {
        void a(boolean z10);
    }

    public static a b() {
        return f12318o;
    }

    public static void c(Application application) {
        a aVar = f12318o;
        synchronized (aVar) {
            try {
                if (!aVar.f12322n) {
                    application.registerActivityLifecycleCallbacks(aVar);
                    application.registerComponentCallbacks(aVar);
                    aVar.f12322n = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(InterfaceC0122a interfaceC0122a) {
        synchronized (f12318o) {
            this.f12321m.add(interfaceC0122a);
        }
    }

    public boolean d() {
        return this.f12319c.get();
    }

    public final void e(boolean z10) {
        synchronized (f12318o) {
            try {
                Iterator it = this.f12321m.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0122a) it.next()).a(z10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean zCompareAndSet = this.f12319c.compareAndSet(true, false);
        this.f12320e.set(true);
        if (zCompareAndSet) {
            e(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        boolean zCompareAndSet = this.f12319c.compareAndSet(true, false);
        this.f12320e.set(true);
        if (zCompareAndSet) {
            e(false);
        }
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i10) {
        if (i10 == 20 && this.f12319c.compareAndSet(false, true)) {
            this.f12320e.set(true);
            e(true);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
