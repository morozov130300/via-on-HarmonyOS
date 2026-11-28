package n2;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class d {
    public static Object a(e eVar, Class cls) {
        return eVar.g(b0.b(cls));
    }

    public static Object b(e eVar, b0 b0Var) {
        j3.b bVarF = eVar.f(b0Var);
        if (bVarF == null) {
            return null;
        }
        return bVarF.get();
    }

    public static j3.a c(e eVar, Class cls) {
        return eVar.b(b0.b(cls));
    }

    public static j3.b d(e eVar, Class cls) {
        return eVar.f(b0.b(cls));
    }

    public static Set e(e eVar, Class cls) {
        return eVar.c(b0.b(cls));
    }

    public static Set f(e eVar, b0 b0Var) {
        return (Set) eVar.e(b0Var).get();
    }
}
