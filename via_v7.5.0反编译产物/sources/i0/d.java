package i0;

import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d extends a {
    /* JADX WARN: Multi-variable type inference failed */
    public d() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // i0.a
    public Object a(a.b key) {
        h.f(key, "key");
        return b().get(key);
    }

    public final void c(a.b key, Object obj) {
        h.f(key, "key");
        b().put(key, obj);
    }

    public d(a initialExtras) {
        h.f(initialExtras, "initialExtras");
        b().putAll(initialExtras.b());
    }

    public /* synthetic */ d(a aVar, int i10, kotlin.jvm.internal.f fVar) {
        this((i10 & 1) != 0 ? a.C0074a.f6187b : aVar);
    }
}
