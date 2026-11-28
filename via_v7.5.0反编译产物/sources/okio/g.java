package okio;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class g implements q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q f11448c;

    public g(q qVar) {
        if (qVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f11448c = qVar;
    }

    public final q a() {
        return this.f11448c;
    }

    @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f11448c.close();
    }

    @Override // okio.q
    public r i() {
        return this.f11448c.i();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f11448c.toString() + ")";
    }
}
