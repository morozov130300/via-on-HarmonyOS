package okio;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class f implements p {

    /* renamed from: e, reason: collision with root package name */
    public final p f10834e;

    public f(p pVar) {
        if (pVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f10834e = pVar;
    }

    @Override // okio.p
    public void I(c cVar, long j10) {
        this.f10834e.I(cVar, j10);
    }

    @Override // okio.p, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f10834e.close();
    }

    @Override // okio.p
    public r e() {
        return this.f10834e.e();
    }

    @Override // okio.p, java.io.Flushable
    public void flush() {
        this.f10834e.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f10834e.toString() + ")";
    }
}
