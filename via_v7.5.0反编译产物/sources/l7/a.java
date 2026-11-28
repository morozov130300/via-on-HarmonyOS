package l7;

import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends k7.a {

    /* JADX INFO: renamed from: l7.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class C0092a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0092a f7479a = new C0092a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Integer f7480b;

        static {
            Integer num;
            Integer num2 = null;
            try {
                Object obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
                num = obj instanceof Integer ? (Integer) obj : null;
            } catch (Throwable unused) {
            }
            if (num != null && num.intValue() > 0) {
                num2 = num;
            }
            f7480b = num2;
        }
    }

    private final boolean c(int i10) {
        Integer num = C0092a.f7480b;
        return num == null || num.intValue() >= i10;
    }

    @Override // k7.a
    public void a(Throwable cause, Throwable exception) throws IllegalAccessException, InvocationTargetException {
        h.f(cause, "cause");
        h.f(exception, "exception");
        if (c(19)) {
            cause.addSuppressed(exception);
        } else {
            super.a(cause, exception);
        }
    }
}
