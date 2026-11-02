package i6;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public interface k0 {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a {
        public static /* synthetic */ void a(k0 k0Var, String str, q7.p pVar, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: evaluateJavaScript");
            }
            if ((i10 & 2) != 0) {
                pVar = null;
            }
            k0Var.b(str, pVar);
        }
    }

    boolean a();

    void b(String str, q7.p pVar);

    String getUrl();
}
