package kotlin.jvm.internal;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f7318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t7.c[] f7319b;

    static {
        k kVar = null;
        try {
            kVar = (k) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (kVar == null) {
            kVar = new k();
        }
        f7318a = kVar;
        f7319b = new t7.c[0];
    }

    public static t7.e a(FunctionReference functionReference) {
        return f7318a.a(functionReference);
    }

    public static t7.c b(Class cls) {
        return f7318a.b(cls);
    }

    public static t7.d c(Class cls) {
        return f7318a.c(cls, "");
    }

    public static String d(g gVar) {
        return f7318a.d(gVar);
    }

    public static String e(Lambda lambda) {
        return f7318a.e(lambda);
    }
}
