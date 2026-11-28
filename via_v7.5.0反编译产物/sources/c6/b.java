package c6;

import com.tuyafeng.wormhole.AdMarkingBridge;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f1959a = new b();

    public final void a(c2 c2Var) {
        if (c2Var == null) {
            return;
        }
        c2.a.a(c2Var, a.f1955a.b(), null, 2, null);
    }

    public final void b(c2 c2Var) {
        if (c2Var == null) {
            return;
        }
        c2.a.a(c2Var, a.f1955a.d(), null, 2, null);
    }

    public final String c(String element) {
        kotlin.jvm.internal.h.f(element, "element");
        return a.f1955a.e(kotlin.text.x.z(kotlin.text.x.z(kotlin.text.x.z(kotlin.text.x.z(element, "\\", "\\\\", false, 4, null), "\"", "\\\"", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null));
    }

    public final String d(boolean z10) {
        return "window.__setMarkerPreview && window.__setMarkerPreview(" + z10 + ");";
    }

    public final String e(String secret, AdMarkingBridge bridge) {
        kotlin.jvm.internal.h.f(secret, "secret");
        kotlin.jvm.internal.h.f(bridge, "bridge");
        a aVar = a.f1955a;
        b2 b2Var = b2.f1963a;
        return aVar.a(b2Var.o(bridge.name()), b2Var.o(secret));
    }

    public final void f(c2 c2Var, String str) {
        if (c2Var == null || str == null || str.length() == 0) {
            return;
        }
        c2.a.a(c2Var, c(str), null, 2, null);
    }

    public final void g(c2 c2Var, String str) {
        if (c2Var == null || str == null || str.length() == 0) {
            return;
        }
        c2.a.a(c2Var, e(str, AdMarkingBridge.LEGACY), null, 2, null);
    }

    public final void h(c2 c2Var) {
        if (c2Var == null) {
            return;
        }
        c2.a.a(c2Var, a.f1955a.f(), null, 2, null);
    }

    public final void i(c2 c2Var) {
        if (c2Var == null) {
            return;
        }
        c2.a.a(c2Var, a.f1955a.g(), null, 2, null);
    }

    public final void j(c2 c2Var, String str) {
        if (c2Var == null || str == null || str.length() == 0) {
            return;
        }
        c2.a.a(c2Var, e(str, AdMarkingBridge.LEGACY), null, 2, null);
        c2.a.a(c2Var, a.f1955a.c(), null, 2, null);
    }
}
