package c6;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f2088a = new q();

    public final String a(String secret, String url, String id, boolean z10, boolean z11) {
        kotlin.jvm.internal.h.f(secret, "secret");
        kotlin.jvm.internal.h.f(url, "url");
        kotlin.jvm.internal.h.f(id, "id");
        o oVar = o.f2074a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        b2 b2Var = b2.f1963a;
        sb2.append(b2Var.o(secret));
        sb2.append(',');
        sb2.append(b2Var.o(url));
        sb2.append(',');
        sb2.append(b2Var.o(id));
        sb2.append(',');
        sb2.append(z10);
        sb2.append(',');
        sb2.append(z11);
        sb2.append(']');
        return oVar.a(sb2.toString());
    }

    public final String b(String secret, boolean z10) {
        kotlin.jvm.internal.h.f(secret, "secret");
        return o.f2074a.b('[' + b2.f1963a.o(secret) + ',' + z10 + ']');
    }
}
