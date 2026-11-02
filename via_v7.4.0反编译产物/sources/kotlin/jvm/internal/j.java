package kotlin.jvm.internal;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final k f8304a;

    /* renamed from: b, reason: collision with root package name */
    public static final u7.c[] f8305b;

    static {
        k kVar = null;
        try {
            kVar = (k) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (kVar == null) {
            kVar = new k();
        }
        f8304a = kVar;
        f8305b = new u7.c[0];
    }

    public static u7.e a(FunctionReference functionReference) {
        return f8304a.a(functionReference);
    }

    public static u7.c b(Class cls) {
        return f8304a.b(cls);
    }

    public static u7.d c(Class cls) {
        return f8304a.c(cls, "");
    }

    public static String d(Lambda lambda) {
        return f8304a.e(lambda);
    }
}
