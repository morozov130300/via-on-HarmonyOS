package i0;

import androidx.lifecycle.a0;
import androidx.lifecycle.b0;
import androidx.lifecycle.z;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b implements a0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f[] f6188a;

    public b(f... initializers) {
        h.f(initializers, "initializers");
        this.f6188a = initializers;
    }

    @Override // androidx.lifecycle.a0.b
    public /* synthetic */ z a(Class cls) {
        return b0.a(this, cls);
    }

    @Override // androidx.lifecycle.a0.b
    public z b(Class modelClass, a extras) {
        h.f(modelClass, "modelClass");
        h.f(extras, "extras");
        z zVar = null;
        for (f fVar : this.f6188a) {
            if (h.a(fVar.a(), modelClass)) {
                Object objInvoke = fVar.b().invoke(extras);
                zVar = objInvoke instanceof z ? (z) objInvoke : null;
            }
        }
        if (zVar != null) {
            return zVar;
        }
        throw new IllegalArgumentException("No initializer set for given class " + modelClass.getName());
    }
}
