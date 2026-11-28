package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.j;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import m0.d;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f1526g = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f1529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1530d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Recreator.b f1531e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g.b f1527a = new g.b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1532f = true;

    /* JADX INFO: renamed from: androidx.savedstate.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface InterfaceC0023a {
        void a(d dVar);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b {
        public /* synthetic */ b(f fVar) {
            this();
        }

        public b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface c {
        Bundle b();
    }

    public static final void d(a this$0, j jVar, Lifecycle.Event event) {
        h.f(this$0, "this$0");
        h.f(jVar, "<anonymous parameter 0>");
        h.f(event, "event");
        if (event == Lifecycle.Event.ON_START) {
            this$0.f1532f = true;
        } else if (event == Lifecycle.Event.ON_STOP) {
            this$0.f1532f = false;
        }
    }

    public final Bundle b(String key) {
        h.f(key, "key");
        if (!this.f1530d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.f1529c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle != null ? bundle.getBundle(key) : null;
        Bundle bundle3 = this.f1529c;
        if (bundle3 != null) {
            bundle3.remove(key);
        }
        Bundle bundle4 = this.f1529c;
        if (bundle4 != null && !bundle4.isEmpty()) {
            return bundle2;
        }
        this.f1529c = null;
        return bundle2;
    }

    public final c c(String key) {
        h.f(key, "key");
        for (Map.Entry components : this.f1527a) {
            h.e(components, "components");
            String str = (String) components.getKey();
            c cVar = (c) components.getValue();
            if (h.a(str, key)) {
                return cVar;
            }
        }
        return null;
    }

    public final void e(Lifecycle lifecycle) {
        h.f(lifecycle, "lifecycle");
        if (this.f1528b) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        lifecycle.a(new androidx.lifecycle.h() { // from class: m0.b
            @Override // androidx.lifecycle.h
            public final void e(j jVar, Lifecycle.Event event) {
                androidx.savedstate.a.d(this.f7783c, jVar, event);
            }
        });
        this.f1528b = true;
    }

    public final void f(Bundle bundle) {
        if (!this.f1528b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
        }
        if (this.f1530d) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        this.f1529c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        this.f1530d = true;
    }

    public final void g(Bundle outBundle) {
        h.f(outBundle, "outBundle");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f1529c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        g.b.d dVarG = this.f1527a.g();
        h.e(dVarG, "this.components.iteratorWithAdditions()");
        while (dVarG.hasNext()) {
            Map.Entry entry = (Map.Entry) dVarG.next();
            bundle.putBundle((String) entry.getKey(), ((c) entry.getValue()).b());
        }
        if (bundle.isEmpty()) {
            return;
        }
        outBundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle);
    }

    public final void h(String key, c provider) {
        h.f(key, "key");
        h.f(provider, "provider");
        if (((c) this.f1527a.n(key, provider)) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public final void i(Class clazz) {
        h.f(clazz, "clazz");
        if (!this.f1532f) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        Recreator.b bVar = this.f1531e;
        if (bVar == null) {
            bVar = new Recreator.b(this);
        }
        this.f1531e = bVar;
        try {
            clazz.getDeclaredConstructor(null);
            Recreator.b bVar2 = this.f1531e;
            if (bVar2 != null) {
                String name = clazz.getName();
                h.e(name, "clazz.name");
                bVar2.a(name);
            }
        } catch (NoSuchMethodException e10) {
            throw new IllegalArgumentException("Class " + clazz.getSimpleName() + " must have default constructor in order to be automatically recreated", e10);
        }
    }
}
