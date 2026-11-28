package c6;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o0 f2075a = new o0();

    public final String a(String title, boolean z10) {
        kotlin.jvm.internal.h.f(title, "title");
        String str = z10 ? "body{background:transparent}" : "body{background:#fff}@media(prefers-color-scheme:dark){body{background:#000}}";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(r0.f2099a.a(b0.f1960a.d(title), "<style>" + str + "</style>"));
        sb2.append("<body></body></html>");
        return sb2.toString();
    }
}
