package s1;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: m, reason: collision with root package name */
    public static final a f11650m = new a();

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f11651e = new AtomicBoolean();

    /* renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f11652j = new AtomicBoolean();

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f11653k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public boolean f11654l = false;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: s1.a$a, reason: collision with other inner class name */
    public interface InterfaceC0119a {
        void a(boolean z10);
    }

    public static a b() {
        return f11650m;
    }

    public static void c(Application application) {
        a aVar = f11650m;
        synchronized (aVar) {
            try {
                if (!aVar.f11654l) {
                    application.registerActivityLifecycleCallbacks(aVar);
                    application.registerComponentCallbacks(aVar);
                    aVar.f11654l = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(InterfaceC0119a interfaceC0119a) {
        synchronized (f11650m) {
            this.f11653k.add(interfaceC0119a);
        }
    }

    public boolean d() {
        return this.f11651e.get();
    }

    public final void e(boolean z10) {
        synchronized (f11650m) {
            try {
                Iterator it = this.f11653k.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0119a) it.next()).a(z10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean zCompareAndSet = this.f11651e.compareAndSet(true, false);
        this.f11652j.set(true);
        if (zCompareAndSet) {
            e(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        boolean zCompareAndSet = this.f11651e.compareAndSet(true, false);
        this.f11652j.set(true);
        if (zCompareAndSet) {
            e(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
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

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i10) {
        if (i10 == 20 && this.f11651e.compareAndSet(false, true)) {
            this.f11652j.set(true);
            e(true);
        }
    }
}
