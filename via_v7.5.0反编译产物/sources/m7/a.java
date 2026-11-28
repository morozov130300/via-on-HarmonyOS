package m7;

import kotlin.random.Random;
import r7.f;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a extends l7.a {

    /* JADX INFO: renamed from: m7.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class C0097a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0097a f7942a = new C0097a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Integer f7943b;

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
            f7943b = num2;
        }
    }

    @Override // k7.a
    public Random b() {
        return c(34) ? new f() : super.b();
    }

    public final boolean c(int i10) {
        Integer num = C0097a.f7943b;
        return num == null || num.intValue() >= i10;
    }
}
