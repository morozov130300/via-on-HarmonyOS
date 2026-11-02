package okio;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class g implements q {

    /* renamed from: e, reason: collision with root package name */
    public final q f10835e;

    public g(q qVar) {
        if (qVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f10835e = qVar;
    }

    public final q a() {
        return this.f10835e;
    }

    @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f10835e.close();
    }

    @Override // okio.q
    public r e() {
        return this.f10835e.e();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f10835e.toString() + ")";
    }
}
