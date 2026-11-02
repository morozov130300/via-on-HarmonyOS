package autodispose2.androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.c;
import androidx.lifecycle.h;
import androidx.lifecycle.k;
import autodispose2.androidx.lifecycle.LifecycleEventsObservable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class LifecycleEventsObservable_AutoDisposeLifecycleObserver_LifecycleAdapter implements c {

    /* renamed from: a, reason: collision with root package name */
    public final LifecycleEventsObservable.AutoDisposeLifecycleObserver f1743a;

    public LifecycleEventsObservable_AutoDisposeLifecycleObserver_LifecycleAdapter(LifecycleEventsObservable.AutoDisposeLifecycleObserver autoDisposeLifecycleObserver) {
        this.f1743a = autoDisposeLifecycleObserver;
    }

    @Override // androidx.lifecycle.c
    public void a(h hVar, Lifecycle.Event event, boolean z10, k kVar) {
        boolean z11 = kVar != null;
        if (z10) {
            if (!z11 || kVar.a("onStateChange", 4)) {
                this.f1743a.onStateChange(hVar, event);
            }
        }
    }
}
