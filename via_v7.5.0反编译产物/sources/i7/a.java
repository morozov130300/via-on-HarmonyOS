package i7;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a implements h7.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f6296c = new a();

    @Override // h7.a
    public kotlin.coroutines.b getContext() {
        throw new IllegalStateException("This continuation is already complete");
    }

    @Override // h7.a
    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete");
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
