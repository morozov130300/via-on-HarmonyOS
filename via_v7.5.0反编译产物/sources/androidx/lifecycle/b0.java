package androidx.lifecycle;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class b0 {
    public static z a(a0.b bVar, Class modelClass) {
        kotlin.jvm.internal.h.f(modelClass, "modelClass");
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    public static z b(a0.b bVar, Class modelClass, i0.a extras) {
        kotlin.jvm.internal.h.f(modelClass, "modelClass");
        kotlin.jvm.internal.h.f(extras, "extras");
        return bVar.a(modelClass);
    }
}
