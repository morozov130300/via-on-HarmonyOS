package r0;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f11889a = new s0.m();
    }

    public static e b() {
        if (l.a("PROXY_OVERRIDE")) {
            return a.f11889a;
        }
        throw new UnsupportedOperationException("Proxy override not supported");
    }

    public abstract void a(Executor executor, Runnable runnable);

    public abstract void c(d dVar, Executor executor, Runnable runnable);
}
