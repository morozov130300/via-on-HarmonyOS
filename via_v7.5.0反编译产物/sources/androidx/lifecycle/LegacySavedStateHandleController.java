package androidx.lifecycle;

import android.os.Bundle;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class LegacySavedStateHandleController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LegacySavedStateHandleController f896a = new LegacySavedStateHandleController();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a implements androidx.savedstate.a.InterfaceC0023a {
        @Override // androidx.savedstate.a.InterfaceC0023a
        public void a(m0.d owner) {
            kotlin.jvm.internal.h.f(owner, "owner");
            if (!(owner instanceof e0)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
            }
            d0 d0VarB = ((e0) owner).B();
            androidx.savedstate.a aVarQ = owner.Q();
            Iterator it = d0VarB.c().iterator();
            while (it.hasNext()) {
                z zVarB = d0VarB.b((String) it.next());
                kotlin.jvm.internal.h.c(zVarB);
                LegacySavedStateHandleController.a(zVarB, aVarQ, owner.h0());
            }
            if (d0VarB.c().isEmpty()) {
                return;
            }
            aVarQ.i(a.class);
        }
    }

    public static final void a(z viewModel, androidx.savedstate.a registry, Lifecycle lifecycle) {
        kotlin.jvm.internal.h.f(viewModel, "viewModel");
        kotlin.jvm.internal.h.f(registry, "registry");
        kotlin.jvm.internal.h.f(lifecycle, "lifecycle");
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) viewModel.g("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController == null || savedStateHandleController.h()) {
            return;
        }
        savedStateHandleController.a(registry, lifecycle);
        f896a.c(registry, lifecycle);
    }

    public static final SavedStateHandleController b(androidx.savedstate.a registry, Lifecycle lifecycle, String str, Bundle bundle) {
        kotlin.jvm.internal.h.f(registry, "registry");
        kotlin.jvm.internal.h.f(lifecycle, "lifecycle");
        kotlin.jvm.internal.h.c(str);
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, v.f975f.a(registry.b(str), bundle));
        savedStateHandleController.a(registry, lifecycle);
        f896a.c(registry, lifecycle);
        return savedStateHandleController;
    }

    public final void c(final androidx.savedstate.a aVar, final Lifecycle lifecycle) {
        Lifecycle.State stateB = lifecycle.b();
        if (stateB == Lifecycle.State.INITIALIZED || stateB.isAtLeast(Lifecycle.State.STARTED)) {
            aVar.i(a.class);
        } else {
            lifecycle.a(new h() { // from class: androidx.lifecycle.LegacySavedStateHandleController$tryToAddRecreator$1
                @Override // androidx.lifecycle.h
                public void e(j source, Lifecycle.Event event) {
                    kotlin.jvm.internal.h.f(source, "source");
                    kotlin.jvm.internal.h.f(event, "event");
                    if (event == Lifecycle.Event.ON_START) {
                        lifecycle.c(this);
                        aVar.i(LegacySavedStateHandleController.a.class);
                    }
                }
            });
        }
    }
}
