package q0;

import java.util.concurrent.Executor;
import r0.k;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class c {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final c f11207a = new k();
    }

    public static c b() {
        if (g.a("PROXY_OVERRIDE")) {
            return a.f11207a;
        }
        throw new UnsupportedOperationException("Proxy override not supported");
    }

    public abstract void a(Executor executor, Runnable runnable);

    public abstract void c(b bVar, Executor executor, Runnable runnable);
}
