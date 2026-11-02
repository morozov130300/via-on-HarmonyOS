package g2;

import java.util.concurrent.Executor;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class s implements z {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f6172a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f6173b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public b f6174c;

    public s(Executor executor, b bVar) {
        this.f6172a = executor;
        this.f6174c = bVar;
    }

    @Override // g2.z
    public final void a(f fVar) {
        if (fVar.i()) {
            synchronized (this.f6173b) {
                try {
                    if (this.f6174c == null) {
                        return;
                    }
                    this.f6172a.execute(new r(this));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
