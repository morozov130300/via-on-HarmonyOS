package androidx.lifecycle;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class SavedStateHandleSupport {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i0.a.b f930a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i0.a.b f931b = new c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i0.a.b f932c = new a();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a implements i0.a.b {
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b implements i0.a.b {
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class c implements i0.a.b {
    }

    public static final v a(i0.a aVar) {
        kotlin.jvm.internal.h.f(aVar, "<this>");
        m0.d dVar = (m0.d) aVar.a(f930a);
        if (dVar == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        e0 e0Var = (e0) aVar.a(f931b);
        if (e0Var == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) aVar.a(f932c);
        String str = (String) aVar.a(a0.c.f948c);
        if (str != null) {
            return b(dVar, e0Var, str, bundle);
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
    }

    public static final v b(m0.d dVar, e0 e0Var, String str, Bundle bundle) {
        SavedStateHandlesProvider savedStateHandlesProviderD = d(dVar);
        w wVarE = e(e0Var);
        v vVar = (v) wVarE.j().get(str);
        if (vVar != null) {
            return vVar;
        }
        v vVarA = v.f975f.a(savedStateHandlesProviderD.a(str), bundle);
        wVarE.j().put(str, vVarA);
        return vVarA;
    }

    public static final void c(m0.d dVar) {
        kotlin.jvm.internal.h.f(dVar, "<this>");
        Lifecycle.State stateB = dVar.h0().b();
        if (stateB != Lifecycle.State.INITIALIZED && stateB != Lifecycle.State.CREATED) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (dVar.Q().c("androidx.lifecycle.internal.SavedStateHandlesProvider") == null) {
            SavedStateHandlesProvider savedStateHandlesProvider = new SavedStateHandlesProvider(dVar.Q(), (e0) dVar);
            dVar.Q().h("androidx.lifecycle.internal.SavedStateHandlesProvider", savedStateHandlesProvider);
            dVar.h0().a(new SavedStateHandleAttacher(savedStateHandlesProvider));
        }
    }

    public static final SavedStateHandlesProvider d(m0.d dVar) {
        kotlin.jvm.internal.h.f(dVar, "<this>");
        androidx.savedstate.a.c cVarC = dVar.Q().c("androidx.lifecycle.internal.SavedStateHandlesProvider");
        SavedStateHandlesProvider savedStateHandlesProvider = cVarC instanceof SavedStateHandlesProvider ? (SavedStateHandlesProvider) cVarC : null;
        if (savedStateHandlesProvider != null) {
            return savedStateHandlesProvider;
        }
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    }

    public static final w e(e0 e0Var) {
        kotlin.jvm.internal.h.f(e0Var, "<this>");
        i0.c cVar = new i0.c();
        cVar.a(kotlin.jvm.internal.j.b(w.class), new p7.l() { // from class: androidx.lifecycle.SavedStateHandleSupport$savedStateHandlesVM$1$1
            @Override // p7.l
            public final w invoke(i0.a initializer) {
                kotlin.jvm.internal.h.f(initializer, "$this$initializer");
                return new w();
            }
        });
        return (w) new a0(e0Var, cVar.b()).b("androidx.lifecycle.internal.SavedStateHandlesVM", w.class);
    }
}
