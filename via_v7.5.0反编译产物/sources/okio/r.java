package okio;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final r f11481d = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f11482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f11483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f11484c;

    public r a() {
        this.f11482a = false;
        return this;
    }

    public r b() {
        this.f11484c = 0L;
        return this;
    }

    public long c() {
        if (this.f11482a) {
            return this.f11483b;
        }
        throw new IllegalStateException("No deadline");
    }

    public r d(long j10) {
        this.f11482a = true;
        this.f11483b = j10;
        return this;
    }

    public boolean e() {
        return this.f11482a;
    }

    public void f() throws InterruptedIOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.f11482a && this.f11483b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public r g(long j10, TimeUnit timeUnit) {
        if (j10 >= 0) {
            if (timeUnit == null) {
                throw new IllegalArgumentException("unit == null");
            }
            this.f11484c = timeUnit.toNanos(j10);
            return this;
        }
        throw new IllegalArgumentException("timeout < 0: " + j10);
    }

    public long h() {
        return this.f11484c;
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends r {
        @Override // okio.r
        public r d(long j10) {
            return this;
        }

        @Override // okio.r
        public void f() {
        }

        @Override // okio.r
        public r g(long j10, TimeUnit timeUnit) {
            return this;
        }
    }
}
