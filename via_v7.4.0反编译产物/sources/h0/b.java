package h0;

import androidx.lifecycle.x;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import kotlin.jvm.internal.h;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b implements y.b {

    /* renamed from: a, reason: collision with root package name */
    public final f[] f6319a;

    public b(f... initializers) {
        h.f(initializers, "initializers");
        this.f6319a = initializers;
    }

    @Override // androidx.lifecycle.y.b
    public /* synthetic */ x a(Class cls) {
        return z.a(this, cls);
    }

    @Override // androidx.lifecycle.y.b
    public x b(Class modelClass, a extras) {
        h.f(modelClass, "modelClass");
        h.f(extras, "extras");
        x xVar = null;
        for (f fVar : this.f6319a) {
            if (h.a(fVar.a(), modelClass)) {
                Object objInvoke = fVar.b().invoke(extras);
                xVar = objInvoke instanceof x ? (x) objInvoke : null;
            }
        }
        if (xVar != null) {
            return xVar;
        }
        throw new IllegalArgumentException("No initializer set for given class " + modelClass.getName());
    }
}
