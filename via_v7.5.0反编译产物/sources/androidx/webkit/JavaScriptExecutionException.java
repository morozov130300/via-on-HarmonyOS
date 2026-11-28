package androidx.webkit;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class JavaScriptExecutionException extends Exception {
    public static final int ERROR_FRAME_DESTROYED = 1;
    public static final int ERROR_GENERIC = 0;
    private final int mErrorType;

    public JavaScriptExecutionException(int i10, String str) {
        super(str == null ? "" : str);
        this.mErrorType = i10;
    }

    public int getErrorType() {
        return this.mErrorType;
    }
}
