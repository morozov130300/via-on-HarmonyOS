package androidx.lifecycle;

import android.os.Bundle;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandlesProvider implements androidx.savedstate.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.savedstate.a f933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d7.e f936d;

    public SavedStateHandlesProvider(androidx.savedstate.a savedStateRegistry, final e0 viewModelStoreOwner) {
        kotlin.jvm.internal.h.f(savedStateRegistry, "savedStateRegistry");
        kotlin.jvm.internal.h.f(viewModelStoreOwner, "viewModelStoreOwner");
        this.f933a = savedStateRegistry;
        this.f936d = kotlin.a.a(new p7.a() { // from class: androidx.lifecycle.SavedStateHandlesProvider$viewModel$2
            {
                super(0);
            }

            @Override // p7.a
            public final w invoke() {
                return SavedStateHandleSupport.e(viewModelStoreOwner);
            }
        });
    }

    public final Bundle a(String key) {
        kotlin.jvm.internal.h.f(key, "key");
        d();
        Bundle bundle = this.f935c;
        Bundle bundle2 = bundle != null ? bundle.getBundle(key) : null;
        Bundle bundle3 = this.f935c;
        if (bundle3 != null) {
            bundle3.remove(key);
        }
        Bundle bundle4 = this.f935c;
        if (bundle4 != null && bundle4.isEmpty()) {
            this.f935c = null;
        }
        return bundle2;
    }

    @Override // androidx.savedstate.a.c
    public Bundle b() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f935c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry entry : c().j().entrySet()) {
            String str = (String) entry.getKey();
            Bundle bundleB = ((v) entry.getValue()).c().b();
            if (!kotlin.jvm.internal.h.a(bundleB, Bundle.EMPTY)) {
                bundle.putBundle(str, bundleB);
            }
        }
        this.f934b = false;
        return bundle;
    }

    public final w c() {
        return (w) this.f936d.getValue();
    }

    public final void d() {
        if (this.f934b) {
            return;
        }
        this.f935c = this.f933a.b("androidx.lifecycle.internal.SavedStateHandlesProvider");
        this.f934b = true;
        c();
    }
}
