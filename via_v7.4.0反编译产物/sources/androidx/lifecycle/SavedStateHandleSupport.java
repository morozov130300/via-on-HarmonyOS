package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.y;
import androidx.savedstate.a;
import h0.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class SavedStateHandleSupport {

    /* renamed from: a, reason: collision with root package name */
    public static final a.b f1027a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final a.b f1028b = new c();

    /* renamed from: c, reason: collision with root package name */
    public static final a.b f1029c = new a();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a implements a.b {
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b implements a.b {
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class c implements a.b {
    }

    public static final t a(h0.a aVar) {
        kotlin.jvm.internal.h.f(aVar, "<this>");
        l0.d dVar = (l0.d) aVar.a(f1027a);
        if (dVar == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        c0 c0Var = (c0) aVar.a(f1028b);
        if (c0Var == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) aVar.a(f1029c);
        String str = (String) aVar.a(y.c.f1088c);
        if (str != null) {
            return b(dVar, c0Var, str, bundle);
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
    }

    public static final t b(l0.d dVar, c0 c0Var, String str, Bundle bundle) {
        SavedStateHandlesProvider savedStateHandlesProviderD = d(dVar);
        u uVarE = e(c0Var);
        t tVar = (t) uVarE.j().get(str);
        if (tVar != null) {
            return tVar;
        }
        t tVarA = t.f1060f.a(savedStateHandlesProviderD.a(str), bundle);
        uVarE.j().put(str, tVarA);
        return tVarA;
    }

    public static final void c(l0.d dVar) {
        kotlin.jvm.internal.h.f(dVar, "<this>");
        Lifecycle.State stateB = dVar.k0().b();
        if (stateB != Lifecycle.State.INITIALIZED && stateB != Lifecycle.State.CREATED) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (dVar.T().c("androidx.lifecycle.internal.SavedStateHandlesProvider") == null) {
            SavedStateHandlesProvider savedStateHandlesProvider = new SavedStateHandlesProvider(dVar.T(), (c0) dVar);
            dVar.T().h("androidx.lifecycle.internal.SavedStateHandlesProvider", savedStateHandlesProvider);
            dVar.k0().a(new SavedStateHandleAttacher(savedStateHandlesProvider));
        }
    }

    public static final SavedStateHandlesProvider d(l0.d dVar) {
        kotlin.jvm.internal.h.f(dVar, "<this>");
        a.c cVarC = dVar.T().c("androidx.lifecycle.internal.SavedStateHandlesProvider");
        SavedStateHandlesProvider savedStateHandlesProvider = cVarC instanceof SavedStateHandlesProvider ? (SavedStateHandlesProvider) cVarC : null;
        if (savedStateHandlesProvider != null) {
            return savedStateHandlesProvider;
        }
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    }

    public static final u e(c0 c0Var) {
        kotlin.jvm.internal.h.f(c0Var, "<this>");
        h0.c cVar = new h0.c();
        cVar.a(kotlin.jvm.internal.j.b(u.class), new q7.l() { // from class: androidx.lifecycle.SavedStateHandleSupport$savedStateHandlesVM$1$1
            @Override // q7.l
            public final u invoke(h0.a initializer) {
                kotlin.jvm.internal.h.f(initializer, "$this$initializer");
                return new u();
            }
        });
        return (u) new y(c0Var, cVar.b()).b("androidx.lifecycle.internal.SavedStateHandlesVM", u.class);
    }
}
