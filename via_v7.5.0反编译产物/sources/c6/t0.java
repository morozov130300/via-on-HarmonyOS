package c6;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t0 f2104a = new t0();

    public final String a(String user, String password, long j10) {
        kotlin.jvm.internal.h.f(user, "user");
        kotlin.jvm.internal.h.f(password, "password");
        return b(user, password, j10, null);
    }

    public final String b(String user, String password, long j10, String str) {
        String str2;
        kotlin.jvm.internal.h.f(user, "user");
        kotlin.jvm.internal.h.f(password, "password");
        if (str != null) {
            str2 = ',' + b2.f1963a.o(str);
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        s0 s0Var = s0.f2103a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        b2 b2Var = b2.f1963a;
        sb2.append(b2Var.o(user));
        sb2.append(',');
        sb2.append(b2Var.o(password));
        sb2.append(',');
        sb2.append(j10);
        sb2.append(str2);
        sb2.append(']');
        return s0Var.a(sb2.toString());
    }

    public final String c(String str) {
        String strO;
        s0 s0Var = s0.f2103a;
        if (str == null || (strO = b2.f1963a.o(str)) == null) {
            strO = "null";
        }
        return s0Var.b(strO);
    }
}
