package c6;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public interface c2 {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {
        public static /* synthetic */ void a(c2 c2Var, String str, p7.p pVar, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: evaluateJavaScript");
            }
            if ((i10 & 2) != 0) {
                pVar = null;
            }
            c2Var.a(str, pVar);
        }
    }

    void a(String str, p7.p pVar);

    String getUrl();

    boolean isJavaScriptEnabled();
}
