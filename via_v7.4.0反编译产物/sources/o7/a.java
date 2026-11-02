package o7;

import kotlin.random.Random;
import s7.f;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a extends n7.a {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: o7.a$a, reason: collision with other inner class name */
    public static final class C0107a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0107a f10455a = new C0107a();

        /* renamed from: b, reason: collision with root package name */
        public static final Integer f10456b;

        static {
            Object obj;
            Integer num = null;
            try {
                obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Throwable unused) {
            }
            Integer num2 = obj instanceof Integer ? (Integer) obj : null;
            if (num2 != null && num2.intValue() > 0) {
                num = num2;
            }
            f10456b = num;
        }
    }

    @Override // m7.a
    public Random a() {
        return b(34) ? new f() : super.a();
    }

    public final boolean b(int i10) {
        Integer num = C0107a.f10456b;
        return num == null || num.intValue() >= i10;
    }
}
