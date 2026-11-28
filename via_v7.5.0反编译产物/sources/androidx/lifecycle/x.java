package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import java.lang.reflect.Constructor;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class x extends a0.d implements a0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Application f983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a0.b f984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Lifecycle f986d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public androidx.savedstate.a f987e;

    public x(Application application, m0.d owner, Bundle bundle) {
        kotlin.jvm.internal.h.f(owner, "owner");
        this.f987e = owner.Q();
        this.f986d = owner.h0();
        this.f985c = bundle;
        this.f983a = application;
        this.f984b = application != null ? a0.a.f941e.b(application) : new a0.a();
    }

    @Override // androidx.lifecycle.a0.b
    public z a(Class modelClass) {
        kotlin.jvm.internal.h.f(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName != null) {
            return d(canonicalName, modelClass);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.a0.b
    public z b(Class modelClass, i0.a extras) {
        kotlin.jvm.internal.h.f(modelClass, "modelClass");
        kotlin.jvm.internal.h.f(extras, "extras");
        String str = (String) extras.a(a0.c.f948c);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (extras.a(SavedStateHandleSupport.f930a) == null || extras.a(SavedStateHandleSupport.f931b) == null) {
            if (this.f986d != null) {
                return d(str, modelClass);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        Application application = (Application) extras.a(a0.a.f943g);
        boolean zIsAssignableFrom = a.class.isAssignableFrom(modelClass);
        Constructor constructorC = (!zIsAssignableFrom || application == null) ? y.c(modelClass, y.f989b) : y.c(modelClass, y.f988a);
        if (constructorC == null) {
            return this.f984b.b(modelClass, extras);
        }
        return (!zIsAssignableFrom || application == null) ? y.d(modelClass, constructorC, SavedStateHandleSupport.a(extras)) : y.d(modelClass, constructorC, application, SavedStateHandleSupport.a(extras));
    }

    @Override // androidx.lifecycle.a0.d
    public void c(z viewModel) {
        kotlin.jvm.internal.h.f(viewModel, "viewModel");
        if (this.f986d != null) {
            androidx.savedstate.a aVar = this.f987e;
            kotlin.jvm.internal.h.c(aVar);
            Lifecycle lifecycle = this.f986d;
            kotlin.jvm.internal.h.c(lifecycle);
            LegacySavedStateHandleController.a(viewModel, aVar, lifecycle);
        }
    }

    public final z d(String key, Class modelClass) {
        z zVarD;
        Application application;
        kotlin.jvm.internal.h.f(key, "key");
        kotlin.jvm.internal.h.f(modelClass, "modelClass");
        Lifecycle lifecycle = this.f986d;
        if (lifecycle == null) {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        boolean zIsAssignableFrom = a.class.isAssignableFrom(modelClass);
        Constructor constructorC = (!zIsAssignableFrom || this.f983a == null) ? y.c(modelClass, y.f989b) : y.c(modelClass, y.f988a);
        if (constructorC == null) {
            return this.f983a != null ? this.f984b.a(modelClass) : a0.c.f946a.a().a(modelClass);
        }
        androidx.savedstate.a aVar = this.f987e;
        kotlin.jvm.internal.h.c(aVar);
        SavedStateHandleController savedStateHandleControllerB = LegacySavedStateHandleController.b(aVar, lifecycle, key, this.f985c);
        if (!zIsAssignableFrom || (application = this.f983a) == null) {
            zVarD = y.d(modelClass, constructorC, savedStateHandleControllerB.d());
        } else {
            kotlin.jvm.internal.h.c(application);
            zVarD = y.d(modelClass, constructorC, application, savedStateHandleControllerB.d());
        }
        zVarD.i("androidx.lifecycle.savedstate.vm.tag", savedStateHandleControllerB);
        return zVarD;
    }
}
