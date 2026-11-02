package g2;

import java.util.ArrayDeque;
import java.util.Queue;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public final Object f6137a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public Queue f6138b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6139c;

    public final void a(z zVar) {
        synchronized (this.f6137a) {
            try {
                if (this.f6138b == null) {
                    this.f6138b = new ArrayDeque();
                }
                this.f6138b.add(zVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(f fVar) {
        z zVar;
        synchronized (this.f6137a) {
            if (this.f6138b != null && !this.f6139c) {
                this.f6139c = true;
                while (true) {
                    synchronized (this.f6137a) {
                        try {
                            zVar = (z) this.f6138b.poll();
                            if (zVar == null) {
                                this.f6139c = false;
                                return;
                            }
                        } finally {
                        }
                    }
                    zVar.a(fVar);
                }
            }
        }
    }
}
