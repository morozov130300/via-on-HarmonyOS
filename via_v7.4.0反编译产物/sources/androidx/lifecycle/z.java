package androidx.lifecycle;

import androidx.lifecycle.y;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract /* synthetic */ class z {
    public static x a(y.b bVar, Class modelClass) {
        kotlin.jvm.internal.h.f(modelClass, "modelClass");
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    public static x b(y.b bVar, Class modelClass, h0.a extras) {
        kotlin.jvm.internal.h.f(modelClass, "modelClass");
        kotlin.jvm.internal.h.f(extras, "extras");
        return bVar.a(modelClass);
    }
}
