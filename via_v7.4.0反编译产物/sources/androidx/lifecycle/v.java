package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.y;
import java.io.IOException;
import java.lang.reflect.Constructor;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class v extends y.d implements y.b {

    /* renamed from: a, reason: collision with root package name */
    public Application f1068a;

    /* renamed from: b, reason: collision with root package name */
    public final y.b f1069b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f1070c;

    /* renamed from: d, reason: collision with root package name */
    public Lifecycle f1071d;

    /* renamed from: e, reason: collision with root package name */
    public androidx.savedstate.a f1072e;

    public v(Application application, l0.d owner, Bundle bundle) {
        kotlin.jvm.internal.h.f(owner, "owner");
        this.f1072e = owner.T();
        this.f1071d = owner.k0();
        this.f1070c = bundle;
        this.f1068a = application;
        this.f1069b = application != null ? y.a.f1081e.b(application) : new y.a();
    }

    @Override // androidx.lifecycle.y.b
    public x a(Class modelClass) {
        kotlin.jvm.internal.h.f(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName != null) {
            return d(canonicalName, modelClass);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.y.b
    public x b(Class modelClass, h0.a extras) {
        kotlin.jvm.internal.h.f(modelClass, "modelClass");
        kotlin.jvm.internal.h.f(extras, "extras");
        String str = (String) extras.a(y.c.f1088c);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (extras.a(SavedStateHandleSupport.f1027a) == null || extras.a(SavedStateHandleSupport.f1028b) == null) {
            if (this.f1071d != null) {
                return d(str, modelClass);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        Application application = (Application) extras.a(y.a.f1083g);
        boolean zIsAssignableFrom = a.class.isAssignableFrom(modelClass);
        Constructor constructorC = (!zIsAssignableFrom || application == null) ? w.c(modelClass, w.f1074b) : w.c(modelClass, w.f1073a);
        return constructorC == null ? this.f1069b.b(modelClass, extras) : (!zIsAssignableFrom || application == null) ? w.d(modelClass, constructorC, SavedStateHandleSupport.a(extras)) : w.d(modelClass, constructorC, application, SavedStateHandleSupport.a(extras));
    }

    @Override // androidx.lifecycle.y.d
    public void c(x viewModel) {
        kotlin.jvm.internal.h.f(viewModel, "viewModel");
        if (this.f1071d != null) {
            androidx.savedstate.a aVar = this.f1072e;
            kotlin.jvm.internal.h.c(aVar);
            Lifecycle lifecycle = this.f1071d;
            kotlin.jvm.internal.h.c(lifecycle);
            LegacySavedStateHandleController.a(viewModel, aVar, lifecycle);
        }
    }

    public final x d(String key, Class modelClass) throws IOException {
        x xVarD;
        Application application;
        kotlin.jvm.internal.h.f(key, "key");
        kotlin.jvm.internal.h.f(modelClass, "modelClass");
        Lifecycle lifecycle = this.f1071d;
        if (lifecycle == null) {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        boolean zIsAssignableFrom = a.class.isAssignableFrom(modelClass);
        Constructor constructorC = (!zIsAssignableFrom || this.f1068a == null) ? w.c(modelClass, w.f1074b) : w.c(modelClass, w.f1073a);
        if (constructorC == null) {
            return this.f1068a != null ? this.f1069b.a(modelClass) : y.c.f1086a.a().a(modelClass);
        }
        androidx.savedstate.a aVar = this.f1072e;
        kotlin.jvm.internal.h.c(aVar);
        SavedStateHandleController savedStateHandleControllerB = LegacySavedStateHandleController.b(aVar, lifecycle, key, this.f1070c);
        if (!zIsAssignableFrom || (application = this.f1068a) == null) {
            xVarD = w.d(modelClass, constructorC, savedStateHandleControllerB.c());
        } else {
            kotlin.jvm.internal.h.c(application);
            xVarD = w.d(modelClass, constructorC, application, savedStateHandleControllerB.c());
        }
        xVarD.i("androidx.lifecycle.savedstate.vm.tag", savedStateHandleControllerB);
        return xVarD;
    }
}
