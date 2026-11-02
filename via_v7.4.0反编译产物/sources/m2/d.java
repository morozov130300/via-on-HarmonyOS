package m2;

import java.util.Set;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract /* synthetic */ class d {
    public static Object a(e eVar, Class cls) {
        return eVar.f(b0.b(cls));
    }

    public static Object b(e eVar, b0 b0Var) {
        i3.b bVarG = eVar.g(b0Var);
        if (bVarG == null) {
            return null;
        }
        return bVarG.get();
    }

    public static i3.a c(e eVar, Class cls) {
        return eVar.d(b0.b(cls));
    }

    public static i3.b d(e eVar, Class cls) {
        return eVar.g(b0.b(cls));
    }

    public static Set e(e eVar, Class cls) {
        return eVar.b(b0.b(cls));
    }

    public static Set f(e eVar, b0 b0Var) {
        return (Set) eVar.h(b0Var).get();
    }
}
