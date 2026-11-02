package h0;

import h0.a;
import kotlin.jvm.internal.h;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d extends a {
    /* JADX WARN: Multi-variable type inference failed */
    public d() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public d(a initialExtras) {
        h.f(initialExtras, "initialExtras");
        b().putAll(initialExtras.b());
    }

    public /* synthetic */ d(a aVar, int i10, kotlin.jvm.internal.f fVar) {
        this((i10 & 1) != 0 ? a.C0074a.f6318b : aVar);
    }

    @Override // h0.a
    public Object a(a.b key) {
        h.f(key, "key");
        return b().get(key);
    }

    public final void c(a.b key, Object obj) {
        h.f(key, "key");
        b().put(key, obj);
    }
}
