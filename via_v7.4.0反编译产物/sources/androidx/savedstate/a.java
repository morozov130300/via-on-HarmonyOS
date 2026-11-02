package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.h;
import androidx.savedstate.Recreator;
import g.b;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.f;
import l0.d;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: g, reason: collision with root package name */
    public static final b f1625g = new b(null);

    /* renamed from: b, reason: collision with root package name */
    public boolean f1627b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f1628c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1629d;

    /* renamed from: e, reason: collision with root package name */
    public Recreator.b f1630e;

    /* renamed from: a, reason: collision with root package name */
    public final g.b f1626a = new g.b();

    /* renamed from: f, reason: collision with root package name */
    public boolean f1631f = true;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: androidx.savedstate.a$a, reason: collision with other inner class name */
    public interface InterfaceC0024a {
        void a(d dVar);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface c {
        Bundle b();
    }

    public static final void d(a this$0, h hVar, Lifecycle.Event event) {
        kotlin.jvm.internal.h.f(this$0, "this$0");
        kotlin.jvm.internal.h.f(hVar, "<anonymous parameter 0>");
        kotlin.jvm.internal.h.f(event, "event");
        if (event == Lifecycle.Event.ON_START) {
            this$0.f1631f = true;
        } else if (event == Lifecycle.Event.ON_STOP) {
            this$0.f1631f = false;
        }
    }

    public final Bundle b(String key) {
        kotlin.jvm.internal.h.f(key, "key");
        if (!this.f1629d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.f1628c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle != null ? bundle.getBundle(key) : null;
        Bundle bundle3 = this.f1628c;
        if (bundle3 != null) {
            bundle3.remove(key);
        }
        Bundle bundle4 = this.f1628c;
        if (bundle4 != null && !bundle4.isEmpty()) {
            return bundle2;
        }
        this.f1628c = null;
        return bundle2;
    }

    public final c c(String key) {
        kotlin.jvm.internal.h.f(key, "key");
        Iterator it = this.f1626a.iterator();
        while (it.hasNext()) {
            Map.Entry components = (Map.Entry) it.next();
            kotlin.jvm.internal.h.e(components, "components");
            String str = (String) components.getKey();
            c cVar = (c) components.getValue();
            if (kotlin.jvm.internal.h.a(str, key)) {
                return cVar;
            }
        }
        return null;
    }

    public final void e(Lifecycle lifecycle) {
        kotlin.jvm.internal.h.f(lifecycle, "lifecycle");
        if (this.f1627b) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        lifecycle.a(new androidx.lifecycle.f() { // from class: l0.b
            @Override // androidx.lifecycle.f
            public final void a(h hVar, Lifecycle.Event event) {
                androidx.savedstate.a.d(this.f8309e, hVar, event);
            }
        });
        this.f1627b = true;
    }

    public final void f(Bundle bundle) {
        if (!this.f1627b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
        }
        if (this.f1629d) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        this.f1628c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        this.f1629d = true;
    }

    public final void g(Bundle outBundle) {
        kotlin.jvm.internal.h.f(outBundle, "outBundle");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f1628c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        b.d dVarG = this.f1626a.g();
        kotlin.jvm.internal.h.e(dVarG, "this.components.iteratorWithAdditions()");
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
        kotlin.jvm.internal.h.f(key, "key");
        kotlin.jvm.internal.h.f(provider, "provider");
        if (((c) this.f1626a.n(key, provider)) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public final void i(Class clazz) throws NoSuchMethodException, SecurityException {
        kotlin.jvm.internal.h.f(clazz, "clazz");
        if (!this.f1631f) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        Recreator.b bVar = this.f1630e;
        if (bVar == null) {
            bVar = new Recreator.b(this);
        }
        this.f1630e = bVar;
        try {
            clazz.getDeclaredConstructor(null);
            Recreator.b bVar2 = this.f1630e;
            if (bVar2 != null) {
                String name = clazz.getName();
                kotlin.jvm.internal.h.e(name, "clazz.name");
                bVar2.a(name);
            }
        } catch (NoSuchMethodException e10) {
            throw new IllegalArgumentException("Class " + clazz.getSimpleName() + " must have default constructor in order to be automatically recreated", e10);
        }
    }
}
