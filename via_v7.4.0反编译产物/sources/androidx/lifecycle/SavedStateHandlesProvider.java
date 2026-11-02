package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.a;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class SavedStateHandlesProvider implements a.c {

    /* renamed from: a, reason: collision with root package name */
    public final androidx.savedstate.a f1030a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1031b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f1032c;

    /* renamed from: d, reason: collision with root package name */
    public final j7.c f1033d;

    public SavedStateHandlesProvider(androidx.savedstate.a savedStateRegistry, final c0 viewModelStoreOwner) {
        kotlin.jvm.internal.h.f(savedStateRegistry, "savedStateRegistry");
        kotlin.jvm.internal.h.f(viewModelStoreOwner, "viewModelStoreOwner");
        this.f1030a = savedStateRegistry;
        this.f1033d = kotlin.a.a(new q7.a() { // from class: androidx.lifecycle.SavedStateHandlesProvider$viewModel$2
            {
                super(0);
            }

            @Override // q7.a
            public final u invoke() {
                return SavedStateHandleSupport.e(viewModelStoreOwner);
            }
        });
    }

    public final Bundle a(String key) {
        kotlin.jvm.internal.h.f(key, "key");
        d();
        Bundle bundle = this.f1032c;
        Bundle bundle2 = bundle != null ? bundle.getBundle(key) : null;
        Bundle bundle3 = this.f1032c;
        if (bundle3 != null) {
            bundle3.remove(key);
        }
        Bundle bundle4 = this.f1032c;
        if (bundle4 != null && bundle4.isEmpty()) {
            this.f1032c = null;
        }
        return bundle2;
    }

    @Override // androidx.savedstate.a.c
    public Bundle b() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f1032c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry entry : c().j().entrySet()) {
            String str = (String) entry.getKey();
            Bundle bundleB = ((t) entry.getValue()).c().b();
            if (!kotlin.jvm.internal.h.a(bundleB, Bundle.EMPTY)) {
                bundle.putBundle(str, bundleB);
            }
        }
        this.f1031b = false;
        return bundle;
    }

    public final u c() {
        return (u) this.f1033d.getValue();
    }

    public final void d() {
        if (this.f1031b) {
            return;
        }
        this.f1032c = this.f1030a.b("androidx.lifecycle.internal.SavedStateHandlesProvider");
        this.f1031b = true;
        c();
    }
}
