package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.LegacySavedStateHandleController;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.a;
import java.util.Iterator;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class LegacySavedStateHandleController {

    /* renamed from: a, reason: collision with root package name */
    public static final LegacySavedStateHandleController f994a = new LegacySavedStateHandleController();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a implements a.InterfaceC0024a {
        @Override // androidx.savedstate.a.InterfaceC0024a
        public void a(l0.d owner) throws NoSuchMethodException, SecurityException {
            kotlin.jvm.internal.h.f(owner, "owner");
            if (!(owner instanceof c0)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
            }
            b0 b0VarD = ((c0) owner).D();
            androidx.savedstate.a aVarT = owner.T();
            Iterator it = b0VarD.c().iterator();
            while (it.hasNext()) {
                x xVarB = b0VarD.b((String) it.next());
                kotlin.jvm.internal.h.c(xVarB);
                LegacySavedStateHandleController.a(xVarB, aVarT, owner.k0());
            }
            if (b0VarD.c().isEmpty()) {
                return;
            }
            aVarT.i(a.class);
        }
    }

    public static final void a(x viewModel, androidx.savedstate.a registry, Lifecycle lifecycle) {
        kotlin.jvm.internal.h.f(viewModel, "viewModel");
        kotlin.jvm.internal.h.f(registry, "registry");
        kotlin.jvm.internal.h.f(lifecycle, "lifecycle");
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) viewModel.g("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController == null || savedStateHandleController.d()) {
            return;
        }
        savedStateHandleController.b(registry, lifecycle);
        f994a.c(registry, lifecycle);
    }

    public static final SavedStateHandleController b(androidx.savedstate.a registry, Lifecycle lifecycle, String str, Bundle bundle) {
        kotlin.jvm.internal.h.f(registry, "registry");
        kotlin.jvm.internal.h.f(lifecycle, "lifecycle");
        kotlin.jvm.internal.h.c(str);
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, t.f1060f.a(registry.b(str), bundle));
        savedStateHandleController.b(registry, lifecycle);
        f994a.c(registry, lifecycle);
        return savedStateHandleController;
    }

    public final void c(final androidx.savedstate.a aVar, final Lifecycle lifecycle) throws NoSuchMethodException, SecurityException {
        Lifecycle.State stateB = lifecycle.b();
        if (stateB == Lifecycle.State.INITIALIZED || stateB.isAtLeast(Lifecycle.State.STARTED)) {
            aVar.i(a.class);
        } else {
            lifecycle.a(new f() { // from class: androidx.lifecycle.LegacySavedStateHandleController$tryToAddRecreator$1
                @Override // androidx.lifecycle.f
                public void a(h source, Lifecycle.Event event) throws NoSuchMethodException, SecurityException {
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
