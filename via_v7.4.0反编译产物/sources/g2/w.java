package g2;

import java.util.concurrent.Executor;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class w implements z {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f6182a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f6183b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public d f6184c;

    public w(Executor executor, d dVar) {
        this.f6182a = executor;
        this.f6184c = dVar;
    }

    @Override // g2.z
    public final void a(f fVar) {
        if (fVar.k()) {
            synchronized (this.f6183b) {
                try {
                    if (this.f6184c == null) {
                        return;
                    }
                    this.f6182a.execute(new v(this, fVar));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
