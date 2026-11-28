package okio;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class f implements p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f11447c;

    public f(p pVar) {
        if (pVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f11447c = pVar;
    }

    @Override // okio.p
    public void L(c cVar, long j10) {
        this.f11447c.L(cVar, j10);
    }

    @Override // okio.p, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f11447c.close();
    }

    @Override // okio.p, java.io.Flushable
    public void flush() {
        this.f11447c.flush();
    }

    @Override // okio.p
    public r i() {
        return this.f11447c.i();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f11447c.toString() + ")";
    }
}
