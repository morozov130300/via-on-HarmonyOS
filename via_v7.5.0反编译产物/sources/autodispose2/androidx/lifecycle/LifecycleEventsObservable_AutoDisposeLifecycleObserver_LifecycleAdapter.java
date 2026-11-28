package autodispose2.androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.e;
import androidx.lifecycle.j;
import androidx.lifecycle.m;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class LifecycleEventsObservable_AutoDisposeLifecycleObserver_LifecycleAdapter implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleEventsObservable.AutoDisposeLifecycleObserver f1642a;

    public LifecycleEventsObservable_AutoDisposeLifecycleObserver_LifecycleAdapter(LifecycleEventsObservable.AutoDisposeLifecycleObserver autoDisposeLifecycleObserver) {
        this.f1642a = autoDisposeLifecycleObserver;
    }

    @Override // androidx.lifecycle.e
    public void a(j jVar, Lifecycle.Event event, boolean z10, m mVar) {
        boolean z11 = mVar != null;
        if (z10) {
            if (!z11 || mVar.a("onStateChange", 4)) {
                this.f1642a.onStateChange(jVar, event);
            }
        }
    }
}
